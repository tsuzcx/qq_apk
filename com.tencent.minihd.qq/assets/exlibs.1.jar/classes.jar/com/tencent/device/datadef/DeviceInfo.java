package com.tencent.device.datadef;

import android.os.Parcel;
import android.os.Parcelable;
import android.os.Parcelable.Creator;
import android.text.TextUtils;
import czo;

public class DeviceInfo
  implements Parcelable
{
  public static final Parcelable.Creator CREATOR = new czo();
  public String appSecret;
  public long din;
  public int isAdmin;
  public String name;
  public String netAPN;
  public String netAddress;
  public String netDetail;
  public int netType;
  public String osPlatform;
  public String osVersion;
  public int productId;
  public int productType;
  public String remark;
  public String serialNum;
  public short status;
  public String type;
  public short userStatus;
  
  public DeviceInfo() {}
  
  public DeviceInfo(Parcel paramParcel)
  {
    this.osPlatform = paramParcel.readString();
    this.osVersion = paramParcel.readString();
    this.netType = paramParcel.readInt();
    this.netDetail = paramParcel.readString();
    this.netAddress = paramParcel.readString();
    this.netAPN = paramParcel.readString();
    this.name = paramParcel.readString();
    this.remark = paramParcel.readString();
    this.type = paramParcel.readString();
    this.serialNum = paramParcel.readString();
    this.productId = paramParcel.readInt();
    this.appSecret = paramParcel.readString();
    this.din = paramParcel.readLong();
    this.isAdmin = paramParcel.readInt();
    this.status = ((short)paramParcel.readInt());
    this.userStatus = ((short)paramParcel.readInt());
    this.productType = paramParcel.readInt();
  }
  
  public int describeContents()
  {
    return 0;
  }
  
  public String getDisplayName()
  {
    if (!TextUtils.isEmpty(this.remark)) {
      return this.remark;
    }
    return this.name;
  }
  
  public void init(String paramString1, String paramString2, int paramInt1, String paramString3, String paramString4, String paramString5, String paramString6, String paramString7, String paramString8, String paramString9, int paramInt2, String paramString10, long paramLong, int paramInt3, short paramShort1, short paramShort2, int paramInt4)
  {
    this.osPlatform = paramString1;
    this.osVersion = paramString2;
    this.netType = paramInt1;
    this.netDetail = paramString3;
    this.netAddress = paramString4;
    this.netAPN = paramString5;
    this.name = paramString6;
    this.remark = paramString7;
    this.type = paramString8;
    this.serialNum = paramString9;
    this.productId = paramInt2;
    this.appSecret = paramString10;
    this.din = paramLong;
    this.isAdmin = paramInt3;
    this.status = paramShort1;
    this.userStatus = paramShort2;
    this.productType = paramInt4;
  }
  
  public void writeToParcel(Parcel paramParcel, int paramInt)
  {
    paramParcel.writeString(this.osPlatform);
    paramParcel.writeString(this.osVersion);
    paramParcel.writeInt(this.netType);
    paramParcel.writeString(this.netDetail);
    paramParcel.writeString(this.netAddress);
    paramParcel.writeString(this.netAPN);
    paramParcel.writeString(this.name);
    paramParcel.writeString(this.remark);
    paramParcel.writeString(this.type);
    paramParcel.writeString(this.serialNum);
    paramParcel.writeInt(this.productId);
    paramParcel.writeString(this.appSecret);
    paramParcel.writeLong(this.din);
    paramParcel.writeInt(this.isAdmin);
    paramParcel.writeInt(this.status);
    paramParcel.writeInt(this.userStatus);
    paramParcel.writeInt(this.productType);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.minihd.qq\assets\exlibs.1.jar\classes.jar
 * Qualified Name:     com.tencent.device.datadef.DeviceInfo
 * JD-Core Version:    0.7.0.1
 */