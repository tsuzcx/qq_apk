package com.google.android.gms.common.internal;

import com.google.android.gms.common.internal.safeparcel.zza;

public abstract class DowngradeableSafeParcel
  extends zza
  implements ReflectedParcelable
{
  private static final Object zzaFG = new Object();
  private static ClassLoader zzaFH = null;
  private static Integer zzaFI = null;
  private boolean zzaFJ = false;
  
  protected static boolean zzdl(String paramString)
  {
    zzxU();
    return true;
  }
  
  protected static ClassLoader zzxU()
  {
    synchronized (zzaFG)
    {
      return null;
    }
  }
  
  protected static Integer zzxV()
  {
    synchronized (zzaFG)
    {
      return null;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes9.jar
 * Qualified Name:     com.google.android.gms.common.internal.DowngradeableSafeParcel
 * JD-Core Version:    0.7.0.1
 */