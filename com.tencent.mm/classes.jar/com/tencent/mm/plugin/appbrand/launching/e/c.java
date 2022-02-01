package com.tencent.mm.plugin.appbrand.launching.e;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.appbrand.config.AppBrandInitConfigWC;
import com.tencent.mm.plugin.appbrand.launching.AppBrandLaunchProxyUI;
import com.tencent.mm.plugin.appbrand.launching.params.LaunchParcel;
import com.tencent.mm.plugin.appbrand.report.AppBrandStatObject;
import com.tencent.mm.plugin.appbrand.report.quality.f;
import com.tencent.mm.plugin.appbrand.report.quality.n;
import com.tencent.mm.plugin.appbrand.report.s;
import com.tencent.mm.plugin.appbrand.step.KSProcessWeAppLaunch;
import com.tencent.mm.plugin.appbrand.ui.AppBrandUI;
import com.tencent.mm.plugin.appbrand.ui.r;
import com.tencent.mm.sdk.platformtools.ax;
import com.tencent.mm.sdk.platformtools.bs;

public final class c
  extends a
  implements g
{
  int jUI;
  private LaunchParcel lpZ;
  private Intent mIntent;
  
  public c(AppBrandLaunchProxyUI paramAppBrandLaunchProxyUI)
  {
    AppMethodBeat.i(47439);
    this.jUI = 0;
    setBaseContext(paramAppBrandLaunchProxyUI);
    this.lpO = false;
    AppMethodBeat.o(47439);
  }
  
  private void boi()
  {
    AppMethodBeat.i(47445);
    if ((isFinishing()) || (bog()))
    {
      AppMethodBeat.o(47445);
      return;
    }
    super.boe();
    AppMethodBeat.o(47445);
  }
  
  public final void G(Intent paramIntent)
  {
    AppMethodBeat.i(47440);
    if ((getBaseContext() != null) && ((getBaseContext() instanceof Activity)))
    {
      localObject1 = (Activity)getBaseContext();
      r.b(((Activity)localObject1).getWindow());
      r.c(((Activity)localObject1).getWindow(), true);
    }
    this.mIntent = paramIntent;
    LaunchParcel localLaunchParcel = (LaunchParcel)paramIntent.getParcelableExtra("extra_launch_parcel");
    if (localLaunchParcel == null)
    {
      finish();
      AppMethodBeat.o(47440);
      return;
    }
    this.lpZ = localLaunchParcel;
    Object localObject1 = localLaunchParcel.appId;
    paramIntent = (Intent)localObject1;
    if (bs.isNullOrNil((String)localObject1)) {
      paramIntent = h.a(localLaunchParcel);
    }
    localObject1 = com.tencent.mm.plugin.appbrand.utils.a.c(localLaunchParcel, paramIntent);
    f.a(localLaunchParcel, (String)localObject1, paramIntent);
    Object localObject2 = s.lSi;
    s.b(localLaunchParcel, (String)localObject1);
    if (n.btU())
    {
      localObject2 = n.lWn;
      n.ec(paramIntent, (String)localObject1);
      com.tencent.mm.plugin.appbrand.keylogger.c.a(KSProcessWeAppLaunch.class, paramIntent);
      com.tencent.mm.plugin.appbrand.keylogger.c.a(KSProcessWeAppLaunch.class, paramIntent, String.format("Network:%s", new Object[] { ax.getNetTypeString(this) }));
    }
    a(localLaunchParcel, (String)localObject1);
    AppMethodBeat.o(47440);
  }
  
  protected final void b(AppBrandInitConfigWC paramAppBrandInitConfigWC, AppBrandStatObject paramAppBrandStatObject)
  {
    AppMethodBeat.i(47444);
    if ((this.lpZ != null) && (this.lpZ.lpK != null))
    {
      Bundle localBundle = new Bundle();
      localBundle.putParcelable("KEY_PRECONDITION_RESULT", paramAppBrandInitConfigWC);
      this.lpZ.lpK.b(localBundle);
    }
    super.b(paramAppBrandInitConfigWC, paramAppBrandStatObject);
    AppMethodBeat.o(47444);
  }
  
  public final boolean boh()
  {
    return true;
  }
  
  protected final boolean c(AppBrandInitConfigWC paramAppBrandInitConfigWC, AppBrandStatObject paramAppBrandStatObject)
  {
    AppMethodBeat.i(47438);
    try
    {
      Class localClass = Class.forName(bs.nullAsNil(this.mIntent.getStringExtra("extra_launch_source_context")));
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
  
  public final void onDestroy()
  {
    AppMethodBeat.i(47443);
    super.boc();
    AppMethodBeat.o(47443);
  }
  
  public final void onPause()
  {
    AppMethodBeat.i(47442);
    boi();
    AppMethodBeat.o(47442);
  }
  
  public final void onResume()
  {
    AppMethodBeat.i(47441);
    int i = this.jUI + 1;
    this.jUI = i;
    if (i > 1) {
      boi();
    }
    AppMethodBeat.o(47441);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.launching.e.c
 * JD-Core Version:    0.7.0.1
 */