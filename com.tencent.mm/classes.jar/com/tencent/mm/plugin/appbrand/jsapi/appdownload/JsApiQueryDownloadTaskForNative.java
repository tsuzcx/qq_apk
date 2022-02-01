package com.tencent.mm.plugin.appbrand.jsapi.appdownload;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.appbrand.ipc.MainProcessTask;
import com.tencent.mm.plugin.appbrand.jsapi.a;
import com.tencent.mm.plugin.appbrand.jsapi.m;
import com.tencent.mm.plugin.appbrand.q;
import com.tencent.mm.plugin.downloader.model.FileDownloadTaskInfo;
import com.tencent.mm.plugin.downloader.model.f;
import com.tencent.mm.sdk.platformtools.ad;
import com.tencent.mm.sdk.platformtools.bt;
import com.tencent.mm.vfs.i;
import java.util.HashMap;
import java.util.Map;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

public final class JsApiQueryDownloadTaskForNative
  extends a<q>
{
  public static final int CTRL_INDEX = 661;
  public static final String NAME = "queryDownloadTaskForNative";
  
  static class QueryDownloadTask
    extends MainProcessTask
  {
    public static final Parcelable.Creator<QueryDownloadTask> CREATOR;
    private int cgA;
    private q jwH;
    private m ksO;
    private boolean ksW;
    private String ksX;
    private long ksY;
    private JSONArray kvM;
    private JSONArray kvN;
    private JSONArray kvO;
    private String kvP;
    private long kvQ;
    private float kvR;
    private boolean kvS;
    
    static
    {
      AppMethodBeat.i(45890);
      CREATOR = new Parcelable.Creator() {};
      AppMethodBeat.o(45890);
    }
    
    public QueryDownloadTask(Parcel paramParcel)
    {
      AppMethodBeat.i(45882);
      e(paramParcel);
      AppMethodBeat.o(45882);
    }
    
    public QueryDownloadTask(m paramm, q paramq, int paramInt, JSONObject paramJSONObject)
    {
      AppMethodBeat.i(45881);
      bhN();
      this.ksO = paramm;
      this.jwH = paramq;
      this.cgA = paramInt;
      this.ksY = paramJSONObject.optLong("downloadId");
      this.kvM = paramJSONObject.optJSONArray("downloadIdArray");
      this.kvN = paramJSONObject.optJSONArray("appIdArray");
      this.ksW = true;
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
          ad.e("MicroMsg.JsApiQueryDownloadTaskForNative", paramFileDownloadTaskInfo.getMessage());
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
        ad.i("MicroMsg.JsApiQueryDownloadTaskForNative", "doQueryDownloadTask, state = %s", new Object[] { str });
        f = 0.0F;
        if (paramFileDownloadTaskInfo.nsQ != 0L)
        {
          l = paramFileDownloadTaskInfo.pmT * 100L / paramFileDownloadTaskInfo.nsQ;
          f = (float)paramFileDownloadTaskInfo.pmT * 100.0F / (float)paramFileDownloadTaskInfo.nsQ;
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
          if (!paramFileDownloadTaskInfo.pmW) {
            continue;
          }
          i = 1;
          localJSONObject.put("reserve_for_wifi", i);
        }
        catch (JSONException paramFileDownloadTaskInfo)
        {
          int i;
          ad.e("MicroMsg.JsApiQueryDownloadTaskForNative", paramFileDownloadTaskInfo.getMessage());
          continue;
        }
        AppMethodBeat.o(45886);
        return localJSONObject;
        this.ksX = "fail_apilevel_too_low";
        AppMethodBeat.o(45886);
        return localJSONObject;
        str = "downloading";
        break;
        if (i.fv(paramFileDownloadTaskInfo.path))
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
          ad.e("MicroMsg.JsApiQueryDownloadTaskForNative", paramString.getMessage());
        }
      }
    }
    
    public final void aOA()
    {
      AppMethodBeat.i(45883);
      ad.i("MicroMsg.JsApiQueryDownloadTaskForNative", "doQueryDownloadTask, downloadId = %d", new Object[] { Long.valueOf(this.ksY) });
      int i;
      if ((this.kvM != null) && (this.kvM.length() > 0))
      {
        this.kvO = new JSONArray();
        i = 0;
        while (i < this.kvM.length())
        {
          long l = this.kvM.optLong(i);
          localObject = f.ccl().tS(l);
          this.kvO.put(a(l, (FileDownloadTaskInfo)localObject));
          i += 1;
        }
        this.ksW = false;
      }
      for (;;)
      {
        bhX();
        AppMethodBeat.o(45883);
        return;
        if ((this.kvN != null) && (this.kvN.length() > 0))
        {
          this.kvO = new JSONArray();
          i = 0;
          while (i < this.kvN.length())
          {
            localObject = this.kvN.optString(i);
            FileDownloadTaskInfo localFileDownloadTaskInfo = f.ccl().aai((String)localObject);
            this.kvO.put(a((String)localObject, localFileDownloadTaskInfo));
            i += 1;
          }
          this.ksW = false;
        }
        else
        {
          if (this.ksY > 0L) {
            break;
          }
          this.ksX = "downloadId invalid";
        }
      }
      Object localObject = f.ccl().tS(this.ksY);
      switch (((FileDownloadTaskInfo)localObject).status)
      {
      case 0: 
      default: 
        this.kvP = "default";
      }
      for (;;)
      {
        ad.i("MicroMsg.JsApiQueryDownloadTaskForNative", "doQueryDownloadTask, state = %s", new Object[] { this.kvP });
        if (((FileDownloadTaskInfo)localObject).nsQ != 0L)
        {
          this.kvQ = (((float)((FileDownloadTaskInfo)localObject).pmT / (float)((FileDownloadTaskInfo)localObject).nsQ * 100.0F));
          this.kvR = ((float)((FileDownloadTaskInfo)localObject).pmT * 100.0F / (float)((FileDownloadTaskInfo)localObject).nsQ);
        }
        this.kvS = ((FileDownloadTaskInfo)localObject).pmW;
        this.ksW = false;
        break;
        this.ksX = "fail_apilevel_too_low";
        break;
        this.kvP = "downloading";
        continue;
        if (i.fv(((FileDownloadTaskInfo)localObject).path))
        {
          this.kvP = "download_succ";
        }
        else
        {
          this.kvP = "default";
          continue;
          this.kvP = "download_pause";
          continue;
          this.kvP = "download_fail";
        }
      }
    }
    
    public final void aOB()
    {
      AppMethodBeat.i(45887);
      bhO();
      boolean bool;
      if (this.jwH == null)
      {
        bool = true;
        ad.d("MicroMsg.JsApiQueryDownloadTaskForNative", "callback, service is null: %b", new Object[] { Boolean.valueOf(bool) });
        if (!this.ksW) {
          break label110;
        }
        if (!bt.isNullOrNil(this.ksX)) {
          break label89;
        }
      }
      label89:
      for (Object localObject = "fail";; localObject = String.format("fail:%s", new Object[] { this.ksX }))
      {
        this.jwH.h(this.cgA, this.ksO.e((String)localObject, null));
        AppMethodBeat.o(45887);
        return;
        bool = false;
        break;
      }
      label110:
      localObject = new HashMap();
      if (this.kvO != null) {
        ((Map)localObject).put("result", this.kvO);
      }
      for (;;)
      {
        this.jwH.h(this.cgA, this.ksO.m("ok", (Map)localObject));
        AppMethodBeat.o(45887);
        return;
        ((Map)localObject).put("downloadId", Long.valueOf(this.ksY));
        ((Map)localObject).put("state", this.kvP);
        ((Map)localObject).put("progress", Long.valueOf(this.kvQ));
        ((Map)localObject).put("progress_float", Float.valueOf(this.kvR));
        ((Map)localObject).put("reserve_for_wifi", Boolean.valueOf(this.kvS));
      }
    }
    
    public final void e(Parcel paramParcel)
    {
      boolean bool2 = true;
      AppMethodBeat.i(45888);
      this.ksY = paramParcel.readLong();
      if (paramParcel.readInt() == 1) {}
      for (bool1 = true;; bool1 = false)
      {
        this.ksW = bool1;
        this.ksX = paramParcel.readString();
        this.kvP = paramParcel.readString();
        this.kvQ = paramParcel.readLong();
        String str1 = paramParcel.readString();
        String str2 = paramParcel.readString();
        String str3 = paramParcel.readString();
        if (str1 != null) {}
        try
        {
          this.kvM = new JSONArray(str1);
          if (str2 != null) {
            this.kvN = new JSONArray(str2);
          }
          if (str3 != null) {
            this.kvO = new JSONArray(str3);
          }
        }
        catch (JSONException localJSONException)
        {
          for (;;)
          {
            ad.printErrStackTrace("MicroMsg.JsApiQueryDownloadTaskForNative", localJSONException, "", new Object[0]);
            continue;
            bool1 = false;
          }
        }
        if (paramParcel.readInt() != 1) {
          break;
        }
        bool1 = bool2;
        this.kvS = bool1;
        AppMethodBeat.o(45888);
        return;
      }
    }
    
    public void writeToParcel(Parcel paramParcel, int paramInt)
    {
      int i = 1;
      Object localObject2 = null;
      AppMethodBeat.i(45889);
      paramParcel.writeLong(this.ksY);
      Object localObject1;
      if (this.ksW)
      {
        paramInt = 1;
        paramParcel.writeInt(paramInt);
        paramParcel.writeString(this.ksX);
        paramParcel.writeString(this.kvP);
        paramParcel.writeLong(this.kvQ);
        if (this.kvM == null) {
          break label153;
        }
        localObject1 = this.kvM.toString();
        label73:
        paramParcel.writeString((String)localObject1);
        if (this.kvN == null) {
          break label159;
        }
        localObject1 = this.kvN.toString();
        label95:
        paramParcel.writeString((String)localObject1);
        localObject1 = localObject2;
        if (this.kvO != null) {
          localObject1 = this.kvO.toString();
        }
        paramParcel.writeString((String)localObject1);
        if (!this.kvS) {
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