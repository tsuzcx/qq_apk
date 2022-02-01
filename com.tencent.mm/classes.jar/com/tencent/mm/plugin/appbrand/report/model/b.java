package com.tencent.mm.plugin.appbrand.report.model;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.appbrand.AppBrandRuntime;
import com.tencent.mm.plugin.appbrand.report.w;
import com.tencent.mm.plugin.appbrand.report.w.a;
import com.tencent.mm.plugin.appbrand.report.w.c;
import com.tencent.mm.plugin.appbrand.report.w.d;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.Util;
import java.util.LinkedList;
import java.util.concurrent.atomic.AtomicInteger;

public class b
{
  public volatile String mAppId;
  public volatile AppBrandRuntime nxs;
  protected final w qKC;
  public volatile String qKD;
  public volatile long qKE;
  public volatile long qKF;
  private final LinkedList<Runnable> qKG;
  
  public b(int paramInt)
  {
    AppMethodBeat.i(139925);
    this.qKE = 0L;
    this.qKF = 0L;
    this.qKG = new LinkedList();
    this.qKC = new w("MicroMsg.AppBrandPageViewStatistics[" + paramInt + "]");
    AppMethodBeat.o(139925);
  }
  
  public final long chN()
  {
    AppMethodBeat.i(139926);
    long l = Math.max(0L, this.qKF);
    AppMethodBeat.o(139926);
    return l;
  }
  
  public final long chO()
  {
    AppMethodBeat.i(139927);
    if (1 == this.qKC.qKa.get())
    {
      i = 1;
      if (i != 0) {
        break label69;
      }
      i = this.qKC.qKa.get();
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
    long l2 = this.qKC.qKf;
    long l1 = this.qKE;
    long l3 = this.qKF;
    if (l2 <= 0L)
    {
      if ((this.nxs != null) && (this.nxs.aol)) {}
      for (boolean bool = true;; bool = false)
      {
        Log.i("MicroMsg.AppBrandPageViewStatistics", "foregroundMs invalid(%d), loadStart %d, loadCost %d, [%s/%s], runtimeIsFinishing=%b", new Object[] { Long.valueOf(l2), Long.valueOf(l1), Long.valueOf(l3), this.mAppId, this.qKD, Boolean.valueOf(bool) });
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
    return (this.qKE > 0L) && (this.qKF <= 0L);
  }
  
  public final void onBackground()
  {
    AppMethodBeat.i(199407);
    if (this.qKC.chJ()) {
      while (!this.qKG.isEmpty()) {
        ((Runnable)this.qKG.pollFirst()).run();
      }
    }
    AppMethodBeat.o(199407);
  }
  
  public final void onDestroy()
  {
    AppMethodBeat.i(199414);
    this.qKC.chJ();
    w localw = this.qKC;
    localw.qKa.set(-1);
    localw.qKb = new w.d(localw, (byte)0);
    AppMethodBeat.o(199414);
  }
  
  public final void onForeground()
  {
    AppMethodBeat.i(199412);
    if (this.qKE <= 0L)
    {
      AppMethodBeat.o(199412);
      return;
    }
    w localw = this.qKC;
    if (localw.qKa.getAndSet(1) != 1) {}
    for (boolean bool = true;; bool = false)
    {
      Log.d("Luggage.StayingRecorder", "%s toForeground, changed:%b", new Object[] { localw.mName, Boolean.valueOf(bool) });
      if (bool)
      {
        localw.qKb.exit();
        w.c localc = localw.qKc;
        localw.qKb = localc;
        localc.enter();
      }
      if (bool) {
        this.qKG.clear();
      }
      AppMethodBeat.o(199412);
      return;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.report.model.b
 * JD-Core Version:    0.7.0.1
 */