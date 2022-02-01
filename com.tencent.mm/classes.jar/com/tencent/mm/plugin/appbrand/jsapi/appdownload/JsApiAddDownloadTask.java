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

public final class JsApiAddDownloadTask
  extends a<r>
{
  public static final int CTRL_INDEX = 474;
  public static final String NAME = "addDownloadTask";
  
  static class AddDownloadTask
    extends MainProcessTask
  {
    public static final Parcelable.Creator<AddDownloadTask> CREATOR;
    private int cgA;
    private r jzD;
    private m kwe;
    private String kwf;
    private String kwg;
    private String kwh;
    private long kwj;
    private String kwk;
    private String kwl;
    private boolean kwm;
    private String kwn;
    private long kwo;
    private boolean kxt;
    private boolean kyF;
    private int kyG;
    private String mAppId;
    private String mPackageName;
    
    static
    {
      AppMethodBeat.i(45750);
      CREATOR = new Parcelable.Creator() {};
      AppMethodBeat.o(45750);
    }
    
    public AddDownloadTask(Parcel paramParcel)
    {
      AppMethodBeat.i(45745);
      e(paramParcel);
      AppMethodBeat.o(45745);
    }
    
    public AddDownloadTask(m paramm, r paramr, int paramInt, JSONObject paramJSONObject)
    {
      AppMethodBeat.i(45744);
      biw();
      this.kwe = paramm;
      this.jzD = paramr;
      this.cgA = paramInt;
      this.kwf = paramJSONObject.optString("taskName");
      this.kwg = paramJSONObject.optString("taskUrl");
      this.kwh = paramJSONObject.optString("fileMd5");
      this.kwj = paramJSONObject.optInt("taskSize", 0);
      this.kwk = paramJSONObject.optString("extInfo");
      this.kwl = paramJSONObject.optString("fileType");
      this.mAppId = paramJSONObject.optString("appId");
      this.mPackageName = paramJSONObject.optString("packageName");
      this.kxt = paramJSONObject.optBoolean("downloadInWifi", false);
      this.kyF = paramJSONObject.optBoolean("showNotification", false);
      this.kyG = paramJSONObject.optInt("downloaderType", 0);
      this.kwm = true;
      AppMethodBeat.o(45744);
    }
    
    public final void aOX()
    {
      AppMethodBeat.i(45746);
      com.tencent.mm.kernel.g.ajS();
      if (!com.tencent.mm.kernel.g.ajR().isSDCardAvailable()) {
        this.kwn = "fail_sdcard_not_ready";
      }
      for (;;)
      {
        biG();
        AppMethodBeat.o(45746);
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
          ae.i("MicroMsg.JsApiAddDownloadTask", "runInMainProcess taskUrl:%s md5:%s", new Object[] { this.kwg, this.kwh });
          Object localObject = new g.a();
          ((g.a)localObject).abb(this.kwg);
          ((g.a)localObject).uz(this.kwj);
          ((g.a)localObject).abd(this.kwf);
          ((g.a)localObject).abe(this.kwh);
          ((g.a)localObject).setAppId(this.mAppId);
          ((g.a)localObject).fz(this.mPackageName);
          ((g.a)localObject).jP(true);
          ((g.a)localObject).BB(bu.getInt(this.kwl, 1));
          ((g.a)localObject).setScene(6001);
          ((g.a)localObject).abf(this.kwk);
          ((g.a)localObject).jQ(this.kyF);
          ((g.a)localObject).jS(this.kxt);
          ((g.a)localObject).jP(false);
          ((g.a)localObject).cdI();
          localObject = ((g.a)localObject).ptu;
          if (this.kyG == 1) {}
          for (long l = f.cdA().b((com.tencent.mm.plugin.downloader.model.g)localObject);; l = f.cdA().a((com.tencent.mm.plugin.downloader.model.g)localObject))
          {
            ae.i("MicroMsg.JsApiAddDownloadTask", "doAddDownloadTaskStraight, downloadId = ".concat(String.valueOf(l)));
            if (l > 0L) {
              break label297;
            }
            ae.e("MicroMsg.JsApiAddDownloadTask", "doAddDownloadTaskStraight fail, downloadId = ".concat(String.valueOf(l)));
            this.kwn = "";
            break;
          }
          label297:
          this.kwm = false;
          this.kwo = l;
        }
      }
    }
    
    public final void aOY()
    {
      AppMethodBeat.i(45747);
      bix();
      if (this.kwm)
      {
        if (bu.isNullOrNil(this.kwn)) {}
        for (localObject = "fail";; localObject = String.format("fail:%s", new Object[] { this.kwn }))
        {
          this.jzD.h(this.cgA, this.kwe.e((String)localObject, null));
          AppMethodBeat.o(45747);
          return;
        }
      }
      Object localObject = new HashMap();
      ((Map)localObject).put("downloadId", Long.valueOf(this.kwo));
      this.jzD.h(this.cgA, this.kwe.n("ok", (Map)localObject));
      AppMethodBeat.o(45747);
    }
    
    public final void e(Parcel paramParcel)
    {
      boolean bool2 = true;
      AppMethodBeat.i(45748);
      this.kwf = paramParcel.readString();
      this.kwg = paramParcel.readString();
      this.kwh = paramParcel.readString();
      this.kwj = paramParcel.readLong();
      this.kwk = paramParcel.readString();
      this.kwl = paramParcel.readString();
      this.mAppId = paramParcel.readString();
      this.mPackageName = paramParcel.readString();
      if (paramParcel.readByte() == 1)
      {
        bool1 = true;
        this.kxt = bool1;
        if (paramParcel.readByte() != 1) {
          break label153;
        }
        bool1 = true;
        label97:
        this.kyF = bool1;
        this.kyG = paramParcel.readInt();
        if (paramParcel.readInt() != 1) {
          break label158;
        }
      }
      label153:
      label158:
      for (boolean bool1 = bool2;; bool1 = false)
      {
        this.kwm = bool1;
        this.kwn = paramParcel.readString();
        this.kwo = paramParcel.readLong();
        AppMethodBeat.o(45748);
        return;
        bool1 = false;
        break;
        bool1 = false;
        break label97;
      }
    }
    
    public void writeToParcel(Parcel paramParcel, int paramInt)
    {
      paramInt = 1;
      AppMethodBeat.i(45749);
      paramParcel.writeString(this.kwf);
      paramParcel.writeString(this.kwg);
      paramParcel.writeString(this.kwh);
      paramParcel.writeLong(this.kwj);
      paramParcel.writeString(this.kwk);
      paramParcel.writeString(this.kwl);
      paramParcel.writeString(this.mAppId);
      paramParcel.writeString(this.mPackageName);
      byte b;
      if (this.kxt)
      {
        b = 1;
        paramParcel.writeByte(b);
        if (!this.kyF) {
          break label148;
        }
        b = 1;
        label95:
        paramParcel.writeByte(b);
        paramParcel.writeInt(this.kyG);
        if (!this.kwm) {
          break label153;
        }
      }
      for (;;)
      {
        paramParcel.writeInt(paramInt);
        paramParcel.writeString(this.kwn);
        paramParcel.writeLong(this.kwo);
        AppMethodBeat.o(45749);
        return;
        b = 0;
        break;
        label148:
        b = 0;
        break label95;
        label153:
        paramInt = 0;
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.jsapi.appdownload.JsApiAddDownloadTask
 * JD-Core Version:    0.7.0.1
 */