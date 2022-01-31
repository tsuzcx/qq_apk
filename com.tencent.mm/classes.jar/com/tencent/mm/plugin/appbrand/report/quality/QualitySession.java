package com.tencent.mm.plugin.appbrand.report.quality;

import android.os.Parcel;
import android.os.Parcelable;
import android.os.Parcelable.Creator;
import com.tencent.mm.plugin.appbrand.config.AppBrandInitConfigWC;
import com.tencent.mm.plugin.appbrand.report.AppBrandStatObject;

public class QualitySession
  implements Parcelable
{
  public static final Parcelable.Creator<QualitySession> CREATOR = new QualitySession.1();
  public String appId;
  public int apptype;
  public final String gKi;
  public int ham;
  public int han;
  public int scene;
  
  protected QualitySession(Parcel paramParcel)
  {
    this.gKi = paramParcel.readString();
    this.appId = paramParcel.readString();
    this.ham = paramParcel.readInt();
    this.apptype = paramParcel.readInt();
    this.scene = paramParcel.readInt();
    this.han = paramParcel.readInt();
  }
  
  public QualitySession(String paramString, AppBrandInitConfigWC paramAppBrandInitConfigWC, AppBrandStatObject paramAppBrandStatObject)
  {
    this.gKi = paramString;
    this.appId = paramAppBrandInitConfigWC.appId;
    switch (paramAppBrandInitConfigWC.fEL)
    {
    }
    for (;;)
    {
      this.apptype = (paramAppBrandInitConfigWC.bFB + 1000);
      this.scene = paramAppBrandStatObject.scene;
      this.han = paramAppBrandInitConfigWC.cau;
      return;
      this.ham = 1;
      continue;
      this.ham = 2;
      continue;
      this.ham = 3;
    }
  }
  
  public int describeContents()
  {
    return 0;
  }
  
  public void writeToParcel(Parcel paramParcel, int paramInt)
  {
    paramParcel.writeString(this.gKi);
    paramParcel.writeString(this.appId);
    paramParcel.writeInt(this.ham);
    paramParcel.writeInt(this.apptype);
    paramParcel.writeInt(this.scene);
    paramParcel.writeInt(this.han);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes9.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.report.quality.QualitySession
 * JD-Core Version:    0.7.0.1
 */