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

@l(iBK={1, 1, 16}, iBL={""}, iBM={"Lcom/tencent/mm/plugin/appbrand/jsapi/video/player/advance/AdvanceBandwidthMeter;", "Lcom/google/android/exoplayer2/upstream/BandwidthMeter;", "Lcom/google/android/exoplayer2/upstream/TransferListener;", "", "eventHandler", "Landroid/os/Handler;", "eventListener", "Lcom/google/android/exoplayer2/upstream/BandwidthMeter$EventListener;", "maxWeight", "", "clock", "Lcom/google/android/exoplayer2/util/Clock;", "(Landroid/os/Handler;Lcom/google/android/exoplayer2/upstream/BandwidthMeter$EventListener;ILcom/google/android/exoplayer2/util/Clock;)V", "bitrateEstimate", "", "sampleBytesTransferred", "sampleStartTimeMs", "slidingPercentile", "Lcom/tencent/mm/plugin/appbrand/jsapi/video/player/advance/AdvanceSliding;", "streamCount", "totalBytesTransferred", "totalElapsedTimeMs", "getBitrateEstimate", "notifyBandwidthSample", "", "elapsedMs", "bytes", "bitrate", "onBytesTransferred", "source", "onTransferEnd", "onTransferStart", "dataSpec", "Lcom/google/android/exoplayer2/upstream/DataSpec;", "resetBizrateEstimate", "Companion", "luggage-commons-jsapi-video-ext_release"})
public final class a
  implements d, w<Object>
{
  private static final int pAi = 2000;
  private static final long pAj = 2000L;
  private static final long pAk = 524288L;
  public static final a.a pAl;
  private final d.a boA;
  private final c boC;
  private int boD;
  private long boE;
  private long boF;
  private long boG;
  private long boH;
  long boI;
  private final Handler eventHandler;
  private final b pAh;
  
  static
  {
    AppMethodBeat.i(226977);
    pAl = new a.a((byte)0);
    pAi = 2000;
    pAj = 2000L;
    pAk = 524288L;
    AppMethodBeat.o(226977);
  }
  
  public a(byte paramByte)
  {
    this();
  }
  
  private a(int paramInt, c paramc)
  {
    AppMethodBeat.i(226970);
    this.eventHandler = null;
    this.boA = null;
    this.boC = paramc;
    this.pAh = new b(paramInt);
    this.boI = -1L;
    AppMethodBeat.o(226970);
  }
  
  public final void a(Object paramObject, j paramj)
  {
    try
    {
      AppMethodBeat.i(226946);
      p.k(paramObject, "source");
      p.k(paramj, "dataSpec");
      if (this.boD == 0) {
        this.boE = this.boC.elapsedRealtime();
      }
      this.boD += 1;
      AppMethodBeat.o(226946);
      return;
    }
    finally {}
  }
  
  public final void aa(Object paramObject)
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
        AppMethodBeat.i(226967);
        p.k(paramObject, "source");
        if (this.boD > 0)
        {
          bool = true;
          com.google.android.exoplayer2.i.a.checkState(bool);
          l2 = this.boC.elapsedRealtime();
          j = (int)(l2 - this.boE);
          this.boG += j;
          this.boH += this.boF;
          if (j <= 0) {
            break label554;
          }
          f1 = (float)(this.boF * 8000L / j);
          localb = this.pAh;
          k = (int)Math.sqrt(this.boF);
          if (localb.brg != 1)
          {
            Collections.sort((List)localb.bre, b.brb);
            localb.brg = 1;
          }
          if (localb.brj <= 0) {
            break label372;
          }
          paramObject = localb.pAq;
          localb.brj -= 1;
          paramObject = paramObject[localb.brj];
          if (paramObject == null) {
            p.iCn();
          }
          int m = localb.brh;
          localb.brh = (m + 1);
          paramObject.index = m;
          paramObject.weight = k;
          paramObject.value = f1;
          localb.bre.add(paramObject);
          localb.bri += k;
          if (localb.bri <= localb.brd) {
            break;
          }
          k = localb.bri - localb.brd;
          paramObject = localb.bre.get(0);
          p.j(paramObject, "this.samples[0]");
          paramObject = (b.d)paramObject;
          if (paramObject.weight > k) {
            break label383;
          }
          localb.bri -= paramObject.weight;
          localb.bre.remove(0);
          if (localb.brj >= 5) {
            continue;
          }
          b.d[] arrayOfd = localb.pAq;
          k = localb.brj;
          localb.brj = (k + 1);
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
      localb.bri -= k;
    }
    if ((this.boG >= pAj) || (this.boH >= pAk))
    {
      paramObject = this.pAh;
      k = ((Collection)paramObject.bre).size();
      f1 = 0.0F;
      while (i < k)
      {
        float f2 = ((b.d)paramObject.bre.get(i)).weight / paramObject.bri;
        f1 += ((b.d)paramObject.bre.get(i)).value * f2;
        i += 1;
      }
      if (f1 != 0.0F) {
        break label674;
      }
      if (!paramObject.bre.isEmpty()) {
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
      this.boI = localObject;
      label554:
      final long l1 = this.boF;
      long l3 = this.boI;
      if ((this.eventHandler != null) && (this.boA != null)) {
        this.eventHandler.post((Runnable)new b(this, j, l1, l3));
      }
      this.boD -= 1;
      if (this.boD > 0) {
        this.boE = l2;
      }
      this.boF = 0L;
      AppMethodBeat.o(226967);
      return;
      label641:
      f1 = ((b.d)paramObject.bre.get(paramObject.bre.size() - 1)).value;
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
      AppMethodBeat.i(226948);
      p.k(paramObject, "source");
      this.boF += paramInt;
      AppMethodBeat.o(226948);
      return;
    }
    finally
    {
      paramObject = finally;
      throw paramObject;
    }
  }
  
  public final long uF()
  {
    try
    {
      long l = this.boI;
      return l;
    }
    finally
    {
      localObject = finally;
      throw localObject;
    }
  }
  
  @l(iBK={1, 1, 16}, iBL={""}, iBM={"<anonymous>", "", "run"})
  static final class b
    implements Runnable
  {
    b(a parama, int paramInt, long paramLong1, long paramLong2) {}
    
    public final void run()
    {
      AppMethodBeat.i(229399);
      a.a(this.pAm);
      AppMethodBeat.o(229399);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes9.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.jsapi.video.e.a.a
 * JD-Core Version:    0.7.0.1
 */