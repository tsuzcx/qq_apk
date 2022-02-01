package com.google.android.gms.wearable.internal;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.common.internal.safeparcel.AbstractSafeParcelable;
import com.google.android.gms.common.internal.safeparcel.SafeParcelWriter;
import com.tencent.matrix.trace.core.AppMethodBeat;

public final class zzl
  extends AbstractSafeParcelable
{
  public static final Parcelable.Creator<zzl> CREATOR;
  private int id;
  private final String packageName;
  private final String zzbf;
  private final String zzbg;
  private final String zzbh;
  private final String zzbi;
  private final String zzbj;
  private final String zzbk;
  private final byte zzbl;
  private final byte zzbm;
  private final byte zzbn;
  private final byte zzbo;
  
  static
  {
    AppMethodBeat.i(101436);
    CREATOR = new zzm();
    AppMethodBeat.o(101436);
  }
  
  public zzl(int paramInt, String paramString1, String paramString2, String paramString3, String paramString4, String paramString5, String paramString6, byte paramByte1, byte paramByte2, byte paramByte3, byte paramByte4, String paramString7)
  {
    this.id = paramInt;
    this.zzbf = paramString1;
    this.zzbg = paramString2;
    this.zzbh = paramString3;
    this.zzbi = paramString4;
    this.zzbj = paramString5;
    this.zzbk = paramString6;
    this.zzbl = paramByte1;
    this.zzbm = paramByte2;
    this.zzbn = paramByte3;
    this.zzbo = paramByte4;
    this.packageName = paramString7;
  }
  
  public final boolean equals(Object paramObject)
  {
    AppMethodBeat.i(101434);
    if (this == paramObject)
    {
      AppMethodBeat.o(101434);
      return true;
    }
    if ((paramObject == null) || (getClass() != paramObject.getClass()))
    {
      AppMethodBeat.o(101434);
      return false;
    }
    paramObject = (zzl)paramObject;
    if (this.id != paramObject.id)
    {
      AppMethodBeat.o(101434);
      return false;
    }
    if (this.zzbl != paramObject.zzbl)
    {
      AppMethodBeat.o(101434);
      return false;
    }
    if (this.zzbm != paramObject.zzbm)
    {
      AppMethodBeat.o(101434);
      return false;
    }
    if (this.zzbn != paramObject.zzbn)
    {
      AppMethodBeat.o(101434);
      return false;
    }
    if (this.zzbo != paramObject.zzbo)
    {
      AppMethodBeat.o(101434);
      return false;
    }
    if (!this.zzbf.equals(paramObject.zzbf))
    {
      AppMethodBeat.o(101434);
      return false;
    }
    if (this.zzbg != null)
    {
      if (this.zzbg.equals(paramObject.zzbg)) {}
    }
    else {
      while (paramObject.zzbg != null)
      {
        AppMethodBeat.o(101434);
        return false;
      }
    }
    if (!this.zzbh.equals(paramObject.zzbh))
    {
      AppMethodBeat.o(101434);
      return false;
    }
    if (!this.zzbi.equals(paramObject.zzbi))
    {
      AppMethodBeat.o(101434);
      return false;
    }
    if (!this.zzbj.equals(paramObject.zzbj))
    {
      AppMethodBeat.o(101434);
      return false;
    }
    if (this.zzbk != null)
    {
      if (this.zzbk.equals(paramObject.zzbk)) {}
    }
    else {
      while (paramObject.zzbk != null)
      {
        AppMethodBeat.o(101434);
        return false;
      }
    }
    if (this.packageName != null)
    {
      boolean bool = this.packageName.equals(paramObject.packageName);
      AppMethodBeat.o(101434);
      return bool;
    }
    if (paramObject.packageName == null)
    {
      AppMethodBeat.o(101434);
      return true;
    }
    AppMethodBeat.o(101434);
    return false;
  }
  
  public final int hashCode()
  {
    int k = 0;
    AppMethodBeat.i(101435);
    int m = this.id;
    int n = this.zzbf.hashCode();
    int i;
    int i1;
    int i2;
    int i3;
    if (this.zzbg != null)
    {
      i = this.zzbg.hashCode();
      i1 = this.zzbh.hashCode();
      i2 = this.zzbi.hashCode();
      i3 = this.zzbj.hashCode();
      if (this.zzbk == null) {
        break label197;
      }
    }
    label197:
    for (int j = this.zzbk.hashCode();; j = 0)
    {
      int i4 = this.zzbl;
      int i5 = this.zzbm;
      int i6 = this.zzbn;
      int i7 = this.zzbo;
      if (this.packageName != null) {
        k = this.packageName.hashCode();
      }
      AppMethodBeat.o(101435);
      return (((((j + ((((i + ((m + 31) * 31 + n) * 31) * 31 + i1) * 31 + i2) * 31 + i3) * 31) * 31 + i4) * 31 + i5) * 31 + i6) * 31 + i7) * 31 + k;
      i = 0;
      break;
    }
  }
  
  public final String toString()
  {
    AppMethodBeat.i(101433);
    int i = this.id;
    String str1 = this.zzbf;
    String str2 = this.zzbg;
    String str3 = this.zzbh;
    String str4 = this.zzbi;
    String str5 = this.zzbj;
    String str6 = this.zzbk;
    int j = this.zzbl;
    int k = this.zzbm;
    int m = this.zzbn;
    int n = this.zzbo;
    String str7 = this.packageName;
    str1 = String.valueOf(str1).length() + 211 + String.valueOf(str2).length() + String.valueOf(str3).length() + String.valueOf(str4).length() + String.valueOf(str5).length() + String.valueOf(str6).length() + String.valueOf(str7).length() + "AncsNotificationParcelable{, id=" + i + ", appId='" + str1 + '\'' + ", dateTime='" + str2 + '\'' + ", notificationText='" + str3 + '\'' + ", title='" + str4 + '\'' + ", subtitle='" + str5 + '\'' + ", displayName='" + str6 + '\'' + ", eventId=" + j + ", eventFlags=" + k + ", categoryId=" + m + ", categoryCount=" + n + ", packageName='" + str7 + '\'' + '}';
    AppMethodBeat.o(101433);
    return str1;
  }
  
  public final void writeToParcel(Parcel paramParcel, int paramInt)
  {
    AppMethodBeat.i(101432);
    paramInt = SafeParcelWriter.beginObjectHeader(paramParcel);
    SafeParcelWriter.writeInt(paramParcel, 2, this.id);
    SafeParcelWriter.writeString(paramParcel, 3, this.zzbf, false);
    SafeParcelWriter.writeString(paramParcel, 4, this.zzbg, false);
    SafeParcelWriter.writeString(paramParcel, 5, this.zzbh, false);
    SafeParcelWriter.writeString(paramParcel, 6, this.zzbi, false);
    SafeParcelWriter.writeString(paramParcel, 7, this.zzbj, false);
    if (this.zzbk == null) {}
    for (String str = this.zzbf;; str = this.zzbk)
    {
      SafeParcelWriter.writeString(paramParcel, 8, str, false);
      SafeParcelWriter.writeByte(paramParcel, 9, this.zzbl);
      SafeParcelWriter.writeByte(paramParcel, 10, this.zzbm);
      SafeParcelWriter.writeByte(paramParcel, 11, this.zzbn);
      SafeParcelWriter.writeByte(paramParcel, 12, this.zzbo);
      SafeParcelWriter.writeString(paramParcel, 13, this.packageName, false);
      SafeParcelWriter.finishObjectHeader(paramParcel, paramInt);
      AppMethodBeat.o(101432);
      return;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.google.android.gms.wearable.internal.zzl
 * JD-Core Version:    0.7.0.1
 */