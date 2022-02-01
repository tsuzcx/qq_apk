package com.tencent.mm.plugin.appbrand.media.music;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import android.text.TextUtils;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ay.b;
import com.tencent.mm.plugin.appbrand.ipc.AppBrandMainProcessService;
import com.tencent.mm.plugin.appbrand.ipc.MainProcessTask;
import com.tencent.mm.sdk.platformtools.ae;
import com.tencent.mm.sdk.platformtools.bu;
import java.util.HashMap;

public final class AppBrandMusicClientService
{
  public static AppBrandMusicClientService lVt;
  public HashMap<String, a> lVs;
  public volatile String lVu;
  
  static
  {
    AppMethodBeat.i(145815);
    lVt = new AppBrandMusicClientService();
    AppMethodBeat.o(145815);
  }
  
  private AppBrandMusicClientService()
  {
    AppMethodBeat.i(145813);
    this.lVs = new HashMap();
    this.lVu = "";
    AppMethodBeat.o(145813);
  }
  
  public static boolean SY(String paramString)
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
    private String lVv;
    private boolean lVw;
    
    static
    {
      AppMethodBeat.i(145806);
      CREATOR = new Parcelable.Creator() {};
      AppMethodBeat.o(145806);
    }
    
    IPCQueryPlaying()
    {
      this.lVv = null;
      this.lVw = false;
    }
    
    IPCQueryPlaying(Parcel paramParcel)
    {
      AppMethodBeat.i(145802);
      this.lVv = null;
      this.lVw = false;
      e(paramParcel);
      AppMethodBeat.o(145802);
    }
    
    public final void aOX()
    {
      AppMethodBeat.i(145803);
      this.lVw = a.a.bto().Ta(this.lVv);
      AppMethodBeat.o(145803);
    }
    
    public final void e(Parcel paramParcel)
    {
      AppMethodBeat.i(145804);
      this.lVv = paramParcel.readString();
      if (paramParcel.readByte() != 0) {}
      for (boolean bool = true;; bool = false)
      {
        this.lVw = bool;
        AppMethodBeat.o(145804);
        return;
      }
    }
    
    public void writeToParcel(Parcel paramParcel, int paramInt)
    {
      AppMethodBeat.i(145805);
      paramParcel.writeString(this.lVv);
      if (this.lVw) {}
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
      e(paramParcel);
      AppMethodBeat.o(145808);
    }
    
    public final void aOX()
    {
      AppMethodBeat.i(145809);
      ae.i("MicroMsg.AppBrandMusicClientService", "runInMainProcess");
      String str = a.a.bto().lVx;
      if ((!bu.isNullOrNil(str)) && (!str.equals(this.appId)))
      {
        ae.i("MicroMsg.AppBrandMusicClientService", "appid not match cannot operate, preAppId:%s, appId:%s", new Object[] { str, this.appId });
        biG();
        AppMethodBeat.o(145809);
        return;
      }
      if (!a.a.bto().Ta(this.appId))
      {
        ae.i("MicroMsg.AppBrandMusicClientService", "appid not match cannot operate, can't not stop, preAppId:%s, appId:%s", new Object[] { str, this.appId });
        biG();
        AppMethodBeat.o(145809);
        return;
      }
      if (b.aKg()) {
        ae.i("MicroMsg.AppBrandMusicClientService", "stop music ok");
      }
      for (;;)
      {
        biG();
        AppMethodBeat.o(145809);
        return;
        ae.e("MicroMsg.AppBrandMusicClientService", "stop music fail");
      }
    }
    
    public final void e(Parcel paramParcel)
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
    public abstract void bbP();
    
    public abstract void onStop();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.media.music.AppBrandMusicClientService
 * JD-Core Version:    0.7.0.1
 */