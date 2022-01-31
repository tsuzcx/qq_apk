package com.tencent.mm.plugin.appbrand.media.music;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.appbrand.ipc.MainProcessTask;

class AppBrandMusicClientService$IPCQueryPlaying
  extends MainProcessTask
{
  public static final Parcelable.Creator<IPCQueryPlaying> CREATOR;
  private String ipa;
  private boolean isPlaying;
  
  static
  {
    AppMethodBeat.i(137826);
    CREATOR = new AppBrandMusicClientService.IPCQueryPlaying.1();
    AppMethodBeat.o(137826);
  }
  
  AppBrandMusicClientService$IPCQueryPlaying()
  {
    this.ipa = null;
    this.isPlaying = false;
  }
  
  AppBrandMusicClientService$IPCQueryPlaying(Parcel paramParcel)
  {
    AppMethodBeat.i(137822);
    this.ipa = null;
    this.isPlaying = false;
    f(paramParcel);
    AppMethodBeat.o(137822);
  }
  
  public final void ata()
  {
    AppMethodBeat.i(137823);
    this.isPlaying = a.a.aHK().DA(this.ipa);
    AppMethodBeat.o(137823);
  }
  
  public final void f(Parcel paramParcel)
  {
    AppMethodBeat.i(137824);
    this.ipa = paramParcel.readString();
    if (paramParcel.readByte() != 0) {}
    for (boolean bool = true;; bool = false)
    {
      this.isPlaying = bool;
      AppMethodBeat.o(137824);
      return;
    }
  }
  
  public void writeToParcel(Parcel paramParcel, int paramInt)
  {
    AppMethodBeat.i(137825);
    paramParcel.writeString(this.ipa);
    if (this.isPlaying) {}
    for (paramInt = 1;; paramInt = 0)
    {
      paramParcel.writeByte((byte)paramInt);
      AppMethodBeat.o(137825);
      return;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.media.music.AppBrandMusicClientService.IPCQueryPlaying
 * JD-Core Version:    0.7.0.1
 */