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
  public static List<a> wGD;
  private static String wGE = "";
  private static String wGF = "";
  private static long wGG = 0L;
  
  private static void a(String paramString1, long paramLong, int paramInt, String paramString2)
  {
    AppMethodBeat.i(103400);
    if (wGD == null)
    {
      AppMethodBeat.o(103400);
      return;
    }
    a locala = new a((byte)0);
    locala.pageId = paramString1;
    locala.wGH = paramLong;
    locala.wGI = paramInt;
    if (Util.isNullOrNil(paramString2)) {}
    for (locala.wmA = "-1";; locala.wmA = paramString2)
    {
      if (wGD != null) {
        wGD.add(locala);
      }
      AppMethodBeat.o(103400);
      return;
    }
  }
  
  public static void azU(String paramString)
  {
    AppMethodBeat.i(103402);
    gT(paramString, "");
    AppMethodBeat.o(103402);
  }
  
  public static void azV(String paramString)
  {
    AppMethodBeat.i(103404);
    gU(paramString, "");
    AppMethodBeat.o(103404);
  }
  
  private static void djK()
  {
    wGE = "";
    wGF = "";
    wGG = 0L;
  }
  
  public static void end()
  {
    AppMethodBeat.i(103399);
    if (wGD == null)
    {
      wGD = null;
      djK();
      AppMethodBeat.o(103399);
      return;
    }
    Object localObject1 = new StringBuilder();
    ((StringBuilder)localObject1).append("[");
    Object localObject2 = wGD.iterator();
    for (;;)
    {
      if (((Iterator)localObject2).hasNext())
      {
        a locala = (a)((Iterator)localObject2).next();
        JSONObject localJSONObject = new JSONObject();
        try
        {
          localJSONObject.put("p", locala.pageId);
          localJSONObject.put("tbe", locala.wGH);
          localJSONObject.put("in", locala.wGI);
          localJSONObject.put("sid", locala.wmA);
          ((StringBuilder)localObject1).append(localJSONObject.toString()).append(";");
          if (((StringBuilder)localObject1).length() > 3072)
          {
            wGD = null;
            djK();
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
      wGD = null;
      djK();
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
      h.IzE.a(15508, new Object[] { localObject2[0], localObject2[1], localObject2[2] });
      wGD = null;
      djK();
      AppMethodBeat.o(103399);
      return;
      i = 0;
    }
  }
  
  public static void gT(String paramString1, String paramString2)
  {
    AppMethodBeat.i(103401);
    if (!Util.isNullOrNil(wGE)) {
      gU(wGE, wGF);
    }
    wGE = paramString1;
    wGF = paramString2;
    wGG = System.currentTimeMillis();
    AppMethodBeat.o(103401);
  }
  
  private static void gU(String paramString1, String paramString2)
  {
    AppMethodBeat.i(103403);
    if ((Util.isNullOrNil(paramString1)) || (!paramString1.equals(wGE)))
    {
      AppMethodBeat.o(103403);
      return;
    }
    int i = (int)(System.currentTimeMillis() - wGG);
    wGG /= 1000L;
    String str = paramString2;
    if (Util.isNullOrNil(paramString2)) {
      str = "-1";
    }
    a(paramString1, wGG, i, str);
    djK();
    AppMethodBeat.o(103403);
  }
  
  public static void start()
  {
    AppMethodBeat.i(103398);
    wGD = new Vector();
    AppMethodBeat.o(103398);
  }
  
  static final class a
  {
    String pageId;
    long wGH;
    int wGI;
    String wmA;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.plugin.fav.a.i
 * JD-Core Version:    0.7.0.1
 */