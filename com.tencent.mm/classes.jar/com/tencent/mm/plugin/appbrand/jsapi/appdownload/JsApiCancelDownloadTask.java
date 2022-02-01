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

public final class JsApiCancelDownloadTask
  extends com.tencent.mm.plugin.appbrand.jsapi.a<q>
{
  public static final int CTRL_INDEX = 475;
  public static final String NAME = "cancelDownloadTask";
  
  static class CancelDownloadTask
    extends MainProcessTask
  {
    public static Parcelable.Creator<CancelDownloadTask> CREATOR;
    private q iIL;
    private JSONArray jAD;
    private com.tencent.mm.plugin.appbrand.jsapi.a jAE;
    private int joH;
    
    static
    {
      AppMethodBeat.i(45778);
      CREATOR = new Parcelable.Creator() {};
      AppMethodBeat.o(45778);
    }
    
    private CancelDownloadTask(Parcel paramParcel)
    {
      AppMethodBeat.i(45775);
      e(paramParcel);
      AppMethodBeat.o(45775);
    }
    
    public CancelDownloadTask(JSONArray paramJSONArray, com.tencent.mm.plugin.appbrand.jsapi.a parama, q paramq, int paramInt)
    {
      AppMethodBeat.i(45774);
      aXm();
      this.jAD = paramJSONArray;
      this.jAE = parama;
      this.iIL = paramq;
      this.joH = paramInt;
      AppMethodBeat.o(45774);
    }
    
    public final void aEA()
    {
      AppMethodBeat.i(45773);
      aXn();
      this.iIL.h(this.joH, this.jAE.e("ok", null));
      AppMethodBeat.o(45773);
    }
    
    public final void aEz()
    {
      AppMethodBeat.i(45772);
      if ((this.jAD != null) && (this.jAD.length() > 0))
      {
        int i = 0;
        if (i < this.jAD.length())
        {
          long l = this.jAD.optLong(i);
          com.tencent.mm.plugin.downloader.g.a locala = d.oq(l);
          if ((locala != null) && (locala.field_status == 3))
          {
            ad.i("MicroMsg.JsApiCancelDownloadTask", "canceldownloadtask, path: %s", new Object[] { locala.field_filePath });
            i.deleteFile(locala.field_filePath);
            d.Sl(locala.field_downloadUrl);
          }
          for (;;)
          {
            i += 1;
            break;
            f.bQt().og(l);
          }
        }
      }
      aXw();
      AppMethodBeat.o(45772);
    }
    
    public final void e(Parcel paramParcel)
    {
      AppMethodBeat.i(45776);
      paramParcel = paramParcel.readString();
      if (paramParcel != null) {
        try
        {
          this.jAD = new JSONArray(paramParcel);
          AppMethodBeat.o(45776);
          return;
        }
        catch (JSONException paramParcel)
        {
          ad.e("MicroMsg.JsApiCancelDownloadTask", "parseFromParcel: " + paramParcel.getMessage());
        }
      }
      AppMethodBeat.o(45776);
    }
    
    public void writeToParcel(Parcel paramParcel, int paramInt)
    {
      AppMethodBeat.i(45777);
      if (this.jAD != null) {}
      for (String str = this.jAD.toString();; str = null)
      {
        paramParcel.writeString(str);
        AppMethodBeat.o(45777);
        return;
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.jsapi.appdownload.JsApiCancelDownloadTask
 * JD-Core Version:    0.7.0.1
 */