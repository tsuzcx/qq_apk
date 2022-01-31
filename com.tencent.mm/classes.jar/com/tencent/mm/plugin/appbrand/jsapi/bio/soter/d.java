package com.tencent.mm.plugin.appbrand.jsapi.bio.soter;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.sdk.platformtools.ab;
import org.json.JSONArray;
import org.json.JSONException;

public final class d
{
  public static int BT(String paramString)
  {
    AppMethodBeat.i(73796);
    if ("fingerPrint".equals(paramString))
    {
      AppMethodBeat.o(73796);
      return 1;
    }
    if ("facial".equals(paramString))
    {
      AppMethodBeat.o(73796);
      return 8;
    }
    if ("speech".equals(paramString))
    {
      AppMethodBeat.o(73796);
      return 2;
    }
    ab.e("MicroMsg.AppBrandSoterTranslateUtil", "hy: invalid item");
    AppMethodBeat.o(73796);
    return 0;
  }
  
  public static String n(JSONArray paramJSONArray)
  {
    AppMethodBeat.i(73795);
    if (paramJSONArray == null) {}
    for (String str = null;; str = paramJSONArray.toString())
    {
      ab.i("MicroMsg.AppBrandSoterTranslateUtil", "hy: translating string array: %s", new Object[] { str });
      if ((paramJSONArray != null) && (paramJSONArray.length() != 0)) {
        break;
      }
      AppMethodBeat.o(73795);
      return "0x00";
    }
    int i = 0;
    int j = 0;
    for (;;)
    {
      if (i >= paramJSONArray.length()) {
        break label107;
      }
      try
      {
        int k = BT(paramJSONArray.getString(i));
        j = (byte)(j | k);
      }
      catch (JSONException localJSONException)
      {
        for (;;)
        {
          ab.printErrStackTrace("MicroMsg.AppBrandSoterTranslateUtil", localJSONException, "hy: json error in translate", new Object[0]);
        }
      }
      i += 1;
    }
    label107:
    paramJSONArray = "0x" + Integer.toHexString(j);
    ab.i("MicroMsg.AppBrandSoterTranslateUtil", "hy: translated bitsetStr: %s", new Object[] { paramJSONArray });
    AppMethodBeat.o(73795);
    return paramJSONArray;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.jsapi.bio.soter.d
 * JD-Core Version:    0.7.0.1
 */