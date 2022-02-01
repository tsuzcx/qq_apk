package com.tencent.mm.plugin.card.d;

import android.text.TextUtils;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.card.sharecard.model.j;
import com.tencent.mm.plugin.card.sharecard.model.q;
import com.tencent.mm.sdk.platformtools.ad;
import java.util.ArrayList;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

public final class s
{
  public static j Zp(String paramString)
  {
    AppMethodBeat.i(113874);
    ad.i("MicroMsg.ShareCardConsumedInfoParser", "parseShareCardConsumedInfoParser()");
    if (TextUtils.isEmpty(paramString))
    {
      ad.e("MicroMsg.ShareCardConsumedInfoParser", "parseShareCardConsumedInfoParser json is empty");
      AppMethodBeat.o(113874);
      return null;
    }
    try
    {
      Object localObject = new JSONObject(paramString);
      paramString = new j();
      paramString.oBG = ((JSONObject)localObject).optString("consumed_box_id");
      paramString.oBH = ((JSONObject)localObject).optString("subscribe_wording");
      paramString.oBI = ((JSONObject)localObject).optString("subscribe_app_username");
      localObject = ((JSONObject)localObject).optJSONArray("list");
      if ((localObject == null) || (((JSONArray)localObject).length() == 0))
      {
        ad.e("MicroMsg.ShareCardConsumedInfoParser", "parseShareCardConsumedInfoParser cardItemListJson is null");
        AppMethodBeat.o(113874);
        return null;
      }
      ArrayList localArrayList = new ArrayList();
      int i = 0;
      while (i < ((JSONArray)localObject).length())
      {
        JSONObject localJSONObject = ((JSONArray)localObject).optJSONObject(i);
        q localq = new q();
        localq.dHY = localJSONObject.optString("card_ext");
        localq.oyX = f.ag(localJSONObject.optJSONObject("card_tp_info"));
        localArrayList.add(localq);
        i += 1;
      }
      paramString.dbZ = localArrayList;
      ad.i("MicroMsg.ShareCardConsumedInfoParser", "parseShareCardConsumedInfoParser() tempList size is" + localArrayList.size());
      if (TextUtils.isEmpty(paramString.oBG)) {
        ad.i("MicroMsg.ShareCardConsumedInfoParser", "parseShareCardConsumedInfoParser()  consumed_box_id is empty");
      }
      if (TextUtils.isEmpty(paramString.oBH)) {
        ad.i("MicroMsg.ShareCardConsumedInfoParser", "parseShareCardConsumedInfoParser()  subscribe_wording is empty");
      }
      AppMethodBeat.o(113874);
      return paramString;
    }
    catch (JSONException paramString)
    {
      ad.e("MicroMsg.ShareCardConsumedInfoParser", "parseShareCardConsumedInfoParser exception:" + paramString.getMessage());
      ad.printErrStackTrace("MicroMsg.ShareCardConsumedInfoParser", paramString, "", new Object[0]);
      AppMethodBeat.o(113874);
    }
    return null;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.plugin.card.d.s
 * JD-Core Version:    0.7.0.1
 */