package com.tencent.luggage.sdk.config;

import android.os.Parcel;
import android.os.Parcelable;
import android.os.Parcelable.Creator;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.appbrand.appcache.WxaPkgWrappingInfo;
import com.tencent.mm.plugin.appbrand.config.AppBrandGlobalSystemConfig;
import com.tencent.mm.plugin.appbrand.config.l;
import com.tencent.mm.plugin.appbrand.jsapi.m;
import com.tencent.mm.plugin.appbrand.permission.AppRuntimeApiPermissionBundle;
import java.util.ArrayList;
import java.util.HashMap;

public class AppBrandSysConfigLU
  extends l
  implements Parcelable, m
{
  public static final Parcelable.Creator<AppBrandSysConfigLU> CREATOR;
  public String cyB;
  public boolean cyC;
  public boolean cyD;
  @Deprecated
  public boolean cyE;
  public boolean cyF;
  public AppRuntimeApiPermissionBundle cyG;
  public HashMap<String, AppRuntimeApiPermissionBundle> cyH;
  public String cyI;
  public int cyJ;
  public int cyK;
  public int cyL;
  public int cyM;
  public int cyN;
  public int cyO;
  public boolean cyP;
  public boolean cyQ;
  public long cyR;
  public int cyS;
  public ArrayList<String> cyT;
  public ArrayList<String> cyU;
  public ArrayList<String> cyV;
  public ArrayList<String> cyW;
  public ArrayList<String> cyX;
  public boolean cyY;
  public int cyZ;
  public boolean cyp;
  public int cza;
  public int czb;
  public long czc;
  public AppBrandGlobalSystemConfig czd;
  public String[] cze;
  public long czf;
  
  static
  {
    AppMethodBeat.i(146709);
    CREATOR = new Parcelable.Creator() {};
    AppMethodBeat.o(146709);
  }
  
  public AppBrandSysConfigLU()
  {
    AppMethodBeat.i(146705);
    this.cyC = false;
    this.cyD = false;
    this.cyE = false;
    this.cyF = false;
    this.cyp = false;
    this.czc = 0L;
    this.cze = new String[0];
    AppMethodBeat.o(146705);
  }
  
  protected AppBrandSysConfigLU(Parcel paramParcel)
  {
    AppMethodBeat.i(146708);
    this.cyC = false;
    this.cyD = false;
    this.cyE = false;
    this.cyF = false;
    this.cyp = false;
    this.czc = 0L;
    this.cze = new String[0];
    this.brandName = paramParcel.readString();
    this.cyB = paramParcel.readString();
    this.appId = paramParcel.readString();
    this.jyi = paramParcel.readString();
    if (paramParcel.readByte() != 0)
    {
      bool1 = true;
      this.cyC = bool1;
      if (paramParcel.readByte() == 0) {
        break label514;
      }
      bool1 = true;
      label104:
      this.cyD = bool1;
      if (paramParcel.readByte() == 0) {
        break label519;
      }
      bool1 = true;
      label118:
      this.cyE = bool1;
      this.cyG = ((AppRuntimeApiPermissionBundle)paramParcel.readParcelable(AppRuntimeApiPermissionBundle.class.getClassLoader()));
      this.lex = paramParcel.readInt();
      this.cyJ = paramParcel.readInt();
      this.cyK = paramParcel.readInt();
      this.cyL = paramParcel.readInt();
      this.cyM = paramParcel.readInt();
      this.cyN = paramParcel.readInt();
      this.cyO = paramParcel.readInt();
      if (paramParcel.readByte() == 0) {
        break label524;
      }
      bool1 = true;
      label204:
      this.cyP = bool1;
      if (paramParcel.readByte() == 0) {
        break label529;
      }
      bool1 = true;
      label218:
      this.cyQ = bool1;
      this.cyR = paramParcel.readLong();
      this.cyS = paramParcel.readInt();
      this.cyT = paramParcel.createStringArrayList();
      this.cyU = paramParcel.createStringArrayList();
      this.cyV = paramParcel.createStringArrayList();
      this.cyW = paramParcel.createStringArrayList();
      this.cyX = paramParcel.createStringArrayList();
      this.leE = ((WxaPkgWrappingInfo)paramParcel.readParcelable(WxaPkgWrappingInfo.class.getClassLoader()));
      this.czd = ((AppBrandGlobalSystemConfig)paramParcel.readParcelable(AppBrandGlobalSystemConfig.class.getClassLoader()));
      if (paramParcel.readByte() <= 0) {
        break label534;
      }
      bool1 = true;
      label320:
      this.ley = bool1;
      if (paramParcel.readByte() <= 0) {
        break label539;
      }
      bool1 = true;
      label334:
      this.lez = bool1;
      this.leC = paramParcel.readInt();
      this.leD = paramParcel.readInt();
      this.cyZ = paramParcel.readInt();
      if (paramParcel.readInt() != 1) {
        break label544;
      }
      bool1 = true;
      label373:
      this.cyY = bool1;
      this.czc = paramParcel.readLong();
      this.cyI = paramParcel.readString();
      this.cze = new String[paramParcel.readInt()];
      paramParcel.readStringArray(this.cze);
      this.cza = paramParcel.readInt();
      this.czb = paramParcel.readInt();
      this.leF = paramParcel.readInt();
      if (paramParcel.readInt() != 1) {
        break label549;
      }
      bool1 = true;
      label447:
      this.leG = bool1;
      if (paramParcel.readInt() != 1) {
        break label554;
      }
      bool1 = true;
      label462:
      this.leA = bool1;
      if (paramParcel.readInt() != 1) {
        break label559;
      }
    }
    label514:
    label519:
    label524:
    label529:
    label534:
    label539:
    label544:
    label549:
    label554:
    label559:
    for (boolean bool1 = bool2;; bool1 = false)
    {
      this.leB = bool1;
      this.czf = paramParcel.readLong();
      this.cyH = paramParcel.readHashMap(AppRuntimeApiPermissionBundle.class.getClassLoader());
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
    StringBuilder localStringBuilder = new StringBuilder("AppBrandSysConfigLU{, brandName='").append(this.brandName).append('\'').append(", appId='").append(this.appId).append('\'').append(", appIconUrl='").append(this.jyi).append('\'').append(", debugEnabled=").append(this.cyC).append(", performancePanelEnabled=").append(this.cyD).append(", maxWebViewDepth=").append(this.lex).append(", maxBackgroundLifeSpan=").append(this.cyJ).append(", maxRequestConcurrent=").append(this.cyK).append(", maxUploadConcurrent=").append(this.cyL).append(", maxDownloadConcurrent=").append(this.cyM).append(", maxWebsocketConnect=").append(this.cyN).append(", websocketSkipPortCheck=").append(this.cyP).append(", requestDomains=").append(this.cyT).append(", socketDomains=").append(this.cyU).append(", uploadDomains=").append(this.cyV).append(", downloadDomains=").append(this.cyW).append(", downloadDomains=").append(this.cyX).append(", appPkgInfo=").append(this.leE).append(", systemSettings=").append(this.czd).append(", runningFlag=").append(this.czf).append(", operationInfo=").append(this.cyI).append(", kvStorageScheme=").append(this.leF).append(", TLSSkipHostnameCheck=").append(this.cyQ).append(", kvStoragePerformanceReportOn=").append(this.leG).append(", pluginPermissionBundleMap=");
    if (this.cyH == null) {}
    for (String str = "0";; str = String.valueOf(this.cyH.size()))
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
    paramParcel.writeString(this.brandName);
    paramParcel.writeString(this.cyB);
    paramParcel.writeString(this.appId);
    paramParcel.writeString(this.jyi);
    byte b;
    if (this.cyC)
    {
      b = 1;
      paramParcel.writeByte(b);
      if (!this.cyD) {
        break label444;
      }
      b = 1;
      label64:
      paramParcel.writeByte(b);
      if (!this.cyE) {
        break label449;
      }
      b = 1;
      label78:
      paramParcel.writeByte(b);
      paramParcel.writeParcelable(this.cyG, paramInt);
      paramParcel.writeInt(this.lex);
      paramParcel.writeInt(this.cyJ);
      paramParcel.writeInt(this.cyK);
      paramParcel.writeInt(this.cyL);
      paramParcel.writeInt(this.cyM);
      paramParcel.writeInt(this.cyN);
      paramParcel.writeInt(this.cyO);
      if (!this.cyP) {
        break label454;
      }
      b = 1;
      label157:
      paramParcel.writeByte(b);
      if (!this.cyQ) {
        break label459;
      }
      b = 1;
      label171:
      paramParcel.writeByte(b);
      paramParcel.writeLong(this.cyR);
      paramParcel.writeInt(this.cyS);
      paramParcel.writeStringList(this.cyT);
      paramParcel.writeStringList(this.cyU);
      paramParcel.writeStringList(this.cyV);
      paramParcel.writeStringList(this.cyW);
      paramParcel.writeStringList(this.cyX);
      paramParcel.writeParcelable(this.leE, paramInt);
      paramParcel.writeParcelable(this.czd, paramInt);
      if (!this.ley) {
        break label464;
      }
      b = 1;
      label259:
      paramParcel.writeByte(b);
      if (!this.lez) {
        break label469;
      }
      b = 1;
      label273:
      paramParcel.writeByte(b);
      paramParcel.writeInt(this.leC);
      paramParcel.writeInt(this.leD);
      paramParcel.writeInt(this.cyZ);
      if (!this.cyY) {
        break label474;
      }
      paramInt = 1;
      label311:
      paramParcel.writeInt(paramInt);
      paramParcel.writeLong(this.czc);
      paramParcel.writeString(this.cyI);
      paramParcel.writeInt(this.cze.length);
      paramParcel.writeStringArray(this.cze);
      paramParcel.writeInt(this.cza);
      paramParcel.writeInt(this.czb);
      paramParcel.writeInt(this.leF);
      if (!this.leG) {
        break label479;
      }
      paramInt = 1;
      label382:
      paramParcel.writeInt(paramInt);
      if (!this.leA) {
        break label484;
      }
      paramInt = 1;
      label396:
      paramParcel.writeInt(paramInt);
      if (!this.leB) {
        break label489;
      }
    }
    label444:
    label449:
    label454:
    label459:
    label464:
    label469:
    label474:
    label479:
    label484:
    label489:
    for (paramInt = i;; paramInt = 0)
    {
      paramParcel.writeInt(paramInt);
      paramParcel.writeLong(this.czf);
      paramParcel.writeMap(this.cyH);
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