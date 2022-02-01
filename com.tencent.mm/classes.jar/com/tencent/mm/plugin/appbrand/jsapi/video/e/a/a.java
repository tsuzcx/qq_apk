package com.tencent.mm.plugin.appbrand.jsapi.video.e.a;

import android.os.Handler;
import com.google.android.exoplayer2.h.d;
import com.google.android.exoplayer2.h.d.a;
import com.google.android.exoplayer2.h.j;
import com.google.android.exoplayer2.h.w;
import com.google.android.exoplayer2.i.c;
import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.List;
import kotlin.g.b.p;
import kotlin.l;

@l(hxD={1, 1, 16}, hxE={""}, hxF={"Lcom/tencent/mm/plugin/appbrand/jsapi/video/player/advance/AdvanceBandwidthMeter;", "Lcom/google/android/exoplayer2/upstream/BandwidthMeter;", "Lcom/google/android/exoplayer2/upstream/TransferListener;", "", "eventHandler", "Landroid/os/Handler;", "eventListener", "Lcom/google/android/exoplayer2/upstream/BandwidthMeter$EventListener;", "maxWeight", "", "clock", "Lcom/google/android/exoplayer2/util/Clock;", "(Landroid/os/Handler;Lcom/google/android/exoplayer2/upstream/BandwidthMeter$EventListener;ILcom/google/android/exoplayer2/util/Clock;)V", "bitrateEstimate", "", "sampleBytesTransferred", "sampleStartTimeMs", "slidingPercentile", "Lcom/tencent/mm/plugin/appbrand/jsapi/video/player/advance/AdvanceSliding;", "streamCount", "totalBytesTransferred", "totalElapsedTimeMs", "getBitrateEstimate", "notifyBandwidthSample", "", "elapsedMs", "bytes", "bitrate", "onBytesTransferred", "source", "onTransferEnd", "onTransferStart", "dataSpec", "Lcom/google/android/exoplayer2/upstream/DataSpec;", "resetBizrateEstimate", "Companion", "luggage-commons-jsapi-video-ext_release"})
public final class a
  implements d, w<Object>
{
  private static final int mBA = 2000;
  private static final long mBB = 2000L;
  private static final long mBC = 524288L;
  public static final a.a mBD;
  private final d.a bEX;
  private final c bEZ;
  private int bFa;
  private long bFb;
  private long bFc;
  private long bFd;
  private long bFe;
  long bFf;
  private final Handler eventHandler;
  private final b mBz;
  
  static
  {
    AppMethodBeat.i(235229);
    mBD = new a.a((byte)0);
    mBA = 2000;
    mBB = 2000L;
    mBC = 524288L;
    AppMethodBeat.o(235229);
  }
  
  public a(byte paramByte)
  {
    this();
  }
  
  private a(int paramInt, c paramc)
  {
    AppMethodBeat.i(235227);
    this.eventHandler = null;
    this.bEX = null;
    this.bEZ = paramc;
    this.mBz = new b(paramInt);
    this.bFf = -1L;
    AppMethodBeat.o(235227);
  }
  
  public final void a(Object paramObject, j paramj)
  {
    try
    {
      AppMethodBeat.i(235224);
      p.h(paramObject, "source");
      p.h(paramj, "dataSpec");
      if (this.bFa == 0) {
        this.bFb = this.bEZ.elapsedRealtime();
      }
      this.bFa += 1;
      AppMethodBeat.o(235224);
      return;
    }
    finally {}
  }
  
  public final void ai(Object paramObject)
  {
    int i = 0;
    long l2;
    final int j;
    float f1;
    int k;
    for (;;)
    {
      b localb;
      try
      {
        AppMethodBeat.i(235226);
        p.h(paramObject, "source");
        if (this.bFa > 0)
        {
          bool = true;
          com.google.android.exoplayer2.i.a.checkState(bool);
          l2 = this.bEZ.elapsedRealtime();
          j = (int)(l2 - this.bFb);
          this.bFd += j;
          this.bFe += this.bFc;
          if (j <= 0) {
            break label554;
          }
          f1 = (float)(this.bFc * 8000L / j);
          localb = this.mBz;
          k = (int)Math.sqrt(this.bFc);
          if (localb.bHz != 1)
          {
            Collections.sort((List)localb.bHx, b.bHu);
            localb.bHz = 1;
          }
          if (localb.bHC <= 0) {
            break label372;
          }
          paramObject = localb.mBI;
          localb.bHC -= 1;
          paramObject = paramObject[localb.bHC];
          if (paramObject == null) {
            p.hyc();
          }
          int m = localb.bHA;
          localb.bHA = (m + 1);
          paramObject.index = m;
          paramObject.weight = k;
          paramObject.value = f1;
          localb.bHx.add(paramObject);
          localb.bHB += k;
          if (localb.bHB <= localb.bHw) {
            break;
          }
          k = localb.bHB - localb.bHw;
          paramObject = localb.bHx.get(0);
          p.g(paramObject, "this.samples[0]");
          paramObject = (b.d)paramObject;
          if (paramObject.weight > k) {
            break label383;
          }
          localb.bHB -= paramObject.weight;
          localb.bHx.remove(0);
          if (localb.bHC >= 5) {
            continue;
          }
          b.d[] arrayOfd = localb.mBI;
          k = localb.bHC;
          localb.bHC = (k + 1);
          arrayOfd[k] = paramObject;
          continue;
        }
        boolean bool = false;
      }
      finally {}
      continue;
      label372:
      paramObject = new b.d();
      continue;
      label383:
      paramObject.weight -= k;
      localb.bHB -= k;
    }
    if ((this.bFd >= mBB) || (this.bFe >= mBC))
    {
      paramObject = this.mBz;
      k = ((Collection)paramObject.bHx).size();
      f1 = 0.0F;
      while (i < k)
      {
        float f2 = ((b.d)paramObject.bHx.get(i)).weight / paramObject.bHB;
        f1 += ((b.d)paramObject.bHx.get(i)).value * f2;
        i += 1;
      }
      if (f1 != 0.0F) {
        break label674;
      }
      if (!paramObject.bHx.isEmpty()) {
        break label641;
      }
      f1 = -1.0F;
      if (Float.isNaN(f1)) {
        break label677;
      }
      if (f1 >= 0.0F) {
        break label667;
      }
      break label677;
    }
    for (;;)
    {
      Object localObject;
      this.bFf = localObject;
      label554:
      final long l1 = this.bFc;
      long l3 = this.bFf;
      if ((this.eventHandler != null) && (this.bEX != null)) {
        this.eventHandler.post((Runnable)new b(this, j, l1, l3));
      }
      this.bFa -= 1;
      if (this.bFa > 0) {
        this.bFb = l2;
      }
      this.bFc = 0L;
      AppMethodBeat.o(235226);
      return;
      label641:
      f1 = ((b.d)paramObject.bHx.get(paramObject.bHx.size() - 1)).value;
      break;
      label667:
      l1 = f1;
      continue;
      label674:
      break;
      label677:
      l1 = -1L;
    }
  }
  
  public final void d(Object paramObject, int paramInt)
  {
    try
    {
      AppMethodBeat.i(235225);
      p.h(paramObject, "source");
      this.bFc += paramInt;
      AppMethodBeat.o(235225);
      return;
    }
    finally
    {
      paramObject = finally;
      throw paramObject;
    }
  }
  
  public final long wE()
  {
    try
    {
      long l = this.bFf;
      return l;
    }
    finally
    {
      localObject = finally;
      throw localObject;
    }
  }
  
  @l(hxD={1, 1, 16}, hxE={""}, hxF={"<anonymous>", "", "run"})
  static final class b
    implements Runnable
  {
    b(a parama, int paramInt, long paramLong1, long paramLong2) {}
    
    public final void run()
    {
      AppMethodBeat.i(235223);
      a.a(this.mBE);
      AppMethodBeat.o(235223);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes8.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.jsapi.video.e.a.a
 * JD-Core Version:    0.7.0.1
 */