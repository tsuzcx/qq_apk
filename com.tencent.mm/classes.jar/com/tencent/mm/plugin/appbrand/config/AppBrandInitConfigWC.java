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
  public String fWY;
  public int launchMode;
  public int lyw;
  public String nBA;
  public AppBrandLaunchFromNotifyReferrer nBB;
  public List<String> nBD;
  public HalfScreenConfig nBE;
  public boolean nBF;
  public ParcelableMultiTaskData nBI;
  public String nBJ;
  public boolean nYb;
  public long nYc;
  public String nYd;
  public PersistableBundle nYe;
  public String nYf;
  public String nYg;
  public String nYh;
  public boolean nYi;
  public WebRenderingCacheDirectoryDescriptor nYj;
  public volatile QualitySession nYk;
  public transient int nYl;
  public boolean nYm;
  public int nYn;
  public String nYo;
  public int nYp;
  public int nYq;
  public boolean nYr;
  public WeAppOpenDeclarePromptBundle nYs;
  public AppBrandRuntimeReloadReportBundle nYt;
  public boolean nYu;
  public WeAppOpenUICallbackIPCProxy nYv;
  public boolean nYw;
  
  static
  {
    AppMethodBeat.i(44843);
    CREATOR = new AppBrandInitConfigWC.1();
    AppMethodBeat.o(44843);
  }
  
  public AppBrandInitConfigWC()
  {
    AppMethodBeat.i(44834);
    this.nYe = new PersistableBundle();
    this.nYi = false;
    this.nYr = false;
    this.nBE = HalfScreenConfig.nZJ;
    this.nBD = new ArrayList();
    this.nBJ = "";
    this.nYu = false;
    this.nBF = false;
    this.nYw = false;
    this.nBI = null;
    AppMethodBeat.o(44834);
  }
  
  protected AppBrandInitConfigWC(Parcel paramParcel)
  {
    super(paramParcel);
    AppMethodBeat.i(44839);
    this.nYe = new PersistableBundle();
    this.nYi = false;
    this.nYr = false;
    this.nBE = HalfScreenConfig.nZJ;
    this.nBD = new ArrayList();
    this.nBJ = "";
    this.nYu = false;
    this.nBF = false;
    this.nYw = false;
    this.nBI = null;
    if (paramParcel.readByte() != 0)
    {
      bool1 = true;
      this.nYb = bool1;
      if (paramParcel.readByte() == 0) {
        break label465;
      }
      bool1 = true;
      label100:
      this.nYm = bool1;
      this.nYn = paramParcel.readInt();
      this.nYc = paramParcel.readLong();
      this.nYd = paramParcel.readString();
      this.nYk = ((QualitySession)paramParcel.readParcelable(QualitySession.class.getClassLoader()));
      this.nYf = paramParcel.readString();
      this.nYe = paramParcel.readPersistableBundle(AppBrandInitConfigWC.class.getClassLoader());
      this.nYg = paramParcel.readString();
      if (paramParcel.readByte() <= 0) {
        break label470;
      }
      bool1 = true;
      label183:
      this.nYi = bool1;
      this.nYh = paramParcel.readString();
      this.nYj = ((WebRenderingCacheDirectoryDescriptor)paramParcel.readParcelable(WebRenderingCacheDirectoryDescriptor.class.getClassLoader()));
      this.fWY = paramParcel.readString();
      this.launchMode = paramParcel.readInt();
      this.nBA = paramParcel.readString();
      this.nBB = ((AppBrandLaunchFromNotifyReferrer)paramParcel.readParcelable(AppBrandLaunchFromNotifyReferrer.class.getClassLoader()));
      this.nYo = paramParcel.readString();
      this.nYp = paramParcel.readInt();
      this.nYq = paramParcel.readInt();
      if (paramParcel.readByte() <= 0) {
        break label475;
      }
      bool1 = true;
      label285:
      this.nYr = bool1;
      this.nYs = ((WeAppOpenDeclarePromptBundle)paramParcel.readParcelable(WeAppOpenDeclarePromptBundle.class.getClassLoader()));
      this.nYt = ((AppBrandRuntimeReloadReportBundle)paramParcel.readParcelable(AppBrandRuntimeReloadReportBundle.class.getClassLoader()));
      paramParcel.readStringList(this.nBD);
      HalfScreenConfig localHalfScreenConfig2 = (HalfScreenConfig)paramParcel.readParcelable(HalfScreenConfig.class.getClassLoader());
      HalfScreenConfig localHalfScreenConfig1 = localHalfScreenConfig2;
      if (localHalfScreenConfig2 == null) {
        localHalfScreenConfig1 = HalfScreenConfig.nZJ;
      }
      this.nBE = localHalfScreenConfig1;
      if (paramParcel.readByte() <= 0) {
        break label480;
      }
      bool1 = true;
      label373:
      this.nYu = bool1;
      if (paramParcel.readByte() <= 0) {
        break label485;
      }
      bool1 = true;
      label387:
      this.nBF = bool1;
      this.nYv = ((WeAppOpenUICallbackIPCProxy)paramParcel.readParcelable(WeAppOpenUICallbackIPCProxy.class.getClassLoader()));
      if (paramParcel.readByte() <= 0) {
        break label490;
      }
    }
    label465:
    label470:
    label475:
    label480:
    label485:
    label490:
    for (boolean bool1 = bool2;; bool1 = false)
    {
      this.nYw = bool1;
      this.nBJ = paramParcel.readString();
      this.nBI = ((ParcelableMultiTaskData)paramParcel.readParcelable(ParcelableMultiTaskData.class.getClassLoader()));
      this.lyw = paramParcel.readInt();
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
  
  public final boolean Qv()
  {
    return this.cwR == 4;
  }
  
  public final Parcel bLg()
  {
    AppMethodBeat.i(44837);
    Parcel localParcel = Parcel.obtain();
    localParcel.setDataPosition(0);
    writeToParcel(localParcel, 0);
    localParcel.setDataPosition(0);
    AppMethodBeat.o(44837);
    return localParcel;
  }
  
  public final AppBrandInitConfigWC bLj()
  {
    AppMethodBeat.i(44836);
    Parcel localParcel = bLg();
    AppBrandInitConfigWC localAppBrandInitConfigWC = new AppBrandInitConfigWC(localParcel);
    localParcel.recycle();
    AppMethodBeat.o(44836);
    return localAppBrandInitConfigWC;
  }
  
  public String toString()
  {
    AppMethodBeat.i(44835);
    String str = "AppBrandInitConfigWC {visitingSessionId='" + this.cwP + '\'' + ", username='" + this.username + '\'' + ", appId='" + this.appId + '\'' + ", brandName='" + this.fzM + '\'' + ", debugType=" + this.cBI + ", uin=" + p.getString(this.uin) + ", isPluginApp=" + this.nYb + ", isAdContact=" + this.nYm + ", performanceValue=" + this.nYn + ", orientation='" + this.cCi + '\'' + ", enterPath='" + this.nBq + '\'' + ", shareName='" + this.cwT + '\'' + ", shareKey='" + this.cwU + '\'' + ", startTime=" + this.startTime + ", attrsFromCgi=" + this.cxd + ", referrer=" + this.cwV + ", extInfo=" + this.extInfo + ", appVersion=" + this.appVersion + ", launchMode=" + this.launchMode + "， triggerServiceName=" + this.nYh + "， createdAsHalfScreen=" + this.nYu + ", halfScreenConfig=" + this.nBE + ", secFlagForSinglePageMode=" + this.lyw + '}';
    AppMethodBeat.o(44835);
    return str;
  }
  
  public void writeToParcel(Parcel paramParcel, int paramInt)
  {
    int j = 1;
    AppMethodBeat.i(44838);
    super.writeToParcel(paramParcel, paramInt);
    byte b;
    if (this.nYb)
    {
      b = 1;
      paramParcel.writeByte(b);
      if (!this.nYm) {
        break label341;
      }
      b = 1;
      label38:
      paramParcel.writeByte(b);
      paramParcel.writeInt(this.nYn);
      paramParcel.writeLong(this.nYc);
      paramParcel.writeString(this.nYd);
      paramParcel.writeParcelable(this.nYk, paramInt);
      paramParcel.writeString(this.nYf);
      paramParcel.writePersistableBundle(this.nYe);
      paramParcel.writeString(this.nYg);
      if (!this.nYi) {
        break label346;
      }
      i = 1;
      label110:
      paramParcel.writeByte((byte)i);
      paramParcel.writeString(this.nYh);
      paramParcel.writeParcelable(this.nYj, paramInt);
      paramParcel.writeString(this.fWY);
      paramParcel.writeInt(this.launchMode);
      paramParcel.writeString(this.nBA);
      paramParcel.writeParcelable(this.nBB, paramInt);
      paramParcel.writeString(this.nYo);
      paramParcel.writeInt(this.nYp);
      paramParcel.writeInt(this.nYq);
      if (!this.nYr) {
        break label352;
      }
      i = 1;
      label201:
      paramParcel.writeByte((byte)i);
      paramParcel.writeParcelable(this.nYs, paramInt);
      paramParcel.writeParcelable(this.nYt, paramInt);
      paramParcel.writeStringList(this.nBD);
      paramParcel.writeParcelable(this.nBE, paramInt);
      if (!this.nYu) {
        break label358;
      }
      i = 1;
      label253:
      paramParcel.writeByte((byte)i);
      if (!this.nBF) {
        break label364;
      }
      i = 1;
      label270:
      paramParcel.writeByte((byte)i);
      paramParcel.writeParcelable(this.nYv, paramInt);
      if (!this.nYw) {
        break label370;
      }
    }
    label341:
    label346:
    label352:
    label358:
    label364:
    label370:
    for (int i = j;; i = 0)
    {
      paramParcel.writeByte((byte)i);
      paramParcel.writeString(this.nBJ);
      paramParcel.writeParcelable(this.nBI, paramInt);
      paramParcel.writeInt(this.lyw);
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


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.config.AppBrandInitConfigWC
 * JD-Core Version:    0.7.0.1
 */