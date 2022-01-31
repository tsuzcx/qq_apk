package com.google.android.gms.common.internal;

import android.accounts.Account;
import android.os.Bundle;
import android.os.IBinder;
import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.common.api.Scope;
import com.google.android.gms.common.zzc;
import com.google.android.gms.common.zze;
import java.util.Collection;

public class zzj
  extends com.google.android.gms.common.internal.safeparcel.zza
{
  public static final Parcelable.Creator<zzj> CREATOR = new zzk();
  final int version;
  final int zzaFK;
  int zzaFL;
  String zzaFM;
  IBinder zzaFN;
  Scope[] zzaFO;
  Bundle zzaFP;
  Account zzaFQ;
  zzc[] zzaFR;
  
  public zzj(int paramInt)
  {
    this.version = 3;
    this.zzaFL = zze.GOOGLE_PLAY_SERVICES_VERSION_CODE;
    this.zzaFK = paramInt;
  }
  
  zzj(int paramInt1, int paramInt2, int paramInt3, String paramString, IBinder paramIBinder, Scope[] paramArrayOfScope, Bundle paramBundle, Account paramAccount, zzc[] paramArrayOfzzc)
  {
    this.version = paramInt1;
    this.zzaFK = paramInt2;
    this.zzaFL = paramInt3;
    if ("com.google.android.gms".equals(paramString))
    {
      this.zzaFM = "com.google.android.gms";
      if (paramInt1 >= 2) {
        break label78;
      }
    }
    for (this.zzaFQ = zzbq(paramIBinder);; this.zzaFQ = paramAccount)
    {
      this.zzaFO = paramArrayOfScope;
      this.zzaFP = paramBundle;
      this.zzaFR = paramArrayOfzzc;
      return;
      this.zzaFM = paramString;
      break;
      label78:
      this.zzaFN = paramIBinder;
    }
  }
  
  private Account zzbq(IBinder paramIBinder)
  {
    Account localAccount = null;
    if (paramIBinder != null) {
      localAccount = zza.zza(zzr.zza.zzbr(paramIBinder));
    }
    return localAccount;
  }
  
  public void writeToParcel(Parcel paramParcel, int paramInt)
  {
    zzk.zza(this, paramParcel, paramInt);
  }
  
  public zzj zza(zzc[] paramArrayOfzzc)
  {
    this.zzaFR = paramArrayOfzzc;
    return this;
  }
  
  public zzj zzb(zzr paramzzr)
  {
    if (paramzzr != null) {
      this.zzaFN = paramzzr.asBinder();
    }
    return this;
  }
  
  public zzj zzdm(String paramString)
  {
    this.zzaFM = paramString;
    return this;
  }
  
  public zzj zzf(Account paramAccount)
  {
    this.zzaFQ = paramAccount;
    return this;
  }
  
  public zzj zzf(Collection<Scope> paramCollection)
  {
    this.zzaFO = ((Scope[])paramCollection.toArray(new Scope[paramCollection.size()]));
    return this;
  }
  
  public zzj zzp(Bundle paramBundle)
  {
    this.zzaFP = paramBundle;
    return this;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.google.android.gms.common.internal.zzj
 * JD-Core Version:    0.7.0.1
 */