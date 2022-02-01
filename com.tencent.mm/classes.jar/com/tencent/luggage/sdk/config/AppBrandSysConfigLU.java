package com.tencent.luggage.sdk.config;

import android.os.Parcel;
import android.os.Parcelable;
import android.os.Parcelable.Creator;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.appbrand.appcache.WxaPkgWrappingInfo;
import com.tencent.mm.plugin.appbrand.config.AppBrandGlobalSystemConfig;
import com.tencent.mm.plugin.appbrand.config.WxaAttributes.WxaPluginCodeInfo;
import com.tencent.mm.plugin.appbrand.config.k;
import com.tencent.mm.plugin.appbrand.jsapi.j;
import com.tencent.mm.plugin.appbrand.permission.AppRuntimeApiPermissionBundle;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class AppBrandSysConfigLU
  extends k
  implements Parcelable, j
{
  public static final Parcelable.Creator<AppBrandSysConfigLU> CREATOR;
  public int cfA;
  public int cfB;
  public int cfC;
  public boolean cfD;
  public boolean cfE;
  public long cfF;
  public int cfG;
  public ArrayList<String> cfH;
  public ArrayList<String> cfI;
  public ArrayList<String> cfJ;
  public ArrayList<String> cfK;
  public ArrayList<String> cfL;
  public boolean cfM;
  public int cfN;
  public int cfO;
  public int cfP;
  public long cfQ;
  public AppBrandGlobalSystemConfig cfR;
  public String[] cfS;
  public long cfT;
  public int cfU;
  public List<WxaAttributes.WxaPluginCodeInfo> cfV;
  public boolean cfe;
  public String cfp;
  public boolean cfq;
  public boolean cfr;
  @Deprecated
  public boolean cfs;
  public boolean cft;
  public AppRuntimeApiPermissionBundle cfu;
  public HashMap<String, AppRuntimeApiPermissionBundle> cfv;
  public String cfw;
  public int cfx;
  public int cfy;
  public int cfz;
  
  static
  {
    AppMethodBeat.i(146709);
    CREATOR = new Parcelable.Creator() {};
    AppMethodBeat.o(146709);
  }
  
  public AppBrandSysConfigLU()
  {
    AppMethodBeat.i(146705);
    this.cfq = false;
    this.cfr = false;
    this.cfs = false;
    this.cft = false;
    this.cfe = false;
    this.cfQ = 0L;
    this.cfS = new String[0];
    AppMethodBeat.o(146705);
  }
  
  protected AppBrandSysConfigLU(Parcel paramParcel)
  {
    AppMethodBeat.i(146708);
    this.cfq = false;
    this.cfr = false;
    this.cfs = false;
    this.cft = false;
    this.cfe = false;
    this.cfQ = 0L;
    this.cfS = new String[0];
    this.dfM = paramParcel.readString();
    this.cfp = paramParcel.readString();
    this.appId = paramParcel.readString();
    this.hGe = paramParcel.readString();
    if (paramParcel.readByte() != 0)
    {
      bool1 = true;
      this.cfq = bool1;
      if (paramParcel.readByte() == 0) {
        break label533;
      }
      bool1 = true;
      label104:
      this.cfr = bool1;
      if (paramParcel.readByte() == 0) {
        break label538;
      }
      bool1 = true;
      label118:
      this.cfs = bool1;
      this.cfu = ((AppRuntimeApiPermissionBundle)paramParcel.readParcelable(AppRuntimeApiPermissionBundle.class.getClassLoader()));
      this.jdL = paramParcel.readInt();
      this.cfx = paramParcel.readInt();
      this.cfy = paramParcel.readInt();
      this.cfz = paramParcel.readInt();
      this.cfA = paramParcel.readInt();
      this.cfB = paramParcel.readInt();
      this.cfC = paramParcel.readInt();
      if (paramParcel.readByte() == 0) {
        break label543;
      }
      bool1 = true;
      label204:
      this.cfD = bool1;
      if (paramParcel.readByte() == 0) {
        break label548;
      }
      bool1 = true;
      label218:
      this.cfE = bool1;
      this.cfF = paramParcel.readLong();
      this.cfG = paramParcel.readInt();
      this.cfH = paramParcel.createStringArrayList();
      this.cfI = paramParcel.createStringArrayList();
      this.cfJ = paramParcel.createStringArrayList();
      this.cfK = paramParcel.createStringArrayList();
      this.cfL = paramParcel.createStringArrayList();
      this.jdS = ((WxaPkgWrappingInfo)paramParcel.readParcelable(WxaPkgWrappingInfo.class.getClassLoader()));
      this.cfR = ((AppBrandGlobalSystemConfig)paramParcel.readParcelable(AppBrandGlobalSystemConfig.class.getClassLoader()));
      if (paramParcel.readByte() <= 0) {
        break label553;
      }
      bool1 = true;
      label320:
      this.jdM = bool1;
      if (paramParcel.readByte() <= 0) {
        break label558;
      }
      bool1 = true;
      label334:
      this.jdN = bool1;
      this.jdQ = paramParcel.readInt();
      this.jdR = paramParcel.readInt();
      this.cfN = paramParcel.readInt();
      if (paramParcel.readInt() != 1) {
        break label563;
      }
      bool1 = true;
      label373:
      this.cfM = bool1;
      this.cfQ = paramParcel.readLong();
      this.cfw = paramParcel.readString();
      this.cfS = new String[paramParcel.readInt()];
      paramParcel.readStringArray(this.cfS);
      this.cfO = paramParcel.readInt();
      this.cfP = paramParcel.readInt();
      this.jdT = paramParcel.readInt();
      if (paramParcel.readInt() != 1) {
        break label568;
      }
      bool1 = true;
      label447:
      this.jdU = bool1;
      if (paramParcel.readInt() != 1) {
        break label573;
      }
      bool1 = true;
      label462:
      this.jdO = bool1;
      if (paramParcel.readInt() != 1) {
        break label578;
      }
    }
    label533:
    label538:
    label543:
    label548:
    label553:
    label558:
    label563:
    label568:
    label573:
    label578:
    for (boolean bool1 = bool2;; bool1 = false)
    {
      this.jdP = bool1;
      this.cfT = paramParcel.readLong();
      this.cfV = paramParcel.createTypedArrayList(WxaAttributes.WxaPluginCodeInfo.CREATOR);
      this.cfU = paramParcel.readInt();
      this.cfv = paramParcel.readHashMap(AppRuntimeApiPermissionBundle.class.getClassLoader());
      AppMethodBeat.o(146708);
      return;
      bool1 = false;
      break;
      bool1 = false;
      break label104;
      bool1 = false;
      break label118;
      bool1 = false;
      break label204;
      bool1 = false;
      break label218;
      bool1 = false;
      break label320;
      bool1 = false;
      break label334;
      bool1 = false;
      break label373;
      bool1 = false;
      break label447;
      bool1 = false;
      break label462;
    }
  }
  
  public int describeContents()
  {
    return 0;
  }
  
  public String toString()
  {
    AppMethodBeat.i(146706);
    StringBuilder localStringBuilder = new StringBuilder("AppBrandSysConfigLU{, brandName='").append(this.dfM).append('\'').append(", appId='").append(this.appId).append('\'').append(", appIconUrl='").append(this.hGe).append('\'').append(", debugEnabled=").append(this.cfq).append(", performancePanelEnabled=").append(this.cfr).append(", maxWebViewDepth=").append(this.jdL).append(", maxBackgroundLifeSpan=").append(this.cfx).append(", maxRequestConcurrent=").append(this.cfy).append(", maxUploadConcurrent=").append(this.cfz).append(", maxDownloadConcurrent=").append(this.cfA).append(", maxWebsocketConnect=").append(this.cfB).append(", websocketSkipPortCheck=").append(this.cfD).append(", requestDomains=").append(this.cfH).append(", socketDomains=").append(this.cfI).append(", uploadDomains=").append(this.cfJ).append(", downloadDomains=").append(this.cfK).append(", downloadDomains=").append(this.cfL).append(", appPkgInfo=").append(this.jdS).append(", systemSettings=").append(this.cfR).append(", runningFlag=").append(this.cfT).append(", operationInfo=").append(this.cfw).append(", kvStorageScheme=").append(this.jdT).append(", TLSSkipHostnameCheck=").append(this.cfE).append(", kvStoragePerformanceReportOn=").append(this.jdU).append(", pluginPermissionBundleMap=");
    if (this.cfv == null) {}
    for (String str = "0";; str = String.valueOf(this.cfv.size()))
    {
      str = str + '}';
      AppMethodBeat.o(146706);
      return str;
    }
  }
  
  public void writeToParcel(Parcel paramParcel, int paramInt)
  {
    int i = 1;
    AppMethodBeat.i(146707);
    paramParcel.writeString(this.dfM);
    paramParcel.writeString(this.cfp);
    paramParcel.writeString(this.appId);
    paramParcel.writeString(this.hGe);
    byte b;
    if (this.cfq)
    {
      b = 1;
      paramParcel.writeByte(b);
      if (!this.cfr) {
        break label460;
      }
      b = 1;
      label64:
      paramParcel.writeByte(b);
      if (!this.cfs) {
        break label465;
      }
      b = 1;
      label78:
      paramParcel.writeByte(b);
      paramParcel.writeParcelable(this.cfu, paramInt);
      paramParcel.writeInt(this.jdL);
      paramParcel.writeInt(this.cfx);
      paramParcel.writeInt(this.cfy);
      paramParcel.writeInt(this.cfz);
      paramParcel.writeInt(this.cfA);
      paramParcel.writeInt(this.cfB);
      paramParcel.writeInt(this.cfC);
      if (!this.cfD) {
        break label470;
      }
      b = 1;
      label157:
      paramParcel.writeByte(b);
      if (!this.cfE) {
        break label475;
      }
      b = 1;
      label171:
      paramParcel.writeByte(b);
      paramParcel.writeLong(this.cfF);
      paramParcel.writeInt(this.cfG);
      paramParcel.writeStringList(this.cfH);
      paramParcel.writeStringList(this.cfI);
      paramParcel.writeStringList(this.cfJ);
      paramParcel.writeStringList(this.cfK);
      paramParcel.writeStringList(this.cfL);
      paramParcel.writeParcelable(this.jdS, paramInt);
      paramParcel.writeParcelable(this.cfR, paramInt);
      if (!this.jdM) {
        break label480;
      }
      b = 1;
      label259:
      paramParcel.writeByte(b);
      if (!this.jdN) {
        break label485;
      }
      b = 1;
      label273:
      paramParcel.writeByte(b);
      paramParcel.writeInt(this.jdQ);
      paramParcel.writeInt(this.jdR);
      paramParcel.writeInt(this.cfN);
      if (!this.cfM) {
        break label490;
      }
      paramInt = 1;
      label311:
      paramParcel.writeInt(paramInt);
      paramParcel.writeLong(this.cfQ);
      paramParcel.writeString(this.cfw);
      paramParcel.writeInt(this.cfS.length);
      paramParcel.writeStringArray(this.cfS);
      paramParcel.writeInt(this.cfO);
      paramParcel.writeInt(this.cfP);
      paramParcel.writeInt(this.jdT);
      if (!this.jdU) {
        break label495;
      }
      paramInt = 1;
      label382:
      paramParcel.writeInt(paramInt);
      if (!this.jdO) {
        break label500;
      }
      paramInt = 1;
      label396:
      paramParcel.writeInt(paramInt);
      if (!this.jdP) {
        break label505;
      }
    }
    label460:
    label465:
    label470:
    label475:
    label480:
    label485:
    label490:
    label495:
    label500:
    label505:
    for (paramInt = i;; paramInt = 0)
    {
      paramParcel.writeInt(paramInt);
      paramParcel.writeLong(this.cfT);
      paramParcel.writeTypedList(this.cfV);
      paramParcel.writeInt(this.cfU);
      paramParcel.writeMap(this.cfv);
      AppMethodBeat.o(146707);
      return;
      b = 0;
      break;
      b = 0;
      break label64;
      b = 0;
      break label78;
      b = 0;
      break label157;
      b = 0;
      break label171;
      b = 0;
      break label259;
      b = 0;
      break label273;
      paramInt = 0;
      break label311;
      paramInt = 0;
      break label382;
      paramInt = 0;
      break label396;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.luggage.sdk.config.AppBrandSysConfigLU
 * JD-Core Version:    0.7.0.1
 */