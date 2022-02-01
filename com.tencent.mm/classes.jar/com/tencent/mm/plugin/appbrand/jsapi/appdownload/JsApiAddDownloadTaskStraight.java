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
    private int cgA;
    private q jwH;
    private m ksO;
    private String ksP;
    private String ksQ;
    private String ksR;
    private String ksS;
    private long ksT;
    private String ksU;
    private String ksV;
    private boolean ksW;
    private String ksX;
    private long ksY;
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
      this.ksO = paramm;
      this.jwH = paramq;
      this.cgA = paramInt;
      this.ksP = paramJSONObject.optString("taskName");
      this.ksQ = paramJSONObject.optString("taskUrl");
      this.ksR = paramJSONObject.optString("fileMd5");
      this.ksS = paramJSONObject.optString("alternativeUrl");
      this.ksT = paramJSONObject.optInt("taskSize", 0);
      this.ksU = paramJSONObject.optString("extInfo");
      this.ksV = paramJSONObject.optString("fileType");
      this.mAppId = paramq.getAppId();
      this.mPackageName = paramJSONObject.optString("packageName");
      this.ksW = true;
      AppMethodBeat.o(45763);
    }
    
    public final void aOA()
    {
      AppMethodBeat.i(45765);
      com.tencent.mm.kernel.g.ajD();
      if (!com.tencent.mm.kernel.g.ajC().isSDCardAvailable()) {
        this.ksX = "fail_sdcard_not_ready";
      }
      for (;;)
      {
        bhX();
        AppMethodBeat.o(45765);
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
          ad.i("MicroMsg.JsApiAddDownloadTaskStraight", "runInMainProcess taskUrl:%s md5:%s", new Object[] { this.ksQ, this.ksR });
          Object localObject = new g.a();
          ((g.a)localObject).aak(this.ksQ);
          ((g.a)localObject).aal(this.ksS);
          ((g.a)localObject).ui(this.ksT);
          ((g.a)localObject).aam(this.ksP);
          ((g.a)localObject).aan(this.ksR);
          ((g.a)localObject).setAppId(this.mAppId);
          ((g.a)localObject).ft(this.mPackageName);
          ((g.a)localObject).jQ(true);
          ((g.a)localObject).Bp(bt.getInt(this.ksV, 1));
          ((g.a)localObject).setScene(6001);
          ((g.a)localObject).aao(this.ksU);
          localObject = ((g.a)localObject).pmN;
          long l = f.ccl().a((com.tencent.mm.plugin.downloader.model.g)localObject);
          ad.i("MicroMsg.JsApiAddDownloadTaskStraight", "doAddDownloadTaskStraight, downloadId = ".concat(String.valueOf(l)));
          if (l <= 0L)
          {
            ad.e("MicroMsg.JsApiAddDownloadTaskStraight", "doAddDownloadTaskStraight fail, downloadId = ".concat(String.valueOf(l)));
            this.ksX = "";
          }
          else
          {
            this.ksW = false;
            this.ksY = l;
          }
        }
      }
    }
    
    public final void aOB()
    {
      AppMethodBeat.i(45766);
      if (this.ksW)
      {
        if (bt.isNullOrNil(this.ksX)) {}
        for (localObject = "fail";; localObject = String.format("fail:%s", new Object[] { this.ksX }))
        {
          this.jwH.h(this.cgA, this.ksO.e((String)localObject, null));
          AppMethodBeat.o(45766);
          return;
        }
      }
      Object localObject = new HashMap();
      ((Map)localObject).put("downloadId", Long.valueOf(this.ksY));
      this.jwH.h(this.cgA, this.ksO.m("ok", (Map)localObject));
      AppMethodBeat.o(45766);
    }
    
    public final void e(Parcel paramParcel)
    {
      boolean bool = true;
      AppMethodBeat.i(45767);
      this.ksP = paramParcel.readString();
      this.ksQ = paramParcel.readString();
      this.ksR = paramParcel.readString();
      this.ksS = paramParcel.readString();
      this.ksT = paramParcel.readLong();
      this.ksU = paramParcel.readString();
      this.ksV = paramParcel.readString();
      this.mAppId = paramParcel.readString();
      this.mPackageName = paramParcel.readString();
      if (paramParcel.readInt() == 1) {}
      for (;;)
      {
        this.ksW = bool;
        this.ksX = paramParcel.readString();
        this.ksY = paramParcel.readLong();
        AppMethodBeat.o(45767);
        return;
        bool = false;
      }
    }
    
    public void writeToParcel(Parcel paramParcel, int paramInt)
    {
      AppMethodBeat.i(45768);
      paramParcel.writeString(this.ksP);
      paramParcel.writeString(this.ksQ);
      paramParcel.writeString(this.ksR);
      paramParcel.writeString(this.ksS);
      paramParcel.writeLong(this.ksT);
      paramParcel.writeString(this.ksU);
      paramParcel.writeString(this.ksV);
      paramParcel.writeString(this.mAppId);
      paramParcel.writeString(this.mPackageName);
      if (this.ksW) {}
      for (paramInt = 1;; paramInt = 0)
      {
        paramParcel.writeInt(paramInt);
        paramParcel.writeString(this.ksX);
        paramParcel.writeLong(this.ksY);
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