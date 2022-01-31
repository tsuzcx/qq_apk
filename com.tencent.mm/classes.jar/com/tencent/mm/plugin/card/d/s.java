package com.tencent.mm.plugin.card.d;

import android.text.TextUtils;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.card.sharecard.model.l;
import com.tencent.mm.plugin.card.sharecard.model.m;
import com.tencent.mm.sdk.platformtools.ab;
import java.util.LinkedList;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

public final class s
{
  public static l IK(String paramString)
  {
    int m = 1;
    AppMethodBeat.i(88947);
    if (TextUtils.isEmpty(paramString))
    {
      ab.e("MicroMsg.ShareCardLayoutDataParser", "parseShareCardLayoutData jsonContent is null");
      AppMethodBeat.o(88947);
      return null;
    }
    try
    {
      paramString = new JSONObject(paramString).optJSONObject("list");
      if (paramString == null)
      {
        ab.e("MicroMsg.ShareCardLayoutDataParser", "parseShareCardLayoutData resultJson is null");
        AppMethodBeat.o(88947);
        return null;
      }
      l locall = new l();
      locall.kpX = paramString.optString("local_city");
      locall.kpV = IL(paramString.optString("local_city_list"));
      locall.kpW = IL(paramString.optString("other_city_list"));
      locall.kpY = paramString.optBoolean("local_end");
      locall.kpZ = paramString.optBoolean("other_end");
      locall.cHw = paramString.optBoolean("show_red_dot");
      locall.cHx = paramString.optBoolean("show_new");
      locall.kqb = paramString.optString("tips");
      locall.kqa = IM(paramString.optString("icons"));
      locall.kqc = paramString.optInt("newest_sharecard_time_second");
      int i;
      int j;
      label209:
      int k;
      if (locall.kpY)
      {
        i = 1;
        if (!locall.kpZ) {
          break label288;
        }
        j = 1;
        if (!locall.cHw) {
          break label293;
        }
        k = 1;
        label219:
        if (!locall.cHx) {
          break label298;
        }
      }
      for (;;)
      {
        ab.i("MicroMsg.ShareCardLayoutDataParser", "localEnd:%d, otherEnd:%d, showRedDot:%d, showNew:%d, tips:%s", new Object[] { Integer.valueOf(i), Integer.valueOf(j), Integer.valueOf(k), Integer.valueOf(m), locall.kqb });
        AppMethodBeat.o(88947);
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
      ab.printErrStackTrace("MicroMsg.ShareCardLayoutDataParser", paramString, "", new Object[0]);
      AppMethodBeat.o(88947);
    }
  }
  
  private static LinkedList<m> IL(String paramString)
  {
    AppMethodBeat.i(88948);
    if (TextUtils.isEmpty(paramString))
    {
      ab.e("MicroMsg.ShareCardLayoutDataParser", "parseShareCardLayoutItem jsonContent is null");
      AppMethodBeat.o(88948);
      return null;
    }
    try
    {
      paramString = new JSONObject(paramString).optJSONArray("item_list");
      if ((paramString == null) || (paramString.length() == 0))
      {
        ab.e("MicroMsg.ShareCardLayoutDataParser", "parseShareCardLayoutItem itemListJson is null");
        AppMethodBeat.o(88948);
        return null;
      }
      LinkedList localLinkedList = new LinkedList();
      int i = 0;
      while (i < paramString.length())
      {
        JSONObject localJSONObject = paramString.optJSONObject(i);
        m localm = new m();
        localm.cHn = localJSONObject.optString("card_id");
        localm.kml = localJSONObject.optString("card_tp_id");
        localm.kqd = localJSONObject.optString("announcement");
        localm.kqe = localJSONObject.optInt("end_time", 0);
        localm.kqf = localJSONObject.optInt("update_time", 0);
        localm.kqg = localJSONObject.optInt("item_type", 0);
        localm.top = localJSONObject.optInt("top", 0);
        ab.i("MicroMsg.ShareCardLayoutDataParser", "ljd: card_tp_id:" + localm.kml + " top:" + localm.top);
        localLinkedList.add(localm);
        i += 1;
      }
      AppMethodBeat.o(88948);
      return localLinkedList;
    }
    catch (JSONException paramString)
    {
      ab.printErrStackTrace("MicroMsg.ShareCardLayoutDataParser", paramString, "", new Object[0]);
      AppMethodBeat.o(88948);
    }
    return null;
  }
  
  private static LinkedList<String> IM(String paramString)
  {
    AppMethodBeat.i(88949);
    if (TextUtils.isEmpty(paramString))
    {
      ab.e("MicroMsg.ShareCardLayoutDataParser", "parseShareCardIcons jsonContent is null");
      AppMethodBeat.o(88949);
      return null;
    }
    try
    {
      paramString = new JSONArray(paramString);
      if (paramString.length() == 0)
      {
        ab.e("MicroMsg.ShareCardLayoutDataParser", "parseShareCardIcons itemListJson is null");
        AppMethodBeat.o(88949);
        return null;
      }
      LinkedList localLinkedList = new LinkedList();
      int i = 0;
      while (i < paramString.length())
      {
        localLinkedList.add(paramString.optString(i));
        i += 1;
      }
      AppMethodBeat.o(88949);
      return localLinkedList;
    }
    catch (JSONException paramString)
    {
      ab.printErrStackTrace("MicroMsg.ShareCardLayoutDataParser", paramString, "", new Object[0]);
      AppMethodBeat.o(88949);
    }
    return null;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.mm.plugin.card.d.s
 * JD-Core Version:    0.7.0.1
 */