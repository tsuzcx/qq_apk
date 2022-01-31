package com.tencent.mm.plugin.appbrand.jsapi.bio.soter;

import com.tencent.mm.sdk.platformtools.y;
import java.util.ArrayList;
import org.json.JSONArray;
import org.json.JSONException;

public final class a
{
  public static String k(JSONArray paramJSONArray)
  {
    if (paramJSONArray == null) {}
    for (String str = null;; str = paramJSONArray.toString())
    {
      y.i("MicroMsg.AppBrandSoterTranslateUtil", "hy: translating string array: %s", new Object[] { str });
      if ((paramJSONArray != null) && (paramJSONArray.length() != 0)) {
        break;
      }
      return "0x00";
    }
    int i = 0;
    int j = 0;
    for (;;)
    {
      if (i >= paramJSONArray.length()) {
        break label97;
      }
      try
      {
        int k = tU(paramJSONArray.getString(i));
        j = (byte)(j | k);
      }
      catch (JSONException localJSONException)
      {
        for (;;)
        {
          y.printErrStackTrace("MicroMsg.AppBrandSoterTranslateUtil", localJSONException, "hy: json error in translate", new Object[0]);
        }
      }
      i += 1;
    }
    label97:
    paramJSONArray = "0x" + Integer.toHexString(j);
    y.i("MicroMsg.AppBrandSoterTranslateUtil", "hy: translated bitsetStr: %s", new Object[] { paramJSONArray });
    return paramJSONArray;
  }
  
  public static JSONArray lj(int paramInt)
  {
    if (paramInt <= 0) {
      return new JSONArray();
    }
    ArrayList localArrayList = new ArrayList(3);
    if ((paramInt & 0x1) == 1) {
      localArrayList.add("fingerPrint");
    }
    if ((paramInt & 0x8) == 8) {
      localArrayList.add("facial");
    }
    if ((paramInt & 0x2) == 2) {
      localArrayList.add("speech");
    }
    y.i("MicroMsg.AppBrandSoterTranslateUtil", "hy: final string is: %s", new Object[] { localArrayList.toString() });
    return new JSONArray(localArrayList);
  }
  
  public static int tU(String paramString)
  {
    if ("fingerPrint".equals(paramString)) {
      return 1;
    }
    if ("facial".equals(paramString)) {
      return 8;
    }
    if ("speech".equals(paramString)) {
      return 2;
    }
    y.e("MicroMsg.AppBrandSoterTranslateUtil", "hy: invalid item");
    return 0;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes9.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.jsapi.bio.soter.a
 * JD-Core Version:    0.7.0.1
 */