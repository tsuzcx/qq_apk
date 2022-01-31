package com.tencent.mm.plugin.appbrand.collector;

import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.HashSet;
import java.util.Set;

public final class c
{
  private static boolean hgA;
  private static final Set<String> hgB;
  private static b hgz;
  
  static
  {
    AppMethodBeat.i(57040);
    hgz = new h();
    hgB = new HashSet();
    AppMethodBeat.o(57040);
  }
  
  public static void a(CollectSession paramCollectSession)
  {
    AppMethodBeat.i(57032);
    if (paramCollectSession == null)
    {
      AppMethodBeat.o(57032);
      return;
    }
    if (!zP(paramCollectSession.groupId))
    {
      AppMethodBeat.o(57032);
      return;
    }
    hgz.a(paramCollectSession);
    AppMethodBeat.o(57032);
  }
  
  public static boolean ayk()
  {
    return hgA;
  }
  
  public static CollectSession bH(String paramString1, String paramString2)
  {
    AppMethodBeat.i(57033);
    if (!zQ(paramString1))
    {
      AppMethodBeat.o(57033);
      return null;
    }
    paramString1 = hgz.bH(paramString1, paramString2);
    AppMethodBeat.o(57033);
    return paramString1;
  }
  
  public static void bI(String paramString1, String paramString2)
  {
    AppMethodBeat.i(57031);
    if (!zQ(paramString1))
    {
      AppMethodBeat.o(57031);
      return;
    }
    hgz.bI(paramString1, paramString2);
    AppMethodBeat.o(57031);
  }
  
  public static int bJ(String paramString1, String paramString2)
  {
    AppMethodBeat.i(57038);
    if (!zP(paramString1))
    {
      AppMethodBeat.o(57038);
      return 0;
    }
    int i = hgz.bJ(paramString1, paramString2);
    AppMethodBeat.o(57038);
    return i;
  }
  
  public static void c(String paramString1, String paramString2, String paramString3, boolean paramBoolean)
  {
    AppMethodBeat.i(57030);
    if (!zP(paramString1))
    {
      AppMethodBeat.o(57030);
      return;
    }
    hgz.c(paramString1, paramString2, paramString3, paramBoolean);
    AppMethodBeat.o(57030);
  }
  
  public static void clear()
  {
    AppMethodBeat.i(57029);
    if (!hgA)
    {
      AppMethodBeat.o(57029);
      return;
    }
    hgz.clear();
    AppMethodBeat.o(57029);
  }
  
  public static void dO(boolean paramBoolean)
  {
    hgA = paramBoolean;
  }
  
  public static void l(String paramString1, String paramString2, boolean paramBoolean)
  {
    AppMethodBeat.i(57034);
    if (!zQ(paramString1))
    {
      AppMethodBeat.o(57034);
      return;
    }
    hgz.l(paramString1, paramString2, paramBoolean);
    AppMethodBeat.o(57034);
  }
  
  public static void print(String paramString)
  {
    AppMethodBeat.i(57037);
    if (!zQ(paramString))
    {
      AppMethodBeat.o(57037);
      return;
    }
    hgz.print(paramString);
    AppMethodBeat.o(57037);
  }
  
  public static CollectSession zJ(String paramString)
  {
    AppMethodBeat.i(57035);
    if (!zQ(paramString))
    {
      AppMethodBeat.o(57035);
      return null;
    }
    paramString = hgz.zJ(paramString);
    AppMethodBeat.o(57035);
    return paramString;
  }
  
  public static CollectSession zK(String paramString)
  {
    AppMethodBeat.i(57036);
    if (!hgA)
    {
      AppMethodBeat.o(57036);
      return null;
    }
    paramString = hgz.zK(paramString);
    AppMethodBeat.o(57036);
    return paramString;
  }
  
  public static StringBuilder zL(String paramString)
  {
    AppMethodBeat.i(57039);
    if (!zP(paramString))
    {
      paramString = new StringBuilder();
      AppMethodBeat.o(57039);
      return paramString;
    }
    paramString = hgz.zL(paramString);
    AppMethodBeat.o(57039);
    return paramString;
  }
  
  public static void zM(String paramString)
  {
    AppMethodBeat.i(57024);
    if (paramString.length() == 0)
    {
      AppMethodBeat.o(57024);
      return;
    }
    hgB.add(paramString);
    AppMethodBeat.o(57024);
  }
  
  public static void zN(String paramString)
  {
    AppMethodBeat.i(57025);
    if (paramString.length() == 0)
    {
      AppMethodBeat.o(57025);
      return;
    }
    hgB.remove(paramString);
    AppMethodBeat.o(57025);
  }
  
  public static boolean zO(String paramString)
  {
    AppMethodBeat.i(57026);
    if (paramString.length() == 0)
    {
      AppMethodBeat.o(57026);
      return false;
    }
    boolean bool = hgB.contains(paramString);
    AppMethodBeat.o(57026);
    return bool;
  }
  
  private static boolean zP(String paramString)
  {
    AppMethodBeat.i(57027);
    if ((hgA) && (hgB.contains(paramString)))
    {
      AppMethodBeat.o(57027);
      return true;
    }
    AppMethodBeat.o(57027);
    return false;
  }
  
  private static boolean zQ(String paramString)
  {
    AppMethodBeat.i(57028);
    if (!hgA)
    {
      AppMethodBeat.o(57028);
      return false;
    }
    paramString = hgz.zJ(paramString);
    if (paramString == null)
    {
      AppMethodBeat.o(57028);
      return false;
    }
    if (!hgB.contains(paramString.groupId))
    {
      AppMethodBeat.o(57028);
      return false;
    }
    AppMethodBeat.o(57028);
    return true;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.collector.c
 * JD-Core Version:    0.7.0.1
 */