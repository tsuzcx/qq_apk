package com.tencent.av.service;

import android.os.Parcel;
import android.os.Parcelable;
import android.os.Parcelable.Creator;

public class AVPbInfo
  implements Parcelable
{
  public static final Parcelable.Creator<AVPbInfo> CREATOR = new Parcelable.Creator()
  {
    public AVPbInfo createFromParcel(Parcel paramAnonymousParcel)
    {
      return new AVPbInfo(paramAnonymousParcel);
    }
    
    public AVPbInfo[] newArray(int paramAnonymousInt)
    {
      return new AVPbInfo[paramAnonymousInt];
    }
  };
  public String bindId;
  public int bindIdType;
  public String phoneNum;
  
  public AVPbInfo() {}
  
  public AVPbInfo(Parcel paramParcel)
  {
    this.bindId = paramParcel.readString();
    this.bindIdType = paramParcel.readInt();
    this.phoneNum = paramParcel.readString();
  }
  
  public int describeContents()
  {
    return 0;
  }
  
  public void writeToParcel(Parcel paramParcel, int paramInt)
  {
    paramParcel.writeString(this.bindId);
    paramParcel.writeInt(this.bindIdType);
    paramParcel.writeString(this.phoneNum);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.minihd.qq\assets\exlibs.2.jar\classes.jar
 * Qualified Name:     com.tencent.av.service.AVPbInfo
 * JD-Core Version:    0.7.0.1
 */