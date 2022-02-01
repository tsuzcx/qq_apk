package com.tencent.mm.plugin.card.d;

import android.text.TextUtils;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.protocal.protobuf.rr;
import com.tencent.mm.sdk.platformtools.ac;
import java.util.ArrayList;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

public final class u
{
  public static ArrayList<rr> VK(String paramString)
  {
    AppMethodBeat.i(113878);
    if (TextUtils.isEmpty(paramString))
    {
      AppMethodBeat.o(113878);
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
          AppMethodBeat.o(113878);
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
          paramString = new rr();
          paramString.name = localJSONObject.optString("name");
          paramString.descriptor = localJSONObject.optString("descriptor");
          paramString.nUG = localJSONObject.optString("phone");
          paramString.country = localJSONObject.optString("country");
          paramString.exV = localJSONObject.optString("province");
          paramString.exW = localJSONObject.optString("city");
          paramString.hEt = localJSONObject.optString("address");
          paramString.yhi = ((float)localJSONObject.optDouble("distance"));
          paramString.doB = ((float)localJSONObject.optDouble("longitude"));
          paramString.dmL = ((float)localJSONObject.optDouble("latitude"));
          paramString.nWj = localJSONObject.optString("jump_url");
          paramString.Ekb = localJSONObject.optString("app_brand_user_name");
          paramString.Ekc = localJSONObject.optString("app_brand_pass");
          continue;
        }
        AppMethodBeat.o(113878);
      }
      catch (JSONException paramString)
      {
        ac.printErrStackTrace("MicroMsg.ShopInfoItemParser", paramString, "", new Object[0]);
        AppMethodBeat.o(113878);
        return null;
      }
      return localArrayList;
      label282:
      i += 1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.plugin.card.d.u
 * JD-Core Version:    0.7.0.1
 */