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

public final class JsApiInstallDownloadTaskForNative
  extends c<f>
{
  public static final int CTRL_INDEX = 658;
  public static final String NAME = "installDownloadTaskForNative";
  
  public final void a(f paramf, JSONObject paramJSONObject, int paramInt)
  {
    AppMethodBeat.i(45823);
    new InstallDownloadTask(this, paramf, paramInt, paramJSONObject).bQt();
    AppMethodBeat.o(45823);
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
      AppMethodBeat.i(45822);
      CREATOR = new Parcelable.Creator() {};
      AppMethodBeat.o(45822);
    }
    
    public InstallDownloadTask(Parcel paramParcel)
    {
      AppMethodBeat.i(45817);
      h(paramParcel);
      AppMethodBeat.o(45817);
    }
    
    public InstallDownloadTask(p paramp, f paramf, int paramInt, JSONObject paramJSONObject)
    {
      AppMethodBeat.i(45816);
      this.ryT = paramp;
      this.qNp = paramf;
      this.eit = paramInt;
      this.rzd = paramJSONObject.optLong("downloadId");
      this.mAppId = paramJSONObject.optString("appId");
      this.rzb = true;
      AppMethodBeat.o(45816);
    }
    
    public final void asn()
    {
      AppMethodBeat.i(45818);
      Log.i("MicroMsg.JsApiInstallDownloadTaskForNative", "doInstallDownloadTask, downloadId = %d", new Object[] { Long.valueOf(this.rzd) });
      com.tencent.mm.plugin.downloader.f.a locala;
      if (!Util.isNullOrNil(this.mAppId))
      {
        locala = d.amJ(this.mAppId);
        if ((locala != null) && (locala.field_status == 3) && (y.ZC(locala.field_filePath))) {
          com.tencent.mm.plugin.downloader.h.a.a(locala.field_downloadId, false, new com.tencent.mm.pluginsdk.permission.a()
          {
            public final void iZ(boolean paramAnonymousBoolean)
            {
              AppMethodBeat.i(45813);
              JsApiInstallDownloadTaskForNative.InstallDownloadTask localInstallDownloadTask = JsApiInstallDownloadTaskForNative.InstallDownloadTask.this;
              if (!paramAnonymousBoolean) {}
              for (paramAnonymousBoolean = true;; paramAnonymousBoolean = false)
              {
                JsApiInstallDownloadTaskForNative.InstallDownloadTask.a(localInstallDownloadTask, paramAnonymousBoolean);
                AppMethodBeat.o(45813);
                return;
              }
            }
          });
        }
      }
      for (;;)
      {
        cpA();
        AppMethodBeat.o(45818);
        return;
        locala = d.la(this.rzd);
        if ((locala != null) && (locala.field_status == 3) && (y.ZC(locala.field_filePath))) {
          com.tencent.mm.plugin.downloader.h.a.a(locala.field_downloadId, false, new com.tencent.mm.pluginsdk.permission.a()
          {
            public final void iZ(boolean paramAnonymousBoolean)
            {
              AppMethodBeat.i(45814);
              JsApiInstallDownloadTaskForNative.InstallDownloadTask localInstallDownloadTask = JsApiInstallDownloadTaskForNative.InstallDownloadTask.this;
              if (!paramAnonymousBoolean) {}
              for (paramAnonymousBoolean = true;; paramAnonymousBoolean = false)
              {
                JsApiInstallDownloadTaskForNative.InstallDownloadTask.a(localInstallDownloadTask, paramAnonymousBoolean);
                AppMethodBeat.o(45814);
                return;
              }
            }
          });
        }
      }
    }
    
    public final void bQr()
    {
      AppMethodBeat.i(45819);
      if (this.rzb)
      {
        if (Util.isNullOrNil(this.rzc)) {}
        for (String str = "fail";; str = String.format("fail:%s", new Object[] { this.rzc }))
        {
          this.qNp.callback(this.eit, this.ryT.ZP(str));
          AppMethodBeat.o(45819);
          return;
        }
      }
      this.qNp.callback(this.eit, this.ryT.ZP("ok"));
      AppMethodBeat.o(45819);
    }
    
    public final void h(Parcel paramParcel)
    {
      boolean bool = true;
      AppMethodBeat.i(45820);
      this.rzd = paramParcel.readLong();
      this.mAppId = paramParcel.readString();
      if (paramParcel.readInt() == 1) {}
      for (;;)
      {
        this.rzb = bool;
        this.rzc = paramParcel.readString();
        AppMethodBeat.o(45820);
        return;
        bool = false;
      }
    }
    
    public void writeToParcel(Parcel paramParcel, int paramInt)
    {
      AppMethodBeat.i(45821);
      paramParcel.writeLong(this.rzd);
      paramParcel.writeString(this.mAppId);
      if (this.rzb) {}
      for (paramInt = 1;; paramInt = 0)
      {
        paramParcel.writeInt(paramInt);
        paramParcel.writeString(this.rzc);
        AppMethodBeat.o(45821);
        return;
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.jsapi.appdownload.JsApiInstallDownloadTaskForNative
 * JD-Core Version:    0.7.0.1
 */