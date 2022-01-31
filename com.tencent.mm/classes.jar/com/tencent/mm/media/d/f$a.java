package com.tencent.mm.media.d;

import a.f.a.a;
import a.f.b.j;
import a.l;
import android.media.MediaCodec;
import android.media.MediaCodec.BufferInfo;
import android.media.MediaCodec.Callback;
import android.media.MediaCodec.CodecException;
import android.media.MediaFormat;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.media.i.c;
import com.tencent.mm.sdk.platformtools.ab;
import java.nio.ByteBuffer;

@l(eaO={1, 1, 13}, eaP={""}, eaQ={"com/tencent/mm/media/encoder/MediaCodecTransEncoderAsync$codecCallback$1", "Landroid/media/MediaCodec$Callback;", "onError", "", "codec", "Landroid/media/MediaCodec;", "e", "Landroid/media/MediaCodec$CodecException;", "onInputBufferAvailable", "index", "", "onOutputBufferAvailable", "outputBufferIndex", "bufferInfo", "Landroid/media/MediaCodec$BufferInfo;", "onOutputFormatChanged", "format", "Landroid/media/MediaFormat;", "plugin-mediaeditor_release"})
public final class f$a
  extends MediaCodec.Callback
{
  public final void onError(MediaCodec paramMediaCodec, MediaCodec.CodecException paramCodecException)
  {
    AppMethodBeat.i(12956);
    j.q(paramMediaCodec, "codec");
    j.q(paramCodecException, "e");
    ab.e(this.eUG.TAG, "codec Error, e:".concat(String.valueOf(paramCodecException)));
    if (this.eUG.eSb)
    {
      paramMediaCodec = c.eZC;
      c.Wz();
    }
    AppMethodBeat.o(12956);
  }
  
  public final void onInputBufferAvailable(MediaCodec paramMediaCodec, int paramInt)
  {
    AppMethodBeat.i(12954);
    j.q(paramMediaCodec, "codec");
    ab.i(this.eUG.TAG, "onInputBufferAvailable, index:".concat(String.valueOf(paramInt)));
    AppMethodBeat.o(12954);
  }
  
  public final void onOutputBufferAvailable(MediaCodec paramMediaCodec, int paramInt, MediaCodec.BufferInfo paramBufferInfo)
  {
    AppMethodBeat.i(12953);
    j.q(paramMediaCodec, "codec");
    j.q(paramBufferInfo, "bufferInfo");
    ab.d(this.eUG.TAG, "onOutputBufferAvailable index:" + paramInt + ", info: " + paramBufferInfo);
    if (paramInt >= 0)
    {
      try
      {
        paramMediaCodec = this.eUG.eUg.getOutputBuffer(paramInt);
        if ((paramBufferInfo.flags & 0x2) != 0) {
          ab.i(this.eUG.TAG, "codec config!");
        }
        if (((paramBufferInfo.flags & 0x4) == 0) && (!this.eUG.eRq)) {
          break label267;
        }
        ab.i(this.eUG.TAG, "encode end of stream");
        try
        {
          this.eUG.eUg.stop();
          this.eUG.eUg.release();
          this.eUG.eRq = true;
          this.eUG.release();
          paramMediaCodec = this.eUG.eUp;
          if (paramMediaCodec != null)
          {
            paramMediaCodec.invoke();
            AppMethodBeat.o(12953);
            return;
          }
        }
        catch (Exception paramMediaCodec)
        {
          for (;;)
          {
            ab.e(this.eUG.TAG, "release encoder error " + paramMediaCodec.getMessage());
          }
        }
        AppMethodBeat.o(12953);
      }
      catch (Exception paramMediaCodec)
      {
        ab.printErrStackTrace(this.eUG.TAG, (Throwable)paramMediaCodec, "onOutputBufferAvailable error", new Object[0]);
        if (this.eUG.eSb)
        {
          paramMediaCodec = c.eZC;
          c.Wy();
        }
        AppMethodBeat.o(12953);
        return;
      }
      return;
      label267:
      if (paramBufferInfo.size != 0)
      {
        paramMediaCodec.position(paramBufferInfo.offset);
        paramMediaCodec.limit(paramBufferInfo.offset + paramBufferInfo.size);
        f localf = this.eUG;
        j.p(paramMediaCodec, "outputBuffer");
        localf.f(paramMediaCodec, paramBufferInfo);
        this.eUG.eUg.releaseOutputBuffer(paramInt, paramBufferInfo.presentationTimeUs);
      }
      AppMethodBeat.o(12953);
      return;
    }
    this.eUG.eUg.releaseOutputBuffer(paramInt, false);
    AppMethodBeat.o(12953);
  }
  
  public final void onOutputFormatChanged(MediaCodec paramMediaCodec, MediaFormat paramMediaFormat)
  {
    AppMethodBeat.i(12955);
    j.q(paramMediaCodec, "codec");
    j.q(paramMediaFormat, "format");
    ab.i(this.eUG.TAG, "encoder output format changed " + this.eUG.eUg.getOutputFormat());
    AppMethodBeat.o(12955);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.media.d.f.a
 * JD-Core Version:    0.7.0.1
 */