package com.tencent.mm.plugin.card.d;

import android.text.TextUtils;
import com.tencent.mm.protocal.c.mh;
import com.tencent.mm.sdk.platformtools.y;
import java.util.LinkedList;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

public final class k
{
  public static LinkedList<mh> bp(String paramString, int paramInt)
  {
    if (TextUtils.isEmpty(paramString))
    {
      y.e("MicroMsg.CardListItemParser", "parseCardTpInfoItemArray jsonContent is null");
      return null;
    }
    JSONArray localJSONArray;
    try
    {
      localJSONArray = new JSONArray(paramString);
      if (localJSONArray.length() == 0)
      {
        y.e("MicroMsg.CardListItemParser", "parseCardTpInfoItemArray cardItemListJson is null");
        return null;
      }
    }
    catch (JSONException paramString)
    {
      y.printErrStackTrace("MicroMsg.CardListItemParser", paramString, "", new Object[0]);
      return null;
    }
    LinkedList localLinkedList = new LinkedList();
    int i = 0;
    if (i < localJSONArray.length())
    {
      JSONObject localJSONObject = localJSONArray.optJSONObject(i);
      mh localmh = new mh();
      if (paramInt == 26) {}
      for (paramString = "cardId";; paramString = "card_id")
      {
        localmh.iln = localJSONObject.optString(paramString);
        localmh.code = localJSONObject.optString("code");
        localmh.sJd = localJSONObject.optString("openCardParams");
        localLinkedList.add(localmh);
        i += 1;
        break;
      }
    }
    return localLinkedList;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes9.jar
 * Qualified Name:     com.tencent.mm.plugin.card.d.k
 * JD-Core Version:    0.7.0.1
 */