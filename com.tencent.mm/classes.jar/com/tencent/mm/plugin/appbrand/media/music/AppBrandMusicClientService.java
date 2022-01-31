package com.tencent.mm.plugin.appbrand.media.music;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import android.text.TextUtils;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.aw.b;
import com.tencent.mm.plugin.appbrand.ipc.AppBrandMainProcessService;
import com.tencent.mm.plugin.appbrand.ipc.MainProcessTask;
import com.tencent.mm.sdk.platformtools.ab;
import com.tencent.mm.sdk.platformtools.bo;
import java.util.HashMap;

public final class AppBrandMusicClientService
{
  public static AppBrandMusicClientService ioY;
  public HashMap<String, AppBrandMusicClientService.a> ioX;
  public volatile String ioZ;
  
  static
  {
    AppMethodBeat.i(137835);
    ioY = new AppBrandMusicClientService();
    AppMethodBeat.o(137835);
  }
  
  private AppBrandMusicClientService()
  {
    AppMethodBeat.i(137833);
    this.ioX = new HashMap();
    this.ioZ = "";
    AppMethodBeat.o(137833);
  }
  
  public static boolean Dy(String paramString)
  {
    AppMethodBeat.i(137834);
    if (TextUtils.isEmpty(paramString))
    {
      AppMethodBeat.o(137834);
      return false;
    }
    AppBrandMusicClientService.IPCQueryPlaying localIPCQueryPlaying = new AppBrandMusicClientService.IPCQueryPlaying();
    AppBrandMusicClientService.IPCQueryPlaying.a(localIPCQueryPlaying, paramString);
    if (AppBrandMainProcessService.b(localIPCQueryPlaying))
    {
      boolean bool = AppBrandMusicClientService.IPCQueryPlaying.a(localIPCQueryPlaying);
      AppMethodBeat.o(137834);
      return bool;
    }
    AppMethodBeat.o(137834);
    return false;
  }
  
  public static class StopBackgroundMusicTask
    extends MainProcessTask
  {
    public static final Parcelable.Creator<StopBackgroundMusicTask> CREATOR;
    public String appId;
    
    static
    {
      AppMethodBeat.i(137832);
      CREATOR = new AppBrandMusicClientService.StopBackgroundMusicTask.1();
      AppMethodBeat.o(137832);
    }
    
    public StopBackgroundMusicTask() {}
    
    public StopBackgroundMusicTask(Parcel paramParcel)
    {
      AppMethodBeat.i(137828);
      f(paramParcel);
      AppMethodBeat.o(137828);
    }
    
    public final void ata()
    {
      AppMethodBeat.i(137829);
      ab.i("MicroMsg.AppBrandMusicClientService", "runInMainProcess");
      String str = a.a.aHK().ipb;
      if ((!bo.isNullOrNil(str)) && (!str.equals(this.appId)))
      {
        ab.i("MicroMsg.AppBrandMusicClientService", "appid not match cannot operate, preAppId:%s, appId:%s", new Object[] { str, this.appId });
        aBp();
        AppMethodBeat.o(137829);
        return;
      }
      if (!a.a.aHK().DA(this.appId))
      {
        ab.i("MicroMsg.AppBrandMusicClientService", "appid not match cannot operate, can't not stop, preAppId:%s, appId:%s", new Object[] { str, this.appId });
        aBp();
        AppMethodBeat.o(137829);
        return;
      }
      if (b.aiD()) {
        ab.i("MicroMsg.AppBrandMusicClientService", "stop music ok");
      }
      for (;;)
      {
        aBp();
        AppMethodBeat.o(137829);
        return;
        ab.e("MicroMsg.AppBrandMusicClientService", "stop music fail");
      }
    }
    
    public final void f(Parcel paramParcel)
    {
      AppMethodBeat.i(137830);
      this.appId = paramParcel.readString();
      AppMethodBeat.o(137830);
    }
    
    public void writeToParcel(Parcel paramParcel, int paramInt)
    {
      AppMethodBeat.i(137831);
      paramParcel.writeString(this.appId);
      AppMethodBeat.o(137831);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.media.music.AppBrandMusicClientService
 * JD-Core Version:    0.7.0.1
 */