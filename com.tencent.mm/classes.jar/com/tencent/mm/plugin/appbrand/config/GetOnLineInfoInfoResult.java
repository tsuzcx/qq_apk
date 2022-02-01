package com.tencent.mm.plugin.appbrand.config;

import android.os.Parcel;
import android.os.Parcelable;
import android.os.Parcelable.Creator;
import com.tencent.matrix.trace.core.AppMethodBeat;

public class GetOnLineInfoInfoResult
  implements Parcelable
{
  public static final Parcelable.Creator<GetOnLineInfoInfoResult> CREATOR;
  public int jjN;
  public int jjS;
  public boolean kDf;
  
  static
  {
    AppMethodBeat.i(194340);
    CREATOR = new Parcelable.Creator() {};
    AppMethodBeat.o(194340);
  }
  
  public GetOnLineInfoInfoResult()
  {
    this.jjN = -1;
    this.jjS = 0;
    this.kDf = false;
  }
  
  protected GetOnLineInfoInfoResult(Parcel paramParcel)
  {
    AppMethodBeat.i(194338);
    this.jjN = -1;
    this.jjS = 0;
    this.kDf = false;
    this.jjN = paramParcel.readInt();
    this.jjS = paramParcel.readInt();
    if (paramParcel.readByte() != 0) {
      bool = true;
    }
    this.kDf = bool;
    AppMethodBeat.o(194338);
  }
  
  public int describeContents()
  {
    return 0;
  }
  
  public String toString()
  {
    AppMethodBeat.i(194339);
    String str = "GetOnLineInfoInfoResult{iconType=" + this.jjN + ", clientVersion=" + this.jjS + ", isWXOnline=" + this.kDf + '}';
    AppMethodBeat.o(194339);
    return str;
  }
  
  public void writeToParcel(Parcel paramParcel, int paramInt)
  {
    AppMethodBeat.i(194337);
    paramParcel.writeInt(this.jjN);
    paramParcel.writeInt(this.jjS);
    if (this.kDf) {}
    for (byte b = 1;; b = 0)
    {
      paramParcel.writeByte(b);
      AppMethodBeat.o(194337);
      return;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.config.GetOnLineInfoInfoResult
 * JD-Core Version:    0.7.0.1
 */