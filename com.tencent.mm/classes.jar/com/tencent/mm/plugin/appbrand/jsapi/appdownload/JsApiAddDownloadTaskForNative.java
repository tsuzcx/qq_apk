package com.tencent.mm.plugin.appbrand.jsapi.appdownload;

import android.content.Context;
import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.compatible.util.e;
import com.tencent.mm.kernel.h;
import com.tencent.mm.modelstat.d;
import com.tencent.mm.plugin.appbrand.ipc.MainProcessTask;
import com.tencent.mm.plugin.appbrand.jsapi.c;
import com.tencent.mm.plugin.appbrand.jsapi.p;
import com.tencent.mm.plugin.appbrand.y;
import com.tencent.mm.plugin.downloader.model.g;
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
  extends c<y>
{
  public static final int CTRL_INDEX = 655;
  public static final String NAME = "addDownloadTaskForNative";
  
  static class AddDownloadTask
    extends MainProcessTask
  {
    public static final Parcelable.Creator<AddDownloadTask> CREATOR;
    private JSONObject eif;
    private int eit;
    private String mAppId;
    private String mPackageName;
    private int mScene;
    private y qsi;
    private boolean rAz;
    private int rCt;
    private boolean rCu;
    private String rCv;
    private p ryT;
    private String ryU;
    private String ryV;
    private String ryW;
    private long ryY;
    private String ryZ;
    private String rza;
    private boolean rzb;
    private String rzc;
    private long rzd;
    
    static
    {
      AppMethodBeat.i(45760);
      CREATOR = new Parcelable.Creator() {};
      AppMethodBeat.o(45760);
    }
    
    public AddDownloadTask(Parcel paramParcel)
    {
      AppMethodBeat.i(45755);
      h(paramParcel);
      AppMethodBeat.o(45755);
    }
    
    public AddDownloadTask(p paramp, y paramy, int paramInt, JSONObject paramJSONObject)
    {
      AppMethodBeat.i(45754);
      this.ryT = paramp;
      this.qsi = paramy;
      this.eit = paramInt;
      this.eif = paramJSONObject;
      this.ryU = paramJSONObject.optString("taskName");
      this.ryV = paramJSONObject.optString("taskUrl");
      this.ryW = paramJSONObject.optString("fileMd5");
      this.ryY = paramJSONObject.optInt("taskSize", 0);
      this.ryZ = paramJSONObject.optString("extInfo");
      this.rza = paramJSONObject.optString("fileType");
      this.mAppId = paramJSONObject.optString("appId");
      this.mPackageName = paramJSONObject.optString("packageName");
      this.rAz = paramJSONObject.optBoolean("downloadInWifi", false);
      this.rCt = paramJSONObject.optInt("downloaderType", 0);
      this.rCu = paramJSONObject.optBoolean("useDownloaderWidget", false);
      this.mScene = paramJSONObject.optInt("scene", 6001);
      this.rCv = paramJSONObject.optString("alterUrl");
      this.rzb = true;
      AppMethodBeat.o(45754);
    }
    
    public final void asn()
    {
      boolean bool = true;
      AppMethodBeat.i(45756);
      h.baF();
      if (!h.baE().isSDCardAvailable()) {
        this.rzc = "fail_sdcard_not_ready";
      }
      for (;;)
      {
        cpA();
        AppMethodBeat.o(45756);
        return;
        if ((this.ryY > 0L) && (!e.hq(this.ryY)))
        {
          this.rzc = "fail_sdcard_has_not_enough_space";
        }
        else if (Util.isNullOrNil(this.ryV))
        {
          this.rzc = "fail_invalid_url";
        }
        else
        {
          Object localObject;
          if (this.rCu)
          {
            localObject = MMApplicationContext.getContext();
            JSONObject localJSONObject = this.eif;
            a locala = new a();
            if (localJSONObject == null)
            {
              o.a((Context)localObject, locala, new o.a()
              {
                public final void j(String paramAnonymousString, JSONObject paramAnonymousJSONObject)
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
            }
            else
            {
              locala.appName = localJSONObject.optString("taskName");
              locala.downloadUrl = localJSONObject.optString("taskUrl");
              locala.xrR = localJSONObject.optString("alterUrl");
              locala.xrT = localJSONObject.optLong("taskSize");
              locala.tdo = localJSONObject.optString("fileMd5");
              locala.extInfo = localJSONObject.optString("extInfo");
              locala.fileType = Util.getInt(localJSONObject.optString("fileType"), 0);
              locala.appId = localJSONObject.optString("appId");
              locala.xrS = localJSONObject.optString("rawAppId");
              locala.packageName = localJSONObject.optString("packageName");
              locala.scene = localJSONObject.optInt("scene", 1000);
              locala.hMd = localJSONObject.optInt("downloaderType", 1);
              locala.xoo = localJSONObject.optBoolean("downloadInWifi", false);
              if (localJSONObject.optInt("ignoreNetwork", 0) == 1) {}
              for (;;)
              {
                locala.xrY = bool;
                break;
                bool = false;
              }
            }
          }
          else
          {
            Log.i("MicroMsg.JsApiAddDownloadTaskForNative", "runInMainProcess taskUrl:%s md5:%s", new Object[] { this.ryV, this.ryW });
            localObject = new g.a();
            ((g.a)localObject).amR(this.ryV);
            ((g.a)localObject).setFileSize(this.ryY);
            ((g.a)localObject).amT(this.ryU);
            ((g.a)localObject).setFileMD5(this.ryW);
            ((g.a)localObject).setAppId(this.mAppId);
            ((g.a)localObject).setPackageName(this.mPackageName);
            ((g.a)localObject).nA(true);
            ((g.a)localObject).JA(Util.getInt(this.rza, 1));
            ((g.a)localObject).setScene(this.mScene);
            ((g.a)localObject).QX(this.ryZ);
            ((g.a)localObject).duD();
            ((g.a)localObject).amS(this.rCv);
            localObject = ((g.a)localObject).xoe;
            if (this.rCt == 1) {}
            for (long l = com.tencent.mm.plugin.downloader.model.f.duv().b((g)localObject);; l = com.tencent.mm.plugin.downloader.model.f.duv().a((g)localObject))
            {
              Log.i("MicroMsg.JsApiAddDownloadTaskForNative", "doAddDownloadTaskStraight, downloadId = ".concat(String.valueOf(l)));
              if (l > 0L) {
                break label562;
              }
              Log.e("MicroMsg.JsApiAddDownloadTaskForNative", "doAddDownloadTaskStraight fail, downloadId = ".concat(String.valueOf(l)));
              this.rzc = "";
              break;
            }
            label562:
            this.rzb = false;
            this.rzd = l;
          }
        }
      }
    }
    
    public final void bQr()
    {
      AppMethodBeat.i(45757);
      cpx();
      if (this.rzb)
      {
        if (Util.isNullOrNil(this.rzc)) {}
        for (localObject = "fail";; localObject = String.format("fail:%s", new Object[] { this.rzc }))
        {
          this.qsi.callback(this.eit, this.ryT.ZP((String)localObject));
          AppMethodBeat.o(45757);
          return;
        }
      }
      Object localObject = new HashMap();
      ((Map)localObject).put("downloadId", Long.valueOf(this.rzd));
      this.qsi.callback(this.eit, this.ryT.m("ok", (Map)localObject));
      AppMethodBeat.o(45757);
    }
    
    public final void h(Parcel paramParcel)
    {
      boolean bool2 = true;
      AppMethodBeat.i(45758);
      this.ryU = paramParcel.readString();
      this.ryV = paramParcel.readString();
      this.ryW = paramParcel.readString();
      this.ryY = paramParcel.readLong();
      this.ryZ = paramParcel.readString();
      this.rza = paramParcel.readString();
      this.mAppId = paramParcel.readString();
      this.mPackageName = paramParcel.readString();
      boolean bool1;
      if (paramParcel.readInt() == 1) {
        bool1 = true;
      }
      for (;;)
      {
        this.rAz = bool1;
        this.rCt = paramParcel.readInt();
        if (paramParcel.readInt() == 1)
        {
          bool1 = true;
          label105:
          this.rzb = bool1;
          this.rzc = paramParcel.readString();
          this.rzd = paramParcel.readLong();
          this.mScene = paramParcel.readInt();
          if (paramParcel.readInt() != 1) {
            break label189;
          }
          bool1 = bool2;
          this.rCu = bool1;
        }
        try
        {
          this.eif = new JSONObject(paramParcel.readString());
          this.rCv = paramParcel.readString();
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
      paramParcel.writeString(this.ryU);
      paramParcel.writeString(this.ryV);
      paramParcel.writeString(this.ryW);
      paramParcel.writeLong(this.ryY);
      paramParcel.writeString(this.ryZ);
      paramParcel.writeString(this.rza);
      paramParcel.writeString(this.mAppId);
      paramParcel.writeString(this.mPackageName);
      if (this.rAz)
      {
        paramInt = 1;
        paramParcel.writeInt(paramInt);
        paramParcel.writeInt(this.rCt);
        if (!this.rzb) {
          break label188;
        }
        paramInt = 1;
        label103:
        paramParcel.writeInt(paramInt);
        paramParcel.writeString(this.rzc);
        paramParcel.writeLong(this.rzd);
        paramParcel.writeInt(this.mScene);
        if (!this.rCu) {
          break label193;
        }
        paramInt = i;
        label141:
        paramParcel.writeInt(paramInt);
        if (this.eif == null) {
          break label198;
        }
      }
      label188:
      label193:
      label198:
      for (String str = this.eif.toString();; str = "")
      {
        paramParcel.writeString(str);
        paramParcel.writeString(this.rCv);
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