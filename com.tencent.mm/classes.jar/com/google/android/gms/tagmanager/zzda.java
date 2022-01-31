package com.google.android.gms.tagmanager;

import com.google.android.gms.common.util.zze;
import com.google.android.gms.common.util.zzi;

class zzda
  implements zzcl
{
  private final long zzagm;
  private final int zzagn;
  private double zzago;
  private final Object zzagq = new Object();
  private long zzbId;
  private final zze zzuP;
  
  public zzda()
  {
    this(60, 2000L);
  }
  
  public zzda(int paramInt, long paramLong)
  {
    this.zzagn = paramInt;
    this.zzago = this.zzagn;
    this.zzagm = paramLong;
    this.zzuP = zzi.zzzc();
  }
  
  public boolean zzpV()
  {
    synchronized (this.zzagq)
    {
      long l = this.zzuP.currentTimeMillis();
      if (this.zzago < this.zzagn)
      {
        double d = (l - this.zzbId) / this.zzagm;
        if (d > 0.0D) {
          this.zzago = Math.min(this.zzagn, d + this.zzago);
        }
      }
      this.zzbId = l;
      if (this.zzago >= 1.0D)
      {
        this.zzago -= 1.0D;
        return true;
      }
      zzbo.zzbh("No more tokens available.");
      return false;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes9.jar
 * Qualified Name:     com.google.android.gms.tagmanager.zzda
 * JD-Core Version:    0.7.0.1
 */