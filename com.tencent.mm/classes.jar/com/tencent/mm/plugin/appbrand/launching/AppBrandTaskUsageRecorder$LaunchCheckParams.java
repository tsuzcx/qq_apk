package com.tencent.mm.plugin.appbrand.launching;

import android.os.Parcel;
import android.os.Parcelable;
import android.os.Parcelable.Creator;
import com.tencent.mm.plugin.appbrand.config.AppBrandInitConfigWC;
import com.tencent.mm.plugin.appbrand.report.AppBrandStatObject;
import com.tencent.mm.plugin.appbrand.report.quality.QualitySession;

public final class AppBrandTaskUsageRecorder$LaunchCheckParams
  implements Parcelable
{
  public static final Parcelable.Creator<LaunchCheckParams> CREATOR = new AppBrandTaskUsageRecorder.LaunchCheckParams.1();
  final int fEN;
  final String fJO;
  final QualitySession fPC;
  final boolean fWI = true;
  final AppBrandInitConfigWC gJN;
  final AppBrandStatObject gJO;
  final int glj;
  
  AppBrandTaskUsageRecorder$LaunchCheckParams(Parcel paramParcel)
  {
    this.gJN = ((AppBrandInitConfigWC)paramParcel.readParcelable(AppBrandInitConfigWC.class.getClassLoader()));
    this.gJO = ((AppBrandStatObject)paramParcel.readParcelable(AppBrandStatObject.class.getClassLoader()));
    this.fEN = paramParcel.readInt();
    this.glj = paramParcel.readInt();
    this.fJO = paramParcel.readString();
    this.fPC = ((QualitySession)paramParcel.readParcelable(QualitySession.class.getClassLoader()));
  }
  
  public AppBrandTaskUsageRecorder$LaunchCheckParams(AppBrandInitConfigWC paramAppBrandInitConfigWC, AppBrandStatObject paramAppBrandStatObject, int paramInt1, int paramInt2, String paramString, QualitySession paramQualitySession)
  {
    this.gJN = paramAppBrandInitConfigWC;
    this.gJO = paramAppBrandStatObject;
    this.fEN = paramInt1;
    this.glj = paramInt2;
    this.fJO = paramString;
    this.fPC = paramQualitySession;
  }
  
  public final int describeContents()
  {
    return 0;
  }
  
  public final void writeToParcel(Parcel paramParcel, int paramInt)
  {
    paramParcel.writeParcelable(this.gJN, paramInt);
    paramParcel.writeParcelable(this.gJO, paramInt);
    paramParcel.writeInt(this.fEN);
    paramParcel.writeInt(this.glj);
    paramParcel.writeString(this.fJO);
    paramParcel.writeParcelable(this.fPC, paramInt);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.launching.AppBrandTaskUsageRecorder.LaunchCheckParams
 * JD-Core Version:    0.7.0.1
 */