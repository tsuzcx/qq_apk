package com.tencent.mm.plugin.appbrand.jsapi.appdownload;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.appbrand.ipc.MainProcessTask;
import com.tencent.mm.plugin.appbrand.jsapi.a;
import com.tencent.mm.plugin.appbrand.jsapi.m;
import com.tencent.mm.plugin.appbrand.q;
import com.tencent.mm.plugin.downloader.model.f;
import com.tencent.mm.plugin.downloader.model.g.a;
import com.tencent.mm.sdk.platformtools.ad;
import com.tencent.mm.sdk.platformtools.bt;
import java.util.HashMap;
import java.util.Map;
import org.json.JSONObject;

public final class JsApiAddDownloadTask
  extends a<q>
{
  public static final int CTRL_INDEX = 474;
  public static final String NAME = "addDownloadTask";
  
  static class AddDownloadTask
    extends MainProcessTask
  {
    public static final Parcelable.Creator<AddDownloadTask> CREATOR;
    private int cgA;
    private q jwH;
    private m ksO;
    private String ksP;
    private String ksQ;
    private String ksR;
    private long ksT;
    private String ksU;
    private String ksV;
    private boolean ksW;
    private String ksX;
    private long ksY;
    private boolean kud;
    private boolean kvq;
    private int kvr;
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
      e(paramParcel);
      AppMethodBeat.o(45745);
    }
    
    public AddDownloadTask(m paramm, q paramq, int paramInt, JSONObject paramJSONObject)
    {
      AppMethodBeat.i(45744);
      bhN();
      this.ksO = paramm;
      this.jwH = paramq;
      this.cgA = paramInt;
      this.ksP = paramJSONObject.optString("taskName");
      this.ksQ = paramJSONObject.optString("taskUrl");
      this.ksR = paramJSONObject.optString("fileMd5");
      this.ksT = paramJSONObject.optInt("taskSize", 0);
      this.ksU = paramJSONObject.optString("extInfo");
      this.ksV = paramJSONObject.optString("fileType");
      this.mAppId = paramJSONObject.optString("appId");
      this.mPackageName = paramJSONObject.optString("packageName");
      this.kud = paramJSONObject.optBoolean("downloadInWifi", false);
      this.kvq = paramJSONObject.optBoolean("showNotification", false);
      this.kvr = paramJSONObject.optInt("downloaderType", 0);
      this.ksW = true;
      AppMethodBeat.o(45744);
    }
    
    public final void aOA()
    {
      AppMethodBeat.i(45746);
      com.tencent.mm.kernel.g.ajD();
      if (!com.tencent.mm.kernel.g.ajC().isSDCardAvailable()) {
        this.ksX = "fail_sdcard_not_ready";
      }
      for (;;)
      {
        bhX();
        AppMethodBeat.o(45746);
        return;
        if ((this.ksT > 0L) && (!com.tencent.mm.compatible.util.e.qR(this.ksT)))
        {
          this.ksX = "fail_sdcard_has_not_enough_space";
        }
        else if (bt.isNullOrNil(this.ksQ))
        {
          this.ksX = "fail_invalid_url";
        }
        else
        {
          ad.i("MicroMsg.JsApiAddDownloadTask", "runInMainProcess taskUrl:%s md5:%s", new Object[] { this.ksQ, this.ksR });
          Object localObject = new g.a();
          ((g.a)localObject).aak(this.ksQ);
          ((g.a)localObject).ui(this.ksT);
          ((g.a)localObject).aam(this.ksP);
          ((g.a)localObject).aan(this.ksR);
          ((g.a)localObject).setAppId(this.mAppId);
          ((g.a)localObject).ft(this.mPackageName);
          ((g.a)localObject).jQ(true);
          ((g.a)localObject).Bp(bt.getInt(this.ksV, 1));
          ((g.a)localObject).setScene(6001);
          ((g.a)localObject).aao(this.ksU);
          ((g.a)localObject).jR(this.kvq);
          ((g.a)localObject).jT(this.kud);
          ((g.a)localObject).jQ(false);
          ((g.a)localObject).cct();
          localObject = ((g.a)localObject).pmN;
          if (this.kvr == 1) {}
          for (long l = f.ccl().b((com.tencent.mm.plugin.downloader.model.g)localObject);; l = f.ccl().a((com.tencent.mm.plugin.downloader.model.g)localObject))
          {
            ad.i("MicroMsg.JsApiAddDownloadTask", "doAddDownloadTaskStraight, downloadId = ".concat(String.valueOf(l)));
            if (l > 0L) {
              break label297;
            }
            ad.e("MicroMsg.JsApiAddDownloadTask", "doAddDownloadTaskStraight fail, downloadId = ".concat(String.valueOf(l)));
            this.ksX = "";
            break;
          }
          label297:
          this.ksW = false;
          this.ksY = l;
        }
      }
    }
    
    public final void aOB()
    {
      AppMethodBeat.i(45747);
      bhO();
      if (this.ksW)
      {
        if (bt.isNullOrNil(this.ksX)) {}
        for (localObject = "fail";; localObject = String.format("fail:%s", new Object[] { this.ksX }))
        {
          this.jwH.h(this.cgA, this.ksO.e((String)localObject, null));
          AppMethodBeat.o(45747);
          return;
        }
      }
      Object localObject = new HashMap();
      ((Map)localObject).put("downloadId", Long.valueOf(this.ksY));
      this.jwH.h(this.cgA, this.ksO.m("ok", (Map)localObject));
      AppMethodBeat.o(45747);
    }
    
    public final void e(Parcel paramParcel)
    {
      boolean bool2 = true;
      AppMethodBeat.i(45748);
      this.ksP = paramParcel.readString();
      this.ksQ = paramParcel.readString();
      this.ksR = paramParcel.readString();
      this.ksT = paramParcel.readLong();
      this.ksU = paramParcel.readString();
      this.ksV = paramParcel.readString();
      this.mAppId = paramParcel.readString();
      this.mPackageName = paramParcel.readString();
      if (paramParcel.readByte() == 1)
      {
        bool1 = true;
        this.kud = bool1;
        if (paramParcel.readByte() != 1) {
          break label153;
        }
        bool1 = true;
        label97:
        this.kvq = bool1;
        this.kvr = paramParcel.readInt();
        if (paramParcel.readInt() != 1) {
          break label158;
        }
      }
      label153:
      label158:
      for (boolean bool1 = bool2;; bool1 = false)
      {
        this.ksW = bool1;
        this.ksX = paramParcel.readString();
        this.ksY = paramParcel.readLong();
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
      paramParcel.writeString(this.ksP);
      paramParcel.writeString(this.ksQ);
      paramParcel.writeString(this.ksR);
      paramParcel.writeLong(this.ksT);
      paramParcel.writeString(this.ksU);
      paramParcel.writeString(this.ksV);
      paramParcel.writeString(this.mAppId);
      paramParcel.writeString(this.mPackageName);
      byte b;
      if (this.kud)
      {
        b = 1;
        paramParcel.writeByte(b);
        if (!this.kvq) {
          break label148;
        }
        b = 1;
        label95:
        paramParcel.writeByte(b);
        paramParcel.writeInt(this.kvr);
        if (!this.ksW) {
          break label153;
        }
      }
      for (;;)
      {
        paramParcel.writeInt(paramInt);
        paramParcel.writeString(this.ksX);
        paramParcel.writeLong(this.ksY);
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