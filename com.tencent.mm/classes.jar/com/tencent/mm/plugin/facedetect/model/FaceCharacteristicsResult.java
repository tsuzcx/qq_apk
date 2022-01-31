package com.tencent.mm.plugin.facedetect.model;

import android.os.Parcel;
import android.os.Parcelable;
import android.os.Parcelable.Creator;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.facedetect.FaceProNative.FaceStatus;

public class FaceCharacteristicsResult
  implements Parcelable
{
  public static final Parcelable.Creator<FaceCharacteristicsResult> CREATOR;
  public int errCode;
  public String errMsg;
  public FaceProNative.FaceStatus mhS;
  
  static
  {
    AppMethodBeat.i(181);
    CREATOR = new FaceCharacteristicsResult.1();
    AppMethodBeat.o(181);
  }
  
  public FaceCharacteristicsResult() {}
  
  protected FaceCharacteristicsResult(Parcel paramParcel)
  {
    AppMethodBeat.i(178);
    this.errCode = paramParcel.readInt();
    this.errMsg = paramParcel.readString();
    AppMethodBeat.o(178);
  }
  
  public static boolean vC(int paramInt)
  {
    return (paramInt >= 10) && (paramInt < 100);
  }
  
  public static boolean vD(int paramInt)
  {
    return (paramInt > 0) && (paramInt < 10);
  }
  
  public static boolean vE(int paramInt)
  {
    return paramInt <= 0;
  }
  
  public final void ay(int paramInt, String paramString)
  {
    this.errCode = paramInt;
    this.errMsg = paramString;
  }
  
  public int describeContents()
  {
    return 0;
  }
  
  public String toString()
  {
    AppMethodBeat.i(180);
    String str = "FaceCharacteristicsResult{mStatus=" + this.mhS + ", errCode=" + this.errCode + ", errMsg='" + this.errMsg + '\'' + '}';
    AppMethodBeat.o(180);
    return str;
  }
  
  public void writeToParcel(Parcel paramParcel, int paramInt)
  {
    AppMethodBeat.i(179);
    paramParcel.writeParcelable(this.mhS, paramInt);
    paramParcel.writeInt(this.errCode);
    paramParcel.writeString(this.errMsg);
    AppMethodBeat.o(179);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.plugin.facedetect.model.FaceCharacteristicsResult
 * JD-Core Version:    0.7.0.1
 */