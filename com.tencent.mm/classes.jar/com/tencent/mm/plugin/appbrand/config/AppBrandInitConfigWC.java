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
  public String icX;
  public int launchMode;
  public int nOX;
  public int opX;
  public String qAP;
  public AppBrandLaunchFromNotifyReferrer qAQ;
  public List<String> qAS;
  public HalfScreenConfig qAT;
  public ParcelableMultiTaskData qAW;
  public String qAX;
  public String qBa;
  public boolean qYd;
  public long qYe;
  public String qYf;
  public PersistableBundle qYg;
  public String qYh;
  public String qYi;
  public String qYj;
  public boolean qYk;
  public WebRenderingCacheDirectoryDescriptor qYl;
  public volatile QualitySession qYm;
  public transient int qYn;
  public boolean qYo;
  public int qYp;
  public String qYq;
  public int qYr;
  public boolean qYs;
  public WeAppOpenDeclarePromptBundle qYt;
  public AppBrandRuntimeReloadReportBundle qYu;
  public boolean qYv;
  public WeAppOpenUICallbackIPCProxy qYw;
  public boolean qYx;
  public String qYy;
  
  static
  {
    AppMethodBeat.i(44843);
    CREATOR = new Parcelable.Creator() {};
    AppMethodBeat.o(44843);
  }
  
  public AppBrandInitConfigWC()
  {
    AppMethodBeat.i(44834);
    this.qYg = new PersistableBundle();
    this.qYk = false;
    this.qYs = false;
    this.qAT = HalfScreenConfig.rad;
    this.qAS = new ArrayList();
    this.qAX = "";
    this.qYv = false;
    this.qYx = false;
    this.qAW = null;
    this.qYy = "";
    this.qBa = "";
    AppMethodBeat.o(44834);
  }
  
  protected AppBrandInitConfigWC(Parcel paramParcel)
  {
    super(paramParcel);
    AppMethodBeat.i(44839);
    this.qYg = new PersistableBundle();
    this.qYk = false;
    this.qYs = false;
    this.qAT = HalfScreenConfig.rad;
    this.qAS = new ArrayList();
    this.qAX = "";
    this.qYv = false;
    this.qYx = false;
    this.qAW = null;
    this.qYy = "";
    this.qBa = "";
    if (paramParcel.readByte() != 0)
    {
      bool1 = true;
      this.qYd = bool1;
      if (paramParcel.readByte() == 0) {
        break label474;
      }
      bool1 = true;
      label107:
      this.qYo = bool1;
      this.qYp = paramParcel.readInt();
      this.qYe = paramParcel.readLong();
      this.qYf = paramParcel.readString();
      this.qYm = ((QualitySession)paramParcel.readParcelable(QualitySession.class.getClassLoader()));
      this.qYh = paramParcel.readString();
      this.qYg = paramParcel.readPersistableBundle(AppBrandInitConfigWC.class.getClassLoader());
      this.qYi = paramParcel.readString();
      if (paramParcel.readByte() <= 0) {
        break label479;
      }
      bool1 = true;
      label190:
      this.qYk = bool1;
      this.qYj = paramParcel.readString();
      this.qYl = ((WebRenderingCacheDirectoryDescriptor)paramParcel.readParcelable(WebRenderingCacheDirectoryDescriptor.class.getClassLoader()));
      this.icX = paramParcel.readString();
      this.launchMode = paramParcel.readInt();
      this.qAP = paramParcel.readString();
      this.qAQ = ((AppBrandLaunchFromNotifyReferrer)paramParcel.readParcelable(AppBrandLaunchFromNotifyReferrer.class.getClassLoader()));
      this.qYq = paramParcel.readString();
      this.nOX = paramParcel.readInt();
      this.qYr = paramParcel.readInt();
      if (paramParcel.readByte() <= 0) {
        break label484;
      }
      bool1 = true;
      label292:
      this.qYs = bool1;
      this.qYt = ((WeAppOpenDeclarePromptBundle)paramParcel.readParcelable(WeAppOpenDeclarePromptBundle.class.getClassLoader()));
      this.qYu = ((AppBrandRuntimeReloadReportBundle)paramParcel.readParcelable(AppBrandRuntimeReloadReportBundle.class.getClassLoader()));
      paramParcel.readStringList(this.qAS);
      HalfScreenConfig localHalfScreenConfig2 = (HalfScreenConfig)paramParcel.readParcelable(HalfScreenConfig.class.getClassLoader());
      HalfScreenConfig localHalfScreenConfig1 = localHalfScreenConfig2;
      if (localHalfScreenConfig2 == null) {
        localHalfScreenConfig1 = HalfScreenConfig.rad;
      }
      this.qAT = localHalfScreenConfig1;
      if (paramParcel.readByte() <= 0) {
        break label489;
      }
      bool1 = true;
      label380:
      this.qYv = bool1;
      this.qYw = ((WeAppOpenUICallbackIPCProxy)paramParcel.readParcelable(WeAppOpenUICallbackIPCProxy.class.getClassLoader()));
      if (paramParcel.readByte() <= 0) {
        break label494;
      }
    }
    label474:
    label479:
    label484:
    label489:
    label494:
    for (boolean bool1 = bool2;; bool1 = false)
    {
      this.qYx = bool1;
      this.qAX = paramParcel.readString();
      this.qAW = ((ParcelableMultiTaskData)paramParcel.readParcelable(ParcelableMultiTaskData.class.getClassLoader()));
      this.opX = paramParcel.readInt();
      this.qYy = paramParcel.readString();
      this.qBa = paramParcel.readString();
      AppMethodBeat.o(44839);
      return;
      bool1 = false;
      break;
      bool1 = false;
      break label107;
      bool1 = false;
      break label190;
      bool1 = false;
      break label292;
      bool1 = false;
      break label380;
    }
  }
  
  public final boolean aqJ()
  {
    return this.appServiceType == 4;
  }
  
  public final Parcel ckF()
  {
    AppMethodBeat.i(44837);
    Parcel localParcel = Parcel.obtain();
    localParcel.setDataPosition(0);
    writeToParcel(localParcel, 0);
    localParcel.setDataPosition(0);
    AppMethodBeat.o(44837);
    return localParcel;
  }
  
  public final AppBrandInitConfigWC ckH()
  {
    AppMethodBeat.i(44836);
    Parcel localParcel = ckF();
    AppBrandInitConfigWC localAppBrandInitConfigWC = new AppBrandInitConfigWC(localParcel);
    localParcel.recycle();
    AppMethodBeat.o(44836);
    return localAppBrandInitConfigWC;
  }
  
  public String toString()
  {
    AppMethodBeat.i(44835);
    String str = "AppBrandInitConfigWC {visitingSessionId='" + this.eoP + '\'' + ", wxaLaunchInstanceId=" + this.eoQ + ", clickTimestamp=" + this.startTime + ", username='" + this.username + '\'' + ", appId='" + this.appId + '\'' + ", brandName='" + this.hEy + '\'' + ", debugType=" + this.eul + ", uin=" + p.getString(this.uin) + ", isPluginApp=" + this.qYd + ", isAdContact=" + this.qYo + ", performanceValue=" + this.qYp + ", orientation='" + this.euP + '\'' + ", enterPath='" + this.qAF + '\'' + ", shareName='" + this.eoT + '\'' + ", shareKey='" + this.eoU + '\'' + ", startTime=" + this.startTime + ", attrsFromCgi=" + this.epl + ", referrer=" + this.eoV + ", extInfo=" + this.extInfo + ", appVersion=" + this.appVersion + ", launchMode=" + this.launchMode + "， triggerServiceName=" + this.qYj + "， createdAsHalfScreen=" + this.qYv + ", halfScreenConfig=" + this.qAT + ", secFlagForSinglePageMode=" + this.opX + ", showRelievedBuyFlag=" + this.nOX + '}';
    AppMethodBeat.o(44835);
    return str;
  }
  
  public void writeToParcel(Parcel paramParcel, int paramInt)
  {
    int j = 1;
    AppMethodBeat.i(44838);
    super.writeToParcel(paramParcel, paramInt);
    byte b;
    if (this.qYd)
    {
      b = 1;
      paramParcel.writeByte(b);
      if (!this.qYo) {
        break label340;
      }
      b = 1;
      label38:
      paramParcel.writeByte(b);
      paramParcel.writeInt(this.qYp);
      paramParcel.writeLong(this.qYe);
      paramParcel.writeString(this.qYf);
      paramParcel.writeParcelable(this.qYm, paramInt);
      paramParcel.writeString(this.qYh);
      paramParcel.writePersistableBundle(this.qYg);
      paramParcel.writeString(this.qYi);
      if (!this.qYk) {
        break label345;
      }
      i = 1;
      label110:
      paramParcel.writeByte((byte)i);
      paramParcel.writeString(this.qYj);
      paramParcel.writeParcelable(this.qYl, paramInt);
      paramParcel.writeString(this.icX);
      paramParcel.writeInt(this.launchMode);
      paramParcel.writeString(this.qAP);
      paramParcel.writeParcelable(this.qAQ, paramInt);
      paramParcel.writeString(this.qYq);
      paramParcel.writeInt(this.nOX);
      paramParcel.writeInt(this.qYr);
      if (!this.qYs) {
        break label351;
      }
      i = 1;
      label201:
      paramParcel.writeByte((byte)i);
      paramParcel.writeParcelable(this.qYt, paramInt);
      paramParcel.writeParcelable(this.qYu, paramInt);
      paramParcel.writeStringList(this.qAS);
      paramParcel.writeParcelable(this.qAT, paramInt);
      if (!this.qYv) {
        break label357;
      }
      i = 1;
      label253:
      paramParcel.writeByte((byte)i);
      paramParcel.writeParcelable(this.qYw, paramInt);
      if (!this.qYx) {
        break label363;
      }
    }
    label340:
    label345:
    label351:
    label357:
    label363:
    for (int i = j;; i = 0)
    {
      paramParcel.writeByte((byte)i);
      paramParcel.writeString(this.qAX);
      paramParcel.writeParcelable(this.qAW, paramInt);
      paramParcel.writeInt(this.opX);
      paramParcel.writeString(this.qYy);
      paramParcel.writeString(this.qBa);
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
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.config.AppBrandInitConfigWC
 * JD-Core Version:    0.7.0.1
 */