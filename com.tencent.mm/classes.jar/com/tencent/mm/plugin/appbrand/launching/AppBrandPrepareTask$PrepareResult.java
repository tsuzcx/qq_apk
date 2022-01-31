package com.tencent.mm.plugin.appbrand.launching;

import android.os.Parcel;
import android.os.Parcelable;
import android.os.Parcelable.Creator;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.appbrand.config.AppBrandSysConfigWC;
import com.tencent.mm.plugin.appbrand.jsapi.version.a;

final class AppBrandPrepareTask$PrepareResult
  implements Parcelable
{
  public static final Parcelable.Creator<PrepareResult> CREATOR;
  private int ikr;
  private AppBrandLaunchErrorAction iks;
  private AppBrandSysConfigWC ikt;
  private AppStartupPerformanceReportBundle iku;
  private int ikv;
  private long ikw;
  private a ikx;
  private int iky;
  
  static
  {
    AppMethodBeat.i(131757);
    CREATOR = new AppBrandPrepareTask.PrepareResult.1();
    AppMethodBeat.o(131757);
  }
  
  AppBrandPrepareTask$PrepareResult()
  {
    this.iky = 0;
  }
  
  AppBrandPrepareTask$PrepareResult(Parcel paramParcel)
  {
    AppMethodBeat.i(131756);
    this.iky = 0;
    this.ikr = paramParcel.readInt();
    this.iks = ((AppBrandLaunchErrorAction)paramParcel.readParcelable(AppBrandLaunchErrorAction.class.getClassLoader()));
    this.ikt = ((AppBrandSysConfigWC)paramParcel.readParcelable(AppBrandSysConfigWC.class.getClassLoader()));
    this.ikv = paramParcel.readInt();
    this.ikw = paramParcel.readLong();
    this.iku = ((AppStartupPerformanceReportBundle)paramParcel.readParcelable(AppStartupPerformanceReportBundle.class.getClassLoader()));
    this.iky = paramParcel.readInt();
    if (this.ikr == 5) {
      this.ikx = a.CP(paramParcel.readString());
    }
    AppMethodBeat.o(131756);
  }
  
  public final int describeContents()
  {
    return 0;
  }
  
  public final void writeToParcel(Parcel paramParcel, int paramInt)
  {
    AppMethodBeat.i(131755);
    paramParcel.writeInt(this.ikr);
    paramParcel.writeParcelable(this.iks, paramInt);
    paramParcel.writeParcelable(this.ikt, paramInt);
    paramParcel.writeInt(this.ikv);
    paramParcel.writeLong(this.ikw);
    paramParcel.writeParcelable(this.iku, paramInt);
    paramParcel.writeInt(this.iky);
    if (this.ikr == 5) {
      paramParcel.writeString(this.ikx.toString());
    }
    AppMethodBeat.o(131755);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.launching.AppBrandPrepareTask.PrepareResult
 * JD-Core Version:    0.7.0.1
 */