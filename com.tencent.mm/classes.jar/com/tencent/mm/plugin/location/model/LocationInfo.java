package com.tencent.mm.plugin.location.model;

import android.os.Parcel;
import android.os.Parcelable;
import android.os.Parcelable.Creator;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.location.ui.d;
import com.tencent.mm.sdk.platformtools.bo;

public class LocationInfo
  implements Parcelable
{
  public static final Parcelable.Creator<LocationInfo> CREATOR;
  public String cDl;
  public String nZU;
  public double nZV;
  public double nZW;
  public int nZX;
  public String nZY;
  public String nZZ;
  String oaa;
  public int oab;
  public String oac;
  
  static
  {
    AppMethodBeat.i(113298);
    CREATOR = new LocationInfo.1();
    AppMethodBeat.o(113298);
  }
  
  public LocationInfo()
  {
    this.nZU = "";
    this.nZV = -85.0D;
    this.nZW = -1000.0D;
    this.nZY = "";
    this.nZZ = "zh-cn";
    this.oaa = "";
    this.oab = 0;
  }
  
  public LocationInfo(byte paramByte)
  {
    AppMethodBeat.i(113294);
    this.nZU = "";
    this.nZV = -85.0D;
    this.nZW = -1000.0D;
    this.nZY = "";
    this.nZZ = "zh-cn";
    this.oaa = "";
    this.oab = 0;
    this.nZU = (toString() + " " + System.nanoTime());
    this.nZX = d.bLF();
    AppMethodBeat.o(113294);
  }
  
  public final boolean bLh()
  {
    return (this.nZV != -85.0D) && (this.nZW != -1000.0D);
  }
  
  public final boolean bLi()
  {
    AppMethodBeat.i(113296);
    if ((bo.isNullOrNil(this.nZY)) && (bo.isNullOrNil(this.cDl)))
    {
      AppMethodBeat.o(113296);
      return false;
    }
    AppMethodBeat.o(113296);
    return true;
  }
  
  public int describeContents()
  {
    return 0;
  }
  
  public String toString()
  {
    AppMethodBeat.i(113297);
    String str = this.nZV + " " + this.nZW + " " + this.nZY + " " + this.cDl + "  " + this.nZU;
    AppMethodBeat.o(113297);
    return str;
  }
  
  public void writeToParcel(Parcel paramParcel, int paramInt)
  {
    AppMethodBeat.i(113295);
    paramParcel.writeString(this.nZU);
    paramParcel.writeDouble(this.nZV);
    paramParcel.writeDouble(this.nZW);
    paramParcel.writeInt(this.nZX);
    paramParcel.writeString(this.nZY);
    paramParcel.writeString(this.nZZ);
    paramParcel.writeString(this.cDl);
    paramParcel.writeString(this.oaa);
    paramParcel.writeInt(this.oab);
    paramParcel.writeString(this.oac);
    AppMethodBeat.o(113295);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.plugin.location.model.LocationInfo
 * JD-Core Version:    0.7.0.1
 */