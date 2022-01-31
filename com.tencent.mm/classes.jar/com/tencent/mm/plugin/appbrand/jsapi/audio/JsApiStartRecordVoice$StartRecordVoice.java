package com.tencent.mm.plugin.appbrand.jsapi.audio;

import android.content.Context;
import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.modelvoice.w;
import com.tencent.mm.plugin.appbrand.appstorage.o;
import com.tencent.mm.plugin.appbrand.ipc.MainProcessTask;
import com.tencent.mm.plugin.appbrand.jsapi.m;
import com.tencent.mm.plugin.appbrand.r;
import com.tencent.mm.plugin.appbrand.t.e;
import com.tencent.mm.sdk.platformtools.ab;
import com.tencent.mm.sdk.platformtools.al;
import java.io.File;
import java.util.HashMap;
import java.util.Map;

class JsApiStartRecordVoice$StartRecordVoice
  extends MainProcessTask
{
  public static final Parcelable.Creator<StartRecordVoice> CREATOR;
  private String appId;
  private int duration;
  private String filePath;
  private JsApiStartRecordVoice hCP;
  private boolean hCQ;
  private int hry;
  private r hxb;
  private int result;
  
  static
  {
    AppMethodBeat.i(130799);
    CREATOR = new JsApiStartRecordVoice.StartRecordVoice.2();
    AppMethodBeat.o(130799);
  }
  
  JsApiStartRecordVoice$StartRecordVoice(Parcel paramParcel)
  {
    AppMethodBeat.i(130792);
    this.hCQ = false;
    f(paramParcel);
    AppMethodBeat.o(130792);
  }
  
  JsApiStartRecordVoice$StartRecordVoice(JsApiStartRecordVoice paramJsApiStartRecordVoice, r paramr, int paramInt1, int paramInt2)
  {
    AppMethodBeat.i(130791);
    this.hCQ = false;
    this.hCP = paramJsApiStartRecordVoice;
    this.hxb = paramr;
    this.duration = paramInt1;
    this.hry = paramInt2;
    this.appId = paramr.getAppId();
    paramJsApiStartRecordVoice = w.vV(this.appId);
    com.tencent.mm.plugin.appbrand.s.j localj = new com.tencent.mm.plugin.appbrand.s.j();
    if (paramr.wX().a(localj) == com.tencent.mm.plugin.appbrand.appstorage.j.gZA)
    {
      this.filePath = new File((String)localj.value, paramJsApiStartRecordVoice).getAbsolutePath();
      AppMethodBeat.o(130791);
      return;
    }
    this.filePath = new File(paramr.getContext().getCacheDir(), paramJsApiStartRecordVoice).getAbsolutePath();
    AppMethodBeat.o(130791);
  }
  
  public final void ata()
  {
    AppMethodBeat.i(130793);
    e.aNS().ac(new JsApiStartRecordVoice.StartRecordVoice.1(this));
    AppMethodBeat.o(130793);
  }
  
  public final void atb()
  {
    AppMethodBeat.i(130794);
    if (this.result == -1)
    {
      ab.e("MicroMsg.JsApiStartRecordVoice", "fail:record_error");
      this.hxb.h(this.hry, this.hCP.j("fail:record_error", null));
      AppMethodBeat.o(130794);
      return;
    }
    HashMap localHashMap;
    if (this.hCQ)
    {
      localHashMap = new HashMap(1);
      com.tencent.mm.plugin.appbrand.s.j localj = new com.tencent.mm.plugin.appbrand.s.j();
      if (this.hxb.wX().a(new File(this.filePath), "silk", true, localj) == com.tencent.mm.plugin.appbrand.appstorage.j.gZA)
      {
        localHashMap.put("tempFilePath", localj.value);
        this.hxb.h(this.hry, this.hCP.j("ok", localHashMap));
      }
    }
    for (;;)
    {
      ab.i("MicroMsg.JsApiStartRecordVoice", "runInClientProcess, appId = %s, startRecordOk = %b", new Object[] { this.appId, Boolean.valueOf(this.hCQ) });
      JsApiStartRecordVoice.a(this.hCP, false);
      AppMethodBeat.o(130794);
      return;
      ab.e("MicroMsg.JsApiStartRecordVoice", "AppBrandLocalMediaObject obj is null");
      localHashMap.put("tempFilePath", "");
      this.hxb.h(this.hry, this.hCP.j("fail", null));
    }
  }
  
  public int describeContents()
  {
    return 0;
  }
  
  public final void f(Parcel paramParcel)
  {
    AppMethodBeat.i(130795);
    this.hry = paramParcel.readInt();
    this.appId = paramParcel.readString();
    this.filePath = paramParcel.readString();
    if (paramParcel.readByte() != 0) {}
    for (boolean bool = true;; bool = false)
    {
      this.hCQ = bool;
      this.duration = paramParcel.readInt();
      this.result = paramParcel.readInt();
      AppMethodBeat.o(130795);
      return;
    }
  }
  
  public void writeToParcel(Parcel paramParcel, int paramInt)
  {
    AppMethodBeat.i(130796);
    paramParcel.writeInt(this.hry);
    paramParcel.writeString(this.appId);
    paramParcel.writeString(this.filePath);
    if (this.hCQ) {}
    for (byte b = 1;; b = 0)
    {
      paramParcel.writeByte(b);
      paramParcel.writeInt(this.duration);
      paramParcel.writeInt(this.result);
      AppMethodBeat.o(130796);
      return;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.jsapi.audio.JsApiStartRecordVoice.StartRecordVoice
 * JD-Core Version:    0.7.0.1
 */