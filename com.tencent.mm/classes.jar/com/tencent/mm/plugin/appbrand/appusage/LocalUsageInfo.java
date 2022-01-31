package com.tencent.mm.plugin.appbrand.appusage;

import android.os.Parcel;
import android.os.Parcelable;
import android.os.Parcelable.Creator;
import com.tencent.mm.sdk.platformtools.bk;

public class LocalUsageInfo
  implements Parcelable
{
  public static final Parcelable.Creator<LocalUsageInfo> CREATOR = new LocalUsageInfo.1();
  public final String appId;
  public final int cau;
  public final String fJX;
  public final String fJY;
  public final boolean fJZ;
  public final int fJy;
  public final long fKa;
  public final String nickname;
  public final String username;
  
  private LocalUsageInfo(Parcel paramParcel)
  {
    this.username = paramParcel.readString();
    this.appId = paramParcel.readString();
    this.fJy = paramParcel.readInt();
    this.cau = paramParcel.readInt();
    this.nickname = paramParcel.readString();
    this.fJX = paramParcel.readString();
    this.fJY = paramParcel.readString();
    if (paramParcel.readByte() > 0) {}
    for (boolean bool = true;; bool = false)
    {
      this.fJZ = bool;
      this.fKa = paramParcel.readLong();
      return;
    }
  }
  
  public LocalUsageInfo(String paramString1, String paramString2, int paramInt1, int paramInt2, String paramString3, String paramString4, String paramString5, boolean paramBoolean, long paramLong)
  {
    this.username = paramString1;
    this.appId = paramString2;
    this.fJy = paramInt1;
    this.cau = paramInt2;
    this.nickname = paramString3;
    this.fJX = paramString4;
    this.fJY = paramString5;
    this.fJZ = paramBoolean;
    this.fKa = paramLong;
  }
  
  public int describeContents()
  {
    return 0;
  }
  
  public final boolean e(LocalUsageInfo paramLocalUsageInfo)
  {
    if (paramLocalUsageInfo == null) {}
    while ((bk.bl(paramLocalUsageInfo.username)) || (!paramLocalUsageInfo.username.equals(this.username)) || (paramLocalUsageInfo.fJy != this.fJy)) {
      return false;
    }
    return true;
  }
  
  public void writeToParcel(Parcel paramParcel, int paramInt)
  {
    paramParcel.writeString(this.username);
    paramParcel.writeString(this.appId);
    paramParcel.writeInt(this.fJy);
    paramParcel.writeInt(this.cau);
    paramParcel.writeString(this.nickname);
    paramParcel.writeString(this.fJX);
    paramParcel.writeString(this.fJY);
    if (this.fJZ) {}
    for (paramInt = 1;; paramInt = 0)
    {
      paramParcel.writeByte((byte)paramInt);
      paramParcel.writeLong(this.fKa);
      return;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.appusage.LocalUsageInfo
 * JD-Core Version:    0.7.0.1
 */