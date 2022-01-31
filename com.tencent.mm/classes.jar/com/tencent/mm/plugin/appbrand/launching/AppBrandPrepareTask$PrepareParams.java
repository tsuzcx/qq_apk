package com.tencent.mm.plugin.appbrand.launching;

import android.os.Parcel;
import android.os.Parcelable;
import android.os.Parcelable.Creator;
import com.tencent.mm.plugin.appbrand.config.AppBrandLaunchReferrer;
import com.tencent.mm.plugin.appbrand.report.quality.QualitySession;
import java.util.Locale;

final class AppBrandPrepareTask$PrepareParams
  implements Parcelable
{
  public static final Parcelable.Creator<PrepareParams> CREATOR = new AppBrandPrepareTask.PrepareParams.1();
  private int faB;
  private int gJA;
  private AppBrandLaunchReferrer gJB;
  private String gJC;
  private int gJD;
  private boolean gJE;
  private QualitySession gJF;
  private boolean gJp;
  private int gJy;
  private String gJz;
  private String mAppId;
  
  AppBrandPrepareTask$PrepareParams() {}
  
  AppBrandPrepareTask$PrepareParams(Parcel paramParcel)
  {
    this.gJy = paramParcel.readInt();
    this.faB = paramParcel.readInt();
    this.gJz = paramParcel.readString();
    this.mAppId = paramParcel.readString();
    this.gJA = paramParcel.readInt();
    this.gJB = ((AppBrandLaunchReferrer)paramParcel.readParcelable(AppBrandLaunchReferrer.class.getClassLoader()));
    this.gJC = paramParcel.readString();
    this.gJD = paramParcel.readInt();
    if (paramParcel.readInt() == 1)
    {
      bool1 = true;
      this.gJp = bool1;
      if (paramParcel.readInt() <= 0) {
        break label129;
      }
    }
    label129:
    for (boolean bool1 = bool2;; bool1 = false)
    {
      this.gJE = bool1;
      this.gJF = ((QualitySession)paramParcel.readParcelable(QualitySession.class.getClassLoader()));
      return;
      bool1 = false;
      break;
    }
  }
  
  public final int describeContents()
  {
    return 0;
  }
  
  public final String toShortString()
  {
    return String.format(Locale.US, "[%s|%d]", new Object[] { this.mAppId, Integer.valueOf(this.gJA) });
  }
  
  public final void writeToParcel(Parcel paramParcel, int paramInt)
  {
    int j = 1;
    paramParcel.writeInt(this.gJy);
    paramParcel.writeInt(this.faB);
    paramParcel.writeString(this.gJz);
    paramParcel.writeString(this.mAppId);
    paramParcel.writeInt(this.gJA);
    paramParcel.writeParcelable(this.gJB, paramInt);
    paramParcel.writeString(this.gJC);
    paramParcel.writeInt(this.gJD);
    if (this.gJp)
    {
      i = 1;
      paramParcel.writeInt(i);
      if (!this.gJE) {
        break label112;
      }
    }
    label112:
    for (int i = j;; i = 0)
    {
      paramParcel.writeInt(i);
      paramParcel.writeParcelable(this.gJF, paramInt);
      return;
      i = 0;
      break;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.launching.AppBrandPrepareTask.PrepareParams
 * JD-Core Version:    0.7.0.1
 */