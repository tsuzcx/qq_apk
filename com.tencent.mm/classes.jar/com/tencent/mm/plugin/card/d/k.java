package com.tencent.mm.plugin.card.d;

import android.text.TextUtils;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.protocal.protobuf.ph;
import com.tencent.mm.sdk.platformtools.ab;
import java.util.LinkedList;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

public final class k
{
  public static LinkedList<ph> r(String paramString1, int paramInt, String paramString2)
  {
    AppMethodBeat.i(152201);
    if (TextUtils.isEmpty(paramString1))
    {
      ab.e("MicroMsg.CardListItemParser", "parseCardTpInfoItemArray jsonContent is null");
      AppMethodBeat.o(152201);
      return null;
    }
    try
    {
      JSONArray localJSONArray = new JSONArray(paramString1);
      if (localJSONArray.length() == 0)
      {
        ab.e("MicroMsg.CardListItemParser", "parseCardTpInfoItemArray cardItemListJson is null");
        AppMethodBeat.o(152201);
        return null;
      }
      LinkedList localLinkedList = new LinkedList();
      int i = 0;
      if (i < localJSONArray.length())
      {
        JSONObject localJSONObject = localJSONArray.optJSONObject(i);
        ph localph = new ph();
        if (paramInt == 26) {}
        for (paramString1 = "cardId";; paramString1 = "card_id")
        {
          localph.kml = localJSONObject.optString(paramString1);
          localph.code = localJSONObject.optString("code");
          localph.wGM = localJSONObject.optString("openCardParams");
          localph.cwc = paramString2;
          localLinkedList.add(localph);
          i += 1;
          break;
        }
      }
      AppMethodBeat.o(152201);
      return localLinkedList;
    }
    catch (JSONException paramString1)
    {
      ab.printErrStackTrace("MicroMsg.CardListItemParser", paramString1, "", new Object[0]);
      AppMethodBeat.o(152201);
    }
    return null;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes9.jar
 * Qualified Name:     com.tencent.mm.plugin.card.d.k
 * JD-Core Version:    0.7.0.1
 */