package com.google.android.gms.internal;

import android.accounts.Account;
import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.common.api.Scope;
import com.google.android.gms.common.internal.safeparcel.zza;

public class zzbar
  extends zza
{
  public static final Parcelable.Creator<zzbar> CREATOR = new zzbas();
  private final Account zzahh;
  final int zzaiI;
  private final String zzajw;
  private final Scope[] zzbEv;
  
  zzbar(int paramInt, Account paramAccount, Scope[] paramArrayOfScope, String paramString)
  {
    this.zzaiI = paramInt;
    this.zzahh = paramAccount;
    this.zzbEv = paramArrayOfScope;
    this.zzajw = paramString;
  }
  
  public Account getAccount()
  {
    return this.zzahh;
  }
  
  public String getServerClientId()
  {
    return this.zzajw;
  }
  
  public void writeToParcel(Parcel paramParcel, int paramInt)
  {
    zzbas.zza(this, paramParcel, paramInt);
  }
  
  public Scope[] zzPQ()
  {
    return this.zzbEv;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.google.android.gms.internal.zzbar
 * JD-Core Version:    0.7.0.1
 */