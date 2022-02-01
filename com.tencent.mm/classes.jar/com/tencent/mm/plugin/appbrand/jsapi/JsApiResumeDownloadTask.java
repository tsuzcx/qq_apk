package com.tencent.mm.plugin.appbrand.jsapi;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.appbrand.ipc.MainProcessTask;
import com.tencent.mm.plugin.appbrand.s;
import com.tencent.mm.plugin.downloader.g.a;
import com.tencent.mm.plugin.downloader.model.f;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.Util;
import org.json.JSONObject;

public final class JsApiResumeDownloadTask
  extends d<s>
{
  public static final int CTRL_INDEX = 444;
  public static final String NAME = "resumeDownloadTask";
  
  static class ResumeDownloadTask
    extends MainProcessTask
  {
    public static final Parcelable.Creator<ResumeDownloadTask> CREATOR;
    private int csv;
    private s kAr;
    private p lAi;
    private boolean lAq;
    private String lAr;
    private long lAs;
    private boolean lBG;
    
    static
    {
      AppMethodBeat.i(107799);
      CREATOR = new Parcelable.Creator() {};
      AppMethodBeat.o(107799);
    }
    
    public ResumeDownloadTask(Parcel paramParcel)
    {
      AppMethodBeat.i(107794);
      f(paramParcel);
      AppMethodBeat.o(107794);
    }
    
    public ResumeDownloadTask(p paramp, s params, int paramInt, JSONObject paramJSONObject)
    {
      AppMethodBeat.i(107793);
      this.lAi = paramp;
      this.kAr = params;
      this.csv = paramInt;
      this.lAs = paramJSONObject.optLong("downloadId");
      this.lBG = paramJSONObject.optBoolean("downloadInWifi", false);
      this.lAq = true;
      AppMethodBeat.o(107793);
    }
    
    public final void bjj()
    {
      boolean bool = true;
      AppMethodBeat.i(107795);
      Log.i("MicroMsg.JsApiResumeDownloadTask", "doQueryDownloadTask, downloadId = %d", new Object[] { Long.valueOf(this.lAs) });
      if (this.lAs <= 0L)
      {
        this.lAr = "downloadId invalid";
        bDU();
        AppMethodBeat.o(107795);
        return;
      }
      a locala = com.tencent.mm.plugin.downloader.model.d.Cw(this.lAs);
      if ((locala != null) && (locala.field_downloadInWifi != this.lBG))
      {
        locala.field_downloadInWifi = this.lBG;
        com.tencent.mm.plugin.downloader.model.d.e(locala);
      }
      if (!f.cBv().Cq(this.lAs)) {}
      for (;;)
      {
        this.lAq = bool;
        break;
        bool = false;
      }
    }
    
    public final void bjk()
    {
      AppMethodBeat.i(107796);
      if (this.lAq)
      {
        if (Util.isNullOrNil(this.lAr)) {}
        for (String str = "fail";; str = String.format("fail:%s", new Object[] { this.lAr }))
        {
          this.kAr.i(this.csv, this.lAi.h(str, null));
          AppMethodBeat.o(107796);
          return;
        }
      }
      this.kAr.i(this.csv, this.lAi.h("ok", null));
      AppMethodBeat.o(107796);
    }
    
    public final void f(Parcel paramParcel)
    {
      boolean bool2 = true;
      AppMethodBeat.i(107797);
      this.lAs = paramParcel.readLong();
      if (paramParcel.readByte() == 1)
      {
        bool1 = true;
        this.lBG = bool1;
        if (paramParcel.readInt() != 1) {
          break label64;
        }
      }
      label64:
      for (boolean bool1 = bool2;; bool1 = false)
      {
        this.lAq = bool1;
        this.lAr = paramParcel.readString();
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
      paramParcel.writeLong(this.lAs);
      byte b;
      if (this.lBG)
      {
        b = 1;
        paramParcel.writeByte(b);
        if (!this.lAq) {
          break label60;
        }
      }
      for (;;)
      {
        paramParcel.writeInt(paramInt);
        paramParcel.writeString(this.lAr);
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