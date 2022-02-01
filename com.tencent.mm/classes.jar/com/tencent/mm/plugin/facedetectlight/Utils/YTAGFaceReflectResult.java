package com.tencent.mm.plugin.facedetectlight.Utils;

import android.os.Parcel;
import android.os.Parcelable;
import android.os.Parcelable.Creator;
import com.tencent.matrix.trace.core.AppMethodBeat;

public class YTAGFaceReflectResult
  implements Parcelable
{
  public static final Parcelable.Creator<YTAGFaceReflectResult> CREATOR;
  public byte[] data;
  public int result;
  public byte[] sidedata;
  
  static
  {
    AppMethodBeat.i(104279);
    CREATOR = new Parcelable.Creator() {};
    AppMethodBeat.o(104279);
  }
  
  public YTAGFaceReflectResult(int paramInt)
  {
    this.result = paramInt;
    this.data = null;
    this.sidedata = null;
  }
  
  protected YTAGFaceReflectResult(Parcel paramParcel)
  {
    AppMethodBeat.i(104277);
    this.result = paramParcel.readInt();
    this.data = paramParcel.createByteArray();
    this.sidedata = paramParcel.createByteArray();
    AppMethodBeat.o(104277);
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
    AppMethodBeat.i(104278);
    paramParcel.writeInt(this.result);
    paramParcel.writeByteArray(this.data);
    paramParcel.writeByteArray(this.sidedata);
    AppMethodBeat.o(104278);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.plugin.facedetectlight.Utils.YTAGFaceReflectResult
 * JD-Core Version:    0.7.0.1
 */