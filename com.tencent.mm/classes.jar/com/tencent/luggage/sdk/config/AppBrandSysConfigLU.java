package com.tencent.luggage.sdk.config;

import android.os.Parcel;
import android.os.Parcelable;
import android.os.Parcelable.Creator;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.appbrand.appcache.WxaPkgWrappingInfo;
import com.tencent.mm.plugin.appbrand.config.AppBrandGlobalSystemConfig;
import com.tencent.mm.plugin.appbrand.config.h;
import com.tencent.mm.plugin.appbrand.jsapi.j;
import com.tencent.mm.plugin.appbrand.permission.AppRuntimeApiPermissionBundle;
import java.util.ArrayList;

public class AppBrandSysConfigLU
  extends h
  implements Parcelable, j
{
  public static final Parcelable.Creator<AppBrandSysConfigLU> CREATOR;
  public boolean bCW;
  public ArrayList<String> bDA;
  public ArrayList<String> bDB;
  public ArrayList<String> bDC;
  public ArrayList<String> bDD;
  public boolean bDE;
  public int bDF;
  public int bDG;
  public long bDH;
  public AppBrandGlobalSystemConfig bDI;
  public boolean bDJ;
  public String[] bDK;
  public long bDL;
  public String bDi;
  public boolean bDj;
  public boolean bDk;
  public boolean bDl;
  public boolean bDm;
  public AppRuntimeApiPermissionBundle bDn;
  public String bDo;
  public int bDp;
  public int bDq;
  public int bDr;
  public int bDs;
  public int bDt;
  public int bDu;
  public boolean bDv;
  public boolean bDw;
  public long bDx;
  public int bDy;
  public ArrayList<String> bDz;
  public String nickname;
  
  static
  {
    AppMethodBeat.i(101626);
    CREATOR = new AppBrandSysConfigLU.1();
    AppMethodBeat.o(101626);
  }
  
  public AppBrandSysConfigLU()
  {
    AppMethodBeat.i(101622);
    this.bDj = false;
    this.bDk = false;
    this.bDl = false;
    this.bDm = false;
    this.bCW = false;
    this.bDH = 0L;
    this.bDK = new String[0];
    this.nickname = "";
    AppMethodBeat.o(101622);
  }
  
  protected AppBrandSysConfigLU(Parcel paramParcel)
  {
    AppMethodBeat.i(101625);
    this.bDj = false;
    this.bDk = false;
    this.bDl = false;
    this.bDm = false;
    this.bCW = false;
    this.bDH = 0L;
    this.bDK = new String[0];
    this.nickname = "";
    this.cqQ = paramParcel.readString();
    this.bDi = paramParcel.readString();
    this.appId = paramParcel.readString();
    this.hiQ = paramParcel.readString();
    if (paramParcel.readByte() != 0)
    {
      bool1 = true;
      this.bDj = bool1;
      if (paramParcel.readByte() == 0) {
        break label508;
      }
      bool1 = true;
      label110:
      this.bDk = bool1;
      if (paramParcel.readByte() == 0) {
        break label513;
      }
      bool1 = true;
      label124:
      this.bDl = bool1;
      this.bDn = ((AppRuntimeApiPermissionBundle)paramParcel.readParcelable(AppRuntimeApiPermissionBundle.class.getClassLoader()));
      this.hiR = paramParcel.readInt();
      this.bDp = paramParcel.readInt();
      this.bDq = paramParcel.readInt();
      this.bDr = paramParcel.readInt();
      this.bDs = paramParcel.readInt();
      this.bDt = paramParcel.readInt();
      this.bDu = paramParcel.readInt();
      if (paramParcel.readByte() == 0) {
        break label518;
      }
      bool1 = true;
      label210:
      this.bDv = bool1;
      if (paramParcel.readByte() == 0) {
        break label523;
      }
      bool1 = true;
      label224:
      this.bDw = bool1;
      this.bDx = paramParcel.readLong();
      this.bDy = paramParcel.readInt();
      this.bDz = paramParcel.createStringArrayList();
      this.bDA = paramParcel.createStringArrayList();
      this.bDB = paramParcel.createStringArrayList();
      this.bDC = paramParcel.createStringArrayList();
      this.bDD = paramParcel.createStringArrayList();
      this.hiX = ((WxaPkgWrappingInfo)paramParcel.readParcelable(WxaPkgWrappingInfo.class.getClassLoader()));
      this.bDI = ((AppBrandGlobalSystemConfig)paramParcel.readParcelable(AppBrandGlobalSystemConfig.class.getClassLoader()));
      if (paramParcel.readByte() <= 0) {
        break label528;
      }
      bool1 = true;
      label326:
      this.hiS = bool1;
      this.hiV = paramParcel.readInt();
      this.hiW = paramParcel.readInt();
      this.bDF = paramParcel.readInt();
      if (paramParcel.readInt() != 1) {
        break label533;
      }
      bool1 = true;
      label365:
      this.bDE = bool1;
      this.bDH = paramParcel.readLong();
      if (paramParcel.readInt() != 1) {
        break label538;
      }
      bool1 = true;
      label388:
      this.bDJ = bool1;
      this.bDo = paramParcel.readString();
      this.bDK = new String[paramParcel.readInt()];
      paramParcel.readStringArray(this.bDK);
      this.nickname = paramParcel.readString();
      this.bDG = paramParcel.readInt();
      this.hiY = paramParcel.readInt();
      if (paramParcel.readInt() != 1) {
        break label543;
      }
      bool1 = true;
      label454:
      this.hiZ = bool1;
      if (paramParcel.readInt() != 1) {
        break label548;
      }
      bool1 = true;
      label469:
      this.hiT = bool1;
      if (paramParcel.readInt() != 1) {
        break label553;
      }
    }
    label513:
    label518:
    label523:
    label528:
    label533:
    label538:
    label543:
    label548:
    label553:
    for (boolean bool1 = bool2;; bool1 = false)
    {
      this.hiU = bool1;
      this.bDL = paramParcel.readLong();
      AppMethodBeat.o(101625);
      return;
      bool1 = false;
      break;
      label508:
      bool1 = false;
      break label110;
      bool1 = false;
      break label124;
      bool1 = false;
      break label210;
      bool1 = false;
      break label224;
      bool1 = false;
      break label326;
      bool1 = false;
      break label365;
      bool1 = false;
      break label388;
      bool1 = false;
      break label454;
      bool1 = false;
      break label469;
    }
  }
  
  public int describeContents()
  {
    return 0;
  }
  
  public String toString()
  {
    AppMethodBeat.i(101623);
    String str = "AppBrandSysConfigLU{, brandName='" + this.cqQ + '\'' + ", appId='" + this.appId + '\'' + ", appIconUrl='" + this.hiQ + '\'' + ", debugEnabled=" + this.bDj + ", performancePanelEnabled=" + this.bDk + ", maxWebViewDepth=" + this.hiR + ", maxBackgroundLifeSpan=" + this.bDp + ", maxRequestConcurrent=" + this.bDq + ", maxUploadConcurrent=" + this.bDr + ", maxDownloadConcurrent=" + this.bDs + ", maxWebsocketConnect=" + this.bDt + ", websocketSkipPortCheck=" + this.bDv + ", requestDomains=" + this.bDz + ", socketDomains=" + this.bDA + ", uploadDomains=" + this.bDB + ", downloadDomains=" + this.bDC + ", downloadDomains=" + this.bDD + ", appPkgInfo=" + this.hiX + ", systemSettings=" + this.bDI + ", runningFlag=" + this.bDL + ", operationInfo=" + this.bDo + ", kvStorageScheme=" + this.hiY + ", TLSSkipHostnameCheck=" + this.bDw + ", kvStoragePerformanceReportOn=" + this.hiZ + '}';
    AppMethodBeat.o(101623);
    return str;
  }
  
  public void writeToParcel(Parcel paramParcel, int paramInt)
  {
    int i = 1;
    AppMethodBeat.i(101624);
    paramParcel.writeString(this.cqQ);
    paramParcel.writeString(this.bDi);
    paramParcel.writeString(this.appId);
    paramParcel.writeString(this.hiQ);
    byte b;
    if (this.bDj)
    {
      b = 1;
      paramParcel.writeByte(b);
      if (!this.bDk) {
        break label436;
      }
      b = 1;
      label64:
      paramParcel.writeByte(b);
      if (!this.bDl) {
        break label441;
      }
      b = 1;
      label78:
      paramParcel.writeByte(b);
      paramParcel.writeParcelable(this.bDn, paramInt);
      paramParcel.writeInt(this.hiR);
      paramParcel.writeInt(this.bDp);
      paramParcel.writeInt(this.bDq);
      paramParcel.writeInt(this.bDr);
      paramParcel.writeInt(this.bDs);
      paramParcel.writeInt(this.bDt);
      paramParcel.writeInt(this.bDu);
      if (!this.bDv) {
        break label446;
      }
      b = 1;
      label157:
      paramParcel.writeByte(b);
      if (!this.bDw) {
        break label451;
      }
      b = 1;
      label171:
      paramParcel.writeByte(b);
      paramParcel.writeLong(this.bDx);
      paramParcel.writeInt(this.bDy);
      paramParcel.writeStringList(this.bDz);
      paramParcel.writeStringList(this.bDA);
      paramParcel.writeStringList(this.bDB);
      paramParcel.writeStringList(this.bDC);
      paramParcel.writeStringList(this.bDD);
      paramParcel.writeParcelable(this.hiX, paramInt);
      paramParcel.writeParcelable(this.bDI, paramInt);
      if (!this.hiS) {
        break label456;
      }
      b = 1;
      label259:
      paramParcel.writeByte(b);
      paramParcel.writeInt(this.hiV);
      paramParcel.writeInt(this.hiW);
      paramParcel.writeInt(this.bDF);
      if (!this.bDE) {
        break label461;
      }
      paramInt = 1;
      label297:
      paramParcel.writeInt(paramInt);
      paramParcel.writeLong(this.bDH);
      if (!this.bDJ) {
        break label466;
      }
      paramInt = 1;
      label319:
      paramParcel.writeInt(paramInt);
      paramParcel.writeString(this.bDo);
      paramParcel.writeInt(this.bDK.length);
      paramParcel.writeStringArray(this.bDK);
      paramParcel.writeString(this.nickname);
      paramParcel.writeInt(this.bDG);
      paramParcel.writeInt(this.hiY);
      if (!this.hiZ) {
        break label471;
      }
      paramInt = 1;
      label382:
      paramParcel.writeInt(paramInt);
      if (!this.hiT) {
        break label476;
      }
      paramInt = 1;
      label396:
      paramParcel.writeInt(paramInt);
      if (!this.hiU) {
        break label481;
      }
    }
    label436:
    label441:
    label446:
    label451:
    label456:
    label461:
    label466:
    label471:
    label476:
    label481:
    for (paramInt = i;; paramInt = 0)
    {
      paramParcel.writeInt(paramInt);
      paramParcel.writeLong(this.bDL);
      AppMethodBeat.o(101624);
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
      paramInt = 0;
      break label297;
      paramInt = 0;
      break label319;
      paramInt = 0;
      break label382;
      paramInt = 0;
      break label396;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.luggage.sdk.config.AppBrandSysConfigLU
 * JD-Core Version:    0.7.0.1
 */