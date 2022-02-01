package com.tencent.mm.media.e;

import android.media.MediaCodec;
import android.media.MediaCodec.BufferInfo;
import android.media.MediaCodec.Callback;
import android.media.MediaCodec.CodecException;
import android.media.MediaFormat;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.compatible.deviceinfo.aa;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.Util;
import java.nio.ByteBuffer;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import kotlin.Metadata;
import kotlin.a.p;
import kotlin.ah;
import kotlin.g.a.q;
import kotlin.g.b.s;
import kotlin.g.b.u;

@Metadata(d1={""}, d2={"Lcom/tencent/mm/media/encoder/MediaCodecAACEncoderAsync;", "Lcom/tencent/mm/media/encoder/IAudioEncoder;", "mediaFormat", "Landroid/media/MediaFormat;", "frameEncodeCallback", "Lkotlin/Function3;", "Ljava/nio/ByteBuffer;", "Lkotlin/ParameterName;", "name", "data", "Landroid/media/MediaCodec$BufferInfo;", "bufferInfo", "farmat", "", "frameEncodeEndCallback", "Lkotlin/Function0;", "(Landroid/media/MediaFormat;Lkotlin/jvm/functions/Function3;Lkotlin/jvm/functions/Function0;)V", "aacCallback", "com/tencent/mm/media/encoder/MediaCodecAACEncoderAsync$aacCallback$1", "Lcom/tencent/mm/media/encoder/MediaCodecAACEncoderAsync$aacCallback$1;", "availableIndex", "", "", "kotlin.jvm.PlatformType", "", "encoderStart", "", "inputDataSource", "Lcom/tencent/mm/media/encoder/MediaCodecAACEncoderAsync$EncoderData;", "isInputEnd", "stopEncoderTask", "checkDelayFinishEncoder", "sendDataToEncoder", "pcmData", "", "pts", "", "isLast", "startEncoder", "Companion", "EncoderData", "plugin-mediaeditor_release"}, k=1, mv={1, 5, 1}, xi=48)
public final class d
  extends a
{
  public static final d.a nzE;
  private List<d.b> nzF;
  private List<Integer> nzG;
  private boolean nzH;
  private boolean nzI;
  private c nzJ;
  private final kotlin.g.a.a<ah> nzK;
  
  static
  {
    AppMethodBeat.i(93636);
    nzE = new d.a((byte)0);
    AppMethodBeat.o(93636);
  }
  
  public d(MediaFormat paramMediaFormat, q<? super ByteBuffer, ? super MediaCodec.BufferInfo, ? super MediaFormat, ah> paramq, kotlin.g.a.a<ah> parama)
  {
    super(paramMediaFormat, paramq, parama);
    AppMethodBeat.i(93635);
    this.nzF = Collections.synchronizedList((List)new ArrayList());
    this.nzG = Collections.synchronizedList((List)new ArrayList());
    this.nzJ = new c(this);
    try
    {
      this.nzs.setCallback((MediaCodec.Callback)this.nzJ);
      this.nzK = ((kotlin.g.a.a)new d(this));
      AppMethodBeat.o(93635);
      return;
    }
    catch (Exception paramMediaFormat)
    {
      for (;;)
      {
        Log.printErrStackTrace("MicroMsg.MediaCodecAACEncoderAsync", (Throwable)paramMediaFormat, "", new Object[0]);
      }
    }
  }
  
  private static final void V(kotlin.g.a.a parama)
  {
    AppMethodBeat.i(236968);
    s.u(parama, "$tmp0");
    parama.invoke();
    AppMethodBeat.o(236968);
  }
  
  private static final void W(kotlin.g.a.a parama)
  {
    AppMethodBeat.i(236971);
    s.u(parama, "$tmp0");
    parama.invoke();
    AppMethodBeat.o(236971);
  }
  
  public final void b(byte[] paramArrayOfByte, long paramLong, boolean paramBoolean)
  {
    AppMethodBeat.i(93634);
    s.u(paramArrayOfByte, "data");
    if (paramArrayOfByte != null)
    {
      paramArrayOfByte = new d.b(paramArrayOfByte, paramLong, paramBoolean);
      this.nzF.add(paramArrayOfByte);
      if (this.nzG.size() > 0)
      {
        paramArrayOfByte = this.nzG;
        s.s(paramArrayOfByte, "availableIndex");
        paramArrayOfByte = (Integer)p.oK(paramArrayOfByte);
        this.nzG.remove(paramArrayOfByte);
        c localc = this.nzJ;
        MediaCodec localMediaCodec = this.nzs.lXj;
        s.s(localMediaCodec, "encoder.mediaCodecImpl");
        s.s(paramArrayOfByte, "index");
        localc.onInputBufferAvailable(localMediaCodec, paramArrayOfByte.intValue());
      }
      if (!this.nzI)
      {
        this.nzs.start();
        this.nzI = true;
      }
    }
    AppMethodBeat.o(93634);
  }
  
  @Metadata(d1={""}, d2={"com/tencent/mm/media/encoder/MediaCodecAACEncoderAsync$aacCallback$1", "Landroid/media/MediaCodec$Callback;", "onError", "", "codec", "Landroid/media/MediaCodec;", "e", "Landroid/media/MediaCodec$CodecException;", "onInputBufferAvailable", "index", "", "onOutputBufferAvailable", "info", "Landroid/media/MediaCodec$BufferInfo;", "onOutputFormatChanged", "format", "Landroid/media/MediaFormat;", "plugin-mediaeditor_release"}, k=1, mv={1, 5, 1}, xi=48)
  public static final class c
    extends MediaCodec.Callback
  {
    c(d paramd) {}
    
    public final void onError(MediaCodec paramMediaCodec, MediaCodec.CodecException paramCodecException)
    {
      AppMethodBeat.i(93633);
      s.u(paramMediaCodec, "codec");
      s.u(paramCodecException, "e");
      Log.e("MicroMsg.MediaCodecAACEncoderAsync", "onError, e:" + paramCodecException.getMessage() + ", " + paramCodecException);
      AppMethodBeat.o(93633);
    }
    
    public final void onInputBufferAvailable(MediaCodec paramMediaCodec, int paramInt)
    {
      AppMethodBeat.i(93631);
      s.u(paramMediaCodec, "codec");
      d.b localb;
      byte[] arrayOfByte;
      long l;
      boolean bool;
      do
      {
        try
        {
          Log.i("MicroMsg.MediaCodecAACEncoderAsync", s.X("has input buffer ", Integer.valueOf(paramInt)));
          if (d.a(this.nzM).size() == 0)
          {
            Log.i("MicroMsg.MediaCodecAACEncoderAsync", "current data is null");
            d.b(this.nzM).add(Integer.valueOf(paramInt));
            AppMethodBeat.o(93631);
            return;
          }
          Log.i("MicroMsg.MediaCodecAACEncoderAsync", s.X("has input buffer avaiable", Integer.valueOf(paramInt)));
          if (this.nzM.nxG)
          {
            Log.i("MicroMsg.MediaCodecAACEncoderAsync", "sendDataToEncoder end now");
            AppMethodBeat.o(93631);
            return;
          }
        }
        catch (Exception paramMediaCodec)
        {
          Log.printErrStackTrace("MicroMsg.MediaCodecAACEncoderAsync", (Throwable)paramMediaCodec, "onInputBufferAvailable error", new Object[0]);
          AppMethodBeat.o(93631);
          return;
        }
        this.nzM.nzu = Util.currentTicks();
        if (paramInt < 0)
        {
          Log.d("MicroMsg.MediaCodecAACEncoderAsync", "encoder no input buffer available, drain first");
          AppMethodBeat.o(93631);
          return;
        }
        paramMediaCodec = d.a(this.nzM);
        s.s(paramMediaCodec, "inputDataSource");
        localb = (d.b)p.oK(paramMediaCodec);
        arrayOfByte = localb.hqJ;
        l = localb.pts;
        bool = localb.nzL;
        StringBuilder localStringBuilder = new StringBuilder("encode data, pts:").append(l).append(", isLast:").append(bool).append(", pcmData:");
        if (arrayOfByte == null) {}
        for (paramMediaCodec = null;; paramMediaCodec = Integer.valueOf(arrayOfByte.length))
        {
          Log.i("MicroMsg.MediaCodecAACEncoderAsync", paramMediaCodec + ", inputDataSource.size:" + d.a(this.nzM).size());
          if (arrayOfByte != null) {
            break;
          }
          AppMethodBeat.o(93631);
          return;
        }
      } while (paramInt < 0);
      paramMediaCodec = this.nzM.nzs.getInputBuffer(paramInt);
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
          d.c(this.nzM);
          Log.i("MicroMsg.MediaCodecAACEncoderAsync", "EOS received in sendAudioToEncoder");
          this.nzM.nzs.a(paramInt, arrayOfByte.length, l, 4);
          d.d(this.nzM);
        }
        for (;;)
        {
          d.a(this.nzM).remove(localb);
          AppMethodBeat.o(93631);
          return;
          this.nzM.nzs.a(paramInt, arrayOfByte.length, l, 0);
        }
      }
    }
    
    public final void onOutputBufferAvailable(MediaCodec paramMediaCodec, int paramInt, MediaCodec.BufferInfo paramBufferInfo)
    {
      AppMethodBeat.i(93630);
      s.u(paramMediaCodec, "codec");
      s.u(paramBufferInfo, "info");
      do
      {
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
            paramMediaCodec = this.nzM;
            paramBufferInfo = this.nzM.nzs.getOutputFormat();
            s.s(paramBufferInfo, "encoder.outputFormat");
            paramMediaCodec.d(paramBufferInfo);
            Log.i("MicroMsg.MediaCodecAACEncoderAsync", "dstMediaFormat change: %s", new Object[] { this.nzM.nzt });
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
          Log.v("MicroMsg.MediaCodecAACEncoderAsync", "ignoring BUFFER_FLAG_CODEC_CONFIG,size: %s, %s", new Object[] { Integer.valueOf(paramBufferInfo.size), Boolean.valueOf(d.boY()) });
          if (d.boY()) {
            paramBufferInfo.size = 0;
          }
        }
        Log.v("MicroMsg.MediaCodecAACEncoderAsync", "perform encoding");
        paramMediaCodec = this.nzM.nzs.getOutputBuffer(paramInt);
        this.nzM.f(paramMediaCodec, paramBufferInfo);
        this.nzM.nzs.releaseOutputBuffer(paramInt, false);
      } while ((paramBufferInfo.flags & 0x4) == 0);
      Log.i("MicroMsg.MediaCodecAACEncoderAsync", "receive EOS!");
      this.nzM.bpa();
      AppMethodBeat.o(93630);
    }
    
    public final void onOutputFormatChanged(MediaCodec paramMediaCodec, MediaFormat paramMediaFormat)
    {
      AppMethodBeat.i(93632);
      s.u(paramMediaCodec, "codec");
      s.u(paramMediaFormat, "format");
      Log.i("MicroMsg.MediaCodecAACEncoderAsync", s.X("onOutputFormatChanged: ", paramMediaFormat));
      AppMethodBeat.o(93632);
    }
  }
  
  @Metadata(d1={""}, d2={"<anonymous>", ""}, k=3, mv={1, 5, 1}, xi=48)
  static final class d
    extends u
    implements kotlin.g.a.a<ah>
  {
    d(d paramd)
    {
      super();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes9.jar
 * Qualified Name:     com.tencent.mm.media.e.d
 * JD-Core Version:    0.7.0.1
 */