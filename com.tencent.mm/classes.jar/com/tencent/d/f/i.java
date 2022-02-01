package com.tencent.d.f;

import android.content.Context;
import android.content.pm.PackageInfo;
import android.content.pm.PackageManager;
import com.tencent.d.e.a.a.a;
import com.tencent.matrix.trace.core.AppMethodBeat;

public final class i
{
  public static a df(Context paramContext, String paramString)
  {
    AppMethodBeat.i(138484);
    a locala = new a();
    try
    {
      paramContext = paramContext.getPackageManager().getPackageInfo(paramString, 64);
      locala.pkgName = paramString;
      locala.versionName = paramContext.versionName;
      locala.versionCode = paramContext.versionCode;
      label45:
      AppMethodBeat.o(138484);
      return locala;
    }
    catch (Throwable paramContext)
    {
      break label45;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.d.f.i
 * JD-Core Version:    0.7.0.1
 */