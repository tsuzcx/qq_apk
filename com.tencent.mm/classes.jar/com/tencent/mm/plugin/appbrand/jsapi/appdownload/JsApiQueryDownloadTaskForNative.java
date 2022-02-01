package com.tencent.mm.plugin.appbrand.jsapi.appdownload;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.appbrand.ipc.MainProcessTask;
import com.tencent.mm.plugin.appbrand.jsapi.a;
import com.tencent.mm.plugin.appbrand.jsapi.m;
import com.tencent.mm.plugin.appbrand.r;
import com.tencent.mm.plugin.downloader.model.FileDownloadTaskInfo;
import com.tencent.mm.plugin.downloader.model.f;
import com.tencent.mm.sdk.platformtools.ae;
import com.tencent.mm.sdk.platformtools.bu;
import com.tencent.mm.vfs.o;
import java.util.HashMap;
import java.util.Map;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

public final class JsApiQueryDownloadTaskForNative
  extends a<r>
{
  public static final int CTRL_INDEX = 661;
  public static final String NAME = "queryDownloadTaskForNative";
  
  static class QueryDownloadTask
    extends MainProcessTask
  {
    public static final Parcelable.Creator<QueryDownloadTask> CREATOR;
    private int cgA;
    private r jzD;
    private m kwe;
    private boolean kwm;
    private String kwn;
    private long kwo;
    private JSONArray kzb;
    private JSONArray kzc;
    private JSONArray kzd;
    private String kze;
    private long kzf;
    private float kzg;
    private boolean kzh;
    
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
    
    public QueryDownloadTask(m paramm, r paramr, int paramInt, JSONObject paramJSONObject)
    {
      AppMethodBeat.i(45881);
      biw();
      this.kwe = paramm;
      this.jzD = paramr;
      this.cgA = paramInt;
      this.kwo = paramJSONObject.optLong("downloadId");
      this.kzb = paramJSONObject.optJSONArray("downloadIdArray");
      this.kzc = paramJSONObject.optJSONArray("appIdArray");
      this.kwm = true;
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
          ae.e("MicroMsg.JsApiQueryDownloadTaskForNative", paramFileDownloadTaskInfo.getMessage());
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
        ae.i("MicroMsg.JsApiQueryDownloadTaskForNative", "doQueryDownloadTask, state = %s", new Object[] { str });
        f = 0.0F;
        if (paramFileDownloadTaskInfo.nyl != 0L)
        {
          l = paramFileDownloadTaskInfo.ptA * 100L / paramFileDownloadTaskInfo.nyl;
          f = (float)paramFileDownloadTaskInfo.ptA * 100.0F / (float)paramFileDownloadTaskInfo.nyl;
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
          if (!paramFileDownloadTaskInfo.ptD) {
            continue;
          }
          i = 1;
          localJSONObject.put("reserve_for_wifi", i);
        }
        catch (JSONException paramFileDownloadTaskInfo)
        {
          int i;
          ae.e("MicroMsg.JsApiQueryDownloadTaskForNative", paramFileDownloadTaskInfo.getMessage());
          continue;
        }
        AppMethodBeat.o(45886);
        return localJSONObject;
        this.kwn = "fail_apilevel_too_low";
        AppMethodBeat.o(45886);
        return localJSONObject;
        str = "downloading";
        break;
        if (o.fB(paramFileDownloadTaskInfo.path))
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
          ae.e("MicroMsg.JsApiQueryDownloadTaskForNative", paramString.getMessage());
        }
      }
    }
    
    public final void aOX()
    {
      AppMethodBeat.i(45883);
      ae.i("MicroMsg.JsApiQueryDownloadTaskForNative", "doQueryDownloadTask, downloadId = %d", new Object[] { Long.valueOf(this.kwo) });
      int i;
      if ((this.kzb != null) && (this.kzb.length() > 0))
      {
        this.kzd = new JSONArray();
        i = 0;
        while (i < this.kzb.length())
        {
          long l = this.kzb.optLong(i);
          localObject = f.cdA().uj(l);
          this.kzd.put(a(l, (FileDownloadTaskInfo)localObject));
          i += 1;
        }
        this.kwm = false;
      }
      for (;;)
      {
        biG();
        AppMethodBeat.o(45883);
        return;
        if ((this.kzc != null) && (this.kzc.length() > 0))
        {
          this.kzd = new JSONArray();
          i = 0;
          while (i < this.kzc.length())
          {
            localObject = this.kzc.optString(i);
            FileDownloadTaskInfo localFileDownloadTaskInfo = f.cdA().aaZ((String)localObject);
            this.kzd.put(a((String)localObject, localFileDownloadTaskInfo));
            i += 1;
          }
          this.kwm = false;
        }
        else
        {
          if (this.kwo > 0L) {
            break;
          }
          this.kwn = "downloadId invalid";
        }
      }
      Object localObject = f.cdA().uj(this.kwo);
      switch (((FileDownloadTaskInfo)localObject).status)
      {
      case 0: 
      default: 
        this.kze = "default";
      }
      for (;;)
      {
        ae.i("MicroMsg.JsApiQueryDownloadTaskForNative", "doQueryDownloadTask, state = %s", new Object[] { this.kze });
        if (((FileDownloadTaskInfo)localObject).nyl != 0L)
        {
          this.kzf = (((float)((FileDownloadTaskInfo)localObject).ptA / (float)((FileDownloadTaskInfo)localObject).nyl * 100.0F));
          this.kzg = ((float)((FileDownloadTaskInfo)localObject).ptA * 100.0F / (float)((FileDownloadTaskInfo)localObject).nyl);
        }
        this.kzh = ((FileDownloadTaskInfo)localObject).ptD;
        this.kwm = false;
        break;
        this.kwn = "fail_apilevel_too_low";
        break;
        this.kze = "downloading";
        continue;
        if (o.fB(((FileDownloadTaskInfo)localObject).path))
        {
          this.kze = "download_succ";
        }
        else
        {
          this.kze = "default";
          continue;
          this.kze = "download_pause";
          continue;
          this.kze = "download_fail";
        }
      }
    }
    
    public final void aOY()
    {
      AppMethodBeat.i(45887);
      bix();
      boolean bool;
      if (this.jzD == null)
      {
        bool = true;
        ae.d("MicroMsg.JsApiQueryDownloadTaskForNative", "callback, service is null: %b", new Object[] { Boolean.valueOf(bool) });
        if (!this.kwm) {
          break label110;
        }
        if (!bu.isNullOrNil(this.kwn)) {
          break label89;
        }
      }
      label89:
      for (Object localObject = "fail";; localObject = String.format("fail:%s", new Object[] { this.kwn }))
      {
        this.jzD.h(this.cgA, this.kwe.e((String)localObject, null));
        AppMethodBeat.o(45887);
        return;
        bool = false;
        break;
      }
      label110:
      localObject = new HashMap();
      if (this.kzd != null) {
        ((Map)localObject).put("result", this.kzd);
      }
      for (;;)
      {
        this.jzD.h(this.cgA, this.kwe.n("ok", (Map)localObject));
        AppMethodBeat.o(45887);
        return;
        ((Map)localObject).put("downloadId", Long.valueOf(this.kwo));
        ((Map)localObject).put("state", this.kze);
        ((Map)localObject).put("progress", Long.valueOf(this.kzf));
        ((Map)localObject).put("progress_float", Float.valueOf(this.kzg));
        ((Map)localObject).put("reserve_for_wifi", Boolean.valueOf(this.kzh));
      }
    }
    
    public final void e(Parcel paramParcel)
    {
      boolean bool2 = true;
      AppMethodBeat.i(45888);
      this.kwo = paramParcel.readLong();
      if (paramParcel.readInt() == 1) {}
      for (bool1 = true;; bool1 = false)
      {
        this.kwm = bool1;
        this.kwn = paramParcel.readString();
        this.kze = paramParcel.readString();
        this.kzf = paramParcel.readLong();
        String str1 = paramParcel.readString();
        String str2 = paramParcel.readString();
        String str3 = paramParcel.readString();
        if (str1 != null) {}
        try
        {
          this.kzb = new JSONArray(str1);
          if (str2 != null) {
            this.kzc = new JSONArray(str2);
          }
          if (str3 != null) {
            this.kzd = new JSONArray(str3);
          }
        }
        catch (JSONException localJSONException)
        {
          for (;;)
          {
            ae.printErrStackTrace("MicroMsg.JsApiQueryDownloadTaskForNative", localJSONException, "", new Object[0]);
            continue;
            bool1 = false;
          }
        }
        if (paramParcel.readInt() != 1) {
          break;
        }
        bool1 = bool2;
        this.kzh = bool1;
        AppMethodBeat.o(45888);
        return;
      }
    }
    
    public void writeToParcel(Parcel paramParcel, int paramInt)
    {
      int i = 1;
      Object localObject2 = null;
      AppMethodBeat.i(45889);
      paramParcel.writeLong(this.kwo);
      Object localObject1;
      if (this.kwm)
      {
        paramInt = 1;
        paramParcel.writeInt(paramInt);
        paramParcel.writeString(this.kwn);
        paramParcel.writeString(this.kze);
        paramParcel.writeLong(this.kzf);
        if (this.kzb == null) {
          break label153;
        }
        localObject1 = this.kzb.toString();
        label73:
        paramParcel.writeString((String)localObject1);
        if (this.kzc == null) {
          break label159;
        }
        localObject1 = this.kzc.toString();
        label95:
        paramParcel.writeString((String)localObject1);
        localObject1 = localObject2;
        if (this.kzd != null) {
          localObject1 = this.kzd.toString();
        }
        paramParcel.writeString((String)localObject1);
        if (!this.kzh) {
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