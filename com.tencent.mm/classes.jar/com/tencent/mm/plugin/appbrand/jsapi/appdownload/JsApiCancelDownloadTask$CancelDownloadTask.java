package com.tencent.mm.plugin.appbrand.jsapi.appdownload;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.tencent.mm.plugin.appbrand.ipc.MainProcessTask;
import com.tencent.mm.plugin.appbrand.jsapi.i;
import com.tencent.mm.plugin.appbrand.o;
import com.tencent.mm.plugin.downloader.model.c;
import com.tencent.mm.plugin.downloader.model.d;
import com.tencent.mm.sdk.platformtools.y;
import com.tencent.mm.vfs.e;
import org.json.JSONArray;
import org.json.JSONException;

class JsApiCancelDownloadTask$CancelDownloadTask
  extends MainProcessTask
{
  public static Parcelable.Creator<CancelDownloadTask> CREATOR = new JsApiCancelDownloadTask.CancelDownloadTask.1();
  private o gfd;
  private int gfg;
  private JSONArray ghX;
  private com.tencent.mm.plugin.appbrand.jsapi.a ghY;
  
  private JsApiCancelDownloadTask$CancelDownloadTask(Parcel paramParcel)
  {
    e(paramParcel);
  }
  
  public JsApiCancelDownloadTask$CancelDownloadTask(JSONArray paramJSONArray, com.tencent.mm.plugin.appbrand.jsapi.a parama, o paramo, int paramInt)
  {
    ahC();
    this.ghX = paramJSONArray;
    this.ghY = parama;
    this.gfd = paramo;
    this.gfg = paramInt;
  }
  
  public final void Zu()
  {
    if ((this.ghX != null) && (this.ghX.length() > 0))
    {
      int i = 0;
      if (i < this.ghX.length())
      {
        long l = this.ghX.optLong(i);
        com.tencent.mm.plugin.downloader.f.a locala = c.dk(l);
        if ((locala != null) && (locala.field_status == 3))
        {
          y.i("MicroMsg.JsApiCancelDownloadTask", "canceldownloadtask, path: %s", new Object[] { locala.field_filePath });
          e.deleteFile(locala.field_filePath);
          c.zI(locala.field_downloadUrl);
        }
        for (;;)
        {
          i += 1;
          break;
          d.aFP().dc(l);
        }
      }
    }
    ahI();
  }
  
  public final void Zv()
  {
    ahD();
    this.gfd.C(this.gfg, this.ghY.h("ok", null));
  }
  
  public final void e(Parcel paramParcel)
  {
    paramParcel = paramParcel.readString();
    if (paramParcel != null) {}
    try
    {
      this.ghX = new JSONArray(paramParcel);
      return;
    }
    catch (JSONException paramParcel)
    {
      y.e("MicroMsg.JsApiCancelDownloadTask", "parseFromParcel: " + paramParcel.getMessage());
    }
  }
  
  public void writeToParcel(Parcel paramParcel, int paramInt)
  {
    if (this.ghX != null) {}
    for (String str = this.ghX.toString();; str = null)
    {
      paramParcel.writeString(str);
      return;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.jsapi.appdownload.JsApiCancelDownloadTask.CancelDownloadTask
 * JD-Core Version:    0.7.0.1
 */