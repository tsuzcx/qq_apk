package com.tencent.luggage.sdk.config;

import android.os.Parcel;
import android.os.Parcelable;
import android.os.Parcelable.Creator;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.appbrand.appcache.WxaPkgWrappingInfo;
import com.tencent.mm.plugin.appbrand.config.AppBrandGlobalSystemConfig;
import com.tencent.mm.plugin.appbrand.permission.AppRuntimeApiPermissionBundle;
import com.tencent.mm.plugin.appbrand.permission.appidABTest.AppRuntimeAppidABTestPermissionBundle;
import java.util.ArrayList;
import java.util.HashMap;

public class AppBrandSysConfigLU
  extends com.tencent.mm.plugin.appbrand.config.l
  implements Parcelable, com.tencent.mm.plugin.appbrand.jsapi.l
{
  public static final Parcelable.Creator<AppBrandSysConfigLU> CREATOR;
  public boolean cwS;
  public ArrayList<String> cxA;
  public ArrayList<String> cxB;
  public ArrayList<String> cxC;
  public ArrayList<String> cxD;
  public ArrayList<String> cxE;
  public ArrayList<String> cxF;
  public boolean cxG;
  public int cxH;
  public int cxI;
  public int cxJ;
  public long cxK;
  public AppBrandGlobalSystemConfig cxL;
  public String[] cxM;
  public long cxN;
  public String cxg;
  public boolean cxh;
  public boolean cxi;
  public boolean cxj;
  public LaunchWxaAppInfoParcelized cxk;
  public HashMap<String, AppRuntimeApiPermissionBundle> cxl;
  public HashMap<String, AppRuntimeAppidABTestPermissionBundle> cxm;
  public String cxn;
  public int cxo;
  public int cxp;
  public int cxq;
  public int cxr;
  public int cxs;
  public int cxt;
  public boolean cxu;
  public boolean cxv;
  public long cxw;
  public long cxx;
  public long cxy;
  public int cxz;
  
  static
  {
    AppMethodBeat.i(146709);
    CREATOR = new Parcelable.Creator() {};
    AppMethodBeat.o(146709);
  }
  
  public AppBrandSysConfigLU()
  {
    AppMethodBeat.i(146705);
    this.cxh = false;
    this.cxi = false;
    this.cxj = false;
    this.cwS = false;
    this.cxK = 0L;
    this.cxM = new String[0];
    AppMethodBeat.o(146705);
  }
  
  protected AppBrandSysConfigLU(Parcel paramParcel)
  {
    AppMethodBeat.i(146708);
    this.cxh = false;
    this.cxi = false;
    this.cxj = false;
    this.cwS = false;
    this.cxK = 0L;
    this.cxM = new String[0];
    this.fzM = paramParcel.readString();
    this.cxg = paramParcel.readString();
    this.appId = paramParcel.readString();
    this.mnM = paramParcel.readString();
    if (paramParcel.readByte() != 0)
    {
      bool1 = true;
      this.cxh = bool1;
      if (paramParcel.readByte() == 0) {
        break label532;
      }
      bool1 = true;
      label99:
      this.cxi = bool1;
      this.cxk = ((LaunchWxaAppInfoParcelized)paramParcel.readParcelable(LaunchWxaAppInfoParcelized.class.getClassLoader()));
      this.nYK = paramParcel.readInt();
      this.cxo = paramParcel.readInt();
      this.cxp = paramParcel.readInt();
      this.cxq = paramParcel.readInt();
      this.cxr = paramParcel.readInt();
      this.cxs = paramParcel.readInt();
      this.cxt = paramParcel.readInt();
      if (paramParcel.readByte() == 0) {
        break label537;
      }
      bool1 = true;
      label185:
      this.cxu = bool1;
      if (paramParcel.readByte() == 0) {
        break label542;
      }
      bool1 = true;
      label199:
      this.cxv = bool1;
      this.cxy = paramParcel.readLong();
      this.cxw = paramParcel.readLong();
      this.cxx = paramParcel.readLong();
      this.cxz = paramParcel.readInt();
      this.cxA = paramParcel.createStringArrayList();
      this.cxB = paramParcel.createStringArrayList();
      this.cxC = paramParcel.createStringArrayList();
      this.cxD = paramParcel.createStringArrayList();
      this.cxE = paramParcel.createStringArrayList();
      this.cxF = paramParcel.createStringArrayList();
      this.nYR = ((WxaPkgWrappingInfo)paramParcel.readParcelable(WxaPkgWrappingInfo.class.getClassLoader()));
      this.cxL = ((AppBrandGlobalSystemConfig)paramParcel.readParcelable(AppBrandGlobalSystemConfig.class.getClassLoader()));
      if (paramParcel.readByte() <= 0) {
        break label547;
      }
      bool1 = true;
      label325:
      this.nYL = bool1;
      if (paramParcel.readByte() <= 0) {
        break label552;
      }
      bool1 = true;
      label339:
      this.nYM = bool1;
      this.nYP = paramParcel.readInt();
      this.nYQ = paramParcel.readInt();
      this.cxH = paramParcel.readInt();
      if (paramParcel.readInt() != 1) {
        break label557;
      }
      bool1 = true;
      label378:
      this.cxG = bool1;
      this.cxK = paramParcel.readLong();
      this.cxn = paramParcel.readString();
      this.cxM = new String[paramParcel.readInt()];
      paramParcel.readStringArray(this.cxM);
      this.cxI = paramParcel.readInt();
      this.cxJ = paramParcel.readInt();
      this.nYS = paramParcel.readInt();
      if (paramParcel.readInt() != 1) {
        break label562;
      }
      bool1 = true;
      label452:
      this.nYT = bool1;
      if (paramParcel.readInt() != 1) {
        break label567;
      }
      bool1 = true;
      label467:
      this.nYN = bool1;
      if (paramParcel.readInt() != 1) {
        break label572;
      }
    }
    label532:
    label537:
    label542:
    label547:
    label552:
    label557:
    label562:
    label567:
    label572:
    for (boolean bool1 = bool2;; bool1 = false)
    {
      this.nYO = bool1;
      this.cxN = paramParcel.readLong();
      this.cxl = paramParcel.readHashMap(AppRuntimeApiPermissionBundle.class.getClassLoader());
      this.cxm = paramParcel.readHashMap(AppRuntimeAppidABTestPermissionBundle.class.getClassLoader());
      AppMethodBeat.o(146708);
      return;
      bool1 = false;
      break;
      bool1 = false;
      break label99;
      bool1 = false;
      break label185;
      bool1 = false;
      break label199;
      bool1 = false;
      break label325;
      bool1 = false;
      break label339;
      bool1 = false;
      break label378;
      bool1 = false;
      break label452;
      bool1 = false;
      break label467;
    }
  }
  
  public int describeContents()
  {
    return 0;
  }
  
  public String toString()
  {
    AppMethodBeat.i(146706);
    StringBuilder localStringBuilder = new StringBuilder("AppBrandSysConfigLU{, brandName='").append(this.fzM).append('\'').append(", appId='").append(this.appId).append('\'').append(", appIconUrl='").append(this.mnM).append('\'').append(", debugEnabled=").append(this.cxh).append(", performancePanelEnabled=").append(this.cxi).append(", maxWebViewDepth=").append(this.nYK).append(", maxBackgroundLifeSpan=").append(this.cxo).append(", maxRequestConcurrent=").append(this.cxp).append(", maxUploadConcurrent=").append(this.cxq).append(", maxDownloadConcurrent=").append(this.cxr).append(", maxWebsocketConnect=").append(this.cxs).append(", websocketSkipPortCheck=").append(this.cxu).append(", requestDomains=").append(this.cxA).append(", socketDomains=").append(this.cxB).append(", uploadDomains=").append(this.cxC).append(", downloadDomains=").append(this.cxD).append(", udpDomains=").append(this.cxE).append(", tcpDomains=").append(this.cxF).append(", appPkgInfo=").append(this.nYR).append(", systemSettings=").append(this.cxL).append(", runningFlag=").append(this.cxN).append(", operationInfo=").append(this.cxn).append(", kvStorageScheme=").append(this.nYS).append(", TLSSkipHostnameCheck=").append(this.cxv).append(", kvStoragePerformanceReportOn=").append(this.nYT).append(", pluginPermissionBundleMap=");
    if (this.cxl == null)
    {
      str = "0";
      localStringBuilder = localStringBuilder.append(str).append(", appidABTestPermissionBundleMap=");
      if (this.cxm != null) {
        break label424;
      }
    }
    label424:
    for (String str = "0";; str = String.valueOf(this.cxm.size()))
    {
      str = str + '}';
      AppMethodBeat.o(146706);
      return str;
      str = String.valueOf(this.cxl.size());
      break;
    }
  }
  
  public void writeToParcel(Parcel paramParcel, int paramInt)
  {
    int i = 1;
    AppMethodBeat.i(146707);
    paramParcel.writeString(this.fzM);
    paramParcel.writeString(this.cxg);
    paramParcel.writeString(this.appId);
    paramParcel.writeString(this.mnM);
    byte b;
    if (this.cxh)
    {
      b = 1;
      paramParcel.writeByte(b);
      if (!this.cxi) {
        break label462;
      }
      b = 1;
      label64:
      paramParcel.writeByte(b);
      paramParcel.writeParcelable(this.cxk, paramInt);
      paramParcel.writeInt(this.nYK);
      paramParcel.writeInt(this.cxo);
      paramParcel.writeInt(this.cxp);
      paramParcel.writeInt(this.cxq);
      paramParcel.writeInt(this.cxr);
      paramParcel.writeInt(this.cxs);
      paramParcel.writeInt(this.cxt);
      if (!this.cxu) {
        break label467;
      }
      b = 1;
      label143:
      paramParcel.writeByte(b);
      if (!this.cxv) {
        break label472;
      }
      b = 1;
      label157:
      paramParcel.writeByte(b);
      paramParcel.writeLong(this.cxy);
      paramParcel.writeLong(this.cxw);
      paramParcel.writeLong(this.cxx);
      paramParcel.writeInt(this.cxz);
      paramParcel.writeStringList(this.cxA);
      paramParcel.writeStringList(this.cxB);
      paramParcel.writeStringList(this.cxC);
      paramParcel.writeStringList(this.cxD);
      paramParcel.writeStringList(this.cxE);
      paramParcel.writeStringList(this.cxF);
      paramParcel.writeParcelable(this.nYR, paramInt);
      paramParcel.writeParcelable(this.cxL, paramInt);
      if (!this.nYL) {
        break label477;
      }
      b = 1;
      label269:
      paramParcel.writeByte(b);
      if (!this.nYM) {
        break label482;
      }
      b = 1;
      label283:
      paramParcel.writeByte(b);
      paramParcel.writeInt(this.nYP);
      paramParcel.writeInt(this.nYQ);
      paramParcel.writeInt(this.cxH);
      if (!this.cxG) {
        break label487;
      }
      paramInt = 1;
      label321:
      paramParcel.writeInt(paramInt);
      paramParcel.writeLong(this.cxK);
      paramParcel.writeString(this.cxn);
      paramParcel.writeInt(this.cxM.length);
      paramParcel.writeStringArray(this.cxM);
      paramParcel.writeInt(this.cxI);
      paramParcel.writeInt(this.cxJ);
      paramParcel.writeInt(this.nYS);
      if (!this.nYT) {
        break label492;
      }
      paramInt = 1;
      label392:
      paramParcel.writeInt(paramInt);
      if (!this.nYN) {
        break label497;
      }
      paramInt = 1;
      label406:
      paramParcel.writeInt(paramInt);
      if (!this.nYO) {
        break label502;
      }
    }
    label462:
    label467:
    label472:
    label477:
    label482:
    label487:
    label492:
    label497:
    label502:
    for (paramInt = i;; paramInt = 0)
    {
      paramParcel.writeInt(paramInt);
      paramParcel.writeLong(this.cxN);
      paramParcel.writeMap(this.cxl);
      paramParcel.writeMap(this.cxm);
      AppMethodBeat.o(146707);
      return;
      b = 0;
      break;
      b = 0;
      break label64;
      b = 0;
      break label143;
      b = 0;
      break label157;
      b = 0;
      break label269;
      b = 0;
      break label283;
      paramInt = 0;
      break label321;
      paramInt = 0;
      break label392;
      paramInt = 0;
      break label406;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.luggage.sdk.config.AppBrandSysConfigLU
 * JD-Core Version:    0.7.0.1
 */