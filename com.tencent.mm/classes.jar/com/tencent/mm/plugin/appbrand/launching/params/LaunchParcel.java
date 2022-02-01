package com.tencent.mm.plugin.appbrand.launching.params;

import android.os.Bundle;
import android.os.Parcel;
import android.os.Parcelable;
import android.os.Parcelable.Creator;
import android.os.PersistableBundle;
import android.text.TextUtils;
import com.tencent.luggage.sdk.config.AppBrandInitConfigLU;
import com.tencent.luggage.sdk.launching.ActivityStarterIpcDelegate;
import com.tencent.luggage.sdk.launching.OnWXAppResultXPCWrapper;
import com.tencent.luggage.sdk.launching.a;
import com.tencent.luggage.sdk.launching.b;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.modelappbrand.LaunchParamsOptional;
import com.tencent.mm.plugin.appbrand.appstorage.n;
import com.tencent.mm.plugin.appbrand.config.AppBrandLaunchFromNotifyReferrer;
import com.tencent.mm.plugin.appbrand.config.AppBrandLaunchReferrer;
import com.tencent.mm.plugin.appbrand.config.AppBrandWeishiParams;
import com.tencent.mm.plugin.appbrand.config.HalfScreenConfig;
import com.tencent.mm.plugin.appbrand.report.AppBrandStatObject;
import java.util.ArrayList;
import java.util.List;

public final class LaunchParcel
  implements Parcelable
{
  public static final Parcelable.Creator<LaunchParcel> CREATOR;
  public String appId;
  private String cym;
  public AppBrandLaunchReferrer cys;
  public b cyz;
  public int iOo;
  public int kHC;
  public String kHG;
  public AppBrandLaunchFromNotifyReferrer kHI;
  public List<String> kHK;
  public HalfScreenConfig kHL;
  public boolean kHM;
  public String kHQ;
  public String kHw;
  public int launchMode;
  public PersistableBundle ldQ;
  public String ldR;
  public ActivityStarterIpcDelegate mQC;
  public AppBrandStatObject mYK;
  public LaunchParamsOptional mYL;
  public long mYM;
  public a<?> mYN;
  public a<Bundle> mYO;
  public PersistableBundle mYP;
  public Parcelable mYQ;
  public Parcelable mYR;
  public int mYS;
  public String username;
  public int version;
  
  static
  {
    AppMethodBeat.i(147326);
    CREATOR = new Parcelable.Creator() {};
    AppMethodBeat.o(147326);
  }
  
  public LaunchParcel()
  {
    AppMethodBeat.i(229921);
    this.kHC = -1;
    this.mYP = null;
    this.kHG = null;
    this.kHL = HalfScreenConfig.lfr;
    this.kHM = false;
    this.kHK = new ArrayList();
    this.cyz = b.cBB;
    this.mYS = 0;
    this.kHQ = "";
    AppMethodBeat.o(229921);
  }
  
  private LaunchParcel(Parcel paramParcel)
  {
    AppMethodBeat.i(147323);
    this.kHC = -1;
    this.mYP = null;
    this.kHG = null;
    this.kHL = HalfScreenConfig.lfr;
    this.kHM = false;
    this.kHK = new ArrayList();
    this.cyz = b.cBB;
    this.mYS = 0;
    this.kHQ = "";
    this.username = paramParcel.readString();
    this.appId = paramParcel.readString();
    this.version = paramParcel.readInt();
    this.iOo = paramParcel.readInt();
    this.kHw = paramParcel.readString();
    this.cym = paramParcel.readString();
    this.mYK = ((AppBrandStatObject)paramParcel.readParcelable(AppBrandStatObject.class.getClassLoader()));
    this.cys = ((AppBrandLaunchReferrer)paramParcel.readParcelable(AppBrandLaunchReferrer.class.getClassLoader()));
    this.mYL = ((LaunchParamsOptional)paramParcel.readParcelable(LaunchParamsOptional.class.getClassLoader()));
    this.mYM = paramParcel.readLong();
    this.ldR = paramParcel.readString();
    this.ldQ = paramParcel.readPersistableBundle(LaunchParcel.class.getClassLoader());
    this.mQC = ((ActivityStarterIpcDelegate)paramParcel.readParcelable(ActivityStarterIpcDelegate.class.getClassLoader()));
    this.mYN = OnWXAppResultXPCWrapper.a(paramParcel);
    this.kHC = paramParcel.readInt();
    this.mYO = OnWXAppResultXPCWrapper.a(paramParcel);
    this.mYP = paramParcel.readPersistableBundle(LaunchParcel.class.getClassLoader());
    this.kHG = paramParcel.readString();
    this.launchMode = paramParcel.readInt();
    this.kHI = ((AppBrandLaunchFromNotifyReferrer)paramParcel.readParcelable(AppBrandLaunchFromNotifyReferrer.class.getClassLoader()));
    this.mYQ = paramParcel.readParcelable(LaunchParcel.class.getClassLoader());
    this.mYR = paramParcel.readParcelable(LaunchParcel.class.getClassLoader());
    paramParcel.readStringList(this.kHK);
    this.kHL = ((HalfScreenConfig)paramParcel.readParcelable(HalfScreenConfig.class.getClassLoader()));
    this.cyz = b.b(paramParcel);
    if (paramParcel.readInt() == 1) {}
    for (boolean bool = true;; bool = false)
    {
      this.kHM = bool;
      this.mYS = paramParcel.readInt();
      this.kHQ = paramParcel.readString();
      AppMethodBeat.o(147323);
      return;
    }
  }
  
  public static String Wf(String paramString)
  {
    AppMethodBeat.i(258559);
    paramString = n.Wf(paramString);
    AppMethodBeat.o(258559);
    return paramString;
  }
  
  public static String ack(String paramString)
  {
    AppMethodBeat.i(229923);
    if (TextUtils.isEmpty(paramString))
    {
      AppMethodBeat.o(229923);
      return "";
    }
    StringBuilder localStringBuilder = new StringBuilder();
    String str1 = Wf(paramString);
    paramString = "";
    int i = str1.lastIndexOf("?");
    if (i != -1)
    {
      paramString = str1.substring(0, i);
      String str2 = str1.substring(i);
      str1 = paramString;
      paramString = str2;
    }
    for (;;)
    {
      if ((!TextUtils.isEmpty(str1)) && (!str1.endsWith(".html"))) {
        localStringBuilder.append(str1).append(".html").append(paramString);
      }
      for (;;)
      {
        paramString = localStringBuilder.toString();
        AppMethodBeat.o(229923);
        return paramString;
        localStringBuilder.append(str1).append(paramString);
      }
    }
  }
  
  public final void acj(String paramString)
  {
    this.cym = paramString;
  }
  
  public final int describeContents()
  {
    return 0;
  }
  
  public final void f(AppBrandInitConfigLU paramAppBrandInitConfigLU)
  {
    Object localObject2 = null;
    AppMethodBeat.i(147324);
    if (paramAppBrandInitConfigLU == null)
    {
      AppMethodBeat.o(147324);
      return;
    }
    if (TextUtils.isEmpty(paramAppBrandInitConfigLU.username)) {
      paramAppBrandInitConfigLU.username = this.username;
    }
    if ((this.mYL != null) && (this.mYL.cyt != null)) {
      paramAppBrandInitConfigLU.cyt.a(this.mYL.cyt);
    }
    paramAppBrandInitConfigLU.kHw = n.Wf(this.kHw);
    paramAppBrandInitConfigLU.cys.a(this.cys);
    if (this.mYL == null)
    {
      localObject1 = null;
      paramAppBrandInitConfigLU.cyq = ((String)localObject1);
      if (this.mYL != null) {
        break label168;
      }
    }
    label168:
    for (Object localObject1 = localObject2;; localObject1 = this.mYL.cyr)
    {
      paramAppBrandInitConfigLU.cyr = ((String)localObject1);
      paramAppBrandInitConfigLU.startTime = this.mYM;
      paramAppBrandInitConfigLU.cyx = this.mYN;
      paramAppBrandInitConfigLU.cyz = this.cyz;
      paramAppBrandInitConfigLU.dB(this.cym);
      AppMethodBeat.o(147324);
      return;
      localObject1 = this.mYL.cyq;
      break;
    }
  }
  
  public final String toString()
  {
    AppMethodBeat.i(169496);
    String str = "LaunchParcel{username='" + this.username + '\'' + ", appId='" + this.appId + '\'' + ", version=" + this.version + ", versionType=" + this.iOo + ", enterPath='" + this.kHw + '\'' + ", statObj=" + this.mYK + ", referrer=" + this.cys + ", startClickTimestamp=" + this.mYM + ", forceKeepOpaque=" + this.kHM + '}';
    AppMethodBeat.o(169496);
    return str;
  }
  
  public final void writeToParcel(Parcel paramParcel, int paramInt)
  {
    AppMethodBeat.i(147322);
    paramParcel.writeString(this.username);
    paramParcel.writeString(this.appId);
    paramParcel.writeInt(this.version);
    paramParcel.writeInt(this.iOo);
    paramParcel.writeString(this.kHw);
    paramParcel.writeString(this.cym);
    paramParcel.writeParcelable(this.mYK, paramInt);
    paramParcel.writeParcelable(this.cys, paramInt);
    paramParcel.writeParcelable(this.mYL, paramInt);
    paramParcel.writeLong(this.mYM);
    paramParcel.writeString(this.ldR);
    paramParcel.writePersistableBundle(this.ldQ);
    paramParcel.writeParcelable(this.mQC, paramInt);
    OnWXAppResultXPCWrapper.a(this.mYN, paramParcel);
    paramParcel.writeInt(this.kHC);
    OnWXAppResultXPCWrapper.a(this.mYO, paramParcel);
    paramParcel.writePersistableBundle(this.mYP);
    paramParcel.writeString(this.kHG);
    paramParcel.writeInt(this.launchMode);
    paramParcel.writeParcelable(this.kHI, paramInt);
    paramParcel.writeParcelable(this.mYQ, paramInt);
    paramParcel.writeParcelable(this.mYR, paramInt);
    paramParcel.writeStringList(this.kHK);
    paramParcel.writeParcelable(this.kHL, paramInt);
    b.a(this.cyz, paramParcel);
    if (this.kHM) {}
    for (paramInt = 1;; paramInt = 0)
    {
      paramParcel.writeInt(paramInt);
      paramParcel.writeInt(this.mYS);
      paramParcel.writeString(this.kHQ);
      AppMethodBeat.o(147322);
      return;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.launching.params.LaunchParcel
 * JD-Core Version:    0.7.0.1
 */