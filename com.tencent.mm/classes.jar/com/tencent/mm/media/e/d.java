package com.tencent.mm.media.e;

import android.media.MediaCodec;
import android.media.MediaCodec.BufferInfo;
import android.media.MediaCodec.Callback;
import android.media.MediaCodec.CodecException;
import android.media.MediaFormat;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.compatible.deviceinfo.z;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.Util;
import java.nio.ByteBuffer;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import kotlin.a.j;
import kotlin.g.a.q;
import kotlin.g.b.p;
import kotlin.l;
import kotlin.x;

@l(hxD={1, 1, 16}, hxE={""}, hxF={"Lcom/tencent/mm/media/encoder/MediaCodecAACEncoderAsync;", "Lcom/tencent/mm/media/encoder/IAudioEncoder;", "mediaFormat", "Landroid/media/MediaFormat;", "frameEncodeCallback", "Lkotlin/Function3;", "Ljava/nio/ByteBuffer;", "Lkotlin/ParameterName;", "name", "data", "Landroid/media/MediaCodec$BufferInfo;", "bufferInfo", "farmat", "", "frameEncodeEndCallback", "Lkotlin/Function0;", "(Landroid/media/MediaFormat;Lkotlin/jvm/functions/Function3;Lkotlin/jvm/functions/Function0;)V", "aacCallback", "com/tencent/mm/media/encoder/MediaCodecAACEncoderAsync$aacCallback$1", "Lcom/tencent/mm/media/encoder/MediaCodecAACEncoderAsync$aacCallback$1;", "encoderStart", "", "inputDataSource", "", "Lcom/tencent/mm/media/encoder/MediaCodecAACEncoderAsync$EncoderData;", "kotlin.jvm.PlatformType", "", "isInputEnd", "sendDataToEncoder", "pcmData", "", "pts", "", "isLast", "startEncoder", "Companion", "EncoderData", "plugin-mediaeditor_release"})
public final class d
  extends a
{
  public static final d.a ifn;
  private List<b> ifj;
  private boolean ifk;
  private boolean ifl;
  private c ifm;
  
  static
  {
    AppMethodBeat.i(93636);
    ifn = new d.a((byte)0);
    AppMethodBeat.o(93636);
  }
  
  public d(MediaFormat paramMediaFormat, q<? super ByteBuffer, ? super MediaCodec.BufferInfo, ? super MediaFormat, x> paramq, kotlin.g.a.a<x> parama)
  {
    super(paramMediaFormat, paramq, parama);
    AppMethodBeat.i(93635);
    this.ifj = Collections.synchronizedList((List)new ArrayList());
    this.ifm = new c(this);
    try
    {
      this.ieT.setCallback((MediaCodec.Callback)this.ifm);
      AppMethodBeat.o(93635);
      return;
    }
    catch (Exception paramMediaFormat)
    {
      Log.printErrStackTrace("MicroMsg.MediaCodecAACEncoderAsync", (Throwable)paramMediaFormat, "", new Object[0]);
      AppMethodBeat.o(93635);
    }
  }
  
  public final void b(byte[] paramArrayOfByte, long paramLong, boolean paramBoolean)
  {
    AppMethodBeat.i(93634);
    p.h(paramArrayOfByte, "data");
    if (paramArrayOfByte != null)
    {
      paramArrayOfByte = new b(paramArrayOfByte, paramLong, paramBoolean);
      this.ifj.add(paramArrayOfByte);
      if (!this.ifl)
      {
        this.ieT.start();
        this.ifl = true;
      }
    }
    AppMethodBeat.o(93634);
  }
  
  @l(hxD={1, 1, 16}, hxE={""}, hxF={"Lcom/tencent/mm/media/encoder/MediaCodecAACEncoderAsync$EncoderData;", "", "pcmData", "", "pts", "", "isLast", "", "([BJZ)V", "()Z", "setLast", "(Z)V", "getPcmData", "()[B", "setPcmData", "([B)V", "getPts", "()J", "setPts", "(J)V", "component1", "component2", "component3", "copy", "equals", "other", "hashCode", "", "toString", "", "plugin-mediaeditor_release"})
  public static final class b
  {
    byte[] dtQ;
    boolean ifo;
    long pts;
    
    public b(byte[] paramArrayOfByte, long paramLong, boolean paramBoolean)
    {
      this.dtQ = paramArrayOfByte;
      this.pts = paramLong;
      this.ifo = paramBoolean;
    }
    
    public final boolean equals(Object paramObject)
    {
      AppMethodBeat.i(93629);
      if (this != paramObject)
      {
        if ((paramObject instanceof b))
        {
          paramObject = (b)paramObject;
          if ((!p.j(this.dtQ, paramObject.dtQ)) || (this.pts != paramObject.pts) || (this.ifo != paramObject.ifo)) {}
        }
      }
      else
      {
        AppMethodBeat.o(93629);
        return true;
      }
      AppMethodBeat.o(93629);
      return false;
    }
    
    public final int hashCode()
    {
      throw new Runtime("d2j fail translate: java.lang.RuntimeException: can not merge I and Z\r\n\tat com.googlecode.dex2jar.ir.TypeClass.merge(TypeClass.java:100)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeRef.updateTypeClass(TypeTransformer.java:174)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeAnalyze.copyTypes(TypeTransformer.java:311)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeAnalyze.fixTypes(TypeTransformer.java:226)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeAnalyze.analyze(TypeTransformer.java:207)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer.transform(TypeTransformer.java:44)\r\n\tat com.googlecode.d2j.dex.Dex2jar$2.optimize(Dex2jar.java:162)\r\n\tat com.googlecode.d2j.dex.Dex2Asm.convertCode(Dex2Asm.java:414)\r\n\tat com.googlecode.d2j.dex.ExDex2Asm.convertCode(ExDex2Asm.java:42)\r\n\tat com.googlecode.d2j.dex.Dex2jar$2.convertCode(Dex2jar.java:128)\r\n\tat com.googlecode.d2j.dex.Dex2Asm.convertMethod(Dex2Asm.java:509)\r\n\tat com.googlecode.d2j.dex.Dex2Asm.convertClass(Dex2Asm.java:406)\r\n\tat com.googlecode.d2j.dex.Dex2Asm.convertDex(Dex2Asm.java:422)\r\n\tat com.googlecode.d2j.dex.Dex2jar.doTranslate(Dex2jar.java:172)\r\n\tat com.googlecode.d2j.dex.Dex2jar.to(Dex2jar.java:272)\r\n\tat com.googlecode.dex2jar.tools.Dex2jarCmd.doCommandLine(Dex2jarCmd.java:108)\r\n\tat com.googlecode.dex2jar.tools.BaseCmd.doMain(BaseCmd.java:288)\r\n\tat com.googlecode.dex2jar.tools.Dex2jarCmd.main(Dex2jarCmd.java:32)\r\n");
    }
    
    public final String toString()
    {
      AppMethodBeat.i(93627);
      String str = "EncoderData(pcmData=" + Arrays.toString(this.dtQ) + ", pts=" + this.pts + ", isLast=" + this.ifo + ")";
      AppMethodBeat.o(93627);
      return str;
    }
  }
  
  @l(hxD={1, 1, 16}, hxE={""}, hxF={"com/tencent/mm/media/encoder/MediaCodecAACEncoderAsync$aacCallback$1", "Landroid/media/MediaCodec$Callback;", "onError", "", "codec", "Landroid/media/MediaCodec;", "e", "Landroid/media/MediaCodec$CodecException;", "onInputBufferAvailable", "index", "", "onOutputBufferAvailable", "info", "Landroid/media/MediaCodec$BufferInfo;", "onOutputFormatChanged", "format", "Landroid/media/MediaFormat;", "plugin-mediaeditor_release"})
  public static final class c
    extends MediaCodec.Callback
  {
    public final void onError(MediaCodec paramMediaCodec, MediaCodec.CodecException paramCodecException)
    {
      AppMethodBeat.i(93633);
      p.h(paramMediaCodec, "codec");
      p.h(paramCodecException, "e");
      Log.e("MicroMsg.MediaCodecAACEncoderAsync", "onError, e:" + paramCodecException.getMessage() + ", " + paramCodecException);
      AppMethodBeat.o(93633);
    }
    
    public final void onInputBufferAvailable(MediaCodec paramMediaCodec, int paramInt)
    {
      AppMethodBeat.i(93631);
      p.h(paramMediaCodec, "codec");
      try
      {
        Log.i("MicroMsg.MediaCodecAACEncoderAsync", "has input buffer ".concat(String.valueOf(paramInt)));
        if (d.c(this.ifp).size() == 0)
        {
          Log.i("MicroMsg.MediaCodecAACEncoderAsync", "current data is null");
          this.ifp.ieT.a(paramInt, 0, 0L, 0);
          AppMethodBeat.o(93631);
          return;
        }
        Log.i("MicroMsg.MediaCodecAACEncoderAsync", "has input buffer avaiable".concat(String.valueOf(paramInt)));
        if (!this.ifp.idt) {
          break label126;
        }
        Log.i("MicroMsg.MediaCodecAACEncoderAsync", "sendDataToEncoder end now");
        AppMethodBeat.o(93631);
        return;
      }
      catch (Exception paramMediaCodec)
      {
        Log.printErrStackTrace("MicroMsg.MediaCodecAACEncoderAsync", (Throwable)paramMediaCodec, "onInputBufferAvailable error", new Object[0]);
      }
      AppMethodBeat.o(93631);
      return;
      label126:
      this.ifp.ieV = Util.currentTicks();
      if (paramInt < 0)
      {
        Log.d("MicroMsg.MediaCodecAACEncoderAsync", "encoder no input buffer available, drain first");
        AppMethodBeat.o(93631);
        return;
      }
      paramMediaCodec = d.c(this.ifp);
      p.g(paramMediaCodec, "inputDataSource");
      d.b localb = (d.b)j.ks(paramMediaCodec);
      byte[] arrayOfByte = localb.dtQ;
      long l = localb.pts;
      boolean bool = localb.ifo;
      StringBuilder localStringBuilder = new StringBuilder("encode data, pts:").append(l).append(", isLast:").append(bool).append(", pcmData:");
      if (arrayOfByte != null) {}
      for (paramMediaCodec = Integer.valueOf(arrayOfByte.length);; paramMediaCodec = null)
      {
        Log.i("MicroMsg.MediaCodecAACEncoderAsync", paramMediaCodec + ", inputDataSource.size:" + d.c(this.ifp).size());
        if (arrayOfByte == null)
        {
          AppMethodBeat.o(93631);
          return;
        }
        if (paramInt < 0) {
          break;
        }
        paramMediaCodec = this.ifp.ieT.getInputBuffer(paramInt);
        if (paramMediaCodec != null) {
          paramMediaCodec.clear();
        }
        if (paramMediaCodec != null) {
          paramMediaCodec.position(0);
        }
        if (paramMediaCodec != null) {
          paramMediaCodec.put(arrayOfByte);
        }
        if (bool) {
          Log.i("MicroMsg.MediaCodecAACEncoderAsync", "last, send EOS and try delay stop encoder");
        }
        for (int i = 1;; i = 0)
        {
          if (i != 0)
          {
            d.b(this.ifp);
            Log.i("MicroMsg.MediaCodecAACEncoderAsync", "EOS received in sendAudioToEncoder");
            this.ifp.ieT.a(paramInt, arrayOfByte.length, l, 4);
          }
          for (;;)
          {
            d.c(this.ifp).remove(localb);
            AppMethodBeat.o(93631);
            return;
            this.ifp.ieT.a(paramInt, arrayOfByte.length, l, 0);
          }
        }
      }
    }
    
    public final void onOutputBufferAvailable(MediaCodec paramMediaCodec, int paramInt, MediaCodec.BufferInfo paramBufferInfo)
    {
      AppMethodBeat.i(93630);
      p.h(paramMediaCodec, "codec");
      p.h(paramBufferInfo, "info");
      try
      {
        Log.d("MicroMsg.MediaCodecAACEncoderAsync", "encoderOutputBufferIndex: %s", new Object[] { Integer.valueOf(paramInt) });
        if (paramInt == -1)
        {
          Log.d("MicroMsg.MediaCodecAACEncoderAsync", "no output available, break");
          AppMethodBeat.o(93630);
          return;
        }
        if (paramInt == -2)
        {
          paramMediaCodec = this.ifp;
          paramBufferInfo = this.ifp.ieT.getOutputFormat();
          p.g(paramBufferInfo, "encoder.outputFormat");
          paramMediaCodec.d(paramBufferInfo);
          Log.i("MicroMsg.MediaCodecAACEncoderAsync", "dstMediaFormat change: %s", new Object[] { this.ifp.ieU });
          AppMethodBeat.o(93630);
          return;
        }
      }
      catch (Exception paramMediaCodec)
      {
        Log.printErrStackTrace("MicroMsg.MediaCodecAACEncoderAsync", (Throwable)paramMediaCodec, "drainEncoder error: %s", new Object[] { paramMediaCodec.getMessage() });
        AppMethodBeat.o(93630);
        return;
      }
      if (paramInt < 0)
      {
        Log.e("MicroMsg.MediaCodecAACEncoderAsync", "unexpected encoderOutputBufferIndex: %s", new Object[] { Integer.valueOf(paramInt) });
        AppMethodBeat.o(93630);
        return;
      }
      if ((paramBufferInfo.flags & 0x2) != 0)
      {
        Log.v("MicroMsg.MediaCodecAACEncoderAsync", "ignoring BUFFER_FLAG_CODEC_CONFIG,size: %s, %s", new Object[] { Integer.valueOf(paramBufferInfo.size), Boolean.TRUE });
        paramBufferInfo.size = 0;
      }
      Log.v("MicroMsg.MediaCodecAACEncoderAsync", "perform encoding");
      paramMediaCodec = this.ifp.ieT.getOutputBuffer(paramInt);
      this.ifp.f(paramMediaCodec, paramBufferInfo);
      this.ifp.ieT.releaseOutputBuffer(paramInt, false);
      if (((paramBufferInfo.flags & 0x4) != 0) || (d.a(this.ifp)))
      {
        Log.i("MicroMsg.MediaCodecAACEncoderAsync", "receive EOS!");
        this.ifp.aMj();
        AppMethodBeat.o(93630);
        return;
      }
      AppMethodBeat.o(93630);
    }
    
    public final void onOutputFormatChanged(MediaCodec paramMediaCodec, MediaFormat paramMediaFormat)
    {
      AppMethodBeat.i(93632);
      p.h(paramMediaCodec, "codec");
      p.h(paramMediaFormat, "format");
      Log.i("MicroMsg.MediaCodecAACEncoderAsync", "onOutputFormatChanged: ".concat(String.valueOf(paramMediaFormat)));
      AppMethodBeat.o(93632);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.media.e.d
 * JD-Core Version:    0.7.0.1
 */