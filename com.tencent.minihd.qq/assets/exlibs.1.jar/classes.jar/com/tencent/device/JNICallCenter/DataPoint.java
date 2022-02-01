package com.tencent.device.JNICallCenter;

import android.os.Parcel;
import android.os.Parcelable;
import android.os.Parcelable.Creator;
import cww;

public class DataPoint
  implements Parcelable
{
  public static final Parcelable.Creator CREATOR = new cww();
  public static final int PID_AudioMsg = 10003;
  public static final int PID_RawTextMsg = 10007;
  public static final int PID_SingleStructMsg = 10004;
  public static final int PID_SwitchDisconnect = 10102;
  public static final int UINTYPE_DIN = 4;
  public static final int UINTYPE_MOBILE = 6;
  public static final int UINTYPE_QQ = 1;
  public static final int UINTYPE_TINYID = 5;
  public String mApiName;
  public long mDin;
  public String mErrMsg;
  public int mProperityId;
  public int mRetCode;
  public int mSendUinType;
  public String mSeq;
  public String mValue;
  public String mValueType;
  
  public DataPoint()
  {
    this.mSendUinType = 0;
    this.mProperityId = 0;
    this.mRetCode = 0;
  }
  
  public DataPoint(long paramLong, int paramInt1, String paramString1, int paramInt2, String paramString2, String paramString3, int paramInt3, String paramString4)
  {
    this.mDin = paramLong;
    this.mSendUinType = paramInt1;
    this.mApiName = paramString1;
    this.mProperityId = paramInt2;
    this.mValueType = paramString2;
    this.mValue = paramString3;
    this.mRetCode = paramInt3;
    this.mErrMsg = paramString4;
  }
  
  public DataPoint(Parcel paramParcel)
  {
    this.mDin = paramParcel.readLong();
    this.mSendUinType = paramParcel.readInt();
    this.mApiName = paramParcel.readString();
    this.mProperityId = paramParcel.readInt();
    this.mValueType = paramParcel.readString();
    this.mValue = paramParcel.readString();
    this.mRetCode = paramParcel.readInt();
    this.mErrMsg = paramParcel.readString();
    this.mSeq = paramParcel.readString();
  }
  
  public DataPoint(String paramString1, int paramInt, String paramString2, String paramString3)
  {
    this.mApiName = paramString1;
    this.mProperityId = paramInt;
    this.mValueType = paramString2;
    this.mValue = paramString3;
    this.mRetCode = 0;
    this.mDin = 0L;
  }
  
  public int describeContents()
  {
    return 0;
  }
  
  public void init(long paramLong, int paramInt1, String paramString1, int paramInt2, String paramString2, String paramString3, int paramInt3, String paramString4)
  {
    this.mDin = paramLong;
    this.mSendUinType = paramInt1;
    this.mApiName = paramString1;
    this.mProperityId = paramInt2;
    this.mValueType = paramString2;
    this.mValue = paramString3;
    this.mRetCode = paramInt3;
    this.mErrMsg = paramString4;
  }
  
  public void initWithSeq(long paramLong, int paramInt1, String paramString1, int paramInt2, String paramString2, String paramString3, int paramInt3, String paramString4, String paramString5)
  {
    this.mDin = paramLong;
    this.mSendUinType = paramInt1;
    this.mApiName = paramString1;
    this.mProperityId = paramInt2;
    this.mValueType = paramString2;
    this.mValue = paramString3;
    this.mRetCode = paramInt3;
    this.mErrMsg = paramString4;
    this.mSeq = paramString5;
  }
  
  public String toString()
  {
    return "[datapoint din=" + this.mDin + " id=" + this.mProperityId + " value=" + this.mValue;
  }
  
  public void writeToParcel(Parcel paramParcel, int paramInt)
  {
    paramParcel.writeLong(this.mDin);
    paramParcel.writeInt(this.mSendUinType);
    paramParcel.writeString(this.mApiName);
    paramParcel.writeInt(this.mProperityId);
    paramParcel.writeString(this.mValueType);
    paramParcel.writeString(this.mValue);
    paramParcel.writeInt(this.mRetCode);
    paramParcel.writeString(this.mErrMsg);
    paramParcel.writeString(this.mSeq);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.minihd.qq\assets\exlibs.1.jar\classes.jar
 * Qualified Name:     com.tencent.device.JNICallCenter.DataPoint
 * JD-Core Version:    0.7.0.1
 */