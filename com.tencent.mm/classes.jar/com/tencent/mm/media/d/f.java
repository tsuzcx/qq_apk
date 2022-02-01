package com.tencent.mm.media.d;

import android.media.MediaCodec.BufferInfo;
import android.media.MediaFormat;
import android.os.Looper;
import android.view.Surface;
import com.tencent.mm.compatible.deviceinfo.z;
import com.tencent.mm.plugin.report.service.h;
import com.tencent.mm.plugin.sight.base.e;
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

@l(hxD={1, 1, 16}, hxE={""}, hxF={"Lcom/tencent/mm/media/decoder/IMediaCodecTransDecoder;", "", "startTimeMs", "", "endTimeMs", "mediaExtractorWrapper", "Lcom/tencent/mm/media/extractor/MediaExtractorWrapper;", "decodeSurface", "Landroid/view/Surface;", "outputFps", "", "enableHevc", "", "(JJLcom/tencent/mm/media/extractor/MediaExtractorWrapper;Landroid/view/Surface;IZ)V", "TAG", "", "bFrameNum", "decodeHelper", "Lcom/tencent/mm/media/decoder/DecodeHelper;", "getDecodeHelper", "()Lcom/tencent/mm/media/decoder/DecodeHelper;", "setDecodeHelper", "(Lcom/tencent/mm/media/decoder/DecodeHelper;)V", "decodePts", "getDecodeSurface", "()Landroid/view/Surface;", "setDecodeSurface", "(Landroid/view/Surface;)V", "decoder", "Lcom/tencent/mm/compatible/deviceinfo/MediaCodecProxy;", "getDecoder", "()Lcom/tencent/mm/compatible/deviceinfo/MediaCodecProxy;", "setDecoder", "(Lcom/tencent/mm/compatible/deviceinfo/MediaCodecProxy;)V", "decoderLock", "Ljava/lang/Object;", "getDecoderLock", "()Ljava/lang/Object;", "getEndTimeMs", "()J", "setEndTimeMs", "(J)V", "frameCount", "frameDropInterval", "frameDuration", "", "getFrameDuration", "()F", "setFrameDuration", "(F)V", "hasBFrame", "isFinished", "()Z", "setFinished", "(Z)V", "isPause", "setPause", "lastDecodePts", "getMediaExtractorWrapper", "()Lcom/tencent/mm/media/extractor/MediaExtractorWrapper;", "mediaFormat", "Landroid/media/MediaFormat;", "getMediaFormat", "()Landroid/media/MediaFormat;", "setMediaFormat", "(Landroid/media/MediaFormat;)V", "onDecodeDataCallback", "Lkotlin/Function4;", "Ljava/nio/ByteBuffer;", "Lkotlin/ParameterName;", "name", "decodeData", "pts", "Landroid/media/MediaCodec$BufferInfo;", "bufferInfo", "duplicate", "", "getOnDecodeDataCallback", "()Lkotlin/jvm/functions/Function4;", "setOnDecodeDataCallback", "(Lkotlin/jvm/functions/Function4;)V", "onDecodeEnd", "Lkotlin/Function0;", "getOnDecodeEnd", "()Lkotlin/jvm/functions/Function0;", "setOnDecodeEnd", "(Lkotlin/jvm/functions/Function0;)V", "onDecodeError", "getOnDecodeError", "setOnDecodeError", "onFormatChanged", "Lkotlin/Function1;", "getOnFormatChanged", "()Lkotlin/jvm/functions/Function1;", "setOnFormatChanged", "(Lkotlin/jvm/functions/Function1;)V", "pauseSemaphore", "Ljava/util/concurrent/Semaphore;", "ptsList", "Ljava/util/ArrayList;", "Lkotlin/collections/ArrayList;", "getStartTimeMs", "setStartTimeMs", "useInRemuxer", "getUseInRemuxer", "setUseInRemuxer", "videoFps", "getVideoFps", "()I", "setVideoFps", "(I)V", "getBFrameNum", "getFrameCount", "getFrameDropInterval", "getVideoFormat", "isDecoderPause", "onDecode", "callback", "processDecodeOutputBuffer", "bufferIndex", "releaseDecoder", "setFrameDropInterval", "interval", "setPauseDecoder", "pause", "startDecode", "useInRemux", "plugin-mediaeditor_release"})
public abstract class f
{
  public final String TAG;
  protected volatile boolean dLD;
  long endTimeMs;
  private int frameCount;
  private volatile boolean ieA;
  private volatile int ieB;
  private ArrayList<Long> ieC;
  protected Surface ieD;
  z iec;
  final com.tencent.mm.media.f.a iei;
  public r<? super ByteBuffer, ? super Long, ? super MediaCodec.BufferInfo, ? super Boolean, x> ieo;
  public kotlin.g.a.a<x> iep;
  public kotlin.g.a.b<? super MediaFormat, x> ieq;
  public kotlin.g.a.a<x> ier;
  public int ies;
  private final Semaphore iet;
  final Object ieu;
  private float iev;
  private b iew;
  public boolean iex;
  private long iey;
  private long iez;
  volatile boolean isFinished;
  public MediaFormat mediaFormat;
  long startTimeMs;
  private int videoFps;
  
  public f(long paramLong1, long paramLong2, com.tencent.mm.media.f.a parama, Surface paramSurface, int paramInt, boolean paramBoolean)
  {
    this.startTimeMs = paramLong1;
    this.endTimeMs = paramLong2;
    this.iei = parama;
    this.ieD = paramSurface;
    this.TAG = "MicroMsg.IMediaCodecTransDecoder";
    this.iet = new Semaphore(1);
    this.ieu = new Object();
    this.iey = -1L;
    this.iez = -1L;
    this.ieC = new ArrayList();
    Log.i(this.TAG, "create IMediaCodecTransDecoder, startTimeMs:" + this.startTimeMs + ", endTimeMs:" + this.endTimeMs);
    parama = this.iei;
    if (parama != null) {
      parama.aMq();
    }
    if (this.startTimeMs >= 0L)
    {
      parama = this.iei;
      if (parama != null) {
        parama.seek(this.startTimeMs * 1000L);
      }
    }
    parama = this.iei;
    if (parama != null) {}
    for (parama = parama.filePath;; parama = null)
    {
      this.iew = new b(parama, paramInt, this.startTimeMs * 1000L, paramBoolean);
      this.ieB = 0;
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
          localObject1 = this.iei;
          if (localObject1 == null) {
            break label722;
          }
          localObject1 = ((com.tencent.mm.media.f.a)localObject1).igh;
        }
      }
      if ((localObject1 == null) || (((MediaFormat)localObject1).containsKey("frame-rate"))) {
        break label739;
      }
      localObject1 = this.iei;
      if (localObject1 == null) {
        break label728;
      }
      localObject1 = ((com.tencent.mm.media.f.a)localObject1).filePath;
      localObject1 = e.aNx((String)localObject1);
      if (localObject1 == null) {
        break label734;
      }
      i = ((com.tencent.mm.plugin.sight.base.a)localObject1).frameRate;
      label120:
      this.videoFps = i;
      if (this.videoFps > 0) {
        this.iev = (1000.0F / this.videoFps);
      }
    }
    if (this.videoFps <= 0) {
      h.CyF.F(986L, 104L);
    }
    for (boolean bool1 = false;; bool1 = true)
    {
      this.frameCount += 1;
      this.iey = paramBufferInfo.presentationTimeUs;
      localObject1 = this.TAG;
      localObject2 = new StringBuilder("processDecodeOutputBuffer, usePts:").append(bool1).append(", pts: ").append(paramBufferInfo.presentationTimeUs).append(", frameDuration:").append(this.iev).append(", frameCount:").append(this.frameCount).append(", startTimeMs:").append(this.startTimeMs).append(", size: ").append(paramBufferInfo.size).append(", isKeyFrame:");
      boolean bool2;
      label292:
      long l1;
      if ((paramBufferInfo.flags & 0x1) == 1)
      {
        bool2 = true;
        Log.i((String)localObject1, bool2 + ", isMain:" + p.j(Looper.myLooper(), Looper.getMainLooper()));
        if ((this.iez > 0L) && (this.iey < this.iez))
        {
          this.ieA = true;
          this.ieB += 1;
          Log.i(this.TAG, "processDecodeOutputBuffer has B Frame, decodePts:" + this.iey + ", lastDecodePts:" + this.iez + ", bFrameNum:" + this.ieB);
        }
        this.iez = this.iey;
        if (!bool1) {
          break label1371;
        }
        l1 = paramBufferInfo.presentationTimeUs;
        localObject1 = this.iew;
        Log.i("DecodeHelper", "sendPacket, pts:" + l1 + ", recentPts:" + ((b)localObject1).idQ + ", parents[" + l1 + "]:" + (Long)((b)localObject1).idS.get(Long.valueOf(l1)) + ", lastPts:" + ((b)localObject1).idR);
        if ((l1 == ((b)localObject1).idQ) || ((l1 <= ((b)localObject1).idR) && (!((Map)((b)localObject1).idS).containsKey(Long.valueOf(l1))))) {
          break label772;
        }
        ((b)localObject1).bHs.add(new o(Long.valueOf(l1), Integer.valueOf(paramInt)));
        i = 1;
      }
      int k;
      for (;;)
      {
        if (i == 0)
        {
          Log.i(this.TAG, "processDecodeOutputBuffer sendPacket return false");
          localObject1 = this.iec;
          if (localObject1 != null) {
            ((z)localObject1).releaseOutputBuffer(paramInt, false);
          }
          k = 1;
          if (k == 0)
          {
            Log.e(this.TAG, "processDecodeOutputBuffer still not release buffer fallback release it");
            localObject1 = this.iec;
            if (localObject1 != null)
            {
              if (this.ieD == null) {
                break label1322;
              }
              bool1 = bool3;
              label669:
              ((z)localObject1).releaseOutputBuffer(paramInt, bool1);
            }
            if (!this.ieC.contains(Long.valueOf(l1))) {
              break label1328;
            }
            localObject1 = this.ieo;
            if (localObject1 != null) {
              ((r)localObject1).invoke(null, Long.valueOf(l1), paramBufferInfo, Boolean.TRUE);
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
        localObject1 = this.iew;
        int j;
        long l2;
        if (!((Collection)((b)localObject1).bHs).isEmpty())
        {
          j = 1;
          if (j == 0) {
            break label1242;
          }
          l2 = ((Number)((o)((b)localObject1).bHs.peek()).first).longValue();
          if (l2 <= ((b)localObject1).idR) {
            break label1212;
          }
          j = 1;
          label845:
          k = i;
          if (j == 0) {
            break;
          }
          Log.i(this.TAG, "decode hasFrame");
          localObject1 = this.iew;
          localObject2 = (o)((b)localObject1).bHs.poll();
          l2 = ((Number)((o)localObject2).first).longValue();
          j = ((Number)((o)localObject2).second).intValue();
          ((b)localObject1).idQ = l2;
          localObject2 = ((Map)((b)localObject1).idT).get(Long.valueOf(l2));
          localObject1 = localObject2;
          if (localObject2 == null) {
            localObject1 = j.listOf(Long.valueOf(l2));
          }
          localObject2 = new o(localObject1, Integer.valueOf(j));
          localObject1 = (List)((o)localObject2).first;
          k = ((Number)((o)localObject2).second).intValue();
          Log.i(this.TAG, "processDecodeOutputBuffer, duplicate frame size:" + ((List)localObject1).size() + ", bufferInfo pts:" + paramBufferInfo.presentationTimeUs);
          if (((Collection)localObject1).isEmpty()) {
            break label1265;
          }
          j = 1;
          label1052:
          if (j == 0) {
            break label1439;
          }
          localObject2 = this.iec;
          if (localObject2 != null)
          {
            if (this.ieD == null) {
              break label1271;
            }
            bool1 = true;
            label1078:
            ((z)localObject2).releaseOutputBuffer(k, bool1);
          }
          localObject1 = ((Iterable)localObject1).iterator();
        }
        for (;;)
        {
          if (!((Iterator)localObject1).hasNext()) {
            break label1320;
          }
          l2 = ((Number)((Iterator)localObject1).next()).longValue();
          Log.i(this.TAG, "processDecodeOutputBuffer, duplicate frame, pts: " + l2 + ", bufferInfo: " + paramBufferInfo);
          if (this.ieC.contains(Long.valueOf(l1)))
          {
            localObject2 = this.ieo;
            if (localObject2 == null) {
              continue;
            }
            ((r)localObject2).invoke(null, Long.valueOf(l1), paramBufferInfo, Boolean.TRUE);
            continue;
            j = 0;
            break;
            label1212:
            localObject2 = (Long)((b)localObject1).idS.get(Long.valueOf(l2));
            l2 = ((b)localObject1).idQ;
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
          this.ieC.add(Long.valueOf(l1));
          localObject2 = this.ieo;
          if (localObject2 != null) {
            ((r)localObject2).invoke(null, Long.valueOf(l1), paramBufferInfo, Boolean.FALSE);
          }
        }
        label1320:
        break label777;
        label1322:
        bool1 = false;
        break label669;
        label1328:
        this.ieC.add(Long.valueOf(l1));
        localObject1 = this.ieo;
        if (localObject1 == null) {
          break label721;
        }
        ((r)localObject1).invoke(null, Long.valueOf(l1), paramBufferInfo, Boolean.FALSE);
        return;
        label1371:
        localObject1 = this.iec;
        if (localObject1 != null) {
          if (this.ieD == null) {
            break label1433;
          }
        }
        label1433:
        for (bool1 = bool4;; bool1 = false)
        {
          ((z)localObject1).releaseOutputBuffer(paramInt, bool1);
          localObject1 = this.ieo;
          if (localObject1 == null) {
            break;
          }
          ((r)localObject1).invoke(null, Long.valueOf(paramBufferInfo.presentationTimeUs), paramBufferInfo, Boolean.FALSE);
          return;
        }
        label1439:
        continue;
        i = 0;
      }
    }
  }
  
  public void eU(boolean paramBoolean)
  {
    long l = Util.currentTicks();
    this.dLD = paramBoolean;
    Log.d(this.TAG, "setPauseDecoder:" + paramBoolean + ", remain:" + this.iet.availablePermits() + ", thread:" + Thread.currentThread() + ' ' + l);
    if (paramBoolean)
    {
      Log.d(this.TAG, "try acquire, thread:" + Thread.currentThread() + ' ' + l);
      this.iet.acquire();
    }
    for (;;)
    {
      Log.d(this.TAG, "after setPauseDecoder:" + paramBoolean + ", remain:" + this.iet.availablePermits() + ", thread:" + Thread.currentThread() + ' ' + l);
      return;
      Log.d(this.TAG, "release, thread:" + Thread.currentThread() + ' ' + l);
      this.iet.release();
    }
  }
  
  /* Error */
  public void releaseDecoder()
  {
    // Byte code:
    //   0: aload_0
    //   1: getfield 188	com/tencent/mm/media/d/f:TAG	Ljava/lang/String;
    //   4: new 209	java/lang/StringBuilder
    //   7: dup
    //   8: ldc_w 575
    //   11: invokespecial 214	java/lang/StringBuilder:<init>	(Ljava/lang/String;)V
    //   14: aload_0
    //   15: invokevirtual 578	com/tencent/mm/media/d/f:hashCode	()I
    //   18: invokevirtual 330	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   21: invokevirtual 227	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   24: invokestatic 233	com/tencent/mm/sdk/platformtools/Log:i	(Ljava/lang/String;Ljava/lang/String;)V
    //   27: aload_0
    //   28: getfield 196	com/tencent/mm/media/d/f:ieu	Ljava/lang/Object;
    //   31: astore_1
    //   32: aload_1
    //   33: monitorenter
    //   34: aload_0
    //   35: getfield 253	com/tencent/mm/media/d/f:iew	Lcom/tencent/mm/media/d/b;
    //   38: getfield 411	com/tencent/mm/media/d/b:bHs	Ljava/util/PriorityQueue;
    //   41: invokevirtual 581	java/util/PriorityQueue:clear	()V
    //   44: aload_0
    //   45: getfield 430	com/tencent/mm/media/d/f:iec	Lcom/tencent/mm/compatible/deviceinfo/z;
    //   48: astore_2
    //   49: aload_2
    //   50: ifnull +7 -> 57
    //   53: aload_2
    //   54: invokevirtual 584	com/tencent/mm/compatible/deviceinfo/z:stop	()V
    //   57: aload_0
    //   58: getfield 188	com/tencent/mm/media/d/f:TAG	Ljava/lang/String;
    //   61: ldc_w 586
    //   64: invokestatic 233	com/tencent/mm/sdk/platformtools/Log:i	(Ljava/lang/String;Ljava/lang/String;)V
    //   67: aload_0
    //   68: getfield 430	com/tencent/mm/media/d/f:iec	Lcom/tencent/mm/compatible/deviceinfo/z;
    //   71: astore_2
    //   72: aload_2
    //   73: ifnull +7 -> 80
    //   76: aload_2
    //   77: invokevirtual 587	com/tencent/mm/compatible/deviceinfo/z:release	()V
    //   80: aload_0
    //   81: getfield 188	com/tencent/mm/media/d/f:TAG	Ljava/lang/String;
    //   84: ldc_w 589
    //   87: invokestatic 233	com/tencent/mm/sdk/platformtools/Log:i	(Ljava/lang/String;Ljava/lang/String;)V
    //   90: aload_0
    //   91: iconst_1
    //   92: putfield 591	com/tencent/mm/media/d/f:isFinished	Z
    //   95: aload_0
    //   96: getfield 184	com/tencent/mm/media/d/f:ieD	Landroid/view/Surface;
    //   99: astore_2
    //   100: aload_2
    //   101: ifnull +7 -> 108
    //   104: aload_2
    //   105: invokevirtual 594	android/view/Surface:release	()V
    //   108: aload_0
    //   109: getfield 188	com/tencent/mm/media/d/f:TAG	Ljava/lang/String;
    //   112: ldc_w 596
    //   115: invokestatic 233	com/tencent/mm/sdk/platformtools/Log:i	(Ljava/lang/String;Ljava/lang/String;)V
    //   118: getstatic 602	kotlin/x:SXb	Lkotlin/x;
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


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.mm.media.d.f
 * JD-Core Version:    0.7.0.1
 */