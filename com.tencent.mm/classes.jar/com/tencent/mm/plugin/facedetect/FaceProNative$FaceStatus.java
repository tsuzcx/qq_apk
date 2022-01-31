package com.tencent.mm.plugin.facedetect;

import android.graphics.Rect;
import android.os.Parcel;
import android.os.Parcelable;
import android.os.Parcelable.Creator;
import com.tencent.matrix.trace.core.AppMethodBeat;

public class FaceProNative$FaceStatus
  implements Parcelable
{
  public static final Parcelable.Creator<FaceStatus> CREATOR;
  public Rect facerect;
  public float pitch;
  public int result;
  public float roll;
  public float[] xys;
  public float yaw;
  
  static
  {
    AppMethodBeat.i(43);
    CREATOR = new FaceProNative.FaceStatus.1();
    AppMethodBeat.o(43);
  }
  
  public FaceProNative$FaceStatus() {}
  
  protected FaceProNative$FaceStatus(Parcel paramParcel)
  {
    AppMethodBeat.i(40);
    this.result = paramParcel.readInt();
    this.facerect = ((Rect)paramParcel.readParcelable(Rect.class.getClassLoader()));
    this.xys = paramParcel.createFloatArray();
    this.pitch = paramParcel.readFloat();
    this.yaw = paramParcel.readFloat();
    this.roll = paramParcel.readFloat();
    AppMethodBeat.o(40);
  }
  
  public int describeContents()
  {
    return 0;
  }
  
  public String toString()
  {
    AppMethodBeat.i(42);
    String str = "FaceStatus{result=" + this.result + ", facerect=" + this.facerect + ", pitch=" + this.pitch + ", yaw=" + this.yaw + ", roll=" + this.roll + '}';
    AppMethodBeat.o(42);
    return str;
  }
  
  public void writeToParcel(Parcel paramParcel, int paramInt)
  {
    AppMethodBeat.i(41);
    paramParcel.writeInt(this.result);
    paramParcel.writeParcelable(this.facerect, paramInt);
    paramParcel.writeFloatArray(this.xys);
    paramParcel.writeFloat(this.pitch);
    paramParcel.writeFloat(this.yaw);
    paramParcel.writeFloat(this.roll);
    AppMethodBeat.o(41);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes8.jar
 * Qualified Name:     com.tencent.mm.plugin.facedetect.FaceProNative.FaceStatus
 * JD-Core Version:    0.7.0.1
 */