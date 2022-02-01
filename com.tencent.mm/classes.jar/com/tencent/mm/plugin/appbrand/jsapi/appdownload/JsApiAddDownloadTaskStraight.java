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

public final class JsApiAddDownloadTaskStraight
  extends a<q>
{
  public static final int CTRL_INDEX = 440;
  public static final String NAME = "addDownloadTaskStraight";
  
  static class AddDownloadTaskStraightTask
    extends MainProcessTask
  {
    public static final Parcelable.Creator<AddDownloadTaskStraightTask> CREATOR;
    private int bWl;
    private boolean jYA;
    private String jYB;
    private long jYC;
    private m jYs;
    private String jYt;
    private String jYu;
    private String jYv;
    private String jYw;
    private long jYx;
    private String jYy;
    private String jYz;
    private q jdy;
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
      this.jYs = paramm;
      this.jdy = paramq;
      this.bWl = paramInt;
      this.jYt = paramJSONObject.optString("taskName");
      this.jYu = paramJSONObject.optString("taskUrl");
      this.jYv = paramJSONObject.optString("fileMd5");
      this.jYw = paramJSONObject.optString("alternativeUrl");
      this.jYx = paramJSONObject.optInt("taskSize", 0);
      this.jYy = paramJSONObject.optString("extInfo");
      this.jYz = paramJSONObject.optString("fileType");
      this.mAppId = paramq.getAppId();
      this.mPackageName = paramJSONObject.optString("packageName");
      this.jYA = true;
      AppMethodBeat.o(45763);
    }
    
    public final void aLq()
    {
      AppMethodBeat.i(45765);
      com.tencent.mm.kernel.g.agS();
      if (!com.tencent.mm.kernel.g.agR().isSDCardAvailable()) {
        this.jYB = "fail_sdcard_not_ready";
      }
      for (;;)
      {
        bet();
        AppMethodBeat.o(45765);
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
          ac.i("MicroMsg.JsApiAddDownloadTaskStraight", "runInMainProcess taskUrl:%s md5:%s", new Object[] { this.jYu, this.jYv });
          Object localObject = new g.a();
          ((g.a)localObject).WD(this.jYu);
          ((g.a)localObject).WE(this.jYw);
          ((g.a)localObject).sk(this.jYx);
          ((g.a)localObject).WF(this.jYt);
          ((g.a)localObject).WG(this.jYv);
          ((g.a)localObject).setAppId(this.mAppId);
          ((g.a)localObject).ey(this.mPackageName);
          ((g.a)localObject).jF(true);
          ((g.a)localObject).AG(bs.getInt(this.jYz, 1));
          ((g.a)localObject).setScene(6001);
          ((g.a)localObject).WH(this.jYy);
          localObject = ((g.a)localObject).oJg;
          long l = f.bXJ().a((com.tencent.mm.plugin.downloader.model.g)localObject);
          ac.i("MicroMsg.JsApiAddDownloadTaskStraight", "doAddDownloadTaskStraight, downloadId = ".concat(String.valueOf(l)));
          if (l <= 0L)
          {
            ac.e("MicroMsg.JsApiAddDownloadTaskStraight", "doAddDownloadTaskStraight fail, downloadId = ".concat(String.valueOf(l)));
            this.jYB = "";
          }
          else
          {
            this.jYA = false;
            this.jYC = l;
          }
        }
      }
    }
    
    public final void aLr()
    {
      AppMethodBeat.i(45766);
      if (this.jYA)
      {
        if (bs.isNullOrNil(this.jYB)) {}
        for (localObject = "fail";; localObject = String.format("fail:%s", new Object[] { this.jYB }))
        {
          this.jdy.h(this.bWl, this.jYs.e((String)localObject, null));
          AppMethodBeat.o(45766);
          return;
        }
      }
      Object localObject = new HashMap();
      ((Map)localObject).put("downloadId", Long.valueOf(this.jYC));
      this.jdy.h(this.bWl, this.jYs.k("ok", (Map)localObject));
      AppMethodBeat.o(45766);
    }
    
    public final void e(Parcel paramParcel)
    {
      boolean bool = true;
      AppMethodBeat.i(45767);
      this.jYt = paramParcel.readString();
      this.jYu = paramParcel.readString();
      this.jYv = paramParcel.readString();
      this.jYw = paramParcel.readString();
      this.jYx = paramParcel.readLong();
      this.jYy = paramParcel.readString();
      this.jYz = paramParcel.readString();
      this.mAppId = paramParcel.readString();
      this.mPackageName = paramParcel.readString();
      if (paramParcel.readInt() == 1) {}
      for (;;)
      {
        this.jYA = bool;
        this.jYB = paramParcel.readString();
        this.jYC = paramParcel.readLong();
        AppMethodBeat.o(45767);
        return;
        bool = false;
      }
    }
    
    public void writeToParcel(Parcel paramParcel, int paramInt)
    {
      AppMethodBeat.i(45768);
      paramParcel.writeString(this.jYt);
      paramParcel.writeString(this.jYu);
      paramParcel.writeString(this.jYv);
      paramParcel.writeString(this.jYw);
      paramParcel.writeLong(this.jYx);
      paramParcel.writeString(this.jYy);
      paramParcel.writeString(this.jYz);
      paramParcel.writeString(this.mAppId);
      paramParcel.writeString(this.mPackageName);
      if (this.jYA) {}
      for (paramInt = 1;; paramInt = 0)
      {
        paramParcel.writeInt(paramInt);
        paramParcel.writeString(this.jYB);
        paramParcel.writeLong(this.jYC);
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