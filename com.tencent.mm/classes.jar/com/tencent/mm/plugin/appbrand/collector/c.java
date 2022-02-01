package com.tencent.mm.plugin.appbrand.collector;

import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.HashSet;
import java.util.Set;

public final class c
{
  private static b qVa;
  private static boolean qVb;
  private static final Set<String> qVc;
  
  static
  {
    AppMethodBeat.i(146105);
    qVa = new h();
    qVc = new HashSet();
    AppMethodBeat.o(146105);
  }
  
  public static CollectSession WY(String paramString)
  {
    AppMethodBeat.i(146100);
    if (!Xg(paramString))
    {
      AppMethodBeat.o(146100);
      return null;
    }
    paramString = qVa.WY(paramString);
    AppMethodBeat.o(146100);
    return paramString;
  }
  
  public static CollectSession WZ(String paramString)
  {
    AppMethodBeat.i(146101);
    if (!qVb)
    {
      AppMethodBeat.o(146101);
      return null;
    }
    paramString = qVa.WZ(paramString);
    AppMethodBeat.o(146101);
    return paramString;
  }
  
  public static void Xa(String paramString)
  {
    AppMethodBeat.i(146102);
    if (!Xg(paramString))
    {
      AppMethodBeat.o(146102);
      return;
    }
    qVa.Xa(paramString);
    AppMethodBeat.o(146102);
  }
  
  public static StringBuilder Xb(String paramString)
  {
    AppMethodBeat.i(146104);
    if (!Xf(paramString))
    {
      paramString = new StringBuilder();
      AppMethodBeat.o(146104);
      return paramString;
    }
    paramString = qVa.Xb(paramString);
    AppMethodBeat.o(146104);
    return paramString;
  }
  
  public static void Xc(String paramString)
  {
    AppMethodBeat.i(146089);
    if (paramString.length() == 0)
    {
      AppMethodBeat.o(146089);
      return;
    }
    qVc.add(paramString);
    AppMethodBeat.o(146089);
  }
  
  public static void Xd(String paramString)
  {
    AppMethodBeat.i(146090);
    if (paramString.length() == 0)
    {
      AppMethodBeat.o(146090);
      return;
    }
    qVc.remove(paramString);
    AppMethodBeat.o(146090);
  }
  
  public static boolean Xe(String paramString)
  {
    AppMethodBeat.i(146091);
    if (paramString.length() == 0)
    {
      AppMethodBeat.o(146091);
      return false;
    }
    boolean bool = qVc.contains(paramString);
    AppMethodBeat.o(146091);
    return bool;
  }
  
  private static boolean Xf(String paramString)
  {
    AppMethodBeat.i(146092);
    if ((qVb) && (qVc.contains(paramString)))
    {
      AppMethodBeat.o(146092);
      return true;
    }
    AppMethodBeat.o(146092);
    return false;
  }
  
  private static boolean Xg(String paramString)
  {
    AppMethodBeat.i(146093);
    if (!qVb)
    {
      AppMethodBeat.o(146093);
      return false;
    }
    paramString = qVa.WY(paramString);
    if (paramString == null)
    {
      AppMethodBeat.o(146093);
      return false;
    }
    if (!qVc.contains(paramString.groupId))
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
    if (!Xf(paramCollectSession.groupId))
    {
      AppMethodBeat.o(146097);
      return;
    }
    qVa.a(paramCollectSession);
    AppMethodBeat.o(146097);
  }
  
  public static void c(String paramString1, String paramString2, String paramString3, boolean paramBoolean)
  {
    AppMethodBeat.i(146095);
    if (!Xf(paramString1))
    {
      AppMethodBeat.o(146095);
      return;
    }
    qVa.c(paramString1, paramString2, paramString3, paramBoolean);
    AppMethodBeat.o(146095);
  }
  
  public static boolean ckn()
  {
    return qVb;
  }
  
  public static void clear()
  {
    AppMethodBeat.i(146094);
    if (!qVb)
    {
      AppMethodBeat.o(146094);
      return;
    }
    qVa.clear();
    AppMethodBeat.o(146094);
  }
  
  public static CollectSession dp(String paramString1, String paramString2)
  {
    AppMethodBeat.i(146098);
    if (!Xg(paramString1))
    {
      AppMethodBeat.o(146098);
      return null;
    }
    paramString1 = qVa.dp(paramString1, paramString2);
    AppMethodBeat.o(146098);
    return paramString1;
  }
  
  public static void dq(String paramString1, String paramString2)
  {
    AppMethodBeat.i(146096);
    if (!Xg(paramString1))
    {
      AppMethodBeat.o(146096);
      return;
    }
    qVa.dq(paramString1, paramString2);
    AppMethodBeat.o(146096);
  }
  
  public static int dr(String paramString1, String paramString2)
  {
    AppMethodBeat.i(146103);
    if (!Xf(paramString1))
    {
      AppMethodBeat.o(146103);
      return 0;
    }
    int i = qVa.dr(paramString1, paramString2);
    AppMethodBeat.o(146103);
    return i;
  }
  
  public static void iu(boolean paramBoolean)
  {
    qVb = paramBoolean;
  }
  
  public static void o(String paramString1, String paramString2, boolean paramBoolean)
  {
    AppMethodBeat.i(146099);
    if (!Xg(paramString1))
    {
      AppMethodBeat.o(146099);
      return;
    }
    qVa.o(paramString1, paramString2, paramBoolean);
    AppMethodBeat.o(146099);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes11.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.collector.c
 * JD-Core Version:    0.7.0.1
 */