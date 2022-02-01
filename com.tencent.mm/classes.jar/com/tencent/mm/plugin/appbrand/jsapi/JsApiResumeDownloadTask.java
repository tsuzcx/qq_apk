package com.tencent.mm.plugin.appbrand.jsapi;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.appbrand.ipc.MainProcessTask;
import com.tencent.mm.plugin.appbrand.v;
import com.tencent.mm.plugin.downloader.g.a;
import com.tencent.mm.plugin.downloader.model.d;
import com.tencent.mm.plugin.downloader.model.f;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.Util;
import org.json.JSONObject;

public final class JsApiResumeDownloadTask
  extends c<v>
{
  public static final int CTRL_INDEX = 444;
  public static final String NAME = "resumeDownloadTask";
  
  static class ResumeDownloadTask
    extends MainProcessTask
  {
    public static final Parcelable.Creator<ResumeDownloadTask> CREATOR;
    private int cqA;
    private v ntA;
    private boolean ovH;
    private String ovI;
    private long ovJ;
    private o ovz;
    private boolean owW;
    
    static
    {
      AppMethodBeat.i(107799);
      CREATOR = new Parcelable.Creator() {};
      AppMethodBeat.o(107799);
    }
    
    public ResumeDownloadTask(Parcel paramParcel)
    {
      AppMethodBeat.i(107794);
      f(paramParcel);
      AppMethodBeat.o(107794);
    }
    
    public ResumeDownloadTask(o paramo, v paramv, int paramInt, JSONObject paramJSONObject)
    {
      AppMethodBeat.i(107793);
      this.ovz = paramo;
      this.ntA = paramv;
      this.cqA = paramInt;
      this.ovJ = paramJSONObject.optLong("downloadId");
      this.owW = paramJSONObject.optBoolean("downloadInWifi", false);
      this.ovH = true;
      AppMethodBeat.o(107793);
    }
    
    public final void RW()
    {
      boolean bool = true;
      AppMethodBeat.i(107795);
      Log.i("MicroMsg.JsApiResumeDownloadTask", "doQueryDownloadTask, downloadId = %d", new Object[] { Long.valueOf(this.ovJ) });
      if (this.ovJ <= 0L)
      {
        this.ovI = "downloadId invalid";
        bPt();
        AppMethodBeat.o(107795);
        return;
      }
      a locala = d.IF(this.ovJ);
      if ((locala != null) && (locala.field_downloadInWifi != this.owW))
      {
        locala.field_downloadInWifi = this.owW;
        d.e(locala);
      }
      if (!f.cPZ().Iz(this.ovJ)) {}
      for (;;)
      {
        this.ovH = bool;
        break;
        bool = false;
      }
    }
    
    public final void bsK()
    {
      AppMethodBeat.i(107796);
      if (this.ovH)
      {
        if (Util.isNullOrNil(this.ovI)) {}
        for (String str = "fail";; str = String.format("fail:%s", new Object[] { this.ovI }))
        {
          this.ntA.j(this.cqA, this.ovz.h(str, null));
          AppMethodBeat.o(107796);
          return;
        }
      }
      this.ntA.j(this.cqA, this.ovz.h("ok", null));
      AppMethodBeat.o(107796);
    }
    
    public final void f(Parcel paramParcel)
    {
      boolean bool2 = true;
      AppMethodBeat.i(107797);
      this.ovJ = paramParcel.readLong();
      if (paramParcel.readByte() == 1)
      {
        bool1 = true;
        this.owW = bool1;
        if (paramParcel.readInt() != 1) {
          break label64;
        }
      }
      label64:
      for (boolean bool1 = bool2;; bool1 = false)
      {
        this.ovH = bool1;
        this.ovI = paramParcel.readString();
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
      paramParcel.writeLong(this.ovJ);
      byte b;
      if (this.owW)
      {
        b = 1;
        paramParcel.writeByte(b);
        if (!this.ovH) {
          break label60;
        }
      }
      for (;;)
      {
        paramParcel.writeInt(paramInt);
        paramParcel.writeString(this.ovI);
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