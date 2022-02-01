package com.tencent.mm.media.i;

import android.media.MediaCodec.BufferInfo;
import android.media.MediaExtractor;
import android.media.MediaFormat;
import android.os.Build.VERSION;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.media.util.f;
import com.tencent.mm.media.util.g;
import com.tencent.mm.media.util.g.a;
import com.tencent.mm.plugin.sight.base.SightVideoJNI;
import com.tencent.mm.plugin.sight.base.d;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.Util;
import java.nio.ByteBuffer;
import kotlin.Metadata;
import kotlin.g.b.s;

@Metadata(d1={""}, d2={"Lcom/tencent/mm/media/remuxer/MixMuxerController;", "", "remuxStartTime", "", "remuxEndTime", "outputBitrate", "", "outputVideoWidth", "outputVideoHeight", "useX264Encode", "", "outputFps", "", "enableHevc", "colorSpace", "Lcom/tencent/mm/media/util/VideoColorSpaceDetector$VideoColorSpace;", "(JJIIIZFZLcom/tencent/mm/media/util/VideoColorSpaceDetector$VideoColorSpace;)V", "useSoftEncode", "(JJIZZLcom/tencent/mm/media/util/VideoColorSpaceDetector$VideoColorSpace;)V", "TAG", "", "aacSampleRate", "bufId", "channelCount", "duration", "frameCount", "isRelease", "isUseFFmpegMuxer", "getRemuxEndTime", "()J", "getRemuxStartTime", "getBufID", "output", "mediaExtractor", "Lcom/tencent/mm/media/extractor/MediaExtractorWrapper;", "muxOuputFilePath", "sampleRate", "mute", "release", "", "writeAudioData", "startTime", "endTime", "encodeData", "Ljava/nio/ByteBuffer;", "bufferInfo", "Landroid/media/MediaCodec$BufferInfo;", "format", "Landroid/media/MediaFormat;", "writeVideoData", "writeVideoDts", "dts", "writeVideoDtsList", "dtsList", "", "plugin-mediaeditor_release"}, k=1, mv={1, 5, 1}, xi=48)
public final class h
{
  private final String TAG;
  public int bufId;
  private int duration;
  private int frameCount;
  private final int nBU;
  private final boolean nBZ;
  public final long nBy;
  private final g.a nDd;
  private float nDe;
  private int nDf;
  private int nDg;
  private boolean nDh;
  private final boolean nyh;
  private boolean nzB;
  public final long remuxEndTime;
  
  public h(long paramLong1, long paramLong2, int paramInt1, int paramInt2, int paramInt3, boolean paramBoolean1, float paramFloat, boolean paramBoolean2, g.a parama)
  {
    this(paramLong1, paramLong2, paramInt1, paramBoolean1, paramBoolean2, parama);
    AppMethodBeat.i(237810);
    this.nDe = paramFloat;
    this.nDf = paramInt2;
    this.nDg = paramInt3;
    Log.i(this.TAG, "secondary create MixMuxerController, outputFps:" + paramFloat + ", outputVideoWidth:" + paramInt2 + ", outputVideoHeight:" + paramInt3 + ", enableHevc:" + paramBoolean2);
    this.nDh = com.tencent.mm.plugin.sight.base.c.aO(paramBoolean1, paramBoolean2);
    this.duration = ((int)(paramLong2 - paramLong1));
    if (this.duration != 0)
    {
      if (!paramBoolean1) {
        break label256;
      }
      if (parama == null) {
        break label234;
      }
      paramInt1 = SightVideoJNI.initSoftEncodeDataBufferLock(paramInt2, paramInt3, paramInt1, paramFloat, paramBoolean2, parama.colorRange, parama.colorStandard, parama.colorTransfer, this.nDh);
    }
    label256:
    for (this.bufId = paramInt1;; this.bufId = SightVideoJNI.initDataBufferForRemux(paramBoolean2))
    {
      this.nzB = false;
      Log.i(this.TAG, "secondary init endTime:" + paramLong2 + ", startTime:" + paramLong1 + ", duration:" + this.duration + ", bufId:" + this.bufId);
      AppMethodBeat.o(237810);
      return;
      label234:
      paramInt1 = SightVideoJNI.initSoftEncodeDataBufferLock(paramInt2, paramInt3, paramInt1, paramFloat, paramBoolean2, this.nDh);
      break;
    }
  }
  
  private h(long paramLong1, long paramLong2, int paramInt, boolean paramBoolean1, boolean paramBoolean2, g.a parama)
  {
    AppMethodBeat.i(237806);
    this.nBy = paramLong1;
    this.remuxEndTime = paramLong2;
    this.nBU = paramInt;
    this.nBZ = paramBoolean1;
    this.nyh = paramBoolean2;
    this.nDd = parama;
    this.TAG = "MicroMsg.MixMuxerController";
    this.duration = ((int)(this.remuxEndTime - this.nBy));
    if ((this.duration != 0) && (!this.nBZ)) {
      this.bufId = SightVideoJNI.initDataBufferForRemux(this.nyh);
    }
    this.nzB = false;
    this.nDh = com.tencent.mm.plugin.sight.base.c.aO(this.nBZ, this.nyh);
    Log.i(this.TAG, "init endTime:" + this.remuxEndTime + ", startTime:" + this.nBy + ", duration:" + this.duration + ", bufId:" + this.bufId + ", enableHevc:" + this.nyh);
    if ((this.nDd != null) && (Build.VERSION.SDK_INT >= 24))
    {
      parama = g.nFH;
      g.a(this.bufId, this.nDd);
    }
    AppMethodBeat.o(237806);
  }
  
  private void a(com.tencent.mm.media.f.a parama, long paramLong1, long paramLong2)
  {
    AppMethodBeat.i(93830);
    if (parama == null)
    {
      AppMethodBeat.o(93830);
      return;
    }
    if (this.nzB)
    {
      Log.e(this.TAG, "writeAudioData, already release");
      AppMethodBeat.o(93830);
      return;
    }
    if (parama.nzB)
    {
      Log.e(this.TAG, "writeAudioData, mediaExtractor already release");
      AppMethodBeat.o(93830);
      return;
    }
    int j = parama.audioTrackIndex;
    Object localObject = parama.bpq();
    MediaFormat localMediaFormat = parama.nAt;
    int i;
    if ((j >= 0) && (localMediaFormat != null) && (!Util.isNullOrNil((String)localObject)))
    {
      Log.i(this.TAG, s.X("writeAudioData, startTime: ", Long.valueOf(paramLong1)));
      parama.bpo();
      if (paramLong1 > 0L)
      {
        Log.i(this.TAG, s.X("writeAudioData, seek to startTime:", Long.valueOf(this.nBy)));
        parama.seek(1000L * paramLong1);
      }
      if (!localMediaFormat.containsKey("max-input-size")) {
        break label286;
      }
      i = localMediaFormat.getInteger("max-input-size");
      localObject = ByteBuffer.allocateDirect(i);
    }
    for (;;)
    {
      try
      {
        ((ByteBuffer)localObject).clear();
        s.s(localObject, "dstBuf");
        com.tencent.mm.media.f.a.a(parama, (ByteBuffer)localObject);
        i = parama.sampleSize;
        Log.d(this.TAG, "sampleSize: %d", new Object[] { Integer.valueOf(i) });
        if (i > 0) {
          break label294;
        }
        Log.i(this.TAG, "muxAudio size = %d. Saw eos.", new Object[] { Integer.valueOf(i) });
        AppMethodBeat.o(93830);
        return;
      }
      catch (Exception parama)
      {
        Log.printErrStackTrace(this.TAG, (Throwable)parama, "writeAudioData error", new Object[0]);
      }
      AppMethodBeat.o(93830);
      return;
      label286:
      i = 1024;
      break;
      label294:
      long l = parama.getSampleTime();
      Log.i(this.TAG, s.X("aac pts:", Long.valueOf(l)));
      if (l >= 1000L * paramLong2)
      {
        Log.i(this.TAG, "pts exceed endTime");
        AppMethodBeat.o(93830);
        return;
      }
      if (parama.nAr.lZm.getSampleTrackIndex() != j)
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
  
  public final int a(com.tencent.mm.media.f.a parama, String paramString, int paramInt1, int paramInt2, boolean paramBoolean)
  {
    AppMethodBeat.i(93828);
    s.u(paramString, "muxOuputFilePath");
    if (this.nzB)
    {
      Log.e(this.TAG, "output, already release");
      AppMethodBeat.o(93828);
      return -1;
    }
    if ((this.frameCount <= 0) && (!this.nBZ))
    {
      Log.e(this.TAG, "output, no write h264 frame!!");
      parama = f.nFE;
      f.bsd();
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
        String str = parama.bpq();
        MediaFormat localMediaFormat = parama.nAt;
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
        Log.i(this.TAG, "output, fps:" + f + ", frameCount:" + this.frameCount + ", outputBitrate:" + this.nBU + ", finalChannelCount:" + paramInt2 + ", finalSampleRate:" + paramInt1 + ", outputPath:" + paramString + ", bufId:" + this.bufId + ", mute:" + paramBoolean + ", videoMute:" + bool + ", mediaExtractor:" + parama);
        i = this.bufId;
        int j = Math.max(1000, this.duration);
        int k = this.nBU;
        int m = d.PFh;
        if ((paramBoolean) || (bool)) {}
        for (paramBoolean = true;; paramBoolean = false)
        {
          paramInt1 = SightVideoJNI.muxingLock(i, null, paramInt1, 1024, 2, paramInt2, 0L, paramString, f, j, k, m, 8, 2, 23.0F, null, 0, false, paramBoolean, this.nBZ, this.nyh, com.tencent.mm.plugin.sight.base.c.aO(this.nBZ, this.nyh));
          release();
          if (paramInt1 < 0)
          {
            parama = f.nFE;
            f.bse();
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
    int n = 0;
    int m = 1;
    AppMethodBeat.i(93827);
    s.u(paramByteBuffer, "encodeData");
    s.u(paramBufferInfo, "bufferInfo");
    if (this.nzB)
    {
      Log.e(this.TAG, "writeAACData, already release");
      AppMethodBeat.o(93827);
      return;
    }
    if (this.nDh)
    {
      int i1 = this.bufId;
      int i2 = paramBufferInfo.size;
      long l = paramBufferInfo.presentationTimeUs;
      int i;
      if ((paramMediaFormat != null) && (paramMediaFormat.containsKey("aac-profile") == true))
      {
        i = 1;
        if (i == 0) {
          break label211;
        }
        i = paramMediaFormat.getInteger("aac-profile");
        label107:
        if ((paramMediaFormat == null) || (paramMediaFormat.containsKey("sample-rate") != true)) {
          break label217;
        }
        j = 1;
        label125:
        if (j == 0) {
          break label223;
        }
      }
      label211:
      label217:
      label223:
      for (int j = com.tencent.mm.plugin.mmsight.model.a.abb(paramMediaFormat.getInteger("sample-rate"));; j = 4)
      {
        int k = n;
        if (paramMediaFormat != null)
        {
          k = n;
          if (paramMediaFormat.containsKey("channel-count") == true) {
            k = 1;
          }
        }
        if (k != 0) {
          m = paramMediaFormat.getInteger("channel-count");
        }
        SightVideoJNI.writeAACDataWithADTSLock(i1, paramByteBuffer, i2, l, i, j, m);
        AppMethodBeat.o(93827);
        return;
        i = 0;
        break;
        i = 2;
        break label107;
        j = 0;
        break label125;
      }
    }
    Log.i(this.TAG, "writeAACData: " + paramByteBuffer.capacity() + ", " + paramBufferInfo.size + ", bufId:" + this.bufId);
    SightVideoJNI.writeAACDataLock(this.bufId, paramByteBuffer, paramBufferInfo.size, paramBufferInfo.presentationTimeUs);
    AppMethodBeat.o(93827);
  }
  
  public final void g(ByteBuffer paramByteBuffer, MediaCodec.BufferInfo paramBufferInfo)
  {
    AppMethodBeat.i(93826);
    s.u(paramByteBuffer, "encodeData");
    s.u(paramBufferInfo, "bufferInfo");
    if (this.nzB)
    {
      Log.e(this.TAG, "writeVideoData, already release");
      AppMethodBeat.o(93826);
      return;
    }
    Log.i(this.TAG, "writeH264Data: " + paramByteBuffer.capacity() + ", " + paramBufferInfo.size + ", bufId:" + this.bufId + ", pts:" + paramBufferInfo.presentationTimeUs);
    SightVideoJNI.writeH264DataLock(this.bufId, paramByteBuffer, paramBufferInfo.size, paramBufferInfo.presentationTimeUs);
    this.frameCount += 1;
    Log.i(this.TAG, s.X("frameCount: ", Integer.valueOf(this.frameCount)));
    AppMethodBeat.o(93826);
  }
  
  public final void hY(long paramLong)
  {
    AppMethodBeat.i(237825);
    if (this.nzB)
    {
      Log.e(this.TAG, "writeVideoDts, already release");
      AppMethodBeat.o(237825);
      return;
    }
    Log.i(this.TAG, s.X("writeVideoDts: ", Long.valueOf(paramLong)));
    SightVideoJNI.writeDtsDataLock(this.bufId, paramLong);
    AppMethodBeat.o(237825);
  }
  
  public final void release()
  {
    AppMethodBeat.i(93829);
    Log.i(this.TAG, "release");
    SightVideoJNI.releaseRecorderBufferRefLock("clear");
    SightVideoJNI.releaseBigSightDataBufferLock(this.bufId);
    this.nzB = true;
    AppMethodBeat.o(93829);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes9.jar
 * Qualified Name:     com.tencent.mm.media.i.h
 * JD-Core Version:    0.7.0.1
 */