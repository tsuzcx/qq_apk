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
  public FaceProNative.FaceStatus qxo;
  
  static
  {
    AppMethodBeat.i(103706);
    CREATOR = new Parcelable.Creator() {};
    AppMethodBeat.o(103706);
  }
  
  public FaceCharacteristicsResult() {}
  
  protected FaceCharacteristicsResult(Parcel paramParcel)
  {
    AppMethodBeat.i(103703);
    this.errCode = paramParcel.readInt();
    this.errMsg = paramParcel.readString();
    AppMethodBeat.o(103703);
  }
  
  public static boolean CP(int paramInt)
  {
    return (paramInt >= 10) && (paramInt < 100);
  }
  
  public static boolean CQ(int paramInt)
  {
    return (paramInt > 0) && (paramInt < 10);
  }
  
  public static boolean CR(int paramInt)
  {
    return paramInt <= 0;
  }
  
  public final void aR(int paramInt, String paramString)
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
    AppMethodBeat.i(103705);
    String str = "FaceCharacteristicsResult{mStatus=" + this.qxo + ", errCode=" + this.errCode + ", errMsg='" + this.errMsg + '\'' + '}';
    AppMethodBeat.o(103705);
    return str;
  }
  
  public void writeToParcel(Parcel paramParcel, int paramInt)
  {
    AppMethodBeat.i(103704);
    paramParcel.writeParcelable(this.qxo, paramInt);
    paramParcel.writeInt(this.errCode);
    paramParcel.writeString(this.errMsg);
    AppMethodBeat.o(103704);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.mm.plugin.facedetect.model.FaceCharacteristicsResult
 * JD-Core Version:    0.7.0.1
 */