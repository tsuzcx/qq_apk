package com.tencent.mm.plugin.appbrand.jsapi.video.e.a;

import android.os.Handler;
import com.google.android.exoplayer2.h.d;
import com.google.android.exoplayer2.h.d.a;
import com.google.android.exoplayer2.h.j;
import com.google.android.exoplayer2.h.w;
import com.google.android.exoplayer2.i.c;
import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import kotlin.Metadata;
import kotlin.g.b.s;

@Metadata(d1={""}, d2={"Lcom/tencent/mm/plugin/appbrand/jsapi/video/player/advance/AdvanceBandwidthMeter;", "Lcom/google/android/exoplayer2/upstream/BandwidthMeter;", "Lcom/google/android/exoplayer2/upstream/TransferListener;", "", "eventHandler", "Landroid/os/Handler;", "eventListener", "Lcom/google/android/exoplayer2/upstream/BandwidthMeter$EventListener;", "maxWeight", "", "clock", "Lcom/google/android/exoplayer2/util/Clock;", "(Landroid/os/Handler;Lcom/google/android/exoplayer2/upstream/BandwidthMeter$EventListener;ILcom/google/android/exoplayer2/util/Clock;)V", "bitrateEstimate", "", "sampleBytesTransferred", "sampleStartTimeMs", "slidingPercentile", "Lcom/tencent/mm/plugin/appbrand/jsapi/video/player/advance/AdvanceSliding;", "streamCount", "totalBytesTransferred", "totalElapsedTimeMs", "getBitrateEstimate", "notifyBandwidthSample", "", "elapsedMs", "bytes", "bitrate", "onBytesTransferred", "source", "onTransferEnd", "onTransferStart", "dataSpec", "Lcom/google/android/exoplayer2/upstream/DataSpec;", "resetBizrateEstimate", "Companion", "luggage-commons-jsapi-video-ext_release"}, k=1, mv={1, 5, 1}, xi=48)
public final class a
  implements d, w<Object>
{
  public static final a.a sFo;
  private static final int sFq;
  private static final long sFr;
  private static final long sFs;
  private final d.a dip;
  private final c dis;
  private int dit;
  private long diu;
  private long div;
  private long diw;
  private long dix;
  long diy;
  private final Handler eventHandler;
  private final b sFp;
  
  static
  {
    AppMethodBeat.i(328665);
    sFo = new a.a((byte)0);
    sFq = 2000;
    sFr = 2000L;
    sFs = 524288L;
    AppMethodBeat.o(328665);
  }
  
  public a(byte paramByte)
  {
    this();
  }
  
  private a(int paramInt, c paramc)
  {
    AppMethodBeat.i(328642);
    this.eventHandler = null;
    this.dip = null;
    this.dis = paramc;
    this.sFp = new b(paramInt);
    this.diy = -1L;
    AppMethodBeat.o(328642);
  }
  
  private static final void a(a parama, int paramInt, long paramLong1, long paramLong2)
  {
    AppMethodBeat.i(328658);
    s.u(parama, "this$0");
    AppMethodBeat.o(328658);
  }
  
  public final long Ui()
  {
    try
    {
      long l = this.diy;
      return l;
    }
    finally
    {
      localObject = finally;
      throw localObject;
    }
  }
  
  public final void a(Object paramObject, j paramj)
  {
    try
    {
      AppMethodBeat.i(328683);
      s.u(paramObject, "source");
      s.u(paramj, "dataSpec");
      if (this.dit == 0) {
        this.diu = this.dis.elapsedRealtime();
      }
      this.dit += 1;
      AppMethodBeat.o(328683);
      return;
    }
    finally {}
  }
  
  public final void bj(Object paramObject)
  {
    int j = 1;
    long l2;
    int m;
    float f1;
    int i;
    int k;
    for (;;)
    {
      b localb;
      try
      {
        AppMethodBeat.i(328702);
        s.u(paramObject, "source");
        if (this.dit > 0)
        {
          bool = true;
          com.google.android.exoplayer2.i.a.checkState(bool);
          l2 = this.dis.elapsedRealtime();
          m = (int)(l2 - this.diu);
          this.diw += m;
          this.dix += this.div;
          if (m <= 0) {
            break label555;
          }
          f1 = (float)(this.div * 8000L / m);
          localb = this.sFp;
          i = (int)Math.sqrt(this.div);
          if (localb.dkK != 1)
          {
            Collections.sort((List)localb.dkI, b.dkF);
            localb.dkK = 1;
          }
          if (localb.dkN <= 0) {
            break label369;
          }
          paramObject = localb.sFu;
          localb.dkN -= 1;
          paramObject = paramObject[localb.dkN];
          s.checkNotNull(paramObject);
          k = localb.dkL;
          localb.dkL = (k + 1);
          paramObject.index = k;
          paramObject.weight = i;
          paramObject.value = f1;
          localb.dkI.add(paramObject);
          localb.dkM += i;
          if (localb.dkM <= localb.dkH) {
            break;
          }
          i = localb.dkM - localb.dkH;
          paramObject = localb.dkI.get(0);
          s.s(paramObject, "this.samples[0]");
          paramObject = (b.b)paramObject;
          if (paramObject.weight > i) {
            break label380;
          }
          localb.dkM -= paramObject.weight;
          localb.dkI.remove(0);
          if (localb.dkN >= 5) {
            continue;
          }
          b.b[] arrayOfb = localb.sFu;
          i = localb.dkN;
          localb.dkN = (i + 1);
          arrayOfb[i] = paramObject;
          continue;
        }
        boolean bool = false;
      }
      finally {}
      continue;
      label369:
      paramObject = new b.b();
      continue;
      label380:
      paramObject.weight -= i;
      localb.dkM -= i;
    }
    if ((this.diw >= sFr) || (this.dix >= sFs))
    {
      paramObject = this.sFp;
      int n = paramObject.dkI.size() - 1;
      if (n < 0) {
        break label685;
      }
      f1 = 0.0F;
      i = 0;
      k = i + 1;
      float f2 = ((b.b)paramObject.dkI.get(i)).weight / paramObject.dkM;
      f1 = ((b.b)paramObject.dkI.get(i)).value * f2 + f1;
      if (k <= n) {
        break label678;
      }
      break label687;
      label514:
      if (i != 0)
      {
        if (!paramObject.dkI.isEmpty()) {
          break label645;
        }
        f1 = -1.0F;
      }
      label533:
      if (Float.isNaN(f1)) {
        break label700;
      }
      if (f1 >= 0.0F) {
        break label671;
      }
      break label700;
    }
    for (;;)
    {
      label549:
      Object localObject;
      this.diy = localObject;
      label555:
      long l1 = this.div;
      long l3 = this.diy;
      if ((this.eventHandler != null) && (this.dip != null)) {
        this.eventHandler.post(new a..ExternalSyntheticLambda0(this, m, l1, l3));
      }
      this.dit -= 1;
      if (this.dit > 0) {
        this.diu = l2;
      }
      this.div = 0L;
      AppMethodBeat.o(328702);
      return;
      label645:
      label671:
      label678:
      label685:
      label687:
      do
      {
        i = 0;
        break label514;
        f1 = ((b.b)paramObject.dkI.get(paramObject.dkI.size() - 1)).value;
        break label533;
        l1 = f1;
        break label549;
        i = k;
        break;
        f1 = 0.0F;
      } while (f1 != 0.0F);
      i = j;
      break label514;
      label700:
      l1 = -1L;
    }
  }
  
  public final void f(Object paramObject, int paramInt)
  {
    try
    {
      AppMethodBeat.i(328689);
      s.u(paramObject, "source");
      this.div += paramInt;
      AppMethodBeat.o(328689);
      return;
    }
    finally
    {
      paramObject = finally;
      throw paramObject;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes11.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.jsapi.video.e.a.a
 * JD-Core Version:    0.7.0.1
 */