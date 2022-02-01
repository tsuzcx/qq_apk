package com.tencent.mm.plugin.appbrand.config;

import android.os.Parcel;
import android.os.Parcelable;
import android.os.Parcelable.Creator;
import com.tencent.matrix.trace.core.AppMethodBeat;

public class GetOnLineInfoInfoResult
  implements Parcelable
{
  public static final Parcelable.Creator<GetOnLineInfoInfoResult> CREATOR;
  public int qvo;
  public int qvp;
  public boolean qvq;
  
  static
  {
    AppMethodBeat.i(323318);
    CREATOR = new Parcelable.Creator() {};
    AppMethodBeat.o(323318);
  }
  
  public GetOnLineInfoInfoResult()
  {
    this.qvo = -1;
    this.qvp = 0;
    this.qvq = false;
  }
  
  protected GetOnLineInfoInfoResult(Parcel paramParcel)
  {
    AppMethodBeat.i(323317);
    this.qvo = -1;
    this.qvp = 0;
    this.qvq = false;
    this.qvo = paramParcel.readInt();
    this.qvp = paramParcel.readInt();
    if (paramParcel.readByte() != 0) {
      bool = true;
    }
    this.qvq = bool;
    AppMethodBeat.o(323317);
  }
  
  public int describeContents()
  {
    return 0;
  }
  
  public String toString()
  {
    AppMethodBeat.i(323332);
    String str = "GetOnLineInfoInfoResult{iconType=" + this.qvo + ", clientVersion=" + this.qvp + ", isWXOnline=" + this.qvq + '}';
    AppMethodBeat.o(323332);
    return str;
  }
  
  public void writeToParcel(Parcel paramParcel, int paramInt)
  {
    AppMethodBeat.i(323324);
    paramParcel.writeInt(this.qvo);
    paramParcel.writeInt(this.qvp);
    if (this.qvq) {}
    for (byte b = 1;; b = 0)
    {
      paramParcel.writeByte(b);
      AppMethodBeat.o(323324);
      return;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.config.GetOnLineInfoInfoResult
 * JD-Core Version:    0.7.0.1
 */