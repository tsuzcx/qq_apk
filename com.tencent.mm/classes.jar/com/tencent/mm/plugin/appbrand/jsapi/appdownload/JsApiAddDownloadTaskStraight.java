package com.tencent.mm.plugin.appbrand.jsapi.appdownload;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.appbrand.ipc.MainProcessTask;
import com.tencent.mm.plugin.appbrand.jsapi.d;
import com.tencent.mm.plugin.appbrand.jsapi.p;
import com.tencent.mm.plugin.appbrand.s;
import com.tencent.mm.plugin.downloader.model.f;
import com.tencent.mm.plugin.downloader.model.g.a;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.Util;
import java.util.HashMap;
import java.util.Map;
import org.json.JSONObject;

public final class JsApiAddDownloadTaskStraight
  extends d<s>
{
  public static final int CTRL_INDEX = 440;
  public static final String NAME = "addDownloadTaskStraight";
  
  static class AddDownloadTaskStraightTask
    extends MainProcessTask
  {
    public static final Parcelable.Creator<AddDownloadTaskStraightTask> CREATOR;
    private int csv;
    private s kAr;
    private p lAi;
    private String lAj;
    private String lAk;
    private String lAl;
    private String lAm;
    private long lAn;
    private String lAo;
    private String lAp;
    private boolean lAq;
    private String lAr;
    private long lAs;
    private String mAppId;
    private String mPackageName;
    
    static
    {
      AppMethodBeat.i(45769);
      CREATOR = new Parcelable.Creator() {};
      AppMethodBeat.o(45769);
    }
    
    public AddDownloadTaskStraightTask(Parcel paramParcel)
    {
      AppMethodBeat.i(45764);
      f(paramParcel);
      AppMethodBeat.o(45764);
    }
    
    public AddDownloadTaskStraightTask(p paramp, s params, int paramInt, JSONObject paramJSONObject)
    {
      AppMethodBeat.i(45763);
      this.lAi = paramp;
      this.kAr = params;
      this.csv = paramInt;
      this.lAj = paramJSONObject.optString("taskName");
      this.lAk = paramJSONObject.optString("taskUrl");
      this.lAl = paramJSONObject.optString("fileMd5");
      this.lAm = paramJSONObject.optString("alternativeUrl");
      this.lAn = paramJSONObject.optInt("taskSize", 0);
      this.lAo = paramJSONObject.optString("extInfo");
      this.lAp = paramJSONObject.optString("fileType");
      this.mAppId = params.getAppId();
      this.mPackageName = paramJSONObject.optString("packageName");
      this.lAq = true;
      AppMethodBeat.o(45763);
    }
    
    public final void bjj()
    {
      AppMethodBeat.i(45765);
      com.tencent.mm.kernel.g.aAi();
      if (!com.tencent.mm.kernel.g.aAh().isSDCardAvailable()) {
        this.lAr = "fail_sdcard_not_ready";
      }
      for (;;)
      {
        bDU();
        AppMethodBeat.o(45765);
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
          Log.i("MicroMsg.JsApiAddDownloadTaskStraight", "runInMainProcess taskUrl:%s md5:%s", new Object[] { this.lAk, this.lAl });
          Object localObject = new g.a();
          ((g.a)localObject).alj(this.lAk);
          ((g.a)localObject).alk(this.lAm);
          ((g.a)localObject).setFileSize(this.lAn);
          ((g.a)localObject).all(this.lAj);
          ((g.a)localObject).setFileMD5(this.lAl);
          ((g.a)localObject).setAppId(this.mAppId);
          ((g.a)localObject).gm(this.mPackageName);
          ((g.a)localObject).kS(true);
          ((g.a)localObject).Fl(Util.getInt(this.lAp, 1));
          ((g.a)localObject).setScene(6001);
          ((g.a)localObject).Rv(this.lAo);
          localObject = ((g.a)localObject).qIY;
          long l = f.cBv().a((com.tencent.mm.plugin.downloader.model.g)localObject);
          Log.i("MicroMsg.JsApiAddDownloadTaskStraight", "doAddDownloadTaskStraight, downloadId = ".concat(String.valueOf(l)));
          if (l <= 0L)
          {
            Log.e("MicroMsg.JsApiAddDownloadTaskStraight", "doAddDownloadTaskStraight fail, downloadId = ".concat(String.valueOf(l)));
            this.lAr = "";
          }
          else
          {
            this.lAq = false;
            this.lAs = l;
          }
        }
      }
    }
    
    public final void bjk()
    {
      AppMethodBeat.i(45766);
      if (this.lAq)
      {
        if (Util.isNullOrNil(this.lAr)) {}
        for (localObject = "fail";; localObject = String.format("fail:%s", new Object[] { this.lAr }))
        {
          this.kAr.i(this.csv, this.lAi.h((String)localObject, null));
          AppMethodBeat.o(45766);
          return;
        }
      }
      Object localObject = new HashMap();
      ((Map)localObject).put("downloadId", Long.valueOf(this.lAs));
      this.kAr.i(this.csv, this.lAi.n("ok", (Map)localObject));
      AppMethodBeat.o(45766);
    }
    
    public final void f(Parcel paramParcel)
    {
      boolean bool = true;
      AppMethodBeat.i(45767);
      this.lAj = paramParcel.readString();
      this.lAk = paramParcel.readString();
      this.lAl = paramParcel.readString();
      this.lAm = paramParcel.readString();
      this.lAn = paramParcel.readLong();
      this.lAo = paramParcel.readString();
      this.lAp = paramParcel.readString();
      this.mAppId = paramParcel.readString();
      this.mPackageName = paramParcel.readString();
      if (paramParcel.readInt() == 1) {}
      for (;;)
      {
        this.lAq = bool;
        this.lAr = paramParcel.readString();
        this.lAs = paramParcel.readLong();
        AppMethodBeat.o(45767);
        return;
        bool = false;
      }
    }
    
    public void writeToParcel(Parcel paramParcel, int paramInt)
    {
      AppMethodBeat.i(45768);
      paramParcel.writeString(this.lAj);
      paramParcel.writeString(this.lAk);
      paramParcel.writeString(this.lAl);
      paramParcel.writeString(this.lAm);
      paramParcel.writeLong(this.lAn);
      paramParcel.writeString(this.lAo);
      paramParcel.writeString(this.lAp);
      paramParcel.writeString(this.mAppId);
      paramParcel.writeString(this.mPackageName);
      if (this.lAq) {}
      for (paramInt = 1;; paramInt = 0)
      {
        paramParcel.writeInt(paramInt);
        paramParcel.writeString(this.lAr);
        paramParcel.writeLong(this.lAs);
        AppMethodBeat.o(45768);
        return;
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.jsapi.appdownload.JsApiAddDownloadTaskStraight
 * JD-Core Version:    0.7.0.1
 */