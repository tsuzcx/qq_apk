package com.tencent.mm.plugin.game.e;

import android.content.Context;
import com.tencent.mm.game.report.a.a;
import com.tencent.mm.game.report.api.c;
import com.tencent.mm.game.report.api.d;
import com.tencent.mm.sdk.platformtools.bk;
import org.json.JSONException;
import org.json.JSONObject;

public final class b
{
  public static void a(Context paramContext, int paramInt1, int paramInt2, int paramInt3, int paramInt4, int paramInt5, String paramString)
  {
    a(paramContext, paramInt1, paramInt2, paramInt3, paramInt4, 0, null, paramInt5, 0, null, null, paramString);
  }
  
  public static void a(Context paramContext, int paramInt1, int paramInt2, int paramInt3, int paramInt4, int paramInt5, String paramString1, int paramInt6, int paramInt7, String paramString2, String paramString3, String paramString4)
  {
    paramContext = d.c(12909, new Object[] { Integer.valueOf(paramInt1), Integer.valueOf(paramInt2), Integer.valueOf(paramInt3), Integer.valueOf(paramInt4), Integer.valueOf(paramInt5), paramString1, Integer.valueOf(paramInt6), Integer.valueOf(paramInt7), paramString2, Integer.valueOf(bk.getInt(paramString3, 0)), Integer.valueOf(a.getNetworkType(paramContext)), paramString4 });
    c.dCx.a(paramContext);
  }
  
  public static void a(Context paramContext, int paramInt1, int paramInt2, int paramInt3, int paramInt4, String paramString1, int paramInt5, String paramString2)
  {
    a(paramContext, paramInt1, paramInt2, paramInt3, paramInt4, 0, paramString1, paramInt5, 0, null, null, paramString2);
  }
  
  public static void a(Context paramContext, int paramInt1, int paramInt2, int paramInt3, int paramInt4, String paramString1, int paramInt5, String paramString2, String paramString3)
  {
    a(paramContext, paramInt1, paramInt2, paramInt3, paramInt4, 0, paramString1, paramInt5, 0, null, paramString2, paramString3);
  }
  
  public static String dq(String paramString1, String paramString2)
  {
    if (paramString2 == null) {
      return null;
    }
    JSONObject localJSONObject = new JSONObject();
    try
    {
      localJSONObject.put("function_type", paramString1);
      localJSONObject.put("function_value", paramString2);
      label30:
      return a.fy(localJSONObject.toString());
    }
    catch (JSONException paramString1)
    {
      break label30;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.plugin.game.e.b
 * JD-Core Version:    0.7.0.1
 */