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
import com.tencent.mm.sdk.platformtools.Util;
import java.util.HashMap;
import java.util.Map;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

public final class JsApiQueryDownloadTaskForNative
  extends c<com.tencent.mm.plugin.appbrand.y>
{
  public static final int CTRL_INDEX = 661;
  public static final String NAME = "queryDownloadTaskForNative";
  
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
    private float rCT;
    private boolean rCU;
    private p ryT;
    private boolean rzb;
    private String rzc;
    private long rzd;
    
    static
    {
      AppMethodBeat.i(45890);
      CREATOR = new Parcelable.Creator() {};
      AppMethodBeat.o(45890);
    }
    
    public QueryDownloadTask(Parcel paramParcel)
    {
      AppMethodBeat.i(45882);
      h(paramParcel);
      AppMethodBeat.o(45882);
    }
    
    public QueryDownloadTask(p paramp, com.tencent.mm.plugin.appbrand.y paramy, int paramInt, JSONObject paramJSONObject)
    {
      AppMethodBeat.i(45881);
      this.ryT = paramp;
      this.qsi = paramy;
      this.eit = paramInt;
      this.rzd = paramJSONObject.optLong("downloadId");
      this.rCO = paramJSONObject.optJSONArray("downloadIdArray");
      this.rCP = paramJSONObject.optJSONArray("appIdArray");
      this.rzb = true;
      AppMethodBeat.o(45881);
    }
    
    private JSONObject a(long paramLong, FileDownloadTaskInfo paramFileDownloadTaskInfo)
    {
      AppMethodBeat.i(45884);
      JSONObject localJSONObject = a(paramFileDownloadTaskInfo);
      if (paramFileDownloadTaskInfo != null) {}
      try
      {
        localJSONObject.put("downloadId", paramLong);
        AppMethodBeat.o(45884);
        return localJSONObject;
      }
      catch (JSONException paramFileDownloadTaskInfo)
      {
        for (;;)
        {
          Log.e("MicroMsg.JsApiQueryDownloadTaskForNative", paramFileDownloadTaskInfo.getMessage());
        }
      }
    }
    
    private JSONObject a(FileDownloadTaskInfo paramFileDownloadTaskInfo)
    {
      long l = 0L;
      AppMethodBeat.i(45886);
      JSONObject localJSONObject = new JSONObject();
      String str;
      float f;
      switch (paramFileDownloadTaskInfo.status)
      {
      case 0: 
      default: 
        str = "default";
        Log.i("MicroMsg.JsApiQueryDownloadTaskForNative", "doQueryDownloadTask, state = %s", new Object[] { str });
        f = 0.0F;
        if (paramFileDownloadTaskInfo.uWn != 0L)
        {
          l = paramFileDownloadTaskInfo.xom * 100L / paramFileDownloadTaskInfo.uWn;
          f = (float)paramFileDownloadTaskInfo.xom * 100.0F / (float)paramFileDownloadTaskInfo.uWn;
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
          if (!paramFileDownloadTaskInfo.xop) {
            continue;
          }
          i = 1;
          localJSONObject.put("reserve_for_wifi", i);
        }
        catch (JSONException paramFileDownloadTaskInfo)
        {
          int i;
          Log.e("MicroMsg.JsApiQueryDownloadTaskForNative", paramFileDownloadTaskInfo.getMessage());
          continue;
        }
        AppMethodBeat.o(45886);
        return localJSONObject;
        this.rzc = "fail_apilevel_too_low";
        AppMethodBeat.o(45886);
        return localJSONObject;
        str = "downloading";
        break;
        if (com.tencent.mm.vfs.y.ZC(paramFileDownloadTaskInfo.path))
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
      AppMethodBeat.i(45885);
      paramFileDownloadTaskInfo = a(paramFileDownloadTaskInfo);
      if (paramFileDownloadTaskInfo != null) {}
      try
      {
        paramFileDownloadTaskInfo.put("appId", paramString);
        AppMethodBeat.o(45885);
        return paramFileDownloadTaskInfo;
      }
      catch (JSONException paramString)
      {
        for (;;)
        {
          Log.e("MicroMsg.JsApiQueryDownloadTaskForNative", paramString.getMessage());
        }
      }
    }
    
    public final void asn()
    {
      AppMethodBeat.i(45883);
      Log.i("MicroMsg.JsApiQueryDownloadTaskForNative", "doQueryDownloadTask, downloadId = %d", new Object[] { Long.valueOf(this.rzd) });
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
        AppMethodBeat.o(45883);
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
      switch (((FileDownloadTaskInfo)localObject).status)
      {
      case 0: 
      default: 
        this.rCR = "default";
      }
      for (;;)
      {
        Log.i("MicroMsg.JsApiQueryDownloadTaskForNative", "doQueryDownloadTask, state = %s", new Object[] { this.rCR });
        if (((FileDownloadTaskInfo)localObject).uWn != 0L)
        {
          this.rCS = (((float)((FileDownloadTaskInfo)localObject).xom / (float)((FileDownloadTaskInfo)localObject).uWn * 100.0F));
          this.rCT = ((float)((FileDownloadTaskInfo)localObject).xom * 100.0F / (float)((FileDownloadTaskInfo)localObject).uWn);
        }
        this.rCU = ((FileDownloadTaskInfo)localObject).xop;
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
      AppMethodBeat.i(45887);
      cpx();
      boolean bool;
      if (this.qsi == null)
      {
        bool = true;
        Log.d("MicroMsg.JsApiQueryDownloadTaskForNative", "callback, service is null: %b", new Object[] { Boolean.valueOf(bool) });
        if (!this.rzb) {
          break label109;
        }
        if (!Util.isNullOrNil(this.rzc)) {
          break label88;
        }
      }
      label88:
      for (Object localObject = "fail";; localObject = String.format("fail:%s", new Object[] { this.rzc }))
      {
        this.qsi.callback(this.eit, this.ryT.ZP((String)localObject));
        AppMethodBeat.o(45887);
        return;
        bool = false;
        break;
      }
      label109:
      localObject = new HashMap();
      if (this.rCQ != null) {
        ((Map)localObject).put("result", this.rCQ);
      }
      for (;;)
      {
        this.qsi.callback(this.eit, this.ryT.m("ok", (Map)localObject));
        AppMethodBeat.o(45887);
        return;
        ((Map)localObject).put("downloadId", Long.valueOf(this.rzd));
        ((Map)localObject).put("state", this.rCR);
        ((Map)localObject).put("progress", Long.valueOf(this.rCS));
        ((Map)localObject).put("progress_float", Float.valueOf(this.rCT));
        ((Map)localObject).put("reserve_for_wifi", Boolean.valueOf(this.rCU));
      }
    }
    
    public final void h(Parcel paramParcel)
    {
      boolean bool2 = true;
      AppMethodBeat.i(45888);
      this.rzd = paramParcel.readLong();
      if (paramParcel.readInt() == 1) {}
      for (bool1 = true;; bool1 = false)
      {
        this.rzb = bool1;
        this.rzc = paramParcel.readString();
        this.rCR = paramParcel.readString();
        this.rCS = paramParcel.readLong();
        String str1 = paramParcel.readString();
        String str2 = paramParcel.readString();
        String str3 = paramParcel.readString();
        if (str1 != null) {}
        try
        {
          this.rCO = new JSONArray(str1);
          if (str2 != null) {
            this.rCP = new JSONArray(str2);
          }
          if (str3 != null) {
            this.rCQ = new JSONArray(str3);
          }
        }
        catch (JSONException localJSONException)
        {
          for (;;)
          {
            Log.printErrStackTrace("MicroMsg.JsApiQueryDownloadTaskForNative", localJSONException, "", new Object[0]);
            continue;
            bool1 = false;
          }
        }
        if (paramParcel.readInt() != 1) {
          break;
        }
        bool1 = bool2;
        this.rCU = bool1;
        AppMethodBeat.o(45888);
        return;
      }
    }
    
    public void writeToParcel(Parcel paramParcel, int paramInt)
    {
      int i = 1;
      Object localObject2 = null;
      AppMethodBeat.i(45889);
      paramParcel.writeLong(this.rzd);
      Object localObject1;
      if (this.rzb)
      {
        paramInt = 1;
        paramParcel.writeInt(paramInt);
        paramParcel.writeString(this.rzc);
        paramParcel.writeString(this.rCR);
        paramParcel.writeLong(this.rCS);
        if (this.rCO == null) {
          break label153;
        }
        localObject1 = this.rCO.toString();
        label73:
        paramParcel.writeString((String)localObject1);
        if (this.rCP == null) {
          break label159;
        }
        localObject1 = this.rCP.toString();
        label95:
        paramParcel.writeString((String)localObject1);
        localObject1 = localObject2;
        if (this.rCQ != null) {
          localObject1 = this.rCQ.toString();
        }
        paramParcel.writeString((String)localObject1);
        if (!this.rCU) {
          break label165;
        }
      }
      label153:
      label159:
      label165:
      for (paramInt = i;; paramInt = 0)
      {
        paramParcel.writeInt(paramInt);
        AppMethodBeat.o(45889);
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
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.jsapi.appdownload.JsApiQueryDownloadTaskForNative
 * JD-Core Version:    0.7.0.1
 */