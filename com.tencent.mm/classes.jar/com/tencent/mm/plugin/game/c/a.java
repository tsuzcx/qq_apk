package com.tencent.mm.plugin.game.c;

import android.content.Context;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.game.report.api.b;
import com.tencent.mm.plugin.report.service.h;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.NetStatusUtil;
import com.tencent.mm.sdk.platformtools.Util;
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
  private static String CSj = "";
  
  public static String Md(String paramString)
  {
    AppMethodBeat.i(41852);
    if (Util.isNullOrNil(paramString))
    {
      AppMethodBeat.o(41852);
      return "";
    }
    try
    {
      paramString = URLEncoder.encode(paramString, "UTF-8");
      AppMethodBeat.o(41852);
      return paramString;
    }
    catch (Exception localException)
    {
      for (;;)
      {
        paramString = "";
        Log.e("MicroMsg.GameReportUtil", localException.getMessage());
      }
    }
  }
  
  public static void a(int paramInt1, int paramInt2, int paramInt3, long paramLong1, String paramString1, String paramString2, long paramLong2, long paramLong3)
  {
    AppMethodBeat.i(41850);
    paramString1 = b.d(14683, new Object[] { Integer.valueOf(paramInt1), Integer.valueOf(paramInt2), Integer.valueOf(paramInt3), Long.valueOf(paramLong1), paramString1, null, paramString2, Long.valueOf(paramLong2), Long.valueOf(paramLong3), null });
    com.tencent.mm.game.report.api.a.jTp.a(paramString1);
    AppMethodBeat.o(41850);
  }
  
  public static void aKk(String paramString)
  {
    CSj = paramString;
  }
  
  public static String am(String paramString1, String paramString2, String paramString3)
  {
    AppMethodBeat.i(41854);
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
        Log.e("MicroMsg.GameReportUtil", paramString2.getMessage());
        paramString2 = null;
      }
    }
    paramString3 = paramString1;
    if (paramString2 != null) {
      paramString3 = hW(paramString1, paramString2.toString());
    }
    paramString1 = Md(paramString3);
    AppMethodBeat.o(41854);
    return paramString1;
  }
  
  public static void b(Context paramContext, int paramInt1, int paramInt2, int paramInt3, String paramString1, int paramInt4, String paramString2)
  {
    AppMethodBeat.i(41849);
    Log.i("MicroMsg.GameReportUtil", "reportExposureInfo : " + paramInt1 + " , " + paramInt2 + " , " + paramInt3 + " , 1 , 0 , " + Util.nullAsNil(paramString1) + " , " + paramInt4 + " , 0 , " + Util.nullAsNil(null) + " , " + Util.nullAsNil(null) + " , " + Util.nullAsNil(paramString2));
    h localh = h.IzE;
    int j = Util.getInt(null, 0);
    int i;
    if (NetStatusUtil.is3G(paramContext)) {
      i = 4;
    }
    for (;;)
    {
      localh.a(13384, new Object[] { Integer.valueOf(paramInt1), Integer.valueOf(paramInt2), Integer.valueOf(paramInt3), Integer.valueOf(1), Integer.valueOf(0), paramString1, Integer.valueOf(paramInt4), Integer.valueOf(0), null, Integer.valueOf(j), Integer.valueOf(i), paramString2 });
      AppMethodBeat.o(41849);
      return;
      if (NetStatusUtil.is4G(paramContext)) {
        i = 5;
      } else {
        switch (NetStatusUtil.getNetType(paramContext))
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
  
  public static void bw(int paramInt, String paramString)
  {
    AppMethodBeat.i(41851);
    b localb = new b();
    localb.jTq = paramInt;
    localb.jTr = paramString;
    com.tencent.mm.game.report.api.a.jTp.a(localb);
    AppMethodBeat.o(41851);
  }
  
  private static String hW(String paramString1, String paramString2)
  {
    AppMethodBeat.i(41855);
    if (Util.isNullOrNil(paramString1))
    {
      AppMethodBeat.o(41855);
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
                AppMethodBeat.o(41855);
                return "";
              }
            }
          }
        }
        paramString1 = paramString2.toString();
      }
      catch (JSONException paramString1)
      {
        AppMethodBeat.o(41855);
        return "";
      }
      AppMethodBeat.o(41855);
      return paramString1;
    }
    catch (Exception paramString1)
    {
      for (;;)
      {
        paramString1 = localIterator;
      }
    }
  }
  
  public static String m(Map<String, String> paramMap)
  {
    AppMethodBeat.i(41853);
    if (paramMap.size() == 0)
    {
      AppMethodBeat.o(41853);
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
        Log.e("MicroMsg.GameReportUtil", paramMap.getMessage());
        AppMethodBeat.o(41853);
        return "";
      }
    }
    try
    {
      paramMap = URLEncoder.encode(localJSONObject.toString(), "UTF-8");
      AppMethodBeat.o(41853);
      return paramMap;
    }
    catch (Exception paramMap)
    {
      Log.e("MicroMsg.GameReportUtil", paramMap.getMessage());
      AppMethodBeat.o(41853);
    }
    return "";
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.plugin.game.c.a
 * JD-Core Version:    0.7.0.1
 */