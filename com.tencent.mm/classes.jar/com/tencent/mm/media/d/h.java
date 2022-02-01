package com.tencent.mm.media.d;

import android.media.MediaCodec;
import android.media.MediaCodec.BufferInfo;
import android.media.MediaCodec.Callback;
import android.media.MediaCodec.CodecException;
import android.media.MediaFormat;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.sdk.platformtools.ad;
import com.tencent.mm.sdk.platformtools.bt;
import d.g.a.m;
import d.g.b.p;
import d.l;
import java.nio.ByteBuffer;

@l(gfx={1, 1, 16}, gfy={""}, gfz={"Lcom/tencent/mm/media/decoder/MediaCodecAACDecoderAsync;", "Lcom/tencent/mm/media/decoder/IAudioDecoder;", "mediaExtractorWrapper", "Lcom/tencent/mm/media/extractor/MediaExtractorWrapper;", "audioId", "", "startTimeMs", "", "endTimeMs", "(Lcom/tencent/mm/media/extractor/MediaExtractorWrapper;Ljava/lang/String;JJ)V", "frameDecodeCallback", "Lkotlin/Function2;", "", "Lkotlin/ParameterName;", "name", "pcmData", "pts", "", "frameDecodeEndCallback", "Lkotlin/Function0;", "(Lcom/tencent/mm/media/extractor/MediaExtractorWrapper;Ljava/lang/String;JJLkotlin/jvm/functions/Function2;Lkotlin/jvm/functions/Function0;)V", "aacCallback", "Landroid/media/MediaCodec$Callback;", "endTimeMsChanged", "sawInputEOS", "", "zeroCount", "", "startDecoder", "Companion", "plugin-mediaeditor_release"})
public final class h
  extends e
{
  private static final String TAG = "MicroMsg.MediaCodecAACDecoderAsync";
  public static final h.a hja;
  private int hiW;
  private long hiX;
  private boolean hiY;
  private MediaCodec.Callback hiZ;
  
  static
  {
    AppMethodBeat.i(93543);
    hja = new h.a((byte)0);
    TAG = "MicroMsg.MediaCodecAACDecoderAsync";
    AppMethodBeat.o(93543);
  }
  
  public h(com.tencent.mm.media.f.a parama, String paramString, long paramLong1, long paramLong2)
  {
    this(parama, paramString, paramLong1, paramLong2, null, null);
    AppMethodBeat.i(93542);
    AppMethodBeat.o(93542);
  }
  
  public h(com.tencent.mm.media.f.a parama, final String paramString, final long paramLong1, long paramLong2, m<? super byte[], ? super Long, d.z> paramm, d.g.a.a<d.z> parama1)
  {
    super(parama, paramString, paramLong1, paramLong2, paramm, parama1);
    AppMethodBeat.i(93541);
    this.hiX = paramLong2;
    this.hiZ = ((MediaCodec.Callback)new b(this, paramString, paramLong1, parama));
    parama = this.hir;
    if (parama != null)
    {
      parama.setCallback(this.hiZ);
      AppMethodBeat.o(93541);
      return;
    }
    AppMethodBeat.o(93541);
  }
  
  public final void startDecoder()
  {
    AppMethodBeat.i(93540);
    try
    {
      com.tencent.mm.compatible.deviceinfo.z localz = this.hir;
      if (localz != null) {
        localz.start();
      }
      ad.i(TAG, "startDecoder " + this.dce);
      AppMethodBeat.o(93540);
      return;
    }
    catch (Exception localException)
    {
      ad.printErrStackTrace(TAG, (Throwable)localException, "startDecoder error", new Object[0]);
      AppMethodBeat.o(93540);
    }
  }
  
  @l(gfx={1, 1, 16}, gfy={""}, gfz={"com/tencent/mm/media/decoder/MediaCodecAACDecoderAsync$aacCallback$1", "Landroid/media/MediaCodec$Callback;", "onError", "", "codec", "Landroid/media/MediaCodec;", "e", "Landroid/media/MediaCodec$CodecException;", "onInputBufferAvailable", "index", "", "onOutputBufferAvailable", "decoderOutputBufferIndex", "bufferInfo", "Landroid/media/MediaCodec$BufferInfo;", "onOutputFormatChanged", "format", "Landroid/media/MediaFormat;", "plugin-mediaeditor_release"})
  public static final class b
    extends MediaCodec.Callback
  {
    b(String paramString, long paramLong, com.tencent.mm.media.f.a parama) {}
    
    public final void onError(MediaCodec paramMediaCodec, MediaCodec.CodecException paramCodecException) {}
    
    public final void onInputBufferAvailable(MediaCodec paramMediaCodec, int paramInt)
    {
      AppMethodBeat.i(93538);
      for (;;)
      {
        try
        {
          ad.i(h.access$getTAG$cp(), "onInputBufferAvailable, index:" + paramInt + ", audioId:" + paramString);
          this.hjb.hiu = bt.HI();
          if (paramInt < 0)
          {
            AppMethodBeat.o(93538);
            return;
          }
          paramMediaCodec = this.hjb.hir;
          if (paramMediaCodec != null)
          {
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
        }
        catch (Exception paramMediaCodec)
        {
          ad.printErrStackTrace(h.access$getTAG$cp(), (Throwable)paramMediaCodec, "", new Object[0]);
          AppMethodBeat.o(93538);
          return;
        }
        paramMediaCodec = null;
      }
      h.a(this.hjb, false);
      if (!this.hje.j(paramMediaCodec))
      {
        ad.i(h.access$getTAG$cp(), "read sample end");
        h.a(this.hjb, true);
      }
      long l1 = 0L;
      int j;
      if (!h.c(this.hjb))
      {
        j = this.hje.sampleSize;
        paramMediaCodec.position(0);
        long l2 = this.hje.getSampleTime();
        ad.i(h.access$getTAG$cp(), "sampleTime : " + l2 + ", sampleSize:" + j + ", audioId:" + paramString);
        if (j >= 0)
        {
          i = j;
          l1 = l2;
          if (l2 < h.b(this.hjb) * 1000L) {}
        }
        else
        {
          h.a(this.hjb, true);
          ad.i(h.access$getTAG$cp(), "sawInputEOS, audioId:" + paramString);
          l1 = l2;
        }
      }
      for (int i = j;; i = 0)
      {
        paramMediaCodec = this.hjb.hir;
        if (paramMediaCodec != null)
        {
          if (h.c(this.hjb)) {}
          for (j = 4;; j = 0)
          {
            paramMediaCodec.a(paramInt, i, l1, j);
            AppMethodBeat.o(93538);
            return;
          }
        }
        AppMethodBeat.o(93538);
        return;
      }
    }
    
    public final void onOutputBufferAvailable(MediaCodec paramMediaCodec, int paramInt, MediaCodec.BufferInfo paramBufferInfo)
    {
      AppMethodBeat.i(93537);
      p.h(paramBufferInfo, "bufferInfo");
      long l;
      try
      {
        ad.i(h.access$getTAG$cp(), "onOutputBufferAvailable, index:" + paramInt + ", bufferInfo:" + paramBufferInfo + " size:" + paramBufferInfo.size + ", audioId:" + paramString);
        if (paramInt < 0) {
          break label478;
        }
        l = paramBufferInfo.presentationTimeUs;
        ad.i(h.access$getTAG$cp(), "presentationTimeUs : ".concat(String.valueOf(l)));
        if ((l < paramLong1 * 1000L) && ((paramBufferInfo.flags & 0x4) == 0))
        {
          paramMediaCodec = this.hjb.hir;
          if (paramMediaCodec != null) {
            paramMediaCodec.releaseOutputBuffer(paramInt, false);
          }
          ad.i(h.access$getTAG$cp(), "decoder pts: " + l + ", not reach start: " + paramLong1 * 1000L + ", audioId:" + paramString);
          AppMethodBeat.o(93537);
          return;
        }
        if (paramBufferInfo.size != 0) {
          break label305;
        }
        ad.i(h.access$getTAG$cp(), "decode zero size:" + paramString + ", zeroCount:" + h.a(this.hjb));
        paramMediaCodec = this.hjb;
        h.a(paramMediaCodec, h.a(paramMediaCodec) + 1);
        paramMediaCodec = this.hjb.hir;
        if (paramMediaCodec == null) {
          break label299;
        }
        paramMediaCodec.releaseOutputBuffer(paramInt, false);
        AppMethodBeat.o(93537);
        return;
      }
      catch (Exception paramMediaCodec)
      {
        ad.printErrStackTrace(h.access$getTAG$cp(), (Throwable)paramMediaCodec, "", new Object[0]);
      }
      AppMethodBeat.o(93537);
      return;
      label299:
      AppMethodBeat.o(93537);
      return;
      label305:
      paramMediaCodec = this.hjb.hir;
      if (paramMediaCodec != null) {}
      for (paramMediaCodec = paramMediaCodec.getOutputBuffer(paramInt);; paramMediaCodec = null)
      {
        this.hjb.e(paramMediaCodec, paramBufferInfo);
        paramMediaCodec = this.hjb.hir;
        if (paramMediaCodec != null) {
          paramMediaCodec.releaseOutputBuffer(paramInt, false);
        }
        if ((h.b(this.hjb) * 1000L != 1L) && (l >= h.b(this.hjb) * 1000L))
        {
          ad.e(h.access$getTAG$cp(), "exceed endTimeMs, audioId:" + paramString);
          this.hjb.atm();
          AppMethodBeat.o(93537);
          return;
        }
        if (((paramBufferInfo.flags & 0x4) == 0) && (!h.c(this.hjb))) {
          break;
        }
        ad.i(h.access$getTAG$cp(), "receive eos! audioId:" + paramString);
        this.hjb.atm();
        AppMethodBeat.o(93537);
        return;
        label478:
        paramMediaCodec = this.hjb.hir;
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
      this.hjb.hhq = paramMediaFormat;
      paramMediaCodec = this.hjb.hhq;
      if ((paramMediaCodec != null) && (paramMediaCodec.containsKey("sample-rate") == true))
      {
        paramMediaCodec = this.hjb.hhq;
        if (paramMediaCodec == null) {
          break label133;
        }
      }
      label133:
      for (int i = paramMediaCodec.getInteger("sample-rate");; i = 0)
      {
        if (i > 0) {
          this.hjb.hit = i;
        }
        ad.i(h.access$getTAG$cp(), "onOutputFormatChanged:" + this.hjb.hhq + ", aacSampleRate:" + this.hjb.hit + ", audioId:" + paramString);
        AppMethodBeat.o(93539);
        return;
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.media.d.h
 * JD-Core Version:    0.7.0.1
 */