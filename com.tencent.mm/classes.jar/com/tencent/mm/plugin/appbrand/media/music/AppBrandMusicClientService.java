package com.tencent.mm.plugin.appbrand.media.music;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import android.text.TextUtils;
import com.tencent.mm.av.b;
import com.tencent.mm.plugin.appbrand.ipc.AppBrandMainProcessService;
import com.tencent.mm.plugin.appbrand.ipc.MainProcessTask;
import com.tencent.mm.sdk.platformtools.bk;
import com.tencent.mm.sdk.platformtools.y;
import java.util.HashMap;

public final class AppBrandMusicClientService
{
  public static AppBrandMusicClientService gNe = new AppBrandMusicClientService();
  public HashMap<String, AppBrandMusicClientService.a> gNd = new HashMap();
  public volatile String gNf = "";
  
  public static boolean vc(String paramString)
  {
    if (TextUtils.isEmpty(paramString)) {}
    AppBrandMusicClientService.IPCQueryPlaying localIPCQueryPlaying;
    do
    {
      return false;
      localIPCQueryPlaying = new AppBrandMusicClientService.IPCQueryPlaying();
      AppBrandMusicClientService.IPCQueryPlaying.a(localIPCQueryPlaying, paramString);
    } while (!AppBrandMainProcessService.b(localIPCQueryPlaying));
    return AppBrandMusicClientService.IPCQueryPlaying.a(localIPCQueryPlaying);
  }
  
  private static class StopBackgroundMusicTask
    extends MainProcessTask
  {
    public static final Parcelable.Creator<StopBackgroundMusicTask> CREATOR = new AppBrandMusicClientService.StopBackgroundMusicTask.1();
    public String appId;
    
    public StopBackgroundMusicTask() {}
    
    public StopBackgroundMusicTask(Parcel paramParcel)
    {
      e(paramParcel);
    }
    
    public final void Zu()
    {
      y.i("MicroMsg.AppBrandMusicClientService", "runInMainProcess");
      String str = a.a.amd().gNh;
      if ((!bk.bl(str)) && (!str.equals(this.appId)))
      {
        y.i("MicroMsg.AppBrandMusicClientService", "appid not match cannot operate, preAppId:%s, appId:%s", new Object[] { str, this.appId });
        ahI();
        return;
      }
      if (!a.a.amd().vd(this.appId))
      {
        y.i("MicroMsg.AppBrandMusicClientService", "appid not match cannot operate, can't not stop, preAppId:%s, appId:%s", new Object[] { str, this.appId });
        ahI();
        return;
      }
      if (b.PA()) {
        y.i("MicroMsg.AppBrandMusicClientService", "stop music ok");
      }
      for (;;)
      {
        ahI();
        return;
        y.e("MicroMsg.AppBrandMusicClientService", "stop music fail");
      }
    }
    
    public final void e(Parcel paramParcel)
    {
      this.appId = paramParcel.readString();
    }
    
    public void writeToParcel(Parcel paramParcel, int paramInt)
    {
      paramParcel.writeString(this.appId);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.media.music.AppBrandMusicClientService
 * JD-Core Version:    0.7.0.1
 */