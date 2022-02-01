package com.tencent.mm.plugin.appbrand.jsapi.appdownload;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.appbrand.ipc.MainProcessTask;
import com.tencent.mm.plugin.appbrand.jsapi.p;
import com.tencent.mm.plugin.appbrand.y;
import com.tencent.mm.plugin.downloader.f.a;
import com.tencent.mm.plugin.downloader.model.d;
import com.tencent.mm.plugin.downloader.model.f;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.Util;
import org.json.JSONObject;

public final class JsApiPauseDownloadTask
  extends com.tencent.mm.plugin.appbrand.jsapi.c<com.tencent.mm.plugin.appbrand.service.c>
{
  public static final int CTRL_INDEX = 443;
  public static final String NAME = "pauseDownloadTask";
  
  static class PauseDownloadTask
    extends MainProcessTask
  {
    public static final Parcelable.Creator<PauseDownloadTask> CREATOR;
    private int eit;
    private y qsi;
    private p ryT;
    private boolean rzb;
    private String rzc;
    private long rzd;
    
    static
    {
      AppMethodBeat.i(45857);
      CREATOR = new Parcelable.Creator() {};
      AppMethodBeat.o(45857);
    }
    
    public PauseDownloadTask(Parcel paramParcel)
    {
      AppMethodBeat.i(45852);
      h(paramParcel);
      AppMethodBeat.o(45852);
    }
    
    public PauseDownloadTask(p paramp, y paramy, int paramInt, JSONObject paramJSONObject)
    {
      AppMethodBeat.i(45851);
      this.ryT = paramp;
      this.qsi = paramy;
      this.eit = paramInt;
      this.rzd = paramJSONObject.optLong("downloadId");
      this.rzb = true;
      AppMethodBeat.o(45851);
    }
    
    public final void asn()
    {
      boolean bool = true;
      AppMethodBeat.i(45853);
      Log.i("MicroMsg.JsApiPauseDownloadTask", "doPauseDownloadTask, downloadId = %d", new Object[] { Long.valueOf(this.rzd) });
      if (this.rzd <= 0L) {}
      a locala;
      for (this.rzc = "downloadId invalid";; this.rzc = "downloadId invalid")
      {
        cpA();
        AppMethodBeat.o(45853);
        return;
        locala = d.la(this.rzd);
        if (locala != null) {
          break;
        }
      }
      if (locala.field_downloadInWifi)
      {
        locala.field_downloadInWifi = false;
        d.e(locala);
      }
      if (!f.duv().kT(this.rzd)) {}
      for (;;)
      {
        this.rzb = bool;
        break;
        bool = false;
      }
    }
    
    public final void bQr()
    {
      AppMethodBeat.i(45854);
      if (this.rzb)
      {
        if (Util.isNullOrNil(this.rzc)) {}
        for (String str = "fail";; str = String.format("fail:%s", new Object[] { this.rzc }))
        {
          this.qsi.callback(this.eit, this.ryT.ZP(str));
          AppMethodBeat.o(45854);
          return;
        }
      }
      this.qsi.callback(this.eit, this.ryT.ZP("ok"));
      AppMethodBeat.o(45854);
    }
    
    public final void h(Parcel paramParcel)
    {
      boolean bool = true;
      AppMethodBeat.i(45855);
      this.rzd = paramParcel.readLong();
      if (paramParcel.readInt() == 1) {}
      for (;;)
      {
        this.rzb = bool;
        this.rzc = paramParcel.readString();
        AppMethodBeat.o(45855);
        return;
        bool = false;
      }
    }
    
    public void writeToParcel(Parcel paramParcel, int paramInt)
    {
      AppMethodBeat.i(45856);
      paramParcel.writeLong(this.rzd);
      if (this.rzb) {}
      for (paramInt = 1;; paramInt = 0)
      {
        paramParcel.writeInt(paramInt);
        paramParcel.writeString(this.rzc);
        AppMethodBeat.o(45856);
        return;
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.jsapi.appdownload.JsApiPauseDownloadTask
 * JD-Core Version:    0.7.0.1
 */