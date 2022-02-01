package com.tencent.mm.plugin.appbrand;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.pointers.PBool;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.xweb.WebView.PreInitCallback;
import java.util.HashSet;
import java.util.Iterator;
import java.util.Set;

public class ag
{
  private static volatile boolean qxr;
  private static volatile boolean qxs;
  private static final Set<a> qxt;
  
  static
  {
    AppMethodBeat.i(43976);
    qxr = false;
    qxs = false;
    qxt = new HashSet();
    AppMethodBeat.o(43976);
  }
  
  /* Error */
  public static void a(a parama)
  {
    // Byte code:
    //   0: ldc 42
    //   2: invokestatic 24	com/tencent/matrix/trace/core/AppMethodBeat:i	(I)V
    //   5: ldc 2
    //   7: monitorenter
    //   8: getstatic 26	com/tencent/mm/plugin/appbrand/ag:qxr	Z
    //   11: istore_2
    //   12: getstatic 28	com/tencent/mm/plugin/appbrand/ag:qxs	Z
    //   15: istore_3
    //   16: iload_3
    //   17: ifne +21 -> 38
    //   20: getstatic 35	com/tencent/mm/plugin/appbrand/ag:qxt	Ljava/util/Set;
    //   23: aload_0
    //   24: invokeinterface 48 2 0
    //   29: pop
    //   30: iconst_1
    //   31: putstatic 26	com/tencent/mm/plugin/appbrand/ag:qxr	Z
    //   34: iconst_0
    //   35: putstatic 28	com/tencent/mm/plugin/appbrand/ag:qxs	Z
    //   38: iload_2
    //   39: ifeq +12 -> 51
    //   42: ldc 2
    //   44: monitorexit
    //   45: ldc 42
    //   47: invokestatic 38	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   50: return
    //   51: ldc 2
    //   53: monitorexit
    //   54: iload_3
    //   55: ifeq +26 -> 81
    //   58: aload_0
    //   59: invokeinterface 51 1 0
    //   64: ldc 42
    //   66: invokestatic 38	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   69: return
    //   70: astore_0
    //   71: ldc 2
    //   73: monitorexit
    //   74: ldc 42
    //   76: invokestatic 38	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   79: aload_0
    //   80: athrow
    //   81: ldc 53
    //   83: ldc 55
    //   85: invokestatic 60	com/tencent/mm/sdk/platformtools/Log:i	(Ljava/lang/String;Ljava/lang/String;)V
    //   88: invokestatic 66	android/os/Process:myTid	()I
    //   91: invokestatic 70	android/os/Process:getThreadPriority	(I)I
    //   94: istore_1
    //   95: bipush 254
    //   97: invokestatic 75	com/tencent/mm/sdk/platformtools/MMHandlerThread:setCurrentPriority	(I)V
    //   100: invokestatic 81	com/tencent/xweb/ao:kgk	()Z
    //   103: ifeq +16 -> 119
    //   106: invokestatic 84	com/tencent/mm/plugin/appbrand/ag:cdv	()V
    //   109: iload_1
    //   110: invokestatic 75	com/tencent/mm/sdk/platformtools/MMHandlerThread:setCurrentPriority	(I)V
    //   113: ldc 42
    //   115: invokestatic 38	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   118: return
    //   119: new 86	com/tencent/mm/pointers/PBool
    //   122: dup
    //   123: invokespecial 87	com/tencent/mm/pointers/PBool:<init>	()V
    //   126: astore_0
    //   127: invokestatic 92	com/tencent/mm/plugin/appbrand/ui/r:cLr	()Z
    //   130: ifeq +12 -> 142
    //   133: invokestatic 95	com/tencent/mm/plugin/appbrand/ui/r:cLs	()Z
    //   136: ifeq +6 -> 142
    //   139: invokestatic 100	com/tencent/mm/xwebutil/c:jQC	()V
    //   142: getstatic 106	com/tencent/xweb/WebView$WebViewKind:aifI	Lcom/tencent/xweb/WebView$WebViewKind;
    //   145: new 6	com/tencent/mm/plugin/appbrand/ag$1
    //   148: dup
    //   149: aload_0
    //   150: invokespecial 109	com/tencent/mm/plugin/appbrand/ag$1:<init>	(Lcom/tencent/mm/pointers/PBool;)V
    //   153: invokestatic 112	com/tencent/mm/xwebutil/c:a	(Lcom/tencent/xweb/WebView$WebViewKind;Lcom/tencent/xweb/WebView$PreInitCallback;)V
    //   156: aload_0
    //   157: getfield 115	com/tencent/mm/pointers/PBool:value	Z
    //   160: ifeq +16 -> 176
    //   163: invokestatic 84	com/tencent/mm/plugin/appbrand/ag:cdv	()V
    //   166: iload_1
    //   167: invokestatic 75	com/tencent/mm/sdk/platformtools/MMHandlerThread:setCurrentPriority	(I)V
    //   170: ldc 42
    //   172: invokestatic 38	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   175: return
    //   176: ldc 2
    //   178: monitorenter
    //   179: iconst_0
    //   180: putstatic 28	com/tencent/mm/plugin/appbrand/ag:qxs	Z
    //   183: iconst_0
    //   184: putstatic 26	com/tencent/mm/plugin/appbrand/ag:qxr	Z
    //   187: new 30	java/util/HashSet
    //   190: dup
    //   191: getstatic 35	com/tencent/mm/plugin/appbrand/ag:qxt	Ljava/util/Set;
    //   194: invokespecial 118	java/util/HashSet:<init>	(Ljava/util/Collection;)V
    //   197: astore_0
    //   198: getstatic 35	com/tencent/mm/plugin/appbrand/ag:qxt	Ljava/util/Set;
    //   201: invokeinterface 121 1 0
    //   206: ldc 2
    //   208: monitorexit
    //   209: ldc 53
    //   211: ldc 123
    //   213: iconst_1
    //   214: anewarray 4	java/lang/Object
    //   217: dup
    //   218: iconst_0
    //   219: aload_0
    //   220: invokeinterface 126 1 0
    //   225: invokestatic 132	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
    //   228: aastore
    //   229: invokestatic 135	com/tencent/mm/sdk/platformtools/Log:i	(Ljava/lang/String;Ljava/lang/String;[Ljava/lang/Object;)V
    //   232: aload_0
    //   233: invokeinterface 139 1 0
    //   238: astore_0
    //   239: aload_0
    //   240: invokeinterface 144 1 0
    //   245: ifeq -79 -> 166
    //   248: aload_0
    //   249: invokeinterface 148 1 0
    //   254: checkcast 8	com/tencent/mm/plugin/appbrand/ag$a
    //   257: invokeinterface 151 1 0
    //   262: goto -23 -> 239
    //   265: astore_0
    //   266: iload_1
    //   267: invokestatic 75	com/tencent/mm/sdk/platformtools/MMHandlerThread:setCurrentPriority	(I)V
    //   270: ldc 42
    //   272: invokestatic 38	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   275: aload_0
    //   276: athrow
    //   277: astore_0
    //   278: ldc 2
    //   280: monitorexit
    //   281: ldc 42
    //   283: invokestatic 38	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   286: aload_0
    //   287: athrow
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	288	0	parama	a
    //   94	173	1	i	int
    //   11	28	2	bool1	boolean
    //   15	40	3	bool2	boolean
    // Exception table:
    //   from	to	target	type
    //   8	16	70	finally
    //   20	38	70	finally
    //   42	45	70	finally
    //   95	109	265	finally
    //   119	142	265	finally
    //   142	166	265	finally
    //   176	179	265	finally
    //   209	239	265	finally
    //   239	262	265	finally
    //   278	288	265	finally
    //   179	209	277	finally
  }
  
  public static boolean cdu()
  {
    try
    {
      boolean bool = qxs;
      return bool;
    }
    finally
    {
      localObject = finally;
      throw localObject;
    }
  }
  
  private static void cdv()
  {
    AppMethodBeat.i(43975);
    try
    {
      qxs = true;
      qxr = false;
      Object localObject1 = new HashSet(qxt);
      qxt.clear();
      Log.i("MicroMsg.AppBrandXWebPreloader[preload]", "notifyPreloadDone callbacks[%d]", new Object[] { Integer.valueOf(((Set)localObject1).size()) });
      localObject1 = ((Set)localObject1).iterator();
      if (((Iterator)localObject1).hasNext()) {}
      return;
    }
    finally
    {
      AppMethodBeat.o(43975);
    }
  }
  
  public static abstract interface a
  {
    public abstract void cbZ();
    
    public abstract void cca();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.ag
 * JD-Core Version:    0.7.0.1
 */