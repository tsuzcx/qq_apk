package com.tencent.mm.plugin.appbrand.collector;

import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.HashSet;
import java.util.Set;

public final class c
{
  private static b lbh;
  private static boolean lbi;
  private static final Set<String> lbj;
  
  static
  {
    AppMethodBeat.i(146105);
    lbh = new h();
    lbj = new HashSet();
    AppMethodBeat.o(146105);
  }
  
  public static CollectSession WJ(String paramString)
  {
    AppMethodBeat.i(146100);
    if (!WQ(paramString))
    {
      AppMethodBeat.o(146100);
      return null;
    }
    paramString = lbh.WJ(paramString);
    AppMethodBeat.o(146100);
    return paramString;
  }
  
  public static CollectSession WK(String paramString)
  {
    AppMethodBeat.i(146101);
    if (!lbi)
    {
      AppMethodBeat.o(146101);
      return null;
    }
    paramString = lbh.WK(paramString);
    AppMethodBeat.o(146101);
    return paramString;
  }
  
  public static StringBuilder WL(String paramString)
  {
    AppMethodBeat.i(146104);
    if (!WP(paramString))
    {
      paramString = new StringBuilder();
      AppMethodBeat.o(146104);
      return paramString;
    }
    paramString = lbh.WL(paramString);
    AppMethodBeat.o(146104);
    return paramString;
  }
  
  public static void WM(String paramString)
  {
    AppMethodBeat.i(146089);
    if (paramString.length() == 0)
    {
      AppMethodBeat.o(146089);
      return;
    }
    lbj.add(paramString);
    AppMethodBeat.o(146089);
  }
  
  public static void WN(String paramString)
  {
    AppMethodBeat.i(146090);
    if (paramString.length() == 0)
    {
      AppMethodBeat.o(146090);
      return;
    }
    lbj.remove(paramString);
    AppMethodBeat.o(146090);
  }
  
  public static boolean WO(String paramString)
  {
    AppMethodBeat.i(146091);
    if (paramString.length() == 0)
    {
      AppMethodBeat.o(146091);
      return false;
    }
    boolean bool = lbj.contains(paramString);
    AppMethodBeat.o(146091);
    return bool;
  }
  
  private static boolean WP(String paramString)
  {
    AppMethodBeat.i(146092);
    if ((lbi) && (lbj.contains(paramString)))
    {
      AppMethodBeat.o(146092);
      return true;
    }
    AppMethodBeat.o(146092);
    return false;
  }
  
  private static boolean WQ(String paramString)
  {
    AppMethodBeat.i(146093);
    if (!lbi)
    {
      AppMethodBeat.o(146093);
      return false;
    }
    paramString = lbh.WJ(paramString);
    if (paramString == null)
    {
      AppMethodBeat.o(146093);
      return false;
    }
    if (!lbj.contains(paramString.groupId))
    {
      AppMethodBeat.o(146093);
      return false;
    }
    AppMethodBeat.o(146093);
    return true;
  }
  
  public static void a(CollectSession paramCollectSession)
  {
    AppMethodBeat.i(146097);
    if (paramCollectSession == null)
    {
      AppMethodBeat.o(146097);
      return;
    }
    if (!WP(paramCollectSession.groupId))
    {
      AppMethodBeat.o(146097);
      return;
    }
    lbh.a(paramCollectSession);
    AppMethodBeat.o(146097);
  }
  
  public static boolean bzy()
  {
    return lbi;
  }
  
  public static void c(String paramString1, String paramString2, String paramString3, boolean paramBoolean)
  {
    AppMethodBeat.i(146095);
    if (!WP(paramString1))
    {
      AppMethodBeat.o(146095);
      return;
    }
    lbh.c(paramString1, paramString2, paramString3, paramBoolean);
    AppMethodBeat.o(146095);
  }
  
  public static CollectSession cP(String paramString1, String paramString2)
  {
    AppMethodBeat.i(146098);
    if (!WQ(paramString1))
    {
      AppMethodBeat.o(146098);
      return null;
    }
    paramString1 = lbh.cP(paramString1, paramString2);
    AppMethodBeat.o(146098);
    return paramString1;
  }
  
  public static void cQ(String paramString1, String paramString2)
  {
    AppMethodBeat.i(146096);
    if (!WQ(paramString1))
    {
      AppMethodBeat.o(146096);
      return;
    }
    lbh.cQ(paramString1, paramString2);
    AppMethodBeat.o(146096);
  }
  
  public static int cR(String paramString1, String paramString2)
  {
    AppMethodBeat.i(146103);
    if (!WP(paramString1))
    {
      AppMethodBeat.o(146103);
      return 0;
    }
    int i = lbh.cR(paramString1, paramString2);
    AppMethodBeat.o(146103);
    return i;
  }
  
  public static void clear()
  {
    AppMethodBeat.i(146094);
    if (!lbi)
    {
      AppMethodBeat.o(146094);
      return;
    }
    lbh.clear();
    AppMethodBeat.o(146094);
  }
  
  public static void gT(boolean paramBoolean)
  {
    lbi = paramBoolean;
  }
  
  public static void k(String paramString1, String paramString2, boolean paramBoolean)
  {
    AppMethodBeat.i(146099);
    if (!WQ(paramString1))
    {
      AppMethodBeat.o(146099);
      return;
    }
    lbh.k(paramString1, paramString2, paramBoolean);
    AppMethodBeat.o(146099);
  }
  
  public static void print(String paramString)
  {
    AppMethodBeat.i(146102);
    if (!WQ(paramString))
    {
      AppMethodBeat.o(146102);
      return;
    }
    lbh.print(paramString);
    AppMethodBeat.o(146102);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes8.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.collector.c
 * JD-Core Version:    0.7.0.1
 */