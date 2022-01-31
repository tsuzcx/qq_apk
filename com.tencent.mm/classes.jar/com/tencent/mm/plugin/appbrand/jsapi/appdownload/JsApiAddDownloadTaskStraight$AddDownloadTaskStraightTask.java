package com.tencent.mm.plugin.appbrand.jsapi.appdownload;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.tencent.mm.compatible.util.f;
import com.tencent.mm.kernel.g;
import com.tencent.mm.plugin.appbrand.ipc.MainProcessTask;
import com.tencent.mm.plugin.appbrand.jsapi.i;
import com.tencent.mm.plugin.appbrand.o;
import com.tencent.mm.plugin.downloader.model.d;
import com.tencent.mm.plugin.downloader.model.e.a;
import com.tencent.mm.sdk.platformtools.bk;
import com.tencent.mm.sdk.platformtools.y;
import java.util.HashMap;
import java.util.Map;
import org.json.JSONObject;

class JsApiAddDownloadTaskStraight$AddDownloadTaskStraightTask
  extends MainProcessTask
{
  public static final Parcelable.Creator<AddDownloadTaskStraightTask> CREATOR = new JsApiAddDownloadTaskStraight.AddDownloadTaskStraightTask.1();
  private int bhx;
  private o fyo;
  private String ghO;
  private String ghP;
  private String ghQ;
  private long ghR;
  private String ghS;
  private String ghT;
  private String ghW;
  private i gho;
  private long ghp;
  private boolean ghr;
  private String ghs;
  private String mAppId;
  private String mPackageName;
  
  public JsApiAddDownloadTaskStraight$AddDownloadTaskStraightTask(Parcel paramParcel)
  {
    e(paramParcel);
  }
  
  public JsApiAddDownloadTaskStraight$AddDownloadTaskStraightTask(i parami, o paramo, int paramInt, JSONObject paramJSONObject)
  {
    this.gho = parami;
    this.fyo = paramo;
    this.bhx = paramInt;
    this.ghO = paramJSONObject.optString("taskName");
    this.ghP = paramJSONObject.optString("taskUrl");
    this.ghQ = paramJSONObject.optString("fileMd5");
    this.ghW = paramJSONObject.optString("alternativeUrl");
    this.ghR = paramJSONObject.optInt("taskSize", 0);
    this.ghS = paramJSONObject.optString("extInfo");
    this.ghT = paramJSONObject.optString("fileType");
    this.mAppId = paramo.mAppId;
    this.mPackageName = paramJSONObject.optString("packageName");
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
        y.i("MicroMsg.JsApiAddDownloadTaskStraight", "runInMainProcess taskUrl:%s md5:%s", new Object[] { this.ghP, this.ghQ });
        Object localObject = new e.a();
        ((e.a)localObject).zN(this.ghP);
        ((e.a)localObject).zO(this.ghW);
        ((e.a)localObject).dp(this.ghR);
        ((e.a)localObject).zP(this.ghO);
        ((e.a)localObject).zQ(this.ghQ);
        ((e.a)localObject).setAppId(this.mAppId);
        ((e.a)localObject).cq(this.mPackageName);
        ((e.a)localObject).eO(true);
        ((e.a)localObject).pE(bk.getInt(this.ghT, 1));
        ((e.a)localObject).setScene(6001);
        ((e.a)localObject).zR(this.ghS);
        localObject = ((e.a)localObject).iPG;
        long l = d.aFP().a((com.tencent.mm.plugin.downloader.model.e)localObject);
        y.i("MicroMsg.JsApiAddDownloadTaskStraight", "doAddDownloadTaskStraight, downloadId = " + l);
        if (l <= 0L)
        {
          y.e("MicroMsg.JsApiAddDownloadTaskStraight", "doAddDownloadTaskStraight fail, downloadId = " + l);
          this.ghs = "";
        }
        else
        {
          this.ghr = false;
          this.ghp = l;
        }
      }
    }
  }
  
  public final void Zv()
  {
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
    boolean bool = true;
    this.ghO = paramParcel.readString();
    this.ghP = paramParcel.readString();
    this.ghQ = paramParcel.readString();
    this.ghW = paramParcel.readString();
    this.ghR = paramParcel.readLong();
    this.ghS = paramParcel.readString();
    this.ghT = paramParcel.readString();
    this.mAppId = paramParcel.readString();
    this.mPackageName = paramParcel.readString();
    if (paramParcel.readInt() == 1) {}
    for (;;)
    {
      this.ghr = bool;
      this.ghs = paramParcel.readString();
      this.ghp = paramParcel.readLong();
      return;
      bool = false;
    }
  }
  
  public void writeToParcel(Parcel paramParcel, int paramInt)
  {
    paramParcel.writeString(this.ghO);
    paramParcel.writeString(this.ghP);
    paramParcel.writeString(this.ghQ);
    paramParcel.writeString(this.ghW);
    paramParcel.writeLong(this.ghR);
    paramParcel.writeString(this.ghS);
    paramParcel.writeString(this.ghT);
    paramParcel.writeString(this.mAppId);
    paramParcel.writeString(this.mPackageName);
    if (this.ghr) {}
    for (paramInt = 1;; paramInt = 0)
    {
      paramParcel.writeInt(paramInt);
      paramParcel.writeString(this.ghs);
      paramParcel.writeLong(this.ghp);
      return;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.jsapi.appdownload.JsApiAddDownloadTaskStraight.AddDownloadTaskStraightTask
 * JD-Core Version:    0.7.0.1
 */