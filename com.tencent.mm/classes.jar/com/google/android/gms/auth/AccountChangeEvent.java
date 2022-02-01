package com.google.android.gms.auth;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.common.internal.Objects;
import com.google.android.gms.common.internal.Preconditions;
import com.google.android.gms.common.internal.safeparcel.AbstractSafeParcelable;
import com.google.android.gms.common.internal.safeparcel.SafeParcelWriter;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable.Class;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable.Constructor;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable.Field;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable.Param;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable.VersionField;
import com.tencent.matrix.trace.core.AppMethodBeat;

@SafeParcelable.Class(creator="AccountChangeEventCreator")
public class AccountChangeEvent
  extends AbstractSafeParcelable
{
  public static final Parcelable.Creator<AccountChangeEvent> CREATOR;
  @SafeParcelable.VersionField(id=1)
  private final int zzh;
  @SafeParcelable.Field(id=2)
  private final long zzi;
  @SafeParcelable.Field(id=3)
  private final String zzj;
  @SafeParcelable.Field(id=4)
  private final int zzk;
  @SafeParcelable.Field(id=5)
  private final int zzl;
  @SafeParcelable.Field(id=6)
  private final String zzm;
  
  static
  {
    AppMethodBeat.i(10586);
    CREATOR = new zzd();
    AppMethodBeat.o(10586);
  }
  
  @SafeParcelable.Constructor
  AccountChangeEvent(@SafeParcelable.Param(id=1) int paramInt1, @SafeParcelable.Param(id=2) long paramLong, @SafeParcelable.Param(id=3) String paramString1, @SafeParcelable.Param(id=4) int paramInt2, @SafeParcelable.Param(id=5) int paramInt3, @SafeParcelable.Param(id=6) String paramString2)
  {
    AppMethodBeat.i(10580);
    this.zzh = paramInt1;
    this.zzi = paramLong;
    this.zzj = ((String)Preconditions.checkNotNull(paramString1));
    this.zzk = paramInt2;
    this.zzl = paramInt3;
    this.zzm = paramString2;
    AppMethodBeat.o(10580);
  }
  
  public AccountChangeEvent(long paramLong, String paramString1, int paramInt1, int paramInt2, String paramString2)
  {
    AppMethodBeat.i(10581);
    this.zzh = 1;
    this.zzi = paramLong;
    this.zzj = ((String)Preconditions.checkNotNull(paramString1));
    this.zzk = paramInt1;
    this.zzl = paramInt2;
    this.zzm = paramString2;
    AppMethodBeat.o(10581);
  }
  
  public boolean equals(Object paramObject)
  {
    AppMethodBeat.i(10585);
    if (paramObject == this)
    {
      AppMethodBeat.o(10585);
      return true;
    }
    if ((paramObject instanceof AccountChangeEvent))
    {
      paramObject = (AccountChangeEvent)paramObject;
      if ((this.zzh == paramObject.zzh) && (this.zzi == paramObject.zzi) && (Objects.equal(this.zzj, paramObject.zzj)) && (this.zzk == paramObject.zzk) && (this.zzl == paramObject.zzl) && (Objects.equal(this.zzm, paramObject.zzm)))
      {
        AppMethodBeat.o(10585);
        return true;
      }
      AppMethodBeat.o(10585);
      return false;
    }
    AppMethodBeat.o(10585);
    return false;
  }
  
  public String getAccountName()
  {
    return this.zzj;
  }
  
  public String getChangeData()
  {
    return this.zzm;
  }
  
  public int getChangeType()
  {
    return this.zzk;
  }
  
  public int getEventIndex()
  {
    return this.zzl;
  }
  
  public int hashCode()
  {
    AppMethodBeat.i(10584);
    int i = Objects.hashCode(new Object[] { Integer.valueOf(this.zzh), Long.valueOf(this.zzi), this.zzj, Integer.valueOf(this.zzk), Integer.valueOf(this.zzl), this.zzm });
    AppMethodBeat.o(10584);
    return i;
  }
  
  public String toString()
  {
    AppMethodBeat.i(10583);
    String str1 = "UNKNOWN";
    switch (this.zzk)
    {
    }
    for (;;)
    {
      String str2 = this.zzj;
      String str3 = this.zzm;
      int i = this.zzl;
      str1 = String.valueOf(str2).length() + 91 + String.valueOf(str1).length() + String.valueOf(str3).length() + "AccountChangeEvent {accountName = " + str2 + ", changeType = " + str1 + ", changeData = " + str3 + ", eventIndex = " + i + "}";
      AppMethodBeat.o(10583);
      return str1;
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
    AppMethodBeat.i(10582);
    paramInt = SafeParcelWriter.beginObjectHeader(paramParcel);
    SafeParcelWriter.writeInt(paramParcel, 1, this.zzh);
    SafeParcelWriter.writeLong(paramParcel, 2, this.zzi);
    SafeParcelWriter.writeString(paramParcel, 3, this.zzj, false);
    SafeParcelWriter.writeInt(paramParcel, 4, this.zzk);
    SafeParcelWriter.writeInt(paramParcel, 5, this.zzl);
    SafeParcelWriter.writeString(paramParcel, 6, this.zzm, false);
    SafeParcelWriter.finishObjectHeader(paramParcel, paramInt);
    AppMethodBeat.o(10582);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes9.jar
 * Qualified Name:     com.google.android.gms.auth.AccountChangeEvent
 * JD-Core Version:    0.7.0.1
 */