package com.tencent.mm.plugin.appbrand.jsapi.appdownload;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.compatible.util.e;
import com.tencent.mm.kernel.h;
import com.tencent.mm.plugin.appbrand.ipc.MainProcessTask;
import com.tencent.mm.plugin.appbrand.jsapi.c;
import com.tencent.mm.plugin.appbrand.jsapi.p;
import com.tencent.mm.plugin.appbrand.y;
import com.tencent.mm.plugin.downloader.model.g;
import com.tencent.mm.plugin.downloader.model.g.a;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.Util;
import java.util.HashMap;
import java.util.Map;
import org.json.JSONObject;

public final class JsApiAddDownloadTask
  extends c<y>
{
  public static final int CTRL_INDEX = 474;
  public static final String NAME = "addDownloadTask";
  
  static class AddDownloadTask
    extends MainProcessTask
  {
    public static final Parcelable.Creator<AddDownloadTask> CREATOR;
    private int eit;
    private String mAppId;
    private String mPackageName;
    private y qsi;
    private boolean rAz;
    private boolean rCs;
    private int rCt;
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
      AppMethodBeat.i(45750);
      CREATOR = new Parcelable.Creator() {};
      AppMethodBeat.o(45750);
    }
    
    public AddDownloadTask(Parcel paramParcel)
    {
      AppMethodBeat.i(45745);
      h(paramParcel);
      AppMethodBeat.o(45745);
    }
    
    public AddDownloadTask(p paramp, y paramy, int paramInt, JSONObject paramJSONObject)
    {
      AppMethodBeat.i(45744);
      this.ryT = paramp;
      this.qsi = paramy;
      this.eit = paramInt;
      this.ryU = paramJSONObject.optString("taskName");
      this.ryV = paramJSONObject.optString("taskUrl");
      this.ryW = paramJSONObject.optString("fileMd5");
      this.ryY = paramJSONObject.optInt("taskSize", 0);
      this.ryZ = paramJSONObject.optString("extInfo");
      this.rza = paramJSONObject.optString("fileType");
      this.mAppId = paramJSONObject.optString("appId");
      this.mPackageName = paramJSONObject.optString("packageName");
      this.rAz = paramJSONObject.optBoolean("downloadInWifi", false);
      this.rCs = paramJSONObject.optBoolean("showNotification", false);
      this.rCt = paramJSONObject.optInt("downloaderType", 0);
      this.rzb = true;
      AppMethodBeat.o(45744);
    }
    
    public final void asn()
    {
      AppMethodBeat.i(45746);
      h.baF();
      if (!h.baE().isSDCardAvailable()) {
        this.rzc = "fail_sdcard_not_ready";
      }
      for (;;)
      {
        cpA();
        AppMethodBeat.o(45746);
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
          Log.i("MicroMsg.JsApiAddDownloadTask", "runInMainProcess taskUrl:%s md5:%s", new Object[] { this.ryV, this.ryW });
          Object localObject = new g.a();
          ((g.a)localObject).amR(this.ryV);
          ((g.a)localObject).setFileSize(this.ryY);
          ((g.a)localObject).amT(this.ryU);
          ((g.a)localObject).setFileMD5(this.ryW);
          ((g.a)localObject).setAppId(this.mAppId);
          ((g.a)localObject).setPackageName(this.mPackageName);
          ((g.a)localObject).nA(true);
          ((g.a)localObject).JA(Util.getInt(this.rza, 1));
          ((g.a)localObject).setScene(6001);
          ((g.a)localObject).QX(this.ryZ);
          ((g.a)localObject).nB(this.rCs);
          ((g.a)localObject).nD(this.rAz);
          ((g.a)localObject).nA(false);
          ((g.a)localObject).duD();
          localObject = ((g.a)localObject).xoe;
          if (this.rCt == 1) {}
          for (long l = com.tencent.mm.plugin.downloader.model.f.duv().b((g)localObject);; l = com.tencent.mm.plugin.downloader.model.f.duv().a((g)localObject))
          {
            Log.i("MicroMsg.JsApiAddDownloadTask", "doAddDownloadTaskStraight, downloadId = ".concat(String.valueOf(l)));
            if (l > 0L) {
              break label297;
            }
            Log.e("MicroMsg.JsApiAddDownloadTask", "doAddDownloadTaskStraight fail, downloadId = ".concat(String.valueOf(l)));
            this.rzc = "";
            break;
          }
          label297:
          this.rzb = false;
          this.rzd = l;
        }
      }
    }
    
    public final void bQr()
    {
      AppMethodBeat.i(45747);
      cpx();
      if (this.rzb)
      {
        if (Util.isNullOrNil(this.rzc)) {}
        for (localObject = "fail";; localObject = String.format("fail:%s", new Object[] { this.rzc }))
        {
          this.qsi.callback(this.eit, this.ryT.ZP((String)localObject));
          AppMethodBeat.o(45747);
          return;
        }
      }
      Object localObject = new HashMap();
      ((Map)localObject).put("downloadId", Long.valueOf(this.rzd));
      this.qsi.callback(this.eit, this.ryT.m("ok", (Map)localObject));
      AppMethodBeat.o(45747);
    }
    
    public final void h(Parcel paramParcel)
    {
      boolean bool2 = true;
      AppMethodBeat.i(45748);
      this.ryU = paramParcel.readString();
      this.ryV = paramParcel.readString();
      this.ryW = paramParcel.readString();
      this.ryY = paramParcel.readLong();
      this.ryZ = paramParcel.readString();
      this.rza = paramParcel.readString();
      this.mAppId = paramParcel.readString();
      this.mPackageName = paramParcel.readString();
      if (paramParcel.readByte() == 1)
      {
        bool1 = true;
        this.rAz = bool1;
        if (paramParcel.readByte() != 1) {
          break label153;
        }
        bool1 = true;
        label97:
        this.rCs = bool1;
        this.rCt = paramParcel.readInt();
        if (paramParcel.readInt() != 1) {
          break label158;
        }
      }
      label153:
      label158:
      for (boolean bool1 = bool2;; bool1 = false)
      {
        this.rzb = bool1;
        this.rzc = paramParcel.readString();
        this.rzd = paramParcel.readLong();
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
      paramParcel.writeString(this.ryU);
      paramParcel.writeString(this.ryV);
      paramParcel.writeString(this.ryW);
      paramParcel.writeLong(this.ryY);
      paramParcel.writeString(this.ryZ);
      paramParcel.writeString(this.rza);
      paramParcel.writeString(this.mAppId);
      paramParcel.writeString(this.mPackageName);
      byte b;
      if (this.rAz)
      {
        b = 1;
        paramParcel.writeByte(b);
        if (!this.rCs) {
          break label148;
        }
        b = 1;
        label95:
        paramParcel.writeByte(b);
        paramParcel.writeInt(this.rCt);
        if (!this.rzb) {
          break label153;
        }
      }
      for (;;)
      {
        paramParcel.writeInt(paramInt);
        paramParcel.writeString(this.rzc);
        paramParcel.writeLong(this.rzd);
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