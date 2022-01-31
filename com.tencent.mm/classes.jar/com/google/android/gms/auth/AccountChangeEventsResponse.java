package com.google.android.gms.auth;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.common.internal.safeparcel.zza;
import com.google.android.gms.common.internal.zzac;
import java.util.List;

public class AccountChangeEventsResponse
  extends zza
{
  public static final Parcelable.Creator<AccountChangeEventsResponse> CREATOR = new zzc();
  final int mVersion;
  final List<AccountChangeEvent> zzth;
  
  AccountChangeEventsResponse(int paramInt, List<AccountChangeEvent> paramList)
  {
    this.mVersion = paramInt;
    this.zzth = ((List)zzac.zzw(paramList));
  }
  
  public AccountChangeEventsResponse(List<AccountChangeEvent> paramList)
  {
    this.mVersion = 1;
    this.zzth = ((List)zzac.zzw(paramList));
  }
  
  public List<AccountChangeEvent> getEvents()
  {
    return this.zzth;
  }
  
  public void writeToParcel(Parcel paramParcel, int paramInt)
  {
    zzc.zza(this, paramParcel, paramInt);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.google.android.gms.auth.AccountChangeEventsResponse
 * JD-Core Version:    0.7.0.1
 */