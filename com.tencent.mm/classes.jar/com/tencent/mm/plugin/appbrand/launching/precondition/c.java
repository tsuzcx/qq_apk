package com.tencent.mm.plugin.appbrand.launching.precondition;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import com.tencent.luggage.sdk.launching.b;
import com.tencent.luggage.sdk.launching.d;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.appbrand.config.AppBrandInitConfigWC;
import com.tencent.mm.plugin.appbrand.launching.AppBrandLaunchProxyUI;
import com.tencent.mm.plugin.appbrand.launching.params.LaunchParcel;
import com.tencent.mm.plugin.appbrand.report.AppBrandStatObject;
import com.tencent.mm.plugin.appbrand.report.quality.f;
import com.tencent.mm.plugin.appbrand.report.quality.n;
import com.tencent.mm.plugin.appbrand.report.y;
import com.tencent.mm.plugin.appbrand.step.KSProcessWeAppLaunch;
import com.tencent.mm.plugin.appbrand.ui.AppBrandUI;
import com.tencent.mm.plugin.appbrand.ui.ae;
import com.tencent.mm.sdk.platformtools.NetStatusUtil;
import com.tencent.mm.sdk.platformtools.Util;

public final class c
  extends a
  implements g
{
  private Intent mIntent;
  int ruz;
  private LaunchParcel tek;
  
  public c(AppBrandLaunchProxyUI paramAppBrandLaunchProxyUI)
  {
    AppMethodBeat.i(47439);
    this.ruz = 0;
    setBaseContext(paramAppBrandLaunchProxyUI);
    this.teh = false;
    AppMethodBeat.o(47439);
  }
  
  private void cAV()
  {
    AppMethodBeat.i(47445);
    if ((isFinishing()) || (cAT()))
    {
      AppMethodBeat.o(47445);
      return;
    }
    super.cAQ();
    AppMethodBeat.o(47445);
  }
  
  public final void L(Intent paramIntent)
  {
    AppMethodBeat.i(47440);
    if ((getBaseContext() != null) && ((getBaseContext() instanceof Activity)))
    {
      localObject1 = (Activity)getBaseContext();
      ae.g(((Activity)localObject1).getWindow());
      ae.c(((Activity)localObject1).getWindow(), true);
    }
    this.mIntent = paramIntent;
    LaunchParcel localLaunchParcel = (LaunchParcel)paramIntent.getParcelableExtra("extra_launch_parcel");
    if (localLaunchParcel == null)
    {
      finish();
      AppMethodBeat.o(47440);
      return;
    }
    ((Activity)getBaseContext()).overridePendingTransition(0, 0);
    this.tek = localLaunchParcel;
    Object localObject1 = localLaunchParcel.appId;
    paramIntent = (Intent)localObject1;
    if (Util.isNullOrNil((String)localObject1)) {
      paramIntent = i.a(localLaunchParcel);
    }
    localObject1 = f.d(localLaunchParcel, paramIntent);
    f.a(localLaunchParcel, (String)localObject1, paramIntent);
    Object localObject2 = y.tOP;
    y.b(localLaunchParcel, (String)localObject1);
    if (n.cJm())
    {
      localObject2 = n.tTb;
      n.fn(paramIntent, (String)localObject1);
      com.tencent.mm.plugin.appbrand.keylogger.c.d(KSProcessWeAppLaunch.class, paramIntent);
      com.tencent.mm.plugin.appbrand.keylogger.c.a(KSProcessWeAppLaunch.class, paramIntent, String.format("Network:%s", new Object[] { NetStatusUtil.getNetTypeString(this) }));
    }
    a(localLaunchParcel, (String)localObject1);
    AppMethodBeat.o(47440);
  }
  
  protected final void b(AppBrandInitConfigWC paramAppBrandInitConfigWC, AppBrandStatObject paramAppBrandStatObject)
  {
    AppMethodBeat.i(47444);
    try
    {
      if ((this.tek != null) && (this.tek.tea != null))
      {
        Bundle localBundle = new Bundle();
        localBundle.putParcelable("KEY_PRECONDITION_RESULT", paramAppBrandInitConfigWC);
        this.tek.tea.onWXAppResult(localBundle);
      }
      if (paramAppBrandInitConfigWC != null) {
        paramAppBrandInitConfigWC.qYf = this.mIntent.getStringExtra("extra_launch_source_process_name");
      }
      super.b(paramAppBrandInitConfigWC, paramAppBrandStatObject);
      return;
    }
    finally
    {
      if (this.tek != null) {
        d.a(this.tek.tea);
      }
      AppMethodBeat.o(47444);
    }
    AppMethodBeat.o(47444);
  }
  
  protected final boolean c(AppBrandInitConfigWC paramAppBrandInitConfigWC, AppBrandStatObject paramAppBrandStatObject)
  {
    AppMethodBeat.i(47438);
    try
    {
      Class localClass = Class.forName(Util.nullAsNil(this.mIntent.getStringExtra("extra_launch_source_context")));
      if ((localClass != null) && (AppBrandUI.class.isAssignableFrom(localClass)))
      {
        AppMethodBeat.o(47438);
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
      AppMethodBeat.o(47438);
      return bool;
    }
  }
  
  public final boolean cAU()
  {
    return true;
  }
  
  public final void onDestroy()
  {
    AppMethodBeat.i(47443);
    super.cAO();
    AppMethodBeat.o(47443);
  }
  
  public final void onPause()
  {
    AppMethodBeat.i(47442);
    cAV();
    AppMethodBeat.o(47442);
  }
  
  public final void onResume()
  {
    AppMethodBeat.i(47441);
    int i = this.ruz + 1;
    this.ruz = i;
    if (i > 1) {
      cAV();
    }
    AppMethodBeat.o(47441);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.launching.precondition.c
 * JD-Core Version:    0.7.0.1
 */