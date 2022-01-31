package com.google.android.gms.internal;

import android.os.RemoteException;

public class zzaqa$zzd
  extends zzaqa<String>
{
  public zzaqa$zzd(int paramInt, String paramString1, String paramString2)
  {
    super(paramInt, paramString1, paramString2, null);
  }
  
  public String zze(zzaqd paramzzaqd)
  {
    try
    {
      paramzzaqd = paramzzaqd.getStringFlagValue(getKey(), (String)zzfr(), getSource());
      return paramzzaqd;
    }
    catch (RemoteException paramzzaqd) {}
    return (String)zzfr();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes8.jar
 * Qualified Name:     com.google.android.gms.internal.zzaqa.zzd
 * JD-Core Version:    0.7.0.1
 */