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
    private int bZo;
    private q iDy;
    private JSONArray jAU;
    private JSONArray jAV;
    private JSONArray jAW;
    private String jAX;
    private long jAY;
    private float jAZ;
    private boolean jBa;
    private m jxX;
    private boolean jyf;
    private String jyg;
    private long jyh;
    
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
      aXm();
      this.jxX = paramm;
      this.iDy = paramq;
      this.bZo = paramInt;
      this.jyh = paramJSONObject.optLong("downloadId");
      this.jAU = paramJSONObject.optJSONArray("downloadIdArray");
      this.jAV = paramJSONObject.optJSONArray("appIdArray");
      this.jyf = true;
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
        if (paramFileDownloadTaskInfo.mqq != 0L)
        {
          l = paramFileDownloadTaskInfo.ofL * 100L / paramFileDownloadTaskInfo.mqq;
          f = (float)paramFileDownloadTaskInfo.ofL * 100.0F / (float)paramFileDownloadTaskInfo.mqq;
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
          if (!paramFileDownloadTaskInfo.ofO) {
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
        this.jyg = "fail_apilevel_too_low";
        AppMethodBeat.o(45886);
        return localJSONObject;
        str = "downloading";
        break;
        if (i.eK(paramFileDownloadTaskInfo.path))
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
    
    public final void aEA()
    {
      AppMethodBeat.i(45887);
      aXn();
      boolean bool;
      if (this.iDy == null)
      {
        bool = true;
        ad.d("MicroMsg.JsApiQueryDownloadTaskForNative", "callback, service is null: %b", new Object[] { Boolean.valueOf(bool) });
        if (!this.jyf) {
          break label107;
        }
        if (!bt.isNullOrNil(this.jyg)) {
          break label87;
        }
      }
      label87:
      for (Object localObject = "fail";; localObject = String.format("fail:%s", new Object[] { this.jyg }))
      {
        this.iDy.h(this.bZo, this.jxX.e((String)localObject, null));
        AppMethodBeat.o(45887);
        return;
        bool = false;
        break;
      }
      label107:
      localObject = new HashMap();
      if (this.jAW != null) {
        ((Map)localObject).put("result", this.jAW);
      }
      for (;;)
      {
        this.iDy.h(this.bZo, this.jxX.k("ok", (Map)localObject));
        AppMethodBeat.o(45887);
        return;
        ((Map)localObject).put("downloadId", Long.valueOf(this.jyh));
        ((Map)localObject).put("state", this.jAX);
        ((Map)localObject).put("progress", Long.valueOf(this.jAY));
        ((Map)localObject).put("progress_float", Float.valueOf(this.jAZ));
        ((Map)localObject).put("reserve_for_wifi", Boolean.valueOf(this.jBa));
      }
    }
    
    public final void aEz()
    {
      AppMethodBeat.i(45883);
      ad.i("MicroMsg.JsApiQueryDownloadTaskForNative", "doQueryDownloadTask, downloadId = %d", new Object[] { Long.valueOf(this.jyh) });
      int i;
      if ((this.jAU != null) && (this.jAU.length() > 0))
      {
        this.jAW = new JSONArray();
        i = 0;
        while (i < this.jAU.length())
        {
          long l = this.jAU.optLong(i);
          localObject = f.bQt().oh(l);
          this.jAW.put(a(l, (FileDownloadTaskInfo)localObject));
          i += 1;
        }
        this.jyf = false;
      }
      for (;;)
      {
        aXw();
        AppMethodBeat.o(45883);
        return;
        if ((this.jAV != null) && (this.jAV.length() > 0))
        {
          this.jAW = new JSONArray();
          i = 0;
          while (i < this.jAV.length())
          {
            localObject = this.jAV.optString(i);
            FileDownloadTaskInfo localFileDownloadTaskInfo = f.bQt().Sp((String)localObject);
            this.jAW.put(a((String)localObject, localFileDownloadTaskInfo));
            i += 1;
          }
          this.jyf = false;
        }
        else
        {
          if (this.jyh > 0L) {
            break;
          }
          this.jyg = "downloadId invalid";
        }
      }
      Object localObject = f.bQt().oh(this.jyh);
      switch (((FileDownloadTaskInfo)localObject).status)
      {
      case 0: 
      default: 
        this.jAX = "default";
      }
      for (;;)
      {
        ad.i("MicroMsg.JsApiQueryDownloadTaskForNative", "doQueryDownloadTask, state = %s", new Object[] { this.jAX });
        if (((FileDownloadTaskInfo)localObject).mqq != 0L)
        {
          this.jAY = (((float)((FileDownloadTaskInfo)localObject).ofL / (float)((FileDownloadTaskInfo)localObject).mqq * 100.0F));
          this.jAZ = ((float)((FileDownloadTaskInfo)localObject).ofL * 100.0F / (float)((FileDownloadTaskInfo)localObject).mqq);
        }
        this.jBa = ((FileDownloadTaskInfo)localObject).ofO;
        this.jyf = false;
        break;
        this.jyg = "fail_apilevel_too_low";
        break;
        this.jAX = "downloading";
        continue;
        if (i.eK(((FileDownloadTaskInfo)localObject).path))
        {
          this.jAX = "download_succ";
        }
        else
        {
          this.jAX = "default";
          continue;
          this.jAX = "download_pause";
          continue;
          this.jAX = "download_fail";
        }
      }
    }
    
    public final void e(Parcel paramParcel)
    {
      boolean bool2 = true;
      AppMethodBeat.i(45888);
      this.jyh = paramParcel.readLong();
      if (paramParcel.readInt() == 1) {}
      for (bool1 = true;; bool1 = false)
      {
        this.jyf = bool1;
        this.jyg = paramParcel.readString();
        this.jAX = paramParcel.readString();
        this.jAY = paramParcel.readLong();
        String str1 = paramParcel.readString();
        String str2 = paramParcel.readString();
        String str3 = paramParcel.readString();
        if (str1 != null) {}
        try
        {
          this.jAU = new JSONArray(str1);
          if (str2 != null) {
            this.jAV = new JSONArray(str2);
          }
          if (str3 != null) {
            this.jAW = new JSONArray(str3);
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
        this.jBa = bool1;
        AppMethodBeat.o(45888);
        return;
      }
    }
    
    public void writeToParcel(Parcel paramParcel, int paramInt)
    {
      int i = 1;
      Object localObject2 = null;
      AppMethodBeat.i(45889);
      paramParcel.writeLong(this.jyh);
      Object localObject1;
      if (this.jyf)
      {
        paramInt = 1;
        paramParcel.writeInt(paramInt);
        paramParcel.writeString(this.jyg);
        paramParcel.writeString(this.jAX);
        paramParcel.writeLong(this.jAY);
        if (this.jAU == null) {
          break label153;
        }
        localObject1 = this.jAU.toString();
        label73:
        paramParcel.writeString((String)localObject1);
        if (this.jAV == null) {
          break label159;
        }
        localObject1 = this.jAV.toString();
        label95:
        paramParcel.writeString((String)localObject1);
        localObject1 = localObject2;
        if (this.jAW != null) {
          localObject1 = this.jAW.toString();
        }
        paramParcel.writeString((String)localObject1);
        if (!this.jBa) {
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