package com.tencent.mm.plugin.appbrand.jsapi.appdownload;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.appbrand.ipc.MainProcessTask;
import com.tencent.mm.plugin.appbrand.jsapi.c;
import com.tencent.mm.plugin.appbrand.jsapi.p;
import com.tencent.mm.plugin.appbrand.y;
import com.tencent.mm.plugin.downloader.f.a;
import com.tencent.mm.plugin.downloader.model.f;
import com.tencent.mm.plugin.downloader.model.o;
import com.tencent.mm.plugin.downloader.model.o.a;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.MMApplicationContext;
import com.tencent.mm.sdk.platformtools.Util;
import org.json.JSONObject;

public final class JsApiResumeDownloadTaskForNative
  extends c<y>
{
  public static final int CTRL_INDEX = 660;
  public static final String NAME = "resumeDownloadTaskForNative";
  
  static class ResumeDownloadTask
    extends MainProcessTask
  {
    public static final Parcelable.Creator<ResumeDownloadTask> CREATOR;
    private int eit;
    private y qsi;
    private boolean rAz;
    private boolean rCu;
    private p ryT;
    private boolean rzb;
    private String rzc;
    private long rzd;
    
    static
    {
      AppMethodBeat.i(45900);
      CREATOR = new Parcelable.Creator() {};
      AppMethodBeat.o(45900);
    }
    
    public ResumeDownloadTask(Parcel paramParcel)
    {
      AppMethodBeat.i(45895);
      h(paramParcel);
      AppMethodBeat.o(45895);
    }
    
    public ResumeDownloadTask(p paramp, y paramy, int paramInt, JSONObject paramJSONObject)
    {
      AppMethodBeat.i(45894);
      this.ryT = paramp;
      this.qsi = paramy;
      this.eit = paramInt;
      this.rzd = paramJSONObject.optLong("downloadId");
      this.rCu = paramJSONObject.optBoolean("useDownloaderWidget", false);
      this.rAz = paramJSONObject.optBoolean("downloadInWifi", false);
      this.rzb = true;
      AppMethodBeat.o(45894);
    }
    
    public final void asn()
    {
      boolean bool = false;
      AppMethodBeat.i(45896);
      Log.i("MicroMsg.JsApiResumeDownloadTaskForNative", "doQueryDownloadTask, downloadId = %d", new Object[] { Long.valueOf(this.rzd) });
      if (this.rzd <= 0L) {
        this.rzc = "downloadId invalid";
      }
      for (;;)
      {
        cpA();
        AppMethodBeat.o(45896);
        return;
        if (this.rCu)
        {
          o.a(MMApplicationContext.getContext(), this.rzd, this.rAz, false, new o.a()
          {
            public final void j(String paramAnonymousString, JSONObject paramAnonymousJSONObject)
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
          a locala = com.tencent.mm.plugin.downloader.model.d.la(this.rzd);
          if (locala != null)
          {
            locala.field_downloadInWifi = false;
            locala.field_fromDownloadApp = false;
            locala.field_showNotification = true;
            com.tencent.mm.plugin.downloader.model.d.e(locala);
          }
          if (!f.duv().kU(this.rzd)) {
            bool = true;
          }
          this.rzb = bool;
        }
      }
    }
    
    public final void bQr()
    {
      AppMethodBeat.i(45897);
      if (this.rzb)
      {
        if (Util.isNullOrNil(this.rzc)) {}
        for (String str = "fail";; str = String.format("fail:%s", new Object[] { this.rzc }))
        {
          this.qsi.callback(this.eit, this.ryT.ZP(str));
          AppMethodBeat.o(45897);
          return;
        }
      }
      this.qsi.callback(this.eit, this.ryT.ZP("ok"));
      AppMethodBeat.o(45897);
    }
    
    public final void h(Parcel paramParcel)
    {
      boolean bool2 = true;
      AppMethodBeat.i(45898);
      this.rzd = paramParcel.readLong();
      if (paramParcel.readByte() == 1)
      {
        bool1 = true;
        this.rAz = bool1;
        if (paramParcel.readInt() != 1) {
          break label79;
        }
        bool1 = true;
        label40:
        this.rzb = bool1;
        this.rzc = paramParcel.readString();
        if (paramParcel.readInt() != 1) {
          break label84;
        }
      }
      label79:
      label84:
      for (boolean bool1 = bool2;; bool1 = false)
      {
        this.rCu = bool1;
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
      paramParcel.writeLong(this.rzd);
      byte b;
      if (this.rAz)
      {
        b = 1;
        paramParcel.writeByte(b);
        if (!this.rzb) {
          break label78;
        }
        paramInt = 1;
        label39:
        paramParcel.writeInt(paramInt);
        paramParcel.writeString(this.rzc);
        if (!this.rCu) {
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