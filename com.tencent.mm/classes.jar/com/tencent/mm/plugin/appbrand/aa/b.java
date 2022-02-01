package com.tencent.mm.plugin.appbrand.aa;

import android.content.Context;
import android.content.pm.ApplicationInfo;
import android.content.pm.PackageInfo;
import android.content.pm.PackageManager;
import android.content.pm.PackageManager.NameNotFoundException;
import android.os.Bundle;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.sdk.platformtools.ad;
import com.tencent.mm.sdk.platformtools.aj;

public final class b
{
  public static String dW(String paramString1, String paramString2)
  {
    AppMethodBeat.i(194907);
    try
    {
      paramString1 = aj.getContext().getPackageManager().getApplicationInfo(aj.getContext().getPackageName(), 128).metaData.getString(paramString1, paramString2);
      AppMethodBeat.o(194907);
      return paramString1;
    }
    catch (PackageManager.NameNotFoundException paramString1)
    {
      ad.l("Luggage.AndroidPackageUtil", "", new Object[] { paramString1 });
      AppMethodBeat.o(194907);
    }
    return paramString2;
  }
  
  public static PackageInfo getPackageInfo(Context paramContext, String paramString)
  {
    AppMethodBeat.i(140800);
    if (paramString == null)
    {
      ad.e("Luggage.AndroidPackageUtil", "getPackageInfo fail, packageName is null");
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
      ad.w("Luggage.AndroidPackageUtil", paramContext.getMessage());
      AppMethodBeat.o(140800);
    }
    return null;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.aa.b
 * JD-Core Version:    0.7.0.1
 */