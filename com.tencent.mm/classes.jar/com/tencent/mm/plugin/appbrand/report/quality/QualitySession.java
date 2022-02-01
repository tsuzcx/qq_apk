package com.tencent.mm.plugin.appbrand.report.quality;

import android.os.Parcel;
import android.os.Parcelable;
import android.os.Parcelable.Creator;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.appbrand.config.AppBrandInitConfigWC;
import com.tencent.mm.plugin.appbrand.report.AppBrandStatObject;
import com.tencent.mm.sdk.platformtools.ac;

public class QualitySession
  implements Parcelable
{
  public static final Parcelable.Creator<QualitySession> CREATOR;
  public String appId;
  public int apptype;
  public int lTR;
  public int lVs;
  public long lVt;
  public int lVu;
  public final String lht;
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
    this.lVt = 0L;
    this.lVu = 0;
    this.lht = paramParcel.readString();
    this.appId = paramParcel.readString();
    this.lTR = paramParcel.readInt();
    this.apptype = paramParcel.readInt();
    this.scene = paramParcel.readInt();
    this.lVs = paramParcel.readInt();
    this.lVt = paramParcel.readLong();
    this.lVu = paramParcel.readInt();
    ac.i("MicroMsg.AppBrand.QualitySession", "secondary <init> instanceId[%s] apptype[%d] scene[%d] appversion[%d]", new Object[] { this.lht, Integer.valueOf(this.apptype), Integer.valueOf(this.scene), Integer.valueOf(this.lVs) });
    AppMethodBeat.o(48228);
  }
  
  public QualitySession(String paramString, AppBrandInitConfigWC paramAppBrandInitConfigWC, AppBrandStatObject paramAppBrandStatObject)
  {
    AppMethodBeat.i(48226);
    this.lVt = 0L;
    this.lVu = 0;
    this.lht = paramString;
    this.appId = paramAppBrandInitConfigWC.appId;
    switch (paramAppBrandInitConfigWC.joY)
    {
    }
    for (;;)
    {
      this.apptype = (paramAppBrandInitConfigWC.cca + 1000);
      this.scene = paramAppBrandStatObject.scene;
      this.lVs = paramAppBrandInitConfigWC.aBM;
      ac.i("MicroMsg.AppBrand.QualitySession", "primary <init> instanceId[%s] apptype[%d] scene[%d] appversion[%d]", new Object[] { this.lht, Integer.valueOf(this.apptype), Integer.valueOf(this.scene), Integer.valueOf(this.lVs) });
      AppMethodBeat.o(48226);
      return;
      this.lTR = 1;
      continue;
      this.lTR = 2;
      continue;
      this.lTR = 3;
    }
  }
  
  public int describeContents()
  {
    return 0;
  }
  
  public void writeToParcel(Parcel paramParcel, int paramInt)
  {
    AppMethodBeat.i(48227);
    paramParcel.writeString(this.lht);
    paramParcel.writeString(this.appId);
    paramParcel.writeInt(this.lTR);
    paramParcel.writeInt(this.apptype);
    paramParcel.writeInt(this.scene);
    paramParcel.writeInt(this.lVs);
    paramParcel.writeLong(this.lVt);
    paramParcel.writeInt(this.lVu);
    AppMethodBeat.o(48227);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.report.quality.QualitySession
 * JD-Core Version:    0.7.0.1
 */