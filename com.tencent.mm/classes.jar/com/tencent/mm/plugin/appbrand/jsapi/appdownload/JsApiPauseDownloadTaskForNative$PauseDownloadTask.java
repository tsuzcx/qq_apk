package com.tencent.mm.plugin.appbrand.jsapi.appdownload;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.appbrand.ipc.MainProcessTask;
import com.tencent.mm.plugin.appbrand.jsapi.m;
import com.tencent.mm.plugin.appbrand.r;
import com.tencent.mm.plugin.downloader.g.a;
import com.tencent.mm.plugin.downloader.model.d;
import com.tencent.mm.plugin.downloader.model.f;
import com.tencent.mm.sdk.platformtools.ab;
import com.tencent.mm.sdk.platformtools.bo;
import org.json.JSONObject;

class JsApiPauseDownloadTaskForNative$PauseDownloadTask
  extends MainProcessTask
{
  public static final Parcelable.Creator<PauseDownloadTask> CREATOR;
  private int bxX;
  private r gPA;
  private m hyA;
  private boolean hyI;
  private String hyJ;
  private long hyK;
  
  static
  {
    AppMethodBeat.i(143355);
    CREATOR = new JsApiPauseDownloadTaskForNative.PauseDownloadTask.1();
    AppMethodBeat.o(143355);
  }
  
  public JsApiPauseDownloadTaskForNative$PauseDownloadTask(Parcel paramParcel)
  {
    AppMethodBeat.i(143350);
    f(paramParcel);
    AppMethodBeat.o(143350);
  }
  
  public JsApiPauseDownloadTaskForNative$PauseDownloadTask(m paramm, r paramr, int paramInt, JSONObject paramJSONObject)
  {
    AppMethodBeat.i(143349);
    this.hyA = paramm;
    this.gPA = paramr;
    this.bxX = paramInt;
    this.hyK = paramJSONObject.optLong("downloadId");
    this.hyI = true;
    AppMethodBeat.o(143349);
  }
  
  public final void ata()
  {
    boolean bool = true;
    AppMethodBeat.i(143351);
    ab.i("MicroMsg.JsApiPauseDownloadTaskForNative", "doPauseDownloadTask, downloadId = %d", new Object[] { Long.valueOf(this.hyK) });
    if (this.hyK <= 0L) {}
    a locala;
    for (this.hyJ = "downloadId invalid";; this.hyJ = "downloadId invalid")
    {
      aBp();
      AppMethodBeat.o(143351);
      return;
      locala = d.iJ(this.hyK);
      if (locala != null) {
        break;
      }
    }
    if (locala.field_downloadInWifi)
    {
      locala.field_downloadInWifi = false;
      d.e(locala);
    }
    if (!f.bjl().iB(this.hyK)) {}
    for (;;)
    {
      this.hyI = bool;
      break;
      bool = false;
    }
  }
  
  public final void atb()
  {
    AppMethodBeat.i(143352);
    if (this.hyI)
    {
      if (bo.isNullOrNil(this.hyJ)) {}
      for (String str = "fail";; str = String.format("fail:%s", new Object[] { this.hyJ }))
      {
        this.gPA.h(this.bxX, this.hyA.j(str, null));
        AppMethodBeat.o(143352);
        return;
      }
    }
    this.gPA.h(this.bxX, this.hyA.j("ok", null));
    AppMethodBeat.o(143352);
  }
  
  public final void f(Parcel paramParcel)
  {
    boolean bool = true;
    AppMethodBeat.i(143353);
    this.hyK = paramParcel.readLong();
    if (paramParcel.readInt() == 1) {}
    for (;;)
    {
      this.hyI = bool;
      this.hyJ = paramParcel.readString();
      AppMethodBeat.o(143353);
      return;
      bool = false;
    }
  }
  
  public void writeToParcel(Parcel paramParcel, int paramInt)
  {
    AppMethodBeat.i(143354);
    paramParcel.writeLong(this.hyK);
    if (this.hyI) {}
    for (paramInt = 1;; paramInt = 0)
    {
      paramParcel.writeInt(paramInt);
      paramParcel.writeString(this.hyJ);
      AppMethodBeat.o(143354);
      return;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.jsapi.appdownload.JsApiPauseDownloadTaskForNative.PauseDownloadTask
 * JD-Core Version:    0.7.0.1
 */