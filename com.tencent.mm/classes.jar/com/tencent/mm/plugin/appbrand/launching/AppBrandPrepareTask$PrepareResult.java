package com.tencent.mm.plugin.appbrand.launching;

import android.os.Parcel;
import android.os.Parcelable;
import android.os.Parcelable.Creator;
import com.tencent.mm.plugin.appbrand.config.AppBrandSysConfigWC;
import com.tencent.mm.plugin.appbrand.jsapi.version.a;

final class AppBrandPrepareTask$PrepareResult
  implements Parcelable
{
  public static final Parcelable.Creator<PrepareResult> CREATOR = new Parcelable.Creator() {};
  private int gJG;
  private AppBrandLaunchErrorAction gJH;
  private AppBrandSysConfigWC gJI;
  private AppStartupPerformanceReportBundle gJJ;
  private int gJK;
  private long gJL;
  private a gJM;
  
  AppBrandPrepareTask$PrepareResult() {}
  
  AppBrandPrepareTask$PrepareResult(Parcel paramParcel)
  {
    this.gJG = paramParcel.readInt();
    this.gJH = ((AppBrandLaunchErrorAction)paramParcel.readParcelable(AppBrandLaunchErrorAction.class.getClassLoader()));
    this.gJI = ((AppBrandSysConfigWC)paramParcel.readParcelable(AppBrandSysConfigWC.class.getClassLoader()));
    this.gJK = paramParcel.readInt();
    this.gJL = paramParcel.readLong();
    this.gJJ = ((AppStartupPerformanceReportBundle)paramParcel.readParcelable(AppStartupPerformanceReportBundle.class.getClassLoader()));
    if (this.gJG == 5) {
      this.gJM = a.uE(paramParcel.readString());
    }
  }
  
  public final int describeContents()
  {
    return 0;
  }
  
  public final void writeToParcel(Parcel paramParcel, int paramInt)
  {
    paramParcel.writeInt(this.gJG);
    paramParcel.writeParcelable(this.gJH, paramInt);
    paramParcel.writeParcelable(this.gJI, paramInt);
    paramParcel.writeInt(this.gJK);
    paramParcel.writeLong(this.gJL);
    paramParcel.writeParcelable(this.gJJ, paramInt);
    if (this.gJG == 5) {
      paramParcel.writeString(this.gJM.toString());
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.launching.AppBrandPrepareTask.PrepareResult
 * JD-Core Version:    0.7.0.1
 */