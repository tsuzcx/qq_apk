package com.tencent.mm.plugin.card.d;

import android.text.TextUtils;
import com.tencent.mm.plugin.card.sharecard.model.j;
import com.tencent.mm.plugin.card.sharecard.model.q;
import com.tencent.mm.sdk.platformtools.y;
import java.util.ArrayList;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

public final class r
{
  public static j za(String paramString)
  {
    y.i("MicroMsg.ShareCardConsumedInfoParser", "parseShareCardConsumedInfoParser()");
    if (TextUtils.isEmpty(paramString))
    {
      y.e("MicroMsg.ShareCardConsumedInfoParser", "parseShareCardConsumedInfoParser json is empty");
      return null;
    }
    Object localObject;
    try
    {
      localObject = new JSONObject(paramString);
      paramString = new j();
      paramString.ioL = ((JSONObject)localObject).optString("consumed_box_id");
      paramString.ioM = ((JSONObject)localObject).optString("subscribe_wording");
      paramString.ioN = ((JSONObject)localObject).optString("subscribe_app_username");
      localObject = ((JSONObject)localObject).optJSONArray("list");
      if ((localObject == null) || (((JSONArray)localObject).length() == 0))
      {
        y.e("MicroMsg.ShareCardConsumedInfoParser", "parseShareCardConsumedInfoParser cardItemListJson is null");
        return null;
      }
    }
    catch (JSONException paramString)
    {
      y.e("MicroMsg.ShareCardConsumedInfoParser", "parseShareCardConsumedInfoParser exception:" + paramString.getMessage());
      y.printErrStackTrace("MicroMsg.ShareCardConsumedInfoParser", paramString, "", new Object[0]);
      return null;
    }
    ArrayList localArrayList = new ArrayList();
    int i = 0;
    while (i < ((JSONArray)localObject).length())
    {
      JSONObject localJSONObject = ((JSONArray)localObject).optJSONObject(i);
      q localq = new q();
      localq.bZd = localJSONObject.optString("card_ext");
      localq.ims = f.H(localJSONObject.optJSONObject("card_tp_info"));
      localArrayList.add(localq);
      i += 1;
    }
    paramString.ioK = localArrayList;
    y.i("MicroMsg.ShareCardConsumedInfoParser", "parseShareCardConsumedInfoParser() tempList size is" + localArrayList.size());
    if (TextUtils.isEmpty(paramString.ioL)) {
      y.i("MicroMsg.ShareCardConsumedInfoParser", "parseShareCardConsumedInfoParser()  consumed_box_id is empty");
    }
    if (TextUtils.isEmpty(paramString.ioM)) {
      y.i("MicroMsg.ShareCardConsumedInfoParser", "parseShareCardConsumedInfoParser()  subscribe_wording is empty");
    }
    return paramString;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.plugin.card.d.r
 * JD-Core Version:    0.7.0.1
 */