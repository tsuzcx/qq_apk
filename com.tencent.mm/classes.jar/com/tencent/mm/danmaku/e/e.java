package com.tencent.mm.danmaku.e;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.danmaku.a.c;
import com.tencent.mm.danmaku.c.l.a;

public final class e
{
  private static l.a gQU;
  public static final int gQV;
  private static final StringBuilder gQW;
  
  static
  {
    AppMethodBeat.i(241777);
    if (c.gNA) {}
    for (int i = 4;; i = 3)
    {
      gQV = i;
      gQW = new StringBuilder();
      AppMethodBeat.o(241777);
      return;
    }
  }
  
  public static void a(l.a parama)
  {
    gQU = parama;
  }
  
  public static void d(String paramString1, String paramString2)
  {
    AppMethodBeat.i(241770);
    if ((gQV >= 4) && (gQU != null)) {
      gQU.d(paramString1, paramString2);
    }
    AppMethodBeat.o(241770);
  }
  
  public static void d(String paramString, Object... paramVarArgs)
  {
    int i = 0;
    AppMethodBeat.i(241769);
    if ((gQV >= 4) && (gQU != null))
    {
      gQW.setLength(0);
      int j = paramVarArgs.length;
      while (i < j)
      {
        Object localObject = paramVarArgs[i];
        gQW.append(localObject);
        i += 1;
      }
      gQU.d(paramString, gQW.toString());
    }
    AppMethodBeat.o(241769);
  }
  
  public static void e(String paramString1, String paramString2)
  {
    AppMethodBeat.i(241775);
    if ((gQV > 0) && (gQU != null)) {
      gQU.e(paramString1, paramString2);
    }
    AppMethodBeat.o(241775);
  }
  
  public static void e(String paramString1, String paramString2, Throwable paramThrowable)
  {
    AppMethodBeat.i(241776);
    if ((gQV > 0) && (gQU != null)) {
      gQU.e(paramString1, paramString2, paramThrowable);
    }
    AppMethodBeat.o(241776);
  }
  
  public static void e(String paramString, Object... paramVarArgs)
  {
    AppMethodBeat.i(241774);
    if ((gQV > 0) && (gQU != null))
    {
      gQW.setLength(0);
      int i = 0;
      while (i <= 0)
      {
        Object localObject = paramVarArgs[0];
        gQW.append(localObject);
        i += 1;
      }
      gQU.e(paramString, gQW.toString());
    }
    AppMethodBeat.o(241774);
  }
  
  public static void i(String paramString1, String paramString2)
  {
    AppMethodBeat.i(241772);
    if ((gQV >= 3) && (gQU != null)) {
      gQU.i(paramString1, paramString2);
    }
    AppMethodBeat.o(241772);
  }
  
  public static void i(String paramString, Object... paramVarArgs)
  {
    int i = 0;
    AppMethodBeat.i(241771);
    if ((gQV >= 3) && (gQU != null))
    {
      gQW.setLength(0);
      while (i < 2)
      {
        Object localObject = paramVarArgs[i];
        gQW.append(localObject);
        i += 1;
      }
      gQU.i(paramString, gQW.toString());
    }
    AppMethodBeat.o(241771);
  }
  
  public static void v(String paramString1, String paramString2)
  {
    AppMethodBeat.i(241768);
    if ((gQV >= 5) && (gQU != null)) {
      gQU.v(paramString1, paramString2);
    }
    AppMethodBeat.o(241768);
  }
  
  public static void v(String paramString, Object... paramVarArgs)
  {
    int i = 0;
    AppMethodBeat.i(241767);
    if ((gQV >= 5) && (gQU != null))
    {
      gQW.setLength(0);
      int j = paramVarArgs.length;
      while (i < j)
      {
        Object localObject = paramVarArgs[i];
        gQW.append(localObject);
        i += 1;
      }
      gQU.v(paramString, gQW.toString());
    }
    AppMethodBeat.o(241767);
  }
  
  public static void w(String paramString1, String paramString2)
  {
    AppMethodBeat.i(241773);
    if ((gQV >= 2) && (gQU != null)) {
      gQU.w(paramString1, paramString2);
    }
    AppMethodBeat.o(241773);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes9.jar
 * Qualified Name:     com.tencent.mm.danmaku.e.e
 * JD-Core Version:    0.7.0.1
 */