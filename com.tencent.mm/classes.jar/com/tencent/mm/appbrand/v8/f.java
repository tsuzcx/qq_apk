package com.tencent.mm.appbrand.v8;

import com.eclipsesource.v8.ILoadLibraryDelegate;
import com.eclipsesource.v8.V8;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.compatible.util.j;
import com.tencent.mm.sdk.platformtools.ad;
import com.tencent.mm.sdk.platformtools.bt;
import com.tencent.mm.sdk.platformtools.i;

public final class f
{
  private static boolean cXQ;
  
  static
  {
    AppMethodBeat.i(144000);
    V8.setLoadLibraryDelegate(new ILoadLibraryDelegate()
    {
      public final void loadLibrary(String paramAnonymousString)
      {
        AppMethodBeat.i(143996);
        try
        {
          bt.flT();
          f.access$000();
          h.class.getClassLoader();
          j.vr("mmskia");
          h.class.getClassLoader();
          j.vr("canvas");
          h.class.getClassLoader();
          j.vr("skia-canvas");
          h.class.getClassLoader();
          j.vr("skia-canvas-log-bridge");
          ad.i("MicroMsg.JSRuntimeCreator", "load so done");
          AppMethodBeat.o(143996);
          return;
        }
        catch (Exception paramAnonymousString)
        {
          do
          {
            ad.printErrStackTrace("MicroMsg.JSRuntimeCreator", paramAnonymousString, "", new Object[0]);
          } while ((!i.DEBUG) && (!i.IS_FLAVOR_RED));
          AppMethodBeat.o(143996);
          throw paramAnonymousString;
        }
      }
    });
    cXQ = false;
    AppMethodBeat.o(144000);
  }
  
  /* Error */
  private static void Ns()
  {
    // Byte code:
    //   0: ldc 37
    //   2: invokestatic 17	com/tencent/matrix/trace/core/AppMethodBeat:i	(I)V
    //   5: ldc 2
    //   7: monitorenter
    //   8: getstatic 28	com/tencent/mm/appbrand/v8/f:cXQ	Z
    //   11: ifeq +19 -> 30
    //   14: ldc 39
    //   16: ldc 41
    //   18: invokestatic 46	com/tencent/mm/sdk/platformtools/ad:i	(Ljava/lang/String;Ljava/lang/String;)V
    //   21: ldc 2
    //   23: monitorexit
    //   24: ldc 37
    //   26: invokestatic 31	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   29: return
    //   30: ldc 2
    //   32: monitorexit
    //   33: invokestatic 52	com/tencent/mm/sdk/platformtools/bt:flT	()J
    //   36: lstore_0
    //   37: ldc 54
    //   39: invokevirtual 60	java/lang/Class:getClassLoader	()Ljava/lang/ClassLoader;
    //   42: pop
    //   43: ldc 62
    //   45: invokestatic 68	com/tencent/mm/compatible/util/j:vr	(Ljava/lang/String;)V
    //   48: ldc 54
    //   50: invokevirtual 60	java/lang/Class:getClassLoader	()Ljava/lang/ClassLoader;
    //   53: pop
    //   54: ldc 70
    //   56: invokestatic 68	com/tencent/mm/compatible/util/j:vr	(Ljava/lang/String;)V
    //   59: ldc 54
    //   61: invokevirtual 60	java/lang/Class:getClassLoader	()Ljava/lang/ClassLoader;
    //   64: pop
    //   65: ldc 72
    //   67: invokestatic 68	com/tencent/mm/compatible/util/j:vr	(Ljava/lang/String;)V
    //   70: bipush 6
    //   72: invokestatic 52	com/tencent/mm/sdk/platformtools/bt:flT	()J
    //   75: lload_0
    //   76: lsub
    //   77: iconst_m1
    //   78: aconst_null
    //   79: iconst_m1
    //   80: iconst_m1
    //   81: iconst_m1
    //   82: invokestatic 78	com/tencent/mm/appbrand/v8/x:a	(IJILjava/lang/String;III)V
    //   85: ldc 39
    //   87: ldc 80
    //   89: invokestatic 46	com/tencent/mm/sdk/platformtools/ad:i	(Ljava/lang/String;Ljava/lang/String;)V
    //   92: ldc 2
    //   94: monitorenter
    //   95: iconst_1
    //   96: putstatic 28	com/tencent/mm/appbrand/v8/f:cXQ	Z
    //   99: ldc 2
    //   101: monitorexit
    //   102: ldc 37
    //   104: invokestatic 31	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   107: return
    //   108: astore_2
    //   109: ldc 2
    //   111: monitorexit
    //   112: ldc 37
    //   114: invokestatic 31	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   117: aload_2
    //   118: athrow
    //   119: astore_2
    //   120: ldc 39
    //   122: aload_2
    //   123: ldc 82
    //   125: iconst_0
    //   126: anewarray 4	java/lang/Object
    //   129: invokestatic 86	com/tencent/mm/sdk/platformtools/ad:printErrStackTrace	(Ljava/lang/String;Ljava/lang/Throwable;Ljava/lang/String;[Ljava/lang/Object;)V
    //   132: getstatic 91	com/tencent/mm/sdk/platformtools/i:DEBUG	Z
    //   135: ifne +9 -> 144
    //   138: getstatic 94	com/tencent/mm/sdk/platformtools/i:IS_FLAVOR_RED	Z
    //   141: ifeq -56 -> 85
    //   144: ldc 37
    //   146: invokestatic 31	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   149: aload_2
    //   150: athrow
    //   151: astore_2
    //   152: ldc 2
    //   154: monitorexit
    //   155: ldc 37
    //   157: invokestatic 31	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   160: aload_2
    //   161: athrow
    // Local variable table:
    //   start	length	slot	name	signature
    //   36	40	0	l	long
    //   108	10	2	localObject1	Object
    //   119	31	2	localException	Exception
    //   151	10	2	localObject2	Object
    // Exception table:
    //   from	to	target	type
    //   8	24	108	finally
    //   30	33	108	finally
    //   109	112	108	finally
    //   33	85	119	java/lang/Exception
    //   95	102	151	finally
    //   152	155	151	finally
  }
  
  public static h b(IJSRuntime.Config paramConfig)
  {
    AppMethodBeat.i(143997);
    paramConfig = h.e(paramConfig);
    AppMethodBeat.o(143997);
    return paramConfig;
  }
  
  public static y c(IJSRuntime.Config paramConfig)
  {
    AppMethodBeat.i(143998);
    paramConfig = y.f(paramConfig);
    AppMethodBeat.o(143998);
    return paramConfig;
  }
  
  public static y d(IJSRuntime.Config paramConfig)
  {
    AppMethodBeat.i(143999);
    paramConfig = b.a(paramConfig);
    AppMethodBeat.o(143999);
    return paramConfig;
  }
  
  public static long getNativeTransManager()
  {
    AppMethodBeat.i(198675);
    Ns();
    long l = V8.getNativeTransManager();
    AppMethodBeat.o(198675);
    return l;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.appbrand.v8.f
 * JD-Core Version:    0.7.0.1
 */