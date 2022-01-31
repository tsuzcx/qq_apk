package com.tencent.mm.plugin.appbrand.launching;

import android.os.Parcel;
import android.os.Parcelable;
import android.os.Parcelable.Creator;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.appbrand.config.AppBrandInitConfigWC;
import com.tencent.mm.plugin.appbrand.report.AppBrandStatObject;
import com.tencent.mm.plugin.appbrand.report.quality.QualitySession;

public final class AppBrandTaskUsageRecorder$LaunchCheckParams
  implements Parcelable
{
  public static final Parcelable.Creator<LaunchCheckParams> CREATOR;
  final String bCU;
  final int gXf;
  final int hEZ;
  final QualitySession hiI;
  final boolean hqi;
  final AppBrandStatObject ikA;
  final AppBrandInitConfigWC ikz;
  
  static
  {
    AppMethodBeat.i(131763);
    CREATOR = new AppBrandTaskUsageRecorder.LaunchCheckParams.1();
    AppMethodBeat.o(131763);
  }
  
  AppBrandTaskUsageRecorder$LaunchCheckParams(Parcel paramParcel)
  {
    AppMethodBeat.i(131762);
    this.hqi = true;
    this.ikz = ((AppBrandInitConfigWC)paramParcel.readParcelable(AppBrandInitConfigWC.class.getClassLoader()));
    this.ikA = ((AppBrandStatObject)paramParcel.readParcelable(AppBrandStatObject.class.getClassLoader()));
    this.gXf = paramParcel.readInt();
    this.hEZ = paramParcel.readInt();
    this.bCU = paramParcel.readString();
    this.hiI = ((QualitySession)paramParcel.readParcelable(QualitySession.class.getClassLoader()));
    AppMethodBeat.o(131762);
  }
  
  public AppBrandTaskUsageRecorder$LaunchCheckParams(AppBrandInitConfigWC paramAppBrandInitConfigWC, AppBrandStatObject paramAppBrandStatObject, int paramInt1, int paramInt2, String paramString, QualitySession paramQualitySession)
  {
    this.hqi = true;
    this.ikz = paramAppBrandInitConfigWC;
    this.ikA = paramAppBrandStatObject;
    this.gXf = paramInt1;
    this.hEZ = paramInt2;
    this.bCU = paramString;
    this.hiI = paramQualitySession;
  }
  
  public final int describeContents()
  {
    return 0;
  }
  
  public final void writeToParcel(Parcel paramParcel, int paramInt)
  {
    AppMethodBeat.i(131761);
    paramParcel.writeParcelable(this.ikz, paramInt);
    paramParcel.writeParcelable(this.ikA, paramInt);
    paramParcel.writeInt(this.gXf);
    paramParcel.writeInt(this.hEZ);
    paramParcel.writeString(this.bCU);
    paramParcel.writeParcelable(this.hiI, paramInt);
    AppMethodBeat.o(131761);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.launching.AppBrandTaskUsageRecorder.LaunchCheckParams
 * JD-Core Version:    0.7.0.1
 */