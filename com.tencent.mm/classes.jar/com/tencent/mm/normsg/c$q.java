package com.tencent.mm.normsg;

import android.content.Context;
import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.ArrayList;
import java.util.List;

public final class c$q
{
  private static volatile a pqI = null;
  
  public static void c0(a parama)
  {
    try
    {
      pqI = parama;
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
    //   8: getstatic 13	com/tencent/mm/normsg/c$q:pqI	Lcom/tencent/mm/normsg/a;
    //   11: ifnull +22 -> 33
    //   14: getstatic 13	com/tencent/mm/normsg/c$q:pqI	Lcom/tencent/mm/normsg/a;
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
    if (pqI != null)
    {
      String str = pqI.bRM();
      AppMethodBeat.o(62435);
      return str;
    }
    AppMethodBeat.o(62435);
    return "";
  }
  
  private static boolean c11(String paramString, byte[] paramArrayOfByte)
  {
    AppMethodBeat.i(62436);
    if (pqI != null)
    {
      boolean bool = pqI.m(paramString, paramArrayOfByte);
      AppMethodBeat.o(62436);
      return bool;
    }
    AppMethodBeat.o(62436);
    return false;
  }
  
  private static byte[] c12(String paramString)
  {
    AppMethodBeat.i(62437);
    if (pqI != null)
    {
      paramString = pqI.RA(paramString);
      AppMethodBeat.o(62437);
      return paramString;
    }
    AppMethodBeat.o(62437);
    return new byte[0];
  }
  
  private static void c13(String paramString)
  {
    AppMethodBeat.i(62438);
    if (pqI != null) {
      pqI.RB(paramString);
    }
    AppMethodBeat.o(62438);
  }
  
  private static String c14()
  {
    AppMethodBeat.i(62439);
    if (pqI != null)
    {
      String str = pqI.aPk();
      AppMethodBeat.o(62439);
      return str;
    }
    AppMethodBeat.o(62439);
    return "";
  }
  
  private static String c15(Context paramContext, String paramString)
  {
    AppMethodBeat.i(62440);
    if (pqI != null)
    {
      paramContext = pqI.M(paramContext, paramString);
      AppMethodBeat.o(62440);
      return paramContext;
    }
    AppMethodBeat.o(62440);
    return paramString;
  }
  
  private static boolean c16(Context paramContext)
  {
    AppMethodBeat.i(236297);
    if (pqI != null)
    {
      boolean bool = pqI.ec(paramContext);
      AppMethodBeat.o(236297);
      return bool;
    }
    AppMethodBeat.o(236297);
    return false;
  }
  
  private static boolean c17()
  {
    AppMethodBeat.i(236302);
    if (pqI != null)
    {
      boolean bool = pqI.bRN();
      AppMethodBeat.o(236302);
      return bool;
    }
    AppMethodBeat.o(236302);
    return false;
  }
  
  private static String c18()
  {
    AppMethodBeat.i(236307);
    if (pqI != null)
    {
      String str = pqI.getWiFiSsid();
      AppMethodBeat.o(236307);
      return str;
    }
    AppMethodBeat.o(236307);
    return "";
  }
  
  private static String c19()
  {
    AppMethodBeat.i(236312);
    if (pqI != null)
    {
      String str = pqI.getWiFiBssid();
      AppMethodBeat.o(236312);
      return str;
    }
    AppMethodBeat.o(236312);
    return "";
  }
  
  /* Error */
  static long c2()
  {
    // Byte code:
    //   0: ldc 2
    //   2: monitorenter
    //   3: ldc 97
    //   5: invokestatic 28	com/tencent/matrix/trace/core/AppMethodBeat:i	(I)V
    //   8: getstatic 13	com/tencent/mm/normsg/c$q:pqI	Lcom/tencent/mm/normsg/a;
    //   11: ifnull +22 -> 33
    //   14: getstatic 13	com/tencent/mm/normsg/c$q:pqI	Lcom/tencent/mm/normsg/a;
    //   17: invokeinterface 100 1 0
    //   22: lstore_0
    //   23: ldc 97
    //   25: invokestatic 36	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   28: ldc 2
    //   30: monitorexit
    //   31: lload_0
    //   32: lreturn
    //   33: lconst_0
    //   34: lstore_0
    //   35: ldc 97
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
  
  private static List<String> c20()
  {
    AppMethodBeat.i(236320);
    if (pqI != null)
    {
      localObject = pqI.bRO();
      AppMethodBeat.o(236320);
      return localObject;
    }
    Object localObject = new ArrayList();
    AppMethodBeat.o(236320);
    return localObject;
  }
  
  private static long c21()
  {
    AppMethodBeat.i(236325);
    if (pqI != null)
    {
      long l = pqI.getGSMSignalStrength();
      AppMethodBeat.o(236325);
      return l;
    }
    AppMethodBeat.o(236325);
    return -1L;
  }
  
  private static String c22()
  {
    AppMethodBeat.i(236337);
    if (pqI != null)
    {
      String str = pqI.getAndroidId();
      if (str == null)
      {
        AppMethodBeat.o(236337);
        return "";
      }
      AppMethodBeat.o(236337);
      return str;
    }
    AppMethodBeat.o(236337);
    return "";
  }
  
  static void c3(int paramInt, String paramString)
  {
    try
    {
      AppMethodBeat.i(62429);
      if (pqI != null) {
        pqI.Y(paramInt, paramString);
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
      if (pqI != null) {
        pqI.W(paramInt1, paramInt2, paramInt3);
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
      if (pqI != null) {
        pqI.E(paramInt1, paramInt2, paramInt3, paramInt4);
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
    //   3: ldc 144
    //   5: invokestatic 28	com/tencent/matrix/trace/core/AppMethodBeat:i	(I)V
    //   8: getstatic 13	com/tencent/mm/normsg/c$q:pqI	Lcom/tencent/mm/normsg/a;
    //   11: ifnull +22 -> 33
    //   14: getstatic 13	com/tencent/mm/normsg/c$q:pqI	Lcom/tencent/mm/normsg/a;
    //   17: invokeinterface 147 1 0
    //   22: astore_0
    //   23: ldc 144
    //   25: invokestatic 36	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   28: ldc 2
    //   30: monitorexit
    //   31: aload_0
    //   32: areturn
    //   33: ldc 38
    //   35: astore_0
    //   36: ldc 144
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
    if (pqI != null)
    {
      boolean bool = pqI.bRK();
      AppMethodBeat.o(62433);
      return bool;
    }
    AppMethodBeat.o(62433);
    return false;
  }
  
  private static String c9()
  {
    AppMethodBeat.i(62434);
    if (pqI != null)
    {
      String str = pqI.bRL();
      AppMethodBeat.o(62434);
      return str;
    }
    AppMethodBeat.o(62434);
    return "";
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes12.jar
 * Qualified Name:     com.tencent.mm.normsg.c.q
 * JD-Core Version:    0.7.0.1
 */