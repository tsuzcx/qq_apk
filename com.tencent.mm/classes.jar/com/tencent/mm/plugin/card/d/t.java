package com.tencent.mm.plugin.card.d;

import android.text.TextUtils;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.card.sharecard.model.l;
import com.tencent.mm.plugin.card.sharecard.model.m;
import com.tencent.mm.sdk.platformtools.ac;
import java.util.LinkedList;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

public final class t
{
  public static l VH(String paramString)
  {
    int m = 1;
    AppMethodBeat.i(113875);
    if (TextUtils.isEmpty(paramString))
    {
      ac.e("MicroMsg.ShareCardLayoutDataParser", "parseShareCardLayoutData jsonContent is null");
      AppMethodBeat.o(113875);
      return null;
    }
    try
    {
      paramString = new JSONObject(paramString).optJSONObject("list");
      if (paramString == null)
      {
        ac.e("MicroMsg.ShareCardLayoutDataParser", "parseShareCardLayoutData resultJson is null");
        AppMethodBeat.o(113875);
        return null;
      }
      l locall = new l();
      locall.nYr = paramString.optString("local_city");
      locall.nYp = VI(paramString.optString("local_city_list"));
      locall.nYq = VI(paramString.optString("other_city_list"));
      locall.nYs = paramString.optBoolean("local_end");
      locall.nYt = paramString.optBoolean("other_end");
      locall.dvX = paramString.optBoolean("show_red_dot");
      locall.dvY = paramString.optBoolean("show_new");
      locall.nYv = paramString.optString("tips");
      locall.nYu = VJ(paramString.optString("icons"));
      locall.nYw = paramString.optInt("newest_sharecard_time_second");
      int i;
      int j;
      label209:
      int k;
      if (locall.nYs)
      {
        i = 1;
        if (!locall.nYt) {
          break label288;
        }
        j = 1;
        if (!locall.dvX) {
          break label293;
        }
        k = 1;
        label219:
        if (!locall.dvY) {
          break label298;
        }
      }
      for (;;)
      {
        ac.i("MicroMsg.ShareCardLayoutDataParser", "localEnd:%d, otherEnd:%d, showRedDot:%d, showNew:%d, tips:%s", new Object[] { Integer.valueOf(i), Integer.valueOf(j), Integer.valueOf(k), Integer.valueOf(m), locall.nYv });
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
      ac.printErrStackTrace("MicroMsg.ShareCardLayoutDataParser", paramString, "", new Object[0]);
      AppMethodBeat.o(113875);
    }
  }
  
  private static LinkedList<m> VI(String paramString)
  {
    AppMethodBeat.i(113876);
    if (TextUtils.isEmpty(paramString))
    {
      ac.e("MicroMsg.ShareCardLayoutDataParser", "parseShareCardLayoutItem jsonContent is null");
      AppMethodBeat.o(113876);
      return null;
    }
    try
    {
      paramString = new JSONObject(paramString).optJSONArray("item_list");
      if ((paramString == null) || (paramString.length() == 0))
      {
        ac.e("MicroMsg.ShareCardLayoutDataParser", "parseShareCardLayoutItem itemListJson is null");
        AppMethodBeat.o(113876);
        return null;
      }
      LinkedList localLinkedList = new LinkedList();
      int i = 0;
      while (i < paramString.length())
      {
        JSONObject localJSONObject = paramString.optJSONObject(i);
        m localm = new m();
        localm.dvO = localJSONObject.optString("card_id");
        localm.nUr = localJSONObject.optString("card_tp_id");
        localm.nYx = localJSONObject.optString("announcement");
        localm.nYy = localJSONObject.optInt("end_time", 0);
        localm.nYz = localJSONObject.optInt("update_time", 0);
        localm.nYA = localJSONObject.optInt("item_type", 0);
        localm.top = localJSONObject.optInt("top", 0);
        ac.i("MicroMsg.ShareCardLayoutDataParser", "ljd: card_tp_id:" + localm.nUr + " top:" + localm.top);
        localLinkedList.add(localm);
        i += 1;
      }
      AppMethodBeat.o(113876);
      return localLinkedList;
    }
    catch (JSONException paramString)
    {
      ac.printErrStackTrace("MicroMsg.ShareCardLayoutDataParser", paramString, "", new Object[0]);
      AppMethodBeat.o(113876);
    }
    return null;
  }
  
  private static LinkedList<String> VJ(String paramString)
  {
    AppMethodBeat.i(113877);
    if (TextUtils.isEmpty(paramString))
    {
      ac.e("MicroMsg.ShareCardLayoutDataParser", "parseShareCardIcons jsonContent is null");
      AppMethodBeat.o(113877);
      return null;
    }
    try
    {
      paramString = new JSONArray(paramString);
      if (paramString.length() == 0)
      {
        ac.e("MicroMsg.ShareCardLayoutDataParser", "parseShareCardIcons itemListJson is null");
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
      ac.printErrStackTrace("MicroMsg.ShareCardLayoutDataParser", paramString, "", new Object[0]);
      AppMethodBeat.o(113877);
    }
    return null;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.plugin.card.d.t
 * JD-Core Version:    0.7.0.1
 */