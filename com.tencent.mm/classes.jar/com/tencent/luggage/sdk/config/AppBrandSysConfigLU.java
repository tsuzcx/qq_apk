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
  public boolean ccA;
  public boolean ccB;
  public long ccC;
  public int ccD;
  public ArrayList<String> ccE;
  public ArrayList<String> ccF;
  public ArrayList<String> ccG;
  public ArrayList<String> ccH;
  public ArrayList<String> ccI;
  public boolean ccJ;
  public int ccK;
  public int ccL;
  public int ccM;
  public long ccN;
  public AppBrandGlobalSystemConfig ccO;
  public String[] ccP;
  public long ccQ;
  public int ccR;
  public List<WxaAttributes.WxaPluginCodeInfo> ccS;
  public boolean ccb;
  public String ccm;
  public boolean ccn;
  public boolean cco;
  @Deprecated
  public boolean ccp;
  public boolean ccq;
  public AppRuntimeApiPermissionBundle ccr;
  public HashMap<String, AppRuntimeApiPermissionBundle> ccs;
  public String cct;
  public int ccu;
  public int ccv;
  public int ccw;
  public int ccx;
  public int ccy;
  public int ccz;
  
  static
  {
    AppMethodBeat.i(146709);
    CREATOR = new Parcelable.Creator() {};
    AppMethodBeat.o(146709);
  }
  
  public AppBrandSysConfigLU()
  {
    AppMethodBeat.i(146705);
    this.ccn = false;
    this.cco = false;
    this.ccp = false;
    this.ccq = false;
    this.ccb = false;
    this.ccN = 0L;
    this.ccP = new String[0];
    AppMethodBeat.o(146705);
  }
  
  protected AppBrandSysConfigLU(Parcel paramParcel)
  {
    AppMethodBeat.i(146708);
    this.ccn = false;
    this.cco = false;
    this.ccp = false;
    this.ccq = false;
    this.ccb = false;
    this.ccN = 0L;
    this.ccP = new String[0];
    this.ddh = paramParcel.readString();
    this.ccm = paramParcel.readString();
    this.appId = paramParcel.readString();
    this.igG = paramParcel.readString();
    if (paramParcel.readByte() != 0)
    {
      bool1 = true;
      this.ccn = bool1;
      if (paramParcel.readByte() == 0) {
        break label533;
      }
      bool1 = true;
      label104:
      this.cco = bool1;
      if (paramParcel.readByte() == 0) {
        break label538;
      }
      bool1 = true;
      label118:
      this.ccp = bool1;
      this.ccr = ((AppRuntimeApiPermissionBundle)paramParcel.readParcelable(AppRuntimeApiPermissionBundle.class.getClassLoader()));
      this.jDZ = paramParcel.readInt();
      this.ccu = paramParcel.readInt();
      this.ccv = paramParcel.readInt();
      this.ccw = paramParcel.readInt();
      this.ccx = paramParcel.readInt();
      this.ccy = paramParcel.readInt();
      this.ccz = paramParcel.readInt();
      if (paramParcel.readByte() == 0) {
        break label543;
      }
      bool1 = true;
      label204:
      this.ccA = bool1;
      if (paramParcel.readByte() == 0) {
        break label548;
      }
      bool1 = true;
      label218:
      this.ccB = bool1;
      this.ccC = paramParcel.readLong();
      this.ccD = paramParcel.readInt();
      this.ccE = paramParcel.createStringArrayList();
      this.ccF = paramParcel.createStringArrayList();
      this.ccG = paramParcel.createStringArrayList();
      this.ccH = paramParcel.createStringArrayList();
      this.ccI = paramParcel.createStringArrayList();
      this.jEg = ((WxaPkgWrappingInfo)paramParcel.readParcelable(WxaPkgWrappingInfo.class.getClassLoader()));
      this.ccO = ((AppBrandGlobalSystemConfig)paramParcel.readParcelable(AppBrandGlobalSystemConfig.class.getClassLoader()));
      if (paramParcel.readByte() <= 0) {
        break label553;
      }
      bool1 = true;
      label320:
      this.jEa = bool1;
      if (paramParcel.readByte() <= 0) {
        break label558;
      }
      bool1 = true;
      label334:
      this.jEb = bool1;
      this.jEe = paramParcel.readInt();
      this.jEf = paramParcel.readInt();
      this.ccK = paramParcel.readInt();
      if (paramParcel.readInt() != 1) {
        break label563;
      }
      bool1 = true;
      label373:
      this.ccJ = bool1;
      this.ccN = paramParcel.readLong();
      this.cct = paramParcel.readString();
      this.ccP = new String[paramParcel.readInt()];
      paramParcel.readStringArray(this.ccP);
      this.ccL = paramParcel.readInt();
      this.ccM = paramParcel.readInt();
      this.jEh = paramParcel.readInt();
      if (paramParcel.readInt() != 1) {
        break label568;
      }
      bool1 = true;
      label447:
      this.jEi = bool1;
      if (paramParcel.readInt() != 1) {
        break label573;
      }
      bool1 = true;
      label462:
      this.jEc = bool1;
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
      this.jEd = bool1;
      this.ccQ = paramParcel.readLong();
      this.ccS = paramParcel.createTypedArrayList(WxaAttributes.WxaPluginCodeInfo.CREATOR);
      this.ccR = paramParcel.readInt();
      this.ccs = paramParcel.readHashMap(AppRuntimeApiPermissionBundle.class.getClassLoader());
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
    StringBuilder localStringBuilder = new StringBuilder("AppBrandSysConfigLU{, brandName='").append(this.ddh).append('\'').append(", appId='").append(this.appId).append('\'').append(", appIconUrl='").append(this.igG).append('\'').append(", debugEnabled=").append(this.ccn).append(", performancePanelEnabled=").append(this.cco).append(", maxWebViewDepth=").append(this.jDZ).append(", maxBackgroundLifeSpan=").append(this.ccu).append(", maxRequestConcurrent=").append(this.ccv).append(", maxUploadConcurrent=").append(this.ccw).append(", maxDownloadConcurrent=").append(this.ccx).append(", maxWebsocketConnect=").append(this.ccy).append(", websocketSkipPortCheck=").append(this.ccA).append(", requestDomains=").append(this.ccE).append(", socketDomains=").append(this.ccF).append(", uploadDomains=").append(this.ccG).append(", downloadDomains=").append(this.ccH).append(", downloadDomains=").append(this.ccI).append(", appPkgInfo=").append(this.jEg).append(", systemSettings=").append(this.ccO).append(", runningFlag=").append(this.ccQ).append(", operationInfo=").append(this.cct).append(", kvStorageScheme=").append(this.jEh).append(", TLSSkipHostnameCheck=").append(this.ccB).append(", kvStoragePerformanceReportOn=").append(this.jEi).append(", pluginPermissionBundleMap=");
    if (this.ccs == null) {}
    for (String str = "0";; str = String.valueOf(this.ccs.size()))
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
    paramParcel.writeString(this.ddh);
    paramParcel.writeString(this.ccm);
    paramParcel.writeString(this.appId);
    paramParcel.writeString(this.igG);
    byte b;
    if (this.ccn)
    {
      b = 1;
      paramParcel.writeByte(b);
      if (!this.cco) {
        break label460;
      }
      b = 1;
      label64:
      paramParcel.writeByte(b);
      if (!this.ccp) {
        break label465;
      }
      b = 1;
      label78:
      paramParcel.writeByte(b);
      paramParcel.writeParcelable(this.ccr, paramInt);
      paramParcel.writeInt(this.jDZ);
      paramParcel.writeInt(this.ccu);
      paramParcel.writeInt(this.ccv);
      paramParcel.writeInt(this.ccw);
      paramParcel.writeInt(this.ccx);
      paramParcel.writeInt(this.ccy);
      paramParcel.writeInt(this.ccz);
      if (!this.ccA) {
        break label470;
      }
      b = 1;
      label157:
      paramParcel.writeByte(b);
      if (!this.ccB) {
        break label475;
      }
      b = 1;
      label171:
      paramParcel.writeByte(b);
      paramParcel.writeLong(this.ccC);
      paramParcel.writeInt(this.ccD);
      paramParcel.writeStringList(this.ccE);
      paramParcel.writeStringList(this.ccF);
      paramParcel.writeStringList(this.ccG);
      paramParcel.writeStringList(this.ccH);
      paramParcel.writeStringList(this.ccI);
      paramParcel.writeParcelable(this.jEg, paramInt);
      paramParcel.writeParcelable(this.ccO, paramInt);
      if (!this.jEa) {
        break label480;
      }
      b = 1;
      label259:
      paramParcel.writeByte(b);
      if (!this.jEb) {
        break label485;
      }
      b = 1;
      label273:
      paramParcel.writeByte(b);
      paramParcel.writeInt(this.jEe);
      paramParcel.writeInt(this.jEf);
      paramParcel.writeInt(this.ccK);
      if (!this.ccJ) {
        break label490;
      }
      paramInt = 1;
      label311:
      paramParcel.writeInt(paramInt);
      paramParcel.writeLong(this.ccN);
      paramParcel.writeString(this.cct);
      paramParcel.writeInt(this.ccP.length);
      paramParcel.writeStringArray(this.ccP);
      paramParcel.writeInt(this.ccL);
      paramParcel.writeInt(this.ccM);
      paramParcel.writeInt(this.jEh);
      if (!this.jEi) {
        break label495;
      }
      paramInt = 1;
      label382:
      paramParcel.writeInt(paramInt);
      if (!this.jEc) {
        break label500;
      }
      paramInt = 1;
      label396:
      paramParcel.writeInt(paramInt);
      if (!this.jEd) {
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
      paramParcel.writeLong(this.ccQ);
      paramParcel.writeTypedList(this.ccS);
      paramParcel.writeInt(this.ccR);
      paramParcel.writeMap(this.ccs);
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


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.luggage.sdk.config.AppBrandSysConfigLU
 * JD-Core Version:    0.7.0.1
 */