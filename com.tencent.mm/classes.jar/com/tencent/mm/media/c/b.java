package com.tencent.mm.media.c;

import a.f.a.q;
import a.f.b.j;
import a.l;
import a.y;
import android.media.MediaCodec;
import android.media.MediaCodec.BufferInfo;
import android.media.MediaFormat;
import android.os.Looper;
import android.view.Surface;
import com.tencent.mm.plugin.sight.base.d;
import com.tencent.mm.sdk.platformtools.ab;
import com.tencent.mm.sdk.platformtools.bo;
import java.nio.ByteBuffer;
import java.util.concurrent.Semaphore;

@l(eaO={1, 1, 13}, eaP={""}, eaQ={"Lcom/tencent/mm/media/decoder/IMediaCodecTransDecoder;", "", "startTimeMs", "", "endTimeMs", "mediaExtractorWrapper", "Lcom/tencent/mm/media/extractor/MediaExtractorWrapper;", "decodeSurface", "Landroid/view/Surface;", "(JJLcom/tencent/mm/media/extractor/MediaExtractorWrapper;Landroid/view/Surface;)V", "TAG", "", "bFrameNum", "", "decodePts", "getDecodeSurface", "()Landroid/view/Surface;", "decoder", "Landroid/media/MediaCodec;", "getDecoder", "()Landroid/media/MediaCodec;", "setDecoder", "(Landroid/media/MediaCodec;)V", "decoderLock", "Ljava/lang/Object;", "getDecoderLock", "()Ljava/lang/Object;", "getEndTimeMs", "()J", "setEndTimeMs", "(J)V", "frameCount", "frameDropInterval", "frameDuration", "", "getFrameDuration", "()F", "setFrameDuration", "(F)V", "hasBFrame", "", "isFinished", "()Z", "setFinished", "(Z)V", "isPause", "setPause", "lastDecodePts", "getMediaExtractorWrapper", "()Lcom/tencent/mm/media/extractor/MediaExtractorWrapper;", "mediaFormat", "Landroid/media/MediaFormat;", "getMediaFormat", "()Landroid/media/MediaFormat;", "setMediaFormat", "(Landroid/media/MediaFormat;)V", "onDecodeDataCallback", "Lkotlin/Function3;", "Ljava/nio/ByteBuffer;", "Lkotlin/ParameterName;", "name", "decodeData", "pts", "Landroid/media/MediaCodec$BufferInfo;", "bufferInfo", "", "getOnDecodeDataCallback", "()Lkotlin/jvm/functions/Function3;", "setOnDecodeDataCallback", "(Lkotlin/jvm/functions/Function3;)V", "onDecodeEnd", "Lkotlin/Function0;", "getOnDecodeEnd", "()Lkotlin/jvm/functions/Function0;", "setOnDecodeEnd", "(Lkotlin/jvm/functions/Function0;)V", "onFormatChanged", "Lkotlin/Function1;", "getOnFormatChanged", "()Lkotlin/jvm/functions/Function1;", "setOnFormatChanged", "(Lkotlin/jvm/functions/Function1;)V", "pauseSemaphore", "Ljava/util/concurrent/Semaphore;", "getStartTimeMs", "setStartTimeMs", "useInRemuxer", "getUseInRemuxer", "setUseInRemuxer", "videoFps", "getVideoFps", "()I", "setVideoFps", "(I)V", "getBFrameNum", "getFrameCount", "getFrameDropInterval", "getVideoFormat", "isDecoderPause", "onDecode", "callback", "processDecodeOutputBuffer", "byteBuffer", "releaseDecoder", "setFrameDropInterval", "interval", "setPauseDecoder", "pause", "startDecode", "useInRemux", "plugin-mediaeditor_release"})
public abstract class b
{
  public final String TAG;
  long aZw;
  protected volatile boolean cvo;
  MediaCodec eRD;
  final com.tencent.mm.media.e.a eRM;
  long eRN;
  public q<? super ByteBuffer, ? super Long, ? super MediaCodec.BufferInfo, y> eRT;
  public a.f.a.a<y> eRU;
  public a.f.a.b<? super MediaFormat, y> eRV;
  public int eRW;
  private final Semaphore eRX;
  final Object eRY;
  volatile boolean eRZ;
  private float eSa;
  public boolean eSb;
  private long eSc;
  private long eSd;
  public volatile boolean eSe;
  private volatile int eSf;
  final Surface eSg;
  private int frameCount;
  public MediaFormat mediaFormat;
  private int videoFps;
  
  public b(long paramLong1, long paramLong2, com.tencent.mm.media.e.a parama, Surface paramSurface)
  {
    this.aZw = paramLong1;
    this.eRN = paramLong2;
    this.eRM = parama;
    this.eSg = paramSurface;
    this.TAG = "MicroMsg.IMediaCodecTransDecoder";
    this.eRX = new Semaphore(1);
    this.eRY = new Object();
    this.eSc = -1L;
    this.eSd = -1L;
    ab.i(this.TAG, "create IMediaCodecTransDecoder, startTimeMs:" + this.aZw + ", endTimeMs:" + this.eRN);
    parama = this.eRM;
    if (parama != null) {
      parama.UT();
    }
    if (this.aZw >= 0L)
    {
      parama = this.eRM;
      if (parama != null) {
        parama.seek(this.aZw * 1000L);
      }
    }
    this.eSf = 0;
  }
  
  protected final void a(MediaCodec.BufferInfo paramBufferInfo)
  {
    boolean bool = false;
    j.q(paramBufferInfo, "bufferInfo");
    Object localObject2;
    Object localObject1;
    if (this.videoFps <= 0)
    {
      localObject2 = this.mediaFormat;
      localObject1 = localObject2;
      if (localObject2 != null)
      {
        localObject1 = localObject2;
        if (!((MediaFormat)localObject2).containsKey("frame-rate"))
        {
          localObject1 = this.eRM;
          if (localObject1 == null) {
            break label481;
          }
          localObject1 = ((com.tencent.mm.media.e.a)localObject1).eUT;
        }
      }
      if ((localObject1 == null) || (((MediaFormat)localObject1).containsKey("frame-rate"))) {
        break label498;
      }
      localObject1 = this.eRM;
      if (localObject1 == null) {
        break label487;
      }
      localObject1 = ((com.tencent.mm.media.e.a)localObject1).filePath;
      label95:
      localObject1 = d.Zo((String)localObject1);
      if (localObject1 == null) {
        break label493;
      }
      i = ((com.tencent.mm.plugin.sight.base.a)localObject1).eRw;
      label113:
      this.videoFps = i;
      if (this.videoFps > 0) {
        this.eSa = (1000.0F / this.videoFps);
      }
    }
    if (this.videoFps <= 0) {}
    for (int i = 0;; i = 1)
    {
      long l = (((float)this.aZw + this.frameCount * this.eSa) * 1000.0F);
      this.eSc = paramBufferInfo.presentationTimeUs;
      this.frameCount += 1;
      localObject1 = this.TAG;
      localObject2 = new StringBuilder("processDecodeOutputBuffer, byteBuffer: ").append(null).append(", pts: ").append(paramBufferInfo.presentationTimeUs).append(", calcPts:").append(l).append(", frameDuration:").append(this.eSa).append(", frameCount:").append(this.frameCount).append(", startTimeMs:").append(this.aZw).append(", size: ").append(paramBufferInfo.size).append(", isKeyFrame:");
      if ((paramBufferInfo.flags & 0x1) == 1) {
        bool = true;
      }
      ab.i((String)localObject1, bool + ", isMain:" + j.e(Looper.myLooper(), Looper.getMainLooper()));
      if ((this.eSd > 0L) && (this.eSc < this.eSd))
      {
        this.eSe = true;
        this.eSf += 1;
        ab.i(this.TAG, "processDecodeOutputBuffer has B Frame, decodePts:" + this.eSc + ", lastDecodePts:" + this.eSd + ", bFrameNum:" + this.eSf);
      }
      this.eSd = this.eSc;
      ab.d(this.TAG, "jump one frame: " + this.frameCount);
      if ((this.eRW > 1) && (this.frameCount % this.eRW == 0)) {}
      label481:
      label487:
      label493:
      label498:
      do
      {
        do
        {
          return;
          localObject1 = null;
          break;
          localObject1 = null;
          break label95;
          i = 0;
          break label113;
          if (localObject1 != null) {}
          for (i = ((MediaFormat)localObject1).getInteger("frame-rate");; i = 0)
          {
            this.videoFps = i;
            break;
          }
          if (i == 0) {
            break label555;
          }
          localObject1 = this.eRT;
        } while (localObject1 == null);
        ((q)localObject1).d(null, Long.valueOf(l), paramBufferInfo);
        return;
        localObject1 = this.eRT;
      } while (localObject1 == null);
      label555:
      ((q)localObject1).d(null, Long.valueOf(paramBufferInfo.presentationTimeUs), paramBufferInfo);
      return;
    }
  }
  
  public void cy(boolean paramBoolean)
  {
    long l = bo.yB();
    this.cvo = paramBoolean;
    ab.d(this.TAG, "setPauseDecoder:" + paramBoolean + ", remain:" + this.eRX.availablePermits() + ", thread:" + Thread.currentThread() + ' ' + l);
    if (paramBoolean)
    {
      ab.d(this.TAG, "try acquire, thread:" + Thread.currentThread() + ' ' + l);
      this.eRX.acquire();
    }
    for (;;)
    {
      ab.d(this.TAG, "after setPauseDecoder:" + paramBoolean + ", remain:" + this.eRX.availablePermits() + ", thread:" + Thread.currentThread() + ' ' + l);
      return;
      ab.d(this.TAG, "release, thread:" + Thread.currentThread() + ' ' + l);
      this.eRX.release();
    }
  }
  
  public void pJ()
  {
    ab.i(this.TAG, "releaseDecoder  " + hashCode());
    synchronized (this.eRY)
    {
      try
      {
        Object localObject2 = this.eRD;
        if (localObject2 != null) {
          ((MediaCodec)localObject2).stop();
        }
        localObject2 = this.eRD;
        if (localObject2 != null) {
          ((MediaCodec)localObject2).release();
        }
        this.eRZ = true;
        localObject2 = this.eSg;
        if (localObject2 != null)
        {
          ((Surface)localObject2).release();
          localObject2 = y.BMg;
        }
      }
      catch (Exception localException)
      {
        for (;;)
        {
          y localy = y.BMg;
        }
      }
      return;
    }
  }
  
  public abstract void startDecode();
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes9.jar
 * Qualified Name:     com.tencent.mm.media.c.b
 * JD-Core Version:    0.7.0.1
 */