package com.google.android.gms.auth;

import android.accounts.Account;
import android.os.Parcel;
import android.os.Parcelable.Creator;
import android.text.TextUtils;
import com.google.android.gms.common.internal.safeparcel.AbstractSafeParcelable;
import com.google.android.gms.common.internal.safeparcel.SafeParcelWriter;
import com.tencent.matrix.trace.core.AppMethodBeat;

public class AccountChangeEventsRequest
  extends AbstractSafeParcelable
{
  public static final Parcelable.Creator<AccountChangeEventsRequest> CREATOR;
  private final int zzh;
  @Deprecated
  private String zzj;
  private int zzl;
  private Account zzn;
  
  static
  {
    AppMethodBeat.i(10589);
    CREATOR = new zze();
    AppMethodBeat.o(10589);
  }
  
  public AccountChangeEventsRequest()
  {
    this.zzh = 1;
  }
  
  AccountChangeEventsRequest(int paramInt1, int paramInt2, String paramString, Account paramAccount)
  {
    AppMethodBeat.i(10587);
    this.zzh = paramInt1;
    this.zzl = paramInt2;
    this.zzj = paramString;
    if ((paramAccount == null) && (!TextUtils.isEmpty(paramString)))
    {
      this.zzn = new Account(paramString, "com.google");
      AppMethodBeat.o(10587);
      return;
    }
    this.zzn = paramAccount;
    AppMethodBeat.o(10587);
  }
  
  public Account getAccount()
  {
    return this.zzn;
  }
  
  @Deprecated
  public String getAccountName()
  {
    return this.zzj;
  }
  
  public int getEventIndex()
  {
    return this.zzl;
  }
  
  public AccountChangeEventsRequest setAccount(Account paramAccount)
  {
    this.zzn = paramAccount;
    return this;
  }
  
  @Deprecated
  public AccountChangeEventsRequest setAccountName(String paramString)
  {
    this.zzj = paramString;
    return this;
  }
  
  public AccountChangeEventsRequest setEventIndex(int paramInt)
  {
    this.zzl = paramInt;
    return this;
  }
  
  public void writeToParcel(Parcel paramParcel, int paramInt)
  {
    AppMethodBeat.i(10588);
    int i = SafeParcelWriter.beginObjectHeader(paramParcel);
    SafeParcelWriter.writeInt(paramParcel, 1, this.zzh);
    SafeParcelWriter.writeInt(paramParcel, 2, this.zzl);
    SafeParcelWriter.writeString(paramParcel, 3, this.zzj, false);
    SafeParcelWriter.writeParcelable(paramParcel, 4, this.zzn, paramInt, false);
    SafeParcelWriter.finishObjectHeader(paramParcel, i);
    AppMethodBeat.o(10588);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.google.android.gms.auth.AccountChangeEventsRequest
 * JD-Core Version:    0.7.0.1
 */