package com.tencent.mm.plugin.facedetect.model;

import android.os.Parcel;
import android.os.Parcelable;
import android.os.Parcelable.Creator;
import com.tencent.mm.plugin.facedetect.FaceProNative.FaceStatus;

public class FaceCharacteristicsResult
  implements Parcelable
{
  public static final Parcelable.Creator<FaceCharacteristicsResult> CREATOR = new FaceCharacteristicsResult.1();
  public String aox;
  public int errCode;
  public FaceProNative.FaceStatus jNG;
  
  public FaceCharacteristicsResult() {}
  
  protected FaceCharacteristicsResult(Parcel paramParcel)
  {
    this.errCode = paramParcel.readInt();
    this.aox = paramParcel.readString();
  }
  
  public static boolean qH(int paramInt)
  {
    return (paramInt >= 10) && (paramInt < 100);
  }
  
  public static boolean qI(int paramInt)
  {
    return (paramInt > 0) && (paramInt < 10);
  }
  
  public static boolean qJ(int paramInt)
  {
    return paramInt <= 0;
  }
  
  public final void af(int paramInt, String paramString)
  {
    this.errCode = paramInt;
    this.aox = paramString;
  }
  
  public int describeContents()
  {
    return 0;
  }
  
  public String toString()
  {
    return "FaceCharacteristicsResult{mStatus=" + this.jNG + ", errCode=" + this.errCode + ", errMsg='" + this.aox + '\'' + '}';
  }
  
  public void writeToParcel(Parcel paramParcel, int paramInt)
  {
    paramParcel.writeParcelable(this.jNG, paramInt);
    paramParcel.writeInt(this.errCode);
    paramParcel.writeString(this.aox);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.plugin.facedetect.model.FaceCharacteristicsResult
 * JD-Core Version:    0.7.0.1
 */