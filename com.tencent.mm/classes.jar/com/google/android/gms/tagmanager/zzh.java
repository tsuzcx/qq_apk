package com.google.android.gms.tagmanager;

import android.content.Context;
import android.content.pm.PackageInfo;
import android.content.pm.PackageManager;
import android.content.pm.PackageManager.NameNotFoundException;
import com.google.android.gms.internal.zzah;
import com.google.android.gms.internal.zzak.zza;
import java.util.Map;

class zzh
  extends zzam
{
  private static final String ID = zzah.zzdh.toString();
  private final Context mContext;
  
  public zzh(Context paramContext)
  {
    super(ID, new String[0]);
    this.mContext = paramContext;
  }
  
  public boolean zzQa()
  {
    return true;
  }
  
  public zzak.zza zzZ(Map<String, zzak.zza> paramMap)
  {
    try
    {
      paramMap = zzdl.zzR(Integer.valueOf(this.mContext.getPackageManager().getPackageInfo(this.mContext.getPackageName(), 0).versionCode));
      return paramMap;
    }
    catch (PackageManager.NameNotFoundException localNameNotFoundException)
    {
      paramMap = String.valueOf(this.mContext.getPackageName());
      String str = String.valueOf(localNameNotFoundException.getMessage());
      zzbo.e(String.valueOf(paramMap).length() + 25 + String.valueOf(str).length() + "Package name " + paramMap + " not found. " + str);
    }
    return zzdl.zzRQ();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.google.android.gms.tagmanager.zzh
 * JD-Core Version:    0.7.0.1
 */