package com.tencent.mm.plugin.appbrand.config;

import android.os.Parcel;
import android.os.Parcelable;
import android.os.Parcelable.Creator;
import com.tencent.matrix.trace.core.AppMethodBeat;

public class GetOnLineInfoInfoResult
  implements Parcelable
{
  public static final Parcelable.Creator<GetOnLineInfoInfoResult> CREATOR;
  public int ioG;
  public int ioL;
  public boolean kRc;
  
  static
  {
    AppMethodBeat.i(224403);
    CREATOR = new Parcelable.Creator() {};
    AppMethodBeat.o(224403);
  }
  
  public GetOnLineInfoInfoResult()
  {
    this.ioG = -1;
    this.ioL = 0;
    this.kRc = false;
  }
  
  protected GetOnLineInfoInfoResult(Parcel paramParcel)
  {
    AppMethodBeat.i(224402);
    this.ioG = -1;
    this.ioL = 0;
    this.kRc = false;
    this.ioG = paramParcel.readInt();
    this.ioL = paramParcel.readInt();
    if (paramParcel.readByte() != 0) {
      bool = true;
    }
    this.kRc = bool;
    AppMethodBeat.o(224402);
  }
  
  public int describeContents()
  {
    return 0;
  }
  
  public void writeToParcel(Parcel paramParcel, int paramInt)
  {
    AppMethodBeat.i(224401);
    paramParcel.writeInt(this.ioG);
    paramParcel.writeInt(this.ioL);
    if (this.kRc) {}
    for (byte b = 1;; b = 0)
    {
      paramParcel.writeByte(b);
      AppMethodBeat.o(224401);
      return;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes8.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.config.GetOnLineInfoInfoResult
 * JD-Core Version:    0.7.0.1
 */