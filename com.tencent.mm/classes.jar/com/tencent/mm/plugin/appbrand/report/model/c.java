package com.tencent.mm.plugin.appbrand.report.model;

import com.tencent.mm.plugin.appbrand.report.j;
import com.tencent.mm.sdk.platformtools.ai;
import com.tencent.mm.sdk.platformtools.bk;
import java.util.LinkedList;

public final class c
{
  public final j gYi;
  volatile String gYj;
  public volatile long gYk = 0L;
  volatile long gYl = 0L;
  private final LinkedList<Runnable> gYm = new LinkedList();
  public volatile String mAppId;
  
  public c(int paramInt)
  {
    this.gYi = new j("MicroMsg.AppBrandPageViewStatistics[" + paramInt + "]");
  }
  
  public final void E(Runnable paramRunnable)
  {
    if (this.gYi.aod())
    {
      paramRunnable.run();
      return;
    }
    this.gYm.addLast(paramRunnable);
  }
  
  public final void aog()
  {
    this.gYl = (bk.UY() - this.gYk);
  }
  
  final void aoh()
  {
    while (!this.gYm.isEmpty()) {
      ((Runnable)this.gYm.pollFirst()).run();
    }
  }
  
  public final boolean isLoading()
  {
    return (this.gYk > 0L) && (this.gYl <= 0L);
  }
  
  public final void pY()
  {
    if (this.gYk <= 0L) {
      return;
    }
    this.gYi.aoe();
    this.gYm.clear();
  }
  
  public final void qa()
  {
    this.gYi.aof();
    if (this.gYi.aod())
    {
      aoh();
      return;
    }
    ai.d(new c.1(this));
  }
  
  public final void wc(String paramString)
  {
    this.gYk = bk.UY();
    this.gYi.aoe();
    this.gYj = paramString;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.report.model.c
 * JD-Core Version:    0.7.0.1
 */