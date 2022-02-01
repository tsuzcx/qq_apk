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

public final class JsApiAddDownloadTask
  extends c<v>
{
  public static final int CTRL_INDEX = 474;
  public static final String NAME = "addDownloadTask";
  
  static class AddDownloadTask
    extends MainProcessTask
  {
    public static final Parcelable.Creator<AddDownloadTask> CREATOR;
    private int cqA;
    private String mAppId;
    private String mPackageName;
    private v ntA;
    private String ovA;
    private String ovB;
    private String ovC;
    private long ovE;
    private String ovF;
    private String ovG;
    private boolean ovH;
    private String ovI;
    private long ovJ;
    private o ovz;
    private boolean owW;
    private boolean oyA;
    private int oyB;
    
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
    
    public AddDownloadTask(o paramo, v paramv, int paramInt, JSONObject paramJSONObject)
    {
      AppMethodBeat.i(45744);
      this.ovz = paramo;
      this.ntA = paramv;
      this.cqA = paramInt;
      this.ovA = paramJSONObject.optString("taskName");
      this.ovB = paramJSONObject.optString("taskUrl");
      this.ovC = paramJSONObject.optString("fileMd5");
      this.ovE = paramJSONObject.optInt("taskSize", 0);
      this.ovF = paramJSONObject.optString("extInfo");
      this.ovG = paramJSONObject.optString("fileType");
      this.mAppId = paramJSONObject.optString("appId");
      this.mPackageName = paramJSONObject.optString("packageName");
      this.owW = paramJSONObject.optBoolean("downloadInWifi", false);
      this.oyA = paramJSONObject.optBoolean("showNotification", false);
      this.oyB = paramJSONObject.optInt("downloaderType", 0);
      this.ovH = true;
      AppMethodBeat.o(45744);
    }
    
    public final void RW()
    {
      AppMethodBeat.i(45746);
      h.aHH();
      if (!h.aHG().isSDCardAvailable()) {
        this.ovI = "fail_sdcard_not_ready";
      }
      for (;;)
      {
        bPt();
        AppMethodBeat.o(45746);
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
          Log.i("MicroMsg.JsApiAddDownloadTask", "runInMainProcess taskUrl:%s md5:%s", new Object[] { this.ovB, this.ovC });
          Object localObject = new g.a();
          ((g.a)localObject).atc(this.ovB);
          ((g.a)localObject).setFileSize(this.ovE);
          ((g.a)localObject).ate(this.ovA);
          ((g.a)localObject).setFileMD5(this.ovC);
          ((g.a)localObject).setAppId(this.mAppId);
          ((g.a)localObject).setPackageName(this.mPackageName);
          ((g.a)localObject).me(true);
          ((g.a)localObject).IS(Util.getInt(this.ovG, 1));
          ((g.a)localObject).setScene(6001);
          ((g.a)localObject).YS(this.ovF);
          ((g.a)localObject).mf(this.oyA);
          ((g.a)localObject).mh(this.owW);
          ((g.a)localObject).me(false);
          ((g.a)localObject).cQh();
          localObject = ((g.a)localObject).uhY;
          if (this.oyB == 1) {}
          for (long l = com.tencent.mm.plugin.downloader.model.f.cPZ().b((g)localObject);; l = com.tencent.mm.plugin.downloader.model.f.cPZ().a((g)localObject))
          {
            Log.i("MicroMsg.JsApiAddDownloadTask", "doAddDownloadTaskStraight, downloadId = ".concat(String.valueOf(l)));
            if (l > 0L) {
              break label297;
            }
            Log.e("MicroMsg.JsApiAddDownloadTask", "doAddDownloadTaskStraight fail, downloadId = ".concat(String.valueOf(l)));
            this.ovI = "";
            break;
          }
          label297:
          this.ovH = false;
          this.ovJ = l;
        }
      }
    }
    
    public final void bsK()
    {
      AppMethodBeat.i(45747);
      bPk();
      if (this.ovH)
      {
        if (Util.isNullOrNil(this.ovI)) {}
        for (localObject = "fail";; localObject = String.format("fail:%s", new Object[] { this.ovI }))
        {
          this.ntA.j(this.cqA, this.ovz.h((String)localObject, null));
          AppMethodBeat.o(45747);
          return;
        }
      }
      Object localObject = new HashMap();
      ((Map)localObject).put("downloadId", Long.valueOf(this.ovJ));
      this.ntA.j(this.cqA, this.ovz.m("ok", (Map)localObject));
      AppMethodBeat.o(45747);
    }
    
    public final void f(Parcel paramParcel)
    {
      boolean bool2 = true;
      AppMethodBeat.i(45748);
      this.ovA = paramParcel.readString();
      this.ovB = paramParcel.readString();
      this.ovC = paramParcel.readString();
      this.ovE = paramParcel.readLong();
      this.ovF = paramParcel.readString();
      this.ovG = paramParcel.readString();
      this.mAppId = paramParcel.readString();
      this.mPackageName = paramParcel.readString();
      if (paramParcel.readByte() == 1)
      {
        bool1 = true;
        this.owW = bool1;
        if (paramParcel.readByte() != 1) {
          break label153;
        }
        bool1 = true;
        label97:
        this.oyA = bool1;
        this.oyB = paramParcel.readInt();
        if (paramParcel.readInt() != 1) {
          break label158;
        }
      }
      label153:
      label158:
      for (boolean bool1 = bool2;; bool1 = false)
      {
        this.ovH = bool1;
        this.ovI = paramParcel.readString();
        this.ovJ = paramParcel.readLong();
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
      paramParcel.writeString(this.ovA);
      paramParcel.writeString(this.ovB);
      paramParcel.writeString(this.ovC);
      paramParcel.writeLong(this.ovE);
      paramParcel.writeString(this.ovF);
      paramParcel.writeString(this.ovG);
      paramParcel.writeString(this.mAppId);
      paramParcel.writeString(this.mPackageName);
      byte b;
      if (this.owW)
      {
        b = 1;
        paramParcel.writeByte(b);
        if (!this.oyA) {
          break label148;
        }
        b = 1;
        label95:
        paramParcel.writeByte(b);
        paramParcel.writeInt(this.oyB);
        if (!this.ovH) {
          break label153;
        }
      }
      for (;;)
      {
        paramParcel.writeInt(paramInt);
        paramParcel.writeString(this.ovI);
        paramParcel.writeLong(this.ovJ);
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