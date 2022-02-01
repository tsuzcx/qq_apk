package com.tencent.mm.plugin.appbrand.jsapi.appdownload;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.appbrand.ipc.MainProcessTask;
import com.tencent.mm.plugin.appbrand.jsapi.c;
import com.tencent.mm.plugin.downloader.f.a;
import com.tencent.mm.plugin.downloader.model.d;
import com.tencent.mm.plugin.downloader.model.f;
import com.tencent.mm.sdk.platformtools.Log;
import org.json.JSONArray;
import org.json.JSONException;

public final class JsApiCancelDownloadTaskForNative
  extends c<com.tencent.mm.plugin.appbrand.y>
{
  public static final int CTRL_INDEX = 657;
  public static final String NAME = "cancelDownloadTaskForNative";
  
  static class CancelDownloadTask
    extends MainProcessTask
  {
    public static Parcelable.Creator<CancelDownloadTask> CREATOR;
    private com.tencent.mm.plugin.appbrand.y qqV;
    private JSONArray rCx;
    private c rCy;
    private int ror;
    
    static
    {
      AppMethodBeat.i(45787);
      CREATOR = new Parcelable.Creator() {};
      AppMethodBeat.o(45787);
    }
    
    private CancelDownloadTask(Parcel paramParcel)
    {
      AppMethodBeat.i(45784);
      h(paramParcel);
      AppMethodBeat.o(45784);
    }
    
    public CancelDownloadTask(JSONArray paramJSONArray, c paramc, com.tencent.mm.plugin.appbrand.y paramy, int paramInt)
    {
      AppMethodBeat.i(45783);
      this.rCx = paramJSONArray;
      this.rCy = paramc;
      this.qqV = paramy;
      this.ror = paramInt;
      AppMethodBeat.o(45783);
    }
    
    public final void asn()
    {
      AppMethodBeat.i(45781);
      if ((this.rCx != null) && (this.rCx.length() > 0))
      {
        int i = 0;
        if (i < this.rCx.length())
        {
          long l = this.rCx.optLong(i);
          a locala = d.la(l);
          if ((locala != null) && (locala.field_status == 3))
          {
            Log.i("MicroMsg.JsApiCancelDownloadTaskForNative", "canceldownloadtask, path: %s", new Object[] { locala.field_filePath });
            com.tencent.mm.vfs.y.deleteFile(locala.field_filePath);
            d.amK(locala.field_downloadUrl);
          }
          for (;;)
          {
            i += 1;
            break;
            f.duv().kR(l);
          }
        }
      }
      cpA();
      AppMethodBeat.o(45781);
    }
    
    public final void bQr()
    {
      AppMethodBeat.i(45782);
      cpx();
      this.qqV.callback(this.ror, this.rCy.ZP("ok"));
      AppMethodBeat.o(45782);
    }
    
    public final void h(Parcel paramParcel)
    {
      AppMethodBeat.i(45785);
      paramParcel = paramParcel.readString();
      if (paramParcel != null) {
        try
        {
          this.rCx = new JSONArray(paramParcel);
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
      if (this.rCx != null) {}
      for (String str = this.rCx.toString();; str = null)
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