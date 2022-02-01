package com.tencent.mm.plugin.appbrand.jsapi.appdownload;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.appbrand.ipc.AppBrandMainProcessService;
import com.tencent.mm.plugin.appbrand.ipc.MainProcessTask;
import com.tencent.mm.plugin.appbrand.jsapi.c;
import com.tencent.mm.plugin.appbrand.jsapi.m;
import com.tencent.mm.plugin.downloader.model.d;
import com.tencent.mm.sdk.platformtools.ae;
import com.tencent.mm.sdk.platformtools.bu;
import com.tencent.mm.vfs.o;
import org.json.JSONObject;

public final class JsApiInstallDownloadTaskForNative
  extends com.tencent.mm.plugin.appbrand.jsapi.a<c>
{
  public static final int CTRL_INDEX = 658;
  public static final String NAME = "installDownloadTaskForNative";
  
  public final void a(c paramc, JSONObject paramJSONObject, int paramInt)
  {
    AppMethodBeat.i(45823);
    AppBrandMainProcessService.a(new InstallDownloadTask(this, paramc, paramInt, paramJSONObject));
    AppMethodBeat.o(45823);
  }
  
  static class InstallDownloadTask
    extends MainProcessTask
  {
    public static final Parcelable.Creator<InstallDownloadTask> CREATOR;
    private int cgA;
    private c jQp;
    private m kwe;
    private boolean kwm;
    private String kwn;
    private long kwo;
    private String mAppId;
    
    static
    {
      AppMethodBeat.i(45822);
      CREATOR = new Parcelable.Creator() {};
      AppMethodBeat.o(45822);
    }
    
    public InstallDownloadTask(Parcel paramParcel)
    {
      AppMethodBeat.i(45817);
      e(paramParcel);
      AppMethodBeat.o(45817);
    }
    
    public InstallDownloadTask(m paramm, c paramc, int paramInt, JSONObject paramJSONObject)
    {
      AppMethodBeat.i(45816);
      this.kwe = paramm;
      this.jQp = paramc;
      this.cgA = paramInt;
      this.kwo = paramJSONObject.optLong("downloadId");
      this.mAppId = paramJSONObject.optString("appId");
      this.kwm = true;
      AppMethodBeat.o(45816);
    }
    
    public final void aOX()
    {
      AppMethodBeat.i(45818);
      ae.i("MicroMsg.JsApiInstallDownloadTaskForNative", "doInstallDownloadTask, downloadId = %d", new Object[] { Long.valueOf(this.kwo) });
      com.tencent.mm.plugin.downloader.g.a locala;
      if (!bu.isNullOrNil(this.mAppId))
      {
        locala = d.aaU(this.mAppId);
        if ((locala != null) && (locala.field_status == 3) && (o.fB(locala.field_filePath))) {
          com.tencent.mm.plugin.downloader.i.a.a(locala.field_downloadId, false, new com.tencent.mm.pluginsdk.permission.a()
          {
            public final void gn(boolean paramAnonymousBoolean)
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
        biG();
        AppMethodBeat.o(45818);
        return;
        locala = d.ur(this.kwo);
        if ((locala != null) && (locala.field_status == 3) && (o.fB(locala.field_filePath))) {
          com.tencent.mm.plugin.downloader.i.a.a(locala.field_downloadId, false, new com.tencent.mm.pluginsdk.permission.a()
          {
            public final void gn(boolean paramAnonymousBoolean)
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
    
    public final void aOY()
    {
      AppMethodBeat.i(45819);
      if (this.kwm)
      {
        if (bu.isNullOrNil(this.kwn)) {}
        for (String str = "fail";; str = String.format("fail:%s", new Object[] { this.kwn }))
        {
          this.jQp.h(this.cgA, this.kwe.e(str, null));
          AppMethodBeat.o(45819);
          return;
        }
      }
      this.jQp.h(this.cgA, this.kwe.e("ok", null));
      AppMethodBeat.o(45819);
    }
    
    public final void e(Parcel paramParcel)
    {
      boolean bool = true;
      AppMethodBeat.i(45820);
      this.kwo = paramParcel.readLong();
      this.mAppId = paramParcel.readString();
      if (paramParcel.readInt() == 1) {}
      for (;;)
      {
        this.kwm = bool;
        this.kwn = paramParcel.readString();
        AppMethodBeat.o(45820);
        return;
        bool = false;
      }
    }
    
    public void writeToParcel(Parcel paramParcel, int paramInt)
    {
      AppMethodBeat.i(45821);
      paramParcel.writeLong(this.kwo);
      paramParcel.writeString(this.mAppId);
      if (this.kwm) {}
      for (paramInt = 1;; paramInt = 0)
      {
        paramParcel.writeInt(paramInt);
        paramParcel.writeString(this.kwn);
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