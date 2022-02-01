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
import android.support.v4.e.k;
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
    AppMethodBeat.i(5347);
    if (isCallerInstantApp())
    {
      SecurityException localSecurityException = new SecurityException("This operation is not supported for instant apps.");
      AppMethodBeat.o(5347);
      throw localSecurityException;
    }
    AppMethodBeat.o(5347);
  }
  
  public int checkCallingOrSelfPermission(String paramString)
  {
    AppMethodBeat.i(5338);
    int i = this.zzjp.checkCallingOrSelfPermission(paramString);
    AppMethodBeat.o(5338);
    return i;
  }
  
  public int checkCallingOrSelfPermissionAndAppOps(String paramString)
  {
    AppMethodBeat.i(5339);
    int i = f.f(this.zzjp, paramString);
    AppMethodBeat.o(5339);
    return i;
  }
  
  public int checkCallingPermission(String paramString)
  {
    AppMethodBeat.i(5336);
    int i = this.zzjp.checkCallingPermission(paramString);
    AppMethodBeat.o(5336);
    return i;
  }
  
  @Deprecated
  public int checkCallingPermission(String paramString1, String paramString2)
  {
    AppMethodBeat.i(5340);
    int i = checkPermission(paramString1, paramString2);
    AppMethodBeat.o(5340);
    return i;
  }
  
  public int checkCallingPermissionAndAppOps(String paramString1, String paramString2)
  {
    AppMethodBeat.i(5337);
    Context localContext = this.zzjp;
    if (Binder.getCallingPid() == Process.myPid())
    {
      AppMethodBeat.o(5337);
      return -1;
    }
    int i = f.a(localContext, paramString1, Binder.getCallingPid(), Binder.getCallingUid(), paramString2);
    AppMethodBeat.o(5337);
    return i;
  }
  
  public void checkPackage(int paramInt, String paramString)
  {
    AppMethodBeat.i(5331);
    if (!uidHasPackageName(paramInt, paramString))
    {
      paramString = new SecurityException(String.valueOf(paramString).length() + 39 + "Package " + paramString + " does not belong to " + paramInt);
      AppMethodBeat.o(5331);
      throw paramString;
    }
    AppMethodBeat.o(5331);
  }
  
  public int checkPermission(String paramString, int paramInt1, int paramInt2)
  {
    AppMethodBeat.i(5333);
    paramInt1 = this.zzjp.checkPermission(paramString, paramInt1, paramInt2);
    AppMethodBeat.o(5333);
    return paramInt1;
  }
  
  @Deprecated
  public int checkPermission(String paramString1, int paramInt1, int paramInt2, String paramString2)
  {
    AppMethodBeat.i(5334);
    paramInt1 = checkPermission(paramString1, paramInt1, paramInt2);
    AppMethodBeat.o(5334);
    return paramInt1;
  }
  
  public int checkPermission(String paramString1, String paramString2)
  {
    AppMethodBeat.i(5341);
    int i = this.zzjp.getPackageManager().checkPermission(paramString1, paramString2);
    AppMethodBeat.o(5341);
    return i;
  }
  
  public int checkPermissionAndAppOps(String paramString1, int paramInt1, int paramInt2, String paramString2)
  {
    AppMethodBeat.i(5335);
    paramInt1 = f.a(this.zzjp, paramString1, paramInt1, paramInt2, paramString2);
    AppMethodBeat.o(5335);
    return paramInt1;
  }
  
  public ApplicationInfo getApplicationInfo(String paramString, int paramInt)
  {
    AppMethodBeat.i(5328);
    paramString = this.zzjp.getPackageManager().getApplicationInfo(paramString, paramInt);
    AppMethodBeat.o(5328);
    return paramString;
  }
  
  public CharSequence getApplicationLabel(String paramString)
  {
    AppMethodBeat.i(5344);
    paramString = this.zzjp.getPackageManager().getApplicationLabel(this.zzjp.getPackageManager().getApplicationInfo(paramString, 0));
    AppMethodBeat.o(5344);
    return paramString;
  }
  
  public k<CharSequence, Drawable> getApplicationLabelAndIcon(String paramString)
  {
    AppMethodBeat.i(5345);
    paramString = this.zzjp.getPackageManager().getApplicationInfo(paramString, 0);
    paramString = new k(this.zzjp.getPackageManager().getApplicationLabel(paramString), this.zzjp.getPackageManager().getApplicationIcon(paramString));
    AppMethodBeat.o(5345);
    return paramString;
  }
  
  public ComponentName getCallingActivity(Activity paramActivity)
  {
    AppMethodBeat.i(5343);
    paramActivity = paramActivity.getCallingActivity();
    AppMethodBeat.o(5343);
    return paramActivity;
  }
  
  public String getCallingPackage(Activity paramActivity)
  {
    AppMethodBeat.i(5342);
    paramActivity = paramActivity.getCallingActivity();
    if (paramActivity == null)
    {
      AppMethodBeat.o(5342);
      return null;
    }
    String str = paramActivity.getPackageName();
    if (str == null)
    {
      paramActivity = String.valueOf(paramActivity);
      new StringBuilder(String.valueOf(paramActivity).length() + 54).append("getCallingPackage(): Couldn't get a package name from ").append(paramActivity);
      AppMethodBeat.o(5342);
      return null;
    }
    AppMethodBeat.o(5342);
    return str;
  }
  
  protected Context getContext()
  {
    return this.zzjp;
  }
  
  public PackageInfo getPackageInfo(String paramString, int paramInt)
  {
    AppMethodBeat.i(5329);
    paramString = this.zzjp.getPackageManager().getPackageInfo(paramString, paramInt);
    AppMethodBeat.o(5329);
    return paramString;
  }
  
  public String[] getPackagesForUid(int paramInt)
  {
    AppMethodBeat.i(5330);
    String[] arrayOfString = this.zzjp.getPackageManager().getPackagesForUid(paramInt);
    AppMethodBeat.o(5330);
    return arrayOfString;
  }
  
  public boolean isCallerInstantApp()
  {
    AppMethodBeat.i(5346);
    boolean bool;
    if (Binder.getCallingUid() == Process.myUid())
    {
      bool = InstantApps.isInstantApp(this.zzjp);
      AppMethodBeat.o(5346);
      return bool;
    }
    if (PlatformVersion.isAtLeastO())
    {
      String str = this.zzjp.getPackageManager().getNameForUid(Binder.getCallingUid());
      if (str != null)
      {
        bool = this.zzjp.getPackageManager().isInstantApp(str);
        AppMethodBeat.o(5346);
        return bool;
      }
    }
    AppMethodBeat.o(5346);
    return false;
  }
  
  public boolean isInstantAppUid(int paramInt)
  {
    return false;
  }
  
  @TargetApi(19)
  public boolean uidHasPackageName(int paramInt, String paramString)
  {
    AppMethodBeat.i(5332);
    if (PlatformVersion.isAtLeastKitKat()) {
      try
      {
        ((AppOpsManager)this.zzjp.getSystemService("appops")).checkPackage(paramInt, paramString);
        AppMethodBeat.o(5332);
        return true;
      }
      catch (SecurityException paramString)
      {
        AppMethodBeat.o(5332);
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
          AppMethodBeat.o(5332);
          return true;
        }
        paramInt += 1;
      }
    }
    AppMethodBeat.o(5332);
    return false;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.google.android.gms.common.wrappers.PackageManagerWrapper
 * JD-Core Version:    0.7.0.1
 */