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
    private int bZo;
    private q iDy;
    private m jxX;
    private boolean jyf;
    private String jyg;
    private long jyh;
    private boolean jzk;
    
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
      this.jxX = paramm;
      this.iDy = paramq;
      this.bZo = paramInt;
      this.jyh = paramJSONObject.optLong("downloadId");
      this.jzk = paramJSONObject.optBoolean("downloadInWifi", false);
      this.jyf = true;
      AppMethodBeat.o(107793);
    }
    
    public final void aEA()
    {
      AppMethodBeat.i(107796);
      if (this.jyf)
      {
        if (bt.isNullOrNil(this.jyg)) {}
        for (String str = "fail";; str = String.format("fail:%s", new Object[] { this.jyg }))
        {
          this.iDy.h(this.bZo, this.jxX.e(str, null));
          AppMethodBeat.o(107796);
          return;
        }
      }
      this.iDy.h(this.bZo, this.jxX.e("ok", null));
      AppMethodBeat.o(107796);
    }
    
    public final void aEz()
    {
      boolean bool = true;
      AppMethodBeat.i(107795);
      ad.i("MicroMsg.JsApiResumeDownloadTask", "doQueryDownloadTask, downloadId = %d", new Object[] { Long.valueOf(this.jyh) });
      if (this.jyh <= 0L)
      {
        this.jyg = "downloadId invalid";
        aXw();
        AppMethodBeat.o(107795);
        return;
      }
      com.tencent.mm.plugin.downloader.g.a locala = d.oq(this.jyh);
      if ((locala != null) && (locala.field_downloadInWifi != this.jzk))
      {
        locala.field_downloadInWifi = this.jzk;
        d.e(locala);
      }
      if (!f.bQt().oj(this.jyh)) {}
      for (;;)
      {
        this.jyf = bool;
        break;
        bool = false;
      }
    }
    
    public final void e(Parcel paramParcel)
    {
      boolean bool2 = true;
      AppMethodBeat.i(107797);
      this.jyh = paramParcel.readLong();
      if (paramParcel.readByte() == 1)
      {
        bool1 = true;
        this.jzk = bool1;
        if (paramParcel.readInt() != 1) {
          break label64;
        }
      }
      label64:
      for (boolean bool1 = bool2;; bool1 = false)
      {
        this.jyf = bool1;
        this.jyg = paramParcel.readString();
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
      paramParcel.writeLong(this.jyh);
      byte b;
      if (this.jzk)
      {
        b = 1;
        paramParcel.writeByte(b);
        if (!this.jyf) {
          break label60;
        }
      }
      for (;;)
      {
        paramParcel.writeInt(paramInt);
        paramParcel.writeString(this.jyg);
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