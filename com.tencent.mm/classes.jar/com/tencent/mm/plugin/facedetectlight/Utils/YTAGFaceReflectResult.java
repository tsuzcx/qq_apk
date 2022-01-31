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
    AppMethodBeat.i(757);
    CREATOR = new YTAGFaceReflectResult.1();
    AppMethodBeat.o(757);
  }
  
  public YTAGFaceReflectResult(int paramInt)
  {
    this.result = paramInt;
    this.data = null;
    this.sidedata = null;
  }
  
  protected YTAGFaceReflectResult(Parcel paramParcel)
  {
    AppMethodBeat.i(755);
    this.result = paramParcel.readInt();
    this.data = paramParcel.createByteArray();
    this.sidedata = paramParcel.createByteArray();
    AppMethodBeat.o(755);
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
    AppMethodBeat.i(756);
    paramParcel.writeInt(this.result);
    paramParcel.writeByteArray(this.data);
    paramParcel.writeByteArray(this.sidedata);
    AppMethodBeat.o(756);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.plugin.facedetectlight.Utils.YTAGFaceReflectResult
 * JD-Core Version:    0.7.0.1
 */