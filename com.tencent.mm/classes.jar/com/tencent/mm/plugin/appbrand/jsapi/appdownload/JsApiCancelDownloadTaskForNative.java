package com.tencent.mm.plugin.appbrand.jsapi.appdownload;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.appbrand.ipc.MainProcessTask;
import com.tencent.mm.plugin.appbrand.jsapi.c;
import com.tencent.mm.plugin.appbrand.jsapi.o;
import com.tencent.mm.plugin.appbrand.v;
import com.tencent.mm.plugin.downloader.g.a;
import com.tencent.mm.plugin.downloader.model.d;
import com.tencent.mm.plugin.downloader.model.f;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.vfs.u;
import org.json.JSONArray;
import org.json.JSONException;

public final class JsApiCancelDownloadTaskForNative
  extends c<v>
{
  public static final int CTRL_INDEX = 657;
  public static final String NAME = "cancelDownloadTaskForNative";
  
  static class CancelDownloadTask
    extends MainProcessTask
  {
    public static Parcelable.Creator<CancelDownloadTask> CREATOR;
    private v nAz;
    private int okO;
    private JSONArray oyF;
    private c oyG;
    
    static
    {
      AppMethodBeat.i(45787);
      CREATOR = new Parcelable.Creator() {};
      AppMethodBeat.o(45787);
    }
    
    private CancelDownloadTask(Parcel paramParcel)
    {
      AppMethodBeat.i(45784);
      f(paramParcel);
      AppMethodBeat.o(45784);
    }
    
    public CancelDownloadTask(JSONArray paramJSONArray, c paramc, v paramv, int paramInt)
    {
      AppMethodBeat.i(45783);
      this.oyF = paramJSONArray;
      this.oyG = paramc;
      this.nAz = paramv;
      this.okO = paramInt;
      AppMethodBeat.o(45783);
    }
    
    public final void RW()
    {
      AppMethodBeat.i(45781);
      if ((this.oyF != null) && (this.oyF.length() > 0))
      {
        int i = 0;
        if (i < this.oyF.length())
        {
          long l = this.oyF.optLong(i);
          a locala = d.IF(l);
          if ((locala != null) && (locala.field_status == 3))
          {
            Log.i("MicroMsg.JsApiCancelDownloadTaskForNative", "canceldownloadtask, path: %s", new Object[] { locala.field_filePath });
            u.deleteFile(locala.field_filePath);
            d.asV(locala.field_downloadUrl);
          }
          for (;;)
          {
            i += 1;
            break;
            f.cPZ().Iw(l);
          }
        }
      }
      bPt();
      AppMethodBeat.o(45781);
    }
    
    public final void bsK()
    {
      AppMethodBeat.i(45782);
      bPk();
      this.nAz.j(this.okO, this.oyG.h("ok", null));
      AppMethodBeat.o(45782);
    }
    
    public final void f(Parcel paramParcel)
    {
      AppMethodBeat.i(45785);
      paramParcel = paramParcel.readString();
      if (paramParcel != null) {
        try
        {
          this.oyF = new JSONArray(paramParcel);
          AppMethodBeat.o(45785);
          return;
        }
        catch (JSONException paramParcel)
        {
          Log.e("MicroMsg.JsApiCancelDownloadTaskForNative", "parseFromParcel: " + paramParcel.getMessage());
        }
      }
      AppMethodBeat.o(45785);
    }
    
    public void writeToParcel(Parcel paramParcel, int paramInt)
    {
      AppMethodBeat.i(45786);
      if (this.oyF != null) {}
      for (String str = this.oyF.toString();; str = null)
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