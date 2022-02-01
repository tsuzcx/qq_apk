package com.tencent.mm.plugin.appbrand.report.quality;

import android.os.Parcel;
import android.os.Parcelable;
import android.os.Parcelable.Creator;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.appbrand.config.AppBrandInitConfigWC;
import com.tencent.mm.plugin.appbrand.report.AppBrandStatObject;
import com.tencent.mm.sdk.platformtools.ad;

public class QualitySession
  implements Parcelable
{
  public static final Parcelable.Creator<QualitySession> CREATOR;
  public String appId;
  public int apptype;
  public final String kGa;
  public int lrW;
  public int ltA;
  public int lty;
  public long ltz;
  public int scene;
  
  static
  {
    AppMethodBeat.i(48229);
    CREATOR = new Parcelable.Creator() {};
    AppMethodBeat.o(48229);
  }
  
  protected QualitySession(Parcel paramParcel)
  {
    AppMethodBeat.i(48228);
    this.ltz = 0L;
    this.ltA = 0;
    this.kGa = paramParcel.readString();
    this.appId = paramParcel.readString();
    this.lrW = paramParcel.readInt();
    this.apptype = paramParcel.readInt();
    this.scene = paramParcel.readInt();
    this.lty = paramParcel.readInt();
    this.ltz = paramParcel.readLong();
    this.ltA = paramParcel.readInt();
    ad.i("MicroMsg.AppBrand.QualitySession", "secondary <init> instanceId[%s] apptype[%d] scene[%d] appversion[%d]", new Object[] { this.kGa, Integer.valueOf(this.apptype), Integer.valueOf(this.scene), Integer.valueOf(this.lty) });
    AppMethodBeat.o(48228);
  }
  
  public QualitySession(String paramString, AppBrandInitConfigWC paramAppBrandInitConfigWC, AppBrandStatObject paramAppBrandStatObject)
  {
    AppMethodBeat.i(48226);
    this.ltz = 0L;
    this.ltA = 0;
    this.kGa = paramString;
    this.appId = paramAppBrandInitConfigWC.appId;
    switch (paramAppBrandInitConfigWC.iOP)
    {
    }
    for (;;)
    {
      this.apptype = (paramAppBrandInitConfigWC.cfd + 1000);
      this.scene = paramAppBrandStatObject.scene;
      this.lty = paramAppBrandInitConfigWC.aAS;
      ad.i("MicroMsg.AppBrand.QualitySession", "primary <init> instanceId[%s] apptype[%d] scene[%d] appversion[%d]", new Object[] { this.kGa, Integer.valueOf(this.apptype), Integer.valueOf(this.scene), Integer.valueOf(this.lty) });
      AppMethodBeat.o(48226);
      return;
      this.lrW = 1;
      continue;
      this.lrW = 2;
      continue;
      this.lrW = 3;
    }
  }
  
  public int describeContents()
  {
    return 0;
  }
  
  public void writeToParcel(Parcel paramParcel, int paramInt)
  {
    AppMethodBeat.i(48227);
    paramParcel.writeString(this.kGa);
    paramParcel.writeString(this.appId);
    paramParcel.writeInt(this.lrW);
    paramParcel.writeInt(this.apptype);
    paramParcel.writeInt(this.scene);
    paramParcel.writeInt(this.lty);
    paramParcel.writeLong(this.ltz);
    paramParcel.writeInt(this.ltA);
    AppMethodBeat.o(48227);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.report.quality.QualitySession
 * JD-Core Version:    0.7.0.1
 */