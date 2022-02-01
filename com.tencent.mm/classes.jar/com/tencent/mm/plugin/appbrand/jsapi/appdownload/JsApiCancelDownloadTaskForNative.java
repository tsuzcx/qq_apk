package com.tencent.mm.plugin.appbrand.jsapi.appdownload;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.appbrand.ipc.MainProcessTask;
import com.tencent.mm.plugin.appbrand.jsapi.m;
import com.tencent.mm.plugin.appbrand.r;
import com.tencent.mm.plugin.downloader.model.d;
import com.tencent.mm.plugin.downloader.model.f;
import com.tencent.mm.sdk.platformtools.ae;
import com.tencent.mm.vfs.o;
import org.json.JSONArray;
import org.json.JSONException;

public final class JsApiCancelDownloadTaskForNative
  extends com.tencent.mm.plugin.appbrand.jsapi.a<r>
{
  public static final int CTRL_INDEX = 657;
  public static final String NAME = "cancelDownloadTaskForNative";
  
  static class CancelDownloadTask
    extends MainProcessTask
  {
    public static Parcelable.Creator<CancelDownloadTask> CREATOR;
    private r jFj;
    private int kmu;
    private JSONArray kyK;
    private com.tencent.mm.plugin.appbrand.jsapi.a kyL;
    
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
    
    public CancelDownloadTask(JSONArray paramJSONArray, com.tencent.mm.plugin.appbrand.jsapi.a parama, r paramr, int paramInt)
    {
      AppMethodBeat.i(45783);
      biw();
      this.kyK = paramJSONArray;
      this.kyL = parama;
      this.jFj = paramr;
      this.kmu = paramInt;
      AppMethodBeat.o(45783);
    }
    
    public final void aOX()
    {
      AppMethodBeat.i(45781);
      if ((this.kyK != null) && (this.kyK.length() > 0))
      {
        int i = 0;
        if (i < this.kyK.length())
        {
          long l = this.kyK.optLong(i);
          com.tencent.mm.plugin.downloader.g.a locala = d.ur(l);
          if ((locala != null) && (locala.field_status == 3))
          {
            ae.i("MicroMsg.JsApiCancelDownloadTaskForNative", "canceldownloadtask, path: %s", new Object[] { locala.field_filePath });
            o.deleteFile(locala.field_filePath);
            d.aaV(locala.field_downloadUrl);
          }
          for (;;)
          {
            i += 1;
            break;
            f.cdA().ui(l);
          }
        }
      }
      biG();
      AppMethodBeat.o(45781);
    }
    
    public final void aOY()
    {
      AppMethodBeat.i(45782);
      bix();
      this.jFj.h(this.kmu, this.kyL.e("ok", null));
      AppMethodBeat.o(45782);
    }
    
    public final void e(Parcel paramParcel)
    {
      AppMethodBeat.i(45785);
      paramParcel = paramParcel.readString();
      if (paramParcel != null) {
        try
        {
          this.kyK = new JSONArray(paramParcel);
          AppMethodBeat.o(45785);
          return;
        }
        catch (JSONException paramParcel)
        {
          ae.e("MicroMsg.JsApiCancelDownloadTaskForNative", "parseFromParcel: " + paramParcel.getMessage());
        }
      }
      AppMethodBeat.o(45785);
    }
    
    public void writeToParcel(Parcel paramParcel, int paramInt)
    {
      AppMethodBeat.i(45786);
      if (this.kyK != null) {}
      for (String str = this.kyK.toString();; str = null)
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