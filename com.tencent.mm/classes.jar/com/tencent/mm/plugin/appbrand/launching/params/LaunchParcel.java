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
import com.tencent.mm.plugin.appbrand.appstorage.n;
import com.tencent.mm.plugin.appbrand.config.AppBrandLaunchFromNotifyReferrer;
import com.tencent.mm.plugin.appbrand.config.AppBrandLaunchReferrer;
import com.tencent.mm.plugin.appbrand.config.AppBrandWeishiParams;
import com.tencent.mm.plugin.appbrand.report.AppBrandStatObject;

public final class LaunchParcel
  implements Parcelable
{
  public static final Parcelable.Creator<LaunchParcel> CREATOR;
  public String appId;
  public AppBrandLaunchReferrer cmx;
  public int hSZ;
  public String jFL;
  public int jFR;
  public String jFV;
  public AppBrandLaunchFromNotifyReferrer jFX;
  public PersistableBundle kaM;
  public String kaN;
  public ActivityStarterIpcDelegate lIP;
  public AppBrandStatObject lRA;
  public LaunchParamsOptional lRB;
  public long lRC;
  public a<?> lRD;
  public a<Bundle> lRE;
  public PersistableBundle lRF;
  public Parcelable lRG;
  public Parcelable lRH;
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
    this.jFR = -1;
    this.lRF = null;
    this.jFV = null;
  }
  
  private LaunchParcel(Parcel paramParcel)
  {
    AppMethodBeat.i(147323);
    this.jFR = -1;
    this.lRF = null;
    this.jFV = null;
    this.username = paramParcel.readString();
    this.appId = paramParcel.readString();
    this.version = paramParcel.readInt();
    this.hSZ = paramParcel.readInt();
    this.jFL = paramParcel.readString();
    this.lRA = ((AppBrandStatObject)paramParcel.readParcelable(AppBrandStatObject.class.getClassLoader()));
    this.cmx = ((AppBrandLaunchReferrer)paramParcel.readParcelable(AppBrandLaunchReferrer.class.getClassLoader()));
    this.lRB = ((LaunchParamsOptional)paramParcel.readParcelable(LaunchParamsOptional.class.getClassLoader()));
    this.lRC = paramParcel.readLong();
    this.kaN = paramParcel.readString();
    this.kaM = paramParcel.readPersistableBundle(LaunchParcel.class.getClassLoader());
    this.lIP = ((ActivityStarterIpcDelegate)paramParcel.readParcelable(ActivityStarterIpcDelegate.class.getClassLoader()));
    this.lRD = OnWXAppResultXPCWrapper.a(paramParcel);
    this.jFR = paramParcel.readInt();
    this.lRE = OnWXAppResultXPCWrapper.a(paramParcel);
    this.lRF = paramParcel.readPersistableBundle(LaunchParcel.class.getClassLoader());
    this.jFV = paramParcel.readString();
    this.launchMode = paramParcel.readInt();
    this.jFX = ((AppBrandLaunchFromNotifyReferrer)paramParcel.readParcelable(AppBrandLaunchFromNotifyReferrer.class.getClassLoader()));
    this.lRG = paramParcel.readParcelable(LaunchParcel.class.getClassLoader());
    this.lRH = paramParcel.readParcelable(LaunchParcel.class.getClassLoader());
    AppMethodBeat.o(147323);
  }
  
  public static String MW(String paramString)
  {
    AppMethodBeat.i(224456);
    paramString = n.MW(paramString);
    AppMethodBeat.o(224456);
    return paramString;
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
    if ((this.lRB != null) && (this.lRB.cmy != null)) {
      paramAppBrandInitConfigLU.cmy.a(this.lRB.cmy);
    }
    paramAppBrandInitConfigLU.jFL = n.MW(this.jFL);
    paramAppBrandInitConfigLU.cmx.a(this.cmx);
    if (this.lRB == null)
    {
      localObject1 = null;
      paramAppBrandInitConfigLU.cmv = ((String)localObject1);
      if (this.lRB != null) {
        break label149;
      }
    }
    label149:
    for (Object localObject1 = localObject2;; localObject1 = this.lRB.cmw)
    {
      paramAppBrandInitConfigLU.cmw = ((String)localObject1);
      paramAppBrandInitConfigLU.startTime = this.lRC;
      paramAppBrandInitConfigLU.cmC = this.lRD;
      AppMethodBeat.o(147324);
      return;
      localObject1 = this.lRB.cmv;
      break;
    }
  }
  
  public final String toString()
  {
    AppMethodBeat.i(169496);
    String str = "LaunchParcel{username='" + this.username + '\'' + ", appId='" + this.appId + '\'' + ", version=" + this.version + ", versionType=" + this.hSZ + ", enterPath='" + this.jFL + '\'' + ", statObj=" + this.lRA + ", referrer=" + this.cmx + ", startClickTimestamp=" + this.lRC + '}';
    AppMethodBeat.o(169496);
    return str;
  }
  
  public final void writeToParcel(Parcel paramParcel, int paramInt)
  {
    AppMethodBeat.i(147322);
    paramParcel.writeString(this.username);
    paramParcel.writeString(this.appId);
    paramParcel.writeInt(this.version);
    paramParcel.writeInt(this.hSZ);
    paramParcel.writeString(this.jFL);
    paramParcel.writeParcelable(this.lRA, paramInt);
    paramParcel.writeParcelable(this.cmx, paramInt);
    paramParcel.writeParcelable(this.lRB, paramInt);
    paramParcel.writeLong(this.lRC);
    paramParcel.writeString(this.kaN);
    paramParcel.writePersistableBundle(this.kaM);
    paramParcel.writeParcelable(this.lIP, paramInt);
    OnWXAppResultXPCWrapper.a(this.lRD, paramParcel);
    paramParcel.writeInt(this.jFR);
    OnWXAppResultXPCWrapper.a(this.lRE, paramParcel);
    paramParcel.writePersistableBundle(this.lRF);
    paramParcel.writeString(this.jFV);
    paramParcel.writeInt(this.launchMode);
    paramParcel.writeParcelable(this.jFX, paramInt);
    paramParcel.writeParcelable(this.lRG, paramInt);
    paramParcel.writeParcelable(this.lRH, paramInt);
    AppMethodBeat.o(147322);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.launching.params.LaunchParcel
 * JD-Core Version:    0.7.0.1
 */