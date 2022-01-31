package com.tencent.mm.plugin.appbrand.launching.params;

import android.os.Parcel;
import android.os.Parcelable;
import android.os.Parcelable.Creator;
import com.tencent.mm.modelappbrand.LaunchParamsOptional;
import com.tencent.mm.plugin.appbrand.appcache.a;
import com.tencent.mm.plugin.appbrand.config.AppBrandInitConfigWC;
import com.tencent.mm.plugin.appbrand.config.AppBrandLaunchReferrer;
import com.tencent.mm.plugin.appbrand.launching.ActivityStarterIpcDelegate;
import com.tencent.mm.plugin.appbrand.report.AppBrandStatObject;

public final class LaunchParcel
  implements Parcelable
{
  public static final Parcelable.Creator<LaunchParcel> CREATOR = new LaunchParcel.1();
  public String appId;
  public int fJy;
  public String fPq;
  public AppBrandLaunchReferrer fPr;
  public ActivityStarterIpcDelegate gJl;
  public AppBrandStatObject gMm;
  public LaunchParamsOptional gMn;
  public long gMo;
  public String username;
  public int version;
  
  public LaunchParcel() {}
  
  private LaunchParcel(Parcel paramParcel)
  {
    this.username = paramParcel.readString();
    this.appId = paramParcel.readString();
    this.version = paramParcel.readInt();
    this.fJy = paramParcel.readInt();
    this.fPq = paramParcel.readString();
    this.gMm = ((AppBrandStatObject)paramParcel.readParcelable(AppBrandStatObject.class.getClassLoader()));
    this.fPr = ((AppBrandLaunchReferrer)paramParcel.readParcelable(AppBrandLaunchReferrer.class.getClassLoader()));
    this.gMn = ((LaunchParamsOptional)paramParcel.readParcelable(LaunchParamsOptional.class.getClassLoader()));
    this.gMo = paramParcel.readLong();
    this.gJl = ((ActivityStarterIpcDelegate)paramParcel.readParcelable(ActivityStarterIpcDelegate.class.getClassLoader()));
  }
  
  public final void a(AppBrandInitConfigWC paramAppBrandInitConfigWC)
  {
    Object localObject2 = null;
    if (paramAppBrandInitConfigWC == null) {
      return;
    }
    paramAppBrandInitConfigWC.username = this.username;
    paramAppBrandInitConfigWC.fPq = a.qQ(this.fPq);
    paramAppBrandInitConfigWC.fPr.a(this.fPr);
    if (this.gMn == null)
    {
      localObject1 = null;
      paramAppBrandInitConfigWC.dZN = ((String)localObject1);
      if (this.gMn != null) {
        break label85;
      }
    }
    label85:
    for (Object localObject1 = localObject2;; localObject1 = this.gMn.dTX)
    {
      paramAppBrandInitConfigWC.dTX = ((String)localObject1);
      paramAppBrandInitConfigWC.startTime = this.gMo;
      return;
      localObject1 = this.gMn.dZN;
      break;
    }
  }
  
  public final int describeContents()
  {
    return 0;
  }
  
  public final void writeToParcel(Parcel paramParcel, int paramInt)
  {
    paramParcel.writeString(this.username);
    paramParcel.writeString(this.appId);
    paramParcel.writeInt(this.version);
    paramParcel.writeInt(this.fJy);
    paramParcel.writeString(this.fPq);
    paramParcel.writeParcelable(this.gMm, paramInt);
    paramParcel.writeParcelable(this.fPr, paramInt);
    paramParcel.writeParcelable(this.gMn, paramInt);
    paramParcel.writeLong(this.gMo);
    paramParcel.writeParcelable(this.gJl, paramInt);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.launching.params.LaunchParcel
 * JD-Core Version:    0.7.0.1
 */