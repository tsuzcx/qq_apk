package com.tencent.mm.plugin.location.model;

import android.os.Parcel;
import android.os.Parcelable;
import android.os.Parcelable.Creator;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.location.ui.d;
import com.tencent.mm.sdk.platformtools.bt;

public class LocationInfo
  implements Parcelable
{
  public static final Parcelable.Creator<LocationInfo> CREATOR;
  public String dDq;
  public String uZq;
  public double uZr;
  public double uZs;
  public int uZt;
  public String uZu;
  public String uZv;
  String uZw;
  public int uZx;
  public String uZy;
  
  static
  {
    AppMethodBeat.i(55677);
    CREATOR = new Parcelable.Creator() {};
    AppMethodBeat.o(55677);
  }
  
  public LocationInfo()
  {
    this.uZq = "";
    this.uZr = -85.0D;
    this.uZs = -1000.0D;
    this.uZu = "";
    this.uZv = "zh-cn";
    this.uZw = "";
    this.uZx = 0;
  }
  
  public LocationInfo(byte paramByte)
  {
    AppMethodBeat.i(55673);
    this.uZq = "";
    this.uZr = -85.0D;
    this.uZs = -1000.0D;
    this.uZu = "";
    this.uZv = "zh-cn";
    this.uZw = "";
    this.uZx = 0;
    this.uZq = (toString() + " " + System.nanoTime());
    this.uZt = d.dgu();
    AppMethodBeat.o(55673);
  }
  
  public int describeContents()
  {
    return 0;
  }
  
  public final boolean dfX()
  {
    return (this.uZr != -85.0D) && (this.uZs != -1000.0D);
  }
  
  public final boolean dfY()
  {
    AppMethodBeat.i(55675);
    if ((bt.isNullOrNil(this.uZu)) && (bt.isNullOrNil(this.dDq)))
    {
      AppMethodBeat.o(55675);
      return false;
    }
    AppMethodBeat.o(55675);
    return true;
  }
  
  public String toString()
  {
    AppMethodBeat.i(55676);
    String str = this.uZr + " " + this.uZs + " " + this.uZu + " " + this.dDq + "  " + this.uZq;
    AppMethodBeat.o(55676);
    return str;
  }
  
  public void writeToParcel(Parcel paramParcel, int paramInt)
  {
    AppMethodBeat.i(55674);
    paramParcel.writeString(this.uZq);
    paramParcel.writeDouble(this.uZr);
    paramParcel.writeDouble(this.uZs);
    paramParcel.writeInt(this.uZt);
    paramParcel.writeString(this.uZu);
    paramParcel.writeString(this.uZv);
    paramParcel.writeString(this.dDq);
    paramParcel.writeString(this.uZw);
    paramParcel.writeInt(this.uZx);
    paramParcel.writeString(this.uZy);
    AppMethodBeat.o(55674);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.plugin.location.model.LocationInfo
 * JD-Core Version:    0.7.0.1
 */