package com.tencent.mm.plugin.card.d;

import android.text.TextUtils;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.protocal.protobuf.tl;
import com.tencent.mm.sdk.platformtools.ad;
import java.util.ArrayList;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

public final class u
{
  public static ArrayList<tl> Zt(String paramString)
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
          paramString = new tl();
          paramString.name = localJSONObject.optString("name");
          paramString.descriptor = localJSONObject.optString("descriptor");
          paramString.oyb = localJSONObject.optString("phone");
          paramString.country = localJSONObject.optString("country");
          paramString.ePu = localJSONObject.optString("province");
          paramString.ePv = localJSONObject.optString("city");
          paramString.hWY = localJSONObject.optString("address");
          paramString.zxp = ((float)localJSONObject.optDouble("distance"));
          paramString.dAp = ((float)localJSONObject.optDouble("longitude"));
          paramString.dyz = ((float)localJSONObject.optDouble("latitude"));
          paramString.ozD = localJSONObject.optString("jump_url");
          paramString.FRk = localJSONObject.optString("app_brand_user_name");
          paramString.FRl = localJSONObject.optString("app_brand_pass");
          continue;
        }
        AppMethodBeat.o(113878);
      }
      catch (JSONException paramString)
      {
        ad.printErrStackTrace("MicroMsg.ShopInfoItemParser", paramString, "", new Object[0]);
        AppMethodBeat.o(113878);
        return null;
      }
      return localArrayList;
      label282:
      i += 1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.mm.plugin.card.d.u
 * JD-Core Version:    0.7.0.1
 */