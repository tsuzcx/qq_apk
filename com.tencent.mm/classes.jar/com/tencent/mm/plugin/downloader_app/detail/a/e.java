package com.tencent.mm.plugin.downloader_app.detail.a;

import android.content.Context;
import com.tencent.luggage.d.a.a;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.downloader.model.FileDownloadTaskInfo;
import com.tencent.mm.plugin.downloader.model.f;
import com.tencent.mm.plugin.webview.luggage.jsapi.bn;
import com.tencent.mm.plugin.webview.luggage.jsapi.bn.a;
import com.tencent.mm.sdk.platformtools.ac;
import com.tencent.mm.sdk.platformtools.ai;
import com.tencent.mm.sdk.platformtools.ax;
import com.tencent.mm.sdk.platformtools.bs;
import com.tencent.mm.vfs.i;
import java.util.Iterator;
import java.util.LinkedList;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

public class e
  extends bn
{
  private static void a(FileDownloadTaskInfo paramFileDownloadTaskInfo, bn.a parama)
  {
    AppMethodBeat.i(8830);
    JSONObject localJSONObject = new JSONObject();
    String str;
    switch (paramFileDownloadTaskInfo.status)
    {
    case 0: 
    default: 
      str = "default";
    }
    for (;;)
    {
      try
      {
        localJSONObject.put("download_id", paramFileDownloadTaskInfo.id);
        localJSONObject.put("state", str);
        if ((str == "downloading") && (paramFileDownloadTaskInfo.mSs != 0L)) {
          localJSONObject.put("progress", paramFileDownloadTaskInfo.oJm / paramFileDownloadTaskInfo.mSs * 100L);
        }
        parama.f(null, localJSONObject);
        AppMethodBeat.o(8830);
        return;
      }
      catch (Exception paramFileDownloadTaskInfo)
      {
        ac.e("MicroMsg.JsApiQueryDownloadTask", paramFileDownloadTaskInfo.getMessage());
        AppMethodBeat.o(8830);
      }
      str = "api_not_support";
      continue;
      str = "downloading";
      continue;
      if (i.eA(paramFileDownloadTaskInfo.path))
      {
        str = "download_succ";
      }
      else
      {
        str = "default";
        continue;
        if ((paramFileDownloadTaskInfo.oJo) && (!ax.isWifi(ai.getContext())))
        {
          str = "download_wait_for_wifi";
        }
        else
        {
          str = "download_pause";
          continue;
          str = "download_fail";
        }
      }
    }
  }
  
  private static void a(JSONArray paramJSONArray, bn.a parama)
  {
    AppMethodBeat.i(8831);
    JSONObject localJSONObject1 = new JSONObject();
    LinkedList localLinkedList = new LinkedList();
    int i = 0;
    while (i < paramJSONArray.length())
    {
      localLinkedList.add(paramJSONArray.optString(i));
      i += 1;
    }
    f.bXJ();
    paramJSONArray = f.R(localLinkedList);
    if (paramJSONArray.size() > 0)
    {
      Iterator localIterator = paramJSONArray.iterator();
      if (localIterator.hasNext())
      {
        FileDownloadTaskInfo localFileDownloadTaskInfo = (FileDownloadTaskInfo)localIterator.next();
        JSONObject localJSONObject2 = new JSONObject();
        switch (localFileDownloadTaskInfo.status)
        {
        case 0: 
        default: 
          paramJSONArray = "default";
        }
        for (;;)
        {
          try
          {
            localJSONObject2.put("download_id", localFileDownloadTaskInfo.id);
            localJSONObject2.put("state", paramJSONArray);
            if ((paramJSONArray == "downloading") && (localFileDownloadTaskInfo.mSs != 0L)) {
              localJSONObject2.put("progress", localFileDownloadTaskInfo.oJm / localFileDownloadTaskInfo.mSs * 100L);
            }
            localJSONObject1.put(localFileDownloadTaskInfo.appId, localJSONObject2);
            localLinkedList.remove(localFileDownloadTaskInfo.appId);
          }
          catch (Exception paramJSONArray)
          {
            ac.e("MicroMsg.JsApiQueryDownloadTask", paramJSONArray.getMessage());
          }
          break;
          paramJSONArray = "api_not_support";
          continue;
          paramJSONArray = "downloading";
          continue;
          if (i.eA(localFileDownloadTaskInfo.path))
          {
            paramJSONArray = "download_succ";
          }
          else
          {
            paramJSONArray = "default";
            continue;
            if ((localFileDownloadTaskInfo.oJo) && (!ax.isWifi(ai.getContext())))
            {
              paramJSONArray = "download_wait_for_wifi";
            }
            else
            {
              paramJSONArray = "download_pause";
              continue;
              paramJSONArray = "download_fail";
            }
          }
        }
      }
      a(localJSONObject1, localLinkedList);
      paramJSONArray = new JSONObject();
    }
    try
    {
      paramJSONArray.put("result", localJSONObject1.toString());
      label346:
      parama.f(null, paramJSONArray);
      AppMethodBeat.o(8831);
      return;
      ac.e("MicroMsg.JsApiQueryDownloadTask", "taskInfos is null");
      a(localJSONObject1, localLinkedList);
      paramJSONArray = new JSONObject();
      try
      {
        paramJSONArray.put("result", localJSONObject1.toString());
        label391:
        parama.f(null, paramJSONArray);
        AppMethodBeat.o(8831);
        return;
      }
      catch (JSONException localJSONException1)
      {
        break label391;
      }
    }
    catch (JSONException localJSONException2)
    {
      break label346;
    }
  }
  
  private static void a(JSONObject paramJSONObject, LinkedList<String> paramLinkedList)
  {
    AppMethodBeat.i(8832);
    if (bs.gY(paramLinkedList))
    {
      AppMethodBeat.o(8832);
      return;
    }
    paramLinkedList = paramLinkedList.iterator();
    while (paramLinkedList.hasNext())
    {
      String str = (String)paramLinkedList.next();
      JSONObject localJSONObject = new JSONObject();
      try
      {
        localJSONObject.put("download_id", -1);
        localJSONObject.put("state", "default");
        paramJSONObject.put(str, localJSONObject);
      }
      catch (Exception localException)
      {
        ac.e("MicroMsg.JsApiQueryDownloadTask", localException.getMessage());
      }
    }
    AppMethodBeat.o(8832);
  }
  
  public final void a(Context paramContext, String paramString, bn.a parama)
  {
    AppMethodBeat.i(8829);
    ac.i("MicroMsg.JsApiQueryDownloadTask", "invokeInMM");
    try
    {
      paramContext = new JSONObject(paramString);
      paramString = paramContext.optJSONArray("appIdArray");
      if ((paramString != null) && (paramString.length() > 0))
      {
        a(paramString, parama);
        AppMethodBeat.o(8829);
        return;
      }
    }
    catch (JSONException paramContext)
    {
      ac.e("MicroMsg.JsApiQueryDownloadTask", "paras data error: " + paramContext.getMessage());
      parama.f("fail", null);
      AppMethodBeat.o(8829);
      return;
    }
    long l = paramContext.optLong("download_id", -1L);
    paramContext = paramContext.optString("appid");
    if (l > 0L)
    {
      paramString = f.bXJ().rT(l);
      paramContext = paramString;
      if (paramString == null) {
        paramContext = new FileDownloadTaskInfo();
      }
      a(paramContext, parama);
      AppMethodBeat.o(8829);
      return;
    }
    if (!bs.isNullOrNil(paramContext))
    {
      paramString = f.bXJ().WB(paramContext);
      paramContext = paramString;
      if (paramString == null) {
        paramContext = new FileDownloadTaskInfo();
      }
      a(paramContext, parama);
      AppMethodBeat.o(8829);
      return;
    }
    parama.f("fail", null);
    AppMethodBeat.o(8829);
  }
  
  public final void b(a.a parama) {}
  
  public final int bYk()
  {
    return 1;
  }
  
  public final String name()
  {
    return "queryDownloadTask";
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.plugin.downloader_app.detail.a.e
 * JD-Core Version:    0.7.0.1
 */