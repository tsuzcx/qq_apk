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
import com.tencent.mm.sdk.platformtools.bo;
import java.util.HashMap;
import java.util.Map;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

class JsApiQueryDownloadTaskForNative$QueryDownloadTask
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
  private float hBv;
  private boolean hBw;
  private m hyA;
  private boolean hyI;
  private String hyJ;
  private long hyK;
  
  static
  {
    AppMethodBeat.i(143367);
    CREATOR = new JsApiQueryDownloadTaskForNative.QueryDownloadTask.1();
    AppMethodBeat.o(143367);
  }
  
  public JsApiQueryDownloadTaskForNative$QueryDownloadTask(Parcel paramParcel)
  {
    AppMethodBeat.i(143359);
    f(paramParcel);
    AppMethodBeat.o(143359);
  }
  
  public JsApiQueryDownloadTaskForNative$QueryDownloadTask(m paramm, r paramr, int paramInt, JSONObject paramJSONObject)
  {
    AppMethodBeat.i(143358);
    aBj();
    this.hyA = paramm;
    this.gPA = paramr;
    this.bxX = paramInt;
    this.hyK = paramJSONObject.optLong("downloadId");
    this.hBq = paramJSONObject.optJSONArray("downloadIdArray");
    this.hBr = paramJSONObject.optJSONArray("appIdArray");
    this.hyI = true;
    AppMethodBeat.o(143358);
  }
  
  private JSONObject a(long paramLong, FileDownloadTaskInfo paramFileDownloadTaskInfo)
  {
    AppMethodBeat.i(143361);
    JSONObject localJSONObject = a(paramFileDownloadTaskInfo);
    if (paramFileDownloadTaskInfo != null) {}
    try
    {
      localJSONObject.put("downloadId", paramLong);
      AppMethodBeat.o(143361);
      return localJSONObject;
    }
    catch (JSONException paramFileDownloadTaskInfo)
    {
      for (;;)
      {
        ab.e("MicroMsg.JsApiQueryDownloadTaskForNative", paramFileDownloadTaskInfo.getMessage());
      }
    }
  }
  
  private JSONObject a(FileDownloadTaskInfo paramFileDownloadTaskInfo)
  {
    long l = 0L;
    AppMethodBeat.i(143363);
    JSONObject localJSONObject = new JSONObject();
    String str;
    float f;
    switch (paramFileDownloadTaskInfo.status)
    {
    case 0: 
    default: 
      str = "default";
      ab.i("MicroMsg.JsApiQueryDownloadTaskForNative", "doQueryDownloadTask, state = %s", new Object[] { str });
      f = 0.0F;
      if (paramFileDownloadTaskInfo.jyU != 0L)
      {
        l = paramFileDownloadTaskInfo.kYX * 100L / paramFileDownloadTaskInfo.jyU;
        f = (float)paramFileDownloadTaskInfo.kYX * 100.0F / (float)paramFileDownloadTaskInfo.jyU;
      }
      break;
    }
    for (;;)
    {
      try
      {
        localJSONObject.put("appId", paramFileDownloadTaskInfo.appId);
        localJSONObject.put("downloadId", paramFileDownloadTaskInfo.id);
        localJSONObject.put("state", str);
        localJSONObject.put("progress", l);
        localJSONObject.put("progress_float", f);
        if (!paramFileDownloadTaskInfo.kZa) {
          continue;
        }
        i = 1;
        localJSONObject.put("reserve_for_wifi", i);
      }
      catch (JSONException paramFileDownloadTaskInfo)
      {
        int i;
        ab.e("MicroMsg.JsApiQueryDownloadTaskForNative", paramFileDownloadTaskInfo.getMessage());
        continue;
      }
      AppMethodBeat.o(143363);
      return localJSONObject;
      this.hyJ = "fail_apilevel_too_low";
      AppMethodBeat.o(143363);
      return localJSONObject;
      str = "downloading";
      break;
      if (e.cN(paramFileDownloadTaskInfo.path))
      {
        str = "download_succ";
        break;
      }
      str = "default";
      break;
      str = "download_pause";
      break;
      str = "download_fail";
      break;
      i = 0;
    }
  }
  
  private JSONObject a(String paramString, FileDownloadTaskInfo paramFileDownloadTaskInfo)
  {
    AppMethodBeat.i(143362);
    paramFileDownloadTaskInfo = a(paramFileDownloadTaskInfo);
    try
    {
      paramFileDownloadTaskInfo.put("appId", paramString);
      AppMethodBeat.o(143362);
      return paramFileDownloadTaskInfo;
    }
    catch (JSONException paramString)
    {
      for (;;)
      {
        ab.e("MicroMsg.JsApiQueryDownloadTaskForNative", paramString.getMessage());
      }
    }
  }
  
  public final void ata()
  {
    AppMethodBeat.i(143360);
    ab.i("MicroMsg.JsApiQueryDownloadTaskForNative", "doQueryDownloadTask, downloadId = %d", new Object[] { Long.valueOf(this.hyK) });
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
      AppMethodBeat.o(143360);
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
    switch (((FileDownloadTaskInfo)localObject).status)
    {
    case 0: 
    default: 
      this.hBt = "default";
    }
    for (;;)
    {
      ab.i("MicroMsg.JsApiQueryDownloadTaskForNative", "doQueryDownloadTask, state = %s", new Object[] { this.hBt });
      if (((FileDownloadTaskInfo)localObject).jyU != 0L)
      {
        this.hBu = (((float)((FileDownloadTaskInfo)localObject).kYX / (float)((FileDownloadTaskInfo)localObject).jyU * 100.0F));
        this.hBv = ((float)((FileDownloadTaskInfo)localObject).kYX * 100.0F / (float)((FileDownloadTaskInfo)localObject).jyU);
      }
      this.hBw = ((FileDownloadTaskInfo)localObject).kZa;
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
    AppMethodBeat.i(143364);
    aBk();
    boolean bool;
    if (this.gPA == null)
    {
      bool = true;
      ab.d("MicroMsg.JsApiQueryDownloadTaskForNative", "callback, service is null: %b", new Object[] { Boolean.valueOf(bool) });
      if (!this.hyI) {
        break label110;
      }
      if (!bo.isNullOrNil(this.hyJ)) {
        break label89;
      }
    }
    label89:
    for (Object localObject = "fail";; localObject = String.format("fail:%s", new Object[] { this.hyJ }))
    {
      this.gPA.h(this.bxX, this.hyA.j((String)localObject, null));
      AppMethodBeat.o(143364);
      return;
      bool = false;
      break;
    }
    label110:
    localObject = new HashMap();
    if (this.hBs != null) {
      ((Map)localObject).put("result", this.hBs);
    }
    for (;;)
    {
      this.gPA.h(this.bxX, this.hyA.j("ok", (Map)localObject));
      AppMethodBeat.o(143364);
      return;
      ((Map)localObject).put("downloadId", Long.valueOf(this.hyK));
      ((Map)localObject).put("state", this.hBt);
      ((Map)localObject).put("progress", Long.valueOf(this.hBu));
      ((Map)localObject).put("progress_float", Float.valueOf(this.hBv));
      ((Map)localObject).put("reserve_for_wifi", Boolean.valueOf(this.hBw));
    }
  }
  
  public final void f(Parcel paramParcel)
  {
    boolean bool2 = true;
    AppMethodBeat.i(143365);
    this.hyK = paramParcel.readLong();
    if (paramParcel.readInt() == 1) {}
    for (bool1 = true;; bool1 = false)
    {
      this.hyI = bool1;
      this.hyJ = paramParcel.readString();
      this.hBt = paramParcel.readString();
      this.hBu = paramParcel.readLong();
      String str1 = paramParcel.readString();
      String str2 = paramParcel.readString();
      String str3 = paramParcel.readString();
      if (str1 != null) {}
      try
      {
        this.hBq = new JSONArray(str1);
        if (str2 != null) {
          this.hBr = new JSONArray(str2);
        }
        if (str3 != null) {
          this.hBs = new JSONArray(str3);
        }
      }
      catch (JSONException localJSONException)
      {
        for (;;)
        {
          ab.printErrStackTrace("MicroMsg.JsApiQueryDownloadTaskForNative", localJSONException, "", new Object[0]);
          continue;
          bool1 = false;
        }
      }
      if (paramParcel.readInt() != 1) {
        break;
      }
      bool1 = bool2;
      this.hBw = bool1;
      AppMethodBeat.o(143365);
      return;
    }
  }
  
  public void writeToParcel(Parcel paramParcel, int paramInt)
  {
    int i = 1;
    Object localObject2 = null;
    AppMethodBeat.i(143366);
    paramParcel.writeLong(this.hyK);
    Object localObject1;
    if (this.hyI)
    {
      paramInt = 1;
      paramParcel.writeInt(paramInt);
      paramParcel.writeString(this.hyJ);
      paramParcel.writeString(this.hBt);
      paramParcel.writeLong(this.hBu);
      if (this.hBq == null) {
        break label153;
      }
      localObject1 = this.hBq.toString();
      label73:
      paramParcel.writeString((String)localObject1);
      if (this.hBr == null) {
        break label159;
      }
      localObject1 = this.hBr.toString();
      label95:
      paramParcel.writeString((String)localObject1);
      localObject1 = localObject2;
      if (this.hBs != null) {
        localObject1 = this.hBs.toString();
      }
      paramParcel.writeString((String)localObject1);
      if (!this.hBw) {
        break label165;
      }
    }
    label153:
    label159:
    label165:
    for (paramInt = i;; paramInt = 0)
    {
      paramParcel.writeInt(paramInt);
      AppMethodBeat.o(143366);
      return;
      paramInt = 0;
      break;
      localObject1 = null;
      break label73;
      localObject1 = null;
      break label95;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.jsapi.appdownload.JsApiQueryDownloadTaskForNative.QueryDownloadTask
 * JD-Core Version:    0.7.0.1
 */