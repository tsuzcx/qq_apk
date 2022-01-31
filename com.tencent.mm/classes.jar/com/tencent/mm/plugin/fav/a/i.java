package com.tencent.mm.plugin.fav.a;

import com.tencent.mm.plugin.report.service.h;
import com.tencent.mm.sdk.platformtools.bk;
import com.tencent.mm.sdk.platformtools.y;
import java.util.Iterator;
import java.util.List;
import java.util.Vector;
import org.json.JSONException;
import org.json.JSONObject;

public final class i
{
  public static List<i.a> jYV;
  private static String jYW = "";
  private static String jYX = "";
  private static long jYY = 0L;
  
  public static void CG(String paramString)
  {
    da(paramString, "");
  }
  
  public static void CH(String paramString)
  {
    db(paramString, "");
  }
  
  private static void aQg()
  {
    jYW = "";
    jYX = "";
    jYY = 0L;
  }
  
  public static void da(String paramString1, String paramString2)
  {
    if (!bk.bl(jYW)) {
      db(jYW, jYX);
    }
    jYW = paramString1;
    jYX = paramString2;
    jYY = System.currentTimeMillis();
  }
  
  private static void db(String paramString1, String paramString2)
  {
    if ((bk.bl(paramString1)) || (!paramString1.equals(jYW))) {
      return;
    }
    int i = (int)(System.currentTimeMillis() - jYY);
    jYY /= 1000L;
    String str = paramString2;
    if (bk.bl(paramString2)) {
      str = "-1";
    }
    long l = jYY;
    if (jYV != null)
    {
      paramString2 = new i.a((byte)0);
      paramString2.bUo = paramString1;
      paramString2.jYZ = l;
      paramString2.in = i;
      if (!bk.bl(str)) {
        break label119;
      }
    }
    label119:
    for (paramString2.sid = "-1";; paramString2.sid = str)
    {
      if (jYV != null) {
        jYV.add(paramString2);
      }
      aQg();
      return;
    }
  }
  
  public static void end()
  {
    if (jYV == null)
    {
      jYV = null;
      aQg();
      return;
    }
    Object localObject1 = new StringBuilder();
    ((StringBuilder)localObject1).append("[");
    Object localObject2 = jYV.iterator();
    for (;;)
    {
      if (((Iterator)localObject2).hasNext())
      {
        i.a locala = (i.a)((Iterator)localObject2).next();
        JSONObject localJSONObject = new JSONObject();
        try
        {
          localJSONObject.put("p", locala.bUo);
          localJSONObject.put("tbe", locala.jYZ);
          localJSONObject.put("in", locala.in);
          localJSONObject.put("sid", locala.sid);
          ((StringBuilder)localObject1).append(localJSONObject.toString()).append(";");
          if (((StringBuilder)localObject1).length() > 3072)
          {
            jYV = null;
            aQg();
            return;
          }
        }
        catch (JSONException localJSONException)
        {
          for (;;)
          {
            y.w("MicroMsg.Fav.FavSearchFlowReportLogic", "end, JSONException");
          }
        }
      }
    }
    ((StringBuilder)localObject1).append("]");
    localObject1 = ((StringBuilder)localObject1).toString();
    if (((String)localObject1).length() > 3072)
    {
      jYV = null;
      aQg();
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
          y.w("MicroMsg.Fav.FavSearchFlowReportLogic", "report flow error: " + localThrowable.getMessage());
        }
      }
      h.nFQ.f(15508, new Object[] { localObject2[0], localObject2[1], localObject2[2] });
      jYV = null;
      aQg();
      return;
      i = 0;
    }
  }
  
  public static void start()
  {
    jYV = new Vector();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.plugin.fav.a.i
 * JD-Core Version:    0.7.0.1
 */