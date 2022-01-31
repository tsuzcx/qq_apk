package com.google.android.gms.tagmanager;

import com.google.android.gms.common.util.zze;

class zzbm
  implements zzcl
{
  private final String zzadb;
  private final long zzagm;
  private final int zzagn;
  private double zzago;
  private long zzagp;
  private final Object zzagq = new Object();
  private final long zzbGL;
  private final zze zzuP;
  
  public zzbm(int paramInt1, int paramInt2, long paramLong1, long paramLong2, String paramString, zze paramzze)
  {
    this.zzagn = paramInt2;
    this.zzago = Math.min(paramInt1, paramInt2);
    this.zzagm = paramLong1;
    this.zzbGL = paramLong2;
    this.zzadb = paramString;
    this.zzuP = paramzze;
  }
  
  public boolean zzpV()
  {
    synchronized (this.zzagq)
    {
      long l = this.zzuP.currentTimeMillis();
      if (l - this.zzagp < this.zzbGL)
      {
        String str1 = this.zzadb;
        zzbo.zzbh(String.valueOf(str1).length() + 34 + "Excessive " + str1 + " detected; call ignored.");
        return false;
      }
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
    }
    String str2 = this.zzadb;
    zzbo.zzbh(String.valueOf(str2).length() + 34 + "Excessive " + str2 + " detected; call ignored.");
    return false;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes8.jar
 * Qualified Name:     com.google.android.gms.tagmanager.zzbm
 * JD-Core Version:    0.7.0.1
 */