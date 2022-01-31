package com.tencent.mm.plugin.appbrand.jsapi.appdownload;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.appbrand.ipc.MainProcessTask;
import com.tencent.mm.plugin.appbrand.jsapi.m;
import com.tencent.mm.plugin.appbrand.r;
import com.tencent.mm.plugin.downloader.model.d;
import com.tencent.mm.plugin.downloader.model.f;
import com.tencent.mm.sdk.platformtools.ab;
import com.tencent.mm.vfs.e;
import org.json.JSONArray;
import org.json.JSONException;

class JsApiCancelDownloadTaskForNative$CancelDownloadTask
  extends MainProcessTask
{
  public static Parcelable.Creator<CancelDownloadTask> CREATOR;
  private JSONArray hAZ;
  private com.tencent.mm.plugin.appbrand.jsapi.a hBa;
  private int hry;
  private r hxb;
  
  static
  {
    AppMethodBeat.i(143297);
    CREATOR = new Parcelable.Creator() {};
    AppMethodBeat.o(143297);
  }
  
  private JsApiCancelDownloadTaskForNative$CancelDownloadTask(Parcel paramParcel)
  {
    AppMethodBeat.i(143294);
    f(paramParcel);
    AppMethodBeat.o(143294);
  }
  
  public JsApiCancelDownloadTaskForNative$CancelDownloadTask(JSONArray paramJSONArray, com.tencent.mm.plugin.appbrand.jsapi.a parama, r paramr, int paramInt)
  {
    AppMethodBeat.i(143293);
    aBj();
    this.hAZ = paramJSONArray;
    this.hBa = parama;
    this.hxb = paramr;
    this.hry = paramInt;
    AppMethodBeat.o(143293);
  }
  
  public final void ata()
  {
    AppMethodBeat.i(143291);
    if ((this.hAZ != null) && (this.hAZ.length() > 0))
    {
      int i = 0;
      if (i < this.hAZ.length())
      {
        long l = this.hAZ.optLong(i);
        com.tencent.mm.plugin.downloader.g.a locala = d.iJ(l);
        if ((locala != null) && (locala.field_status == 3))
        {
          ab.i("MicroMsg.JsApiCancelDownloadTaskForNative", "canceldownloadtask, path: %s", new Object[] { locala.field_filePath });
          e.deleteFile(locala.field_filePath);
          d.JE(locala.field_downloadUrl);
        }
        for (;;)
        {
          i += 1;
          break;
          f.bjl().iz(l);
        }
      }
    }
    aBp();
    AppMethodBeat.o(143291);
  }
  
  public final void atb()
  {
    AppMethodBeat.i(143292);
    aBk();
    this.hxb.h(this.hry, this.hBa.j("ok", null));
    AppMethodBeat.o(143292);
  }
  
  public final void f(Parcel paramParcel)
  {
    AppMethodBeat.i(143295);
    paramParcel = paramParcel.readString();
    if (paramParcel != null) {
      try
      {
        this.hAZ = new JSONArray(paramParcel);
        AppMethodBeat.o(143295);
        return;
      }
      catch (JSONException paramParcel)
      {
        ab.e("MicroMsg.JsApiCancelDownloadTaskForNative", "parseFromParcel: " + paramParcel.getMessage());
      }
    }
    AppMethodBeat.o(143295);
  }
  
  public void writeToParcel(Parcel paramParcel, int paramInt)
  {
    AppMethodBeat.i(143296);
    if (this.hAZ != null) {}
    for (String str = this.hAZ.toString();; str = null)
    {
      paramParcel.writeString(str);
      AppMethodBeat.o(143296);
      return;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.jsapi.appdownload.JsApiCancelDownloadTaskForNative.CancelDownloadTask
 * JD-Core Version:    0.7.0.1
 */