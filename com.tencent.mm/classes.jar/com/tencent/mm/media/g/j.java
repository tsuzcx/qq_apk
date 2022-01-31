package com.tencent.mm.media.g;

import a.l;
import android.media.MediaExtractor;
import android.media.MediaFormat;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.media.e.a;
import com.tencent.mm.media.i.c;
import com.tencent.mm.plugin.sight.base.SightVideoJNI;
import com.tencent.mm.plugin.sight.base.b;
import com.tencent.mm.sdk.platformtools.ab;
import com.tencent.mm.sdk.platformtools.bo;
import java.nio.ByteBuffer;

@l(eaO={1, 1, 13}, eaP={""}, eaQ={"Lcom/tencent/mm/media/remuxer/MixMuxerController;", "", "remuxStartTime", "", "remuxEndTime", "outputBitrate", "", "outputVideoWidth", "outputVideoHeight", "useX264Encode", "", "outputFps", "", "(JJIIIZF)V", "(JJIZ)V", "TAG", "", "aacSampleRate", "bufId", "channelCount", "duration", "frameCount", "isRelease", "getRemuxEndTime", "()J", "getRemuxStartTime", "getBufID", "output", "mediaExtractor", "Lcom/tencent/mm/media/extractor/MediaExtractorWrapper;", "muxOuputFilePath", "sampleRate", "mute", "release", "", "writeAudioData", "startTime", "endTime", "encodeData", "Ljava/nio/ByteBuffer;", "size", "writeVideoData", "plugin-mediaeditor_release"})
public final class j
{
  final String TAG;
  private int duration;
  public int eRm;
  boolean eUY;
  public final long eWM;
  public final long eWN;
  private float eXU;
  private int eXV;
  private int eXW;
  private final int eXq;
  private final boolean eXv;
  int frameCount;
  
  public j(long paramLong1, long paramLong2, int paramInt1, int paramInt2, int paramInt3, boolean paramBoolean, float paramFloat)
  {
    this(paramLong1, paramLong2, paramInt1, paramBoolean);
    AppMethodBeat.i(155538);
    this.eXU = paramFloat;
    this.eXV = paramInt2;
    this.eXW = paramInt3;
    ab.i(this.TAG, "secondary create MixMuxerController, outputFps:" + paramFloat + ", outputVideoWidth:" + paramInt2 + ", outputVideoHeight:" + paramInt3);
    this.duration = ((int)(paramLong2 - paramLong1));
    if (this.duration != 0) {
      if (!paramBoolean) {
        break label197;
      }
    }
    label197:
    for (this.eRm = SightVideoJNI.initDataBufferForMMSightLock(paramInt2, paramInt3, 0, paramInt2, paramInt3, paramFloat, paramInt1, 1, 8, 2, 23.0F, false, true, this.duration, false);; this.eRm = SightVideoJNI.initDataBufferForRemux())
    {
      this.eUY = false;
      ab.i(this.TAG, "secondary init endTime:" + paramLong2 + ", startTime:" + paramLong1 + ", duration:" + this.duration + ", bufId:" + this.eRm);
      AppMethodBeat.o(155538);
      return;
    }
  }
  
  public j(long paramLong1, long paramLong2, int paramInt, boolean paramBoolean)
  {
    AppMethodBeat.i(155537);
    this.eWM = paramLong1;
    this.eWN = paramLong2;
    this.eXq = paramInt;
    this.eXv = paramBoolean;
    this.TAG = "MicroMsg.MixMuxerController";
    this.duration = ((int)(this.eWN - this.eWM));
    if ((this.duration != 0) && (!this.eXv)) {
      this.eRm = SightVideoJNI.initDataBufferForRemux();
    }
    this.eUY = false;
    ab.i(this.TAG, "init endTime:" + this.eWN + ", startTime:" + this.eWM + ", duration:" + this.duration + ", bufId:" + this.eRm);
    AppMethodBeat.o(155537);
  }
  
  private void a(a parama, long paramLong1, long paramLong2)
  {
    AppMethodBeat.i(13081);
    if (parama == null)
    {
      AppMethodBeat.o(13081);
      return;
    }
    if (this.eUY)
    {
      ab.e(this.TAG, "writeAudioData, already release");
      AppMethodBeat.o(13081);
      return;
    }
    if (parama.eUY)
    {
      ab.e(this.TAG, "writeAudioData, mediaExtractor already release");
      AppMethodBeat.o(13081);
      return;
    }
    int j = parama.eUS;
    Object localObject = parama.UW();
    MediaFormat localMediaFormat = parama.eUU;
    if ((j >= 0) && (localMediaFormat != null) && (!bo.isNullOrNil((String)localObject)))
    {
      ab.i(this.TAG, "writeAudioData, startTime: ".concat(String.valueOf(paramLong1)));
      parama.UU();
      if (paramLong1 > 0L)
      {
        ab.i(this.TAG, "writeAudioData, seek to startTime:" + this.eWM);
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
          a.f.b.j.p(localObject, "dstBuf");
          parama.g((ByteBuffer)localObject);
          i = parama.sampleSize;
          ab.d(this.TAG, "sampleSize: %d", new Object[] { Integer.valueOf(i) });
          if (i > 0) {
            break label301;
          }
          ab.i(this.TAG, "muxAudio size = %d. Saw eos.", new Object[] { Integer.valueOf(i) });
          AppMethodBeat.o(13081);
          return;
        }
        catch (Exception parama)
        {
          ab.printErrStackTrace(this.TAG, (Throwable)parama, "writeAudioData error", new Object[0]);
          AppMethodBeat.o(13081);
          return;
        }
        i = 1024;
        break;
        label301:
        long l = parama.getSampleTime();
        ab.i(this.TAG, "aac pts:".concat(String.valueOf(l)));
        if ((l >= 1000L * paramLong2) || (l < 0L))
        {
          ab.i(this.TAG, "pts exceed endTime");
          AppMethodBeat.o(13081);
          return;
        }
        if (parama.mediaExtractor.getSampleTrackIndex() != j)
        {
          ab.e(this.TAG, "track index not match! break");
          AppMethodBeat.o(13081);
          return;
        }
        if (l < 1000L * paramLong1)
        {
          ab.i(this.TAG, "not reach start");
        }
        else
        {
          ((ByteBuffer)localObject).position(0);
          c((ByteBuffer)localObject, i);
        }
      }
    }
    AppMethodBeat.o(13081);
  }
  
  private void release()
  {
    AppMethodBeat.i(13080);
    SightVideoJNI.releaseRecorderBufferRef("clear");
    SightVideoJNI.releaseBigSightDataBufferLock(this.eRm);
    this.eUY = true;
    AppMethodBeat.o(13080);
  }
  
  public final int a(a parama, String paramString, int paramInt1, int paramInt2, boolean paramBoolean)
  {
    AppMethodBeat.i(13079);
    a.f.b.j.q(paramString, "muxOuputFilePath");
    if (this.eUY)
    {
      ab.e(this.TAG, "output, already release");
      AppMethodBeat.o(13079);
      return -1;
    }
    if ((this.frameCount <= 0) && (!this.eXv))
    {
      ab.e(this.TAG, "output, no write h264 frame!!");
      parama = c.eZC;
      c.WC();
      AppMethodBeat.o(13079);
      return -1;
    }
    ab.i(this.TAG, "sampelRate:" + paramInt1 + ", channelCount:" + paramInt2);
    boolean bool = false;
    int i;
    if ((paramInt1 == 0) || (paramInt2 == 0)) {
      if (parama != null)
      {
        i = parama.eUS;
        String str = parama.UW();
        MediaFormat localMediaFormat = parama.eUU;
        if ((i >= 0) && (localMediaFormat != null) && (!bo.isNullOrNil(str)))
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
        ab.i(this.TAG, "output, fps:" + f + ", frameCount:" + this.frameCount + ", outputBitrate:" + this.eXq + ", finalChannelCount:" + paramInt2 + ", finalSampleRate:" + paramInt1 + ", outputPath:" + paramString + ", bufId:" + this.eRm + ", mute:" + paramBoolean + ", videoMute:" + bool + ", mediaExtractor:" + parama);
        i = this.eRm;
        int j = Math.max(1000, this.duration);
        int k = this.eXq;
        int m = b.qSn;
        if ((paramBoolean) || (bool)) {}
        for (paramBoolean = true;; paramBoolean = false)
        {
          paramInt1 = SightVideoJNI.muxingLock(i, null, paramInt1, 1024, 2, paramInt2, 0L, paramString, f, j, k, m, 8, 2, 23.0F, null, 0, false, paramBoolean);
          release();
          if (paramInt1 < 0)
          {
            parama = c.eZC;
            c.WD();
          }
          AppMethodBeat.o(13079);
          return paramInt1;
          bool = true;
          break;
        }
      }
    }
  }
  
  public final void c(ByteBuffer paramByteBuffer, int paramInt)
  {
    AppMethodBeat.i(13078);
    a.f.b.j.q(paramByteBuffer, "encodeData");
    if (this.eUY)
    {
      ab.e(this.TAG, "writeAACData, already release");
      AppMethodBeat.o(13078);
      return;
    }
    ab.i(this.TAG, "writeAACData: " + paramByteBuffer.capacity() + ", " + paramInt + ", bufId:" + this.eRm);
    SightVideoJNI.writeAACDataLock(this.eRm, paramByteBuffer, paramInt);
    AppMethodBeat.o(13078);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.media.g.j
 * JD-Core Version:    0.7.0.1
 */