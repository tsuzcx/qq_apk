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
  public String cmF;
  public boolean cmG;
  public boolean cmH;
  @Deprecated
  public boolean cmI;
  public boolean cmJ;
  public AppRuntimeApiPermissionBundle cmK;
  public HashMap<String, AppRuntimeApiPermissionBundle> cmL;
  public String cmM;
  public int cmN;
  public int cmO;
  public int cmP;
  public int cmQ;
  public int cmR;
  public int cmS;
  public boolean cmT;
  public boolean cmU;
  public long cmV;
  public int cmW;
  public ArrayList<String> cmX;
  public ArrayList<String> cmY;
  public ArrayList<String> cmZ;
  public boolean cmu;
  public ArrayList<String> cna;
  public ArrayList<String> cnb;
  public boolean cnc;
  public int cnd;
  public int cne;
  public int cnf;
  public long cng;
  public AppBrandGlobalSystemConfig cnh;
  public String[] cni;
  public long cnj;
  public List<WxaAttributes.WxaPluginCodeInfo> cnk;
  
  static
  {
    AppMethodBeat.i(146709);
    CREATOR = new Parcelable.Creator() {};
    AppMethodBeat.o(146709);
  }
  
  public AppBrandSysConfigLU()
  {
    AppMethodBeat.i(146705);
    this.cmG = false;
    this.cmH = false;
    this.cmI = false;
    this.cmJ = false;
    this.cmu = false;
    this.cng = 0L;
    this.cni = new String[0];
    AppMethodBeat.o(146705);
  }
  
  protected AppBrandSysConfigLU(Parcel paramParcel)
  {
    AppMethodBeat.i(146708);
    this.cmG = false;
    this.cmH = false;
    this.cmI = false;
    this.cmJ = false;
    this.cmu = false;
    this.cng = 0L;
    this.cni = new String[0];
    this.dpI = paramParcel.readString();
    this.cmF = paramParcel.readString();
    this.appId = paramParcel.readString();
    this.iCT = paramParcel.readString();
    if (paramParcel.readByte() != 0)
    {
      bool1 = true;
      this.cmG = bool1;
      if (paramParcel.readByte() == 0) {
        break label525;
      }
      bool1 = true;
      label104:
      this.cmH = bool1;
      if (paramParcel.readByte() == 0) {
        break label530;
      }
      bool1 = true;
      label118:
      this.cmI = bool1;
      this.cmK = ((AppRuntimeApiPermissionBundle)paramParcel.readParcelable(AppRuntimeApiPermissionBundle.class.getClassLoader()));
      this.kbp = paramParcel.readInt();
      this.cmN = paramParcel.readInt();
      this.cmO = paramParcel.readInt();
      this.cmP = paramParcel.readInt();
      this.cmQ = paramParcel.readInt();
      this.cmR = paramParcel.readInt();
      this.cmS = paramParcel.readInt();
      if (paramParcel.readByte() == 0) {
        break label535;
      }
      bool1 = true;
      label204:
      this.cmT = bool1;
      if (paramParcel.readByte() == 0) {
        break label540;
      }
      bool1 = true;
      label218:
      this.cmU = bool1;
      this.cmV = paramParcel.readLong();
      this.cmW = paramParcel.readInt();
      this.cmX = paramParcel.createStringArrayList();
      this.cmY = paramParcel.createStringArrayList();
      this.cmZ = paramParcel.createStringArrayList();
      this.cna = paramParcel.createStringArrayList();
      this.cnb = paramParcel.createStringArrayList();
      this.kbw = ((WxaPkgWrappingInfo)paramParcel.readParcelable(WxaPkgWrappingInfo.class.getClassLoader()));
      this.cnh = ((AppBrandGlobalSystemConfig)paramParcel.readParcelable(AppBrandGlobalSystemConfig.class.getClassLoader()));
      if (paramParcel.readByte() <= 0) {
        break label545;
      }
      bool1 = true;
      label320:
      this.kbq = bool1;
      if (paramParcel.readByte() <= 0) {
        break label550;
      }
      bool1 = true;
      label334:
      this.kbr = bool1;
      this.kbu = paramParcel.readInt();
      this.kbv = paramParcel.readInt();
      this.cnd = paramParcel.readInt();
      if (paramParcel.readInt() != 1) {
        break label555;
      }
      bool1 = true;
      label373:
      this.cnc = bool1;
      this.cng = paramParcel.readLong();
      this.cmM = paramParcel.readString();
      this.cni = new String[paramParcel.readInt()];
      paramParcel.readStringArray(this.cni);
      this.cne = paramParcel.readInt();
      this.cnf = paramParcel.readInt();
      this.kbx = paramParcel.readInt();
      if (paramParcel.readInt() != 1) {
        break label560;
      }
      bool1 = true;
      label447:
      this.kby = bool1;
      if (paramParcel.readInt() != 1) {
        break label565;
      }
      bool1 = true;
      label462:
      this.kbs = bool1;
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
      this.kbt = bool1;
      this.cnj = paramParcel.readLong();
      this.cnk = paramParcel.createTypedArrayList(WxaAttributes.WxaPluginCodeInfo.CREATOR);
      this.cmL = paramParcel.readHashMap(AppRuntimeApiPermissionBundle.class.getClassLoader());
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
    StringBuilder localStringBuilder = new StringBuilder("AppBrandSysConfigLU{, brandName='").append(this.dpI).append('\'').append(", appId='").append(this.appId).append('\'').append(", appIconUrl='").append(this.iCT).append('\'').append(", debugEnabled=").append(this.cmG).append(", performancePanelEnabled=").append(this.cmH).append(", maxWebViewDepth=").append(this.kbp).append(", maxBackgroundLifeSpan=").append(this.cmN).append(", maxRequestConcurrent=").append(this.cmO).append(", maxUploadConcurrent=").append(this.cmP).append(", maxDownloadConcurrent=").append(this.cmQ).append(", maxWebsocketConnect=").append(this.cmR).append(", websocketSkipPortCheck=").append(this.cmT).append(", requestDomains=").append(this.cmX).append(", socketDomains=").append(this.cmY).append(", uploadDomains=").append(this.cmZ).append(", downloadDomains=").append(this.cna).append(", downloadDomains=").append(this.cnb).append(", appPkgInfo=").append(this.kbw).append(", systemSettings=").append(this.cnh).append(", runningFlag=").append(this.cnj).append(", operationInfo=").append(this.cmM).append(", kvStorageScheme=").append(this.kbx).append(", TLSSkipHostnameCheck=").append(this.cmU).append(", kvStoragePerformanceReportOn=").append(this.kby).append(", pluginPermissionBundleMap=");
    if (this.cmL == null) {}
    for (String str = "0";; str = String.valueOf(this.cmL.size()))
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
    paramParcel.writeString(this.dpI);
    paramParcel.writeString(this.cmF);
    paramParcel.writeString(this.appId);
    paramParcel.writeString(this.iCT);
    byte b;
    if (this.cmG)
    {
      b = 1;
      paramParcel.writeByte(b);
      if (!this.cmH) {
        break label452;
      }
      b = 1;
      label64:
      paramParcel.writeByte(b);
      if (!this.cmI) {
        break label457;
      }
      b = 1;
      label78:
      paramParcel.writeByte(b);
      paramParcel.writeParcelable(this.cmK, paramInt);
      paramParcel.writeInt(this.kbp);
      paramParcel.writeInt(this.cmN);
      paramParcel.writeInt(this.cmO);
      paramParcel.writeInt(this.cmP);
      paramParcel.writeInt(this.cmQ);
      paramParcel.writeInt(this.cmR);
      paramParcel.writeInt(this.cmS);
      if (!this.cmT) {
        break label462;
      }
      b = 1;
      label157:
      paramParcel.writeByte(b);
      if (!this.cmU) {
        break label467;
      }
      b = 1;
      label171:
      paramParcel.writeByte(b);
      paramParcel.writeLong(this.cmV);
      paramParcel.writeInt(this.cmW);
      paramParcel.writeStringList(this.cmX);
      paramParcel.writeStringList(this.cmY);
      paramParcel.writeStringList(this.cmZ);
      paramParcel.writeStringList(this.cna);
      paramParcel.writeStringList(this.cnb);
      paramParcel.writeParcelable(this.kbw, paramInt);
      paramParcel.writeParcelable(this.cnh, paramInt);
      if (!this.kbq) {
        break label472;
      }
      b = 1;
      label259:
      paramParcel.writeByte(b);
      if (!this.kbr) {
        break label477;
      }
      b = 1;
      label273:
      paramParcel.writeByte(b);
      paramParcel.writeInt(this.kbu);
      paramParcel.writeInt(this.kbv);
      paramParcel.writeInt(this.cnd);
      if (!this.cnc) {
        break label482;
      }
      paramInt = 1;
      label311:
      paramParcel.writeInt(paramInt);
      paramParcel.writeLong(this.cng);
      paramParcel.writeString(this.cmM);
      paramParcel.writeInt(this.cni.length);
      paramParcel.writeStringArray(this.cni);
      paramParcel.writeInt(this.cne);
      paramParcel.writeInt(this.cnf);
      paramParcel.writeInt(this.kbx);
      if (!this.kby) {
        break label487;
      }
      paramInt = 1;
      label382:
      paramParcel.writeInt(paramInt);
      if (!this.kbs) {
        break label492;
      }
      paramInt = 1;
      label396:
      paramParcel.writeInt(paramInt);
      if (!this.kbt) {
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
      paramParcel.writeLong(this.cnj);
      paramParcel.writeTypedList(this.cnk);
      paramParcel.writeMap(this.cmL);
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