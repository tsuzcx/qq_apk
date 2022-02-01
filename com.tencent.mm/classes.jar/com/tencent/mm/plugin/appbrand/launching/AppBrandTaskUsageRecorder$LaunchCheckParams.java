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
  final String cbY;
  final QualitySession jDH;
  final boolean jND;
  final int khA;
  final AppBrandInitConfigWC liu;
  final AppBrandStatObject liv;
  final int pkgVersion;
  
  static
  {
    AppMethodBeat.i(47111);
    CREATOR = new Parcelable.Creator() {};
    AppMethodBeat.o(47111);
  }
  
  AppBrandTaskUsageRecorder$LaunchCheckParams(Parcel paramParcel)
  {
    AppMethodBeat.i(47110);
    this.jND = true;
    this.liu = ((AppBrandInitConfigWC)paramParcel.readParcelable(AppBrandInitConfigWC.class.getClassLoader()));
    this.liv = ((AppBrandStatObject)paramParcel.readParcelable(AppBrandStatObject.class.getClassLoader()));
    this.pkgVersion = paramParcel.readInt();
    this.khA = paramParcel.readInt();
    this.cbY = paramParcel.readString();
    this.jDH = ((QualitySession)paramParcel.readParcelable(QualitySession.class.getClassLoader()));
    AppMethodBeat.o(47110);
  }
  
  public AppBrandTaskUsageRecorder$LaunchCheckParams(AppBrandInitConfigWC paramAppBrandInitConfigWC, AppBrandStatObject paramAppBrandStatObject, int paramInt1, int paramInt2, String paramString, QualitySession paramQualitySession)
  {
    this.jND = true;
    this.liu = paramAppBrandInitConfigWC;
    this.liv = paramAppBrandStatObject;
    this.pkgVersion = paramInt1;
    this.khA = paramInt2;
    this.cbY = paramString;
    this.jDH = paramQualitySession;
  }
  
  public final int describeContents()
  {
    return 0;
  }
  
  public final void writeToParcel(Parcel paramParcel, int paramInt)
  {
    AppMethodBeat.i(47109);
    paramParcel.writeParcelable(this.liu, paramInt);
    paramParcel.writeParcelable(this.liv, paramInt);
    paramParcel.writeInt(this.pkgVersion);
    paramParcel.writeInt(this.khA);
    paramParcel.writeString(this.cbY);
    paramParcel.writeParcelable(this.jDH, paramInt);
    AppMethodBeat.o(47109);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.launching.AppBrandTaskUsageRecorder.LaunchCheckParams
 * JD-Core Version:    0.7.0.1
 */