package com.tencent.mm.plugin.game.model;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.compatible.util.p;
import com.tencent.mm.plugin.report.service.h;
import com.tencent.mm.sdk.platformtools.ac;
import com.tencent.mm.sdk.platformtools.bs;
import com.tencent.mm.storage.c;
import java.io.UnsupportedEncodingException;
import java.util.Map;
import org.json.JSONException;
import org.json.JSONObject;

public final class a
{
  private static String TAG = "MicroMsg.GameABTestStrategy";
  
  private static void a(c paramc, int paramInt1, String paramString, int paramInt2)
  {
    AppMethodBeat.i(41350);
    if (paramc == null)
    {
      ac.i(TAG, "ABTestItem is null");
      AppMethodBeat.o(41350);
      return;
    }
    str = "";
    try
    {
      JSONObject localJSONObject = new JSONObject();
      if (!bs.isNullOrNil(paramString)) {
        localJSONObject.put("url", paramString);
      }
      localJSONObject.put("jumpType", paramInt2);
      paramString = p.encode(localJSONObject.toString(), "UTF-8");
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
    ac.i(TAG, "reportABTest : " + paramc.field_layerId + " , " + paramc.field_business + " , " + paramc.field_expId + " , " + paramc.field_sequence + " , " + paramc.field_prioritylevel + " , " + paramc.field_startTime + " , " + paramc.field_endTime + " , " + paramInt1 + " , " + paramString);
    h.wUl.f(14841, new Object[] { paramc.field_layerId, paramc.field_business, paramc.field_expId, Long.valueOf(paramc.field_sequence), Integer.valueOf(paramc.field_prioritylevel), Long.valueOf(paramc.field_startTime), Long.valueOf(paramc.field_endTime), Integer.valueOf(paramInt1), paramString });
    AppMethodBeat.o(41350);
  }
  
  public static a cPP()
  {
    AppMethodBeat.i(41346);
    a locala = new a();
    c localc = com.tencent.mm.model.c.d.aAp().tJ("100001");
    if (!localc.isValid())
    {
      ac.e(TAG, "getIndexABTestInfo is timeout,startTime: %d, endTime: %d", new Object[] { Long.valueOf(localc.field_startTime), Long.valueOf(localc.field_endTime) });
      AppMethodBeat.o(41346);
      return locala;
    }
    Object localObject = localc.eYV();
    locala.drx = bs.getInt((String)((Map)localObject).get("game_homepage_jump"), 0);
    String str = (String)((Map)localObject).get("game_homepage_url");
    localObject = str;
    if (str == null) {
      localObject = "";
    }
    locala.url = ((String)localObject);
    a(localc, 901, locala.url, locala.drx);
    ac.i(TAG, "getIndexABTestInfo success, layerId = %s, expId = %s, flag = %d, url = %s", new Object[] { localc.field_layerId, localc.field_expId, Integer.valueOf(locala.drx), locala.url });
    AppMethodBeat.o(41346);
    return locala;
  }
  
  public static a cPQ()
  {
    AppMethodBeat.i(41348);
    a locala = new a();
    c localc = com.tencent.mm.model.c.d.aAp().tJ("100003");
    if (!localc.isValid())
    {
      ac.e(TAG, "getLibraryABTestInfo is timeout,startTime: %d, endTime: %d", new Object[] { Long.valueOf(localc.field_startTime), Long.valueOf(localc.field_endTime) });
      AppMethodBeat.o(41348);
      return locala;
    }
    ac.i(TAG, "getLibraryABTestInfo success, layerId = %s", new Object[] { localc.field_layerId });
    Object localObject = localc.eYV();
    locala.drx = bs.getInt((String)((Map)localObject).get("game_library_jump"), 0);
    String str = (String)((Map)localObject).get("game_library_url");
    localObject = str;
    if (str == null) {
      localObject = "";
    }
    locala.url = ((String)localObject);
    a(localc, 1005, locala.url, locala.drx);
    AppMethodBeat.o(41348);
    return locala;
  }
  
  public static a cPR()
  {
    AppMethodBeat.i(41349);
    a locala = new a();
    c localc = com.tencent.mm.model.c.d.aAp().tJ("100022");
    if (!localc.isValid())
    {
      AppMethodBeat.o(41349);
      return locala;
    }
    Object localObject = localc.eYV();
    locala.drx = bs.getInt((String)((Map)localObject).get("game_message_jump"), 0);
    String str = (String)((Map)localObject).get("game_message_url");
    localObject = str;
    if (str == null) {
      localObject = "";
    }
    locala.url = ((String)localObject);
    a(localc, 1001, locala.url, locala.drx);
    AppMethodBeat.o(41349);
    return locala;
  }
  
  public static a dy(String paramString, int paramInt)
  {
    AppMethodBeat.i(41347);
    a locala = new a();
    if (bs.isNullOrNil(paramString))
    {
      ac.e(TAG, "appid is null");
      AppMethodBeat.o(41347);
      return locala;
    }
    c localc = com.tencent.mm.model.c.d.aAp().tJ("100002");
    if (!localc.isValid())
    {
      ac.e(TAG, "getDetailABTestInfo is timeout,startTime: %d, endTime: %d", new Object[] { Long.valueOf(localc.field_startTime), Long.valueOf(localc.field_endTime) });
      AppMethodBeat.o(41347);
      return locala;
    }
    ac.i(TAG, "getDetailABTestInfo success, layerId = %s", new Object[] { localc.field_layerId });
    Object localObject = localc.eYV();
    locala.drx = bs.getInt((String)((Map)localObject).get("game_detail_jump"), 0);
    localObject = (String)((Map)localObject).get("game_detail_url");
    if (localObject == null) {}
    for (paramString = "";; paramString = (String)localObject + paramString)
    {
      locala.url = paramString;
      a(localc, paramInt, locala.url, locala.drx);
      AppMethodBeat.o(41347);
      return locala;
    }
  }
  
  public static final class a
  {
    public int drx = 0;
    public String url = "";
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.plugin.game.model.a
 * JD-Core Version:    0.7.0.1
 */