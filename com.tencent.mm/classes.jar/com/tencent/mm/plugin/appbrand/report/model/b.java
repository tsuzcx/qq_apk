package com.tencent.mm.plugin.appbrand.report.model;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.appbrand.AppBrandRuntime;
import com.tencent.mm.plugin.appbrand.report.s;
import com.tencent.mm.plugin.appbrand.report.s.a;
import com.tencent.mm.plugin.appbrand.report.s.c;
import com.tencent.mm.plugin.appbrand.report.s.d;
import com.tencent.mm.sdk.platformtools.ad;
import com.tencent.mm.sdk.platformtools.bt;
import java.util.LinkedList;
import java.util.concurrent.atomic.AtomicInteger;

public class b
{
  public volatile AppBrandRuntime jzY;
  public volatile String mAppId;
  protected final s msp;
  public volatile String msq;
  public volatile long msr;
  public volatile long mss;
  private final LinkedList<Runnable> mst;
  
  public b(int paramInt)
  {
    AppMethodBeat.i(139925);
    this.msr = 0L;
    this.mss = 0L;
    this.mst = new LinkedList();
    this.msp = new s("MicroMsg.AppBrandPageViewStatistics[" + paramInt + "]");
    AppMethodBeat.o(139925);
  }
  
  public final long bxs()
  {
    AppMethodBeat.i(139926);
    long l = Math.max(0L, this.mss);
    AppMethodBeat.o(139926);
    return l;
  }
  
  public final long bxt()
  {
    AppMethodBeat.i(139927);
    if (1 == this.msp.mrN.get())
    {
      i = 1;
      if (i != 0) {
        break label69;
      }
      i = this.msp.mrN.get();
      if ((-1 != i) && (2 != i)) {
        break label64;
      }
    }
    label64:
    for (int i = 1;; i = 0)
    {
      if (i != 0) {
        break label69;
      }
      AppMethodBeat.o(139927);
      return 0L;
      i = 0;
      break;
    }
    label69:
    long l2 = this.msp.mrS;
    long l1 = this.msr;
    long l3 = this.mss;
    if (l2 <= 0L)
    {
      if ((this.jzY != null) && (this.jzY.SB)) {}
      for (boolean bool = true;; bool = false)
      {
        ad.i("MicroMsg.AppBrandPageViewStatistics", "foregroundMs invalid(%d), loadStart %d, loadCost %d, [%s/%s], runtimeIsFinishing=%b", new Object[] { Long.valueOf(l2), Long.valueOf(l1), Long.valueOf(l3), this.mAppId, this.msq, Boolean.valueOf(bool) });
        if ((l1 <= 0L) || (l3 <= 0L) || (l2 != 0L)) {
          break;
        }
        l2 = bt.flT();
        AppMethodBeat.o(139927);
        return l2 - l1;
      }
    }
    l1 = Math.max(0L, l2);
    AppMethodBeat.o(139927);
    return l1;
  }
  
  public final boolean isLoading()
  {
    return (this.msr > 0L) && (this.mss <= 0L);
  }
  
  public final void onBackground()
  {
    AppMethodBeat.i(194937);
    if (this.msp.bxp()) {
      while (!this.mst.isEmpty()) {
        ((Runnable)this.mst.pollFirst()).run();
      }
    }
    AppMethodBeat.o(194937);
  }
  
  public final void onDestroy()
  {
    AppMethodBeat.i(194939);
    this.msp.bxp();
    s locals = this.msp;
    locals.mrN.set(-1);
    locals.mrO = new s.d(locals, (byte)0);
    AppMethodBeat.o(194939);
  }
  
  public final void onForeground()
  {
    AppMethodBeat.i(194938);
    if (this.msr <= 0L)
    {
      AppMethodBeat.o(194938);
      return;
    }
    s locals = this.msp;
    if (locals.mrN.getAndSet(1) != 1) {}
    for (boolean bool = true;; bool = false)
    {
      ad.d("Luggage.StayingRecorder", "%s toForeground, changed:%b", new Object[] { locals.mName, Boolean.valueOf(bool) });
      if (bool)
      {
        locals.mrO.exit();
        s.c localc = locals.mrP;
        locals.mrO = localc;
        localc.enter();
      }
      if (bool) {
        this.mst.clear();
      }
      AppMethodBeat.o(194938);
      return;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.report.model.b
 * JD-Core Version:    0.7.0.1
 */