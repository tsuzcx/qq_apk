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
  final String cmr;
  final int kFG;
  final QualitySession kaS;
  final boolean kle;
  final AppBrandInitConfigWC lJW;
  final AppBrandStatObject lJX;
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
    this.kle = true;
    this.lJW = ((AppBrandInitConfigWC)paramParcel.readParcelable(AppBrandInitConfigWC.class.getClassLoader()));
    this.lJX = ((AppBrandStatObject)paramParcel.readParcelable(AppBrandStatObject.class.getClassLoader()));
    this.pkgVersion = paramParcel.readInt();
    this.kFG = paramParcel.readInt();
    this.cmr = paramParcel.readString();
    this.kaS = ((QualitySession)paramParcel.readParcelable(QualitySession.class.getClassLoader()));
    AppMethodBeat.o(47110);
  }
  
  public AppBrandTaskUsageRecorder$LaunchCheckParams(AppBrandInitConfigWC paramAppBrandInitConfigWC, AppBrandStatObject paramAppBrandStatObject, int paramInt1, int paramInt2, String paramString, QualitySession paramQualitySession)
  {
    this.kle = true;
    this.lJW = paramAppBrandInitConfigWC;
    this.lJX = paramAppBrandStatObject;
    this.pkgVersion = paramInt1;
    this.kFG = paramInt2;
    this.cmr = paramString;
    this.kaS = paramQualitySession;
  }
  
  public final int describeContents()
  {
    return 0;
  }
  
  public final void writeToParcel(Parcel paramParcel, int paramInt)
  {
    AppMethodBeat.i(47109);
    paramParcel.writeParcelable(this.lJW, paramInt);
    paramParcel.writeParcelable(this.lJX, paramInt);
    paramParcel.writeInt(this.pkgVersion);
    paramParcel.writeInt(this.kFG);
    paramParcel.writeString(this.cmr);
    paramParcel.writeParcelable(this.kaS, paramInt);
    AppMethodBeat.o(47109);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.launching.AppBrandTaskUsageRecorder.LaunchCheckParams
 * JD-Core Version:    0.7.0.1
 */