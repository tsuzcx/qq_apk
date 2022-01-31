package com.tencent.mm.media.c;

import a.f.b.j;
import a.l;
import android.media.MediaCodec;
import android.media.MediaCodec.BufferInfo;
import android.media.MediaCodec.Callback;
import android.media.MediaCodec.CodecException;
import android.media.MediaFormat;
import android.view.Surface;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.media.e.a;
import com.tencent.mm.media.i.c;
import com.tencent.mm.sdk.platformtools.ab;
import java.nio.ByteBuffer;

@l(eaO={1, 1, 13}, eaP={""}, eaQ={"com/tencent/mm/media/decoder/MediaCodecTransDecoderAsync$codecCallback$1", "Landroid/media/MediaCodec$Callback;", "onError", "", "codec", "Landroid/media/MediaCodec;", "e", "Landroid/media/MediaCodec$CodecException;", "onInputBufferAvailable", "index", "", "onOutputBufferAvailable", "decoderOutputBufferIndex", "bufferInfo", "Landroid/media/MediaCodec$BufferInfo;", "onOutputFormatChanged", "format", "Landroid/media/MediaFormat;", "plugin-mediaeditor_release"})
public final class f$a
  extends MediaCodec.Callback
{
  f$a(Surface paramSurface, a parama) {}
  
  public final void onError(MediaCodec paramMediaCodec, MediaCodec.CodecException paramCodecException)
  {
    AppMethodBeat.i(12870);
    j.q(paramMediaCodec, "codec");
    j.q(paramCodecException, "e");
    ab.e(this.eSw.TAG, "onError, codec:" + paramMediaCodec + ", " + paramCodecException.isRecoverable() + ' ' + paramCodecException.isTransient() + ' ' + paramCodecException.getDiagnosticInfo());
    if (this.eSw.eSb)
    {
      paramMediaCodec = c.eZC;
      c.Ww();
    }
    if ((!paramCodecException.isRecoverable()) && (!paramCodecException.isTransient()))
    {
      paramMediaCodec = c.eZC;
      c.Wx();
      this.eSw.pJ();
      f.a(this.eSw);
    }
    AppMethodBeat.o(12870);
  }
  
  public final void onInputBufferAvailable(MediaCodec paramMediaCodec, int paramInt)
  {
    AppMethodBeat.i(12868);
    j.q(paramMediaCodec, "codec");
    ab.i(this.eSw.TAG, "onInputBufferAvailable, index:".concat(String.valueOf(paramInt)));
    if (paramInt >= 0) {}
    for (;;)
    {
      try
      {
        this.eSw.eSr = false;
        paramMediaCodec = this.eSw.eRD;
        if (paramMediaCodec == null) {
          j.ebi();
        }
        paramMediaCodec = paramMediaCodec.getInputBuffer(paramInt);
        paramMediaCodec.clear();
        a locala = this.eSq;
        j.p(paramMediaCodec, "inputBuffer");
        if (!locala.g(paramMediaCodec))
        {
          ab.i(this.eSw.TAG, "read sample end");
          this.eSw.eSr = true;
        }
        long l1 = 0L;
        if (this.eSw.eSr) {
          break label337;
        }
        int j = this.eSq.sampleSize;
        paramMediaCodec.position(0);
        long l2 = this.eSq.getSampleTime();
        ab.i(this.eSw.TAG, "sampleTime : " + l2 + ", sampleSize:" + j);
        if (j >= 0)
        {
          i = j;
          l1 = l2;
          if (l2 < this.eSw.eRN * 1000L) {}
        }
        else
        {
          this.eSw.eSr = true;
          ab.i(this.eSw.TAG, "sawInputEOS");
          l1 = l2;
          i = j;
        }
        paramMediaCodec = this.eSw.eRD;
        if (paramMediaCodec == null) {
          j.ebi();
        }
        if (this.eSw.eSr)
        {
          j = 4;
          paramMediaCodec.queueInputBuffer(paramInt, 0, i, l1, j);
          AppMethodBeat.o(12868);
          return;
        }
        j = 0;
        continue;
        AppMethodBeat.o(12868);
      }
      catch (Exception paramMediaCodec)
      {
        ab.printErrStackTrace(this.eSw.TAG, (Throwable)paramMediaCodec, "onInputBufferAvailable error", new Object[0]);
        if (this.eSw.eSb)
        {
          paramMediaCodec = c.eZC;
          c.Wv();
        }
      }
      return;
      label337:
      int i = 0;
    }
  }
  
  public final void onOutputBufferAvailable(MediaCodec paramMediaCodec, int paramInt, MediaCodec.BufferInfo paramBufferInfo)
  {
    AppMethodBeat.i(12867);
    j.q(paramMediaCodec, "codec");
    j.q(paramBufferInfo, "bufferInfo");
    ab.i(this.eSw.TAG, "onOutputBufferAvailable, index:" + paramInt + ", bufferInfo:" + paramBufferInfo + " size:" + paramBufferInfo.size + ", isFinished:" + this.eSw.eRZ);
    if (paramInt >= 0)
    {
      do
      {
        for (;;)
        {
          try
          {
            long l = paramBufferInfo.presentationTimeUs;
            ab.i(this.eSw.TAG, "presentationTimeUs : ".concat(String.valueOf(l)));
            if ((l < this.eSw.aZw * 1000L) && ((paramBufferInfo.flags & 0x4) == 0))
            {
              paramMediaCodec = this.eSw.eRD;
              if (paramMediaCodec == null) {
                j.ebi();
              }
              paramMediaCodec.releaseOutputBuffer(paramInt, false);
              ab.i(this.eSw.TAG, "decoder pts: " + l + ", not reach start: " + this.eSw.aZw * 1000L);
              AppMethodBeat.o(12867);
              return;
            }
            this.eSw.a(paramBufferInfo);
            paramMediaCodec = this.eSw.eRD;
            if (paramMediaCodec == null) {
              j.ebi();
            }
            if (this.eSx != null)
            {
              bool = true;
              paramMediaCodec.releaseOutputBuffer(paramInt, bool);
              if ((this.eSw.eRN * 1000L == 1L) || (l < this.eSw.eRN * 1000L)) {
                break;
              }
              ab.e(this.eSw.TAG, "exceed endTimeMs");
              this.eSw.pJ();
              f.a(this.eSw);
              AppMethodBeat.o(12867);
              return;
            }
          }
          catch (Exception paramMediaCodec)
          {
            ab.printErrStackTrace(this.eSw.TAG, (Throwable)paramMediaCodec, "onOutputBufferAvailable error", new Object[0]);
            if (this.eSw.eSb)
            {
              paramMediaCodec = c.eZC;
              c.Wv();
            }
            AppMethodBeat.o(12867);
            return;
          }
          boolean bool = false;
        }
      } while (((paramBufferInfo.flags & 0x4) == 0) && (!this.eSw.eSr));
      ab.i(this.eSw.TAG, "receive eos!");
      this.eSw.pJ();
      f.a(this.eSw);
      AppMethodBeat.o(12867);
      return;
    }
    paramMediaCodec = this.eSw.eRD;
    if (paramMediaCodec == null) {
      j.ebi();
    }
    paramMediaCodec.releaseOutputBuffer(paramInt, false);
    AppMethodBeat.o(12867);
  }
  
  public final void onOutputFormatChanged(MediaCodec paramMediaCodec, MediaFormat paramMediaFormat)
  {
    AppMethodBeat.i(12869);
    j.q(paramMediaCodec, "codec");
    j.q(paramMediaFormat, "format");
    this.eSw.mediaFormat = paramMediaFormat;
    ab.i(this.eSw.TAG, "decoder output format changed: " + this.eSw.mediaFormat);
    paramMediaCodec = this.eSw.mediaFormat;
    if (paramMediaCodec != null)
    {
      paramMediaFormat = this.eSw.eRV;
      if (paramMediaFormat != null)
      {
        paramMediaFormat.S(paramMediaCodec);
        AppMethodBeat.o(12869);
        return;
      }
      AppMethodBeat.o(12869);
      return;
    }
    AppMethodBeat.o(12869);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes8.jar
 * Qualified Name:     com.tencent.mm.media.c.f.a
 * JD-Core Version:    0.7.0.1
 */