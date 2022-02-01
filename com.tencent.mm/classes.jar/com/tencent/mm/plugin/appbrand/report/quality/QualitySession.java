package com.tencent.mm.plugin.appbrand.report.quality;

import android.os.Parcel;
import android.os.Parcelable;
import android.os.Parcelable.Creator;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.appbrand.config.AppBrandInitConfigWC;
import com.tencent.mm.plugin.appbrand.report.AppBrandStatObject;
import com.tencent.mm.sdk.platformtools.Log;

public class QualitySession
  implements Parcelable
{
  public static final Parcelable.Creator<QualitySession> CREATOR;
  public String appId;
  public int apptype;
  public final String kEY;
  public int nJE;
  public int nLk;
  public long nLl;
  public boolean nLm;
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
    this.nLl = 0L;
    this.nLm = false;
    this.kEY = paramParcel.readString();
    this.appId = paramParcel.readString();
    this.nJE = paramParcel.readInt();
    this.apptype = paramParcel.readInt();
    this.scene = paramParcel.readInt();
    this.nLk = paramParcel.readInt();
    this.nLl = paramParcel.readLong();
    if (paramParcel.readByte() > 0) {}
    for (boolean bool = true;; bool = false)
    {
      this.nLm = bool;
      Log.i("MicroMsg.AppBrand.QualitySession", "secondary <init> instanceId[%s] apptype[%d] scene[%d] appversion[%d] UIReadyT[%d] isNewUser[%b]", new Object[] { this.kEY, Integer.valueOf(this.apptype), Integer.valueOf(this.scene), Integer.valueOf(this.nLk), Long.valueOf(this.nLl), Boolean.valueOf(this.nLm) });
      AppMethodBeat.o(48228);
      return;
    }
  }
  
  public QualitySession(String paramString, AppBrandInitConfigWC paramAppBrandInitConfigWC, AppBrandStatObject paramAppBrandStatObject)
  {
    AppMethodBeat.i(48226);
    this.nLl = 0L;
    this.nLm = false;
    this.kEY = paramString;
    this.appId = paramAppBrandInitConfigWC.appId;
    switch (paramAppBrandInitConfigWC.eix)
    {
    }
    for (;;)
    {
      this.apptype = (paramAppBrandInitConfigWC.cyo + 1000);
      this.scene = paramAppBrandStatObject.scene;
      this.nLk = paramAppBrandInitConfigWC.appVersion;
      Log.i("MicroMsg.AppBrand.QualitySession", "primary <init> instanceId[%s] apptype[%d] scene[%d] appversion[%d]", new Object[] { this.kEY, Integer.valueOf(this.apptype), Integer.valueOf(this.scene), Integer.valueOf(this.nLk) });
      AppMethodBeat.o(48226);
      return;
      this.nJE = 1;
      continue;
      this.nJE = 2;
      continue;
      this.nJE = 3;
    }
  }
  
  public int describeContents()
  {
    return 0;
  }
  
  public void writeToParcel(Parcel paramParcel, int paramInt)
  {
    AppMethodBeat.i(48227);
    paramParcel.writeString(this.kEY);
    paramParcel.writeString(this.appId);
    paramParcel.writeInt(this.nJE);
    paramParcel.writeInt(this.apptype);
    paramParcel.writeInt(this.scene);
    paramParcel.writeInt(this.nLk);
    paramParcel.writeLong(this.nLl);
    if (this.nLm) {}
    for (paramInt = 1;; paramInt = 0)
    {
      paramParcel.writeByte((byte)paramInt);
      AppMethodBeat.o(48227);
      return;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.report.quality.QualitySession
 * JD-Core Version:    0.7.0.1
 */