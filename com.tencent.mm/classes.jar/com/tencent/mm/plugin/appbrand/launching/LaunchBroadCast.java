package com.tencent.mm.plugin.appbrand.launching;

import android.os.Parcel;
import android.os.Parcelable;
import android.os.Parcelable.Creator;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.appbrand.ipc.e;

public final class LaunchBroadCast
  implements Parcelable
{
  public static final Parcelable.Creator<LaunchBroadCast> CREATOR;
  public String appId;
  public boolean dBW;
  public int enterScene;
  public int gXn;
  public String username;
  
  static
  {
    AppMethodBeat.i(147318);
    CREATOR = new Parcelable.Creator() {};
    AppMethodBeat.o(147318);
  }
  
  private LaunchBroadCast() {}
  
  private LaunchBroadCast(Parcel paramParcel)
  {
    AppMethodBeat.i(147317);
    this.username = paramParcel.readString();
    this.appId = paramParcel.readString();
    this.gXn = paramParcel.readInt();
    this.enterScene = paramParcel.readInt();
    if (paramParcel.readByte() != 0) {}
    for (boolean bool = true;; bool = false)
    {
      this.dBW = bool;
      AppMethodBeat.o(147317);
      return;
    }
  }
  
  static void a(String paramString, int paramInt1, int paramInt2, boolean paramBoolean)
  {
    AppMethodBeat.i(147315);
    LaunchBroadCast localLaunchBroadCast = new LaunchBroadCast();
    localLaunchBroadCast.username = null;
    localLaunchBroadCast.appId = paramString;
    localLaunchBroadCast.gXn = paramInt1;
    localLaunchBroadCast.enterScene = paramInt2;
    localLaunchBroadCast.dBW = paramBoolean;
    e.b(paramString, localLaunchBroadCast);
    AppMethodBeat.o(147315);
  }
  
  public final int describeContents()
  {
    return 0;
  }
  
  public final void writeToParcel(Parcel paramParcel, int paramInt)
  {
    AppMethodBeat.i(147316);
    paramParcel.writeString(this.username);
    paramParcel.writeString(this.appId);
    paramParcel.writeInt(this.gXn);
    paramParcel.writeInt(this.enterScene);
    if (this.dBW) {}
    for (byte b = 1;; b = 0)
    {
      paramParcel.writeByte(b);
      AppMethodBeat.o(147316);
      return;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.launching.LaunchBroadCast
 * JD-Core Version:    0.7.0.1
 */