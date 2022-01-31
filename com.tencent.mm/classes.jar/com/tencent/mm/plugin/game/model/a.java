package com.tencent.mm.plugin.game.model;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.compatible.util.q;
import com.tencent.mm.plugin.report.service.h;
import com.tencent.mm.sdk.platformtools.ab;
import com.tencent.mm.sdk.platformtools.bo;
import com.tencent.mm.storage.d;
import java.io.UnsupportedEncodingException;
import java.util.Map;
import org.json.JSONException;
import org.json.JSONObject;

public final class a
{
  private static String TAG = "MicroMsg.GameABTestStrategy";
  
  private static void a(com.tencent.mm.storage.c paramc, int paramInt1, String paramString, int paramInt2)
  {
    AppMethodBeat.i(111188);
    if (paramc == null)
    {
      ab.i(TAG, "ABTestItem is null");
      AppMethodBeat.o(111188);
      return;
    }
    str = "";
    try
    {
      JSONObject localJSONObject = new JSONObject();
      if (!bo.isNullOrNil(paramString)) {
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
    ab.i(TAG, "reportABTest : " + paramc.field_layerId + " , " + paramc.field_business + " , " + paramc.field_expId + " , " + paramc.field_sequence + " , " + paramc.field_prioritylevel + " , " + paramc.field_startTime + " , " + paramc.field_endTime + " , " + paramInt1 + " , " + paramString);
    h.qsU.e(14841, new Object[] { paramc.field_layerId, paramc.field_business, paramc.field_expId, Long.valueOf(paramc.field_sequence), Integer.valueOf(paramc.field_prioritylevel), Long.valueOf(paramc.field_startTime), Long.valueOf(paramc.field_endTime), Integer.valueOf(paramInt1), paramString });
    AppMethodBeat.o(111188);
  }
  
  public static a.a bFM()
  {
    AppMethodBeat.i(111184);
    a.a locala = new a.a();
    com.tencent.mm.storage.c localc = com.tencent.mm.model.c.c.abU().me("100001");
    if (!localc.isValid())
    {
      ab.e(TAG, "getIndexABTestInfo is timeout,startTime: %d, endTime: %d", new Object[] { Long.valueOf(localc.field_startTime), Long.valueOf(localc.field_endTime) });
      AppMethodBeat.o(111184);
      return locala;
    }
    Object localObject = localc.dvN();
    locala.bsY = bo.getInt((String)((Map)localObject).get("game_homepage_jump"), 0);
    String str = (String)((Map)localObject).get("game_homepage_url");
    localObject = str;
    if (str == null) {
      localObject = "";
    }
    locala.url = ((String)localObject);
    a(localc, 901, locala.url, locala.bsY);
    ab.i(TAG, "getIndexABTestInfo success, layerId = %s, expId = %s, flag = %d, url = %s", new Object[] { localc.field_layerId, localc.field_expId, Integer.valueOf(locala.bsY), locala.url });
    AppMethodBeat.o(111184);
    return locala;
  }
  
  public static a.a bFN()
  {
    AppMethodBeat.i(111186);
    a.a locala = new a.a();
    com.tencent.mm.storage.c localc = com.tencent.mm.model.c.c.abU().me("100003");
    if (!localc.isValid())
    {
      ab.e(TAG, "getLibraryABTestInfo is timeout,startTime: %d, endTime: %d", new Object[] { Long.valueOf(localc.field_startTime), Long.valueOf(localc.field_endTime) });
      AppMethodBeat.o(111186);
      return locala;
    }
    ab.i(TAG, "getLibraryABTestInfo success, layerId = %s", new Object[] { localc.field_layerId });
    Object localObject = localc.dvN();
    locala.bsY = bo.getInt((String)((Map)localObject).get("game_library_jump"), 0);
    String str = (String)((Map)localObject).get("game_library_url");
    localObject = str;
    if (str == null) {
      localObject = "";
    }
    locala.url = ((String)localObject);
    a(localc, 1005, locala.url, locala.bsY);
    AppMethodBeat.o(111186);
    return locala;
  }
  
  public static a.a bFO()
  {
    AppMethodBeat.i(111187);
    a.a locala = new a.a();
    com.tencent.mm.storage.c localc = com.tencent.mm.model.c.c.abU().me("100022");
    if (!localc.isValid())
    {
      AppMethodBeat.o(111187);
      return locala;
    }
    Object localObject = localc.dvN();
    locala.bsY = bo.getInt((String)((Map)localObject).get("game_message_jump"), 0);
    String str = (String)((Map)localObject).get("game_message_url");
    localObject = str;
    if (str == null) {
      localObject = "";
    }
    locala.url = ((String)localObject);
    a(localc, 1001, locala.url, locala.bsY);
    AppMethodBeat.o(111187);
    return locala;
  }
  
  public static a.a cu(String paramString, int paramInt)
  {
    AppMethodBeat.i(111185);
    a.a locala = new a.a();
    if (bo.isNullOrNil(paramString))
    {
      ab.e(TAG, "appid is null");
      AppMethodBeat.o(111185);
      return locala;
    }
    com.tencent.mm.storage.c localc = com.tencent.mm.model.c.c.abU().me("100002");
    if (!localc.isValid())
    {
      ab.e(TAG, "getDetailABTestInfo is timeout,startTime: %d, endTime: %d", new Object[] { Long.valueOf(localc.field_startTime), Long.valueOf(localc.field_endTime) });
      AppMethodBeat.o(111185);
      return locala;
    }
    ab.i(TAG, "getDetailABTestInfo success, layerId = %s", new Object[] { localc.field_layerId });
    Object localObject = localc.dvN();
    locala.bsY = bo.getInt((String)((Map)localObject).get("game_detail_jump"), 0);
    localObject = (String)((Map)localObject).get("game_detail_url");
    if (localObject == null) {}
    for (paramString = "";; paramString = (String)localObject + paramString)
    {
      locala.url = paramString;
      a(localc, paramInt, locala.url, locala.bsY);
      AppMethodBeat.o(111185);
      return locala;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.plugin.game.model.a
 * JD-Core Version:    0.7.0.1
 */