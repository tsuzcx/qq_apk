package com.tencent.mm.plugin.appbrand.collector;

import java.util.HashSet;
import java.util.Set;

public final class c
{
  private static b fNp = new h();
  private static boolean fNq;
  private static final Set<String> fNr = new HashSet();
  
  public static void a(CollectSession paramCollectSession)
  {
    if (paramCollectSession == null) {}
    while (!rZ(paramCollectSession.groupId)) {
      return;
    }
    fNp.a(paramCollectSession);
  }
  
  public static boolean adS()
  {
    return fNq;
  }
  
  public static CollectSession bf(String paramString1, String paramString2)
  {
    if (!sa(paramString1)) {
      return null;
    }
    return fNp.bf(paramString1, paramString2);
  }
  
  public static void bg(String paramString1, String paramString2)
  {
    if (!sa(paramString1)) {
      return;
    }
    fNp.bg(paramString1, paramString2);
  }
  
  public static int bh(String paramString1, String paramString2)
  {
    if (!rZ(paramString1)) {
      return 0;
    }
    return fNp.bh(paramString1, paramString2);
  }
  
  public static void c(String paramString1, String paramString2, String paramString3, boolean paramBoolean)
  {
    if (!rZ(paramString1)) {
      return;
    }
    fNp.c(paramString1, paramString2, paramString3, paramBoolean);
  }
  
  public static void cK(boolean paramBoolean)
  {
    fNq = paramBoolean;
  }
  
  public static void clear()
  {
    if (!fNq) {
      return;
    }
    fNp.clear();
  }
  
  public static void j(String paramString1, String paramString2, boolean paramBoolean)
  {
    if (!sa(paramString1)) {
      return;
    }
    fNp.j(paramString1, paramString2, paramBoolean);
  }
  
  public static void print(String paramString)
  {
    if (!sa(paramString)) {
      return;
    }
    fNp.print(paramString);
  }
  
  public static CollectSession rT(String paramString)
  {
    if (!sa(paramString)) {
      return null;
    }
    return fNp.rT(paramString);
  }
  
  public static CollectSession rU(String paramString)
  {
    if (!fNq) {
      return null;
    }
    return fNp.rU(paramString);
  }
  
  public static StringBuilder rV(String paramString)
  {
    if (!rZ(paramString)) {
      return new StringBuilder();
    }
    return fNp.rV(paramString);
  }
  
  public static void rW(String paramString)
  {
    if (paramString.length() == 0) {
      return;
    }
    fNr.add(paramString);
  }
  
  public static void rX(String paramString)
  {
    if (paramString.length() == 0) {
      return;
    }
    fNr.remove(paramString);
  }
  
  public static boolean rY(String paramString)
  {
    if (paramString.length() == 0) {
      return false;
    }
    return fNr.contains(paramString);
  }
  
  private static boolean rZ(String paramString)
  {
    return (fNq) && (fNr.contains(paramString));
  }
  
  private static boolean sa(String paramString)
  {
    if (!fNq) {}
    do
    {
      return false;
      paramString = fNp.rT(paramString);
    } while ((paramString == null) || (!fNr.contains(paramString.groupId)));
    return true;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.collector.c
 * JD-Core Version:    0.7.0.1
 */