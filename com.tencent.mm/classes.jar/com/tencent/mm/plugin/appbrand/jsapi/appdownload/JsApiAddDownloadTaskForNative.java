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
import com.tencent.mm.sdk.platformtools.ac;
import com.tencent.mm.sdk.platformtools.ai;
import com.tencent.mm.sdk.platformtools.bs;
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
    private JSONObject bVY;
    private int bWl;
    private boolean jYA;
    private String jYB;
    private long jYC;
    private m jYs;
    private String jYt;
    private String jYu;
    private String jYv;
    private long jYx;
    private String jYy;
    private String jYz;
    private boolean jZH;
    private q jdy;
    private int kaV;
    private boolean kaW;
    private String kaX;
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
      bej();
      this.jYs = paramm;
      this.jdy = paramq;
      this.bWl = paramInt;
      this.bVY = paramJSONObject;
      this.jYt = paramJSONObject.optString("taskName");
      this.jYu = paramJSONObject.optString("taskUrl");
      this.jYv = paramJSONObject.optString("fileMd5");
      this.jYx = paramJSONObject.optInt("taskSize", 0);
      this.jYy = paramJSONObject.optString("extInfo");
      this.jYz = paramJSONObject.optString("fileType");
      this.mAppId = paramJSONObject.optString("appId");
      this.mPackageName = paramJSONObject.optString("packageName");
      this.jZH = paramJSONObject.optBoolean("downloadInWifi", false);
      this.kaV = paramJSONObject.optInt("downloaderType", 0);
      this.kaW = paramJSONObject.optBoolean("useDownloaderWidget", false);
      this.mScene = paramJSONObject.optInt("scene", 6001);
      this.kaX = paramJSONObject.optString("alterUrl");
      this.jYA = true;
      AppMethodBeat.o(45754);
    }
    
    public final void aLq()
    {
      AppMethodBeat.i(45756);
      com.tencent.mm.kernel.g.agS();
      if (!com.tencent.mm.kernel.g.agR().isSDCardAvailable()) {
        this.jYB = "fail_sdcard_not_ready";
      }
      for (;;)
      {
        bet();
        AppMethodBeat.o(45756);
        return;
        if ((this.jYx > 0L) && (!com.tencent.mm.compatible.util.e.oR(this.jYx)))
        {
          this.jYB = "fail_sdcard_has_not_enough_space";
        }
        else if (bs.isNullOrNil(this.jYu))
        {
          this.jYB = "fail_invalid_url";
        }
        else
        {
          if (this.kaW)
          {
            localObject = ai.getContext();
            JSONObject localJSONObject = this.bVY;
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
              locala.oKQ = localJSONObject.optString("alterUrl");
              locala.oKS = localJSONObject.optLong("taskSize");
              locala.lpa = localJSONObject.optString("fileMd5");
              locala.extInfo = localJSONObject.optString("extInfo");
              locala.fileType = bs.getInt(localJSONObject.optString("fileType"), 0);
              locala.appId = localJSONObject.optString("appId");
              locala.oKR = localJSONObject.optString("rawAppId");
              locala.packageName = localJSONObject.optString("packageName");
              locala.scene = localJSONObject.optInt("scene", 1000);
              locala.diX = localJSONObject.optInt("downloaderType", 1);
              locala.oJo = localJSONObject.optBoolean("downloadInWifi", false);
            }
          }
          ac.i("MicroMsg.JsApiAddDownloadTaskForNative", "runInMainProcess taskUrl:%s md5:%s", new Object[] { this.jYu, this.jYv });
          Object localObject = new g.a();
          ((g.a)localObject).WD(this.jYu);
          ((g.a)localObject).sk(this.jYx);
          ((g.a)localObject).WF(this.jYt);
          ((g.a)localObject).WG(this.jYv);
          ((g.a)localObject).setAppId(this.mAppId);
          ((g.a)localObject).ey(this.mPackageName);
          ((g.a)localObject).jF(true);
          ((g.a)localObject).AG(bs.getInt(this.jYz, 1));
          ((g.a)localObject).setScene(this.mScene);
          ((g.a)localObject).WH(this.jYy);
          ((g.a)localObject).bXR();
          ((g.a)localObject).WE(this.kaX);
          localObject = ((g.a)localObject).oJg;
          if (this.kaV == 1) {}
          for (long l = f.bXJ().b((com.tencent.mm.plugin.downloader.model.g)localObject);; l = f.bXJ().a((com.tencent.mm.plugin.downloader.model.g)localObject))
          {
            ac.i("MicroMsg.JsApiAddDownloadTaskForNative", "doAddDownloadTaskStraight, downloadId = ".concat(String.valueOf(l)));
            if (l > 0L) {
              break label517;
            }
            ac.e("MicroMsg.JsApiAddDownloadTaskForNative", "doAddDownloadTaskStraight fail, downloadId = ".concat(String.valueOf(l)));
            this.jYB = "";
            break;
          }
          label517:
          this.jYA = false;
          this.jYC = l;
        }
      }
    }
    
    public final void aLr()
    {
      AppMethodBeat.i(45757);
      bek();
      if (this.jYA)
      {
        if (bs.isNullOrNil(this.jYB)) {}
        for (localObject = "fail";; localObject = String.format("fail:%s", new Object[] { this.jYB }))
        {
          this.jdy.h(this.bWl, this.jYs.e((String)localObject, null));
          AppMethodBeat.o(45757);
          return;
        }
      }
      Object localObject = new HashMap();
      ((Map)localObject).put("downloadId", Long.valueOf(this.jYC));
      this.jdy.h(this.bWl, this.jYs.k("ok", (Map)localObject));
      AppMethodBeat.o(45757);
    }
    
    public final void e(Parcel paramParcel)
    {
      boolean bool2 = true;
      AppMethodBeat.i(45758);
      this.jYt = paramParcel.readString();
      this.jYu = paramParcel.readString();
      this.jYv = paramParcel.readString();
      this.jYx = paramParcel.readLong();
      this.jYy = paramParcel.readString();
      this.jYz = paramParcel.readString();
      this.mAppId = paramParcel.readString();
      this.mPackageName = paramParcel.readString();
      boolean bool1;
      if (paramParcel.readInt() == 1) {
        bool1 = true;
      }
      for (;;)
      {
        this.jZH = bool1;
        this.kaV = paramParcel.readInt();
        if (paramParcel.readInt() == 1)
        {
          bool1 = true;
          label105:
          this.jYA = bool1;
          this.jYB = paramParcel.readString();
          this.jYC = paramParcel.readLong();
          this.mScene = paramParcel.readInt();
          if (paramParcel.readInt() != 1) {
            break label189;
          }
          bool1 = bool2;
          this.kaW = bool1;
        }
        try
        {
          this.bVY = new JSONObject(paramParcel.readString());
          this.kaX = paramParcel.readString();
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
            ac.d("MicroMsg.JsApiAddDownloadTaskForNative", localException.getMessage());
          }
        }
      }
    }
    
    public void writeToParcel(Parcel paramParcel, int paramInt)
    {
      int i = 1;
      AppMethodBeat.i(45759);
      paramParcel.writeString(this.jYt);
      paramParcel.writeString(this.jYu);
      paramParcel.writeString(this.jYv);
      paramParcel.writeLong(this.jYx);
      paramParcel.writeString(this.jYy);
      paramParcel.writeString(this.jYz);
      paramParcel.writeString(this.mAppId);
      paramParcel.writeString(this.mPackageName);
      if (this.jZH)
      {
        paramInt = 1;
        paramParcel.writeInt(paramInt);
        paramParcel.writeInt(this.kaV);
        if (!this.jYA) {
          break label188;
        }
        paramInt = 1;
        label103:
        paramParcel.writeInt(paramInt);
        paramParcel.writeString(this.jYB);
        paramParcel.writeLong(this.jYC);
        paramParcel.writeInt(this.mScene);
        if (!this.kaW) {
          break label193;
        }
        paramInt = i;
        label141:
        paramParcel.writeInt(paramInt);
        if (this.bVY == null) {
          break label198;
        }
      }
      label188:
      label193:
      label198:
      for (String str = this.bVY.toString();; str = "")
      {
        paramParcel.writeString(str);
        paramParcel.writeString(this.kaX);
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