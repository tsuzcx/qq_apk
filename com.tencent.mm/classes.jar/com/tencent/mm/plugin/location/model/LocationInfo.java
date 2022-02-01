package com.tencent.mm.plugin.location.model;

import android.os.Parcel;
import android.os.Parcelable;
import android.os.Parcelable.Creator;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.location.ui.d;
import com.tencent.mm.sdk.platformtools.Util;

public class LocationInfo
  implements Parcelable
{
  public static final Parcelable.Creator<LocationInfo> CREATOR;
  public String dWi;
  public int yFA;
  public String yFB;
  public String yFt;
  public double yFu;
  public double yFv;
  public int yFw;
  public String yFx;
  public String yFy;
  String yFz;
  
  static
  {
    AppMethodBeat.i(55677);
    CREATOR = new Parcelable.Creator() {};
    AppMethodBeat.o(55677);
  }
  
  public LocationInfo()
  {
    this.yFt = "";
    this.yFu = -85.0D;
    this.yFv = -1000.0D;
    this.yFx = "";
    this.yFy = "zh-cn";
    this.yFz = "";
    this.yFA = 0;
  }
  
  public LocationInfo(byte paramByte)
  {
    AppMethodBeat.i(55673);
    this.yFt = "";
    this.yFu = -85.0D;
    this.yFv = -1000.0D;
    this.yFx = "";
    this.yFy = "zh-cn";
    this.yFz = "";
    this.yFA = 0;
    this.yFt = (toString() + " " + System.nanoTime());
    this.yFw = d.ede();
    AppMethodBeat.o(55673);
  }
  
  public int describeContents()
  {
    return 0;
  }
  
  public final boolean ecH()
  {
    return (this.yFu != -85.0D) && (this.yFv != -1000.0D);
  }
  
  public final boolean ecI()
  {
    AppMethodBeat.i(55675);
    if ((Util.isNullOrNil(this.yFx)) && (Util.isNullOrNil(this.dWi)))
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
    String str = this.yFu + " " + this.yFv + " " + this.yFx + " " + this.dWi + "  " + this.yFt;
    AppMethodBeat.o(55676);
    return str;
  }
  
  public void writeToParcel(Parcel paramParcel, int paramInt)
  {
    AppMethodBeat.i(55674);
    paramParcel.writeString(this.yFt);
    paramParcel.writeDouble(this.yFu);
    paramParcel.writeDouble(this.yFv);
    paramParcel.writeInt(this.yFw);
    paramParcel.writeString(this.yFx);
    paramParcel.writeString(this.yFy);
    paramParcel.writeString(this.dWi);
    paramParcel.writeString(this.yFz);
    paramParcel.writeInt(this.yFA);
    paramParcel.writeString(this.yFB);
    AppMethodBeat.o(55674);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.plugin.location.model.LocationInfo
 * JD-Core Version:    0.7.0.1
 */