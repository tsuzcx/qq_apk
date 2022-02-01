package com.tencent.mm.plugin.appbrand.report.model;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.appbrand.AppBrandRuntime;
import com.tencent.mm.plugin.appbrand.report.x;
import com.tencent.mm.plugin.appbrand.report.x.a;
import com.tencent.mm.plugin.appbrand.report.x.c;
import com.tencent.mm.plugin.appbrand.report.x.d;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.Util;
import java.util.LinkedList;
import java.util.concurrent.atomic.AtomicInteger;

public class c
{
  public volatile String mAppId;
  public volatile AppBrandRuntime qwG;
  protected final x tPf;
  public volatile String tPg;
  public volatile long tPh;
  public volatile long tPi;
  private final LinkedList<Runnable> tPj;
  
  public c(int paramInt)
  {
    AppMethodBeat.i(139925);
    this.tPh = 0L;
    this.tPi = 0L;
    this.tPj = new LinkedList();
    this.tPf = new x("MicroMsg.AppBrandPageViewStatistics[" + paramInt + "]");
    AppMethodBeat.o(139925);
  }
  
  public final long cII()
  {
    AppMethodBeat.i(139926);
    long l = Math.max(0L, this.tPi);
    AppMethodBeat.o(139926);
    return l;
  }
  
  public final long cIJ()
  {
    AppMethodBeat.i(139927);
    if (1 == this.tPf.tOG.get())
    {
      i = 1;
      if (i != 0) {
        break label69;
      }
      i = this.tPf.tOG.get();
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
    long l2 = this.tPf.tOL;
    long l1 = this.tPh;
    long l3 = this.tPi;
    if (l2 <= 0L)
    {
      if (isLoading())
      {
        AppMethodBeat.o(139927);
        return 0L;
      }
      if ((this.qwG != null) && (this.qwG.ccV)) {}
      for (boolean bool = true;; bool = false)
      {
        Log.i("MicroMsg.AppBrandPageViewStatistics", "foregroundMs invalid(%d), loadStart %d, loadCost %d, [%s/%s], runtimeIsFinishing=%b", new Object[] { Long.valueOf(l2), Long.valueOf(l1), Long.valueOf(l3), this.mAppId, this.tPg, Boolean.valueOf(bool) });
        if ((l1 <= 0L) || (l3 <= 0L) || (l2 != 0L)) {
          break;
        }
        l2 = Util.nowMilliSecond();
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
    return (this.tPh > 0L) && (this.tPi <= 0L);
  }
  
  public final void onBackground()
  {
    AppMethodBeat.i(321477);
    if (this.tPf.cIE()) {
      while (!this.tPj.isEmpty()) {
        ((Runnable)this.tPj.pollFirst()).run();
      }
    }
    AppMethodBeat.o(321477);
  }
  
  public final void onDestroy()
  {
    AppMethodBeat.i(321483);
    this.tPf.cIE();
    x localx = this.tPf;
    localx.tOG.set(-1);
    localx.tOH = new x.d(localx, (byte)0);
    AppMethodBeat.o(321483);
  }
  
  public final void onForeground()
  {
    AppMethodBeat.i(321481);
    if (this.tPh <= 0L)
    {
      AppMethodBeat.o(321481);
      return;
    }
    x localx = this.tPf;
    if (localx.tOG.getAndSet(1) != 1) {}
    for (boolean bool = true;; bool = false)
    {
      Log.d("Luggage.StayingRecorder", "%s toForeground, changed:%b", new Object[] { localx.mName, Boolean.valueOf(bool) });
      if (bool)
      {
        localx.tOH.exit();
        x.c localc = localx.tOI;
        localx.tOH = localc;
        localc.enter();
      }
      if (bool) {
        this.tPj.clear();
      }
      AppMethodBeat.o(321481);
      return;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes8.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.report.model.c
 * JD-Core Version:    0.7.0.1
 */