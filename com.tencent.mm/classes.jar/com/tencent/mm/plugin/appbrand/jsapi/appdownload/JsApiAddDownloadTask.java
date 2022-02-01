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
    private int bZo;
    private q iDy;
    private boolean jAy;
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
      aXm();
      this.jxX = paramm;
      this.iDy = paramq;
      this.bZo = paramInt;
      this.jxY = paramJSONObject.optString("taskName");
      this.jxZ = paramJSONObject.optString("taskUrl");
      this.jya = paramJSONObject.optString("fileMd5");
      this.jyc = paramJSONObject.optInt("taskSize", 0);
      this.jyd = paramJSONObject.optString("extInfo");
      this.jye = paramJSONObject.optString("fileType");
      this.mAppId = paramJSONObject.optString("appId");
      this.mPackageName = paramJSONObject.optString("packageName");
      this.jzk = paramJSONObject.optBoolean("downloadInWifi", false);
      this.jAy = paramJSONObject.optBoolean("showNotification", false);
      this.jAz = paramJSONObject.optInt("downloaderType", 0);
      this.jyf = true;
      AppMethodBeat.o(45744);
    }
    
    public final void aEA()
    {
      AppMethodBeat.i(45747);
      aXn();
      if (this.jyf)
      {
        if (bt.isNullOrNil(this.jyg)) {}
        for (localObject = "fail";; localObject = String.format("fail:%s", new Object[] { this.jyg }))
        {
          this.iDy.h(this.bZo, this.jxX.e((String)localObject, null));
          AppMethodBeat.o(45747);
          return;
        }
      }
      Object localObject = new HashMap();
      ((Map)localObject).put("downloadId", Long.valueOf(this.jyh));
      this.iDy.h(this.bZo, this.jxX.k("ok", (Map)localObject));
      AppMethodBeat.o(45747);
    }
    
    public final void aEz()
    {
      AppMethodBeat.i(45746);
      com.tencent.mm.kernel.g.afC();
      if (!com.tencent.mm.kernel.g.afB().isSDCardAvailable()) {
        this.jyg = "fail_sdcard_not_ready";
      }
      for (;;)
      {
        aXw();
        AppMethodBeat.o(45746);
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
          ad.i("MicroMsg.JsApiAddDownloadTask", "runInMainProcess taskUrl:%s md5:%s", new Object[] { this.jxZ, this.jya });
          Object localObject = new g.a();
          ((g.a)localObject).Sr(this.jxZ);
          ((g.a)localObject).oy(this.jyc);
          ((g.a)localObject).St(this.jxY);
          ((g.a)localObject).Su(this.jya);
          ((g.a)localObject).setAppId(this.mAppId);
          ((g.a)localObject).eI(this.mPackageName);
          ((g.a)localObject).jc(true);
          ((g.a)localObject).zO(bt.getInt(this.jye, 1));
          ((g.a)localObject).setScene(6001);
          ((g.a)localObject).Sv(this.jyd);
          ((g.a)localObject).jd(this.jAy);
          ((g.a)localObject).jf(this.jzk);
          ((g.a)localObject).jc(false);
          ((g.a)localObject).bQB();
          localObject = ((g.a)localObject).ofF;
          if (this.jAz == 1) {}
          for (long l = f.bQt().b((com.tencent.mm.plugin.downloader.model.g)localObject);; l = f.bQt().a((com.tencent.mm.plugin.downloader.model.g)localObject))
          {
            ad.i("MicroMsg.JsApiAddDownloadTask", "doAddDownloadTaskStraight, downloadId = ".concat(String.valueOf(l)));
            if (l > 0L) {
              break label298;
            }
            ad.e("MicroMsg.JsApiAddDownloadTask", "doAddDownloadTaskStraight fail, downloadId = ".concat(String.valueOf(l)));
            this.jyg = "";
            break;
          }
          label298:
          this.jyf = false;
          this.jyh = l;
        }
      }
    }
    
    public final void e(Parcel paramParcel)
    {
      boolean bool2 = true;
      AppMethodBeat.i(45748);
      this.jxY = paramParcel.readString();
      this.jxZ = paramParcel.readString();
      this.jya = paramParcel.readString();
      this.jyc = paramParcel.readLong();
      this.jyd = paramParcel.readString();
      this.jye = paramParcel.readString();
      this.mAppId = paramParcel.readString();
      this.mPackageName = paramParcel.readString();
      if (paramParcel.readByte() == 1)
      {
        bool1 = true;
        this.jzk = bool1;
        if (paramParcel.readByte() != 1) {
          break label153;
        }
        bool1 = true;
        label97:
        this.jAy = bool1;
        this.jAz = paramParcel.readInt();
        if (paramParcel.readInt() != 1) {
          break label158;
        }
      }
      label153:
      label158:
      for (boolean bool1 = bool2;; bool1 = false)
      {
        this.jyf = bool1;
        this.jyg = paramParcel.readString();
        this.jyh = paramParcel.readLong();
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
      paramParcel.writeString(this.jxY);
      paramParcel.writeString(this.jxZ);
      paramParcel.writeString(this.jya);
      paramParcel.writeLong(this.jyc);
      paramParcel.writeString(this.jyd);
      paramParcel.writeString(this.jye);
      paramParcel.writeString(this.mAppId);
      paramParcel.writeString(this.mPackageName);
      byte b;
      if (this.jzk)
      {
        b = 1;
        paramParcel.writeByte(b);
        if (!this.jAy) {
          break label148;
        }
        b = 1;
        label95:
        paramParcel.writeByte(b);
        paramParcel.writeInt(this.jAz);
        if (!this.jyf) {
          break label153;
        }
      }
      for (;;)
      {
        paramParcel.writeInt(paramInt);
        paramParcel.writeString(this.jyg);
        paramParcel.writeLong(this.jyh);
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