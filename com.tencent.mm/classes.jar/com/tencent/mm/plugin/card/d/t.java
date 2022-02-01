package com.tencent.mm.plugin.card.d;

import android.text.TextUtils;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.card.sharecard.model.l;
import com.tencent.mm.plugin.card.sharecard.model.m;
import com.tencent.mm.sdk.platformtools.ae;
import java.util.LinkedList;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

public final class t
{
  public static l aah(String paramString)
  {
    int m = 1;
    AppMethodBeat.i(113875);
    if (TextUtils.isEmpty(paramString))
    {
      ae.e("MicroMsg.ShareCardLayoutDataParser", "parseShareCardLayoutData jsonContent is null");
      AppMethodBeat.o(113875);
      return null;
    }
    try
    {
      paramString = new JSONObject(paramString).optJSONObject("list");
      if (paramString == null)
      {
        ae.e("MicroMsg.ShareCardLayoutDataParser", "parseShareCardLayoutData resultJson is null");
        AppMethodBeat.o(113875);
        return null;
      }
      l locall = new l();
      locall.oIn = paramString.optString("local_city");
      locall.oIl = aai(paramString.optString("local_city_list"));
      locall.oIm = aai(paramString.optString("other_city_list"));
      locall.oIo = paramString.optBoolean("local_end");
      locall.oIp = paramString.optBoolean("other_end");
      locall.dJl = paramString.optBoolean("show_red_dot");
      locall.dJm = paramString.optBoolean("show_new");
      locall.oIr = paramString.optString("tips");
      locall.oIq = aaj(paramString.optString("icons"));
      locall.oIs = paramString.optInt("newest_sharecard_time_second");
      int i;
      int j;
      label209:
      int k;
      if (locall.oIo)
      {
        i = 1;
        if (!locall.oIp) {
          break label288;
        }
        j = 1;
        if (!locall.dJl) {
          break label293;
        }
        k = 1;
        label219:
        if (!locall.dJm) {
          break label298;
        }
      }
      for (;;)
      {
        ae.i("MicroMsg.ShareCardLayoutDataParser", "localEnd:%d, otherEnd:%d, showRedDot:%d, showNew:%d, tips:%s", new Object[] { Integer.valueOf(i), Integer.valueOf(j), Integer.valueOf(k), Integer.valueOf(m), locall.oIr });
        AppMethodBeat.o(113875);
        return locall;
        i = 0;
        break;
        label288:
        j = 0;
        break label209;
        label293:
        k = 0;
        break label219;
        label298:
        m = 0;
      }
      return null;
    }
    catch (JSONException paramString)
    {
      ae.printErrStackTrace("MicroMsg.ShareCardLayoutDataParser", paramString, "", new Object[0]);
      AppMethodBeat.o(113875);
    }
  }
  
  private static LinkedList<m> aai(String paramString)
  {
    AppMethodBeat.i(113876);
    if (TextUtils.isEmpty(paramString))
    {
      ae.e("MicroMsg.ShareCardLayoutDataParser", "parseShareCardLayoutItem jsonContent is null");
      AppMethodBeat.o(113876);
      return null;
    }
    try
    {
      paramString = new JSONObject(paramString).optJSONArray("item_list");
      if ((paramString == null) || (paramString.length() == 0))
      {
        ae.e("MicroMsg.ShareCardLayoutDataParser", "parseShareCardLayoutItem itemListJson is null");
        AppMethodBeat.o(113876);
        return null;
      }
      LinkedList localLinkedList = new LinkedList();
      int i = 0;
      while (i < paramString.length())
      {
        JSONObject localJSONObject = paramString.optJSONObject(i);
        m localm = new m();
        localm.dJb = localJSONObject.optString("card_id");
        localm.oEo = localJSONObject.optString("card_tp_id");
        localm.oIt = localJSONObject.optString("announcement");
        localm.oIu = localJSONObject.optInt("end_time", 0);
        localm.oIv = localJSONObject.optInt("update_time", 0);
        localm.oIw = localJSONObject.optInt("item_type", 0);
        localm.top = localJSONObject.optInt("top", 0);
        ae.i("MicroMsg.ShareCardLayoutDataParser", "ljd: card_tp_id:" + localm.oEo + " top:" + localm.top);
        localLinkedList.add(localm);
        i += 1;
      }
      AppMethodBeat.o(113876);
      return localLinkedList;
    }
    catch (JSONException paramString)
    {
      ae.printErrStackTrace("MicroMsg.ShareCardLayoutDataParser", paramString, "", new Object[0]);
      AppMethodBeat.o(113876);
    }
    return null;
  }
  
  private static LinkedList<String> aaj(String paramString)
  {
    AppMethodBeat.i(113877);
    if (TextUtils.isEmpty(paramString))
    {
      ae.e("MicroMsg.ShareCardLayoutDataParser", "parseShareCardIcons jsonContent is null");
      AppMethodBeat.o(113877);
      return null;
    }
    try
    {
      paramString = new JSONArray(paramString);
      if (paramString.length() == 0)
      {
        ae.e("MicroMsg.ShareCardLayoutDataParser", "parseShareCardIcons itemListJson is null");
        AppMethodBeat.o(113877);
        return null;
      }
      LinkedList localLinkedList = new LinkedList();
      int i = 0;
      while (i < paramString.length())
      {
        localLinkedList.add(paramString.optString(i));
        i += 1;
      }
      AppMethodBeat.o(113877);
      return localLinkedList;
    }
    catch (JSONException paramString)
    {
      ae.printErrStackTrace("MicroMsg.ShareCardLayoutDataParser", paramString, "", new Object[0]);
      AppMethodBeat.o(113877);
    }
    return null;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.mm.plugin.card.d.t
 * JD-Core Version:    0.7.0.1
 */