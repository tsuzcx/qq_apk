package com.tencent.mm.game.report;

import android.content.Context;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.game.report.api.b;
import com.tencent.mm.sdk.platformtools.bo;
import org.json.JSONException;
import org.json.JSONObject;

public final class c
{
  public static String S(String paramString1, String paramString2)
  {
    AppMethodBeat.i(140316);
    if (paramString2 == null)
    {
      AppMethodBeat.o(140316);
      return null;
    }
    JSONObject localJSONObject = new JSONObject();
    try
    {
      localJSONObject.put("function_type", paramString1);
      localJSONObject.put("function_value", paramString2);
      label40:
      paramString1 = com.tencent.mm.game.report.c.a.lR(localJSONObject.toString());
      AppMethodBeat.o(140316);
      return paramString1;
    }
    catch (JSONException paramString1)
    {
      break label40;
    }
  }
  
  public static void a(Context paramContext, int paramInt1, int paramInt2, int paramInt3, int paramInt4, int paramInt5, String paramString)
  {
    AppMethodBeat.i(140312);
    a(paramContext, paramInt1, paramInt2, paramInt3, paramInt4, 0, null, paramInt5, 0, null, null, paramString);
    AppMethodBeat.o(140312);
  }
  
  public static void a(Context paramContext, int paramInt1, int paramInt2, int paramInt3, int paramInt4, int paramInt5, String paramString1, int paramInt6, int paramInt7, String paramString2, String paramString3, String paramString4)
  {
    AppMethodBeat.i(140315);
    paramContext = b.b(12909, new Object[] { Integer.valueOf(paramInt1), Integer.valueOf(paramInt2), Integer.valueOf(paramInt3), Integer.valueOf(paramInt4), Integer.valueOf(paramInt5), paramString1, Integer.valueOf(paramInt6), Integer.valueOf(paramInt7), paramString2, Integer.valueOf(bo.getInt(paramString3, 0)), Integer.valueOf(com.tencent.mm.game.report.c.a.getNetworkType(paramContext)), paramString4 });
    com.tencent.mm.game.report.api.a.ezM.a(paramContext);
    AppMethodBeat.o(140315);
  }
  
  public static void a(Context paramContext, int paramInt1, int paramInt2, int paramInt3, int paramInt4, String paramString1, int paramInt5, String paramString2)
  {
    AppMethodBeat.i(140313);
    a(paramContext, paramInt1, paramInt2, paramInt3, paramInt4, 0, paramString1, paramInt5, 0, null, null, paramString2);
    AppMethodBeat.o(140313);
  }
  
  public static void a(Context paramContext, int paramInt1, int paramInt2, int paramInt3, int paramInt4, String paramString1, int paramInt5, String paramString2, String paramString3)
  {
    AppMethodBeat.i(140314);
    a(paramContext, paramInt1, paramInt2, paramInt3, paramInt4, 0, paramString1, paramInt5, 0, null, paramString2, paramString3);
    AppMethodBeat.o(140314);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.game.report.c
 * JD-Core Version:    0.7.0.1
 */