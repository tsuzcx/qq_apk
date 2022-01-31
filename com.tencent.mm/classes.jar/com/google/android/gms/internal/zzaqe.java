package com.google.android.gms.internal;

public final class zzaqe
{
  private static zzaqe zzaXl;
  private final zzaqb zzaXm = new zzaqb();
  private final zzaqc zzaXn = new zzaqc();
  
  static
  {
    zza(new zzaqe());
  }
  
  private static zzaqe zzDC()
  {
    try
    {
      zzaqe localzzaqe = zzaXl;
      return localzzaqe;
    }
    finally {}
  }
  
  public static zzaqb zzDD()
  {
    return zzDC().zzaXm;
  }
  
  public static zzaqc zzDE()
  {
    return zzDC().zzaXn;
  }
  
  protected static void zza(zzaqe paramzzaqe)
  {
    try
    {
      zzaXl = paramzzaqe;
      return;
    }
    finally {}
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.google.android.gms.internal.zzaqe
 * JD-Core Version:    0.7.0.1
 */