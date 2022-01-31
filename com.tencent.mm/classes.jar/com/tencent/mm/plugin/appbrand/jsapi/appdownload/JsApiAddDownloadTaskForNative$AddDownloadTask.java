package com.tencent.mm.plugin.appbrand.jsapi.appdownload;

import android.content.Context;
import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.kernel.e;
import com.tencent.mm.modelstat.d;
import com.tencent.mm.plugin.appbrand.ipc.MainProcessTask;
import com.tencent.mm.plugin.appbrand.jsapi.m;
import com.tencent.mm.plugin.appbrand.r;
import com.tencent.mm.plugin.downloader.model.g.a;
import com.tencent.mm.plugin.downloader.model.o;
import com.tencent.mm.plugin.downloader_app.b.a;
import com.tencent.mm.sdk.platformtools.ab;
import com.tencent.mm.sdk.platformtools.ah;
import com.tencent.mm.sdk.platformtools.bo;
import java.util.HashMap;
import java.util.Map;
import org.json.JSONObject;

class JsApiAddDownloadTaskForNative$AddDownloadTask
  extends MainProcessTask
{
  public static final Parcelable.Creator<AddDownloadTask> CREATOR;
  private JSONObject bxK;
  private int bxX;
  private r gPA;
  private int hAV;
  private boolean hAW;
  private String hAX;
  private m hyA;
  private String hyB;
  private String hyC;
  private String hyD;
  private long hyF;
  private String hyG;
  private String hyH;
  private boolean hyI;
  private String hyJ;
  private long hyK;
  private boolean hzD;
  private String mAppId;
  private String mPackageName;
  private int mScene;
  
  static
  {
    AppMethodBeat.i(143288);
    CREATOR = new JsApiAddDownloadTaskForNative.AddDownloadTask.2();
    AppMethodBeat.o(143288);
  }
  
  public JsApiAddDownloadTaskForNative$AddDownloadTask(Parcel paramParcel)
  {
    AppMethodBeat.i(143283);
    f(paramParcel);
    AppMethodBeat.o(143283);
  }
  
  public JsApiAddDownloadTaskForNative$AddDownloadTask(m paramm, r paramr, int paramInt, JSONObject paramJSONObject)
  {
    AppMethodBeat.i(143282);
    aBj();
    this.hyA = paramm;
    this.gPA = paramr;
    this.bxX = paramInt;
    this.bxK = paramJSONObject;
    this.hyB = paramJSONObject.optString("taskName");
    this.hyC = paramJSONObject.optString("taskUrl");
    this.hyD = paramJSONObject.optString("fileMd5");
    this.hyF = paramJSONObject.optInt("taskSize", 0);
    this.hyG = paramJSONObject.optString("extInfo");
    this.hyH = paramJSONObject.optString("fileType");
    this.mAppId = paramJSONObject.optString("appId");
    this.mPackageName = paramJSONObject.optString("packageName");
    this.hzD = paramJSONObject.optBoolean("downloadInWifi", false);
    this.hAV = paramJSONObject.optInt("downloaderType", 0);
    this.hAW = paramJSONObject.optBoolean("useDownloaderWidget", false);
    this.mScene = paramJSONObject.optInt("scene", 6001);
    this.hAX = paramJSONObject.optString("alterUrl");
    this.hyI = true;
    AppMethodBeat.o(143282);
  }
  
  public final void ata()
  {
    AppMethodBeat.i(143284);
    com.tencent.mm.kernel.g.RM();
    if (!com.tencent.mm.kernel.g.RL().isSDCardAvailable()) {
      this.hyJ = "fail_sdcard_not_ready";
    }
    for (;;)
    {
      aBp();
      AppMethodBeat.o(143284);
      return;
      if ((this.hyF > 0L) && (!com.tencent.mm.compatible.util.f.gc(this.hyF)))
      {
        this.hyJ = "fail_sdcard_has_not_enough_space";
      }
      else if (bo.isNullOrNil(this.hyC))
      {
        this.hyJ = "fail_invalid_url";
      }
      else
      {
        if (this.hAW)
        {
          localObject = ah.getContext();
          JSONObject localJSONObject = this.bxK;
          a locala = new a();
          if (localJSONObject == null) {}
          for (;;)
          {
            o.a((Context)localObject, locala, new JsApiAddDownloadTaskForNative.AddDownloadTask.1(this));
            d.b(10, "JsApiAddDownloadTaskForNative", hashCode());
            break;
            locala.appName = localJSONObject.optString("taskName");
            locala.downloadUrl = localJSONObject.optString("taskUrl");
            locala.laB = localJSONObject.optString("alterUrl");
            locala.laC = localJSONObject.optLong("taskSize");
            locala.laD = localJSONObject.optString("fileMd5");
            locala.extInfo = localJSONObject.optString("extInfo");
            locala.fileType = bo.getInt(localJSONObject.optString("fileType"), 0);
            locala.appId = localJSONObject.optString("appId");
            locala.packageName = localJSONObject.optString("packageName");
            locala.scene = localJSONObject.optInt("scene", 1000);
            locala.cvQ = localJSONObject.optInt("downloaderType", 1);
            locala.kYZ = localJSONObject.optBoolean("downloadInWifi", false);
          }
        }
        ab.i("MicroMsg.JsApiAddDownloadTaskForNative", "runInMainProcess taskUrl:%s md5:%s", new Object[] { this.hyC, this.hyD });
        Object localObject = new g.a();
        ((g.a)localObject).JJ(this.hyC);
        ((g.a)localObject).iR(this.hyF);
        ((g.a)localObject).JL(this.hyB);
        ((g.a)localObject).JM(this.hyD);
        ((g.a)localObject).setAppId(this.mAppId);
        ((g.a)localObject).dC(this.mPackageName);
        ((g.a)localObject).gr(true);
        ((g.a)localObject).tV(bo.getInt(this.hyH, 1));
        ((g.a)localObject).setScene(this.mScene);
        ((g.a)localObject).JN(this.hyG);
        ((g.a)localObject).bju();
        ((g.a)localObject).JK(this.hAX);
        localObject = ((g.a)localObject).kYR;
        if (this.hAV == 1) {}
        for (long l = com.tencent.mm.plugin.downloader.model.f.bjl().b((com.tencent.mm.plugin.downloader.model.g)localObject);; l = com.tencent.mm.plugin.downloader.model.f.bjl().a((com.tencent.mm.plugin.downloader.model.g)localObject))
        {
          ab.i("MicroMsg.JsApiAddDownloadTaskForNative", "doAddDownloadTaskStraight, downloadId = ".concat(String.valueOf(l)));
          if (l > 0L) {
            break label505;
          }
          ab.e("MicroMsg.JsApiAddDownloadTaskForNative", "doAddDownloadTaskStraight fail, downloadId = ".concat(String.valueOf(l)));
          this.hyJ = "";
          break;
        }
        label505:
        this.hyI = false;
        this.hyK = l;
      }
    }
  }
  
  public final void atb()
  {
    AppMethodBeat.i(143285);
    aBk();
    if (this.hyI)
    {
      if (bo.isNullOrNil(this.hyJ)) {}
      for (localObject = "fail";; localObject = String.format("fail:%s", new Object[] { this.hyJ }))
      {
        this.gPA.h(this.bxX, this.hyA.j((String)localObject, null));
        AppMethodBeat.o(143285);
        return;
      }
    }
    Object localObject = new HashMap();
    ((Map)localObject).put("downloadId", Long.valueOf(this.hyK));
    this.gPA.h(this.bxX, this.hyA.j("ok", (Map)localObject));
    AppMethodBeat.o(143285);
  }
  
  public final void f(Parcel paramParcel)
  {
    boolean bool2 = true;
    AppMethodBeat.i(143286);
    this.hyB = paramParcel.readString();
    this.hyC = paramParcel.readString();
    this.hyD = paramParcel.readString();
    this.hyF = paramParcel.readLong();
    this.hyG = paramParcel.readString();
    this.hyH = paramParcel.readString();
    this.mAppId = paramParcel.readString();
    this.mPackageName = paramParcel.readString();
    boolean bool1;
    if (paramParcel.readInt() == 1) {
      bool1 = true;
    }
    for (;;)
    {
      this.hzD = bool1;
      this.hAV = paramParcel.readInt();
      if (paramParcel.readInt() == 1)
      {
        bool1 = true;
        label105:
        this.hyI = bool1;
        this.hyJ = paramParcel.readString();
        this.hyK = paramParcel.readLong();
        this.mScene = paramParcel.readInt();
        if (paramParcel.readInt() != 1) {
          break label189;
        }
        bool1 = bool2;
        this.hAW = bool1;
      }
      try
      {
        this.bxK = new JSONObject(paramParcel.readString());
        this.hAX = paramParcel.readString();
        AppMethodBeat.o(143286);
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
          ab.d("MicroMsg.JsApiAddDownloadTaskForNative", localException.getMessage());
        }
      }
    }
  }
  
  public void writeToParcel(Parcel paramParcel, int paramInt)
  {
    int i = 1;
    AppMethodBeat.i(143287);
    paramParcel.writeString(this.hyB);
    paramParcel.writeString(this.hyC);
    paramParcel.writeString(this.hyD);
    paramParcel.writeLong(this.hyF);
    paramParcel.writeString(this.hyG);
    paramParcel.writeString(this.hyH);
    paramParcel.writeString(this.mAppId);
    paramParcel.writeString(this.mPackageName);
    if (this.hzD)
    {
      paramInt = 1;
      paramParcel.writeInt(paramInt);
      paramParcel.writeInt(this.hAV);
      if (!this.hyI) {
        break label188;
      }
      paramInt = 1;
      label103:
      paramParcel.writeInt(paramInt);
      paramParcel.writeString(this.hyJ);
      paramParcel.writeLong(this.hyK);
      paramParcel.writeInt(this.mScene);
      if (!this.hAW) {
        break label193;
      }
      paramInt = i;
      label141:
      paramParcel.writeInt(paramInt);
      if (this.bxK == null) {
        break label198;
      }
    }
    label188:
    label193:
    label198:
    for (String str = this.bxK.toString();; str = "")
    {
      paramParcel.writeString(str);
      paramParcel.writeString(this.hAX);
      AppMethodBeat.o(143287);
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


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.jsapi.appdownload.JsApiAddDownloadTaskForNative.AddDownloadTask
 * JD-Core Version:    0.7.0.1
 */