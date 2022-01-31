package com.tencent.mm.plugin.location.model;

import android.os.Parcel;
import android.os.Parcelable;
import android.os.Parcelable.Creator;
import com.tencent.mm.plugin.location.ui.d;
import com.tencent.mm.sdk.platformtools.bk;

public class LocationInfo
  implements Parcelable
{
  public static final Parcelable.Creator<LocationInfo> CREATOR = new LocationInfo.1();
  public String bVA;
  public String lCI = "";
  public double lCJ = -85.0D;
  public double lCK = -1000.0D;
  public int lCL;
  public String lCM = "";
  public String lCN = "zh-cn";
  String lCO = "";
  public int lCP = 0;
  public String lCQ;
  
  public LocationInfo() {}
  
  public LocationInfo(byte paramByte)
  {
    this.lCI = (toString() + " " + System.nanoTime());
    this.lCL = d.bem();
  }
  
  public final boolean bdN()
  {
    return (this.lCJ != -85.0D) && (this.lCK != -1000.0D);
  }
  
  public final boolean bdO()
  {
    return (!bk.bl(this.lCM)) || (!bk.bl(this.bVA));
  }
  
  public int describeContents()
  {
    return 0;
  }
  
  public String toString()
  {
    return this.lCJ + " " + this.lCK + " " + this.lCM + " " + this.bVA + "  " + this.lCI;
  }
  
  public void writeToParcel(Parcel paramParcel, int paramInt)
  {
    paramParcel.writeString(this.lCI);
    paramParcel.writeDouble(this.lCJ);
    paramParcel.writeDouble(this.lCK);
    paramParcel.writeInt(this.lCL);
    paramParcel.writeString(this.lCM);
    paramParcel.writeString(this.lCN);
    paramParcel.writeString(this.bVA);
    paramParcel.writeString(this.lCO);
    paramParcel.writeInt(this.lCP);
    paramParcel.writeString(this.lCQ);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.plugin.location.model.LocationInfo
 * JD-Core Version:    0.7.0.1
 */