package com.tencent.mm.plugin.appbrand.jsapi.appdownload;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.appbrand.ipc.MainProcessTask;
import com.tencent.mm.plugin.appbrand.jsapi.m;
import com.tencent.mm.plugin.appbrand.q;
import com.tencent.mm.plugin.appbrand.service.c;
import com.tencent.mm.plugin.downloader.model.d;
import com.tencent.mm.plugin.downloader.model.f;
import com.tencent.mm.sdk.platformtools.ac;
import com.tencent.mm.sdk.platformtools.bs;
import org.json.JSONObject;

public final class JsApiPauseDownloadTask
  extends com.tencent.mm.plugin.appbrand.jsapi.a<c>
{
  public static final int CTRL_INDEX = 443;
  public static final String NAME = "pauseDownloadTask";
  
  static class PauseDownloadTask
    extends MainProcessTask
  {
    public static final Parcelable.Creator<PauseDownloadTask> CREATOR;
    private int bWl;
    private boolean jYA;
    private String jYB;
    private long jYC;
    private m jYs;
    private q jdy;
    
    static
    {
      AppMethodBeat.i(45857);
      CREATOR = new Parcelable.Creator() {};
      AppMethodBeat.o(45857);
    }
    
    public PauseDownloadTask(Parcel paramParcel)
    {
      AppMethodBeat.i(45852);
      e(paramParcel);
      AppMethodBeat.o(45852);
    }
    
    public PauseDownloadTask(m paramm, q paramq, int paramInt, JSONObject paramJSONObject)
    {
      AppMethodBeat.i(45851);
      this.jYs = paramm;
      this.jdy = paramq;
      this.bWl = paramInt;
      this.jYC = paramJSONObject.optLong("downloadId");
      this.jYA = true;
      AppMethodBeat.o(45851);
    }
    
    public final void aLq()
    {
      boolean bool = true;
      AppMethodBeat.i(45853);
      ac.i("MicroMsg.JsApiPauseDownloadTask", "doPauseDownloadTask, downloadId = %d", new Object[] { Long.valueOf(this.jYC) });
      if (this.jYC <= 0L) {}
      com.tencent.mm.plugin.downloader.g.a locala;
      for (this.jYB = "downloadId invalid";; this.jYB = "downloadId invalid")
      {
        bet();
        AppMethodBeat.o(45853);
        return;
        locala = d.sc(this.jYC);
        if (locala != null) {
          break;
        }
      }
      if (locala.field_downloadInWifi)
      {
        locala.field_downloadInWifi = false;
        d.e(locala);
      }
      if (!f.bXJ().rU(this.jYC)) {}
      for (;;)
      {
        this.jYA = bool;
        break;
        bool = false;
      }
    }
    
    public final void aLr()
    {
      AppMethodBeat.i(45854);
      if (this.jYA)
      {
        if (bs.isNullOrNil(this.jYB)) {}
        for (String str = "fail";; str = String.format("fail:%s", new Object[] { this.jYB }))
        {
          this.jdy.h(this.bWl, this.jYs.e(str, null));
          AppMethodBeat.o(45854);
          return;
        }
      }
      this.jdy.h(this.bWl, this.jYs.e("ok", null));
      AppMethodBeat.o(45854);
    }
    
    public final void e(Parcel paramParcel)
    {
      boolean bool = true;
      AppMethodBeat.i(45855);
      this.jYC = paramParcel.readLong();
      if (paramParcel.readInt() == 1) {}
      for (;;)
      {
        this.jYA = bool;
        this.jYB = paramParcel.readString();
        AppMethodBeat.o(45855);
        return;
        bool = false;
      }
    }
    
    public void writeToParcel(Parcel paramParcel, int paramInt)
    {
      AppMethodBeat.i(45856);
      paramParcel.writeLong(this.jYC);
      if (this.jYA) {}
      for (paramInt = 1;; paramInt = 0)
      {
        paramParcel.writeInt(paramInt);
        paramParcel.writeString(this.jYB);
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