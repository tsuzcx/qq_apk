package com.tencent.mm.normsg;

import android.content.Context;
import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.ArrayList;
import java.util.List;

public final class c$q
{
  private static volatile a mxj = null;
  
  public static void c0(a parama)
  {
    try
    {
      mxj = parama;
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
    //   8: getstatic 13	com/tencent/mm/normsg/c$q:mxj	Lcom/tencent/mm/normsg/a;
    //   11: ifnull +22 -> 33
    //   14: getstatic 13	com/tencent/mm/normsg/c$q:mxj	Lcom/tencent/mm/normsg/a;
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
    if (mxj != null)
    {
      String str = mxj.getDeviceId();
      AppMethodBeat.o(62435);
      return str;
    }
    AppMethodBeat.o(62435);
    return "";
  }
  
  private static boolean c11(String paramString, byte[] paramArrayOfByte)
  {
    AppMethodBeat.i(62436);
    if (mxj != null)
    {
      boolean bool = mxj.k(paramString, paramArrayOfByte);
      AppMethodBeat.o(62436);
      return bool;
    }
    AppMethodBeat.o(62436);
    return false;
  }
  
  private static byte[] c12(String paramString)
  {
    AppMethodBeat.i(62437);
    if (mxj != null)
    {
      paramString = mxj.Zy(paramString);
      AppMethodBeat.o(62437);
      return paramString;
    }
    AppMethodBeat.o(62437);
    return new byte[0];
  }
  
  private static void c13(String paramString)
  {
    AppMethodBeat.i(62438);
    if (mxj != null) {
      mxj.Zz(paramString);
    }
    AppMethodBeat.o(62438);
  }
  
  private static String c14()
  {
    AppMethodBeat.i(62439);
    if (mxj != null)
    {
      String str = mxj.auQ();
      AppMethodBeat.o(62439);
      return str;
    }
    AppMethodBeat.o(62439);
    return "";
  }
  
  private static String c15(Context paramContext, String paramString)
  {
    AppMethodBeat.i(62440);
    if (mxj != null)
    {
      paramContext = mxj.H(paramContext, paramString);
      AppMethodBeat.o(62440);
      return paramContext;
    }
    AppMethodBeat.o(62440);
    return paramString;
  }
  
  private static boolean c16(Context paramContext)
  {
    AppMethodBeat.i(243966);
    if (mxj != null)
    {
      boolean bool = mxj.dk(paramContext);
      AppMethodBeat.o(243966);
      return bool;
    }
    AppMethodBeat.o(243966);
    return false;
  }
  
  private static boolean c17()
  {
    AppMethodBeat.i(243967);
    if (mxj != null)
    {
      boolean bool = mxj.buj();
      AppMethodBeat.o(243967);
      return bool;
    }
    AppMethodBeat.o(243967);
    return false;
  }
  
  private static String c18()
  {
    AppMethodBeat.i(243968);
    if (mxj != null)
    {
      String str = mxj.getWiFiSsid();
      AppMethodBeat.o(243968);
      return str;
    }
    AppMethodBeat.o(243968);
    return "";
  }
  
  private static String c19()
  {
    AppMethodBeat.i(243969);
    if (mxj != null)
    {
      String str = mxj.getWiFiBssid();
      AppMethodBeat.o(243969);
      return str;
    }
    AppMethodBeat.o(243969);
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
    //   8: getstatic 13	com/tencent/mm/normsg/c$q:mxj	Lcom/tencent/mm/normsg/a;
    //   11: ifnull +22 -> 33
    //   14: getstatic 13	com/tencent/mm/normsg/c$q:mxj	Lcom/tencent/mm/normsg/a;
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
    AppMethodBeat.i(243970);
    if (mxj != null)
    {
      localObject = mxj.buk();
      AppMethodBeat.o(243970);
      return localObject;
    }
    Object localObject = new ArrayList();
    AppMethodBeat.o(243970);
    return localObject;
  }
  
  static void c3(int paramInt, String paramString)
  {
    try
    {
      AppMethodBeat.i(62429);
      if (mxj != null) {
        mxj.T(paramInt, paramString);
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
      if (mxj != null) {
        mxj.R(paramInt1, paramInt2, paramInt3);
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
      if (mxj != null) {
        mxj.y(paramInt1, paramInt2, paramInt3, paramInt4);
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
    //   3: ldc 132
    //   5: invokestatic 28	com/tencent/matrix/trace/core/AppMethodBeat:i	(I)V
    //   8: getstatic 13	com/tencent/mm/normsg/c$q:mxj	Lcom/tencent/mm/normsg/a;
    //   11: ifnull +22 -> 33
    //   14: getstatic 13	com/tencent/mm/normsg/c$q:mxj	Lcom/tencent/mm/normsg/a;
    //   17: invokeinterface 135 1 0
    //   22: astore_0
    //   23: ldc 132
    //   25: invokestatic 36	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   28: ldc 2
    //   30: monitorexit
    //   31: aload_0
    //   32: areturn
    //   33: ldc 38
    //   35: astore_0
    //   36: ldc 132
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
    if (mxj != null)
    {
      boolean bool = mxj.buh();
      AppMethodBeat.o(62433);
      return bool;
    }
    AppMethodBeat.o(62433);
    return false;
  }
  
  private static String c9()
  {
    AppMethodBeat.i(62434);
    if (mxj != null)
    {
      String str = mxj.bui();
      AppMethodBeat.o(62434);
      return str;
    }
    AppMethodBeat.o(62434);
    return "";
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes10.jar
 * Qualified Name:     com.tencent.mm.normsg.c.q
 * JD-Core Version:    0.7.0.1
 */