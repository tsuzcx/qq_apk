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
import kotlin.Metadata;
import kotlin.a.p;
import kotlin.ah;
import kotlin.g.b.s;

@Metadata(d1={""}, d2={"Lcom/tencent/mm/media/decoder/IMediaCodecTransDecoder;", "", "startTimeMs", "", "endTimeMs", "mediaExtractorWrapper", "Lcom/tencent/mm/media/extractor/MediaExtractorWrapper;", "decodeSurface", "Landroid/view/Surface;", "outputFps", "", "enableHevc", "", "(JJLcom/tencent/mm/media/extractor/MediaExtractorWrapper;Landroid/view/Surface;IZ)V", "TAG", "", "bFrameNum", "decodeHelper", "Lcom/tencent/mm/media/decoder/DecodeHelper;", "getDecodeHelper", "()Lcom/tencent/mm/media/decoder/DecodeHelper;", "setDecodeHelper", "(Lcom/tencent/mm/media/decoder/DecodeHelper;)V", "decodePts", "getDecodeSurface", "()Landroid/view/Surface;", "setDecodeSurface", "(Landroid/view/Surface;)V", "decoder", "Lcom/tencent/mm/compatible/deviceinfo/MediaCodecProxy;", "getDecoder", "()Lcom/tencent/mm/compatible/deviceinfo/MediaCodecProxy;", "setDecoder", "(Lcom/tencent/mm/compatible/deviceinfo/MediaCodecProxy;)V", "decoderLock", "Ljava/lang/Object;", "getDecoderLock", "()Ljava/lang/Object;", "getEndTimeMs", "()J", "setEndTimeMs", "(J)V", "frameCount", "frameDropInterval", "frameDuration", "", "getFrameDuration", "()F", "setFrameDuration", "(F)V", "hasBFrame", "isFinished", "()Z", "setFinished", "(Z)V", "isPause", "setPause", "lastDecodePts", "getMediaExtractorWrapper", "()Lcom/tencent/mm/media/extractor/MediaExtractorWrapper;", "mediaFormat", "Landroid/media/MediaFormat;", "getMediaFormat", "()Landroid/media/MediaFormat;", "setMediaFormat", "(Landroid/media/MediaFormat;)V", "onDecodeDataCallback", "Lkotlin/Function4;", "Ljava/nio/ByteBuffer;", "Lkotlin/ParameterName;", "name", "decodeData", "pts", "Landroid/media/MediaCodec$BufferInfo;", "bufferInfo", "duplicate", "", "getOnDecodeDataCallback", "()Lkotlin/jvm/functions/Function4;", "setOnDecodeDataCallback", "(Lkotlin/jvm/functions/Function4;)V", "onDecodeEnd", "Lkotlin/Function0;", "getOnDecodeEnd", "()Lkotlin/jvm/functions/Function0;", "setOnDecodeEnd", "(Lkotlin/jvm/functions/Function0;)V", "onDecodeError", "getOnDecodeError", "setOnDecodeError", "onFormatChanged", "Lkotlin/Function1;", "getOnFormatChanged", "()Lkotlin/jvm/functions/Function1;", "setOnFormatChanged", "(Lkotlin/jvm/functions/Function1;)V", "pauseSemaphore", "Ljava/util/concurrent/Semaphore;", "ptsList", "Ljava/util/ArrayList;", "Lkotlin/collections/ArrayList;", "getStartTimeMs", "setStartTimeMs", "useInRemuxer", "getUseInRemuxer", "setUseInRemuxer", "videoFps", "getVideoFps", "()I", "setVideoFps", "(I)V", "getBFrameNum", "getFrameCount", "getFrameDropInterval", "getVideoFormat", "invokeDecodeCallback", "callbackPts", "isDecoderPause", "onDecode", "callback", "processDecodeOutputBuffer", "bufferIndex", "releaseDecoder", "setFrameDropInterval", "interval", "setPauseDecoder", "pause", "startDecode", "useInRemux", "plugin-mediaeditor_release"}, k=1, mv={1, 5, 1}, xi=48)
public abstract class f
{
  public final String TAG;
  long endTimeMs;
  private int frameCount;
  private volatile boolean hJi;
  volatile boolean isFinished;
  private Surface mVI;
  public MediaFormat mediaFormat;
  public kotlin.g.a.r<? super ByteBuffer, ? super Long, ? super MediaCodec.BufferInfo, ? super Boolean, ah> nyK;
  public kotlin.g.a.a<ah> nyL;
  public kotlin.g.a.b<? super MediaFormat, ah> nyM;
  public kotlin.g.a.a<ah> nyN;
  public int nyO;
  private final Semaphore nyP;
  private final Object nyQ;
  private float nyR;
  private b nyS;
  public boolean nyT;
  private long nyU;
  private long nyV;
  private volatile boolean nyW;
  private volatile int nyX;
  private ArrayList<Long> nyY;
  private final com.tencent.mm.media.f.a nyw;
  aa nyz;
  long startTimeMs;
  private int videoFps;
  
  public f(long paramLong1, long paramLong2, com.tencent.mm.media.f.a parama, Surface paramSurface, int paramInt, boolean paramBoolean)
  {
    this.startTimeMs = paramLong1;
    this.endTimeMs = paramLong2;
    this.nyw = parama;
    this.mVI = paramSurface;
    this.TAG = "MicroMsg.IMediaCodecTransDecoder";
    this.nyP = new Semaphore(1);
    this.nyQ = new Object();
    this.nyU = -1L;
    this.nyV = -1L;
    this.nyY = new ArrayList();
    Log.i(this.TAG, "create IMediaCodecTransDecoder, startTimeMs:" + this.startTimeMs + ", endTimeMs:" + this.endTimeMs);
    parama = this.nyw;
    if (parama != null) {
      parama.bpn();
    }
    if (this.startTimeMs >= 0L)
    {
      parama = this.nyw;
      if (parama != null) {
        parama.seek(this.startTimeMs * 1000L);
      }
    }
    parama = this.nyw;
    if (parama == null) {}
    for (parama = null;; parama = parama.filePath)
    {
      this.nyS = new b(parama, paramInt, this.startTimeMs * 1000L, paramBoolean);
      this.nyX = 0;
      return;
    }
  }
  
  private final void a(long paramLong1, long paramLong2, MediaCodec.BufferInfo paramBufferInfo)
  {
    kotlin.g.a.r localr;
    if (this.nyY.contains(Long.valueOf(paramLong1)))
    {
      localr = this.nyK;
      if (localr != null) {
        localr.a(null, Long.valueOf(paramLong2), paramBufferInfo, Boolean.TRUE);
      }
    }
    do
    {
      return;
      this.nyY.add(Long.valueOf(paramLong1));
      localr = this.nyK;
    } while (localr == null);
    localr.a(null, Long.valueOf(paramLong2), paramBufferInfo, Boolean.FALSE);
  }
  
  protected final void a(int paramInt, MediaCodec.BufferInfo paramBufferInfo)
  {
    s.u(paramBufferInfo, "bufferInfo");
    Object localObject1;
    int i;
    if (this.videoFps <= 0)
    {
      localObject1 = this.mediaFormat;
      if ((localObject1 == null) || (((MediaFormat)localObject1).containsKey("frame-rate"))) {
        break label674;
      }
      i = 1;
      if (i == 0) {
        break label1299;
      }
      localObject1 = this.nyw;
      if (localObject1 != null) {
        break label679;
      }
      localObject1 = null;
    }
    label656:
    label1299:
    for (;;)
    {
      label56:
      label74:
      label92:
      label106:
      boolean bool1;
      if ((localObject1 != null) && (!((MediaFormat)localObject1).containsKey("frame-rate")))
      {
        i = 1;
        if (i == 0) {
          break label713;
        }
        localObject1 = this.nyw;
        if (localObject1 != null) {
          break label694;
        }
        localObject1 = null;
        localObject1 = com.tencent.mm.plugin.sight.base.f.aVX((String)localObject1);
        if (localObject1 != null) {
          break label704;
        }
        i = 0;
        this.videoFps = i;
        if (this.videoFps > 0) {
          this.nyR = (1000.0F / this.videoFps);
        }
        if (this.videoFps > 0) {
          break label1293;
        }
        bool1 = false;
        h.OAn.p(986L, 104L, 1L);
      }
      for (;;)
      {
        this.frameCount += 1;
        this.nyU = paramBufferInfo.presentationTimeUs;
        localObject1 = this.TAG;
        Object localObject2 = new StringBuilder("processDecodeOutputBuffer, usePts:").append(bool1).append(", pts: ").append(paramBufferInfo.presentationTimeUs).append(", frameDuration:").append(this.nyR).append(", frameCount:").append(this.frameCount).append(", startTimeMs:").append(this.startTimeMs).append(", size: ").append(paramBufferInfo.size).append(", isKeyFrame:");
        boolean bool2;
        label279:
        long l1;
        int j;
        if ((paramBufferInfo.flags & 0x1) == 1)
        {
          bool2 = true;
          Log.i((String)localObject1, bool2 + ", isMain:" + s.p(Looper.myLooper(), Looper.getMainLooper()));
          if ((this.nyV > 0L) && (this.nyU < this.nyV))
          {
            this.nyW = true;
            this.nyX += 1;
            Log.i(this.TAG, "processDecodeOutputBuffer has B Frame, decodePts:" + this.nyU + ", lastDecodePts:" + this.nyV + ", bFrameNum:" + this.nyX);
          }
          this.nyV = this.nyU;
          if (!bool1) {
            break label1223;
          }
          i = 0;
          l1 = paramBufferInfo.presentationTimeUs;
          localObject1 = this.nyS;
          Log.i("DecodeHelper", "sendPacket, pts:" + l1 + ", recentPts:" + ((b)localObject1).nyi + ", parents[" + l1 + "]:" + ((b)localObject1).nyk.get(Long.valueOf(l1)) + ", lastPts:" + ((b)localObject1).nyj);
          if ((l1 == ((b)localObject1).nyi) || ((l1 <= ((b)localObject1).nyj) && (!((Map)((b)localObject1).nyk).containsKey(Long.valueOf(l1))))) {
            break label746;
          }
          ((b)localObject1).nym.add(new kotlin.r(Long.valueOf(l1), Integer.valueOf(paramInt)));
          j = 1;
        }
        int k;
        for (;;)
        {
          if (j == 0)
          {
            Log.i(this.TAG, "processDecodeOutputBuffer sendPacket return false");
            localObject1 = this.nyz;
            if (localObject1 != null) {
              ((aa)localObject1).releaseOutputBuffer(paramInt, false);
            }
            k = 1;
            if (k == 0)
            {
              Log.e(this.TAG, "processDecodeOutputBuffer still not release buffer fallback release it");
              localObject1 = this.nyz;
              if (localObject1 != null)
              {
                if (this.mVI == null) {
                  break label1217;
                }
                bool1 = true;
                ((aa)localObject1).releaseOutputBuffer(paramInt, bool1);
              }
              a(l1, l1, paramBufferInfo);
            }
            return;
            label674:
            i = 0;
            break;
            label679:
            localObject1 = ((com.tencent.mm.media.f.a)localObject1).nAs;
            break label56;
            i = 0;
            break label74;
            label694:
            localObject1 = ((com.tencent.mm.media.f.a)localObject1).filePath;
            break label92;
            label704:
            i = ((com.tencent.mm.plugin.sight.base.b)localObject1).frameRate;
            break label106;
            label713:
            if (localObject1 == null) {}
            for (i = 0;; i = ((MediaFormat)localObject1).getInteger("frame-rate"))
            {
              this.videoFps = i;
              break;
            }
            bool2 = false;
            break label279;
            label746:
            j = 0;
            continue;
            i = 1;
          }
        }
        for (;;)
        {
          localObject1 = this.nyS;
          long l2;
          if (!((Collection)((b)localObject1).nym).isEmpty())
          {
            j = 1;
            if (j == 0) {
              break label1182;
            }
            l2 = ((Number)((kotlin.r)((b)localObject1).nym.peek()).bsC).longValue();
            if (l2 <= ((b)localObject1).nyj) {
              break label1152;
            }
            j = 1;
            label820:
            k = i;
            if (j == 0) {
              break;
            }
            Log.i(this.TAG, "decode hasFrame");
            localObject1 = this.nyS;
            localObject2 = (kotlin.r)((b)localObject1).nym.poll();
            l2 = ((Number)((kotlin.r)localObject2).bsC).longValue();
            j = ((Number)((kotlin.r)localObject2).bsD).intValue();
            ((b)localObject1).nyi = l2;
            localObject2 = ((Map)((b)localObject1).nyl).get(Long.valueOf(l2));
            localObject1 = localObject2;
            if (localObject2 == null) {
              localObject1 = p.listOf(Long.valueOf(l2));
            }
            localObject2 = new kotlin.r(localObject1, Integer.valueOf(j));
            localObject1 = (List)((kotlin.r)localObject2).bsC;
            k = ((Number)((kotlin.r)localObject2).bsD).intValue();
            Log.i(this.TAG, "processDecodeOutputBuffer, duplicate frame size:" + ((List)localObject1).size() + ", bufferInfo pts:" + paramBufferInfo.presentationTimeUs);
            if (((Collection)localObject1).isEmpty()) {
              break label1205;
            }
            j = 1;
            if (j == 0) {
              break label1290;
            }
            localObject2 = this.nyz;
            if (localObject2 != null) {
              if (this.mVI == null) {
                break label1211;
              }
            }
          }
          label1182:
          label1205:
          label1211:
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
            break label779;
            localObject2 = (Long)((b)localObject1).nyk.get(Long.valueOf(l2));
            l2 = ((b)localObject1).nyi;
            if (localObject2 == null) {}
            while (((Long)localObject2).longValue() != l2)
            {
              j = 0;
              break;
            }
            j = 1;
            break label820;
            j = 0;
            break label1027;
          }
          label1217:
          bool1 = false;
          break label656;
          label1223:
          localObject1 = this.nyz;
          if (localObject1 != null) {
            if (this.mVI == null) {
              break label1284;
            }
          }
          for (bool1 = true;; bool1 = false)
          {
            ((aa)localObject1).releaseOutputBuffer(paramInt, bool1);
            localObject1 = this.nyK;
            if (localObject1 == null) {
              break;
            }
            ((kotlin.g.a.r)localObject1).a(null, Long.valueOf(paramBufferInfo.presentationTimeUs), paramBufferInfo, Boolean.FALSE);
            return;
          }
        }
        bool1 = true;
      }
    }
  }
  
  public final com.tencent.mm.media.f.a boN()
  {
    return this.nyw;
  }
  
  protected final Surface boR()
  {
    return this.mVI;
  }
  
  protected final Object boS()
  {
    return this.nyQ;
  }
  
  public void gl(boolean paramBoolean)
  {
    long l = Util.currentTicks();
    this.hJi = paramBoolean;
    Log.d(this.TAG, "setPauseDecoder:" + paramBoolean + ", remain:" + this.nyP.availablePermits() + ", thread:" + Thread.currentThread() + ' ' + l);
    if (paramBoolean)
    {
      Log.d(this.TAG, "try acquire, thread:" + Thread.currentThread() + ' ' + l);
      this.nyP.acquire();
    }
    for (;;)
    {
      Log.d(this.TAG, "after setPauseDecoder:" + paramBoolean + ", remain:" + this.nyP.availablePermits() + ", thread:" + Thread.currentThread() + ' ' + l);
      return;
      Log.d(this.TAG, "release, thread:" + Thread.currentThread() + ' ' + l);
      this.nyP.release();
    }
  }
  
  protected final void k(Surface paramSurface)
  {
    this.mVI = paramSurface;
  }
  
  /* Error */
  public void releaseDecoder()
  {
    // Byte code:
    //   0: aload_0
    //   1: getfield 193	com/tencent/mm/media/d/f:TAG	Ljava/lang/String;
    //   4: ldc_w 586
    //   7: aload_0
    //   8: invokevirtual 589	com/tencent/mm/media/d/f:hashCode	()I
    //   11: invokestatic 438	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
    //   14: invokestatic 593	kotlin/g/b/s:X	(Ljava/lang/String;Ljava/lang/Object;)Ljava/lang/String;
    //   17: invokestatic 238	com/tencent/mm/sdk/platformtools/Log:i	(Ljava/lang/String;Ljava/lang/String;)V
    //   20: aload_0
    //   21: getfield 201	com/tencent/mm/media/d/f:nyQ	Ljava/lang/Object;
    //   24: astore_1
    //   25: aload_1
    //   26: monitorenter
    //   27: aload_0
    //   28: getfield 255	com/tencent/mm/media/d/f:nyS	Lcom/tencent/mm/media/d/b;
    //   31: getfield 431	com/tencent/mm/media/d/b:nym	Ljava/util/PriorityQueue;
    //   34: invokevirtual 596	java/util/PriorityQueue:clear	()V
    //   37: aload_0
    //   38: getfield 448	com/tencent/mm/media/d/f:nyz	Lcom/tencent/mm/compatible/deviceinfo/aa;
    //   41: astore_2
    //   42: aload_2
    //   43: ifnull +7 -> 50
    //   46: aload_2
    //   47: invokevirtual 599	com/tencent/mm/compatible/deviceinfo/aa:stop	()V
    //   50: aload_0
    //   51: getfield 193	com/tencent/mm/media/d/f:TAG	Ljava/lang/String;
    //   54: ldc_w 601
    //   57: invokestatic 238	com/tencent/mm/sdk/platformtools/Log:i	(Ljava/lang/String;Ljava/lang/String;)V
    //   60: aload_0
    //   61: getfield 448	com/tencent/mm/media/d/f:nyz	Lcom/tencent/mm/compatible/deviceinfo/aa;
    //   64: astore_2
    //   65: aload_2
    //   66: ifnull +7 -> 73
    //   69: aload_2
    //   70: invokevirtual 602	com/tencent/mm/compatible/deviceinfo/aa:release	()V
    //   73: aload_0
    //   74: getfield 193	com/tencent/mm/media/d/f:TAG	Ljava/lang/String;
    //   77: ldc_w 604
    //   80: invokestatic 238	com/tencent/mm/sdk/platformtools/Log:i	(Ljava/lang/String;Ljava/lang/String;)V
    //   83: aload_0
    //   84: iconst_1
    //   85: putfield 606	com/tencent/mm/media/d/f:isFinished	Z
    //   88: aload_0
    //   89: getfield 189	com/tencent/mm/media/d/f:mVI	Landroid/view/Surface;
    //   92: astore_2
    //   93: aload_2
    //   94: ifnull +7 -> 101
    //   97: aload_2
    //   98: invokevirtual 609	android/view/Surface:release	()V
    //   101: aload_0
    //   102: getfield 193	com/tencent/mm/media/d/f:TAG	Ljava/lang/String;
    //   105: ldc_w 611
    //   108: invokestatic 238	com/tencent/mm/sdk/platformtools/Log:i	(Ljava/lang/String;Ljava/lang/String;)V
    //   111: getstatic 617	kotlin/ah:aiuX	Lkotlin/ah;
    //   114: astore_2
    //   115: aload_1
    //   116: monitorexit
    //   117: return
    //   118: astore_2
    //   119: aload_1
    //   120: monitorexit
    //   121: aload_2
    //   122: athrow
    //   123: astore_2
    //   124: goto -13 -> 111
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	127	0	this	f
    //   41	74	2	localObject2	Object
    //   118	4	2	localObject3	Object
    //   123	1	2	localException	java.lang.Exception
    // Exception table:
    //   from	to	target	type
    //   27	42	118	finally
    //   46	50	118	finally
    //   50	65	118	finally
    //   69	73	118	finally
    //   73	93	118	finally
    //   97	101	118	finally
    //   101	111	118	finally
    //   111	115	118	finally
    //   27	42	123	java/lang/Exception
    //   46	50	123	java/lang/Exception
    //   50	65	123	java/lang/Exception
    //   69	73	123	java/lang/Exception
    //   73	93	123	java/lang/Exception
    //   97	101	123	java/lang/Exception
    //   101	111	123	java/lang/Exception
  }
  
  protected final void setPause(boolean paramBoolean)
  {
    this.hJi = paramBoolean;
  }
  
  public abstract void startDecode();
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes9.jar
 * Qualified Name:     com.tencent.mm.media.d.f
 * JD-Core Version:    0.7.0.1
 */