package com.tencent.mm.media.d;

import android.media.MediaCodec;
import android.media.MediaCodec.BufferInfo;
import android.media.MediaCodec.Callback;
import android.media.MediaCodec.CodecException;
import android.media.MediaFormat;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.compatible.deviceinfo.z;
import com.tencent.mm.sdk.platformtools.ac;
import com.tencent.mm.sdk.platformtools.bs;
import d.a.j;
import d.g.a.q;
import d.g.b.k;
import d.l;
import d.y;
import java.nio.ByteBuffer;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

@l(fNY={1, 1, 16}, fNZ={""}, fOa={"Lcom/tencent/mm/media/encoder/MediaCodecAACEncoderAsync;", "Lcom/tencent/mm/media/encoder/IAudioEncoder;", "mediaFormat", "Landroid/media/MediaFormat;", "frameEncodeCallback", "Lkotlin/Function3;", "Ljava/nio/ByteBuffer;", "Lkotlin/ParameterName;", "name", "data", "Landroid/media/MediaCodec$BufferInfo;", "bufferInfo", "farmat", "", "frameEncodeEndCallback", "Lkotlin/Function0;", "(Landroid/media/MediaFormat;Lkotlin/jvm/functions/Function3;Lkotlin/jvm/functions/Function0;)V", "aacCallback", "com/tencent/mm/media/encoder/MediaCodecAACEncoderAsync$aacCallback$1", "Lcom/tencent/mm/media/encoder/MediaCodecAACEncoderAsync$aacCallback$1;", "encoderStart", "", "inputDataSource", "", "Lcom/tencent/mm/media/encoder/MediaCodecAACEncoderAsync$EncoderData;", "kotlin.jvm.PlatformType", "", "isInputEnd", "sendDataToEncoder", "pcmData", "", "pts", "", "isLast", "startEncoder", "Companion", "EncoderData", "plugin-mediaeditor_release"})
public final class d
  extends a
{
  public static final d.a gRl;
  private List<d.b> gRh;
  private boolean gRi;
  private boolean gRj;
  private c gRk;
  
  static
  {
    AppMethodBeat.i(93636);
    gRl = new d.a((byte)0);
    AppMethodBeat.o(93636);
  }
  
  public d(MediaFormat paramMediaFormat, q<? super ByteBuffer, ? super MediaCodec.BufferInfo, ? super MediaFormat, y> paramq, d.g.a.a<y> parama)
  {
    super(paramMediaFormat, paramq, parama);
    AppMethodBeat.i(93635);
    this.gRh = Collections.synchronizedList((List)new ArrayList());
    this.gRk = new c(this);
    try
    {
      this.gQR.setCallback((MediaCodec.Callback)this.gRk);
      AppMethodBeat.o(93635);
      return;
    }
    catch (Exception paramMediaFormat)
    {
      ac.printErrStackTrace("MicroMsg.MediaCodecAACEncoderAsync", (Throwable)paramMediaFormat, "", new Object[0]);
      AppMethodBeat.o(93635);
    }
  }
  
  public final void b(byte[] paramArrayOfByte, long paramLong, boolean paramBoolean)
  {
    AppMethodBeat.i(93634);
    k.h(paramArrayOfByte, "data");
    if (paramArrayOfByte != null)
    {
      paramArrayOfByte = new d.b(paramArrayOfByte, paramLong, paramBoolean);
      this.gRh.add(paramArrayOfByte);
      if (!this.gRj)
      {
        this.gQR.start();
        this.gRj = true;
      }
    }
    AppMethodBeat.o(93634);
  }
  
  @l(fNY={1, 1, 16}, fNZ={""}, fOa={"com/tencent/mm/media/encoder/MediaCodecAACEncoderAsync$aacCallback$1", "Landroid/media/MediaCodec$Callback;", "onError", "", "codec", "Landroid/media/MediaCodec;", "e", "Landroid/media/MediaCodec$CodecException;", "onInputBufferAvailable", "index", "", "onOutputBufferAvailable", "info", "Landroid/media/MediaCodec$BufferInfo;", "onOutputFormatChanged", "format", "Landroid/media/MediaFormat;", "plugin-mediaeditor_release"})
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
        ac.e("MicroMsg.MediaCodecAACEncoderAsync", paramMediaCodec + ", " + paramCodecException);
        AppMethodBeat.o(93633);
        return;
      }
    }
    
    public final void onInputBufferAvailable(MediaCodec paramMediaCodec, int paramInt)
    {
      AppMethodBeat.i(93631);
      try
      {
        ac.i("MicroMsg.MediaCodecAACEncoderAsync", "has input buffer ".concat(String.valueOf(paramInt)));
        if (d.c(this.gRn).size() == 0)
        {
          ac.i("MicroMsg.MediaCodecAACEncoderAsync", "current data is null");
          this.gRn.gQR.a(paramInt, 0, 0L, 0);
          AppMethodBeat.o(93631);
          return;
        }
        ac.i("MicroMsg.MediaCodecAACEncoderAsync", "has input buffer avaiable".concat(String.valueOf(paramInt)));
        if (!this.gRn.gNN) {
          break label120;
        }
        ac.i("MicroMsg.MediaCodecAACEncoderAsync", "sendDataToEncoder end now");
        AppMethodBeat.o(93631);
        return;
      }
      catch (Exception paramMediaCodec)
      {
        ac.printErrStackTrace("MicroMsg.MediaCodecAACEncoderAsync", (Throwable)paramMediaCodec, "onInputBufferAvailable error", new Object[0]);
      }
      AppMethodBeat.o(93631);
      return;
      label120:
      this.gRn.gQT = bs.Gn();
      if (paramInt < 0)
      {
        ac.d("MicroMsg.MediaCodecAACEncoderAsync", "encoder no input buffer available, drain first");
        AppMethodBeat.o(93631);
        return;
      }
      paramMediaCodec = d.c(this.gRn);
      k.g(paramMediaCodec, "inputDataSource");
      d.b localb = (d.b)j.iO(paramMediaCodec);
      byte[] arrayOfByte = localb.cQH;
      long l = localb.pts;
      boolean bool = localb.gRm;
      StringBuilder localStringBuilder = new StringBuilder("encode data, pts:").append(l).append(", isLast:").append(bool).append(", pcmData:");
      if (arrayOfByte != null) {}
      for (paramMediaCodec = Integer.valueOf(arrayOfByte.length);; paramMediaCodec = null)
      {
        ac.i("MicroMsg.MediaCodecAACEncoderAsync", paramMediaCodec + ", inputDataSource.size:" + d.c(this.gRn).size());
        if (arrayOfByte == null)
        {
          AppMethodBeat.o(93631);
          return;
        }
        if (paramInt < 0) {
          break;
        }
        paramMediaCodec = this.gRn.gQR.getInputBuffer(paramInt);
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
          ac.i("MicroMsg.MediaCodecAACEncoderAsync", "last, send EOS and try delay stop encoder");
        }
        for (int i = 1;; i = 0)
        {
          if (i != 0)
          {
            d.b(this.gRn);
            ac.i("MicroMsg.MediaCodecAACEncoderAsync", "EOS received in sendAudioToEncoder");
            this.gRn.gQR.a(paramInt, arrayOfByte.length, l, 4);
          }
          for (;;)
          {
            d.c(this.gRn).remove(localb);
            AppMethodBeat.o(93631);
            return;
            this.gRn.gQR.a(paramInt, arrayOfByte.length, l, 0);
          }
        }
      }
    }
    
    public final void onOutputBufferAvailable(MediaCodec paramMediaCodec, int paramInt, MediaCodec.BufferInfo paramBufferInfo)
    {
      AppMethodBeat.i(93630);
      try
      {
        ac.d("MicroMsg.MediaCodecAACEncoderAsync", "encoderOutputBufferIndex: %s", new Object[] { Integer.valueOf(paramInt) });
        if (paramInt == -1)
        {
          ac.d("MicroMsg.MediaCodecAACEncoderAsync", "no output available, break");
          AppMethodBeat.o(93630);
          return;
        }
        if (paramInt == -2)
        {
          paramMediaCodec = this.gRn;
          paramBufferInfo = this.gRn.gQR.getOutputFormat();
          k.g(paramBufferInfo, "encoder.outputFormat");
          paramMediaCodec.d(paramBufferInfo);
          ac.i("MicroMsg.MediaCodecAACEncoderAsync", "dstMediaFormat change: %s", new Object[] { this.gRn.gQS });
          AppMethodBeat.o(93630);
          return;
        }
      }
      catch (Exception paramMediaCodec)
      {
        ac.printErrStackTrace("MicroMsg.MediaCodecAACEncoderAsync", (Throwable)paramMediaCodec, "drainEncoder error: %s", new Object[] { paramMediaCodec.getMessage() });
        AppMethodBeat.o(93630);
        return;
      }
      if (paramInt < 0)
      {
        ac.e("MicroMsg.MediaCodecAACEncoderAsync", "unexpected encoderOutputBufferIndex: %s", new Object[] { Integer.valueOf(paramInt) });
        AppMethodBeat.o(93630);
        return;
      }
      if (paramBufferInfo == null) {
        k.fOy();
      }
      if ((paramBufferInfo.flags & 0x2) != 0)
      {
        ac.v("MicroMsg.MediaCodecAACEncoderAsync", "ignoring BUFFER_FLAG_CODEC_CONFIG,size: %s, %s", new Object[] { Integer.valueOf(paramBufferInfo.size), Boolean.TRUE });
        paramBufferInfo.size = 0;
      }
      ac.v("MicroMsg.MediaCodecAACEncoderAsync", "perform encoding");
      paramMediaCodec = this.gRn.gQR.getOutputBuffer(paramInt);
      this.gRn.f(paramMediaCodec, paramBufferInfo);
      this.gRn.gQR.releaseOutputBuffer(paramInt, false);
      if (((paramBufferInfo.flags & 0x4) != 0) || (d.a(this.gRn)))
      {
        ac.i("MicroMsg.MediaCodecAACEncoderAsync", "receive EOS!");
        this.gRn.aqF();
        AppMethodBeat.o(93630);
        return;
      }
      AppMethodBeat.o(93630);
    }
    
    public final void onOutputFormatChanged(MediaCodec paramMediaCodec, MediaFormat paramMediaFormat)
    {
      AppMethodBeat.i(93632);
      ac.i("MicroMsg.MediaCodecAACEncoderAsync", "onOutputFormatChanged: ".concat(String.valueOf(paramMediaFormat)));
      AppMethodBeat.o(93632);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.media.d.d
 * JD-Core Version:    0.7.0.1
 */