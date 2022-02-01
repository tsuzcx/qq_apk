package com.tencent.mm.normsgext;

import android.content.Context;
import com.tencent.matrix.trace.core.AppMethodBeat;

public final class d$n
{
  private static volatile a mxk = null;
  
  public static void c0(a parama)
  {
    try
    {
      mxk = parama;
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
    //   8: getstatic 13	com/tencent/mm/normsgext/d$n:mxk	Lcom/tencent/mm/normsgext/a;
    //   11: ifnull +22 -> 33
    //   14: getstatic 13	com/tencent/mm/normsgext/d$n:mxk	Lcom/tencent/mm/normsgext/a;
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
    AppMethodBeat.i(248758);
    if (mxk != null)
    {
      String str = mxk.getDeviceId();
      AppMethodBeat.o(248758);
      return str;
    }
    AppMethodBeat.o(248758);
    return "";
  }
  
  private static boolean c11(String paramString, byte[] paramArrayOfByte)
  {
    AppMethodBeat.i(248761);
    if (mxk != null)
    {
      boolean bool = mxk.k(paramString, paramArrayOfByte);
      AppMethodBeat.o(248761);
      return bool;
    }
    AppMethodBeat.o(248761);
    return false;
  }
  
  private static byte[] c12(String paramString)
  {
    AppMethodBeat.i(248763);
    if (mxk != null)
    {
      paramString = mxk.Zy(paramString);
      AppMethodBeat.o(248763);
      return paramString;
    }
    AppMethodBeat.o(248763);
    return new byte[0];
  }
  
  private static void c13(String paramString)
  {
    AppMethodBeat.i(248764);
    if (mxk != null) {
      mxk.Zz(paramString);
    }
    AppMethodBeat.o(248764);
  }
  
  private static String c14()
  {
    AppMethodBeat.i(248765);
    if (mxk != null)
    {
      String str = mxk.auQ();
      AppMethodBeat.o(248765);
      return str;
    }
    AppMethodBeat.o(248765);
    return "";
  }
  
  private static String c15(Context paramContext, String paramString)
  {
    AppMethodBeat.i(248766);
    if (mxk != null)
    {
      paramContext = mxk.H(paramContext, paramString);
      AppMethodBeat.o(248766);
      return paramContext;
    }
    AppMethodBeat.o(248766);
    return paramString;
  }
  
  private static boolean c16(Context paramContext)
  {
    AppMethodBeat.i(248768);
    if (mxk != null)
    {
      boolean bool = mxk.dk(paramContext);
      AppMethodBeat.o(248768);
      return bool;
    }
    AppMethodBeat.o(248768);
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
    //   8: getstatic 13	com/tencent/mm/normsgext/d$n:mxk	Lcom/tencent/mm/normsgext/a;
    //   11: ifnull +22 -> 33
    //   14: getstatic 13	com/tencent/mm/normsgext/d$n:mxk	Lcom/tencent/mm/normsgext/a;
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
      AppMethodBeat.i(248742);
      if (mxk != null) {
        mxk.T(paramInt, paramString);
      }
      AppMethodBeat.o(248742);
      return;
    }
    finally {}
  }
  
  static void c4(int paramInt1, int paramInt2, int paramInt3)
  {
    try
    {
      AppMethodBeat.i(248746);
      if (mxk != null) {
        mxk.R(paramInt1, paramInt2, paramInt3);
      }
      AppMethodBeat.o(248746);
      return;
    }
    finally {}
  }
  
  static void c5(int paramInt1, int paramInt2, int paramInt3, int paramInt4)
  {
    try
    {
      AppMethodBeat.i(248747);
      if (mxk != null) {
        mxk.y(paramInt1, paramInt2, paramInt3, paramInt4);
      }
      AppMethodBeat.o(248747);
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
    //   8: getstatic 13	com/tencent/mm/normsgext/d$n:mxk	Lcom/tencent/mm/normsgext/a;
    //   11: ifnull +22 -> 33
    //   14: getstatic 13	com/tencent/mm/normsgext/d$n:mxk	Lcom/tencent/mm/normsgext/a;
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
    AppMethodBeat.i(248754);
    if (mxk != null)
    {
      boolean bool = mxk.buh();
      AppMethodBeat.o(248754);
      return bool;
    }
    AppMethodBeat.o(248754);
    return false;
  }
  
  private static String c9()
  {
    AppMethodBeat.i(248756);
    if (mxk != null)
    {
      String str = mxk.bui();
      AppMethodBeat.o(248756);
      return str;
    }
    AppMethodBeat.o(248756);
    return "";
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes10.jar
 * Qualified Name:     com.tencent.mm.normsgext.d.n
 * JD-Core Version:    0.7.0.1
 */