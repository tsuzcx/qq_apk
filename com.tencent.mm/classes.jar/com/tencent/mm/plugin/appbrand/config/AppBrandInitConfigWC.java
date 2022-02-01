package com.tencent.mm.plugin.appbrand.config;

import android.os.Parcel;
import android.os.Parcelable;
import android.os.Parcelable.Creator;
import android.os.PersistableBundle;
import com.tencent.luggage.sdk.config.AppBrandInitConfigLU;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.appbrand.api.WeAppOpenDeclarePromptBundle;
import com.tencent.mm.plugin.appbrand.launching.report.AppBrandRuntimeReloadReportBundle;
import com.tencent.mm.plugin.appbrand.page.web_renderingcache.WebRenderingCacheDirectoryDescriptor;
import com.tencent.mm.plugin.appbrand.report.quality.QualitySession;

public class AppBrandInitConfigWC
  extends AppBrandInitConfigLU
  implements Parcelable
{
  public static final Parcelable.Creator<AppBrandInitConfigWC> CREATOR;
  public String jFV;
  public String jFW;
  public AppBrandLaunchFromNotifyReferrer jFX;
  public boolean kaJ;
  public long kaK;
  public String kaL;
  public PersistableBundle kaM;
  public String kaN;
  public String kaO;
  public String kaP;
  public boolean kaQ;
  public WebRenderingCacheDirectoryDescriptor kaR;
  public volatile QualitySession kaS;
  public transient int kaT;
  public boolean kaU;
  public int kaV;
  public String kaW;
  public int kaX;
  public int kaY;
  public boolean kaZ;
  public WeAppOpenDeclarePromptBundle kba;
  public AppBrandRuntimeReloadReportBundle kbb;
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
    this.kaM = new PersistableBundle();
    this.kaQ = false;
    this.kaZ = false;
    AppMethodBeat.o(44834);
  }
  
  protected AppBrandInitConfigWC(Parcel paramParcel)
  {
    super(paramParcel);
    AppMethodBeat.i(44839);
    this.kaM = new PersistableBundle();
    this.kaQ = false;
    this.kaZ = false;
    if (paramParcel.readByte() != 0)
    {
      bool1 = true;
      this.kaJ = bool1;
      if (paramParcel.readByte() == 0) {
        break label289;
      }
      bool1 = true;
      label56:
      this.kaU = bool1;
      this.kaV = paramParcel.readInt();
      this.kaK = paramParcel.readLong();
      this.kaL = paramParcel.readString();
      this.kaS = ((QualitySession)paramParcel.readParcelable(QualitySession.class.getClassLoader()));
      this.kaN = paramParcel.readString();
      this.kaM = paramParcel.readPersistableBundle(AppBrandInitConfigWC.class.getClassLoader());
      this.kaO = paramParcel.readString();
      if (paramParcel.readByte() <= 0) {
        break label294;
      }
      bool1 = true;
      label139:
      this.kaQ = bool1;
      this.kaP = paramParcel.readString();
      this.kaR = ((WebRenderingCacheDirectoryDescriptor)paramParcel.readParcelable(WebRenderingCacheDirectoryDescriptor.class.getClassLoader()));
      this.jFV = paramParcel.readString();
      this.launchMode = paramParcel.readInt();
      this.jFW = paramParcel.readString();
      this.jFX = ((AppBrandLaunchFromNotifyReferrer)paramParcel.readParcelable(AppBrandLaunchFromNotifyReferrer.class.getClassLoader()));
      this.kaW = paramParcel.readString();
      this.kaX = paramParcel.readInt();
      this.kaY = paramParcel.readInt();
      if (paramParcel.readByte() <= 0) {
        break label299;
      }
    }
    label289:
    label294:
    label299:
    for (boolean bool1 = bool2;; bool1 = false)
    {
      this.kaZ = bool1;
      this.kba = ((WeAppOpenDeclarePromptBundle)paramParcel.readParcelable(WeAppOpenDeclarePromptBundle.class.getClassLoader()));
      this.kbb = ((AppBrandRuntimeReloadReportBundle)paramParcel.readParcelable(AppBrandRuntimeReloadReportBundle.class.getClassLoader()));
      AppMethodBeat.o(44839);
      return;
      bool1 = false;
      break;
      bool1 = false;
      break label56;
      bool1 = false;
      break label139;
    }
  }
  
  private AppBrandInitConfigWC beD()
  {
    AppMethodBeat.i(44836);
    Parcel localParcel = beA();
    AppBrandInitConfigWC localAppBrandInitConfigWC = new AppBrandInitConfigWC(localParcel);
    localParcel.recycle();
    AppMethodBeat.o(44836);
    return localAppBrandInitConfigWC;
  }
  
  public final boolean Ee()
  {
    return this.cmt == 4;
  }
  
  public final Parcel beA()
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
    String str = "AppBrandInitConfigWC {visitingSessionId='" + this.cmr + '\'' + ", username='" + this.username + '\'' + ", appId='" + this.appId + '\'' + ", brandName='" + this.dpI + '\'' + ", debugType=" + this.dQv + ", uin=" + this.uin + ", isPluginApp=" + this.kaJ + ", isAdContact=" + this.kaU + ", performanceValue=" + this.kaV + ", orientation='" + this.cpm + '\'' + ", enterPath='" + this.jFL + '\'' + ", shareName='" + this.cmv + '\'' + ", shareKey='" + this.cmw + '\'' + ", startTime=" + this.startTime + ", attrsFromCgi=" + this.cmD + ", referrer=" + this.cmx + ", extInfo=" + this.extInfo + ", appVersion=" + this.aDD + ", launchMode=" + this.launchMode + "， triggerServiceName" + this.kaP + '}';
    AppMethodBeat.o(44835);
    return str;
  }
  
  public void writeToParcel(Parcel paramParcel, int paramInt)
  {
    int j = 1;
    AppMethodBeat.i(44838);
    super.writeToParcel(paramParcel, paramInt);
    byte b;
    if (this.kaJ)
    {
      b = 1;
      paramParcel.writeByte(b);
      if (!this.kaU) {
        break label239;
      }
      b = 1;
      label38:
      paramParcel.writeByte(b);
      paramParcel.writeInt(this.kaV);
      paramParcel.writeLong(this.kaK);
      paramParcel.writeString(this.kaL);
      paramParcel.writeParcelable(this.kaS, paramInt);
      paramParcel.writeString(this.kaN);
      paramParcel.writePersistableBundle(this.kaM);
      paramParcel.writeString(this.kaO);
      if (!this.kaQ) {
        break label244;
      }
      i = 1;
      label110:
      paramParcel.writeByte((byte)i);
      paramParcel.writeString(this.kaP);
      paramParcel.writeParcelable(this.kaR, paramInt);
      paramParcel.writeString(this.jFV);
      paramParcel.writeInt(this.launchMode);
      paramParcel.writeString(this.jFW);
      paramParcel.writeParcelable(this.jFX, paramInt);
      paramParcel.writeString(this.kaW);
      paramParcel.writeInt(this.kaX);
      paramParcel.writeInt(this.kaY);
      if (!this.kaZ) {
        break label250;
      }
    }
    label239:
    label244:
    label250:
    for (int i = j;; i = 0)
    {
      paramParcel.writeByte((byte)i);
      paramParcel.writeParcelable(this.kba, paramInt);
      paramParcel.writeParcelable(this.kbb, paramInt);
      AppMethodBeat.o(44838);
      return;
      b = 0;
      break;
      b = 0;
      break label38;
      i = 0;
      break label110;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.config.AppBrandInitConfigWC
 * JD-Core Version:    0.7.0.1
 */