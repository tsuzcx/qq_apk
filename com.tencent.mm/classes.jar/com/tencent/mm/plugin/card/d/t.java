package com.tencent.mm.plugin.card.d;

import android.text.TextUtils;
import com.tencent.mm.protocal.c.mb;
import com.tencent.mm.sdk.platformtools.y;
import java.util.ArrayList;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

public final class t
{
  public static ArrayList<mb> ze(String paramString)
  {
    if (TextUtils.isEmpty(paramString)) {
      return null;
    }
    for (;;)
    {
      int i;
      try
      {
        JSONArray localJSONArray = new JSONObject(paramString).getJSONArray("used_store_list");
        if ((localJSONArray == null) || (localJSONArray.length() == 0)) {
          break;
        }
        ArrayList localArrayList = new ArrayList();
        i = 0;
        if (i < localJSONArray.length())
        {
          JSONObject localJSONObject = localJSONArray.getJSONObject(i);
          if (localJSONObject == null)
          {
            paramString = null;
            if (paramString != null) {
              localArrayList.add(paramString);
            }
          }
          else
          {
            paramString = new mb();
            paramString.name = localJSONObject.optString("name");
            paramString.descriptor = localJSONObject.optString("descriptor");
            paramString.ilD = localJSONObject.optString("phone");
            paramString.country = localJSONObject.optString("country");
            paramString.cCA = localJSONObject.optString("province");
            paramString.cCB = localJSONObject.optString("city");
            paramString.ekZ = localJSONObject.optString("address");
            paramString.sIe = ((float)localJSONObject.optDouble("distance"));
            paramString.bTc = ((float)localJSONObject.optDouble("longitude"));
            paramString.bRt = ((float)localJSONObject.optDouble("latitude"));
            paramString.ina = localJSONObject.optString("jump_url");
            paramString.sIf = localJSONObject.optString("app_brand_user_name");
            paramString.sIg = localJSONObject.optString("app_brand_pass");
            continue;
          }
        }
        else
        {
          return localArrayList;
        }
      }
      catch (JSONException paramString)
      {
        y.printErrStackTrace("MicroMsg.ShopInfoItemParser", paramString, "", new Object[0]);
        return null;
      }
      i += 1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes9.jar
 * Qualified Name:     com.tencent.mm.plugin.card.d.t
 * JD-Core Version:    0.7.0.1
 */