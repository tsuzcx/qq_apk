package com.tencent.mm.plugin.appbrand.launching;

import android.os.Parcel;
import android.os.Parcelable;
import android.os.Parcelable.Creator;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.appbrand.permission.AppRuntimeApiPermissionBundle;
import java.util.HashMap;

public class ILaunchWxaAppInfoNotify$PluginIpcWrapper
  implements Parcelable
{
  public static final Parcelable.Creator<PluginIpcWrapper> CREATOR;
  public String appId;
  public int cBU;
  public HashMap<String, AppRuntimeApiPermissionBundle> pVz;
  
  static
  {
    AppMethodBeat.i(267307);
    CREATOR = new Parcelable.Creator() {};
    AppMethodBeat.o(267307);
  }
  
  ILaunchWxaAppInfoNotify$PluginIpcWrapper() {}
  
  ILaunchWxaAppInfoNotify$PluginIpcWrapper(Parcel paramParcel)
  {
    AppMethodBeat.i(267306);
    this.appId = paramParcel.readString();
    this.cBU = paramParcel.readInt();
    this.pVz = paramParcel.readHashMap(AppRuntimeApiPermissionBundle.class.getClassLoader());
    AppMethodBeat.o(267306);
  }
  
  public int describeContents()
  {
    return 0;
  }
  
  public void writeToParcel(Parcel paramParcel, int paramInt)
  {
    AppMethodBeat.i(267305);
    paramParcel.writeString(this.appId);
    paramParcel.writeInt(this.cBU);
    paramParcel.writeMap(this.pVz);
    AppMethodBeat.o(267305);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.launching.ILaunchWxaAppInfoNotify.PluginIpcWrapper
 * JD-Core Version:    0.7.0.1
 */