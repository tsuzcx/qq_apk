package com.tencent.mm.plugin.appbrand.launching.params;

import android.os.Parcel;
import android.os.Parcelable;
import android.os.Parcelable.Creator;
import android.text.TextUtils;
import com.tencent.luggage.g.e.a;
import com.tencent.luggage.sdk.config.AppBrandInitConfigLU;
import com.tencent.luggage.sdk.launching.ActivityStarterIpcDelegate;
import com.tencent.luggage.sdk.launching.OnWXAppResultXPCWrapper;
import com.tencent.luggage.sdk.launching.b;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.modelappbrand.LaunchParamsOptional;
import com.tencent.mm.plugin.appbrand.config.AppBrandLaunchReferrer;
import com.tencent.mm.plugin.appbrand.report.AppBrandStatObject;

public final class LaunchParcel
  implements Parcelable
{
  public static final Parcelable.Creator<LaunchParcel> CREATOR;
  public String appId;
  public int hcr;
  public String hiw;
  public AppBrandLaunchReferrer hiz;
  public ActivityStarterIpcDelegate ijQ;
  public AppBrandStatObject inG;
  public LaunchParamsOptional inH;
  public long inI;
  public b<?> inJ;
  public transient e.a inK;
  public String username;
  public int version;
  
  static
  {
    AppMethodBeat.i(102124);
    CREATOR = new LaunchParcel.1();
    AppMethodBeat.o(102124);
  }
  
  public LaunchParcel() {}
  
  private LaunchParcel(Parcel paramParcel)
  {
    AppMethodBeat.i(102121);
    this.username = paramParcel.readString();
    this.appId = paramParcel.readString();
    this.version = paramParcel.readInt();
    this.hcr = paramParcel.readInt();
    this.hiw = paramParcel.readString();
    this.inG = ((AppBrandStatObject)paramParcel.readParcelable(AppBrandStatObject.class.getClassLoader()));
    this.hiz = ((AppBrandLaunchReferrer)paramParcel.readParcelable(AppBrandLaunchReferrer.class.getClassLoader()));
    this.inH = ((LaunchParamsOptional)paramParcel.readParcelable(LaunchParamsOptional.class.getClassLoader()));
    this.inI = paramParcel.readLong();
    this.ijQ = ((ActivityStarterIpcDelegate)paramParcel.readParcelable(ActivityStarterIpcDelegate.class.getClassLoader()));
    this.inJ = OnWXAppResultXPCWrapper.b(paramParcel);
    AppMethodBeat.o(102121);
  }
  
  public static String Dq(String paramString)
  {
    AppMethodBeat.i(102123);
    if (TextUtils.isEmpty(paramString))
    {
      AppMethodBeat.o(102123);
      return paramString;
    }
    int i = 0;
    while ((i < paramString.length()) && ('/' == paramString.charAt(i))) {
      i += 1;
    }
    paramString = paramString.substring(i);
    AppMethodBeat.o(102123);
    return paramString;
  }
  
  public final void c(AppBrandInitConfigLU paramAppBrandInitConfigLU)
  {
    Object localObject2 = null;
    AppMethodBeat.i(102122);
    if (paramAppBrandInitConfigLU == null)
    {
      AppMethodBeat.o(102122);
      return;
    }
    if (TextUtils.isEmpty(paramAppBrandInitConfigLU.username)) {
      paramAppBrandInitConfigLU.username = this.username;
    }
    if ((this.inH != null) && (this.inH.bDa != null)) {
      paramAppBrandInitConfigLU.bDa.a(this.inH.bDa);
    }
    paramAppBrandInitConfigLU.hiw = Dq(this.hiw);
    paramAppBrandInitConfigLU.hiz.a(this.hiz);
    if (this.inH == null)
    {
      localObject1 = null;
      paramAppBrandInitConfigLU.bCY = ((String)localObject1);
      if (this.inH != null) {
        break label149;
      }
    }
    label149:
    for (Object localObject1 = localObject2;; localObject1 = this.inH.bCZ)
    {
      paramAppBrandInitConfigLU.bCZ = ((String)localObject1);
      paramAppBrandInitConfigLU.startTime = this.inI;
      paramAppBrandInitConfigLU.bDf = this.inJ;
      AppMethodBeat.o(102122);
      return;
      localObject1 = this.inH.bCY;
      break;
    }
  }
  
  public final int describeContents()
  {
    return 0;
  }
  
  public final void writeToParcel(Parcel paramParcel, int paramInt)
  {
    AppMethodBeat.i(102120);
    paramParcel.writeString(this.username);
    paramParcel.writeString(this.appId);
    paramParcel.writeInt(this.version);
    paramParcel.writeInt(this.hcr);
    paramParcel.writeString(this.hiw);
    paramParcel.writeParcelable(this.inG, paramInt);
    paramParcel.writeParcelable(this.hiz, paramInt);
    paramParcel.writeParcelable(this.inH, paramInt);
    paramParcel.writeLong(this.inI);
    paramParcel.writeParcelable(this.ijQ, paramInt);
    OnWXAppResultXPCWrapper.a(this.inJ, paramParcel);
    AppMethodBeat.o(102120);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.launching.params.LaunchParcel
 * JD-Core Version:    0.7.0.1
 */