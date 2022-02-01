package com.tencent.mm.plugin.appbrand.report.model;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.appbrand.AppBrandRuntime;
import com.tencent.mm.plugin.appbrand.report.v;
import com.tencent.mm.plugin.appbrand.report.v.a;
import com.tencent.mm.plugin.appbrand.report.v.c;
import com.tencent.mm.plugin.appbrand.report.v.d;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.Util;
import java.util.LinkedList;
import java.util.concurrent.atomic.AtomicInteger;

public class b
{
  public volatile AppBrandRuntime kEc;
  public volatile String mAppId;
  protected final v nIq;
  public volatile String nIr;
  public volatile long nIs;
  public volatile long nIt;
  private final LinkedList<Runnable> nIu;
  
  public b(int paramInt)
  {
    AppMethodBeat.i(139925);
    this.nIs = 0L;
    this.nIt = 0L;
    this.nIu = new LinkedList();
    this.nIq = new v("MicroMsg.AppBrandPageViewStatistics[" + paramInt + "]");
    AppMethodBeat.o(139925);
  }
  
  public final long bUD()
  {
    AppMethodBeat.i(139926);
    long l = Math.max(0L, this.nIt);
    AppMethodBeat.o(139926);
    return l;
  }
  
  public final long bUE()
  {
    AppMethodBeat.i(139927);
    if (1 == this.nIq.nHO.get())
    {
      i = 1;
      if (i != 0) {
        break label69;
      }
      i = this.nIq.nHO.get();
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
    long l2 = this.nIq.nHT;
    long l1 = this.nIs;
    long l3 = this.nIt;
    if (l2 <= 0L)
    {
      if ((this.kEc != null) && (this.kEc.SO)) {}
      for (boolean bool = true;; bool = false)
      {
        Log.i("MicroMsg.AppBrandPageViewStatistics", "foregroundMs invalid(%d), loadStart %d, loadCost %d, [%s/%s], runtimeIsFinishing=%b", new Object[] { Long.valueOf(l2), Long.valueOf(l1), Long.valueOf(l3), this.mAppId, this.nIr, Boolean.valueOf(bool) });
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
    return (this.nIs > 0L) && (this.nIt <= 0L);
  }
  
  public final void onBackground()
  {
    AppMethodBeat.i(230541);
    if (this.nIq.bUz()) {
      while (!this.nIu.isEmpty()) {
        ((Runnable)this.nIu.pollFirst()).run();
      }
    }
    AppMethodBeat.o(230541);
  }
  
  public final void onDestroy()
  {
    AppMethodBeat.i(230543);
    this.nIq.bUz();
    v localv = this.nIq;
    localv.nHO.set(-1);
    localv.nHP = new v.d(localv, (byte)0);
    AppMethodBeat.o(230543);
  }
  
  public final void onForeground()
  {
    AppMethodBeat.i(230542);
    if (this.nIs <= 0L)
    {
      AppMethodBeat.o(230542);
      return;
    }
    v localv = this.nIq;
    if (localv.nHO.getAndSet(1) != 1) {}
    for (boolean bool = true;; bool = false)
    {
      Log.d("Luggage.StayingRecorder", "%s toForeground, changed:%b", new Object[] { localv.mName, Boolean.valueOf(bool) });
      if (bool)
      {
        localv.nHP.exit();
        v.c localc = localv.nHQ;
        localv.nHP = localc;
        localc.enter();
      }
      if (bool) {
        this.nIu.clear();
      }
      AppMethodBeat.o(230542);
      return;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.report.model.b
 * JD-Core Version:    0.7.0.1
 */