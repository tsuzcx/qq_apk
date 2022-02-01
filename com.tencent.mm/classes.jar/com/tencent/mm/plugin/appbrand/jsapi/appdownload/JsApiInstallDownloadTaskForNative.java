package com.tencent.mm.plugin.appbrand.jsapi.appdownload;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.appbrand.ipc.AppBrandMainProcessService;
import com.tencent.mm.plugin.appbrand.ipc.MainProcessTask;
import com.tencent.mm.plugin.appbrand.jsapi.c;
import com.tencent.mm.plugin.appbrand.jsapi.m;
import com.tencent.mm.plugin.downloader.model.d;
import com.tencent.mm.sdk.platformtools.ad;
import com.tencent.mm.sdk.platformtools.bt;
import com.tencent.mm.vfs.i;
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
    private m ksO;
    private boolean ksW;
    private String ksX;
    private long ksY;
    private c kuU;
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
      this.ksO = paramm;
      this.kuU = paramc;
      this.cgA = paramInt;
      this.ksY = paramJSONObject.optLong("downloadId");
      this.mAppId = paramJSONObject.optString("appId");
      this.ksW = true;
      AppMethodBeat.o(45816);
    }
    
    public final void aOA()
    {
      AppMethodBeat.i(45818);
      ad.i("MicroMsg.JsApiInstallDownloadTaskForNative", "doInstallDownloadTask, downloadId = %d", new Object[] { Long.valueOf(this.ksY) });
      com.tencent.mm.plugin.downloader.g.a locala;
      if (!bt.isNullOrNil(this.mAppId))
      {
        locala = d.aad(this.mAppId);
        if ((locala != null) && (locala.field_status == 3) && (i.fv(locala.field_filePath))) {
          com.tencent.mm.plugin.downloader.i.a.a(locala.field_downloadId, false, new com.tencent.mm.pluginsdk.permission.a()
          {
            public final void gp(boolean paramAnonymousBoolean)
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
        bhX();
        AppMethodBeat.o(45818);
        return;
        locala = d.ua(this.ksY);
        if ((locala != null) && (locala.field_status == 3) && (i.fv(locala.field_filePath))) {
          com.tencent.mm.plugin.downloader.i.a.a(locala.field_downloadId, false, new com.tencent.mm.pluginsdk.permission.a()
          {
            public final void gp(boolean paramAnonymousBoolean)
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
    
    public final void aOB()
    {
      AppMethodBeat.i(45819);
      if (this.ksW)
      {
        if (bt.isNullOrNil(this.ksX)) {}
        for (String str = "fail";; str = String.format("fail:%s", new Object[] { this.ksX }))
        {
          this.kuU.h(this.cgA, this.ksO.e(str, null));
          AppMethodBeat.o(45819);
          return;
        }
      }
      this.kuU.h(this.cgA, this.ksO.e("ok", null));
      AppMethodBeat.o(45819);
    }
    
    public final void e(Parcel paramParcel)
    {
      boolean bool = true;
      AppMethodBeat.i(45820);
      this.ksY = paramParcel.readLong();
      this.mAppId = paramParcel.readString();
      if (paramParcel.readInt() == 1) {}
      for (;;)
      {
        this.ksW = bool;
        this.ksX = paramParcel.readString();
        AppMethodBeat.o(45820);
        return;
        bool = false;
      }
    }
    
    public void writeToParcel(Parcel paramParcel, int paramInt)
    {
      AppMethodBeat.i(45821);
      paramParcel.writeLong(this.ksY);
      paramParcel.writeString(this.mAppId);
      if (this.ksW) {}
      for (paramInt = 1;; paramInt = 0)
      {
        paramParcel.writeInt(paramInt);
        paramParcel.writeString(this.ksX);
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