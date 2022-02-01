package com.tencent.mm.plugin.appbrand.report.model;

import com.tencent.matrix.trace.core.AppMethodBeat;
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
  protected final s lqD;
  public volatile String lqE;
  public volatile long lqF;
  public volatile long lqG;
  private final LinkedList<Runnable> lqH;
  public volatile String mAppId;
  
  public b(int paramInt)
  {
    AppMethodBeat.i(139925);
    this.lqF = 0L;
    this.lqG = 0L;
    this.lqH = new LinkedList();
    this.lqD = new s("MicroMsg.AppBrandPageViewStatistics[" + paramInt + "]");
    AppMethodBeat.o(139925);
  }
  
  public final long bmr()
  {
    AppMethodBeat.i(139926);
    long l = Math.max(0L, this.lqG);
    AppMethodBeat.o(139926);
    return l;
  }
  
  public final long bms()
  {
    AppMethodBeat.i(139927);
    if (1 == this.lqD.lqc.get())
    {
      i = 1;
      if (i != 0) {
        break label69;
      }
      i = this.lqD.lqc.get();
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
    long l2 = this.lqD.lqh;
    long l1 = this.lqF;
    long l3 = this.lqG;
    if (l2 <= 0L)
    {
      ad.i("MicroMsg.AppBrandPageViewStatistics", "foregroundMs invalid(%d), loadStart %d, loadCost %d, [%s/%s]", new Object[] { Long.valueOf(l2), Long.valueOf(l1), Long.valueOf(l3), this.mAppId, this.lqE });
      if ((l1 > 0L) && (l3 > 0L) && (l2 == 0L))
      {
        l2 = bt.eGO();
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
    return (this.lqF > 0L) && (this.lqG <= 0L);
  }
  
  public final void onBackground()
  {
    AppMethodBeat.i(193716);
    if (this.lqD.bmo()) {
      while (!this.lqH.isEmpty()) {
        ((Runnable)this.lqH.pollFirst()).run();
      }
    }
    AppMethodBeat.o(193716);
  }
  
  public final void onDestroy()
  {
    AppMethodBeat.i(193718);
    this.lqD.bmo();
    s locals = this.lqD;
    locals.lqc.set(-1);
    locals.lqd = new s.d(locals, (byte)0);
    AppMethodBeat.o(193718);
  }
  
  public final void onForeground()
  {
    AppMethodBeat.i(193717);
    if (this.lqF <= 0L)
    {
      AppMethodBeat.o(193717);
      return;
    }
    s locals = this.lqD;
    if (locals.lqc.getAndSet(1) != 1) {}
    for (boolean bool = true;; bool = false)
    {
      ad.d("Luggage.StayingRecorder", "%s toForeground, changed:%b", new Object[] { locals.mName, Boolean.valueOf(bool) });
      if (bool)
      {
        locals.lqd.exit();
        s.c localc = locals.lqe;
        locals.lqd = localc;
        localc.enter();
      }
      if (bool) {
        this.lqH.clear();
      }
      AppMethodBeat.o(193717);
      return;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.report.model.b
 * JD-Core Version:    0.7.0.1
 */