package com.tencent.mm.media.h;

import android.media.MediaCodec.BufferInfo;
import android.media.MediaFormat;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.media.j.d;
import com.tencent.mm.plugin.sight.base.SightVideoJNI;
import com.tencent.mm.plugin.sight.base.b;
import com.tencent.mm.sdk.platformtools.ac;
import com.tencent.mm.sdk.platformtools.bs;
import d.g.b.k;
import d.l;
import java.nio.ByteBuffer;

@l(fNY={1, 1, 16}, fNZ={""}, fOa={"Lcom/tencent/mm/media/remuxer/MixMuxerController;", "", "remuxStartTime", "", "remuxEndTime", "outputBitrate", "", "outputVideoWidth", "outputVideoHeight", "useX264Encode", "", "outputFps", "", "enableHevc", "(JJIIIZFZ)V", "useSoftEncode", "(JJIZZ)V", "TAG", "", "aacSampleRate", "bufId", "channelCount", "duration", "frameCount", "isRelease", "isUseFFmpegMuxer", "getRemuxEndTime", "()J", "getRemuxStartTime", "getBufID", "output", "mediaExtractor", "Lcom/tencent/mm/media/extractor/MediaExtractorWrapper;", "muxOuputFilePath", "sampleRate", "mute", "release", "", "writeAudioData", "startTime", "endTime", "encodeData", "Ljava/nio/ByteBuffer;", "bufferInfo", "Landroid/media/MediaCodec$BufferInfo;", "format", "Landroid/media/MediaFormat;", "writeVideoData", "plugin-mediaeditor_release"})
public final class i
{
  private final String TAG;
  private int duration;
  private int frameCount;
  public int gNJ;
  private boolean gRc;
  public final long gTJ;
  private float gUX;
  private int gUY;
  private int gUZ;
  private final int gUm;
  private final boolean gUr;
  private final boolean gUs;
  private boolean gVa;
  public final long remuxEndTime;
  
  public i(long paramLong1, long paramLong2, int paramInt1, int paramInt2, int paramInt3, boolean paramBoolean1, float paramFloat, boolean paramBoolean2)
  {
    this(paramLong1, paramLong2, paramInt1, paramBoolean1, paramBoolean2);
    AppMethodBeat.i(93833);
    this.gUX = paramFloat;
    this.gUY = paramInt2;
    this.gUZ = paramInt3;
    ac.i(this.TAG, "secondary create MixMuxerController, outputFps:" + paramFloat + ", outputVideoWidth:" + paramInt2 + ", outputVideoHeight:" + paramInt3 + ", enableHevc:" + paramBoolean2);
    this.duration = ((int)(paramLong2 - paramLong1));
    if (this.duration != 0) {
      if (!paramBoolean1) {
        break label228;
      }
    }
    label228:
    for (this.gNJ = SightVideoJNI.initDataBufferForMMSightLock(paramInt2, paramInt3, 0, paramInt2, paramInt3, paramFloat, paramInt1, 1, 8, 2, 23.0F, false, true, this.duration, false, paramBoolean2, b.ab(true, paramBoolean2));; this.gNJ = SightVideoJNI.initDataBufferForRemux(paramBoolean2))
    {
      this.gRc = false;
      this.gVa = b.ab(paramBoolean1, paramBoolean2);
      ac.i(this.TAG, "secondary init endTime:" + paramLong2 + ", startTime:" + paramLong1 + ", duration:" + this.duration + ", bufId:" + this.gNJ);
      AppMethodBeat.o(93833);
      return;
    }
  }
  
  private i(long paramLong1, long paramLong2, int paramInt, boolean paramBoolean1, boolean paramBoolean2)
  {
    AppMethodBeat.i(93832);
    this.gTJ = paramLong1;
    this.remuxEndTime = paramLong2;
    this.gUm = paramInt;
    this.gUr = paramBoolean1;
    this.gUs = paramBoolean2;
    this.TAG = "MicroMsg.MixMuxerController";
    this.duration = ((int)(this.remuxEndTime - this.gTJ));
    if ((this.duration != 0) && (!this.gUr)) {
      this.gNJ = SightVideoJNI.initDataBufferForRemux(this.gUs);
    }
    this.gRc = false;
    this.gVa = b.ab(this.gUr, this.gUs);
    ac.i(this.TAG, "init endTime:" + this.remuxEndTime + ", startTime:" + this.gTJ + ", duration:" + this.duration + ", bufId:" + this.gNJ + ", enableHevc:" + this.gUs);
    AppMethodBeat.o(93832);
  }
  
  private void a(com.tencent.mm.media.e.a parama, long paramLong1, long paramLong2)
  {
    AppMethodBeat.i(93830);
    if (parama == null)
    {
      AppMethodBeat.o(93830);
      return;
    }
    if (this.gRc)
    {
      ac.e(this.TAG, "writeAudioData, already release");
      AppMethodBeat.o(93830);
      return;
    }
    if (parama.gRc)
    {
      ac.e(this.TAG, "writeAudioData, mediaExtractor already release");
      AppMethodBeat.o(93830);
      return;
    }
    int j = parama.gRH;
    Object localObject = parama.aqO();
    MediaFormat localMediaFormat = parama.gRJ;
    if ((j >= 0) && (localMediaFormat != null) && (!bs.isNullOrNil((String)localObject)))
    {
      ac.i(this.TAG, "writeAudioData, startTime: ".concat(String.valueOf(paramLong1)));
      parama.aqM();
      if (paramLong1 > 0L)
      {
        ac.i(this.TAG, "writeAudioData, seek to startTime:" + this.gTJ);
        parama.seek(1000L * paramLong1);
      }
      int i;
      if (localMediaFormat.containsKey("max-input-size"))
      {
        i = localMediaFormat.getInteger("max-input-size");
        localObject = ByteBuffer.allocateDirect(i);
      }
      for (;;)
      {
        try
        {
          ((ByteBuffer)localObject).clear();
          k.g(localObject, "dstBuf");
          parama.k((ByteBuffer)localObject);
          i = parama.sampleSize;
          ac.d(this.TAG, "sampleSize: %d", new Object[] { Integer.valueOf(i) });
          if (i > 0) {
            break label297;
          }
          ac.i(this.TAG, "muxAudio size = %d. Saw eos.", new Object[] { Integer.valueOf(i) });
          AppMethodBeat.o(93830);
          return;
        }
        catch (Exception parama)
        {
          ac.printErrStackTrace(this.TAG, (Throwable)parama, "writeAudioData error", new Object[0]);
          AppMethodBeat.o(93830);
          return;
        }
        i = 1024;
        break;
        label297:
        long l = parama.getSampleTime();
        ac.i(this.TAG, "aac pts:".concat(String.valueOf(l)));
        if ((l >= 1000L * paramLong2) || (l < 0L))
        {
          ac.i(this.TAG, "pts exceed endTime");
          AppMethodBeat.o(93830);
          return;
        }
        if (parama.gRF.getSampleTrackIndex() != j)
        {
          ac.e(this.TAG, "track index not match! break");
          AppMethodBeat.o(93830);
          return;
        }
        if (l < 1000L * paramLong1)
        {
          ac.i(this.TAG, "not reach start");
        }
        else
        {
          ((ByteBuffer)localObject).position(0);
          MediaCodec.BufferInfo localBufferInfo = new MediaCodec.BufferInfo();
          localBufferInfo.set(0, i, l, 0);
          a((ByteBuffer)localObject, localBufferInfo, localMediaFormat);
        }
      }
    }
    AppMethodBeat.o(93830);
  }
  
  public final int a(com.tencent.mm.media.e.a parama, String paramString, int paramInt1, int paramInt2, boolean paramBoolean)
  {
    AppMethodBeat.i(93828);
    k.h(paramString, "muxOuputFilePath");
    if (this.gRc)
    {
      ac.e(this.TAG, "output, already release");
      AppMethodBeat.o(93828);
      return -1;
    }
    if ((this.frameCount <= 0) && (!this.gUr))
    {
      ac.e(this.TAG, "output, no write h264 frame!!");
      parama = d.gWO;
      d.atc();
      AppMethodBeat.o(93828);
      return -1;
    }
    ac.i(this.TAG, "sampelRate:" + paramInt1 + ", channelCount:" + paramInt2);
    boolean bool = false;
    int i;
    if ((paramInt1 == 0) || (paramInt2 == 0)) {
      if (parama != null)
      {
        i = parama.gRH;
        String str = parama.aqO();
        MediaFormat localMediaFormat = parama.gRJ;
        if ((i >= 0) && (localMediaFormat != null) && (!bs.isNullOrNil(str)))
        {
          paramInt2 = localMediaFormat.getInteger("channel-count");
          paramInt1 = localMediaFormat.getInteger("sample-rate");
        }
      }
    }
    for (;;)
    {
      float f = this.frameCount * 1000.0F / this.duration;
      if ((paramInt2 <= 0) && (paramInt1 <= 0)) {
        bool = true;
      }
      for (;;)
      {
        ac.i(this.TAG, "output, fps:" + f + ", frameCount:" + this.frameCount + ", outputBitrate:" + this.gUm + ", finalChannelCount:" + paramInt2 + ", finalSampleRate:" + paramInt1 + ", outputPath:" + paramString + ", bufId:" + this.gNJ + ", mute:" + paramBoolean + ", videoMute:" + bool + ", mediaExtractor:" + parama);
        i = this.gNJ;
        int j = Math.max(1000, this.duration);
        int k = this.gUm;
        int m = com.tencent.mm.plugin.sight.base.c.xCp;
        if ((paramBoolean) || (bool)) {}
        for (paramBoolean = true;; paramBoolean = false)
        {
          paramInt1 = SightVideoJNI.muxingLock(i, null, paramInt1, 1024, 2, paramInt2, 0L, paramString, f, j, k, m, 8, 2, 23.0F, null, 0, false, paramBoolean, this.gUr, this.gUs, b.ab(this.gUr, this.gUs));
          release();
          if (paramInt1 < 0)
          {
            parama = d.gWO;
            d.atd();
          }
          AppMethodBeat.o(93828);
          return paramInt1;
          bool = true;
          break;
        }
      }
    }
  }
  
  public final void a(ByteBuffer paramByteBuffer, MediaCodec.BufferInfo paramBufferInfo, MediaFormat paramMediaFormat)
  {
    AppMethodBeat.i(93827);
    k.h(paramByteBuffer, "encodeData");
    k.h(paramBufferInfo, "bufferInfo");
    if (this.gRc)
    {
      ac.e(this.TAG, "writeAACData, already release");
      AppMethodBeat.o(93827);
      return;
    }
    if (this.gVa)
    {
      int m = this.gNJ;
      int n = paramBufferInfo.size;
      long l = paramBufferInfo.presentationTimeUs;
      int i;
      int j;
      if (paramMediaFormat != null)
      {
        i = paramMediaFormat.getInteger("aac-profile");
        if (paramMediaFormat == null) {
          break label140;
        }
        j = com.tencent.mm.plugin.mmsight.model.a.IN(paramMediaFormat.getInteger("sample-rate"));
        label98:
        if (paramMediaFormat == null) {
          break label146;
        }
      }
      label140:
      label146:
      for (int k = paramMediaFormat.getInteger("channel-count");; k = 1)
      {
        SightVideoJNI.writeAACDataWithADTSLock(m, paramByteBuffer, n, l, i, j, k);
        AppMethodBeat.o(93827);
        return;
        i = 2;
        break;
        j = 4;
        break label98;
      }
    }
    ac.i(this.TAG, "writeAACData: " + paramByteBuffer.capacity() + ", " + paramBufferInfo.size + ", bufId:" + this.gNJ);
    SightVideoJNI.writeAACDataLock(this.gNJ, paramByteBuffer, paramBufferInfo.size, paramBufferInfo.presentationTimeUs);
    AppMethodBeat.o(93827);
  }
  
  public final void g(ByteBuffer paramByteBuffer, MediaCodec.BufferInfo paramBufferInfo)
  {
    AppMethodBeat.i(93826);
    k.h(paramByteBuffer, "encodeData");
    k.h(paramBufferInfo, "bufferInfo");
    if (this.gRc)
    {
      ac.e(this.TAG, "writeVideoData, already release");
      AppMethodBeat.o(93826);
      return;
    }
    ac.i(this.TAG, "writeH264Data: " + paramByteBuffer.capacity() + ", " + paramBufferInfo.size + ", bufId:" + this.gNJ);
    SightVideoJNI.writeH264DataLock(this.gNJ, paramByteBuffer, paramBufferInfo.size, paramBufferInfo.presentationTimeUs);
    this.frameCount += 1;
    ac.i(this.TAG, "frameCount: " + this.frameCount);
    AppMethodBeat.o(93826);
  }
  
  public final void release()
  {
    AppMethodBeat.i(93829);
    SightVideoJNI.releaseRecorderBufferRefLock("clear");
    SightVideoJNI.releaseBigSightDataBufferLock(this.gNJ);
    this.gRc = true;
    AppMethodBeat.o(93829);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.media.h.i
 * JD-Core Version:    0.7.0.1
 */