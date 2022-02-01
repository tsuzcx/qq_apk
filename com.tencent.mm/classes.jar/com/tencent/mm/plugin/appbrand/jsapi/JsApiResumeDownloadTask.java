package com.tencent.mm.plugin.appbrand.jsapi;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.appbrand.ipc.MainProcessTask;
import com.tencent.mm.plugin.appbrand.y;
import com.tencent.mm.plugin.downloader.f.a;
import com.tencent.mm.plugin.downloader.model.d;
import com.tencent.mm.plugin.downloader.model.f;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.Util;
import org.json.JSONObject;

public final class JsApiResumeDownloadTask
  extends c<y>
{
  public static final int CTRL_INDEX = 444;
  public static final String NAME = "resumeDownloadTask";
  
  static class ResumeDownloadTask
    extends MainProcessTask
  {
    public static final Parcelable.Creator<ResumeDownloadTask> CREATOR;
    private int eit;
    private y qsi;
    private boolean rAz;
    private p ryT;
    private boolean rzb;
    private String rzc;
    private long rzd;
    
    static
    {
      AppMethodBeat.i(107799);
      CREATOR = new Parcelable.Creator() {};
      AppMethodBeat.o(107799);
    }
    
    public ResumeDownloadTask(Parcel paramParcel)
    {
      AppMethodBeat.i(107794);
      h(paramParcel);
      AppMethodBeat.o(107794);
    }
    
    public ResumeDownloadTask(p paramp, y paramy, int paramInt, JSONObject paramJSONObject)
    {
      AppMethodBeat.i(107793);
      this.ryT = paramp;
      this.qsi = paramy;
      this.eit = paramInt;
      this.rzd = paramJSONObject.optLong("downloadId");
      this.rAz = paramJSONObject.optBoolean("downloadInWifi", false);
      this.rzb = true;
      AppMethodBeat.o(107793);
    }
    
    public final void asn()
    {
      boolean bool = true;
      AppMethodBeat.i(107795);
      Log.i("MicroMsg.JsApiResumeDownloadTask", "doQueryDownloadTask, downloadId = %d", new Object[] { Long.valueOf(this.rzd) });
      if (this.rzd <= 0L)
      {
        this.rzc = "downloadId invalid";
        cpA();
        AppMethodBeat.o(107795);
        return;
      }
      a locala = d.la(this.rzd);
      if ((locala != null) && (locala.field_downloadInWifi != this.rAz))
      {
        locala.field_downloadInWifi = this.rAz;
        d.e(locala);
      }
      if (!f.duv().kU(this.rzd)) {}
      for (;;)
      {
        this.rzb = bool;
        break;
        bool = false;
      }
    }
    
    public final void bQr()
    {
      AppMethodBeat.i(107796);
      if (this.rzb)
      {
        if (Util.isNullOrNil(this.rzc)) {}
        for (String str = "fail";; str = String.format("fail:%s", new Object[] { this.rzc }))
        {
          this.qsi.callback(this.eit, this.ryT.ZP(str));
          AppMethodBeat.o(107796);
          return;
        }
      }
      this.qsi.callback(this.eit, this.ryT.ZP("ok"));
      AppMethodBeat.o(107796);
    }
    
    public final void h(Parcel paramParcel)
    {
      boolean bool2 = true;
      AppMethodBeat.i(107797);
      this.rzd = paramParcel.readLong();
      if (paramParcel.readByte() == 1)
      {
        bool1 = true;
        this.rAz = bool1;
        if (paramParcel.readInt() != 1) {
          break label64;
        }
      }
      label64:
      for (boolean bool1 = bool2;; bool1 = false)
      {
        this.rzb = bool1;
        this.rzc = paramParcel.readString();
        AppMethodBeat.o(107797);
        return;
        bool1 = false;
        break;
      }
    }
    
    public void writeToParcel(Parcel paramParcel, int paramInt)
    {
      paramInt = 1;
      AppMethodBeat.i(107798);
      paramParcel.writeLong(this.rzd);
      byte b;
      if (this.rAz)
      {
        b = 1;
        paramParcel.writeByte(b);
        if (!this.rzb) {
          break label60;
        }
      }
      for (;;)
      {
        paramParcel.writeInt(paramInt);
        paramParcel.writeString(this.rzc);
        AppMethodBeat.o(107798);
        return;
        b = 0;
        break;
        label60:
        paramInt = 0;
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.jsapi.JsApiResumeDownloadTask
 * JD-Core Version:    0.7.0.1
 */