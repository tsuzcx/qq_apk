package com.tencent.mm.media.d;

import android.media.MediaCodec.BufferInfo;
import android.media.MediaFormat;
import android.os.Looper;
import android.view.Surface;
import com.tencent.mm.compatible.deviceinfo.aa;
import com.tencent.mm.plugin.report.service.h;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.Util;
import java.nio.ByteBuffer;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.PriorityQueue;
import java.util.concurrent.Semaphore;
import kotlin.a.j;
import kotlin.g.a.r;
import kotlin.g.b.p;
import kotlin.l;
import kotlin.o;
import kotlin.x;

@l(iBK={1, 1, 16}, iBL={""}, iBM={"Lcom/tencent/mm/media/decoder/IMediaCodecTransDecoder;", "", "startTimeMs", "", "endTimeMs", "mediaExtractorWrapper", "Lcom/tencent/mm/media/extractor/MediaExtractorWrapper;", "decodeSurface", "Landroid/view/Surface;", "outputFps", "", "enableHevc", "", "(JJLcom/tencent/mm/media/extractor/MediaExtractorWrapper;Landroid/view/Surface;IZ)V", "TAG", "", "bFrameNum", "decodeHelper", "Lcom/tencent/mm/media/decoder/DecodeHelper;", "getDecodeHelper", "()Lcom/tencent/mm/media/decoder/DecodeHelper;", "setDecodeHelper", "(Lcom/tencent/mm/media/decoder/DecodeHelper;)V", "decodePts", "getDecodeSurface", "()Landroid/view/Surface;", "setDecodeSurface", "(Landroid/view/Surface;)V", "decoder", "Lcom/tencent/mm/compatible/deviceinfo/MediaCodecProxy;", "getDecoder", "()Lcom/tencent/mm/compatible/deviceinfo/MediaCodecProxy;", "setDecoder", "(Lcom/tencent/mm/compatible/deviceinfo/MediaCodecProxy;)V", "decoderLock", "Ljava/lang/Object;", "getDecoderLock", "()Ljava/lang/Object;", "getEndTimeMs", "()J", "setEndTimeMs", "(J)V", "frameCount", "frameDropInterval", "frameDuration", "", "getFrameDuration", "()F", "setFrameDuration", "(F)V", "hasBFrame", "isFinished", "()Z", "setFinished", "(Z)V", "isPause", "setPause", "lastDecodePts", "getMediaExtractorWrapper", "()Lcom/tencent/mm/media/extractor/MediaExtractorWrapper;", "mediaFormat", "Landroid/media/MediaFormat;", "getMediaFormat", "()Landroid/media/MediaFormat;", "setMediaFormat", "(Landroid/media/MediaFormat;)V", "onDecodeDataCallback", "Lkotlin/Function4;", "Ljava/nio/ByteBuffer;", "Lkotlin/ParameterName;", "name", "decodeData", "pts", "Landroid/media/MediaCodec$BufferInfo;", "bufferInfo", "duplicate", "", "getOnDecodeDataCallback", "()Lkotlin/jvm/functions/Function4;", "setOnDecodeDataCallback", "(Lkotlin/jvm/functions/Function4;)V", "onDecodeEnd", "Lkotlin/Function0;", "getOnDecodeEnd", "()Lkotlin/jvm/functions/Function0;", "setOnDecodeEnd", "(Lkotlin/jvm/functions/Function0;)V", "onDecodeError", "getOnDecodeError", "setOnDecodeError", "onFormatChanged", "Lkotlin/Function1;", "getOnFormatChanged", "()Lkotlin/jvm/functions/Function1;", "setOnFormatChanged", "(Lkotlin/jvm/functions/Function1;)V", "pauseSemaphore", "Ljava/util/concurrent/Semaphore;", "ptsList", "Ljava/util/ArrayList;", "Lkotlin/collections/ArrayList;", "getStartTimeMs", "setStartTimeMs", "useInRemuxer", "getUseInRemuxer", "setUseInRemuxer", "videoFps", "getVideoFps", "()I", "setVideoFps", "(I)V", "getBFrameNum", "getFrameCount", "getFrameDropInterval", "getVideoFormat", "invokeDecodeCallback", "callbackPts", "isDecoderPause", "onDecode", "callback", "processDecodeOutputBuffer", "bufferIndex", "releaseDecoder", "setFrameDropInterval", "interval", "setPauseDecoder", "pause", "startDecode", "useInRemux", "plugin-mediaeditor_release"})
public abstract class f
{
  public final String TAG;
  long endTimeMs;
  private volatile boolean fEs;
  private int frameCount;
  volatile boolean isFinished;
  aa kSN;
  private final com.tencent.mm.media.f.a kSW;
  public r<? super ByteBuffer, ? super Long, ? super MediaCodec.BufferInfo, ? super Boolean, x> kTc;
  public kotlin.g.a.a<x> kTd;
  public kotlin.g.a.b<? super MediaFormat, x> kTe;
  public kotlin.g.a.a<x> kTf;
  public int kTg;
  private final Semaphore kTh;
  private final Object kTi;
  private float kTj;
  private b kTk;
  public boolean kTl;
  private long kTm;
  private long kTn;
  private volatile boolean kTo;
  private volatile int kTp;
  private ArrayList<Long> kTq;
  private Surface krL;
  public MediaFormat mediaFormat;
  long startTimeMs;
  private int videoFps;
  
  public f(long paramLong1, long paramLong2, com.tencent.mm.media.f.a parama, Surface paramSurface, int paramInt, boolean paramBoolean)
  {
    this.startTimeMs = paramLong1;
    this.endTimeMs = paramLong2;
    this.kSW = parama;
    this.krL = paramSurface;
    this.TAG = "MicroMsg.IMediaCodecTransDecoder";
    this.kTh = new Semaphore(1);
    this.kTi = new Object();
    this.kTm = -1L;
    this.kTn = -1L;
    this.kTq = new ArrayList();
    Log.i(this.TAG, "create IMediaCodecTransDecoder, startTimeMs:" + this.startTimeMs + ", endTimeMs:" + this.endTimeMs);
    parama = this.kSW;
    if (parama != null) {
      parama.aUG();
    }
    if (this.startTimeMs >= 0L)
    {
      parama = this.kSW;
      if (parama != null) {
        parama.seek(this.startTimeMs * 1000L);
      }
    }
    parama = this.kSW;
    if (parama != null) {}
    for (parama = parama.filePath;; parama = null)
    {
      this.kTk = new b(parama, paramInt, this.startTimeMs * 1000L, paramBoolean);
      this.kTp = 0;
      return;
    }
  }
  
  private final void a(long paramLong1, long paramLong2, MediaCodec.BufferInfo paramBufferInfo)
  {
    r localr;
    if (this.kTq.contains(Long.valueOf(paramLong1)))
    {
      localr = this.kTc;
      if (localr != null) {
        localr.a(null, Long.valueOf(paramLong2), paramBufferInfo, Boolean.TRUE);
      }
    }
    do
    {
      return;
      this.kTq.add(Long.valueOf(paramLong1));
      localr = this.kTc;
    } while (localr == null);
    localr.a(null, Long.valueOf(paramLong2), paramBufferInfo, Boolean.FALSE);
  }
  
  protected final void a(int paramInt, MediaCodec.BufferInfo paramBufferInfo)
  {
    p.k(paramBufferInfo, "bufferInfo");
    Object localObject2;
    Object localObject1;
    label96:
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
          localObject1 = this.kSW;
          if (localObject1 == null) {
            break label684;
          }
          localObject1 = ((com.tencent.mm.media.f.a)localObject1).kUV;
        }
      }
      if ((localObject1 == null) || (((MediaFormat)localObject1).containsKey("frame-rate"))) {
        break label701;
      }
      localObject1 = this.kSW;
      if (localObject1 == null) {
        break label690;
      }
      localObject1 = ((com.tencent.mm.media.f.a)localObject1).filePath;
      localObject1 = com.tencent.mm.plugin.sight.base.f.aYg((String)localObject1);
      if (localObject1 == null) {
        break label696;
      }
      i = ((com.tencent.mm.plugin.sight.base.b)localObject1).frameRate;
      label114:
      this.videoFps = i;
      if (this.videoFps > 0) {
        this.kTj = (1000.0F / this.videoFps);
      }
    }
    boolean bool1;
    if (this.videoFps <= 0)
    {
      bool1 = false;
      h.IzE.F(986L, 104L);
    }
    label286:
    label684:
    label690:
    label696:
    label1211:
    for (;;)
    {
      this.frameCount += 1;
      this.kTm = paramBufferInfo.presentationTimeUs;
      localObject1 = this.TAG;
      localObject2 = new StringBuilder("processDecodeOutputBuffer, usePts:").append(bool1).append(", pts: ").append(paramBufferInfo.presentationTimeUs).append(", frameDuration:").append(this.kTj).append(", frameCount:").append(this.frameCount).append(", startTimeMs:").append(this.startTimeMs).append(", size: ").append(paramBufferInfo.size).append(", isKeyFrame:");
      boolean bool2;
      long l1;
      int j;
      if ((paramBufferInfo.flags & 0x1) == 1)
      {
        bool2 = true;
        Log.i((String)localObject1, bool2 + ", isMain:" + p.h(Looper.myLooper(), Looper.getMainLooper()));
        if ((this.kTn > 0L) && (this.kTm < this.kTn))
        {
          this.kTo = true;
          this.kTp += 1;
          Log.i(this.TAG, "processDecodeOutputBuffer has B Frame, decodePts:" + this.kTm + ", lastDecodePts:" + this.kTn + ", bFrameNum:" + this.kTp);
        }
        this.kTn = this.kTm;
        if (!bool1) {
          break label1211;
        }
        i = 0;
        l1 = paramBufferInfo.presentationTimeUs;
        localObject1 = this.kTk;
        Log.i("DecodeHelper", "sendPacket, pts:" + l1 + ", recentPts:" + ((b)localObject1).kSx + ", parents[" + l1 + "]:" + (Long)((b)localObject1).kSz.get(Long.valueOf(l1)) + ", lastPts:" + ((b)localObject1).kSy);
        if ((l1 == ((b)localObject1).kSx) || ((l1 <= ((b)localObject1).kSy) && (!((Map)((b)localObject1).kSz).containsKey(Long.valueOf(l1))))) {
          break label734;
        }
        ((b)localObject1).kSB.add(new o(Long.valueOf(l1), Integer.valueOf(paramInt)));
        j = 1;
      }
      int k;
      for (;;)
      {
        if (j == 0)
        {
          Log.i(this.TAG, "processDecodeOutputBuffer sendPacket return false");
          localObject1 = this.kSN;
          if (localObject1 != null) {
            ((aa)localObject1).releaseOutputBuffer(paramInt, false);
          }
          k = 1;
          if (k == 0)
          {
            Log.e(this.TAG, "processDecodeOutputBuffer still not release buffer fallback release it");
            localObject1 = this.kSN;
            if (localObject1 != null)
            {
              if (this.krL == null) {
                break label1205;
              }
              bool1 = true;
              ((aa)localObject1).releaseOutputBuffer(paramInt, bool1);
            }
            a(l1, l1, paramBufferInfo);
          }
          return;
          localObject1 = null;
          break;
          localObject1 = null;
          break label96;
          i = 0;
          break label114;
          label701:
          if (localObject1 != null) {}
          for (i = ((MediaFormat)localObject1).getInteger("frame-rate");; i = 0)
          {
            this.videoFps = i;
            break;
          }
          bool2 = false;
          break label286;
          label734:
          j = 0;
          continue;
          i = 1;
        }
      }
      label1015:
      label1272:
      label1278:
      for (;;)
      {
        localObject1 = this.kTk;
        label767:
        long l2;
        if (!((Collection)((b)localObject1).kSB).isEmpty())
        {
          j = 1;
          if (j == 0) {
            break label1170;
          }
          l2 = ((Number)((o)((b)localObject1).kSB.peek()).Mx).longValue();
          if (l2 <= ((b)localObject1).kSy) {
            break label1140;
          }
          j = 1;
          k = i;
          if (j == 0) {
            break;
          }
          Log.i(this.TAG, "decode hasFrame");
          localObject1 = this.kTk;
          localObject2 = (o)((b)localObject1).kSB.poll();
          l2 = ((Number)((o)localObject2).Mx).longValue();
          j = ((Number)((o)localObject2).My).intValue();
          ((b)localObject1).kSx = l2;
          localObject2 = ((Map)((b)localObject1).kSA).get(Long.valueOf(l2));
          localObject1 = localObject2;
          if (localObject2 == null) {
            localObject1 = j.listOf(Long.valueOf(l2));
          }
          localObject2 = new o(localObject1, Integer.valueOf(j));
          localObject1 = (List)((o)localObject2).Mx;
          k = ((Number)((o)localObject2).My).intValue();
          Log.i(this.TAG, "processDecodeOutputBuffer, duplicate frame size:" + ((List)localObject1).size() + ", bufferInfo pts:" + paramBufferInfo.presentationTimeUs);
          if (((Collection)localObject1).isEmpty()) {
            break label1193;
          }
          j = 1;
          if (j == 0) {
            break label1278;
          }
          localObject2 = this.kSN;
          if (localObject2 != null) {
            if (this.krL == null) {
              break label1199;
            }
          }
        }
        for (bool1 = true;; bool1 = false)
        {
          ((aa)localObject2).releaseOutputBuffer(k, bool1);
          localObject1 = ((Iterable)localObject1).iterator();
          while (((Iterator)localObject1).hasNext())
          {
            l2 = ((Number)((Iterator)localObject1).next()).longValue();
            Log.i(this.TAG, "processDecodeOutputBuffer, duplicate frame, pts: " + l2 + ", bufferInfo: " + paramBufferInfo);
            a(l1, l2, paramBufferInfo);
          }
          break;
          j = 0;
          break label767;
          localObject2 = (Long)((b)localObject1).kSz.get(Long.valueOf(l2));
          l2 = ((b)localObject1).kSx;
          if (localObject2 == null) {}
          while (((Long)localObject2).longValue() != l2)
          {
            j = 0;
            break;
          }
          j = 1;
          break label808;
          j = 0;
          break label1015;
        }
        bool1 = false;
        break label666;
        localObject1 = this.kSN;
        if (localObject1 != null) {
          if (this.krL == null) {
            break label1272;
          }
        }
        for (bool1 = true;; bool1 = false)
        {
          ((aa)localObject1).releaseOutputBuffer(paramInt, bool1);
          localObject1 = this.kTc;
          if (localObject1 == null) {
            break;
          }
          ((r)localObject1).a(null, Long.valueOf(paramBufferInfo.presentationTimeUs), paramBufferInfo, Boolean.FALSE);
          return;
        }
      }
      label1140:
      bool1 = true;
    }
  }
  
  public final com.tencent.mm.media.f.a aUp()
  {
    return this.kSW;
  }
  
  protected final Object aUq()
  {
    return this.kTi;
  }
  
  protected final Surface aUr()
  {
    return this.krL;
  }
  
  public void fB(boolean paramBoolean)
  {
    long l = Util.currentTicks();
    this.fEs = paramBoolean;
    Log.d(this.TAG, "setPauseDecoder:" + paramBoolean + ", remain:" + this.kTh.availablePermits() + ", thread:" + Thread.currentThread() + ' ' + l);
    if (paramBoolean)
    {
      Log.d(this.TAG, "try acquire, thread:" + Thread.currentThread() + ' ' + l);
      this.kTh.acquire();
    }
    for (;;)
    {
      Log.d(this.TAG, "after setPauseDecoder:" + paramBoolean + ", remain:" + this.kTh.availablePermits() + ", thread:" + Thread.currentThread() + ' ' + l);
      return;
      Log.d(this.TAG, "release, thread:" + Thread.currentThread() + ' ' + l);
      this.kTh.release();
    }
  }
  
  protected final void g(Surface paramSurface)
  {
    this.krL = paramSurface;
  }
  
  /* Error */
  public void releaseDecoder()
  {
    // Byte code:
    //   0: aload_0
    //   1: getfield 190	com/tencent/mm/media/d/f:TAG	Ljava/lang/String;
    //   4: new 211	java/lang/StringBuilder
    //   7: dup
    //   8: ldc_w 584
    //   11: invokespecial 216	java/lang/StringBuilder:<init>	(Ljava/lang/String;)V
    //   14: aload_0
    //   15: invokevirtual 587	com/tencent/mm/media/d/f:hashCode	()I
    //   18: invokevirtual 362	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   21: invokevirtual 229	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   24: invokestatic 235	com/tencent/mm/sdk/platformtools/Log:i	(Ljava/lang/String;Ljava/lang/String;)V
    //   27: aload_0
    //   28: getfield 198	com/tencent/mm/media/d/f:kTi	Ljava/lang/Object;
    //   31: astore_1
    //   32: aload_1
    //   33: monitorenter
    //   34: aload_0
    //   35: getfield 255	com/tencent/mm/media/d/f:kTk	Lcom/tencent/mm/media/d/b;
    //   38: getfield 436	com/tencent/mm/media/d/b:kSB	Ljava/util/PriorityQueue;
    //   41: invokevirtual 590	java/util/PriorityQueue:clear	()V
    //   44: aload_0
    //   45: getfield 453	com/tencent/mm/media/d/f:kSN	Lcom/tencent/mm/compatible/deviceinfo/aa;
    //   48: astore_2
    //   49: aload_2
    //   50: ifnull +7 -> 57
    //   53: aload_2
    //   54: invokevirtual 593	com/tencent/mm/compatible/deviceinfo/aa:stop	()V
    //   57: aload_0
    //   58: getfield 190	com/tencent/mm/media/d/f:TAG	Ljava/lang/String;
    //   61: ldc_w 595
    //   64: invokestatic 235	com/tencent/mm/sdk/platformtools/Log:i	(Ljava/lang/String;Ljava/lang/String;)V
    //   67: aload_0
    //   68: getfield 453	com/tencent/mm/media/d/f:kSN	Lcom/tencent/mm/compatible/deviceinfo/aa;
    //   71: astore_2
    //   72: aload_2
    //   73: ifnull +7 -> 80
    //   76: aload_2
    //   77: invokevirtual 596	com/tencent/mm/compatible/deviceinfo/aa:release	()V
    //   80: aload_0
    //   81: getfield 190	com/tencent/mm/media/d/f:TAG	Ljava/lang/String;
    //   84: ldc_w 598
    //   87: invokestatic 235	com/tencent/mm/sdk/platformtools/Log:i	(Ljava/lang/String;Ljava/lang/String;)V
    //   90: aload_0
    //   91: iconst_1
    //   92: putfield 600	com/tencent/mm/media/d/f:isFinished	Z
    //   95: aload_0
    //   96: getfield 186	com/tencent/mm/media/d/f:krL	Landroid/view/Surface;
    //   99: astore_2
    //   100: aload_2
    //   101: ifnull +7 -> 108
    //   104: aload_2
    //   105: invokevirtual 603	android/view/Surface:release	()V
    //   108: aload_0
    //   109: getfield 190	com/tencent/mm/media/d/f:TAG	Ljava/lang/String;
    //   112: ldc_w 605
    //   115: invokestatic 235	com/tencent/mm/sdk/platformtools/Log:i	(Ljava/lang/String;Ljava/lang/String;)V
    //   118: getstatic 611	kotlin/x:aazN	Lkotlin/x;
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
  
  protected final void setPause(boolean paramBoolean)
  {
    this.fEs = paramBoolean;
  }
  
  public abstract void startDecode();
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.media.d.f
 * JD-Core Version:    0.7.0.1
 */