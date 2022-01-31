package com.tencent.mm.plugin.emojicapture.model.b;

import a.f.a.a;
import a.f.a.b;
import a.y;
import android.media.MediaCodec;
import android.media.MediaCodec.BufferInfo;
import android.media.MediaCodec.Callback;
import android.media.MediaCodec.CodecException;
import android.media.MediaExtractor;
import android.media.MediaFormat;
import android.os.HandlerThread;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.sdk.platformtools.ab;
import java.nio.ByteBuffer;

@a.l(eaO={1, 1, 13}, eaP={""}, eaQ={"com/tencent/mm/plugin/emojicapture/model/mix/EmojiMixVideoDecoderAsync$codecCallback$1", "Landroid/media/MediaCodec$Callback;", "onError", "", "codec", "Landroid/media/MediaCodec;", "e", "Landroid/media/MediaCodec$CodecException;", "onInputBufferAvailable", "index", "", "onOutputBufferAvailable", "info", "Landroid/media/MediaCodec$BufferInfo;", "onOutputFormatChanged", "format", "Landroid/media/MediaFormat;", "plugin-emojicapture_release"})
public final class j$a
  extends MediaCodec.Callback
{
  public final void onError(MediaCodec paramMediaCodec, MediaCodec.CodecException paramCodecException)
  {
    AppMethodBeat.i(2692);
    a.f.b.j.q(paramMediaCodec, "codec");
    a.f.b.j.q(paramCodecException, "e");
    ab.printErrStackTrace(this.luS.TAG, (Throwable)paramCodecException, "onError", new Object[0]);
    AppMethodBeat.o(2692);
  }
  
  public final void onInputBufferAvailable(MediaCodec paramMediaCodec, int paramInt)
  {
    AppMethodBeat.i(2690);
    a.f.b.j.q(paramMediaCodec, "codec");
    ab.i(this.luS.TAG, "onInputBufferAvailable ".concat(String.valueOf(paramInt)));
    int j;
    long l;
    if ((paramInt >= 0) && (!this.luS.luP))
    {
      paramMediaCodec = this.luS.eRD;
      if (paramMediaCodec != null) {}
      for (paramMediaCodec = paramMediaCodec.getInputBuffer(paramInt); paramMediaCodec == null; paramMediaCodec = null)
      {
        ab.w(this.luS.TAG, "inputBuffer is null");
        AppMethodBeat.o(2690);
        return;
      }
      paramMediaCodec.clear();
      j = this.luS.cfO.readSampleData(paramMediaCodec, 0);
      this.luS.cfO.advance();
      paramMediaCodec.position(0);
      l = this.luS.cfO.getSampleTime();
      ab.i(this.luS.TAG, "sampleTime: " + l + ", sampleSize: " + j);
      if (l > this.luS.luQ) {
        this.luS.luQ = l;
      }
      if ((j >= 0) && (l >= 0L)) {
        break label288;
      }
      ab.i(this.luS.TAG, "read sample end");
    }
    label288:
    for (boolean bool = true;; bool = false)
    {
      this.luS.luP = bool;
      paramMediaCodec = this.luS.eRD;
      if (paramMediaCodec != null)
      {
        if (this.luS.luP) {}
        for (int i = 4;; i = 0)
        {
          paramMediaCodec.queueInputBuffer(paramInt, 0, j, l, i);
          AppMethodBeat.o(2690);
          return;
        }
      }
      AppMethodBeat.o(2690);
      return;
    }
  }
  
  public final void onOutputBufferAvailable(MediaCodec arg1, int paramInt, MediaCodec.BufferInfo paramBufferInfo)
  {
    AppMethodBeat.i(2689);
    a.f.b.j.q(???, "codec");
    a.f.b.j.q(paramBufferInfo, "info");
    ab.i(this.luS.TAG, "onOutputBufferAvailable " + paramInt + ", flags " + paramBufferInfo.flags);
    if ((paramInt >= 0) && (paramBufferInfo.size != 0))
    {
      long l1 = paramBufferInfo.presentationTimeUs;
      ab.i(this.luS.TAG, "presentationTimeUs: " + l1 + ", inputSampleTime: " + this.luS.luQ);
      ??? = this.luS.eRD;
      if (??? != null) {
        ???.releaseOutputBuffer(paramInt, true);
      }
      Object localObject = this.luS;
      ab.i(((j)localObject).TAG, "processDecodeBuffer pts: " + paramBufferInfo.presentationTimeUs + ", size: " + paramBufferInfo.size);
      ??? = ((l)localObject).lvi;
      if (??? != null) {
        ???.S(Long.valueOf(paramBufferInfo.presentationTimeUs * 1000L));
      }
      long l2;
      label330:
      do
      {
        synchronized (((j)localObject).luN)
        {
          try
          {
            ((j)localObject).luN.wait(50L);
            localObject = y.BMg;
            if (this.luS.luP)
            {
              l2 = this.luS.luQ;
              if (0L > l1)
              {
                ab.i(this.luS.TAG, "receive eos!");
                ab.i(this.luS.TAG, "sendDecoderEos");
                ??? = this.luS;
                ab.i(???.TAG, "release");
              }
            }
            try
            {
              ???.eSt.quit();
              paramBufferInfo = ???.eRD;
              if (paramBufferInfo != null) {
                paramBufferInfo.stop();
              }
              ??? = ???.eRD;
              if (??? != null) {
                ???.release();
              }
            }
            catch (Exception ???)
            {
              break label330;
            }
            ??? = this.luS.lvj;
            if (??? == null) {
              break;
            }
            ???.invoke();
            AppMethodBeat.o(2689);
            return;
          }
          catch (Exception localException)
          {
            for (;;)
            {
              ab.printErrStackTrace(((j)localObject).TAG, (Throwable)localException, "", new Object[0]);
            }
          }
        }
      } while ((l2 <= l1) || ((paramBufferInfo.flags & 0x4) != 0));
    }
    else
    {
      do
      {
        AppMethodBeat.o(2689);
        return;
        AppMethodBeat.o(2689);
        return;
        ??? = this.luS.eRD;
      } while (??? == null);
      ???.releaseOutputBuffer(paramInt, false);
      AppMethodBeat.o(2689);
      return;
    }
  }
  
  public final void onOutputFormatChanged(MediaCodec paramMediaCodec, MediaFormat paramMediaFormat)
  {
    AppMethodBeat.i(2691);
    a.f.b.j.q(paramMediaCodec, "codec");
    a.f.b.j.q(paramMediaFormat, "format");
    ab.i(this.luS.TAG, "onOutputFormatChanged ".concat(String.valueOf(paramMediaFormat)));
    this.luS.mediaFormat = paramMediaFormat;
    AppMethodBeat.o(2691);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.plugin.emojicapture.model.b.j.a
 * JD-Core Version:    0.7.0.1
 */