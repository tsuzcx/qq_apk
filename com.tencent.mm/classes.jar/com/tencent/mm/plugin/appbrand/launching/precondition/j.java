package com.tencent.mm.plugin.appbrand.launching.precondition;

import android.content.ComponentName;
import android.content.Context;
import android.content.pm.ActivityInfo;
import android.content.pm.PackageManager;
import android.content.pm.PackageManager.NameNotFoundException;
import android.content.pm.ServiceInfo;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.appbrand.backgroundfetch.b;
import com.tencent.mm.plugin.appbrand.config.AppBrandInitConfigWC;
import com.tencent.mm.plugin.appbrand.launching.c;
import com.tencent.mm.plugin.appbrand.report.AppBrandStatObject;
import com.tencent.mm.sdk.platformtools.ab;
import com.tencent.mm.sdk.platformtools.ah;
import com.tencent.mm.sdk.platformtools.bo;

final class j
{
  static String Ds(String paramString)
  {
    AppMethodBeat.i(132082);
    if (bo.isNullOrNil(paramString))
    {
      AppMethodBeat.o(132082);
      return "";
    }
    paramString = new ComponentName(ah.getContext(), paramString);
    PackageManager localPackageManager = ah.getContext().getPackageManager();
    if (localPackageManager == null)
    {
      AppMethodBeat.o(132082);
      return "";
    }
    try
    {
      Object localObject = localPackageManager.getActivityInfo(paramString, 128);
      if (localObject == null)
      {
        AppMethodBeat.o(132082);
        return "";
      }
      localObject = ((ActivityInfo)localObject).processName;
      AppMethodBeat.o(132082);
      return localObject;
    }
    catch (PackageManager.NameNotFoundException localNameNotFoundException)
    {
      try
      {
        paramString = localPackageManager.getServiceInfo(paramString, 128);
        if (paramString == null)
        {
          AppMethodBeat.o(132082);
          return "";
        }
        paramString = paramString.processName;
        AppMethodBeat.o(132082);
        return paramString;
      }
      catch (PackageManager.NameNotFoundException paramString)
      {
        AppMethodBeat.o(132082);
      }
    }
    return "";
  }
  
  static void b(Context paramContext, AppBrandInitConfigWC paramAppBrandInitConfigWC, AppBrandStatObject paramAppBrandStatObject)
  {
    AppMethodBeat.i(132083);
    ab.i("MicroMsg.AppBrand.PreconditionUtil", "startAppOnInitConfigGot, %s", new Object[] { paramAppBrandInitConfigWC });
    if (b.a(paramAppBrandInitConfigWC)) {
      b.a(paramAppBrandInitConfigWC.appId, paramAppBrandInitConfigWC.username, paramAppBrandInitConfigWC.gXd, paramAppBrandInitConfigWC.hiw, paramAppBrandStatObject.scene, new com.tencent.mm.plugin.appbrand.backgroundfetch.j());
    }
    c.a(paramAppBrandInitConfigWC, paramAppBrandStatObject);
    com.tencent.mm.plugin.appbrand.launching.f.a(paramContext, paramAppBrandInitConfigWC, paramAppBrandStatObject);
    com.tencent.mm.plugin.appbrand.config.f.ayv().a(paramAppBrandInitConfigWC.username, paramAppBrandInitConfigWC);
    AppMethodBeat.o(132083);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.launching.precondition.j
 * JD-Core Version:    0.7.0.1
 */