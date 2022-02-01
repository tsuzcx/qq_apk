package com.tencent.mm.plugin.appbrand.launching.e;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.appbrand.config.AppBrandInitConfigWC;
import com.tencent.mm.plugin.appbrand.launching.AppBrandLaunchProxyUI;
import com.tencent.mm.plugin.appbrand.launching.params.LaunchParcel;
import com.tencent.mm.plugin.appbrand.report.AppBrandStatObject;
import com.tencent.mm.plugin.appbrand.report.quality.o;
import com.tencent.mm.plugin.appbrand.step.KSProcessWeAppLaunch;
import com.tencent.mm.plugin.appbrand.ui.AppBrandUI;
import com.tencent.mm.sdk.platformtools.NetStatusUtil;
import com.tencent.mm.sdk.platformtools.Util;

public final class c
  extends a
  implements g
{
  private Intent mIntent;
  int oqF;
  private LaunchParcel pZw;
  
  public c(AppBrandLaunchProxyUI paramAppBrandLaunchProxyUI)
  {
    AppMethodBeat.i(47439);
    this.oqF = 0;
    setBaseContext(paramAppBrandLaunchProxyUI);
    this.pZt = false;
    AppMethodBeat.o(47439);
  }
  
  private void caD()
  {
    AppMethodBeat.i(47445);
    if ((isFinishing()) || (caB()))
    {
      AppMethodBeat.o(47445);
      return;
    }
    super.cay();
    AppMethodBeat.o(47445);
  }
  
  public final void I(Intent paramIntent)
  {
    AppMethodBeat.i(47440);
    if ((getBaseContext() != null) && ((getBaseContext() instanceof Activity)))
    {
      localObject1 = (Activity)getBaseContext();
      com.tencent.mm.plugin.appbrand.ui.x.e(((Activity)localObject1).getWindow());
      com.tencent.mm.plugin.appbrand.ui.x.d(((Activity)localObject1).getWindow(), true);
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
    this.pZw = localLaunchParcel;
    Object localObject1 = localLaunchParcel.appId;
    paramIntent = (Intent)localObject1;
    if (Util.isNullOrNil((String)localObject1)) {
      paramIntent = h.a(localLaunchParcel);
    }
    localObject1 = com.tencent.mm.plugin.appbrand.report.quality.g.c(localLaunchParcel, paramIntent);
    com.tencent.mm.plugin.appbrand.report.quality.g.a(localLaunchParcel, (String)localObject1, paramIntent);
    Object localObject2 = com.tencent.mm.plugin.appbrand.report.x.qKl;
    com.tencent.mm.plugin.appbrand.report.x.b(localLaunchParcel, (String)localObject1);
    if (o.civ())
    {
      localObject2 = o.qOt;
      o.eW(paramIntent, (String)localObject1);
      com.tencent.mm.plugin.appbrand.keylogger.c.d(KSProcessWeAppLaunch.class, paramIntent);
      com.tencent.mm.plugin.appbrand.keylogger.c.a(KSProcessWeAppLaunch.class, paramIntent, String.format("Network:%s", new Object[] { NetStatusUtil.getNetTypeString(this) }));
    }
    a(localLaunchParcel, (String)localObject1);
    AppMethodBeat.o(47440);
  }
  
  protected final void c(AppBrandInitConfigWC paramAppBrandInitConfigWC, AppBrandStatObject paramAppBrandStatObject)
  {
    AppMethodBeat.i(47444);
    if ((this.pZw != null) && (this.pZw.pZm != null))
    {
      Bundle localBundle = new Bundle();
      localBundle.putParcelable("KEY_PRECONDITION_RESULT", paramAppBrandInitConfigWC);
      this.pZw.pZm.b(localBundle);
    }
    if (paramAppBrandInitConfigWC != null) {
      paramAppBrandInitConfigWC.nYd = this.mIntent.getStringExtra("extra_launch_source_process_name");
    }
    super.c(paramAppBrandInitConfigWC, paramAppBrandStatObject);
    AppMethodBeat.o(47444);
  }
  
  public final boolean caC()
  {
    return true;
  }
  
  protected final boolean d(AppBrandInitConfigWC paramAppBrandInitConfigWC, AppBrandStatObject paramAppBrandStatObject)
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
      boolean bool = super.d(paramAppBrandInitConfigWC, paramAppBrandStatObject);
      AppMethodBeat.o(47438);
      return bool;
    }
  }
  
  public final void onDestroy()
  {
    AppMethodBeat.i(47443);
    super.caw();
    AppMethodBeat.o(47443);
  }
  
  public final void onPause()
  {
    AppMethodBeat.i(47442);
    caD();
    AppMethodBeat.o(47442);
  }
  
  public final void onResume()
  {
    AppMethodBeat.i(47441);
    int i = this.oqF + 1;
    this.oqF = i;
    if (i > 1) {
      caD();
    }
    AppMethodBeat.o(47441);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.launching.e.c
 * JD-Core Version:    0.7.0.1
 */