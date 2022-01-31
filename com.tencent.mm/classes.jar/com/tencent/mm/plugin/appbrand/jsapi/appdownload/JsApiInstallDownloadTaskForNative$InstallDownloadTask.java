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

class JsApiInstallDownloadTaskForNative$InstallDownloadTask
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
    AppMethodBeat.i(143320);
    CREATOR = new JsApiInstallDownloadTaskForNative.InstallDownloadTask.3();
    AppMethodBeat.o(143320);
  }
  
  public JsApiInstallDownloadTaskForNative$InstallDownloadTask(Parcel paramParcel)
  {
    AppMethodBeat.i(143315);
    f(paramParcel);
    AppMethodBeat.o(143315);
  }
  
  public JsApiInstallDownloadTaskForNative$InstallDownloadTask(m paramm, c paramc, int paramInt, JSONObject paramJSONObject)
  {
    AppMethodBeat.i(143314);
    this.hyA = paramm;
    this.hAC = paramc;
    this.bxX = paramInt;
    this.hyK = paramJSONObject.optLong("downloadId");
    this.mAppId = paramJSONObject.optString("appId");
    this.hyI = true;
    AppMethodBeat.o(143314);
  }
  
  public final void ata()
  {
    AppMethodBeat.i(143316);
    ab.i("MicroMsg.JsApiInstallDownloadTaskForNative", "doInstallDownloadTask, downloadId = %d", new Object[] { Long.valueOf(this.hyK) });
    com.tencent.mm.plugin.downloader.g.a locala;
    if (!bo.isNullOrNil(this.mAppId))
    {
      locala = d.JD(this.mAppId);
      if ((locala != null) && (locala.field_status == 3) && (e.cN(locala.field_filePath))) {
        com.tencent.mm.plugin.downloader.i.a.a(locala.field_downloadId, false, new JsApiInstallDownloadTaskForNative.InstallDownloadTask.1(this));
      }
    }
    for (;;)
    {
      aBp();
      AppMethodBeat.o(143316);
      return;
      locala = d.iJ(this.hyK);
      if ((locala != null) && (locala.field_status == 3) && (e.cN(locala.field_filePath))) {
        com.tencent.mm.plugin.downloader.i.a.a(locala.field_downloadId, false, new JsApiInstallDownloadTaskForNative.InstallDownloadTask.2(this));
      }
    }
  }
  
  public final void atb()
  {
    AppMethodBeat.i(143317);
    if (this.hyI)
    {
      if (bo.isNullOrNil(this.hyJ)) {}
      for (String str = "fail";; str = String.format("fail:%s", new Object[] { this.hyJ }))
      {
        this.hAC.h(this.bxX, this.hyA.j(str, null));
        AppMethodBeat.o(143317);
        return;
      }
    }
    this.hAC.h(this.bxX, this.hyA.j("ok", null));
    AppMethodBeat.o(143317);
  }
  
  public final void f(Parcel paramParcel)
  {
    boolean bool = true;
    AppMethodBeat.i(143318);
    this.hyK = paramParcel.readLong();
    this.mAppId = paramParcel.readString();
    if (paramParcel.readInt() == 1) {}
    for (;;)
    {
      this.hyI = bool;
      this.hyJ = paramParcel.readString();
      AppMethodBeat.o(143318);
      return;
      bool = false;
    }
  }
  
  public void writeToParcel(Parcel paramParcel, int paramInt)
  {
    AppMethodBeat.i(143319);
    paramParcel.writeLong(this.hyK);
    paramParcel.writeString(this.mAppId);
    if (this.hyI) {}
    for (paramInt = 1;; paramInt = 0)
    {
      paramParcel.writeInt(paramInt);
      paramParcel.writeString(this.hyJ);
      AppMethodBeat.o(143319);
      return;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.jsapi.appdownload.JsApiInstallDownloadTaskForNative.InstallDownloadTask
 * JD-Core Version:    0.7.0.1
 */