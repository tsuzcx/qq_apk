package com.google.android.gms.auth;

import android.accounts.Account;
import android.os.Parcel;
import android.os.Parcelable.Creator;
import android.text.TextUtils;
import com.google.android.gms.common.internal.safeparcel.zza;

public class AccountChangeEventsRequest
  extends zza
{
  public static final Parcelable.Creator<AccountChangeEventsRequest> CREATOR = new zzb();
  final int mVersion;
  Account zzahh;
  @Deprecated
  String zzaiu;
  int zzaiw;
  
  public AccountChangeEventsRequest()
  {
    this.mVersion = 1;
  }
  
  AccountChangeEventsRequest(int paramInt1, int paramInt2, String paramString, Account paramAccount)
  {
    this.mVersion = paramInt1;
    this.zzaiw = paramInt2;
    this.zzaiu = paramString;
    if ((paramAccount == null) && (!TextUtils.isEmpty(paramString)))
    {
      this.zzahh = new Account(paramString, "com.google");
      return;
    }
    this.zzahh = paramAccount;
  }
  
  public Account getAccount()
  {
    return this.zzahh;
  }
  
  @Deprecated
  public String getAccountName()
  {
    return this.zzaiu;
  }
  
  public int getEventIndex()
  {
    return this.zzaiw;
  }
  
  public AccountChangeEventsRequest setAccount(Account paramAccount)
  {
    this.zzahh = paramAccount;
    return this;
  }
  
  @Deprecated
  public AccountChangeEventsRequest setAccountName(String paramString)
  {
    this.zzaiu = paramString;
    return this;
  }
  
  public AccountChangeEventsRequest setEventIndex(int paramInt)
  {
    this.zzaiw = paramInt;
    return this;
  }
  
  public void writeToParcel(Parcel paramParcel, int paramInt)
  {
    zzb.zza(this, paramParcel, paramInt);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes9.jar
 * Qualified Name:     com.google.android.gms.auth.AccountChangeEventsRequest
 * JD-Core Version:    0.7.0.1
 */