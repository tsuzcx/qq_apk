package com.tencent.mm.plugin.appbrand.config;

import android.os.Parcel;
import android.os.Parcelable;
import android.os.Parcelable.Creator;
import android.os.PersistableBundle;
import com.tencent.luggage.sdk.config.AppBrandInitConfigLU;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.appbrand.page.web_renderingcache.WebRenderingCacheDirectoryDescriptor;
import com.tencent.mm.plugin.appbrand.report.quality.QualitySession;

public class AppBrandInitConfigWC
  extends AppBrandInitConfigLU
  implements Parcelable
{
  public static final Parcelable.Creator<AppBrandInitConfigWC> CREATOR;
  public String iJl;
  public String iJm;
  public AppBrandLaunchFromNotifyReferrer iJn;
  public boolean jdl;
  public long jdm;
  public String jdn;
  public PersistableBundle jdo;
  public String jdp;
  public String jdq;
  public String jdr;
  public boolean jds;
  public WebRenderingCacheDirectoryDescriptor jdt;
  public volatile QualitySession jdu;
  public transient int jdv;
  public boolean jdw;
  public int jdx;
  public String jdy;
  public int launchMode;
  
  static
  {
    AppMethodBeat.i(44843);
    CREATOR = new Parcelable.Creator() {};
    AppMethodBeat.o(44843);
  }
  
  public AppBrandInitConfigWC()
  {
    AppMethodBeat.i(44834);
    this.jdo = new PersistableBundle();
    this.jds = false;
    AppMethodBeat.o(44834);
  }
  
  protected AppBrandInitConfigWC(Parcel paramParcel)
  {
    super(paramParcel);
    AppMethodBeat.i(44839);
    this.jdo = new PersistableBundle();
    this.jds = false;
    if (paramParcel.readByte() != 0)
    {
      bool1 = true;
      this.jdl = bool1;
      if (paramParcel.readByte() == 0) {
        break label222;
      }
      bool1 = true;
      label51:
      this.jdw = bool1;
      this.jdx = paramParcel.readInt();
      this.jdm = paramParcel.readLong();
      this.jdn = paramParcel.readString();
      this.jdu = ((QualitySession)paramParcel.readParcelable(QualitySession.class.getClassLoader()));
      this.jdp = paramParcel.readString();
      this.jdo = paramParcel.readPersistableBundle(AppBrandInitConfigWC.class.getClassLoader());
      this.jdq = paramParcel.readString();
      if (paramParcel.readByte() <= 0) {
        break label227;
      }
    }
    label222:
    label227:
    for (boolean bool1 = bool2;; bool1 = false)
    {
      this.jds = bool1;
      this.jdr = paramParcel.readString();
      this.jdt = ((WebRenderingCacheDirectoryDescriptor)paramParcel.readParcelable(WebRenderingCacheDirectoryDescriptor.class.getClassLoader()));
      this.iJl = paramParcel.readString();
      this.launchMode = paramParcel.readInt();
      this.iJm = paramParcel.readString();
      this.iJn = ((AppBrandLaunchFromNotifyReferrer)paramParcel.readParcelable(AppBrandLaunchFromNotifyReferrer.class.getClassLoader()));
      this.jdy = paramParcel.readString();
      AppMethodBeat.o(44839);
      return;
      bool1 = false;
      break;
      bool1 = false;
      break label51;
    }
  }
  
  private AppBrandInitConfigWC aTz()
  {
    AppMethodBeat.i(44836);
    Parcel localParcel = aTw();
    AppBrandInitConfigWC localAppBrandInitConfigWC = new AppBrandInitConfigWC(localParcel);
    localParcel.recycle();
    AppMethodBeat.o(44836);
    return localAppBrandInitConfigWC;
  }
  
  public final boolean CZ()
  {
    return this.cfd == 4;
  }
  
  public final Parcel aTw()
  {
    AppMethodBeat.i(44837);
    Parcel localParcel = Parcel.obtain();
    localParcel.setDataPosition(0);
    writeToParcel(localParcel, 0);
    localParcel.setDataPosition(0);
    AppMethodBeat.o(44837);
    return localParcel;
  }
  
  public String toString()
  {
    AppMethodBeat.i(44835);
    String str = "AppBrandInitConfigWC {visitingSessionId='" + this.cfb + '\'' + ", username='" + this.username + '\'' + ", appId='" + this.appId + '\'' + ", brandName='" + this.dfM + '\'' + ", debugType=" + this.iOP + ", uin=" + this.uin + ", isPluginApp=" + this.jdl + ", isAdContact=" + this.jdw + ", performanceValue=" + this.jdx + ", orientation='" + this.jbC + '\'' + ", enterPath='" + this.iJb + '\'' + ", shareName='" + this.cff + '\'' + ", shareKey='" + this.cfh + '\'' + ", startTime=" + this.startTime + ", attrsFromCgi=" + this.cfn + ", referrer=" + this.cfi + ", extInfo=" + this.extInfo + ", appVersion=" + this.aAS + ", launchMode=" + this.launchMode + "， triggerServiceName" + this.jdr + '}';
    AppMethodBeat.o(44835);
    return str;
  }
  
  public void writeToParcel(Parcel paramParcel, int paramInt)
  {
    int i = 1;
    AppMethodBeat.i(44838);
    super.writeToParcel(paramParcel, paramInt);
    byte b;
    if (this.jdl)
    {
      b = 1;
      paramParcel.writeByte(b);
      if (!this.jdw) {
        break label184;
      }
      b = 1;
      label38:
      paramParcel.writeByte(b);
      paramParcel.writeInt(this.jdx);
      paramParcel.writeLong(this.jdm);
      paramParcel.writeString(this.jdn);
      paramParcel.writeParcelable(this.jdu, paramInt);
      paramParcel.writeString(this.jdp);
      paramParcel.writePersistableBundle(this.jdo);
      paramParcel.writeString(this.jdq);
      if (!this.jds) {
        break label189;
      }
    }
    for (;;)
    {
      paramParcel.writeByte((byte)i);
      paramParcel.writeString(this.jdr);
      paramParcel.writeParcelable(this.jdt, paramInt);
      paramParcel.writeString(this.iJl);
      paramParcel.writeInt(this.launchMode);
      paramParcel.writeString(this.iJm);
      paramParcel.writeParcelable(this.iJn, paramInt);
      paramParcel.writeString(this.jdy);
      AppMethodBeat.o(44838);
      return;
      b = 0;
      break;
      label184:
      b = 0;
      break label38;
      label189:
      i = 0;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.config.AppBrandInitConfigWC
 * JD-Core Version:    0.7.0.1
 */