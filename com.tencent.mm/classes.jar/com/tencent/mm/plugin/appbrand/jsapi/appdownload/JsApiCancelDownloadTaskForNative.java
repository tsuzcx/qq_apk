package com.tencent.mm.plugin.appbrand.jsapi.appdownload;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.appbrand.ipc.MainProcessTask;
import com.tencent.mm.plugin.appbrand.jsapi.m;
import com.tencent.mm.plugin.appbrand.q;
import com.tencent.mm.plugin.downloader.model.d;
import com.tencent.mm.plugin.downloader.model.f;
import com.tencent.mm.sdk.platformtools.ad;
import com.tencent.mm.vfs.i;
import org.json.JSONArray;
import org.json.JSONException;

public final class JsApiCancelDownloadTaskForNative
  extends com.tencent.mm.plugin.appbrand.jsapi.a<q>
{
  public static final int CTRL_INDEX = 657;
  public static final String NAME = "cancelDownloadTaskForNative";
  
  static class CancelDownloadTask
    extends MainProcessTask
  {
    public static Parcelable.Creator<CancelDownloadTask> CREATOR;
    private q jCl;
    private int kje;
    private JSONArray kvv;
    private com.tencent.mm.plugin.appbrand.jsapi.a kvw;
    
    static
    {
      AppMethodBeat.i(45787);
      CREATOR = new Parcelable.Creator() {};
      AppMethodBeat.o(45787);
    }
    
    private CancelDownloadTask(Parcel paramParcel)
    {
      AppMethodBeat.i(45784);
      e(paramParcel);
      AppMethodBeat.o(45784);
    }
    
    public CancelDownloadTask(JSONArray paramJSONArray, com.tencent.mm.plugin.appbrand.jsapi.a parama, q paramq, int paramInt)
    {
      AppMethodBeat.i(45783);
      bhN();
      this.kvv = paramJSONArray;
      this.kvw = parama;
      this.jCl = paramq;
      this.kje = paramInt;
      AppMethodBeat.o(45783);
    }
    
    public final void aOA()
    {
      AppMethodBeat.i(45781);
      if ((this.kvv != null) && (this.kvv.length() > 0))
      {
        int i = 0;
        if (i < this.kvv.length())
        {
          long l = this.kvv.optLong(i);
          com.tencent.mm.plugin.downloader.g.a locala = d.ua(l);
          if ((locala != null) && (locala.field_status == 3))
          {
            ad.i("MicroMsg.JsApiCancelDownloadTaskForNative", "canceldownloadtask, path: %s", new Object[] { locala.field_filePath });
            i.deleteFile(locala.field_filePath);
            d.aae(locala.field_downloadUrl);
          }
          for (;;)
          {
            i += 1;
            break;
            f.ccl().tR(l);
          }
        }
      }
      bhX();
      AppMethodBeat.o(45781);
    }
    
    public final void aOB()
    {
      AppMethodBeat.i(45782);
      bhO();
      this.jCl.h(this.kje, this.kvw.e("ok", null));
      AppMethodBeat.o(45782);
    }
    
    public final void e(Parcel paramParcel)
    {
      AppMethodBeat.i(45785);
      paramParcel = paramParcel.readString();
      if (paramParcel != null) {
        try
        {
          this.kvv = new JSONArray(paramParcel);
          AppMethodBeat.o(45785);
          return;
        }
        catch (JSONException paramParcel)
        {
          ad.e("MicroMsg.JsApiCancelDownloadTaskForNative", "parseFromParcel: " + paramParcel.getMessage());
        }
      }
      AppMethodBeat.o(45785);
    }
    
    public void writeToParcel(Parcel paramParcel, int paramInt)
    {
      AppMethodBeat.i(45786);
      if (this.kvv != null) {}
      for (String str = this.kvv.toString();; str = null)
      {
        paramParcel.writeString(str);
        AppMethodBeat.o(45786);
        return;
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.jsapi.appdownload.JsApiCancelDownloadTaskForNative
 * JD-Core Version:    0.7.0.1
 */