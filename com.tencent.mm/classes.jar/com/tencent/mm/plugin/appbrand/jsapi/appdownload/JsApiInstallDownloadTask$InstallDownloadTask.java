package com.tencent.mm.plugin.appbrand.jsapi.appdownload;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.a.e;
import com.tencent.mm.plugin.appbrand.ipc.MainProcessTask;
import com.tencent.mm.plugin.appbrand.jsapi.c;
import com.tencent.mm.plugin.appbrand.jsapi.m;
import com.tencent.mm.plugin.downloader.model.d;
import com.tencent.mm.sdk.platformtools.ab;
import com.tencent.mm.sdk.platformtools.bo;
import org.json.JSONObject;

class JsApiInstallDownloadTask$InstallDownloadTask
  extends MainProcessTask
{
  public static final Parcelable.Creator<InstallDownloadTask> CREATOR;
  private int bxX;
  private c hAC;
  private m hyA;
  private boolean hyI;
  private String hyJ;
  private long hyK;
  private String mAppId;
  
  static
  {
    AppMethodBeat.i(130688);
    CREATOR = new JsApiInstallDownloadTask.InstallDownloadTask.3();
    AppMethodBeat.o(130688);
  }
  
  public JsApiInstallDownloadTask$InstallDownloadTask(Parcel paramParcel)
  {
    AppMethodBeat.i(130683);
    f(paramParcel);
    AppMethodBeat.o(130683);
  }
  
  public JsApiInstallDownloadTask$InstallDownloadTask(m paramm, c paramc, int paramInt, JSONObject paramJSONObject)
  {
    AppMethodBeat.i(130682);
    this.hyA = paramm;
    this.hAC = paramc;
    this.bxX = paramInt;
    this.hyK = paramJSONObject.optLong("downloadId");
    this.mAppId = paramJSONObject.optString("appId");
    this.hyI = true;
    AppMethodBeat.o(130682);
  }
  
  public final void ata()
  {
    AppMethodBeat.i(130684);
    ab.i("MicroMsg.JsApiInstallDownloadTask", "doInstallDownloadTask, downloadId = %d", new Object[] { Long.valueOf(this.hyK) });
    com.tencent.mm.plugin.downloader.g.a locala;
    if (!bo.isNullOrNil(this.mAppId))
    {
      locala = d.JD(this.mAppId);
      if ((locala != null) && (locala.field_status == 3) && (e.cN(locala.field_filePath))) {
        com.tencent.mm.plugin.downloader.i.a.a(locala.field_downloadId, false, new com.tencent.mm.pluginsdk.permission.a()
        {
          public final void eb(boolean paramAnonymousBoolean)
          {
            AppMethodBeat.i(130679);
            JsApiInstallDownloadTask.InstallDownloadTask localInstallDownloadTask = JsApiInstallDownloadTask.InstallDownloadTask.this;
            if (!paramAnonymousBoolean) {}
            for (paramAnonymousBoolean = true;; paramAnonymousBoolean = false)
            {
              JsApiInstallDownloadTask.InstallDownloadTask.a(localInstallDownloadTask, paramAnonymousBoolean);
              AppMethodBeat.o(130679);
              return;
            }
          }
        });
      }
    }
    for (;;)
    {
      aBp();
      AppMethodBeat.o(130684);
      return;
      locala = d.iJ(this.hyK);
      if ((locala != null) && (locala.field_status == 3) && (e.cN(locala.field_filePath))) {
        com.tencent.mm.plugin.downloader.i.a.a(locala.field_downloadId, false, new JsApiInstallDownloadTask.InstallDownloadTask.2(this));
      }
    }
  }
  
  public final void atb()
  {
    AppMethodBeat.i(130685);
    if (this.hyI)
    {
      if (bo.isNullOrNil(this.hyJ)) {}
      for (String str = "fail";; str = String.format("fail:%s", new Object[] { this.hyJ }))
      {
        this.hAC.h(this.bxX, this.hyA.j(str, null));
        AppMethodBeat.o(130685);
        return;
      }
    }
    this.hAC.h(this.bxX, this.hyA.j("ok", null));
    AppMethodBeat.o(130685);
  }
  
  public final void f(Parcel paramParcel)
  {
    boolean bool = true;
    AppMethodBeat.i(130686);
    this.hyK = paramParcel.readLong();
    this.mAppId = paramParcel.readString();
    if (paramParcel.readInt() == 1) {}
    for (;;)
    {
      this.hyI = bool;
      this.hyJ = paramParcel.readString();
      AppMethodBeat.o(130686);
      return;
      bool = false;
    }
  }
  
  public void writeToParcel(Parcel paramParcel, int paramInt)
  {
    AppMethodBeat.i(130687);
    paramParcel.writeLong(this.hyK);
    paramParcel.writeString(this.mAppId);
    if (this.hyI) {}
    for (paramInt = 1;; paramInt = 0)
    {
      paramParcel.writeInt(paramInt);
      paramParcel.writeString(this.hyJ);
      AppMethodBeat.o(130687);
      return;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.jsapi.appdownload.JsApiInstallDownloadTask.InstallDownloadTask
 * JD-Core Version:    0.7.0.1
 */