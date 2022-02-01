package com.tencent.mm.plugin.appbrand.jsapi.appdownload;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.appbrand.ipc.MainProcessTask;
import com.tencent.mm.plugin.appbrand.jsapi.m;
import com.tencent.mm.plugin.appbrand.q;
import com.tencent.mm.plugin.downloader.model.f;
import com.tencent.mm.plugin.downloader.model.o;
import com.tencent.mm.plugin.downloader.model.o.a;
import com.tencent.mm.sdk.platformtools.ad;
import com.tencent.mm.sdk.platformtools.aj;
import com.tencent.mm.sdk.platformtools.bt;
import org.json.JSONObject;

public final class JsApiResumeDownloadTaskForNative
  extends com.tencent.mm.plugin.appbrand.jsapi.a<q>
{
  public static final int CTRL_INDEX = 660;
  public static final String NAME = "resumeDownloadTaskForNative";
  
  static class ResumeDownloadTask
    extends MainProcessTask
  {
    public static final Parcelable.Creator<ResumeDownloadTask> CREATOR;
    private int bZo;
    private q iDy;
    private boolean jAA;
    private m jxX;
    private boolean jyf;
    private String jyg;
    private long jyh;
    private boolean jzk;
    
    static
    {
      AppMethodBeat.i(45900);
      CREATOR = new Parcelable.Creator() {};
      AppMethodBeat.o(45900);
    }
    
    public ResumeDownloadTask(Parcel paramParcel)
    {
      AppMethodBeat.i(45895);
      e(paramParcel);
      AppMethodBeat.o(45895);
    }
    
    public ResumeDownloadTask(m paramm, q paramq, int paramInt, JSONObject paramJSONObject)
    {
      AppMethodBeat.i(45894);
      this.jxX = paramm;
      this.iDy = paramq;
      this.bZo = paramInt;
      this.jyh = paramJSONObject.optLong("downloadId");
      this.jAA = paramJSONObject.optBoolean("useDownloaderWidget", false);
      this.jzk = paramJSONObject.optBoolean("downloadInWifi", false);
      this.jyf = true;
      AppMethodBeat.o(45894);
    }
    
    public final void aEA()
    {
      AppMethodBeat.i(45897);
      if (this.jyf)
      {
        if (bt.isNullOrNil(this.jyg)) {}
        for (String str = "fail";; str = String.format("fail:%s", new Object[] { this.jyg }))
        {
          this.iDy.h(this.bZo, this.jxX.e(str, null));
          AppMethodBeat.o(45897);
          return;
        }
      }
      this.iDy.h(this.bZo, this.jxX.e("ok", null));
      AppMethodBeat.o(45897);
    }
    
    public final void aEz()
    {
      boolean bool = true;
      AppMethodBeat.i(45896);
      ad.i("MicroMsg.JsApiResumeDownloadTaskForNative", "doQueryDownloadTask, downloadId = %d", new Object[] { Long.valueOf(this.jyh) });
      if (this.jyh <= 0L) {
        this.jyg = "downloadId invalid";
      }
      for (;;)
      {
        aXw();
        AppMethodBeat.o(45896);
        return;
        if (!this.jAA) {
          break;
        }
        o.a(aj.getContext(), this.jyh, this.jzk, new o.a()
        {
          public final void f(String paramAnonymousString, JSONObject paramAnonymousJSONObject)
          {
            AppMethodBeat.i(45892);
            if (bt.isNullOrNil(paramAnonymousString))
            {
              JsApiResumeDownloadTaskForNative.ResumeDownloadTask.a(JsApiResumeDownloadTaskForNative.ResumeDownloadTask.this, false);
              AppMethodBeat.o(45892);
              return;
            }
            JsApiResumeDownloadTaskForNative.ResumeDownloadTask.a(JsApiResumeDownloadTaskForNative.ResumeDownloadTask.this, true);
            AppMethodBeat.o(45892);
          }
        });
        com.tencent.mm.modelstat.d.c(10, "JsApiResumeDownloadApp_resumeDownloadTask", hashCode());
      }
      com.tencent.mm.plugin.downloader.g.a locala = com.tencent.mm.plugin.downloader.model.d.oq(this.jyh);
      if (locala != null)
      {
        locala.field_downloadInWifi = false;
        locala.field_fromDownloadApp = false;
        locala.field_showNotification = true;
        com.tencent.mm.plugin.downloader.model.d.e(locala);
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
      AppMethodBeat.i(45898);
      this.jyh = paramParcel.readLong();
      if (paramParcel.readByte() == 1)
      {
        bool1 = true;
        this.jzk = bool1;
        if (paramParcel.readInt() != 1) {
          break label79;
        }
        bool1 = true;
        label40:
        this.jyf = bool1;
        this.jyg = paramParcel.readString();
        if (paramParcel.readInt() != 1) {
          break label84;
        }
      }
      label79:
      label84:
      for (boolean bool1 = bool2;; bool1 = false)
      {
        this.jAA = bool1;
        AppMethodBeat.o(45898);
        return;
        bool1 = false;
        break;
        bool1 = false;
        break label40;
      }
    }
    
    public void writeToParcel(Parcel paramParcel, int paramInt)
    {
      int i = 1;
      AppMethodBeat.i(45899);
      paramParcel.writeLong(this.jyh);
      byte b;
      if (this.jzk)
      {
        b = 1;
        paramParcel.writeByte(b);
        if (!this.jyf) {
          break label78;
        }
        paramInt = 1;
        label39:
        paramParcel.writeInt(paramInt);
        paramParcel.writeString(this.jyg);
        if (!this.jAA) {
          break label83;
        }
      }
      label78:
      label83:
      for (paramInt = i;; paramInt = 0)
      {
        paramParcel.writeInt(paramInt);
        AppMethodBeat.o(45899);
        return;
        b = 0;
        break;
        paramInt = 0;
        break label39;
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.jsapi.appdownload.JsApiResumeDownloadTaskForNative
 * JD-Core Version:    0.7.0.1
 */