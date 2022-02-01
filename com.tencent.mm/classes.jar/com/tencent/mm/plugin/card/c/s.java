package com.tencent.mm.plugin.card.c;

import android.text.TextUtils;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.card.sharecard.model.j;
import com.tencent.mm.plugin.card.sharecard.model.q;
import com.tencent.mm.sdk.platformtools.Log;
import java.util.ArrayList;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

public final class s
{
  public static j alD(String paramString)
  {
    AppMethodBeat.i(113874);
    Log.i("MicroMsg.ShareCardConsumedInfoParser", "parseShareCardConsumedInfoParser()");
    if (TextUtils.isEmpty(paramString))
    {
      Log.e("MicroMsg.ShareCardConsumedInfoParser", "parseShareCardConsumedInfoParser json is empty");
      AppMethodBeat.o(113874);
      return null;
    }
    try
    {
      Object localObject = new JSONObject(paramString);
      paramString = new j();
      paramString.wwv = ((JSONObject)localObject).optString("consumed_box_id");
      paramString.www = ((JSONObject)localObject).optString("subscribe_wording");
      paramString.wwx = ((JSONObject)localObject).optString("subscribe_app_username");
      localObject = ((JSONObject)localObject).optJSONArray("list");
      if ((localObject == null) || (((JSONArray)localObject).length() == 0))
      {
        Log.e("MicroMsg.ShareCardConsumedInfoParser", "parseShareCardConsumedInfoParser cardItemListJson is null");
        AppMethodBeat.o(113874);
        return null;
      }
      ArrayList localArrayList = new ArrayList();
      int i = 0;
      while (i < ((JSONArray)localObject).length())
      {
        JSONObject localJSONObject = ((JSONArray)localObject).optJSONObject(i);
        q localq = new q();
        localq.iaJ = localJSONObject.optString("card_ext");
        localq.wtH = f.aN(localJSONObject.optJSONObject("card_tp_info"));
        localArrayList.add(localq);
        i += 1;
      }
      paramString.hqL = localArrayList;
      Log.i("MicroMsg.ShareCardConsumedInfoParser", "parseShareCardConsumedInfoParser() tempList size is" + localArrayList.size());
      if (TextUtils.isEmpty(paramString.wwv)) {
        Log.i("MicroMsg.ShareCardConsumedInfoParser", "parseShareCardConsumedInfoParser()  consumed_box_id is empty");
      }
      if (TextUtils.isEmpty(paramString.www)) {
        Log.i("MicroMsg.ShareCardConsumedInfoParser", "parseShareCardConsumedInfoParser()  subscribe_wording is empty");
      }
      AppMethodBeat.o(113874);
      return paramString;
    }
    catch (JSONException paramString)
    {
      Log.e("MicroMsg.ShareCardConsumedInfoParser", "parseShareCardConsumedInfoParser exception:" + paramString.getMessage());
      Log.printErrStackTrace("MicroMsg.ShareCardConsumedInfoParser", paramString, "", new Object[0]);
      AppMethodBeat.o(113874);
    }
    return null;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes10.jar
 * Qualified Name:     com.tencent.mm.plugin.card.c.s
 * JD-Core Version:    0.7.0.1
 */