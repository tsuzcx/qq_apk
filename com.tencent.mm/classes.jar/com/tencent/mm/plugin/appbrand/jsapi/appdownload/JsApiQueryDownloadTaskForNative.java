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
import com.tencent.mm.sdk.platformtools.Util;
import java.util.HashMap;
import java.util.Map;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

public final class JsApiQueryDownloadTaskForNative
  extends d<com.tencent.mm.plugin.appbrand.s>
{
  public static final int CTRL_INDEX = 661;
  public static final String NAME = "queryDownloadTaskForNative";
  
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
    private boolean lDA;
    private JSONArray lDu;
    private JSONArray lDv;
    private JSONArray lDw;
    private String lDx;
    private long lDy;
    private float lDz;
    
    static
    {
      AppMethodBeat.i(45890);
      CREATOR = new Parcelable.Creator() {};
      AppMethodBeat.o(45890);
    }
    
    public QueryDownloadTask(Parcel paramParcel)
    {
      AppMethodBeat.i(45882);
      f(paramParcel);
      AppMethodBeat.o(45882);
    }
    
    public QueryDownloadTask(p paramp, com.tencent.mm.plugin.appbrand.s params, int paramInt, JSONObject paramJSONObject)
    {
      AppMethodBeat.i(45881);
      bDJ();
      this.lAi = paramp;
      this.kAr = params;
      this.csv = paramInt;
      this.lAs = paramJSONObject.optLong("downloadId");
      this.lDu = paramJSONObject.optJSONArray("downloadIdArray");
      this.lDv = paramJSONObject.optJSONArray("appIdArray");
      this.lAq = true;
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
        if (paramFileDownloadTaskInfo.oJj != 0L)
        {
          l = paramFileDownloadTaskInfo.qJe * 100L / paramFileDownloadTaskInfo.oJj;
          f = (float)paramFileDownloadTaskInfo.qJe * 100.0F / (float)paramFileDownloadTaskInfo.oJj;
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
          if (!paramFileDownloadTaskInfo.qJh) {
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
        this.lAr = "fail_apilevel_too_low";
        AppMethodBeat.o(45886);
        return localJSONObject;
        str = "downloading";
        break;
        if (com.tencent.mm.vfs.s.YS(paramFileDownloadTaskInfo.path))
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
    
    public final void bjj()
    {
      AppMethodBeat.i(45883);
      Log.i("MicroMsg.JsApiQueryDownloadTaskForNative", "doQueryDownloadTask, downloadId = %d", new Object[] { Long.valueOf(this.lAs) });
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
        AppMethodBeat.o(45883);
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
      switch (((FileDownloadTaskInfo)localObject).status)
      {
      case 0: 
      default: 
        this.lDx = "default";
      }
      for (;;)
      {
        Log.i("MicroMsg.JsApiQueryDownloadTaskForNative", "doQueryDownloadTask, state = %s", new Object[] { this.lDx });
        if (((FileDownloadTaskInfo)localObject).oJj != 0L)
        {
          this.lDy = (((float)((FileDownloadTaskInfo)localObject).qJe / (float)((FileDownloadTaskInfo)localObject).oJj * 100.0F));
          this.lDz = ((float)((FileDownloadTaskInfo)localObject).qJe * 100.0F / (float)((FileDownloadTaskInfo)localObject).oJj);
        }
        this.lDA = ((FileDownloadTaskInfo)localObject).qJh;
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
      AppMethodBeat.i(45887);
      bDK();
      boolean bool;
      if (this.kAr == null)
      {
        bool = true;
        Log.d("MicroMsg.JsApiQueryDownloadTaskForNative", "callback, service is null: %b", new Object[] { Boolean.valueOf(bool) });
        if (!this.lAq) {
          break label110;
        }
        if (!Util.isNullOrNil(this.lAr)) {
          break label89;
        }
      }
      label89:
      for (Object localObject = "fail";; localObject = String.format("fail:%s", new Object[] { this.lAr }))
      {
        this.kAr.i(this.csv, this.lAi.h((String)localObject, null));
        AppMethodBeat.o(45887);
        return;
        bool = false;
        break;
      }
      label110:
      localObject = new HashMap();
      if (this.lDw != null) {
        ((Map)localObject).put("result", this.lDw);
      }
      for (;;)
      {
        this.kAr.i(this.csv, this.lAi.n("ok", (Map)localObject));
        AppMethodBeat.o(45887);
        return;
        ((Map)localObject).put("downloadId", Long.valueOf(this.lAs));
        ((Map)localObject).put("state", this.lDx);
        ((Map)localObject).put("progress", Long.valueOf(this.lDy));
        ((Map)localObject).put("progress_float", Float.valueOf(this.lDz));
        ((Map)localObject).put("reserve_for_wifi", Boolean.valueOf(this.lDA));
      }
    }
    
    public final void f(Parcel paramParcel)
    {
      boolean bool2 = true;
      AppMethodBeat.i(45888);
      this.lAs = paramParcel.readLong();
      if (paramParcel.readInt() == 1) {}
      for (bool1 = true;; bool1 = false)
      {
        this.lAq = bool1;
        this.lAr = paramParcel.readString();
        this.lDx = paramParcel.readString();
        this.lDy = paramParcel.readLong();
        String str1 = paramParcel.readString();
        String str2 = paramParcel.readString();
        String str3 = paramParcel.readString();
        if (str1 != null) {}
        try
        {
          this.lDu = new JSONArray(str1);
          if (str2 != null) {
            this.lDv = new JSONArray(str2);
          }
          if (str3 != null) {
            this.lDw = new JSONArray(str3);
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
        this.lDA = bool1;
        AppMethodBeat.o(45888);
        return;
      }
    }
    
    public void writeToParcel(Parcel paramParcel, int paramInt)
    {
      int i = 1;
      Object localObject2 = null;
      AppMethodBeat.i(45889);
      paramParcel.writeLong(this.lAs);
      Object localObject1;
      if (this.lAq)
      {
        paramInt = 1;
        paramParcel.writeInt(paramInt);
        paramParcel.writeString(this.lAr);
        paramParcel.writeString(this.lDx);
        paramParcel.writeLong(this.lDy);
        if (this.lDu == null) {
          break label153;
        }
        localObject1 = this.lDu.toString();
        label73:
        paramParcel.writeString((String)localObject1);
        if (this.lDv == null) {
          break label159;
        }
        localObject1 = this.lDv.toString();
        label95:
        paramParcel.writeString((String)localObject1);
        localObject1 = localObject2;
        if (this.lDw != null) {
          localObject1 = this.lDw.toString();
        }
        paramParcel.writeString((String)localObject1);
        if (!this.lDA) {
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