package com.tencent.mm.plugin.appbrand.jsapi.appdownload;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.appbrand.ipc.MainProcessTask;
import com.tencent.mm.plugin.appbrand.jsapi.p;
import com.tencent.mm.plugin.appbrand.s;
import com.tencent.mm.plugin.appbrand.service.c;
import com.tencent.mm.plugin.downloader.g.a;
import com.tencent.mm.plugin.downloader.model.f;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.Util;
import org.json.JSONObject;

public final class JsApiPauseDownloadTaskForNative
  extends com.tencent.mm.plugin.appbrand.jsapi.d<c>
{
  public static final int CTRL_INDEX = 659;
  public static final String NAME = "pauseDownloadTaskForNative";
  
  static class PauseDownloadTask
    extends MainProcessTask
  {
    public static final Parcelable.Creator<PauseDownloadTask> CREATOR;
    private int csv;
    private s kAr;
    private p lAi;
    private boolean lAq;
    private String lAr;
    private long lAs;
    
    static
    {
      AppMethodBeat.i(45866);
      CREATOR = new Parcelable.Creator() {};
      AppMethodBeat.o(45866);
    }
    
    public PauseDownloadTask(Parcel paramParcel)
    {
      AppMethodBeat.i(45861);
      f(paramParcel);
      AppMethodBeat.o(45861);
    }
    
    public PauseDownloadTask(p paramp, s params, int paramInt, JSONObject paramJSONObject)
    {
      AppMethodBeat.i(45860);
      this.lAi = paramp;
      this.kAr = params;
      this.csv = paramInt;
      this.lAs = paramJSONObject.optLong("downloadId");
      this.lAq = true;
      AppMethodBeat.o(45860);
    }
    
    public final void bjj()
    {
      boolean bool = true;
      AppMethodBeat.i(45862);
      Log.i("MicroMsg.JsApiPauseDownloadTaskForNative", "doPauseDownloadTask, downloadId = %d", new Object[] { Long.valueOf(this.lAs) });
      if (this.lAs <= 0L) {}
      a locala;
      for (this.lAr = "downloadId invalid";; this.lAr = "downloadId invalid")
      {
        bDU();
        AppMethodBeat.o(45862);
        return;
        locala = com.tencent.mm.plugin.downloader.model.d.Cw(this.lAs);
        if (locala != null) {
          break;
        }
      }
      if (locala.field_downloadInWifi)
      {
        locala.field_downloadInWifi = false;
        com.tencent.mm.plugin.downloader.model.d.e(locala);
      }
      if (!f.cBv().Cp(this.lAs)) {}
      for (;;)
      {
        this.lAq = bool;
        break;
        bool = false;
      }
    }
    
    public final void bjk()
    {
      AppMethodBeat.i(45863);
      if (this.lAq)
      {
        if (Util.isNullOrNil(this.lAr)) {}
        for (String str = "fail";; str = String.format("fail:%s", new Object[] { this.lAr }))
        {
          this.kAr.i(this.csv, this.lAi.h(str, null));
          AppMethodBeat.o(45863);
          return;
        }
      }
      this.kAr.i(this.csv, this.lAi.h("ok", null));
      AppMethodBeat.o(45863);
    }
    
    public final void f(Parcel paramParcel)
    {
      boolean bool = true;
      AppMethodBeat.i(45864);
      this.lAs = paramParcel.readLong();
      if (paramParcel.readInt() == 1) {}
      for (;;)
      {
        this.lAq = bool;
        this.lAr = paramParcel.readString();
        AppMethodBeat.o(45864);
        return;
        bool = false;
      }
    }
    
    public void writeToParcel(Parcel paramParcel, int paramInt)
    {
      AppMethodBeat.i(45865);
      paramParcel.writeLong(this.lAs);
      if (this.lAq) {}
      for (paramInt = 1;; paramInt = 0)
      {
        paramParcel.writeInt(paramInt);
        paramParcel.writeString(this.lAr);
        AppMethodBeat.o(45865);
        return;
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.jsapi.appdownload.JsApiPauseDownloadTaskForNative
 * JD-Core Version:    0.7.0.1
 */