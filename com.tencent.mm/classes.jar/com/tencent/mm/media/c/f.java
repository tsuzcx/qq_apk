package com.tencent.mm.media.c;

import android.media.MediaCodec.BufferInfo;
import android.media.MediaFormat;
import android.os.Looper;
import android.view.Surface;
import com.tencent.mm.compatible.deviceinfo.z;
import com.tencent.mm.plugin.report.service.h;
import com.tencent.mm.plugin.sight.base.e;
import com.tencent.mm.sdk.platformtools.ac;
import com.tencent.mm.sdk.platformtools.bs;
import d.a.j;
import d.g.a.r;
import d.g.b.k;
import d.l;
import d.o;
import d.y;
import java.nio.ByteBuffer;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.PriorityQueue;
import java.util.concurrent.Semaphore;

@l(fNY={1, 1, 16}, fNZ={""}, fOa={"Lcom/tencent/mm/media/decoder/IMediaCodecTransDecoder;", "", "startTimeMs", "", "endTimeMs", "mediaExtractorWrapper", "Lcom/tencent/mm/media/extractor/MediaExtractorWrapper;", "decodeSurface", "Landroid/view/Surface;", "outputFps", "", "(JJLcom/tencent/mm/media/extractor/MediaExtractorWrapper;Landroid/view/Surface;I)V", "TAG", "", "bFrameNum", "decodeHelper", "Lcom/tencent/mm/media/decoder/DecodeHelper;", "getDecodeHelper", "()Lcom/tencent/mm/media/decoder/DecodeHelper;", "setDecodeHelper", "(Lcom/tencent/mm/media/decoder/DecodeHelper;)V", "decodePts", "getDecodeSurface", "()Landroid/view/Surface;", "setDecodeSurface", "(Landroid/view/Surface;)V", "decoder", "Lcom/tencent/mm/compatible/deviceinfo/MediaCodecProxy;", "getDecoder", "()Lcom/tencent/mm/compatible/deviceinfo/MediaCodecProxy;", "setDecoder", "(Lcom/tencent/mm/compatible/deviceinfo/MediaCodecProxy;)V", "decoderLock", "Ljava/lang/Object;", "getDecoderLock", "()Ljava/lang/Object;", "getEndTimeMs", "()J", "setEndTimeMs", "(J)V", "frameCount", "frameDropInterval", "frameDuration", "", "getFrameDuration", "()F", "setFrameDuration", "(F)V", "hasBFrame", "", "isFinished", "()Z", "setFinished", "(Z)V", "isPause", "setPause", "lastDecodePts", "getMediaExtractorWrapper", "()Lcom/tencent/mm/media/extractor/MediaExtractorWrapper;", "mediaFormat", "Landroid/media/MediaFormat;", "getMediaFormat", "()Landroid/media/MediaFormat;", "setMediaFormat", "(Landroid/media/MediaFormat;)V", "onDecodeDataCallback", "Lkotlin/Function4;", "Ljava/nio/ByteBuffer;", "Lkotlin/ParameterName;", "name", "decodeData", "pts", "Landroid/media/MediaCodec$BufferInfo;", "bufferInfo", "duplicate", "", "getOnDecodeDataCallback", "()Lkotlin/jvm/functions/Function4;", "setOnDecodeDataCallback", "(Lkotlin/jvm/functions/Function4;)V", "onDecodeEnd", "Lkotlin/Function0;", "getOnDecodeEnd", "()Lkotlin/jvm/functions/Function0;", "setOnDecodeEnd", "(Lkotlin/jvm/functions/Function0;)V", "onFormatChanged", "Lkotlin/Function1;", "getOnFormatChanged", "()Lkotlin/jvm/functions/Function1;", "setOnFormatChanged", "(Lkotlin/jvm/functions/Function1;)V", "pauseSemaphore", "Ljava/util/concurrent/Semaphore;", "ptsList", "Ljava/util/ArrayList;", "Lkotlin/collections/ArrayList;", "getStartTimeMs", "setStartTimeMs", "useInRemuxer", "getUseInRemuxer", "setUseInRemuxer", "videoFps", "getVideoFps", "()I", "setVideoFps", "(I)V", "getBFrameNum", "getFrameCount", "getFrameDropInterval", "getVideoFormat", "isDecoderPause", "onDecode", "callback", "processDecodeOutputBuffer", "bufferIndex", "releaseDecoder", "setFrameDropInterval", "interval", "setPauseDecoder", "pause", "startDecode", "useInRemux", "plugin-mediaeditor_release"})
public abstract class f
{
  public final String TAG;
  long bvf;
  protected volatile boolean dhO;
  private int frameCount;
  public r<? super ByteBuffer, ? super Long, ? super MediaCodec.BufferInfo, ? super Boolean, y> gOF;
  public d.g.a.a<y> gOG;
  public d.g.a.b<? super MediaFormat, y> gOH;
  public int gOI;
  private final Semaphore gOJ;
  final Object gOK;
  private float gOL;
  private b gOM;
  public boolean gON;
  private long gOO;
  private long gOP;
  private volatile boolean gOQ;
  private volatile int gOR;
  private ArrayList<Long> gOS;
  protected Surface gOT;
  z gOr;
  final com.tencent.mm.media.e.a gOy;
  long gOz;
  volatile boolean gnd;
  public MediaFormat mediaFormat;
  private int videoFps;
  
  public f(long paramLong1, long paramLong2, com.tencent.mm.media.e.a parama, Surface paramSurface, int paramInt)
  {
    this.bvf = paramLong1;
    this.gOz = paramLong2;
    this.gOy = parama;
    this.gOT = paramSurface;
    this.TAG = "MicroMsg.IMediaCodecTransDecoder";
    this.gOJ = new Semaphore(1);
    this.gOK = new Object();
    this.gOO = -1L;
    this.gOP = -1L;
    this.gOS = new ArrayList();
    ac.i(this.TAG, "create IMediaCodecTransDecoder, startTimeMs:" + this.bvf + ", endTimeMs:" + this.gOz);
    parama = this.gOy;
    if (parama != null) {
      parama.aqL();
    }
    if (this.bvf >= 0L)
    {
      parama = this.gOy;
      if (parama != null) {
        parama.seek(this.bvf * 1000L);
      }
    }
    parama = this.gOy;
    if (parama != null) {}
    for (parama = parama.filePath;; parama = null)
    {
      this.gOM = new b(parama, paramInt, this.bvf * 1000L);
      this.gOR = 0;
      return;
    }
  }
  
  protected final void a(int paramInt, MediaCodec.BufferInfo paramBufferInfo)
  {
    boolean bool4 = true;
    boolean bool3 = true;
    k.h(paramBufferInfo, "bufferInfo");
    Object localObject2;
    Object localObject1;
    label101:
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
          localObject1 = this.gOy;
          if (localObject1 == null) {
            break label721;
          }
          localObject1 = ((com.tencent.mm.media.e.a)localObject1).gRI;
        }
      }
      if ((localObject1 == null) || (((MediaFormat)localObject1).containsKey("frame-rate"))) {
        break label738;
      }
      localObject1 = this.gOy;
      if (localObject1 == null) {
        break label727;
      }
      localObject1 = ((com.tencent.mm.media.e.a)localObject1).filePath;
      localObject1 = e.asx((String)localObject1);
      if (localObject1 == null) {
        break label733;
      }
      i = ((com.tencent.mm.plugin.sight.base.a)localObject1).frameRate;
      label119:
      this.videoFps = i;
      if (this.videoFps > 0) {
        this.gOL = (1000.0F / this.videoFps);
      }
    }
    if (this.videoFps <= 0) {
      h.wUl.A(986L, 104L);
    }
    for (boolean bool1 = false;; bool1 = true)
    {
      this.frameCount += 1;
      this.gOO = paramBufferInfo.presentationTimeUs;
      localObject1 = this.TAG;
      localObject2 = new StringBuilder("processDecodeOutputBuffer, usePts:").append(bool1).append(", pts: ").append(paramBufferInfo.presentationTimeUs).append(", frameDuration:").append(this.gOL).append(", frameCount:").append(this.frameCount).append(", startTimeMs:").append(this.bvf).append(", size: ").append(paramBufferInfo.size).append(", isKeyFrame:");
      boolean bool2;
      label291:
      long l1;
      if ((paramBufferInfo.flags & 0x1) == 1)
      {
        bool2 = true;
        ac.i((String)localObject1, bool2 + ", isMain:" + k.g(Looper.myLooper(), Looper.getMainLooper()));
        if ((this.gOP > 0L) && (this.gOO < this.gOP))
        {
          this.gOQ = true;
          this.gOR += 1;
          ac.i(this.TAG, "processDecodeOutputBuffer has B Frame, decodePts:" + this.gOO + ", lastDecodePts:" + this.gOP + ", bFrameNum:" + this.gOR);
        }
        this.gOP = this.gOO;
        if (!bool1) {
          break label1370;
        }
        l1 = paramBufferInfo.presentationTimeUs;
        localObject1 = this.gOM;
        ac.i("DecodeHelper", "sendPacket, pts:" + l1 + ", recentPts:" + ((b)localObject1).gOf + ", parents[" + l1 + "]:" + (Long)((b)localObject1).gOh.get(Long.valueOf(l1)) + ", lastPts:" + ((b)localObject1).gOg);
        if ((l1 == ((b)localObject1).gOf) || ((l1 <= ((b)localObject1).gOg) && (!((Map)((b)localObject1).gOh).containsKey(Long.valueOf(l1))))) {
          break label771;
        }
        ((b)localObject1).bwN.add(new o(Long.valueOf(l1), Integer.valueOf(paramInt)));
        i = 1;
      }
      int k;
      for (;;)
      {
        if (i == 0)
        {
          ac.i(this.TAG, "processDecodeOutputBuffer sendPacket return false");
          localObject1 = this.gOr;
          if (localObject1 != null) {
            ((z)localObject1).releaseOutputBuffer(paramInt, false);
          }
          k = 1;
          if (k == 0)
          {
            ac.e(this.TAG, "processDecodeOutputBuffer still not release buffer fallback release it");
            localObject1 = this.gOr;
            if (localObject1 != null)
            {
              if (this.gOT == null) {
                break label1321;
              }
              bool1 = bool3;
              label668:
              ((z)localObject1).releaseOutputBuffer(paramInt, bool1);
            }
            if (!this.gOS.contains(Long.valueOf(l1))) {
              break label1327;
            }
            localObject1 = this.gOF;
            if (localObject1 != null) {
              ((r)localObject1).a(null, Long.valueOf(l1), paramBufferInfo, Boolean.TRUE);
            }
          }
          label720:
          return;
          label721:
          localObject1 = null;
          break;
          label727:
          localObject1 = null;
          break label101;
          label733:
          i = 0;
          break label119;
          label738:
          if (localObject1 != null) {}
          for (i = ((MediaFormat)localObject1).getInteger("frame-rate");; i = 0)
          {
            this.videoFps = i;
            break;
          }
          bool2 = false;
          break label291;
          label771:
          i = 0;
          continue;
          label776:
          i = 1;
        }
      }
      for (;;)
      {
        localObject1 = this.gOM;
        int j;
        long l2;
        if (!((Collection)((b)localObject1).bwN).isEmpty())
        {
          j = 1;
          if (j == 0) {
            break label1241;
          }
          l2 = ((Number)((o)((b)localObject1).bwN.peek()).first).longValue();
          if (l2 <= ((b)localObject1).gOg) {
            break label1211;
          }
          j = 1;
          label844:
          k = i;
          if (j == 0) {
            break;
          }
          ac.i(this.TAG, "decode hasFrame");
          localObject1 = this.gOM;
          localObject2 = (o)((b)localObject1).bwN.poll();
          l2 = ((Number)((o)localObject2).first).longValue();
          j = ((Number)((o)localObject2).second).intValue();
          ((b)localObject1).gOf = l2;
          localObject2 = ((Map)((b)localObject1).gOi).get(Long.valueOf(l2));
          localObject1 = localObject2;
          if (localObject2 == null) {
            localObject1 = j.listOf(Long.valueOf(l2));
          }
          localObject2 = new o(localObject1, Integer.valueOf(j));
          localObject1 = (List)((o)localObject2).first;
          k = ((Number)((o)localObject2).second).intValue();
          ac.i(this.TAG, "processDecodeOutputBuffer, duplicate frame size:" + ((List)localObject1).size() + ", bufferInfo pts:" + paramBufferInfo.presentationTimeUs);
          if (((Collection)localObject1).isEmpty()) {
            break label1264;
          }
          j = 1;
          label1051:
          if (j == 0) {
            break label1438;
          }
          localObject2 = this.gOr;
          if (localObject2 != null)
          {
            if (this.gOT == null) {
              break label1270;
            }
            bool1 = true;
            label1077:
            ((z)localObject2).releaseOutputBuffer(k, bool1);
          }
          localObject1 = ((Iterable)localObject1).iterator();
        }
        for (;;)
        {
          if (!((Iterator)localObject1).hasNext()) {
            break label1319;
          }
          l2 = ((Number)((Iterator)localObject1).next()).longValue();
          ac.i(this.TAG, "processDecodeOutputBuffer, duplicate frame, pts: " + l2 + ", bufferInfo: " + paramBufferInfo);
          if (this.gOS.contains(Long.valueOf(l1)))
          {
            localObject2 = this.gOF;
            if (localObject2 == null) {
              continue;
            }
            ((r)localObject2).a(null, Long.valueOf(l1), paramBufferInfo, Boolean.TRUE);
            continue;
            j = 0;
            break;
            label1211:
            localObject2 = (Long)((b)localObject1).gOh.get(Long.valueOf(l2));
            l2 = ((b)localObject1).gOf;
            if (localObject2 == null) {}
            label1241:
            while (((Long)localObject2).longValue() != l2)
            {
              j = 0;
              break;
            }
            j = 1;
            break label844;
            label1264:
            j = 0;
            break label1051;
            label1270:
            bool1 = false;
            break label1077;
          }
          this.gOS.add(Long.valueOf(l1));
          localObject2 = this.gOF;
          if (localObject2 != null) {
            ((r)localObject2).a(null, Long.valueOf(l1), paramBufferInfo, Boolean.FALSE);
          }
        }
        label1319:
        break label776;
        label1321:
        bool1 = false;
        break label668;
        label1327:
        this.gOS.add(Long.valueOf(l1));
        localObject1 = this.gOF;
        if (localObject1 == null) {
          break label720;
        }
        ((r)localObject1).a(null, Long.valueOf(l1), paramBufferInfo, Boolean.FALSE);
        return;
        label1370:
        localObject1 = this.gOr;
        if (localObject1 != null) {
          if (this.gOT == null) {
            break label1432;
          }
        }
        label1432:
        for (bool1 = bool4;; bool1 = false)
        {
          ((z)localObject1).releaseOutputBuffer(paramInt, bool1);
          localObject1 = this.gOF;
          if (localObject1 == null) {
            break;
          }
          ((r)localObject1).a(null, Long.valueOf(paramBufferInfo.presentationTimeUs), paramBufferInfo, Boolean.FALSE);
          return;
        }
        label1438:
        continue;
        i = 0;
      }
    }
  }
  
  public void dZ(boolean paramBoolean)
  {
    long l = bs.Gn();
    this.dhO = paramBoolean;
    ac.d(this.TAG, "setPauseDecoder:" + paramBoolean + ", remain:" + this.gOJ.availablePermits() + ", thread:" + Thread.currentThread() + ' ' + l);
    if (paramBoolean)
    {
      ac.d(this.TAG, "try acquire, thread:" + Thread.currentThread() + ' ' + l);
      this.gOJ.acquire();
    }
    for (;;)
    {
      ac.d(this.TAG, "after setPauseDecoder:" + paramBoolean + ", remain:" + this.gOJ.availablePermits() + ", thread:" + Thread.currentThread() + ' ' + l);
      return;
      ac.d(this.TAG, "release, thread:" + Thread.currentThread() + ' ' + l);
      this.gOJ.release();
    }
  }
  
  /* Error */
  public void releaseDecoder()
  {
    // Byte code:
    //   0: aload_0
    //   1: getfield 182	com/tencent/mm/media/c/f:TAG	Ljava/lang/String;
    //   4: new 203	java/lang/StringBuilder
    //   7: dup
    //   8: ldc_w 570
    //   11: invokespecial 208	java/lang/StringBuilder:<init>	(Ljava/lang/String;)V
    //   14: aload_0
    //   15: invokevirtual 573	com/tencent/mm/media/c/f:hashCode	()I
    //   18: invokevirtual 326	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   21: invokevirtual 221	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   24: invokestatic 227	com/tencent/mm/sdk/platformtools/ac:i	(Ljava/lang/String;Ljava/lang/String;)V
    //   27: aload_0
    //   28: getfield 190	com/tencent/mm/media/c/f:gOK	Ljava/lang/Object;
    //   31: astore_1
    //   32: aload_1
    //   33: monitorenter
    //   34: aload_0
    //   35: getfield 247	com/tencent/mm/media/c/f:gOM	Lcom/tencent/mm/media/c/b;
    //   38: getfield 407	com/tencent/mm/media/c/b:bwN	Ljava/util/PriorityQueue;
    //   41: invokevirtual 576	java/util/PriorityQueue:clear	()V
    //   44: aload_0
    //   45: getfield 426	com/tencent/mm/media/c/f:gOr	Lcom/tencent/mm/compatible/deviceinfo/z;
    //   48: astore_2
    //   49: aload_2
    //   50: ifnull +7 -> 57
    //   53: aload_2
    //   54: invokevirtual 579	com/tencent/mm/compatible/deviceinfo/z:stop	()V
    //   57: aload_0
    //   58: getfield 182	com/tencent/mm/media/c/f:TAG	Ljava/lang/String;
    //   61: ldc_w 581
    //   64: invokestatic 227	com/tencent/mm/sdk/platformtools/ac:i	(Ljava/lang/String;Ljava/lang/String;)V
    //   67: aload_0
    //   68: getfield 426	com/tencent/mm/media/c/f:gOr	Lcom/tencent/mm/compatible/deviceinfo/z;
    //   71: astore_2
    //   72: aload_2
    //   73: ifnull +7 -> 80
    //   76: aload_2
    //   77: invokevirtual 582	com/tencent/mm/compatible/deviceinfo/z:release	()V
    //   80: aload_0
    //   81: getfield 182	com/tencent/mm/media/c/f:TAG	Ljava/lang/String;
    //   84: ldc_w 584
    //   87: invokestatic 227	com/tencent/mm/sdk/platformtools/ac:i	(Ljava/lang/String;Ljava/lang/String;)V
    //   90: aload_0
    //   91: iconst_1
    //   92: putfield 586	com/tencent/mm/media/c/f:gnd	Z
    //   95: aload_0
    //   96: getfield 178	com/tencent/mm/media/c/f:gOT	Landroid/view/Surface;
    //   99: astore_2
    //   100: aload_2
    //   101: ifnull +7 -> 108
    //   104: aload_2
    //   105: invokevirtual 589	android/view/Surface:release	()V
    //   108: aload_0
    //   109: getfield 182	com/tencent/mm/media/c/f:TAG	Ljava/lang/String;
    //   112: ldc_w 591
    //   115: invokestatic 227	com/tencent/mm/sdk/platformtools/ac:i	(Ljava/lang/String;Ljava/lang/String;)V
    //   118: getstatic 597	d/y:KTp	Ld/y;
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


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.media.c.f
 * JD-Core Version:    0.7.0.1
 */