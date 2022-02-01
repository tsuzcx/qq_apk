package com.tencent.mm.plugin.appbrand.jsapi.appdownload;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.appbrand.ipc.MainProcessTask;
import com.tencent.mm.plugin.appbrand.jsapi.p;
import com.tencent.mm.plugin.downloader.g.a;
import com.tencent.mm.plugin.downloader.model.f;
import com.tencent.mm.sdk.platformtools.Log;
import org.json.JSONArray;
import org.json.JSONException;

public final class JsApiCancelDownloadTaskForNative
  extends com.tencent.mm.plugin.appbrand.jsapi.d<com.tencent.mm.plugin.appbrand.s>
{
  public static final int CTRL_INDEX = 657;
  public static final String NAME = "cancelDownloadTaskForNative";
  
  static class CancelDownloadTask
    extends MainProcessTask
  {
    public static Parcelable.Creator<CancelDownloadTask> CREATOR;
    private com.tencent.mm.plugin.appbrand.s kGT;
    private JSONArray lDd;
    private com.tencent.mm.plugin.appbrand.jsapi.d lDe;
    private int lqe;
    
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
    
    public CancelDownloadTask(JSONArray paramJSONArray, com.tencent.mm.plugin.appbrand.jsapi.d paramd, com.tencent.mm.plugin.appbrand.s params, int paramInt)
    {
      AppMethodBeat.i(45783);
      bDJ();
      this.lDd = paramJSONArray;
      this.lDe = paramd;
      this.kGT = params;
      this.lqe = paramInt;
      AppMethodBeat.o(45783);
    }
    
    public final void bjj()
    {
      AppMethodBeat.i(45781);
      if ((this.lDd != null) && (this.lDd.length() > 0))
      {
        int i = 0;
        if (i < this.lDd.length())
        {
          long l = this.lDd.optLong(i);
          a locala = com.tencent.mm.plugin.downloader.model.d.Cw(l);
          if ((locala != null) && (locala.field_status == 3))
          {
            Log.i("MicroMsg.JsApiCancelDownloadTaskForNative", "canceldownloadtask, path: %s", new Object[] { locala.field_filePath });
            com.tencent.mm.vfs.s.deleteFile(locala.field_filePath);
            com.tencent.mm.plugin.downloader.model.d.alc(locala.field_downloadUrl);
          }
          for (;;)
          {
            i += 1;
            break;
            f.cBv().Cn(l);
          }
        }
      }
      bDU();
      AppMethodBeat.o(45781);
    }
    
    public final void bjk()
    {
      AppMethodBeat.i(45782);
      bDK();
      this.kGT.i(this.lqe, this.lDe.h("ok", null));
      AppMethodBeat.o(45782);
    }
    
    public final void f(Parcel paramParcel)
    {
      AppMethodBeat.i(45785);
      paramParcel = paramParcel.readString();
      if (paramParcel != null) {
        try
        {
          this.lDd = new JSONArray(paramParcel);
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
      if (this.lDd != null) {}
      for (String str = this.lDd.toString();; str = null)
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