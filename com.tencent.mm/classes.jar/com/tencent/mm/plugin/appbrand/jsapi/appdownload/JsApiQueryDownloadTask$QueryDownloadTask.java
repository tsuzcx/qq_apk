package com.tencent.mm.plugin.appbrand.jsapi.appdownload;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.tencent.mm.a.e;
import com.tencent.mm.plugin.appbrand.ipc.MainProcessTask;
import com.tencent.mm.plugin.appbrand.jsapi.i;
import com.tencent.mm.plugin.appbrand.o;
import com.tencent.mm.plugin.downloader.model.FileDownloadTaskInfo;
import com.tencent.mm.plugin.downloader.model.d;
import com.tencent.mm.sdk.platformtools.ae;
import com.tencent.mm.sdk.platformtools.aq;
import com.tencent.mm.sdk.platformtools.bk;
import com.tencent.mm.sdk.platformtools.y;
import java.util.HashMap;
import java.util.Map;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

class JsApiQueryDownloadTask$QueryDownloadTask
  extends MainProcessTask
{
  public static final Parcelable.Creator<QueryDownloadTask> CREATOR = new JsApiQueryDownloadTask.QueryDownloadTask.1();
  private int bhx;
  private o fyo;
  private i gho;
  private long ghp;
  private boolean ghr;
  private String ghs;
  private JSONArray gic;
  private JSONArray gid;
  private JSONArray gie;
  private String gif;
  private long gig;
  
  public JsApiQueryDownloadTask$QueryDownloadTask(Parcel paramParcel)
  {
    e(paramParcel);
  }
  
  public JsApiQueryDownloadTask$QueryDownloadTask(i parami, o paramo, int paramInt, JSONObject paramJSONObject)
  {
    ahC();
    this.gho = parami;
    this.fyo = paramo;
    this.bhx = paramInt;
    this.ghp = paramJSONObject.optLong("downloadId");
    this.gic = paramJSONObject.optJSONArray("downloadIdArray");
    this.gid = paramJSONObject.optJSONArray("appIdArray");
    this.ghr = true;
  }
  
  private JSONObject a(long paramLong, FileDownloadTaskInfo paramFileDownloadTaskInfo)
  {
    JSONObject localJSONObject = a(paramFileDownloadTaskInfo);
    if (paramFileDownloadTaskInfo != null) {}
    try
    {
      localJSONObject.put("downloadId", paramLong);
      return localJSONObject;
    }
    catch (JSONException paramFileDownloadTaskInfo)
    {
      y.e("MicroMsg.JsApiQueryDownloadTask", paramFileDownloadTaskInfo.getMessage());
    }
    return localJSONObject;
  }
  
  private JSONObject a(FileDownloadTaskInfo paramFileDownloadTaskInfo)
  {
    long l2 = 0L;
    JSONObject localJSONObject = new JSONObject();
    String str1;
    switch (paramFileDownloadTaskInfo.status)
    {
    case 0: 
    default: 
      str1 = "default";
    }
    for (;;)
    {
      y.i("MicroMsg.JsApiQueryDownloadTask", "doQueryDownloadTask, state = %s", new Object[] { str1 });
      String str2 = str1;
      if (paramFileDownloadTaskInfo.iPO)
      {
        str2 = str1;
        if (!aq.isWifi(ae.getContext()))
        {
          str2 = str1;
          if (paramFileDownloadTaskInfo.status != 3)
          {
            str2 = str1;
            if (paramFileDownloadTaskInfo.status != 1) {
              str2 = "download_wait_wifi";
            }
          }
        }
      }
      long l1;
      if (str2 != "downloading")
      {
        l1 = l2;
        if (str2 != "download_pause") {}
      }
      else
      {
        l1 = l2;
        if (paramFileDownloadTaskInfo.hFz != 0L) {
          l1 = ((float)paramFileDownloadTaskInfo.iPM / (float)paramFileDownloadTaskInfo.hFz * 100.0F);
        }
      }
      try
      {
        localJSONObject.put("appId", paramFileDownloadTaskInfo.appId);
        localJSONObject.put("downloadId", paramFileDownloadTaskInfo.id);
        localJSONObject.put("state", str2);
        localJSONObject.put("progress", l1);
        return localJSONObject;
        this.ghs = "fail_apilevel_too_low";
        return localJSONObject;
        str1 = "downloading";
        continue;
        if (e.bK(paramFileDownloadTaskInfo.path))
        {
          str1 = "download_succ";
          continue;
        }
        str1 = "default";
        continue;
        str1 = "download_pause";
        continue;
        str1 = "download_fail";
      }
      catch (JSONException paramFileDownloadTaskInfo)
      {
        for (;;)
        {
          y.e("MicroMsg.JsApiQueryDownloadTask", paramFileDownloadTaskInfo.getMessage());
        }
      }
    }
  }
  
  private JSONObject a(String paramString, FileDownloadTaskInfo paramFileDownloadTaskInfo)
  {
    JSONObject localJSONObject = a(paramFileDownloadTaskInfo);
    if (paramFileDownloadTaskInfo != null) {}
    try
    {
      localJSONObject.put("appId", paramString);
      return localJSONObject;
    }
    catch (JSONException paramString)
    {
      y.e("MicroMsg.JsApiQueryDownloadTask", paramString.getMessage());
    }
    return localJSONObject;
  }
  
  public final void Zu()
  {
    y.i("MicroMsg.JsApiQueryDownloadTask", "doQueryDownloadTask, downloadId = %d", new Object[] { Long.valueOf(this.ghp) });
    int i;
    if ((this.gic != null) && (this.gic.length() > 0))
    {
      this.gie = new JSONArray();
      i = 0;
      while (i < this.gic.length())
      {
        long l = this.gic.optLong(i);
        localObject = d.aFP().dd(l);
        this.gie.put(a(l, (FileDownloadTaskInfo)localObject));
        i += 1;
      }
      this.ghr = false;
    }
    for (;;)
    {
      ahI();
      return;
      if ((this.gid != null) && (this.gid.length() > 0))
      {
        this.gie = new JSONArray();
        i = 0;
        while (i < this.gid.length())
        {
          localObject = this.gid.optString(i);
          FileDownloadTaskInfo localFileDownloadTaskInfo = d.aFP().zL((String)localObject);
          this.gie.put(a((String)localObject, localFileDownloadTaskInfo));
          i += 1;
        }
        this.ghr = false;
      }
      else
      {
        if (this.ghp > 0L) {
          break;
        }
        this.ghs = "downloadId invalid";
      }
    }
    Object localObject = d.aFP().dd(this.ghp);
    if ((((FileDownloadTaskInfo)localObject).iPO) && (((FileDownloadTaskInfo)localObject).status != 1) && (((FileDownloadTaskInfo)localObject).status != 3)) {
      this.gif = "download_wait_wifi";
    }
    switch (((FileDownloadTaskInfo)localObject).status)
    {
    case 0: 
    default: 
      this.gif = "default";
    }
    for (;;)
    {
      y.i("MicroMsg.JsApiQueryDownloadTask", "doQueryDownloadTask, state = %s", new Object[] { this.gif });
      if (((this.gif == "downloading") || (this.gif == "download_pause")) && (((FileDownloadTaskInfo)localObject).hFz != 0L)) {
        this.gig = (((float)((FileDownloadTaskInfo)localObject).iPM / (float)((FileDownloadTaskInfo)localObject).hFz * 100.0F));
      }
      if ((((FileDownloadTaskInfo)localObject).iPO) && (!aq.isWifi(ae.getContext())) && (((FileDownloadTaskInfo)localObject).status != 3) && (((FileDownloadTaskInfo)localObject).status != 1)) {
        this.gif = "download_wait_wifi";
      }
      this.ghr = false;
      break;
      this.ghs = "fail_apilevel_too_low";
      break;
      this.gif = "downloading";
      continue;
      if (e.bK(((FileDownloadTaskInfo)localObject).path))
      {
        this.gif = "download_succ";
      }
      else
      {
        this.gif = "default";
        continue;
        this.gif = "download_pause";
        continue;
        this.gif = "download_fail";
      }
    }
  }
  
  public final void Zv()
  {
    ahD();
    boolean bool;
    if (this.fyo == null)
    {
      bool = true;
      y.d("MicroMsg.JsApiQueryDownloadTask", "callback, service is null: %b", new Object[] { Boolean.valueOf(bool) });
      if (!this.ghr) {
        break label98;
      }
      if (!bk.bl(this.ghs)) {
        break label77;
      }
    }
    label77:
    for (Object localObject = "fail";; localObject = String.format("fail:%s", new Object[] { this.ghs }))
    {
      this.fyo.C(this.bhx, this.gho.h((String)localObject, null));
      return;
      bool = false;
      break;
    }
    label98:
    localObject = new HashMap();
    if (this.gie != null) {
      ((Map)localObject).put("result", this.gie);
    }
    for (;;)
    {
      this.fyo.C(this.bhx, this.gho.h("ok", (Map)localObject));
      return;
      ((Map)localObject).put("downloadId", Long.valueOf(this.ghp));
      ((Map)localObject).put("state", this.gif);
      ((Map)localObject).put("progress", Long.valueOf(this.gig));
    }
  }
  
  public final void e(Parcel paramParcel)
  {
    boolean bool = true;
    this.ghp = paramParcel.readLong();
    if (paramParcel.readInt() == 1) {}
    for (;;)
    {
      this.ghr = bool;
      this.ghs = paramParcel.readString();
      this.gif = paramParcel.readString();
      this.gig = paramParcel.readLong();
      String str1 = paramParcel.readString();
      String str2 = paramParcel.readString();
      paramParcel = paramParcel.readString();
      if (str1 != null) {}
      try
      {
        this.gic = new JSONArray(str1);
        if (str2 != null) {
          this.gid = new JSONArray(str2);
        }
        if (paramParcel != null) {
          this.gie = new JSONArray(paramParcel);
        }
        return;
      }
      catch (JSONException paramParcel)
      {
        y.printErrStackTrace("MicroMsg.JsApiQueryDownloadTask", paramParcel, "", new Object[0]);
      }
      bool = false;
    }
  }
  
  public void writeToParcel(Parcel paramParcel, int paramInt)
  {
    Object localObject2 = null;
    paramParcel.writeLong(this.ghp);
    if (this.ghr)
    {
      paramInt = 1;
      paramParcel.writeInt(paramInt);
      paramParcel.writeString(this.ghs);
      paramParcel.writeString(this.gif);
      paramParcel.writeLong(this.gig);
      if (this.gic == null) {
        break label118;
      }
      localObject1 = this.gic.toString();
      label64:
      paramParcel.writeString((String)localObject1);
      if (this.gid == null) {
        break label123;
      }
    }
    label118:
    label123:
    for (Object localObject1 = this.gid.toString();; localObject1 = null)
    {
      paramParcel.writeString((String)localObject1);
      localObject1 = localObject2;
      if (this.gie != null) {
        localObject1 = this.gie.toString();
      }
      paramParcel.writeString((String)localObject1);
      return;
      paramInt = 0;
      break;
      localObject1 = null;
      break label64;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.jsapi.appdownload.JsApiQueryDownloadTask.QueryDownloadTask
 * JD-Core Version:    0.7.0.1
 */