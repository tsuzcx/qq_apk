package com.tencent.mm.plugin.appbrand.jsapi.appdownload;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.tencent.mm.compatible.util.f;
import com.tencent.mm.game.report.api.b;
import com.tencent.mm.kernel.g;
import com.tencent.mm.plugin.appbrand.ipc.MainProcessTask;
import com.tencent.mm.plugin.appbrand.jsapi.a;
import com.tencent.mm.plugin.appbrand.jsapi.i;
import com.tencent.mm.plugin.appbrand.o;
import com.tencent.mm.plugin.downloader.model.d;
import com.tencent.mm.plugin.downloader.model.e.a;
import com.tencent.mm.sdk.platformtools.bk;
import com.tencent.mm.sdk.platformtools.y;
import java.util.HashMap;
import java.util.Map;
import org.json.JSONObject;

public final class JsApiAddDownloadTask
  extends a<o>
{
  public static final int CTRL_INDEX = 474;
  public static final String NAME = "addDownloadTask";
  
  private static class AddDownloadTask
    extends MainProcessTask
  {
    public static final Parcelable.Creator<AddDownloadTask> CREATOR = new JsApiAddDownloadTask.AddDownloadTask.1();
    private int bhx;
    private o fyo;
    private String ghO;
    private String ghP;
    private String ghQ;
    private long ghR;
    private String ghS;
    private String ghT;
    private boolean ghU;
    private int ghV;
    private i gho;
    private long ghp;
    private boolean ghq;
    private boolean ghr;
    private String ghs;
    private String mAppId;
    private String mPackageName;
    
    public AddDownloadTask(Parcel paramParcel)
    {
      e(paramParcel);
    }
    
    public AddDownloadTask(i parami, o paramo, int paramInt, JSONObject paramJSONObject)
    {
      ahC();
      this.gho = parami;
      this.fyo = paramo;
      this.bhx = paramInt;
      this.ghO = paramJSONObject.optString("taskName");
      this.ghP = paramJSONObject.optString("taskUrl");
      this.ghQ = paramJSONObject.optString("fileMd5");
      this.ghR = paramJSONObject.optInt("taskSize", 0);
      this.ghS = paramJSONObject.optString("extInfo");
      this.ghT = paramJSONObject.optString("fileType");
      this.mAppId = paramJSONObject.optString("appId");
      this.mPackageName = paramJSONObject.optString("packageName");
      this.ghq = paramJSONObject.optBoolean("downloadInWifi", false);
      this.ghU = paramJSONObject.optBoolean("showNotification", false);
      this.ghV = paramJSONObject.optInt("downloaderType", 0);
      this.ghr = true;
    }
    
    public final void Zu()
    {
      g.DQ();
      if (!g.DP().isSDCardAvailable()) {
        this.ghs = "fail_sdcard_not_ready";
      }
      for (;;)
      {
        ahI();
        return;
        if ((this.ghR > 0L) && (!f.bs(this.ghR)))
        {
          this.ghs = "fail_sdcard_has_not_enough_space";
        }
        else if (bk.bl(this.ghP))
        {
          this.ghs = "fail_invalid_url";
        }
        else
        {
          y.i("MicroMsg.JsApiAddDownloadTask", "runInMainProcess taskUrl:%s md5:%s", new Object[] { this.ghP, this.ghQ });
          Object localObject = new e.a();
          ((e.a)localObject).zN(this.ghP);
          ((e.a)localObject).dp(this.ghR);
          ((e.a)localObject).zP(this.ghO);
          ((e.a)localObject).zQ(this.ghQ);
          ((e.a)localObject).setAppId(this.mAppId);
          ((e.a)localObject).cq(this.mPackageName);
          ((e.a)localObject).eO(true);
          ((e.a)localObject).pE(bk.getInt(this.ghT, 1));
          ((e.a)localObject).setScene(6001);
          ((e.a)localObject).zR(this.ghS);
          ((e.a)localObject).eP(this.ghU);
          ((e.a)localObject).eQ(this.ghq);
          ((e.a)localObject).eO(false);
          ((e.a)localObject).iPG.iPD = true;
          localObject = ((e.a)localObject).iPG;
          if (this.ghV == 1) {}
          for (long l = d.aFP().b((com.tencent.mm.plugin.downloader.model.e)localObject);; l = d.aFP().a((com.tencent.mm.plugin.downloader.model.e)localObject))
          {
            y.i("MicroMsg.JsApiAddDownloadTask", "doAddDownloadTaskStraight, downloadId = " + l);
            if (l > 0L) {
              break label304;
            }
            y.e("MicroMsg.JsApiAddDownloadTask", "doAddDownloadTaskStraight fail, downloadId = " + l);
            this.ghs = "";
            break;
          }
          label304:
          this.ghr = false;
          this.ghp = l;
          if (this.ghq) {
            b.dCw.a(this.mAppId, 6001, 11, l, "", this.ghS);
          }
        }
      }
    }
    
    public final void Zv()
    {
      ahD();
      if (this.ghr)
      {
        if (bk.bl(this.ghs)) {}
        for (localObject = "fail";; localObject = String.format("fail:%s", new Object[] { this.ghs }))
        {
          this.fyo.C(this.bhx, this.gho.h((String)localObject, null));
          return;
        }
      }
      Object localObject = new HashMap();
      ((Map)localObject).put("downloadId", Long.valueOf(this.ghp));
      this.fyo.C(this.bhx, this.gho.h("ok", (Map)localObject));
    }
    
    public final void e(Parcel paramParcel)
    {
      boolean bool2 = true;
      this.ghO = paramParcel.readString();
      this.ghP = paramParcel.readString();
      this.ghQ = paramParcel.readString();
      this.ghR = paramParcel.readLong();
      this.ghS = paramParcel.readString();
      this.ghT = paramParcel.readString();
      this.mAppId = paramParcel.readString();
      this.mPackageName = paramParcel.readString();
      if (paramParcel.readByte() == 1)
      {
        bool1 = true;
        this.ghq = bool1;
        if (paramParcel.readByte() != 1) {
          break label141;
        }
        bool1 = true;
        label91:
        this.ghU = bool1;
        this.ghV = paramParcel.readInt();
        if (paramParcel.readInt() != 1) {
          break label146;
        }
      }
      label141:
      label146:
      for (boolean bool1 = bool2;; bool1 = false)
      {
        this.ghr = bool1;
        this.ghs = paramParcel.readString();
        this.ghp = paramParcel.readLong();
        return;
        bool1 = false;
        break;
        bool1 = false;
        break label91;
      }
    }
    
    public void writeToParcel(Parcel paramParcel, int paramInt)
    {
      paramInt = 1;
      paramParcel.writeString(this.ghO);
      paramParcel.writeString(this.ghP);
      paramParcel.writeString(this.ghQ);
      paramParcel.writeLong(this.ghR);
      paramParcel.writeString(this.ghS);
      paramParcel.writeString(this.ghT);
      paramParcel.writeString(this.mAppId);
      paramParcel.writeString(this.mPackageName);
      byte b;
      if (this.ghq)
      {
        b = 1;
        paramParcel.writeByte(b);
        if (!this.ghU) {
          break label136;
        }
        b = 1;
        label89:
        paramParcel.writeByte(b);
        paramParcel.writeInt(this.ghV);
        if (!this.ghr) {
          break label141;
        }
      }
      for (;;)
      {
        paramParcel.writeInt(paramInt);
        paramParcel.writeString(this.ghs);
        paramParcel.writeLong(this.ghp);
        return;
        b = 0;
        break;
        label136:
        b = 0;
        break label89;
        label141:
        paramInt = 0;
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.jsapi.appdownload.JsApiAddDownloadTask
 * JD-Core Version:    0.7.0.1
 */