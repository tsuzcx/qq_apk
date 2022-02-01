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

public final class JsApiAddDownloadTaskStraight
  extends a<q>
{
  public static final int CTRL_INDEX = 440;
  public static final String NAME = "addDownloadTaskStraight";
  
  static class AddDownloadTaskStraightTask
    extends MainProcessTask
  {
    public static final Parcelable.Creator<AddDownloadTaskStraightTask> CREATOR;
    private int bZo;
    private q iDy;
    private m jxX;
    private String jxY;
    private String jxZ;
    private String jya;
    private String jyb;
    private long jyc;
    private String jyd;
    private String jye;
    private boolean jyf;
    private String jyg;
    private long jyh;
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
      e(paramParcel);
      AppMethodBeat.o(45764);
    }
    
    public AddDownloadTaskStraightTask(m paramm, q paramq, int paramInt, JSONObject paramJSONObject)
    {
      AppMethodBeat.i(45763);
      this.jxX = paramm;
      this.iDy = paramq;
      this.bZo = paramInt;
      this.jxY = paramJSONObject.optString("taskName");
      this.jxZ = paramJSONObject.optString("taskUrl");
      this.jya = paramJSONObject.optString("fileMd5");
      this.jyb = paramJSONObject.optString("alternativeUrl");
      this.jyc = paramJSONObject.optInt("taskSize", 0);
      this.jyd = paramJSONObject.optString("extInfo");
      this.jye = paramJSONObject.optString("fileType");
      this.mAppId = paramq.getAppId();
      this.mPackageName = paramJSONObject.optString("packageName");
      this.jyf = true;
      AppMethodBeat.o(45763);
    }
    
    public final void aEA()
    {
      AppMethodBeat.i(45766);
      if (this.jyf)
      {
        if (bt.isNullOrNil(this.jyg)) {}
        for (localObject = "fail";; localObject = String.format("fail:%s", new Object[] { this.jyg }))
        {
          this.iDy.h(this.bZo, this.jxX.e((String)localObject, null));
          AppMethodBeat.o(45766);
          return;
        }
      }
      Object localObject = new HashMap();
      ((Map)localObject).put("downloadId", Long.valueOf(this.jyh));
      this.iDy.h(this.bZo, this.jxX.k("ok", (Map)localObject));
      AppMethodBeat.o(45766);
    }
    
    public final void aEz()
    {
      AppMethodBeat.i(45765);
      com.tencent.mm.kernel.g.afC();
      if (!com.tencent.mm.kernel.g.afB().isSDCardAvailable()) {
        this.jyg = "fail_sdcard_not_ready";
      }
      for (;;)
      {
        aXw();
        AppMethodBeat.o(45765);
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
          ad.i("MicroMsg.JsApiAddDownloadTaskStraight", "runInMainProcess taskUrl:%s md5:%s", new Object[] { this.jxZ, this.jya });
          Object localObject = new g.a();
          ((g.a)localObject).Sr(this.jxZ);
          ((g.a)localObject).Ss(this.jyb);
          ((g.a)localObject).oy(this.jyc);
          ((g.a)localObject).St(this.jxY);
          ((g.a)localObject).Su(this.jya);
          ((g.a)localObject).setAppId(this.mAppId);
          ((g.a)localObject).eI(this.mPackageName);
          ((g.a)localObject).jc(true);
          ((g.a)localObject).zO(bt.getInt(this.jye, 1));
          ((g.a)localObject).setScene(6001);
          ((g.a)localObject).Sv(this.jyd);
          localObject = ((g.a)localObject).ofF;
          long l = f.bQt().a((com.tencent.mm.plugin.downloader.model.g)localObject);
          ad.i("MicroMsg.JsApiAddDownloadTaskStraight", "doAddDownloadTaskStraight, downloadId = ".concat(String.valueOf(l)));
          if (l <= 0L)
          {
            ad.e("MicroMsg.JsApiAddDownloadTaskStraight", "doAddDownloadTaskStraight fail, downloadId = ".concat(String.valueOf(l)));
            this.jyg = "";
          }
          else
          {
            this.jyf = false;
            this.jyh = l;
          }
        }
      }
    }
    
    public final void e(Parcel paramParcel)
    {
      boolean bool = true;
      AppMethodBeat.i(45767);
      this.jxY = paramParcel.readString();
      this.jxZ = paramParcel.readString();
      this.jya = paramParcel.readString();
      this.jyb = paramParcel.readString();
      this.jyc = paramParcel.readLong();
      this.jyd = paramParcel.readString();
      this.jye = paramParcel.readString();
      this.mAppId = paramParcel.readString();
      this.mPackageName = paramParcel.readString();
      if (paramParcel.readInt() == 1) {}
      for (;;)
      {
        this.jyf = bool;
        this.jyg = paramParcel.readString();
        this.jyh = paramParcel.readLong();
        AppMethodBeat.o(45767);
        return;
        bool = false;
      }
    }
    
    public void writeToParcel(Parcel paramParcel, int paramInt)
    {
      AppMethodBeat.i(45768);
      paramParcel.writeString(this.jxY);
      paramParcel.writeString(this.jxZ);
      paramParcel.writeString(this.jya);
      paramParcel.writeString(this.jyb);
      paramParcel.writeLong(this.jyc);
      paramParcel.writeString(this.jyd);
      paramParcel.writeString(this.jye);
      paramParcel.writeString(this.mAppId);
      paramParcel.writeString(this.mPackageName);
      if (this.jyf) {}
      for (paramInt = 1;; paramInt = 0)
      {
        paramParcel.writeInt(paramInt);
        paramParcel.writeString(this.jyg);
        paramParcel.writeLong(this.jyh);
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