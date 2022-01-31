package com.tencent.mm.plugin.appbrand.jsapi.appdownload;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.kernel.e;
import com.tencent.mm.plugin.appbrand.ipc.MainProcessTask;
import com.tencent.mm.plugin.appbrand.jsapi.m;
import com.tencent.mm.plugin.appbrand.r;
import com.tencent.mm.plugin.downloader.model.g.a;
import com.tencent.mm.sdk.platformtools.ab;
import com.tencent.mm.sdk.platformtools.bo;
import java.util.HashMap;
import java.util.Map;
import org.json.JSONObject;

class JsApiAddDownloadTaskStraight$AddDownloadTaskStraightTask
  extends MainProcessTask
{
  public static final Parcelable.Creator<AddDownloadTaskStraightTask> CREATOR;
  private int bxX;
  private r gPA;
  private m hyA;
  private String hyB;
  private String hyC;
  private String hyD;
  private String hyE;
  private long hyF;
  private String hyG;
  private String hyH;
  private boolean hyI;
  private String hyJ;
  private long hyK;
  private String mAppId;
  private String mPackageName;
  
  static
  {
    AppMethodBeat.i(130667);
    CREATOR = new JsApiAddDownloadTaskStraight.AddDownloadTaskStraightTask.1();
    AppMethodBeat.o(130667);
  }
  
  public JsApiAddDownloadTaskStraight$AddDownloadTaskStraightTask(Parcel paramParcel)
  {
    AppMethodBeat.i(130662);
    f(paramParcel);
    AppMethodBeat.o(130662);
  }
  
  public JsApiAddDownloadTaskStraight$AddDownloadTaskStraightTask(m paramm, r paramr, int paramInt, JSONObject paramJSONObject)
  {
    AppMethodBeat.i(130661);
    this.hyA = paramm;
    this.gPA = paramr;
    this.bxX = paramInt;
    this.hyB = paramJSONObject.optString("taskName");
    this.hyC = paramJSONObject.optString("taskUrl");
    this.hyD = paramJSONObject.optString("fileMd5");
    this.hyE = paramJSONObject.optString("alternativeUrl");
    this.hyF = paramJSONObject.optInt("taskSize", 0);
    this.hyG = paramJSONObject.optString("extInfo");
    this.hyH = paramJSONObject.optString("fileType");
    this.mAppId = paramr.getAppId();
    this.mPackageName = paramJSONObject.optString("packageName");
    this.hyI = true;
    AppMethodBeat.o(130661);
  }
  
  public final void ata()
  {
    AppMethodBeat.i(130663);
    com.tencent.mm.kernel.g.RM();
    if (!com.tencent.mm.kernel.g.RL().isSDCardAvailable()) {
      this.hyJ = "fail_sdcard_not_ready";
    }
    for (;;)
    {
      aBp();
      AppMethodBeat.o(130663);
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
        ab.i("MicroMsg.JsApiAddDownloadTaskStraight", "runInMainProcess taskUrl:%s md5:%s", new Object[] { this.hyC, this.hyD });
        Object localObject = new g.a();
        ((g.a)localObject).JJ(this.hyC);
        ((g.a)localObject).JK(this.hyE);
        ((g.a)localObject).iR(this.hyF);
        ((g.a)localObject).JL(this.hyB);
        ((g.a)localObject).JM(this.hyD);
        ((g.a)localObject).setAppId(this.mAppId);
        ((g.a)localObject).dC(this.mPackageName);
        ((g.a)localObject).gr(true);
        ((g.a)localObject).tV(bo.getInt(this.hyH, 1));
        ((g.a)localObject).setScene(6001);
        ((g.a)localObject).JN(this.hyG);
        localObject = ((g.a)localObject).kYR;
        long l = com.tencent.mm.plugin.downloader.model.f.bjl().a((com.tencent.mm.plugin.downloader.model.g)localObject);
        ab.i("MicroMsg.JsApiAddDownloadTaskStraight", "doAddDownloadTaskStraight, downloadId = ".concat(String.valueOf(l)));
        if (l <= 0L)
        {
          ab.e("MicroMsg.JsApiAddDownloadTaskStraight", "doAddDownloadTaskStraight fail, downloadId = ".concat(String.valueOf(l)));
          this.hyJ = "";
        }
        else
        {
          this.hyI = false;
          this.hyK = l;
        }
      }
    }
  }
  
  public final void atb()
  {
    AppMethodBeat.i(130664);
    if (this.hyI)
    {
      if (bo.isNullOrNil(this.hyJ)) {}
      for (localObject = "fail";; localObject = String.format("fail:%s", new Object[] { this.hyJ }))
      {
        this.gPA.h(this.bxX, this.hyA.j((String)localObject, null));
        AppMethodBeat.o(130664);
        return;
      }
    }
    Object localObject = new HashMap();
    ((Map)localObject).put("downloadId", Long.valueOf(this.hyK));
    this.gPA.h(this.bxX, this.hyA.j("ok", (Map)localObject));
    AppMethodBeat.o(130664);
  }
  
  public final void f(Parcel paramParcel)
  {
    boolean bool = true;
    AppMethodBeat.i(130665);
    this.hyB = paramParcel.readString();
    this.hyC = paramParcel.readString();
    this.hyD = paramParcel.readString();
    this.hyE = paramParcel.readString();
    this.hyF = paramParcel.readLong();
    this.hyG = paramParcel.readString();
    this.hyH = paramParcel.readString();
    this.mAppId = paramParcel.readString();
    this.mPackageName = paramParcel.readString();
    if (paramParcel.readInt() == 1) {}
    for (;;)
    {
      this.hyI = bool;
      this.hyJ = paramParcel.readString();
      this.hyK = paramParcel.readLong();
      AppMethodBeat.o(130665);
      return;
      bool = false;
    }
  }
  
  public void writeToParcel(Parcel paramParcel, int paramInt)
  {
    AppMethodBeat.i(130666);
    paramParcel.writeString(this.hyB);
    paramParcel.writeString(this.hyC);
    paramParcel.writeString(this.hyD);
    paramParcel.writeString(this.hyE);
    paramParcel.writeLong(this.hyF);
    paramParcel.writeString(this.hyG);
    paramParcel.writeString(this.hyH);
    paramParcel.writeString(this.mAppId);
    paramParcel.writeString(this.mPackageName);
    if (this.hyI) {}
    for (paramInt = 1;; paramInt = 0)
    {
      paramParcel.writeInt(paramInt);
      paramParcel.writeString(this.hyJ);
      paramParcel.writeLong(this.hyK);
      AppMethodBeat.o(130666);
      return;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.jsapi.appdownload.JsApiAddDownloadTaskStraight.AddDownloadTaskStraightTask
 * JD-Core Version:    0.7.0.1
 */