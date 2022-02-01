package com.tencent.mm.plugin.appbrand.report.quality;

import android.os.Parcel;
import android.os.Parcelable;
import android.os.Parcelable.Creator;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.appbrand.config.AppBrandInitConfigWC;
import com.tencent.mm.plugin.appbrand.report.AppBrandStatObject;
import com.tencent.mm.sdk.platformtools.ae;

public class QualitySession
  implements Parcelable
{
  public static final Parcelable.Creator<QualitySession> CREATOR;
  public String appId;
  public int apptype;
  public final String lIU;
  public int mAf;
  public long mAg;
  public boolean mAh;
  public int myD;
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
    this.mAg = 0L;
    this.mAh = false;
    this.lIU = paramParcel.readString();
    this.appId = paramParcel.readString();
    this.myD = paramParcel.readInt();
    this.apptype = paramParcel.readInt();
    this.scene = paramParcel.readInt();
    this.mAf = paramParcel.readInt();
    this.mAg = paramParcel.readLong();
    if (paramParcel.readByte() > 0) {}
    for (boolean bool = true;; bool = false)
    {
      this.mAh = bool;
      ae.i("MicroMsg.AppBrand.QualitySession", "secondary <init> instanceId[%s] apptype[%d] scene[%d] appversion[%d] UIReadyT[%d] isNewUser[%b]", new Object[] { this.lIU, Integer.valueOf(this.apptype), Integer.valueOf(this.scene), Integer.valueOf(this.mAf), Long.valueOf(this.mAg), Boolean.valueOf(this.mAh) });
      AppMethodBeat.o(48228);
      return;
    }
  }
  
  public QualitySession(String paramString, AppBrandInitConfigWC paramAppBrandInitConfigWC, AppBrandStatObject paramAppBrandStatObject)
  {
    AppMethodBeat.i(48226);
    this.mAg = 0L;
    this.mAh = false;
    this.lIU = paramString;
    this.appId = paramAppBrandInitConfigWC.appId;
    switch (paramAppBrandInitConfigWC.dQv)
    {
    }
    for (;;)
    {
      this.apptype = (paramAppBrandInitConfigWC.cmt + 1000);
      this.scene = paramAppBrandStatObject.scene;
      this.mAf = paramAppBrandInitConfigWC.aDD;
      ae.i("MicroMsg.AppBrand.QualitySession", "primary <init> instanceId[%s] apptype[%d] scene[%d] appversion[%d]", new Object[] { this.lIU, Integer.valueOf(this.apptype), Integer.valueOf(this.scene), Integer.valueOf(this.mAf) });
      AppMethodBeat.o(48226);
      return;
      this.myD = 1;
      continue;
      this.myD = 2;
      continue;
      this.myD = 3;
    }
  }
  
  public int describeContents()
  {
    return 0;
  }
  
  public void writeToParcel(Parcel paramParcel, int paramInt)
  {
    AppMethodBeat.i(48227);
    paramParcel.writeString(this.lIU);
    paramParcel.writeString(this.appId);
    paramParcel.writeInt(this.myD);
    paramParcel.writeInt(this.apptype);
    paramParcel.writeInt(this.scene);
    paramParcel.writeInt(this.mAf);
    paramParcel.writeLong(this.mAg);
    if (this.mAh) {}
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