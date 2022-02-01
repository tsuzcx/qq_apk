package com.tencent.mm.plugin.fav.a;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.report.service.h;
import com.tencent.mm.sdk.platformtools.ad;
import com.tencent.mm.sdk.platformtools.bt;
import java.util.Iterator;
import java.util.List;
import java.util.Vector;
import org.json.JSONException;
import org.json.JSONObject;

public final class i
{
  public static List<a> qaa;
  private static String qab = "";
  private static String qac = "";
  private static long qad = 0L;
  
  public static void Yd(String paramString)
  {
    AppMethodBeat.i(103402);
    fM(paramString, "");
    AppMethodBeat.o(103402);
  }
  
  public static void Ye(String paramString)
  {
    AppMethodBeat.i(103404);
    fN(paramString, "");
    AppMethodBeat.o(103404);
  }
  
  private static void a(String paramString1, long paramLong, int paramInt, String paramString2)
  {
    AppMethodBeat.i(103400);
    if (qaa == null)
    {
      AppMethodBeat.o(103400);
      return;
    }
    a locala = new a((byte)0);
    locala.pageId = paramString1;
    locala.qae = paramLong;
    locala.in = paramInt;
    if (bt.isNullOrNil(paramString2)) {}
    for (locala.pZX = "-1";; locala.pZX = paramString2)
    {
      if (qaa != null) {
        qaa.add(locala);
      }
      AppMethodBeat.o(103400);
      return;
    }
  }
  
  private static void chN()
  {
    qab = "";
    qac = "";
    qad = 0L;
  }
  
  public static void end()
  {
    AppMethodBeat.i(103399);
    if (qaa == null)
    {
      qaa = null;
      chN();
      AppMethodBeat.o(103399);
      return;
    }
    Object localObject1 = new StringBuilder();
    ((StringBuilder)localObject1).append("[");
    Object localObject2 = qaa.iterator();
    for (;;)
    {
      if (((Iterator)localObject2).hasNext())
      {
        a locala = (a)((Iterator)localObject2).next();
        JSONObject localJSONObject = new JSONObject();
        try
        {
          localJSONObject.put("p", locala.pageId);
          localJSONObject.put("tbe", locala.qae);
          localJSONObject.put("in", locala.in);
          localJSONObject.put("sid", locala.pZX);
          ((StringBuilder)localObject1).append(localJSONObject.toString()).append(";");
          if (((StringBuilder)localObject1).length() > 3072)
          {
            qaa = null;
            chN();
            AppMethodBeat.o(103399);
            return;
          }
        }
        catch (JSONException localJSONException)
        {
          for (;;)
          {
            ad.w("MicroMsg.Fav.FavSearchFlowReportLogic", "end, JSONException");
          }
        }
      }
    }
    ((StringBuilder)localObject1).append("]");
    localObject1 = ((StringBuilder)localObject1).toString();
    if (((String)localObject1).length() > 3072)
    {
      qaa = null;
      chN();
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
          ad.w("MicroMsg.Fav.FavSearchFlowReportLogic", "report flow error: " + localThrowable.getMessage());
        }
      }
      h.vKh.f(15508, new Object[] { localObject2[0], localObject2[1], localObject2[2] });
      qaa = null;
      chN();
      AppMethodBeat.o(103399);
      return;
      i = 0;
    }
  }
  
  public static void fM(String paramString1, String paramString2)
  {
    AppMethodBeat.i(103401);
    if (!bt.isNullOrNil(qab)) {
      fN(qab, qac);
    }
    qab = paramString1;
    qac = paramString2;
    qad = System.currentTimeMillis();
    AppMethodBeat.o(103401);
  }
  
  private static void fN(String paramString1, String paramString2)
  {
    AppMethodBeat.i(103403);
    if ((bt.isNullOrNil(paramString1)) || (!paramString1.equals(qab)))
    {
      AppMethodBeat.o(103403);
      return;
    }
    int i = (int)(System.currentTimeMillis() - qad);
    qad /= 1000L;
    String str = paramString2;
    if (bt.isNullOrNil(paramString2)) {
      str = "-1";
    }
    a(paramString1, qad, i, str);
    chN();
    AppMethodBeat.o(103403);
  }
  
  public static void start()
  {
    AppMethodBeat.i(103398);
    qaa = new Vector();
    AppMethodBeat.o(103398);
  }
  
  static final class a
  {
    int in;
    String pZX;
    String pageId;
    long qae;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.plugin.fav.a.i
 * JD-Core Version:    0.7.0.1
 */