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
  public String Ejm;
  public double Ejn;
  public double Ejo;
  public int Ejp;
  public String Ejq;
  public String Ejr;
  String Ejs;
  public int Ejt;
  public String Eju;
  public String fPN;
  
  static
  {
    AppMethodBeat.i(55677);
    CREATOR = new Parcelable.Creator() {};
    AppMethodBeat.o(55677);
  }
  
  public LocationInfo()
  {
    this.Ejm = "";
    this.Ejn = -85.0D;
    this.Ejo = -1000.0D;
    this.Ejq = "";
    this.Ejr = "zh-cn";
    this.Ejs = "";
    this.Ejt = 0;
  }
  
  public LocationInfo(byte paramByte)
  {
    AppMethodBeat.i(55673);
    this.Ejm = "";
    this.Ejn = -85.0D;
    this.Ejo = -1000.0D;
    this.Ejq = "";
    this.Ejr = "zh-cn";
    this.Ejs = "";
    this.Ejt = 0;
    this.Ejm = (toString() + " " + System.nanoTime());
    this.Ejp = d.eMx();
    AppMethodBeat.o(55673);
  }
  
  public int describeContents()
  {
    return 0;
  }
  
  public final boolean eLZ()
  {
    return (this.Ejn != -85.0D) && (this.Ejo != -1000.0D);
  }
  
  public final boolean eMa()
  {
    AppMethodBeat.i(55675);
    if ((Util.isNullOrNil(this.Ejq)) && (Util.isNullOrNil(this.fPN)))
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
    String str = this.Ejn + " " + this.Ejo + " " + this.Ejq + " " + this.fPN + "  " + this.Ejm;
    AppMethodBeat.o(55676);
    return str;
  }
  
  public void writeToParcel(Parcel paramParcel, int paramInt)
  {
    AppMethodBeat.i(55674);
    paramParcel.writeString(this.Ejm);
    paramParcel.writeDouble(this.Ejn);
    paramParcel.writeDouble(this.Ejo);
    paramParcel.writeInt(this.Ejp);
    paramParcel.writeString(this.Ejq);
    paramParcel.writeString(this.Ejr);
    paramParcel.writeString(this.fPN);
    paramParcel.writeString(this.Ejs);
    paramParcel.writeInt(this.Ejt);
    paramParcel.writeString(this.Eju);
    AppMethodBeat.o(55674);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.mm.plugin.location.model.LocationInfo
 * JD-Core Version:    0.7.0.1
 */