package com.tencent.mm.plugin.appbrand.jsapi.appdownload;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.a.e;
import com.tencent.mm.plugin.appbrand.ipc.MainProcessTask;
import com.tencent.mm.plugin.appbrand.jsapi.m;
import com.tencent.mm.plugin.appbrand.r;
import com.tencent.mm.plugin.downloader.model.FileDownloadTaskInfo;
import com.tencent.mm.plugin.downloader.model.f;
import com.tencent.mm.sdk.platformtools.ab;
import com.tencent.mm.sdk.platformtools.ah;
import com.tencent.mm.sdk.platformtools.at;
import com.tencent.mm.sdk.platformtools.bo;
import java.util.HashMap;
import java.util.Map;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

class JsApiQueryDownloadTask$QueryDownloadTask
  extends MainProcessTask
{
  public static final Parcelable.Creator<QueryDownloadTask> CREATOR;
  private int bxX;
  private r gPA;
  private JSONArray hBq;
  private JSONArray hBr;
  private JSONArray hBs;
  private String hBt;
  private long hBu;
  private m hyA;
  private boolean hyI;
  private String hyJ;
  private long hyK;
  
  static
  {
    AppMethodBeat.i(130709);
    CREATOR = new JsApiQueryDownloadTask.QueryDownloadTask.1();
    AppMethodBeat.o(130709);
  }
  
  public JsApiQueryDownloadTask$QueryDownloadTask(Parcel paramParcel)
  {
    AppMethodBeat.i(130701);
    f(paramParcel);
    AppMethodBeat.o(130701);
  }
  
  public JsApiQueryDownloadTask$QueryDownloadTask(m paramm, r paramr, int paramInt, JSONObject paramJSONObject)
  {
    AppMethodBeat.i(130700);
    aBj();
    this.hyA = paramm;
    this.gPA = paramr;
    this.bxX = paramInt;
    this.hyK = paramJSONObject.optLong("downloadId");
    this.hBq = paramJSONObject.optJSONArray("downloadIdArray");
    this.hBr = paramJSONObject.optJSONArray("appIdArray");
    this.hyI = true;
    AppMethodBeat.o(130700);
  }
  
  private JSONObject a(long paramLong, FileDownloadTaskInfo paramFileDownloadTaskInfo)
  {
    AppMethodBeat.i(130703);
    JSONObject localJSONObject = a(paramFileDownloadTaskInfo);
    if (paramFileDownloadTaskInfo != null) {}
    try
    {
      localJSONObject.put("downloadId", paramLong);
      AppMethodBeat.o(130703);
      return localJSONObject;
    }
    catch (JSONException paramFileDownloadTaskInfo)
    {
      for (;;)
      {
        ab.e("MicroMsg.JsApiQueryDownloadTask", paramFileDownloadTaskInfo.getMessage());
      }
    }
  }
  
  private JSONObject a(FileDownloadTaskInfo paramFileDownloadTaskInfo)
  {
    long l2 = 0L;
    AppMethodBeat.i(130705);
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
      ab.i("MicroMsg.JsApiQueryDownloadTask", "doQueryDownloadTask, state = %s", new Object[] { str1 });
      String str2 = str1;
      if (paramFileDownloadTaskInfo.kYZ)
      {
        str2 = str1;
        if (!at.isWifi(ah.getContext()))
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
        if (paramFileDownloadTaskInfo.jyU != 0L) {
          l1 = ((float)paramFileDownloadTaskInfo.kYX / (float)paramFileDownloadTaskInfo.jyU * 100.0F);
        }
      }
      try
      {
        localJSONObject.put("appId", paramFileDownloadTaskInfo.appId);
        localJSONObject.put("downloadId", paramFileDownloadTaskInfo.id);
        localJSONObject.put("state", str2);
        localJSONObject.put("progress", l1);
        AppMethodBeat.o(130705);
        return localJSONObject;
        this.hyJ = "fail_apilevel_too_low";
        AppMethodBeat.o(130705);
        return localJSONObject;
        str1 = "downloading";
        continue;
        if (e.cN(paramFileDownloadTaskInfo.path))
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
          ab.e("MicroMsg.JsApiQueryDownloadTask", paramFileDownloadTaskInfo.getMessage());
        }
      }
    }
  }
  
  private JSONObject a(String paramString, FileDownloadTaskInfo paramFileDownloadTaskInfo)
  {
    AppMethodBeat.i(130704);
    paramFileDownloadTaskInfo = a(paramFileDownloadTaskInfo);
    try
    {
      paramFileDownloadTaskInfo.put("appId", paramString);
      AppMethodBeat.o(130704);
      return paramFileDownloadTaskInfo;
    }
    catch (JSONException paramString)
    {
      for (;;)
      {
        ab.e("MicroMsg.JsApiQueryDownloadTask", paramString.getMessage());
      }
    }
  }
  
  public final void ata()
  {
    AppMethodBeat.i(130702);
    ab.i("MicroMsg.JsApiQueryDownloadTask", "doQueryDownloadTask, downloadId = %d", new Object[] { Long.valueOf(this.hyK) });
    int i;
    if ((this.hBq != null) && (this.hBq.length() > 0))
    {
      this.hBs = new JSONArray();
      i = 0;
      while (i < this.hBq.length())
      {
        long l = this.hBq.optLong(i);
        localObject = f.bjl().iA(l);
        this.hBs.put(a(l, (FileDownloadTaskInfo)localObject));
        i += 1;
      }
      this.hyI = false;
    }
    for (;;)
    {
      aBp();
      AppMethodBeat.o(130702);
      return;
      if ((this.hBr != null) && (this.hBr.length() > 0))
      {
        this.hBs = new JSONArray();
        i = 0;
        while (i < this.hBr.length())
        {
          localObject = this.hBr.optString(i);
          FileDownloadTaskInfo localFileDownloadTaskInfo = f.bjl().JH((String)localObject);
          this.hBs.put(a((String)localObject, localFileDownloadTaskInfo));
          i += 1;
        }
        this.hyI = false;
      }
      else
      {
        if (this.hyK > 0L) {
          break;
        }
        this.hyJ = "downloadId invalid";
      }
    }
    Object localObject = f.bjl().iA(this.hyK);
    if ((((FileDownloadTaskInfo)localObject).kYZ) && (((FileDownloadTaskInfo)localObject).status != 1) && (((FileDownloadTaskInfo)localObject).status != 3)) {
      this.hBt = "download_wait_wifi";
    }
    switch (((FileDownloadTaskInfo)localObject).status)
    {
    case 0: 
    default: 
      this.hBt = "default";
    }
    for (;;)
    {
      ab.i("MicroMsg.JsApiQueryDownloadTask", "doQueryDownloadTask, state = %s", new Object[] { this.hBt });
      if (((this.hBt == "downloading") || (this.hBt == "download_pause")) && (((FileDownloadTaskInfo)localObject).jyU != 0L)) {
        this.hBu = (((float)((FileDownloadTaskInfo)localObject).kYX / (float)((FileDownloadTaskInfo)localObject).jyU * 100.0F));
      }
      if ((((FileDownloadTaskInfo)localObject).kYZ) && (!at.isWifi(ah.getContext())) && (((FileDownloadTaskInfo)localObject).status != 3) && (((FileDownloadTaskInfo)localObject).status != 1)) {
        this.hBt = "download_wait_wifi";
      }
      this.hyI = false;
      break;
      this.hyJ = "fail_apilevel_too_low";
      break;
      this.hBt = "downloading";
      continue;
      if (e.cN(((FileDownloadTaskInfo)localObject).path))
      {
        this.hBt = "download_succ";
      }
      else
      {
        this.hBt = "default";
        continue;
        this.hBt = "download_pause";
        continue;
        this.hBt = "download_fail";
      }
    }
  }
  
  public final void atb()
  {
    AppMethodBeat.i(130706);
    aBk();
    boolean bool;
    if (this.gPA == null)
    {
      bool = true;
      ab.d("MicroMsg.JsApiQueryDownloadTask", "callback, service is null: %b", new Object[] { Boolean.valueOf(bool) });
      if (!this.hyI) {
        break label109;
      }
      if (!bo.isNullOrNil(this.hyJ)) {
        break label88;
      }
    }
    label88:
    for (Object localObject = "fail";; localObject = String.format("fail:%s", new Object[] { this.hyJ }))
    {
      this.gPA.h(this.bxX, this.hyA.j((String)localObject, null));
      AppMethodBeat.o(130706);
      return;
      bool = false;
      break;
    }
    label109:
    localObject = new HashMap();
    if (this.hBs != null) {
      ((Map)localObject).put("result", this.hBs);
    }
    for (;;)
    {
      this.gPA.h(this.bxX, this.hyA.j("ok", (Map)localObject));
      AppMethodBeat.o(130706);
      return;
      ((Map)localObject).put("downloadId", Long.valueOf(this.hyK));
      ((Map)localObject).put("state", this.hBt);
      ((Map)localObject).put("progress", Long.valueOf(this.hBu));
    }
  }
  
  public final void f(Parcel paramParcel)
  {
    boolean bool = true;
    AppMethodBeat.i(130707);
    this.hyK = paramParcel.readLong();
    if (paramParcel.readInt() == 1) {}
    for (;;)
    {
      this.hyI = bool;
      this.hyJ = paramParcel.readString();
      this.hBt = paramParcel.readString();
      this.hBu = paramParcel.readLong();
      String str1 = paramParcel.readString();
      String str2 = paramParcel.readString();
      paramParcel = paramParcel.readString();
      if (str1 != null) {}
      try
      {
        this.hBq = new JSONArray(str1);
        if (str2 != null) {
          this.hBr = new JSONArray(str2);
        }
        if (paramParcel != null) {
          this.hBs = new JSONArray(paramParcel);
        }
        AppMethodBeat.o(130707);
        return;
      }
      catch (JSONException paramParcel)
      {
        ab.printErrStackTrace("MicroMsg.JsApiQueryDownloadTask", paramParcel, "", new Object[0]);
        AppMethodBeat.o(130707);
      }
      bool = false;
    }
  }
  
  public void writeToParcel(Parcel paramParcel, int paramInt)
  {
    Object localObject2 = null;
    AppMethodBeat.i(130708);
    paramParcel.writeLong(this.hyK);
    if (this.hyI)
    {
      paramInt = 1;
      paramParcel.writeInt(paramInt);
      paramParcel.writeString(this.hyJ);
      paramParcel.writeString(this.hBt);
      paramParcel.writeLong(this.hBu);
      if (this.hBq == null) {
        break label130;
      }
      localObject1 = this.hBq.toString();
      label70:
      paramParcel.writeString((String)localObject1);
      if (this.hBr == null) {
        break label135;
      }
    }
    label130:
    label135:
    for (Object localObject1 = this.hBr.toString();; localObject1 = null)
    {
      paramParcel.writeString((String)localObject1);
      localObject1 = localObject2;
      if (this.hBs != null) {
        localObject1 = this.hBs.toString();
      }
      paramParcel.writeString((String)localObject1);
      AppMethodBeat.o(130708);
      return;
      paramInt = 0;
      break;
      localObject1 = null;
      break label70;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.jsapi.appdownload.JsApiQueryDownloadTask.QueryDownloadTask
 * JD-Core Version:    0.7.0.1
 */