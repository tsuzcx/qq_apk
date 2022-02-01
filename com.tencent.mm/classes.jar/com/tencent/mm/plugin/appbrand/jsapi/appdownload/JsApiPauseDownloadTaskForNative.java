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

public final class JsApiPauseDownloadTaskForNative
  extends com.tencent.mm.plugin.appbrand.jsapi.a<c>
{
  public static final int CTRL_INDEX = 659;
  public static final String NAME = "pauseDownloadTaskForNative";
  
  static class PauseDownloadTask
    extends MainProcessTask
  {
    public static final Parcelable.Creator<PauseDownloadTask> CREATOR;
    private int cgA;
    private q jwH;
    private m ksO;
    private boolean ksW;
    private String ksX;
    private long ksY;
    
    static
    {
      AppMethodBeat.i(45866);
      CREATOR = new Parcelable.Creator() {};
      AppMethodBeat.o(45866);
    }
    
    public PauseDownloadTask(Parcel paramParcel)
    {
      AppMethodBeat.i(45861);
      e(paramParcel);
      AppMethodBeat.o(45861);
    }
    
    public PauseDownloadTask(m paramm, q paramq, int paramInt, JSONObject paramJSONObject)
    {
      AppMethodBeat.i(45860);
      this.ksO = paramm;
      this.jwH = paramq;
      this.cgA = paramInt;
      this.ksY = paramJSONObject.optLong("downloadId");
      this.ksW = true;
      AppMethodBeat.o(45860);
    }
    
    public final void aOA()
    {
      boolean bool = true;
      AppMethodBeat.i(45862);
      ad.i("MicroMsg.JsApiPauseDownloadTaskForNative", "doPauseDownloadTask, downloadId = %d", new Object[] { Long.valueOf(this.ksY) });
      if (this.ksY <= 0L) {}
      com.tencent.mm.plugin.downloader.g.a locala;
      for (this.ksX = "downloadId invalid";; this.ksX = "downloadId invalid")
      {
        bhX();
        AppMethodBeat.o(45862);
        return;
        locala = d.ua(this.ksY);
        if (locala != null) {
          break;
        }
      }
      if (locala.field_downloadInWifi)
      {
        locala.field_downloadInWifi = false;
        d.e(locala);
      }
      if (!f.ccl().tT(this.ksY)) {}
      for (;;)
      {
        this.ksW = bool;
        break;
        bool = false;
      }
    }
    
    public final void aOB()
    {
      AppMethodBeat.i(45863);
      if (this.ksW)
      {
        if (bt.isNullOrNil(this.ksX)) {}
        for (String str = "fail";; str = String.format("fail:%s", new Object[] { this.ksX }))
        {
          this.jwH.h(this.cgA, this.ksO.e(str, null));
          AppMethodBeat.o(45863);
          return;
        }
      }
      this.jwH.h(this.cgA, this.ksO.e("ok", null));
      AppMethodBeat.o(45863);
    }
    
    public final void e(Parcel paramParcel)
    {
      boolean bool = true;
      AppMethodBeat.i(45864);
      this.ksY = paramParcel.readLong();
      if (paramParcel.readInt() == 1) {}
      for (;;)
      {
        this.ksW = bool;
        this.ksX = paramParcel.readString();
        AppMethodBeat.o(45864);
        return;
        bool = false;
      }
    }
    
    public void writeToParcel(Parcel paramParcel, int paramInt)
    {
      AppMethodBeat.i(45865);
      paramParcel.writeLong(this.ksY);
      if (this.ksW) {}
      for (paramInt = 1;; paramInt = 0)
      {
        paramParcel.writeInt(paramInt);
        paramParcel.writeString(this.ksX);
        AppMethodBeat.o(45865);
        return;
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.jsapi.appdownload.JsApiPauseDownloadTaskForNative
 * JD-Core Version:    0.7.0.1
 */