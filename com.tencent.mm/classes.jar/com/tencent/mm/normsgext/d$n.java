package com.tencent.mm.normsgext;

import android.content.Context;
import com.tencent.matrix.trace.core.AppMethodBeat;

public final class d$n
{
  private static volatile a pqJ = null;
  
  public static void c0(a parama)
  {
    try
    {
      pqJ = parama;
      return;
    }
    finally
    {
      parama = finally;
      throw parama;
    }
  }
  
  /* Error */
  static String c1()
  {
    // Byte code:
    //   0: ldc 2
    //   2: monitorenter
    //   3: ldc 22
    //   5: invokestatic 28	com/tencent/matrix/trace/core/AppMethodBeat:i	(I)V
    //   8: getstatic 13	com/tencent/mm/normsgext/d$n:pqJ	Lcom/tencent/mm/normsgext/a;
    //   11: ifnull +22 -> 33
    //   14: getstatic 13	com/tencent/mm/normsgext/d$n:pqJ	Lcom/tencent/mm/normsgext/a;
    //   17: invokeinterface 33 1 0
    //   22: astore_0
    //   23: ldc 22
    //   25: invokestatic 36	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   28: ldc 2
    //   30: monitorexit
    //   31: aload_0
    //   32: areturn
    //   33: ldc 38
    //   35: astore_0
    //   36: ldc 22
    //   38: invokestatic 36	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   41: goto -13 -> 28
    //   44: astore_0
    //   45: ldc 2
    //   47: monitorexit
    //   48: aload_0
    //   49: athrow
    // Local variable table:
    //   start	length	slot	name	signature
    //   22	14	0	str	String
    //   44	5	0	localObject	Object
    // Exception table:
    //   from	to	target	type
    //   3	28	44	finally
    //   36	41	44	finally
  }
  
  private static String c10()
  {
    AppMethodBeat.i(231283);
    if (pqJ != null)
    {
      String str = pqJ.bRM();
      AppMethodBeat.o(231283);
      return str;
    }
    AppMethodBeat.o(231283);
    return "";
  }
  
  private static boolean c11(String paramString, byte[] paramArrayOfByte)
  {
    AppMethodBeat.i(231284);
    if (pqJ != null)
    {
      boolean bool = pqJ.m(paramString, paramArrayOfByte);
      AppMethodBeat.o(231284);
      return bool;
    }
    AppMethodBeat.o(231284);
    return false;
  }
  
  private static byte[] c12(String paramString)
  {
    AppMethodBeat.i(231289);
    if (pqJ != null)
    {
      paramString = pqJ.RA(paramString);
      AppMethodBeat.o(231289);
      return paramString;
    }
    AppMethodBeat.o(231289);
    return new byte[0];
  }
  
  private static void c13(String paramString)
  {
    AppMethodBeat.i(231292);
    if (pqJ != null) {
      pqJ.RB(paramString);
    }
    AppMethodBeat.o(231292);
  }
  
  private static String c14()
  {
    AppMethodBeat.i(231296);
    if (pqJ != null)
    {
      String str = pqJ.aPk();
      AppMethodBeat.o(231296);
      return str;
    }
    AppMethodBeat.o(231296);
    return "";
  }
  
  private static String c15(Context paramContext, String paramString)
  {
    AppMethodBeat.i(231302);
    if (pqJ != null)
    {
      paramContext = pqJ.M(paramContext, paramString);
      AppMethodBeat.o(231302);
      return paramContext;
    }
    AppMethodBeat.o(231302);
    return paramString;
  }
  
  private static boolean c16(Context paramContext)
  {
    AppMethodBeat.i(231305);
    if (pqJ != null)
    {
      boolean bool = pqJ.ec(paramContext);
      AppMethodBeat.o(231305);
      return bool;
    }
    AppMethodBeat.o(231305);
    return false;
  }
  
  /* Error */
  static long c2()
  {
    // Byte code:
    //   0: ldc 2
    //   2: monitorenter
    //   3: ldc 81
    //   5: invokestatic 28	com/tencent/matrix/trace/core/AppMethodBeat:i	(I)V
    //   8: getstatic 13	com/tencent/mm/normsgext/d$n:pqJ	Lcom/tencent/mm/normsgext/a;
    //   11: ifnull +22 -> 33
    //   14: getstatic 13	com/tencent/mm/normsgext/d$n:pqJ	Lcom/tencent/mm/normsgext/a;
    //   17: invokeinterface 84 1 0
    //   22: lstore_0
    //   23: ldc 81
    //   25: invokestatic 36	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   28: ldc 2
    //   30: monitorexit
    //   31: lload_0
    //   32: lreturn
    //   33: lconst_0
    //   34: lstore_0
    //   35: ldc 81
    //   37: invokestatic 36	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   40: goto -12 -> 28
    //   43: astore_2
    //   44: ldc 2
    //   46: monitorexit
    //   47: aload_2
    //   48: athrow
    // Local variable table:
    //   start	length	slot	name	signature
    //   22	13	0	l	long
    //   43	5	2	localObject	Object
    // Exception table:
    //   from	to	target	type
    //   3	28	43	finally
    //   35	40	43	finally
  }
  
  static void c3(int paramInt, String paramString)
  {
    try
    {
      AppMethodBeat.i(231275);
      if (pqJ != null) {
        pqJ.Y(paramInt, paramString);
      }
      AppMethodBeat.o(231275);
      return;
    }
    finally {}
  }
  
  static void c4(int paramInt1, int paramInt2, int paramInt3)
  {
    try
    {
      AppMethodBeat.i(231276);
      if (pqJ != null) {
        pqJ.W(paramInt1, paramInt2, paramInt3);
      }
      AppMethodBeat.o(231276);
      return;
    }
    finally {}
  }
  
  static void c5(int paramInt1, int paramInt2, int paramInt3, int paramInt4)
  {
    try
    {
      AppMethodBeat.i(231277);
      if (pqJ != null) {
        pqJ.E(paramInt1, paramInt2, paramInt3, paramInt4);
      }
      AppMethodBeat.o(231277);
      return;
    }
    finally {}
  }
  
  static String c6()
  {
    return "";
  }
  
  /* Error */
  static String c7()
  {
    // Byte code:
    //   0: ldc 2
    //   2: monitorenter
    //   3: ldc 105
    //   5: invokestatic 28	com/tencent/matrix/trace/core/AppMethodBeat:i	(I)V
    //   8: getstatic 13	com/tencent/mm/normsgext/d$n:pqJ	Lcom/tencent/mm/normsgext/a;
    //   11: ifnull +22 -> 33
    //   14: getstatic 13	com/tencent/mm/normsgext/d$n:pqJ	Lcom/tencent/mm/normsgext/a;
    //   17: invokeinterface 108 1 0
    //   22: astore_0
    //   23: ldc 105
    //   25: invokestatic 36	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   28: ldc 2
    //   30: monitorexit
    //   31: aload_0
    //   32: areturn
    //   33: ldc 38
    //   35: astore_0
    //   36: ldc 105
    //   38: invokestatic 36	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   41: goto -13 -> 28
    //   44: astore_0
    //   45: ldc 2
    //   47: monitorexit
    //   48: aload_0
    //   49: athrow
    // Local variable table:
    //   start	length	slot	name	signature
    //   22	14	0	str	String
    //   44	5	0	localObject	Object
    // Exception table:
    //   from	to	target	type
    //   3	28	44	finally
    //   36	41	44	finally
  }
  
  private static boolean c8()
  {
    AppMethodBeat.i(231281);
    if (pqJ != null)
    {
      boolean bool = pqJ.bRK();
      AppMethodBeat.o(231281);
      return bool;
    }
    AppMethodBeat.o(231281);
    return false;
  }
  
  private static String c9()
  {
    AppMethodBeat.i(231282);
    if (pqJ != null)
    {
      String str = pqJ.bRL();
      AppMethodBeat.o(231282);
      return str;
    }
    AppMethodBeat.o(231282);
    return "";
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes12.jar
 * Qualified Name:     com.tencent.mm.normsgext.d.n
 * JD-Core Version:    0.7.0.1
 */