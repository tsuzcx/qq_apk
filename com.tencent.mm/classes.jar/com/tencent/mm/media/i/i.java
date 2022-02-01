package com.tencent.mm.media.i;

import android.media.MediaCodec.BufferInfo;
import android.media.MediaFormat;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.media.k.d;
import com.tencent.mm.plugin.sight.base.SightVideoJNI;
import com.tencent.mm.plugin.sight.base.b;
import com.tencent.mm.sdk.platformtools.ad;
import com.tencent.mm.sdk.platformtools.bt;
import d.g.b.p;
import d.l;
import java.nio.ByteBuffer;

@l(gfx={1, 1, 16}, gfy={""}, gfz={"Lcom/tencent/mm/media/remuxer/MixMuxerController;", "", "remuxStartTime", "", "remuxEndTime", "outputBitrate", "", "outputVideoWidth", "outputVideoHeight", "useX264Encode", "", "outputFps", "", "enableHevc", "(JJIIIZFZ)V", "useSoftEncode", "(JJIZZ)V", "TAG", "", "aacSampleRate", "bufId", "channelCount", "duration", "frameCount", "isRelease", "isUseFFmpegMuxer", "getRemuxEndTime", "()J", "getRemuxStartTime", "getBufID", "output", "mediaExtractor", "Lcom/tencent/mm/media/extractor/MediaExtractorWrapper;", "muxOuputFilePath", "sampleRate", "mute", "release", "", "writeAudioData", "startTime", "endTime", "encodeData", "Ljava/nio/ByteBuffer;", "bufferInfo", "Landroid/media/MediaCodec$BufferInfo;", "format", "Landroid/media/MediaFormat;", "writeVideoData", "plugin-mediaeditor_release"})
public final class i
{
  private final String TAG;
  public int bufId;
  private int duration;
  private int frameCount;
  private boolean hju;
  public final long hlK;
  private final int hmn;
  private final boolean hms;
  private final boolean hmt;
  private float hna;
  private int hnb;
  private int hnc;
  private boolean hnd;
  public final long remuxEndTime;
  
  public i(long paramLong1, long paramLong2, int paramInt1, int paramInt2, int paramInt3, boolean paramBoolean1, float paramFloat, boolean paramBoolean2)
  {
    this(paramLong1, paramLong2, paramInt1, paramBoolean1, paramBoolean2);
    AppMethodBeat.i(93833);
    this.hna = paramFloat;
    this.hnb = paramInt2;
    this.hnc = paramInt3;
    ad.i(this.TAG, "secondary create MixMuxerController, outputFps:" + paramFloat + ", outputVideoWidth:" + paramInt2 + ", outputVideoHeight:" + paramInt3 + ", enableHevc:" + paramBoolean2);
    this.duration = ((int)(paramLong2 - paramLong1));
    if (this.duration != 0) {
      if (!paramBoolean1) {
        break label228;
      }
    }
    label228:
    for (this.bufId = SightVideoJNI.initDataBufferForMMSightLock(paramInt2, paramInt3, 0, paramInt2, paramInt3, paramFloat, paramInt1, 1, 8, 2, 23.0F, false, true, this.duration, false, paramBoolean2, b.af(true, paramBoolean2));; this.bufId = SightVideoJNI.initDataBufferForRemux(paramBoolean2))
    {
      this.hju = false;
      this.hnd = b.af(paramBoolean1, paramBoolean2);
      ad.i(this.TAG, "secondary init endTime:" + paramLong2 + ", startTime:" + paramLong1 + ", duration:" + this.duration + ", bufId:" + this.bufId);
      AppMethodBeat.o(93833);
      return;
    }
  }
  
  private i(long paramLong1, long paramLong2, int paramInt, boolean paramBoolean1, boolean paramBoolean2)
  {
    AppMethodBeat.i(93832);
    this.hlK = paramLong1;
    this.remuxEndTime = paramLong2;
    this.hmn = paramInt;
    this.hms = paramBoolean1;
    this.hmt = paramBoolean2;
    this.TAG = "MicroMsg.MixMuxerController";
    this.duration = ((int)(this.remuxEndTime - this.hlK));
    if ((this.duration != 0) && (!this.hms)) {
      this.bufId = SightVideoJNI.initDataBufferForRemux(this.hmt);
    }
    this.hju = false;
    this.hnd = b.af(this.hms, this.hmt);
    ad.i(this.TAG, "init endTime:" + this.remuxEndTime + ", startTime:" + this.hlK + ", duration:" + this.duration + ", bufId:" + this.bufId + ", enableHevc:" + this.hmt);
    AppMethodBeat.o(93832);
  }
  
  private void a(com.tencent.mm.media.f.a parama, long paramLong1, long paramLong2)
  {
    AppMethodBeat.i(93830);
    if (parama == null)
    {
      AppMethodBeat.o(93830);
      return;
    }
    if (this.hju)
    {
      ad.e(this.TAG, "writeAudioData, already release");
      AppMethodBeat.o(93830);
      return;
    }
    if (parama.hju)
    {
      ad.e(this.TAG, "writeAudioData, mediaExtractor already release");
      AppMethodBeat.o(93830);
      return;
    }
    int j = parama.hjZ;
    Object localObject = parama.atC();
    MediaFormat localMediaFormat = parama.hkb;
    if ((j >= 0) && (localMediaFormat != null) && (!bt.isNullOrNil((String)localObject)))
    {
      ad.i(this.TAG, "writeAudioData, startTime: ".concat(String.valueOf(paramLong1)));
      parama.atA();
      if (paramLong1 > 0L)
      {
        ad.i(this.TAG, "writeAudioData, seek to startTime:" + this.hlK);
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
          p.g(localObject, "dstBuf");
          parama.j((ByteBuffer)localObject);
          i = parama.sampleSize;
          ad.d(this.TAG, "sampleSize: %d", new Object[] { Integer.valueOf(i) });
          if (i > 0) {
            break label297;
          }
          ad.i(this.TAG, "muxAudio size = %d. Saw eos.", new Object[] { Integer.valueOf(i) });
          AppMethodBeat.o(93830);
          return;
        }
        catch (Exception parama)
        {
          ad.printErrStackTrace(this.TAG, (Throwable)parama, "writeAudioData error", new Object[0]);
          AppMethodBeat.o(93830);
          return;
        }
        i = 1024;
        break;
        label297:
        long l = parama.getSampleTime();
        ad.i(this.TAG, "aac pts:".concat(String.valueOf(l)));
        if ((l >= 1000L * paramLong2) || (l < 0L))
        {
          ad.i(this.TAG, "pts exceed endTime");
          AppMethodBeat.o(93830);
          return;
        }
        if (parama.hjX.getSampleTrackIndex() != j)
        {
          ad.e(this.TAG, "track index not match! break");
          AppMethodBeat.o(93830);
          return;
        }
        if (l < 1000L * paramLong1)
        {
          ad.i(this.TAG, "not reach start");
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
  
  public final int a(com.tencent.mm.media.f.a parama, String paramString, int paramInt1, int paramInt2, boolean paramBoolean)
  {
    AppMethodBeat.i(93828);
    p.h(paramString, "muxOuputFilePath");
    if (this.hju)
    {
      ad.e(this.TAG, "output, already release");
      AppMethodBeat.o(93828);
      return -1;
    }
    if ((this.frameCount <= 0) && (!this.hms))
    {
      ad.e(this.TAG, "output, no write h264 frame!!");
      parama = d.hoU;
      d.avP();
      AppMethodBeat.o(93828);
      return -1;
    }
    ad.i(this.TAG, "sampelRate:" + paramInt1 + ", channelCount:" + paramInt2);
    boolean bool = false;
    int i;
    if ((paramInt1 == 0) || (paramInt2 == 0)) {
      if (parama != null)
      {
        i = parama.hjZ;
        String str = parama.atC();
        MediaFormat localMediaFormat = parama.hkb;
        if ((i >= 0) && (localMediaFormat != null) && (!bt.isNullOrNil(str)))
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
        ad.i(this.TAG, "output, fps:" + f + ", frameCount:" + this.frameCount + ", outputBitrate:" + this.hmn + ", finalChannelCount:" + paramInt2 + ", finalSampleRate:" + paramInt1 + ", outputPath:" + paramString + ", bufId:" + this.bufId + ", mute:" + paramBoolean + ", videoMute:" + bool + ", mediaExtractor:" + parama);
        i = this.bufId;
        int j = Math.max(1000, this.duration);
        int k = this.hmn;
        int m = com.tencent.mm.plugin.sight.base.c.yQZ;
        if ((paramBoolean) || (bool)) {}
        for (paramBoolean = true;; paramBoolean = false)
        {
          paramInt1 = SightVideoJNI.muxingLock(i, null, paramInt1, 1024, 2, paramInt2, 0L, paramString, f, j, k, m, 8, 2, 23.0F, null, 0, false, paramBoolean, this.hms, this.hmt, b.af(this.hms, this.hmt));
          release();
          if (paramInt1 < 0)
          {
            parama = d.hoU;
            d.avQ();
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
    int m = 1;
    AppMethodBeat.i(93827);
    p.h(paramByteBuffer, "encodeData");
    p.h(paramBufferInfo, "bufferInfo");
    if (this.hju)
    {
      ad.e(this.TAG, "writeAACData, already release");
      AppMethodBeat.o(93827);
      return;
    }
    if (this.hnd)
    {
      int n = this.bufId;
      int i1 = paramBufferInfo.size;
      long l = paramBufferInfo.presentationTimeUs;
      int i;
      if ((paramMediaFormat != null) && (paramMediaFormat.containsKey("aac-profile") == true))
      {
        i = paramMediaFormat.getInteger("aac-profile");
        if ((paramMediaFormat == null) || (paramMediaFormat.containsKey("sample-rate") != true)) {
          break label184;
        }
      }
      label184:
      for (int j = com.tencent.mm.plugin.mmsight.model.a.Kk(paramMediaFormat.getInteger("sample-rate"));; j = 4)
      {
        int k = m;
        if (paramMediaFormat != null)
        {
          k = m;
          if (paramMediaFormat.containsKey("channel-count") == true) {
            k = paramMediaFormat.getInteger("channel-count");
          }
        }
        SightVideoJNI.writeAACDataWithADTSLock(n, paramByteBuffer, i1, l, i, j, k);
        AppMethodBeat.o(93827);
        return;
        i = 2;
        break;
      }
    }
    ad.i(this.TAG, "writeAACData: " + paramByteBuffer.capacity() + ", " + paramBufferInfo.size + ", bufId:" + this.bufId);
    SightVideoJNI.writeAACDataLock(this.bufId, paramByteBuffer, paramBufferInfo.size, paramBufferInfo.presentationTimeUs);
    AppMethodBeat.o(93827);
  }
  
  public final void g(ByteBuffer paramByteBuffer, MediaCodec.BufferInfo paramBufferInfo)
  {
    AppMethodBeat.i(93826);
    p.h(paramByteBuffer, "encodeData");
    p.h(paramBufferInfo, "bufferInfo");
    if (this.hju)
    {
      ad.e(this.TAG, "writeVideoData, already release");
      AppMethodBeat.o(93826);
      return;
    }
    ad.i(this.TAG, "writeH264Data: " + paramByteBuffer.capacity() + ", " + paramBufferInfo.size + ", bufId:" + this.bufId);
    SightVideoJNI.writeH264DataLock(this.bufId, paramByteBuffer, paramBufferInfo.size, paramBufferInfo.presentationTimeUs);
    this.frameCount += 1;
    ad.i(this.TAG, "frameCount: " + this.frameCount);
    AppMethodBeat.o(93826);
  }
  
  public final void release()
  {
    AppMethodBeat.i(93829);
    SightVideoJNI.releaseRecorderBufferRefLock("clear");
    SightVideoJNI.releaseBigSightDataBufferLock(this.bufId);
    this.hju = true;
    AppMethodBeat.o(93829);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.media.i.i
 * JD-Core Version:    0.7.0.1
 */