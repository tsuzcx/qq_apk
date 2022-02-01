package com.tencent.mm.plugin.appbrand.jsapi.appdownload;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.appbrand.ipc.MainProcessTask;
import com.tencent.mm.plugin.appbrand.jsapi.m;
import com.tencent.mm.plugin.appbrand.r;
import com.tencent.mm.plugin.appbrand.service.c;
import com.tencent.mm.plugin.downloader.model.d;
import com.tencent.mm.plugin.downloader.model.f;
import com.tencent.mm.sdk.platformtools.ae;
import com.tencent.mm.sdk.platformtools.bu;
import org.json.JSONObject;

public final class JsApiPauseDownloadTask
  extends com.tencent.mm.plugin.appbrand.jsapi.a<c>
{
  public static final int CTRL_INDEX = 443;
  public static final String NAME = "pauseDownloadTask";
  
  static class PauseDownloadTask
    extends MainProcessTask
  {
    public static final Parcelable.Creator<PauseDownloadTask> CREATOR;
    private int cgA;
    private r jzD;
    private m kwe;
    private boolean kwm;
    private String kwn;
    private long kwo;
    
    static
    {
      AppMethodBeat.i(45857);
      CREATOR = new Parcelable.Creator() {};
      AppMethodBeat.o(45857);
    }
    
    public PauseDownloadTask(Parcel paramParcel)
    {
      AppMethodBeat.i(45852);
      e(paramParcel);
      AppMethodBeat.o(45852);
    }
    
    public PauseDownloadTask(m paramm, r paramr, int paramInt, JSONObject paramJSONObject)
    {
      AppMethodBeat.i(45851);
      this.kwe = paramm;
      this.jzD = paramr;
      this.cgA = paramInt;
      this.kwo = paramJSONObject.optLong("downloadId");
      this.kwm = true;
      AppMethodBeat.o(45851);
    }
    
    public final void aOX()
    {
      boolean bool = true;
      AppMethodBeat.i(45853);
      ae.i("MicroMsg.JsApiPauseDownloadTask", "doPauseDownloadTask, downloadId = %d", new Object[] { Long.valueOf(this.kwo) });
      if (this.kwo <= 0L) {}
      com.tencent.mm.plugin.downloader.g.a locala;
      for (this.kwn = "downloadId invalid";; this.kwn = "downloadId invalid")
      {
        biG();
        AppMethodBeat.o(45853);
        return;
        locala = d.ur(this.kwo);
        if (locala != null) {
          break;
        }
      }
      if (locala.field_downloadInWifi)
      {
        locala.field_downloadInWifi = false;
        d.e(locala);
      }
      if (!f.cdA().uk(this.kwo)) {}
      for (;;)
      {
        this.kwm = bool;
        break;
        bool = false;
      }
    }
    
    public final void aOY()
    {
      AppMethodBeat.i(45854);
      if (this.kwm)
      {
        if (bu.isNullOrNil(this.kwn)) {}
        for (String str = "fail";; str = String.format("fail:%s", new Object[] { this.kwn }))
        {
          this.jzD.h(this.cgA, this.kwe.e(str, null));
          AppMethodBeat.o(45854);
          return;
        }
      }
      this.jzD.h(this.cgA, this.kwe.e("ok", null));
      AppMethodBeat.o(45854);
    }
    
    public final void e(Parcel paramParcel)
    {
      boolean bool = true;
      AppMethodBeat.i(45855);
      this.kwo = paramParcel.readLong();
      if (paramParcel.readInt() == 1) {}
      for (;;)
      {
        this.kwm = bool;
        this.kwn = paramParcel.readString();
        AppMethodBeat.o(45855);
        return;
        bool = false;
      }
    }
    
    public void writeToParcel(Parcel paramParcel, int paramInt)
    {
      AppMethodBeat.i(45856);
      paramParcel.writeLong(this.kwo);
      if (this.kwm) {}
      for (paramInt = 1;; paramInt = 0)
      {
        paramParcel.writeInt(paramInt);
        paramParcel.writeString(this.kwn);
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