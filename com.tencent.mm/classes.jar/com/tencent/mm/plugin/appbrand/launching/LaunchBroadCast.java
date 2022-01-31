package com.tencent.mm.plugin.appbrand.launching;

import android.os.Parcel;
import android.os.Parcelable;
import android.os.Parcelable.Creator;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.appbrand.ipc.d;

public final class LaunchBroadCast
  implements Parcelable
{
  public static final Parcelable.Creator<LaunchBroadCast> CREATOR;
  public String appId;
  public boolean cKZ;
  public int cxS;
  public int hcr;
  public String username;
  
  static
  {
    AppMethodBeat.i(102109);
    CREATOR = new LaunchBroadCast.1();
    AppMethodBeat.o(102109);
  }
  
  private LaunchBroadCast() {}
  
  private LaunchBroadCast(Parcel paramParcel)
  {
    AppMethodBeat.i(102108);
    this.username = paramParcel.readString();
    this.appId = paramParcel.readString();
    this.hcr = paramParcel.readInt();
    this.cxS = paramParcel.readInt();
    if (paramParcel.readByte() != 0) {}
    for (boolean bool = true;; bool = false)
    {
      this.cKZ = bool;
      AppMethodBeat.o(102108);
      return;
    }
  }
  
  static void a(String paramString, int paramInt1, int paramInt2, boolean paramBoolean)
  {
    AppMethodBeat.i(102106);
    LaunchBroadCast localLaunchBroadCast = new LaunchBroadCast();
    localLaunchBroadCast.username = null;
    localLaunchBroadCast.appId = paramString;
    localLaunchBroadCast.hcr = paramInt1;
    localLaunchBroadCast.cxS = paramInt2;
    localLaunchBroadCast.cKZ = paramBoolean;
    d.a(paramString, localLaunchBroadCast);
    AppMethodBeat.o(102106);
  }
  
  public final int describeContents()
  {
    return 0;
  }
  
  public final void writeToParcel(Parcel paramParcel, int paramInt)
  {
    AppMethodBeat.i(102107);
    paramParcel.writeString(this.username);
    paramParcel.writeString(this.appId);
    paramParcel.writeInt(this.hcr);
    paramParcel.writeInt(this.cxS);
    if (this.cKZ) {}
    for (byte b = 1;; b = 0)
    {
      paramParcel.writeByte(b);
      AppMethodBeat.o(102107);
      return;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.launching.LaunchBroadCast
 * JD-Core Version:    0.7.0.1
 */