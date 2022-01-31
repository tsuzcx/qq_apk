package com.tencent.mm.plugin.game.e;

import android.content.Context;
import com.tencent.mm.game.report.api.c;
import com.tencent.mm.game.report.api.d;
import com.tencent.mm.plugin.report.service.h;
import com.tencent.mm.sdk.platformtools.aq;
import com.tencent.mm.sdk.platformtools.bk;
import com.tencent.mm.sdk.platformtools.y;
import java.net.URLEncoder;
import java.util.Iterator;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Set;
import org.json.JSONException;
import org.json.JSONObject;

@Deprecated
public final class a
{
  private static String kWC = "";
  
  public static String B(Map<String, String> paramMap)
  {
    if (paramMap.size() == 0) {
      return "";
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
        y.e("MicroMsg.GameReportUtil", paramMap.getMessage());
        return "";
      }
    }
    try
    {
      paramMap = URLEncoder.encode(localJSONObject.toString(), "UTF-8");
      return paramMap;
    }
    catch (Exception paramMap)
    {
      y.e("MicroMsg.GameReportUtil", paramMap.getMessage());
    }
    return "";
  }
  
  public static void EW(String paramString)
  {
    kWC = paramString;
  }
  
  public static String O(String paramString1, String paramString2, String paramString3)
  {
    JSONObject localJSONObject = new JSONObject();
    try
    {
      localJSONObject.put(paramString2, paramString3);
      paramString2 = localJSONObject;
    }
    catch (Exception paramString2)
    {
      for (;;)
      {
        y.e("MicroMsg.GameReportUtil", paramString2.getMessage());
        paramString2 = null;
      }
    }
    paramString3 = paramString1;
    if (paramString2 != null) {
      paramString3 = dp(paramString1, paramString2.toString());
    }
    return fy(paramString3);
  }
  
  public static void a(int paramInt1, int paramInt2, int paramInt3, long paramLong1, String paramString1, String paramString2, long paramLong2, long paramLong3)
  {
    paramString1 = d.c(14683, new Object[] { Integer.valueOf(paramInt1), Integer.valueOf(paramInt2), Integer.valueOf(paramInt3), Long.valueOf(paramLong1), paramString1, null, paramString2, Long.valueOf(paramLong2), Long.valueOf(paramLong3), null });
    c.dCx.a(paramString1);
  }
  
  public static void a(Context paramContext, int paramInt1, int paramInt2, int paramInt3, String paramString1, int paramInt4, String paramString2)
  {
    y.i("MicroMsg.GameReportUtil", "reportExposureInfo : " + paramInt1 + " , " + paramInt2 + " , " + paramInt3 + " , 1 , 0 , " + bk.pm(paramString1) + " , " + paramInt4 + " , 0 , " + bk.pm(null) + " , " + bk.pm(null) + " , " + bk.pm(paramString2));
    h localh = h.nFQ;
    int j = bk.getInt(null, 0);
    int i;
    if (aq.is3G(paramContext)) {
      i = 4;
    }
    for (;;)
    {
      localh.f(13384, new Object[] { Integer.valueOf(paramInt1), Integer.valueOf(paramInt2), Integer.valueOf(paramInt3), Integer.valueOf(1), Integer.valueOf(0), paramString1, Integer.valueOf(paramInt4), Integer.valueOf(0), null, Integer.valueOf(j), Integer.valueOf(i), paramString2 });
      return;
      if (aq.is4G(paramContext)) {
        i = 5;
      } else {
        switch (aq.getNetType(paramContext))
        {
        case 1: 
        case 2: 
        case 3: 
        case 4: 
        default: 
          i = 6;
          break;
        case -1: 
          i = 255;
          break;
        case 0: 
          i = 1;
          break;
        case 5: 
          i = 2;
          break;
        case 6: 
          i = 3;
        }
      }
    }
  }
  
  public static void ar(int paramInt, String paramString)
  {
    d locald = new d();
    locald.dCy = paramInt;
    locald.dCz = paramString;
    c.dCx.a(locald);
  }
  
  private static String dp(String paramString1, String paramString2)
  {
    if (bk.bl(paramString1)) {
      return paramString2;
    }
    Iterator localIterator = null;
    try
    {
      paramString1 = new JSONObject(paramString1);
      try
      {
        paramString2 = new JSONObject(paramString2);
        if (paramString1 != null)
        {
          localIterator = paramString1.keys();
          for (;;)
          {
            if (localIterator.hasNext()) {
              try
              {
                String str = (String)localIterator.next();
                paramString2.put(str, paramString1.opt(str));
              }
              catch (Exception paramString1)
              {
                return "";
              }
            }
          }
        }
        return paramString2.toString();
      }
      catch (JSONException paramString1)
      {
        return "";
      }
    }
    catch (Exception paramString1)
    {
      for (;;)
      {
        paramString1 = localIterator;
      }
    }
  }
  
  public static String fy(String paramString)
  {
    if (bk.bl(paramString)) {
      return "";
    }
    try
    {
      paramString = URLEncoder.encode(paramString, "UTF-8");
      return paramString;
    }
    catch (Exception paramString)
    {
      y.e("MicroMsg.GameReportUtil", paramString.getMessage());
    }
    return "";
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.plugin.game.e.a
 * JD-Core Version:    0.7.0.1
 */