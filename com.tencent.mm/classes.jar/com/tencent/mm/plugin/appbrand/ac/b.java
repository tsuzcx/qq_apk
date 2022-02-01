package com.tencent.mm.plugin.appbrand.ac;

import android.content.Context;
import android.content.pm.ApplicationInfo;
import android.content.pm.PackageInfo;
import android.content.pm.PackageManager;
import android.content.pm.PackageManager.NameNotFoundException;
import android.os.Bundle;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.MMApplicationContext;

public final class b
{
  public static String fa(String paramString1, String paramString2)
  {
    AppMethodBeat.i(208989);
    try
    {
      paramString1 = MMApplicationContext.getContext().getPackageManager().getApplicationInfo(MMApplicationContext.getContext().getPackageName(), 128).metaData.getString(paramString1, paramString2);
      AppMethodBeat.o(208989);
      return paramString1;
    }
    catch (PackageManager.NameNotFoundException paramString1)
    {
      Log.printDebugStack("Luggage.AndroidPackageUtil", "", new Object[] { paramString1 });
      AppMethodBeat.o(208989);
    }
    return paramString2;
  }
  
  public static PackageInfo getPackageInfo(Context paramContext, String paramString)
  {
    AppMethodBeat.i(140800);
    if (paramString == null)
    {
      Log.e("Luggage.AndroidPackageUtil", "getPackageInfo fail, packageName is null");
      AppMethodBeat.o(140800);
      return null;
    }
    try
    {
      paramContext = paramContext.getPackageManager().getPackageInfo(paramString, 0);
      AppMethodBeat.o(140800);
      return paramContext;
    }
    catch (PackageManager.NameNotFoundException paramContext)
    {
      Log.w("Luggage.AndroidPackageUtil", paramContext.getMessage());
      AppMethodBeat.o(140800);
    }
    return null;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.ac.b
 * JD-Core Version:    0.7.0.1
 */