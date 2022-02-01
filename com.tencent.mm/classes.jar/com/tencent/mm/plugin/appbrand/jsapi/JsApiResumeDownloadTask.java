package com.tencent.mm.plugin.appbrand.jsapi;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.appbrand.ipc.MainProcessTask;
import com.tencent.mm.plugin.appbrand.q;
import com.tencent.mm.plugin.downloader.model.d;
import com.tencent.mm.plugin.downloader.model.f;
import com.tencent.mm.sdk.platformtools.ad;
import com.tencent.mm.sdk.platformtools.bt;
import org.json.JSONObject;

public final class JsApiResumeDownloadTask
  extends a<q>
{
  public static final int CTRL_INDEX = 444;
  public static final String NAME = "resumeDownloadTask";
  
  static class ResumeDownloadTask
    extends MainProcessTask
  {
    public static final Parcelable.Creator<ResumeDownloadTask> CREATOR;
    private int cgA;
    private q jwH;
    private m ksO;
    private boolean ksW;
    private String ksX;
    private long ksY;
    private boolean kud;
    
    static
    {
      AppMethodBeat.i(107799);
      CREATOR = new Parcelable.Creator() {};
      AppMethodBeat.o(107799);
    }
    
    public ResumeDownloadTask(Parcel paramParcel)
    {
      AppMethodBeat.i(107794);
      e(paramParcel);
      AppMethodBeat.o(107794);
    }
    
    public ResumeDownloadTask(m paramm, q paramq, int paramInt, JSONObject paramJSONObject)
    {
      AppMethodBeat.i(107793);
      this.ksO = paramm;
      this.jwH = paramq;
      this.cgA = paramInt;
      this.ksY = paramJSONObject.optLong("downloadId");
      this.kud = paramJSONObject.optBoolean("downloadInWifi", false);
      this.ksW = true;
      AppMethodBeat.o(107793);
    }
    
    public final void aOA()
    {
      boolean bool = true;
      AppMethodBeat.i(107795);
      ad.i("MicroMsg.JsApiResumeDownloadTask", "doQueryDownloadTask, downloadId = %d", new Object[] { Long.valueOf(this.ksY) });
      if (this.ksY <= 0L)
      {
        this.ksX = "downloadId invalid";
        bhX();
        AppMethodBeat.o(107795);
        return;
      }
      com.tencent.mm.plugin.downloader.g.a locala = d.ua(this.ksY);
      if ((locala != null) && (locala.field_downloadInWifi != this.kud))
      {
        locala.field_downloadInWifi = this.kud;
        d.e(locala);
      }
      if (!f.ccl().tU(this.ksY)) {}
      for (;;)
      {
        this.ksW = bool;
        break;
        bool = false;
      }
    }
    
    public final void aOB()
    {
      AppMethodBeat.i(107796);
      if (this.ksW)
      {
        if (bt.isNullOrNil(this.ksX)) {}
        for (String str = "fail";; str = String.format("fail:%s", new Object[] { this.ksX }))
        {
          this.jwH.h(this.cgA, this.ksO.e(str, null));
          AppMethodBeat.o(107796);
          return;
        }
      }
      this.jwH.h(this.cgA, this.ksO.e("ok", null));
      AppMethodBeat.o(107796);
    }
    
    public final void e(Parcel paramParcel)
    {
      boolean bool2 = true;
      AppMethodBeat.i(107797);
      this.ksY = paramParcel.readLong();
      if (paramParcel.readByte() == 1)
      {
        bool1 = true;
        this.kud = bool1;
        if (paramParcel.readInt() != 1) {
          break label64;
        }
      }
      label64:
      for (boolean bool1 = bool2;; bool1 = false)
      {
        this.ksW = bool1;
        this.ksX = paramParcel.readString();
        AppMethodBeat.o(107797);
        return;
        bool1 = false;
        break;
      }
    }
    
    public void writeToParcel(Parcel paramParcel, int paramInt)
    {
      paramInt = 1;
      AppMethodBeat.i(107798);
      paramParcel.writeLong(this.ksY);
      byte b;
      if (this.kud)
      {
        b = 1;
        paramParcel.writeByte(b);
        if (!this.ksW) {
          break label60;
        }
      }
      for (;;)
      {
        paramParcel.writeInt(paramInt);
        paramParcel.writeString(this.ksX);
        AppMethodBeat.o(107798);
        return;
        b = 0;
        break;
        label60:
        paramInt = 0;
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.jsapi.JsApiResumeDownloadTask
 * JD-Core Version:    0.7.0.1
 */