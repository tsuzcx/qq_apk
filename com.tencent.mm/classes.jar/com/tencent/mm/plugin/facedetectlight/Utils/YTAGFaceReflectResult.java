package com.tencent.mm.plugin.facedetectlight.Utils;

import android.os.Parcel;
import android.os.Parcelable;
import android.os.Parcelable.Creator;

public class YTAGFaceReflectResult
  implements Parcelable
{
  public static final Parcelable.Creator<YTAGFaceReflectResult> CREATOR = new YTAGFaceReflectResult.1();
  public byte[] data;
  public int result;
  public byte[] sidedata;
  
  public YTAGFaceReflectResult(int paramInt)
  {
    this.result = paramInt;
    this.data = null;
    this.sidedata = null;
  }
  
  protected YTAGFaceReflectResult(Parcel paramParcel)
  {
    this.result = paramParcel.readInt();
    this.data = paramParcel.createByteArray();
    this.sidedata = paramParcel.createByteArray();
  }
  
  public int describeContents()
  {
    return 0;
  }
  
  public void setData(byte[] paramArrayOfByte)
  {
    this.data = paramArrayOfByte;
  }
  
  public void setResult(int paramInt)
  {
    this.result = paramInt;
  }
  
  public void setSidedata(byte[] paramArrayOfByte)
  {
    this.sidedata = paramArrayOfByte;
  }
  
  public void writeToParcel(Parcel paramParcel, int paramInt)
  {
    paramParcel.writeInt(this.result);
    paramParcel.writeByteArray(this.data);
    paramParcel.writeByteArray(this.sidedata);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.plugin.facedetectlight.Utils.YTAGFaceReflectResult
 * JD-Core Version:    0.7.0.1
 */