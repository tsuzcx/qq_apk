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
  public final String eup;
  public int scene;
  public int tQx;
  public int tSh;
  public long tSi;
  public boolean tSj;
  
  static
  {
    AppMethodBeat.i(48229);
    CREATOR = new Parcelable.Creator() {};
    AppMethodBeat.o(48229);
  }
  
  protected QualitySession(Parcel paramParcel)
  {
    AppMethodBeat.i(48228);
    this.tSi = 0L;
    this.tSj = false;
    this.eup = paramParcel.readString();
    this.appId = paramParcel.readString();
    this.tQx = paramParcel.readInt();
    this.apptype = paramParcel.readInt();
    this.scene = paramParcel.readInt();
    this.tSh = paramParcel.readInt();
    this.tSi = paramParcel.readLong();
    if (paramParcel.readByte() > 0) {}
    for (boolean bool = true;; bool = false)
    {
      this.tSj = bool;
      Log.i("MicroMsg.AppBrand.QualitySession", "secondary <init> instanceId[%s] apptype[%d] scene[%d] appversion[%d] UIReadyT[%d] isNewUser[%b]", new Object[] { this.eup, Integer.valueOf(this.apptype), Integer.valueOf(this.scene), Integer.valueOf(this.tSh), Long.valueOf(this.tSi), Boolean.valueOf(this.tSj) });
      AppMethodBeat.o(48228);
      return;
    }
  }
  
  public QualitySession(String paramString, AppBrandInitConfigWC paramAppBrandInitConfigWC, AppBrandStatObject paramAppBrandStatObject)
  {
    AppMethodBeat.i(48226);
    this.tSi = 0L;
    this.tSj = false;
    this.eup = paramString;
    this.appId = paramAppBrandInitConfigWC.appId;
    switch (paramAppBrandInitConfigWC.eul)
    {
    }
    for (;;)
    {
      this.apptype = (paramAppBrandInitConfigWC.appServiceType + 1000);
      this.scene = paramAppBrandStatObject.scene;
      this.tSh = paramAppBrandInitConfigWC.appVersion;
      Log.i("MicroMsg.AppBrand.QualitySession", "primary <init> instanceId[%s] apptype[%d] scene[%d] appversion[%d]", new Object[] { this.eup, Integer.valueOf(this.apptype), Integer.valueOf(this.scene), Integer.valueOf(this.tSh) });
      AppMethodBeat.o(48226);
      return;
      this.tQx = 1;
      continue;
      this.tQx = 2;
      continue;
      this.tQx = 3;
    }
  }
  
  public int describeContents()
  {
    return 0;
  }
  
  public void writeToParcel(Parcel paramParcel, int paramInt)
  {
    AppMethodBeat.i(48227);
    paramParcel.writeString(this.eup);
    paramParcel.writeString(this.appId);
    paramParcel.writeInt(this.tQx);
    paramParcel.writeInt(this.apptype);
    paramParcel.writeInt(this.scene);
    paramParcel.writeInt(this.tSh);
    paramParcel.writeLong(this.tSi);
    if (this.tSj) {}
    for (paramInt = 1;; paramInt = 0)
    {
      paramParcel.writeByte((byte)paramInt);
      AppMethodBeat.o(48227);
      return;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.report.quality.QualitySession
 * JD-Core Version:    0.7.0.1
 */