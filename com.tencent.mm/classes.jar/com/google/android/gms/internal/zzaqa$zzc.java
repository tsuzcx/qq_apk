package com.google.android.gms.internal;

import android.os.RemoteException;

public class zzaqa$zzc
  extends zzaqa<Long>
{
  public zzaqa$zzc(int paramInt, String paramString, Long paramLong)
  {
    super(paramInt, paramString, paramLong, null);
  }
  
  public Long zzd(zzaqd paramzzaqd)
  {
    try
    {
      long l = paramzzaqd.getLongFlagValue(getKey(), ((Long)zzfr()).longValue(), getSource());
      return Long.valueOf(l);
    }
    catch (RemoteException paramzzaqd) {}
    return (Long)zzfr();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.google.android.gms.internal.zzaqa.zzc
 * JD-Core Version:    0.7.0.1
 */