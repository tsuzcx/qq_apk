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
import kotlin.g.a.m;
import kotlin.g.b.p;
import kotlin.g.b.q;
import kotlin.l;
import kotlin.x;

@l(iBK={1, 1, 16}, iBL={""}, iBM={"Lcom/tencent/mm/media/decoder/MediaCodecAACDecoderAsync;", "Lcom/tencent/mm/media/decoder/IAudioDecoder;", "mediaExtractorWrapper", "Lcom/tencent/mm/media/extractor/MediaExtractorWrapper;", "audioId", "", "startTimeMs", "", "endTimeMs", "(Lcom/tencent/mm/media/extractor/MediaExtractorWrapper;Ljava/lang/String;JJ)V", "frameDecodeCallback", "Lkotlin/Function2;", "", "Lkotlin/ParameterName;", "name", "pcmData", "pts", "", "frameDecodeEndCallback", "Lkotlin/Function0;", "(Lcom/tencent/mm/media/extractor/MediaExtractorWrapper;Ljava/lang/String;JJLkotlin/jvm/functions/Function2;Lkotlin/jvm/functions/Function0;)V", "TAG", "aacCallback", "Landroid/media/MediaCodec$Callback;", "endTimeMsChanged", "sawInputEOS", "", "stopDecoderTask", "zeroCount", "", "delayStopDecoder", "startDecoder", "Companion", "plugin-mediaeditor_release"})
public final class h
  extends e
{
  public static final a kTy;
  private final String TAG;
  private int kTt;
  private long kTu;
  private boolean kTv;
  private MediaCodec.Callback kTw;
  private final kotlin.g.a.a<x> kTx;
  
  static
  {
    AppMethodBeat.i(93543);
    kTy = new a((byte)0);
    AppMethodBeat.o(93543);
  }
  
  public h(com.tencent.mm.media.f.a parama, String paramString, long paramLong1, long paramLong2)
  {
    this(parama, paramString, paramLong1, paramLong2, null, null);
    AppMethodBeat.i(93542);
    AppMethodBeat.o(93542);
  }
  
  public h(com.tencent.mm.media.f.a parama, final String paramString, final long paramLong1, long paramLong2, m<? super byte[], ? super Long, x> paramm, kotlin.g.a.a<x> parama1)
  {
    super(parama, paramString, paramLong1, paramLong2, paramm, parama1);
    AppMethodBeat.i(93541);
    this.TAG = "MicroMsg.MediaCodecAACDecoderAsync@".concat(String.valueOf(paramString));
    this.kTu = paramLong2;
    this.kTw = ((MediaCodec.Callback)new b(this, paramString, paramLong1, parama));
    parama = this.kSN;
    if (parama != null) {
      parama.a(this.kTw);
    }
    this.kTx = ((kotlin.g.a.a)new c(this));
    AppMethodBeat.o(93541);
  }
  
  public final void startDecoder()
  {
    AppMethodBeat.i(93540);
    try
    {
      aa localaa = this.kSN;
      if (localaa != null) {
        localaa.start();
      }
      Log.i(this.TAG, "startDecoder " + adU());
      AppMethodBeat.o(93540);
      return;
    }
    catch (Exception localException)
    {
      Log.printErrStackTrace(this.TAG, (Throwable)localException, "startDecoder error", new Object[0]);
      AppMethodBeat.o(93540);
    }
  }
  
  @l(iBK={1, 1, 16}, iBL={""}, iBM={"Lcom/tencent/mm/media/decoder/MediaCodecAACDecoderAsync$Companion;", "", "()V", "DecodePadingMs", "", "ZeroCountUpperBound", "plugin-mediaeditor_release"})
  public static final class a {}
  
  @l(iBK={1, 1, 16}, iBL={""}, iBM={"com/tencent/mm/media/decoder/MediaCodecAACDecoderAsync$aacCallback$1", "Landroid/media/MediaCodec$Callback;", "onError", "", "codec", "Landroid/media/MediaCodec;", "e", "Landroid/media/MediaCodec$CodecException;", "onInputBufferAvailable", "index", "", "onOutputBufferAvailable", "decoderOutputBufferIndex", "bufferInfo", "Landroid/media/MediaCodec$BufferInfo;", "onOutputFormatChanged", "format", "Landroid/media/MediaFormat;", "plugin-mediaeditor_release"})
  public static final class b
    extends MediaCodec.Callback
  {
    b(String paramString, long paramLong, com.tencent.mm.media.f.a parama) {}
    
    public final void onError(MediaCodec paramMediaCodec, MediaCodec.CodecException paramCodecException)
    {
      AppMethodBeat.i(262444);
      p.k(paramMediaCodec, "codec");
      p.k(paramCodecException, "e");
      AppMethodBeat.o(262444);
    }
    
    public final void onInputBufferAvailable(MediaCodec paramMediaCodec, int paramInt)
    {
      AppMethodBeat.i(93538);
      p.k(paramMediaCodec, "codec");
      for (;;)
      {
        try
        {
          Log.i(h.a(this.kTz), "onInputBufferAvailable, index:" + paramInt + ", audioId:" + paramString);
          this.kTz.kSQ = Util.currentTicks();
          if (paramInt < 0)
          {
            AppMethodBeat.o(93538);
            return;
          }
          paramMediaCodec = this.kTz.kSN;
          if (paramMediaCodec == null) {
            break label133;
          }
          paramMediaCodec = paramMediaCodec.getInputBuffer(paramInt);
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
          Log.printErrStackTrace(h.a(this.kTz), (Throwable)paramMediaCodec, "", new Object[0]);
        }
        AppMethodBeat.o(93538);
        return;
        label133:
        paramMediaCodec = null;
      }
      h.a(this.kTz, false);
      if (!com.tencent.mm.media.f.a.a(this.kTC, paramMediaCodec))
      {
        Log.i(h.a(this.kTz), "read sample end");
        h.a(this.kTz, true);
      }
      long l1 = 0L;
      int j;
      if (!h.d(this.kTz))
      {
        j = this.kTC.sampleSize;
        paramMediaCodec.position(0);
        long l2 = this.kTC.getSampleTime();
        Log.i(h.a(this.kTz), "sampleTime : " + l2 + ", sampleSize:" + j + ", audioId:" + paramString);
        if (j >= 0)
        {
          i = j;
          l1 = l2;
          if (l2 < h.c(this.kTz) * 1000L) {}
        }
        else
        {
          h.a(this.kTz, true);
          Log.i(h.a(this.kTz), "sawInputEOS, audioId:" + paramString);
          l1 = l2;
        }
      }
      for (int i = j;; i = 0)
      {
        paramMediaCodec = this.kTz.kSN;
        if (paramMediaCodec != null) {
          if (!h.d(this.kTz)) {
            break label394;
          }
        }
        label394:
        for (j = 4;; j = 0)
        {
          paramMediaCodec.a(paramInt, i, l1, j);
          if (!h.d(this.kTz)) {
            break;
          }
          h.e(this.kTz);
          AppMethodBeat.o(93538);
          return;
        }
      }
    }
    
    public final void onOutputBufferAvailable(MediaCodec paramMediaCodec, int paramInt, MediaCodec.BufferInfo paramBufferInfo)
    {
      AppMethodBeat.i(93537);
      p.k(paramMediaCodec, "codec");
      p.k(paramBufferInfo, "bufferInfo");
      long l;
      try
      {
        Log.i(h.a(this.kTz), "onOutputBufferAvailable, index:" + paramInt + ", bufferInfo:" + paramBufferInfo + " size:" + paramBufferInfo.size + ", audioId:" + paramString);
        if (paramInt < 0) {
          break label503;
        }
        l = paramBufferInfo.presentationTimeUs;
        Log.i(h.a(this.kTz), "presentationTimeUs : ".concat(String.valueOf(l)));
        if ((l < paramLong1 * 1000L) && ((paramBufferInfo.flags & 0x4) == 0))
        {
          paramMediaCodec = this.kTz.kSN;
          if (paramMediaCodec != null) {
            paramMediaCodec.releaseOutputBuffer(paramInt, false);
          }
          Log.i(h.a(this.kTz), "decoder pts: " + l + ", not reach start: " + paramLong1 * 1000L + ", audioId:" + paramString);
          AppMethodBeat.o(93537);
          return;
        }
        if (paramBufferInfo.size != 0) {
          break label331;
        }
        Log.i(h.a(this.kTz), "decode zero size:" + paramString + ", zeroCount:" + h.b(this.kTz));
        paramMediaCodec = this.kTz;
        h.a(paramMediaCodec, h.b(paramMediaCodec) + 1);
        paramMediaCodec = this.kTz.kSN;
        if (paramMediaCodec == null) {
          break label325;
        }
        paramMediaCodec.releaseOutputBuffer(paramInt, false);
        AppMethodBeat.o(93537);
        return;
      }
      catch (Exception paramMediaCodec)
      {
        Log.printErrStackTrace(h.a(this.kTz), (Throwable)paramMediaCodec, "", new Object[0]);
      }
      AppMethodBeat.o(93537);
      return;
      label325:
      AppMethodBeat.o(93537);
      return;
      label331:
      paramMediaCodec = this.kTz.kSN;
      if (paramMediaCodec != null) {}
      for (paramMediaCodec = paramMediaCodec.getOutputBuffer(paramInt);; paramMediaCodec = null)
      {
        this.kTz.e(paramMediaCodec, paramBufferInfo);
        paramMediaCodec = this.kTz.kSN;
        if (paramMediaCodec != null) {
          paramMediaCodec.releaseOutputBuffer(paramInt, false);
        }
        if ((h.c(this.kTz) * 1000L != 1L) && (l >= h.c(this.kTz) * 1000L))
        {
          Log.e(h.a(this.kTz), "exceed endTimeMs, audioId:" + paramString);
          this.kTz.aUn();
          AppMethodBeat.o(93537);
          return;
        }
        if ((paramBufferInfo.flags & 0x4) == 0) {
          break;
        }
        Log.i(h.a(this.kTz), "receive eos! audioId:" + paramString);
        this.kTz.aUn();
        AppMethodBeat.o(93537);
        return;
        label503:
        paramMediaCodec = this.kTz.kSN;
        if (paramMediaCodec != null)
        {
          paramMediaCodec.releaseOutputBuffer(paramInt, false);
          AppMethodBeat.o(93537);
          return;
        }
        AppMethodBeat.o(93537);
        return;
      }
    }
    
    public final void onOutputFormatChanged(MediaCodec paramMediaCodec, MediaFormat paramMediaFormat)
    {
      AppMethodBeat.i(93539);
      p.k(paramMediaCodec, "codec");
      p.k(paramMediaFormat, "format");
      this.kTz.kRH = paramMediaFormat;
      paramMediaCodec = this.kTz.kRH;
      if ((paramMediaCodec != null) && (paramMediaCodec.containsKey("sample-rate") == true))
      {
        paramMediaCodec = this.kTz.kRH;
        if (paramMediaCodec == null) {
          break label150;
        }
      }
      label150:
      for (int i = paramMediaCodec.getInteger("sample-rate");; i = 0)
      {
        if (i > 0) {
          this.kTz.kSP = i;
        }
        Log.i(h.a(this.kTz), "onOutputFormatChanged:" + this.kTz.kRH + ", aacSampleRate:" + this.kTz.kSP + ", audioId:" + paramString);
        AppMethodBeat.o(93539);
        return;
      }
    }
  }
  
  @l(iBK={1, 1, 16}, iBL={""}, iBM={"<anonymous>", "", "invoke"})
  static final class c
    extends q
    implements kotlin.g.a.a<x>
  {
    c(h paramh)
    {
      super();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.media.d.h
 * JD-Core Version:    0.7.0.1
 */