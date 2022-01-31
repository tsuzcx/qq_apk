package com.tencent.mm.plugin.appbrand.launching;

import android.os.Parcel;
import android.os.Parcelable;
import android.os.Parcelable.Creator;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.appbrand.permission.AppRuntimeApiPermissionBundle;

public abstract interface ILaunchWxaAppInfoNotify
{
  public static final ILaunchWxaAppInfoNotify ilj = new ILaunchWxaAppInfoNotify.1();
  
  public abstract void a(String paramString1, int paramInt, String paramString2, ab paramab);
  
  public static class LaunchInfoIpcWrapper
    implements Parcelable
  {
    public static final Parcelable.Creator<LaunchInfoIpcWrapper> CREATOR;
    public String appId;
    public AppRuntimeApiPermissionBundle bDn;
    public int hcr;
    public AppBrandLaunchErrorAction ilk;
    
    static
    {
      AppMethodBeat.i(131824);
      CREATOR = new ILaunchWxaAppInfoNotify.LaunchInfoIpcWrapper.1();
      AppMethodBeat.o(131824);
    }
    
    LaunchInfoIpcWrapper() {}
    
    LaunchInfoIpcWrapper(Parcel paramParcel)
    {
      AppMethodBeat.i(131823);
      this.appId = paramParcel.readString();
      this.hcr = paramParcel.readInt();
      this.bDn = ((AppRuntimeApiPermissionBundle)paramParcel.readParcelable(AppRuntimeApiPermissionBundle.class.getClassLoader()));
      this.ilk = ((AppBrandLaunchErrorAction)paramParcel.readParcelable(AppBrandLaunchErrorAction.class.getClassLoader()));
      AppMethodBeat.o(131823);
    }
    
    public int describeContents()
    {
      return 0;
    }
    
    public void writeToParcel(Parcel paramParcel, int paramInt)
    {
      AppMethodBeat.i(131822);
      paramParcel.writeString(this.appId);
      paramParcel.writeInt(this.hcr);
      paramParcel.writeParcelable(this.bDn, paramInt);
      paramParcel.writeParcelable(this.ilk, paramInt);
      AppMethodBeat.o(131822);
    }
  }
  
  public static final class a {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.launching.ILaunchWxaAppInfoNotify
 * JD-Core Version:    0.7.0.1
 */