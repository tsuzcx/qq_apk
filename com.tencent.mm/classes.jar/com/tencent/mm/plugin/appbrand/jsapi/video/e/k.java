package com.tencent.mm.plugin.appbrand.jsapi.video.e;

import android.content.Context;
import android.content.pm.ApplicationInfo;
import android.content.pm.PackageInfo;
import android.content.pm.PackageManager;
import android.content.pm.PackageManager.NameNotFoundException;
import com.google.android.exoplayer2.i.x;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.Util;

public final class k
{
  private static String appName;
  
  public static String eP(Context paramContext)
  {
    AppMethodBeat.i(328648);
    if (!Util.isNullOrNil(appName))
    {
      paramContext = appName;
      AppMethodBeat.o(328648);
      return paramContext;
    }
    appName = paramContext.getPackageName();
    try
    {
      PackageInfo localPackageInfo = paramContext.getPackageManager().getPackageInfo(appName, 0);
      if ((localPackageInfo != null) && (localPackageInfo.applicationInfo != null) && (!Util.isNullOrNil(localPackageInfo.applicationInfo.name))) {
        appName = localPackageInfo.applicationInfo.name;
      }
    }
    catch (PackageManager.NameNotFoundException localNameNotFoundException)
    {
      for (;;)
      {
        Log.printErrStackTrace("MicroMsg.AppBrand.Video.Utils", localNameNotFoundException, "getUserAgent exception", new Object[0]);
      }
    }
    paramContext = x.m(paramContext, appName);
    AppMethodBeat.o(328648);
    return paramContext;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.jsapi.video.e.k
 * JD-Core Version:    0.7.0.1
 */