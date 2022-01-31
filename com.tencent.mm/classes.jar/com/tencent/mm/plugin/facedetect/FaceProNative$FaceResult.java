package com.tencent.mm.plugin.facedetect;

import android.os.Parcel;
import android.os.Parcelable;
import android.os.Parcelable.Creator;

public class FaceProNative$FaceResult
  implements Parcelable
{
  public static final Parcelable.Creator<FaceResult> CREATOR = new FaceProNative.FaceResult.1();
  public byte[] data;
  public int result;
  public byte[] sidedata;
  
  public FaceProNative$FaceResult() {}
  
  protected FaceProNative$FaceResult(Parcel paramParcel)
  {
    this.result = paramParcel.readInt();
    this.data = paramParcel.createByteArray();
    this.sidedata = paramParcel.createByteArray();
  }
  
  public int describeContents()
  {
    return 0;
  }
  
  public String toString()
  {
    int j = 0;
    StringBuilder localStringBuilder = new StringBuilder("FaceResult{result=").append(this.result).append(", sidedataLen=");
    if (this.sidedata == null)
    {
      i = 0;
      localStringBuilder = localStringBuilder.append(i).append(", dataLen=");
      if (this.data != null) {
        break label76;
      }
    }
    label76:
    for (int i = j;; i = this.data.length)
    {
      return i + '}';
      i = this.sidedata.length;
      break;
    }
  }
  
  public void writeToParcel(Parcel paramParcel, int paramInt)
  {
    paramParcel.writeInt(this.result);
    paramParcel.writeByteArray(this.data);
    paramParcel.writeByteArray(this.sidedata);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes8.jar
 * Qualified Name:     com.tencent.mm.plugin.facedetect.FaceProNative.FaceResult
 * JD-Core Version:    0.7.0.1
 */