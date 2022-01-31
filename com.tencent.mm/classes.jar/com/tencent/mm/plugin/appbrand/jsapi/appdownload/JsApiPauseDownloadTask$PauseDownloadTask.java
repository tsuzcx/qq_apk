package com.tencent.mm.plugin.appbrand.jsapi.appdownload;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.tencent.mm.plugin.appbrand.ipc.MainProcessTask;
import com.tencent.mm.plugin.appbrand.jsapi.i;
import com.tencent.mm.plugin.appbrand.o;
import com.tencent.mm.plugin.downloader.f.a;
import com.tencent.mm.plugin.downloader.model.c;
import com.tencent.mm.plugin.downloader.model.d;
import com.tencent.mm.sdk.platformtools.bk;
import com.tencent.mm.sdk.platformtools.y;
import org.json.JSONObject;

class JsApiPauseDownloadTask$PauseDownloadTask
  extends MainProcessTask
{
  public static final Parcelable.Creator<PauseDownloadTask> CREATOR = new JsApiPauseDownloadTask.PauseDownloadTask.1();
  private int bhx;
  private o fyo;
  private i gho;
  private long ghp;
  private boolean ghr;
  private String ghs;
  
  public JsApiPauseDownloadTask$PauseDownloadTask(Parcel paramParcel)
  {
    e(paramParcel);
  }
  
  public JsApiPauseDownloadTask$PauseDownloadTask(i parami, o paramo, int paramInt, JSONObject paramJSONObject)
  {
    this.gho = parami;
    this.fyo = paramo;
    this.bhx = paramInt;
    this.ghp = paramJSONObject.optLong("downloadId");
    this.ghr = true;
  }
  
  public final void Zu()
  {
    boolean bool = true;
    y.i("MicroMsg.JsApiPauseDownloadTask", "doPauseDownloadTask, downloadId = %d", new Object[] { Long.valueOf(this.ghp) });
    if (this.ghp <= 0L) {}
    a locala;
    for (this.ghs = "downloadId invalid";; this.ghs = "downloadId invalid")
    {
      ahI();
      return;
      locala = c.dk(this.ghp);
      if (locala != null) {
        break;
      }
    }
    if (locala.field_downloadInWifi)
    {
      locala.field_downloadInWifi = false;
      c.d(locala);
    }
    if (!d.aFP().de(this.ghp)) {}
    for (;;)
    {
      this.ghr = bool;
      break;
      bool = false;
    }
  }
  
  public final void Zv()
  {
    if (this.ghr)
    {
      if (bk.bl(this.ghs)) {}
      for (String str = "fail";; str = String.format("fail:%s", new Object[] { this.ghs }))
      {
        this.fyo.C(this.bhx, this.gho.h(str, null));
        return;
      }
    }
    this.fyo.C(this.bhx, this.gho.h("ok", null));
  }
  
  public final void e(Parcel paramParcel)
  {
    boolean bool = true;
    this.ghp = paramParcel.readLong();
    if (paramParcel.readInt() == 1) {}
    for (;;)
    {
      this.ghr = bool;
      this.ghs = paramParcel.readString();
      return;
      bool = false;
    }
  }
  
  public void writeToParcel(Parcel paramParcel, int paramInt)
  {
    paramParcel.writeLong(this.ghp);
    if (this.ghr) {}
    for (paramInt = 1;; paramInt = 0)
    {
      paramParcel.writeInt(paramInt);
      paramParcel.writeString(this.ghs);
      return;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.jsapi.appdownload.JsApiPauseDownloadTask.PauseDownloadTask
 * JD-Core Version:    0.7.0.1
 */