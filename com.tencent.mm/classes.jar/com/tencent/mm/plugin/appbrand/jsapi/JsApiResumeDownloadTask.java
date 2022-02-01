package com.tencent.mm.plugin.appbrand.jsapi;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.appbrand.ipc.MainProcessTask;
import com.tencent.mm.plugin.appbrand.q;
import com.tencent.mm.plugin.downloader.model.d;
import com.tencent.mm.plugin.downloader.model.f;
import com.tencent.mm.sdk.platformtools.ac;
import com.tencent.mm.sdk.platformtools.bs;
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
    private int bWl;
    private boolean jYA;
    private String jYB;
    private long jYC;
    private m jYs;
    private boolean jZH;
    private q jdy;
    
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
      this.jYs = paramm;
      this.jdy = paramq;
      this.bWl = paramInt;
      this.jYC = paramJSONObject.optLong("downloadId");
      this.jZH = paramJSONObject.optBoolean("downloadInWifi", false);
      this.jYA = true;
      AppMethodBeat.o(107793);
    }
    
    public final void aLq()
    {
      boolean bool = true;
      AppMethodBeat.i(107795);
      ac.i("MicroMsg.JsApiResumeDownloadTask", "doQueryDownloadTask, downloadId = %d", new Object[] { Long.valueOf(this.jYC) });
      if (this.jYC <= 0L)
      {
        this.jYB = "downloadId invalid";
        bet();
        AppMethodBeat.o(107795);
        return;
      }
      com.tencent.mm.plugin.downloader.g.a locala = d.sc(this.jYC);
      if ((locala != null) && (locala.field_downloadInWifi != this.jZH))
      {
        locala.field_downloadInWifi = this.jZH;
        d.e(locala);
      }
      if (!f.bXJ().rV(this.jYC)) {}
      for (;;)
      {
        this.jYA = bool;
        break;
        bool = false;
      }
    }
    
    public final void aLr()
    {
      AppMethodBeat.i(107796);
      if (this.jYA)
      {
        if (bs.isNullOrNil(this.jYB)) {}
        for (String str = "fail";; str = String.format("fail:%s", new Object[] { this.jYB }))
        {
          this.jdy.h(this.bWl, this.jYs.e(str, null));
          AppMethodBeat.o(107796);
          return;
        }
      }
      this.jdy.h(this.bWl, this.jYs.e("ok", null));
      AppMethodBeat.o(107796);
    }
    
    public final void e(Parcel paramParcel)
    {
      boolean bool2 = true;
      AppMethodBeat.i(107797);
      this.jYC = paramParcel.readLong();
      if (paramParcel.readByte() == 1)
      {
        bool1 = true;
        this.jZH = bool1;
        if (paramParcel.readInt() != 1) {
          break label64;
        }
      }
      label64:
      for (boolean bool1 = bool2;; bool1 = false)
      {
        this.jYA = bool1;
        this.jYB = paramParcel.readString();
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
      paramParcel.writeLong(this.jYC);
      byte b;
      if (this.jZH)
      {
        b = 1;
        paramParcel.writeByte(b);
        if (!this.jYA) {
          break label60;
        }
      }
      for (;;)
      {
        paramParcel.writeInt(paramInt);
        paramParcel.writeString(this.jYB);
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