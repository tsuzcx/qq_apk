package com.tencent.mm.danmaku.e;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.danmaku.a.c;
import com.tencent.mm.danmaku.c.l.a;

public final class e
{
  private static l.a jBn;
  public static final int jBo;
  private static final StringBuilder jBp;
  
  static
  {
    AppMethodBeat.i(289672);
    if (c.jxV) {}
    for (int i = 4;; i = 3)
    {
      jBo = i;
      jBp = new StringBuilder();
      AppMethodBeat.o(289672);
      return;
    }
  }
  
  public static void a(l.a parama)
  {
    jBn = parama;
  }
  
  public static void d(String paramString1, String paramString2)
  {
    AppMethodBeat.i(289664);
    if ((jBo >= 4) && (jBn != null)) {
      jBn.d(paramString1, paramString2);
    }
    AppMethodBeat.o(289664);
  }
  
  public static void d(String paramString, Object... paramVarArgs)
  {
    int i = 0;
    AppMethodBeat.i(289663);
    if ((jBo >= 4) && (jBn != null))
    {
      jBp.setLength(0);
      int j = paramVarArgs.length;
      while (i < j)
      {
        Object localObject = paramVarArgs[i];
        jBp.append(localObject);
        i += 1;
      }
      jBn.d(paramString, jBp.toString());
    }
    AppMethodBeat.o(289663);
  }
  
  public static void e(String paramString1, String paramString2)
  {
    AppMethodBeat.i(289670);
    if ((jBo > 0) && (jBn != null)) {
      jBn.e(paramString1, paramString2);
    }
    AppMethodBeat.o(289670);
  }
  
  public static void e(String paramString1, String paramString2, Throwable paramThrowable)
  {
    AppMethodBeat.i(289671);
    if ((jBo > 0) && (jBn != null)) {
      jBn.e(paramString1, paramString2, paramThrowable);
    }
    AppMethodBeat.o(289671);
  }
  
  public static void e(String paramString, Object... paramVarArgs)
  {
    AppMethodBeat.i(289669);
    if ((jBo > 0) && (jBn != null))
    {
      jBp.setLength(0);
      int i = 0;
      while (i <= 0)
      {
        Object localObject = paramVarArgs[0];
        jBp.append(localObject);
        i += 1;
      }
      jBn.e(paramString, jBp.toString());
    }
    AppMethodBeat.o(289669);
  }
  
  public static void i(String paramString1, String paramString2)
  {
    AppMethodBeat.i(289666);
    if ((jBo >= 3) && (jBn != null)) {
      jBn.i(paramString1, paramString2);
    }
    AppMethodBeat.o(289666);
  }
  
  public static void i(String paramString, Object... paramVarArgs)
  {
    int i = 0;
    AppMethodBeat.i(289665);
    if ((jBo >= 3) && (jBn != null))
    {
      jBp.setLength(0);
      while (i < 2)
      {
        Object localObject = paramVarArgs[i];
        jBp.append(localObject);
        i += 1;
      }
      jBn.i(paramString, jBp.toString());
    }
    AppMethodBeat.o(289665);
  }
  
  public static void v(String paramString1, String paramString2)
  {
    AppMethodBeat.i(289662);
    if ((jBo >= 5) && (jBn != null)) {
      jBn.v(paramString1, paramString2);
    }
    AppMethodBeat.o(289662);
  }
  
  public static void v(String paramString, Object... paramVarArgs)
  {
    int i = 0;
    AppMethodBeat.i(289661);
    if ((jBo >= 5) && (jBn != null))
    {
      jBp.setLength(0);
      int j = paramVarArgs.length;
      while (i < j)
      {
        Object localObject = paramVarArgs[i];
        jBp.append(localObject);
        i += 1;
      }
      jBn.v(paramString, jBp.toString());
    }
    AppMethodBeat.o(289661);
  }
  
  public static void w(String paramString1, String paramString2)
  {
    AppMethodBeat.i(289667);
    if ((jBo >= 2) && (jBn != null)) {
      jBn.w(paramString1, paramString2);
    }
    AppMethodBeat.o(289667);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes9.jar
 * Qualified Name:     com.tencent.mm.danmaku.e.e
 * JD-Core Version:    0.7.0.1
 */