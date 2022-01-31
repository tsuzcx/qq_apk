package com.tencent.mm.plugin.appbrand.jsapi.bio.soter;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.sdk.platformtools.ab;
import java.util.ArrayList;
import java.util.Collection;
import org.json.JSONArray;
import org.json.JSONException;

public final class a
{
  public static int BT(String paramString)
  {
    AppMethodBeat.i(3207);
    if ("fingerPrint".equals(paramString))
    {
      AppMethodBeat.o(3207);
      return 1;
    }
    if ("facial".equals(paramString))
    {
      AppMethodBeat.o(3207);
      return 8;
    }
    if ("speech".equals(paramString))
    {
      AppMethodBeat.o(3207);
      return 2;
    }
    ab.e("MicroMsg.AppBrandSoterTranslateUtil", "hy: invalid item");
    AppMethodBeat.o(3207);
    return 0;
  }
  
  public static String n(JSONArray paramJSONArray)
  {
    AppMethodBeat.i(3206);
    if (paramJSONArray == null) {}
    for (String str = null;; str = paramJSONArray.toString())
    {
      ab.i("MicroMsg.AppBrandSoterTranslateUtil", "hy: translating string array: %s", new Object[] { str });
      if ((paramJSONArray != null) && (paramJSONArray.length() != 0)) {
        break;
      }
      AppMethodBeat.o(3206);
      return "0x00";
    }
    int i = 0;
    int j = 0;
    for (;;)
    {
      if (i >= paramJSONArray.length()) {
        break label109;
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
    label109:
    paramJSONArray = "0x" + Integer.toHexString(j);
    ab.i("MicroMsg.AppBrandSoterTranslateUtil", "hy: translated bitsetStr: %s", new Object[] { paramJSONArray });
    AppMethodBeat.o(3206);
    return paramJSONArray;
  }
  
  public static JSONArray nS(int paramInt)
  {
    AppMethodBeat.i(3205);
    if (paramInt <= 0)
    {
      localObject = new JSONArray();
      AppMethodBeat.o(3205);
      return localObject;
    }
    Object localObject = new ArrayList(3);
    if ((paramInt & 0x1) == 1) {
      ((ArrayList)localObject).add("fingerPrint");
    }
    if ((paramInt & 0x8) == 8) {
      ((ArrayList)localObject).add("facial");
    }
    if ((paramInt & 0x2) == 2) {
      ((ArrayList)localObject).add("speech");
    }
    ab.i("MicroMsg.AppBrandSoterTranslateUtil", "hy: final string is: %s", new Object[] { ((ArrayList)localObject).toString() });
    localObject = new JSONArray((Collection)localObject);
    AppMethodBeat.o(3205);
    return localObject;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes9.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.jsapi.bio.soter.a
 * JD-Core Version:    0.7.0.1
 */