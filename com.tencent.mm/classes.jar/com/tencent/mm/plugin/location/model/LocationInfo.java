package com.tencent.mm.plugin.location.model;

import android.os.Parcel;
import android.os.Parcelable;
import android.os.Parcelable.Creator;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.location.ui.d;
import com.tencent.mm.sdk.platformtools.bs;

public class LocationInfo
  implements Parcelable
{
  public static final Parcelable.Creator<LocationInfo> CREATOR;
  public String dry;
  public String tWH;
  public double tWI;
  public double tWJ;
  public int tWK;
  public String tWL;
  public String tWM;
  String tWN;
  public int tWO;
  public String tWP;
  
  static
  {
    AppMethodBeat.i(55677);
    CREATOR = new Parcelable.Creator() {};
    AppMethodBeat.o(55677);
  }
  
  public LocationInfo()
  {
    this.tWH = "";
    this.tWI = -85.0D;
    this.tWJ = -1000.0D;
    this.tWL = "";
    this.tWM = "zh-cn";
    this.tWN = "";
    this.tWO = 0;
  }
  
  public LocationInfo(byte paramByte)
  {
    AppMethodBeat.i(55673);
    this.tWH = "";
    this.tWI = -85.0D;
    this.tWJ = -1000.0D;
    this.tWL = "";
    this.tWM = "zh-cn";
    this.tWN = "";
    this.tWO = 0;
    this.tWH = (toString() + " " + System.nanoTime());
    this.tWK = d.cXi();
    AppMethodBeat.o(55673);
  }
  
  public final boolean cWL()
  {
    return (this.tWI != -85.0D) && (this.tWJ != -1000.0D);
  }
  
  public final boolean cWM()
  {
    AppMethodBeat.i(55675);
    if ((bs.isNullOrNil(this.tWL)) && (bs.isNullOrNil(this.dry)))
    {
      AppMethodBeat.o(55675);
      return false;
    }
    AppMethodBeat.o(55675);
    return true;
  }
  
  public int describeContents()
  {
    return 0;
  }
  
  public String toString()
  {
    AppMethodBeat.i(55676);
    String str = this.tWI + " " + this.tWJ + " " + this.tWL + " " + this.dry + "  " + this.tWH;
    AppMethodBeat.o(55676);
    return str;
  }
  
  public void writeToParcel(Parcel paramParcel, int paramInt)
  {
    AppMethodBeat.i(55674);
    paramParcel.writeString(this.tWH);
    paramParcel.writeDouble(this.tWI);
    paramParcel.writeDouble(this.tWJ);
    paramParcel.writeInt(this.tWK);
    paramParcel.writeString(this.tWL);
    paramParcel.writeString(this.tWM);
    paramParcel.writeString(this.dry);
    paramParcel.writeString(this.tWN);
    paramParcel.writeInt(this.tWO);
    paramParcel.writeString(this.tWP);
    AppMethodBeat.o(55674);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.plugin.location.model.LocationInfo
 * JD-Core Version:    0.7.0.1
 */