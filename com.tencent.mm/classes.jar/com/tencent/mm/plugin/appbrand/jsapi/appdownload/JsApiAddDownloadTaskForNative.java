package com.tencent.mm.plugin.appbrand.jsapi.appdownload;

import android.content.Context;
import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.appbrand.ipc.MainProcessTask;
import com.tencent.mm.plugin.appbrand.jsapi.p;
import com.tencent.mm.plugin.appbrand.s;
import com.tencent.mm.plugin.downloader.model.f;
import com.tencent.mm.plugin.downloader.model.g.a;
import com.tencent.mm.plugin.downloader.model.o;
import com.tencent.mm.plugin.downloader.model.o.a;
import com.tencent.mm.plugin.downloader_app.a.a;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.MMApplicationContext;
import com.tencent.mm.sdk.platformtools.Util;
import java.util.HashMap;
import java.util.Map;
import org.json.JSONObject;

public final class JsApiAddDownloadTaskForNative
  extends com.tencent.mm.plugin.appbrand.jsapi.d<s>
{
  public static final int CTRL_INDEX = 655;
  public static final String NAME = "addDownloadTaskForNative";
  
  static class AddDownloadTask
    extends MainProcessTask
  {
    public static final Parcelable.Creator<AddDownloadTask> CREATOR;
    private JSONObject csi;
    private int csv;
    private s kAr;
    private p lAi;
    private String lAj;
    private String lAk;
    private String lAl;
    private long lAn;
    private String lAo;
    private String lAp;
    private boolean lAq;
    private String lAr;
    private long lAs;
    private boolean lBG;
    private int lCZ;
    private boolean lDa;
    private String lDb;
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
      f(paramParcel);
      AppMethodBeat.o(45755);
    }
    
    public AddDownloadTask(p paramp, s params, int paramInt, JSONObject paramJSONObject)
    {
      AppMethodBeat.i(45754);
      bDJ();
      this.lAi = paramp;
      this.kAr = params;
      this.csv = paramInt;
      this.csi = paramJSONObject;
      this.lAj = paramJSONObject.optString("taskName");
      this.lAk = paramJSONObject.optString("taskUrl");
      this.lAl = paramJSONObject.optString("fileMd5");
      this.lAn = paramJSONObject.optInt("taskSize", 0);
      this.lAo = paramJSONObject.optString("extInfo");
      this.lAp = paramJSONObject.optString("fileType");
      this.mAppId = paramJSONObject.optString("appId");
      this.mPackageName = paramJSONObject.optString("packageName");
      this.lBG = paramJSONObject.optBoolean("downloadInWifi", false);
      this.lCZ = paramJSONObject.optInt("downloaderType", 0);
      this.lDa = paramJSONObject.optBoolean("useDownloaderWidget", false);
      this.mScene = paramJSONObject.optInt("scene", 6001);
      this.lDb = paramJSONObject.optString("alterUrl");
      this.lAq = true;
      AppMethodBeat.o(45754);
    }
    
    public final void bjj()
    {
      boolean bool = true;
      AppMethodBeat.i(45756);
      com.tencent.mm.kernel.g.aAi();
      if (!com.tencent.mm.kernel.g.aAh().isSDCardAvailable()) {
        this.lAr = "fail_sdcard_not_ready";
      }
      for (;;)
      {
        bDU();
        AppMethodBeat.o(45756);
        return;
        if ((this.lAn > 0L) && (!com.tencent.mm.compatible.util.e.yV(this.lAn)))
        {
          this.lAr = "fail_sdcard_has_not_enough_space";
        }
        else if (Util.isNullOrNil(this.lAk))
        {
          this.lAr = "fail_invalid_url";
        }
        else
        {
          Object localObject;
          if (this.lDa)
          {
            localObject = MMApplicationContext.getContext();
            JSONObject localJSONObject = this.csi;
            a locala = new a();
            if (localJSONObject == null)
            {
              o.a((Context)localObject, locala, new o.a()
              {
                public final void i(String paramAnonymousString, JSONObject paramAnonymousJSONObject)
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
              com.tencent.mm.modelstat.d.d(10, "JsApiAddDownloadTaskForNative", hashCode());
            }
            else
            {
              locala.appName = localJSONObject.optString("taskName");
              locala.downloadUrl = localJSONObject.optString("taskUrl");
              locala.qKt = localJSONObject.optString("alterUrl");
              locala.qKv = localJSONObject.optLong("taskSize");
              locala.mYc = localJSONObject.optString("fileMd5");
              locala.extInfo = localJSONObject.optString("extInfo");
              locala.fileType = Util.getInt(localJSONObject.optString("fileType"), 0);
              locala.appId = localJSONObject.optString("appId");
              locala.qKu = localJSONObject.optString("rawAppId");
              locala.packageName = localJSONObject.optString("packageName");
              locala.scene = localJSONObject.optInt("scene", 1000);
              locala.dNv = localJSONObject.optInt("downloaderType", 1);
              locala.qJg = localJSONObject.optBoolean("downloadInWifi", false);
              if (localJSONObject.optInt("ignoreNetwork", 0) == 1) {}
              for (;;)
              {
                locala.qKA = bool;
                break;
                bool = false;
              }
            }
          }
          else
          {
            Log.i("MicroMsg.JsApiAddDownloadTaskForNative", "runInMainProcess taskUrl:%s md5:%s", new Object[] { this.lAk, this.lAl });
            localObject = new g.a();
            ((g.a)localObject).alj(this.lAk);
            ((g.a)localObject).setFileSize(this.lAn);
            ((g.a)localObject).all(this.lAj);
            ((g.a)localObject).setFileMD5(this.lAl);
            ((g.a)localObject).setAppId(this.mAppId);
            ((g.a)localObject).gm(this.mPackageName);
            ((g.a)localObject).kS(true);
            ((g.a)localObject).Fl(Util.getInt(this.lAp, 1));
            ((g.a)localObject).setScene(this.mScene);
            ((g.a)localObject).Rv(this.lAo);
            ((g.a)localObject).cBD();
            ((g.a)localObject).alk(this.lDb);
            localObject = ((g.a)localObject).qIY;
            if (this.lCZ == 1) {}
            for (long l = f.cBv().b((com.tencent.mm.plugin.downloader.model.g)localObject);; l = f.cBv().a((com.tencent.mm.plugin.downloader.model.g)localObject))
            {
              Log.i("MicroMsg.JsApiAddDownloadTaskForNative", "doAddDownloadTaskStraight, downloadId = ".concat(String.valueOf(l)));
              if (l > 0L) {
                break label562;
              }
              Log.e("MicroMsg.JsApiAddDownloadTaskForNative", "doAddDownloadTaskStraight fail, downloadId = ".concat(String.valueOf(l)));
              this.lAr = "";
              break;
            }
            label562:
            this.lAq = false;
            this.lAs = l;
          }
        }
      }
    }
    
    public final void bjk()
    {
      AppMethodBeat.i(45757);
      bDK();
      if (this.lAq)
      {
        if (Util.isNullOrNil(this.lAr)) {}
        for (localObject = "fail";; localObject = String.format("fail:%s", new Object[] { this.lAr }))
        {
          this.kAr.i(this.csv, this.lAi.h((String)localObject, null));
          AppMethodBeat.o(45757);
          return;
        }
      }
      Object localObject = new HashMap();
      ((Map)localObject).put("downloadId", Long.valueOf(this.lAs));
      this.kAr.i(this.csv, this.lAi.n("ok", (Map)localObject));
      AppMethodBeat.o(45757);
    }
    
    public final void f(Parcel paramParcel)
    {
      boolean bool2 = true;
      AppMethodBeat.i(45758);
      this.lAj = paramParcel.readString();
      this.lAk = paramParcel.readString();
      this.lAl = paramParcel.readString();
      this.lAn = paramParcel.readLong();
      this.lAo = paramParcel.readString();
      this.lAp = paramParcel.readString();
      this.mAppId = paramParcel.readString();
      this.mPackageName = paramParcel.readString();
      boolean bool1;
      if (paramParcel.readInt() == 1) {
        bool1 = true;
      }
      for (;;)
      {
        this.lBG = bool1;
        this.lCZ = paramParcel.readInt();
        if (paramParcel.readInt() == 1)
        {
          bool1 = true;
          label105:
          this.lAq = bool1;
          this.lAr = paramParcel.readString();
          this.lAs = paramParcel.readLong();
          this.mScene = paramParcel.readInt();
          if (paramParcel.readInt() != 1) {
            break label189;
          }
          bool1 = bool2;
          this.lDa = bool1;
        }
        try
        {
          this.csi = new JSONObject(paramParcel.readString());
          this.lDb = paramParcel.readString();
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
            Log.d("MicroMsg.JsApiAddDownloadTaskForNative", localException.getMessage());
          }
        }
      }
    }
    
    public void writeToParcel(Parcel paramParcel, int paramInt)
    {
      int i = 1;
      AppMethodBeat.i(45759);
      paramParcel.writeString(this.lAj);
      paramParcel.writeString(this.lAk);
      paramParcel.writeString(this.lAl);
      paramParcel.writeLong(this.lAn);
      paramParcel.writeString(this.lAo);
      paramParcel.writeString(this.lAp);
      paramParcel.writeString(this.mAppId);
      paramParcel.writeString(this.mPackageName);
      if (this.lBG)
      {
        paramInt = 1;
        paramParcel.writeInt(paramInt);
        paramParcel.writeInt(this.lCZ);
        if (!this.lAq) {
          break label188;
        }
        paramInt = 1;
        label103:
        paramParcel.writeInt(paramInt);
        paramParcel.writeString(this.lAr);
        paramParcel.writeLong(this.lAs);
        paramParcel.writeInt(this.mScene);
        if (!this.lDa) {
          break label193;
        }
        paramInt = i;
        label141:
        paramParcel.writeInt(paramInt);
        if (this.csi == null) {
          break label198;
        }
      }
      label188:
      label193:
      label198:
      for (String str = this.csi.toString();; str = "")
      {
        paramParcel.writeString(str);
        paramParcel.writeString(this.lDb);
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