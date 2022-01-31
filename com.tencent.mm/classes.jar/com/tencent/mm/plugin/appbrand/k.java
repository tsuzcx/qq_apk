package com.tencent.mm.plugin.appbrand;

import android.app.Activity;
import android.content.Intent;
import com.tencent.luggage.b.e;
import com.tencent.mm.kernel.g;
import com.tencent.mm.plugin.appbrand.config.AppBrandInitConfig;
import com.tencent.mm.plugin.appbrand.config.AppBrandInitConfigWC;
import com.tencent.mm.plugin.appbrand.config.AppBrandSysConfigWC;
import com.tencent.mm.plugin.appbrand.report.AppBrandStatObject;
import com.tencent.mm.plugin.appbrand.task.h;
import com.tencent.mm.plugin.appbrand.ui.AppBrandEmbedUI;
import com.tencent.mm.plugin.appbrand.ui.r;
import com.tencent.mm.plugin.appbrand.widget.recentview.d;
import java.util.Iterator;

public final class k
  extends j
{
  Activity fyk;
  boolean fzf = false;
  
  public k(h paramh)
  {
    super(paramh, n.class);
    this.fyk = paramh.getContext();
  }
  
  public final void a(i parami, AppBrandInitConfigWC paramAppBrandInitConfigWC, AppBrandStatObject paramAppBrandStatObject)
  {
    if ((paramAppBrandInitConfigWC == null) || (paramAppBrandStatObject == null)) {
      return;
    }
    com.tencent.mm.plugin.appbrand.u.n.runOnUiThread(new k.1(this, parami, paramAppBrandInitConfigWC, paramAppBrandStatObject));
  }
  
  protected final void a(i parami1, i parami2, AppBrandInitConfig paramAppBrandInitConfig)
  {
    this.fzf = true;
    parami2.s(new k.2(this));
    if (paramAppBrandInitConfig.ZH()) {
      cleanup();
    }
    for (;;)
    {
      super.a(parami1, parami2, paramAppBrandInitConfig);
      if (parami1 != null) {
        ((r)e.i(r.class)).a(parami2, parami1, null);
      }
      return;
      Iterator localIterator = ZY();
      while (localIterator.hasNext())
      {
        i locali = (i)localIterator.next();
        if (locali.ZH())
        {
          locali.fyE = false;
          super.f(locali);
        }
      }
    }
  }
  
  protected final void b(MiniProgramNavigationBackResult paramMiniProgramNavigationBackResult)
  {
    if ((paramMiniProgramNavigationBackResult != null) && ((this.fyk instanceof AppBrandEmbedUI)))
    {
      Intent localIntent = new Intent();
      localIntent.putExtra("result_key_mini_program_navigate_back_result", paramMiniProgramNavigationBackResult);
      this.fyk.setResult(-1, localIntent);
    }
  }
  
  protected final void b(i parami1, i parami2, AppBrandInitConfig paramAppBrandInitConfig)
  {
    super.b(parami1, parami2, paramAppBrandInitConfig);
    if (parami1 != null)
    {
      paramAppBrandInitConfig = new k.3(this, parami1);
      ((r)e.i(r.class)).a(parami2, parami1, paramAppBrandInitConfig);
    }
  }
  
  protected final void c(i parami1, i parami2, Runnable paramRunnable)
  {
    if (parami2 == null) {
      return;
    }
    paramRunnable = new k.4(this, paramRunnable, parami1);
    if ((parami2.fyE) && ((parami2.fyk == null) || (!parami2.fyk.isFinishing())) && (parami2.fyp != null) && (parami2.fyp.getCurrentPage() != null) && (!parami2.fyp.getCurrentPage().mSwiping)) {}
    for (int i = 1; i != 0; i = 0)
    {
      ((r)e.i(r.class)).b(parami1, parami2, paramRunnable);
      return;
    }
    paramRunnable.run();
  }
  
  protected final void onClose()
  {
    super.onClose();
    n localn = (n)ZV();
    if ((localn != null) && (localn.aaa() != null) && (localn.aaa().fPU) && (ZV().dNk))
    {
      ((d)g.r(d.class)).cE(this.fyk);
      localn.aaa().fPU = false;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.k
 * JD-Core Version:    0.7.0.1
 */