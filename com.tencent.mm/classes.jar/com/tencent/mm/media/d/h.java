package com.tencent.mm.media.d;

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
import kotlin.Metadata;
import kotlin.ah;
import kotlin.g.a.m;
import kotlin.g.b.s;
import kotlin.g.b.u;

@Metadata(d1={""}, d2={"Lcom/tencent/mm/media/decoder/MediaCodecAACDecoderAsync;", "Lcom/tencent/mm/media/decoder/IAudioDecoder;", "mediaExtractorWrapper", "Lcom/tencent/mm/media/extractor/MediaExtractorWrapper;", "audioId", "", "startTimeMs", "", "endTimeMs", "(Lcom/tencent/mm/media/extractor/MediaExtractorWrapper;Ljava/lang/String;JJ)V", "frameDecodeCallback", "Lkotlin/Function2;", "", "Lkotlin/ParameterName;", "name", "pcmData", "pts", "", "frameDecodeEndCallback", "Lkotlin/Function0;", "(Lcom/tencent/mm/media/extractor/MediaExtractorWrapper;Ljava/lang/String;JJLkotlin/jvm/functions/Function2;Lkotlin/jvm/functions/Function0;)V", "TAG", "aacCallback", "Landroid/media/MediaCodec$Callback;", "endTimeMsChanged", "sawInputEOS", "", "stopDecoderTask", "zeroCount", "", "delayStopDecoder", "startDecoder", "Companion", "plugin-mediaeditor_release"}, k=1, mv={1, 5, 1}, xi=48)
public final class h
  extends e
{
  public static final h.a nzb;
  private final String TAG;
  private int nzc;
  private long nzd;
  private boolean nze;
  private MediaCodec.Callback nzf;
  private final kotlin.g.a.a<ah> nzg;
  
  static
  {
    AppMethodBeat.i(93543);
    nzb = new h.a((byte)0);
    AppMethodBeat.o(93543);
  }
  
  public h(com.tencent.mm.media.f.a parama, String paramString, long paramLong1, long paramLong2)
  {
    this(parama, paramString, paramLong1, paramLong2, null, null);
    AppMethodBeat.i(93542);
    AppMethodBeat.o(93542);
  }
  
  public h(com.tencent.mm.media.f.a parama, final String paramString, final long paramLong1, long paramLong2, m<? super byte[], ? super Long, ah> paramm, kotlin.g.a.a<ah> parama1)
  {
    super(parama, paramString, paramLong1, paramLong2, paramm, parama1);
    AppMethodBeat.i(93541);
    this.TAG = s.X("MicroMsg.MediaCodecAACDecoderAsync@", paramString);
    this.nzd = paramLong2;
    this.nzf = ((MediaCodec.Callback)new b(this, paramString, paramLong1, parama));
    parama = this.nyz;
    if (parama != null) {
      parama.setCallback(this.nzf);
    }
    this.nzg = ((kotlin.g.a.a)new c(this));
    AppMethodBeat.o(93541);
  }
  
  private static final void T(kotlin.g.a.a parama)
  {
    AppMethodBeat.i(236906);
    s.u(parama, "$tmp0");
    parama.invoke();
    AppMethodBeat.o(236906);
  }
  
  private static final void U(kotlin.g.a.a parama)
  {
    AppMethodBeat.i(236907);
    s.u(parama, "$tmp0");
    parama.invoke();
    AppMethodBeat.o(236907);
  }
  
  public final void startDecoder()
  {
    AppMethodBeat.i(93540);
    try
    {
      aa localaa = this.nyz;
      if (localaa != null) {
        localaa.start();
      }
      Log.i(this.TAG, s.X("startDecoder ", aFS()));
      AppMethodBeat.o(93540);
      return;
    }
    catch (Exception localException)
    {
      Log.printErrStackTrace(this.TAG, (Throwable)localException, "startDecoder error", new Object[0]);
      AppMethodBeat.o(93540);
    }
  }
  
  @Metadata(d1={""}, d2={"com/tencent/mm/media/decoder/MediaCodecAACDecoderAsync$aacCallback$1", "Landroid/media/MediaCodec$Callback;", "onError", "", "codec", "Landroid/media/MediaCodec;", "e", "Landroid/media/MediaCodec$CodecException;", "onInputBufferAvailable", "index", "", "onOutputBufferAvailable", "decoderOutputBufferIndex", "bufferInfo", "Landroid/media/MediaCodec$BufferInfo;", "onOutputFormatChanged", "format", "Landroid/media/MediaFormat;", "plugin-mediaeditor_release"}, k=1, mv={1, 5, 1}, xi=48)
  public static final class b
    extends MediaCodec.Callback
  {
    b(h paramh, String paramString, long paramLong, com.tencent.mm.media.f.a parama) {}
    
    public final void onError(MediaCodec paramMediaCodec, MediaCodec.CodecException paramCodecException)
    {
      AppMethodBeat.i(236924);
      s.u(paramMediaCodec, "codec");
      s.u(paramCodecException, "e");
      AppMethodBeat.o(236924);
    }
    
    public final void onInputBufferAvailable(MediaCodec paramMediaCodec, int paramInt)
    {
      AppMethodBeat.i(93538);
      s.u(paramMediaCodec, "codec");
      for (;;)
      {
        try
        {
          Log.i(h.a(this.nzh), "onInputBufferAvailable, index:" + paramInt + ", audioId:" + paramString);
          this.nzh.nyC = Util.currentTicks();
          if (paramInt < 0)
          {
            AppMethodBeat.o(93538);
            return;
          }
          paramMediaCodec = this.nzh.nyz;
          if (paramMediaCodec != null) {
            break label129;
          }
          paramMediaCodec = null;
          if (paramMediaCodec != null) {
            paramMediaCodec.clear();
          }
          if (paramMediaCodec != null) {
            break;
          }
          AppMethodBeat.o(93538);
          return;
        }
        catch (Exception paramMediaCodec)
        {
          Log.printErrStackTrace(h.a(this.nzh), (Throwable)paramMediaCodec, "", new Object[0]);
        }
        AppMethodBeat.o(93538);
        return;
        label129:
        paramMediaCodec = paramMediaCodec.getInputBuffer(paramInt);
      }
      h.a(this.nzh, false);
      if (!com.tencent.mm.media.f.a.a(this.nzk, paramMediaCodec))
      {
        Log.i(h.a(this.nzh), "read sample end");
        h.a(this.nzh, true);
      }
      long l1 = 0L;
      int j;
      if (!h.d(this.nzh))
      {
        j = this.nzk.sampleSize;
        paramMediaCodec.position(0);
        long l2 = this.nzk.getSampleTime();
        Log.i(h.a(this.nzh), "sampleTime : " + l2 + ", sampleSize:" + j + ", audioId:" + paramString);
        if (j >= 0)
        {
          i = j;
          l1 = l2;
          if (l2 < h.c(this.nzh) * 1000L) {}
        }
        else
        {
          h.a(this.nzh, true);
          Log.i(h.a(this.nzh), s.X("sawInputEOS, audioId:", paramString));
          l1 = l2;
        }
      }
      for (int i = j;; i = 0)
      {
        paramMediaCodec = this.nzh.nyz;
        if (paramMediaCodec != null) {
          if (!h.d(this.nzh)) {
            break label384;
          }
        }
        label384:
        for (j = 4;; j = 0)
        {
          paramMediaCodec.a(paramInt, i, l1, j);
          if (!h.d(this.nzh)) {
            break;
          }
          h.e(this.nzh);
          AppMethodBeat.o(93538);
          return;
        }
      }
    }
    
    public final void onOutputBufferAvailable(MediaCodec paramMediaCodec, int paramInt, MediaCodec.BufferInfo paramBufferInfo)
    {
      AppMethodBeat.i(93537);
      s.u(paramMediaCodec, "codec");
      s.u(paramBufferInfo, "bufferInfo");
      do
      {
        for (;;)
        {
          long l;
          try
          {
            Log.i(h.a(this.nzh), "onOutputBufferAvailable, index:" + paramInt + ", bufferInfo:" + paramBufferInfo + " size:" + paramBufferInfo.size + ", audioId:" + paramString);
            if (paramInt < 0) {
              break;
            }
            l = paramBufferInfo.presentationTimeUs;
            Log.i(h.a(this.nzh), s.X("presentationTimeUs : ", Long.valueOf(l)));
            if ((l < paramLong1 * 1000L) && ((paramBufferInfo.flags & 0x4) == 0))
            {
              paramMediaCodec = this.nzh.nyz;
              if (paramMediaCodec != null) {
                paramMediaCodec.releaseOutputBuffer(paramInt, false);
              }
              Log.i(h.a(this.nzh), "decoder pts: " + l + ", not reach start: " + paramLong1 * 1000L + ", audioId:" + paramString);
              AppMethodBeat.o(93537);
              return;
            }
            if (paramBufferInfo.size == 0)
            {
              Log.i(h.a(this.nzh), "decode zero size:" + paramString + ", zeroCount:" + h.b(this.nzh));
              paramMediaCodec = this.nzh;
              h.a(paramMediaCodec, h.b(paramMediaCodec) + 1);
              paramMediaCodec = this.nzh.nyz;
              if (paramMediaCodec != null) {
                paramMediaCodec.releaseOutputBuffer(paramInt, false);
              }
              AppMethodBeat.o(93537);
              return;
            }
          }
          catch (Exception paramMediaCodec)
          {
            Log.printErrStackTrace(h.a(this.nzh), (Throwable)paramMediaCodec, "", new Object[0]);
            AppMethodBeat.o(93537);
            return;
          }
          paramMediaCodec = this.nzh.nyz;
          if (paramMediaCodec == null) {}
          for (paramMediaCodec = null;; paramMediaCodec = paramMediaCodec.getOutputBuffer(paramInt))
          {
            this.nzh.e(paramMediaCodec, paramBufferInfo);
            paramMediaCodec = this.nzh.nyz;
            if (paramMediaCodec != null) {
              paramMediaCodec.releaseOutputBuffer(paramInt, false);
            }
            if ((h.c(this.nzh) * 1000L == 1L) || (l < h.c(this.nzh) * 1000L)) {
              break;
            }
            Log.e(h.a(this.nzh), s.X("exceed endTimeMs, audioId:", paramString));
            this.nzh.boQ();
            AppMethodBeat.o(93537);
            return;
          }
          if ((paramBufferInfo.flags & 0x4) != 0)
          {
            Log.i(h.a(this.nzh), s.X("receive eos! audioId:", paramString));
            this.nzh.boQ();
            AppMethodBeat.o(93537);
            return;
          }
        }
        paramMediaCodec = this.nzh.nyz;
      } while (paramMediaCodec == null);
      paramMediaCodec.releaseOutputBuffer(paramInt, false);
      AppMethodBeat.o(93537);
    }
    
    public final void onOutputFormatChanged(MediaCodec paramMediaCodec, MediaFormat paramMediaFormat)
    {
      int i = 1;
      int j = 0;
      AppMethodBeat.i(93539);
      s.u(paramMediaCodec, "codec");
      s.u(paramMediaFormat, "format");
      this.nzh.nxp = paramMediaFormat;
      paramMediaCodec = this.nzh.nxp;
      if ((paramMediaCodec != null) && (paramMediaCodec.containsKey("sample-rate") == true)) {
        if (i != 0)
        {
          paramMediaCodec = this.nzh.nxp;
          if (paramMediaCodec != null) {
            break label159;
          }
        }
      }
      label159:
      for (i = j;; i = paramMediaCodec.getInteger("sample-rate"))
      {
        if (i > 0) {
          this.nzh.nyB = i;
        }
        Log.i(h.a(this.nzh), "onOutputFormatChanged:" + this.nzh.nxp + ", aacSampleRate:" + this.nzh.nyB + ", audioId:" + paramString);
        AppMethodBeat.o(93539);
        return;
        i = 0;
        break;
      }
    }
  }
  
  @Metadata(d1={""}, d2={"<anonymous>", ""}, k=3, mv={1, 5, 1}, xi=48)
  static final class c
    extends u
    implements kotlin.g.a.a<ah>
  {
    c(h paramh)
    {
      super();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes9.jar
 * Qualified Name:     com.tencent.mm.media.d.h
 * JD-Core Version:    0.7.0.1
 */