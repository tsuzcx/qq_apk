package com.tencent.mm.plugin.facedetect;

import android.graphics.Rect;
import android.os.Parcel;
import android.os.Parcelable;
import android.os.Parcelable.Creator;

public class FaceProNative$FaceStatus
  implements Parcelable
{
  public static final Parcelable.Creator<FaceStatus> CREATOR = new FaceProNative.FaceStatus.1();
  public Rect facerect;
  public float pitch;
  public int result;
  public float roll;
  public float[] xys;
  public float yaw;
  
  public FaceProNative$FaceStatus() {}
  
  protected FaceProNative$FaceStatus(Parcel paramParcel)
  {
    this.result = paramParcel.readInt();
    this.facerect = ((Rect)paramParcel.readParcelable(Rect.class.getClassLoader()));
    this.xys = paramParcel.createFloatArray();
    this.pitch = paramParcel.readFloat();
    this.yaw = paramParcel.readFloat();
    this.roll = paramParcel.readFloat();
  }
  
  public int describeContents()
  {
    return 0;
  }
  
  public String toString()
  {
    return "FaceStatus{result=" + this.result + ", facerect=" + this.facerect + ", pitch=" + this.pitch + ", yaw=" + this.yaw + ", roll=" + this.roll + '}';
  }
  
  public void writeToParcel(Parcel paramParcel, int paramInt)
  {
    paramParcel.writeInt(this.result);
    paramParcel.writeParcelable(this.facerect, paramInt);
    paramParcel.writeFloatArray(this.xys);
    paramParcel.writeFloat(this.pitch);
    paramParcel.writeFloat(this.yaw);
    paramParcel.writeFloat(this.roll);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes9.jar
 * Qualified Name:     com.tencent.mm.plugin.facedetect.FaceProNative.FaceStatus
 * JD-Core Version:    0.7.0.1
 */