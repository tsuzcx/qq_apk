package com.tencent.mm.plugin.appbrand.jsapi.appdownload;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.appbrand.ipc.MainProcessTask;
import com.tencent.mm.plugin.appbrand.jsapi.c;
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
  extends c<com.tencent.mm.plugin.appbrand.y>
{
  public static final int CTRL_INDEX = 441;
  public static final String NAME = "queryDownloadTask";
  
  static class QueryDownloadTask
    extends MainProcessTask
  {
    public static final Parcelable.Creator<QueryDownloadTask> CREATOR;
    private int eit;
    private com.tencent.mm.plugin.appbrand.y qsi;
    private JSONArray rCO;
    private JSONArray rCP;
    private JSONArray rCQ;
    private String rCR;
    private long rCS;
    private p ryT;
    private boolean rzb;
    private String rzc;
    private long rzd;
    
    static
    {
      AppMethodBeat.i(45878);
      CREATOR = new Parcelable.Creator() {};
      AppMethodBeat.o(45878);
    }
    
    public QueryDownloadTask(Parcel paramParcel)
    {
      AppMethodBeat.i(45870);
      h(paramParcel);
      AppMethodBeat.o(45870);
    }
    
    public QueryDownloadTask(p paramp, com.tencent.mm.plugin.appbrand.y paramy, int paramInt, JSONObject paramJSONObject)
    {
      AppMethodBeat.i(45869);
      this.ryT = paramp;
      this.qsi = paramy;
      this.eit = paramInt;
      this.rzd = paramJSONObject.optLong("downloadId");
      this.rCO = paramJSONObject.optJSONArray("downloadIdArray");
      this.rCP = paramJSONObject.optJSONArray("appIdArray");
      this.rzb = true;
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
        if (paramFileDownloadTaskInfo.xoo)
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
          if (paramFileDownloadTaskInfo.uWn != 0L) {
            l1 = ((float)paramFileDownloadTaskInfo.xom / (float)paramFileDownloadTaskInfo.uWn * 100.0F);
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
          this.rzc = "fail_apilevel_too_low";
          AppMethodBeat.o(45874);
          return localJSONObject;
          str1 = "downloading";
          continue;
          if (com.tencent.mm.vfs.y.ZC(paramFileDownloadTaskInfo.path))
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
      if (paramFileDownloadTaskInfo != null) {}
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
    
    public final void asn()
    {
      AppMethodBeat.i(45871);
      Log.i("MicroMsg.JsApiQueryDownloadTask", "doQueryDownloadTask, downloadId = %d", new Object[] { Long.valueOf(this.rzd) });
      int i;
      if ((this.rCO != null) && (this.rCO.length() > 0))
      {
        this.rCQ = new JSONArray();
        i = 0;
        while (i < this.rCO.length())
        {
          long l = this.rCO.optLong(i);
          localObject = f.duv().kS(l);
          this.rCQ.put(a(l, (FileDownloadTaskInfo)localObject));
          i += 1;
        }
        this.rzb = false;
      }
      for (;;)
      {
        cpA();
        AppMethodBeat.o(45871);
        return;
        if ((this.rCP != null) && (this.rCP.length() > 0))
        {
          this.rCQ = new JSONArray();
          i = 0;
          while (i < this.rCP.length())
          {
            localObject = this.rCP.optString(i);
            FileDownloadTaskInfo localFileDownloadTaskInfo = f.duv().amO((String)localObject);
            this.rCQ.put(a((String)localObject, localFileDownloadTaskInfo));
            i += 1;
          }
          this.rzb = false;
        }
        else
        {
          if (this.rzd > 0L) {
            break;
          }
          this.rzc = "downloadId invalid";
        }
      }
      Object localObject = f.duv().kS(this.rzd);
      if ((((FileDownloadTaskInfo)localObject).xoo) && (((FileDownloadTaskInfo)localObject).status != 1) && (((FileDownloadTaskInfo)localObject).status != 3)) {
        this.rCR = "download_wait_wifi";
      }
      switch (((FileDownloadTaskInfo)localObject).status)
      {
      case 0: 
      default: 
        this.rCR = "default";
      }
      for (;;)
      {
        Log.i("MicroMsg.JsApiQueryDownloadTask", "doQueryDownloadTask, state = %s", new Object[] { this.rCR });
        if (((this.rCR == "downloading") || (this.rCR == "download_pause")) && (((FileDownloadTaskInfo)localObject).uWn != 0L)) {
          this.rCS = (((float)((FileDownloadTaskInfo)localObject).xom / (float)((FileDownloadTaskInfo)localObject).uWn * 100.0F));
        }
        if ((((FileDownloadTaskInfo)localObject).xoo) && (!NetStatusUtil.isWifi(MMApplicationContext.getContext())) && (((FileDownloadTaskInfo)localObject).status != 3) && (((FileDownloadTaskInfo)localObject).status != 1)) {
          this.rCR = "download_wait_wifi";
        }
        this.rzb = false;
        break;
        this.rzc = "fail_apilevel_too_low";
        break;
        this.rCR = "downloading";
        continue;
        if (com.tencent.mm.vfs.y.ZC(((FileDownloadTaskInfo)localObject).path))
        {
          this.rCR = "download_succ";
        }
        else
        {
          this.rCR = "default";
          continue;
          this.rCR = "download_pause";
          continue;
          this.rCR = "download_fail";
        }
      }
    }
    
    public final void bQr()
    {
      AppMethodBeat.i(45875);
      cpx();
      boolean bool;
      if (this.qsi == null)
      {
        bool = true;
        Log.d("MicroMsg.JsApiQueryDownloadTask", "callback, service is null: %b", new Object[] { Boolean.valueOf(bool) });
        if (!this.rzb) {
          break label108;
        }
        if (!Util.isNullOrNil(this.rzc)) {
          break label87;
        }
      }
      label87:
      for (Object localObject = "fail";; localObject = String.format("fail:%s", new Object[] { this.rzc }))
      {
        this.qsi.callback(this.eit, this.ryT.ZP((String)localObject));
        AppMethodBeat.o(45875);
        return;
        bool = false;
        break;
      }
      label108:
      localObject = new HashMap();
      if (this.rCQ != null) {
        ((Map)localObject).put("result", this.rCQ);
      }
      for (;;)
      {
        this.qsi.callback(this.eit, this.ryT.m("ok", (Map)localObject));
        AppMethodBeat.o(45875);
        return;
        ((Map)localObject).put("downloadId", Long.valueOf(this.rzd));
        ((Map)localObject).put("state", this.rCR);
        ((Map)localObject).put("progress", Long.valueOf(this.rCS));
      }
    }
    
    public final void h(Parcel paramParcel)
    {
      boolean bool = true;
      AppMethodBeat.i(45876);
      this.rzd = paramParcel.readLong();
      if (paramParcel.readInt() == 1) {}
      for (;;)
      {
        this.rzb = bool;
        this.rzc = paramParcel.readString();
        this.rCR = paramParcel.readString();
        this.rCS = paramParcel.readLong();
        String str1 = paramParcel.readString();
        String str2 = paramParcel.readString();
        paramParcel = paramParcel.readString();
        if (str1 != null) {}
        try
        {
          this.rCO = new JSONArray(str1);
          if (str2 != null) {
            this.rCP = new JSONArray(str2);
          }
          if (paramParcel != null) {
            this.rCQ = new JSONArray(paramParcel);
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
      paramParcel.writeLong(this.rzd);
      if (this.rzb)
      {
        paramInt = 1;
        paramParcel.writeInt(paramInt);
        paramParcel.writeString(this.rzc);
        paramParcel.writeString(this.rCR);
        paramParcel.writeLong(this.rCS);
        if (this.rCO == null) {
          break label130;
        }
        localObject1 = this.rCO.toString();
        label70:
        paramParcel.writeString((String)localObject1);
        if (this.rCP == null) {
          break label135;
        }
      }
      label130:
      label135:
      for (Object localObject1 = this.rCP.toString();; localObject1 = null)
      {
        paramParcel.writeString((String)localObject1);
        localObject1 = localObject2;
        if (this.rCQ != null) {
          localObject1 = this.rCQ.toString();
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