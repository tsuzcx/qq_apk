package com.tencent.mm.media.i;

import android.media.MediaCodec.BufferInfo;
import android.media.MediaFormat;
import android.os.Build.VERSION;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.media.k.f;
import com.tencent.mm.media.k.g;
import com.tencent.mm.media.k.g.a;
import com.tencent.mm.plugin.sight.base.SightVideoJNI;
import com.tencent.mm.plugin.sight.base.d;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.Util;
import java.nio.ByteBuffer;
import kotlin.g.b.p;
import kotlin.l;

@l(iBK={1, 1, 16}, iBL={""}, iBM={"Lcom/tencent/mm/media/remuxer/MixMuxerController;", "", "remuxStartTime", "", "remuxEndTime", "outputBitrate", "", "outputVideoWidth", "outputVideoHeight", "useX264Encode", "", "outputFps", "", "enableHevc", "colorSpace", "Lcom/tencent/mm/media/util/VideoColorSpaceDetector$VideoColorSpace;", "(JJIIIZFZLcom/tencent/mm/media/util/VideoColorSpaceDetector$VideoColorSpace;)V", "useSoftEncode", "(JJIZZLcom/tencent/mm/media/util/VideoColorSpaceDetector$VideoColorSpace;)V", "TAG", "", "aacSampleRate", "bufId", "channelCount", "duration", "frameCount", "isRelease", "isUseFFmpegMuxer", "getRemuxEndTime", "()J", "getRemuxStartTime", "getBufID", "output", "mediaExtractor", "Lcom/tencent/mm/media/extractor/MediaExtractorWrapper;", "muxOuputFilePath", "sampleRate", "mute", "release", "", "writeAudioData", "startTime", "endTime", "encodeData", "Ljava/nio/ByteBuffer;", "bufferInfo", "Landroid/media/MediaCodec$BufferInfo;", "format", "Landroid/media/MediaFormat;", "writeVideoData", "writeVideoDts", "dts", "writeVideoDtsList", "dtsList", "", "plugin-mediaeditor_release"})
public final class i
{
  private final String TAG;
  public int bufId;
  private int duration;
  private int frameCount;
  private final boolean kSJ;
  private boolean kTS;
  public final long kWc;
  private float kXV;
  private int kXW;
  private int kXX;
  private boolean kXY;
  private final g.a kXZ;
  private final int kXk;
  private final boolean kXp;
  public final long remuxEndTime;
  
  public i(long paramLong1, long paramLong2, int paramInt1, int paramInt2, int paramInt3, boolean paramBoolean1, float paramFloat, boolean paramBoolean2, g.a parama)
  {
    this(paramLong1, paramLong2, paramInt1, paramBoolean1, paramBoolean2, parama);
    AppMethodBeat.i(259734);
    this.kXV = paramFloat;
    this.kXW = paramInt2;
    this.kXX = paramInt3;
    Log.i(this.TAG, "secondary create MixMuxerController, outputFps:" + paramFloat + ", outputVideoWidth:" + paramInt2 + ", outputVideoHeight:" + paramInt3 + ", enableHevc:" + paramBoolean2);
    this.kXY = com.tencent.mm.plugin.sight.base.c.av(paramBoolean1, paramBoolean2);
    this.duration = ((int)(paramLong2 - paramLong1));
    if (this.duration != 0)
    {
      if (!paramBoolean1) {
        break label256;
      }
      if (parama == null) {
        break label234;
      }
      paramInt1 = SightVideoJNI.initSoftEncodeDataBufferLock(paramInt2, paramInt3, paramInt1, paramFloat, paramBoolean2, parama.colorRange, parama.colorStandard, parama.colorTransfer, this.kXY);
    }
    label256:
    for (this.bufId = paramInt1;; this.bufId = SightVideoJNI.initDataBufferForRemux(paramBoolean2))
    {
      this.kTS = false;
      Log.i(this.TAG, "secondary init endTime:" + paramLong2 + ", startTime:" + paramLong1 + ", duration:" + this.duration + ", bufId:" + this.bufId);
      AppMethodBeat.o(259734);
      return;
      label234:
      paramInt1 = SightVideoJNI.initSoftEncodeDataBufferLock(paramInt2, paramInt3, paramInt1, paramFloat, paramBoolean2, this.kXY);
      break;
    }
  }
  
  private i(long paramLong1, long paramLong2, int paramInt, boolean paramBoolean1, boolean paramBoolean2, g.a parama)
  {
    AppMethodBeat.i(259729);
    this.kWc = paramLong1;
    this.remuxEndTime = paramLong2;
    this.kXk = paramInt;
    this.kXp = paramBoolean1;
    this.kSJ = paramBoolean2;
    this.kXZ = parama;
    this.TAG = "MicroMsg.MixMuxerController";
    this.duration = ((int)(this.remuxEndTime - this.kWc));
    if ((this.duration != 0) && (!this.kXp)) {
      this.bufId = SightVideoJNI.initDataBufferForRemux(this.kSJ);
    }
    this.kTS = false;
    this.kXY = com.tencent.mm.plugin.sight.base.c.av(this.kXp, this.kSJ);
    Log.i(this.TAG, "init endTime:" + this.remuxEndTime + ", startTime:" + this.kWc + ", duration:" + this.duration + ", bufId:" + this.bufId + ", enableHevc:" + this.kSJ);
    if ((this.kXZ != null) && (Build.VERSION.SDK_INT >= 24))
    {
      parama = g.laC;
      g.a(this.bufId, this.kXZ);
    }
    AppMethodBeat.o(259729);
  }
  
  private void a(com.tencent.mm.media.f.a parama, long paramLong1, long paramLong2)
  {
    AppMethodBeat.i(93830);
    if (parama == null)
    {
      AppMethodBeat.o(93830);
      return;
    }
    if (this.kTS)
    {
      Log.e(this.TAG, "writeAudioData, already release");
      AppMethodBeat.o(93830);
      return;
    }
    if (parama.kTS)
    {
      Log.e(this.TAG, "writeAudioData, mediaExtractor already release");
      AppMethodBeat.o(93830);
      return;
    }
    int j = parama.audioTrackIndex;
    Object localObject = parama.aUJ();
    MediaFormat localMediaFormat = parama.kUW;
    if ((j >= 0) && (localMediaFormat != null) && (!Util.isNullOrNil((String)localObject)))
    {
      Log.i(this.TAG, "writeAudioData, startTime: ".concat(String.valueOf(paramLong1)));
      parama.aUH();
      if (paramLong1 > 0L)
      {
        Log.i(this.TAG, "writeAudioData, seek to startTime:" + this.kWc);
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
          p.j(localObject, "dstBuf");
          com.tencent.mm.media.f.a.a(parama, (ByteBuffer)localObject);
          i = parama.sampleSize;
          Log.d(this.TAG, "sampleSize: %d", new Object[] { Integer.valueOf(i) });
          if (i > 0) {
            break label300;
          }
          Log.i(this.TAG, "muxAudio size = %d. Saw eos.", new Object[] { Integer.valueOf(i) });
          AppMethodBeat.o(93830);
          return;
        }
        catch (Exception parama)
        {
          Log.printErrStackTrace(this.TAG, (Throwable)parama, "writeAudioData error", new Object[0]);
          AppMethodBeat.o(93830);
          return;
        }
        i = 1024;
        break;
        label300:
        long l = parama.getSampleTime();
        Log.i(this.TAG, "aac pts:".concat(String.valueOf(l)));
        if (l >= 1000L * paramLong2)
        {
          Log.i(this.TAG, "pts exceed endTime");
          AppMethodBeat.o(93830);
          return;
        }
        if (parama.kUU.getSampleTrackIndex() != j)
        {
          Log.e(this.TAG, "track index not match! break");
          AppMethodBeat.o(93830);
          return;
        }
        if (l < 1000L * paramLong1)
        {
          Log.i(this.TAG, "not reach start");
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
  
  public final void FQ(long paramLong)
  {
    AppMethodBeat.i(259722);
    if (this.kTS)
    {
      Log.e(this.TAG, "writeVideoDts, already release");
      AppMethodBeat.o(259722);
      return;
    }
    Log.i(this.TAG, "writeVideoDts: ".concat(String.valueOf(paramLong)));
    SightVideoJNI.writeDtsDataLock(this.bufId, paramLong);
    AppMethodBeat.o(259722);
  }
  
  public final int a(com.tencent.mm.media.f.a parama, String paramString, int paramInt1, int paramInt2, boolean paramBoolean)
  {
    AppMethodBeat.i(93828);
    p.k(paramString, "muxOuputFilePath");
    if (this.kTS)
    {
      Log.e(this.TAG, "output, already release");
      AppMethodBeat.o(93828);
      return -1;
    }
    if ((this.frameCount <= 0) && (!this.kXp))
    {
      Log.e(this.TAG, "output, no write h264 frame!!");
      parama = f.laB;
      f.aXv();
      AppMethodBeat.o(93828);
      return -1;
    }
    Log.i(this.TAG, "sampelRate:" + paramInt1 + ", channelCount:" + paramInt2);
    boolean bool = false;
    int i;
    if ((paramInt1 == 0) || (paramInt2 == 0)) {
      if (parama != null)
      {
        i = parama.audioTrackIndex;
        String str = parama.aUJ();
        MediaFormat localMediaFormat = parama.kUW;
        if ((i >= 0) && (localMediaFormat != null) && (!Util.isNullOrNil(str)))
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
        Log.i(this.TAG, "output, fps:" + f + ", frameCount:" + this.frameCount + ", outputBitrate:" + this.kXk + ", finalChannelCount:" + paramInt2 + ", finalSampleRate:" + paramInt1 + ", outputPath:" + paramString + ", bufId:" + this.bufId + ", mute:" + paramBoolean + ", videoMute:" + bool + ", mediaExtractor:" + parama);
        i = this.bufId;
        int j = Math.max(1000, this.duration);
        int k = this.kXk;
        int m = d.JrF;
        if ((paramBoolean) || (bool)) {}
        for (paramBoolean = true;; paramBoolean = false)
        {
          paramInt1 = SightVideoJNI.muxingLock(i, null, paramInt1, 1024, 2, paramInt2, 0L, paramString, f, j, k, m, 8, 2, 23.0F, null, 0, false, paramBoolean, this.kXp, this.kSJ, com.tencent.mm.plugin.sight.base.c.av(this.kXp, this.kSJ));
          release();
          if (paramInt1 < 0)
          {
            parama = f.laB;
            f.aXw();
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
    p.k(paramByteBuffer, "encodeData");
    p.k(paramBufferInfo, "bufferInfo");
    if (this.kTS)
    {
      Log.e(this.TAG, "writeAACData, already release");
      AppMethodBeat.o(93827);
      return;
    }
    if (this.kXY)
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
      for (int j = com.tencent.mm.plugin.mmsight.model.a.WZ(paramMediaFormat.getInteger("sample-rate"));; j = 4)
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
    Log.i(this.TAG, "writeAACData: " + paramByteBuffer.capacity() + ", " + paramBufferInfo.size + ", bufId:" + this.bufId);
    SightVideoJNI.writeAACDataLock(this.bufId, paramByteBuffer, paramBufferInfo.size, paramBufferInfo.presentationTimeUs);
    AppMethodBeat.o(93827);
  }
  
  public final void g(ByteBuffer paramByteBuffer, MediaCodec.BufferInfo paramBufferInfo)
  {
    AppMethodBeat.i(93826);
    p.k(paramByteBuffer, "encodeData");
    p.k(paramBufferInfo, "bufferInfo");
    if (this.kTS)
    {
      Log.e(this.TAG, "writeVideoData, already release");
      AppMethodBeat.o(93826);
      return;
    }
    Log.i(this.TAG, "writeH264Data: " + paramByteBuffer.capacity() + ", " + paramBufferInfo.size + ", bufId:" + this.bufId + ", pts:" + paramBufferInfo.presentationTimeUs);
    SightVideoJNI.writeH264DataLock(this.bufId, paramByteBuffer, paramBufferInfo.size, paramBufferInfo.presentationTimeUs);
    this.frameCount += 1;
    Log.i(this.TAG, "frameCount: " + this.frameCount);
    AppMethodBeat.o(93826);
  }
  
  public final void release()
  {
    AppMethodBeat.i(93829);
    Log.i(this.TAG, "release");
    SightVideoJNI.releaseRecorderBufferRefLock("clear");
    SightVideoJNI.releaseBigSightDataBufferLock(this.bufId);
    this.kTS = true;
    AppMethodBeat.o(93829);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.media.i.i
 * JD-Core Version:    0.7.0.1
 */