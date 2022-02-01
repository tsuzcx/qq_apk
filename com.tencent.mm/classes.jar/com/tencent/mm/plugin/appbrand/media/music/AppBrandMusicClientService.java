package com.tencent.mm.plugin.appbrand.media.music;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import android.text.TextUtils;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.bb.b;
import com.tencent.mm.plugin.appbrand.ipc.MainProcessTask;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.Util;
import java.util.HashMap;

public final class AppBrandMusicClientService
{
  public static AppBrandMusicClientService qdk;
  public HashMap<String, a> qdj;
  public volatile String qdl;
  
  static
  {
    AppMethodBeat.i(145815);
    qdk = new AppBrandMusicClientService();
    AppMethodBeat.o(145815);
  }
  
  private AppBrandMusicClientService()
  {
    AppMethodBeat.i(145813);
    this.qdj = new HashMap();
    this.qdl = "";
    AppMethodBeat.o(145813);
  }
  
  public static boolean akw(String paramString)
  {
    AppMethodBeat.i(145814);
    if (TextUtils.isEmpty(paramString))
    {
      AppMethodBeat.o(145814);
      return false;
    }
    IPCQueryPlaying localIPCQueryPlaying = new IPCQueryPlaying();
    IPCQueryPlaying.a(localIPCQueryPlaying, paramString);
    if (localIPCQueryPlaying.bPu())
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
    private boolean fGh;
    private String qdm;
    
    static
    {
      AppMethodBeat.i(145806);
      CREATOR = new Parcelable.Creator() {};
      AppMethodBeat.o(145806);
    }
    
    IPCQueryPlaying()
    {
      this.qdm = null;
      this.fGh = false;
    }
    
    IPCQueryPlaying(Parcel paramParcel)
    {
      AppMethodBeat.i(145802);
      this.qdm = null;
      this.fGh = false;
      f(paramParcel);
      AppMethodBeat.o(145802);
    }
    
    public final void RW()
    {
      AppMethodBeat.i(145803);
      this.fGh = a.a.cbh().aky(this.qdm);
      AppMethodBeat.o(145803);
    }
    
    public final void f(Parcel paramParcel)
    {
      AppMethodBeat.i(145804);
      this.qdm = paramParcel.readString();
      if (paramParcel.readByte() != 0) {}
      for (boolean bool = true;; bool = false)
      {
        this.fGh = bool;
        AppMethodBeat.o(145804);
        return;
      }
    }
    
    public void writeToParcel(Parcel paramParcel, int paramInt)
    {
      AppMethodBeat.i(145805);
      paramParcel.writeString(this.qdm);
      if (this.fGh) {}
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
    
    public final void RW()
    {
      AppMethodBeat.i(145809);
      Log.i("MicroMsg.AppBrandMusicClientService", "runInMainProcess");
      String str = a.a.cbh().qdn;
      if ((!Util.isNullOrNil(str)) && (!str.equals(this.appId)))
      {
        Log.i("MicroMsg.AppBrandMusicClientService", "appid not match cannot operate, preAppId:%s, appId:%s", new Object[] { str, this.appId });
        bPt();
        AppMethodBeat.o(145809);
        return;
      }
      if (!a.a.cbh().aky(this.appId))
      {
        Log.i("MicroMsg.AppBrandMusicClientService", "appid not match cannot operate, can't not stop, preAppId:%s, appId:%s", new Object[] { str, this.appId });
        bPt();
        AppMethodBeat.o(145809);
        return;
      }
      if (b.bnE()) {
        Log.i("MicroMsg.AppBrandMusicClientService", "stop music ok");
      }
      for (;;)
      {
        bPt();
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
    public abstract void bIo();
    
    public abstract void onStop();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.media.music.AppBrandMusicClientService
 * JD-Core Version:    0.7.0.1
 */