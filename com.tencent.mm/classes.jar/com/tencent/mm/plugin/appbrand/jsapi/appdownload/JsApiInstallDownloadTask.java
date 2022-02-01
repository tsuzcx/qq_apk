package com.tencent.mm.plugin.appbrand.jsapi.appdownload;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.appbrand.ipc.MainProcessTask;
import com.tencent.mm.plugin.appbrand.jsapi.c;
import com.tencent.mm.plugin.appbrand.jsapi.f;
import com.tencent.mm.plugin.appbrand.jsapi.p;
import com.tencent.mm.plugin.downloader.model.d;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.Util;
import com.tencent.mm.vfs.y;
import org.json.JSONObject;

public final class JsApiInstallDownloadTask
  extends c<f>
{
  public static final int CTRL_INDEX = 442;
  public static final String NAME = "installDownloadTask";
  
  public final void a(f paramf, JSONObject paramJSONObject, int paramInt)
  {
    AppMethodBeat.i(45812);
    new InstallDownloadTask(this, paramf, paramInt, paramJSONObject).bQt();
    AppMethodBeat.o(45812);
  }
  
  static class InstallDownloadTask
    extends MainProcessTask
  {
    public static final Parcelable.Creator<InstallDownloadTask> CREATOR;
    private int eit;
    private String mAppId;
    private f qNp;
    private p ryT;
    private boolean rzb;
    private String rzc;
    private long rzd;
    
    static
    {
      AppMethodBeat.i(45811);
      CREATOR = new Parcelable.Creator() {};
      AppMethodBeat.o(45811);
    }
    
    public InstallDownloadTask(Parcel paramParcel)
    {
      AppMethodBeat.i(45806);
      h(paramParcel);
      AppMethodBeat.o(45806);
    }
    
    public InstallDownloadTask(p paramp, f paramf, int paramInt, JSONObject paramJSONObject)
    {
      AppMethodBeat.i(45805);
      this.ryT = paramp;
      this.qNp = paramf;
      this.eit = paramInt;
      this.rzd = paramJSONObject.optLong("downloadId");
      this.mAppId = paramJSONObject.optString("appId");
      this.rzb = true;
      AppMethodBeat.o(45805);
    }
    
    public final void asn()
    {
      AppMethodBeat.i(45807);
      Log.i("MicroMsg.JsApiInstallDownloadTask", "doInstallDownloadTask, downloadId = %d", new Object[] { Long.valueOf(this.rzd) });
      com.tencent.mm.plugin.downloader.f.a locala;
      if (!Util.isNullOrNil(this.mAppId))
      {
        locala = d.amJ(this.mAppId);
        if ((locala != null) && (locala.field_status == 3) && (y.ZC(locala.field_filePath))) {
          com.tencent.mm.plugin.downloader.h.a.a(locala.field_downloadId, false, new com.tencent.mm.pluginsdk.permission.a()
          {
            public final void iZ(boolean paramAnonymousBoolean)
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
        cpA();
        AppMethodBeat.o(45807);
        return;
        locala = d.la(this.rzd);
        if ((locala != null) && (locala.field_status == 3) && (y.ZC(locala.field_filePath))) {
          com.tencent.mm.plugin.downloader.h.a.a(locala.field_downloadId, false, new com.tencent.mm.pluginsdk.permission.a()
          {
            public final void iZ(boolean paramAnonymousBoolean)
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
    
    public final void bQr()
    {
      AppMethodBeat.i(45808);
      String str;
      if (this.rzb) {
        if (Util.isNullOrNil(this.rzc))
        {
          str = "fail";
          this.qNp.callback(this.eit, this.ryT.ZP(str));
        }
      }
      for (;;)
      {
        cpx();
        AppMethodBeat.o(45808);
        return;
        str = String.format("fail:%s", new Object[] { this.rzc });
        break;
        this.qNp.callback(this.eit, this.ryT.ZP("ok"));
      }
    }
    
    public final void h(Parcel paramParcel)
    {
      boolean bool = true;
      AppMethodBeat.i(45809);
      this.rzd = paramParcel.readLong();
      this.mAppId = paramParcel.readString();
      if (paramParcel.readInt() == 1) {}
      for (;;)
      {
        this.rzb = bool;
        this.rzc = paramParcel.readString();
        AppMethodBeat.o(45809);
        return;
        bool = false;
      }
    }
    
    public void writeToParcel(Parcel paramParcel, int paramInt)
    {
      AppMethodBeat.i(45810);
      paramParcel.writeLong(this.rzd);
      paramParcel.writeString(this.mAppId);
      if (this.rzb) {}
      for (paramInt = 1;; paramInt = 0)
      {
        paramParcel.writeInt(paramInt);
        paramParcel.writeString(this.rzc);
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