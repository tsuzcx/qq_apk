package com.tencent.mm.plugin.fav.a;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.report.service.g;
import com.tencent.mm.sdk.platformtools.ae;
import com.tencent.mm.sdk.platformtools.bu;
import java.util.Iterator;
import java.util.List;
import java.util.Vector;
import org.json.JSONException;
import org.json.JSONObject;

public final class i
{
  public static List<a> rAU;
  private static String rAV = "";
  private static String rAW = "";
  private static long rAX = 0L;
  
  private static void a(String paramString1, long paramLong, int paramInt, String paramString2)
  {
    AppMethodBeat.i(103400);
    if (rAU == null)
    {
      AppMethodBeat.o(103400);
      return;
    }
    a locala = new a((byte)0);
    locala.pageId = paramString1;
    locala.rAY = paramLong;
    locala.in = paramInt;
    if (bu.isNullOrNil(paramString2)) {}
    for (locala.rfp = "-1";; locala.rfp = paramString2)
    {
      if (rAU != null) {
        rAU.add(locala);
      }
      AppMethodBeat.o(103400);
      return;
    }
  }
  
  public static void ahl(String paramString)
  {
    AppMethodBeat.i(103402);
    gn(paramString, "");
    AppMethodBeat.o(103402);
  }
  
  public static void ahm(String paramString)
  {
    AppMethodBeat.i(103404);
    go(paramString, "");
    AppMethodBeat.o(103404);
  }
  
  private static void cwA()
  {
    rAV = "";
    rAW = "";
    rAX = 0L;
  }
  
  public static void end()
  {
    AppMethodBeat.i(103399);
    if (rAU == null)
    {
      rAU = null;
      cwA();
      AppMethodBeat.o(103399);
      return;
    }
    Object localObject1 = new StringBuilder();
    ((StringBuilder)localObject1).append("[");
    Object localObject2 = rAU.iterator();
    for (;;)
    {
      if (((Iterator)localObject2).hasNext())
      {
        a locala = (a)((Iterator)localObject2).next();
        JSONObject localJSONObject = new JSONObject();
        try
        {
          localJSONObject.put("p", locala.pageId);
          localJSONObject.put("tbe", locala.rAY);
          localJSONObject.put("in", locala.in);
          localJSONObject.put("sid", locala.rfp);
          ((StringBuilder)localObject1).append(localJSONObject.toString()).append(";");
          if (((StringBuilder)localObject1).length() > 3072)
          {
            rAU = null;
            cwA();
            AppMethodBeat.o(103399);
            return;
          }
        }
        catch (JSONException localJSONException)
        {
          for (;;)
          {
            ae.w("MicroMsg.Fav.FavSearchFlowReportLogic", "end, JSONException");
          }
        }
      }
    }
    ((StringBuilder)localObject1).append("]");
    localObject1 = ((StringBuilder)localObject1).toString();
    if (((String)localObject1).length() > 3072)
    {
      rAU = null;
      cwA();
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
          ae.w("MicroMsg.Fav.FavSearchFlowReportLogic", "report flow error: " + localThrowable.getMessage());
        }
      }
      g.yxI.f(15508, new Object[] { localObject2[0], localObject2[1], localObject2[2] });
      rAU = null;
      cwA();
      AppMethodBeat.o(103399);
      return;
      i = 0;
    }
  }
  
  public static void gn(String paramString1, String paramString2)
  {
    AppMethodBeat.i(103401);
    if (!bu.isNullOrNil(rAV)) {
      go(rAV, rAW);
    }
    rAV = paramString1;
    rAW = paramString2;
    rAX = System.currentTimeMillis();
    AppMethodBeat.o(103401);
  }
  
  private static void go(String paramString1, String paramString2)
  {
    AppMethodBeat.i(103403);
    if ((bu.isNullOrNil(paramString1)) || (!paramString1.equals(rAV)))
    {
      AppMethodBeat.o(103403);
      return;
    }
    int i = (int)(System.currentTimeMillis() - rAX);
    rAX /= 1000L;
    String str = paramString2;
    if (bu.isNullOrNil(paramString2)) {
      str = "-1";
    }
    a(paramString1, rAX, i, str);
    cwA();
    AppMethodBeat.o(103403);
  }
  
  public static void start()
  {
    AppMethodBeat.i(103398);
    rAU = new Vector();
    AppMethodBeat.o(103398);
  }
  
  static final class a
  {
    int in;
    String pageId;
    long rAY;
    String rfp;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.plugin.fav.a.i
 * JD-Core Version:    0.7.0.1
 */