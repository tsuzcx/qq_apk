package com.google.android.gms.auth;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.common.internal.zzaa;
import com.google.android.gms.common.internal.zzac;

public class AccountChangeEvent
  extends com.google.android.gms.common.internal.safeparcel.zza
{
  public static final Parcelable.Creator<AccountChangeEvent> CREATOR = new zza();
  final int mVersion;
  final long zzait;
  final String zzaiu;
  final int zzaiv;
  final int zzaiw;
  final String zzaix;
  
  AccountChangeEvent(int paramInt1, long paramLong, String paramString1, int paramInt2, int paramInt3, String paramString2)
  {
    this.mVersion = paramInt1;
    this.zzait = paramLong;
    this.zzaiu = ((String)zzac.zzw(paramString1));
    this.zzaiv = paramInt2;
    this.zzaiw = paramInt3;
    this.zzaix = paramString2;
  }
  
  public AccountChangeEvent(long paramLong, String paramString1, int paramInt1, int paramInt2, String paramString2)
  {
    this.mVersion = 1;
    this.zzait = paramLong;
    this.zzaiu = ((String)zzac.zzw(paramString1));
    this.zzaiv = paramInt1;
    this.zzaiw = paramInt2;
    this.zzaix = paramString2;
  }
  
  public boolean equals(Object paramObject)
  {
    if (paramObject == this) {}
    do
    {
      return true;
      if (!(paramObject instanceof AccountChangeEvent)) {
        break;
      }
      paramObject = (AccountChangeEvent)paramObject;
    } while ((this.mVersion == paramObject.mVersion) && (this.zzait == paramObject.zzait) && (zzaa.equal(this.zzaiu, paramObject.zzaiu)) && (this.zzaiv == paramObject.zzaiv) && (this.zzaiw == paramObject.zzaiw) && (zzaa.equal(this.zzaix, paramObject.zzaix)));
    return false;
    return false;
  }
  
  public String getAccountName()
  {
    return this.zzaiu;
  }
  
  public String getChangeData()
  {
    return this.zzaix;
  }
  
  public int getChangeType()
  {
    return this.zzaiv;
  }
  
  public int getEventIndex()
  {
    return this.zzaiw;
  }
  
  public int hashCode()
  {
    return zzaa.hashCode(new Object[] { Integer.valueOf(this.mVersion), Long.valueOf(this.zzait), this.zzaiu, Integer.valueOf(this.zzaiv), Integer.valueOf(this.zzaiw), this.zzaix });
  }
  
  public String toString()
  {
    String str1 = "UNKNOWN";
    switch (this.zzaiv)
    {
    }
    for (;;)
    {
      String str2 = this.zzaiu;
      String str3 = this.zzaix;
      int i = this.zzaiw;
      return String.valueOf(str2).length() + 91 + String.valueOf(str1).length() + String.valueOf(str3).length() + "AccountChangeEvent {accountName = " + str2 + ", changeType = " + str1 + ", changeData = " + str3 + ", eventIndex = " + i + "}";
      str1 = "ADDED";
      continue;
      str1 = "REMOVED";
      continue;
      str1 = "RENAMED_TO";
      continue;
      str1 = "RENAMED_FROM";
    }
  }
  
  public void writeToParcel(Parcel paramParcel, int paramInt)
  {
    zza.zza(this, paramParcel, paramInt);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.google.android.gms.auth.AccountChangeEvent
 * JD-Core Version:    0.7.0.1
 */