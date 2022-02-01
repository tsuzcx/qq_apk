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
  public final String cBH;
  public int qLQ;
  public int qNx;
  public long qNy;
  public boolean qNz;
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
    this.qNy = 0L;
    this.qNz = false;
    this.cBH = paramParcel.readString();
    this.appId = paramParcel.readString();
    this.qLQ = paramParcel.readInt();
    this.apptype = paramParcel.readInt();
    this.scene = paramParcel.readInt();
    this.qNx = paramParcel.readInt();
    this.qNy = paramParcel.readLong();
    if (paramParcel.readByte() > 0) {}
    for (boolean bool = true;; bool = false)
    {
      this.qNz = bool;
      Log.i("MicroMsg.AppBrand.QualitySession", "secondary <init> instanceId[%s] apptype[%d] scene[%d] appversion[%d] UIReadyT[%d] isNewUser[%b]", new Object[] { this.cBH, Integer.valueOf(this.apptype), Integer.valueOf(this.scene), Integer.valueOf(this.qNx), Long.valueOf(this.qNy), Boolean.valueOf(this.qNz) });
      AppMethodBeat.o(48228);
      return;
    }
  }
  
  public QualitySession(String paramString, AppBrandInitConfigWC paramAppBrandInitConfigWC, AppBrandStatObject paramAppBrandStatObject)
  {
    AppMethodBeat.i(48226);
    this.qNy = 0L;
    this.qNz = false;
    this.cBH = paramString;
    this.appId = paramAppBrandInitConfigWC.appId;
    switch (paramAppBrandInitConfigWC.cBI)
    {
    }
    for (;;)
    {
      this.apptype = (paramAppBrandInitConfigWC.cwR + 1000);
      this.scene = paramAppBrandStatObject.scene;
      this.qNx = paramAppBrandInitConfigWC.appVersion;
      Log.i("MicroMsg.AppBrand.QualitySession", "primary <init> instanceId[%s] apptype[%d] scene[%d] appversion[%d]", new Object[] { this.cBH, Integer.valueOf(this.apptype), Integer.valueOf(this.scene), Integer.valueOf(this.qNx) });
      AppMethodBeat.o(48226);
      return;
      this.qLQ = 1;
      continue;
      this.qLQ = 2;
      continue;
      this.qLQ = 3;
    }
  }
  
  public int describeContents()
  {
    return 0;
  }
  
  public void writeToParcel(Parcel paramParcel, int paramInt)
  {
    AppMethodBeat.i(48227);
    paramParcel.writeString(this.cBH);
    paramParcel.writeString(this.appId);
    paramParcel.writeInt(this.qLQ);
    paramParcel.writeInt(this.apptype);
    paramParcel.writeInt(this.scene);
    paramParcel.writeInt(this.qNx);
    paramParcel.writeLong(this.qNy);
    if (this.qNz) {}
    for (paramInt = 1;; paramInt = 0)
    {
      paramParcel.writeByte((byte)paramInt);
      AppMethodBeat.o(48227);
      return;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.report.quality.QualitySession
 * JD-Core Version:    0.7.0.1
 */