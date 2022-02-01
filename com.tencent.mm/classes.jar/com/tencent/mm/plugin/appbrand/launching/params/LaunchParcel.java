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
  public AppBrandLaunchReferrer cce;
  public int hxM;
  public PersistableBundle jDB;
  public String jDC;
  public String jjf;
  public int jjl;
  public String jjp;
  public String jjq;
  public AppBrandLaunchFromNotifyReferrer jjr;
  public int launchMode;
  public ActivityStarterIpcDelegate lhq;
  public AppBrandStatObject lpG;
  public LaunchParamsOptional lpH;
  public long lpI;
  public a<?> lpJ;
  public a<Bundle> lpK;
  public PersistableBundle lpL;
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
    this.jjl = -1;
    this.lpL = null;
    this.jjp = null;
  }
  
  private LaunchParcel(Parcel paramParcel)
  {
    AppMethodBeat.i(147323);
    this.jjl = -1;
    this.lpL = null;
    this.jjp = null;
    this.username = paramParcel.readString();
    this.appId = paramParcel.readString();
    this.version = paramParcel.readInt();
    this.hxM = paramParcel.readInt();
    this.jjf = paramParcel.readString();
    this.lpG = ((AppBrandStatObject)paramParcel.readParcelable(AppBrandStatObject.class.getClassLoader()));
    this.cce = ((AppBrandLaunchReferrer)paramParcel.readParcelable(AppBrandLaunchReferrer.class.getClassLoader()));
    this.lpH = ((LaunchParamsOptional)paramParcel.readParcelable(LaunchParamsOptional.class.getClassLoader()));
    this.lpI = paramParcel.readLong();
    this.jDC = paramParcel.readString();
    this.jDB = paramParcel.readPersistableBundle(LaunchParcel.class.getClassLoader());
    this.lhq = ((ActivityStarterIpcDelegate)paramParcel.readParcelable(ActivityStarterIpcDelegate.class.getClassLoader()));
    this.lpJ = OnWXAppResultXPCWrapper.a(paramParcel);
    this.jjl = paramParcel.readInt();
    this.lpK = OnWXAppResultXPCWrapper.a(paramParcel);
    this.lpL = paramParcel.readPersistableBundle(LaunchParcel.class.getClassLoader());
    this.jjp = paramParcel.readString();
    this.launchMode = paramParcel.readInt();
    this.jjq = paramParcel.readString();
    this.jjr = ((AppBrandLaunchFromNotifyReferrer)paramParcel.readParcelable(AppBrandLaunchFromNotifyReferrer.class.getClassLoader()));
    AppMethodBeat.o(147323);
  }
  
  public static String IZ(String paramString)
  {
    AppMethodBeat.i(210396);
    paramString = m.IZ(paramString);
    AppMethodBeat.o(210396);
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
    if ((this.lpH != null) && (this.lpH.ccf != null)) {
      paramAppBrandInitConfigLU.ccf.a(this.lpH.ccf);
    }
    paramAppBrandInitConfigLU.jjf = m.IZ(this.jjf);
    paramAppBrandInitConfigLU.cce.a(this.cce);
    if (this.lpH == null)
    {
      localObject1 = null;
      paramAppBrandInitConfigLU.ccc = ((String)localObject1);
      if (this.lpH != null) {
        break label149;
      }
    }
    label149:
    for (Object localObject1 = localObject2;; localObject1 = this.lpH.ccd)
    {
      paramAppBrandInitConfigLU.ccd = ((String)localObject1);
      paramAppBrandInitConfigLU.startTime = this.lpI;
      paramAppBrandInitConfigLU.ccj = this.lpJ;
      AppMethodBeat.o(147324);
      return;
      localObject1 = this.lpH.ccc;
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
    String str = "LaunchParcel{username='" + this.username + '\'' + ", appId='" + this.appId + '\'' + ", version=" + this.version + ", versionType=" + this.hxM + ", enterPath='" + this.jjf + '\'' + ", statObj=" + this.lpG + ", referrer=" + this.cce + ", startClickTimestamp=" + this.lpI + '}';
    AppMethodBeat.o(169496);
    return str;
  }
  
  public final void writeToParcel(Parcel paramParcel, int paramInt)
  {
    AppMethodBeat.i(147322);
    paramParcel.writeString(this.username);
    paramParcel.writeString(this.appId);
    paramParcel.writeInt(this.version);
    paramParcel.writeInt(this.hxM);
    paramParcel.writeString(this.jjf);
    paramParcel.writeParcelable(this.lpG, paramInt);
    paramParcel.writeParcelable(this.cce, paramInt);
    paramParcel.writeParcelable(this.lpH, paramInt);
    paramParcel.writeLong(this.lpI);
    paramParcel.writeString(this.jDC);
    paramParcel.writePersistableBundle(this.jDB);
    paramParcel.writeParcelable(this.lhq, paramInt);
    OnWXAppResultXPCWrapper.a(this.lpJ, paramParcel);
    paramParcel.writeInt(this.jjl);
    OnWXAppResultXPCWrapper.a(this.lpK, paramParcel);
    paramParcel.writePersistableBundle(this.lpL);
    paramParcel.writeString(this.jjp);
    paramParcel.writeInt(this.launchMode);
    paramParcel.writeString(this.jjq);
    paramParcel.writeParcelable(this.jjr, paramInt);
    AppMethodBeat.o(147322);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.launching.params.LaunchParcel
 * JD-Core Version:    0.7.0.1
 */