package com.tencent.mm.plugin.appbrand.jsapi.appdownload;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.appbrand.ipc.AppBrandMainProcessService;
import com.tencent.mm.plugin.appbrand.ipc.MainProcessTask;
import com.tencent.mm.plugin.appbrand.jsapi.f;
import com.tencent.mm.plugin.appbrand.jsapi.p;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.Util;
import com.tencent.mm.vfs.s;
import org.json.JSONObject;

public final class JsApiInstallDownloadTask
  extends com.tencent.mm.plugin.appbrand.jsapi.d<f>
{
  public static final int CTRL_INDEX = 442;
  public static final String NAME = "installDownloadTask";
  
  public final void a(f paramf, JSONObject paramJSONObject, int paramInt)
  {
    AppMethodBeat.i(45812);
    AppBrandMainProcessService.a(new InstallDownloadTask(this, paramf, paramInt, paramJSONObject));
    AppMethodBeat.o(45812);
  }
  
  static class InstallDownloadTask
    extends MainProcessTask
  {
    public static final Parcelable.Creator<InstallDownloadTask> CREATOR;
    private int csv;
    private f kSY;
    private p lAi;
    private boolean lAq;
    private String lAr;
    private long lAs;
    private String mAppId;
    
    static
    {
      AppMethodBeat.i(45811);
      CREATOR = new Parcelable.Creator() {};
      AppMethodBeat.o(45811);
    }
    
    public InstallDownloadTask(Parcel paramParcel)
    {
      AppMethodBeat.i(45806);
      f(paramParcel);
      AppMethodBeat.o(45806);
    }
    
    public InstallDownloadTask(p paramp, f paramf, int paramInt, JSONObject paramJSONObject)
    {
      AppMethodBeat.i(45805);
      this.lAi = paramp;
      this.kSY = paramf;
      this.csv = paramInt;
      this.lAs = paramJSONObject.optLong("downloadId");
      this.mAppId = paramJSONObject.optString("appId");
      this.lAq = true;
      AppMethodBeat.o(45805);
    }
    
    public final void bjj()
    {
      AppMethodBeat.i(45807);
      Log.i("MicroMsg.JsApiInstallDownloadTask", "doInstallDownloadTask, downloadId = %d", new Object[] { Long.valueOf(this.lAs) });
      com.tencent.mm.plugin.downloader.g.a locala;
      if (!Util.isNullOrNil(this.mAppId))
      {
        locala = com.tencent.mm.plugin.downloader.model.d.alb(this.mAppId);
        if ((locala != null) && (locala.field_status == 3) && (s.YS(locala.field_filePath))) {
          com.tencent.mm.plugin.downloader.i.a.a(locala.field_downloadId, false, new com.tencent.mm.pluginsdk.permission.a()
          {
            public final void hk(boolean paramAnonymousBoolean)
            {
              AppMethodBeat.i(45802);
              JsApiInstallDownloadTask.InstallDownloadTask localInstallDownloadTask = JsApiInstallDownloadTask.InstallDownloadTask.this;
              if (!paramAnonymousBoolean) {}
              for (paramAnonymousBoolean = true;; paramAnonymousBoolean = false)
              {
                JsApiInstallDownloadTask.InstallDownloadTask.a(localInstallDownloadTask, paramAnonymousBoolean);
                AppMethodBeat.o(45802);
                return;
              }
            }
          });
        }
      }
      for (;;)
      {
        bDU();
        AppMethodBeat.o(45807);
        return;
        locala = com.tencent.mm.plugin.downloader.model.d.Cw(this.lAs);
        if ((locala != null) && (locala.field_status == 3) && (s.YS(locala.field_filePath))) {
          com.tencent.mm.plugin.downloader.i.a.a(locala.field_downloadId, false, new com.tencent.mm.pluginsdk.permission.a()
          {
            public final void hk(boolean paramAnonymousBoolean)
            {
              AppMethodBeat.i(45803);
              JsApiInstallDownloadTask.InstallDownloadTask localInstallDownloadTask = JsApiInstallDownloadTask.InstallDownloadTask.this;
              if (!paramAnonymousBoolean) {}
              for (paramAnonymousBoolean = true;; paramAnonymousBoolean = false)
              {
                JsApiInstallDownloadTask.InstallDownloadTask.a(localInstallDownloadTask, paramAnonymousBoolean);
                AppMethodBeat.o(45803);
                return;
              }
            }
          });
        }
      }
    }
    
    public final void bjk()
    {
      AppMethodBeat.i(45808);
      if (this.lAq)
      {
        if (Util.isNullOrNil(this.lAr)) {}
        for (String str = "fail";; str = String.format("fail:%s", new Object[] { this.lAr }))
        {
          this.kSY.i(this.csv, this.lAi.h(str, null));
          AppMethodBeat.o(45808);
          return;
        }
      }
      this.kSY.i(this.csv, this.lAi.h("ok", null));
      AppMethodBeat.o(45808);
    }
    
    public final void f(Parcel paramParcel)
    {
      boolean bool = true;
      AppMethodBeat.i(45809);
      this.lAs = paramParcel.readLong();
      this.mAppId = paramParcel.readString();
      if (paramParcel.readInt() == 1) {}
      for (;;)
      {
        this.lAq = bool;
        this.lAr = paramParcel.readString();
        AppMethodBeat.o(45809);
        return;
        bool = false;
      }
    }
    
    public void writeToParcel(Parcel paramParcel, int paramInt)
    {
      AppMethodBeat.i(45810);
      paramParcel.writeLong(this.lAs);
      paramParcel.writeString(this.mAppId);
      if (this.lAq) {}
      for (paramInt = 1;; paramInt = 0)
      {
        paramParcel.writeInt(paramInt);
        paramParcel.writeString(this.lAr);
        AppMethodBeat.o(45810);
        return;
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.jsapi.appdownload.JsApiInstallDownloadTask
 * JD-Core Version:    0.7.0.1
 */