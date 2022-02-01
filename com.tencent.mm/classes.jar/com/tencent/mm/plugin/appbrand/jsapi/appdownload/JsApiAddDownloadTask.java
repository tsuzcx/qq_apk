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
import com.tencent.mm.sdk.platformtools.ac;
import com.tencent.mm.sdk.platformtools.bs;
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
    private boolean kaU;
    private int kaV;
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
      bej();
      this.jYs = paramm;
      this.jdy = paramq;
      this.bWl = paramInt;
      this.jYt = paramJSONObject.optString("taskName");
      this.jYu = paramJSONObject.optString("taskUrl");
      this.jYv = paramJSONObject.optString("fileMd5");
      this.jYx = paramJSONObject.optInt("taskSize", 0);
      this.jYy = paramJSONObject.optString("extInfo");
      this.jYz = paramJSONObject.optString("fileType");
      this.mAppId = paramJSONObject.optString("appId");
      this.mPackageName = paramJSONObject.optString("packageName");
      this.jZH = paramJSONObject.optBoolean("downloadInWifi", false);
      this.kaU = paramJSONObject.optBoolean("showNotification", false);
      this.kaV = paramJSONObject.optInt("downloaderType", 0);
      this.jYA = true;
      AppMethodBeat.o(45744);
    }
    
    public final void aLq()
    {
      AppMethodBeat.i(45746);
      com.tencent.mm.kernel.g.agS();
      if (!com.tencent.mm.kernel.g.agR().isSDCardAvailable()) {
        this.jYB = "fail_sdcard_not_ready";
      }
      for (;;)
      {
        bet();
        AppMethodBeat.o(45746);
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
          ac.i("MicroMsg.JsApiAddDownloadTask", "runInMainProcess taskUrl:%s md5:%s", new Object[] { this.jYu, this.jYv });
          Object localObject = new g.a();
          ((g.a)localObject).WD(this.jYu);
          ((g.a)localObject).sk(this.jYx);
          ((g.a)localObject).WF(this.jYt);
          ((g.a)localObject).WG(this.jYv);
          ((g.a)localObject).setAppId(this.mAppId);
          ((g.a)localObject).ey(this.mPackageName);
          ((g.a)localObject).jF(true);
          ((g.a)localObject).AG(bs.getInt(this.jYz, 1));
          ((g.a)localObject).setScene(6001);
          ((g.a)localObject).WH(this.jYy);
          ((g.a)localObject).jG(this.kaU);
          ((g.a)localObject).jI(this.jZH);
          ((g.a)localObject).jF(false);
          ((g.a)localObject).bXR();
          localObject = ((g.a)localObject).oJg;
          if (this.kaV == 1) {}
          for (long l = f.bXJ().b((com.tencent.mm.plugin.downloader.model.g)localObject);; l = f.bXJ().a((com.tencent.mm.plugin.downloader.model.g)localObject))
          {
            ac.i("MicroMsg.JsApiAddDownloadTask", "doAddDownloadTaskStraight, downloadId = ".concat(String.valueOf(l)));
            if (l > 0L) {
              break label297;
            }
            ac.e("MicroMsg.JsApiAddDownloadTask", "doAddDownloadTaskStraight fail, downloadId = ".concat(String.valueOf(l)));
            this.jYB = "";
            break;
          }
          label297:
          this.jYA = false;
          this.jYC = l;
        }
      }
    }
    
    public final void aLr()
    {
      AppMethodBeat.i(45747);
      bek();
      if (this.jYA)
      {
        if (bs.isNullOrNil(this.jYB)) {}
        for (localObject = "fail";; localObject = String.format("fail:%s", new Object[] { this.jYB }))
        {
          this.jdy.h(this.bWl, this.jYs.e((String)localObject, null));
          AppMethodBeat.o(45747);
          return;
        }
      }
      Object localObject = new HashMap();
      ((Map)localObject).put("downloadId", Long.valueOf(this.jYC));
      this.jdy.h(this.bWl, this.jYs.k("ok", (Map)localObject));
      AppMethodBeat.o(45747);
    }
    
    public final void e(Parcel paramParcel)
    {
      boolean bool2 = true;
      AppMethodBeat.i(45748);
      this.jYt = paramParcel.readString();
      this.jYu = paramParcel.readString();
      this.jYv = paramParcel.readString();
      this.jYx = paramParcel.readLong();
      this.jYy = paramParcel.readString();
      this.jYz = paramParcel.readString();
      this.mAppId = paramParcel.readString();
      this.mPackageName = paramParcel.readString();
      if (paramParcel.readByte() == 1)
      {
        bool1 = true;
        this.jZH = bool1;
        if (paramParcel.readByte() != 1) {
          break label153;
        }
        bool1 = true;
        label97:
        this.kaU = bool1;
        this.kaV = paramParcel.readInt();
        if (paramParcel.readInt() != 1) {
          break label158;
        }
      }
      label153:
      label158:
      for (boolean bool1 = bool2;; bool1 = false)
      {
        this.jYA = bool1;
        this.jYB = paramParcel.readString();
        this.jYC = paramParcel.readLong();
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
      paramParcel.writeString(this.jYt);
      paramParcel.writeString(this.jYu);
      paramParcel.writeString(this.jYv);
      paramParcel.writeLong(this.jYx);
      paramParcel.writeString(this.jYy);
      paramParcel.writeString(this.jYz);
      paramParcel.writeString(this.mAppId);
      paramParcel.writeString(this.mPackageName);
      byte b;
      if (this.jZH)
      {
        b = 1;
        paramParcel.writeByte(b);
        if (!this.kaU) {
          break label148;
        }
        b = 1;
        label95:
        paramParcel.writeByte(b);
        paramParcel.writeInt(this.kaV);
        if (!this.jYA) {
          break label153;
        }
      }
      for (;;)
      {
        paramParcel.writeInt(paramInt);
        paramParcel.writeString(this.jYB);
        paramParcel.writeLong(this.jYC);
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