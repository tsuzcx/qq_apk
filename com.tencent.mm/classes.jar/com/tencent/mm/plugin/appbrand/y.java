package com.tencent.mm.plugin.appbrand;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.pointers.PBool;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.xweb.WebView.PreInitCallback;
import java.util.HashSet;
import java.util.Iterator;
import java.util.Set;

public class y
{
  private static volatile boolean kEC;
  private static volatile boolean kED;
  private static final Set<a> kEE;
  
  static
  {
    AppMethodBeat.i(43976);
    kEC = false;
    kED = false;
    kEE = new HashSet();
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
    //   8: getstatic 26	com/tencent/mm/plugin/appbrand/y:kEC	Z
    //   11: istore_2
    //   12: getstatic 28	com/tencent/mm/plugin/appbrand/y:kED	Z
    //   15: istore_3
    //   16: iload_3
    //   17: ifne +21 -> 38
    //   20: getstatic 35	com/tencent/mm/plugin/appbrand/y:kEE	Ljava/util/Set;
    //   23: aload_0
    //   24: invokeinterface 48 2 0
    //   29: pop
    //   30: iconst_1
    //   31: putstatic 26	com/tencent/mm/plugin/appbrand/y:kEC	Z
    //   34: iconst_0
    //   35: putstatic 28	com/tencent/mm/plugin/appbrand/y:kED	Z
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
    //   100: invokestatic 81	com/tencent/xweb/WebView:hasInited	()Z
    //   103: ifeq +16 -> 119
    //   106: invokestatic 84	com/tencent/mm/plugin/appbrand/y:btk	()V
    //   109: iload_1
    //   110: invokestatic 75	com/tencent/mm/sdk/platformtools/MMHandlerThread:setCurrentPriority	(I)V
    //   113: ldc 42
    //   115: invokestatic 38	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   118: return
    //   119: new 86	com/tencent/mm/pointers/PBool
    //   122: dup
    //   123: invokespecial 87	com/tencent/mm/pointers/PBool:<init>	()V
    //   126: astore_0
    //   127: getstatic 93	com/tencent/xweb/WebView$c:SAt	Lcom/tencent/xweb/WebView$c;
    //   130: new 6	com/tencent/mm/plugin/appbrand/y$1
    //   133: dup
    //   134: aload_0
    //   135: invokespecial 96	com/tencent/mm/plugin/appbrand/y$1:<init>	(Lcom/tencent/mm/pointers/PBool;)V
    //   138: invokestatic 101	com/tencent/mm/cr/d:a	(Lcom/tencent/xweb/WebView$c;Lcom/tencent/xweb/WebView$PreInitCallback;)V
    //   141: aload_0
    //   142: getfield 104	com/tencent/mm/pointers/PBool:value	Z
    //   145: ifeq +16 -> 161
    //   148: invokestatic 84	com/tencent/mm/plugin/appbrand/y:btk	()V
    //   151: iload_1
    //   152: invokestatic 75	com/tencent/mm/sdk/platformtools/MMHandlerThread:setCurrentPriority	(I)V
    //   155: ldc 42
    //   157: invokestatic 38	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   160: return
    //   161: ldc 2
    //   163: monitorenter
    //   164: iconst_0
    //   165: putstatic 28	com/tencent/mm/plugin/appbrand/y:kED	Z
    //   168: iconst_0
    //   169: putstatic 26	com/tencent/mm/plugin/appbrand/y:kEC	Z
    //   172: new 30	java/util/HashSet
    //   175: dup
    //   176: getstatic 35	com/tencent/mm/plugin/appbrand/y:kEE	Ljava/util/Set;
    //   179: invokespecial 107	java/util/HashSet:<init>	(Ljava/util/Collection;)V
    //   182: astore_0
    //   183: getstatic 35	com/tencent/mm/plugin/appbrand/y:kEE	Ljava/util/Set;
    //   186: invokeinterface 110 1 0
    //   191: ldc 2
    //   193: monitorexit
    //   194: ldc 53
    //   196: ldc 112
    //   198: iconst_1
    //   199: anewarray 4	java/lang/Object
    //   202: dup
    //   203: iconst_0
    //   204: aload_0
    //   205: invokeinterface 115 1 0
    //   210: invokestatic 121	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
    //   213: aastore
    //   214: invokestatic 124	com/tencent/mm/sdk/platformtools/Log:i	(Ljava/lang/String;Ljava/lang/String;[Ljava/lang/Object;)V
    //   217: aload_0
    //   218: invokeinterface 128 1 0
    //   223: astore_0
    //   224: aload_0
    //   225: invokeinterface 133 1 0
    //   230: ifeq -79 -> 151
    //   233: aload_0
    //   234: invokeinterface 137 1 0
    //   239: checkcast 8	com/tencent/mm/plugin/appbrand/y$a
    //   242: invokeinterface 140 1 0
    //   247: goto -23 -> 224
    //   250: astore_0
    //   251: iload_1
    //   252: invokestatic 75	com/tencent/mm/sdk/platformtools/MMHandlerThread:setCurrentPriority	(I)V
    //   255: ldc 42
    //   257: invokestatic 38	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   260: aload_0
    //   261: athrow
    //   262: astore_0
    //   263: ldc 2
    //   265: monitorexit
    //   266: ldc 42
    //   268: invokestatic 38	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   271: aload_0
    //   272: athrow
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	273	0	parama	a
    //   94	158	1	i	int
    //   11	28	2	bool1	boolean
    //   15	40	3	bool2	boolean
    // Exception table:
    //   from	to	target	type
    //   8	16	70	finally
    //   20	38	70	finally
    //   42	45	70	finally
    //   51	54	70	finally
    //   71	74	70	finally
    //   95	109	250	finally
    //   119	151	250	finally
    //   161	164	250	finally
    //   194	224	250	finally
    //   224	247	250	finally
    //   266	273	250	finally
    //   164	194	262	finally
    //   263	266	262	finally
  }
  
  public static boolean btj()
  {
    try
    {
      boolean bool = kED;
      return bool;
    }
    finally {}
  }
  
  private static void btk()
  {
    AppMethodBeat.i(43975);
    try
    {
      kED = true;
      kEC = false;
      Object localObject1 = new HashSet(kEE);
      kEE.clear();
      Log.i("MicroMsg.AppBrandXWebPreloader[preload]", "notifyPreloadDone callbacks[%d]", new Object[] { Integer.valueOf(((Set)localObject1).size()) });
      localObject1 = ((Set)localObject1).iterator();
      while (((Iterator)localObject1).hasNext()) {
        ((a)((Iterator)localObject1).next()).brW();
      }
      AppMethodBeat.o(43975);
    }
    finally
    {
      AppMethodBeat.o(43975);
    }
  }
  
  public static abstract interface a
  {
    public abstract void brW();
    
    public abstract void brX();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.y
 * JD-Core Version:    0.7.0.1
 */