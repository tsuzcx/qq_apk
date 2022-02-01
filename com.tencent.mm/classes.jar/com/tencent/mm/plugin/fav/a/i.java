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
  public static List<a> AcM;
  private static String AcN = "";
  private static String AcO = "";
  private static long AcP = 0L;
  
  private static void a(String paramString1, long paramLong, int paramInt, String paramString2)
  {
    AppMethodBeat.i(103400);
    if (AcM == null)
    {
      AppMethodBeat.o(103400);
      return;
    }
    a locala = new a((byte)0);
    locala.hUf = paramString1;
    locala.AcQ = paramLong;
    locala.AcR = paramInt;
    if (Util.isNullOrNil(paramString2)) {}
    for (locala.zIC = "-1";; locala.zIC = paramString2)
    {
      if (AcM != null) {
        AcM.add(locala);
      }
      AppMethodBeat.o(103400);
      return;
    }
  }
  
  public static void aua(String paramString)
  {
    AppMethodBeat.i(103402);
    hC(paramString, "");
    AppMethodBeat.o(103402);
  }
  
  public static void aub(String paramString)
  {
    AppMethodBeat.i(103404);
    hD(paramString, "");
    AppMethodBeat.o(103404);
  }
  
  private static void dQv()
  {
    AcN = "";
    AcO = "";
    AcP = 0L;
  }
  
  public static void end()
  {
    AppMethodBeat.i(103399);
    if (AcM == null)
    {
      AcM = null;
      dQv();
      AppMethodBeat.o(103399);
      return;
    }
    Object localObject1 = new StringBuilder();
    ((StringBuilder)localObject1).append("[");
    Object localObject3 = AcM.iterator();
    for (;;)
    {
      if (((Iterator)localObject3).hasNext())
      {
        a locala = (a)((Iterator)localObject3).next();
        JSONObject localJSONObject = new JSONObject();
        try
        {
          localJSONObject.put("p", locala.hUf);
          localJSONObject.put("tbe", locala.AcQ);
          localJSONObject.put("in", locala.AcR);
          localJSONObject.put("sid", locala.zIC);
          ((StringBuilder)localObject1).append(localJSONObject.toString()).append(";");
          if (((StringBuilder)localObject1).length() > 3072)
          {
            AcM = null;
            dQv();
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
      AcM = null;
      dQv();
      AppMethodBeat.o(103399);
      return;
    }
    localObject3 = new String[3];
    int i = 0;
    while (i < 3)
    {
      localObject3[i] = "";
      i += 1;
    }
    for (;;)
    {
      if (i < 3) {}
      try
      {
        if (((String)localObject1).length() > 1024)
        {
          localObject3[i] = ((String)localObject1).substring(0, 1024);
          localObject1 = ((String)localObject1).substring(1024);
          i += 1;
          continue;
        }
        localObject3[i] = localObject1;
      }
      finally
      {
        for (;;)
        {
          Log.w("MicroMsg.Fav.FavSearchFlowReportLogic", "report flow error: " + localObject2.getMessage());
        }
      }
      h.OAn.b(15508, new Object[] { localObject3[0], localObject3[1], localObject3[2] });
      AcM = null;
      dQv();
      AppMethodBeat.o(103399);
      return;
      i = 0;
    }
  }
  
  public static void hC(String paramString1, String paramString2)
  {
    AppMethodBeat.i(103401);
    if (!Util.isNullOrNil(AcN)) {
      hD(AcN, AcO);
    }
    AcN = paramString1;
    AcO = paramString2;
    AcP = System.currentTimeMillis();
    AppMethodBeat.o(103401);
  }
  
  private static void hD(String paramString1, String paramString2)
  {
    AppMethodBeat.i(103403);
    if ((Util.isNullOrNil(paramString1)) || (!paramString1.equals(AcN)))
    {
      AppMethodBeat.o(103403);
      return;
    }
    int i = (int)(System.currentTimeMillis() - AcP);
    AcP /= 1000L;
    String str = paramString2;
    if (Util.isNullOrNil(paramString2)) {
      str = "-1";
    }
    a(paramString1, AcP, i, str);
    dQv();
    AppMethodBeat.o(103403);
  }
  
  public static void start()
  {
    AppMethodBeat.i(103398);
    AcM = new Vector();
    AppMethodBeat.o(103398);
  }
  
  static final class a
  {
    long AcQ;
    int AcR;
    String hUf;
    String zIC;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.plugin.fav.a.i
 * JD-Core Version:    0.7.0.1
 */