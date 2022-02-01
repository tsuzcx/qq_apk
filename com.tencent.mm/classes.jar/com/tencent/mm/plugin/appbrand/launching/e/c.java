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
import com.tencent.mm.plugin.appbrand.ui.s;
import com.tencent.mm.sdk.platformtools.ay;
import com.tencent.mm.sdk.platformtools.bt;

public final class c
  extends a
  implements g
{
  int koW;
  private LaunchParcel lNu;
  private Intent mIntent;
  
  public c(AppBrandLaunchProxyUI paramAppBrandLaunchProxyUI)
  {
    AppMethodBeat.i(47439);
    this.koW = 0;
    setBaseContext(paramAppBrandLaunchProxyUI);
    this.lNj = false;
    AppMethodBeat.o(47439);
  }
  
  private void bsb()
  {
    AppMethodBeat.i(47445);
    if ((isFinishing()) || (brZ()))
    {
      AppMethodBeat.o(47445);
      return;
    }
    super.brX();
    AppMethodBeat.o(47445);
  }
  
  public final void H(Intent paramIntent)
  {
    AppMethodBeat.i(47440);
    if ((getBaseContext() != null) && ((getBaseContext() instanceof Activity)))
    {
      localObject1 = (Activity)getBaseContext();
      s.b(((Activity)localObject1).getWindow());
      s.c(((Activity)localObject1).getWindow(), true);
    }
    this.mIntent = paramIntent;
    LaunchParcel localLaunchParcel = (LaunchParcel)paramIntent.getParcelableExtra("extra_launch_parcel");
    if (localLaunchParcel == null)
    {
      finish();
      AppMethodBeat.o(47440);
      return;
    }
    this.lNu = localLaunchParcel;
    Object localObject1 = localLaunchParcel.appId;
    paramIntent = (Intent)localObject1;
    if (bt.isNullOrNil((String)localObject1)) {
      paramIntent = h.a(localLaunchParcel);
    }
    localObject1 = com.tencent.mm.plugin.appbrand.utils.a.c(localLaunchParcel, paramIntent);
    f.a(localLaunchParcel, (String)localObject1, paramIntent);
    f.b(localLaunchParcel, (String)localObject1, paramIntent);
    Object localObject2 = t.mrY;
    t.b(localLaunchParcel, (String)localObject1);
    if (n.bxY())
    {
      localObject2 = n.mwc;
      n.em(paramIntent, (String)localObject1);
      com.tencent.mm.plugin.appbrand.keylogger.c.a(KSProcessWeAppLaunch.class, paramIntent);
      com.tencent.mm.plugin.appbrand.keylogger.c.a(KSProcessWeAppLaunch.class, paramIntent, String.format("Network:%s", new Object[] { ay.getNetTypeString(this) }));
    }
    a(localLaunchParcel, (String)localObject1);
    AppMethodBeat.o(47440);
  }
  
  public final boolean bsa()
  {
    return true;
  }
  
  protected final void c(AppBrandInitConfigWC paramAppBrandInitConfigWC, AppBrandStatObject paramAppBrandStatObject)
  {
    AppMethodBeat.i(47444);
    if ((this.lNu != null) && (this.lNu.lNd != null))
    {
      Bundle localBundle = new Bundle();
      localBundle.putParcelable("KEY_PRECONDITION_RESULT", paramAppBrandInitConfigWC);
      this.lNu.lNd.b(localBundle);
    }
    super.c(paramAppBrandInitConfigWC, paramAppBrandStatObject);
    AppMethodBeat.o(47444);
  }
  
  protected final boolean d(AppBrandInitConfigWC paramAppBrandInitConfigWC, AppBrandStatObject paramAppBrandStatObject)
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
      boolean bool = super.d(paramAppBrandInitConfigWC, paramAppBrandStatObject);
      AppMethodBeat.o(47438);
      return bool;
    }
  }
  
  public final void onDestroy()
  {
    AppMethodBeat.i(47443);
    super.brV();
    AppMethodBeat.o(47443);
  }
  
  public final void onPause()
  {
    AppMethodBeat.i(47442);
    bsb();
    AppMethodBeat.o(47442);
  }
  
  public final void onResume()
  {
    AppMethodBeat.i(47441);
    int i = this.koW + 1;
    this.koW = i;
    if (i > 1) {
      bsb();
    }
    AppMethodBeat.o(47441);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.launching.e.c
 * JD-Core Version:    0.7.0.1
 */