package com.tencent.mm.plugin.appbrand.jsapi.appdownload;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.appbrand.ipc.MainProcessTask;
import com.tencent.mm.plugin.appbrand.jsapi.m;
import com.tencent.mm.plugin.appbrand.r;
import com.tencent.mm.plugin.appbrand.service.c;
import com.tencent.mm.plugin.downloader.model.d;
import com.tencent.mm.plugin.downloader.model.f;
import com.tencent.mm.sdk.platformtools.ab;
import com.tencent.mm.sdk.platformtools.bo;
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
    private int bxX;
    private r gPA;
    private m hyA;
    private boolean hyI;
    private String hyJ;
    private long hyK;
    
    static
    {
      AppMethodBeat.i(130697);
      CREATOR = new JsApiPauseDownloadTask.PauseDownloadTask.1();
      AppMethodBeat.o(130697);
    }
    
    public PauseDownloadTask(Parcel paramParcel)
    {
      AppMethodBeat.i(130692);
      f(paramParcel);
      AppMethodBeat.o(130692);
    }
    
    public PauseDownloadTask(m paramm, r paramr, int paramInt, JSONObject paramJSONObject)
    {
      AppMethodBeat.i(130691);
      this.hyA = paramm;
      this.gPA = paramr;
      this.bxX = paramInt;
      this.hyK = paramJSONObject.optLong("downloadId");
      this.hyI = true;
      AppMethodBeat.o(130691);
    }
    
    public final void ata()
    {
      boolean bool = true;
      AppMethodBeat.i(130693);
      ab.i("MicroMsg.JsApiPauseDownloadTask", "doPauseDownloadTask, downloadId = %d", new Object[] { Long.valueOf(this.hyK) });
      if (this.hyK <= 0L) {}
      com.tencent.mm.plugin.downloader.g.a locala;
      for (this.hyJ = "downloadId invalid";; this.hyJ = "downloadId invalid")
      {
        aBp();
        AppMethodBeat.o(130693);
        return;
        locala = d.iJ(this.hyK);
        if (locala != null) {
          break;
        }
      }
      if (locala.field_downloadInWifi)
      {
        locala.field_downloadInWifi = false;
        d.e(locala);
      }
      if (!f.bjl().iB(this.hyK)) {}
      for (;;)
      {
        this.hyI = bool;
        break;
        bool = false;
      }
    }
    
    public final void atb()
    {
      AppMethodBeat.i(130694);
      if (this.hyI)
      {
        if (bo.isNullOrNil(this.hyJ)) {}
        for (String str = "fail";; str = String.format("fail:%s", new Object[] { this.hyJ }))
        {
          this.gPA.h(this.bxX, this.hyA.j(str, null));
          AppMethodBeat.o(130694);
          return;
        }
      }
      this.gPA.h(this.bxX, this.hyA.j("ok", null));
      AppMethodBeat.o(130694);
    }
    
    public final void f(Parcel paramParcel)
    {
      boolean bool = true;
      AppMethodBeat.i(130695);
      this.hyK = paramParcel.readLong();
      if (paramParcel.readInt() == 1) {}
      for (;;)
      {
        this.hyI = bool;
        this.hyJ = paramParcel.readString();
        AppMethodBeat.o(130695);
        return;
        bool = false;
      }
    }
    
    public void writeToParcel(Parcel paramParcel, int paramInt)
    {
      AppMethodBeat.i(130696);
      paramParcel.writeLong(this.hyK);
      if (this.hyI) {}
      for (paramInt = 1;; paramInt = 0)
      {
        paramParcel.writeInt(paramInt);
        paramParcel.writeString(this.hyJ);
        AppMethodBeat.o(130696);
        return;
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.jsapi.appdownload.JsApiPauseDownloadTask
 * JD-Core Version:    0.7.0.1
 */