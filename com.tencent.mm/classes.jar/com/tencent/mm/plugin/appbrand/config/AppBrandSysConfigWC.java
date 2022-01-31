package com.tencent.mm.plugin.appbrand.config;

import android.os.Parcel;
import android.os.Parcelable;
import android.os.Parcelable.Creator;
import com.tencent.mm.ipcinvoker.extension.c;
import com.tencent.mm.ipcinvoker.wx_extension.d;
import com.tencent.mm.plugin.appbrand.appcache.WxaPkgWrappingInfo;
import com.tencent.mm.plugin.appbrand.jsapi.g;
import com.tencent.mm.plugin.appbrand.permission.AppRuntimeApiPermissionBundle;
import com.tencent.mm.protocal.c.dv;
import java.util.ArrayList;

public class AppBrandSysConfigWC
  extends i
  implements Parcelable, g
{
  public static final Parcelable.Creator<AppBrandSysConfigWC> CREATOR = new AppBrandSysConfigWC.1();
  public String appId;
  public String bFn;
  public String[] bHW = new String[0];
  public String bJw;
  public String fJX;
  public String fPM;
  public boolean fPN = false;
  public int fPO;
  public boolean fPP;
  public int fPQ;
  public int fPR;
  public final WxaPkgWrappingInfo fPS;
  public boolean fPT = false;
  public boolean fPU = false;
  public boolean fPV = false;
  public AppRuntimeApiPermissionBundle fPW;
  public String fPX;
  public int fPY;
  public int fPZ;
  public boolean fPx = false;
  public int fQa;
  public int fQb;
  public int fQc;
  public int fQd;
  public boolean fQe;
  public long fQf;
  public int fQg;
  public boolean fQh;
  public boolean fQi;
  public ArrayList<String> fQj;
  public ArrayList<String> fQk;
  public ArrayList<String> fQl;
  public ArrayList<String> fQm;
  public boolean fQn;
  public int fQo;
  public long fQp = 0L;
  public AppBrandGlobalSystemConfig fQq;
  public boolean fQr;
  dv fQs;
  public String nickname = "";
  
  public AppBrandSysConfigWC()
  {
    this.fPS = new WxaPkgWrappingInfo();
  }
  
  protected AppBrandSysConfigWC(Parcel paramParcel)
  {
    this.bFn = paramParcel.readString();
    this.bJw = paramParcel.readString();
    this.fJX = paramParcel.readString();
    this.appId = paramParcel.readString();
    this.fPM = paramParcel.readString();
    if (paramParcel.readByte() != 0)
    {
      bool1 = true;
      this.fPN = bool1;
      if (paramParcel.readByte() == 0) {
        break label459;
      }
      bool1 = true;
      label113:
      this.fPT = bool1;
      if (paramParcel.readByte() == 0) {
        break label464;
      }
      bool1 = true;
      label127:
      this.fPU = bool1;
      this.fPW = ((AppRuntimeApiPermissionBundle)paramParcel.readParcelable(AppRuntimeApiPermissionBundle.class.getClassLoader()));
      this.fPO = paramParcel.readInt();
      this.fPY = paramParcel.readInt();
      this.fPZ = paramParcel.readInt();
      this.fQa = paramParcel.readInt();
      this.fQb = paramParcel.readInt();
      this.fQc = paramParcel.readInt();
      this.fQd = paramParcel.readInt();
      if (paramParcel.readByte() == 0) {
        break label469;
      }
      bool1 = true;
      label213:
      this.fQe = bool1;
      this.fQf = paramParcel.readLong();
      this.fQg = paramParcel.readInt();
      if (paramParcel.readByte() == 0) {
        break label474;
      }
      bool1 = true;
      label243:
      this.fQh = bool1;
      if (paramParcel.readByte() == 0) {
        break label479;
      }
      bool1 = true;
      label257:
      this.fQi = bool1;
      this.fQj = paramParcel.createStringArrayList();
      this.fQk = paramParcel.createStringArrayList();
      this.fQl = paramParcel.createStringArrayList();
      this.fQm = paramParcel.createStringArrayList();
      this.fPS = ((WxaPkgWrappingInfo)paramParcel.readParcelable(WxaPkgWrappingInfo.class.getClassLoader()));
      this.fQq = ((AppBrandGlobalSystemConfig)paramParcel.readParcelable(AppBrandGlobalSystemConfig.class.getClassLoader()));
      if (paramParcel.readByte() <= 0) {
        break label484;
      }
      bool1 = true;
      label335:
      this.fPP = bool1;
      this.fPQ = paramParcel.readInt();
      this.fPR = paramParcel.readInt();
      this.fQo = paramParcel.readInt();
      if (paramParcel.readInt() != 1) {
        break label489;
      }
      bool1 = true;
      label374:
      this.fQn = bool1;
      this.fQp = paramParcel.readLong();
      if (paramParcel.readInt() != 1) {
        break label494;
      }
    }
    label459:
    label464:
    label469:
    label474:
    label479:
    label484:
    label489:
    label494:
    for (boolean bool1 = bool2;; bool1 = false)
    {
      this.fQr = bool1;
      this.fPX = paramParcel.readString();
      this.bHW = new String[paramParcel.readInt()];
      paramParcel.readStringArray(this.bHW);
      this.nickname = paramParcel.readString();
      this.fQs = ((dv)c.a(d.class.getName(), paramParcel));
      return;
      bool1 = false;
      break;
      bool1 = false;
      break label113;
      bool1 = false;
      break label127;
      bool1 = false;
      break label213;
      bool1 = false;
      break label243;
      bool1 = false;
      break label257;
      bool1 = false;
      break label335;
      bool1 = false;
      break label374;
    }
  }
  
  public final int aej()
  {
    return this.fPS.fEM;
  }
  
  public final long aek()
  {
    if (this.fQs == null) {
      return 0L;
    }
    return this.fQs.sxr;
  }
  
  public int describeContents()
  {
    return 0;
  }
  
  public String toString()
  {
    return "AppBrandSysConfig{, brandId='" + this.bFn + '\'' + ", brandName='" + this.bJw + '\'' + ", appId='" + this.appId + '\'' + ", appIconUrl='" + this.fPM + '\'' + ", debugEnabled=" + this.fPN + ", performancePanelEnabled=" + this.fPT + ", maxWebViewDepth=" + this.fPO + ", maxBackgroundLifeSpan=" + this.fPY + ", maxRequestConcurrent=" + this.fPZ + ", maxUploadConcurrent=" + this.fQa + ", maxDownloadConcurrent=" + this.fQb + ", maxWebsocketConnect=" + this.fQc + ", websocketSkipPortCheck=" + this.fQe + ", requestDomains=" + this.fQj + ", socketDomains=" + this.fQk + ", uploadDomains=" + this.fQl + ", downloadDomains=" + this.fQm + ", appPkgInfo=" + this.fPS + ", systemSettings=" + this.fQq + ", runningFlag=" + o.a(this.fQs) + ", operationInfo=" + this.fPX + '}';
  }
  
  public void writeToParcel(Parcel paramParcel, int paramInt)
  {
    int i = 1;
    paramParcel.writeString(this.bFn);
    paramParcel.writeString(this.bJw);
    paramParcel.writeString(this.fJX);
    paramParcel.writeString(this.appId);
    paramParcel.writeString(this.fPM);
    byte b;
    if (this.fPN)
    {
      b = 1;
      paramParcel.writeByte(b);
      if (!this.fPT) {
        break label380;
      }
      b = 1;
      label66:
      paramParcel.writeByte(b);
      if (!this.fPU) {
        break label385;
      }
      b = 1;
      label80:
      paramParcel.writeByte(b);
      paramParcel.writeParcelable(this.fPW, paramInt);
      paramParcel.writeInt(this.fPO);
      paramParcel.writeInt(this.fPY);
      paramParcel.writeInt(this.fPZ);
      paramParcel.writeInt(this.fQa);
      paramParcel.writeInt(this.fQb);
      paramParcel.writeInt(this.fQc);
      paramParcel.writeInt(this.fQd);
      if (!this.fQe) {
        break label390;
      }
      b = 1;
      label159:
      paramParcel.writeByte(b);
      paramParcel.writeLong(this.fQf);
      paramParcel.writeInt(this.fQg);
      if (!this.fQh) {
        break label395;
      }
      b = 1;
      label189:
      paramParcel.writeByte(b);
      if (!this.fQi) {
        break label400;
      }
      b = 1;
      label203:
      paramParcel.writeByte(b);
      paramParcel.writeStringList(this.fQj);
      paramParcel.writeStringList(this.fQk);
      paramParcel.writeStringList(this.fQl);
      paramParcel.writeStringList(this.fQm);
      paramParcel.writeParcelable(this.fPS, paramInt);
      paramParcel.writeParcelable(this.fQq, paramInt);
      if (!this.fPP) {
        break label405;
      }
      b = 1;
      label267:
      paramParcel.writeByte(b);
      paramParcel.writeInt(this.fPQ);
      paramParcel.writeInt(this.fPR);
      paramParcel.writeInt(this.fQo);
      if (!this.fQn) {
        break label410;
      }
      paramInt = 1;
      label305:
      paramParcel.writeInt(paramInt);
      paramParcel.writeLong(this.fQp);
      if (!this.fQr) {
        break label415;
      }
    }
    label385:
    label390:
    label395:
    label400:
    label405:
    label410:
    label415:
    for (paramInt = i;; paramInt = 0)
    {
      paramParcel.writeInt(paramInt);
      paramParcel.writeString(this.fPX);
      paramParcel.writeInt(this.bHW.length);
      paramParcel.writeStringArray(this.bHW);
      paramParcel.writeString(this.nickname);
      c.a(this.fQs, paramParcel);
      return;
      b = 0;
      break;
      label380:
      b = 0;
      break label66;
      b = 0;
      break label80;
      b = 0;
      break label159;
      b = 0;
      break label189;
      b = 0;
      break label203;
      b = 0;
      break label267;
      paramInt = 0;
      break label305;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.config.AppBrandSysConfigWC
 * JD-Core Version:    0.7.0.1
 */