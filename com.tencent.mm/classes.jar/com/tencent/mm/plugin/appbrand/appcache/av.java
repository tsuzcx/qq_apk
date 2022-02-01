package com.tencent.mm.plugin.appbrand.appcache;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.appbrand.appstorage.ICommLibReader;

public final class av
{
  private static a qFS;
  private static ICommLibReader qFT = null;
  
  public static void a(a parama)
  {
    qFS = parama;
  }
  
  public static ICommLibReader cgx()
  {
    AppMethodBeat.i(184407);
    try
    {
      ICommLibReader localICommLibReader = qFT;
      com.tencent.mm.sdk.platformtools.Log.i("MicroMsg.AppBrand.WxaCommLibPreloadSessionInMM", "getCurrentAcceptedCommLibReader [%s], stacktrace=%s", new Object[] { localICommLibReader, android.util.Log.getStackTraceString(new Throwable()) });
      AppMethodBeat.o(184407);
      return localICommLibReader;
    }
    finally
    {
      AppMethodBeat.o(184407);
    }
  }
  
  /* Error */
  static void e(ICommLibReader paramICommLibReader)
  {
    // Byte code:
    //   0: iconst_0
    //   1: istore_1
    //   2: ldc 57
    //   4: invokestatic 31	com/tencent/matrix/trace/core/AppMethodBeat:i	(I)V
    //   7: ldc 2
    //   9: monitorenter
    //   10: getstatic 15	com/tencent/mm/plugin/appbrand/appcache/av:qFT	Lcom/tencent/mm/plugin/appbrand/appstorage/ICommLibReader;
    //   13: astore_3
    //   14: aload_3
    //   15: ifnull +9 -> 24
    //   18: aload_3
    //   19: invokeinterface 62 1 0
    //   24: aload_3
    //   25: ifnull +9 -> 34
    //   28: aload_3
    //   29: invokeinterface 62 1 0
    //   34: aload_0
    //   35: putstatic 15	com/tencent/mm/plugin/appbrand/appcache/av:qFT	Lcom/tencent/mm/plugin/appbrand/appstorage/ICommLibReader;
    //   38: ldc 2
    //   40: monitorexit
    //   41: aload_0
    //   42: invokeinterface 66 1 0
    //   47: astore_2
    //   48: getstatic 22	com/tencent/mm/plugin/appbrand/appcache/av:qFS	Lcom/tencent/mm/plugin/appbrand/appcache/av$a;
    //   51: ifnull +5 -> 56
    //   54: iconst_1
    //   55: istore_1
    //   56: ldc 33
    //   58: ldc 68
    //   60: iconst_2
    //   61: anewarray 4	java/lang/Object
    //   64: dup
    //   65: iconst_0
    //   66: aload_2
    //   67: aastore
    //   68: dup
    //   69: iconst_1
    //   70: iload_1
    //   71: invokestatic 74	java/lang/Boolean:valueOf	(Z)Ljava/lang/Boolean;
    //   74: aastore
    //   75: invokestatic 49	com/tencent/mm/sdk/platformtools/Log:i	(Ljava/lang/String;Ljava/lang/String;[Ljava/lang/Object;)V
    //   78: getstatic 22	com/tencent/mm/plugin/appbrand/appcache/av:qFS	Lcom/tencent/mm/plugin/appbrand/appcache/av$a;
    //   81: ifnull +12 -> 93
    //   84: getstatic 22	com/tencent/mm/plugin/appbrand/appcache/av:qFS	Lcom/tencent/mm/plugin/appbrand/appcache/av$a;
    //   87: aload_0
    //   88: invokeinterface 77 2 0
    //   93: ldc 57
    //   95: invokestatic 52	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   98: return
    //   99: astore_2
    //   100: aload_3
    //   101: ifnull +9 -> 110
    //   104: aload_3
    //   105: invokeinterface 62 1 0
    //   110: ldc 57
    //   112: invokestatic 52	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   115: aload_2
    //   116: athrow
    //   117: astore_3
    //   118: aload_2
    //   119: aload_3
    //   120: invokevirtual 81	java/lang/Throwable:addSuppressed	(Ljava/lang/Throwable;)V
    //   123: goto -13 -> 110
    //   126: astore_0
    //   127: ldc 2
    //   129: monitorexit
    //   130: ldc 57
    //   132: invokestatic 52	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   135: aload_0
    //   136: athrow
    //   137: astore_2
    //   138: goto -104 -> 34
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	141	0	paramICommLibReader	ICommLibReader
    //   1	70	1	bool	boolean
    //   47	20	2	str	java.lang.String
    //   99	20	2	localObject	Object
    //   137	1	2	localException	java.lang.Exception
    //   13	92	3	localICommLibReader	ICommLibReader
    //   117	3	3	localThrowable	Throwable
    // Exception table:
    //   from	to	target	type
    //   18	24	99	finally
    //   104	110	117	finally
    //   10	14	126	finally
    //   28	34	126	finally
    //   34	41	126	finally
    //   110	117	126	finally
    //   118	123	126	finally
    //   10	14	137	java/lang/Exception
    //   28	34	137	java/lang/Exception
    //   110	117	137	java/lang/Exception
    //   118	123	137	java/lang/Exception
  }
  
  public static abstract interface a
  {
    public abstract void d(ICommLibReader paramICommLibReader);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.appcache.av
 * JD-Core Version:    0.7.0.1
 */