package com.tencent.mm.media.c;

import android.media.MediaCodec;
import android.media.MediaCodec.BufferInfo;
import android.media.MediaCodec.Callback;
import android.media.MediaCodec.CodecException;
import android.media.MediaFormat;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.compatible.deviceinfo.z;
import com.tencent.mm.sdk.platformtools.ac;
import com.tencent.mm.sdk.platformtools.bs;
import d.g.a.m;
import d.g.b.k;
import d.l;
import d.y;
import java.nio.ByteBuffer;

@l(fNY={1, 1, 16}, fNZ={""}, fOa={"Lcom/tencent/mm/media/decoder/MediaCodecAACDecoderAsync;", "Lcom/tencent/mm/media/decoder/IAudioDecoder;", "mediaExtractorWrapper", "Lcom/tencent/mm/media/extractor/MediaExtractorWrapper;", "audioId", "", "startTimeMs", "", "endTimeMs", "(Lcom/tencent/mm/media/extractor/MediaExtractorWrapper;Ljava/lang/String;JJ)V", "frameDecodeCallback", "Lkotlin/Function2;", "", "Lkotlin/ParameterName;", "name", "pcmData", "pts", "", "frameDecodeEndCallback", "Lkotlin/Function0;", "(Lcom/tencent/mm/media/extractor/MediaExtractorWrapper;Ljava/lang/String;JJLkotlin/jvm/functions/Function2;Lkotlin/jvm/functions/Function0;)V", "aacCallback", "Landroid/media/MediaCodec$Callback;", "endTimeMsChanged", "sawInputEOS", "", "zeroCount", "", "startDecoder", "Companion", "plugin-mediaeditor_release"})
public final class h
  extends e
{
  private static final String TAG = "MicroMsg.MediaCodecAACDecoderAsync";
  public static final h.a gPa;
  private int gOW;
  private long gOX;
  private boolean gOY;
  private MediaCodec.Callback gOZ;
  
  static
  {
    AppMethodBeat.i(93543);
    gPa = new h.a((byte)0);
    TAG = "MicroMsg.MediaCodecAACDecoderAsync";
    AppMethodBeat.o(93543);
  }
  
  public h(com.tencent.mm.media.e.a parama, String paramString, long paramLong1, long paramLong2)
  {
    this(parama, paramString, paramLong1, paramLong2, null, null);
    AppMethodBeat.i(93542);
    AppMethodBeat.o(93542);
  }
  
  public h(com.tencent.mm.media.e.a parama, final String paramString, final long paramLong1, long paramLong2, m<? super byte[], ? super Long, y> paramm, d.g.a.a<y> parama1)
  {
    super(parama, paramString, paramLong1, paramLong2, paramm, parama1);
    AppMethodBeat.i(93541);
    this.gOX = paramLong2;
    this.gOZ = ((MediaCodec.Callback)new b(this, paramString, paramLong1, parama));
    parama = this.gOr;
    if (parama != null)
    {
      parama.setCallback(this.gOZ);
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
      z localz = this.gOr;
      if (localz != null) {
        localz.start();
      }
      ac.i(TAG, "startDecoder " + this.cQO);
      AppMethodBeat.o(93540);
      return;
    }
    catch (Exception localException)
    {
      ac.printErrStackTrace(TAG, (Throwable)localException, "startDecoder error", new Object[0]);
      AppMethodBeat.o(93540);
    }
  }
  
  @l(fNY={1, 1, 16}, fNZ={""}, fOa={"com/tencent/mm/media/decoder/MediaCodecAACDecoderAsync$aacCallback$1", "Landroid/media/MediaCodec$Callback;", "onError", "", "codec", "Landroid/media/MediaCodec;", "e", "Landroid/media/MediaCodec$CodecException;", "onInputBufferAvailable", "index", "", "onOutputBufferAvailable", "decoderOutputBufferIndex", "bufferInfo", "Landroid/media/MediaCodec$BufferInfo;", "onOutputFormatChanged", "format", "Landroid/media/MediaFormat;", "plugin-mediaeditor_release"})
  public static final class b
    extends MediaCodec.Callback
  {
    b(String paramString, long paramLong, com.tencent.mm.media.e.a parama) {}
    
    public final void onError(MediaCodec paramMediaCodec, MediaCodec.CodecException paramCodecException) {}
    
    public final void onInputBufferAvailable(MediaCodec paramMediaCodec, int paramInt)
    {
      AppMethodBeat.i(93538);
      for (;;)
      {
        try
        {
          ac.i(h.access$getTAG$cp(), "onInputBufferAvailable, index:" + paramInt + ", audioId:" + paramString);
          this.gPb.gOv = bs.Gn();
          if (paramInt < 0)
          {
            AppMethodBeat.o(93538);
            return;
          }
          paramMediaCodec = this.gPb.gOr;
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
          ac.printErrStackTrace(h.access$getTAG$cp(), (Throwable)paramMediaCodec, "", new Object[0]);
          AppMethodBeat.o(93538);
          return;
        }
        paramMediaCodec = null;
      }
      h.a(this.gPb, false);
      if (!this.gPe.k(paramMediaCodec))
      {
        ac.i(h.access$getTAG$cp(), "read sample end");
        h.a(this.gPb, true);
      }
      long l1 = 0L;
      int j;
      if (!h.c(this.gPb))
      {
        j = this.gPe.sampleSize;
        paramMediaCodec.position(0);
        long l2 = this.gPe.getSampleTime();
        ac.i(h.access$getTAG$cp(), "sampleTime : " + l2 + ", sampleSize:" + j + ", audioId:" + paramString);
        if (j >= 0)
        {
          i = j;
          l1 = l2;
          if (l2 < h.b(this.gPb) * 1000L) {}
        }
        else
        {
          h.a(this.gPb, true);
          ac.i(h.access$getTAG$cp(), "sawInputEOS, audioId:" + paramString);
          l1 = l2;
        }
      }
      for (int i = j;; i = 0)
      {
        paramMediaCodec = this.gPb.gOr;
        if (paramMediaCodec != null)
        {
          if (h.c(this.gPb)) {}
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
      k.h(paramBufferInfo, "bufferInfo");
      long l;
      try
      {
        ac.i(h.access$getTAG$cp(), "onOutputBufferAvailable, index:" + paramInt + ", bufferInfo:" + paramBufferInfo + " size:" + paramBufferInfo.size + ", audioId:" + paramString);
        if (paramInt < 0) {
          break label478;
        }
        l = paramBufferInfo.presentationTimeUs;
        ac.i(h.access$getTAG$cp(), "presentationTimeUs : ".concat(String.valueOf(l)));
        if ((l < paramLong1 * 1000L) && ((paramBufferInfo.flags & 0x4) == 0))
        {
          paramMediaCodec = this.gPb.gOr;
          if (paramMediaCodec != null) {
            paramMediaCodec.releaseOutputBuffer(paramInt, false);
          }
          ac.i(h.access$getTAG$cp(), "decoder pts: " + l + ", not reach start: " + paramLong1 * 1000L + ", audioId:" + paramString);
          AppMethodBeat.o(93537);
          return;
        }
        if (paramBufferInfo.size != 0) {
          break label305;
        }
        ac.i(h.access$getTAG$cp(), "decode zero size:" + paramString + ", zeroCount:" + h.a(this.gPb));
        paramMediaCodec = this.gPb;
        h.a(paramMediaCodec, h.a(paramMediaCodec) + 1);
        paramMediaCodec = this.gPb.gOr;
        if (paramMediaCodec == null) {
          break label299;
        }
        paramMediaCodec.releaseOutputBuffer(paramInt, false);
        AppMethodBeat.o(93537);
        return;
      }
      catch (Exception paramMediaCodec)
      {
        ac.printErrStackTrace(h.access$getTAG$cp(), (Throwable)paramMediaCodec, "", new Object[0]);
      }
      AppMethodBeat.o(93537);
      return;
      label299:
      AppMethodBeat.o(93537);
      return;
      label305:
      paramMediaCodec = this.gPb.gOr;
      if (paramMediaCodec != null) {}
      for (paramMediaCodec = paramMediaCodec.getOutputBuffer(paramInt);; paramMediaCodec = null)
      {
        this.gPb.e(paramMediaCodec, paramBufferInfo);
        paramMediaCodec = this.gPb.gOr;
        if (paramMediaCodec != null) {
          paramMediaCodec.releaseOutputBuffer(paramInt, false);
        }
        if ((h.b(this.gPb) * 1000L != 1L) && (l >= h.b(this.gPb) * 1000L))
        {
          ac.e(h.access$getTAG$cp(), "exceed endTimeMs, audioId:" + paramString);
          this.gPb.aqr();
          AppMethodBeat.o(93537);
          return;
        }
        if (((paramBufferInfo.flags & 0x4) == 0) && (!h.c(this.gPb))) {
          break;
        }
        ac.i(h.access$getTAG$cp(), "receive eos! audioId:" + paramString);
        this.gPb.aqr();
        AppMethodBeat.o(93537);
        return;
        label478:
        paramMediaCodec = this.gPb.gOr;
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
      this.gPb.gNt = paramMediaFormat;
      paramMediaCodec = this.gPb.gNt;
      if ((paramMediaCodec != null) && (paramMediaCodec.containsKey("sample-rate") == true))
      {
        paramMediaCodec = this.gPb.gNt;
        if (paramMediaCodec == null) {
          break label133;
        }
      }
      label133:
      for (int i = paramMediaCodec.getInteger("sample-rate");; i = 0)
      {
        if (i > 0) {
          this.gPb.gOu = i;
        }
        ac.i(h.access$getTAG$cp(), "onOutputFormatChanged:" + this.gPb.gNt + ", aacSampleRate:" + this.gPb.gOu + ", audioId:" + paramString);
        AppMethodBeat.o(93539);
        return;
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.media.c.h
 * JD-Core Version:    0.7.0.1
 */