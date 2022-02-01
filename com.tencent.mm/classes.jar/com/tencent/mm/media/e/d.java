package com.tencent.mm.media.e;

import android.media.MediaCodec;
import android.media.MediaCodec.BufferInfo;
import android.media.MediaCodec.Callback;
import android.media.MediaCodec.CodecException;
import android.media.MediaFormat;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.sdk.platformtools.ae;
import com.tencent.mm.sdk.platformtools.bu;
import d.a.j;
import d.g.a.q;
import d.g.b.p;
import d.l;
import java.nio.ByteBuffer;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

@l(gjZ={1, 1, 16}, gka={""}, gkb={"Lcom/tencent/mm/media/encoder/MediaCodecAACEncoderAsync;", "Lcom/tencent/mm/media/encoder/IAudioEncoder;", "mediaFormat", "Landroid/media/MediaFormat;", "frameEncodeCallback", "Lkotlin/Function3;", "Ljava/nio/ByteBuffer;", "Lkotlin/ParameterName;", "name", "data", "Landroid/media/MediaCodec$BufferInfo;", "bufferInfo", "farmat", "", "frameEncodeEndCallback", "Lkotlin/Function0;", "(Landroid/media/MediaFormat;Lkotlin/jvm/functions/Function3;Lkotlin/jvm/functions/Function0;)V", "aacCallback", "com/tencent/mm/media/encoder/MediaCodecAACEncoderAsync$aacCallback$1", "Lcom/tencent/mm/media/encoder/MediaCodecAACEncoderAsync$aacCallback$1;", "encoderStart", "", "inputDataSource", "", "Lcom/tencent/mm/media/encoder/MediaCodecAACEncoderAsync$EncoderData;", "kotlin.jvm.PlatformType", "", "isInputEnd", "sendDataToEncoder", "pcmData", "", "pts", "", "isLast", "startEncoder", "Companion", "EncoderData", "plugin-mediaeditor_release"})
public final class d
  extends a
{
  public static final d.a hmr;
  private List<d.b> hmn;
  private boolean hmo;
  private boolean hmp;
  private c hmq;
  
  static
  {
    AppMethodBeat.i(93636);
    hmr = new d.a((byte)0);
    AppMethodBeat.o(93636);
  }
  
  public d(MediaFormat paramMediaFormat, q<? super ByteBuffer, ? super MediaCodec.BufferInfo, ? super MediaFormat, d.z> paramq, d.g.a.a<d.z> parama)
  {
    super(paramMediaFormat, paramq, parama);
    AppMethodBeat.i(93635);
    this.hmn = Collections.synchronizedList((List)new ArrayList());
    this.hmq = new c(this);
    try
    {
      this.hlX.setCallback((MediaCodec.Callback)this.hmq);
      AppMethodBeat.o(93635);
      return;
    }
    catch (Exception paramMediaFormat)
    {
      ae.printErrStackTrace("MicroMsg.MediaCodecAACEncoderAsync", (Throwable)paramMediaFormat, "", new Object[0]);
      AppMethodBeat.o(93635);
    }
  }
  
  public final void b(byte[] paramArrayOfByte, long paramLong, boolean paramBoolean)
  {
    AppMethodBeat.i(93634);
    p.h(paramArrayOfByte, "data");
    if (paramArrayOfByte != null)
    {
      paramArrayOfByte = new d.b(paramArrayOfByte, paramLong, paramBoolean);
      this.hmn.add(paramArrayOfByte);
      if (!this.hmp)
      {
        this.hlX.start();
        this.hmp = true;
      }
    }
    AppMethodBeat.o(93634);
  }
  
  @l(gjZ={1, 1, 16}, gka={""}, gkb={"com/tencent/mm/media/encoder/MediaCodecAACEncoderAsync$aacCallback$1", "Landroid/media/MediaCodec$Callback;", "onError", "", "codec", "Landroid/media/MediaCodec;", "e", "Landroid/media/MediaCodec$CodecException;", "onInputBufferAvailable", "index", "", "onOutputBufferAvailable", "info", "Landroid/media/MediaCodec$BufferInfo;", "onOutputFormatChanged", "format", "Landroid/media/MediaFormat;", "plugin-mediaeditor_release"})
  public static final class c
    extends MediaCodec.Callback
  {
    public final void onError(MediaCodec paramMediaCodec, MediaCodec.CodecException paramCodecException)
    {
      AppMethodBeat.i(93633);
      StringBuilder localStringBuilder = new StringBuilder("onError, e:");
      if (paramCodecException != null) {}
      for (paramMediaCodec = paramCodecException.getMessage();; paramMediaCodec = null)
      {
        ae.e("MicroMsg.MediaCodecAACEncoderAsync", paramMediaCodec + ", " + paramCodecException);
        AppMethodBeat.o(93633);
        return;
      }
    }
    
    public final void onInputBufferAvailable(MediaCodec paramMediaCodec, int paramInt)
    {
      AppMethodBeat.i(93631);
      try
      {
        ae.i("MicroMsg.MediaCodecAACEncoderAsync", "has input buffer ".concat(String.valueOf(paramInt)));
        if (d.c(this.hmt).size() == 0)
        {
          ae.i("MicroMsg.MediaCodecAACEncoderAsync", "current data is null");
          this.hmt.hlX.a(paramInt, 0, 0L, 0);
          AppMethodBeat.o(93631);
          return;
        }
        ae.i("MicroMsg.MediaCodecAACEncoderAsync", "has input buffer avaiable".concat(String.valueOf(paramInt)));
        if (!this.hmt.hkx) {
          break label120;
        }
        ae.i("MicroMsg.MediaCodecAACEncoderAsync", "sendDataToEncoder end now");
        AppMethodBeat.o(93631);
        return;
      }
      catch (Exception paramMediaCodec)
      {
        ae.printErrStackTrace("MicroMsg.MediaCodecAACEncoderAsync", (Throwable)paramMediaCodec, "onInputBufferAvailable error", new Object[0]);
      }
      AppMethodBeat.o(93631);
      return;
      label120:
      this.hmt.hlZ = bu.HQ();
      if (paramInt < 0)
      {
        ae.d("MicroMsg.MediaCodecAACEncoderAsync", "encoder no input buffer available, drain first");
        AppMethodBeat.o(93631);
        return;
      }
      paramMediaCodec = d.c(this.hmt);
      p.g(paramMediaCodec, "inputDataSource");
      d.b localb = (d.b)j.jl(paramMediaCodec);
      byte[] arrayOfByte = localb.dcZ;
      long l = localb.pts;
      boolean bool = localb.hms;
      StringBuilder localStringBuilder = new StringBuilder("encode data, pts:").append(l).append(", isLast:").append(bool).append(", pcmData:");
      if (arrayOfByte != null) {}
      for (paramMediaCodec = Integer.valueOf(arrayOfByte.length);; paramMediaCodec = null)
      {
        ae.i("MicroMsg.MediaCodecAACEncoderAsync", paramMediaCodec + ", inputDataSource.size:" + d.c(this.hmt).size());
        if (arrayOfByte == null)
        {
          AppMethodBeat.o(93631);
          return;
        }
        if (paramInt < 0) {
          break;
        }
        paramMediaCodec = this.hmt.hlX.getInputBuffer(paramInt);
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
          ae.i("MicroMsg.MediaCodecAACEncoderAsync", "last, send EOS and try delay stop encoder");
        }
        for (int i = 1;; i = 0)
        {
          if (i != 0)
          {
            d.b(this.hmt);
            ae.i("MicroMsg.MediaCodecAACEncoderAsync", "EOS received in sendAudioToEncoder");
            this.hmt.hlX.a(paramInt, arrayOfByte.length, l, 4);
          }
          for (;;)
          {
            d.c(this.hmt).remove(localb);
            AppMethodBeat.o(93631);
            return;
            this.hmt.hlX.a(paramInt, arrayOfByte.length, l, 0);
          }
        }
      }
    }
    
    public final void onOutputBufferAvailable(MediaCodec paramMediaCodec, int paramInt, MediaCodec.BufferInfo paramBufferInfo)
    {
      AppMethodBeat.i(93630);
      try
      {
        ae.d("MicroMsg.MediaCodecAACEncoderAsync", "encoderOutputBufferIndex: %s", new Object[] { Integer.valueOf(paramInt) });
        if (paramInt == -1)
        {
          ae.d("MicroMsg.MediaCodecAACEncoderAsync", "no output available, break");
          AppMethodBeat.o(93630);
          return;
        }
        if (paramInt == -2)
        {
          paramMediaCodec = this.hmt;
          paramBufferInfo = this.hmt.hlX.getOutputFormat();
          p.g(paramBufferInfo, "encoder.outputFormat");
          paramMediaCodec.d(paramBufferInfo);
          ae.i("MicroMsg.MediaCodecAACEncoderAsync", "dstMediaFormat change: %s", new Object[] { this.hmt.hlY });
          AppMethodBeat.o(93630);
          return;
        }
      }
      catch (Exception paramMediaCodec)
      {
        ae.printErrStackTrace("MicroMsg.MediaCodecAACEncoderAsync", (Throwable)paramMediaCodec, "drainEncoder error: %s", new Object[] { paramMediaCodec.getMessage() });
        AppMethodBeat.o(93630);
        return;
      }
      if (paramInt < 0)
      {
        ae.e("MicroMsg.MediaCodecAACEncoderAsync", "unexpected encoderOutputBufferIndex: %s", new Object[] { Integer.valueOf(paramInt) });
        AppMethodBeat.o(93630);
        return;
      }
      if (paramBufferInfo == null) {
        p.gkB();
      }
      if ((paramBufferInfo.flags & 0x2) != 0)
      {
        ae.v("MicroMsg.MediaCodecAACEncoderAsync", "ignoring BUFFER_FLAG_CODEC_CONFIG,size: %s, %s", new Object[] { Integer.valueOf(paramBufferInfo.size), Boolean.TRUE });
        paramBufferInfo.size = 0;
      }
      ae.v("MicroMsg.MediaCodecAACEncoderAsync", "perform encoding");
      paramMediaCodec = this.hmt.hlX.getOutputBuffer(paramInt);
      this.hmt.f(paramMediaCodec, paramBufferInfo);
      this.hmt.hlX.releaseOutputBuffer(paramInt, false);
      if (((paramBufferInfo.flags & 0x4) != 0) || (d.a(this.hmt)))
      {
        ae.i("MicroMsg.MediaCodecAACEncoderAsync", "receive EOS!");
        this.hmt.atI();
        AppMethodBeat.o(93630);
        return;
      }
      AppMethodBeat.o(93630);
    }
    
    public final void onOutputFormatChanged(MediaCodec paramMediaCodec, MediaFormat paramMediaFormat)
    {
      AppMethodBeat.i(93632);
      ae.i("MicroMsg.MediaCodecAACEncoderAsync", "onOutputFormatChanged: ".concat(String.valueOf(paramMediaFormat)));
      AppMethodBeat.o(93632);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.media.e.d
 * JD-Core Version:    0.7.0.1
 */