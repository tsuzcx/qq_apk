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
    private int bZo;
    private c jAc;
    private m jxX;
    private boolean jyf;
    private String jyg;
    private long jyh;
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
      this.jxX = paramm;
      this.jAc = paramc;
      this.bZo = paramInt;
      this.jyh = paramJSONObject.optLong("downloadId");
      this.mAppId = paramJSONObject.optString("appId");
      this.jyf = true;
      AppMethodBeat.o(45816);
    }
    
    public final void aEA()
    {
      AppMethodBeat.i(45819);
      if (this.jyf)
      {
        if (bt.isNullOrNil(this.jyg)) {}
        for (String str = "fail";; str = String.format("fail:%s", new Object[] { this.jyg }))
        {
          this.jAc.h(this.bZo, this.jxX.e(str, null));
          AppMethodBeat.o(45819);
          return;
        }
      }
      this.jAc.h(this.bZo, this.jxX.e("ok", null));
      AppMethodBeat.o(45819);
    }
    
    public final void aEz()
    {
      AppMethodBeat.i(45818);
      ad.i("MicroMsg.JsApiInstallDownloadTaskForNative", "doInstallDownloadTask, downloadId = %d", new Object[] { Long.valueOf(this.jyh) });
      com.tencent.mm.plugin.downloader.g.a locala;
      if (!bt.isNullOrNil(this.mAppId))
      {
        locala = d.Sk(this.mAppId);
        if ((locala != null) && (locala.field_status == 3) && (i.eK(locala.field_filePath))) {
          com.tencent.mm.plugin.downloader.i.a.a(locala.field_downloadId, false, new com.tencent.mm.pluginsdk.permission.a()
          {
            public final void fO(boolean paramAnonymousBoolean)
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
        aXw();
        AppMethodBeat.o(45818);
        return;
        locala = d.oq(this.jyh);
        if ((locala != null) && (locala.field_status == 3) && (i.eK(locala.field_filePath))) {
          com.tencent.mm.plugin.downloader.i.a.a(locala.field_downloadId, false, new com.tencent.mm.pluginsdk.permission.a()
          {
            public final void fO(boolean paramAnonymousBoolean)
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
    
    public final void e(Parcel paramParcel)
    {
      boolean bool = true;
      AppMethodBeat.i(45820);
      this.jyh = paramParcel.readLong();
      this.mAppId = paramParcel.readString();
      if (paramParcel.readInt() == 1) {}
      for (;;)
      {
        this.jyf = bool;
        this.jyg = paramParcel.readString();
        AppMethodBeat.o(45820);
        return;
        bool = false;
      }
    }
    
    public void writeToParcel(Parcel paramParcel, int paramInt)
    {
      AppMethodBeat.i(45821);
      paramParcel.writeLong(this.jyh);
      paramParcel.writeString(this.mAppId);
      if (this.jyf) {}
      for (paramInt = 1;; paramInt = 0)
      {
        paramParcel.writeInt(paramInt);
        paramParcel.writeString(this.jyg);
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