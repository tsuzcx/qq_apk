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
  public String KbV;
  public double KbW;
  public double KbX;
  public int KbY;
  public String KbZ;
  public String Kca;
  String Kcb;
  public int Kcc;
  public String Kcd;
  public String hVI;
  
  static
  {
    AppMethodBeat.i(55677);
    CREATOR = new Parcelable.Creator() {};
    AppMethodBeat.o(55677);
  }
  
  public LocationInfo()
  {
    this.KbV = "";
    this.KbW = -85.0D;
    this.KbX = -1000.0D;
    this.KbZ = "";
    this.Kca = "zh-cn";
    this.Kcb = "";
    this.Kcc = 0;
  }
  
  public LocationInfo(byte paramByte)
  {
    AppMethodBeat.i(55673);
    this.KbV = "";
    this.KbW = -85.0D;
    this.KbX = -1000.0D;
    this.KbZ = "";
    this.Kca = "zh-cn";
    this.Kcb = "";
    this.Kcc = 0;
    this.KbV = (toString() + " " + System.nanoTime());
    this.KbY = d.fUQ();
    AppMethodBeat.o(55673);
  }
  
  public int describeContents()
  {
    return 0;
  }
  
  public final boolean fUs()
  {
    return (this.KbW != -85.0D) && (this.KbX != -1000.0D);
  }
  
  public final boolean fUt()
  {
    AppMethodBeat.i(55675);
    if ((Util.isNullOrNil(this.KbZ)) && (Util.isNullOrNil(this.hVI)))
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
    String str = this.KbW + " " + this.KbX + " " + this.KbZ + " " + this.hVI + "  " + this.KbV;
    AppMethodBeat.o(55676);
    return str;
  }
  
  public void writeToParcel(Parcel paramParcel, int paramInt)
  {
    AppMethodBeat.i(55674);
    paramParcel.writeString(this.KbV);
    paramParcel.writeDouble(this.KbW);
    paramParcel.writeDouble(this.KbX);
    paramParcel.writeInt(this.KbY);
    paramParcel.writeString(this.KbZ);
    paramParcel.writeString(this.Kca);
    paramParcel.writeString(this.hVI);
    paramParcel.writeString(this.Kcb);
    paramParcel.writeInt(this.Kcc);
    paramParcel.writeString(this.Kcd);
    AppMethodBeat.o(55674);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.plugin.location.model.LocationInfo
 * JD-Core Version:    0.7.0.1
 */