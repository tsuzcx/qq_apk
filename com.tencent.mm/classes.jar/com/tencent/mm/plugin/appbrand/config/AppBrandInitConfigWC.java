package com.tencent.mm.plugin.appbrand.config;

import android.os.Parcel;
import android.os.Parcelable;
import android.os.Parcelable.Creator;
import com.tencent.luggage.sdk.config.AppBrandInitConfigLU;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.appbrand.report.quality.QualitySession;

public class AppBrandInitConfigWC
  extends AppBrandInitConfigLU
  implements Parcelable
{
  public static final Parcelable.Creator<AppBrandInitConfigWC> CREATOR;
  public transient boolean hiC;
  public boolean hiD;
  public long hiE;
  public String hiF;
  public String hiG;
  public boolean hiH;
  public volatile QualitySession hiI;
  public transient int hiJ;
  
  static
  {
    AppMethodBeat.i(129841);
    CREATOR = new AppBrandInitConfigWC.1();
    AppMethodBeat.o(129841);
  }
  
  AppBrandInitConfigWC()
  {
    this.hiH = false;
  }
  
  protected AppBrandInitConfigWC(Parcel paramParcel)
  {
    super(paramParcel);
    AppMethodBeat.i(129838);
    this.hiH = false;
    if (paramParcel.readByte() != 0)
    {
      bool1 = true;
      this.hiD = bool1;
      this.hiE = paramParcel.readLong();
      this.hiI = ((QualitySession)paramParcel.readParcelable(QualitySession.class.getClassLoader()));
      this.hiF = paramParcel.readString();
      this.hiG = paramParcel.readString();
      if (paramParcel.readByte() <= 0) {
        break label96;
      }
    }
    label96:
    for (boolean bool1 = bool2;; bool1 = false)
    {
      this.hiH = bool1;
      AppMethodBeat.o(129838);
      return;
      bool1 = false;
      break;
    }
  }
  
  private AppBrandInitConfigWC ayw()
  {
    AppMethodBeat.i(129835);
    Parcel localParcel = ayu();
    AppBrandInitConfigWC localAppBrandInitConfigWC = new AppBrandInitConfigWC(localParcel);
    localParcel.recycle();
    AppMethodBeat.o(129835);
    return localAppBrandInitConfigWC;
  }
  
  public final Parcel ayu()
  {
    AppMethodBeat.i(129836);
    Parcel localParcel = Parcel.obtain();
    localParcel.setDataPosition(0);
    writeToParcel(localParcel, 0);
    localParcel.setDataPosition(0);
    AppMethodBeat.o(129836);
    return localParcel;
  }
  
  public String toString()
  {
    AppMethodBeat.i(129834);
    String str = "AppBrandInitConfigWC {visitingSessionId='" + this.bCU + '\'' + ", username='" + this.username + '\'' + ", appId='" + this.appId + '\'' + ", brandName='" + this.cqQ + '\'' + ", debugType=" + this.gXd + ", isPluginApp=" + this.hiD + ", preferRunInTools=" + this.hiC + ", orientation='" + this.hha + '\'' + ", enterPath='" + this.hiw + '\'' + ", shareName='" + this.bCY + '\'' + ", shareKey='" + this.bCZ + '\'' + ", startTime=" + this.startTime + ", attrsFromCgi=" + this.bDg + ", referrer=" + this.hiz + ", extInfo=" + this.extInfo + ", appVersion=" + this.bDc + ", loadingImgUrl=" + this.hiF + ", loadingImgrProgressbarColor" + this.hiG + '}';
    AppMethodBeat.o(129834);
    return str;
  }
  
  public final boolean vY()
  {
    return this.bCV == 4;
  }
  
  public void writeToParcel(Parcel paramParcel, int paramInt)
  {
    int i = 1;
    AppMethodBeat.i(129837);
    super.writeToParcel(paramParcel, paramInt);
    byte b;
    if (this.hiD)
    {
      b = 1;
      paramParcel.writeByte(b);
      paramParcel.writeLong(this.hiE);
      paramParcel.writeParcelable(this.hiI, paramInt);
      paramParcel.writeString(this.hiF);
      paramParcel.writeString(this.hiG);
      if (!this.hiH) {
        break label88;
      }
    }
    label88:
    for (paramInt = i;; paramInt = 0)
    {
      paramParcel.writeByte((byte)paramInt);
      AppMethodBeat.o(129837);
      return;
      b = 0;
      break;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.config.AppBrandInitConfigWC
 * JD-Core Version:    0.7.0.1
 */