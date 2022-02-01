package com.tencent.mm.plugin.appbrand.jsapi.appdownload;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.appbrand.ipc.MainProcessTask;
import com.tencent.mm.plugin.appbrand.jsapi.c;
import com.tencent.mm.plugin.appbrand.jsapi.o;
import com.tencent.mm.plugin.appbrand.v;
import com.tencent.mm.plugin.downloader.model.FileDownloadTaskInfo;
import com.tencent.mm.plugin.downloader.model.f;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.MMApplicationContext;
import com.tencent.mm.sdk.platformtools.NetStatusUtil;
import com.tencent.mm.sdk.platformtools.Util;
import com.tencent.mm.vfs.u;
import java.util.HashMap;
import java.util.Map;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

public final class JsApiQueryDownloadTask
  extends c<v>
{
  public static final int CTRL_INDEX = 441;
  public static final String NAME = "queryDownloadTask";
  
  static class QueryDownloadTask
    extends MainProcessTask
  {
    public static final Parcelable.Creator<QueryDownloadTask> CREATOR;
    private int cqA;
    private v ntA;
    private boolean ovH;
    private String ovI;
    private long ovJ;
    private o ovz;
    private JSONArray oyW;
    private JSONArray oyX;
    private JSONArray oyY;
    private String oyZ;
    private long oza;
    
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
    
    public QueryDownloadTask(o paramo, v paramv, int paramInt, JSONObject paramJSONObject)
    {
      AppMethodBeat.i(45869);
      this.ovz = paramo;
      this.ntA = paramv;
      this.cqA = paramInt;
      this.ovJ = paramJSONObject.optLong("downloadId");
      this.oyW = paramJSONObject.optJSONArray("downloadIdArray");
      this.oyX = paramJSONObject.optJSONArray("appIdArray");
      this.ovH = true;
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
        if (paramFileDownloadTaskInfo.uij)
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
          if (paramFileDownloadTaskInfo.rKZ != 0L) {
            l1 = ((float)paramFileDownloadTaskInfo.uih / (float)paramFileDownloadTaskInfo.rKZ * 100.0F);
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
          this.ovI = "fail_apilevel_too_low";
          AppMethodBeat.o(45874);
          return localJSONObject;
          str1 = "downloading";
          continue;
          if (u.agG(paramFileDownloadTaskInfo.path))
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
    
    public final void RW()
    {
      AppMethodBeat.i(45871);
      Log.i("MicroMsg.JsApiQueryDownloadTask", "doQueryDownloadTask, downloadId = %d", new Object[] { Long.valueOf(this.ovJ) });
      int i;
      if ((this.oyW != null) && (this.oyW.length() > 0))
      {
        this.oyY = new JSONArray();
        i = 0;
        while (i < this.oyW.length())
        {
          long l = this.oyW.optLong(i);
          localObject = f.cPZ().Ix(l);
          this.oyY.put(a(l, (FileDownloadTaskInfo)localObject));
          i += 1;
        }
        this.ovH = false;
      }
      for (;;)
      {
        bPt();
        AppMethodBeat.o(45871);
        return;
        if ((this.oyX != null) && (this.oyX.length() > 0))
        {
          this.oyY = new JSONArray();
          i = 0;
          while (i < this.oyX.length())
          {
            localObject = this.oyX.optString(i);
            FileDownloadTaskInfo localFileDownloadTaskInfo = f.cPZ().asZ((String)localObject);
            this.oyY.put(a((String)localObject, localFileDownloadTaskInfo));
            i += 1;
          }
          this.ovH = false;
        }
        else
        {
          if (this.ovJ > 0L) {
            break;
          }
          this.ovI = "downloadId invalid";
        }
      }
      Object localObject = f.cPZ().Ix(this.ovJ);
      if ((((FileDownloadTaskInfo)localObject).uij) && (((FileDownloadTaskInfo)localObject).status != 1) && (((FileDownloadTaskInfo)localObject).status != 3)) {
        this.oyZ = "download_wait_wifi";
      }
      switch (((FileDownloadTaskInfo)localObject).status)
      {
      case 0: 
      default: 
        this.oyZ = "default";
      }
      for (;;)
      {
        Log.i("MicroMsg.JsApiQueryDownloadTask", "doQueryDownloadTask, state = %s", new Object[] { this.oyZ });
        if (((this.oyZ == "downloading") || (this.oyZ == "download_pause")) && (((FileDownloadTaskInfo)localObject).rKZ != 0L)) {
          this.oza = (((float)((FileDownloadTaskInfo)localObject).uih / (float)((FileDownloadTaskInfo)localObject).rKZ * 100.0F));
        }
        if ((((FileDownloadTaskInfo)localObject).uij) && (!NetStatusUtil.isWifi(MMApplicationContext.getContext())) && (((FileDownloadTaskInfo)localObject).status != 3) && (((FileDownloadTaskInfo)localObject).status != 1)) {
          this.oyZ = "download_wait_wifi";
        }
        this.ovH = false;
        break;
        this.ovI = "fail_apilevel_too_low";
        break;
        this.oyZ = "downloading";
        continue;
        if (u.agG(((FileDownloadTaskInfo)localObject).path))
        {
          this.oyZ = "download_succ";
        }
        else
        {
          this.oyZ = "default";
          continue;
          this.oyZ = "download_pause";
          continue;
          this.oyZ = "download_fail";
        }
      }
    }
    
    public final void bsK()
    {
      AppMethodBeat.i(45875);
      bPk();
      boolean bool;
      if (this.ntA == null)
      {
        bool = true;
        Log.d("MicroMsg.JsApiQueryDownloadTask", "callback, service is null: %b", new Object[] { Boolean.valueOf(bool) });
        if (!this.ovH) {
          break label109;
        }
        if (!Util.isNullOrNil(this.ovI)) {
          break label88;
        }
      }
      label88:
      for (Object localObject = "fail";; localObject = String.format("fail:%s", new Object[] { this.ovI }))
      {
        this.ntA.j(this.cqA, this.ovz.h((String)localObject, null));
        AppMethodBeat.o(45875);
        return;
        bool = false;
        break;
      }
      label109:
      localObject = new HashMap();
      if (this.oyY != null) {
        ((Map)localObject).put("result", this.oyY);
      }
      for (;;)
      {
        this.ntA.j(this.cqA, this.ovz.m("ok", (Map)localObject));
        AppMethodBeat.o(45875);
        return;
        ((Map)localObject).put("downloadId", Long.valueOf(this.ovJ));
        ((Map)localObject).put("state", this.oyZ);
        ((Map)localObject).put("progress", Long.valueOf(this.oza));
      }
    }
    
    public final void f(Parcel paramParcel)
    {
      boolean bool = true;
      AppMethodBeat.i(45876);
      this.ovJ = paramParcel.readLong();
      if (paramParcel.readInt() == 1) {}
      for (;;)
      {
        this.ovH = bool;
        this.ovI = paramParcel.readString();
        this.oyZ = paramParcel.readString();
        this.oza = paramParcel.readLong();
        String str1 = paramParcel.readString();
        String str2 = paramParcel.readString();
        paramParcel = paramParcel.readString();
        if (str1 != null) {}
        try
        {
          this.oyW = new JSONArray(str1);
          if (str2 != null) {
            this.oyX = new JSONArray(str2);
          }
          if (paramParcel != null) {
            this.oyY = new JSONArray(paramParcel);
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
      paramParcel.writeLong(this.ovJ);
      if (this.ovH)
      {
        paramInt = 1;
        paramParcel.writeInt(paramInt);
        paramParcel.writeString(this.ovI);
        paramParcel.writeString(this.oyZ);
        paramParcel.writeLong(this.oza);
        if (this.oyW == null) {
          break label130;
        }
        localObject1 = this.oyW.toString();
        label70:
        paramParcel.writeString((String)localObject1);
        if (this.oyX == null) {
          break label135;
        }
      }
      label130:
      label135:
      for (Object localObject1 = this.oyX.toString();; localObject1 = null)
      {
        paramParcel.writeString((String)localObject1);
        localObject1 = localObject2;
        if (this.oyY != null) {
          localObject1 = this.oyY.toString();
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