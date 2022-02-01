package com.tencent.mm.plugin.card.d;

import android.text.TextUtils;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.protocal.protobuf.tt;
import com.tencent.mm.sdk.platformtools.ad;
import java.util.LinkedList;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

public final class k
{
  public static LinkedList<tt> x(String paramString1, int paramInt, String paramString2)
  {
    AppMethodBeat.i(113810);
    if (TextUtils.isEmpty(paramString1))
    {
      ad.e("MicroMsg.CardTpInfoItemParser", "parseCardTpInfoItemArray jsonContent is null");
      AppMethodBeat.o(113810);
      return null;
    }
    for (;;)
    {
      LinkedList localLinkedList;
      int i;
      try
      {
        JSONArray localJSONArray = new JSONArray(paramString1);
        if (localJSONArray.length() == 0)
        {
          ad.e("MicroMsg.CardTpInfoItemParser", "parseCardTpInfoItemArray cardItemListJson is null");
          AppMethodBeat.o(113810);
          return null;
        }
        localLinkedList = new LinkedList();
        i = 0;
        if (i >= localJSONArray.length()) {
          break label237;
        }
        paramString1 = localJSONArray.optJSONObject(i);
        if (paramString1 != null) {
          break label245;
        }
        if (paramInt != 26) {
          break label248;
        }
        boolean bool = localJSONArray.opt(i) instanceof String;
        if (!bool) {
          break label248;
        }
        try
        {
          paramString1 = new JSONObject(localJSONArray.optString(i));
          tt localtt = new tt();
          if (paramInt == 26)
          {
            str = "cardId";
            localtt.oxM = paramString1.optString(str);
            localtt.code = paramString1.optString("code");
            localtt.FSl = paramString1.optString("openCardParams");
            localtt.duW = paramString2;
            localLinkedList.add(localtt);
          }
        }
        catch (JSONException paramString1)
        {
          ad.printErrStackTrace("MicroMsg.CardTpInfoItemParser", paramString1, "protect itemJSON for AppBrand", new Object[0]);
        }
        String str = "card_id";
      }
      catch (JSONException paramString1)
      {
        ad.printErrStackTrace("MicroMsg.CardTpInfoItemParser", paramString1, "", new Object[0]);
        AppMethodBeat.o(113810);
        return null;
      }
      continue;
      label237:
      AppMethodBeat.o(113810);
      return localLinkedList;
      label245:
      continue;
      label248:
      i += 1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.plugin.card.d.k
 * JD-Core Version:    0.7.0.1
 */