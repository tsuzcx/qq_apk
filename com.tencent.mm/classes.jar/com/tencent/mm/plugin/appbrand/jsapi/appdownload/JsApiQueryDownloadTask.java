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
import com.tencent.mm.sdk.platformtools.ak;
import com.tencent.mm.sdk.platformtools.az;
import com.tencent.mm.sdk.platformtools.bu;
import com.tencent.mm.vfs.o;
import java.util.HashMap;
import java.util.Map;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

public final class JsApiQueryDownloadTask
  extends a<r>
{
  public static final int CTRL_INDEX = 441;
  public static final String NAME = "queryDownloadTask";
  
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
    
    public QueryDownloadTask(m paramm, r paramr, int paramInt, JSONObject paramJSONObject)
    {
      AppMethodBeat.i(45869);
      biw();
      this.kwe = paramm;
      this.jzD = paramr;
      this.cgA = paramInt;
      this.kwo = paramJSONObject.optLong("downloadId");
      this.kzb = paramJSONObject.optJSONArray("downloadIdArray");
      this.kzc = paramJSONObject.optJSONArray("appIdArray");
      this.kwm = true;
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
          ae.e("MicroMsg.JsApiQueryDownloadTask", paramFileDownloadTaskInfo.getMessage());
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
        ae.i("MicroMsg.JsApiQueryDownloadTask", "doQueryDownloadTask, state = %s", new Object[] { str1 });
        String str2 = str1;
        if (paramFileDownloadTaskInfo.ptC)
        {
          str2 = str1;
          if (!az.isWifi(ak.getContext()))
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
          if (paramFileDownloadTaskInfo.nyl != 0L) {
            l1 = ((float)paramFileDownloadTaskInfo.ptA / (float)paramFileDownloadTaskInfo.nyl * 100.0F);
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
          this.kwn = "fail_apilevel_too_low";
          AppMethodBeat.o(45874);
          return localJSONObject;
          str1 = "downloading";
          continue;
          if (o.fB(paramFileDownloadTaskInfo.path))
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
            ae.e("MicroMsg.JsApiQueryDownloadTask", paramFileDownloadTaskInfo.getMessage());
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
          ae.e("MicroMsg.JsApiQueryDownloadTask", paramString.getMessage());
        }
      }
    }
    
    public final void aOX()
    {
      AppMethodBeat.i(45871);
      ae.i("MicroMsg.JsApiQueryDownloadTask", "doQueryDownloadTask, downloadId = %d", new Object[] { Long.valueOf(this.kwo) });
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
        AppMethodBeat.o(45871);
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
      if ((((FileDownloadTaskInfo)localObject).ptC) && (((FileDownloadTaskInfo)localObject).status != 1) && (((FileDownloadTaskInfo)localObject).status != 3)) {
        this.kze = "download_wait_wifi";
      }
      switch (((FileDownloadTaskInfo)localObject).status)
      {
      case 0: 
      default: 
        this.kze = "default";
      }
      for (;;)
      {
        ae.i("MicroMsg.JsApiQueryDownloadTask", "doQueryDownloadTask, state = %s", new Object[] { this.kze });
        if (((this.kze == "downloading") || (this.kze == "download_pause")) && (((FileDownloadTaskInfo)localObject).nyl != 0L)) {
          this.kzf = (((float)((FileDownloadTaskInfo)localObject).ptA / (float)((FileDownloadTaskInfo)localObject).nyl * 100.0F));
        }
        if ((((FileDownloadTaskInfo)localObject).ptC) && (!az.isWifi(ak.getContext())) && (((FileDownloadTaskInfo)localObject).status != 3) && (((FileDownloadTaskInfo)localObject).status != 1)) {
          this.kze = "download_wait_wifi";
        }
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
      AppMethodBeat.i(45875);
      bix();
      boolean bool;
      if (this.jzD == null)
      {
        bool = true;
        ae.d("MicroMsg.JsApiQueryDownloadTask", "callback, service is null: %b", new Object[] { Boolean.valueOf(bool) });
        if (!this.kwm) {
          break label109;
        }
        if (!bu.isNullOrNil(this.kwn)) {
          break label88;
        }
      }
      label88:
      for (Object localObject = "fail";; localObject = String.format("fail:%s", new Object[] { this.kwn }))
      {
        this.jzD.h(this.cgA, this.kwe.e((String)localObject, null));
        AppMethodBeat.o(45875);
        return;
        bool = false;
        break;
      }
      label109:
      localObject = new HashMap();
      if (this.kzd != null) {
        ((Map)localObject).put("result", this.kzd);
      }
      for (;;)
      {
        this.jzD.h(this.cgA, this.kwe.n("ok", (Map)localObject));
        AppMethodBeat.o(45875);
        return;
        ((Map)localObject).put("downloadId", Long.valueOf(this.kwo));
        ((Map)localObject).put("state", this.kze);
        ((Map)localObject).put("progress", Long.valueOf(this.kzf));
      }
    }
    
    public final void e(Parcel paramParcel)
    {
      boolean bool = true;
      AppMethodBeat.i(45876);
      this.kwo = paramParcel.readLong();
      if (paramParcel.readInt() == 1) {}
      for (;;)
      {
        this.kwm = bool;
        this.kwn = paramParcel.readString();
        this.kze = paramParcel.readString();
        this.kzf = paramParcel.readLong();
        String str1 = paramParcel.readString();
        String str2 = paramParcel.readString();
        paramParcel = paramParcel.readString();
        if (str1 != null) {}
        try
        {
          this.kzb = new JSONArray(str1);
          if (str2 != null) {
            this.kzc = new JSONArray(str2);
          }
          if (paramParcel != null) {
            this.kzd = new JSONArray(paramParcel);
          }
          AppMethodBeat.o(45876);
          return;
        }
        catch (JSONException paramParcel)
        {
          ae.printErrStackTrace("MicroMsg.JsApiQueryDownloadTask", paramParcel, "", new Object[0]);
          AppMethodBeat.o(45876);
        }
        bool = false;
      }
    }
    
    public void writeToParcel(Parcel paramParcel, int paramInt)
    {
      Object localObject2 = null;
      AppMethodBeat.i(45877);
      paramParcel.writeLong(this.kwo);
      if (this.kwm)
      {
        paramInt = 1;
        paramParcel.writeInt(paramInt);
        paramParcel.writeString(this.kwn);
        paramParcel.writeString(this.kze);
        paramParcel.writeLong(this.kzf);
        if (this.kzb == null) {
          break label130;
        }
        localObject1 = this.kzb.toString();
        label70:
        paramParcel.writeString((String)localObject1);
        if (this.kzc == null) {
          break label135;
        }
      }
      label130:
      label135:
      for (Object localObject1 = this.kzc.toString();; localObject1 = null)
      {
        paramParcel.writeString((String)localObject1);
        localObject1 = localObject2;
        if (this.kzd != null) {
          localObject1 = this.kzd.toString();
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