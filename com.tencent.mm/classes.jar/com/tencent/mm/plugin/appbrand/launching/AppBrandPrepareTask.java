package com.tencent.mm.plugin.appbrand.launching;

import android.app.Activity;
import com.tencent.luggage.sdk.config.AppBrandInitConfigLU;
import com.tencent.luggage.sdk.d.b;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ipcinvoker.extension.XIPCInvoker;
import com.tencent.mm.plugin.appbrand.appcache.WxaCommLibRuntimeReader;
import com.tencent.mm.plugin.appbrand.appcache.WxaPkgWrappingInfo;
import com.tencent.mm.plugin.appbrand.config.AppBrandInitConfig;
import com.tencent.mm.plugin.appbrand.config.AppBrandInitConfigWC;
import com.tencent.mm.plugin.appbrand.config.AppBrandSysConfigWC;
import com.tencent.mm.plugin.appbrand.i;
import com.tencent.mm.plugin.appbrand.i.y;
import com.tencent.mm.plugin.appbrand.o;
import com.tencent.mm.plugin.appbrand.report.AppBrandStatObject;
import com.tencent.mm.sdk.g.d;
import com.tencent.mm.sdk.platformtools.ab;
import com.tencent.mm.sdk.platformtools.al;
import java.lang.ref.WeakReference;

public final class AppBrandPrepareTask
{
  boolean bAa;
  AppBrandPrepareTask.PrepareParams ijT;
  public volatile transient AppBrandPrepareTask.b<AppBrandSysConfigWC> ijU;
  volatile transient WeakReference<Activity> ijV;
  
  public AppBrandPrepareTask(Activity paramActivity, o paramo)
  {
    AppMethodBeat.i(131758);
    AppBrandStatObject localAppBrandStatObject = paramo.wS().bDh;
    this.ijT = new AppBrandPrepareTask.PrepareParams();
    this.ijV = new WeakReference(paramActivity);
    AppBrandPrepareTask.PrepareParams.a(this.ijT, paramo.mAppId);
    AppBrandPrepareTask.PrepareParams.b(this.ijT, paramo.atS().username);
    AppBrandPrepareTask.PrepareParams.a(this.ijT, paramo.gPz.gXd);
    paramActivity = this.ijT;
    if (localAppBrandStatObject == null)
    {
      i = 0;
      AppBrandPrepareTask.PrepareParams.b(paramActivity, i);
      paramActivity = this.ijT;
      if (localAppBrandStatObject != null) {
        break label248;
      }
    }
    label248:
    for (int i = j;; i = localAppBrandStatObject.scene)
    {
      AppBrandPrepareTask.PrepareParams.c(paramActivity, i);
      AppBrandPrepareTask.PrepareParams.c(this.ijT, paramo.atS().hiw);
      AppBrandPrepareTask.PrepareParams.a(this.ijT, paramo.atS().hiz);
      AppBrandPrepareTask.PrepareParams.d(this.ijT, paramo.atS().vZ());
      AppBrandPrepareTask.PrepareParams.a(this.ijT, paramo.atS().bDe);
      AppBrandPrepareTask.PrepareParams.a(this.ijT, paramo.vY());
      AppBrandPrepareTask.PrepareParams.b(this.ijT, paramo.atS().bDg);
      AppBrandPrepareTask.PrepareParams.a(this.ijT, paramo.atS().hiI);
      this.bAa = paramo.vY();
      AppMethodBeat.o(131758);
      return;
      i = localAppBrandStatObject.cJb;
      break;
    }
  }
  
  public final void aGK()
  {
    AppMethodBeat.i(131759);
    if (al.isMainThread())
    {
      d.post(new AppBrandPrepareTask.1(this), "AppBrandPrepareTask" + this.ijT.toShortString());
      AppMethodBeat.o(131759);
      return;
    }
    if (!WxaCommLibRuntimeReader.avG())
    {
      ab.i("MicroMsg.AppBrandPrepareTask", "startPrepare(), CommLib not loaded, %s", new Object[] { this.ijT.toShortString() });
      WxaCommLibRuntimeReader.avF();
      y.aAM();
    }
    AppBrandPrepareTask.PrepareParams.d(this.ijT, WxaCommLibRuntimeReader.avI().gXf);
    XIPCInvoker.a("com.tencent.mm", this.ijT, AppBrandPrepareTask.a.class, new AppBrandPrepareTask.2(this));
    ab.i("MicroMsg.AppBrandPrepareTask", "[applaunch] startPrepare in appbrand %s, %d", new Object[] { AppBrandPrepareTask.PrepareParams.a(this.ijT), Integer.valueOf(AppBrandPrepareTask.PrepareParams.b(this.ijT)) });
    AppMethodBeat.o(131759);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.launching.AppBrandPrepareTask
 * JD-Core Version:    0.7.0.1
 */