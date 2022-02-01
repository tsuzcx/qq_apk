package com.tencent.mm.plugin.appbrand.jsapi.appdownload;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.appbrand.ipc.MainProcessTask;
import com.tencent.mm.plugin.appbrand.jsapi.c;
import com.tencent.mm.plugin.appbrand.jsapi.e;
import com.tencent.mm.plugin.appbrand.jsapi.o;
import com.tencent.mm.plugin.downloader.model.d;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.Util;
import com.tencent.mm.vfs.u;
import org.json.JSONObject;

public final class JsApiInstallDownloadTask
  extends c<e>
{
  public static final int CTRL_INDEX = 442;
  public static final String NAME = "installDownloadTask";
  
  public final void a(e parame, JSONObject paramJSONObject, int paramInt)
  {
    AppMethodBeat.i(45812);
    new InstallDownloadTask(this, parame, paramInt, paramJSONObject).bsM();
    AppMethodBeat.o(45812);
  }
  
  static class InstallDownloadTask
    extends MainProcessTask
  {
    public static final Parcelable.Creator<InstallDownloadTask> CREATOR;
    private int cqA;
    private String mAppId;
    private e nNw;
    private boolean ovH;
    private String ovI;
    private long ovJ;
    private o ovz;
    
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
    
    public InstallDownloadTask(o paramo, e parame, int paramInt, JSONObject paramJSONObject)
    {
      AppMethodBeat.i(45805);
      this.ovz = paramo;
      this.nNw = parame;
      this.cqA = paramInt;
      this.ovJ = paramJSONObject.optLong("downloadId");
      this.mAppId = paramJSONObject.optString("appId");
      this.ovH = true;
      AppMethodBeat.o(45805);
    }
    
    public final void RW()
    {
      AppMethodBeat.i(45807);
      Log.i("MicroMsg.JsApiInstallDownloadTask", "doInstallDownloadTask, downloadId = %d", new Object[] { Long.valueOf(this.ovJ) });
      com.tencent.mm.plugin.downloader.g.a locala;
      if (!Util.isNullOrNil(this.mAppId))
      {
        locala = d.asU(this.mAppId);
        if ((locala != null) && (locala.field_status == 3) && (u.agG(locala.field_filePath))) {
          com.tencent.mm.plugin.downloader.i.a.a(locala.field_downloadId, false, new com.tencent.mm.pluginsdk.permission.a()
          {
            public final void ia(boolean paramAnonymousBoolean)
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
        bPt();
        AppMethodBeat.o(45807);
        return;
        locala = d.IF(this.ovJ);
        if ((locala != null) && (locala.field_status == 3) && (u.agG(locala.field_filePath))) {
          com.tencent.mm.plugin.downloader.i.a.a(locala.field_downloadId, false, new com.tencent.mm.pluginsdk.permission.a()
          {
            public final void ia(boolean paramAnonymousBoolean)
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
    
    public final void bsK()
    {
      AppMethodBeat.i(45808);
      if (this.ovH)
      {
        if (Util.isNullOrNil(this.ovI)) {}
        for (String str = "fail";; str = String.format("fail:%s", new Object[] { this.ovI }))
        {
          this.nNw.j(this.cqA, this.ovz.h(str, null));
          AppMethodBeat.o(45808);
          return;
        }
      }
      this.nNw.j(this.cqA, this.ovz.h("ok", null));
      AppMethodBeat.o(45808);
    }
    
    public final void f(Parcel paramParcel)
    {
      boolean bool = true;
      AppMethodBeat.i(45809);
      this.ovJ = paramParcel.readLong();
      this.mAppId = paramParcel.readString();
      if (paramParcel.readInt() == 1) {}
      for (;;)
      {
        this.ovH = bool;
        this.ovI = paramParcel.readString();
        AppMethodBeat.o(45809);
        return;
        bool = false;
      }
    }
    
    public void writeToParcel(Parcel paramParcel, int paramInt)
    {
      AppMethodBeat.i(45810);
      paramParcel.writeLong(this.ovJ);
      paramParcel.writeString(this.mAppId);
      if (this.ovH) {}
      for (paramInt = 1;; paramInt = 0)
      {
        paramParcel.writeInt(paramInt);
        paramParcel.writeString(this.ovI);
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