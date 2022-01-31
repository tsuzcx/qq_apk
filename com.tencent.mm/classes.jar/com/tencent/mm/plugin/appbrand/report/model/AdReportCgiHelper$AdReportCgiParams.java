package com.tencent.mm.plugin.appbrand.report.model;

import android.os.Parcel;
import android.os.Parcelable;
import android.os.Parcelable.Creator;

final class AdReportCgiHelper$AdReportCgiParams
  implements Parcelable
{
  public static final Parcelable.Creator<AdReportCgiParams> CREATOR = new AdReportCgiHelper.AdReportCgiParams.1();
  private int dCy;
  private String gXW;
  
  AdReportCgiHelper$AdReportCgiParams() {}
  
  protected AdReportCgiHelper$AdReportCgiParams(Parcel paramParcel)
  {
    this.dCy = paramParcel.readInt();
    this.gXW = paramParcel.readString();
  }
  
  public final int describeContents()
  {
    return 0;
  }
  
  public final void writeToParcel(Parcel paramParcel, int paramInt)
  {
    paramParcel.writeInt(this.dCy);
    paramParcel.writeString(this.gXW);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes9.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.report.model.AdReportCgiHelper.AdReportCgiParams
 * JD-Core Version:    0.7.0.1
 */