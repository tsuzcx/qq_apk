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
import com.tencent.mm.plugin.appbrand.v;
import com.tencent.mm.plugin.downloader.model.g;
import com.tencent.mm.plugin.downloader.model.g.a;
import com.tencent.mm.plugin.downloader.model.o.a;
import com.tencent.mm.plugin.downloader_app.a.a;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.MMApplicationContext;
import com.tencent.mm.sdk.platformtools.Util;
import java.util.HashMap;
import java.util.Map;
import org.json.JSONObject;

public final class JsApiAddDownloadTaskForNative
  extends c<v>
{
  public static final int CTRL_INDEX = 655;
  public static final String NAME = "addDownloadTaskForNative";
  
  static class AddDownloadTask
    extends MainProcessTask
  {
    public static final Parcelable.Creator<AddDownloadTask> CREATOR;
    private int cqA;
    private JSONObject cqn;
    private String mAppId;
    private String mPackageName;
    private int mScene;
    private v ntA;
    private String ovA;
    private String ovB;
    private String ovC;
    private long ovE;
    private String ovF;
    private String ovG;
    private boolean ovH;
    private String ovI;
    private long ovJ;
    private com.tencent.mm.plugin.appbrand.jsapi.o ovz;
    private boolean owW;
    private int oyB;
    private boolean oyC;
    private String oyD;
    
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
    
    public AddDownloadTask(com.tencent.mm.plugin.appbrand.jsapi.o paramo, v paramv, int paramInt, JSONObject paramJSONObject)
    {
      AppMethodBeat.i(45754);
      this.ovz = paramo;
      this.ntA = paramv;
      this.cqA = paramInt;
      this.cqn = paramJSONObject;
      this.ovA = paramJSONObject.optString("taskName");
      this.ovB = paramJSONObject.optString("taskUrl");
      this.ovC = paramJSONObject.optString("fileMd5");
      this.ovE = paramJSONObject.optInt("taskSize", 0);
      this.ovF = paramJSONObject.optString("extInfo");
      this.ovG = paramJSONObject.optString("fileType");
      this.mAppId = paramJSONObject.optString("appId");
      this.mPackageName = paramJSONObject.optString("packageName");
      this.owW = paramJSONObject.optBoolean("downloadInWifi", false);
      this.oyB = paramJSONObject.optInt("downloaderType", 0);
      this.oyC = paramJSONObject.optBoolean("useDownloaderWidget", false);
      this.mScene = paramJSONObject.optInt("scene", 6001);
      this.oyD = paramJSONObject.optString("alterUrl");
      this.ovH = true;
      AppMethodBeat.o(45754);
    }
    
    public final void RW()
    {
      boolean bool = true;
      AppMethodBeat.i(45756);
      h.aHH();
      if (!h.aHG().isSDCardAvailable()) {
        this.ovI = "fail_sdcard_not_ready";
      }
      for (;;)
      {
        bPt();
        AppMethodBeat.o(45756);
        return;
        if ((this.ovE > 0L) && (!e.EY(this.ovE)))
        {
          this.ovI = "fail_sdcard_has_not_enough_space";
        }
        else if (Util.isNullOrNil(this.ovB))
        {
          this.ovI = "fail_invalid_url";
        }
        else
        {
          Object localObject;
          if (this.oyC)
          {
            localObject = MMApplicationContext.getContext();
            JSONObject localJSONObject = this.cqn;
            a locala = new a();
            if (localJSONObject == null)
            {
              com.tencent.mm.plugin.downloader.model.o.a((Context)localObject, locala, new o.a()
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
              d.d(10, "JsApiAddDownloadTaskForNative", hashCode());
            }
            else
            {
              locala.appName = localJSONObject.optString("taskName");
              locala.downloadUrl = localJSONObject.optString("taskUrl");
              locala.ulF = localJSONObject.optString("alterUrl");
              locala.ulH = localJSONObject.optLong("taskSize");
              locala.pYB = localJSONObject.optString("fileMd5");
              locala.extInfo = localJSONObject.optString("extInfo");
              locala.fileType = Util.getInt(localJSONObject.optString("fileType"), 0);
              locala.appId = localJSONObject.optString("appId");
              locala.ulG = localJSONObject.optString("rawAppId");
              locala.packageName = localJSONObject.optString("packageName");
              locala.scene = localJSONObject.optInt("scene", 1000);
              locala.fGH = localJSONObject.optInt("downloaderType", 1);
              locala.uij = localJSONObject.optBoolean("downloadInWifi", false);
              if (localJSONObject.optInt("ignoreNetwork", 0) == 1) {}
              for (;;)
              {
                locala.ulM = bool;
                break;
                bool = false;
              }
            }
          }
          else
          {
            Log.i("MicroMsg.JsApiAddDownloadTaskForNative", "runInMainProcess taskUrl:%s md5:%s", new Object[] { this.ovB, this.ovC });
            localObject = new g.a();
            ((g.a)localObject).atc(this.ovB);
            ((g.a)localObject).setFileSize(this.ovE);
            ((g.a)localObject).ate(this.ovA);
            ((g.a)localObject).setFileMD5(this.ovC);
            ((g.a)localObject).setAppId(this.mAppId);
            ((g.a)localObject).setPackageName(this.mPackageName);
            ((g.a)localObject).me(true);
            ((g.a)localObject).IS(Util.getInt(this.ovG, 1));
            ((g.a)localObject).setScene(this.mScene);
            ((g.a)localObject).YS(this.ovF);
            ((g.a)localObject).cQh();
            ((g.a)localObject).atd(this.oyD);
            localObject = ((g.a)localObject).uhY;
            if (this.oyB == 1) {}
            for (long l = com.tencent.mm.plugin.downloader.model.f.cPZ().b((g)localObject);; l = com.tencent.mm.plugin.downloader.model.f.cPZ().a((g)localObject))
            {
              Log.i("MicroMsg.JsApiAddDownloadTaskForNative", "doAddDownloadTaskStraight, downloadId = ".concat(String.valueOf(l)));
              if (l > 0L) {
                break label562;
              }
              Log.e("MicroMsg.JsApiAddDownloadTaskForNative", "doAddDownloadTaskStraight fail, downloadId = ".concat(String.valueOf(l)));
              this.ovI = "";
              break;
            }
            label562:
            this.ovH = false;
            this.ovJ = l;
          }
        }
      }
    }
    
    public final void bsK()
    {
      AppMethodBeat.i(45757);
      bPk();
      if (this.ovH)
      {
        if (Util.isNullOrNil(this.ovI)) {}
        for (localObject = "fail";; localObject = String.format("fail:%s", new Object[] { this.ovI }))
        {
          this.ntA.j(this.cqA, this.ovz.h((String)localObject, null));
          AppMethodBeat.o(45757);
          return;
        }
      }
      Object localObject = new HashMap();
      ((Map)localObject).put("downloadId", Long.valueOf(this.ovJ));
      this.ntA.j(this.cqA, this.ovz.m("ok", (Map)localObject));
      AppMethodBeat.o(45757);
    }
    
    public final void f(Parcel paramParcel)
    {
      boolean bool2 = true;
      AppMethodBeat.i(45758);
      this.ovA = paramParcel.readString();
      this.ovB = paramParcel.readString();
      this.ovC = paramParcel.readString();
      this.ovE = paramParcel.readLong();
      this.ovF = paramParcel.readString();
      this.ovG = paramParcel.readString();
      this.mAppId = paramParcel.readString();
      this.mPackageName = paramParcel.readString();
      boolean bool1;
      if (paramParcel.readInt() == 1) {
        bool1 = true;
      }
      for (;;)
      {
        this.owW = bool1;
        this.oyB = paramParcel.readInt();
        if (paramParcel.readInt() == 1)
        {
          bool1 = true;
          label105:
          this.ovH = bool1;
          this.ovI = paramParcel.readString();
          this.ovJ = paramParcel.readLong();
          this.mScene = paramParcel.readInt();
          if (paramParcel.readInt() != 1) {
            break label189;
          }
          bool1 = bool2;
          this.oyC = bool1;
        }
        try
        {
          this.cqn = new JSONObject(paramParcel.readString());
          this.oyD = paramParcel.readString();
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
      paramParcel.writeString(this.ovA);
      paramParcel.writeString(this.ovB);
      paramParcel.writeString(this.ovC);
      paramParcel.writeLong(this.ovE);
      paramParcel.writeString(this.ovF);
      paramParcel.writeString(this.ovG);
      paramParcel.writeString(this.mAppId);
      paramParcel.writeString(this.mPackageName);
      if (this.owW)
      {
        paramInt = 1;
        paramParcel.writeInt(paramInt);
        paramParcel.writeInt(this.oyB);
        if (!this.ovH) {
          break label188;
        }
        paramInt = 1;
        label103:
        paramParcel.writeInt(paramInt);
        paramParcel.writeString(this.ovI);
        paramParcel.writeLong(this.ovJ);
        paramParcel.writeInt(this.mScene);
        if (!this.oyC) {
          break label193;
        }
        paramInt = i;
        label141:
        paramParcel.writeInt(paramInt);
        if (this.cqn == null) {
          break label198;
        }
      }
      label188:
      label193:
      label198:
      for (String str = this.cqn.toString();; str = "")
      {
        paramParcel.writeString(str);
        paramParcel.writeString(this.oyD);
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