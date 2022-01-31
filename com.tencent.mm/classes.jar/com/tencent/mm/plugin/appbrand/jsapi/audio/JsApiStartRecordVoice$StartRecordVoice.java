package com.tencent.mm.plugin.appbrand.jsapi.audio;

import android.content.Context;
import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.tencent.mm.modelvoice.u;
import com.tencent.mm.plugin.appbrand.appstorage.h;
import com.tencent.mm.plugin.appbrand.ipc.MainProcessTask;
import com.tencent.mm.plugin.appbrand.jsapi.i;
import com.tencent.mm.plugin.appbrand.o;
import com.tencent.mm.plugin.appbrand.v.c;
import com.tencent.mm.sdk.platformtools.ai;
import com.tencent.mm.sdk.platformtools.y;
import java.io.File;
import java.util.HashMap;
import java.util.Map;

class JsApiStartRecordVoice$StartRecordVoice
  extends MainProcessTask
{
  public static final Parcelable.Creator<StartRecordVoice> CREATOR = new JsApiStartRecordVoice.StartRecordVoice.2();
  private String appId;
  private int duration;
  private String filePath;
  private o gfd;
  private int gfg;
  private JsApiStartRecordVoice gjw;
  private boolean gjx = false;
  private int result;
  
  JsApiStartRecordVoice$StartRecordVoice(Parcel paramParcel)
  {
    e(paramParcel);
  }
  
  JsApiStartRecordVoice$StartRecordVoice(JsApiStartRecordVoice paramJsApiStartRecordVoice, o paramo, int paramInt1, int paramInt2)
  {
    this.gjw = paramJsApiStartRecordVoice;
    this.gfd = paramo;
    this.duration = paramInt1;
    this.gfg = paramInt2;
    this.appId = paramo.mAppId;
    paramJsApiStartRecordVoice = u.oI(this.appId);
    com.tencent.mm.plugin.appbrand.u.k localk = new com.tencent.mm.plugin.appbrand.u.k();
    if (paramo.Zl().a(localk) == h.fGU)
    {
      this.filePath = new File((String)localk.value, paramJsApiStartRecordVoice).getAbsolutePath();
      return;
    }
    this.filePath = new File(paramo.getContext().getCacheDir(), paramJsApiStartRecordVoice).getAbsolutePath();
  }
  
  public final void Zu()
  {
    c.DS().O(new JsApiStartRecordVoice.StartRecordVoice.1(this));
  }
  
  public final void Zv()
  {
    if (this.result == -1)
    {
      y.e("MicroMsg.JsApiStartRecordVoice", "fail:record_error");
      this.gfd.C(this.gfg, this.gjw.h("fail:record_error", null));
      return;
    }
    HashMap localHashMap;
    if (this.gjx)
    {
      localHashMap = new HashMap(1);
      com.tencent.mm.plugin.appbrand.u.k localk = new com.tencent.mm.plugin.appbrand.u.k();
      if (this.gfd.Zl().a(new File(this.filePath), "silk", true, localk) == h.fGU)
      {
        localHashMap.put("tempFilePath", localk.value);
        this.gfd.C(this.gfg, this.gjw.h("ok", localHashMap));
      }
    }
    for (;;)
    {
      y.i("MicroMsg.JsApiStartRecordVoice", "runInClientProcess, appId = %s, startRecordOk = %b", new Object[] { this.appId, Boolean.valueOf(this.gjx) });
      JsApiStartRecordVoice.a(this.gjw, false);
      return;
      y.e("MicroMsg.JsApiStartRecordVoice", "AppBrandLocalMediaObject obj is null");
      localHashMap.put("tempFilePath", "");
      this.gfd.C(this.gfg, this.gjw.h("fail", null));
    }
  }
  
  public int describeContents()
  {
    return 0;
  }
  
  public final void e(Parcel paramParcel)
  {
    this.gfg = paramParcel.readInt();
    this.appId = paramParcel.readString();
    this.filePath = paramParcel.readString();
    if (paramParcel.readByte() != 0) {}
    for (boolean bool = true;; bool = false)
    {
      this.gjx = bool;
      this.duration = paramParcel.readInt();
      this.result = paramParcel.readInt();
      return;
    }
  }
  
  public void writeToParcel(Parcel paramParcel, int paramInt)
  {
    paramParcel.writeInt(this.gfg);
    paramParcel.writeString(this.appId);
    paramParcel.writeString(this.filePath);
    if (this.gjx) {}
    for (byte b = 1;; b = 0)
    {
      paramParcel.writeByte(b);
      paramParcel.writeInt(this.duration);
      paramParcel.writeInt(this.result);
      return;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.jsapi.audio.JsApiStartRecordVoice.StartRecordVoice
 * JD-Core Version:    0.7.0.1
 */