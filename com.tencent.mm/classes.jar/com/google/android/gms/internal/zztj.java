package com.google.android.gms.internal;

import com.google.android.gms.common.internal.zzac;
import com.google.android.gms.common.util.zze;

class zztj
{
  private long zzLp;
  private final zze zzuP;
  
  public zztj(zze paramzze)
  {
    zzac.zzw(paramzze);
    this.zzuP = paramzze;
  }
  
  public zztj(zze paramzze, long paramLong)
  {
    zzac.zzw(paramzze);
    this.zzuP = paramzze;
    this.zzLp = paramLong;
  }
  
  public void clear()
  {
    this.zzLp = 0L;
  }
  
  public void start()
  {
    this.zzLp = this.zzuP.elapsedRealtime();
  }
  
  public boolean zzA(long paramLong)
  {
    if (this.zzLp == 0L) {}
    while (this.zzuP.elapsedRealtime() - this.zzLp > paramLong) {
      return true;
    }
    return false;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.google.android.gms.internal.zztj
 * JD-Core Version:    0.7.0.1
 */