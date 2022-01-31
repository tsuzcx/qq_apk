package com.google.android.gms.flags.impl;

import android.content.Context;
import android.content.SharedPreferences;
import android.content.pm.PackageManager.NameNotFoundException;
import com.google.android.gms.common.util.DynamiteApi;
import com.google.android.gms.dynamic.IObjectWrapper;
import com.google.android.gms.dynamic.zzd;
import com.google.android.gms.internal.zzaqd.zza;

@DynamiteApi
public class FlagProviderImpl
  extends zzaqd.zza
{
  private SharedPreferences zzBd;
  private boolean zztZ = false;
  
  public boolean getBooleanFlagValue(String paramString, boolean paramBoolean, int paramInt)
  {
    if (!this.zztZ) {
      return paramBoolean;
    }
    return zza.zza.zza(this.zzBd, paramString, Boolean.valueOf(paramBoolean)).booleanValue();
  }
  
  public int getIntFlagValue(String paramString, int paramInt1, int paramInt2)
  {
    if (!this.zztZ) {
      return paramInt1;
    }
    return zza.zzb.zza(this.zzBd, paramString, Integer.valueOf(paramInt1)).intValue();
  }
  
  public long getLongFlagValue(String paramString, long paramLong, int paramInt)
  {
    if (!this.zztZ) {
      return paramLong;
    }
    return zza.zzc.zza(this.zzBd, paramString, Long.valueOf(paramLong)).longValue();
  }
  
  public String getStringFlagValue(String paramString1, String paramString2, int paramInt)
  {
    if (!this.zztZ) {
      return paramString2;
    }
    return zza.zzd.zza(this.zzBd, paramString1, paramString2);
  }
  
  public void init(IObjectWrapper paramIObjectWrapper)
  {
    paramIObjectWrapper = (Context)zzd.zzF(paramIObjectWrapper);
    if (this.zztZ) {
      return;
    }
    try
    {
      this.zzBd = zzb.zzn(paramIObjectWrapper.createPackageContext("com.google.android.gms", 0));
      this.zztZ = true;
      return;
    }
    catch (PackageManager.NameNotFoundException paramIObjectWrapper) {}
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.google.android.gms.flags.impl.FlagProviderImpl
 * JD-Core Version:    0.7.0.1
 */