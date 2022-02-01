package com.tencent.mm.plugin.facedetect;

import android.os.Parcel;
import android.os.Parcelable;
import android.os.Parcelable.Creator;
import com.tencent.matrix.trace.core.AppMethodBeat;

public class FaceProNative$FaceResult
  implements Parcelable
{
  public static final Parcelable.Creator<FaceResult> CREATOR;
  public byte[] data;
  public int result;
  public byte[] sidedata;
  
  static
  {
    AppMethodBeat.i(103555);
    CREATOR = new Parcelable.Creator()
    {
      public final FaceProNative.FaceResult createFromParcel(Parcel paramAnonymousParcel)
      {
        AppMethodBeat.i(103549);
        paramAnonymousParcel = new FaceProNative.FaceResult(paramAnonymousParcel);
        AppMethodBeat.o(103549);
        return paramAnonymousParcel;
      }
      
      public final FaceProNative.FaceResult[] newArray(int paramAnonymousInt)
      {
        return new FaceProNative.FaceResult[paramAnonymousInt];
      }
    };
    AppMethodBeat.o(103555);
  }
  
  public FaceProNative$FaceResult() {}
  
  protected FaceProNative$FaceResult(Parcel paramParcel)
  {
    AppMethodBeat.i(103552);
    this.result = paramParcel.readInt();
    this.data = paramParcel.createByteArray();
    this.sidedata = paramParcel.createByteArray();
    AppMethodBeat.o(103552);
  }
  
  public int describeContents()
  {
    return 0;
  }
  
  public String toString()
  {
    int j = 0;
    AppMethodBeat.i(103554);
    Object localObject = new StringBuilder("FaceResult{result=").append(this.result).append(", sidedataLen=");
    if (this.sidedata == null)
    {
      i = 0;
      localObject = ((StringBuilder)localObject).append(i).append(", dataLen=");
      if (this.data != null) {
        break label88;
      }
    }
    label88:
    for (int i = j;; i = this.data.length)
    {
      localObject = i + '}';
      AppMethodBeat.o(103554);
      return localObject;
      i = this.sidedata.length;
      break;
    }
  }
  
  public void writeToParcel(Parcel paramParcel, int paramInt)
  {
    AppMethodBeat.i(103553);
    paramParcel.writeInt(this.result);
    paramParcel.writeByteArray(this.data);
    paramParcel.writeByteArray(this.sidedata);
    AppMethodBeat.o(103553);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.plugin.facedetect.FaceProNative.FaceResult
 * JD-Core Version:    0.7.0.1
 */