package com.tencent.mm.plugin.appbrand.launching.precondition;

import android.app.Activity;
import android.content.Intent;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.appbrand.config.AppBrandInitConfigWC;
import com.tencent.mm.plugin.appbrand.launching.AppBrandLaunchProxyUI;
import com.tencent.mm.plugin.appbrand.launching.params.LaunchParcel;
import com.tencent.mm.plugin.appbrand.report.AppBrandStatObject;
import com.tencent.mm.plugin.appbrand.report.quality.f;
import com.tencent.mm.plugin.appbrand.ui.AppBrandUI;
import com.tencent.mm.plugin.appbrand.ui.o;
import com.tencent.mm.sdk.platformtools.al;
import com.tencent.mm.sdk.platformtools.bo;
import java.util.Queue;

public final class c
  extends a
  implements g
{
  int hvP;
  private Intent mIntent;
  
  public c(AppBrandLaunchProxyUI paramAppBrandLaunchProxyUI)
  {
    AppMethodBeat.i(132060);
    this.hvP = 0;
    setBaseContext(paramAppBrandLaunchProxyUI);
    this.inL = false;
    AppMethodBeat.o(132060);
  }
  
  private void aHx()
  {
    AppMethodBeat.i(132066);
    if ((isFinishing()) || (aHv()))
    {
      AppMethodBeat.o(132066);
      return;
    }
    super.aHt();
    AppMethodBeat.o(132066);
  }
  
  public final void F(Intent paramIntent)
  {
    AppMethodBeat.i(132061);
    if ((getBaseContext() != null) && ((getBaseContext() instanceof Activity)))
    {
      Activity localActivity = (Activity)getBaseContext();
      o.a(localActivity.getWindow());
      o.a(localActivity.getWindow(), true);
    }
    this.mIntent = paramIntent;
    paramIntent = (LaunchParcel)paramIntent.getParcelableExtra("extra_launch_parcel");
    if (paramIntent == null)
    {
      finish();
      AppMethodBeat.o(132061);
      return;
    }
    a(paramIntent, f.a(paramIntent));
    AppMethodBeat.o(132061);
  }
  
  protected final String aHs()
  {
    AppMethodBeat.i(132064);
    String str = this.mIntent.getStringExtra("extra_launch_source_context");
    AppMethodBeat.o(132064);
    return str;
  }
  
  public final boolean aHw()
  {
    return true;
  }
  
  protected final void b(AppBrandInitConfigWC paramAppBrandInitConfigWC, AppBrandStatObject paramAppBrandStatObject)
  {
    AppMethodBeat.i(132065);
    Activity localActivity;
    if ((getBaseContext() instanceof Activity))
    {
      localActivity = (Activity)getBaseContext();
      if (paramAppBrandInitConfigWC == null) {
        break label71;
      }
    }
    label71:
    for (int i = -1;; i = 1)
    {
      localActivity.setResult(i);
      super.b(paramAppBrandInitConfigWC, paramAppBrandStatObject);
      paramAppBrandInitConfigWC = new c.1(this);
      if (!(getBaseContext() instanceof AppBrandLaunchProxyUI)) {
        break;
      }
      al.d(paramAppBrandInitConfigWC);
      AppMethodBeat.o(132065);
      return;
    }
    this.inM.offer(paramAppBrandInitConfigWC);
    AppMethodBeat.o(132065);
  }
  
  protected final boolean c(AppBrandInitConfigWC paramAppBrandInitConfigWC, AppBrandStatObject paramAppBrandStatObject)
  {
    AppMethodBeat.i(132059);
    try
    {
      Class localClass = Class.forName(bo.nullAsNil(this.mIntent.getStringExtra("extra_launch_source_context")));
      if ((localClass != null) && (AppBrandUI.class.isAssignableFrom(localClass)))
      {
        AppMethodBeat.o(132059);
        return false;
      }
    }
    catch (Exception localException)
    {
      for (;;)
      {
        Object localObject = null;
      }
      boolean bool = super.c(paramAppBrandInitConfigWC, paramAppBrandStatObject);
      AppMethodBeat.o(132059);
      return bool;
    }
  }
  
  public final void onDestroy() {}
  
  public final void onPause()
  {
    AppMethodBeat.i(132063);
    aHx();
    AppMethodBeat.o(132063);
  }
  
  public final void onResume()
  {
    AppMethodBeat.i(132062);
    int i = this.hvP + 1;
    this.hvP = i;
    if (i > 1) {
      aHx();
    }
    AppMethodBeat.o(132062);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes8.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.launching.precondition.c
 * JD-Core Version:    0.7.0.1
 */