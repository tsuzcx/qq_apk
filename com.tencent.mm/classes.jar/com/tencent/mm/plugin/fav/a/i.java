package com.tencent.mm.plugin.fav.a;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.report.service.h;
import com.tencent.mm.sdk.platformtools.ab;
import com.tencent.mm.sdk.platformtools.bo;
import java.util.Iterator;
import java.util.List;
import java.util.Vector;
import org.json.JSONException;
import org.json.JSONObject;

public final class i
{
  public static List<i.a> mtn;
  private static String mto = "";
  private static String mtp = "";
  private static long mtq = 0L;
  
  public static void NI(String paramString)
  {
    AppMethodBeat.i(102662);
    ep(paramString, "");
    AppMethodBeat.o(102662);
  }
  
  public static void NJ(String paramString)
  {
    AppMethodBeat.i(102664);
    eq(paramString, "");
    AppMethodBeat.o(102664);
  }
  
  private static void a(String paramString1, long paramLong, int paramInt, String paramString2)
  {
    AppMethodBeat.i(102660);
    if (mtn == null)
    {
      AppMethodBeat.o(102660);
      return;
    }
    i.a locala = new i.a((byte)0);
    locala.pageId = paramString1;
    locala.mtr = paramLong;
    locala.in = paramInt;
    if (bo.isNullOrNil(paramString2)) {}
    for (locala.sid = "-1";; locala.sid = paramString2)
    {
      if (mtn != null) {
        mtn.add(locala);
      }
      AppMethodBeat.o(102660);
      return;
    }
  }
  
  private static void bwv()
  {
    mto = "";
    mtp = "";
    mtq = 0L;
  }
  
  public static void end()
  {
    AppMethodBeat.i(102659);
    if (mtn == null)
    {
      mtn = null;
      bwv();
      AppMethodBeat.o(102659);
      return;
    }
    Object localObject1 = new StringBuilder();
    ((StringBuilder)localObject1).append("[");
    Object localObject2 = mtn.iterator();
    for (;;)
    {
      if (((Iterator)localObject2).hasNext())
      {
        i.a locala = (i.a)((Iterator)localObject2).next();
        JSONObject localJSONObject = new JSONObject();
        try
        {
          localJSONObject.put("p", locala.pageId);
          localJSONObject.put("tbe", locala.mtr);
          localJSONObject.put("in", locala.in);
          localJSONObject.put("sid", locala.sid);
          ((StringBuilder)localObject1).append(localJSONObject.toString()).append(";");
          if (((StringBuilder)localObject1).length() > 3072)
          {
            mtn = null;
            bwv();
            AppMethodBeat.o(102659);
            return;
          }
        }
        catch (JSONException localJSONException)
        {
          for (;;)
          {
            ab.w("MicroMsg.Fav.FavSearchFlowReportLogic", "end, JSONException");
          }
        }
      }
    }
    ((StringBuilder)localObject1).append("]");
    localObject1 = ((StringBuilder)localObject1).toString();
    if (((String)localObject1).length() > 3072)
    {
      mtn = null;
      bwv();
      AppMethodBeat.o(102659);
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
          ab.w("MicroMsg.Fav.FavSearchFlowReportLogic", "report flow error: " + localThrowable.getMessage());
        }
      }
      h.qsU.e(15508, new Object[] { localObject2[0], localObject2[1], localObject2[2] });
      mtn = null;
      bwv();
      AppMethodBeat.o(102659);
      return;
      i = 0;
    }
  }
  
  public static void ep(String paramString1, String paramString2)
  {
    AppMethodBeat.i(102661);
    if (!bo.isNullOrNil(mto)) {
      eq(mto, mtp);
    }
    mto = paramString1;
    mtp = paramString2;
    mtq = System.currentTimeMillis();
    AppMethodBeat.o(102661);
  }
  
  private static void eq(String paramString1, String paramString2)
  {
    AppMethodBeat.i(102663);
    if ((bo.isNullOrNil(paramString1)) || (!paramString1.equals(mto)))
    {
      AppMethodBeat.o(102663);
      return;
    }
    int i = (int)(System.currentTimeMillis() - mtq);
    mtq /= 1000L;
    String str = paramString2;
    if (bo.isNullOrNil(paramString2)) {
      str = "-1";
    }
    a(paramString1, mtq, i, str);
    bwv();
    AppMethodBeat.o(102663);
  }
  
  public static void start()
  {
    AppMethodBeat.i(102658);
    mtn = new Vector();
    AppMethodBeat.o(102658);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.plugin.fav.a.i
 * JD-Core Version:    0.7.0.1
 */