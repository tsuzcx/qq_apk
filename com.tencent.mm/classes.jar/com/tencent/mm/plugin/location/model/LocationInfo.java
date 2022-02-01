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
  public String dtN;
  String sOA;
  public int sOB;
  public String sOC;
  public String sOu;
  public double sOv;
  public double sOw;
  public int sOx;
  public String sOy;
  public String sOz;
  
  static
  {
    AppMethodBeat.i(55677);
    CREATOR = new Parcelable.Creator() {};
    AppMethodBeat.o(55677);
  }
  
  public LocationInfo()
  {
    this.sOu = "";
    this.sOv = -85.0D;
    this.sOw = -1000.0D;
    this.sOy = "";
    this.sOz = "zh-cn";
    this.sOA = "";
    this.sOB = 0;
  }
  
  public LocationInfo(byte paramByte)
  {
    AppMethodBeat.i(55673);
    this.sOu = "";
    this.sOv = -85.0D;
    this.sOw = -1000.0D;
    this.sOy = "";
    this.sOz = "zh-cn";
    this.sOA = "";
    this.sOB = 0;
    this.sOu = (toString() + " " + System.nanoTime());
    this.sOx = d.cJD();
    AppMethodBeat.o(55673);
  }
  
  public final boolean cJg()
  {
    return (this.sOv != -85.0D) && (this.sOw != -1000.0D);
  }
  
  public final boolean cJh()
  {
    AppMethodBeat.i(55675);
    if ((bt.isNullOrNil(this.sOy)) && (bt.isNullOrNil(this.dtN)))
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
    String str = this.sOv + " " + this.sOw + " " + this.sOy + " " + this.dtN + "  " + this.sOu;
    AppMethodBeat.o(55676);
    return str;
  }
  
  public void writeToParcel(Parcel paramParcel, int paramInt)
  {
    AppMethodBeat.i(55674);
    paramParcel.writeString(this.sOu);
    paramParcel.writeDouble(this.sOv);
    paramParcel.writeDouble(this.sOw);
    paramParcel.writeInt(this.sOx);
    paramParcel.writeString(this.sOy);
    paramParcel.writeString(this.sOz);
    paramParcel.writeString(this.dtN);
    paramParcel.writeString(this.sOA);
    paramParcel.writeInt(this.sOB);
    paramParcel.writeString(this.sOC);
    AppMethodBeat.o(55674);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.plugin.location.model.LocationInfo
 * JD-Core Version:    0.7.0.1
 */