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
import com.tencent.mm.plugin.appbrand.report.t;
import com.tencent.mm.plugin.appbrand.step.KSProcessWeAppLaunch;
import com.tencent.mm.plugin.appbrand.ui.AppBrandUI;
import com.tencent.mm.plugin.appbrand.ui.r;
import com.tencent.mm.sdk.platformtools.ay;
import com.tencent.mm.sdk.platformtools.bt;

public final class c
  extends a
  implements g
{
  int jun;
  private LaunchParcel kOA;
  private Intent mIntent;
  
  public c(AppBrandLaunchProxyUI paramAppBrandLaunchProxyUI)
  {
    AppMethodBeat.i(47439);
    this.jun = 0;
    setBaseContext(paramAppBrandLaunchProxyUI);
    this.kOp = false;
    AppMethodBeat.o(47439);
  }
  
  private void bho()
  {
    AppMethodBeat.i(47445);
    if ((isFinishing()) || (bhm()))
    {
      AppMethodBeat.o(47445);
      return;
    }
    super.bhk();
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
    this.kOA = localLaunchParcel;
    Object localObject1 = localLaunchParcel.appId;
    paramIntent = (Intent)localObject1;
    if (bt.isNullOrNil((String)localObject1)) {
      paramIntent = h.a(localLaunchParcel);
    }
    localObject1 = com.tencent.mm.plugin.appbrand.utils.a.c(localLaunchParcel, paramIntent);
    f.a(localLaunchParcel, (String)localObject1, paramIntent);
    Object localObject2 = t.lqn;
    t.b(localLaunchParcel, (String)localObject1);
    if (n.bmY())
    {
      localObject2 = n.lut;
      n.dQ(paramIntent, (String)localObject1);
      com.tencent.mm.plugin.appbrand.keylogger.c.a(KSProcessWeAppLaunch.class, paramIntent);
      com.tencent.mm.plugin.appbrand.keylogger.c.a(KSProcessWeAppLaunch.class, paramIntent, String.format("Network:%s", new Object[] { ay.getNetTypeString(this) }));
    }
    a(localLaunchParcel, (String)localObject1);
    AppMethodBeat.o(47440);
  }
  
  protected final void b(AppBrandInitConfigWC paramAppBrandInitConfigWC, AppBrandStatObject paramAppBrandStatObject)
  {
    AppMethodBeat.i(47444);
    if ((this.kOA != null) && (this.kOA.kOl != null))
    {
      Bundle localBundle = new Bundle();
      localBundle.putParcelable("KEY_PRECONDITION_RESULT", paramAppBrandInitConfigWC);
      this.kOA.kOl.b(localBundle);
    }
    super.b(paramAppBrandInitConfigWC, paramAppBrandStatObject);
    AppMethodBeat.o(47444);
  }
  
  public final boolean bhn()
  {
    return true;
  }
  
  protected final boolean c(AppBrandInitConfigWC paramAppBrandInitConfigWC, AppBrandStatObject paramAppBrandStatObject)
  {
    AppMethodBeat.i(47438);
    try
    {
      Class localClass = Class.forName(bt.nullAsNil(this.mIntent.getStringExtra("extra_launch_source_context")));
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
    super.bhi();
    AppMethodBeat.o(47443);
  }
  
  public final void onPause()
  {
    AppMethodBeat.i(47442);
    bho();
    AppMethodBeat.o(47442);
  }
  
  public final void onResume()
  {
    AppMethodBeat.i(47441);
    int i = this.jun + 1;
    this.jun = i;
    if (i > 1) {
      bho();
    }
    AppMethodBeat.o(47441);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.launching.e.c
 * JD-Core Version:    0.7.0.1
 */