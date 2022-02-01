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
import com.tencent.mm.sdk.platformtools.aj;
import com.tencent.mm.sdk.platformtools.ay;
import com.tencent.mm.sdk.platformtools.bt;
import com.tencent.mm.vfs.i;
import java.util.HashMap;
import java.util.Map;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

public final class JsApiQueryDownloadTask
  extends a<q>
{
  public static final int CTRL_INDEX = 441;
  public static final String NAME = "queryDownloadTask";
  
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
    
    static
    {
      AppMethodBeat.i(45878);
      CREATOR = new Parcelable.Creator() {};
      AppMethodBeat.o(45878);
    }
    
    public QueryDownloadTask(Parcel paramParcel)
    {
      AppMethodBeat.i(45870);
      e(paramParcel);
      AppMethodBeat.o(45870);
    }
    
    public QueryDownloadTask(m paramm, q paramq, int paramInt, JSONObject paramJSONObject)
    {
      AppMethodBeat.i(45869);
      bhN();
      this.ksO = paramm;
      this.jwH = paramq;
      this.cgA = paramInt;
      this.ksY = paramJSONObject.optLong("downloadId");
      this.kvM = paramJSONObject.optJSONArray("downloadIdArray");
      this.kvN = paramJSONObject.optJSONArray("appIdArray");
      this.ksW = true;
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
          ad.e("MicroMsg.JsApiQueryDownloadTask", paramFileDownloadTaskInfo.getMessage());
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
        ad.i("MicroMsg.JsApiQueryDownloadTask", "doQueryDownloadTask, state = %s", new Object[] { str1 });
        String str2 = str1;
        if (paramFileDownloadTaskInfo.pmV)
        {
          str2 = str1;
          if (!ay.isWifi(aj.getContext()))
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
          if (paramFileDownloadTaskInfo.nsQ != 0L) {
            l1 = ((float)paramFileDownloadTaskInfo.pmT / (float)paramFileDownloadTaskInfo.nsQ * 100.0F);
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
          this.ksX = "fail_apilevel_too_low";
          AppMethodBeat.o(45874);
          return localJSONObject;
          str1 = "downloading";
          continue;
          if (i.fv(paramFileDownloadTaskInfo.path))
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
            ad.e("MicroMsg.JsApiQueryDownloadTask", paramFileDownloadTaskInfo.getMessage());
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
          ad.e("MicroMsg.JsApiQueryDownloadTask", paramString.getMessage());
        }
      }
    }
    
    public final void aOA()
    {
      AppMethodBeat.i(45871);
      ad.i("MicroMsg.JsApiQueryDownloadTask", "doQueryDownloadTask, downloadId = %d", new Object[] { Long.valueOf(this.ksY) });
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
        AppMethodBeat.o(45871);
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
      if ((((FileDownloadTaskInfo)localObject).pmV) && (((FileDownloadTaskInfo)localObject).status != 1) && (((FileDownloadTaskInfo)localObject).status != 3)) {
        this.kvP = "download_wait_wifi";
      }
      switch (((FileDownloadTaskInfo)localObject).status)
      {
      case 0: 
      default: 
        this.kvP = "default";
      }
      for (;;)
      {
        ad.i("MicroMsg.JsApiQueryDownloadTask", "doQueryDownloadTask, state = %s", new Object[] { this.kvP });
        if (((this.kvP == "downloading") || (this.kvP == "download_pause")) && (((FileDownloadTaskInfo)localObject).nsQ != 0L)) {
          this.kvQ = (((float)((FileDownloadTaskInfo)localObject).pmT / (float)((FileDownloadTaskInfo)localObject).nsQ * 100.0F));
        }
        if ((((FileDownloadTaskInfo)localObject).pmV) && (!ay.isWifi(aj.getContext())) && (((FileDownloadTaskInfo)localObject).status != 3) && (((FileDownloadTaskInfo)localObject).status != 1)) {
          this.kvP = "download_wait_wifi";
        }
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
      AppMethodBeat.i(45875);
      bhO();
      boolean bool;
      if (this.jwH == null)
      {
        bool = true;
        ad.d("MicroMsg.JsApiQueryDownloadTask", "callback, service is null: %b", new Object[] { Boolean.valueOf(bool) });
        if (!this.ksW) {
          break label109;
        }
        if (!bt.isNullOrNil(this.ksX)) {
          break label88;
        }
      }
      label88:
      for (Object localObject = "fail";; localObject = String.format("fail:%s", new Object[] { this.ksX }))
      {
        this.jwH.h(this.cgA, this.ksO.e((String)localObject, null));
        AppMethodBeat.o(45875);
        return;
        bool = false;
        break;
      }
      label109:
      localObject = new HashMap();
      if (this.kvO != null) {
        ((Map)localObject).put("result", this.kvO);
      }
      for (;;)
      {
        this.jwH.h(this.cgA, this.ksO.m("ok", (Map)localObject));
        AppMethodBeat.o(45875);
        return;
        ((Map)localObject).put("downloadId", Long.valueOf(this.ksY));
        ((Map)localObject).put("state", this.kvP);
        ((Map)localObject).put("progress", Long.valueOf(this.kvQ));
      }
    }
    
    public final void e(Parcel paramParcel)
    {
      boolean bool = true;
      AppMethodBeat.i(45876);
      this.ksY = paramParcel.readLong();
      if (paramParcel.readInt() == 1) {}
      for (;;)
      {
        this.ksW = bool;
        this.ksX = paramParcel.readString();
        this.kvP = paramParcel.readString();
        this.kvQ = paramParcel.readLong();
        String str1 = paramParcel.readString();
        String str2 = paramParcel.readString();
        paramParcel = paramParcel.readString();
        if (str1 != null) {}
        try
        {
          this.kvM = new JSONArray(str1);
          if (str2 != null) {
            this.kvN = new JSONArray(str2);
          }
          if (paramParcel != null) {
            this.kvO = new JSONArray(paramParcel);
          }
          AppMethodBeat.o(45876);
          return;
        }
        catch (JSONException paramParcel)
        {
          ad.printErrStackTrace("MicroMsg.JsApiQueryDownloadTask", paramParcel, "", new Object[0]);
          AppMethodBeat.o(45876);
        }
        bool = false;
      }
    }
    
    public void writeToParcel(Parcel paramParcel, int paramInt)
    {
      Object localObject2 = null;
      AppMethodBeat.i(45877);
      paramParcel.writeLong(this.ksY);
      if (this.ksW)
      {
        paramInt = 1;
        paramParcel.writeInt(paramInt);
        paramParcel.writeString(this.ksX);
        paramParcel.writeString(this.kvP);
        paramParcel.writeLong(this.kvQ);
        if (this.kvM == null) {
          break label130;
        }
        localObject1 = this.kvM.toString();
        label70:
        paramParcel.writeString((String)localObject1);
        if (this.kvN == null) {
          break label135;
        }
      }
      label130:
      label135:
      for (Object localObject1 = this.kvN.toString();; localObject1 = null)
      {
        paramParcel.writeString((String)localObject1);
        localObject1 = localObject2;
        if (this.kvO != null) {
          localObject1 = this.kvO.toString();
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