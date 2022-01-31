package com.tencent.mm.plugin.downloader_app.detail.a;

import android.content.Context;
import com.tencent.luggage.d.a.a;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.downloader.model.FileDownloadTaskInfo;
import com.tencent.mm.plugin.downloader.model.f;
import com.tencent.mm.plugin.webview.luggage.jsapi.bh;
import com.tencent.mm.plugin.webview.luggage.jsapi.bh.a;
import com.tencent.mm.sdk.platformtools.ab;
import com.tencent.mm.sdk.platformtools.ah;
import com.tencent.mm.sdk.platformtools.at;
import com.tencent.mm.sdk.platformtools.bo;
import java.util.Iterator;
import java.util.LinkedList;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

public class e
  extends bh
{
  private static void a(FileDownloadTaskInfo paramFileDownloadTaskInfo, bh.a parama)
  {
    AppMethodBeat.i(136075);
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
        if ((str == "downloading") && (paramFileDownloadTaskInfo.jyU != 0L)) {
          localJSONObject.put("progress", paramFileDownloadTaskInfo.kYX / paramFileDownloadTaskInfo.jyU * 100L);
        }
        parama.c(null, localJSONObject);
        AppMethodBeat.o(136075);
        return;
      }
      catch (Exception paramFileDownloadTaskInfo)
      {
        ab.e("MicroMsg.JsApiQueryDownloadTask", paramFileDownloadTaskInfo.getMessage());
        AppMethodBeat.o(136075);
      }
      str = "api_not_support";
      continue;
      str = "downloading";
      continue;
      if (com.tencent.mm.a.e.cN(paramFileDownloadTaskInfo.path))
      {
        str = "download_succ";
      }
      else
      {
        str = "default";
        continue;
        if ((paramFileDownloadTaskInfo.kYZ) && (!at.isWifi(ah.getContext())))
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
  
  private static void a(JSONArray paramJSONArray, bh.a parama)
  {
    AppMethodBeat.i(136076);
    JSONObject localJSONObject1 = new JSONObject();
    LinkedList localLinkedList = new LinkedList();
    int i = 0;
    while (i < paramJSONArray.length())
    {
      localLinkedList.add(paramJSONArray.optString(i));
      i += 1;
    }
    f.bjl();
    paramJSONArray = f.M(localLinkedList);
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
            if ((paramJSONArray == "downloading") && (localFileDownloadTaskInfo.jyU != 0L)) {
              localJSONObject2.put("progress", localFileDownloadTaskInfo.kYX / localFileDownloadTaskInfo.jyU * 100L);
            }
            localJSONObject1.put(localFileDownloadTaskInfo.appId, localJSONObject2);
            localLinkedList.remove(localFileDownloadTaskInfo.appId);
          }
          catch (Exception paramJSONArray)
          {
            ab.e("MicroMsg.JsApiQueryDownloadTask", paramJSONArray.getMessage());
          }
          break;
          paramJSONArray = "api_not_support";
          continue;
          paramJSONArray = "downloading";
          continue;
          if (com.tencent.mm.a.e.cN(localFileDownloadTaskInfo.path))
          {
            paramJSONArray = "download_succ";
          }
          else
          {
            paramJSONArray = "default";
            continue;
            if ((localFileDownloadTaskInfo.kYZ) && (!at.isWifi(ah.getContext())))
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
      parama.c(null, paramJSONArray);
      AppMethodBeat.o(136076);
      return;
      ab.e("MicroMsg.JsApiQueryDownloadTask", "taskInfos is null");
      a(localJSONObject1, localLinkedList);
      paramJSONArray = new JSONObject();
      try
      {
        paramJSONArray.put("result", localJSONObject1.toString());
        label390:
        parama.c(null, paramJSONArray);
        AppMethodBeat.o(136076);
        return;
      }
      catch (JSONException localJSONException1)
      {
        break label390;
      }
    }
    catch (JSONException localJSONException2)
    {
      break label346;
    }
  }
  
  private static void a(JSONObject paramJSONObject, LinkedList<String> paramLinkedList)
  {
    AppMethodBeat.i(136077);
    if (bo.es(paramLinkedList))
    {
      AppMethodBeat.o(136077);
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
        ab.e("MicroMsg.JsApiQueryDownloadTask", localException.getMessage());
      }
    }
    AppMethodBeat.o(136077);
  }
  
  public final void a(Context paramContext, String paramString, bh.a parama)
  {
    AppMethodBeat.i(136074);
    ab.i("MicroMsg.JsApiQueryDownloadTask", "invokeInMM");
    try
    {
      paramContext = new JSONObject(paramString);
      paramString = paramContext.optJSONArray("appIdArray");
      if ((paramString != null) && (paramString.length() > 0))
      {
        a(paramString, parama);
        AppMethodBeat.o(136074);
        return;
      }
    }
    catch (JSONException paramContext)
    {
      ab.e("MicroMsg.JsApiQueryDownloadTask", "paras data error: " + paramContext.getMessage());
      parama.c("fail", null);
      AppMethodBeat.o(136074);
      return;
    }
    long l = paramContext.optLong("download_id", -1L);
    paramContext = paramContext.optString("appid");
    if (l > 0L)
    {
      paramString = f.bjl().iA(l);
      paramContext = paramString;
      if (paramString == null) {
        paramContext = new FileDownloadTaskInfo();
      }
      a(paramContext, parama);
      AppMethodBeat.o(136074);
      return;
    }
    if (!bo.isNullOrNil(paramContext))
    {
      paramString = f.bjl().JH(paramContext);
      paramContext = paramString;
      if (paramString == null) {
        paramContext = new FileDownloadTaskInfo();
      }
      a(paramContext, parama);
      AppMethodBeat.o(136074);
      return;
    }
    parama.c("fail", null);
    AppMethodBeat.o(136074);
  }
  
  public final void b(a.a parama) {}
  
  public final int bjL()
  {
    return 1;
  }
  
  public final String name()
  {
    return "queryDownloadTask";
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes9.jar
 * Qualified Name:     com.tencent.mm.plugin.downloader_app.detail.a.e
 * JD-Core Version:    0.7.0.1
 */