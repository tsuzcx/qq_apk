package com.tencent.mm.plugin.appbrand.launching;

import android.content.Context;
import android.os.Parcel;
import android.os.Parcelable;

public abstract class AppBrandLaunchErrorAction
  implements Parcelable
{
  public static final AppBrandLaunchErrorAction.a CREATOR = new AppBrandLaunchErrorAction.a();
  final String appId;
  final int hcr;
  
  AppBrandLaunchErrorAction(Parcel paramParcel)
  {
    this.appId = paramParcel.readString();
    this.hcr = paramParcel.readInt();
  }
  
  AppBrandLaunchErrorAction(String paramString, int paramInt)
  {
    this.appId = paramString;
    this.hcr = paramInt;
  }
  
  public abstract void cS(Context paramContext);
  
  public final int describeContents()
  {
    return 0;
  }
  
  public void writeToParcel(Parcel paramParcel, int paramInt)
  {
    paramParcel.writeString(getClass().getName());
    paramParcel.writeString(this.appId);
    paramParcel.writeInt(this.hcr);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.launching.AppBrandLaunchErrorAction
 * JD-Core Version:    0.7.0.1
 */