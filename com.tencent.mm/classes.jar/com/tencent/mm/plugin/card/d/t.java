package com.tencent.mm.plugin.card.d;

import android.text.TextUtils;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.protocal.protobuf.oz;
import com.tencent.mm.sdk.platformtools.ab;
import java.util.ArrayList;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

public final class t
{
  public static ArrayList<oz> IN(String paramString)
  {
    AppMethodBeat.i(88950);
    if (TextUtils.isEmpty(paramString))
    {
      AppMethodBeat.o(88950);
      return null;
    }
    for (;;)
    {
      int i;
      ArrayList localArrayList;
      try
      {
        JSONArray localJSONArray = new JSONObject(paramString).getJSONArray("used_store_list");
        if (localJSONArray != null)
        {
          i = localJSONArray.length();
          if (i != 0) {}
        }
        else
        {
          AppMethodBeat.o(88950);
          return null;
        }
        localArrayList = new ArrayList();
        i = 0;
        if (i < localJSONArray.length())
        {
          JSONObject localJSONObject = localJSONArray.getJSONObject(i);
          if (localJSONObject == null)
          {
            paramString = null;
            if (paramString == null) {
              break label282;
            }
            localArrayList.add(paramString);
            break label282;
          }
          paramString = new oz();
          paramString.name = localJSONObject.optString("name");
          paramString.descriptor = localJSONObject.optString("descriptor");
          paramString.kmA = localJSONObject.optString("phone");
          paramString.country = localJSONObject.optString("country");
          paramString.province = localJSONObject.optString("province");
          paramString.city = localJSONObject.optString("city");
          paramString.fBq = localJSONObject.optString("address");
          paramString.rqZ = ((float)localJSONObject.optDouble("distance"));
          paramString.cAH = ((float)localJSONObject.optDouble("longitude"));
          paramString.cyV = ((float)localJSONObject.optDouble("latitude"));
          paramString.knV = localJSONObject.optString("jump_url");
          paramString.wFL = localJSONObject.optString("app_brand_user_name");
          paramString.wFM = localJSONObject.optString("app_brand_pass");
          continue;
        }
        AppMethodBeat.o(88950);
      }
      catch (JSONException paramString)
      {
        ab.printErrStackTrace("MicroMsg.ShopInfoItemParser", paramString, "", new Object[0]);
        AppMethodBeat.o(88950);
        return null;
      }
      return localArrayList;
      label282:
      i += 1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes8.jar
 * Qualified Name:     com.tencent.mm.plugin.card.d.t
 * JD-Core Version:    0.7.0.1
 */