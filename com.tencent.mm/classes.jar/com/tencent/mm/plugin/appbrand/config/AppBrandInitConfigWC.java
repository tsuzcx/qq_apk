package com.tencent.mm.plugin.appbrand.config;

import android.os.Parcel;
import android.os.Parcelable;
import android.os.Parcelable.Creator;
import android.os.PersistableBundle;
import com.tencent.luggage.sdk.config.AppBrandInitConfigLU;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.b.p;
import com.tencent.mm.plugin.appbrand.api.ParcelableMultiTaskData;
import com.tencent.mm.plugin.appbrand.api.WeAppOpenDeclarePromptBundle;
import com.tencent.mm.plugin.appbrand.launching.WeAppOpenUICallbackIPCProxy;
import com.tencent.mm.plugin.appbrand.launching.report.AppBrandRuntimeReloadReportBundle;
import com.tencent.mm.plugin.appbrand.page.web_renderingcache.WebRenderingCacheDirectoryDescriptor;
import com.tencent.mm.plugin.appbrand.report.quality.QualitySession;
import java.util.ArrayList;
import java.util.List;

public class AppBrandInitConfigWC
  extends AppBrandInitConfigLU
  implements Parcelable
{
  public static final Parcelable.Creator<AppBrandInitConfigWC> CREATOR;
  public String kHG;
  public String kHH;
  public AppBrandLaunchFromNotifyReferrer kHI;
  public List<String> kHK;
  public HalfScreenConfig kHL;
  public boolean kHM;
  public ParcelableMultiTaskData kHP;
  public String kHQ;
  public int launchMode;
  public boolean ldN;
  public long ldO;
  public String ldP;
  public PersistableBundle ldQ;
  public String ldR;
  public String ldS;
  public String ldT;
  public boolean ldU;
  public WebRenderingCacheDirectoryDescriptor ldV;
  public volatile QualitySession ldW;
  public transient int ldX;
  public boolean ldY;
  public int ldZ;
  public String lea;
  public int leb;
  public int lec;
  public boolean led;
  public WeAppOpenDeclarePromptBundle lee;
  public AppBrandRuntimeReloadReportBundle lef;
  public boolean leg;
  public WeAppOpenUICallbackIPCProxy leh;
  public boolean lei;
  
  static
  {
    AppMethodBeat.i(44843);
    CREATOR = new Parcelable.Creator() {};
    AppMethodBeat.o(44843);
  }
  
  public AppBrandInitConfigWC()
  {
    AppMethodBeat.i(44834);
    this.ldQ = new PersistableBundle();
    this.ldU = false;
    this.led = false;
    this.kHL = HalfScreenConfig.lfr;
    this.kHK = new ArrayList();
    this.kHQ = "";
    this.leg = false;
    this.kHM = false;
    this.lei = false;
    this.kHP = null;
    AppMethodBeat.o(44834);
  }
  
  protected AppBrandInitConfigWC(Parcel paramParcel)
  {
    super(paramParcel);
    AppMethodBeat.i(44839);
    this.ldQ = new PersistableBundle();
    this.ldU = false;
    this.led = false;
    this.kHL = HalfScreenConfig.lfr;
    this.kHK = new ArrayList();
    this.kHQ = "";
    this.leg = false;
    this.kHM = false;
    this.lei = false;
    this.kHP = null;
    if (paramParcel.readByte() != 0)
    {
      bool1 = true;
      this.ldN = bool1;
      if (paramParcel.readByte() == 0) {
        break label457;
      }
      bool1 = true;
      label100:
      this.ldY = bool1;
      this.ldZ = paramParcel.readInt();
      this.ldO = paramParcel.readLong();
      this.ldP = paramParcel.readString();
      this.ldW = ((QualitySession)paramParcel.readParcelable(QualitySession.class.getClassLoader()));
      this.ldR = paramParcel.readString();
      this.ldQ = paramParcel.readPersistableBundle(AppBrandInitConfigWC.class.getClassLoader());
      this.ldS = paramParcel.readString();
      if (paramParcel.readByte() <= 0) {
        break label462;
      }
      bool1 = true;
      label183:
      this.ldU = bool1;
      this.ldT = paramParcel.readString();
      this.ldV = ((WebRenderingCacheDirectoryDescriptor)paramParcel.readParcelable(WebRenderingCacheDirectoryDescriptor.class.getClassLoader()));
      this.kHG = paramParcel.readString();
      this.launchMode = paramParcel.readInt();
      this.kHH = paramParcel.readString();
      this.kHI = ((AppBrandLaunchFromNotifyReferrer)paramParcel.readParcelable(AppBrandLaunchFromNotifyReferrer.class.getClassLoader()));
      this.lea = paramParcel.readString();
      this.leb = paramParcel.readInt();
      this.lec = paramParcel.readInt();
      if (paramParcel.readByte() <= 0) {
        break label467;
      }
      bool1 = true;
      label285:
      this.led = bool1;
      this.lee = ((WeAppOpenDeclarePromptBundle)paramParcel.readParcelable(WeAppOpenDeclarePromptBundle.class.getClassLoader()));
      this.lef = ((AppBrandRuntimeReloadReportBundle)paramParcel.readParcelable(AppBrandRuntimeReloadReportBundle.class.getClassLoader()));
      paramParcel.readStringList(this.kHK);
      HalfScreenConfig localHalfScreenConfig2 = (HalfScreenConfig)paramParcel.readParcelable(HalfScreenConfig.class.getClassLoader());
      HalfScreenConfig localHalfScreenConfig1 = localHalfScreenConfig2;
      if (localHalfScreenConfig2 == null) {
        localHalfScreenConfig1 = HalfScreenConfig.lfr;
      }
      this.kHL = localHalfScreenConfig1;
      if (paramParcel.readByte() <= 0) {
        break label472;
      }
      bool1 = true;
      label373:
      this.leg = bool1;
      if (paramParcel.readByte() <= 0) {
        break label477;
      }
      bool1 = true;
      label387:
      this.kHM = bool1;
      this.leh = ((WeAppOpenUICallbackIPCProxy)paramParcel.readParcelable(WeAppOpenUICallbackIPCProxy.class.getClassLoader()));
      if (paramParcel.readByte() <= 0) {
        break label482;
      }
    }
    label457:
    label462:
    label467:
    label472:
    label477:
    label482:
    for (boolean bool1 = bool2;; bool1 = false)
    {
      this.lei = bool1;
      this.kHQ = paramParcel.readString();
      this.kHP = ((ParcelableMultiTaskData)paramParcel.readParcelable(ParcelableMultiTaskData.class.getClassLoader()));
      AppMethodBeat.o(44839);
      return;
      bool1 = false;
      break;
      bool1 = false;
      break label100;
      bool1 = false;
      break label183;
      bool1 = false;
      break label285;
      bool1 = false;
      break label373;
      bool1 = false;
      break label387;
    }
  }
  
  public final boolean NA()
  {
    return this.cyo == 4;
  }
  
  public final Parcel bzR()
  {
    AppMethodBeat.i(44837);
    Parcel localParcel = Parcel.obtain();
    localParcel.setDataPosition(0);
    writeToParcel(localParcel, 0);
    localParcel.setDataPosition(0);
    AppMethodBeat.o(44837);
    return localParcel;
  }
  
  public final AppBrandInitConfigWC bzU()
  {
    AppMethodBeat.i(44836);
    Parcel localParcel = bzR();
    AppBrandInitConfigWC localAppBrandInitConfigWC = new AppBrandInitConfigWC(localParcel);
    localParcel.recycle();
    AppMethodBeat.o(44836);
    return localAppBrandInitConfigWC;
  }
  
  public String toString()
  {
    AppMethodBeat.i(44835);
    String str = "AppBrandInitConfigWC {visitingSessionId='" + this.cym + '\'' + ", username='" + this.username + '\'' + ", appId='" + this.appId + '\'' + ", brandName='" + this.brandName + '\'' + ", debugType=" + this.eix + ", uin=" + p.getString(this.uin) + ", isPluginApp=" + this.ldN + ", isAdContact=" + this.ldY + ", performanceValue=" + this.ldZ + ", orientation='" + this.cBG + '\'' + ", enterPath='" + this.kHw + '\'' + ", shareName='" + this.cyq + '\'' + ", shareKey='" + this.cyr + '\'' + ", startTime=" + this.startTime + ", attrsFromCgi=" + this.cyy + ", referrer=" + this.cys + ", extInfo=" + this.extInfo + ", appVersion=" + this.appVersion + ", launchMode=" + this.launchMode + "， triggerServiceName=" + this.ldT + "， createdAsHalfScreen=" + this.leg + ", halfScreenConfig=" + this.kHL + '}';
    AppMethodBeat.o(44835);
    return str;
  }
  
  public void writeToParcel(Parcel paramParcel, int paramInt)
  {
    int j = 1;
    AppMethodBeat.i(44838);
    super.writeToParcel(paramParcel, paramInt);
    byte b;
    if (this.ldN)
    {
      b = 1;
      paramParcel.writeByte(b);
      if (!this.ldY) {
        break label333;
      }
      b = 1;
      label38:
      paramParcel.writeByte(b);
      paramParcel.writeInt(this.ldZ);
      paramParcel.writeLong(this.ldO);
      paramParcel.writeString(this.ldP);
      paramParcel.writeParcelable(this.ldW, paramInt);
      paramParcel.writeString(this.ldR);
      paramParcel.writePersistableBundle(this.ldQ);
      paramParcel.writeString(this.ldS);
      if (!this.ldU) {
        break label338;
      }
      i = 1;
      label110:
      paramParcel.writeByte((byte)i);
      paramParcel.writeString(this.ldT);
      paramParcel.writeParcelable(this.ldV, paramInt);
      paramParcel.writeString(this.kHG);
      paramParcel.writeInt(this.launchMode);
      paramParcel.writeString(this.kHH);
      paramParcel.writeParcelable(this.kHI, paramInt);
      paramParcel.writeString(this.lea);
      paramParcel.writeInt(this.leb);
      paramParcel.writeInt(this.lec);
      if (!this.led) {
        break label344;
      }
      i = 1;
      label201:
      paramParcel.writeByte((byte)i);
      paramParcel.writeParcelable(this.lee, paramInt);
      paramParcel.writeParcelable(this.lef, paramInt);
      paramParcel.writeStringList(this.kHK);
      paramParcel.writeParcelable(this.kHL, paramInt);
      if (!this.leg) {
        break label350;
      }
      i = 1;
      label253:
      paramParcel.writeByte((byte)i);
      if (!this.kHM) {
        break label356;
      }
      i = 1;
      label270:
      paramParcel.writeByte((byte)i);
      paramParcel.writeParcelable(this.leh, paramInt);
      if (!this.lei) {
        break label362;
      }
    }
    label333:
    label338:
    label344:
    label350:
    label356:
    label362:
    for (int i = j;; i = 0)
    {
      paramParcel.writeByte((byte)i);
      paramParcel.writeString(this.kHQ);
      paramParcel.writeParcelable(this.kHP, paramInt);
      AppMethodBeat.o(44838);
      return;
      b = 0;
      break;
      b = 0;
      break label38;
      i = 0;
      break label110;
      i = 0;
      break label201;
      i = 0;
      break label253;
      i = 0;
      break label270;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.config.AppBrandInitConfigWC
 * JD-Core Version:    0.7.0.1
 */