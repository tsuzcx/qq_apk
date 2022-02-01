package com.tencent.mm.plugin.appbrand.jsapi;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.appbrand.ipc.MainProcessTask;
import com.tencent.mm.plugin.appbrand.r;
import com.tencent.mm.plugin.downloader.model.d;
import com.tencent.mm.plugin.downloader.model.f;
import com.tencent.mm.sdk.platformtools.ae;
import com.tencent.mm.sdk.platformtools.bu;
import org.json.JSONObject;

public final class JsApiResumeDownloadTask
  extends a<r>
{
  public static final int CTRL_INDEX = 444;
  public static final String NAME = "resumeDownloadTask";
  
  static class ResumeDownloadTask
    extends MainProcessTask
  {
    public static final Parcelable.Creator<ResumeDownloadTask> CREATOR;
    private int cgA;
    private r jzD;
    private m kwe;
    private boolean kwm;
    private String kwn;
    private long kwo;
    private boolean kxt;
    
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
    
    public ResumeDownloadTask(m paramm, r paramr, int paramInt, JSONObject paramJSONObject)
    {
      AppMethodBeat.i(107793);
      this.kwe = paramm;
      this.jzD = paramr;
      this.cgA = paramInt;
      this.kwo = paramJSONObject.optLong("downloadId");
      this.kxt = paramJSONObject.optBoolean("downloadInWifi", false);
      this.kwm = true;
      AppMethodBeat.o(107793);
    }
    
    public final void aOX()
    {
      boolean bool = true;
      AppMethodBeat.i(107795);
      ae.i("MicroMsg.JsApiResumeDownloadTask", "doQueryDownloadTask, downloadId = %d", new Object[] { Long.valueOf(this.kwo) });
      if (this.kwo <= 0L)
      {
        this.kwn = "downloadId invalid";
        biG();
        AppMethodBeat.o(107795);
        return;
      }
      com.tencent.mm.plugin.downloader.g.a locala = d.ur(this.kwo);
      if ((locala != null) && (locala.field_downloadInWifi != this.kxt))
      {
        locala.field_downloadInWifi = this.kxt;
        d.e(locala);
      }
      if (!f.cdA().ul(this.kwo)) {}
      for (;;)
      {
        this.kwm = bool;
        break;
        bool = false;
      }
    }
    
    public final void aOY()
    {
      AppMethodBeat.i(107796);
      if (this.kwm)
      {
        if (bu.isNullOrNil(this.kwn)) {}
        for (String str = "fail";; str = String.format("fail:%s", new Object[] { this.kwn }))
        {
          this.jzD.h(this.cgA, this.kwe.e(str, null));
          AppMethodBeat.o(107796);
          return;
        }
      }
      this.jzD.h(this.cgA, this.kwe.e("ok", null));
      AppMethodBeat.o(107796);
    }
    
    public final void e(Parcel paramParcel)
    {
      boolean bool2 = true;
      AppMethodBeat.i(107797);
      this.kwo = paramParcel.readLong();
      if (paramParcel.readByte() == 1)
      {
        bool1 = true;
        this.kxt = bool1;
        if (paramParcel.readInt() != 1) {
          break label64;
        }
      }
      label64:
      for (boolean bool1 = bool2;; bool1 = false)
      {
        this.kwm = bool1;
        this.kwn = paramParcel.readString();
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
      paramParcel.writeLong(this.kwo);
      byte b;
      if (this.kxt)
      {
        b = 1;
        paramParcel.writeByte(b);
        if (!this.kwm) {
          break label60;
        }
      }
      for (;;)
      {
        paramParcel.writeInt(paramInt);
        paramParcel.writeString(this.kwn);
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