package com.tencent.mm.plugin.game.model;

import com.tencent.mm.compatible.util.q;
import com.tencent.mm.plugin.report.service.h;
import com.tencent.mm.sdk.platformtools.bk;
import com.tencent.mm.sdk.platformtools.y;
import com.tencent.mm.storage.d;
import java.io.UnsupportedEncodingException;
import java.util.Map;
import org.json.JSONException;
import org.json.JSONObject;

public final class b
{
  private static String TAG = "MicroMsg.GameABTestStrategy";
  
  private static void a(com.tencent.mm.storage.c paramc, int paramInt1, String paramString, int paramInt2)
  {
    if (paramc == null)
    {
      y.i(TAG, "ABTestItem is null");
      return;
    }
    str = "";
    try
    {
      JSONObject localJSONObject = new JSONObject();
      if (!bk.bl(paramString)) {
        localJSONObject.put("url", paramString);
      }
      localJSONObject.put("jumpType", paramInt2);
      paramString = q.encode(localJSONObject.toString(), "UTF-8");
    }
    catch (UnsupportedEncodingException paramString)
    {
      for (;;)
      {
        paramString = str;
      }
    }
    catch (JSONException paramString)
    {
      for (;;)
      {
        paramString = str;
      }
    }
    y.i(TAG, "reportABTest : " + paramc.field_layerId + " , " + paramc.field_business + " , " + paramc.field_expId + " , " + paramc.field_sequence + " , " + paramc.field_prioritylevel + " , " + paramc.field_startTime + " , " + paramc.field_endTime + " , " + paramInt1 + " , " + paramString);
    h.nFQ.f(14841, new Object[] { paramc.field_layerId, paramc.field_business, paramc.field_expId, Long.valueOf(paramc.field_sequence), Integer.valueOf(paramc.field_prioritylevel), Long.valueOf(paramc.field_startTime), Long.valueOf(paramc.field_endTime), Integer.valueOf(paramInt1), paramString });
  }
  
  public static b.a aYO()
  {
    b.a locala = new b.a();
    com.tencent.mm.storage.c localc = com.tencent.mm.model.c.c.IX().fJ("100003");
    if (!localc.isValid())
    {
      y.e(TAG, "getLibraryABTestInfo is timeout,startTime: %d, endTime: %d", new Object[] { Long.valueOf(localc.field_startTime), Long.valueOf(localc.field_endTime) });
      return locala;
    }
    y.i(TAG, "getLibraryABTestInfo success, layerId = %s", new Object[] { localc.field_layerId });
    Object localObject = localc.ctr();
    locala.bcw = bk.getInt((String)((Map)localObject).get("game_library_jump"), 0);
    String str = (String)((Map)localObject).get("game_library_url");
    localObject = str;
    if (str == null) {
      localObject = "";
    }
    locala.url = ((String)localObject);
    a(localc, 1005, locala.url, locala.bcw);
    return locala;
  }
  
  public static b.a aYP()
  {
    b.a locala = new b.a();
    com.tencent.mm.storage.c localc = com.tencent.mm.model.c.c.IX().fJ("100022");
    if (!localc.isValid()) {
      return locala;
    }
    Object localObject = localc.ctr();
    locala.bcw = bk.getInt((String)((Map)localObject).get("game_message_jump"), 0);
    String str = (String)((Map)localObject).get("game_message_url");
    localObject = str;
    if (str == null) {
      localObject = "";
    }
    locala.url = ((String)localObject);
    a(localc, 1001, locala.url, locala.bcw);
    return locala;
  }
  
  public static b.a bH(String paramString, int paramInt)
  {
    b.a locala = new b.a();
    if (bk.bl(paramString))
    {
      y.e(TAG, "appid is null");
      return locala;
    }
    com.tencent.mm.storage.c localc = com.tencent.mm.model.c.c.IX().fJ("100002");
    if (!localc.isValid())
    {
      y.e(TAG, "getDetailABTestInfo is timeout,startTime: %d, endTime: %d", new Object[] { Long.valueOf(localc.field_startTime), Long.valueOf(localc.field_endTime) });
      return locala;
    }
    y.i(TAG, "getDetailABTestInfo success, layerId = %s", new Object[] { localc.field_layerId });
    Object localObject = localc.ctr();
    locala.bcw = bk.getInt((String)((Map)localObject).get("game_detail_jump"), 0);
    localObject = (String)((Map)localObject).get("game_detail_url");
    if (localObject == null) {}
    for (paramString = "";; paramString = (String)localObject + paramString)
    {
      locala.url = paramString;
      a(localc, paramInt, locala.url, locala.bcw);
      return locala;
    }
  }
  
  public static b.a sd(int paramInt)
  {
    b.a locala = new b.a();
    com.tencent.mm.storage.c localc = com.tencent.mm.model.c.c.IX().fJ("100001");
    if (!localc.isValid())
    {
      y.e(TAG, "getIndexABTestInfo is timeout,startTime: %d, endTime: %d", new Object[] { Long.valueOf(localc.field_startTime), Long.valueOf(localc.field_endTime) });
      return locala;
    }
    Object localObject = localc.ctr();
    locala.bcw = bk.getInt((String)((Map)localObject).get("game_homepage_jump"), 0);
    String str = (String)((Map)localObject).get("game_homepage_url");
    localObject = str;
    if (str == null) {
      localObject = "";
    }
    locala.url = ((String)localObject);
    a(localc, paramInt, locala.url, locala.bcw);
    y.i(TAG, "getIndexABTestInfo success, layerId = %s, expId = %s, flag = %d, url = %s", new Object[] { localc.field_layerId, localc.field_expId, Integer.valueOf(locala.bcw), locala.url });
    return locala;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.plugin.game.model.b
 * JD-Core Version:    0.7.0.1
 */