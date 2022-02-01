package com.tencent.mm.plugin.appbrand.jsapi.appdownload;

import android.content.Context;
import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.modelstat.d;
import com.tencent.mm.plugin.appbrand.ipc.MainProcessTask;
import com.tencent.mm.plugin.appbrand.jsapi.m;
import com.tencent.mm.plugin.appbrand.r;
import com.tencent.mm.plugin.downloader.model.f;
import com.tencent.mm.plugin.downloader.model.g.a;
import com.tencent.mm.plugin.downloader.model.o;
import com.tencent.mm.plugin.downloader.model.o.a;
import com.tencent.mm.sdk.platformtools.ae;
import com.tencent.mm.sdk.platformtools.ak;
import com.tencent.mm.sdk.platformtools.bu;
import java.util.HashMap;
import java.util.Map;
import org.json.JSONObject;

public final class JsApiAddDownloadTaskForNative
  extends com.tencent.mm.plugin.appbrand.jsapi.a<r>
{
  public static final int CTRL_INDEX = 655;
  public static final String NAME = "addDownloadTaskForNative";
  
  static class AddDownloadTask
    extends MainProcessTask
  {
    public static final Parcelable.Creator<AddDownloadTask> CREATOR;
    private int cgA;
    private JSONObject cgn;
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
    private int kyG;
    private boolean kyH;
    private String kyI;
    private String mAppId;
    private String mPackageName;
    private int mScene;
    
    static
    {
      AppMethodBeat.i(45760);
      CREATOR = new Parcelable.Creator() {};
      AppMethodBeat.o(45760);
    }
    
    public AddDownloadTask(Parcel paramParcel)
    {
      AppMethodBeat.i(45755);
      e(paramParcel);
      AppMethodBeat.o(45755);
    }
    
    public AddDownloadTask(m paramm, r paramr, int paramInt, JSONObject paramJSONObject)
    {
      AppMethodBeat.i(45754);
      biw();
      this.kwe = paramm;
      this.jzD = paramr;
      this.cgA = paramInt;
      this.cgn = paramJSONObject;
      this.kwf = paramJSONObject.optString("taskName");
      this.kwg = paramJSONObject.optString("taskUrl");
      this.kwh = paramJSONObject.optString("fileMd5");
      this.kwj = paramJSONObject.optInt("taskSize", 0);
      this.kwk = paramJSONObject.optString("extInfo");
      this.kwl = paramJSONObject.optString("fileType");
      this.mAppId = paramJSONObject.optString("appId");
      this.mPackageName = paramJSONObject.optString("packageName");
      this.kxt = paramJSONObject.optBoolean("downloadInWifi", false);
      this.kyG = paramJSONObject.optInt("downloaderType", 0);
      this.kyH = paramJSONObject.optBoolean("useDownloaderWidget", false);
      this.mScene = paramJSONObject.optInt("scene", 6001);
      this.kyI = paramJSONObject.optString("alterUrl");
      this.kwm = true;
      AppMethodBeat.o(45754);
    }
    
    public final void aOX()
    {
      AppMethodBeat.i(45756);
      com.tencent.mm.kernel.g.ajS();
      if (!com.tencent.mm.kernel.g.ajR().isSDCardAvailable()) {
        this.kwn = "fail_sdcard_not_ready";
      }
      for (;;)
      {
        biG();
        AppMethodBeat.o(45756);
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
          if (this.kyH)
          {
            localObject = ak.getContext();
            JSONObject localJSONObject = this.cgn;
            com.tencent.mm.plugin.downloader_app.a.a locala = new com.tencent.mm.plugin.downloader_app.a.a();
            if (localJSONObject == null) {}
            for (;;)
            {
              o.a((Context)localObject, locala, new o.a()
              {
                public final void f(String paramAnonymousString, JSONObject paramAnonymousJSONObject)
                {
                  AppMethodBeat.i(45752);
                  if (paramAnonymousJSONObject == null)
                  {
                    JsApiAddDownloadTaskForNative.AddDownloadTask.a(JsApiAddDownloadTaskForNative.AddDownloadTask.this, true);
                    AppMethodBeat.o(45752);
                    return;
                  }
                  JsApiAddDownloadTaskForNative.AddDownloadTask.a(JsApiAddDownloadTaskForNative.AddDownloadTask.this, paramAnonymousJSONObject.optInt("download_id", -1));
                  if (JsApiAddDownloadTaskForNative.AddDownloadTask.a(JsApiAddDownloadTaskForNative.AddDownloadTask.this) <= 0L)
                  {
                    JsApiAddDownloadTaskForNative.AddDownloadTask.a(JsApiAddDownloadTaskForNative.AddDownloadTask.this, true);
                    AppMethodBeat.o(45752);
                    return;
                  }
                  JsApiAddDownloadTaskForNative.AddDownloadTask.a(JsApiAddDownloadTaskForNative.AddDownloadTask.this, false);
                  AppMethodBeat.o(45752);
                }
              });
              d.d(10, "JsApiAddDownloadTaskForNative", hashCode());
              break;
              locala.appName = localJSONObject.optString("taskName");
              locala.downloadUrl = localJSONObject.optString("taskUrl");
              locala.pve = localJSONObject.optString("alterUrl");
              locala.pvg = localJSONObject.optLong("taskSize");
              locala.lQS = localJSONObject.optString("fileMd5");
              locala.extInfo = localJSONObject.optString("extInfo");
              locala.fileType = bu.getInt(localJSONObject.optString("fileType"), 0);
              locala.appId = localJSONObject.optString("appId");
              locala.pvf = localJSONObject.optString("rawAppId");
              locala.packageName = localJSONObject.optString("packageName");
              locala.scene = localJSONObject.optInt("scene", 1000);
              locala.dvO = localJSONObject.optInt("downloaderType", 1);
              locala.ptC = localJSONObject.optBoolean("downloadInWifi", false);
            }
          }
          ae.i("MicroMsg.JsApiAddDownloadTaskForNative", "runInMainProcess taskUrl:%s md5:%s", new Object[] { this.kwg, this.kwh });
          Object localObject = new g.a();
          ((g.a)localObject).abb(this.kwg);
          ((g.a)localObject).uz(this.kwj);
          ((g.a)localObject).abd(this.kwf);
          ((g.a)localObject).abe(this.kwh);
          ((g.a)localObject).setAppId(this.mAppId);
          ((g.a)localObject).fz(this.mPackageName);
          ((g.a)localObject).jP(true);
          ((g.a)localObject).BB(bu.getInt(this.kwl, 1));
          ((g.a)localObject).setScene(this.mScene);
          ((g.a)localObject).abf(this.kwk);
          ((g.a)localObject).cdI();
          ((g.a)localObject).abc(this.kyI);
          localObject = ((g.a)localObject).ptu;
          if (this.kyG == 1) {}
          for (long l = f.cdA().b((com.tencent.mm.plugin.downloader.model.g)localObject);; l = f.cdA().a((com.tencent.mm.plugin.downloader.model.g)localObject))
          {
            ae.i("MicroMsg.JsApiAddDownloadTaskForNative", "doAddDownloadTaskStraight, downloadId = ".concat(String.valueOf(l)));
            if (l > 0L) {
              break label517;
            }
            ae.e("MicroMsg.JsApiAddDownloadTaskForNative", "doAddDownloadTaskStraight fail, downloadId = ".concat(String.valueOf(l)));
            this.kwn = "";
            break;
          }
          label517:
          this.kwm = false;
          this.kwo = l;
        }
      }
    }
    
    public final void aOY()
    {
      AppMethodBeat.i(45757);
      bix();
      if (this.kwm)
      {
        if (bu.isNullOrNil(this.kwn)) {}
        for (localObject = "fail";; localObject = String.format("fail:%s", new Object[] { this.kwn }))
        {
          this.jzD.h(this.cgA, this.kwe.e((String)localObject, null));
          AppMethodBeat.o(45757);
          return;
        }
      }
      Object localObject = new HashMap();
      ((Map)localObject).put("downloadId", Long.valueOf(this.kwo));
      this.jzD.h(this.cgA, this.kwe.n("ok", (Map)localObject));
      AppMethodBeat.o(45757);
    }
    
    public final void e(Parcel paramParcel)
    {
      boolean bool2 = true;
      AppMethodBeat.i(45758);
      this.kwf = paramParcel.readString();
      this.kwg = paramParcel.readString();
      this.kwh = paramParcel.readString();
      this.kwj = paramParcel.readLong();
      this.kwk = paramParcel.readString();
      this.kwl = paramParcel.readString();
      this.mAppId = paramParcel.readString();
      this.mPackageName = paramParcel.readString();
      boolean bool1;
      if (paramParcel.readInt() == 1) {
        bool1 = true;
      }
      for (;;)
      {
        this.kxt = bool1;
        this.kyG = paramParcel.readInt();
        if (paramParcel.readInt() == 1)
        {
          bool1 = true;
          label105:
          this.kwm = bool1;
          this.kwn = paramParcel.readString();
          this.kwo = paramParcel.readLong();
          this.mScene = paramParcel.readInt();
          if (paramParcel.readInt() != 1) {
            break label189;
          }
          bool1 = bool2;
          this.kyH = bool1;
        }
        try
        {
          this.cgn = new JSONObject(paramParcel.readString());
          this.kyI = paramParcel.readString();
          AppMethodBeat.o(45758);
          return;
          bool1 = false;
          continue;
          bool1 = false;
          break label105;
          label189:
          bool1 = false;
        }
        catch (Exception localException)
        {
          for (;;)
          {
            ae.d("MicroMsg.JsApiAddDownloadTaskForNative", localException.getMessage());
          }
        }
      }
    }
    
    public void writeToParcel(Parcel paramParcel, int paramInt)
    {
      int i = 1;
      AppMethodBeat.i(45759);
      paramParcel.writeString(this.kwf);
      paramParcel.writeString(this.kwg);
      paramParcel.writeString(this.kwh);
      paramParcel.writeLong(this.kwj);
      paramParcel.writeString(this.kwk);
      paramParcel.writeString(this.kwl);
      paramParcel.writeString(this.mAppId);
      paramParcel.writeString(this.mPackageName);
      if (this.kxt)
      {
        paramInt = 1;
        paramParcel.writeInt(paramInt);
        paramParcel.writeInt(this.kyG);
        if (!this.kwm) {
          break label188;
        }
        paramInt = 1;
        label103:
        paramParcel.writeInt(paramInt);
        paramParcel.writeString(this.kwn);
        paramParcel.writeLong(this.kwo);
        paramParcel.writeInt(this.mScene);
        if (!this.kyH) {
          break label193;
        }
        paramInt = i;
        label141:
        paramParcel.writeInt(paramInt);
        if (this.cgn == null) {
          break label198;
        }
      }
      label188:
      label193:
      label198:
      for (String str = this.cgn.toString();; str = "")
      {
        paramParcel.writeString(str);
        paramParcel.writeString(this.kyI);
        AppMethodBeat.o(45759);
        return;
        paramInt = 0;
        break;
        paramInt = 0;
        break label103;
        paramInt = 0;
        break label141;
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.jsapi.appdownload.JsApiAddDownloadTaskForNative
 * JD-Core Version:    0.7.0.1
 */