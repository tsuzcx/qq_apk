package com.tencent.mm.plugin.appbrand.report.model;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.appbrand.AppBrandRuntime;
import com.tencent.mm.plugin.appbrand.report.r;
import com.tencent.mm.plugin.appbrand.report.r.a;
import com.tencent.mm.plugin.appbrand.report.r.c;
import com.tencent.mm.plugin.appbrand.report.r.d;
import com.tencent.mm.sdk.platformtools.ac;
import com.tencent.mm.sdk.platformtools.bs;
import java.util.LinkedList;
import java.util.concurrent.atomic.AtomicInteger;

public class b
{
  public volatile AppBrandRuntime jgY;
  public volatile long lSA;
  public volatile long lSB;
  private final LinkedList<Runnable> lSC;
  protected final r lSy;
  public volatile String lSz;
  public volatile String mAppId;
  
  public b(int paramInt)
  {
    AppMethodBeat.i(139925);
    this.lSA = 0L;
    this.lSB = 0L;
    this.lSC = new LinkedList();
    this.lSy = new r("MicroMsg.AppBrandPageViewStatistics[" + paramInt + "]");
    AppMethodBeat.o(139925);
  }
  
  public final long btn()
  {
    AppMethodBeat.i(139926);
    long l = Math.max(0L, this.lSB);
    AppMethodBeat.o(139926);
    return l;
  }
  
  public final long bto()
  {
    AppMethodBeat.i(139927);
    if (1 == this.lSy.lRX.get())
    {
      i = 1;
      if (i != 0) {
        break label69;
      }
      i = this.lSy.lRX.get();
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
    long l2 = this.lSy.lSc;
    long l1 = this.lSA;
    long l3 = this.lSB;
    if (l2 <= 0L)
    {
      if ((this.jgY != null) && (this.jgY.QM)) {}
      for (boolean bool = true;; bool = false)
      {
        ac.i("MicroMsg.AppBrandPageViewStatistics", "foregroundMs invalid(%d), loadStart %d, loadCost %d, [%s/%s], runtimeIsFinishing=%b", new Object[] { Long.valueOf(l2), Long.valueOf(l1), Long.valueOf(l3), this.mAppId, this.lSz, Boolean.valueOf(bool) });
        if ((l1 <= 0L) || (l3 <= 0L) || (l2 != 0L)) {
          break;
        }
        l2 = bs.eWj();
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
    return (this.lSA > 0L) && (this.lSB <= 0L);
  }
  
  public final void onBackground()
  {
    AppMethodBeat.i(208987);
    if (this.lSy.btk()) {
      while (!this.lSC.isEmpty()) {
        ((Runnable)this.lSC.pollFirst()).run();
      }
    }
    AppMethodBeat.o(208987);
  }
  
  public final void onDestroy()
  {
    AppMethodBeat.i(208989);
    this.lSy.btk();
    r localr = this.lSy;
    localr.lRX.set(-1);
    localr.lRY = new r.d(localr, (byte)0);
    AppMethodBeat.o(208989);
  }
  
  public final void onForeground()
  {
    AppMethodBeat.i(208988);
    if (this.lSA <= 0L)
    {
      AppMethodBeat.o(208988);
      return;
    }
    r localr = this.lSy;
    if (localr.lRX.getAndSet(1) != 1) {}
    for (boolean bool = true;; bool = false)
    {
      ac.d("Luggage.StayingRecorder", "%s toForeground, changed:%b", new Object[] { localr.mName, Boolean.valueOf(bool) });
      if (bool)
      {
        localr.lRY.exit();
        r.c localc = localr.lRZ;
        localr.lRY = localc;
        localc.enter();
      }
      if (bool) {
        this.lSC.clear();
      }
      AppMethodBeat.o(208988);
      return;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.report.model.b
 * JD-Core Version:    0.7.0.1
 */