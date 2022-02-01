package com.tencent.luggage.sdk.config;

import android.os.Parcel;
import android.os.Parcelable;
import android.os.Parcelable.Creator;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.appbrand.appcache.WxaPkgWrappingInfo;
import com.tencent.mm.plugin.appbrand.config.AppBrandGlobalSystemConfig;
import com.tencent.mm.plugin.appbrand.config.n;
import com.tencent.mm.plugin.appbrand.jsapi.m;
import com.tencent.mm.plugin.appbrand.permission.AppRuntimeApiPermissionBundle;
import com.tencent.mm.plugin.appbrand.permission.appidABTest.AppRuntimeAppidABTestPermissionBundle;
import java.util.ArrayList;
import java.util.HashMap;

public class AppBrandSysConfigLU
  extends n
  implements Parcelable, m
{
  public static final Parcelable.Creator<AppBrandSysConfigLU> CREATOR;
  public boolean eoX;
  public boolean epA;
  public boolean epB;
  public LaunchWxaAppInfoParcelized epC;
  public HashMap<String, AppRuntimeApiPermissionBundle> epD;
  public HashMap<String, AppRuntimeAppidABTestPermissionBundle> epE;
  public String epF;
  public int epG;
  public int epH;
  public int epI;
  public int epJ;
  public int epK;
  public int epL;
  public boolean epM;
  public boolean epN;
  public long epO;
  public long epP;
  public long epQ;
  public int epR;
  public byte[] epS;
  public int epT;
  public ArrayList<String> epU;
  public ArrayList<String> epV;
  public ArrayList<String> epW;
  public ArrayList<String> epX;
  public ArrayList<String> epY;
  public ArrayList<String> epZ;
  public String epy;
  public boolean epz;
  public boolean eqa;
  public int eqb;
  public int eqc;
  public int eqd;
  public long eqe;
  public AppBrandGlobalSystemConfig eqf;
  public String[] eqg;
  public long eqh;
  
  static
  {
    AppMethodBeat.i(146709);
    CREATOR = new Parcelable.Creator() {};
    AppMethodBeat.o(146709);
  }
  
  public AppBrandSysConfigLU()
  {
    AppMethodBeat.i(146705);
    this.epz = false;
    this.epA = false;
    this.epB = false;
    this.eoX = false;
    this.eqe = 0L;
    this.eqg = new String[0];
    AppMethodBeat.o(146705);
  }
  
  protected AppBrandSysConfigLU(Parcel paramParcel)
  {
    AppMethodBeat.i(146708);
    this.epz = false;
    this.epA = false;
    this.epB = false;
    this.eoX = false;
    this.eqe = 0L;
    this.eqg = new String[0];
    this.hEy = paramParcel.readString();
    this.epy = paramParcel.readString();
    this.appId = paramParcel.readString();
    this.phA = paramParcel.readString();
    if (paramParcel.readByte() != 0)
    {
      bool1 = true;
      this.epz = bool1;
      if (paramParcel.readByte() == 0) {
        break label580;
      }
      bool1 = true;
      label99:
      this.epA = bool1;
      this.epC = ((LaunchWxaAppInfoParcelized)paramParcel.readParcelable(LaunchWxaAppInfoParcelized.class.getClassLoader()));
      this.qYQ = paramParcel.readInt();
      this.epG = paramParcel.readInt();
      this.epH = paramParcel.readInt();
      this.epI = paramParcel.readInt();
      this.epJ = paramParcel.readInt();
      this.epK = paramParcel.readInt();
      this.epL = paramParcel.readInt();
      if (paramParcel.readByte() == 0) {
        break label585;
      }
      bool1 = true;
      label185:
      this.epM = bool1;
      if (paramParcel.readByte() == 0) {
        break label590;
      }
      bool1 = true;
      label199:
      this.epN = bool1;
      this.epQ = paramParcel.readLong();
      this.epO = paramParcel.readLong();
      this.epP = paramParcel.readLong();
      this.epR = paramParcel.readInt();
      this.epU = paramParcel.createStringArrayList();
      this.epV = paramParcel.createStringArrayList();
      this.epW = paramParcel.createStringArrayList();
      this.epX = paramParcel.createStringArrayList();
      this.epY = paramParcel.createStringArrayList();
      this.epZ = paramParcel.createStringArrayList();
      this.qYY = ((WxaPkgWrappingInfo)paramParcel.readParcelable(WxaPkgWrappingInfo.class.getClassLoader()));
      this.eqf = ((AppBrandGlobalSystemConfig)paramParcel.readParcelable(AppBrandGlobalSystemConfig.class.getClassLoader()));
      if (paramParcel.readByte() <= 0) {
        break label595;
      }
      bool1 = true;
      label325:
      this.qYR = bool1;
      if (paramParcel.readByte() <= 0) {
        break label600;
      }
      bool1 = true;
      label339:
      this.qYS = bool1;
      if (paramParcel.readByte() <= 0) {
        break label605;
      }
      bool1 = true;
      label353:
      this.qYT = bool1;
      this.qYW = paramParcel.readInt();
      this.qYX = paramParcel.readInt();
      this.eqb = paramParcel.readInt();
      if (paramParcel.readInt() != 1) {
        break label610;
      }
      bool1 = true;
      label392:
      this.eqa = bool1;
      this.eqe = paramParcel.readLong();
      this.epF = paramParcel.readString();
      this.eqg = new String[paramParcel.readInt()];
      paramParcel.readStringArray(this.eqg);
      this.eqc = paramParcel.readInt();
      this.eqd = paramParcel.readInt();
      this.qYZ = paramParcel.readInt();
      if (paramParcel.readInt() != 1) {
        break label615;
      }
      bool1 = true;
      label466:
      this.qZa = bool1;
      if (paramParcel.readInt() != 1) {
        break label620;
      }
      bool1 = true;
      label481:
      this.qYU = bool1;
      if (paramParcel.readInt() != 1) {
        break label625;
      }
    }
    label580:
    label585:
    label590:
    label595:
    label600:
    label605:
    label610:
    label615:
    label620:
    label625:
    for (boolean bool1 = bool2;; bool1 = false)
    {
      this.qYV = bool1;
      this.eqh = paramParcel.readLong();
      this.epD = paramParcel.readHashMap(AppRuntimeApiPermissionBundle.class.getClassLoader());
      this.epE = paramParcel.readHashMap(AppRuntimeAppidABTestPermissionBundle.class.getClassLoader());
      this.qLQ = paramParcel.readString();
      this.epT = paramParcel.readInt();
      this.epS = new byte[this.epT];
      paramParcel.readByteArray(this.epS);
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
      break label353;
      bool1 = false;
      break label392;
      bool1 = false;
      break label466;
      bool1 = false;
      break label481;
    }
  }
  
  public int describeContents()
  {
    return 0;
  }
  
  public String toString()
  {
    AppMethodBeat.i(146706);
    StringBuilder localStringBuilder = new StringBuilder("AppBrandSysConfigLU{, brandName='").append(this.hEy).append('\'').append(", appId='").append(this.appId).append('\'').append(", appIconUrl='").append(this.phA).append('\'').append(", debugEnabled=").append(this.epz).append(", performancePanelEnabled=").append(this.epA).append(", maxWebViewDepth=").append(this.qYQ).append(", maxBackgroundLifeSpan=").append(this.epG).append(", maxRequestConcurrent=").append(this.epH).append(", maxUploadConcurrent=").append(this.epI).append(", maxDownloadConcurrent=").append(this.epJ).append(", maxWebsocketConnect=").append(this.epK).append(", websocketSkipPortCheck=").append(this.epM).append(", requestDomains=").append(this.epU).append(", socketDomains=").append(this.epV).append(", uploadDomains=").append(this.epW).append(", downloadDomains=").append(this.epX).append(", udpDomains=").append(this.epY).append(", tcpDomains=").append(this.epZ).append(", appPkgInfo=").append(this.qYY).append(", systemSettings=").append(this.eqf).append(", runningFlag=").append(this.eqh).append(", operationInfo=").append(this.epF).append(", kvStorageScheme=").append(this.qYZ).append(", TLSSkipHostnameCheck=").append(this.epN).append(", kvStoragePerformanceReportOn=").append(this.qZa).append(", pluginPermissionBundleMap=");
    if (this.epD == null)
    {
      str = "0";
      localStringBuilder = localStringBuilder.append(str).append(", appidABTestPermissionBundleMap=");
      if (this.epE != null) {
        break label427;
      }
    }
    label427:
    for (String str = "0";; str = String.valueOf(this.epE.size()))
    {
      str = str + '}';
      AppMethodBeat.o(146706);
      return str;
      str = String.valueOf(this.epD.size());
      break;
    }
  }
  
  public void writeToParcel(Parcel paramParcel, int paramInt)
  {
    int i = 1;
    AppMethodBeat.i(146707);
    paramParcel.writeString(this.hEy);
    paramParcel.writeString(this.epy);
    paramParcel.writeString(this.appId);
    paramParcel.writeString(this.phA);
    byte b;
    if (this.epz)
    {
      b = 1;
      paramParcel.writeByte(b);
      if (!this.epA) {
        break label500;
      }
      b = 1;
      label64:
      paramParcel.writeByte(b);
      paramParcel.writeParcelable(this.epC, paramInt);
      paramParcel.writeInt(this.qYQ);
      paramParcel.writeInt(this.epG);
      paramParcel.writeInt(this.epH);
      paramParcel.writeInt(this.epI);
      paramParcel.writeInt(this.epJ);
      paramParcel.writeInt(this.epK);
      paramParcel.writeInt(this.epL);
      if (!this.epM) {
        break label505;
      }
      b = 1;
      label143:
      paramParcel.writeByte(b);
      if (!this.epN) {
        break label510;
      }
      b = 1;
      label157:
      paramParcel.writeByte(b);
      paramParcel.writeLong(this.epQ);
      paramParcel.writeLong(this.epO);
      paramParcel.writeLong(this.epP);
      paramParcel.writeInt(this.epR);
      paramParcel.writeStringList(this.epU);
      paramParcel.writeStringList(this.epV);
      paramParcel.writeStringList(this.epW);
      paramParcel.writeStringList(this.epX);
      paramParcel.writeStringList(this.epY);
      paramParcel.writeStringList(this.epZ);
      paramParcel.writeParcelable(this.qYY, paramInt);
      paramParcel.writeParcelable(this.eqf, paramInt);
      if (!this.qYR) {
        break label515;
      }
      b = 1;
      label269:
      paramParcel.writeByte(b);
      if (!this.qYS) {
        break label520;
      }
      b = 1;
      label283:
      paramParcel.writeByte(b);
      if (!this.qYT) {
        break label525;
      }
      b = 1;
      label297:
      paramParcel.writeByte(b);
      paramParcel.writeInt(this.qYW);
      paramParcel.writeInt(this.qYX);
      paramParcel.writeInt(this.eqb);
      if (!this.eqa) {
        break label530;
      }
      paramInt = 1;
      label335:
      paramParcel.writeInt(paramInt);
      paramParcel.writeLong(this.eqe);
      paramParcel.writeString(this.epF);
      paramParcel.writeInt(this.eqg.length);
      paramParcel.writeStringArray(this.eqg);
      paramParcel.writeInt(this.eqc);
      paramParcel.writeInt(this.eqd);
      paramParcel.writeInt(this.qYZ);
      if (!this.qZa) {
        break label535;
      }
      paramInt = 1;
      label406:
      paramParcel.writeInt(paramInt);
      if (!this.qYU) {
        break label540;
      }
      paramInt = 1;
      label420:
      paramParcel.writeInt(paramInt);
      if (!this.qYV) {
        break label545;
      }
    }
    label515:
    label520:
    label525:
    label530:
    label535:
    label540:
    label545:
    for (paramInt = i;; paramInt = 0)
    {
      paramParcel.writeInt(paramInt);
      paramParcel.writeLong(this.eqh);
      paramParcel.writeMap(this.epD);
      paramParcel.writeMap(this.epE);
      paramParcel.writeString(this.qLQ);
      paramParcel.writeInt(this.epT);
      paramParcel.writeByteArray(this.epS);
      AppMethodBeat.o(146707);
      return;
      b = 0;
      break;
      label500:
      b = 0;
      break label64;
      label505:
      b = 0;
      break label143;
      label510:
      b = 0;
      break label157;
      b = 0;
      break label269;
      b = 0;
      break label283;
      b = 0;
      break label297;
      paramInt = 0;
      break label335;
      paramInt = 0;
      break label406;
      paramInt = 0;
      break label420;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.luggage.sdk.config.AppBrandSysConfigLU
 * JD-Core Version:    0.7.0.1
 */