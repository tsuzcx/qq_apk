package com.google.android.gms.common.api;

import android.accounts.Account;
import android.os.Looper;
import com.google.android.gms.common.internal.zzac;
import com.google.android.gms.internal.zzabs;
import com.google.android.gms.internal.zzzy;

public class zzc$zza
{
  public static final zza zzayY = new zza().zzvk();
  public final Account account;
  public final zzabs zzayZ;
  public final Looper zzaza;
  
  private zzc$zza(zzabs paramzzabs, Account paramAccount, Looper paramLooper)
  {
    this.zzayZ = paramzzabs;
    this.account = paramAccount;
    this.zzaza = paramLooper;
  }
  
  public static class zza
  {
    private zzabs zzayW;
    private Looper zzrs;
    
    public zza zza(zzabs paramzzabs)
    {
      zzac.zzb(paramzzabs, "StatusExceptionMapper must not be null.");
      this.zzayW = paramzzabs;
      return this;
    }
    
    public zza zzb(Looper paramLooper)
    {
      zzac.zzb(paramLooper, "Looper must not be null.");
      this.zzrs = paramLooper;
      return this;
    }
    
    public zzc.zza zzvk()
    {
      if (this.zzayW == null) {
        this.zzayW = new zzzy();
      }
      if (this.zzrs == null) {
        if (Looper.myLooper() == null) {
          break label56;
        }
      }
      label56:
      for (this.zzrs = Looper.myLooper();; this.zzrs = Looper.getMainLooper()) {
        return new zzc.zza(this.zzayW, null, this.zzrs, null);
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.google.android.gms.common.api.zzc.zza
 * JD-Core Version:    0.7.0.1
 */