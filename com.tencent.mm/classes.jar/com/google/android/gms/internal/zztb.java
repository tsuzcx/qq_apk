package com.google.android.gms.internal;

import com.google.android.gms.common.util.zze;

public class zztb
{
  private final String zzadb;
  private final long zzagm;
  private final int zzagn;
  private double zzago;
  private long zzagp;
  private final Object zzagq = new Object();
  private final zze zzuP;
  
  public zztb(int paramInt, long paramLong, String paramString, zze paramzze)
  {
    this.zzagn = paramInt;
    this.zzago = this.zzagn;
    this.zzagm = paramLong;
    this.zzadb = paramString;
    this.zzuP = paramzze;
  }
  
  public zztb(String paramString, zze paramzze)
  {
    this(60, 2000L, paramString, paramzze);
  }
  
  public boolean zzpV()
  {
    synchronized (this.zzagq)
    {
      long l = this.zzuP.currentTimeMillis();
      if (this.zzago < this.zzagn)
      {
        double d = (l - this.zzagp) / this.zzagm;
        if (d > 0.0D) {
          this.zzago = Math.min(this.zzagn, d + this.zzago);
        }
      }
      this.zzagp = l;
      if (this.zzago >= 1.0D)
      {
        this.zzago -= 1.0D;
        return true;
      }
      String str = this.zzadb;
      zztc.zzbh(String.valueOf(str).length() + 34 + "Excessive " + str + " detected; call ignored.");
      return false;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.google.android.gms.internal.zztb
 * JD-Core Version:    0.7.0.1
 */