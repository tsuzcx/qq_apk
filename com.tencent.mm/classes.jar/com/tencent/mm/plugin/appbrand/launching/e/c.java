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
import com.tencent.mm.plugin.appbrand.step.KSProcessWeAppLaunch;
import com.tencent.mm.plugin.appbrand.ui.AppBrandUI;
import com.tencent.mm.plugin.appbrand.utils.b;
import com.tencent.mm.sdk.platformtools.az;
import com.tencent.mm.sdk.platformtools.bu;

public final class c
  extends a
  implements g
{
  int ksm;
  private LaunchParcel lRV;
  private Intent mIntent;
  
  public c(AppBrandLaunchProxyUI paramAppBrandLaunchProxyUI)
  {
    AppMethodBeat.i(47439);
    this.ksm = 0;
    setBaseContext(paramAppBrandLaunchProxyUI);
    this.lRK = false;
    AppMethodBeat.o(47439);
  }
  
  private void bsM()
  {
    AppMethodBeat.i(47445);
    if ((isFinishing()) || (bsK()))
    {
      AppMethodBeat.o(47445);
      return;
    }
    super.bsI();
    AppMethodBeat.o(47445);
  }
  
  public final void H(Intent paramIntent)
  {
    AppMethodBeat.i(47440);
    if ((getBaseContext() != null) && ((getBaseContext() instanceof Activity)))
    {
      localObject1 = (Activity)getBaseContext();
      com.tencent.mm.plugin.appbrand.ui.t.b(((Activity)localObject1).getWindow());
      com.tencent.mm.plugin.appbrand.ui.t.c(((Activity)localObject1).getWindow(), true);
    }
    this.mIntent = paramIntent;
    LaunchParcel localLaunchParcel = (LaunchParcel)paramIntent.getParcelableExtra("extra_launch_parcel");
    if (localLaunchParcel == null)
    {
      finish();
      AppMethodBeat.o(47440);
      return;
    }
    this.lRV = localLaunchParcel;
    Object localObject1 = localLaunchParcel.appId;
    paramIntent = (Intent)localObject1;
    if (bu.isNullOrNil((String)localObject1)) {
      paramIntent = h.a(localLaunchParcel);
    }
    localObject1 = b.c(localLaunchParcel, paramIntent);
    f.a(localLaunchParcel, (String)localObject1, paramIntent);
    f.b(localLaunchParcel, (String)localObject1, paramIntent);
    Object localObject2 = com.tencent.mm.plugin.appbrand.report.t.mwW;
    com.tencent.mm.plugin.appbrand.report.t.b(localLaunchParcel, (String)localObject1);
    if (n.byR())
    {
      localObject2 = n.mAZ;
      n.ep(paramIntent, (String)localObject1);
      com.tencent.mm.plugin.appbrand.keylogger.c.a(KSProcessWeAppLaunch.class, paramIntent);
      com.tencent.mm.plugin.appbrand.keylogger.c.a(KSProcessWeAppLaunch.class, paramIntent, String.format("Network:%s", new Object[] { az.getNetTypeString(this) }));
    }
    a(localLaunchParcel, (String)localObject1);
    AppMethodBeat.o(47440);
  }
  
  public final boolean bsL()
  {
    return true;
  }
  
  protected final void c(AppBrandInitConfigWC paramAppBrandInitConfigWC, AppBrandStatObject paramAppBrandStatObject)
  {
    AppMethodBeat.i(47444);
    if ((this.lRV != null) && (this.lRV.lRE != null))
    {
      Bundle localBundle = new Bundle();
      localBundle.putParcelable("KEY_PRECONDITION_RESULT", paramAppBrandInitConfigWC);
      this.lRV.lRE.b(localBundle);
    }
    if (paramAppBrandInitConfigWC != null) {
      paramAppBrandInitConfigWC.kaL = this.mIntent.getStringExtra("extra_launch_source_process_name");
    }
    super.c(paramAppBrandInitConfigWC, paramAppBrandStatObject);
    AppMethodBeat.o(47444);
  }
  
  protected final boolean d(AppBrandInitConfigWC paramAppBrandInitConfigWC, AppBrandStatObject paramAppBrandStatObject)
  {
    AppMethodBeat.i(47438);
    try
    {
      Class localClass = Class.forName(bu.nullAsNil(this.mIntent.getStringExtra("extra_launch_source_context")));
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
      boolean bool = super.d(paramAppBrandInitConfigWC, paramAppBrandStatObject);
      AppMethodBeat.o(47438);
      return bool;
    }
  }
  
  public final void onDestroy()
  {
    AppMethodBeat.i(47443);
    super.bsG();
    AppMethodBeat.o(47443);
  }
  
  public final void onPause()
  {
    AppMethodBeat.i(47442);
    bsM();
    AppMethodBeat.o(47442);
  }
  
  public final void onResume()
  {
    AppMethodBeat.i(47441);
    int i = this.ksm + 1;
    this.ksm = i;
    if (i > 1) {
      bsM();
    }
    AppMethodBeat.o(47441);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.launching.e.c
 * JD-Core Version:    0.7.0.1
 */