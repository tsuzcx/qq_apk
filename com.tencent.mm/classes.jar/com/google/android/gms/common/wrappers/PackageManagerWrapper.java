package com.google.android.gms.common.wrappers;

import android.annotation.TargetApi;
import android.app.Activity;
import android.app.AppOpsManager;
import android.content.ComponentName;
import android.content.Context;
import android.content.pm.ApplicationInfo;
import android.content.pm.PackageInfo;
import android.content.pm.PackageManager;
import android.graphics.drawable.Drawable;
import android.os.Binder;
import android.os.Process;
import android.support.v4.content.f;
import android.support.v4.e.j;
import com.google.android.gms.common.util.PlatformVersion;
import com.tencent.matrix.trace.core.AppMethodBeat;

public class PackageManagerWrapper
{
  private final Context zzjp;
  
  public PackageManagerWrapper(Context paramContext)
  {
    this.zzjp = paramContext;
  }
  
  public boolean allowApiAccess(String paramString, int paramInt)
  {
    return true;
  }
  
  public void checkCallerIsNotInstantApp()
  {
    AppMethodBeat.i(90326);
    if (isCallerInstantApp())
    {
      SecurityException localSecurityException = new SecurityException("This operation is not supported for instant apps.");
      AppMethodBeat.o(90326);
      throw localSecurityException;
    }
    AppMethodBeat.o(90326);
  }
  
  public int checkCallingOrSelfPermission(String paramString)
  {
    AppMethodBeat.i(90317);
    int i = this.zzjp.checkCallingOrSelfPermission(paramString);
    AppMethodBeat.o(90317);
    return i;
  }
  
  public int checkCallingOrSelfPermissionAndAppOps(String paramString)
  {
    AppMethodBeat.i(90318);
    int i = f.f(this.zzjp, paramString);
    AppMethodBeat.o(90318);
    return i;
  }
  
  public int checkCallingPermission(String paramString)
  {
    AppMethodBeat.i(90315);
    int i = this.zzjp.checkCallingPermission(paramString);
    AppMethodBeat.o(90315);
    return i;
  }
  
  @Deprecated
  public int checkCallingPermission(String paramString1, String paramString2)
  {
    AppMethodBeat.i(90319);
    int i = checkPermission(paramString1, paramString2);
    AppMethodBeat.o(90319);
    return i;
  }
  
  public int checkCallingPermissionAndAppOps(String paramString1, String paramString2)
  {
    AppMethodBeat.i(90316);
    Context localContext = this.zzjp;
    if (Binder.getCallingPid() == Process.myPid())
    {
      AppMethodBeat.o(90316);
      return -1;
    }
    int i = f.a(localContext, paramString1, Binder.getCallingPid(), Binder.getCallingUid(), paramString2);
    AppMethodBeat.o(90316);
    return i;
  }
  
  public void checkPackage(int paramInt, String paramString)
  {
    AppMethodBeat.i(90310);
    if (!uidHasPackageName(paramInt, paramString))
    {
      paramString = new SecurityException(String.valueOf(paramString).length() + 39 + "Package " + paramString + " does not belong to " + paramInt);
      AppMethodBeat.o(90310);
      throw paramString;
    }
    AppMethodBeat.o(90310);
  }
  
  public int checkPermission(String paramString, int paramInt1, int paramInt2)
  {
    AppMethodBeat.i(90312);
    paramInt1 = this.zzjp.checkPermission(paramString, paramInt1, paramInt2);
    AppMethodBeat.o(90312);
    return paramInt1;
  }
  
  @Deprecated
  public int checkPermission(String paramString1, int paramInt1, int paramInt2, String paramString2)
  {
    AppMethodBeat.i(90313);
    paramInt1 = checkPermission(paramString1, paramInt1, paramInt2);
    AppMethodBeat.o(90313);
    return paramInt1;
  }
  
  public int checkPermission(String paramString1, String paramString2)
  {
    AppMethodBeat.i(90320);
    int i = this.zzjp.getPackageManager().checkPermission(paramString1, paramString2);
    AppMethodBeat.o(90320);
    return i;
  }
  
  public int checkPermissionAndAppOps(String paramString1, int paramInt1, int paramInt2, String paramString2)
  {
    AppMethodBeat.i(90314);
    paramInt1 = f.a(this.zzjp, paramString1, paramInt1, paramInt2, paramString2);
    AppMethodBeat.o(90314);
    return paramInt1;
  }
  
  public ApplicationInfo getApplicationInfo(String paramString, int paramInt)
  {
    AppMethodBeat.i(90307);
    paramString = this.zzjp.getPackageManager().getApplicationInfo(paramString, paramInt);
    AppMethodBeat.o(90307);
    return paramString;
  }
  
  public CharSequence getApplicationLabel(String paramString)
  {
    AppMethodBeat.i(90323);
    paramString = this.zzjp.getPackageManager().getApplicationLabel(this.zzjp.getPackageManager().getApplicationInfo(paramString, 0));
    AppMethodBeat.o(90323);
    return paramString;
  }
  
  public j<CharSequence, Drawable> getApplicationLabelAndIcon(String paramString)
  {
    AppMethodBeat.i(90324);
    paramString = this.zzjp.getPackageManager().getApplicationInfo(paramString, 0);
    paramString = new j(this.zzjp.getPackageManager().getApplicationLabel(paramString), this.zzjp.getPackageManager().getApplicationIcon(paramString));
    AppMethodBeat.o(90324);
    return paramString;
  }
  
  public ComponentName getCallingActivity(Activity paramActivity)
  {
    AppMethodBeat.i(90322);
    paramActivity = paramActivity.getCallingActivity();
    AppMethodBeat.o(90322);
    return paramActivity;
  }
  
  public String getCallingPackage(Activity paramActivity)
  {
    AppMethodBeat.i(90321);
    paramActivity = paramActivity.getCallingActivity();
    if (paramActivity == null)
    {
      AppMethodBeat.o(90321);
      return null;
    }
    String str = paramActivity.getPackageName();
    if (str == null)
    {
      paramActivity = String.valueOf(paramActivity);
      new StringBuilder(String.valueOf(paramActivity).length() + 54).append("getCallingPackage(): Couldn't get a package name from ").append(paramActivity);
      AppMethodBeat.o(90321);
      return null;
    }
    AppMethodBeat.o(90321);
    return str;
  }
  
  protected Context getContext()
  {
    return this.zzjp;
  }
  
  public PackageInfo getPackageInfo(String paramString, int paramInt)
  {
    AppMethodBeat.i(90308);
    paramString = this.zzjp.getPackageManager().getPackageInfo(paramString, paramInt);
    AppMethodBeat.o(90308);
    return paramString;
  }
  
  public String[] getPackagesForUid(int paramInt)
  {
    AppMethodBeat.i(90309);
    String[] arrayOfString = this.zzjp.getPackageManager().getPackagesForUid(paramInt);
    AppMethodBeat.o(90309);
    return arrayOfString;
  }
  
  public boolean isCallerInstantApp()
  {
    AppMethodBeat.i(90325);
    boolean bool;
    if (Binder.getCallingUid() == Process.myUid())
    {
      bool = InstantApps.isInstantApp(this.zzjp);
      AppMethodBeat.o(90325);
      return bool;
    }
    if (PlatformVersion.isAtLeastO())
    {
      String str = this.zzjp.getPackageManager().getNameForUid(Binder.getCallingUid());
      if (str != null)
      {
        bool = this.zzjp.getPackageManager().isInstantApp(str);
        AppMethodBeat.o(90325);
        return bool;
      }
    }
    AppMethodBeat.o(90325);
    return false;
  }
  
  public boolean isInstantAppUid(int paramInt)
  {
    return false;
  }
  
  @TargetApi(19)
  public boolean uidHasPackageName(int paramInt, String paramString)
  {
    AppMethodBeat.i(90311);
    if (PlatformVersion.isAtLeastKitKat()) {
      try
      {
        ((AppOpsManager)this.zzjp.getSystemService("appops")).checkPackage(paramInt, paramString);
        AppMethodBeat.o(90311);
        return true;
      }
      catch (SecurityException paramString)
      {
        AppMethodBeat.o(90311);
        return false;
      }
    }
    String[] arrayOfString = this.zzjp.getPackageManager().getPackagesForUid(paramInt);
    if ((paramString != null) && (arrayOfString != null))
    {
      paramInt = 0;
      while (paramInt < arrayOfString.length)
      {
        if (paramString.equals(arrayOfString[paramInt]))
        {
          AppMethodBeat.o(90311);
          return true;
        }
        paramInt += 1;
      }
    }
    AppMethodBeat.o(90311);
    return false;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.google.android.gms.common.wrappers.PackageManagerWrapper
 * JD-Core Version:    0.7.0.1
 */