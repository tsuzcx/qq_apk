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

public final class JsApiAddDownloadTaskStraight
  extends c<y>
{
  public static final int CTRL_INDEX = 440;
  public static final String NAME = "addDownloadTaskStraight";
  
  static class AddDownloadTaskStraightTask
    extends MainProcessTask
  {
    public static final Parcelable.Creator<AddDownloadTaskStraightTask> CREATOR;
    private int eit;
    private String mAppId;
    private String mPackageName;
    private y qsi;
    private p ryT;
    private String ryU;
    private String ryV;
    private String ryW;
    private String ryX;
    private long ryY;
    private String ryZ;
    private String rza;
    private boolean rzb;
    private String rzc;
    private long rzd;
    
    static
    {
      AppMethodBeat.i(45769);
      CREATOR = new Parcelable.Creator() {};
      AppMethodBeat.o(45769);
    }
    
    public AddDownloadTaskStraightTask(Parcel paramParcel)
    {
      AppMethodBeat.i(45764);
      h(paramParcel);
      AppMethodBeat.o(45764);
    }
    
    public AddDownloadTaskStraightTask(p paramp, y paramy, int paramInt, JSONObject paramJSONObject)
    {
      AppMethodBeat.i(45763);
      this.ryT = paramp;
      this.qsi = paramy;
      this.eit = paramInt;
      this.ryU = paramJSONObject.optString("taskName");
      this.ryV = paramJSONObject.optString("taskUrl");
      this.ryW = paramJSONObject.optString("fileMd5");
      this.ryX = paramJSONObject.optString("alternativeUrl");
      this.ryY = paramJSONObject.optInt("taskSize", 0);
      this.ryZ = paramJSONObject.optString("extInfo");
      this.rza = paramJSONObject.optString("fileType");
      this.mAppId = paramy.getAppId();
      this.mPackageName = paramJSONObject.optString("packageName");
      this.rzb = true;
      AppMethodBeat.o(45763);
    }
    
    public final void asn()
    {
      AppMethodBeat.i(45765);
      h.baF();
      if (!h.baE().isSDCardAvailable()) {
        this.rzc = "fail_sdcard_not_ready";
      }
      for (;;)
      {
        cpA();
        AppMethodBeat.o(45765);
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
          Log.i("MicroMsg.JsApiAddDownloadTaskStraight", "runInMainProcess taskUrl:%s md5:%s", new Object[] { this.ryV, this.ryW });
          Object localObject = new g.a();
          ((g.a)localObject).amR(this.ryV);
          ((g.a)localObject).amS(this.ryX);
          ((g.a)localObject).setFileSize(this.ryY);
          ((g.a)localObject).amT(this.ryU);
          ((g.a)localObject).setFileMD5(this.ryW);
          ((g.a)localObject).setAppId(this.mAppId);
          ((g.a)localObject).setPackageName(this.mPackageName);
          ((g.a)localObject).nA(true);
          ((g.a)localObject).JA(Util.getInt(this.rza, 1));
          ((g.a)localObject).setScene(6001);
          ((g.a)localObject).QX(this.ryZ);
          localObject = ((g.a)localObject).xoe;
          long l = com.tencent.mm.plugin.downloader.model.f.duv().a((g)localObject);
          Log.i("MicroMsg.JsApiAddDownloadTaskStraight", "doAddDownloadTaskStraight, downloadId = ".concat(String.valueOf(l)));
          if (l <= 0L)
          {
            Log.e("MicroMsg.JsApiAddDownloadTaskStraight", "doAddDownloadTaskStraight fail, downloadId = ".concat(String.valueOf(l)));
            this.rzc = "";
          }
          else
          {
            this.rzb = false;
            this.rzd = l;
          }
        }
      }
    }
    
    public final void bQr()
    {
      AppMethodBeat.i(45766);
      Object localObject;
      if (this.rzb) {
        if (Util.isNullOrNil(this.rzc))
        {
          localObject = "fail";
          this.qsi.callback(this.eit, this.ryT.ZP((String)localObject));
        }
      }
      for (;;)
      {
        cpx();
        AppMethodBeat.o(45766);
        return;
        localObject = String.format("fail:%s", new Object[] { this.rzc });
        break;
        localObject = new HashMap();
        ((Map)localObject).put("downloadId", Long.valueOf(this.rzd));
        this.qsi.callback(this.eit, this.ryT.m("ok", (Map)localObject));
      }
    }
    
    public final void h(Parcel paramParcel)
    {
      boolean bool = true;
      AppMethodBeat.i(45767);
      this.ryU = paramParcel.readString();
      this.ryV = paramParcel.readString();
      this.ryW = paramParcel.readString();
      this.ryX = paramParcel.readString();
      this.ryY = paramParcel.readLong();
      this.ryZ = paramParcel.readString();
      this.rza = paramParcel.readString();
      this.mAppId = paramParcel.readString();
      this.mPackageName = paramParcel.readString();
      if (paramParcel.readInt() == 1) {}
      for (;;)
      {
        this.rzb = bool;
        this.rzc = paramParcel.readString();
        this.rzd = paramParcel.readLong();
        AppMethodBeat.o(45767);
        return;
        bool = false;
      }
    }
    
    public void writeToParcel(Parcel paramParcel, int paramInt)
    {
      AppMethodBeat.i(45768);
      paramParcel.writeString(this.ryU);
      paramParcel.writeString(this.ryV);
      paramParcel.writeString(this.ryW);
      paramParcel.writeString(this.ryX);
      paramParcel.writeLong(this.ryY);
      paramParcel.writeString(this.ryZ);
      paramParcel.writeString(this.rza);
      paramParcel.writeString(this.mAppId);
      paramParcel.writeString(this.mPackageName);
      if (this.rzb) {}
      for (paramInt = 1;; paramInt = 0)
      {
        paramParcel.writeInt(paramInt);
        paramParcel.writeString(this.rzc);
        paramParcel.writeLong(this.rzd);
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