package com.tencent.mm.plugin.appbrand.launching;

import android.os.Parcel;
import android.os.Parcelable;
import android.os.Parcelable.Creator;
import com.tencent.mm.plugin.appbrand.permission.AppRuntimeApiPermissionBundle;

public abstract interface ILaunchWxaAppInfoNotify
{
  public static final ILaunchWxaAppInfoNotify gKs = new ILaunchWxaAppInfoNotify.1();
  
  public abstract void a(String paramString1, int paramInt, String paramString2, t paramt);
  
  public static class LaunchInfoIpcWrapper
    implements Parcelable
  {
    public static final Parcelable.Creator<LaunchInfoIpcWrapper> CREATOR = new ILaunchWxaAppInfoNotify.LaunchInfoIpcWrapper.1();
    public String appId;
    public int fJy;
    public AppRuntimeApiPermissionBundle fPW;
    public AppBrandLaunchErrorAction gKt;
    
    LaunchInfoIpcWrapper() {}
    
    LaunchInfoIpcWrapper(Parcel paramParcel)
    {
      this.appId = paramParcel.readString();
      this.fJy = paramParcel.readInt();
      this.fPW = ((AppRuntimeApiPermissionBundle)paramParcel.readParcelable(AppRuntimeApiPermissionBundle.class.getClassLoader()));
      this.gKt = ((AppBrandLaunchErrorAction)paramParcel.readParcelable(AppBrandLaunchErrorAction.class.getClassLoader()));
    }
    
    public int describeContents()
    {
      return 0;
    }
    
    public void writeToParcel(Parcel paramParcel, int paramInt)
    {
      paramParcel.writeString(this.appId);
      paramParcel.writeInt(this.fJy);
      paramParcel.writeParcelable(this.fPW, paramInt);
      paramParcel.writeParcelable(this.gKt, paramInt);
    }
  }
  
  public static final class a {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.launching.ILaunchWxaAppInfoNotify
 * JD-Core Version:    0.7.0.1
 */