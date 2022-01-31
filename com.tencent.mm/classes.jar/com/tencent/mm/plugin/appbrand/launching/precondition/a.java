package com.tencent.mm.plugin.appbrand.launching.precondition;

import android.content.Context;
import android.content.MutableContextWrapper;
import com.tencent.mm.plugin.appbrand.config.AppBrandInitConfigWC;
import com.tencent.mm.plugin.appbrand.launching.AppBrandLaunchProxyUI;
import com.tencent.mm.plugin.appbrand.launching.params.LaunchParcel;
import com.tencent.mm.plugin.appbrand.luggage.export.functionalpage.f;
import com.tencent.mm.plugin.appbrand.report.AppBrandStatObject;
import com.tencent.mm.plugin.appbrand.s.m;
import com.tencent.mm.plugin.appbrand.task.h;
import com.tencent.mm.sdk.platformtools.ah;
import com.tencent.mm.sdk.platformtools.al;
import java.util.LinkedList;
import java.util.Queue;

public abstract class a
  extends MutableContextWrapper
{
  protected boolean inL = true;
  final Queue<Runnable> inM = new LinkedList();
  private al inN;
  
  public a()
  {
    super(ah.getContext());
  }
  
  private void H(Runnable paramRunnable)
  {
    if ((getBaseContext() instanceof AppBrandLaunchProxyUI))
    {
      m.runOnUiThread(paramRunnable);
      return;
    }
    this.inM.offer(paramRunnable);
  }
  
  protected final void a(LaunchParcel paramLaunchParcel, String paramString)
  {
    al localal = new al("AppBrandLaunchProxyUI-PrepareThread");
    this.inN = localal;
    localal.ac(new a.3(this, paramLaunchParcel, paramString));
  }
  
  protected abstract String aHs();
  
  protected final void aHt()
  {
    H(new a.1(this));
  }
  
  protected Context aHu()
  {
    return null;
  }
  
  protected final boolean aHv()
  {
    return ((getBaseContext() instanceof AppBrandLaunchProxyUI)) && (((AppBrandLaunchProxyUI)getBaseContext()).isDestroyed());
  }
  
  protected void b(AppBrandInitConfigWC paramAppBrandInitConfigWC, AppBrandStatObject paramAppBrandStatObject)
  {
    if (paramAppBrandInitConfigWC != null)
    {
      Context localContext2 = aHu();
      Context localContext1 = localContext2;
      if (localContext2 == null) {
        localContext1 = getBaseContext();
      }
      j.b(localContext1, paramAppBrandInitConfigWC, paramAppBrandStatObject);
    }
    for (;;)
    {
      if (this.inL) {
        aHt();
      }
      if (this.inN != null) {
        this.inN.ac(new a.4(this));
      }
      return;
      this.inL = true;
    }
  }
  
  protected boolean c(AppBrandInitConfigWC paramAppBrandInitConfigWC, AppBrandStatObject paramAppBrandStatObject)
  {
    if ((paramAppBrandInitConfigWC.hiC) || (h.EZ(paramAppBrandInitConfigWC.appId)) || (paramAppBrandInitConfigWC.vY()) || (paramAppBrandInitConfigWC.hiD)) {}
    for (int i = 1; (i | f.d(paramAppBrandInitConfigWC, paramAppBrandStatObject)) == 0; i = 0) {
      return true;
    }
    return false;
  }
  
  protected final void finish()
  {
    b(null, null);
  }
  
  protected final boolean isFinishing()
  {
    return ((getBaseContext() instanceof AppBrandLaunchProxyUI)) && (((AppBrandLaunchProxyUI)getBaseContext()).isFinishing());
  }
  
  public final void setBaseContext(Context paramContext)
  {
    super.setBaseContext(paramContext);
    if ((getBaseContext() instanceof AppBrandLaunchProxyUI)) {
      while (!this.inM.isEmpty()) {
        ((Runnable)this.inM.poll()).run();
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes8.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.launching.precondition.a
 * JD-Core Version:    0.7.0.1
 */