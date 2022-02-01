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

public final class JsApiAddDownloadTask
  extends d<s>
{
  public static final int CTRL_INDEX = 474;
  public static final String NAME = "addDownloadTask";
  
  static class AddDownloadTask
    extends MainProcessTask
  {
    public static final Parcelable.Creator<AddDownloadTask> CREATOR;
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
    private boolean lCY;
    private int lCZ;
    private String mAppId;
    private String mPackageName;
    
    static
    {
      AppMethodBeat.i(45750);
      CREATOR = new Parcelable.Creator() {};
      AppMethodBeat.o(45750);
    }
    
    public AddDownloadTask(Parcel paramParcel)
    {
      AppMethodBeat.i(45745);
      f(paramParcel);
      AppMethodBeat.o(45745);
    }
    
    public AddDownloadTask(p paramp, s params, int paramInt, JSONObject paramJSONObject)
    {
      AppMethodBeat.i(45744);
      bDJ();
      this.lAi = paramp;
      this.kAr = params;
      this.csv = paramInt;
      this.lAj = paramJSONObject.optString("taskName");
      this.lAk = paramJSONObject.optString("taskUrl");
      this.lAl = paramJSONObject.optString("fileMd5");
      this.lAn = paramJSONObject.optInt("taskSize", 0);
      this.lAo = paramJSONObject.optString("extInfo");
      this.lAp = paramJSONObject.optString("fileType");
      this.mAppId = paramJSONObject.optString("appId");
      this.mPackageName = paramJSONObject.optString("packageName");
      this.lBG = paramJSONObject.optBoolean("downloadInWifi", false);
      this.lCY = paramJSONObject.optBoolean("showNotification", false);
      this.lCZ = paramJSONObject.optInt("downloaderType", 0);
      this.lAq = true;
      AppMethodBeat.o(45744);
    }
    
    public final void bjj()
    {
      AppMethodBeat.i(45746);
      com.tencent.mm.kernel.g.aAi();
      if (!com.tencent.mm.kernel.g.aAh().isSDCardAvailable()) {
        this.lAr = "fail_sdcard_not_ready";
      }
      for (;;)
      {
        bDU();
        AppMethodBeat.o(45746);
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
          Log.i("MicroMsg.JsApiAddDownloadTask", "runInMainProcess taskUrl:%s md5:%s", new Object[] { this.lAk, this.lAl });
          Object localObject = new g.a();
          ((g.a)localObject).alj(this.lAk);
          ((g.a)localObject).setFileSize(this.lAn);
          ((g.a)localObject).all(this.lAj);
          ((g.a)localObject).setFileMD5(this.lAl);
          ((g.a)localObject).setAppId(this.mAppId);
          ((g.a)localObject).gm(this.mPackageName);
          ((g.a)localObject).kS(true);
          ((g.a)localObject).Fl(Util.getInt(this.lAp, 1));
          ((g.a)localObject).setScene(6001);
          ((g.a)localObject).Rv(this.lAo);
          ((g.a)localObject).kT(this.lCY);
          ((g.a)localObject).kV(this.lBG);
          ((g.a)localObject).kS(false);
          ((g.a)localObject).cBD();
          localObject = ((g.a)localObject).qIY;
          if (this.lCZ == 1) {}
          for (long l = f.cBv().b((com.tencent.mm.plugin.downloader.model.g)localObject);; l = f.cBv().a((com.tencent.mm.plugin.downloader.model.g)localObject))
          {
            Log.i("MicroMsg.JsApiAddDownloadTask", "doAddDownloadTaskStraight, downloadId = ".concat(String.valueOf(l)));
            if (l > 0L) {
              break label297;
            }
            Log.e("MicroMsg.JsApiAddDownloadTask", "doAddDownloadTaskStraight fail, downloadId = ".concat(String.valueOf(l)));
            this.lAr = "";
            break;
          }
          label297:
          this.lAq = false;
          this.lAs = l;
        }
      }
    }
    
    public final void bjk()
    {
      AppMethodBeat.i(45747);
      bDK();
      if (this.lAq)
      {
        if (Util.isNullOrNil(this.lAr)) {}
        for (localObject = "fail";; localObject = String.format("fail:%s", new Object[] { this.lAr }))
        {
          this.kAr.i(this.csv, this.lAi.h((String)localObject, null));
          AppMethodBeat.o(45747);
          return;
        }
      }
      Object localObject = new HashMap();
      ((Map)localObject).put("downloadId", Long.valueOf(this.lAs));
      this.kAr.i(this.csv, this.lAi.n("ok", (Map)localObject));
      AppMethodBeat.o(45747);
    }
    
    public final void f(Parcel paramParcel)
    {
      boolean bool2 = true;
      AppMethodBeat.i(45748);
      this.lAj = paramParcel.readString();
      this.lAk = paramParcel.readString();
      this.lAl = paramParcel.readString();
      this.lAn = paramParcel.readLong();
      this.lAo = paramParcel.readString();
      this.lAp = paramParcel.readString();
      this.mAppId = paramParcel.readString();
      this.mPackageName = paramParcel.readString();
      if (paramParcel.readByte() == 1)
      {
        bool1 = true;
        this.lBG = bool1;
        if (paramParcel.readByte() != 1) {
          break label153;
        }
        bool1 = true;
        label97:
        this.lCY = bool1;
        this.lCZ = paramParcel.readInt();
        if (paramParcel.readInt() != 1) {
          break label158;
        }
      }
      label153:
      label158:
      for (boolean bool1 = bool2;; bool1 = false)
      {
        this.lAq = bool1;
        this.lAr = paramParcel.readString();
        this.lAs = paramParcel.readLong();
        AppMethodBeat.o(45748);
        return;
        bool1 = false;
        break;
        bool1 = false;
        break label97;
      }
    }
    
    public void writeToParcel(Parcel paramParcel, int paramInt)
    {
      paramInt = 1;
      AppMethodBeat.i(45749);
      paramParcel.writeString(this.lAj);
      paramParcel.writeString(this.lAk);
      paramParcel.writeString(this.lAl);
      paramParcel.writeLong(this.lAn);
      paramParcel.writeString(this.lAo);
      paramParcel.writeString(this.lAp);
      paramParcel.writeString(this.mAppId);
      paramParcel.writeString(this.mPackageName);
      byte b;
      if (this.lBG)
      {
        b = 1;
        paramParcel.writeByte(b);
        if (!this.lCY) {
          break label148;
        }
        b = 1;
        label95:
        paramParcel.writeByte(b);
        paramParcel.writeInt(this.lCZ);
        if (!this.lAq) {
          break label153;
        }
      }
      for (;;)
      {
        paramParcel.writeInt(paramInt);
        paramParcel.writeString(this.lAr);
        paramParcel.writeLong(this.lAs);
        AppMethodBeat.o(45749);
        return;
        b = 0;
        break;
        label148:
        b = 0;
        break label95;
        label153:
        paramInt = 0;
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.jsapi.appdownload.JsApiAddDownloadTask
 * JD-Core Version:    0.7.0.1
 */