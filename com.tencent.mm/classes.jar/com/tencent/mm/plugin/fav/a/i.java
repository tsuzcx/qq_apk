package com.tencent.mm.plugin.fav.a;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.report.service.h;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.Util;
import java.util.Iterator;
import java.util.List;
import java.util.Vector;
import org.json.JSONException;
import org.json.JSONObject;

public final class i
{
  private static String taA = "";
  private static String taB = "";
  private static long taC = 0L;
  public static List<a> taz;
  
  private static void a(String paramString1, long paramLong, int paramInt, String paramString2)
  {
    AppMethodBeat.i(103400);
    if (taz == null)
    {
      AppMethodBeat.o(103400);
      return;
    }
    a locala = new a((byte)0);
    locala.pageId = paramString1;
    locala.taD = paramLong;
    locala.in = paramInt;
    if (Util.isNullOrNil(paramString2)) {}
    for (locala.sGF = "-1";; locala.sGF = paramString2)
    {
      if (taz != null) {
        taz.add(locala);
      }
      AppMethodBeat.o(103400);
      return;
    }
  }
  
  public static void arT(String paramString)
  {
    AppMethodBeat.i(103402);
    gF(paramString, "");
    AppMethodBeat.o(103402);
  }
  
  public static void arU(String paramString)
  {
    AppMethodBeat.i(103404);
    gG(paramString, "");
    AppMethodBeat.o(103404);
  }
  
  private static void cUE()
  {
    taA = "";
    taB = "";
    taC = 0L;
  }
  
  public static void end()
  {
    AppMethodBeat.i(103399);
    if (taz == null)
    {
      taz = null;
      cUE();
      AppMethodBeat.o(103399);
      return;
    }
    Object localObject1 = new StringBuilder();
    ((StringBuilder)localObject1).append("[");
    Object localObject2 = taz.iterator();
    for (;;)
    {
      if (((Iterator)localObject2).hasNext())
      {
        a locala = (a)((Iterator)localObject2).next();
        JSONObject localJSONObject = new JSONObject();
        try
        {
          localJSONObject.put("p", locala.pageId);
          localJSONObject.put("tbe", locala.taD);
          localJSONObject.put("in", locala.in);
          localJSONObject.put("sid", locala.sGF);
          ((StringBuilder)localObject1).append(localJSONObject.toString()).append(";");
          if (((StringBuilder)localObject1).length() > 3072)
          {
            taz = null;
            cUE();
            AppMethodBeat.o(103399);
            return;
          }
        }
        catch (JSONException localJSONException)
        {
          for (;;)
          {
            Log.w("MicroMsg.Fav.FavSearchFlowReportLogic", "end, JSONException");
          }
        }
      }
    }
    ((StringBuilder)localObject1).append("]");
    localObject1 = ((StringBuilder)localObject1).toString();
    if (((String)localObject1).length() > 3072)
    {
      taz = null;
      cUE();
      AppMethodBeat.o(103399);
      return;
    }
    localObject2 = new String[3];
    int i = 0;
    while (i < 3)
    {
      localObject2[i] = "";
      i += 1;
    }
    for (;;)
    {
      if (i < 3) {}
      try
      {
        if (((String)localObject1).length() > 1024)
        {
          localObject2[i] = ((String)localObject1).substring(0, 1024);
          localObject1 = ((String)localObject1).substring(1024);
          i += 1;
          continue;
        }
        localObject2[i] = localObject1;
      }
      catch (Throwable localThrowable)
      {
        for (;;)
        {
          Log.w("MicroMsg.Fav.FavSearchFlowReportLogic", "report flow error: " + localThrowable.getMessage());
        }
      }
      h.CyF.a(15508, new Object[] { localObject2[0], localObject2[1], localObject2[2] });
      taz = null;
      cUE();
      AppMethodBeat.o(103399);
      return;
      i = 0;
    }
  }
  
  public static void gF(String paramString1, String paramString2)
  {
    AppMethodBeat.i(103401);
    if (!Util.isNullOrNil(taA)) {
      gG(taA, taB);
    }
    taA = paramString1;
    taB = paramString2;
    taC = System.currentTimeMillis();
    AppMethodBeat.o(103401);
  }
  
  private static void gG(String paramString1, String paramString2)
  {
    AppMethodBeat.i(103403);
    if ((Util.isNullOrNil(paramString1)) || (!paramString1.equals(taA)))
    {
      AppMethodBeat.o(103403);
      return;
    }
    int i = (int)(System.currentTimeMillis() - taC);
    taC /= 1000L;
    String str = paramString2;
    if (Util.isNullOrNil(paramString2)) {
      str = "-1";
    }
    a(paramString1, taC, i, str);
    cUE();
    AppMethodBeat.o(103403);
  }
  
  public static void start()
  {
    AppMethodBeat.i(103398);
    taz = new Vector();
    AppMethodBeat.o(103398);
  }
  
  static final class a
  {
    int in;
    String pageId;
    String sGF;
    long taD;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.plugin.fav.a.i
 * JD-Core Version:    0.7.0.1
 */