package com.tencent.mm.plugin.appbrand.u;

import android.content.Context;
import android.content.pm.PackageInfo;
import android.content.pm.PackageManager;
import android.content.pm.PackageManager.NameNotFoundException;
import com.tencent.mm.sdk.platformtools.y;

public final class b
{
  public static PackageInfo getPackageInfo(Context paramContext, String paramString)
  {
    if (paramString == null)
    {
      y.e("Luggage.AndroidPackageUtil", "getPackageInfo fail, packageName is null");
      return null;
    }
    try
    {
      paramContext = paramContext.getPackageManager().getPackageInfo(paramString, 0);
      return paramContext;
    }
    catch (PackageManager.NameNotFoundException paramContext)
    {
      y.printErrStackTrace("Luggage.AndroidPackageUtil", paramContext, "", new Object[0]);
    }
    return null;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.u.b
 * JD-Core Version:    0.7.0.1
 */