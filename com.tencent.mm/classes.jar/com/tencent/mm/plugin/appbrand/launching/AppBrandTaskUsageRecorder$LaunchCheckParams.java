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
  final String cym;
  final AppBrandInitConfigWC kEG;
  final int lKh;
  final QualitySession ldW;
  final boolean loP;
  final AppBrandStatObject mRM;
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
    this.loP = true;
    this.kEG = ((AppBrandInitConfigWC)paramParcel.readParcelable(AppBrandInitConfigWC.class.getClassLoader()));
    this.mRM = ((AppBrandStatObject)paramParcel.readParcelable(AppBrandStatObject.class.getClassLoader()));
    this.pkgVersion = paramParcel.readInt();
    this.lKh = paramParcel.readInt();
    this.cym = paramParcel.readString();
    this.ldW = ((QualitySession)paramParcel.readParcelable(QualitySession.class.getClassLoader()));
    AppMethodBeat.o(47110);
  }
  
  public AppBrandTaskUsageRecorder$LaunchCheckParams(AppBrandInitConfigWC paramAppBrandInitConfigWC, AppBrandStatObject paramAppBrandStatObject, int paramInt1, int paramInt2, String paramString, QualitySession paramQualitySession)
  {
    this.loP = true;
    this.kEG = paramAppBrandInitConfigWC;
    this.mRM = paramAppBrandStatObject;
    this.pkgVersion = paramInt1;
    this.lKh = paramInt2;
    this.cym = paramString;
    this.ldW = paramQualitySession;
  }
  
  public final int describeContents()
  {
    return 0;
  }
  
  public final void writeToParcel(Parcel paramParcel, int paramInt)
  {
    AppMethodBeat.i(47109);
    paramParcel.writeParcelable(this.kEG, paramInt);
    paramParcel.writeParcelable(this.mRM, paramInt);
    paramParcel.writeInt(this.pkgVersion);
    paramParcel.writeInt(this.lKh);
    paramParcel.writeString(this.cym);
    paramParcel.writeParcelable(this.ldW, paramInt);
    AppMethodBeat.o(47109);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.launching.AppBrandTaskUsageRecorder.LaunchCheckParams
 * JD-Core Version:    0.7.0.1
 */