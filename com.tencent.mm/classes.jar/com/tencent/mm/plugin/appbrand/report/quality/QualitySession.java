package com.tencent.mm.plugin.appbrand.report.quality;

import android.os.Parcel;
import android.os.Parcelable;
import android.os.Parcelable.Creator;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.appbrand.config.AppBrandInitConfigWC;
import com.tencent.mm.plugin.appbrand.report.AppBrandStatObject;

public class QualitySession
  implements Parcelable
{
  public static final Parcelable.Creator<QualitySession> CREATOR;
  public String appId;
  public int apptype;
  public int iIF;
  public int iIG;
  public final String ikX;
  public int scene;
  
  static
  {
    AppMethodBeat.i(132707);
    CREATOR = new QualitySession.1();
    AppMethodBeat.o(132707);
  }
  
  protected QualitySession(Parcel paramParcel)
  {
    AppMethodBeat.i(132706);
    this.ikX = paramParcel.readString();
    this.appId = paramParcel.readString();
    this.iIF = paramParcel.readInt();
    this.apptype = paramParcel.readInt();
    this.scene = paramParcel.readInt();
    this.iIG = paramParcel.readInt();
    AppMethodBeat.o(132706);
  }
  
  public QualitySession(String paramString, AppBrandInitConfigWC paramAppBrandInitConfigWC, AppBrandStatObject paramAppBrandStatObject)
  {
    AppMethodBeat.i(132704);
    this.ikX = paramString;
    this.appId = paramAppBrandInitConfigWC.appId;
    switch (paramAppBrandInitConfigWC.gXd)
    {
    }
    for (;;)
    {
      this.apptype = (paramAppBrandInitConfigWC.bCV + 1000);
      this.scene = paramAppBrandStatObject.scene;
      this.iIG = paramAppBrandInitConfigWC.bDc;
      AppMethodBeat.o(132704);
      return;
      this.iIF = 1;
      continue;
      this.iIF = 2;
      continue;
      this.iIF = 3;
    }
  }
  
  public int describeContents()
  {
    return 0;
  }
  
  public void writeToParcel(Parcel paramParcel, int paramInt)
  {
    AppMethodBeat.i(132705);
    paramParcel.writeString(this.ikX);
    paramParcel.writeString(this.appId);
    paramParcel.writeInt(this.iIF);
    paramParcel.writeInt(this.apptype);
    paramParcel.writeInt(this.scene);
    paramParcel.writeInt(this.iIG);
    AppMethodBeat.o(132705);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes9.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.report.quality.QualitySession
 * JD-Core Version:    0.7.0.1
 */