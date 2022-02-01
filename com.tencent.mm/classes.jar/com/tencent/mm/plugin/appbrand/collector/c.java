package com.tencent.mm.plugin.appbrand.collector;

import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.HashSet;
import java.util.Set;

public final class c
{
  private static b jYj;
  private static boolean jYk;
  private static final Set<String> jYl;
  
  static
  {
    AppMethodBeat.i(146105);
    jYj = new h();
    jYl = new HashSet();
    AppMethodBeat.o(146105);
  }
  
  public static CollectSession NB(String paramString)
  {
    AppMethodBeat.i(146100);
    if (!NI(paramString))
    {
      AppMethodBeat.o(146100);
      return null;
    }
    paramString = jYj.NB(paramString);
    AppMethodBeat.o(146100);
    return paramString;
  }
  
  public static CollectSession NC(String paramString)
  {
    AppMethodBeat.i(146101);
    if (!jYk)
    {
      AppMethodBeat.o(146101);
      return null;
    }
    paramString = jYj.NC(paramString);
    AppMethodBeat.o(146101);
    return paramString;
  }
  
  public static StringBuilder ND(String paramString)
  {
    AppMethodBeat.i(146104);
    if (!NH(paramString))
    {
      paramString = new StringBuilder();
      AppMethodBeat.o(146104);
      return paramString;
    }
    paramString = jYj.ND(paramString);
    AppMethodBeat.o(146104);
    return paramString;
  }
  
  public static void NE(String paramString)
  {
    AppMethodBeat.i(146089);
    if (paramString.length() == 0)
    {
      AppMethodBeat.o(146089);
      return;
    }
    jYl.add(paramString);
    AppMethodBeat.o(146089);
  }
  
  public static void NF(String paramString)
  {
    AppMethodBeat.i(146090);
    if (paramString.length() == 0)
    {
      AppMethodBeat.o(146090);
      return;
    }
    jYl.remove(paramString);
    AppMethodBeat.o(146090);
  }
  
  public static boolean NG(String paramString)
  {
    AppMethodBeat.i(146091);
    if (paramString.length() == 0)
    {
      AppMethodBeat.o(146091);
      return false;
    }
    boolean bool = jYl.contains(paramString);
    AppMethodBeat.o(146091);
    return bool;
  }
  
  private static boolean NH(String paramString)
  {
    AppMethodBeat.i(146092);
    if ((jYk) && (jYl.contains(paramString)))
    {
      AppMethodBeat.o(146092);
      return true;
    }
    AppMethodBeat.o(146092);
    return false;
  }
  
  private static boolean NI(String paramString)
  {
    AppMethodBeat.i(146093);
    if (!jYk)
    {
      AppMethodBeat.o(146093);
      return false;
    }
    paramString = jYj.NB(paramString);
    if (paramString == null)
    {
      AppMethodBeat.o(146093);
      return false;
    }
    if (!jYl.contains(paramString.groupId))
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
    if (!NH(paramCollectSession.groupId))
    {
      AppMethodBeat.o(146097);
      return;
    }
    jYj.a(paramCollectSession);
    AppMethodBeat.o(146097);
  }
  
  public static boolean beh()
  {
    return jYk;
  }
  
  public static void c(String paramString1, String paramString2, String paramString3, boolean paramBoolean)
  {
    AppMethodBeat.i(146095);
    if (!NH(paramString1))
    {
      AppMethodBeat.o(146095);
      return;
    }
    jYj.c(paramString1, paramString2, paramString3, paramBoolean);
    AppMethodBeat.o(146095);
  }
  
  public static CollectSession cB(String paramString1, String paramString2)
  {
    AppMethodBeat.i(146098);
    if (!NI(paramString1))
    {
      AppMethodBeat.o(146098);
      return null;
    }
    paramString1 = jYj.cB(paramString1, paramString2);
    AppMethodBeat.o(146098);
    return paramString1;
  }
  
  public static void cC(String paramString1, String paramString2)
  {
    AppMethodBeat.i(146096);
    if (!NI(paramString1))
    {
      AppMethodBeat.o(146096);
      return;
    }
    jYj.cC(paramString1, paramString2);
    AppMethodBeat.o(146096);
  }
  
  public static int cD(String paramString1, String paramString2)
  {
    AppMethodBeat.i(146103);
    if (!NH(paramString1))
    {
      AppMethodBeat.o(146103);
      return 0;
    }
    int i = jYj.cD(paramString1, paramString2);
    AppMethodBeat.o(146103);
    return i;
  }
  
  public static void clear()
  {
    AppMethodBeat.i(146094);
    if (!jYk)
    {
      AppMethodBeat.o(146094);
      return;
    }
    jYj.clear();
    AppMethodBeat.o(146094);
  }
  
  public static void fW(boolean paramBoolean)
  {
    jYk = paramBoolean;
  }
  
  public static void k(String paramString1, String paramString2, boolean paramBoolean)
  {
    AppMethodBeat.i(146099);
    if (!NI(paramString1))
    {
      AppMethodBeat.o(146099);
      return;
    }
    jYj.k(paramString1, paramString2, paramBoolean);
    AppMethodBeat.o(146099);
  }
  
  public static void print(String paramString)
  {
    AppMethodBeat.i(146102);
    if (!NI(paramString))
    {
      AppMethodBeat.o(146102);
      return;
    }
    jYj.print(paramString);
    AppMethodBeat.o(146102);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.collector.c
 * JD-Core Version:    0.7.0.1
 */