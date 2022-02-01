package com.tencent.mm.plugin.appbrand.collector;

import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.HashSet;
import java.util.Set;

public final class c
{
  private static b nVq;
  private static boolean nVr;
  private static final Set<String> nVs;
  
  static
  {
    AppMethodBeat.i(146105);
    nVq = new h();
    nVs = new HashSet();
    AppMethodBeat.o(146105);
  }
  
  public static void a(CollectSession paramCollectSession)
  {
    AppMethodBeat.i(146097);
    if (paramCollectSession == null)
    {
      AppMethodBeat.o(146097);
      return;
    }
    if (!aeC(paramCollectSession.groupId))
    {
      AppMethodBeat.o(146097);
      return;
    }
    nVq.a(paramCollectSession);
    AppMethodBeat.o(146097);
  }
  
  public static void aeA(String paramString)
  {
    AppMethodBeat.i(146090);
    if (paramString.length() == 0)
    {
      AppMethodBeat.o(146090);
      return;
    }
    nVs.remove(paramString);
    AppMethodBeat.o(146090);
  }
  
  public static boolean aeB(String paramString)
  {
    AppMethodBeat.i(146091);
    if (paramString.length() == 0)
    {
      AppMethodBeat.o(146091);
      return false;
    }
    boolean bool = nVs.contains(paramString);
    AppMethodBeat.o(146091);
    return bool;
  }
  
  private static boolean aeC(String paramString)
  {
    AppMethodBeat.i(146092);
    if ((nVr) && (nVs.contains(paramString)))
    {
      AppMethodBeat.o(146092);
      return true;
    }
    AppMethodBeat.o(146092);
    return false;
  }
  
  private static boolean aeD(String paramString)
  {
    AppMethodBeat.i(146093);
    if (!nVr)
    {
      AppMethodBeat.o(146093);
      return false;
    }
    paramString = nVq.aev(paramString);
    if (paramString == null)
    {
      AppMethodBeat.o(146093);
      return false;
    }
    if (!nVs.contains(paramString.groupId))
    {
      AppMethodBeat.o(146093);
      return false;
    }
    AppMethodBeat.o(146093);
    return true;
  }
  
  public static CollectSession aev(String paramString)
  {
    AppMethodBeat.i(146100);
    if (!aeD(paramString))
    {
      AppMethodBeat.o(146100);
      return null;
    }
    paramString = nVq.aev(paramString);
    AppMethodBeat.o(146100);
    return paramString;
  }
  
  public static CollectSession aew(String paramString)
  {
    AppMethodBeat.i(146101);
    if (!nVr)
    {
      AppMethodBeat.o(146101);
      return null;
    }
    paramString = nVq.aew(paramString);
    AppMethodBeat.o(146101);
    return paramString;
  }
  
  public static void aex(String paramString)
  {
    AppMethodBeat.i(146102);
    if (!aeD(paramString))
    {
      AppMethodBeat.o(146102);
      return;
    }
    nVq.aex(paramString);
    AppMethodBeat.o(146102);
  }
  
  public static StringBuilder aey(String paramString)
  {
    AppMethodBeat.i(146104);
    if (!aeC(paramString))
    {
      paramString = new StringBuilder();
      AppMethodBeat.o(146104);
      return paramString;
    }
    paramString = nVq.aey(paramString);
    AppMethodBeat.o(146104);
    return paramString;
  }
  
  public static void aez(String paramString)
  {
    AppMethodBeat.i(146089);
    if (paramString.length() == 0)
    {
      AppMethodBeat.o(146089);
      return;
    }
    nVs.add(paramString);
    AppMethodBeat.o(146089);
  }
  
  public static boolean bKN()
  {
    return nVr;
  }
  
  public static void c(String paramString1, String paramString2, String paramString3, boolean paramBoolean)
  {
    AppMethodBeat.i(146095);
    if (!aeC(paramString1))
    {
      AppMethodBeat.o(146095);
      return;
    }
    nVq.c(paramString1, paramString2, paramString3, paramBoolean);
    AppMethodBeat.o(146095);
  }
  
  public static CollectSession cY(String paramString1, String paramString2)
  {
    AppMethodBeat.i(146098);
    if (!aeD(paramString1))
    {
      AppMethodBeat.o(146098);
      return null;
    }
    paramString1 = nVq.cY(paramString1, paramString2);
    AppMethodBeat.o(146098);
    return paramString1;
  }
  
  public static void cZ(String paramString1, String paramString2)
  {
    AppMethodBeat.i(146096);
    if (!aeD(paramString1))
    {
      AppMethodBeat.o(146096);
      return;
    }
    nVq.cZ(paramString1, paramString2);
    AppMethodBeat.o(146096);
  }
  
  public static void clear()
  {
    AppMethodBeat.i(146094);
    if (!nVr)
    {
      AppMethodBeat.o(146094);
      return;
    }
    nVq.clear();
    AppMethodBeat.o(146094);
  }
  
  public static int da(String paramString1, String paramString2)
  {
    AppMethodBeat.i(146103);
    if (!aeC(paramString1))
    {
      AppMethodBeat.o(146103);
      return 0;
    }
    int i = nVq.da(paramString1, paramString2);
    AppMethodBeat.o(146103);
    return i;
  }
  
  public static void hE(boolean paramBoolean)
  {
    nVr = paramBoolean;
  }
  
  public static void k(String paramString1, String paramString2, boolean paramBoolean)
  {
    AppMethodBeat.i(146099);
    if (!aeD(paramString1))
    {
      AppMethodBeat.o(146099);
      return;
    }
    nVq.k(paramString1, paramString2, paramBoolean);
    AppMethodBeat.o(146099);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.collector.c
 * JD-Core Version:    0.7.0.1
 */