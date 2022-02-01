package com.tencent.mm.plugin.appbrand.jsapi.appdownload;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.appbrand.ipc.MainProcessTask;
import com.tencent.mm.plugin.appbrand.jsapi.m;
import com.tencent.mm.plugin.appbrand.r;
import com.tencent.mm.plugin.downloader.model.f;
import com.tencent.mm.plugin.downloader.model.o;
import com.tencent.mm.plugin.downloader.model.o.a;
import com.tencent.mm.sdk.platformtools.ae;
import com.tencent.mm.sdk.platformtools.ak;
import com.tencent.mm.sdk.platformtools.bu;
import org.json.JSONObject;

public final class JsApiResumeDownloadTaskForNative
  extends com.tencent.mm.plugin.appbrand.jsapi.a<r>
{
  public static final int CTRL_INDEX = 660;
  public static final String NAME = "resumeDownloadTaskForNative";
  
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
    private boolean kyH;
    
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
    
    public ResumeDownloadTask(m paramm, r paramr, int paramInt, JSONObject paramJSONObject)
    {
      AppMethodBeat.i(45894);
      this.kwe = paramm;
      this.jzD = paramr;
      this.cgA = paramInt;
      this.kwo = paramJSONObject.optLong("downloadId");
      this.kyH = paramJSONObject.optBoolean("useDownloaderWidget", false);
      this.kxt = paramJSONObject.optBoolean("downloadInWifi", false);
      this.kwm = true;
      AppMethodBeat.o(45894);
    }
    
    public final void aOX()
    {
      boolean bool = true;
      AppMethodBeat.i(45896);
      ae.i("MicroMsg.JsApiResumeDownloadTaskForNative", "doQueryDownloadTask, downloadId = %d", new Object[] { Long.valueOf(this.kwo) });
      if (this.kwo <= 0L) {
        this.kwn = "downloadId invalid";
      }
      for (;;)
      {
        biG();
        AppMethodBeat.o(45896);
        return;
        if (!this.kyH) {
          break;
        }
        o.a(ak.getContext(), this.kwo, this.kxt, new o.a()
        {
          public final void f(String paramAnonymousString, JSONObject paramAnonymousJSONObject)
          {
            AppMethodBeat.i(45892);
            if (bu.isNullOrNil(paramAnonymousString))
            {
              JsApiResumeDownloadTaskForNative.ResumeDownloadTask.a(JsApiResumeDownloadTaskForNative.ResumeDownloadTask.this, false);
              AppMethodBeat.o(45892);
              return;
            }
            JsApiResumeDownloadTaskForNative.ResumeDownloadTask.a(JsApiResumeDownloadTaskForNative.ResumeDownloadTask.this, true);
            AppMethodBeat.o(45892);
          }
        });
        com.tencent.mm.modelstat.d.d(10, "JsApiResumeDownloadApp_resumeDownloadTask", hashCode());
      }
      com.tencent.mm.plugin.downloader.g.a locala = com.tencent.mm.plugin.downloader.model.d.ur(this.kwo);
      if (locala != null)
      {
        locala.field_downloadInWifi = false;
        locala.field_fromDownloadApp = false;
        locala.field_showNotification = true;
        com.tencent.mm.plugin.downloader.model.d.e(locala);
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
      AppMethodBeat.i(45897);
      if (this.kwm)
      {
        if (bu.isNullOrNil(this.kwn)) {}
        for (String str = "fail";; str = String.format("fail:%s", new Object[] { this.kwn }))
        {
          this.jzD.h(this.cgA, this.kwe.e(str, null));
          AppMethodBeat.o(45897);
          return;
        }
      }
      this.jzD.h(this.cgA, this.kwe.e("ok", null));
      AppMethodBeat.o(45897);
    }
    
    public final void e(Parcel paramParcel)
    {
      boolean bool2 = true;
      AppMethodBeat.i(45898);
      this.kwo = paramParcel.readLong();
      if (paramParcel.readByte() == 1)
      {
        bool1 = true;
        this.kxt = bool1;
        if (paramParcel.readInt() != 1) {
          break label79;
        }
        bool1 = true;
        label40:
        this.kwm = bool1;
        this.kwn = paramParcel.readString();
        if (paramParcel.readInt() != 1) {
          break label84;
        }
      }
      label79:
      label84:
      for (boolean bool1 = bool2;; bool1 = false)
      {
        this.kyH = bool1;
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
      paramParcel.writeLong(this.kwo);
      byte b;
      if (this.kxt)
      {
        b = 1;
        paramParcel.writeByte(b);
        if (!this.kwm) {
          break label78;
        }
        paramInt = 1;
        label39:
        paramParcel.writeInt(paramInt);
        paramParcel.writeString(this.kwn);
        if (!this.kyH) {
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