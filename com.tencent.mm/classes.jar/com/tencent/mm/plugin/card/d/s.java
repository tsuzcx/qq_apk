package com.tencent.mm.plugin.card.d;

import android.text.TextUtils;
import com.tencent.mm.plugin.card.sharecard.model.l;
import com.tencent.mm.plugin.card.sharecard.model.m;
import com.tencent.mm.sdk.platformtools.y;
import java.util.LinkedList;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

public final class s
{
  public static l zb(String paramString)
  {
    int m = 1;
    if (TextUtils.isEmpty(paramString))
    {
      y.e("MicroMsg.ShareCardLayoutDataParser", "parseShareCardLayoutData jsonContent is null");
      return null;
    }
    try
    {
      paramString = new JSONObject(paramString).optJSONObject("list");
      if (paramString == null)
      {
        y.e("MicroMsg.ShareCardLayoutDataParser", "parseShareCardLayoutData resultJson is null");
        return null;
      }
    }
    catch (JSONException paramString)
    {
      y.printErrStackTrace("MicroMsg.ShareCardLayoutDataParser", paramString, "", new Object[0]);
      return null;
    }
    l locall = new l();
    locall.ioQ = paramString.optString("local_city");
    locall.ioO = zc(paramString.optString("local_city_list"));
    locall.ioP = zc(paramString.optString("other_city_list"));
    locall.ioR = paramString.optBoolean("local_end");
    locall.ioS = paramString.optBoolean("other_end");
    locall.bZl = paramString.optBoolean("show_red_dot");
    locall.bZm = paramString.optBoolean("show_new");
    locall.ioU = paramString.optString("tips");
    locall.ioT = zd(paramString.optString("icons"));
    locall.ioV = paramString.optInt("newest_sharecard_time_second");
    int i;
    int j;
    label209:
    int k;
    if (locall.ioR)
    {
      i = 1;
      if (!locall.ioS) {
        break label283;
      }
      j = 1;
      if (!locall.bZl) {
        break label288;
      }
      k = 1;
      label219:
      if (!locall.bZm) {
        break label293;
      }
    }
    for (;;)
    {
      y.i("MicroMsg.ShareCardLayoutDataParser", "localEnd:%d, otherEnd:%d, showRedDot:%d, showNew:%d, tips:%s", new Object[] { Integer.valueOf(i), Integer.valueOf(j), Integer.valueOf(k), Integer.valueOf(m), locall.ioU });
      return locall;
      i = 0;
      break;
      label283:
      j = 0;
      break label209;
      label288:
      k = 0;
      break label219;
      label293:
      m = 0;
    }
  }
  
  private static LinkedList<m> zc(String paramString)
  {
    if (TextUtils.isEmpty(paramString))
    {
      y.e("MicroMsg.ShareCardLayoutDataParser", "parseShareCardLayoutItem jsonContent is null");
      return null;
    }
    try
    {
      paramString = new JSONObject(paramString).optJSONArray("item_list");
      if ((paramString == null) || (paramString.length() == 0))
      {
        y.e("MicroMsg.ShareCardLayoutDataParser", "parseShareCardLayoutItem itemListJson is null");
        return null;
      }
    }
    catch (JSONException paramString)
    {
      y.printErrStackTrace("MicroMsg.ShareCardLayoutDataParser", paramString, "", new Object[0]);
      return null;
    }
    LinkedList localLinkedList = new LinkedList();
    int i = 0;
    while (i < paramString.length())
    {
      JSONObject localJSONObject = paramString.optJSONObject(i);
      m localm = new m();
      localm.bZc = localJSONObject.optString("card_id");
      localm.iln = localJSONObject.optString("card_tp_id");
      localm.ioW = localJSONObject.optString("announcement");
      localm.ioX = localJSONObject.optInt("end_time", 0);
      localm.ioY = localJSONObject.optInt("update_time", 0);
      localm.ioZ = localJSONObject.optInt("item_type", 0);
      localm.top = localJSONObject.optInt("top", 0);
      y.i("MicroMsg.ShareCardLayoutDataParser", "ljd: card_tp_id:" + localm.iln + " top:" + localm.top);
      localLinkedList.add(localm);
      i += 1;
    }
    return localLinkedList;
  }
  
  private static LinkedList<String> zd(String paramString)
  {
    if (TextUtils.isEmpty(paramString))
    {
      y.e("MicroMsg.ShareCardLayoutDataParser", "parseShareCardIcons jsonContent is null");
      return null;
    }
    try
    {
      paramString = new JSONArray(paramString);
      if (paramString.length() == 0)
      {
        y.e("MicroMsg.ShareCardLayoutDataParser", "parseShareCardIcons itemListJson is null");
        return null;
      }
    }
    catch (JSONException paramString)
    {
      y.printErrStackTrace("MicroMsg.ShareCardLayoutDataParser", paramString, "", new Object[0]);
      return null;
    }
    LinkedList localLinkedList = new LinkedList();
    int i = 0;
    while (i < paramString.length())
    {
      localLinkedList.add(paramString.optString(i));
      i += 1;
    }
    return localLinkedList;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.mm.plugin.card.d.s
 * JD-Core Version:    0.7.0.1
 */