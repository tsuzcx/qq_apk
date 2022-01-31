package com.tencent.mm.plugin.appbrand.jsapi.appdownload;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.kernel.e;
import com.tencent.mm.plugin.appbrand.ipc.MainProcessTask;
import com.tencent.mm.plugin.appbrand.jsapi.a;
import com.tencent.mm.plugin.appbrand.jsapi.m;
import com.tencent.mm.plugin.appbrand.r;
import com.tencent.mm.plugin.downloader.model.g.a;
import com.tencent.mm.sdk.platformtools.ab;
import com.tencent.mm.sdk.platformtools.bo;
import java.util.HashMap;
import java.util.Map;
import org.json.JSONObject;

public final class JsApiAddDownloadTask
  extends a<r>
{
  public static final int CTRL_INDEX = 474;
  public static final String NAME = "addDownloadTask";
  
  static class AddDownloadTask
    extends MainProcessTask
  {
    public static final Parcelable.Creator<AddDownloadTask> CREATOR;
    private int bxX;
    private r gPA;
    private boolean hAU;
    private int hAV;
    private m hyA;
    private String hyB;
    private String hyC;
    private String hyD;
    private long hyF;
    private String hyG;
    private String hyH;
    private boolean hyI;
    private String hyJ;
    private long hyK;
    private boolean hzD;
    private String mAppId;
    private String mPackageName;
    
    static
    {
      AppMethodBeat.i(130658);
      CREATOR = new JsApiAddDownloadTask.AddDownloadTask.1();
      AppMethodBeat.o(130658);
    }
    
    public AddDownloadTask(Parcel paramParcel)
    {
      AppMethodBeat.i(130653);
      f(paramParcel);
      AppMethodBeat.o(130653);
    }
    
    public AddDownloadTask(m paramm, r paramr, int paramInt, JSONObject paramJSONObject)
    {
      AppMethodBeat.i(130652);
      aBj();
      this.hyA = paramm;
      this.gPA = paramr;
      this.bxX = paramInt;
      this.hyB = paramJSONObject.optString("taskName");
      this.hyC = paramJSONObject.optString("taskUrl");
      this.hyD = paramJSONObject.optString("fileMd5");
      this.hyF = paramJSONObject.optInt("taskSize", 0);
      this.hyG = paramJSONObject.optString("extInfo");
      this.hyH = paramJSONObject.optString("fileType");
      this.mAppId = paramJSONObject.optString("appId");
      this.mPackageName = paramJSONObject.optString("packageName");
      this.hzD = paramJSONObject.optBoolean("downloadInWifi", false);
      this.hAU = paramJSONObject.optBoolean("showNotification", false);
      this.hAV = paramJSONObject.optInt("downloaderType", 0);
      this.hyI = true;
      AppMethodBeat.o(130652);
    }
    
    public final void ata()
    {
      AppMethodBeat.i(130654);
      com.tencent.mm.kernel.g.RM();
      if (!com.tencent.mm.kernel.g.RL().isSDCardAvailable()) {
        this.hyJ = "fail_sdcard_not_ready";
      }
      for (;;)
      {
        aBp();
        AppMethodBeat.o(130654);
        return;
        if ((this.hyF > 0L) && (!com.tencent.mm.compatible.util.f.gc(this.hyF)))
        {
          this.hyJ = "fail_sdcard_has_not_enough_space";
        }
        else if (bo.isNullOrNil(this.hyC))
        {
          this.hyJ = "fail_invalid_url";
        }
        else
        {
          ab.i("MicroMsg.JsApiAddDownloadTask", "runInMainProcess taskUrl:%s md5:%s", new Object[] { this.hyC, this.hyD });
          Object localObject = new g.a();
          ((g.a)localObject).JJ(this.hyC);
          ((g.a)localObject).iR(this.hyF);
          ((g.a)localObject).JL(this.hyB);
          ((g.a)localObject).JM(this.hyD);
          ((g.a)localObject).setAppId(this.mAppId);
          ((g.a)localObject).dC(this.mPackageName);
          ((g.a)localObject).gr(true);
          ((g.a)localObject).tV(bo.getInt(this.hyH, 1));
          ((g.a)localObject).setScene(6001);
          ((g.a)localObject).JN(this.hyG);
          ((g.a)localObject).gs(this.hAU);
          ((g.a)localObject).gt(this.hzD);
          ((g.a)localObject).gr(false);
          ((g.a)localObject).bju();
          localObject = ((g.a)localObject).kYR;
          if (this.hAV == 1) {}
          for (long l = com.tencent.mm.plugin.downloader.model.f.bjl().b((com.tencent.mm.plugin.downloader.model.g)localObject);; l = com.tencent.mm.plugin.downloader.model.f.bjl().a((com.tencent.mm.plugin.downloader.model.g)localObject))
          {
            ab.i("MicroMsg.JsApiAddDownloadTask", "doAddDownloadTaskStraight, downloadId = ".concat(String.valueOf(l)));
            if (l > 0L) {
              break label297;
            }
            ab.e("MicroMsg.JsApiAddDownloadTask", "doAddDownloadTaskStraight fail, downloadId = ".concat(String.valueOf(l)));
            this.hyJ = "";
            break;
          }
          label297:
          this.hyI = false;
          this.hyK = l;
        }
      }
    }
    
    public final void atb()
    {
      AppMethodBeat.i(130655);
      aBk();
      if (this.hyI)
      {
        if (bo.isNullOrNil(this.hyJ)) {}
        for (localObject = "fail";; localObject = String.format("fail:%s", new Object[] { this.hyJ }))
        {
          this.gPA.h(this.bxX, this.hyA.j((String)localObject, null));
          AppMethodBeat.o(130655);
          return;
        }
      }
      Object localObject = new HashMap();
      ((Map)localObject).put("downloadId", Long.valueOf(this.hyK));
      this.gPA.h(this.bxX, this.hyA.j("ok", (Map)localObject));
      AppMethodBeat.o(130655);
    }
    
    public final void f(Parcel paramParcel)
    {
      boolean bool2 = true;
      AppMethodBeat.i(130656);
      this.hyB = paramParcel.readString();
      this.hyC = paramParcel.readString();
      this.hyD = paramParcel.readString();
      this.hyF = paramParcel.readLong();
      this.hyG = paramParcel.readString();
      this.hyH = paramParcel.readString();
      this.mAppId = paramParcel.readString();
      this.mPackageName = paramParcel.readString();
      if (paramParcel.readByte() == 1)
      {
        bool1 = true;
        this.hzD = bool1;
        if (paramParcel.readByte() != 1) {
          break label153;
        }
        bool1 = true;
        label97:
        this.hAU = bool1;
        this.hAV = paramParcel.readInt();
        if (paramParcel.readInt() != 1) {
          break label158;
        }
      }
      label153:
      label158:
      for (boolean bool1 = bool2;; bool1 = false)
      {
        this.hyI = bool1;
        this.hyJ = paramParcel.readString();
        this.hyK = paramParcel.readLong();
        AppMethodBeat.o(130656);
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
      AppMethodBeat.i(130657);
      paramParcel.writeString(this.hyB);
      paramParcel.writeString(this.hyC);
      paramParcel.writeString(this.hyD);
      paramParcel.writeLong(this.hyF);
      paramParcel.writeString(this.hyG);
      paramParcel.writeString(this.hyH);
      paramParcel.writeString(this.mAppId);
      paramParcel.writeString(this.mPackageName);
      byte b;
      if (this.hzD)
      {
        b = 1;
        paramParcel.writeByte(b);
        if (!this.hAU) {
          break label148;
        }
        b = 1;
        label95:
        paramParcel.writeByte(b);
        paramParcel.writeInt(this.hAV);
        if (!this.hyI) {
          break label153;
        }
      }
      for (;;)
      {
        paramParcel.writeInt(paramInt);
        paramParcel.writeString(this.hyJ);
        paramParcel.writeLong(this.hyK);
        AppMethodBeat.o(130657);
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