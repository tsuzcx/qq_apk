package com.tencent.mm.game.report;

import android.content.Context;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.game.report.api.b;
import com.tencent.mm.sdk.platformtools.Util;
import java.util.Iterator;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Set;
import org.json.JSONException;
import org.json.JSONObject;

public final class g
{
  public static String a(String paramString1, String paramString2, String paramString3, Map paramMap)
  {
    AppMethodBeat.i(108265);
    if ((Util.isNullOrNil(paramString1)) && (Util.isNullOrNil(paramString2)) && (Util.isNullOrNil(paramString3)) && (paramMap == null))
    {
      AppMethodBeat.o(108265);
      return null;
    }
    JSONObject localJSONObject = new JSONObject();
    try
    {
      if (!Util.isNullOrNil(paramString1)) {
        localJSONObject.put("function_type", paramString1);
      }
      if (!Util.isNullOrNil(paramString2)) {
        localJSONObject.put("function_value", paramString2);
      }
      if (!Util.isNullOrNil(paramString3)) {
        localJSONObject.put("ext_data", paramString3);
      }
      if (paramMap != null)
      {
        paramString1 = paramMap.entrySet().iterator();
        for (;;)
        {
          if (paramString1.hasNext())
          {
            paramString2 = (Map.Entry)paramString1.next();
            try
            {
              localJSONObject.put((String)paramString2.getKey(), paramString2.getValue());
            }
            catch (Exception paramString1)
            {
              AppMethodBeat.o(108265);
              return "";
            }
          }
        }
      }
      return paramString1;
    }
    catch (JSONException paramString1)
    {
      paramString1 = com.tencent.mm.game.report.e.a.EM(localJSONObject.toString());
      AppMethodBeat.o(108265);
    }
  }
  
  public static void a(Context paramContext, int paramInt1, int paramInt2, int paramInt3, int paramInt4, int paramInt5, String paramString)
  {
    AppMethodBeat.i(108260);
    a(paramContext, paramInt1, paramInt2, paramInt3, paramInt4, 0, null, paramInt5, 0, null, null, paramString);
    AppMethodBeat.o(108260);
  }
  
  public static void a(Context paramContext, int paramInt1, int paramInt2, int paramInt3, int paramInt4, int paramInt5, String paramString1, int paramInt6, int paramInt7, String paramString2, String paramString3, String paramString4)
  {
    AppMethodBeat.i(108263);
    a(paramContext, paramInt1, paramInt2, paramInt3, paramInt4, paramInt5, paramString1, paramInt6, paramInt7, paramString2, paramString3, paramString4, 0L, 0L, 0L);
    AppMethodBeat.o(108263);
  }
  
  public static void a(Context paramContext, int paramInt1, int paramInt2, int paramInt3, int paramInt4, int paramInt5, String paramString1, int paramInt6, int paramInt7, String paramString2, String paramString3, String paramString4, long paramLong1, long paramLong2, long paramLong3)
  {
    AppMethodBeat.i(240732);
    paramContext = b.e(12909, new Object[] { Integer.valueOf(paramInt1), Integer.valueOf(paramInt2), Integer.valueOf(paramInt3), Integer.valueOf(paramInt4), Integer.valueOf(paramInt5), paramString1, Integer.valueOf(paramInt6), Integer.valueOf(paramInt7), paramString2, Integer.valueOf(Util.getInt(paramString3, 0)), Integer.valueOf(com.tencent.mm.game.report.e.a.dt(paramContext)), paramString4, "", "", Long.valueOf(paramLong1), Long.valueOf(paramLong2), Long.valueOf(paramLong3) });
    com.tencent.mm.game.report.api.a.mtH.a(paramContext);
    AppMethodBeat.o(240732);
  }
  
  public static void a(Context paramContext, int paramInt1, int paramInt2, int paramInt3, int paramInt4, String paramString1, int paramInt5, String paramString2)
  {
    AppMethodBeat.i(108261);
    a(paramContext, paramInt1, paramInt2, paramInt3, paramInt4, 0, paramString1, paramInt5, 0, null, null, paramString2);
    AppMethodBeat.o(108261);
  }
  
  public static void a(Context paramContext, int paramInt1, int paramInt2, int paramInt3, int paramInt4, String paramString1, int paramInt5, String paramString2, String paramString3)
  {
    AppMethodBeat.i(108262);
    a(paramContext, paramInt1, paramInt2, paramInt3, paramInt4, 0, paramString1, paramInt5, 0, null, paramString2, paramString3);
    AppMethodBeat.o(108262);
  }
  
  public static String aB(String paramString1, String paramString2)
  {
    AppMethodBeat.i(108264);
    JSONObject localJSONObject = new JSONObject();
    try
    {
      localJSONObject.put("function_type", paramString1);
      localJSONObject.put("function_value", paramString2);
      label29:
      paramString1 = com.tencent.mm.game.report.e.a.EM(localJSONObject.toString());
      AppMethodBeat.o(108264);
      return paramString1;
    }
    catch (JSONException paramString1)
    {
      break label29;
    }
  }
  
  public static String aC(String paramString1, String paramString2)
  {
    AppMethodBeat.i(108266);
    JSONObject localJSONObject = new JSONObject();
    try
    {
      localJSONObject.put(paramString1, paramString2);
      label20:
      paramString1 = com.tencent.mm.game.report.e.a.EM(localJSONObject.toString());
      AppMethodBeat.o(108266);
      return paramString1;
    }
    catch (JSONException paramString1)
    {
      break label20;
    }
  }
  
  public static String s(Map paramMap)
  {
    AppMethodBeat.i(184813);
    if (paramMap == null)
    {
      AppMethodBeat.o(184813);
      return null;
    }
    JSONObject localJSONObject = new JSONObject();
    paramMap = paramMap.entrySet().iterator();
    while (paramMap.hasNext())
    {
      Map.Entry localEntry = (Map.Entry)paramMap.next();
      try
      {
        localJSONObject.put((String)localEntry.getKey(), localEntry.getValue());
      }
      catch (Exception paramMap)
      {
        AppMethodBeat.o(184813);
        return "";
      }
    }
    paramMap = com.tencent.mm.game.report.e.a.EM(localJSONObject.toString());
    AppMethodBeat.o(184813);
    return paramMap;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.game.report.g
 * JD-Core Version:    0.7.0.1
 */