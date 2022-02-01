package com.tencent.mm.plugin.card.d;

import android.text.TextUtils;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.protocal.protobuf.us;
import com.tencent.mm.sdk.platformtools.Log;
import java.util.ArrayList;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

public final class u
{
  public static ArrayList<us> akq(String paramString)
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
          paramString = new us();
          paramString.name = localJSONObject.optString("name");
          paramString.descriptor = localJSONObject.optString("descriptor");
          paramString.pSm = localJSONObject.optString("phone");
          paramString.country = localJSONObject.optString("country");
          paramString.fuJ = localJSONObject.optString("province");
          paramString.fuK = localJSONObject.optString("city");
          paramString.iUO = localJSONObject.optString("address");
          paramString.DWG = ((float)localJSONObject.optDouble("distance"));
          paramString.dTj = ((float)localJSONObject.optDouble("longitude"));
          paramString.latitude = ((float)localJSONObject.optDouble("latitude"));
          paramString.pTL = localJSONObject.optString("jump_url");
          paramString.Leo = localJSONObject.optString("app_brand_user_name");
          paramString.Lep = localJSONObject.optString("app_brand_pass");
          continue;
        }
        AppMethodBeat.o(113878);
      }
      catch (JSONException paramString)
      {
        Log.printErrStackTrace("MicroMsg.ShopInfoItemParser", paramString, "", new Object[0]);
        AppMethodBeat.o(113878);
        return null;
      }
      return localArrayList;
      label282:
      i += 1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes8.jar
 * Qualified Name:     com.tencent.mm.plugin.card.d.u
 * JD-Core Version:    0.7.0.1
 */