package com.tencent.d.f;

import android.content.Context;
import android.content.pm.PackageInfo;
import android.content.pm.PackageManager;
import com.tencent.d.e.a.a.a;

public final class i
{
  public static a bN(Context paramContext, String paramString)
  {
    a locala = new a();
    try
    {
      paramContext = paramContext.getPackageManager().getPackageInfo(paramString, 64);
      locala.bwQ = paramString;
      locala.versionName = paramContext.versionName;
      locala.versionCode = paramContext.versionCode;
      return locala;
    }
    catch (Throwable paramContext) {}
    return locala;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.d.f.i
 * JD-Core Version:    0.7.0.1
 */