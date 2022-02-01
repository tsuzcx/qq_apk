package com.tencent.mm.plugin.appbrand.report.model;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.appbrand.AppBrandRuntime;
import com.tencent.mm.plugin.appbrand.report.s;
import com.tencent.mm.plugin.appbrand.report.s.a;
import com.tencent.mm.plugin.appbrand.report.s.c;
import com.tencent.mm.plugin.appbrand.report.s.d;
import com.tencent.mm.sdk.platformtools.ae;
import com.tencent.mm.sdk.platformtools.bu;
import java.util.LinkedList;
import java.util.concurrent.atomic.AtomicInteger;

public class b
{
  public volatile AppBrandRuntime jDb;
  public volatile String mAppId;
  protected final s mxm;
  public volatile String mxn;
  public volatile long mxo;
  public volatile long mxp;
  private final LinkedList<Runnable> mxq;
  
  public b(int paramInt)
  {
    AppMethodBeat.i(139925);
    this.mxo = 0L;
    this.mxp = 0L;
    this.mxq = new LinkedList();
    this.mxm = new s("MicroMsg.AppBrandPageViewStatistics[" + paramInt + "]");
    AppMethodBeat.o(139925);
  }
  
  public final long byl()
  {
    AppMethodBeat.i(139926);
    long l = Math.max(0L, this.mxp);
    AppMethodBeat.o(139926);
    return l;
  }
  
  public final long bym()
  {
    AppMethodBeat.i(139927);
    if (1 == this.mxm.mwL.get())
    {
      i = 1;
      if (i != 0) {
        break label69;
      }
      i = this.mxm.mwL.get();
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
    long l2 = this.mxm.mwQ;
    long l1 = this.mxo;
    long l3 = this.mxp;
    if (l2 <= 0L)
    {
      if ((this.jDb != null) && (this.jDb.SB)) {}
      for (boolean bool = true;; bool = false)
      {
        ae.i("MicroMsg.AppBrandPageViewStatistics", "foregroundMs invalid(%d), loadStart %d, loadCost %d, [%s/%s], runtimeIsFinishing=%b", new Object[] { Long.valueOf(l2), Long.valueOf(l1), Long.valueOf(l3), this.mAppId, this.mxn, Boolean.valueOf(bool) });
        if ((l1 <= 0L) || (l3 <= 0L) || (l2 != 0L)) {
          break;
        }
        l2 = bu.fpO();
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
    return (this.mxo > 0L) && (this.mxp <= 0L);
  }
  
  public final void onBackground()
  {
    AppMethodBeat.i(221827);
    if (this.mxm.byi()) {
      while (!this.mxq.isEmpty()) {
        ((Runnable)this.mxq.pollFirst()).run();
      }
    }
    AppMethodBeat.o(221827);
  }
  
  public final void onDestroy()
  {
    AppMethodBeat.i(221829);
    this.mxm.byi();
    s locals = this.mxm;
    locals.mwL.set(-1);
    locals.mwM = new s.d(locals, (byte)0);
    AppMethodBeat.o(221829);
  }
  
  public final void onForeground()
  {
    AppMethodBeat.i(221828);
    if (this.mxo <= 0L)
    {
      AppMethodBeat.o(221828);
      return;
    }
    s locals = this.mxm;
    if (locals.mwL.getAndSet(1) != 1) {}
    for (boolean bool = true;; bool = false)
    {
      ae.d("Luggage.StayingRecorder", "%s toForeground, changed:%b", new Object[] { locals.mName, Boolean.valueOf(bool) });
      if (bool)
      {
        locals.mwM.exit();
        s.c localc = locals.mwN;
        locals.mwM = localc;
        localc.enter();
      }
      if (bool) {
        this.mxq.clear();
      }
      AppMethodBeat.o(221828);
      return;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.report.model.b
 * JD-Core Version:    0.7.0.1
 */