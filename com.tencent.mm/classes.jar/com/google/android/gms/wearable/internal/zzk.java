package com.google.android.gms.wearable.internal;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.common.internal.safeparcel.zza;
import com.google.android.gms.wearable.zzd;

public final class zzk
  extends zza
  implements zzd
{
  public static final Parcelable.Creator<zzk> CREATOR = new zzl();
  private final String mAppId;
  private int mId;
  private final String zzRg;
  private final String zzaZc;
  private final String zzakb;
  private final String zzamJ;
  private final String zzaoc;
  private final String zzbTH;
  private final byte zzbTI;
  private final byte zzbTJ;
  private final byte zzbTK;
  private final byte zzbTL;
  
  public zzk(int paramInt, String paramString1, String paramString2, String paramString3, String paramString4, String paramString5, String paramString6, byte paramByte1, byte paramByte2, byte paramByte3, byte paramByte4, String paramString7)
  {
    this.mId = paramInt;
    this.mAppId = paramString1;
    this.zzbTH = paramString2;
    this.zzaoc = paramString3;
    this.zzamJ = paramString4;
    this.zzaZc = paramString5;
    this.zzakb = paramString6;
    this.zzbTI = paramByte1;
    this.zzbTJ = paramByte2;
    this.zzbTK = paramByte3;
    this.zzbTL = paramByte4;
    this.zzRg = paramString7;
  }
  
  public final boolean equals(Object paramObject)
  {
    if (this == paramObject) {}
    do
    {
      return true;
      if ((paramObject == null) || (getClass() != paramObject.getClass())) {
        return false;
      }
      paramObject = (zzk)paramObject;
      if (this.mId != paramObject.mId) {
        return false;
      }
      if (this.zzbTI != paramObject.zzbTI) {
        return false;
      }
      if (this.zzbTJ != paramObject.zzbTJ) {
        return false;
      }
      if (this.zzbTK != paramObject.zzbTK) {
        return false;
      }
      if (this.zzbTL != paramObject.zzbTL) {
        return false;
      }
      if (!this.mAppId.equals(paramObject.mAppId)) {
        return false;
      }
      if (this.zzbTH != null)
      {
        if (this.zzbTH.equals(paramObject.zzbTH)) {}
      }
      else {
        while (paramObject.zzbTH != null) {
          return false;
        }
      }
      if (!this.zzaoc.equals(paramObject.zzaoc)) {
        return false;
      }
      if (!this.zzamJ.equals(paramObject.zzamJ)) {
        return false;
      }
      if (!this.zzaZc.equals(paramObject.zzaZc)) {
        return false;
      }
      if (this.zzakb != null)
      {
        if (this.zzakb.equals(paramObject.zzakb)) {}
      }
      else {
        while (paramObject.zzakb != null) {
          return false;
        }
      }
      if (this.zzRg != null) {
        return this.zzRg.equals(paramObject.zzRg);
      }
    } while (paramObject.zzRg == null);
    return false;
  }
  
  public final String getDisplayName()
  {
    if (this.zzakb == null) {
      return this.mAppId;
    }
    return this.zzakb;
  }
  
  public final int getId()
  {
    return this.mId;
  }
  
  public final String getPackageName()
  {
    return this.zzRg;
  }
  
  public final String getTitle()
  {
    return this.zzamJ;
  }
  
  public final int hashCode()
  {
    int k = 0;
    int m = this.mId;
    int n = this.mAppId.hashCode();
    int i;
    int i1;
    int i2;
    int i3;
    if (this.zzbTH != null)
    {
      i = this.zzbTH.hashCode();
      i1 = this.zzaoc.hashCode();
      i2 = this.zzamJ.hashCode();
      i3 = this.zzaZc.hashCode();
      if (this.zzakb == null) {
        break label187;
      }
    }
    label187:
    for (int j = this.zzakb.hashCode();; j = 0)
    {
      int i4 = this.zzbTI;
      int i5 = this.zzbTJ;
      int i6 = this.zzbTK;
      int i7 = this.zzbTL;
      if (this.zzRg != null) {
        k = this.zzRg.hashCode();
      }
      return (((((j + ((((i + ((m + 31) * 31 + n) * 31) * 31 + i1) * 31 + i2) * 31 + i3) * 31) * 31 + i4) * 31 + i5) * 31 + i6) * 31 + i7) * 31 + k;
      i = 0;
      break;
    }
  }
  
  public final String toString()
  {
    int i = this.mId;
    String str1 = this.mAppId;
    String str2 = this.zzbTH;
    String str3 = this.zzaoc;
    String str4 = this.zzamJ;
    String str5 = this.zzaZc;
    String str6 = this.zzakb;
    int j = this.zzbTI;
    int k = this.zzbTJ;
    int m = this.zzbTK;
    int n = this.zzbTL;
    String str7 = this.zzRg;
    return String.valueOf(str1).length() + 211 + String.valueOf(str2).length() + String.valueOf(str3).length() + String.valueOf(str4).length() + String.valueOf(str5).length() + String.valueOf(str6).length() + String.valueOf(str7).length() + "AncsNotificationParcelable{, id=" + i + ", appId='" + str1 + "', dateTime='" + str2 + "', notificationText='" + str3 + "', title='" + str4 + "', subtitle='" + str5 + "', displayName='" + str6 + "', eventId=" + j + ", eventFlags=" + k + ", categoryId=" + m + ", categoryCount=" + n + ", packageName='" + str7 + "'}";
  }
  
  public final void writeToParcel(Parcel paramParcel, int paramInt)
  {
    zzl.zza(this, paramParcel, paramInt);
  }
  
  public final String zzEu()
  {
    return this.zzaZc;
  }
  
  public final String zzUl()
  {
    return this.zzbTH;
  }
  
  public final String zzUm()
  {
    return this.zzaoc;
  }
  
  public final byte zzUn()
  {
    return this.zzbTI;
  }
  
  public final byte zzUo()
  {
    return this.zzbTJ;
  }
  
  public final byte zzUp()
  {
    return this.zzbTK;
  }
  
  public final byte zzUq()
  {
    return this.zzbTL;
  }
  
  public final String zzke()
  {
    return this.mAppId;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes8.jar
 * Qualified Name:     com.google.android.gms.wearable.internal.zzk
 * JD-Core Version:    0.7.0.1
 */