package com.tencent.mm.plugin.appbrand.media.music;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import android.text.TextUtils;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ay.b;
import com.tencent.mm.plugin.appbrand.ipc.AppBrandMainProcessService;
import com.tencent.mm.plugin.appbrand.ipc.MainProcessTask;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.Util;
import java.util.HashMap;

public final class AppBrandMusicClientService
{
  public static AppBrandMusicClientService ncV;
  public HashMap<String, a> ncU;
  public volatile String ncW;
  
  static
  {
    AppMethodBeat.i(145815);
    ncV = new AppBrandMusicClientService();
    AppMethodBeat.o(145815);
  }
  
  private AppBrandMusicClientService()
  {
    AppMethodBeat.i(145813);
    this.ncU = new HashMap();
    this.ncW = "";
    AppMethodBeat.o(145813);
  }
  
  public static boolean acC(String paramString)
  {
    AppMethodBeat.i(145814);
    if (TextUtils.isEmpty(paramString))
    {
      AppMethodBeat.o(145814);
      return false;
    }
    IPCQueryPlaying localIPCQueryPlaying = new IPCQueryPlaying();
    IPCQueryPlaying.a(localIPCQueryPlaying, paramString);
    if (AppBrandMainProcessService.b(localIPCQueryPlaying))
    {
      boolean bool = IPCQueryPlaying.a(localIPCQueryPlaying);
      AppMethodBeat.o(145814);
      return bool;
    }
    AppMethodBeat.o(145814);
    return false;
  }
  
  static class IPCQueryPlaying
    extends MainProcessTask
  {
    public static final Parcelable.Creator<IPCQueryPlaying> CREATOR;
    private boolean gVd;
    private String ncX;
    
    static
    {
      AppMethodBeat.i(145806);
      CREATOR = new Parcelable.Creator() {};
      AppMethodBeat.o(145806);
    }
    
    IPCQueryPlaying()
    {
      this.ncX = null;
      this.gVd = false;
    }
    
    IPCQueryPlaying(Parcel paramParcel)
    {
      AppMethodBeat.i(145802);
      this.ncX = null;
      this.gVd = false;
      f(paramParcel);
      AppMethodBeat.o(145802);
    }
    
    public final void bjj()
    {
      AppMethodBeat.i(145803);
      this.gVd = a.a.bOR().acE(this.ncX);
      AppMethodBeat.o(145803);
    }
    
    public final void f(Parcel paramParcel)
    {
      AppMethodBeat.i(145804);
      this.ncX = paramParcel.readString();
      if (paramParcel.readByte() != 0) {}
      for (boolean bool = true;; bool = false)
      {
        this.gVd = bool;
        AppMethodBeat.o(145804);
        return;
      }
    }
    
    public void writeToParcel(Parcel paramParcel, int paramInt)
    {
      AppMethodBeat.i(145805);
      paramParcel.writeString(this.ncX);
      if (this.gVd) {}
      for (paramInt = 1;; paramInt = 0)
      {
        paramParcel.writeByte((byte)paramInt);
        AppMethodBeat.o(145805);
        return;
      }
    }
  }
  
  public static class StopBackgroundMusicTask
    extends MainProcessTask
  {
    public static final Parcelable.Creator<StopBackgroundMusicTask> CREATOR;
    public String appId;
    
    static
    {
      AppMethodBeat.i(145812);
      CREATOR = new Parcelable.Creator() {};
      AppMethodBeat.o(145812);
    }
    
    public StopBackgroundMusicTask() {}
    
    public StopBackgroundMusicTask(Parcel paramParcel)
    {
      AppMethodBeat.i(145808);
      f(paramParcel);
      AppMethodBeat.o(145808);
    }
    
    public final void bjj()
    {
      AppMethodBeat.i(145809);
      Log.i("MicroMsg.AppBrandMusicClientService", "runInMainProcess");
      String str = a.a.bOR().ncY;
      if ((!Util.isNullOrNil(str)) && (!str.equals(this.appId)))
      {
        Log.i("MicroMsg.AppBrandMusicClientService", "appid not match cannot operate, preAppId:%s, appId:%s", new Object[] { str, this.appId });
        bDU();
        AppMethodBeat.o(145809);
        return;
      }
      if (!a.a.bOR().acE(this.appId))
      {
        Log.i("MicroMsg.AppBrandMusicClientService", "appid not match cannot operate, can't not stop, preAppId:%s, appId:%s", new Object[] { str, this.appId });
        bDU();
        AppMethodBeat.o(145809);
        return;
      }
      if (b.bej()) {
        Log.i("MicroMsg.AppBrandMusicClientService", "stop music ok");
      }
      for (;;)
      {
        bDU();
        AppMethodBeat.o(145809);
        return;
        Log.e("MicroMsg.AppBrandMusicClientService", "stop music fail");
      }
    }
    
    public final void f(Parcel paramParcel)
    {
      AppMethodBeat.i(145810);
      this.appId = paramParcel.readString();
      AppMethodBeat.o(145810);
    }
    
    public void writeToParcel(Parcel paramParcel, int paramInt)
    {
      AppMethodBeat.i(145811);
      paramParcel.writeString(this.appId);
      AppMethodBeat.o(145811);
    }
  }
  
  public static abstract interface a
  {
    public abstract void bxf();
    
    public abstract void onStop();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.media.music.AppBrandMusicClientService
 * JD-Core Version:    0.7.0.1
 */