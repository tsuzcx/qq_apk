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
import com.tencent.mm.plugin.appbrand.appstorage.o;
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
  public int cBU;
  private String cwP;
  public AppBrandLaunchReferrer cwV;
  public b cxe;
  public String fWY;
  public int launchMode;
  public AppBrandLaunchFromNotifyReferrer nBB;
  public List<String> nBD;
  public HalfScreenConfig nBE;
  public boolean nBF;
  public String nBJ;
  public String nBq;
  public int nBw;
  public PersistableBundle nYe;
  public String nYf;
  public ActivityStarterIpcDelegate pRy;
  public LaunchParamsOptional pZj;
  public long pZk;
  public a<?> pZl;
  public a<Bundle> pZm;
  public PersistableBundle pZn;
  public Parcelable pZo;
  public Parcelable pZp;
  public int pZq;
  public AppBrandStatObject pdk;
  public String username;
  public int version;
  
  static
  {
    AppMethodBeat.i(147326);
    CREATOR = new LaunchParcel.1();
    AppMethodBeat.o(147326);
  }
  
  public LaunchParcel()
  {
    AppMethodBeat.i(245774);
    this.nBw = -1;
    this.pZn = null;
    this.fWY = null;
    this.nBE = HalfScreenConfig.nZJ;
    this.nBF = false;
    this.nBD = new ArrayList();
    this.cxe = b.cBe;
    this.pZq = 0;
    this.nBJ = "";
    AppMethodBeat.o(245774);
  }
  
  private LaunchParcel(Parcel paramParcel)
  {
    AppMethodBeat.i(147323);
    this.nBw = -1;
    this.pZn = null;
    this.fWY = null;
    this.nBE = HalfScreenConfig.nZJ;
    this.nBF = false;
    this.nBD = new ArrayList();
    this.cxe = b.cBe;
    this.pZq = 0;
    this.nBJ = "";
    this.username = paramParcel.readString();
    this.appId = paramParcel.readString();
    this.version = paramParcel.readInt();
    this.cBU = paramParcel.readInt();
    this.nBq = paramParcel.readString();
    this.cwP = paramParcel.readString();
    this.pdk = ((AppBrandStatObject)paramParcel.readParcelable(AppBrandStatObject.class.getClassLoader()));
    this.cwV = ((AppBrandLaunchReferrer)paramParcel.readParcelable(AppBrandLaunchReferrer.class.getClassLoader()));
    this.pZj = ((LaunchParamsOptional)paramParcel.readParcelable(LaunchParamsOptional.class.getClassLoader()));
    this.pZk = paramParcel.readLong();
    this.nYf = paramParcel.readString();
    this.nYe = paramParcel.readPersistableBundle(LaunchParcel.class.getClassLoader());
    this.pRy = ((ActivityStarterIpcDelegate)paramParcel.readParcelable(ActivityStarterIpcDelegate.class.getClassLoader()));
    this.pZl = OnWXAppResultXPCWrapper.a(paramParcel);
    this.nBw = paramParcel.readInt();
    this.pZm = OnWXAppResultXPCWrapper.a(paramParcel);
    this.pZn = paramParcel.readPersistableBundle(LaunchParcel.class.getClassLoader());
    this.fWY = paramParcel.readString();
    this.launchMode = paramParcel.readInt();
    this.nBB = ((AppBrandLaunchFromNotifyReferrer)paramParcel.readParcelable(AppBrandLaunchFromNotifyReferrer.class.getClassLoader()));
    this.pZo = paramParcel.readParcelable(LaunchParcel.class.getClassLoader());
    this.pZp = paramParcel.readParcelable(LaunchParcel.class.getClassLoader());
    paramParcel.readStringList(this.nBD);
    this.nBE = ((HalfScreenConfig)paramParcel.readParcelable(HalfScreenConfig.class.getClassLoader()));
    this.cxe = b.b(paramParcel);
    if (paramParcel.readInt() == 1) {}
    for (boolean bool = true;; bool = false)
    {
      this.nBF = bool;
      this.pZq = paramParcel.readInt();
      this.nBJ = paramParcel.readString();
      AppMethodBeat.o(147323);
      return;
    }
  }
  
  public static String adT(String paramString)
  {
    AppMethodBeat.i(292981);
    paramString = o.adT(paramString);
    AppMethodBeat.o(292981);
    return paramString;
  }
  
  public static String ake(String paramString)
  {
    AppMethodBeat.i(245777);
    if (TextUtils.isEmpty(paramString))
    {
      AppMethodBeat.o(245777);
      return "";
    }
    StringBuilder localStringBuilder = new StringBuilder();
    String str1 = adT(paramString);
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
        AppMethodBeat.o(245777);
        return paramString;
        localStringBuilder.append(str1).append(paramString);
      }
    }
  }
  
  public final void akd(String paramString)
  {
    this.cwP = paramString;
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
    if ((this.pZj != null) && (this.pZj.cwW != null)) {
      paramAppBrandInitConfigLU.cwW.a(this.pZj.cwW);
    }
    paramAppBrandInitConfigLU.nBq = o.adT(this.nBq);
    paramAppBrandInitConfigLU.cwV.a(this.cwV);
    if (this.pZj == null)
    {
      localObject1 = null;
      paramAppBrandInitConfigLU.cwT = ((String)localObject1);
      if (this.pZj != null) {
        break label168;
      }
    }
    label168:
    for (Object localObject1 = localObject2;; localObject1 = this.pZj.cwU)
    {
      paramAppBrandInitConfigLU.cwU = ((String)localObject1);
      paramAppBrandInitConfigLU.startTime = this.pZk;
      paramAppBrandInitConfigLU.cxc = this.pZl;
      paramAppBrandInitConfigLU.cxe = this.cxe;
      paramAppBrandInitConfigLU.dV(this.cwP);
      AppMethodBeat.o(147324);
      return;
      localObject1 = this.pZj.cwT;
      break;
    }
  }
  
  public final String toString()
  {
    AppMethodBeat.i(169496);
    String str = "LaunchParcel{username='" + this.username + '\'' + ", appId='" + this.appId + '\'' + ", version=" + this.version + ", versionType=" + this.cBU + ", enterPath='" + this.nBq + '\'' + ", statObj=" + this.pdk + ", referrer=" + this.cwV + ", startClickTimestamp=" + this.pZk + ", forceKeepOpaque=" + this.nBF + '}';
    AppMethodBeat.o(169496);
    return str;
  }
  
  public final void writeToParcel(Parcel paramParcel, int paramInt)
  {
    AppMethodBeat.i(147322);
    paramParcel.writeString(this.username);
    paramParcel.writeString(this.appId);
    paramParcel.writeInt(this.version);
    paramParcel.writeInt(this.cBU);
    paramParcel.writeString(this.nBq);
    paramParcel.writeString(this.cwP);
    paramParcel.writeParcelable(this.pdk, paramInt);
    paramParcel.writeParcelable(this.cwV, paramInt);
    paramParcel.writeParcelable(this.pZj, paramInt);
    paramParcel.writeLong(this.pZk);
    paramParcel.writeString(this.nYf);
    paramParcel.writePersistableBundle(this.nYe);
    paramParcel.writeParcelable(this.pRy, paramInt);
    OnWXAppResultXPCWrapper.a(this.pZl, paramParcel);
    paramParcel.writeInt(this.nBw);
    OnWXAppResultXPCWrapper.a(this.pZm, paramParcel);
    paramParcel.writePersistableBundle(this.pZn);
    paramParcel.writeString(this.fWY);
    paramParcel.writeInt(this.launchMode);
    paramParcel.writeParcelable(this.nBB, paramInt);
    paramParcel.writeParcelable(this.pZo, paramInt);
    paramParcel.writeParcelable(this.pZp, paramInt);
    paramParcel.writeStringList(this.nBD);
    paramParcel.writeParcelable(this.nBE, paramInt);
    b.a(this.cxe, paramParcel);
    if (this.nBF) {}
    for (paramInt = 1;; paramInt = 0)
    {
      paramParcel.writeInt(paramInt);
      paramParcel.writeInt(this.pZq);
      paramParcel.writeString(this.nBJ);
      AppMethodBeat.o(147322);
      return;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.launching.params.LaunchParcel
 * JD-Core Version:    0.7.0.1
 */