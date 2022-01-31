package com.tencent.mm.plugin.game.e;

import android.content.Context;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.game.report.api.b;
import com.tencent.mm.plugin.report.service.h;
import com.tencent.mm.sdk.platformtools.ab;
import com.tencent.mm.sdk.platformtools.at;
import com.tencent.mm.sdk.platformtools.bo;
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
  private static String nuE = "";
  
  public static void Qo(String paramString)
  {
    nuE = paramString;
  }
  
  public static String V(String paramString1, String paramString2, String paramString3)
  {
    AppMethodBeat.i(111689);
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
        ab.e("MicroMsg.GameReportUtil", paramString2.getMessage());
        paramString2 = null;
      }
    }
    paramString3 = paramString1;
    if (paramString2 != null) {
      paramString3 = eH(paramString1, paramString2.toString());
    }
    paramString1 = lR(paramString3);
    AppMethodBeat.o(111689);
    return paramString1;
  }
  
  public static void a(int paramInt1, int paramInt2, int paramInt3, long paramLong1, String paramString1, String paramString2, long paramLong2, long paramLong3)
  {
    AppMethodBeat.i(111685);
    paramString1 = b.b(14683, new Object[] { Integer.valueOf(paramInt1), Integer.valueOf(paramInt2), Integer.valueOf(paramInt3), Long.valueOf(paramLong1), paramString1, null, paramString2, Long.valueOf(paramLong2), Long.valueOf(paramLong3), null });
    com.tencent.mm.game.report.api.a.ezM.a(paramString1);
    AppMethodBeat.o(111685);
  }
  
  public static void a(Context paramContext, int paramInt1, int paramInt2, int paramInt3, String paramString1, int paramInt4, String paramString2)
  {
    AppMethodBeat.i(111684);
    ab.i("MicroMsg.GameReportUtil", "reportExposureInfo : " + paramInt1 + " , " + paramInt2 + " , " + paramInt3 + " , 1 , 0 , " + bo.nullAsNil(paramString1) + " , " + paramInt4 + " , 0 , " + bo.nullAsNil(null) + " , " + bo.nullAsNil(null) + " , " + bo.nullAsNil(paramString2));
    h localh = h.qsU;
    int j = bo.getInt(null, 0);
    int i;
    if (at.is3G(paramContext)) {
      i = 4;
    }
    for (;;)
    {
      localh.e(13384, new Object[] { Integer.valueOf(paramInt1), Integer.valueOf(paramInt2), Integer.valueOf(paramInt3), Integer.valueOf(1), Integer.valueOf(0), paramString1, Integer.valueOf(paramInt4), Integer.valueOf(0), null, Integer.valueOf(j), Integer.valueOf(i), paramString2 });
      AppMethodBeat.o(111684);
      return;
      if (at.is4G(paramContext)) {
        i = 5;
      } else {
        switch (at.getNetType(paramContext))
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
  
  public static void aL(int paramInt, String paramString)
  {
    AppMethodBeat.i(111686);
    b localb = new b();
    localb.ezN = paramInt;
    localb.ezO = paramString;
    com.tencent.mm.game.report.api.a.ezM.a(localb);
    AppMethodBeat.o(111686);
  }
  
  private static String eH(String paramString1, String paramString2)
  {
    AppMethodBeat.i(111690);
    if (bo.isNullOrNil(paramString1))
    {
      AppMethodBeat.o(111690);
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
                AppMethodBeat.o(111690);
                return "";
              }
            }
          }
        }
        paramString1 = paramString2.toString();
      }
      catch (JSONException paramString1)
      {
        AppMethodBeat.o(111690);
        return "";
      }
      AppMethodBeat.o(111690);
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
  
  public static String h(Map<String, String> paramMap)
  {
    AppMethodBeat.i(111688);
    if (paramMap.size() == 0)
    {
      AppMethodBeat.o(111688);
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
        ab.e("MicroMsg.GameReportUtil", paramMap.getMessage());
        AppMethodBeat.o(111688);
        return "";
      }
    }
    try
    {
      paramMap = URLEncoder.encode(localJSONObject.toString(), "UTF-8");
      AppMethodBeat.o(111688);
      return paramMap;
    }
    catch (Exception paramMap)
    {
      ab.e("MicroMsg.GameReportUtil", paramMap.getMessage());
      AppMethodBeat.o(111688);
    }
    return "";
  }
  
  public static String lR(String paramString)
  {
    AppMethodBeat.i(111687);
    if (bo.isNullOrNil(paramString))
    {
      AppMethodBeat.o(111687);
      return "";
    }
    try
    {
      paramString = URLEncoder.encode(paramString, "UTF-8");
      AppMethodBeat.o(111687);
      return paramString;
    }
    catch (Exception localException)
    {
      for (;;)
      {
        paramString = "";
        ab.e("MicroMsg.GameReportUtil", localException.getMessage());
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.plugin.game.e.a
 * JD-Core Version:    0.7.0.1
 */