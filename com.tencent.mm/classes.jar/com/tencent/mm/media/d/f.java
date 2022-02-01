package com.tencent.mm.media.d;

import android.media.MediaCodec.BufferInfo;
import android.media.MediaFormat;
import android.os.Looper;
import android.view.Surface;
import com.tencent.mm.plugin.report.service.g;
import com.tencent.mm.plugin.sight.base.e;
import com.tencent.mm.sdk.platformtools.ad;
import com.tencent.mm.sdk.platformtools.bt;
import d.a.j;
import d.g.a.r;
import d.g.b.p;
import d.l;
import d.o;
import java.nio.ByteBuffer;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.PriorityQueue;
import java.util.concurrent.Semaphore;

@l(gfx={1, 1, 16}, gfy={""}, gfz={"Lcom/tencent/mm/media/decoder/IMediaCodecTransDecoder;", "", "startTimeMs", "", "endTimeMs", "mediaExtractorWrapper", "Lcom/tencent/mm/media/extractor/MediaExtractorWrapper;", "decodeSurface", "Landroid/view/Surface;", "outputFps", "", "(JJLcom/tencent/mm/media/extractor/MediaExtractorWrapper;Landroid/view/Surface;I)V", "TAG", "", "bFrameNum", "decodeHelper", "Lcom/tencent/mm/media/decoder/DecodeHelper;", "getDecodeHelper", "()Lcom/tencent/mm/media/decoder/DecodeHelper;", "setDecodeHelper", "(Lcom/tencent/mm/media/decoder/DecodeHelper;)V", "decodePts", "getDecodeSurface", "()Landroid/view/Surface;", "setDecodeSurface", "(Landroid/view/Surface;)V", "decoder", "Lcom/tencent/mm/compatible/deviceinfo/MediaCodecProxy;", "getDecoder", "()Lcom/tencent/mm/compatible/deviceinfo/MediaCodecProxy;", "setDecoder", "(Lcom/tencent/mm/compatible/deviceinfo/MediaCodecProxy;)V", "decoderLock", "Ljava/lang/Object;", "getDecoderLock", "()Ljava/lang/Object;", "getEndTimeMs", "()J", "setEndTimeMs", "(J)V", "frameCount", "frameDropInterval", "frameDuration", "", "getFrameDuration", "()F", "setFrameDuration", "(F)V", "hasBFrame", "", "isFinished", "()Z", "setFinished", "(Z)V", "isPause", "setPause", "lastDecodePts", "getMediaExtractorWrapper", "()Lcom/tencent/mm/media/extractor/MediaExtractorWrapper;", "mediaFormat", "Landroid/media/MediaFormat;", "getMediaFormat", "()Landroid/media/MediaFormat;", "setMediaFormat", "(Landroid/media/MediaFormat;)V", "onDecodeDataCallback", "Lkotlin/Function4;", "Ljava/nio/ByteBuffer;", "Lkotlin/ParameterName;", "name", "decodeData", "pts", "Landroid/media/MediaCodec$BufferInfo;", "bufferInfo", "duplicate", "", "getOnDecodeDataCallback", "()Lkotlin/jvm/functions/Function4;", "setOnDecodeDataCallback", "(Lkotlin/jvm/functions/Function4;)V", "onDecodeEnd", "Lkotlin/Function0;", "getOnDecodeEnd", "()Lkotlin/jvm/functions/Function0;", "setOnDecodeEnd", "(Lkotlin/jvm/functions/Function0;)V", "onDecodeError", "getOnDecodeError", "setOnDecodeError", "onFormatChanged", "Lkotlin/Function1;", "getOnFormatChanged", "()Lkotlin/jvm/functions/Function1;", "setOnFormatChanged", "(Lkotlin/jvm/functions/Function1;)V", "pauseSemaphore", "Ljava/util/concurrent/Semaphore;", "ptsList", "Ljava/util/ArrayList;", "Lkotlin/collections/ArrayList;", "getStartTimeMs", "setStartTimeMs", "useInRemuxer", "getUseInRemuxer", "setUseInRemuxer", "videoFps", "getVideoFps", "()I", "setVideoFps", "(I)V", "getBFrameNum", "getFrameCount", "getFrameDropInterval", "getVideoFormat", "isDecoderPause", "onDecode", "callback", "processDecodeOutputBuffer", "bufferIndex", "releaseDecoder", "setFrameDropInterval", "interval", "setPauseDecoder", "pause", "startDecode", "useInRemux", "plugin-mediaeditor_release"})
public abstract class f
{
  public final String TAG;
  protected volatile boolean dtm;
  private int frameCount;
  volatile boolean gGM;
  public r<? super ByteBuffer, ? super Long, ? super MediaCodec.BufferInfo, ? super Boolean, d.z> hiE;
  public d.g.a.a<d.z> hiF;
  public d.g.a.b<? super MediaFormat, d.z> hiG;
  public d.g.a.a<d.z> hiH;
  public int hiI;
  private final Semaphore hiJ;
  final Object hiK;
  private float hiL;
  private b hiM;
  public boolean hiN;
  private long hiO;
  private long hiP;
  private volatile boolean hiQ;
  private volatile int hiR;
  private ArrayList<Long> hiS;
  protected Surface hiT;
  com.tencent.mm.compatible.deviceinfo.z hir;
  final com.tencent.mm.media.f.a hix;
  long hiy;
  public MediaFormat mediaFormat;
  long startTimeMs;
  private int videoFps;
  
  public f(long paramLong1, long paramLong2, com.tencent.mm.media.f.a parama, Surface paramSurface, int paramInt)
  {
    this.startTimeMs = paramLong1;
    this.hiy = paramLong2;
    this.hix = parama;
    this.hiT = paramSurface;
    this.TAG = "MicroMsg.IMediaCodecTransDecoder";
    this.hiJ = new Semaphore(1);
    this.hiK = new Object();
    this.hiO = -1L;
    this.hiP = -1L;
    this.hiS = new ArrayList();
    ad.i(this.TAG, "create IMediaCodecTransDecoder, startTimeMs:" + this.startTimeMs + ", endTimeMs:" + this.hiy);
    parama = this.hix;
    if (parama != null) {
      parama.atz();
    }
    if (this.startTimeMs >= 0L)
    {
      parama = this.hix;
      if (parama != null) {
        parama.seek(this.startTimeMs * 1000L);
      }
    }
    parama = this.hix;
    if (parama != null) {}
    for (parama = parama.filePath;; parama = null)
    {
      this.hiM = new b(parama, paramInt, this.startTimeMs * 1000L);
      this.hiR = 0;
      return;
    }
  }
  
  protected final void a(int paramInt, MediaCodec.BufferInfo paramBufferInfo)
  {
    boolean bool4 = true;
    boolean bool3 = true;
    p.h(paramBufferInfo, "bufferInfo");
    Object localObject2;
    Object localObject1;
    label102:
    int i;
    if (this.videoFps <= 0)
    {
      localObject2 = this.mediaFormat;
      localObject1 = localObject2;
      if (localObject2 != null)
      {
        localObject1 = localObject2;
        if (!((MediaFormat)localObject2).containsKey("frame-rate"))
        {
          localObject1 = this.hix;
          if (localObject1 == null) {
            break label722;
          }
          localObject1 = ((com.tencent.mm.media.f.a)localObject1).hka;
        }
      }
      if ((localObject1 == null) || (((MediaFormat)localObject1).containsKey("frame-rate"))) {
        break label739;
      }
      localObject1 = this.hix;
      if (localObject1 == null) {
        break label728;
      }
      localObject1 = ((com.tencent.mm.media.f.a)localObject1).filePath;
      localObject1 = e.axx((String)localObject1);
      if (localObject1 == null) {
        break label734;
      }
      i = ((com.tencent.mm.plugin.sight.base.a)localObject1).frameRate;
      label120:
      this.videoFps = i;
      if (this.videoFps > 0) {
        this.hiL = (1000.0F / this.videoFps);
      }
    }
    if (this.videoFps <= 0) {
      g.yhR.A(986L, 104L);
    }
    for (boolean bool1 = false;; bool1 = true)
    {
      this.frameCount += 1;
      this.hiO = paramBufferInfo.presentationTimeUs;
      localObject1 = this.TAG;
      localObject2 = new StringBuilder("processDecodeOutputBuffer, usePts:").append(bool1).append(", pts: ").append(paramBufferInfo.presentationTimeUs).append(", frameDuration:").append(this.hiL).append(", frameCount:").append(this.frameCount).append(", startTimeMs:").append(this.startTimeMs).append(", size: ").append(paramBufferInfo.size).append(", isKeyFrame:");
      boolean bool2;
      label292:
      long l1;
      if ((paramBufferInfo.flags & 0x1) == 1)
      {
        bool2 = true;
        ad.i((String)localObject1, bool2 + ", isMain:" + p.i(Looper.myLooper(), Looper.getMainLooper()));
        if ((this.hiP > 0L) && (this.hiO < this.hiP))
        {
          this.hiQ = true;
          this.hiR += 1;
          ad.i(this.TAG, "processDecodeOutputBuffer has B Frame, decodePts:" + this.hiO + ", lastDecodePts:" + this.hiP + ", bFrameNum:" + this.hiR);
        }
        this.hiP = this.hiO;
        if (!bool1) {
          break label1371;
        }
        l1 = paramBufferInfo.presentationTimeUs;
        localObject1 = this.hiM;
        ad.i("DecodeHelper", "sendPacket, pts:" + l1 + ", recentPts:" + ((b)localObject1).hif + ", parents[" + l1 + "]:" + (Long)((b)localObject1).hih.get(Long.valueOf(l1)) + ", lastPts:" + ((b)localObject1).hig);
        if ((l1 == ((b)localObject1).hif) || ((l1 <= ((b)localObject1).hig) && (!((Map)((b)localObject1).hih).containsKey(Long.valueOf(l1))))) {
          break label772;
        }
        ((b)localObject1).bHb.add(new o(Long.valueOf(l1), Integer.valueOf(paramInt)));
        i = 1;
      }
      int k;
      for (;;)
      {
        if (i == 0)
        {
          ad.i(this.TAG, "processDecodeOutputBuffer sendPacket return false");
          localObject1 = this.hir;
          if (localObject1 != null) {
            ((com.tencent.mm.compatible.deviceinfo.z)localObject1).releaseOutputBuffer(paramInt, false);
          }
          k = 1;
          if (k == 0)
          {
            ad.e(this.TAG, "processDecodeOutputBuffer still not release buffer fallback release it");
            localObject1 = this.hir;
            if (localObject1 != null)
            {
              if (this.hiT == null) {
                break label1322;
              }
              bool1 = bool3;
              label669:
              ((com.tencent.mm.compatible.deviceinfo.z)localObject1).releaseOutputBuffer(paramInt, bool1);
            }
            if (!this.hiS.contains(Long.valueOf(l1))) {
              break label1328;
            }
            localObject1 = this.hiE;
            if (localObject1 != null) {
              ((r)localObject1).a(null, Long.valueOf(l1), paramBufferInfo, Boolean.TRUE);
            }
          }
          label721:
          return;
          label722:
          localObject1 = null;
          break;
          label728:
          localObject1 = null;
          break label102;
          label734:
          i = 0;
          break label120;
          label739:
          if (localObject1 != null) {}
          for (i = ((MediaFormat)localObject1).getInteger("frame-rate");; i = 0)
          {
            this.videoFps = i;
            break;
          }
          bool2 = false;
          break label292;
          label772:
          i = 0;
          continue;
          label777:
          i = 1;
        }
      }
      for (;;)
      {
        localObject1 = this.hiM;
        int j;
        long l2;
        if (!((Collection)((b)localObject1).bHb).isEmpty())
        {
          j = 1;
          if (j == 0) {
            break label1242;
          }
          l2 = ((Number)((o)((b)localObject1).bHb.peek()).first).longValue();
          if (l2 <= ((b)localObject1).hig) {
            break label1212;
          }
          j = 1;
          label845:
          k = i;
          if (j == 0) {
            break;
          }
          ad.i(this.TAG, "decode hasFrame");
          localObject1 = this.hiM;
          localObject2 = (o)((b)localObject1).bHb.poll();
          l2 = ((Number)((o)localObject2).first).longValue();
          j = ((Number)((o)localObject2).second).intValue();
          ((b)localObject1).hif = l2;
          localObject2 = ((Map)((b)localObject1).hii).get(Long.valueOf(l2));
          localObject1 = localObject2;
          if (localObject2 == null) {
            localObject1 = j.listOf(Long.valueOf(l2));
          }
          localObject2 = new o(localObject1, Integer.valueOf(j));
          localObject1 = (List)((o)localObject2).first;
          k = ((Number)((o)localObject2).second).intValue();
          ad.i(this.TAG, "processDecodeOutputBuffer, duplicate frame size:" + ((List)localObject1).size() + ", bufferInfo pts:" + paramBufferInfo.presentationTimeUs);
          if (((Collection)localObject1).isEmpty()) {
            break label1265;
          }
          j = 1;
          label1052:
          if (j == 0) {
            break label1439;
          }
          localObject2 = this.hir;
          if (localObject2 != null)
          {
            if (this.hiT == null) {
              break label1271;
            }
            bool1 = true;
            label1078:
            ((com.tencent.mm.compatible.deviceinfo.z)localObject2).releaseOutputBuffer(k, bool1);
          }
          localObject1 = ((Iterable)localObject1).iterator();
        }
        for (;;)
        {
          if (!((Iterator)localObject1).hasNext()) {
            break label1320;
          }
          l2 = ((Number)((Iterator)localObject1).next()).longValue();
          ad.i(this.TAG, "processDecodeOutputBuffer, duplicate frame, pts: " + l2 + ", bufferInfo: " + paramBufferInfo);
          if (this.hiS.contains(Long.valueOf(l1)))
          {
            localObject2 = this.hiE;
            if (localObject2 == null) {
              continue;
            }
            ((r)localObject2).a(null, Long.valueOf(l1), paramBufferInfo, Boolean.TRUE);
            continue;
            j = 0;
            break;
            label1212:
            localObject2 = (Long)((b)localObject1).hih.get(Long.valueOf(l2));
            l2 = ((b)localObject1).hif;
            if (localObject2 == null) {}
            label1242:
            while (((Long)localObject2).longValue() != l2)
            {
              j = 0;
              break;
            }
            j = 1;
            break label845;
            label1265:
            j = 0;
            break label1052;
            label1271:
            bool1 = false;
            break label1078;
          }
          this.hiS.add(Long.valueOf(l1));
          localObject2 = this.hiE;
          if (localObject2 != null) {
            ((r)localObject2).a(null, Long.valueOf(l1), paramBufferInfo, Boolean.FALSE);
          }
        }
        label1320:
        break label777;
        label1322:
        bool1 = false;
        break label669;
        label1328:
        this.hiS.add(Long.valueOf(l1));
        localObject1 = this.hiE;
        if (localObject1 == null) {
          break label721;
        }
        ((r)localObject1).a(null, Long.valueOf(l1), paramBufferInfo, Boolean.FALSE);
        return;
        label1371:
        localObject1 = this.hir;
        if (localObject1 != null) {
          if (this.hiT == null) {
            break label1433;
          }
        }
        label1433:
        for (bool1 = bool4;; bool1 = false)
        {
          ((com.tencent.mm.compatible.deviceinfo.z)localObject1).releaseOutputBuffer(paramInt, bool1);
          localObject1 = this.hiE;
          if (localObject1 == null) {
            break;
          }
          ((r)localObject1).a(null, Long.valueOf(paramBufferInfo.presentationTimeUs), paramBufferInfo, Boolean.FALSE);
          return;
        }
        label1439:
        continue;
        i = 0;
      }
    }
  }
  
  public void eb(boolean paramBoolean)
  {
    long l = bt.HI();
    this.dtm = paramBoolean;
    ad.d(this.TAG, "setPauseDecoder:" + paramBoolean + ", remain:" + this.hiJ.availablePermits() + ", thread:" + Thread.currentThread() + ' ' + l);
    if (paramBoolean)
    {
      ad.d(this.TAG, "try acquire, thread:" + Thread.currentThread() + ' ' + l);
      this.hiJ.acquire();
    }
    for (;;)
    {
      ad.d(this.TAG, "after setPauseDecoder:" + paramBoolean + ", remain:" + this.hiJ.availablePermits() + ", thread:" + Thread.currentThread() + ' ' + l);
      return;
      ad.d(this.TAG, "release, thread:" + Thread.currentThread() + ' ' + l);
      this.hiJ.release();
    }
  }
  
  /* Error */
  public void releaseDecoder()
  {
    // Byte code:
    //   0: aload_0
    //   1: getfield 185	com/tencent/mm/media/d/f:TAG	Ljava/lang/String;
    //   4: new 206	java/lang/StringBuilder
    //   7: dup
    //   8: ldc_w 572
    //   11: invokespecial 211	java/lang/StringBuilder:<init>	(Ljava/lang/String;)V
    //   14: aload_0
    //   15: invokevirtual 575	com/tencent/mm/media/d/f:hashCode	()I
    //   18: invokevirtual 329	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   21: invokevirtual 224	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   24: invokestatic 230	com/tencent/mm/sdk/platformtools/ad:i	(Ljava/lang/String;Ljava/lang/String;)V
    //   27: aload_0
    //   28: getfield 193	com/tencent/mm/media/d/f:hiK	Ljava/lang/Object;
    //   31: astore_1
    //   32: aload_1
    //   33: monitorenter
    //   34: aload_0
    //   35: getfield 250	com/tencent/mm/media/d/f:hiM	Lcom/tencent/mm/media/d/b;
    //   38: getfield 409	com/tencent/mm/media/d/b:bHb	Ljava/util/PriorityQueue;
    //   41: invokevirtual 578	java/util/PriorityQueue:clear	()V
    //   44: aload_0
    //   45: getfield 428	com/tencent/mm/media/d/f:hir	Lcom/tencent/mm/compatible/deviceinfo/z;
    //   48: astore_2
    //   49: aload_2
    //   50: ifnull +7 -> 57
    //   53: aload_2
    //   54: invokevirtual 581	com/tencent/mm/compatible/deviceinfo/z:stop	()V
    //   57: aload_0
    //   58: getfield 185	com/tencent/mm/media/d/f:TAG	Ljava/lang/String;
    //   61: ldc_w 583
    //   64: invokestatic 230	com/tencent/mm/sdk/platformtools/ad:i	(Ljava/lang/String;Ljava/lang/String;)V
    //   67: aload_0
    //   68: getfield 428	com/tencent/mm/media/d/f:hir	Lcom/tencent/mm/compatible/deviceinfo/z;
    //   71: astore_2
    //   72: aload_2
    //   73: ifnull +7 -> 80
    //   76: aload_2
    //   77: invokevirtual 584	com/tencent/mm/compatible/deviceinfo/z:release	()V
    //   80: aload_0
    //   81: getfield 185	com/tencent/mm/media/d/f:TAG	Ljava/lang/String;
    //   84: ldc_w 586
    //   87: invokestatic 230	com/tencent/mm/sdk/platformtools/ad:i	(Ljava/lang/String;Ljava/lang/String;)V
    //   90: aload_0
    //   91: iconst_1
    //   92: putfield 588	com/tencent/mm/media/d/f:gGM	Z
    //   95: aload_0
    //   96: getfield 181	com/tencent/mm/media/d/f:hiT	Landroid/view/Surface;
    //   99: astore_2
    //   100: aload_2
    //   101: ifnull +7 -> 108
    //   104: aload_2
    //   105: invokevirtual 591	android/view/Surface:release	()V
    //   108: aload_0
    //   109: getfield 185	com/tencent/mm/media/d/f:TAG	Ljava/lang/String;
    //   112: ldc_w 593
    //   115: invokestatic 230	com/tencent/mm/sdk/platformtools/ad:i	(Ljava/lang/String;Ljava/lang/String;)V
    //   118: getstatic 599	d/z:MKo	Ld/z;
    //   121: astore_2
    //   122: aload_1
    //   123: monitorexit
    //   124: return
    //   125: astore_2
    //   126: aload_1
    //   127: monitorexit
    //   128: aload_2
    //   129: athrow
    //   130: astore_2
    //   131: goto -13 -> 118
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	134	0	this	f
    //   48	74	2	localObject2	Object
    //   125	4	2	localObject3	Object
    //   130	1	2	localException	java.lang.Exception
    // Exception table:
    //   from	to	target	type
    //   34	49	125	finally
    //   53	57	125	finally
    //   57	72	125	finally
    //   76	80	125	finally
    //   80	100	125	finally
    //   104	108	125	finally
    //   108	118	125	finally
    //   118	122	125	finally
    //   34	49	130	java/lang/Exception
    //   53	57	130	java/lang/Exception
    //   57	72	130	java/lang/Exception
    //   76	80	130	java/lang/Exception
    //   80	100	130	java/lang/Exception
    //   104	108	130	java/lang/Exception
    //   108	118	130	java/lang/Exception
  }
  
  public abstract void startDecode();
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.media.d.f
 * JD-Core Version:    0.7.0.1
 */