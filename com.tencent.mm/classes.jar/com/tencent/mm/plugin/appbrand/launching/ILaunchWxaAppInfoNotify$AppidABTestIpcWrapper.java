package com.tencent.mm.plugin.appbrand.launching;

import android.os.Parcel;
import android.os.Parcelable;
import android.os.Parcelable.Creator;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.appbrand.permission.AppRuntimeApiPermissionBundle;
import com.tencent.mm.plugin.appbrand.permission.appidABTest.AppRuntimeAppidABTestPermissionBundle;
import java.util.HashMap;

public class ILaunchWxaAppInfoNotify$AppidABTestIpcWrapper
  implements Parcelable
{
  public static final Parcelable.Creator<AppidABTestIpcWrapper> CREATOR;
  public String appId;
  public int cBU;
  public HashMap<String, AppRuntimeAppidABTestPermissionBundle> pVy;
  
  static
  {
    AppMethodBeat.i(277384);
    CREATOR = new Parcelable.Creator() {};
    AppMethodBeat.o(277384);
  }
  
  ILaunchWxaAppInfoNotify$AppidABTestIpcWrapper() {}
  
  ILaunchWxaAppInfoNotify$AppidABTestIpcWrapper(Parcel paramParcel)
  {
    AppMethodBeat.i(277383);
    this.appId = paramParcel.readString();
    this.cBU = paramParcel.readInt();
    this.pVy = paramParcel.readHashMap(AppRuntimeApiPermissionBundle.class.getClassLoader());
    AppMethodBeat.o(277383);
  }
  
  public int describeContents()
  {
    return 0;
  }
  
  public void writeToParcel(Parcel paramParcel, int paramInt)
  {
    AppMethodBeat.i(277382);
    paramParcel.writeString(this.appId);
    paramParcel.writeInt(this.cBU);
    paramParcel.writeMap(this.pVy);
    AppMethodBeat.o(277382);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.launching.ILaunchWxaAppInfoNotify.AppidABTestIpcWrapper
 * JD-Core Version:    0.7.0.1
 */