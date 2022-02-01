package com.tencent.mm.normsg;

import android.content.Context;
import com.tencent.matrix.trace.core.AppMethodBeat;

final class c
{
  public static final class q
  {
    private static volatile a iHh = null;
    
    public static void c0(a parama)
    {
      try
      {
        iHh = parama;
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
      //   8: getstatic 13	com/tencent/mm/normsg/c$q:iHh	Lcom/tencent/mm/normsg/a;
      //   11: ifnull +22 -> 33
      //   14: getstatic 13	com/tencent/mm/normsg/c$q:iHh	Lcom/tencent/mm/normsg/a;
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
      AppMethodBeat.i(62435);
      if (iHh != null)
      {
        String str = iHh.getDeviceId();
        AppMethodBeat.o(62435);
        return str;
      }
      AppMethodBeat.o(62435);
      return "";
    }
    
    private static boolean c11(String paramString, byte[] paramArrayOfByte)
    {
      AppMethodBeat.i(62436);
      if (iHh != null)
      {
        boolean bool = iHh.k(paramString, paramArrayOfByte);
        AppMethodBeat.o(62436);
        return bool;
      }
      AppMethodBeat.o(62436);
      return false;
    }
    
    private static byte[] c12(String paramString)
    {
      AppMethodBeat.i(62437);
      if (iHh != null)
      {
        paramString = iHh.Ix(paramString);
        AppMethodBeat.o(62437);
        return paramString;
      }
      AppMethodBeat.o(62437);
      return new byte[0];
    }
    
    private static void c13(String paramString)
    {
      AppMethodBeat.i(62438);
      if (iHh != null) {
        iHh.Iy(paramString);
      }
      AppMethodBeat.o(62438);
    }
    
    private static String c14()
    {
      AppMethodBeat.i(62439);
      if (iHh != null)
      {
        String str = iHh.aaC();
        AppMethodBeat.o(62439);
        return str;
      }
      AppMethodBeat.o(62439);
      return "";
    }
    
    private static String c15(Context paramContext, String paramString)
    {
      AppMethodBeat.i(62440);
      if (iHh != null)
      {
        paramContext = iHh.G(paramContext, paramString);
        AppMethodBeat.o(62440);
        return paramContext;
      }
      AppMethodBeat.o(62440);
      return paramString;
    }
    
    private static boolean c16(Context paramContext)
    {
      AppMethodBeat.i(192506);
      if (iHh != null)
      {
        boolean bool = iHh.cQ(paramContext);
        AppMethodBeat.o(192506);
        return bool;
      }
      AppMethodBeat.o(192506);
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
      //   8: getstatic 13	com/tencent/mm/normsg/c$q:iHh	Lcom/tencent/mm/normsg/a;
      //   11: ifnull +22 -> 33
      //   14: getstatic 13	com/tencent/mm/normsg/c$q:iHh	Lcom/tencent/mm/normsg/a;
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
        AppMethodBeat.i(62429);
        if (iHh != null) {
          iHh.O(paramInt, paramString);
        }
        AppMethodBeat.o(62429);
        return;
      }
      finally {}
    }
    
    static void c4(int paramInt1, int paramInt2, int paramInt3)
    {
      try
      {
        AppMethodBeat.i(62430);
        if (iHh != null) {
          iHh.N(paramInt1, paramInt2, paramInt3);
        }
        AppMethodBeat.o(62430);
        return;
      }
      finally {}
    }
    
    static void c5(int paramInt1, int paramInt2, int paramInt3, int paramInt4)
    {
      try
      {
        AppMethodBeat.i(62431);
        if (iHh != null) {
          iHh.w(paramInt1, paramInt2, paramInt3, paramInt4);
        }
        AppMethodBeat.o(62431);
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
      //   8: getstatic 13	com/tencent/mm/normsg/c$q:iHh	Lcom/tencent/mm/normsg/a;
      //   11: ifnull +22 -> 33
      //   14: getstatic 13	com/tencent/mm/normsg/c$q:iHh	Lcom/tencent/mm/normsg/a;
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
      AppMethodBeat.i(62433);
      if (iHh != null)
      {
        boolean bool = iHh.aPy();
        AppMethodBeat.o(62433);
        return bool;
      }
      AppMethodBeat.o(62433);
      return false;
    }
    
    private static String c9()
    {
      AppMethodBeat.i(62434);
      if (iHh != null)
      {
        String str = iHh.aPz();
        AppMethodBeat.o(62434);
        return str;
      }
      AppMethodBeat.o(62434);
      return "";
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.normsg.c
 * JD-Core Version:    0.7.0.1
 */