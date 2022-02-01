package com.tencent.mm.plugin.appbrand.jsapi.appdownload;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.compatible.util.e;
import com.tencent.mm.kernel.h;
import com.tencent.mm.plugin.appbrand.ipc.MainProcessTask;
import com.tencent.mm.plugin.appbrand.jsapi.c;
import com.tencent.mm.plugin.appbrand.jsapi.o;
import com.tencent.mm.plugin.appbrand.v;
import com.tencent.mm.plugin.downloader.model.g;
import com.tencent.mm.plugin.downloader.model.g.a;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.Util;
import java.util.HashMap;
import java.util.Map;
import org.json.JSONObject;

public final class JsApiAddDownloadTaskStraight
  extends c<v>
{
  public static final int CTRL_INDEX = 440;
  public static final String NAME = "addDownloadTaskStraight";
  
  static class AddDownloadTaskStraightTask
    extends MainProcessTask
  {
    public static final Parcelable.Creator<AddDownloadTaskStraightTask> CREATOR;
    private int cqA;
    private String mAppId;
    private String mPackageName;
    private v ntA;
    private String ovA;
    private String ovB;
    private String ovC;
    private String ovD;
    private long ovE;
    private String ovF;
    private String ovG;
    private boolean ovH;
    private String ovI;
    private long ovJ;
    private o ovz;
    
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
    
    public AddDownloadTaskStraightTask(o paramo, v paramv, int paramInt, JSONObject paramJSONObject)
    {
      AppMethodBeat.i(45763);
      this.ovz = paramo;
      this.ntA = paramv;
      this.cqA = paramInt;
      this.ovA = paramJSONObject.optString("taskName");
      this.ovB = paramJSONObject.optString("taskUrl");
      this.ovC = paramJSONObject.optString("fileMd5");
      this.ovD = paramJSONObject.optString("alternativeUrl");
      this.ovE = paramJSONObject.optInt("taskSize", 0);
      this.ovF = paramJSONObject.optString("extInfo");
      this.ovG = paramJSONObject.optString("fileType");
      this.mAppId = paramv.getAppId();
      this.mPackageName = paramJSONObject.optString("packageName");
      this.ovH = true;
      AppMethodBeat.o(45763);
    }
    
    public final void RW()
    {
      AppMethodBeat.i(45765);
      h.aHH();
      if (!h.aHG().isSDCardAvailable()) {
        this.ovI = "fail_sdcard_not_ready";
      }
      for (;;)
      {
        bPt();
        AppMethodBeat.o(45765);
        return;
        if ((this.ovE > 0L) && (!e.EY(this.ovE)))
        {
          this.ovI = "fail_sdcard_has_not_enough_space";
        }
        else if (Util.isNullOrNil(this.ovB))
        {
          this.ovI = "fail_invalid_url";
        }
        else
        {
          Log.i("MicroMsg.JsApiAddDownloadTaskStraight", "runInMainProcess taskUrl:%s md5:%s", new Object[] { this.ovB, this.ovC });
          Object localObject = new g.a();
          ((g.a)localObject).atc(this.ovB);
          ((g.a)localObject).atd(this.ovD);
          ((g.a)localObject).setFileSize(this.ovE);
          ((g.a)localObject).ate(this.ovA);
          ((g.a)localObject).setFileMD5(this.ovC);
          ((g.a)localObject).setAppId(this.mAppId);
          ((g.a)localObject).setPackageName(this.mPackageName);
          ((g.a)localObject).me(true);
          ((g.a)localObject).IS(Util.getInt(this.ovG, 1));
          ((g.a)localObject).setScene(6001);
          ((g.a)localObject).YS(this.ovF);
          localObject = ((g.a)localObject).uhY;
          long l = com.tencent.mm.plugin.downloader.model.f.cPZ().a((g)localObject);
          Log.i("MicroMsg.JsApiAddDownloadTaskStraight", "doAddDownloadTaskStraight, downloadId = ".concat(String.valueOf(l)));
          if (l <= 0L)
          {
            Log.e("MicroMsg.JsApiAddDownloadTaskStraight", "doAddDownloadTaskStraight fail, downloadId = ".concat(String.valueOf(l)));
            this.ovI = "";
          }
          else
          {
            this.ovH = false;
            this.ovJ = l;
          }
        }
      }
    }
    
    public final void bsK()
    {
      AppMethodBeat.i(45766);
      if (this.ovH)
      {
        if (Util.isNullOrNil(this.ovI)) {}
        for (localObject = "fail";; localObject = String.format("fail:%s", new Object[] { this.ovI }))
        {
          this.ntA.j(this.cqA, this.ovz.h((String)localObject, null));
          AppMethodBeat.o(45766);
          return;
        }
      }
      Object localObject = new HashMap();
      ((Map)localObject).put("downloadId", Long.valueOf(this.ovJ));
      this.ntA.j(this.cqA, this.ovz.m("ok", (Map)localObject));
      AppMethodBeat.o(45766);
    }
    
    public final void f(Parcel paramParcel)
    {
      boolean bool = true;
      AppMethodBeat.i(45767);
      this.ovA = paramParcel.readString();
      this.ovB = paramParcel.readString();
      this.ovC = paramParcel.readString();
      this.ovD = paramParcel.readString();
      this.ovE = paramParcel.readLong();
      this.ovF = paramParcel.readString();
      this.ovG = paramParcel.readString();
      this.mAppId = paramParcel.readString();
      this.mPackageName = paramParcel.readString();
      if (paramParcel.readInt() == 1) {}
      for (;;)
      {
        this.ovH = bool;
        this.ovI = paramParcel.readString();
        this.ovJ = paramParcel.readLong();
        AppMethodBeat.o(45767);
        return;
        bool = false;
      }
    }
    
    public void writeToParcel(Parcel paramParcel, int paramInt)
    {
      AppMethodBeat.i(45768);
      paramParcel.writeString(this.ovA);
      paramParcel.writeString(this.ovB);
      paramParcel.writeString(this.ovC);
      paramParcel.writeString(this.ovD);
      paramParcel.writeLong(this.ovE);
      paramParcel.writeString(this.ovF);
      paramParcel.writeString(this.ovG);
      paramParcel.writeString(this.mAppId);
      paramParcel.writeString(this.mPackageName);
      if (this.ovH) {}
      for (paramInt = 1;; paramInt = 0)
      {
        paramParcel.writeInt(paramInt);
        paramParcel.writeString(this.ovI);
        paramParcel.writeLong(this.ovJ);
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