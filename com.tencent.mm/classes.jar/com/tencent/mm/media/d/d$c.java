package com.tencent.mm.media.d;

import a.l;
import android.media.MediaCodec;
import android.media.MediaCodec.BufferInfo;
import android.media.MediaCodec.Callback;
import android.media.MediaCodec.CodecException;
import android.media.MediaFormat;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.sdk.platformtools.ab;
import com.tencent.mm.sdk.platformtools.bo;
import java.nio.ByteBuffer;
import java.util.List;

@l(eaO={1, 1, 13}, eaP={""}, eaQ={"com/tencent/mm/media/encoder/MediaCodecAACEncoderAsync$aacCallback$1", "Landroid/media/MediaCodec$Callback;", "onError", "", "codec", "Landroid/media/MediaCodec;", "e", "Landroid/media/MediaCodec$CodecException;", "onInputBufferAvailable", "index", "", "onOutputBufferAvailable", "info", "Landroid/media/MediaCodec$BufferInfo;", "onOutputFormatChanged", "format", "Landroid/media/MediaFormat;", "plugin-mediaeditor_release"})
public final class d$c
  extends MediaCodec.Callback
{
  public final void onError(MediaCodec paramMediaCodec, MediaCodec.CodecException paramCodecException) {}
  
  public final void onInputBufferAvailable(MediaCodec paramMediaCodec, int paramInt)
  {
    AppMethodBeat.i(12939);
    byte[] arrayOfByte;
    long l;
    boolean bool;
    do
    {
      try
      {
        ab.i("MicroMsg.MediaCodecAACEncoder", "has input buffer ".concat(String.valueOf(paramInt)));
        if (d.c(this.eUy).size() == 0)
        {
          ab.i("MicroMsg.MediaCodecAACEncoder", "current data is null");
          this.eUy.eUg.queueInputBuffer(paramInt, 0, 0, 0L, 0);
          AppMethodBeat.o(12939);
          return;
        }
        ab.i("MicroMsg.MediaCodecAACEncoder", "has input buffer avaiable".concat(String.valueOf(paramInt)));
        if (this.eUy.eRq)
        {
          ab.i("MicroMsg.MediaCodecAACEncoder", "sendDataToEncoder end now");
          AppMethodBeat.o(12939);
          return;
        }
      }
      catch (Exception paramMediaCodec)
      {
        ab.printErrStackTrace("MicroMsg.MediaCodecAACEncoder", (Throwable)paramMediaCodec, "onInputBufferAvailable error", new Object[0]);
        AppMethodBeat.o(12939);
        return;
      }
      this.eUy.eUi = bo.yB();
      if (paramInt < 0)
      {
        ab.d("MicroMsg.MediaCodecAACEncoder", "encoder no input buffer available, drain first");
        AppMethodBeat.o(12939);
        return;
      }
      paramMediaCodec = d.c(this.eUy);
      a.f.b.j.p(paramMediaCodec, "inputDataSource");
      paramMediaCodec = (d.b)a.a.j.fQ(paramMediaCodec);
      arrayOfByte = paramMediaCodec.cem;
      l = paramMediaCodec.pts;
      bool = paramMediaCodec.eUx;
      if (arrayOfByte == null)
      {
        AppMethodBeat.o(12939);
        return;
      }
    } while (paramInt < 0);
    ByteBuffer localByteBuffer = this.eUy.eUg.getInputBuffer(paramInt);
    if (localByteBuffer != null) {
      localByteBuffer.clear();
    }
    if (localByteBuffer != null) {
      localByteBuffer.position(0);
    }
    if (localByteBuffer != null) {
      localByteBuffer.put(arrayOfByte);
    }
    if (bool) {
      ab.i("MicroMsg.MediaCodecAACEncoder", "last, send EOS and try delay stop encoder");
    }
    for (int i = 1;; i = 0)
    {
      if (i != 0)
      {
        d.b(this.eUy);
        ab.i("MicroMsg.MediaCodecAACEncoder", "EOS received in sendAudioToEncoder");
        this.eUy.eUg.queueInputBuffer(paramInt, 0, arrayOfByte.length, l, 4);
      }
      for (;;)
      {
        d.c(this.eUy).remove(paramMediaCodec);
        AppMethodBeat.o(12939);
        return;
        this.eUy.eUg.queueInputBuffer(paramInt, 0, arrayOfByte.length, l, 0);
      }
    }
  }
  
  public final void onOutputBufferAvailable(MediaCodec paramMediaCodec, int paramInt, MediaCodec.BufferInfo paramBufferInfo)
  {
    AppMethodBeat.i(12938);
    try
    {
      ab.d("MicroMsg.MediaCodecAACEncoder", "encoderOutputBufferIndex: %s", new Object[] { Integer.valueOf(paramInt) });
      if (paramInt == -1)
      {
        ab.d("MicroMsg.MediaCodecAACEncoder", "no output available, break");
        AppMethodBeat.o(12938);
        return;
      }
      if (paramInt == -2)
      {
        paramMediaCodec = this.eUy;
        paramBufferInfo = this.eUy.eUg.getOutputFormat();
        a.f.b.j.p(paramBufferInfo, "encoder.outputFormat");
        paramMediaCodec.d(paramBufferInfo);
        ab.i("MicroMsg.MediaCodecAACEncoder", "dstMediaFormat change: %s", new Object[] { this.eUy.eUh });
        AppMethodBeat.o(12938);
        return;
      }
    }
    catch (Exception paramMediaCodec)
    {
      ab.printErrStackTrace("MicroMsg.MediaCodecAACEncoder", (Throwable)paramMediaCodec, "drainEncoder error: %s", new Object[] { paramMediaCodec.getMessage() });
      AppMethodBeat.o(12938);
      return;
    }
    if (paramInt < 0)
    {
      ab.e("MicroMsg.MediaCodecAACEncoder", "unexpected encoderOutputBufferIndex: %s", new Object[] { Integer.valueOf(paramInt) });
      AppMethodBeat.o(12938);
      return;
    }
    if (paramBufferInfo == null) {
      a.f.b.j.ebi();
    }
    if ((paramBufferInfo.flags & 0x2) != 0)
    {
      ab.v("MicroMsg.MediaCodecAACEncoder", "ignoring BUFFER_FLAG_CODEC_CONFIG,size: %s, %s", new Object[] { Integer.valueOf(paramBufferInfo.size), Boolean.TRUE });
      paramBufferInfo.size = 0;
    }
    ab.v("MicroMsg.MediaCodecAACEncoder", "perform encoding");
    paramMediaCodec = this.eUy.eUg.getOutputBuffer(paramInt);
    this.eUy.f(paramMediaCodec, paramBufferInfo);
    this.eUy.eUg.releaseOutputBuffer(paramInt, false);
    if (((paramBufferInfo.flags & 0x4) != 0) || (d.a(this.eUy)))
    {
      ab.i("MicroMsg.MediaCodecAACEncoder", "receive EOS!");
      this.eUy.releaseEncoder();
      AppMethodBeat.o(12938);
      return;
    }
    AppMethodBeat.o(12938);
  }
  
  public final void onOutputFormatChanged(MediaCodec paramMediaCodec, MediaFormat paramMediaFormat) {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.media.d.d.c
 * JD-Core Version:    0.7.0.1
 */