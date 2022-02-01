package com.tencent.mm.plugin.appbrand.config;

import android.os.Parcel;
import android.os.Parcelable;
import android.os.Parcelable.Creator;
import com.tencent.matrix.trace.core.AppMethodBeat;

public class GetOnLineInfoInfoResult
  implements Parcelable
{
  public static final Parcelable.Creator<GetOnLineInfoInfoResult> CREATOR;
  public int lZJ;
  public int lZO;
  public boolean nwq;
  
  static
  {
    AppMethodBeat.i(190750);
    CREATOR = new Parcelable.Creator() {};
    AppMethodBeat.o(190750);
  }
  
  public GetOnLineInfoInfoResult()
  {
    this.lZJ = -1;
    this.lZO = 0;
    this.nwq = false;
  }
  
  protected GetOnLineInfoInfoResult(Parcel paramParcel)
  {
    AppMethodBeat.i(190747);
    this.lZJ = -1;
    this.lZO = 0;
    this.nwq = false;
    this.lZJ = paramParcel.readInt();
    this.lZO = paramParcel.readInt();
    if (paramParcel.readByte() != 0) {
      bool = true;
    }
    this.nwq = bool;
    AppMethodBeat.o(190747);
  }
  
  public int describeContents()
  {
    return 0;
  }
  
  public String toString()
  {
    AppMethodBeat.i(190749);
    String str = "GetOnLineInfoInfoResult{iconType=" + this.lZJ + ", clientVersion=" + this.lZO + ", isWXOnline=" + this.nwq + '}';
    AppMethodBeat.o(190749);
    return str;
  }
  
  public void writeToParcel(Parcel paramParcel, int paramInt)
  {
    AppMethodBeat.i(190744);
    paramParcel.writeInt(this.lZJ);
    paramParcel.writeInt(this.lZO);
    if (this.nwq) {}
    for (byte b = 1;; b = 0)
    {
      paramParcel.writeByte(b);
      AppMethodBeat.o(190744);
      return;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.config.GetOnLineInfoInfoResult
 * JD-Core Version:    0.7.0.1
 */