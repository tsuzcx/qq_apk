package com.tencent.mm.plugin.appbrand.collector;

import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.HashSet;
import java.util.Set;

public final class c
{
  private static b jAX;
  private static boolean jAY;
  private static final Set<String> jAZ;
  
  static
  {
    AppMethodBeat.i(146105);
    jAX = new h();
    jAZ = new HashSet();
    AppMethodBeat.o(146105);
  }
  
  public static CollectSession JB(String paramString)
  {
    AppMethodBeat.i(146100);
    if (!JI(paramString))
    {
      AppMethodBeat.o(146100);
      return null;
    }
    paramString = jAX.JB(paramString);
    AppMethodBeat.o(146100);
    return paramString;
  }
  
  public static CollectSession JC(String paramString)
  {
    AppMethodBeat.i(146101);
    if (!jAY)
    {
      AppMethodBeat.o(146101);
      return null;
    }
    paramString = jAX.JC(paramString);
    AppMethodBeat.o(146101);
    return paramString;
  }
  
  public static StringBuilder JD(String paramString)
  {
    AppMethodBeat.i(146104);
    if (!JH(paramString))
    {
      paramString = new StringBuilder();
      AppMethodBeat.o(146104);
      return paramString;
    }
    paramString = jAX.JD(paramString);
    AppMethodBeat.o(146104);
    return paramString;
  }
  
  public static void JE(String paramString)
  {
    AppMethodBeat.i(146089);
    if (paramString.length() == 0)
    {
      AppMethodBeat.o(146089);
      return;
    }
    jAZ.add(paramString);
    AppMethodBeat.o(146089);
  }
  
  public static void JF(String paramString)
  {
    AppMethodBeat.i(146090);
    if (paramString.length() == 0)
    {
      AppMethodBeat.o(146090);
      return;
    }
    jAZ.remove(paramString);
    AppMethodBeat.o(146090);
  }
  
  public static boolean JG(String paramString)
  {
    AppMethodBeat.i(146091);
    if (paramString.length() == 0)
    {
      AppMethodBeat.o(146091);
      return false;
    }
    boolean bool = jAZ.contains(paramString);
    AppMethodBeat.o(146091);
    return bool;
  }
  
  private static boolean JH(String paramString)
  {
    AppMethodBeat.i(146092);
    if ((jAY) && (jAZ.contains(paramString)))
    {
      AppMethodBeat.o(146092);
      return true;
    }
    AppMethodBeat.o(146092);
    return false;
  }
  
  private static boolean JI(String paramString)
  {
    AppMethodBeat.i(146093);
    if (!jAY)
    {
      AppMethodBeat.o(146093);
      return false;
    }
    paramString = jAX.JB(paramString);
    if (paramString == null)
    {
      AppMethodBeat.o(146093);
      return false;
    }
    if (!jAZ.contains(paramString.groupId))
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
    if (!JH(paramCollectSession.groupId))
    {
      AppMethodBeat.o(146097);
      return;
    }
    jAX.a(paramCollectSession);
    AppMethodBeat.o(146097);
  }
  
  public static boolean bad()
  {
    return jAY;
  }
  
  public static void c(String paramString1, String paramString2, String paramString3, boolean paramBoolean)
  {
    AppMethodBeat.i(146095);
    if (!JH(paramString1))
    {
      AppMethodBeat.o(146095);
      return;
    }
    jAX.c(paramString1, paramString2, paramString3, paramBoolean);
    AppMethodBeat.o(146095);
  }
  
  public static void clear()
  {
    AppMethodBeat.i(146094);
    if (!jAY)
    {
      AppMethodBeat.o(146094);
      return;
    }
    jAX.clear();
    AppMethodBeat.o(146094);
  }
  
  public static CollectSession cx(String paramString1, String paramString2)
  {
    AppMethodBeat.i(146098);
    if (!JI(paramString1))
    {
      AppMethodBeat.o(146098);
      return null;
    }
    paramString1 = jAX.cx(paramString1, paramString2);
    AppMethodBeat.o(146098);
    return paramString1;
  }
  
  public static void cy(String paramString1, String paramString2)
  {
    AppMethodBeat.i(146096);
    if (!JI(paramString1))
    {
      AppMethodBeat.o(146096);
      return;
    }
    jAX.cy(paramString1, paramString2);
    AppMethodBeat.o(146096);
  }
  
  public static int cz(String paramString1, String paramString2)
  {
    AppMethodBeat.i(146103);
    if (!JH(paramString1))
    {
      AppMethodBeat.o(146103);
      return 0;
    }
    int i = jAX.cz(paramString1, paramString2);
    AppMethodBeat.o(146103);
    return i;
  }
  
  public static void fT(boolean paramBoolean)
  {
    jAY = paramBoolean;
  }
  
  public static void k(String paramString1, String paramString2, boolean paramBoolean)
  {
    AppMethodBeat.i(146099);
    if (!JI(paramString1))
    {
      AppMethodBeat.o(146099);
      return;
    }
    jAX.k(paramString1, paramString2, paramBoolean);
    AppMethodBeat.o(146099);
  }
  
  public static void print(String paramString)
  {
    AppMethodBeat.i(146102);
    if (!JI(paramString))
    {
      AppMethodBeat.o(146102);
      return;
    }
    jAX.print(paramString);
    AppMethodBeat.o(146102);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.collector.c
 * JD-Core Version:    0.7.0.1
 */