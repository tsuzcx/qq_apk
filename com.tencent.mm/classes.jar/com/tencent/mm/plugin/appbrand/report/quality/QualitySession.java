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
  public final String lEv;
  public int mtG;
  public int mvi;
  public long mvj;
  public boolean mvk;
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
    this.mvj = 0L;
    this.mvk = false;
    this.lEv = paramParcel.readString();
    this.appId = paramParcel.readString();
    this.mtG = paramParcel.readInt();
    this.apptype = paramParcel.readInt();
    this.scene = paramParcel.readInt();
    this.mvi = paramParcel.readInt();
    this.mvj = paramParcel.readLong();
    if (paramParcel.readByte() > 0) {}
    for (boolean bool = true;; bool = false)
    {
      this.mvk = bool;
      ad.i("MicroMsg.AppBrand.QualitySession", "secondary <init> instanceId[%s] apptype[%d] scene[%d] appversion[%d] UIReadyT[%d] isNewUser[%b]", new Object[] { this.lEv, Integer.valueOf(this.apptype), Integer.valueOf(this.scene), Integer.valueOf(this.mvi), Long.valueOf(this.mvj), Boolean.valueOf(this.mvk) });
      AppMethodBeat.o(48228);
      return;
    }
  }
  
  public QualitySession(String paramString, AppBrandInitConfigWC paramAppBrandInitConfigWC, AppBrandStatObject paramAppBrandStatObject)
  {
    AppMethodBeat.i(48226);
    this.mvj = 0L;
    this.mvk = false;
    this.lEv = paramString;
    this.appId = paramAppBrandInitConfigWC.appId;
    switch (paramAppBrandInitConfigWC.dPf)
    {
    }
    for (;;)
    {
      this.apptype = (paramAppBrandInitConfigWC.cmr + 1000);
      this.scene = paramAppBrandStatObject.scene;
      this.mvi = paramAppBrandInitConfigWC.aDD;
      ad.i("MicroMsg.AppBrand.QualitySession", "primary <init> instanceId[%s] apptype[%d] scene[%d] appversion[%d]", new Object[] { this.lEv, Integer.valueOf(this.apptype), Integer.valueOf(this.scene), Integer.valueOf(this.mvi) });
      AppMethodBeat.o(48226);
      return;
      this.mtG = 1;
      continue;
      this.mtG = 2;
      continue;
      this.mtG = 3;
    }
  }
  
  public int describeContents()
  {
    return 0;
  }
  
  public void writeToParcel(Parcel paramParcel, int paramInt)
  {
    AppMethodBeat.i(48227);
    paramParcel.writeString(this.lEv);
    paramParcel.writeString(this.appId);
    paramParcel.writeInt(this.mtG);
    paramParcel.writeInt(this.apptype);
    paramParcel.writeInt(this.scene);
    paramParcel.writeInt(this.mvi);
    paramParcel.writeLong(this.mvj);
    if (this.mvk) {}
    for (paramInt = 1;; paramInt = 0)
    {
      paramParcel.writeByte((byte)paramInt);
      AppMethodBeat.o(48227);
      return;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.report.quality.QualitySession
 * JD-Core Version:    0.7.0.1
 */