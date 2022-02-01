package com.tencent.mm.plugin.card.d;

import android.text.TextUtils;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.protocal.protobuf.rp;
import com.tencent.mm.sdk.platformtools.ad;
import java.util.LinkedList;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

public final class k
{
  public static LinkedList<rp> v(String paramString1, int paramInt, String paramString2)
  {
    AppMethodBeat.i(113810);
    if (TextUtils.isEmpty(paramString1))
    {
      ad.e("MicroMsg.CardListItemParser", "parseCardTpInfoItemArray jsonContent is null");
      AppMethodBeat.o(113810);
      return null;
    }
    try
    {
      JSONArray localJSONArray = new JSONArray(paramString1);
      if (localJSONArray.length() == 0)
      {
        ad.e("MicroMsg.CardListItemParser", "parseCardTpInfoItemArray cardItemListJson is null");
        AppMethodBeat.o(113810);
        return null;
      }
      LinkedList localLinkedList = new LinkedList();
      int i = 0;
      if (i < localJSONArray.length())
      {
        JSONObject localJSONObject = localJSONArray.optJSONObject(i);
        rp localrp = new rp();
        if (paramInt == 26) {}
        for (paramString1 = "cardId";; paramString1 = "card_id")
        {
          localrp.nrr = localJSONObject.optString(paramString1);
          localrp.code = localJSONObject.optString("code");
          localrp.CSr = localJSONObject.optString("openCardParams");
          localrp.dlB = paramString2;
          localLinkedList.add(localrp);
          i += 1;
          break;
        }
      }
      AppMethodBeat.o(113810);
      return localLinkedList;
    }
    catch (JSONException paramString1)
    {
      ad.printErrStackTrace("MicroMsg.CardListItemParser", paramString1, "", new Object[0]);
      AppMethodBeat.o(113810);
    }
    return null;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.plugin.card.d.k
 * JD-Core Version:    0.7.0.1
 */