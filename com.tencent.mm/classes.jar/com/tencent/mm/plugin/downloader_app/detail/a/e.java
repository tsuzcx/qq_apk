package com.tencent.mm.plugin.downloader_app.detail.a;

import android.content.Context;
import com.tencent.luggage.e.a.a;
import com.tencent.mm.plugin.downloader.model.FileDownloadTaskInfo;
import com.tencent.mm.plugin.downloader.model.d;
import com.tencent.mm.plugin.webview.luggage.jsapi.aw;
import com.tencent.mm.plugin.webview.luggage.jsapi.aw.a;
import com.tencent.mm.sdk.platformtools.ae;
import com.tencent.mm.sdk.platformtools.aq;
import com.tencent.mm.sdk.platformtools.bk;
import com.tencent.mm.sdk.platformtools.y;
import java.util.Iterator;
import java.util.LinkedList;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

public class e
  extends aw
{
  private static void a(FileDownloadTaskInfo paramFileDownloadTaskInfo, aw.a parama)
  {
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
        if ((str == "downloading") && (paramFileDownloadTaskInfo.hFz != 0L)) {
          localJSONObject.put("progress", paramFileDownloadTaskInfo.iPM / paramFileDownloadTaskInfo.hFz * 100L);
        }
        parama.e(null, localJSONObject);
        return;
      }
      catch (Exception paramFileDownloadTaskInfo)
      {
        y.e("MicroMsg.JsApiQueryDownloadTask", paramFileDownloadTaskInfo.getMessage());
      }
      str = "api_not_support";
      continue;
      str = "downloading";
      continue;
      if (com.tencent.mm.a.e.bK(paramFileDownloadTaskInfo.path))
      {
        str = "download_succ";
      }
      else
      {
        str = "default";
        continue;
        if ((paramFileDownloadTaskInfo.iPO) && (!aq.isWifi(ae.getContext())))
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
  
  private static void a(JSONArray paramJSONArray, aw.a parama)
  {
    JSONObject localJSONObject1 = new JSONObject();
    LinkedList localLinkedList = new LinkedList();
    int i = 0;
    while (i < paramJSONArray.length())
    {
      localLinkedList.add(paramJSONArray.optString(i));
      i += 1;
    }
    d.aFP();
    paramJSONArray = d.N(localLinkedList);
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
            if ((paramJSONArray == "downloading") && (localFileDownloadTaskInfo.hFz != 0L)) {
              localJSONObject2.put("progress", localFileDownloadTaskInfo.iPM / localFileDownloadTaskInfo.hFz * 100L);
            }
            localJSONObject1.put(localFileDownloadTaskInfo.appId, localJSONObject2);
            localLinkedList.remove(localFileDownloadTaskInfo.appId);
          }
          catch (Exception paramJSONArray)
          {
            y.e("MicroMsg.JsApiQueryDownloadTask", paramJSONArray.getMessage());
          }
          break;
          paramJSONArray = "api_not_support";
          continue;
          paramJSONArray = "downloading";
          continue;
          if (com.tencent.mm.a.e.bK(localFileDownloadTaskInfo.path))
          {
            paramJSONArray = "download_succ";
          }
          else
          {
            paramJSONArray = "default";
            continue;
            if ((localFileDownloadTaskInfo.iPO) && (!aq.isWifi(ae.getContext())))
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
      label342:
      parama.e(null, paramJSONArray);
      return;
      y.e("MicroMsg.JsApiQueryDownloadTask", "taskInfos is null");
      a(localJSONObject1, localLinkedList);
      paramJSONArray = new JSONObject();
      try
      {
        paramJSONArray.put("result", localJSONObject1.toString());
        label381:
        parama.e(null, paramJSONArray);
        return;
      }
      catch (JSONException localJSONException1)
      {
        break label381;
      }
    }
    catch (JSONException localJSONException2)
    {
      break label342;
    }
  }
  
  private static void a(JSONObject paramJSONObject, LinkedList<String> paramLinkedList)
  {
    if (bk.dk(paramLinkedList)) {}
    for (;;)
    {
      return;
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
          y.e("MicroMsg.JsApiQueryDownloadTask", localException.getMessage());
        }
      }
    }
  }
  
  public final void a(Context paramContext, String paramString, aw.a parama)
  {
    y.i("MicroMsg.JsApiQueryDownloadTask", "invokeInMM");
    try
    {
      paramContext = new JSONObject(paramString);
      paramString = paramContext.optJSONArray("appIdArray");
      if ((paramString != null) && (paramString.length() > 0))
      {
        a(paramString, parama);
        return;
      }
    }
    catch (JSONException paramContext)
    {
      y.e("MicroMsg.JsApiQueryDownloadTask", "paras data error: " + paramContext.getMessage());
      parama.e("fail", null);
      return;
    }
    long l = paramContext.optLong("download_id", -1L);
    paramContext = paramContext.optString("appid");
    if (l > 0L)
    {
      paramString = d.aFP().dd(l);
      paramContext = paramString;
      if (paramString == null) {
        paramContext = new FileDownloadTaskInfo();
      }
      a(paramContext, parama);
      return;
    }
    if (!bk.bl(paramContext))
    {
      paramString = d.aFP().zL(paramContext);
      paramContext = paramString;
      if (paramString == null) {
        paramContext = new FileDownloadTaskInfo();
      }
      a(paramContext, parama);
      return;
    }
    parama.e("fail", null);
  }
  
  public final int aGj()
  {
    return 1;
  }
  
  public final void b(a.a parama) {}
  
  public final String name()
  {
    return "queryDownloadTask";
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes9.jar
 * Qualified Name:     com.tencent.mm.plugin.downloader_app.detail.a.e
 * JD-Core Version:    0.7.0.1
 */