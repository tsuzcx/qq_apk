package com.tencent.mm.plugin.appbrand.jsapi.appdownload;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.appbrand.ipc.MainProcessTask;
import com.tencent.mm.plugin.appbrand.jsapi.p;
import com.tencent.mm.plugin.appbrand.s;
import com.tencent.mm.plugin.downloader.g.a;
import com.tencent.mm.plugin.downloader.model.f;
import com.tencent.mm.plugin.downloader.model.o;
import com.tencent.mm.plugin.downloader.model.o.a;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.MMApplicationContext;
import com.tencent.mm.sdk.platformtools.Util;
import org.json.JSONObject;

public final class JsApiResumeDownloadTaskForNative
  extends com.tencent.mm.plugin.appbrand.jsapi.d<s>
{
  public static final int CTRL_INDEX = 660;
  public static final String NAME = "resumeDownloadTaskForNative";
  
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
    private boolean lDa;
    
    static
    {
      AppMethodBeat.i(45900);
      CREATOR = new Parcelable.Creator() {};
      AppMethodBeat.o(45900);
    }
    
    public ResumeDownloadTask(Parcel paramParcel)
    {
      AppMethodBeat.i(45895);
      f(paramParcel);
      AppMethodBeat.o(45895);
    }
    
    public ResumeDownloadTask(p paramp, s params, int paramInt, JSONObject paramJSONObject)
    {
      AppMethodBeat.i(45894);
      this.lAi = paramp;
      this.kAr = params;
      this.csv = paramInt;
      this.lAs = paramJSONObject.optLong("downloadId");
      this.lDa = paramJSONObject.optBoolean("useDownloaderWidget", false);
      this.lBG = paramJSONObject.optBoolean("downloadInWifi", false);
      this.lAq = true;
      AppMethodBeat.o(45894);
    }
    
    public final void bjj()
    {
      boolean bool = false;
      AppMethodBeat.i(45896);
      Log.i("MicroMsg.JsApiResumeDownloadTaskForNative", "doQueryDownloadTask, downloadId = %d", new Object[] { Long.valueOf(this.lAs) });
      if (this.lAs <= 0L) {
        this.lAr = "downloadId invalid";
      }
      for (;;)
      {
        bDU();
        AppMethodBeat.o(45896);
        return;
        if (this.lDa)
        {
          o.a(MMApplicationContext.getContext(), this.lAs, this.lBG, false, new o.a()
          {
            public final void i(String paramAnonymousString, JSONObject paramAnonymousJSONObject)
            {
              AppMethodBeat.i(45892);
              if (Util.isNullOrNil(paramAnonymousString))
              {
                JsApiResumeDownloadTaskForNative.ResumeDownloadTask.a(JsApiResumeDownloadTaskForNative.ResumeDownloadTask.this, false);
                AppMethodBeat.o(45892);
                return;
              }
              JsApiResumeDownloadTaskForNative.ResumeDownloadTask.a(JsApiResumeDownloadTaskForNative.ResumeDownloadTask.this, true);
              AppMethodBeat.o(45892);
            }
          });
          com.tencent.mm.modelstat.d.d(10, "JsApiResumeDownloadApp_resumeDownloadTask", hashCode());
        }
        else
        {
          a locala = com.tencent.mm.plugin.downloader.model.d.Cw(this.lAs);
          if (locala != null)
          {
            locala.field_downloadInWifi = false;
            locala.field_fromDownloadApp = false;
            locala.field_showNotification = true;
            com.tencent.mm.plugin.downloader.model.d.e(locala);
          }
          if (!f.cBv().Cq(this.lAs)) {
            bool = true;
          }
          this.lAq = bool;
        }
      }
    }
    
    public final void bjk()
    {
      AppMethodBeat.i(45897);
      if (this.lAq)
      {
        if (Util.isNullOrNil(this.lAr)) {}
        for (String str = "fail";; str = String.format("fail:%s", new Object[] { this.lAr }))
        {
          this.kAr.i(this.csv, this.lAi.h(str, null));
          AppMethodBeat.o(45897);
          return;
        }
      }
      this.kAr.i(this.csv, this.lAi.h("ok", null));
      AppMethodBeat.o(45897);
    }
    
    public final void f(Parcel paramParcel)
    {
      boolean bool2 = true;
      AppMethodBeat.i(45898);
      this.lAs = paramParcel.readLong();
      if (paramParcel.readByte() == 1)
      {
        bool1 = true;
        this.lBG = bool1;
        if (paramParcel.readInt() != 1) {
          break label79;
        }
        bool1 = true;
        label40:
        this.lAq = bool1;
        this.lAr = paramParcel.readString();
        if (paramParcel.readInt() != 1) {
          break label84;
        }
      }
      label79:
      label84:
      for (boolean bool1 = bool2;; bool1 = false)
      {
        this.lDa = bool1;
        AppMethodBeat.o(45898);
        return;
        bool1 = false;
        break;
        bool1 = false;
        break label40;
      }
    }
    
    public void writeToParcel(Parcel paramParcel, int paramInt)
    {
      int i = 1;
      AppMethodBeat.i(45899);
      paramParcel.writeLong(this.lAs);
      byte b;
      if (this.lBG)
      {
        b = 1;
        paramParcel.writeByte(b);
        if (!this.lAq) {
          break label78;
        }
        paramInt = 1;
        label39:
        paramParcel.writeInt(paramInt);
        paramParcel.writeString(this.lAr);
        if (!this.lDa) {
          break label83;
        }
      }
      label78:
      label83:
      for (paramInt = i;; paramInt = 0)
      {
        paramParcel.writeInt(paramInt);
        AppMethodBeat.o(45899);
        return;
        b = 0;
        break;
        paramInt = 0;
        break label39;
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.jsapi.appdownload.JsApiResumeDownloadTaskForNative
 * JD-Core Version:    0.7.0.1
 */