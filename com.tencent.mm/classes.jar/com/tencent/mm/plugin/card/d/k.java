package com.tencent.mm.plugin.card.d;

import android.text.TextUtils;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.protocal.protobuf.rz;
import com.tencent.mm.sdk.platformtools.ac;
import java.util.LinkedList;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

public final class k
{
  public static LinkedList<rz> v(String paramString1, int paramInt, String paramString2)
  {
    AppMethodBeat.i(113810);
    if (TextUtils.isEmpty(paramString1))
    {
      ac.e("MicroMsg.CardListItemParser", "parseCardTpInfoItemArray jsonContent is null");
      AppMethodBeat.o(113810);
      return null;
    }
    try
    {
      JSONArray localJSONArray = new JSONArray(paramString1);
      if (localJSONArray.length() == 0)
      {
        ac.e("MicroMsg.CardListItemParser", "parseCardTpInfoItemArray cardItemListJson is null");
        AppMethodBeat.o(113810);
        return null;
      }
      LinkedList localLinkedList = new LinkedList();
      int i = 0;
      if (i < localJSONArray.length())
      {
        JSONObject localJSONObject = localJSONArray.optJSONObject(i);
        rz localrz = new rz();
        if (paramInt == 26) {}
        for (paramString1 = "cardId";; paramString1 = "card_id")
        {
          localrz.nUr = localJSONObject.optString(paramString1);
          localrz.code = localJSONObject.optString("code");
          localrz.Elc = localJSONObject.optString("openCardParams");
          localrz.djj = paramString2;
          localLinkedList.add(localrz);
          i += 1;
          break;
        }
      }
      AppMethodBeat.o(113810);
      return localLinkedList;
    }
    catch (JSONException paramString1)
    {
      ac.printErrStackTrace("MicroMsg.CardListItemParser", paramString1, "", new Object[0]);
      AppMethodBeat.o(113810);
    }
    return null;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.plugin.card.d.k
 * JD-Core Version:    0.7.0.1
 */