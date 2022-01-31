package com.tencent.mm.media.c;

import a.f.b.j;
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

@l(eaO={1, 1, 13}, eaP={""}, eaQ={"com/tencent/mm/media/decoder/MediaCodecAACDecoderAsync$aacCallback$1", "Landroid/media/MediaCodec$Callback;", "onError", "", "codec", "Landroid/media/MediaCodec;", "e", "Landroid/media/MediaCodec$CodecException;", "onInputBufferAvailable", "index", "", "onOutputBufferAvailable", "decoderOutputBufferIndex", "bufferInfo", "Landroid/media/MediaCodec$BufferInfo;", "onOutputFormatChanged", "format", "Landroid/media/MediaFormat;", "plugin-mediaeditor_release"})
public final class d$b
  extends MediaCodec.Callback
{
  d$b(String paramString, long paramLong, com.tencent.mm.media.e.a parama) {}
  
  public final void onError(MediaCodec paramMediaCodec, MediaCodec.CodecException paramCodecException) {}
  
  public final void onInputBufferAvailable(MediaCodec paramMediaCodec, int paramInt)
  {
    AppMethodBeat.i(12857);
    for (;;)
    {
      try
      {
        ab.i(d.access$getTAG$cp(), "onInputBufferAvailable, index:" + paramInt + ", audioId:" + this.eSo);
        this.eSn.eRI = bo.yB();
        if (paramInt < 0)
        {
          AppMethodBeat.o(12857);
          return;
        }
        paramMediaCodec = this.eSn.Uy().getInputBuffer(paramInt);
        if (paramMediaCodec != null) {
          paramMediaCodec.clear();
        }
        com.tencent.mm.media.e.a locala = this.eSq;
        j.p(paramMediaCodec, "inputBuffer");
        if (locala.g(paramMediaCodec)) {
          break label322;
        }
        ab.i(d.access$getTAG$cp(), "read sample end");
        i = 1;
        long l = 0L;
        if (i == 0)
        {
          j = this.eSq.sampleSize;
          paramMediaCodec.position(0);
          l = this.eSq.getSampleTime();
          ab.i(d.access$getTAG$cp(), "sampleTime : " + l + ", sampleSize:" + j + ", audioId:" + this.eSo);
          if ((j < 0) || (l >= d.b(this.eSn) * 1000L))
          {
            ab.i(d.access$getTAG$cp(), "sawInputEOS, audioId:" + this.eSo);
            i = 1;
            paramMediaCodec = this.eSn.Uy();
            int k;
            if (i != 0)
            {
              k = 4;
              paramMediaCodec.queueInputBuffer(paramInt, 0, j, l, k);
              if (i != 0)
              {
                this.eSn.UA();
                AppMethodBeat.o(12857);
              }
            }
            else
            {
              k = 0;
              continue;
            }
          }
          continue;
        }
      }
      catch (Exception paramMediaCodec)
      {
        ab.printErrStackTrace(d.access$getTAG$cp(), (Throwable)paramMediaCodec, "", new Object[0]);
        AppMethodBeat.o(12857);
        return;
      }
      int j = 0;
      continue;
      label322:
      int i = 0;
    }
  }
  
  public final void onOutputBufferAvailable(MediaCodec paramMediaCodec, int paramInt, MediaCodec.BufferInfo paramBufferInfo)
  {
    AppMethodBeat.i(12856);
    j.q(paramBufferInfo, "bufferInfo");
    for (;;)
    {
      long l;
      try
      {
        ab.i(d.access$getTAG$cp(), "onOutputBufferAvailable, index:" + paramInt + ", bufferInfo:" + paramBufferInfo + " size:" + paramBufferInfo.size + this.eSo);
        if (paramInt < 0) {
          break;
        }
        l = paramBufferInfo.presentationTimeUs;
        ab.i(d.access$getTAG$cp(), "presentationTimeUs : ".concat(String.valueOf(l)));
        if ((l < this.eSp * 1000L) && ((paramBufferInfo.flags & 0x4) == 0))
        {
          this.eSn.Uy().releaseOutputBuffer(paramInt, false);
          ab.i(d.access$getTAG$cp(), "decoder pts: " + l + ", not reach start: " + this.eSp * 1000L + ", audioId:" + this.eSo);
          AppMethodBeat.o(12856);
          return;
        }
        if (paramBufferInfo.size == 0)
        {
          ab.i(d.access$getTAG$cp(), "decode zero size:" + this.eSo + ", zeroCount:" + d.a(this.eSn));
          paramMediaCodec = this.eSn;
          d.a(paramMediaCodec, d.a(paramMediaCodec) + 1);
          this.eSn.Uy().releaseOutputBuffer(paramInt, false);
          AppMethodBeat.o(12856);
          return;
        }
      }
      catch (Exception paramMediaCodec)
      {
        ab.printErrStackTrace(d.access$getTAG$cp(), (Throwable)paramMediaCodec, "", new Object[0]);
        AppMethodBeat.o(12856);
        return;
      }
      paramMediaCodec = this.eSn.Uy().getOutputBuffer(paramInt);
      this.eSn.e(paramMediaCodec, paramBufferInfo);
      this.eSn.Uy().releaseOutputBuffer(paramInt, false);
      if ((d.b(this.eSn) * 1000L != 1L) && (l >= d.b(this.eSn) * 1000L))
      {
        ab.e(d.access$getTAG$cp(), "exceed endTimeMs, audioId:" + this.eSo);
        this.eSn.UA();
        AppMethodBeat.o(12856);
        return;
      }
      if ((paramBufferInfo.flags & 0x4) != 0)
      {
        ab.i(d.access$getTAG$cp(), "receive eos! audioId:" + this.eSo);
        this.eSn.UA();
        AppMethodBeat.o(12856);
        return;
      }
    }
    this.eSn.Uy().releaseOutputBuffer(paramInt, false);
    AppMethodBeat.o(12856);
  }
  
  public final void onOutputFormatChanged(MediaCodec paramMediaCodec, MediaFormat paramMediaFormat)
  {
    AppMethodBeat.i(12858);
    this.eSn.mMediaFormat = paramMediaFormat;
    ab.i(d.access$getTAG$cp(), "onOutputFormatChanged:" + this.eSn.mMediaFormat + ", audioId:" + this.eSo);
    AppMethodBeat.o(12858);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes8.jar
 * Qualified Name:     com.tencent.mm.media.c.d.b
 * JD-Core Version:    0.7.0.1
 */