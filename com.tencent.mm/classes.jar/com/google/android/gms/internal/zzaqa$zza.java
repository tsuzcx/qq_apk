package com.google.android.gms.internal;

import android.os.RemoteException;

public class zzaqa$zza
  extends zzaqa<Boolean>
{
  public zzaqa$zza(int paramInt, String paramString, Boolean paramBoolean)
  {
    super(paramInt, paramString, paramBoolean, null);
  }
  
  public Boolean zzb(zzaqd paramzzaqd)
  {
    try
    {
      boolean bool = paramzzaqd.getBooleanFlagValue(getKey(), ((Boolean)zzfr()).booleanValue(), getSource());
      return Boolean.valueOf(bool);
    }
    catch (RemoteException paramzzaqd) {}
    return (Boolean)zzfr();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.google.android.gms.internal.zzaqa.zza
 * JD-Core Version:    0.7.0.1
 */