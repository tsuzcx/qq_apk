package com.tencent.mm.plugin.appbrand.jsapi;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.appbrand.ipc.MainProcessTask;
import com.tencent.mm.plugin.appbrand.r;
import com.tencent.mm.plugin.downloader.g.a;
import com.tencent.mm.plugin.downloader.model.d;
import com.tencent.mm.plugin.downloader.model.f;
import com.tencent.mm.sdk.platformtools.ab;
import com.tencent.mm.sdk.platformtools.bo;
import org.json.JSONObject;

class JsApiResumeDownloadTask$ResumeDownloadTask
  extends MainProcessTask
{
  public static final Parcelable.Creator<ResumeDownloadTask> CREATOR;
  private int bxX;
  private r gPA;
  private m hyA;
  private boolean hyI;
  private String hyJ;
  private long hyK;
  private boolean hzD;
  
  static
  {
    AppMethodBeat.i(73179);
    CREATOR = new JsApiResumeDownloadTask.ResumeDownloadTask.1();
    AppMethodBeat.o(73179);
  }
  
  public JsApiResumeDownloadTask$ResumeDownloadTask(Parcel paramParcel)
  {
    AppMethodBeat.i(73174);
    f(paramParcel);
    AppMethodBeat.o(73174);
  }
  
  public JsApiResumeDownloadTask$ResumeDownloadTask(m paramm, r paramr, int paramInt, JSONObject paramJSONObject)
  {
    AppMethodBeat.i(73173);
    this.hyA = paramm;
    this.gPA = paramr;
    this.bxX = paramInt;
    this.hyK = paramJSONObject.optLong("downloadId");
    this.hzD = paramJSONObject.optBoolean("downloadInWifi", false);
    this.hyI = true;
    AppMethodBeat.o(73173);
  }
  
  public final void ata()
  {
    boolean bool = true;
    AppMethodBeat.i(73175);
    ab.i("MicroMsg.JsApiResumeDownloadTask", "doQueryDownloadTask, downloadId = %d", new Object[] { Long.valueOf(this.hyK) });
    if (this.hyK <= 0L)
    {
      this.hyJ = "downloadId invalid";
      aBp();
      AppMethodBeat.o(73175);
      return;
    }
    a locala = d.iJ(this.hyK);
    if ((locala != null) && (locala.field_downloadInWifi != this.hzD))
    {
      locala.field_downloadInWifi = this.hzD;
      d.e(locala);
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
    AppMethodBeat.i(73176);
    if (this.hyI)
    {
      if (bo.isNullOrNil(this.hyJ)) {}
      for (String str = "fail";; str = String.format("fail:%s", new Object[] { this.hyJ }))
      {
        this.gPA.h(this.bxX, this.hyA.j(str, null));
        AppMethodBeat.o(73176);
        return;
      }
    }
    this.gPA.h(this.bxX, this.hyA.j("ok", null));
    AppMethodBeat.o(73176);
  }
  
  public final void f(Parcel paramParcel)
  {
    boolean bool2 = true;
    AppMethodBeat.i(73177);
    this.hyK = paramParcel.readLong();
    if (paramParcel.readByte() == 1)
    {
      bool1 = true;
      this.hzD = bool1;
      if (paramParcel.readInt() != 1) {
        break label64;
      }
    }
    label64:
    for (boolean bool1 = bool2;; bool1 = false)
    {
      this.hyI = bool1;
      this.hyJ = paramParcel.readString();
      AppMethodBeat.o(73177);
      return;
      bool1 = false;
      break;
    }
  }
  
  public void writeToParcel(Parcel paramParcel, int paramInt)
  {
    paramInt = 1;
    AppMethodBeat.i(73178);
    paramParcel.writeLong(this.hyK);
    byte b;
    if (this.hzD)
    {
      b = 1;
      paramParcel.writeByte(b);
      if (!this.hyI) {
        break label60;
      }
    }
    for (;;)
    {
      paramParcel.writeInt(paramInt);
      paramParcel.writeString(this.hyJ);
      AppMethodBeat.o(73178);
      return;
      b = 0;
      break;
      label60:
      paramInt = 0;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.jsapi.JsApiResumeDownloadTask.ResumeDownloadTask
 * JD-Core Version:    0.7.0.1
 */