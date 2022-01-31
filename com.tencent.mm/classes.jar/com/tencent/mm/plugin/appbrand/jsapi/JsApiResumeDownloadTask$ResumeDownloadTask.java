package com.tencent.mm.plugin.appbrand.jsapi;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.tencent.mm.plugin.appbrand.ipc.MainProcessTask;
import com.tencent.mm.plugin.appbrand.o;
import com.tencent.mm.plugin.downloader.f.a;
import com.tencent.mm.plugin.downloader.model.c;
import com.tencent.mm.plugin.downloader.model.d;
import com.tencent.mm.sdk.platformtools.bk;
import com.tencent.mm.sdk.platformtools.y;
import org.json.JSONObject;

class JsApiResumeDownloadTask$ResumeDownloadTask
  extends MainProcessTask
{
  public static final Parcelable.Creator<ResumeDownloadTask> CREATOR = new JsApiResumeDownloadTask.ResumeDownloadTask.1();
  private int bhx;
  private o fyo;
  private i gho;
  private long ghp;
  private boolean ghq;
  private boolean ghr;
  private String ghs;
  
  public JsApiResumeDownloadTask$ResumeDownloadTask(Parcel paramParcel)
  {
    e(paramParcel);
  }
  
  public JsApiResumeDownloadTask$ResumeDownloadTask(i parami, o paramo, int paramInt, JSONObject paramJSONObject)
  {
    this.gho = parami;
    this.fyo = paramo;
    this.bhx = paramInt;
    this.ghp = paramJSONObject.optLong("downloadId");
    this.ghq = paramJSONObject.optBoolean("downloadInWifi", false);
    this.ghr = true;
  }
  
  public final void Zu()
  {
    boolean bool = true;
    y.i("MicroMsg.JsApiResumeDownloadTask", "doQueryDownloadTask, downloadId = %d", new Object[] { Long.valueOf(this.ghp) });
    if (this.ghp <= 0L)
    {
      this.ghs = "downloadId invalid";
      ahI();
      return;
    }
    a locala = c.dk(this.ghp);
    if ((locala != null) && (locala.field_downloadInWifi != this.ghq))
    {
      locala.field_downloadInWifi = this.ghq;
      c.d(locala);
    }
    if (!d.aFP().df(this.ghp)) {}
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
    boolean bool2 = true;
    this.ghp = paramParcel.readLong();
    if (paramParcel.readByte() == 1)
    {
      bool1 = true;
      this.ghq = bool1;
      if (paramParcel.readInt() != 1) {
        break label54;
      }
    }
    label54:
    for (boolean bool1 = bool2;; bool1 = false)
    {
      this.ghr = bool1;
      this.ghs = paramParcel.readString();
      return;
      bool1 = false;
      break;
    }
  }
  
  public void writeToParcel(Parcel paramParcel, int paramInt)
  {
    paramInt = 1;
    paramParcel.writeLong(this.ghp);
    byte b;
    if (this.ghq)
    {
      b = 1;
      paramParcel.writeByte(b);
      if (!this.ghr) {
        break label50;
      }
    }
    for (;;)
    {
      paramParcel.writeInt(paramInt);
      paramParcel.writeString(this.ghs);
      return;
      b = 0;
      break;
      label50:
      paramInt = 0;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.jsapi.JsApiResumeDownloadTask.ResumeDownloadTask
 * JD-Core Version:    0.7.0.1
 */