package com.tencent.mm.plugin.appbrand.report.model;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.appbrand.report.o;
import com.tencent.mm.sdk.platformtools.ab;
import com.tencent.mm.sdk.platformtools.bo;
import java.util.LinkedList;

public final class b
{
  public final o iGA;
  public volatile String iGB;
  public volatile long iGC;
  private volatile long iGD;
  private final LinkedList<Runnable> iGE;
  public volatile String mAppId;
  
  public b(int paramInt)
  {
    AppMethodBeat.i(114413);
    this.iGC = 0L;
    this.iGD = 0L;
    this.iGE = new LinkedList();
    this.iGA = new o("MicroMsg.AppBrandPageViewStatistics[" + paramInt + "]");
    AppMethodBeat.o(114413);
  }
  
  public final void L(Runnable paramRunnable)
  {
    AppMethodBeat.i(114420);
    if (this.iGA.aLb())
    {
      paramRunnable.run();
      AppMethodBeat.o(114420);
      return;
    }
    this.iGE.addLast(paramRunnable);
    AppMethodBeat.o(114420);
  }
  
  public final long aLe()
  {
    AppMethodBeat.i(114414);
    long l = Math.max(0L, this.iGD);
    AppMethodBeat.o(114414);
    return l;
  }
  
  public final void aLf()
  {
    AppMethodBeat.i(114416);
    this.iGD = (bo.aoy() - this.iGC);
    AppMethodBeat.o(114416);
  }
  
  public final long aLg()
  {
    AppMethodBeat.i(114417);
    long l2 = this.iGA.iGg;
    long l1 = this.iGC;
    long l3 = this.iGD;
    if (l2 <= 0L)
    {
      ab.i("MicroMsg.AppBrandPageViewStatistics", "foregroundMs invalid(%d), loadStart %d, loadCost %d, [%s/%s]", new Object[] { Long.valueOf(l2), Long.valueOf(l1), Long.valueOf(l3), this.mAppId, this.iGB });
      if ((l1 > 0L) && (l3 > 0L) && (l2 == 0L))
      {
        l2 = bo.aoy();
        AppMethodBeat.o(114417);
        return l2 - l1;
      }
    }
    l1 = Math.max(0L, l2);
    AppMethodBeat.o(114417);
    return l1;
  }
  
  public final boolean isLoading()
  {
    return (this.iGC > 0L) && (this.iGD <= 0L);
  }
  
  public final void onBackground()
  {
    AppMethodBeat.i(114418);
    this.iGA.aLd();
    while (!this.iGE.isEmpty()) {
      ((Runnable)this.iGE.pollFirst()).run();
    }
    AppMethodBeat.o(114418);
  }
  
  public final void onForeground()
  {
    AppMethodBeat.i(114419);
    if (this.iGC <= 0L)
    {
      AppMethodBeat.o(114419);
      return;
    }
    this.iGA.aLc();
    this.iGE.clear();
    AppMethodBeat.o(114419);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.report.model.b
 * JD-Core Version:    0.7.0.1
 */