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
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.modelappbrand.LaunchParamsOptional;
import com.tencent.mm.plugin.appbrand.appstorage.m;
import com.tencent.mm.plugin.appbrand.config.AppBrandLaunchFromNotifyReferrer;
import com.tencent.mm.plugin.appbrand.config.AppBrandLaunchReferrer;
import com.tencent.mm.plugin.appbrand.config.AppBrandWeishiParams;
import com.tencent.mm.plugin.appbrand.report.AppBrandStatObject;

public final class LaunchParcel
  implements Parcelable
{
  public static final Parcelable.Creator<LaunchParcel> CREATOR;
  public String appId;
  public AppBrandLaunchReferrer cmv;
  public int hQh;
  public String jCN;
  public int jCT;
  public String jCX;
  public AppBrandLaunchFromNotifyReferrer jCZ;
  public PersistableBundle jXx;
  public String jXy;
  public ActivityStarterIpcDelegate lEq;
  public AppBrandStatObject lMZ;
  public LaunchParamsOptional lNa;
  public long lNb;
  public a<?> lNc;
  public a<Bundle> lNd;
  public PersistableBundle lNe;
  public Parcelable lNf;
  public Parcelable lNg;
  public int launchMode;
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
    this.jCT = -1;
    this.lNe = null;
    this.jCX = null;
  }
  
  private LaunchParcel(Parcel paramParcel)
  {
    AppMethodBeat.i(147323);
    this.jCT = -1;
    this.lNe = null;
    this.jCX = null;
    this.username = paramParcel.readString();
    this.appId = paramParcel.readString();
    this.version = paramParcel.readInt();
    this.hQh = paramParcel.readInt();
    this.jCN = paramParcel.readString();
    this.lMZ = ((AppBrandStatObject)paramParcel.readParcelable(AppBrandStatObject.class.getClassLoader()));
    this.cmv = ((AppBrandLaunchReferrer)paramParcel.readParcelable(AppBrandLaunchReferrer.class.getClassLoader()));
    this.lNa = ((LaunchParamsOptional)paramParcel.readParcelable(LaunchParamsOptional.class.getClassLoader()));
    this.lNb = paramParcel.readLong();
    this.jXy = paramParcel.readString();
    this.jXx = paramParcel.readPersistableBundle(LaunchParcel.class.getClassLoader());
    this.lEq = ((ActivityStarterIpcDelegate)paramParcel.readParcelable(ActivityStarterIpcDelegate.class.getClassLoader()));
    this.lNc = OnWXAppResultXPCWrapper.a(paramParcel);
    this.jCT = paramParcel.readInt();
    this.lNd = OnWXAppResultXPCWrapper.a(paramParcel);
    this.lNe = paramParcel.readPersistableBundle(LaunchParcel.class.getClassLoader());
    this.jCX = paramParcel.readString();
    this.launchMode = paramParcel.readInt();
    this.jCZ = ((AppBrandLaunchFromNotifyReferrer)paramParcel.readParcelable(AppBrandLaunchFromNotifyReferrer.class.getClassLoader()));
    this.lNf = paramParcel.readParcelable(LaunchParcel.class.getClassLoader());
    this.lNg = paramParcel.readParcelable(LaunchParcel.class.getClassLoader());
    AppMethodBeat.o(147323);
  }
  
  public static String Mq(String paramString)
  {
    AppMethodBeat.i(221599);
    paramString = m.Mq(paramString);
    AppMethodBeat.o(221599);
    return paramString;
  }
  
  public final void d(AppBrandInitConfigLU paramAppBrandInitConfigLU)
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
    if ((this.lNa != null) && (this.lNa.cmw != null)) {
      paramAppBrandInitConfigLU.cmw.a(this.lNa.cmw);
    }
    paramAppBrandInitConfigLU.jCN = m.Mq(this.jCN);
    paramAppBrandInitConfigLU.cmv.a(this.cmv);
    if (this.lNa == null)
    {
      localObject1 = null;
      paramAppBrandInitConfigLU.cmt = ((String)localObject1);
      if (this.lNa != null) {
        break label149;
      }
    }
    label149:
    for (Object localObject1 = localObject2;; localObject1 = this.lNa.cmu)
    {
      paramAppBrandInitConfigLU.cmu = ((String)localObject1);
      paramAppBrandInitConfigLU.startTime = this.lNb;
      paramAppBrandInitConfigLU.cmA = this.lNc;
      AppMethodBeat.o(147324);
      return;
      localObject1 = this.lNa.cmt;
      break;
    }
  }
  
  public final int describeContents()
  {
    return 0;
  }
  
  public final String toString()
  {
    AppMethodBeat.i(169496);
    String str = "LaunchParcel{username='" + this.username + '\'' + ", appId='" + this.appId + '\'' + ", version=" + this.version + ", versionType=" + this.hQh + ", enterPath='" + this.jCN + '\'' + ", statObj=" + this.lMZ + ", referrer=" + this.cmv + ", startClickTimestamp=" + this.lNb + '}';
    AppMethodBeat.o(169496);
    return str;
  }
  
  public final void writeToParcel(Parcel paramParcel, int paramInt)
  {
    AppMethodBeat.i(147322);
    paramParcel.writeString(this.username);
    paramParcel.writeString(this.appId);
    paramParcel.writeInt(this.version);
    paramParcel.writeInt(this.hQh);
    paramParcel.writeString(this.jCN);
    paramParcel.writeParcelable(this.lMZ, paramInt);
    paramParcel.writeParcelable(this.cmv, paramInt);
    paramParcel.writeParcelable(this.lNa, paramInt);
    paramParcel.writeLong(this.lNb);
    paramParcel.writeString(this.jXy);
    paramParcel.writePersistableBundle(this.jXx);
    paramParcel.writeParcelable(this.lEq, paramInt);
    OnWXAppResultXPCWrapper.a(this.lNc, paramParcel);
    paramParcel.writeInt(this.jCT);
    OnWXAppResultXPCWrapper.a(this.lNd, paramParcel);
    paramParcel.writePersistableBundle(this.lNe);
    paramParcel.writeString(this.jCX);
    paramParcel.writeInt(this.launchMode);
    paramParcel.writeParcelable(this.jCZ, paramInt);
    paramParcel.writeParcelable(this.lNf, paramInt);
    paramParcel.writeParcelable(this.lNg, paramInt);
    AppMethodBeat.o(147322);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.launching.params.LaunchParcel
 * JD-Core Version:    0.7.0.1
 */