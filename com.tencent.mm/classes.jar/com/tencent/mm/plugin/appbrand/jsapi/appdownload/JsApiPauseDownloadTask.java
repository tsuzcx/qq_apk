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
import com.tencent.mm.sdk.platformtools.ad;
import com.tencent.mm.sdk.platformtools.bt;
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
    private int bZo;
    private q iDy;
    private m jxX;
    private boolean jyf;
    private String jyg;
    private long jyh;
    
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
      this.jxX = paramm;
      this.iDy = paramq;
      this.bZo = paramInt;
      this.jyh = paramJSONObject.optLong("downloadId");
      this.jyf = true;
      AppMethodBeat.o(45851);
    }
    
    public final void aEA()
    {
      AppMethodBeat.i(45854);
      if (this.jyf)
      {
        if (bt.isNullOrNil(this.jyg)) {}
        for (String str = "fail";; str = String.format("fail:%s", new Object[] { this.jyg }))
        {
          this.iDy.h(this.bZo, this.jxX.e(str, null));
          AppMethodBeat.o(45854);
          return;
        }
      }
      this.iDy.h(this.bZo, this.jxX.e("ok", null));
      AppMethodBeat.o(45854);
    }
    
    public final void aEz()
    {
      boolean bool = true;
      AppMethodBeat.i(45853);
      ad.i("MicroMsg.JsApiPauseDownloadTask", "doPauseDownloadTask, downloadId = %d", new Object[] { Long.valueOf(this.jyh) });
      if (this.jyh <= 0L) {}
      com.tencent.mm.plugin.downloader.g.a locala;
      for (this.jyg = "downloadId invalid";; this.jyg = "downloadId invalid")
      {
        aXw();
        AppMethodBeat.o(45853);
        return;
        locala = d.oq(this.jyh);
        if (locala != null) {
          break;
        }
      }
      if (locala.field_downloadInWifi)
      {
        locala.field_downloadInWifi = false;
        d.e(locala);
      }
      if (!f.bQt().oi(this.jyh)) {}
      for (;;)
      {
        this.jyf = bool;
        break;
        bool = false;
      }
    }
    
    public final void e(Parcel paramParcel)
    {
      boolean bool = true;
      AppMethodBeat.i(45855);
      this.jyh = paramParcel.readLong();
      if (paramParcel.readInt() == 1) {}
      for (;;)
      {
        this.jyf = bool;
        this.jyg = paramParcel.readString();
        AppMethodBeat.o(45855);
        return;
        bool = false;
      }
    }
    
    public void writeToParcel(Parcel paramParcel, int paramInt)
    {
      AppMethodBeat.i(45856);
      paramParcel.writeLong(this.jyh);
      if (this.jyf) {}
      for (paramInt = 1;; paramInt = 0)
      {
        paramParcel.writeInt(paramInt);
        paramParcel.writeString(this.jyg);
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