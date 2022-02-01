package com.tencent.mm.plugin.appbrand.jsapi.appdownload;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.appbrand.ipc.AppBrandMainProcessService;
import com.tencent.mm.plugin.appbrand.ipc.MainProcessTask;
import com.tencent.mm.plugin.appbrand.jsapi.c;
import com.tencent.mm.plugin.appbrand.jsapi.m;
import com.tencent.mm.plugin.downloader.model.d;
import com.tencent.mm.sdk.platformtools.ac;
import com.tencent.mm.sdk.platformtools.bs;
import com.tencent.mm.vfs.i;
import org.json.JSONObject;

public final class JsApiInstallDownloadTask
  extends com.tencent.mm.plugin.appbrand.jsapi.a<c>
{
  public static final int CTRL_INDEX = 442;
  public static final String NAME = "installDownloadTask";
  
  public final void a(c paramc, JSONObject paramJSONObject, int paramInt)
  {
    AppMethodBeat.i(45812);
    AppBrandMainProcessService.a(new InstallDownloadTask(this, paramc, paramInt, paramJSONObject));
    AppMethodBeat.o(45812);
  }
  
  static class InstallDownloadTask
    extends MainProcessTask
  {
    public static final Parcelable.Creator<InstallDownloadTask> CREATOR;
    private int bWl;
    private boolean jYA;
    private String jYB;
    private long jYC;
    private m jYs;
    private c kay;
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
      e(paramParcel);
      AppMethodBeat.o(45806);
    }
    
    public InstallDownloadTask(m paramm, c paramc, int paramInt, JSONObject paramJSONObject)
    {
      AppMethodBeat.i(45805);
      this.jYs = paramm;
      this.kay = paramc;
      this.bWl = paramInt;
      this.jYC = paramJSONObject.optLong("downloadId");
      this.mAppId = paramJSONObject.optString("appId");
      this.jYA = true;
      AppMethodBeat.o(45805);
    }
    
    public final void aLq()
    {
      AppMethodBeat.i(45807);
      ac.i("MicroMsg.JsApiInstallDownloadTask", "doInstallDownloadTask, downloadId = %d", new Object[] { Long.valueOf(this.jYC) });
      com.tencent.mm.plugin.downloader.g.a locala;
      if (!bs.isNullOrNil(this.mAppId))
      {
        locala = d.Ww(this.mAppId);
        if ((locala != null) && (locala.field_status == 3) && (i.eA(locala.field_filePath))) {
          com.tencent.mm.plugin.downloader.i.a.a(locala.field_downloadId, false, new com.tencent.mm.pluginsdk.permission.a()
          {
            public final void gk(boolean paramAnonymousBoolean)
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
        bet();
        AppMethodBeat.o(45807);
        return;
        locala = d.sc(this.jYC);
        if ((locala != null) && (locala.field_status == 3) && (i.eA(locala.field_filePath))) {
          com.tencent.mm.plugin.downloader.i.a.a(locala.field_downloadId, false, new com.tencent.mm.pluginsdk.permission.a()
          {
            public final void gk(boolean paramAnonymousBoolean)
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
    
    public final void aLr()
    {
      AppMethodBeat.i(45808);
      if (this.jYA)
      {
        if (bs.isNullOrNil(this.jYB)) {}
        for (String str = "fail";; str = String.format("fail:%s", new Object[] { this.jYB }))
        {
          this.kay.h(this.bWl, this.jYs.e(str, null));
          AppMethodBeat.o(45808);
          return;
        }
      }
      this.kay.h(this.bWl, this.jYs.e("ok", null));
      AppMethodBeat.o(45808);
    }
    
    public final void e(Parcel paramParcel)
    {
      boolean bool = true;
      AppMethodBeat.i(45809);
      this.jYC = paramParcel.readLong();
      this.mAppId = paramParcel.readString();
      if (paramParcel.readInt() == 1) {}
      for (;;)
      {
        this.jYA = bool;
        this.jYB = paramParcel.readString();
        AppMethodBeat.o(45809);
        return;
        bool = false;
      }
    }
    
    public void writeToParcel(Parcel paramParcel, int paramInt)
    {
      AppMethodBeat.i(45810);
      paramParcel.writeLong(this.jYC);
      paramParcel.writeString(this.mAppId);
      if (this.jYA) {}
      for (paramInt = 1;; paramInt = 0)
      {
        paramParcel.writeInt(paramInt);
        paramParcel.writeString(this.jYB);
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