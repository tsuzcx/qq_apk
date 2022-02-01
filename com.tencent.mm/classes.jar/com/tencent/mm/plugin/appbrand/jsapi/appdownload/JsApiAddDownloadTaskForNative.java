package com.tencent.mm.plugin.appbrand.jsapi.appdownload;

import android.content.Context;
import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.modelstat.d;
import com.tencent.mm.plugin.appbrand.ipc.MainProcessTask;
import com.tencent.mm.plugin.appbrand.jsapi.m;
import com.tencent.mm.plugin.appbrand.q;
import com.tencent.mm.plugin.downloader.model.f;
import com.tencent.mm.plugin.downloader.model.g.a;
import com.tencent.mm.plugin.downloader.model.o;
import com.tencent.mm.plugin.downloader.model.o.a;
import com.tencent.mm.sdk.platformtools.ad;
import com.tencent.mm.sdk.platformtools.aj;
import com.tencent.mm.sdk.platformtools.bt;
import java.util.HashMap;
import java.util.Map;
import org.json.JSONObject;

public final class JsApiAddDownloadTaskForNative
  extends com.tencent.mm.plugin.appbrand.jsapi.a<q>
{
  public static final int CTRL_INDEX = 655;
  public static final String NAME = "addDownloadTaskForNative";
  
  static class AddDownloadTask
    extends MainProcessTask
  {
    public static final Parcelable.Creator<AddDownloadTask> CREATOR;
    private int cgA;
    private JSONObject cgn;
    private q jwH;
    private m ksO;
    private String ksP;
    private String ksQ;
    private String ksR;
    private long ksT;
    private String ksU;
    private String ksV;
    private boolean ksW;
    private String ksX;
    private long ksY;
    private boolean kud;
    private int kvr;
    private boolean kvs;
    private String kvt;
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
    
    public AddDownloadTask(m paramm, q paramq, int paramInt, JSONObject paramJSONObject)
    {
      AppMethodBeat.i(45754);
      bhN();
      this.ksO = paramm;
      this.jwH = paramq;
      this.cgA = paramInt;
      this.cgn = paramJSONObject;
      this.ksP = paramJSONObject.optString("taskName");
      this.ksQ = paramJSONObject.optString("taskUrl");
      this.ksR = paramJSONObject.optString("fileMd5");
      this.ksT = paramJSONObject.optInt("taskSize", 0);
      this.ksU = paramJSONObject.optString("extInfo");
      this.ksV = paramJSONObject.optString("fileType");
      this.mAppId = paramJSONObject.optString("appId");
      this.mPackageName = paramJSONObject.optString("packageName");
      this.kud = paramJSONObject.optBoolean("downloadInWifi", false);
      this.kvr = paramJSONObject.optInt("downloaderType", 0);
      this.kvs = paramJSONObject.optBoolean("useDownloaderWidget", false);
      this.mScene = paramJSONObject.optInt("scene", 6001);
      this.kvt = paramJSONObject.optString("alterUrl");
      this.ksW = true;
      AppMethodBeat.o(45754);
    }
    
    public final void aOA()
    {
      AppMethodBeat.i(45756);
      com.tencent.mm.kernel.g.ajD();
      if (!com.tencent.mm.kernel.g.ajC().isSDCardAvailable()) {
        this.ksX = "fail_sdcard_not_ready";
      }
      for (;;)
      {
        bhX();
        AppMethodBeat.o(45756);
        return;
        if ((this.ksT > 0L) && (!com.tencent.mm.compatible.util.e.qR(this.ksT)))
        {
          this.ksX = "fail_sdcard_has_not_enough_space";
        }
        else if (bt.isNullOrNil(this.ksQ))
        {
          this.ksX = "fail_invalid_url";
        }
        else
        {
          if (this.kvs)
          {
            localObject = aj.getContext();
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
              locala.poy = localJSONObject.optString("alterUrl");
              locala.poA = localJSONObject.optLong("taskSize");
              locala.lMs = localJSONObject.optString("fileMd5");
              locala.extInfo = localJSONObject.optString("extInfo");
              locala.fileType = bt.getInt(localJSONObject.optString("fileType"), 0);
              locala.appId = localJSONObject.optString("appId");
              locala.poz = localJSONObject.optString("rawAppId");
              locala.packageName = localJSONObject.optString("packageName");
              locala.scene = localJSONObject.optInt("scene", 1000);
              locala.duJ = localJSONObject.optInt("downloaderType", 1);
              locala.pmV = localJSONObject.optBoolean("downloadInWifi", false);
            }
          }
          ad.i("MicroMsg.JsApiAddDownloadTaskForNative", "runInMainProcess taskUrl:%s md5:%s", new Object[] { this.ksQ, this.ksR });
          Object localObject = new g.a();
          ((g.a)localObject).aak(this.ksQ);
          ((g.a)localObject).ui(this.ksT);
          ((g.a)localObject).aam(this.ksP);
          ((g.a)localObject).aan(this.ksR);
          ((g.a)localObject).setAppId(this.mAppId);
          ((g.a)localObject).ft(this.mPackageName);
          ((g.a)localObject).jQ(true);
          ((g.a)localObject).Bp(bt.getInt(this.ksV, 1));
          ((g.a)localObject).setScene(this.mScene);
          ((g.a)localObject).aao(this.ksU);
          ((g.a)localObject).cct();
          ((g.a)localObject).aal(this.kvt);
          localObject = ((g.a)localObject).pmN;
          if (this.kvr == 1) {}
          for (long l = f.ccl().b((com.tencent.mm.plugin.downloader.model.g)localObject);; l = f.ccl().a((com.tencent.mm.plugin.downloader.model.g)localObject))
          {
            ad.i("MicroMsg.JsApiAddDownloadTaskForNative", "doAddDownloadTaskStraight, downloadId = ".concat(String.valueOf(l)));
            if (l > 0L) {
              break label517;
            }
            ad.e("MicroMsg.JsApiAddDownloadTaskForNative", "doAddDownloadTaskStraight fail, downloadId = ".concat(String.valueOf(l)));
            this.ksX = "";
            break;
          }
          label517:
          this.ksW = false;
          this.ksY = l;
        }
      }
    }
    
    public final void aOB()
    {
      AppMethodBeat.i(45757);
      bhO();
      if (this.ksW)
      {
        if (bt.isNullOrNil(this.ksX)) {}
        for (localObject = "fail";; localObject = String.format("fail:%s", new Object[] { this.ksX }))
        {
          this.jwH.h(this.cgA, this.ksO.e((String)localObject, null));
          AppMethodBeat.o(45757);
          return;
        }
      }
      Object localObject = new HashMap();
      ((Map)localObject).put("downloadId", Long.valueOf(this.ksY));
      this.jwH.h(this.cgA, this.ksO.m("ok", (Map)localObject));
      AppMethodBeat.o(45757);
    }
    
    public final void e(Parcel paramParcel)
    {
      boolean bool2 = true;
      AppMethodBeat.i(45758);
      this.ksP = paramParcel.readString();
      this.ksQ = paramParcel.readString();
      this.ksR = paramParcel.readString();
      this.ksT = paramParcel.readLong();
      this.ksU = paramParcel.readString();
      this.ksV = paramParcel.readString();
      this.mAppId = paramParcel.readString();
      this.mPackageName = paramParcel.readString();
      boolean bool1;
      if (paramParcel.readInt() == 1) {
        bool1 = true;
      }
      for (;;)
      {
        this.kud = bool1;
        this.kvr = paramParcel.readInt();
        if (paramParcel.readInt() == 1)
        {
          bool1 = true;
          label105:
          this.ksW = bool1;
          this.ksX = paramParcel.readString();
          this.ksY = paramParcel.readLong();
          this.mScene = paramParcel.readInt();
          if (paramParcel.readInt() != 1) {
            break label189;
          }
          bool1 = bool2;
          this.kvs = bool1;
        }
        try
        {
          this.cgn = new JSONObject(paramParcel.readString());
          this.kvt = paramParcel.readString();
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
            ad.d("MicroMsg.JsApiAddDownloadTaskForNative", localException.getMessage());
          }
        }
      }
    }
    
    public void writeToParcel(Parcel paramParcel, int paramInt)
    {
      int i = 1;
      AppMethodBeat.i(45759);
      paramParcel.writeString(this.ksP);
      paramParcel.writeString(this.ksQ);
      paramParcel.writeString(this.ksR);
      paramParcel.writeLong(this.ksT);
      paramParcel.writeString(this.ksU);
      paramParcel.writeString(this.ksV);
      paramParcel.writeString(this.mAppId);
      paramParcel.writeString(this.mPackageName);
      if (this.kud)
      {
        paramInt = 1;
        paramParcel.writeInt(paramInt);
        paramParcel.writeInt(this.kvr);
        if (!this.ksW) {
          break label188;
        }
        paramInt = 1;
        label103:
        paramParcel.writeInt(paramInt);
        paramParcel.writeString(this.ksX);
        paramParcel.writeLong(this.ksY);
        paramParcel.writeInt(this.mScene);
        if (!this.kvs) {
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
        paramParcel.writeString(this.kvt);
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