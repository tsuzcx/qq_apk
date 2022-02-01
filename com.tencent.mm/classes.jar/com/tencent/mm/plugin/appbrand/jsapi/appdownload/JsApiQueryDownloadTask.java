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
    private int bZo;
    private q iDy;
    private JSONArray jAU;
    private JSONArray jAV;
    private JSONArray jAW;
    private String jAX;
    private long jAY;
    private m jxX;
    private boolean jyf;
    private String jyg;
    private long jyh;
    
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
      aXm();
      this.jxX = paramm;
      this.iDy = paramq;
      this.bZo = paramInt;
      this.jyh = paramJSONObject.optLong("downloadId");
      this.jAU = paramJSONObject.optJSONArray("downloadIdArray");
      this.jAV = paramJSONObject.optJSONArray("appIdArray");
      this.jyf = true;
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
        if (paramFileDownloadTaskInfo.ofN)
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
          if (paramFileDownloadTaskInfo.mqq != 0L) {
            l1 = ((float)paramFileDownloadTaskInfo.ofL / (float)paramFileDownloadTaskInfo.mqq * 100.0F);
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
          this.jyg = "fail_apilevel_too_low";
          AppMethodBeat.o(45874);
          return localJSONObject;
          str1 = "downloading";
          continue;
          if (i.eK(paramFileDownloadTaskInfo.path))
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
    
    public final void aEA()
    {
      AppMethodBeat.i(45875);
      aXn();
      boolean bool;
      if (this.iDy == null)
      {
        bool = true;
        ad.d("MicroMsg.JsApiQueryDownloadTask", "callback, service is null: %b", new Object[] { Boolean.valueOf(bool) });
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
        AppMethodBeat.o(45875);
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
        AppMethodBeat.o(45875);
        return;
        ((Map)localObject).put("downloadId", Long.valueOf(this.jyh));
        ((Map)localObject).put("state", this.jAX);
        ((Map)localObject).put("progress", Long.valueOf(this.jAY));
      }
    }
    
    public final void aEz()
    {
      AppMethodBeat.i(45871);
      ad.i("MicroMsg.JsApiQueryDownloadTask", "doQueryDownloadTask, downloadId = %d", new Object[] { Long.valueOf(this.jyh) });
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
        AppMethodBeat.o(45871);
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
      if ((((FileDownloadTaskInfo)localObject).ofN) && (((FileDownloadTaskInfo)localObject).status != 1) && (((FileDownloadTaskInfo)localObject).status != 3)) {
        this.jAX = "download_wait_wifi";
      }
      switch (((FileDownloadTaskInfo)localObject).status)
      {
      case 0: 
      default: 
        this.jAX = "default";
      }
      for (;;)
      {
        ad.i("MicroMsg.JsApiQueryDownloadTask", "doQueryDownloadTask, state = %s", new Object[] { this.jAX });
        if (((this.jAX == "downloading") || (this.jAX == "download_pause")) && (((FileDownloadTaskInfo)localObject).mqq != 0L)) {
          this.jAY = (((float)((FileDownloadTaskInfo)localObject).ofL / (float)((FileDownloadTaskInfo)localObject).mqq * 100.0F));
        }
        if ((((FileDownloadTaskInfo)localObject).ofN) && (!ay.isWifi(aj.getContext())) && (((FileDownloadTaskInfo)localObject).status != 3) && (((FileDownloadTaskInfo)localObject).status != 1)) {
          this.jAX = "download_wait_wifi";
        }
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
      boolean bool = true;
      AppMethodBeat.i(45876);
      this.jyh = paramParcel.readLong();
      if (paramParcel.readInt() == 1) {}
      for (;;)
      {
        this.jyf = bool;
        this.jyg = paramParcel.readString();
        this.jAX = paramParcel.readString();
        this.jAY = paramParcel.readLong();
        String str1 = paramParcel.readString();
        String str2 = paramParcel.readString();
        paramParcel = paramParcel.readString();
        if (str1 != null) {}
        try
        {
          this.jAU = new JSONArray(str1);
          if (str2 != null) {
            this.jAV = new JSONArray(str2);
          }
          if (paramParcel != null) {
            this.jAW = new JSONArray(paramParcel);
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
      paramParcel.writeLong(this.jyh);
      if (this.jyf)
      {
        paramInt = 1;
        paramParcel.writeInt(paramInt);
        paramParcel.writeString(this.jyg);
        paramParcel.writeString(this.jAX);
        paramParcel.writeLong(this.jAY);
        if (this.jAU == null) {
          break label130;
        }
        localObject1 = this.jAU.toString();
        label70:
        paramParcel.writeString((String)localObject1);
        if (this.jAV == null) {
          break label135;
        }
      }
      label130:
      label135:
      for (Object localObject1 = this.jAV.toString();; localObject1 = null)
      {
        paramParcel.writeString((String)localObject1);
        localObject1 = localObject2;
        if (this.jAW != null) {
          localObject1 = this.jAW.toString();
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