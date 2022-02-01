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
import com.tencent.mm.sdk.platformtools.ai;
import com.tencent.mm.sdk.platformtools.ax;
import com.tencent.mm.sdk.platformtools.bs;
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
      bej();
      this.jYs = paramm;
      this.jdy = paramq;
      this.bWl = paramInt;
      this.jYC = paramJSONObject.optLong("downloadId");
      this.kbq = paramJSONObject.optJSONArray("downloadIdArray");
      this.kbr = paramJSONObject.optJSONArray("appIdArray");
      this.jYA = true;
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
          ac.e("MicroMsg.JsApiQueryDownloadTask", paramFileDownloadTaskInfo.getMessage());
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
        ac.i("MicroMsg.JsApiQueryDownloadTask", "doQueryDownloadTask, state = %s", new Object[] { str1 });
        String str2 = str1;
        if (paramFileDownloadTaskInfo.oJo)
        {
          str2 = str1;
          if (!ax.isWifi(ai.getContext()))
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
          if (paramFileDownloadTaskInfo.mSs != 0L) {
            l1 = ((float)paramFileDownloadTaskInfo.oJm / (float)paramFileDownloadTaskInfo.mSs * 100.0F);
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
          this.jYB = "fail_apilevel_too_low";
          AppMethodBeat.o(45874);
          return localJSONObject;
          str1 = "downloading";
          continue;
          if (i.eA(paramFileDownloadTaskInfo.path))
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
            ac.e("MicroMsg.JsApiQueryDownloadTask", paramFileDownloadTaskInfo.getMessage());
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
          ac.e("MicroMsg.JsApiQueryDownloadTask", paramString.getMessage());
        }
      }
    }
    
    public final void aLq()
    {
      AppMethodBeat.i(45871);
      ac.i("MicroMsg.JsApiQueryDownloadTask", "doQueryDownloadTask, downloadId = %d", new Object[] { Long.valueOf(this.jYC) });
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
        AppMethodBeat.o(45871);
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
      if ((((FileDownloadTaskInfo)localObject).oJo) && (((FileDownloadTaskInfo)localObject).status != 1) && (((FileDownloadTaskInfo)localObject).status != 3)) {
        this.kbt = "download_wait_wifi";
      }
      switch (((FileDownloadTaskInfo)localObject).status)
      {
      case 0: 
      default: 
        this.kbt = "default";
      }
      for (;;)
      {
        ac.i("MicroMsg.JsApiQueryDownloadTask", "doQueryDownloadTask, state = %s", new Object[] { this.kbt });
        if (((this.kbt == "downloading") || (this.kbt == "download_pause")) && (((FileDownloadTaskInfo)localObject).mSs != 0L)) {
          this.kbu = (((float)((FileDownloadTaskInfo)localObject).oJm / (float)((FileDownloadTaskInfo)localObject).mSs * 100.0F));
        }
        if ((((FileDownloadTaskInfo)localObject).oJo) && (!ax.isWifi(ai.getContext())) && (((FileDownloadTaskInfo)localObject).status != 3) && (((FileDownloadTaskInfo)localObject).status != 1)) {
          this.kbt = "download_wait_wifi";
        }
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
      AppMethodBeat.i(45875);
      bek();
      boolean bool;
      if (this.jdy == null)
      {
        bool = true;
        ac.d("MicroMsg.JsApiQueryDownloadTask", "callback, service is null: %b", new Object[] { Boolean.valueOf(bool) });
        if (!this.jYA) {
          break label109;
        }
        if (!bs.isNullOrNil(this.jYB)) {
          break label88;
        }
      }
      label88:
      for (Object localObject = "fail";; localObject = String.format("fail:%s", new Object[] { this.jYB }))
      {
        this.jdy.h(this.bWl, this.jYs.e((String)localObject, null));
        AppMethodBeat.o(45875);
        return;
        bool = false;
        break;
      }
      label109:
      localObject = new HashMap();
      if (this.kbs != null) {
        ((Map)localObject).put("result", this.kbs);
      }
      for (;;)
      {
        this.jdy.h(this.bWl, this.jYs.k("ok", (Map)localObject));
        AppMethodBeat.o(45875);
        return;
        ((Map)localObject).put("downloadId", Long.valueOf(this.jYC));
        ((Map)localObject).put("state", this.kbt);
        ((Map)localObject).put("progress", Long.valueOf(this.kbu));
      }
    }
    
    public final void e(Parcel paramParcel)
    {
      boolean bool = true;
      AppMethodBeat.i(45876);
      this.jYC = paramParcel.readLong();
      if (paramParcel.readInt() == 1) {}
      for (;;)
      {
        this.jYA = bool;
        this.jYB = paramParcel.readString();
        this.kbt = paramParcel.readString();
        this.kbu = paramParcel.readLong();
        String str1 = paramParcel.readString();
        String str2 = paramParcel.readString();
        paramParcel = paramParcel.readString();
        if (str1 != null) {}
        try
        {
          this.kbq = new JSONArray(str1);
          if (str2 != null) {
            this.kbr = new JSONArray(str2);
          }
          if (paramParcel != null) {
            this.kbs = new JSONArray(paramParcel);
          }
          AppMethodBeat.o(45876);
          return;
        }
        catch (JSONException paramParcel)
        {
          ac.printErrStackTrace("MicroMsg.JsApiQueryDownloadTask", paramParcel, "", new Object[0]);
          AppMethodBeat.o(45876);
        }
        bool = false;
      }
    }
    
    public void writeToParcel(Parcel paramParcel, int paramInt)
    {
      Object localObject2 = null;
      AppMethodBeat.i(45877);
      paramParcel.writeLong(this.jYC);
      if (this.jYA)
      {
        paramInt = 1;
        paramParcel.writeInt(paramInt);
        paramParcel.writeString(this.jYB);
        paramParcel.writeString(this.kbt);
        paramParcel.writeLong(this.kbu);
        if (this.kbq == null) {
          break label130;
        }
        localObject1 = this.kbq.toString();
        label70:
        paramParcel.writeString((String)localObject1);
        if (this.kbr == null) {
          break label135;
        }
      }
      label130:
      label135:
      for (Object localObject1 = this.kbr.toString();; localObject1 = null)
      {
        paramParcel.writeString((String)localObject1);
        localObject1 = localObject2;
        if (this.kbs != null) {
          localObject1 = this.kbs.toString();
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