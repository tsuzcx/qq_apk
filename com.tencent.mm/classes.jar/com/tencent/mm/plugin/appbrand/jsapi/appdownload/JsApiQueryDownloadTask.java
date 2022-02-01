package com.tencent.mm.plugin.appbrand.jsapi.appdownload;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.appbrand.ipc.MainProcessTask;
import com.tencent.mm.plugin.appbrand.jsapi.d;
import com.tencent.mm.plugin.appbrand.jsapi.p;
import com.tencent.mm.plugin.downloader.model.FileDownloadTaskInfo;
import com.tencent.mm.plugin.downloader.model.f;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.MMApplicationContext;
import com.tencent.mm.sdk.platformtools.NetStatusUtil;
import com.tencent.mm.sdk.platformtools.Util;
import java.util.HashMap;
import java.util.Map;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

public final class JsApiQueryDownloadTask
  extends d<com.tencent.mm.plugin.appbrand.s>
{
  public static final int CTRL_INDEX = 441;
  public static final String NAME = "queryDownloadTask";
  
  static class QueryDownloadTask
    extends MainProcessTask
  {
    public static final Parcelable.Creator<QueryDownloadTask> CREATOR;
    private int csv;
    private com.tencent.mm.plugin.appbrand.s kAr;
    private p lAi;
    private boolean lAq;
    private String lAr;
    private long lAs;
    private JSONArray lDu;
    private JSONArray lDv;
    private JSONArray lDw;
    private String lDx;
    private long lDy;
    
    static
    {
      AppMethodBeat.i(45878);
      CREATOR = new Parcelable.Creator() {};
      AppMethodBeat.o(45878);
    }
    
    public QueryDownloadTask(Parcel paramParcel)
    {
      AppMethodBeat.i(45870);
      f(paramParcel);
      AppMethodBeat.o(45870);
    }
    
    public QueryDownloadTask(p paramp, com.tencent.mm.plugin.appbrand.s params, int paramInt, JSONObject paramJSONObject)
    {
      AppMethodBeat.i(45869);
      bDJ();
      this.lAi = paramp;
      this.kAr = params;
      this.csv = paramInt;
      this.lAs = paramJSONObject.optLong("downloadId");
      this.lDu = paramJSONObject.optJSONArray("downloadIdArray");
      this.lDv = paramJSONObject.optJSONArray("appIdArray");
      this.lAq = true;
      AppMethodBeat.o(45869);
    }
    
    private JSONObject a(long paramLong, FileDownloadTaskInfo paramFileDownloadTaskInfo)
    {
      AppMethodBeat.i(45872);
      JSONObject localJSONObject = a(paramFileDownloadTaskInfo);
      if (paramFileDownloadTaskInfo != null) {}
      try
      {
        localJSONObject.put("downloadId", paramLong);
        AppMethodBeat.o(45872);
        return localJSONObject;
      }
      catch (JSONException paramFileDownloadTaskInfo)
      {
        for (;;)
        {
          Log.e("MicroMsg.JsApiQueryDownloadTask", paramFileDownloadTaskInfo.getMessage());
        }
      }
    }
    
    private JSONObject a(FileDownloadTaskInfo paramFileDownloadTaskInfo)
    {
      long l2 = 0L;
      AppMethodBeat.i(45874);
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
        Log.i("MicroMsg.JsApiQueryDownloadTask", "doQueryDownloadTask, state = %s", new Object[] { str1 });
        String str2 = str1;
        if (paramFileDownloadTaskInfo.qJg)
        {
          str2 = str1;
          if (!NetStatusUtil.isWifi(MMApplicationContext.getContext()))
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
          if (paramFileDownloadTaskInfo.oJj != 0L) {
            l1 = ((float)paramFileDownloadTaskInfo.qJe / (float)paramFileDownloadTaskInfo.oJj * 100.0F);
          }
        }
        try
        {
          localJSONObject.put("appId", paramFileDownloadTaskInfo.appId);
          localJSONObject.put("downloadId", paramFileDownloadTaskInfo.id);
          localJSONObject.put("state", str2);
          localJSONObject.put("progress", l1);
          AppMethodBeat.o(45874);
          return localJSONObject;
          this.lAr = "fail_apilevel_too_low";
          AppMethodBeat.o(45874);
          return localJSONObject;
          str1 = "downloading";
          continue;
          if (com.tencent.mm.vfs.s.YS(paramFileDownloadTaskInfo.path))
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
            Log.e("MicroMsg.JsApiQueryDownloadTask", paramFileDownloadTaskInfo.getMessage());
          }
        }
      }
    }
    
    private JSONObject a(String paramString, FileDownloadTaskInfo paramFileDownloadTaskInfo)
    {
      AppMethodBeat.i(45873);
      paramFileDownloadTaskInfo = a(paramFileDownloadTaskInfo);
      try
      {
        paramFileDownloadTaskInfo.put("appId", paramString);
        AppMethodBeat.o(45873);
        return paramFileDownloadTaskInfo;
      }
      catch (JSONException paramString)
      {
        for (;;)
        {
          Log.e("MicroMsg.JsApiQueryDownloadTask", paramString.getMessage());
        }
      }
    }
    
    public final void bjj()
    {
      AppMethodBeat.i(45871);
      Log.i("MicroMsg.JsApiQueryDownloadTask", "doQueryDownloadTask, downloadId = %d", new Object[] { Long.valueOf(this.lAs) });
      int i;
      if ((this.lDu != null) && (this.lDu.length() > 0))
      {
        this.lDw = new JSONArray();
        i = 0;
        while (i < this.lDu.length())
        {
          long l = this.lDu.optLong(i);
          localObject = f.cBv().Co(l);
          this.lDw.put(a(l, (FileDownloadTaskInfo)localObject));
          i += 1;
        }
        this.lAq = false;
      }
      for (;;)
      {
        bDU();
        AppMethodBeat.o(45871);
        return;
        if ((this.lDv != null) && (this.lDv.length() > 0))
        {
          this.lDw = new JSONArray();
          i = 0;
          while (i < this.lDv.length())
          {
            localObject = this.lDv.optString(i);
            FileDownloadTaskInfo localFileDownloadTaskInfo = f.cBv().alg((String)localObject);
            this.lDw.put(a((String)localObject, localFileDownloadTaskInfo));
            i += 1;
          }
          this.lAq = false;
        }
        else
        {
          if (this.lAs > 0L) {
            break;
          }
          this.lAr = "downloadId invalid";
        }
      }
      Object localObject = f.cBv().Co(this.lAs);
      if ((((FileDownloadTaskInfo)localObject).qJg) && (((FileDownloadTaskInfo)localObject).status != 1) && (((FileDownloadTaskInfo)localObject).status != 3)) {
        this.lDx = "download_wait_wifi";
      }
      switch (((FileDownloadTaskInfo)localObject).status)
      {
      case 0: 
      default: 
        this.lDx = "default";
      }
      for (;;)
      {
        Log.i("MicroMsg.JsApiQueryDownloadTask", "doQueryDownloadTask, state = %s", new Object[] { this.lDx });
        if (((this.lDx == "downloading") || (this.lDx == "download_pause")) && (((FileDownloadTaskInfo)localObject).oJj != 0L)) {
          this.lDy = (((float)((FileDownloadTaskInfo)localObject).qJe / (float)((FileDownloadTaskInfo)localObject).oJj * 100.0F));
        }
        if ((((FileDownloadTaskInfo)localObject).qJg) && (!NetStatusUtil.isWifi(MMApplicationContext.getContext())) && (((FileDownloadTaskInfo)localObject).status != 3) && (((FileDownloadTaskInfo)localObject).status != 1)) {
          this.lDx = "download_wait_wifi";
        }
        this.lAq = false;
        break;
        this.lAr = "fail_apilevel_too_low";
        break;
        this.lDx = "downloading";
        continue;
        if (com.tencent.mm.vfs.s.YS(((FileDownloadTaskInfo)localObject).path))
        {
          this.lDx = "download_succ";
        }
        else
        {
          this.lDx = "default";
          continue;
          this.lDx = "download_pause";
          continue;
          this.lDx = "download_fail";
        }
      }
    }
    
    public final void bjk()
    {
      AppMethodBeat.i(45875);
      bDK();
      boolean bool;
      if (this.kAr == null)
      {
        bool = true;
        Log.d("MicroMsg.JsApiQueryDownloadTask", "callback, service is null: %b", new Object[] { Boolean.valueOf(bool) });
        if (!this.lAq) {
          break label109;
        }
        if (!Util.isNullOrNil(this.lAr)) {
          break label88;
        }
      }
      label88:
      for (Object localObject = "fail";; localObject = String.format("fail:%s", new Object[] { this.lAr }))
      {
        this.kAr.i(this.csv, this.lAi.h((String)localObject, null));
        AppMethodBeat.o(45875);
        return;
        bool = false;
        break;
      }
      label109:
      localObject = new HashMap();
      if (this.lDw != null) {
        ((Map)localObject).put("result", this.lDw);
      }
      for (;;)
      {
        this.kAr.i(this.csv, this.lAi.n("ok", (Map)localObject));
        AppMethodBeat.o(45875);
        return;
        ((Map)localObject).put("downloadId", Long.valueOf(this.lAs));
        ((Map)localObject).put("state", this.lDx);
        ((Map)localObject).put("progress", Long.valueOf(this.lDy));
      }
    }
    
    public final void f(Parcel paramParcel)
    {
      boolean bool = true;
      AppMethodBeat.i(45876);
      this.lAs = paramParcel.readLong();
      if (paramParcel.readInt() == 1) {}
      for (;;)
      {
        this.lAq = bool;
        this.lAr = paramParcel.readString();
        this.lDx = paramParcel.readString();
        this.lDy = paramParcel.readLong();
        String str1 = paramParcel.readString();
        String str2 = paramParcel.readString();
        paramParcel = paramParcel.readString();
        if (str1 != null) {}
        try
        {
          this.lDu = new JSONArray(str1);
          if (str2 != null) {
            this.lDv = new JSONArray(str2);
          }
          if (paramParcel != null) {
            this.lDw = new JSONArray(paramParcel);
          }
          AppMethodBeat.o(45876);
          return;
        }
        catch (JSONException paramParcel)
        {
          Log.printErrStackTrace("MicroMsg.JsApiQueryDownloadTask", paramParcel, "", new Object[0]);
          AppMethodBeat.o(45876);
        }
        bool = false;
      }
    }
    
    public void writeToParcel(Parcel paramParcel, int paramInt)
    {
      Object localObject2 = null;
      AppMethodBeat.i(45877);
      paramParcel.writeLong(this.lAs);
      if (this.lAq)
      {
        paramInt = 1;
        paramParcel.writeInt(paramInt);
        paramParcel.writeString(this.lAr);
        paramParcel.writeString(this.lDx);
        paramParcel.writeLong(this.lDy);
        if (this.lDu == null) {
          break label130;
        }
        localObject1 = this.lDu.toString();
        label70:
        paramParcel.writeString((String)localObject1);
        if (this.lDv == null) {
          break label135;
        }
      }
      label130:
      label135:
      for (Object localObject1 = this.lDv.toString();; localObject1 = null)
      {
        paramParcel.writeString((String)localObject1);
        localObject1 = localObject2;
        if (this.lDw != null) {
          localObject1 = this.lDw.toString();
        }
        paramParcel.writeString((String)localObject1);
        AppMethodBeat.o(45877);
        return;
        paramInt = 0;
        break;
        localObject1 = null;
        break label70;
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.jsapi.appdownload.JsApiQueryDownloadTask
 * JD-Core Version:    0.7.0.1
 */