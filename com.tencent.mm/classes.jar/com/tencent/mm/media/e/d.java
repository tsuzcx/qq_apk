package com.tencent.mm.media.e;

import android.media.MediaCodec;
import android.media.MediaCodec.BufferInfo;
import android.media.MediaCodec.Callback;
import android.media.MediaCodec.CodecException;
import android.media.MediaFormat;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.sdk.platformtools.ad;
import com.tencent.mm.sdk.platformtools.bt;
import d.a.j;
import d.g.a.q;
import d.g.b.p;
import d.l;
import java.nio.ByteBuffer;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

@l(gfx={1, 1, 16}, gfy={""}, gfz={"Lcom/tencent/mm/media/encoder/MediaCodecAACEncoderAsync;", "Lcom/tencent/mm/media/encoder/IAudioEncoder;", "mediaFormat", "Landroid/media/MediaFormat;", "frameEncodeCallback", "Lkotlin/Function3;", "Ljava/nio/ByteBuffer;", "Lkotlin/ParameterName;", "name", "data", "Landroid/media/MediaCodec$BufferInfo;", "bufferInfo", "farmat", "", "frameEncodeEndCallback", "Lkotlin/Function0;", "(Landroid/media/MediaFormat;Lkotlin/jvm/functions/Function3;Lkotlin/jvm/functions/Function0;)V", "aacCallback", "com/tencent/mm/media/encoder/MediaCodecAACEncoderAsync$aacCallback$1", "Lcom/tencent/mm/media/encoder/MediaCodecAACEncoderAsync$aacCallback$1;", "encoderStart", "", "inputDataSource", "", "Lcom/tencent/mm/media/encoder/MediaCodecAACEncoderAsync$EncoderData;", "kotlin.jvm.PlatformType", "", "isInputEnd", "sendDataToEncoder", "pcmData", "", "pts", "", "isLast", "startEncoder", "Companion", "EncoderData", "plugin-mediaeditor_release"})
public final class d
  extends a
{
  public static final d.a hjD;
  private boolean hjA;
  private boolean hjB;
  private c hjC;
  private List<d.b> hjz;
  
  static
  {
    AppMethodBeat.i(93636);
    hjD = new d.a((byte)0);
    AppMethodBeat.o(93636);
  }
  
  public d(MediaFormat paramMediaFormat, q<? super ByteBuffer, ? super MediaCodec.BufferInfo, ? super MediaFormat, d.z> paramq, d.g.a.a<d.z> parama)
  {
    super(paramMediaFormat, paramq, parama);
    AppMethodBeat.i(93635);
    this.hjz = Collections.synchronizedList((List)new ArrayList());
    this.hjC = new c(this);
    try
    {
      this.hjj.setCallback((MediaCodec.Callback)this.hjC);
      AppMethodBeat.o(93635);
      return;
    }
    catch (Exception paramMediaFormat)
    {
      ad.printErrStackTrace("MicroMsg.MediaCodecAACEncoderAsync", (Throwable)paramMediaFormat, "", new Object[0]);
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
      this.hjz.add(paramArrayOfByte);
      if (!this.hjB)
      {
        this.hjj.start();
        this.hjB = true;
      }
    }
    AppMethodBeat.o(93634);
  }
  
  @l(gfx={1, 1, 16}, gfy={""}, gfz={"com/tencent/mm/media/encoder/MediaCodecAACEncoderAsync$aacCallback$1", "Landroid/media/MediaCodec$Callback;", "onError", "", "codec", "Landroid/media/MediaCodec;", "e", "Landroid/media/MediaCodec$CodecException;", "onInputBufferAvailable", "index", "", "onOutputBufferAvailable", "info", "Landroid/media/MediaCodec$BufferInfo;", "onOutputFormatChanged", "format", "Landroid/media/MediaFormat;", "plugin-mediaeditor_release"})
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
        ad.e("MicroMsg.MediaCodecAACEncoderAsync", paramMediaCodec + ", " + paramCodecException);
        AppMethodBeat.o(93633);
        return;
      }
    }
    
    public final void onInputBufferAvailable(MediaCodec paramMediaCodec, int paramInt)
    {
      AppMethodBeat.i(93631);
      try
      {
        ad.i("MicroMsg.MediaCodecAACEncoderAsync", "has input buffer ".concat(String.valueOf(paramInt)));
        if (d.c(this.hjF).size() == 0)
        {
          ad.i("MicroMsg.MediaCodecAACEncoderAsync", "current data is null");
          this.hjF.hjj.a(paramInt, 0, 0L, 0);
          AppMethodBeat.o(93631);
          return;
        }
        ad.i("MicroMsg.MediaCodecAACEncoderAsync", "has input buffer avaiable".concat(String.valueOf(paramInt)));
        if (!this.hjF.hhJ) {
          break label120;
        }
        ad.i("MicroMsg.MediaCodecAACEncoderAsync", "sendDataToEncoder end now");
        AppMethodBeat.o(93631);
        return;
      }
      catch (Exception paramMediaCodec)
      {
        ad.printErrStackTrace("MicroMsg.MediaCodecAACEncoderAsync", (Throwable)paramMediaCodec, "onInputBufferAvailable error", new Object[0]);
      }
      AppMethodBeat.o(93631);
      return;
      label120:
      this.hjF.hjl = bt.HI();
      if (paramInt < 0)
      {
        ad.d("MicroMsg.MediaCodecAACEncoderAsync", "encoder no input buffer available, drain first");
        AppMethodBeat.o(93631);
        return;
      }
      paramMediaCodec = d.c(this.hjF);
      p.g(paramMediaCodec, "inputDataSource");
      d.b localb = (d.b)j.jc(paramMediaCodec);
      byte[] arrayOfByte = localb.dbX;
      long l = localb.pts;
      boolean bool = localb.hjE;
      StringBuilder localStringBuilder = new StringBuilder("encode data, pts:").append(l).append(", isLast:").append(bool).append(", pcmData:");
      if (arrayOfByte != null) {}
      for (paramMediaCodec = Integer.valueOf(arrayOfByte.length);; paramMediaCodec = null)
      {
        ad.i("MicroMsg.MediaCodecAACEncoderAsync", paramMediaCodec + ", inputDataSource.size:" + d.c(this.hjF).size());
        if (arrayOfByte == null)
        {
          AppMethodBeat.o(93631);
          return;
        }
        if (paramInt < 0) {
          break;
        }
        paramMediaCodec = this.hjF.hjj.getInputBuffer(paramInt);
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
          ad.i("MicroMsg.MediaCodecAACEncoderAsync", "last, send EOS and try delay stop encoder");
        }
        for (int i = 1;; i = 0)
        {
          if (i != 0)
          {
            d.b(this.hjF);
            ad.i("MicroMsg.MediaCodecAACEncoderAsync", "EOS received in sendAudioToEncoder");
            this.hjF.hjj.a(paramInt, arrayOfByte.length, l, 4);
          }
          for (;;)
          {
            d.c(this.hjF).remove(localb);
            AppMethodBeat.o(93631);
            return;
            this.hjF.hjj.a(paramInt, arrayOfByte.length, l, 0);
          }
        }
      }
    }
    
    public final void onOutputBufferAvailable(MediaCodec paramMediaCodec, int paramInt, MediaCodec.BufferInfo paramBufferInfo)
    {
      AppMethodBeat.i(93630);
      try
      {
        ad.d("MicroMsg.MediaCodecAACEncoderAsync", "encoderOutputBufferIndex: %s", new Object[] { Integer.valueOf(paramInt) });
        if (paramInt == -1)
        {
          ad.d("MicroMsg.MediaCodecAACEncoderAsync", "no output available, break");
          AppMethodBeat.o(93630);
          return;
        }
        if (paramInt == -2)
        {
          paramMediaCodec = this.hjF;
          paramBufferInfo = this.hjF.hjj.getOutputFormat();
          p.g(paramBufferInfo, "encoder.outputFormat");
          paramMediaCodec.d(paramBufferInfo);
          ad.i("MicroMsg.MediaCodecAACEncoderAsync", "dstMediaFormat change: %s", new Object[] { this.hjF.hjk });
          AppMethodBeat.o(93630);
          return;
        }
      }
      catch (Exception paramMediaCodec)
      {
        ad.printErrStackTrace("MicroMsg.MediaCodecAACEncoderAsync", (Throwable)paramMediaCodec, "drainEncoder error: %s", new Object[] { paramMediaCodec.getMessage() });
        AppMethodBeat.o(93630);
        return;
      }
      if (paramInt < 0)
      {
        ad.e("MicroMsg.MediaCodecAACEncoderAsync", "unexpected encoderOutputBufferIndex: %s", new Object[] { Integer.valueOf(paramInt) });
        AppMethodBeat.o(93630);
        return;
      }
      if (paramBufferInfo == null) {
        p.gfZ();
      }
      if ((paramBufferInfo.flags & 0x2) != 0)
      {
        ad.v("MicroMsg.MediaCodecAACEncoderAsync", "ignoring BUFFER_FLAG_CODEC_CONFIG,size: %s, %s", new Object[] { Integer.valueOf(paramBufferInfo.size), Boolean.TRUE });
        paramBufferInfo.size = 0;
      }
      ad.v("MicroMsg.MediaCodecAACEncoderAsync", "perform encoding");
      paramMediaCodec = this.hjF.hjj.getOutputBuffer(paramInt);
      this.hjF.f(paramMediaCodec, paramBufferInfo);
      this.hjF.hjj.releaseOutputBuffer(paramInt, false);
      if (((paramBufferInfo.flags & 0x4) != 0) || (d.a(this.hjF)))
      {
        ad.i("MicroMsg.MediaCodecAACEncoderAsync", "receive EOS!");
        this.hjF.att();
        AppMethodBeat.o(93630);
        return;
      }
      AppMethodBeat.o(93630);
    }
    
    public final void onOutputFormatChanged(MediaCodec paramMediaCodec, MediaFormat paramMediaFormat)
    {
      AppMethodBeat.i(93632);
      ad.i("MicroMsg.MediaCodecAACEncoderAsync", "onOutputFormatChanged: ".concat(String.valueOf(paramMediaFormat)));
      AppMethodBeat.o(93632);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.media.e.d
 * JD-Core Version:    0.7.0.1
 */