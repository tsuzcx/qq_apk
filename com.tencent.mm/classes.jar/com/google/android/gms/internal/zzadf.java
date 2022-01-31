package com.google.android.gms.internal;

import android.annotation.TargetApi;
import android.app.AppOpsManager;
import android.content.Context;
import android.content.pm.ApplicationInfo;
import android.content.pm.PackageInfo;
import android.content.pm.PackageManager;
import android.os.Binder;
import android.os.Process;
import com.google.android.gms.common.util.zzt;

public class zzadf
{
  protected final Context mContext;
  
  public zzadf(Context paramContext)
  {
    this.mContext = paramContext;
  }
  
  public int checkCallingOrSelfPermission(String paramString)
  {
    return this.mContext.checkCallingOrSelfPermission(paramString);
  }
  
  public int checkPermission(String paramString1, String paramString2)
  {
    return this.mContext.getPackageManager().checkPermission(paramString1, paramString2);
  }
  
  public ApplicationInfo getApplicationInfo(String paramString, int paramInt)
  {
    return this.mContext.getPackageManager().getApplicationInfo(paramString, paramInt);
  }
  
  public PackageInfo getPackageInfo(String paramString, int paramInt)
  {
    return this.mContext.getPackageManager().getPackageInfo(paramString, paramInt);
  }
  
  public String[] getPackagesForUid(int paramInt)
  {
    return this.mContext.getPackageManager().getPackagesForUid(paramInt);
  }
  
  public CharSequence zzdA(String paramString)
  {
    return this.mContext.getPackageManager().getApplicationLabel(this.mContext.getPackageManager().getApplicationInfo(paramString, 0));
  }
  
  @TargetApi(19)
  public boolean zzg(int paramInt, String paramString)
  {
    boolean bool2 = false;
    if (zzt.zzzl()) {}
    for (;;)
    {
      try
      {
        ((AppOpsManager)this.mContext.getSystemService("appops")).checkPackage(paramInt, paramString);
        bool1 = true;
        return bool1;
      }
      catch (SecurityException paramString) {}
      String[] arrayOfString = this.mContext.getPackageManager().getPackagesForUid(paramInt);
      boolean bool1 = bool2;
      if (paramString != null)
      {
        bool1 = bool2;
        if (arrayOfString != null)
        {
          paramInt = 0;
          for (;;)
          {
            bool1 = bool2;
            if (paramInt >= arrayOfString.length) {
              break;
            }
            if (paramString.equals(arrayOfString[paramInt])) {
              return true;
            }
            paramInt += 1;
          }
        }
      }
    }
    return false;
  }
  
  public boolean zzzw()
  {
    if (Binder.getCallingUid() == Process.myUid()) {
      return zzade.zzbg(this.mContext);
    }
    return false;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.google.android.gms.internal.zzadf
 * JD-Core Version:    0.7.0.1
 */