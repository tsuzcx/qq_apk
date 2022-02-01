package com.tencent.mm.plugin.appbrand.jsapi.appdownload;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.appbrand.ipc.MainProcessTask;
import com.tencent.mm.plugin.appbrand.jsapi.c;
import com.tencent.mm.plugin.appbrand.v;
import com.tencent.mm.plugin.downloader.g.a;
import com.tencent.mm.plugin.downloader.model.f;
import com.tencent.mm.plugin.downloader.model.o.a;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.MMApplicationContext;
import com.tencent.mm.sdk.platformtools.Util;
import org.json.JSONObject;

public final class JsApiResumeDownloadTaskForNative
  extends c<v>
{
  public static final int CTRL_INDEX = 660;
  public static final String NAME = "resumeDownloadTaskForNative";
  
  static class ResumeDownloadTask
    extends MainProcessTask
  {
    public static final Parcelable.Creator<ResumeDownloadTask> CREATOR;
    private int cqA;
    private v ntA;
    private boolean ovH;
    private String ovI;
    private long ovJ;
    private com.tencent.mm.plugin.appbrand.jsapi.o ovz;
    private boolean owW;
    private boolean oyC;
    
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
    
    public ResumeDownloadTask(com.tencent.mm.plugin.appbrand.jsapi.o paramo, v paramv, int paramInt, JSONObject paramJSONObject)
    {
      AppMethodBeat.i(45894);
      this.ovz = paramo;
      this.ntA = paramv;
      this.cqA = paramInt;
      this.ovJ = paramJSONObject.optLong("downloadId");
      this.oyC = paramJSONObject.optBoolean("useDownloaderWidget", false);
      this.owW = paramJSONObject.optBoolean("downloadInWifi", false);
      this.ovH = true;
      AppMethodBeat.o(45894);
    }
    
    public final void RW()
    {
      boolean bool = false;
      AppMethodBeat.i(45896);
      Log.i("MicroMsg.JsApiResumeDownloadTaskForNative", "doQueryDownloadTask, downloadId = %d", new Object[] { Long.valueOf(this.ovJ) });
      if (this.ovJ <= 0L) {
        this.ovI = "downloadId invalid";
      }
      for (;;)
      {
        bPt();
        AppMethodBeat.o(45896);
        return;
        if (this.oyC)
        {
          com.tencent.mm.plugin.downloader.model.o.a(MMApplicationContext.getContext(), this.ovJ, this.owW, false, new o.a()
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
          a locala = com.tencent.mm.plugin.downloader.model.d.IF(this.ovJ);
          if (locala != null)
          {
            locala.field_downloadInWifi = false;
            locala.field_fromDownloadApp = false;
            locala.field_showNotification = true;
            com.tencent.mm.plugin.downloader.model.d.e(locala);
          }
          if (!f.cPZ().Iz(this.ovJ)) {
            bool = true;
          }
          this.ovH = bool;
        }
      }
    }
    
    public final void bsK()
    {
      AppMethodBeat.i(45897);
      if (this.ovH)
      {
        if (Util.isNullOrNil(this.ovI)) {}
        for (String str = "fail";; str = String.format("fail:%s", new Object[] { this.ovI }))
        {
          this.ntA.j(this.cqA, this.ovz.h(str, null));
          AppMethodBeat.o(45897);
          return;
        }
      }
      this.ntA.j(this.cqA, this.ovz.h("ok", null));
      AppMethodBeat.o(45897);
    }
    
    public final void f(Parcel paramParcel)
    {
      boolean bool2 = true;
      AppMethodBeat.i(45898);
      this.ovJ = paramParcel.readLong();
      if (paramParcel.readByte() == 1)
      {
        bool1 = true;
        this.owW = bool1;
        if (paramParcel.readInt() != 1) {
          break label79;
        }
        bool1 = true;
        label40:
        this.ovH = bool1;
        this.ovI = paramParcel.readString();
        if (paramParcel.readInt() != 1) {
          break label84;
        }
      }
      label79:
      label84:
      for (boolean bool1 = bool2;; bool1 = false)
      {
        this.oyC = bool1;
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
      paramParcel.writeLong(this.ovJ);
      byte b;
      if (this.owW)
      {
        b = 1;
        paramParcel.writeByte(b);
        if (!this.ovH) {
          break label78;
        }
        paramInt = 1;
        label39:
        paramParcel.writeInt(paramInt);
        paramParcel.writeString(this.ovI);
        if (!this.oyC) {
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