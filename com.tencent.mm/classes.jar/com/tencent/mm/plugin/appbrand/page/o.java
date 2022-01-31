package com.tencent.mm.plugin.appbrand.page;

import android.annotation.SuppressLint;
import android.content.Context;
import android.content.res.Resources;
import android.util.DisplayMetrics;
import com.tencent.mm.plugin.appbrand.ReportStorageSizeTask;
import com.tencent.mm.plugin.appbrand.config.AppBrandSysConfigWC;
import com.tencent.mm.plugin.appbrand.config.a;
import com.tencent.mm.plugin.appbrand.i;
import com.tencent.mm.plugin.appbrand.ipc.AppBrandMainProcessService;
import com.tencent.mm.plugin.appbrand.report.model.b;
import com.tencent.mm.plugin.appbrand.task.d;
import com.tencent.mm.plugin.report.service.h;
import com.tencent.mm.sdk.platformtools.ai;
import com.tencent.mm.sdk.platformtools.y;
import java.util.LinkedList;
import me.imid.swipebacklayout.lib.SwipeBackLayout;

@SuppressLint({"ViewConstructor"})
public class o
  extends n
{
  private volatile b gTq;
  private long gTr = 0L;
  public boolean gTs = false;
  
  public o(Context paramContext, com.tencent.mm.plugin.appbrand.n paramn)
  {
    super(paramContext, paramn);
    this.gTq = new b(paramn);
  }
  
  protected final void a(al paramal, String paramString)
  {
    boolean bool = false;
    this.gTr = System.currentTimeMillis();
    if (!getRuntime().ZH())
    {
      if ((paramal != al.gVQ) && (paramal != al.gVL)) {
        break label58;
      }
      if (!paramString.startsWith(getRuntime().getAppConfig().adV())) {
        bool = true;
      }
      this.gTs = bool;
    }
    label58:
    while ((paramal != al.gVP) || (!paramString.startsWith(getRuntime().getAppConfig().adV()))) {
      return;
    }
    this.gTs = false;
  }
  
  protected final void a(k paramk1, k paramk2)
  {
    this.gTq.g(0L, 4);
    this.gTq.a((s)paramk2.getCurrentPageView(), (s)paramk1.getCurrentPageView(), al.gVN);
  }
  
  protected final void a(k paramk1, k paramk2, al paramal)
  {
    long l = System.currentTimeMillis() - this.gTr;
    b localb = this.gTq;
    int i;
    switch (com.tencent.mm.plugin.appbrand.report.model.b.3.gYh[paramal.ordinal()])
    {
    default: 
      i = 2;
      localb.g(l, i);
      h.nFQ.a(390L, 0L, 1L, false);
      switch ((int)l / 250)
      {
      default: 
        i = 7;
        label136:
        h.nFQ.a(390L, i, 1L, false);
        y.i("MicroMsg.AppBrandPageContainer", "onReady received, time: %d", new Object[] { Long.valueOf(l) });
        localb = this.gTq;
        paramk2 = (s)paramk2.getCurrentPageView();
        if (paramk1 != null) {}
        break;
      }
      break;
    }
    for (paramk1 = null;; paramk1 = (s)paramk1.getCurrentPageView())
    {
      localb.a(paramk2, paramk1, paramal);
      return;
      i = 1;
      break;
      i = 3;
      break;
      i = 1;
      break label136;
      i = 2;
      break label136;
      i = 3;
      break label136;
      i = 4;
      break label136;
      i = 5;
      break label136;
      i = 6;
      break label136;
    }
  }
  
  public final q amZ()
  {
    q localq = null;
    if ((getRuntime().getAppConfig().fNG) || (!d.aoF())) {
      localq = d.wk(getAppId());
    }
    if (localq != null) {
      return localq;
    }
    return new s();
  }
  
  protected final k b(String paramString, al paramal)
  {
    paramString = super.b(paramString, paramal);
    if ((paramString instanceof SwipeBackLayout))
    {
      float f = getResources().getDisplayMetrics().density;
      paramString.setMinVelocity(100.0F * f);
      paramString.setMaxVelocity(300.0F * f);
      paramString.setEdgeTrackingEnabled(1);
      paramString.setEdgeSize((int)(f * 20.0F + 0.5F));
    }
    return paramString;
  }
  
  public b getReporter()
  {
    return this.gTq;
  }
  
  public com.tencent.mm.plugin.appbrand.n getRuntime()
  {
    return (com.tencent.mm.plugin.appbrand.n)super.getRuntime();
  }
  
  protected final void onDestroy()
  {
    super.onDestroy();
    b localb;
    s locals;
    if (!getPageStack().isEmpty())
    {
      localb = this.gTq;
      locals = (s)getCurrentPage().getCurrentPageView();
      if ((locals != null) && (!localb.gSK)) {}
    }
    else
    {
      return;
    }
    localb.c(locals);
  }
  
  public final void onReady()
  {
    super.onReady();
    ReportStorageSizeTask localReportStorageSizeTask = new ReportStorageSizeTask();
    localReportStorageSizeTask.appId = getRuntime().mAppId;
    AppBrandMainProcessService.a(localReportStorageSizeTask);
  }
  
  public void pY()
  {
    super.pY();
    this.gTq.d((s)getCurrentPage().getCurrentPageView());
  }
  
  public void qa()
  {
    super.qa();
    this.gTq.c((s)getCurrentPage().getCurrentPageView());
  }
  
  public void tA(String paramString)
  {
    super.tA(paramString);
    if (getRuntime().aaa().fPN) {
      ai.l(new o.1(this), 10000L);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.page.o
 * JD-Core Version:    0.7.0.1
 */