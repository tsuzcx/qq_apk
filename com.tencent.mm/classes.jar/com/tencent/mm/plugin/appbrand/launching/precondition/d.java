package com.tencent.mm.plugin.appbrand.launching.precondition;

import android.content.Intent;
import com.tencent.mm.plugin.appbrand.config.AppBrandInitConfigWC;
import com.tencent.mm.plugin.appbrand.launching.AppBrandLaunchProxyUI;
import com.tencent.mm.plugin.appbrand.launching.params.LaunchParcel;
import com.tencent.mm.plugin.appbrand.report.AppBrandStatObject;
import com.tencent.mm.plugin.appbrand.ui.AppBrandUI;
import com.tencent.mm.sdk.platformtools.ai;
import com.tencent.mm.sdk.platformtools.bk;
import java.util.Queue;

public final class d
  extends b
  implements h
{
  int gdS = 0;
  private Intent mIntent;
  
  public d(AppBrandLaunchProxyUI paramAppBrandLaunchProxyUI)
  {
    setBaseContext(paramAppBrandLaunchProxyUI);
  }
  
  private void amc()
  {
    if ((isFinishing()) || (amb())) {
      return;
    }
    super.ama();
  }
  
  protected final String alZ()
  {
    return this.mIntent.getStringExtra("extra_launch_source_context");
  }
  
  protected final void ama() {}
  
  protected final boolean b(AppBrandInitConfigWC paramAppBrandInitConfigWC)
  {
    try
    {
      Class localClass = Class.forName(bk.pm(this.mIntent.getStringExtra("extra_launch_source_context")));
      if ((localClass != null) && (AppBrandUI.class.isAssignableFrom(localClass))) {
        return false;
      }
    }
    catch (Exception localException)
    {
      for (;;)
      {
        Object localObject = null;
      }
    }
    return super.b(paramAppBrandInitConfigWC);
  }
  
  protected final void d(AppBrandInitConfigWC paramAppBrandInitConfigWC, AppBrandStatObject paramAppBrandStatObject)
  {
    super.d(paramAppBrandInitConfigWC, paramAppBrandStatObject);
    paramAppBrandInitConfigWC = new d.1(this);
    if ((getBaseContext() instanceof AppBrandLaunchProxyUI))
    {
      ai.d(paramAppBrandInitConfigWC);
      return;
    }
    this.gMp.offer(paramAppBrandInitConfigWC);
  }
  
  public final void onPause()
  {
    amc();
  }
  
  public final void onResume()
  {
    int i = this.gdS + 1;
    this.gdS = i;
    if (i > 1) {
      amc();
    }
  }
  
  public final void p(Intent paramIntent)
  {
    this.mIntent = paramIntent;
    paramIntent = (LaunchParcel)paramIntent.getParcelableExtra("extra_launch_parcel");
    if (paramIntent == null)
    {
      finish();
      return;
    }
    a(paramIntent);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.launching.precondition.d
 * JD-Core Version:    0.7.0.1
 */