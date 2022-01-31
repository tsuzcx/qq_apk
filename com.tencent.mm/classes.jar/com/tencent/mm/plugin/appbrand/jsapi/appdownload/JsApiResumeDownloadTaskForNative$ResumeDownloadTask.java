package com.tencent.mm.plugin.appbrand.jsapi.appdownload;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.appbrand.ipc.MainProcessTask;
import com.tencent.mm.plugin.appbrand.jsapi.m;
import com.tencent.mm.plugin.appbrand.r;
import com.tencent.mm.plugin.downloader.g.a;
import com.tencent.mm.plugin.downloader.model.f;
import com.tencent.mm.plugin.downloader.model.o;
import com.tencent.mm.sdk.platformtools.ab;
import com.tencent.mm.sdk.platformtools.ah;
import com.tencent.mm.sdk.platformtools.bo;
import org.json.JSONObject;

class JsApiResumeDownloadTaskForNative$ResumeDownloadTask
  extends MainProcessTask
{
  public static final Parcelable.Creator<ResumeDownloadTask> CREATOR;
  private int bxX;
  private r gPA;
  private boolean hAW;
  private m hyA;
  private boolean hyI;
  private String hyJ;
  private long hyK;
  private boolean hzD;
  
  static
  {
    AppMethodBeat.i(143377);
    CREATOR = new JsApiResumeDownloadTaskForNative.ResumeDownloadTask.2();
    AppMethodBeat.o(143377);
  }
  
  public JsApiResumeDownloadTaskForNative$ResumeDownloadTask(Parcel paramParcel)
  {
    AppMethodBeat.i(143372);
    f(paramParcel);
    AppMethodBeat.o(143372);
  }
  
  public JsApiResumeDownloadTaskForNative$ResumeDownloadTask(m paramm, r paramr, int paramInt, JSONObject paramJSONObject)
  {
    AppMethodBeat.i(143371);
    this.hyA = paramm;
    this.gPA = paramr;
    this.bxX = paramInt;
    this.hyK = paramJSONObject.optLong("downloadId");
    this.hAW = paramJSONObject.optBoolean("useDownloaderWidget", false);
    this.hzD = paramJSONObject.optBoolean("downloadInWifi", false);
    this.hyI = true;
    AppMethodBeat.o(143371);
  }
  
  public final void ata()
  {
    boolean bool = true;
    AppMethodBeat.i(143373);
    ab.i("MicroMsg.JsApiResumeDownloadTaskForNative", "doQueryDownloadTask, downloadId = %d", new Object[] { Long.valueOf(this.hyK) });
    if (this.hyK <= 0L) {
      this.hyJ = "downloadId invalid";
    }
    for (;;)
    {
      aBp();
      AppMethodBeat.o(143373);
      return;
      if (!this.hAW) {
        break;
      }
      o.a(ah.getContext(), this.hyK, this.hzD, new JsApiResumeDownloadTaskForNative.ResumeDownloadTask.1(this));
      com.tencent.mm.modelstat.d.b(10, "JsApiResumeDownloadApp_resumeDownloadTask", hashCode());
    }
    a locala = com.tencent.mm.plugin.downloader.model.d.iJ(this.hyK);
    if (locala != null)
    {
      locala.field_downloadInWifi = false;
      locala.field_fromDownloadApp = false;
      locala.field_showNotification = true;
      com.tencent.mm.plugin.downloader.model.d.e(locala);
    }
    if (!f.bjl().iC(this.hyK)) {}
    for (;;)
    {
      this.hyI = bool;
      break;
      bool = false;
    }
  }
  
  public final void atb()
  {
    AppMethodBeat.i(143374);
    if (this.hyI)
    {
      if (bo.isNullOrNil(this.hyJ)) {}
      for (String str = "fail";; str = String.format("fail:%s", new Object[] { this.hyJ }))
      {
        this.gPA.h(this.bxX, this.hyA.j(str, null));
        AppMethodBeat.o(143374);
        return;
      }
    }
    this.gPA.h(this.bxX, this.hyA.j("ok", null));
    AppMethodBeat.o(143374);
  }
  
  public final void f(Parcel paramParcel)
  {
    boolean bool2 = true;
    AppMethodBeat.i(143375);
    this.hyK = paramParcel.readLong();
    if (paramParcel.readByte() == 1)
    {
      bool1 = true;
      this.hzD = bool1;
      if (paramParcel.readInt() != 1) {
        break label79;
      }
      bool1 = true;
      label40:
      this.hyI = bool1;
      this.hyJ = paramParcel.readString();
      if (paramParcel.readInt() != 1) {
        break label84;
      }
    }
    label79:
    label84:
    for (boolean bool1 = bool2;; bool1 = false)
    {
      this.hAW = bool1;
      AppMethodBeat.o(143375);
      return;
      bool1 = false;
      break;
      bool1 = false;
      break label40;
    }
  }
  
  public void writeToParcel(Parcel paramParcel, int paramInt)
  {
    int i = 1;
    AppMethodBeat.i(143376);
    paramParcel.writeLong(this.hyK);
    byte b;
    if (this.hzD)
    {
      b = 1;
      paramParcel.writeByte(b);
      if (!this.hyI) {
        break label78;
      }
      paramInt = 1;
      label39:
      paramParcel.writeInt(paramInt);
      paramParcel.writeString(this.hyJ);
      if (!this.hAW) {
        break label83;
      }
    }
    label78:
    label83:
    for (paramInt = i;; paramInt = 0)
    {
      paramParcel.writeInt(paramInt);
      AppMethodBeat.o(143376);
      return;
      b = 0;
      break;
      paramInt = 0;
      break label39;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes8.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.jsapi.appdownload.JsApiResumeDownloadTaskForNative.ResumeDownloadTask
 * JD-Core Version:    0.7.0.1
 */