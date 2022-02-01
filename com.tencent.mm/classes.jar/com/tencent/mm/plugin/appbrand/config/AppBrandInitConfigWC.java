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
  public String jCX;
  public String jCY;
  public AppBrandLaunchFromNotifyReferrer jCZ;
  public String jXA;
  public boolean jXB;
  public WebRenderingCacheDirectoryDescriptor jXC;
  public volatile QualitySession jXD;
  public transient int jXE;
  public boolean jXF;
  public int jXG;
  public String jXH;
  public int jXI;
  public int jXJ;
  public boolean jXK;
  public WeAppOpenDeclarePromptBundle jXL;
  public AppBrandRuntimeReloadReportBundle jXM;
  public boolean jXu;
  public long jXv;
  public String jXw;
  public PersistableBundle jXx;
  public String jXy;
  public String jXz;
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
    this.jXx = new PersistableBundle();
    this.jXB = false;
    this.jXK = false;
    AppMethodBeat.o(44834);
  }
  
  protected AppBrandInitConfigWC(Parcel paramParcel)
  {
    super(paramParcel);
    AppMethodBeat.i(44839);
    this.jXx = new PersistableBundle();
    this.jXB = false;
    this.jXK = false;
    if (paramParcel.readByte() != 0)
    {
      bool1 = true;
      this.jXu = bool1;
      if (paramParcel.readByte() == 0) {
        break label289;
      }
      bool1 = true;
      label56:
      this.jXF = bool1;
      this.jXG = paramParcel.readInt();
      this.jXv = paramParcel.readLong();
      this.jXw = paramParcel.readString();
      this.jXD = ((QualitySession)paramParcel.readParcelable(QualitySession.class.getClassLoader()));
      this.jXy = paramParcel.readString();
      this.jXx = paramParcel.readPersistableBundle(AppBrandInitConfigWC.class.getClassLoader());
      this.jXz = paramParcel.readString();
      if (paramParcel.readByte() <= 0) {
        break label294;
      }
      bool1 = true;
      label139:
      this.jXB = bool1;
      this.jXA = paramParcel.readString();
      this.jXC = ((WebRenderingCacheDirectoryDescriptor)paramParcel.readParcelable(WebRenderingCacheDirectoryDescriptor.class.getClassLoader()));
      this.jCX = paramParcel.readString();
      this.launchMode = paramParcel.readInt();
      this.jCY = paramParcel.readString();
      this.jCZ = ((AppBrandLaunchFromNotifyReferrer)paramParcel.readParcelable(AppBrandLaunchFromNotifyReferrer.class.getClassLoader()));
      this.jXH = paramParcel.readString();
      this.jXI = paramParcel.readInt();
      this.jXJ = paramParcel.readInt();
      if (paramParcel.readByte() <= 0) {
        break label299;
      }
    }
    label289:
    label294:
    label299:
    for (boolean bool1 = bool2;; bool1 = false)
    {
      this.jXK = bool1;
      this.jXL = ((WeAppOpenDeclarePromptBundle)paramParcel.readParcelable(WeAppOpenDeclarePromptBundle.class.getClassLoader()));
      this.jXM = ((AppBrandRuntimeReloadReportBundle)paramParcel.readParcelable(AppBrandRuntimeReloadReportBundle.class.getClassLoader()));
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
  
  private AppBrandInitConfigWC bdX()
  {
    AppMethodBeat.i(44836);
    Parcel localParcel = bdU();
    AppBrandInitConfigWC localAppBrandInitConfigWC = new AppBrandInitConfigWC(localParcel);
    localParcel.recycle();
    AppMethodBeat.o(44836);
    return localAppBrandInitConfigWC;
  }
  
  public final boolean Eb()
  {
    return this.cmr == 4;
  }
  
  public final Parcel bdU()
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
    String str = "AppBrandInitConfigWC {visitingSessionId='" + this.cmp + '\'' + ", username='" + this.username + '\'' + ", appId='" + this.appId + '\'' + ", brandName='" + this.doD + '\'' + ", debugType=" + this.dPf + ", uin=" + this.uin + ", isPluginApp=" + this.jXu + ", isAdContact=" + this.jXF + ", performanceValue=" + this.jXG + ", orientation='" + this.jVL + '\'' + ", enterPath='" + this.jCN + '\'' + ", shareName='" + this.cmt + '\'' + ", shareKey='" + this.cmu + '\'' + ", startTime=" + this.startTime + ", attrsFromCgi=" + this.cmB + ", referrer=" + this.cmv + ", extInfo=" + this.extInfo + ", appVersion=" + this.aDD + ", launchMode=" + this.launchMode + "， triggerServiceName" + this.jXA + '}';
    AppMethodBeat.o(44835);
    return str;
  }
  
  public void writeToParcel(Parcel paramParcel, int paramInt)
  {
    int j = 1;
    AppMethodBeat.i(44838);
    super.writeToParcel(paramParcel, paramInt);
    byte b;
    if (this.jXu)
    {
      b = 1;
      paramParcel.writeByte(b);
      if (!this.jXF) {
        break label239;
      }
      b = 1;
      label38:
      paramParcel.writeByte(b);
      paramParcel.writeInt(this.jXG);
      paramParcel.writeLong(this.jXv);
      paramParcel.writeString(this.jXw);
      paramParcel.writeParcelable(this.jXD, paramInt);
      paramParcel.writeString(this.jXy);
      paramParcel.writePersistableBundle(this.jXx);
      paramParcel.writeString(this.jXz);
      if (!this.jXB) {
        break label244;
      }
      i = 1;
      label110:
      paramParcel.writeByte((byte)i);
      paramParcel.writeString(this.jXA);
      paramParcel.writeParcelable(this.jXC, paramInt);
      paramParcel.writeString(this.jCX);
      paramParcel.writeInt(this.launchMode);
      paramParcel.writeString(this.jCY);
      paramParcel.writeParcelable(this.jCZ, paramInt);
      paramParcel.writeString(this.jXH);
      paramParcel.writeInt(this.jXI);
      paramParcel.writeInt(this.jXJ);
      if (!this.jXK) {
        break label250;
      }
    }
    label239:
    label244:
    label250:
    for (int i = j;; i = 0)
    {
      paramParcel.writeByte((byte)i);
      paramParcel.writeParcelable(this.jXL, paramInt);
      paramParcel.writeParcelable(this.jXM, paramInt);
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