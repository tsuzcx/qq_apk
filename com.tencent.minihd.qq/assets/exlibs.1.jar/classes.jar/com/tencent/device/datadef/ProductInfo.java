package com.tencent.device.datadef;

import android.os.Parcel;
import android.os.Parcelable;
import android.os.Parcelable.Creator;
import czp;

public class ProductInfo
  implements Parcelable
{
  public static final Parcelable.Creator CREATOR = new czp();
  public static final int SupportFuncType_Pic = 1;
  public static final int SupportFuncType_Video = 2;
  public static final int SupportMainType_All = 7;
  public static final int SupportMainType_Audio = 2;
  public static final int SupportMainType_Func = 4;
  public static final int SupportMainType_Text = 1;
  public int bindType;
  public String deviceName;
  public int deviceType;
  public int productId;
  public int supportFuncMsgType;
  public int supportMainMsgType;
  
  public ProductInfo() {}
  
  public ProductInfo(Parcel paramParcel)
  {
    this.productId = paramParcel.readInt();
    this.deviceType = paramParcel.readInt();
    this.bindType = paramParcel.readInt();
    this.supportMainMsgType = paramParcel.readInt();
    this.supportFuncMsgType = paramParcel.readInt();
    this.deviceName = paramParcel.readString();
  }
  
  public int describeContents()
  {
    return 0;
  }
  
  public void init(int paramInt1, int paramInt2, int paramInt3, int paramInt4, int paramInt5)
  {
    this.productId = paramInt1;
    this.deviceType = paramInt2;
    this.bindType = paramInt3;
    this.supportMainMsgType = paramInt4;
    this.supportFuncMsgType = paramInt5;
  }
  
  public boolean isSupportFuncMsgType(int paramInt)
  {
    return (this.supportFuncMsgType & paramInt) == paramInt;
  }
  
  public boolean isSupportMainMsgType(int paramInt)
  {
    return (this.supportMainMsgType & paramInt) == paramInt;
  }
  
  public void writeToParcel(Parcel paramParcel, int paramInt)
  {
    paramParcel.writeInt(this.productId);
    paramParcel.writeInt(this.deviceType);
    paramParcel.writeInt(this.bindType);
    paramParcel.writeInt(this.supportMainMsgType);
    paramParcel.writeInt(this.supportFuncMsgType);
    paramParcel.writeString(this.deviceName);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.minihd.qq\assets\exlibs.1.jar\classes.jar
 * Qualified Name:     com.tencent.device.datadef.ProductInfo
 * JD-Core Version:    0.7.0.1
 */