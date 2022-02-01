package com.tencent.mm.plugin.appbrand.jsapi.video.e.a;

import android.os.Handler;
import com.google.android.exoplayer2.h.d;
import com.google.android.exoplayer2.h.d.a;
import com.google.android.exoplayer2.h.j;
import com.google.android.exoplayer2.h.w;
import com.google.android.exoplayer2.i.c;
import com.tencent.matrix.trace.core.AppMethodBeat;
import d.g.b.p;
import d.l;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.List;

@l(gfx={1, 1, 16}, gfy={""}, gfz={"Lcom/tencent/mm/plugin/appbrand/jsapi/video/player/advance/AdvanceBandwidthMeter;", "Lcom/google/android/exoplayer2/upstream/BandwidthMeter;", "Lcom/google/android/exoplayer2/upstream/TransferListener;", "", "eventHandler", "Landroid/os/Handler;", "eventListener", "Lcom/google/android/exoplayer2/upstream/BandwidthMeter$EventListener;", "maxWeight", "", "clock", "Lcom/google/android/exoplayer2/util/Clock;", "(Landroid/os/Handler;Lcom/google/android/exoplayer2/upstream/BandwidthMeter$EventListener;ILcom/google/android/exoplayer2/util/Clock;)V", "bitrateEstimate", "", "sampleBytesTransferred", "sampleStartTimeMs", "slidingPercentile", "Lcom/tencent/mm/plugin/appbrand/jsapi/video/player/advance/AdvanceSliding;", "streamCount", "totalBytesTransferred", "totalElapsedTimeMs", "getBitrateEstimate", "notifyBandwidthSample", "", "elapsedMs", "bytes", "bitrate", "onBytesTransferred", "source", "onTransferEnd", "onTransferStart", "dataSpec", "Lcom/google/android/exoplayer2/upstream/DataSpec;", "resetBizrateEstimate", "Companion", "luggage-commons-jsapi-video-ext_release"})
public final class a
  implements d, w<Object>
{
  private static final int lqr = 2000;
  private static final long lqs = 2000L;
  private static final long lqt = 524288L;
  public static final a.a lqu;
  private final d.a bES;
  private final c bEU;
  private int bEV;
  private long bEW;
  private long bEX;
  private long bEY;
  private long bEZ;
  long bFa;
  private final Handler eventHandler;
  private final b lqq;
  
  static
  {
    AppMethodBeat.i(206516);
    lqu = new a.a((byte)0);
    lqr = 2000;
    lqs = 2000L;
    lqt = 524288L;
    AppMethodBeat.o(206516);
  }
  
  public a(byte paramByte)
  {
    this();
  }
  
  private a(int paramInt, c paramc)
  {
    AppMethodBeat.i(206514);
    this.eventHandler = null;
    this.bES = null;
    this.bEU = paramc;
    this.lqq = new b(paramInt);
    this.bFa = -1L;
    AppMethodBeat.o(206514);
  }
  
  public final void a(Object paramObject, j paramj)
  {
    try
    {
      AppMethodBeat.i(206511);
      p.h(paramObject, "source");
      p.h(paramj, "dataSpec");
      if (this.bEV == 0) {
        this.bEW = this.bEU.elapsedRealtime();
      }
      this.bEV += 1;
      AppMethodBeat.o(206511);
      return;
    }
    finally {}
  }
  
  public final void ah(Object paramObject)
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
        AppMethodBeat.i(206513);
        p.h(paramObject, "source");
        if (this.bEV > 0)
        {
          bool = true;
          com.google.android.exoplayer2.i.a.checkState(bool);
          l2 = this.bEU.elapsedRealtime();
          j = (int)(l2 - this.bEW);
          this.bEY += j;
          this.bEZ += this.bEX;
          if (j <= 0) {
            break label554;
          }
          f1 = (float)(this.bEX * 8000L / j);
          localb = this.lqq;
          k = (int)Math.sqrt(this.bEX);
          if (localb.bHi != 1)
          {
            Collections.sort((List)localb.bHg, b.bHd);
            localb.bHi = 1;
          }
          if (localb.bHl <= 0) {
            break label372;
          }
          paramObject = localb.lqz;
          localb.bHl -= 1;
          paramObject = paramObject[localb.bHl];
          if (paramObject == null) {
            p.gfZ();
          }
          int m = localb.bHj;
          localb.bHj = (m + 1);
          paramObject.index = m;
          paramObject.weight = k;
          paramObject.value = f1;
          localb.bHg.add(paramObject);
          localb.bHk += k;
          if (localb.bHk <= localb.bHf) {
            break;
          }
          k = localb.bHk - localb.bHf;
          paramObject = localb.bHg.get(0);
          p.g(paramObject, "this.samples[0]");
          paramObject = (b.d)paramObject;
          if (paramObject.weight > k) {
            break label383;
          }
          localb.bHk -= paramObject.weight;
          localb.bHg.remove(0);
          if (localb.bHl >= 5) {
            continue;
          }
          b.d[] arrayOfd = localb.lqz;
          k = localb.bHl;
          localb.bHl = (k + 1);
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
      localb.bHk -= k;
    }
    if ((this.bEY >= lqs) || (this.bEZ >= lqt))
    {
      paramObject = this.lqq;
      k = ((Collection)paramObject.bHg).size();
      f1 = 0.0F;
      while (i < k)
      {
        float f2 = ((b.d)paramObject.bHg.get(i)).weight / paramObject.bHk;
        f1 += ((b.d)paramObject.bHg.get(i)).value * f2;
        i += 1;
      }
      if (f1 != 0.0F) {
        break label674;
      }
      if (!paramObject.bHg.isEmpty()) {
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
      this.bFa = localObject;
      label554:
      final long l1 = this.bEX;
      long l3 = this.bFa;
      if ((this.eventHandler != null) && (this.bES != null)) {
        this.eventHandler.post((Runnable)new b(this, j, l1, l3));
      }
      this.bEV -= 1;
      if (this.bEV > 0) {
        this.bEW = l2;
      }
      this.bEX = 0L;
      AppMethodBeat.o(206513);
      return;
      label641:
      f1 = ((b.d)paramObject.bHg.get(paramObject.bHg.size() - 1)).value;
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
  
  public final void e(Object paramObject, int paramInt)
  {
    try
    {
      AppMethodBeat.i(206512);
      p.h(paramObject, "source");
      this.bEX += paramInt;
      AppMethodBeat.o(206512);
      return;
    }
    finally
    {
      paramObject = finally;
      throw paramObject;
    }
  }
  
  public final long wz()
  {
    try
    {
      long l = this.bFa;
      return l;
    }
    finally
    {
      localObject = finally;
      throw localObject;
    }
  }
  
  @l(gfx={1, 1, 16}, gfy={""}, gfz={"<anonymous>", "", "run"})
  static final class b
    implements Runnable
  {
    b(a parama, int paramInt, long paramLong1, long paramLong2) {}
    
    public final void run()
    {
      AppMethodBeat.i(206510);
      a.a(this.lqv);
      AppMethodBeat.o(206510);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.jsapi.video.e.a.a
 * JD-Core Version:    0.7.0.1
 */