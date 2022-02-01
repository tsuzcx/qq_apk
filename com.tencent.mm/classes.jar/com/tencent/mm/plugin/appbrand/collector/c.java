package com.tencent.mm.plugin.appbrand.collector;

import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.HashSet;
import java.util.Set;

public final class c
{
  private static b jaK;
  private static boolean jaL;
  private static final Set<String> jaM;
  
  static
  {
    AppMethodBeat.i(146105);
    jaK = new h();
    jaM = new HashSet();
    AppMethodBeat.o(146105);
  }
  
  public static void FA(String paramString)
  {
    AppMethodBeat.i(146089);
    if (paramString.length() == 0)
    {
      AppMethodBeat.o(146089);
      return;
    }
    jaM.add(paramString);
    AppMethodBeat.o(146089);
  }
  
  public static void FB(String paramString)
  {
    AppMethodBeat.i(146090);
    if (paramString.length() == 0)
    {
      AppMethodBeat.o(146090);
      return;
    }
    jaM.remove(paramString);
    AppMethodBeat.o(146090);
  }
  
  public static boolean FC(String paramString)
  {
    AppMethodBeat.i(146091);
    if (paramString.length() == 0)
    {
      AppMethodBeat.o(146091);
      return false;
    }
    boolean bool = jaM.contains(paramString);
    AppMethodBeat.o(146091);
    return bool;
  }
  
  private static boolean FD(String paramString)
  {
    AppMethodBeat.i(146092);
    if ((jaL) && (jaM.contains(paramString)))
    {
      AppMethodBeat.o(146092);
      return true;
    }
    AppMethodBeat.o(146092);
    return false;
  }
  
  private static boolean FE(String paramString)
  {
    AppMethodBeat.i(146093);
    if (!jaL)
    {
      AppMethodBeat.o(146093);
      return false;
    }
    paramString = jaK.Fx(paramString);
    if (paramString == null)
    {
      AppMethodBeat.o(146093);
      return false;
    }
    if (!jaM.contains(paramString.groupId))
    {
      AppMethodBeat.o(146093);
      return false;
    }
    AppMethodBeat.o(146093);
    return true;
  }
  
  public static CollectSession Fx(String paramString)
  {
    AppMethodBeat.i(146100);
    if (!FE(paramString))
    {
      AppMethodBeat.o(146100);
      return null;
    }
    paramString = jaK.Fx(paramString);
    AppMethodBeat.o(146100);
    return paramString;
  }
  
  public static CollectSession Fy(String paramString)
  {
    AppMethodBeat.i(146101);
    if (!jaL)
    {
      AppMethodBeat.o(146101);
      return null;
    }
    paramString = jaK.Fy(paramString);
    AppMethodBeat.o(146101);
    return paramString;
  }
  
  public static StringBuilder Fz(String paramString)
  {
    AppMethodBeat.i(146104);
    if (!FD(paramString))
    {
      paramString = new StringBuilder();
      AppMethodBeat.o(146104);
      return paramString;
    }
    paramString = jaK.Fz(paramString);
    AppMethodBeat.o(146104);
    return paramString;
  }
  
  public static void a(CollectSession paramCollectSession)
  {
    AppMethodBeat.i(146097);
    if (paramCollectSession == null)
    {
      AppMethodBeat.o(146097);
      return;
    }
    if (!FD(paramCollectSession.groupId))
    {
      AppMethodBeat.o(146097);
      return;
    }
    jaK.a(paramCollectSession);
    AppMethodBeat.o(146097);
  }
  
  public static boolean aTe()
  {
    return jaL;
  }
  
  public static void c(String paramString1, String paramString2, String paramString3, boolean paramBoolean)
  {
    AppMethodBeat.i(146095);
    if (!FD(paramString1))
    {
      AppMethodBeat.o(146095);
      return;
    }
    jaK.c(paramString1, paramString2, paramString3, paramBoolean);
    AppMethodBeat.o(146095);
  }
  
  public static void clear()
  {
    AppMethodBeat.i(146094);
    if (!jaL)
    {
      AppMethodBeat.o(146094);
      return;
    }
    jaK.clear();
    AppMethodBeat.o(146094);
  }
  
  public static CollectSession cn(String paramString1, String paramString2)
  {
    AppMethodBeat.i(146098);
    if (!FE(paramString1))
    {
      AppMethodBeat.o(146098);
      return null;
    }
    paramString1 = jaK.cn(paramString1, paramString2);
    AppMethodBeat.o(146098);
    return paramString1;
  }
  
  public static void co(String paramString1, String paramString2)
  {
    AppMethodBeat.i(146096);
    if (!FE(paramString1))
    {
      AppMethodBeat.o(146096);
      return;
    }
    jaK.co(paramString1, paramString2);
    AppMethodBeat.o(146096);
  }
  
  public static int cp(String paramString1, String paramString2)
  {
    AppMethodBeat.i(146103);
    if (!FD(paramString1))
    {
      AppMethodBeat.o(146103);
      return 0;
    }
    int i = jaK.cp(paramString1, paramString2);
    AppMethodBeat.o(146103);
    return i;
  }
  
  public static void fx(boolean paramBoolean)
  {
    jaL = paramBoolean;
  }
  
  public static void k(String paramString1, String paramString2, boolean paramBoolean)
  {
    AppMethodBeat.i(146099);
    if (!FE(paramString1))
    {
      AppMethodBeat.o(146099);
      return;
    }
    jaK.k(paramString1, paramString2, paramBoolean);
    AppMethodBeat.o(146099);
  }
  
  public static void print(String paramString)
  {
    AppMethodBeat.i(146102);
    if (!FE(paramString))
    {
      AppMethodBeat.o(146102);
      return;
    }
    jaK.print(paramString);
    AppMethodBeat.o(146102);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.collector.c
 * JD-Core Version:    0.7.0.1
 */