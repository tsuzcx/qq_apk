package com.tencent.mm.plugin.appbrand.s;

import android.content.Context;
import android.content.pm.PackageInfo;
import android.content.pm.PackageManager;
import android.content.pm.PackageManager.NameNotFoundException;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.sdk.platformtools.ab;

public final class b
{
  public static PackageInfo getPackageInfo(Context paramContext, String paramString)
  {
    AppMethodBeat.i(91136);
    if (paramString == null)
    {
      ab.e("Luggage.AndroidPackageUtil", "getPackageInfo fail, packageName is null");
      AppMethodBeat.o(91136);
      return null;
    }
    try
    {
      paramContext = paramContext.getPackageManager().getPackageInfo(paramString, 0);
      AppMethodBeat.o(91136);
      return paramContext;
    }
    catch (PackageManager.NameNotFoundException paramContext)
    {
      ab.printErrStackTrace("Luggage.AndroidPackageUtil", paramContext, "", new Object[0]);
      AppMethodBeat.o(91136);
    }
    return null;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes8.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.s.b
 * JD-Core Version:    0.7.0.1
 */