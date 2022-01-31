package com.tencent.mm.plugin.appbrand.jsapi.appdownload;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.tencent.mm.a.e;
import com.tencent.mm.plugin.appbrand.ipc.MainProcessTask;
import com.tencent.mm.plugin.appbrand.jsapi.i;
import com.tencent.mm.sdk.platformtools.bk;
import com.tencent.mm.sdk.platformtools.y;
import org.json.JSONObject;

class JsApiInstallDownloadTask$InstallDownloadTask
  extends MainProcessTask
{
  public static final Parcelable.Creator<InstallDownloadTask> CREATOR = new JsApiInstallDownloadTask.InstallDownloadTask.1();
  private int bhx;
  private com.tencent.mm.plugin.appbrand.jsapi.c gfZ;
  private i gho;
  private long ghp;
  private boolean ghr;
  private String ghs;
  private String mAppId;
  
  public JsApiInstallDownloadTask$InstallDownloadTask(Parcel paramParcel)
  {
    e(paramParcel);
  }
  
  public JsApiInstallDownloadTask$InstallDownloadTask(i parami, com.tencent.mm.plugin.appbrand.jsapi.c paramc, int paramInt, JSONObject paramJSONObject)
  {
    this.gho = parami;
    this.gfZ = paramc;
    this.bhx = paramInt;
    this.ghp = paramJSONObject.optLong("downloadId");
    this.mAppId = paramJSONObject.optString("appId");
    this.ghr = true;
  }
  
  public final void Zu()
  {
    boolean bool2 = true;
    boolean bool1 = true;
    y.i("MicroMsg.JsApiInstallDownloadTask", "doInstallDownloadTask, downloadId = %d", new Object[] { Long.valueOf(this.ghp) });
    com.tencent.mm.plugin.downloader.f.a locala;
    if (!bk.bl(this.mAppId))
    {
      locala = com.tencent.mm.plugin.downloader.model.c.zH(this.mAppId);
      if ((locala != null) && (locala.field_status == 3) && (e.bK(locala.field_filePath)))
      {
        if (com.tencent.mm.plugin.downloader.h.a.m(locala.field_downloadId, false)) {
          break label87;
        }
        this.ghr = bool1;
      }
    }
    label87:
    do
    {
      ahI();
      return;
      bool1 = false;
      break;
      locala = com.tencent.mm.plugin.downloader.model.c.dk(this.ghp);
    } while ((locala == null) || (locala.field_status != 3) || (!e.bK(locala.field_filePath)));
    if (!com.tencent.mm.plugin.downloader.h.a.m(locala.field_downloadId, false)) {}
    for (bool1 = bool2;; bool1 = false)
    {
      this.ghr = bool1;
      break;
    }
  }
  
  public final void Zv()
  {
    if (this.ghr)
    {
      if (bk.bl(this.ghs)) {}
      for (String str = "fail";; str = String.format("fail:%s", new Object[] { this.ghs }))
      {
        this.gfZ.C(this.bhx, this.gho.h(str, null));
        return;
      }
    }
    this.gfZ.C(this.bhx, this.gho.h("ok", null));
  }
  
  public final void e(Parcel paramParcel)
  {
    boolean bool = true;
    this.ghp = paramParcel.readLong();
    this.mAppId = paramParcel.readString();
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
    paramParcel.writeString(this.mAppId);
    if (this.ghr) {}
    for (paramInt = 1;; paramInt = 0)
    {
      paramParcel.writeInt(paramInt);
      paramParcel.writeString(this.ghs);
      return;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.jsapi.appdownload.JsApiInstallDownloadTask.InstallDownloadTask
 * JD-Core Version:    0.7.0.1
 */