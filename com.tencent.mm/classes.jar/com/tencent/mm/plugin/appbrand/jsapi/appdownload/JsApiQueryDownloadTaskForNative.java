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
import com.tencent.mm.sdk.platformtools.Util;
import com.tencent.mm.vfs.u;
import java.util.HashMap;
import java.util.Map;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

public final class JsApiQueryDownloadTaskForNative
  extends c<v>
{
  public static final int CTRL_INDEX = 661;
  public static final String NAME = "queryDownloadTaskForNative";
  
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
    private float ozb;
    private boolean ozc;
    
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
    
    public QueryDownloadTask(o paramo, v paramv, int paramInt, JSONObject paramJSONObject)
    {
      AppMethodBeat.i(45881);
      this.ovz = paramo;
      this.ntA = paramv;
      this.cqA = paramInt;
      this.ovJ = paramJSONObject.optLong("downloadId");
      this.oyW = paramJSONObject.optJSONArray("downloadIdArray");
      this.oyX = paramJSONObject.optJSONArray("appIdArray");
      this.ovH = true;
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
        if (paramFileDownloadTaskInfo.rKZ != 0L)
        {
          l = paramFileDownloadTaskInfo.uih * 100L / paramFileDownloadTaskInfo.rKZ;
          f = (float)paramFileDownloadTaskInfo.uih * 100.0F / (float)paramFileDownloadTaskInfo.rKZ;
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
          if (!paramFileDownloadTaskInfo.uik) {
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
        this.ovI = "fail_apilevel_too_low";
        AppMethodBeat.o(45886);
        return localJSONObject;
        str = "downloading";
        break;
        if (u.agG(paramFileDownloadTaskInfo.path))
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
    
    public final void RW()
    {
      AppMethodBeat.i(45883);
      Log.i("MicroMsg.JsApiQueryDownloadTaskForNative", "doQueryDownloadTask, downloadId = %d", new Object[] { Long.valueOf(this.ovJ) });
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
        AppMethodBeat.o(45883);
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
      switch (((FileDownloadTaskInfo)localObject).status)
      {
      case 0: 
      default: 
        this.oyZ = "default";
      }
      for (;;)
      {
        Log.i("MicroMsg.JsApiQueryDownloadTaskForNative", "doQueryDownloadTask, state = %s", new Object[] { this.oyZ });
        if (((FileDownloadTaskInfo)localObject).rKZ != 0L)
        {
          this.oza = (((float)((FileDownloadTaskInfo)localObject).uih / (float)((FileDownloadTaskInfo)localObject).rKZ * 100.0F));
          this.ozb = ((float)((FileDownloadTaskInfo)localObject).uih * 100.0F / (float)((FileDownloadTaskInfo)localObject).rKZ);
        }
        this.ozc = ((FileDownloadTaskInfo)localObject).uik;
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
      AppMethodBeat.i(45887);
      bPk();
      boolean bool;
      if (this.ntA == null)
      {
        bool = true;
        Log.d("MicroMsg.JsApiQueryDownloadTaskForNative", "callback, service is null: %b", new Object[] { Boolean.valueOf(bool) });
        if (!this.ovH) {
          break label110;
        }
        if (!Util.isNullOrNil(this.ovI)) {
          break label89;
        }
      }
      label89:
      for (Object localObject = "fail";; localObject = String.format("fail:%s", new Object[] { this.ovI }))
      {
        this.ntA.j(this.cqA, this.ovz.h((String)localObject, null));
        AppMethodBeat.o(45887);
        return;
        bool = false;
        break;
      }
      label110:
      localObject = new HashMap();
      if (this.oyY != null) {
        ((Map)localObject).put("result", this.oyY);
      }
      for (;;)
      {
        this.ntA.j(this.cqA, this.ovz.m("ok", (Map)localObject));
        AppMethodBeat.o(45887);
        return;
        ((Map)localObject).put("downloadId", Long.valueOf(this.ovJ));
        ((Map)localObject).put("state", this.oyZ);
        ((Map)localObject).put("progress", Long.valueOf(this.oza));
        ((Map)localObject).put("progress_float", Float.valueOf(this.ozb));
        ((Map)localObject).put("reserve_for_wifi", Boolean.valueOf(this.ozc));
      }
    }
    
    public final void f(Parcel paramParcel)
    {
      boolean bool2 = true;
      AppMethodBeat.i(45888);
      this.ovJ = paramParcel.readLong();
      if (paramParcel.readInt() == 1) {}
      for (bool1 = true;; bool1 = false)
      {
        this.ovH = bool1;
        this.ovI = paramParcel.readString();
        this.oyZ = paramParcel.readString();
        this.oza = paramParcel.readLong();
        String str1 = paramParcel.readString();
        String str2 = paramParcel.readString();
        String str3 = paramParcel.readString();
        if (str1 != null) {}
        try
        {
          this.oyW = new JSONArray(str1);
          if (str2 != null) {
            this.oyX = new JSONArray(str2);
          }
          if (str3 != null) {
            this.oyY = new JSONArray(str3);
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
        this.ozc = bool1;
        AppMethodBeat.o(45888);
        return;
      }
    }
    
    public void writeToParcel(Parcel paramParcel, int paramInt)
    {
      int i = 1;
      Object localObject2 = null;
      AppMethodBeat.i(45889);
      paramParcel.writeLong(this.ovJ);
      Object localObject1;
      if (this.ovH)
      {
        paramInt = 1;
        paramParcel.writeInt(paramInt);
        paramParcel.writeString(this.ovI);
        paramParcel.writeString(this.oyZ);
        paramParcel.writeLong(this.oza);
        if (this.oyW == null) {
          break label153;
        }
        localObject1 = this.oyW.toString();
        label73:
        paramParcel.writeString((String)localObject1);
        if (this.oyX == null) {
          break label159;
        }
        localObject1 = this.oyX.toString();
        label95:
        paramParcel.writeString((String)localObject1);
        localObject1 = localObject2;
        if (this.oyY != null) {
          localObject1 = this.oyY.toString();
        }
        paramParcel.writeString((String)localObject1);
        if (!this.ozc) {
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