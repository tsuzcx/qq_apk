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
  public AppBrandLaunchReferrer cfi;
  public int gXn;
  public String iJb;
  public int iJh;
  public String iJl;
  public String iJm;
  public AppBrandLaunchFromNotifyReferrer iJn;
  public PersistableBundle jdo;
  public String jdp;
  public ActivityStarterIpcDelegate kFX;
  public AppBrandStatObject kOh;
  public LaunchParamsOptional kOi;
  public long kOj;
  public a<?> kOk;
  public a<Bundle> kOl;
  public PersistableBundle kOm;
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
    this.iJh = -1;
    this.kOm = null;
    this.iJl = null;
  }
  
  private LaunchParcel(Parcel paramParcel)
  {
    AppMethodBeat.i(147323);
    this.iJh = -1;
    this.kOm = null;
    this.iJl = null;
    this.username = paramParcel.readString();
    this.appId = paramParcel.readString();
    this.version = paramParcel.readInt();
    this.gXn = paramParcel.readInt();
    this.iJb = paramParcel.readString();
    this.kOh = ((AppBrandStatObject)paramParcel.readParcelable(AppBrandStatObject.class.getClassLoader()));
    this.cfi = ((AppBrandLaunchReferrer)paramParcel.readParcelable(AppBrandLaunchReferrer.class.getClassLoader()));
    this.kOi = ((LaunchParamsOptional)paramParcel.readParcelable(LaunchParamsOptional.class.getClassLoader()));
    this.kOj = paramParcel.readLong();
    this.jdp = paramParcel.readString();
    this.jdo = paramParcel.readPersistableBundle(LaunchParcel.class.getClassLoader());
    this.kFX = ((ActivityStarterIpcDelegate)paramParcel.readParcelable(ActivityStarterIpcDelegate.class.getClassLoader()));
    this.kOk = OnWXAppResultXPCWrapper.a(paramParcel);
    this.iJh = paramParcel.readInt();
    this.kOl = OnWXAppResultXPCWrapper.a(paramParcel);
    this.kOm = paramParcel.readPersistableBundle(LaunchParcel.class.getClassLoader());
    this.iJl = paramParcel.readString();
    this.launchMode = paramParcel.readInt();
    this.iJm = paramParcel.readString();
    this.iJn = ((AppBrandLaunchFromNotifyReferrer)paramParcel.readParcelable(AppBrandLaunchFromNotifyReferrer.class.getClassLoader()));
    AppMethodBeat.o(147323);
  }
  
  public static String EW(String paramString)
  {
    AppMethodBeat.i(202258);
    paramString = m.EW(paramString);
    AppMethodBeat.o(202258);
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
    if ((this.kOi != null) && (this.kOi.cfj != null)) {
      paramAppBrandInitConfigLU.cfj.a(this.kOi.cfj);
    }
    paramAppBrandInitConfigLU.iJb = m.EW(this.iJb);
    paramAppBrandInitConfigLU.cfi.a(this.cfi);
    if (this.kOi == null)
    {
      localObject1 = null;
      paramAppBrandInitConfigLU.cff = ((String)localObject1);
      if (this.kOi != null) {
        break label149;
      }
    }
    label149:
    for (Object localObject1 = localObject2;; localObject1 = this.kOi.cfh)
    {
      paramAppBrandInitConfigLU.cfh = ((String)localObject1);
      paramAppBrandInitConfigLU.startTime = this.kOj;
      paramAppBrandInitConfigLU.cfm = this.kOk;
      AppMethodBeat.o(147324);
      return;
      localObject1 = this.kOi.cff;
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
    String str = "LaunchParcel{username='" + this.username + '\'' + ", appId='" + this.appId + '\'' + ", version=" + this.version + ", versionType=" + this.gXn + ", enterPath='" + this.iJb + '\'' + ", statObj=" + this.kOh + ", referrer=" + this.cfi + ", startClickTimestamp=" + this.kOj + '}';
    AppMethodBeat.o(169496);
    return str;
  }
  
  public final void writeToParcel(Parcel paramParcel, int paramInt)
  {
    AppMethodBeat.i(147322);
    paramParcel.writeString(this.username);
    paramParcel.writeString(this.appId);
    paramParcel.writeInt(this.version);
    paramParcel.writeInt(this.gXn);
    paramParcel.writeString(this.iJb);
    paramParcel.writeParcelable(this.kOh, paramInt);
    paramParcel.writeParcelable(this.cfi, paramInt);
    paramParcel.writeParcelable(this.kOi, paramInt);
    paramParcel.writeLong(this.kOj);
    paramParcel.writeString(this.jdp);
    paramParcel.writePersistableBundle(this.jdo);
    paramParcel.writeParcelable(this.kFX, paramInt);
    OnWXAppResultXPCWrapper.a(this.kOk, paramParcel);
    paramParcel.writeInt(this.iJh);
    OnWXAppResultXPCWrapper.a(this.kOl, paramParcel);
    paramParcel.writePersistableBundle(this.kOm);
    paramParcel.writeString(this.iJl);
    paramParcel.writeInt(this.launchMode);
    paramParcel.writeString(this.iJm);
    paramParcel.writeParcelable(this.iJn, paramInt);
    AppMethodBeat.o(147322);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.launching.params.LaunchParcel
 * JD-Core Version:    0.7.0.1
 */