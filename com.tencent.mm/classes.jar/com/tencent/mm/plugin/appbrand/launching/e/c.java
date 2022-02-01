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
import com.tencent.mm.plugin.appbrand.report.w;
import com.tencent.mm.plugin.appbrand.step.KSProcessWeAppLaunch;
import com.tencent.mm.plugin.appbrand.ui.AppBrandUI;
import com.tencent.mm.plugin.appbrand.ui.y;
import com.tencent.mm.sdk.platformtools.NetStatusUtil;
import com.tencent.mm.sdk.platformtools.Util;

public final class c
  extends a
  implements g
{
  int lvW;
  private Intent mIntent;
  private LaunchParcel mYY;
  
  public c(AppBrandLaunchProxyUI paramAppBrandLaunchProxyUI)
  {
    AppMethodBeat.i(47439);
    this.lvW = 0;
    setBaseContext(paramAppBrandLaunchProxyUI);
    this.mYV = false;
    AppMethodBeat.o(47439);
  }
  
  private void bOj()
  {
    AppMethodBeat.i(47445);
    if ((isFinishing()) || (bOh()))
    {
      AppMethodBeat.o(47445);
      return;
    }
    super.bOe();
    AppMethodBeat.o(47445);
  }
  
  public final void H(Intent paramIntent)
  {
    AppMethodBeat.i(47440);
    if ((getBaseContext() != null) && ((getBaseContext() instanceof Activity)))
    {
      localObject1 = (Activity)getBaseContext();
      y.e(((Activity)localObject1).getWindow());
      y.d(((Activity)localObject1).getWindow(), true);
    }
    this.mIntent = paramIntent;
    LaunchParcel localLaunchParcel = (LaunchParcel)paramIntent.getParcelableExtra("extra_launch_parcel");
    if (localLaunchParcel == null)
    {
      finish();
      AppMethodBeat.o(47440);
      return;
    }
    this.mYY = localLaunchParcel;
    Object localObject1 = localLaunchParcel.appId;
    paramIntent = (Intent)localObject1;
    if (Util.isNullOrNil((String)localObject1)) {
      paramIntent = h.a(localLaunchParcel);
    }
    localObject1 = com.tencent.mm.plugin.appbrand.report.quality.g.c(localLaunchParcel, paramIntent);
    com.tencent.mm.plugin.appbrand.report.quality.g.a(localLaunchParcel, (String)localObject1, paramIntent);
    Object localObject2 = w.nHZ;
    w.b(localLaunchParcel, (String)localObject1);
    if (o.bVk())
    {
      localObject2 = o.nMe;
      o.eI(paramIntent, (String)localObject1);
      com.tencent.mm.plugin.appbrand.keylogger.c.e(KSProcessWeAppLaunch.class, paramIntent);
      com.tencent.mm.plugin.appbrand.keylogger.c.a(KSProcessWeAppLaunch.class, paramIntent, String.format("Network:%s", new Object[] { NetStatusUtil.getNetTypeString(this) }));
    }
    a(localLaunchParcel, (String)localObject1);
    AppMethodBeat.o(47440);
  }
  
  public final boolean bOi()
  {
    return true;
  }
  
  protected final void c(AppBrandInitConfigWC paramAppBrandInitConfigWC, AppBrandStatObject paramAppBrandStatObject)
  {
    AppMethodBeat.i(47444);
    if ((this.mYY != null) && (this.mYY.mYO != null))
    {
      Bundle localBundle = new Bundle();
      localBundle.putParcelable("KEY_PRECONDITION_RESULT", paramAppBrandInitConfigWC);
      this.mYY.mYO.b(localBundle);
    }
    if (paramAppBrandInitConfigWC != null) {
      paramAppBrandInitConfigWC.ldP = this.mIntent.getStringExtra("extra_launch_source_process_name");
    }
    super.c(paramAppBrandInitConfigWC, paramAppBrandStatObject);
    AppMethodBeat.o(47444);
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
    super.bOc();
    AppMethodBeat.o(47443);
  }
  
  public final void onPause()
  {
    AppMethodBeat.i(47442);
    bOj();
    AppMethodBeat.o(47442);
  }
  
  public final void onResume()
  {
    AppMethodBeat.i(47441);
    int i = this.lvW + 1;
    this.lvW = i;
    if (i > 1) {
      bOj();
    }
    AppMethodBeat.o(47441);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.launching.e.c
 * JD-Core Version:    0.7.0.1
 */