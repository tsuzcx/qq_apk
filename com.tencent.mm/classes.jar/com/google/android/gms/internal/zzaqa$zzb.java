package com.google.android.gms.internal;

import android.os.RemoteException;

public class zzaqa$zzb
  extends zzaqa<Integer>
{
  public zzaqa$zzb(int paramInt, String paramString, Integer paramInteger)
  {
    super(paramInt, paramString, paramInteger, null);
  }
  
  public Integer zzc(zzaqd paramzzaqd)
  {
    try
    {
      int i = paramzzaqd.getIntFlagValue(getKey(), ((Integer)zzfr()).intValue(), getSource());
      return Integer.valueOf(i);
    }
    catch (RemoteException paramzzaqd) {}
    return (Integer)zzfr();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.google.android.gms.internal.zzaqa.zzb
 * JD-Core Version:    0.7.0.1
 */