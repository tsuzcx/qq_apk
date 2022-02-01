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
    private JSONObject bZb;
    private int bZo;
    private q iDy;
    private boolean jAA;
    private String jAB;
    private int jAz;
    private m jxX;
    private String jxY;
    private String jxZ;
    private String jya;
    private long jyc;
    private String jyd;
    private String jye;
    private boolean jyf;
    private String jyg;
    private long jyh;
    private boolean jzk;
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
      aXm();
      this.jxX = paramm;
      this.iDy = paramq;
      this.bZo = paramInt;
      this.bZb = paramJSONObject;
      this.jxY = paramJSONObject.optString("taskName");
      this.jxZ = paramJSONObject.optString("taskUrl");
      this.jya = paramJSONObject.optString("fileMd5");
      this.jyc = paramJSONObject.optInt("taskSize", 0);
      this.jyd = paramJSONObject.optString("extInfo");
      this.jye = paramJSONObject.optString("fileType");
      this.mAppId = paramJSONObject.optString("appId");
      this.mPackageName = paramJSONObject.optString("packageName");
      this.jzk = paramJSONObject.optBoolean("downloadInWifi", false);
      this.jAz = paramJSONObject.optInt("downloaderType", 0);
      this.jAA = paramJSONObject.optBoolean("useDownloaderWidget", false);
      this.mScene = paramJSONObject.optInt("scene", 6001);
      this.jAB = paramJSONObject.optString("alterUrl");
      this.jyf = true;
      AppMethodBeat.o(45754);
    }
    
    public final void aEA()
    {
      AppMethodBeat.i(45757);
      aXn();
      if (this.jyf)
      {
        if (bt.isNullOrNil(this.jyg)) {}
        for (localObject = "fail";; localObject = String.format("fail:%s", new Object[] { this.jyg }))
        {
          this.iDy.h(this.bZo, this.jxX.e((String)localObject, null));
          AppMethodBeat.o(45757);
          return;
        }
      }
      Object localObject = new HashMap();
      ((Map)localObject).put("downloadId", Long.valueOf(this.jyh));
      this.iDy.h(this.bZo, this.jxX.k("ok", (Map)localObject));
      AppMethodBeat.o(45757);
    }
    
    public final void aEz()
    {
      AppMethodBeat.i(45756);
      com.tencent.mm.kernel.g.afC();
      if (!com.tencent.mm.kernel.g.afB().isSDCardAvailable()) {
        this.jyg = "fail_sdcard_not_ready";
      }
      for (;;)
      {
        aXw();
        AppMethodBeat.o(45756);
        return;
        if ((this.jyc > 0L) && (!com.tencent.mm.compatible.util.e.lo(this.jyc)))
        {
          this.jyg = "fail_sdcard_has_not_enough_space";
        }
        else if (bt.isNullOrNil(this.jxZ))
        {
          this.jyg = "fail_invalid_url";
        }
        else
        {
          if (this.jAA)
          {
            localObject = aj.getContext();
            JSONObject localJSONObject = this.bZb;
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
              d.c(10, "JsApiAddDownloadTaskForNative", hashCode());
              break;
              locala.appName = localJSONObject.optString("taskName");
              locala.downloadUrl = localJSONObject.optString("taskUrl");
              locala.ohq = localJSONObject.optString("alterUrl");
              locala.ohs = localJSONObject.optLong("taskSize");
              locala.kNB = localJSONObject.optString("fileMd5");
              locala.extInfo = localJSONObject.optString("extInfo");
              locala.fileType = bt.getInt(localJSONObject.optString("fileType"), 0);
              locala.appId = localJSONObject.optString("appId");
              locala.ohr = localJSONObject.optString("rawAppId");
              locala.packageName = localJSONObject.optString("packageName");
              locala.scene = localJSONObject.optInt("scene", 1000);
              locala.dlp = localJSONObject.optInt("downloaderType", 1);
              locala.ofN = localJSONObject.optBoolean("downloadInWifi", false);
            }
          }
          ad.i("MicroMsg.JsApiAddDownloadTaskForNative", "runInMainProcess taskUrl:%s md5:%s", new Object[] { this.jxZ, this.jya });
          Object localObject = new g.a();
          ((g.a)localObject).Sr(this.jxZ);
          ((g.a)localObject).oy(this.jyc);
          ((g.a)localObject).St(this.jxY);
          ((g.a)localObject).Su(this.jya);
          ((g.a)localObject).setAppId(this.mAppId);
          ((g.a)localObject).eI(this.mPackageName);
          ((g.a)localObject).jc(true);
          ((g.a)localObject).zO(bt.getInt(this.jye, 1));
          ((g.a)localObject).setScene(this.mScene);
          ((g.a)localObject).Sv(this.jyd);
          ((g.a)localObject).bQB();
          ((g.a)localObject).Ss(this.jAB);
          localObject = ((g.a)localObject).ofF;
          if (this.jAz == 1) {}
          for (long l = f.bQt().b((com.tencent.mm.plugin.downloader.model.g)localObject);; l = f.bQt().a((com.tencent.mm.plugin.downloader.model.g)localObject))
          {
            ad.i("MicroMsg.JsApiAddDownloadTaskForNative", "doAddDownloadTaskStraight, downloadId = ".concat(String.valueOf(l)));
            if (l > 0L) {
              break label519;
            }
            ad.e("MicroMsg.JsApiAddDownloadTaskForNative", "doAddDownloadTaskStraight fail, downloadId = ".concat(String.valueOf(l)));
            this.jyg = "";
            break;
          }
          label519:
          this.jyf = false;
          this.jyh = l;
        }
      }
    }
    
    public final void e(Parcel paramParcel)
    {
      boolean bool2 = true;
      AppMethodBeat.i(45758);
      this.jxY = paramParcel.readString();
      this.jxZ = paramParcel.readString();
      this.jya = paramParcel.readString();
      this.jyc = paramParcel.readLong();
      this.jyd = paramParcel.readString();
      this.jye = paramParcel.readString();
      this.mAppId = paramParcel.readString();
      this.mPackageName = paramParcel.readString();
      boolean bool1;
      if (paramParcel.readInt() == 1) {
        bool1 = true;
      }
      for (;;)
      {
        this.jzk = bool1;
        this.jAz = paramParcel.readInt();
        if (paramParcel.readInt() == 1)
        {
          bool1 = true;
          label105:
          this.jyf = bool1;
          this.jyg = paramParcel.readString();
          this.jyh = paramParcel.readLong();
          this.mScene = paramParcel.readInt();
          if (paramParcel.readInt() != 1) {
            break label189;
          }
          bool1 = bool2;
          this.jAA = bool1;
        }
        try
        {
          this.bZb = new JSONObject(paramParcel.readString());
          this.jAB = paramParcel.readString();
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
      paramParcel.writeString(this.jxY);
      paramParcel.writeString(this.jxZ);
      paramParcel.writeString(this.jya);
      paramParcel.writeLong(this.jyc);
      paramParcel.writeString(this.jyd);
      paramParcel.writeString(this.jye);
      paramParcel.writeString(this.mAppId);
      paramParcel.writeString(this.mPackageName);
      if (this.jzk)
      {
        paramInt = 1;
        paramParcel.writeInt(paramInt);
        paramParcel.writeInt(this.jAz);
        if (!this.jyf) {
          break label188;
        }
        paramInt = 1;
        label103:
        paramParcel.writeInt(paramInt);
        paramParcel.writeString(this.jyg);
        paramParcel.writeLong(this.jyh);
        paramParcel.writeInt(this.mScene);
        if (!this.jAA) {
          break label193;
        }
        paramInt = i;
        label141:
        paramParcel.writeInt(paramInt);
        if (this.bZb == null) {
          break label198;
        }
      }
      label188:
      label193:
      label198:
      for (String str = this.bZb.toString();; str = "")
      {
        paramParcel.writeString(str);
        paramParcel.writeString(this.jAB);
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