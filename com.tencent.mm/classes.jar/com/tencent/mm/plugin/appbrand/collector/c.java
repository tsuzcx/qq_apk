package com.tencent.mm.plugin.appbrand.collector;

import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.HashSet;
import java.util.Set;

public final class c
{
  private static b jUS;
  private static boolean jUT;
  private static final Set<String> jUU;
  
  static
  {
    AppMethodBeat.i(146105);
    jUS = new h();
    jUU = new HashSet();
    AppMethodBeat.o(146105);
  }
  
  public static CollectSession MU(String paramString)
  {
    AppMethodBeat.i(146100);
    if (!Nb(paramString))
    {
      AppMethodBeat.o(146100);
      return null;
    }
    paramString = jUS.MU(paramString);
    AppMethodBeat.o(146100);
    return paramString;
  }
  
  public static CollectSession MV(String paramString)
  {
    AppMethodBeat.i(146101);
    if (!jUT)
    {
      AppMethodBeat.o(146101);
      return null;
    }
    paramString = jUS.MV(paramString);
    AppMethodBeat.o(146101);
    return paramString;
  }
  
  public static StringBuilder MW(String paramString)
  {
    AppMethodBeat.i(146104);
    if (!Na(paramString))
    {
      paramString = new StringBuilder();
      AppMethodBeat.o(146104);
      return paramString;
    }
    paramString = jUS.MW(paramString);
    AppMethodBeat.o(146104);
    return paramString;
  }
  
  public static void MX(String paramString)
  {
    AppMethodBeat.i(146089);
    if (paramString.length() == 0)
    {
      AppMethodBeat.o(146089);
      return;
    }
    jUU.add(paramString);
    AppMethodBeat.o(146089);
  }
  
  public static void MY(String paramString)
  {
    AppMethodBeat.i(146090);
    if (paramString.length() == 0)
    {
      AppMethodBeat.o(146090);
      return;
    }
    jUU.remove(paramString);
    AppMethodBeat.o(146090);
  }
  
  public static boolean MZ(String paramString)
  {
    AppMethodBeat.i(146091);
    if (paramString.length() == 0)
    {
      AppMethodBeat.o(146091);
      return false;
    }
    boolean bool = jUU.contains(paramString);
    AppMethodBeat.o(146091);
    return bool;
  }
  
  private static boolean Na(String paramString)
  {
    AppMethodBeat.i(146092);
    if ((jUT) && (jUU.contains(paramString)))
    {
      AppMethodBeat.o(146092);
      return true;
    }
    AppMethodBeat.o(146092);
    return false;
  }
  
  private static boolean Nb(String paramString)
  {
    AppMethodBeat.i(146093);
    if (!jUT)
    {
      AppMethodBeat.o(146093);
      return false;
    }
    paramString = jUS.MU(paramString);
    if (paramString == null)
    {
      AppMethodBeat.o(146093);
      return false;
    }
    if (!jUU.contains(paramString.groupId))
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
    if (!Na(paramCollectSession.groupId))
    {
      AppMethodBeat.o(146097);
      return;
    }
    jUS.a(paramCollectSession);
    AppMethodBeat.o(146097);
  }
  
  public static boolean bdC()
  {
    return jUT;
  }
  
  public static void c(String paramString1, String paramString2, String paramString3, boolean paramBoolean)
  {
    AppMethodBeat.i(146095);
    if (!Na(paramString1))
    {
      AppMethodBeat.o(146095);
      return;
    }
    jUS.c(paramString1, paramString2, paramString3, paramBoolean);
    AppMethodBeat.o(146095);
  }
  
  public static void cA(String paramString1, String paramString2)
  {
    AppMethodBeat.i(146096);
    if (!Nb(paramString1))
    {
      AppMethodBeat.o(146096);
      return;
    }
    jUS.cA(paramString1, paramString2);
    AppMethodBeat.o(146096);
  }
  
  public static int cB(String paramString1, String paramString2)
  {
    AppMethodBeat.i(146103);
    if (!Na(paramString1))
    {
      AppMethodBeat.o(146103);
      return 0;
    }
    int i = jUS.cB(paramString1, paramString2);
    AppMethodBeat.o(146103);
    return i;
  }
  
  public static void clear()
  {
    AppMethodBeat.i(146094);
    if (!jUT)
    {
      AppMethodBeat.o(146094);
      return;
    }
    jUS.clear();
    AppMethodBeat.o(146094);
  }
  
  public static CollectSession cz(String paramString1, String paramString2)
  {
    AppMethodBeat.i(146098);
    if (!Nb(paramString1))
    {
      AppMethodBeat.o(146098);
      return null;
    }
    paramString1 = jUS.cz(paramString1, paramString2);
    AppMethodBeat.o(146098);
    return paramString1;
  }
  
  public static void fX(boolean paramBoolean)
  {
    jUT = paramBoolean;
  }
  
  public static void k(String paramString1, String paramString2, boolean paramBoolean)
  {
    AppMethodBeat.i(146099);
    if (!Nb(paramString1))
    {
      AppMethodBeat.o(146099);
      return;
    }
    jUS.k(paramString1, paramString2, paramBoolean);
    AppMethodBeat.o(146099);
  }
  
  public static void print(String paramString)
  {
    AppMethodBeat.i(146102);
    if (!Nb(paramString))
    {
      AppMethodBeat.o(146102);
      return;
    }
    jUS.print(paramString);
    AppMethodBeat.o(146102);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.collector.c
 * JD-Core Version:    0.7.0.1
 */