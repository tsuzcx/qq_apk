package com.tencent.mm.plugin.appbrand.jsapi.appdownload;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.appbrand.ipc.MainProcessTask;
import com.tencent.mm.plugin.appbrand.jsapi.a;
import com.tencent.mm.plugin.appbrand.jsapi.m;
import com.tencent.mm.plugin.appbrand.r;
import com.tencent.mm.plugin.downloader.model.f;
import com.tencent.mm.plugin.downloader.model.g.a;
import com.tencent.mm.sdk.platformtools.ae;
import com.tencent.mm.sdk.platformtools.bu;
import java.util.HashMap;
import java.util.Map;
import org.json.JSONObject;

public final class JsApiAddDownloadTaskStraight
  extends a<r>
{
  public static final int CTRL_INDEX = 440;
  public static final String NAME = "addDownloadTaskStraight";
  
  static class AddDownloadTaskStraightTask
    extends MainProcessTask
  {
    public static final Parcelable.Creator<AddDownloadTaskStraightTask> CREATOR;
    private int cgA;
    private r jzD;
    private m kwe;
    private String kwf;
    private String kwg;
    private String kwh;
    private String kwi;
    private long kwj;
    private String kwk;
    private String kwl;
    private boolean kwm;
    private String kwn;
    private long kwo;
    private String mAppId;
    private String mPackageName;
    
    static
    {
      AppMethodBeat.i(45769);
      CREATOR = new Parcelable.Creator() {};
      AppMethodBeat.o(45769);
    }
    
    public AddDownloadTaskStraightTask(Parcel paramParcel)
    {
      AppMethodBeat.i(45764);
      e(paramParcel);
      AppMethodBeat.o(45764);
    }
    
    public AddDownloadTaskStraightTask(m paramm, r paramr, int paramInt, JSONObject paramJSONObject)
    {
      AppMethodBeat.i(45763);
      this.kwe = paramm;
      this.jzD = paramr;
      this.cgA = paramInt;
      this.kwf = paramJSONObject.optString("taskName");
      this.kwg = paramJSONObject.optString("taskUrl");
      this.kwh = paramJSONObject.optString("fileMd5");
      this.kwi = paramJSONObject.optString("alternativeUrl");
      this.kwj = paramJSONObject.optInt("taskSize", 0);
      this.kwk = paramJSONObject.optString("extInfo");
      this.kwl = paramJSONObject.optString("fileType");
      this.mAppId = paramr.getAppId();
      this.mPackageName = paramJSONObject.optString("packageName");
      this.kwm = true;
      AppMethodBeat.o(45763);
    }
    
    public final void aOX()
    {
      AppMethodBeat.i(45765);
      com.tencent.mm.kernel.g.ajS();
      if (!com.tencent.mm.kernel.g.ajR().isSDCardAvailable()) {
        this.kwn = "fail_sdcard_not_ready";
      }
      for (;;)
      {
        biG();
        AppMethodBeat.o(45765);
        return;
        if ((this.kwj > 0L) && (!com.tencent.mm.compatible.util.e.re(this.kwj)))
        {
          this.kwn = "fail_sdcard_has_not_enough_space";
        }
        else if (bu.isNullOrNil(this.kwg))
        {
          this.kwn = "fail_invalid_url";
        }
        else
        {
          ae.i("MicroMsg.JsApiAddDownloadTaskStraight", "runInMainProcess taskUrl:%s md5:%s", new Object[] { this.kwg, this.kwh });
          Object localObject = new g.a();
          ((g.a)localObject).abb(this.kwg);
          ((g.a)localObject).abc(this.kwi);
          ((g.a)localObject).uz(this.kwj);
          ((g.a)localObject).abd(this.kwf);
          ((g.a)localObject).abe(this.kwh);
          ((g.a)localObject).setAppId(this.mAppId);
          ((g.a)localObject).fz(this.mPackageName);
          ((g.a)localObject).jP(true);
          ((g.a)localObject).BB(bu.getInt(this.kwl, 1));
          ((g.a)localObject).setScene(6001);
          ((g.a)localObject).abf(this.kwk);
          localObject = ((g.a)localObject).ptu;
          long l = f.cdA().a((com.tencent.mm.plugin.downloader.model.g)localObject);
          ae.i("MicroMsg.JsApiAddDownloadTaskStraight", "doAddDownloadTaskStraight, downloadId = ".concat(String.valueOf(l)));
          if (l <= 0L)
          {
            ae.e("MicroMsg.JsApiAddDownloadTaskStraight", "doAddDownloadTaskStraight fail, downloadId = ".concat(String.valueOf(l)));
            this.kwn = "";
          }
          else
          {
            this.kwm = false;
            this.kwo = l;
          }
        }
      }
    }
    
    public final void aOY()
    {
      AppMethodBeat.i(45766);
      if (this.kwm)
      {
        if (bu.isNullOrNil(this.kwn)) {}
        for (localObject = "fail";; localObject = String.format("fail:%s", new Object[] { this.kwn }))
        {
          this.jzD.h(this.cgA, this.kwe.e((String)localObject, null));
          AppMethodBeat.o(45766);
          return;
        }
      }
      Object localObject = new HashMap();
      ((Map)localObject).put("downloadId", Long.valueOf(this.kwo));
      this.jzD.h(this.cgA, this.kwe.n("ok", (Map)localObject));
      AppMethodBeat.o(45766);
    }
    
    public final void e(Parcel paramParcel)
    {
      boolean bool = true;
      AppMethodBeat.i(45767);
      this.kwf = paramParcel.readString();
      this.kwg = paramParcel.readString();
      this.kwh = paramParcel.readString();
      this.kwi = paramParcel.readString();
      this.kwj = paramParcel.readLong();
      this.kwk = paramParcel.readString();
      this.kwl = paramParcel.readString();
      this.mAppId = paramParcel.readString();
      this.mPackageName = paramParcel.readString();
      if (paramParcel.readInt() == 1) {}
      for (;;)
      {
        this.kwm = bool;
        this.kwn = paramParcel.readString();
        this.kwo = paramParcel.readLong();
        AppMethodBeat.o(45767);
        return;
        bool = false;
      }
    }
    
    public void writeToParcel(Parcel paramParcel, int paramInt)
    {
      AppMethodBeat.i(45768);
      paramParcel.writeString(this.kwf);
      paramParcel.writeString(this.kwg);
      paramParcel.writeString(this.kwh);
      paramParcel.writeString(this.kwi);
      paramParcel.writeLong(this.kwj);
      paramParcel.writeString(this.kwk);
      paramParcel.writeString(this.kwl);
      paramParcel.writeString(this.mAppId);
      paramParcel.writeString(this.mPackageName);
      if (this.kwm) {}
      for (paramInt = 1;; paramInt = 0)
      {
        paramParcel.writeInt(paramInt);
        paramParcel.writeString(this.kwn);
        paramParcel.writeLong(this.kwo);
        AppMethodBeat.o(45768);
        return;
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.jsapi.appdownload.JsApiAddDownloadTaskStraight
 * JD-Core Version:    0.7.0.1
 */