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
import com.tencent.mm.sdk.platformtools.ac;
import com.tencent.mm.sdk.platformtools.bs;
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
    private int bWl;
    private boolean jYA;
    private String jYB;
    private long jYC;
    private m jYs;
    private q jdy;
    private JSONArray kbq;
    private JSONArray kbr;
    private JSONArray kbs;
    private String kbt;
    private long kbu;
    private float kbv;
    private boolean kbw;
    
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
      bej();
      this.jYs = paramm;
      this.jdy = paramq;
      this.bWl = paramInt;
      this.jYC = paramJSONObject.optLong("downloadId");
      this.kbq = paramJSONObject.optJSONArray("downloadIdArray");
      this.kbr = paramJSONObject.optJSONArray("appIdArray");
      this.jYA = true;
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
          ac.e("MicroMsg.JsApiQueryDownloadTaskForNative", paramFileDownloadTaskInfo.getMessage());
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
        ac.i("MicroMsg.JsApiQueryDownloadTaskForNative", "doQueryDownloadTask, state = %s", new Object[] { str });
        f = 0.0F;
        if (paramFileDownloadTaskInfo.mSs != 0L)
        {
          l = paramFileDownloadTaskInfo.oJm * 100L / paramFileDownloadTaskInfo.mSs;
          f = (float)paramFileDownloadTaskInfo.oJm * 100.0F / (float)paramFileDownloadTaskInfo.mSs;
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
          if (!paramFileDownloadTaskInfo.oJp) {
            continue;
          }
          i = 1;
          localJSONObject.put("reserve_for_wifi", i);
        }
        catch (JSONException paramFileDownloadTaskInfo)
        {
          int i;
          ac.e("MicroMsg.JsApiQueryDownloadTaskForNative", paramFileDownloadTaskInfo.getMessage());
          continue;
        }
        AppMethodBeat.o(45886);
        return localJSONObject;
        this.jYB = "fail_apilevel_too_low";
        AppMethodBeat.o(45886);
        return localJSONObject;
        str = "downloading";
        break;
        if (i.eA(paramFileDownloadTaskInfo.path))
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
          ac.e("MicroMsg.JsApiQueryDownloadTaskForNative", paramString.getMessage());
        }
      }
    }
    
    public final void aLq()
    {
      AppMethodBeat.i(45883);
      ac.i("MicroMsg.JsApiQueryDownloadTaskForNative", "doQueryDownloadTask, downloadId = %d", new Object[] { Long.valueOf(this.jYC) });
      int i;
      if ((this.kbq != null) && (this.kbq.length() > 0))
      {
        this.kbs = new JSONArray();
        i = 0;
        while (i < this.kbq.length())
        {
          long l = this.kbq.optLong(i);
          localObject = f.bXJ().rT(l);
          this.kbs.put(a(l, (FileDownloadTaskInfo)localObject));
          i += 1;
        }
        this.jYA = false;
      }
      for (;;)
      {
        bet();
        AppMethodBeat.o(45883);
        return;
        if ((this.kbr != null) && (this.kbr.length() > 0))
        {
          this.kbs = new JSONArray();
          i = 0;
          while (i < this.kbr.length())
          {
            localObject = this.kbr.optString(i);
            FileDownloadTaskInfo localFileDownloadTaskInfo = f.bXJ().WB((String)localObject);
            this.kbs.put(a((String)localObject, localFileDownloadTaskInfo));
            i += 1;
          }
          this.jYA = false;
        }
        else
        {
          if (this.jYC > 0L) {
            break;
          }
          this.jYB = "downloadId invalid";
        }
      }
      Object localObject = f.bXJ().rT(this.jYC);
      switch (((FileDownloadTaskInfo)localObject).status)
      {
      case 0: 
      default: 
        this.kbt = "default";
      }
      for (;;)
      {
        ac.i("MicroMsg.JsApiQueryDownloadTaskForNative", "doQueryDownloadTask, state = %s", new Object[] { this.kbt });
        if (((FileDownloadTaskInfo)localObject).mSs != 0L)
        {
          this.kbu = (((float)((FileDownloadTaskInfo)localObject).oJm / (float)((FileDownloadTaskInfo)localObject).mSs * 100.0F));
          this.kbv = ((float)((FileDownloadTaskInfo)localObject).oJm * 100.0F / (float)((FileDownloadTaskInfo)localObject).mSs);
        }
        this.kbw = ((FileDownloadTaskInfo)localObject).oJp;
        this.jYA = false;
        break;
        this.jYB = "fail_apilevel_too_low";
        break;
        this.kbt = "downloading";
        continue;
        if (i.eA(((FileDownloadTaskInfo)localObject).path))
        {
          this.kbt = "download_succ";
        }
        else
        {
          this.kbt = "default";
          continue;
          this.kbt = "download_pause";
          continue;
          this.kbt = "download_fail";
        }
      }
    }
    
    public final void aLr()
    {
      AppMethodBeat.i(45887);
      bek();
      boolean bool;
      if (this.jdy == null)
      {
        bool = true;
        ac.d("MicroMsg.JsApiQueryDownloadTaskForNative", "callback, service is null: %b", new Object[] { Boolean.valueOf(bool) });
        if (!this.jYA) {
          break label110;
        }
        if (!bs.isNullOrNil(this.jYB)) {
          break label89;
        }
      }
      label89:
      for (Object localObject = "fail";; localObject = String.format("fail:%s", new Object[] { this.jYB }))
      {
        this.jdy.h(this.bWl, this.jYs.e((String)localObject, null));
        AppMethodBeat.o(45887);
        return;
        bool = false;
        break;
      }
      label110:
      localObject = new HashMap();
      if (this.kbs != null) {
        ((Map)localObject).put("result", this.kbs);
      }
      for (;;)
      {
        this.jdy.h(this.bWl, this.jYs.k("ok", (Map)localObject));
        AppMethodBeat.o(45887);
        return;
        ((Map)localObject).put("downloadId", Long.valueOf(this.jYC));
        ((Map)localObject).put("state", this.kbt);
        ((Map)localObject).put("progress", Long.valueOf(this.kbu));
        ((Map)localObject).put("progress_float", Float.valueOf(this.kbv));
        ((Map)localObject).put("reserve_for_wifi", Boolean.valueOf(this.kbw));
      }
    }
    
    public final void e(Parcel paramParcel)
    {
      boolean bool2 = true;
      AppMethodBeat.i(45888);
      this.jYC = paramParcel.readLong();
      if (paramParcel.readInt() == 1) {}
      for (bool1 = true;; bool1 = false)
      {
        this.jYA = bool1;
        this.jYB = paramParcel.readString();
        this.kbt = paramParcel.readString();
        this.kbu = paramParcel.readLong();
        String str1 = paramParcel.readString();
        String str2 = paramParcel.readString();
        String str3 = paramParcel.readString();
        if (str1 != null) {}
        try
        {
          this.kbq = new JSONArray(str1);
          if (str2 != null) {
            this.kbr = new JSONArray(str2);
          }
          if (str3 != null) {
            this.kbs = new JSONArray(str3);
          }
        }
        catch (JSONException localJSONException)
        {
          for (;;)
          {
            ac.printErrStackTrace("MicroMsg.JsApiQueryDownloadTaskForNative", localJSONException, "", new Object[0]);
            continue;
            bool1 = false;
          }
        }
        if (paramParcel.readInt() != 1) {
          break;
        }
        bool1 = bool2;
        this.kbw = bool1;
        AppMethodBeat.o(45888);
        return;
      }
    }
    
    public void writeToParcel(Parcel paramParcel, int paramInt)
    {
      int i = 1;
      Object localObject2 = null;
      AppMethodBeat.i(45889);
      paramParcel.writeLong(this.jYC);
      Object localObject1;
      if (this.jYA)
      {
        paramInt = 1;
        paramParcel.writeInt(paramInt);
        paramParcel.writeString(this.jYB);
        paramParcel.writeString(this.kbt);
        paramParcel.writeLong(this.kbu);
        if (this.kbq == null) {
          break label153;
        }
        localObject1 = this.kbq.toString();
        label73:
        paramParcel.writeString((String)localObject1);
        if (this.kbr == null) {
          break label159;
        }
        localObject1 = this.kbr.toString();
        label95:
        paramParcel.writeString((String)localObject1);
        localObject1 = localObject2;
        if (this.kbs != null) {
          localObject1 = this.kbs.toString();
        }
        paramParcel.writeString((String)localObject1);
        if (!this.kbw) {
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