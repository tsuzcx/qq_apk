package com.tencent.mm.plugin.appbrand.launching;

import android.os.Parcel;
import android.os.Parcelable;
import android.os.Parcelable.Creator;
import com.tencent.mm.plugin.appbrand.ipc.d;

public final class LaunchBroadCast
  implements Parcelable
{
  public static final Parcelable.Creator<LaunchBroadCast> CREATOR = new LaunchBroadCast.1();
  public String appId;
  public boolean ccp;
  public int fJy;
  public int gJU;
  public String username;
  
  private LaunchBroadCast() {}
  
  private LaunchBroadCast(Parcel paramParcel)
  {
    this.username = paramParcel.readString();
    this.appId = paramParcel.readString();
    this.fJy = paramParcel.readInt();
    this.gJU = paramParcel.readInt();
    if (paramParcel.readByte() != 0) {}
    for (boolean bool = true;; bool = false)
    {
      this.ccp = bool;
      return;
    }
  }
  
  static void a(String paramString, int paramInt1, int paramInt2, boolean paramBoolean)
  {
    LaunchBroadCast localLaunchBroadCast = new LaunchBroadCast();
    localLaunchBroadCast.username = null;
    localLaunchBroadCast.appId = paramString;
    localLaunchBroadCast.fJy = paramInt1;
    localLaunchBroadCast.gJU = paramInt2;
    localLaunchBroadCast.ccp = paramBoolean;
    d.a(paramString, localLaunchBroadCast);
  }
  
  public final int describeContents()
  {
    return 0;
  }
  
  public final void writeToParcel(Parcel paramParcel, int paramInt)
  {
    paramParcel.writeString(this.username);
    paramParcel.writeString(this.appId);
    paramParcel.writeInt(this.fJy);
    paramParcel.writeInt(this.gJU);
    if (this.ccp) {}
    for (byte b = 1;; b = 0)
    {
      paramParcel.writeByte(b);
      return;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.launching.LaunchBroadCast
 * JD-Core Version:    0.7.0.1
 */