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
  public String cmD;
  public boolean cmE;
  public boolean cmF;
  @Deprecated
  public boolean cmG;
  public boolean cmH;
  public AppRuntimeApiPermissionBundle cmI;
  public HashMap<String, AppRuntimeApiPermissionBundle> cmJ;
  public String cmK;
  public int cmL;
  public int cmM;
  public int cmN;
  public int cmO;
  public int cmP;
  public int cmQ;
  public boolean cmR;
  public boolean cmS;
  public long cmT;
  public int cmU;
  public ArrayList<String> cmV;
  public ArrayList<String> cmW;
  public ArrayList<String> cmX;
  public ArrayList<String> cmY;
  public ArrayList<String> cmZ;
  public boolean cms;
  public boolean cna;
  public int cnb;
  public int cnc;
  public int cnd;
  public long cne;
  public AppBrandGlobalSystemConfig cnf;
  public String[] cng;
  public long cnh;
  public List<WxaAttributes.WxaPluginCodeInfo> cni;
  
  static
  {
    AppMethodBeat.i(146709);
    CREATOR = new Parcelable.Creator() {};
    AppMethodBeat.o(146709);
  }
  
  public AppBrandSysConfigLU()
  {
    AppMethodBeat.i(146705);
    this.cmE = false;
    this.cmF = false;
    this.cmG = false;
    this.cmH = false;
    this.cms = false;
    this.cne = 0L;
    this.cng = new String[0];
    AppMethodBeat.o(146705);
  }
  
  protected AppBrandSysConfigLU(Parcel paramParcel)
  {
    AppMethodBeat.i(146708);
    this.cmE = false;
    this.cmF = false;
    this.cmG = false;
    this.cmH = false;
    this.cms = false;
    this.cne = 0L;
    this.cng = new String[0];
    this.doD = paramParcel.readString();
    this.cmD = paramParcel.readString();
    this.appId = paramParcel.readString();
    this.iAa = paramParcel.readString();
    if (paramParcel.readByte() != 0)
    {
      bool1 = true;
      this.cmE = bool1;
      if (paramParcel.readByte() == 0) {
        break label525;
      }
      bool1 = true;
      label104:
      this.cmF = bool1;
      if (paramParcel.readByte() == 0) {
        break label530;
      }
      bool1 = true;
      label118:
      this.cmG = bool1;
      this.cmI = ((AppRuntimeApiPermissionBundle)paramParcel.readParcelable(AppRuntimeApiPermissionBundle.class.getClassLoader()));
      this.jYa = paramParcel.readInt();
      this.cmL = paramParcel.readInt();
      this.cmM = paramParcel.readInt();
      this.cmN = paramParcel.readInt();
      this.cmO = paramParcel.readInt();
      this.cmP = paramParcel.readInt();
      this.cmQ = paramParcel.readInt();
      if (paramParcel.readByte() == 0) {
        break label535;
      }
      bool1 = true;
      label204:
      this.cmR = bool1;
      if (paramParcel.readByte() == 0) {
        break label540;
      }
      bool1 = true;
      label218:
      this.cmS = bool1;
      this.cmT = paramParcel.readLong();
      this.cmU = paramParcel.readInt();
      this.cmV = paramParcel.createStringArrayList();
      this.cmW = paramParcel.createStringArrayList();
      this.cmX = paramParcel.createStringArrayList();
      this.cmY = paramParcel.createStringArrayList();
      this.cmZ = paramParcel.createStringArrayList();
      this.jYh = ((WxaPkgWrappingInfo)paramParcel.readParcelable(WxaPkgWrappingInfo.class.getClassLoader()));
      this.cnf = ((AppBrandGlobalSystemConfig)paramParcel.readParcelable(AppBrandGlobalSystemConfig.class.getClassLoader()));
      if (paramParcel.readByte() <= 0) {
        break label545;
      }
      bool1 = true;
      label320:
      this.jYb = bool1;
      if (paramParcel.readByte() <= 0) {
        break label550;
      }
      bool1 = true;
      label334:
      this.jYc = bool1;
      this.jYf = paramParcel.readInt();
      this.jYg = paramParcel.readInt();
      this.cnb = paramParcel.readInt();
      if (paramParcel.readInt() != 1) {
        break label555;
      }
      bool1 = true;
      label373:
      this.cna = bool1;
      this.cne = paramParcel.readLong();
      this.cmK = paramParcel.readString();
      this.cng = new String[paramParcel.readInt()];
      paramParcel.readStringArray(this.cng);
      this.cnc = paramParcel.readInt();
      this.cnd = paramParcel.readInt();
      this.jYi = paramParcel.readInt();
      if (paramParcel.readInt() != 1) {
        break label560;
      }
      bool1 = true;
      label447:
      this.jYj = bool1;
      if (paramParcel.readInt() != 1) {
        break label565;
      }
      bool1 = true;
      label462:
      this.jYd = bool1;
      if (paramParcel.readInt() != 1) {
        break label570;
      }
    }
    label525:
    label530:
    label535:
    label540:
    label545:
    label550:
    label555:
    label560:
    label565:
    label570:
    for (boolean bool1 = bool2;; bool1 = false)
    {
      this.jYe = bool1;
      this.cnh = paramParcel.readLong();
      this.cni = paramParcel.createTypedArrayList(WxaAttributes.WxaPluginCodeInfo.CREATOR);
      this.cmJ = paramParcel.readHashMap(AppRuntimeApiPermissionBundle.class.getClassLoader());
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
    StringBuilder localStringBuilder = new StringBuilder("AppBrandSysConfigLU{, brandName='").append(this.doD).append('\'').append(", appId='").append(this.appId).append('\'').append(", appIconUrl='").append(this.iAa).append('\'').append(", debugEnabled=").append(this.cmE).append(", performancePanelEnabled=").append(this.cmF).append(", maxWebViewDepth=").append(this.jYa).append(", maxBackgroundLifeSpan=").append(this.cmL).append(", maxRequestConcurrent=").append(this.cmM).append(", maxUploadConcurrent=").append(this.cmN).append(", maxDownloadConcurrent=").append(this.cmO).append(", maxWebsocketConnect=").append(this.cmP).append(", websocketSkipPortCheck=").append(this.cmR).append(", requestDomains=").append(this.cmV).append(", socketDomains=").append(this.cmW).append(", uploadDomains=").append(this.cmX).append(", downloadDomains=").append(this.cmY).append(", downloadDomains=").append(this.cmZ).append(", appPkgInfo=").append(this.jYh).append(", systemSettings=").append(this.cnf).append(", runningFlag=").append(this.cnh).append(", operationInfo=").append(this.cmK).append(", kvStorageScheme=").append(this.jYi).append(", TLSSkipHostnameCheck=").append(this.cmS).append(", kvStoragePerformanceReportOn=").append(this.jYj).append(", pluginPermissionBundleMap=");
    if (this.cmJ == null) {}
    for (String str = "0";; str = String.valueOf(this.cmJ.size()))
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
    paramParcel.writeString(this.doD);
    paramParcel.writeString(this.cmD);
    paramParcel.writeString(this.appId);
    paramParcel.writeString(this.iAa);
    byte b;
    if (this.cmE)
    {
      b = 1;
      paramParcel.writeByte(b);
      if (!this.cmF) {
        break label452;
      }
      b = 1;
      label64:
      paramParcel.writeByte(b);
      if (!this.cmG) {
        break label457;
      }
      b = 1;
      label78:
      paramParcel.writeByte(b);
      paramParcel.writeParcelable(this.cmI, paramInt);
      paramParcel.writeInt(this.jYa);
      paramParcel.writeInt(this.cmL);
      paramParcel.writeInt(this.cmM);
      paramParcel.writeInt(this.cmN);
      paramParcel.writeInt(this.cmO);
      paramParcel.writeInt(this.cmP);
      paramParcel.writeInt(this.cmQ);
      if (!this.cmR) {
        break label462;
      }
      b = 1;
      label157:
      paramParcel.writeByte(b);
      if (!this.cmS) {
        break label467;
      }
      b = 1;
      label171:
      paramParcel.writeByte(b);
      paramParcel.writeLong(this.cmT);
      paramParcel.writeInt(this.cmU);
      paramParcel.writeStringList(this.cmV);
      paramParcel.writeStringList(this.cmW);
      paramParcel.writeStringList(this.cmX);
      paramParcel.writeStringList(this.cmY);
      paramParcel.writeStringList(this.cmZ);
      paramParcel.writeParcelable(this.jYh, paramInt);
      paramParcel.writeParcelable(this.cnf, paramInt);
      if (!this.jYb) {
        break label472;
      }
      b = 1;
      label259:
      paramParcel.writeByte(b);
      if (!this.jYc) {
        break label477;
      }
      b = 1;
      label273:
      paramParcel.writeByte(b);
      paramParcel.writeInt(this.jYf);
      paramParcel.writeInt(this.jYg);
      paramParcel.writeInt(this.cnb);
      if (!this.cna) {
        break label482;
      }
      paramInt = 1;
      label311:
      paramParcel.writeInt(paramInt);
      paramParcel.writeLong(this.cne);
      paramParcel.writeString(this.cmK);
      paramParcel.writeInt(this.cng.length);
      paramParcel.writeStringArray(this.cng);
      paramParcel.writeInt(this.cnc);
      paramParcel.writeInt(this.cnd);
      paramParcel.writeInt(this.jYi);
      if (!this.jYj) {
        break label487;
      }
      paramInt = 1;
      label382:
      paramParcel.writeInt(paramInt);
      if (!this.jYd) {
        break label492;
      }
      paramInt = 1;
      label396:
      paramParcel.writeInt(paramInt);
      if (!this.jYe) {
        break label497;
      }
    }
    label452:
    label457:
    label462:
    label467:
    label472:
    label477:
    label482:
    label487:
    label492:
    label497:
    for (paramInt = i;; paramInt = 0)
    {
      paramParcel.writeInt(paramInt);
      paramParcel.writeLong(this.cnh);
      paramParcel.writeTypedList(this.cni);
      paramParcel.writeMap(this.cmJ);
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