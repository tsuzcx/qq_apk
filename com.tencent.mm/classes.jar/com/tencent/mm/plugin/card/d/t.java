package com.tencent.mm.plugin.card.d;

import android.text.TextUtils;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.card.sharecard.model.l;
import com.tencent.mm.plugin.card.sharecard.model.m;
import com.tencent.mm.sdk.platformtools.ad;
import java.util.LinkedList;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

public final class t
{
  public static l Rv(String paramString)
  {
    int m = 1;
    AppMethodBeat.i(113875);
    if (TextUtils.isEmpty(paramString))
    {
      ad.e("MicroMsg.ShareCardLayoutDataParser", "parseShareCardLayoutData jsonContent is null");
      AppMethodBeat.o(113875);
      return null;
    }
    try
    {
      paramString = new JSONObject(paramString).optJSONObject("list");
      if (paramString == null)
      {
        ad.e("MicroMsg.ShareCardLayoutDataParser", "parseShareCardLayoutData resultJson is null");
        AppMethodBeat.o(113875);
        return null;
      }
      l locall = new l();
      locall.nvr = paramString.optString("local_city");
      locall.nvp = Rw(paramString.optString("local_city_list"));
      locall.nvq = Rw(paramString.optString("other_city_list"));
      locall.nvs = paramString.optBoolean("local_end");
      locall.nvt = paramString.optBoolean("other_end");
      locall.dyl = paramString.optBoolean("show_red_dot");
      locall.dym = paramString.optBoolean("show_new");
      locall.nvv = paramString.optString("tips");
      locall.nvu = Rx(paramString.optString("icons"));
      locall.nvw = paramString.optInt("newest_sharecard_time_second");
      int i;
      int j;
      label209:
      int k;
      if (locall.nvs)
      {
        i = 1;
        if (!locall.nvt) {
          break label288;
        }
        j = 1;
        if (!locall.dyl) {
          break label293;
        }
        k = 1;
        label219:
        if (!locall.dym) {
          break label298;
        }
      }
      for (;;)
      {
        ad.i("MicroMsg.ShareCardLayoutDataParser", "localEnd:%d, otherEnd:%d, showRedDot:%d, showNew:%d, tips:%s", new Object[] { Integer.valueOf(i), Integer.valueOf(j), Integer.valueOf(k), Integer.valueOf(m), locall.nvv });
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
      ad.printErrStackTrace("MicroMsg.ShareCardLayoutDataParser", paramString, "", new Object[0]);
      AppMethodBeat.o(113875);
    }
  }
  
  private static LinkedList<m> Rw(String paramString)
  {
    AppMethodBeat.i(113876);
    if (TextUtils.isEmpty(paramString))
    {
      ad.e("MicroMsg.ShareCardLayoutDataParser", "parseShareCardLayoutItem jsonContent is null");
      AppMethodBeat.o(113876);
      return null;
    }
    try
    {
      paramString = new JSONObject(paramString).optJSONArray("item_list");
      if ((paramString == null) || (paramString.length() == 0))
      {
        ad.e("MicroMsg.ShareCardLayoutDataParser", "parseShareCardLayoutItem itemListJson is null");
        AppMethodBeat.o(113876);
        return null;
      }
      LinkedList localLinkedList = new LinkedList();
      int i = 0;
      while (i < paramString.length())
      {
        JSONObject localJSONObject = paramString.optJSONObject(i);
        m localm = new m();
        localm.dyc = localJSONObject.optString("card_id");
        localm.nrr = localJSONObject.optString("card_tp_id");
        localm.nvx = localJSONObject.optString("announcement");
        localm.nvy = localJSONObject.optInt("end_time", 0);
        localm.nvz = localJSONObject.optInt("update_time", 0);
        localm.nvA = localJSONObject.optInt("item_type", 0);
        localm.top = localJSONObject.optInt("top", 0);
        ad.i("MicroMsg.ShareCardLayoutDataParser", "ljd: card_tp_id:" + localm.nrr + " top:" + localm.top);
        localLinkedList.add(localm);
        i += 1;
      }
      AppMethodBeat.o(113876);
      return localLinkedList;
    }
    catch (JSONException paramString)
    {
      ad.printErrStackTrace("MicroMsg.ShareCardLayoutDataParser", paramString, "", new Object[0]);
      AppMethodBeat.o(113876);
    }
    return null;
  }
  
  private static LinkedList<String> Rx(String paramString)
  {
    AppMethodBeat.i(113877);
    if (TextUtils.isEmpty(paramString))
    {
      ad.e("MicroMsg.ShareCardLayoutDataParser", "parseShareCardIcons jsonContent is null");
      AppMethodBeat.o(113877);
      return null;
    }
    try
    {
      paramString = new JSONArray(paramString);
      if (paramString.length() == 0)
      {
        ad.e("MicroMsg.ShareCardLayoutDataParser", "parseShareCardIcons itemListJson is null");
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
      ad.printErrStackTrace("MicroMsg.ShareCardLayoutDataParser", paramString, "", new Object[0]);
      AppMethodBeat.o(113877);
    }
    return null;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.plugin.card.d.t
 * JD-Core Version:    0.7.0.1
 */