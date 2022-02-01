package com.tencent.mm.plugin.appbrand.launching;

import android.os.Parcel;
import android.os.Parcelable;
import android.os.Parcelable.Creator;
import com.tencent.luggage.sdk.config.LaunchWxaAppInfoParcelized;
import com.tencent.matrix.trace.core.AppMethodBeat;

public class ILaunchWxaAppInfoNotify$LaunchInfoIpcWrapper
  implements Parcelable
{
  public static final Parcelable.Creator<LaunchInfoIpcWrapper> CREATOR;
  public String appId;
  public int cBU;
  public LaunchWxaAppInfoParcelized cxk;
  
  static
  {
    AppMethodBeat.i(47175);
    CREATOR = new Parcelable.Creator() {};
    AppMethodBeat.o(47175);
  }
  
  ILaunchWxaAppInfoNotify$LaunchInfoIpcWrapper() {}
  
  ILaunchWxaAppInfoNotify$LaunchInfoIpcWrapper(Parcel paramParcel)
  {
    AppMethodBeat.i(47174);
    this.appId = paramParcel.readString();
    this.cBU = paramParcel.readInt();
    this.cxk = ((LaunchWxaAppInfoParcelized)paramParcel.readParcelable(LaunchWxaAppInfoParcelized.class.getClassLoader()));
    AppMethodBeat.o(47174);
  }
  
  public int describeContents()
  {
    return 0;
  }
  
  public void writeToParcel(Parcel paramParcel, int paramInt)
  {
    AppMethodBeat.i(47173);
    paramParcel.writeString(this.appId);
    paramParcel.writeInt(this.cBU);
    paramParcel.writeParcelable(this.cxk, paramInt);
    AppMethodBeat.o(47173);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.launching.ILaunchWxaAppInfoNotify.LaunchInfoIpcWrapper
 * JD-Core Version:    0.7.0.1
 */