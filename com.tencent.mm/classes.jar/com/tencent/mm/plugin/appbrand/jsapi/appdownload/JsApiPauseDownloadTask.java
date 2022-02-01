package com.tencent.mm.plugin.appbrand.jsapi.appdownload;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.appbrand.ipc.MainProcessTask;
import com.tencent.mm.plugin.appbrand.jsapi.o;
import com.tencent.mm.plugin.appbrand.v;
import com.tencent.mm.plugin.downloader.g.a;
import com.tencent.mm.plugin.downloader.model.d;
import com.tencent.mm.plugin.downloader.model.f;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.Util;
import org.json.JSONObject;

public final class JsApiPauseDownloadTask
  extends com.tencent.mm.plugin.appbrand.jsapi.c<com.tencent.mm.plugin.appbrand.service.c>
{
  public static final int CTRL_INDEX = 443;
  public static final String NAME = "pauseDownloadTask";
  
  static class PauseDownloadTask
    extends MainProcessTask
  {
    public static final Parcelable.Creator<PauseDownloadTask> CREATOR;
    private int cqA;
    private v ntA;
    private boolean ovH;
    private String ovI;
    private long ovJ;
    private o ovz;
    
    static
    {
      AppMethodBeat.i(45857);
      CREATOR = new Parcelable.Creator() {};
      AppMethodBeat.o(45857);
    }
    
    public PauseDownloadTask(Parcel paramParcel)
    {
      AppMethodBeat.i(45852);
      f(paramParcel);
      AppMethodBeat.o(45852);
    }
    
    public PauseDownloadTask(o paramo, v paramv, int paramInt, JSONObject paramJSONObject)
    {
      AppMethodBeat.i(45851);
      this.ovz = paramo;
      this.ntA = paramv;
      this.cqA = paramInt;
      this.ovJ = paramJSONObject.optLong("downloadId");
      this.ovH = true;
      AppMethodBeat.o(45851);
    }
    
    public final void RW()
    {
      boolean bool = true;
      AppMethodBeat.i(45853);
      Log.i("MicroMsg.JsApiPauseDownloadTask", "doPauseDownloadTask, downloadId = %d", new Object[] { Long.valueOf(this.ovJ) });
      if (this.ovJ <= 0L) {}
      a locala;
      for (this.ovI = "downloadId invalid";; this.ovI = "downloadId invalid")
      {
        bPt();
        AppMethodBeat.o(45853);
        return;
        locala = d.IF(this.ovJ);
        if (locala != null) {
          break;
        }
      }
      if (locala.field_downloadInWifi)
      {
        locala.field_downloadInWifi = false;
        d.e(locala);
      }
      if (!f.cPZ().Iy(this.ovJ)) {}
      for (;;)
      {
        this.ovH = bool;
        break;
        bool = false;
      }
    }
    
    public final void bsK()
    {
      AppMethodBeat.i(45854);
      if (this.ovH)
      {
        if (Util.isNullOrNil(this.ovI)) {}
        for (String str = "fail";; str = String.format("fail:%s", new Object[] { this.ovI }))
        {
          this.ntA.j(this.cqA, this.ovz.h(str, null));
          AppMethodBeat.o(45854);
          return;
        }
      }
      this.ntA.j(this.cqA, this.ovz.h("ok", null));
      AppMethodBeat.o(45854);
    }
    
    public final void f(Parcel paramParcel)
    {
      boolean bool = true;
      AppMethodBeat.i(45855);
      this.ovJ = paramParcel.readLong();
      if (paramParcel.readInt() == 1) {}
      for (;;)
      {
        this.ovH = bool;
        this.ovI = paramParcel.readString();
        AppMethodBeat.o(45855);
        return;
        bool = false;
      }
    }
    
    public void writeToParcel(Parcel paramParcel, int paramInt)
    {
      AppMethodBeat.i(45856);
      paramParcel.writeLong(this.ovJ);
      if (this.ovH) {}
      for (paramInt = 1;; paramInt = 0)
      {
        paramParcel.writeInt(paramInt);
        paramParcel.writeString(this.ovI);
        AppMethodBeat.o(45856);
        return;
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.jsapi.appdownload.JsApiPauseDownloadTask
 * JD-Core Version:    0.7.0.1
 */