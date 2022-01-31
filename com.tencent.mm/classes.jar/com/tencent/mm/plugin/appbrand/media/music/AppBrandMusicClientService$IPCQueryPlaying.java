package com.tencent.mm.plugin.appbrand.media.music;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.tencent.mm.plugin.appbrand.ipc.MainProcessTask;

class AppBrandMusicClientService$IPCQueryPlaying
  extends MainProcessTask
{
  public static final Parcelable.Creator<IPCQueryPlaying> CREATOR = new AppBrandMusicClientService.IPCQueryPlaying.1();
  private String gNg = null;
  private boolean isPlaying = false;
  
  AppBrandMusicClientService$IPCQueryPlaying() {}
  
  AppBrandMusicClientService$IPCQueryPlaying(Parcel paramParcel)
  {
    e(paramParcel);
  }
  
  public final void Zu()
  {
    this.isPlaying = a.a.amd().vd(this.gNg);
  }
  
  public final void e(Parcel paramParcel)
  {
    this.gNg = paramParcel.readString();
    if (paramParcel.readByte() != 0) {}
    for (boolean bool = true;; bool = false)
    {
      this.isPlaying = bool;
      return;
    }
  }
  
  public void writeToParcel(Parcel paramParcel, int paramInt)
  {
    paramParcel.writeString(this.gNg);
    if (this.isPlaying) {}
    for (paramInt = 1;; paramInt = 0)
    {
      paramParcel.writeByte((byte)paramInt);
      return;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes8.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.media.music.AppBrandMusicClientService.IPCQueryPlaying
 * JD-Core Version:    0.7.0.1
 */