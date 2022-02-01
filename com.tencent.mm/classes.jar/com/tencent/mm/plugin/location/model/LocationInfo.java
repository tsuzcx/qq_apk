package com.tencent.mm.plugin.location.model;

import android.os.Parcel;
import android.os.Parcelable;
import android.os.Parcelable.Creator;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.location.ui.d;
import com.tencent.mm.sdk.platformtools.bu;

public class LocationInfo
  implements Parcelable
{
  public static final Parcelable.Creator<LocationInfo> CREATOR;
  public String dEv;
  public String vlB;
  public double vlC;
  public double vlD;
  public int vlE;
  public String vlF;
  public String vlG;
  String vlH;
  public int vlI;
  public String vlJ;
  
  static
  {
    AppMethodBeat.i(55677);
    CREATOR = new Parcelable.Creator() {};
    AppMethodBeat.o(55677);
  }
  
  public LocationInfo()
  {
    this.vlB = "";
    this.vlC = -85.0D;
    this.vlD = -1000.0D;
    this.vlF = "";
    this.vlG = "zh-cn";
    this.vlH = "";
    this.vlI = 0;
  }
  
  public LocationInfo(byte paramByte)
  {
    AppMethodBeat.i(55673);
    this.vlB = "";
    this.vlC = -85.0D;
    this.vlD = -1000.0D;
    this.vlF = "";
    this.vlG = "zh-cn";
    this.vlH = "";
    this.vlI = 0;
    this.vlB = (toString() + " " + System.nanoTime());
    this.vlE = d.djt();
    AppMethodBeat.o(55673);
  }
  
  public int describeContents()
  {
    return 0;
  }
  
  public final boolean diW()
  {
    return (this.vlC != -85.0D) && (this.vlD != -1000.0D);
  }
  
  public final boolean diX()
  {
    AppMethodBeat.i(55675);
    if ((bu.isNullOrNil(this.vlF)) && (bu.isNullOrNil(this.dEv)))
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
    String str = this.vlC + " " + this.vlD + " " + this.vlF + " " + this.dEv + "  " + this.vlB;
    AppMethodBeat.o(55676);
    return str;
  }
  
  public void writeToParcel(Parcel paramParcel, int paramInt)
  {
    AppMethodBeat.i(55674);
    paramParcel.writeString(this.vlB);
    paramParcel.writeDouble(this.vlC);
    paramParcel.writeDouble(this.vlD);
    paramParcel.writeInt(this.vlE);
    paramParcel.writeString(this.vlF);
    paramParcel.writeString(this.vlG);
    paramParcel.writeString(this.dEv);
    paramParcel.writeString(this.vlH);
    paramParcel.writeInt(this.vlI);
    paramParcel.writeString(this.vlJ);
    AppMethodBeat.o(55674);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.plugin.location.model.LocationInfo
 * JD-Core Version:    0.7.0.1
 */