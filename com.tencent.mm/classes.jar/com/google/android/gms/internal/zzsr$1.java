package com.google.android.gms.internal;

import android.os.Looper;
import com.google.android.gms.analytics.zzh;

class zzsr$1
  implements Runnable
{
  zzsr$1(zzsr paramzzsr) {}
  
  public void run()
  {
    if (Looper.myLooper() == Looper.getMainLooper()) {
      zzsr.zza(this.zzaff).zznU().zzg(this);
    }
    boolean bool;
    do
    {
      return;
      bool = this.zzaff.zzcy();
      zzsr.zza(this.zzaff, 0L);
    } while (!bool);
    this.zzaff.run();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes9.jar
 * Qualified Name:     com.google.android.gms.internal.zzsr.1
 * JD-Core Version:    0.7.0.1
 */