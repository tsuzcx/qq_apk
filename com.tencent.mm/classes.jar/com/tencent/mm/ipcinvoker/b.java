package com.tencent.mm.ipcinvoker;

import android.content.ServiceConnection;
import android.os.Handler;
import android.os.HandlerThread;
import com.tencent.mm.ipcinvoker.b.a;
import java.util.HashMap;
import java.util.Map;
import java.util.Set;
import java.util.concurrent.ConcurrentHashMap;

public class b
{
  private static volatile b dGq;
  Map<String, Class<?>> dGr = new HashMap();
  public Map<String, a> dGs = new ConcurrentHashMap();
  private volatile boolean dGt;
  Map<String, Set<j>> dGu;
  private Handler mHandler;
  
  private b()
  {
    HandlerThread localHandlerThread = new HandlerThread("IPCBridgeThread#" + hashCode());
    localHandlerThread.start();
    this.mHandler = new Handler(localHandlerThread.getLooper());
    this.dGu = new HashMap();
  }
  
  public static b BT()
  {
    if (dGq == null) {}
    try
    {
      if (dGq == null) {
        dGq = new b();
      }
      return dGq;
    }
    finally {}
  }
  
  public final void BU()
  {
    try
    {
      this.dGt = true;
      return;
    }
    finally
    {
      localObject = finally;
      throw localObject;
    }
  }
  
  /* Error */
  public final a fB(String paramString)
  {
    // Byte code:
    //   0: aload_0
    //   1: getfield 34	com/tencent/mm/ipcinvoker/b:dGs	Ljava/util/Map;
    //   4: aload_1
    //   5: invokeinterface 86 2 0
    //   10: checkcast 6	com/tencent/mm/ipcinvoker/b$a
    //   13: astore 4
    //   15: aload 4
    //   17: ifnonnull +504 -> 521
    //   20: aload_0
    //   21: getfield 112	com/tencent/mm/ipcinvoker/b:dGt	Z
    //   24: ifeq +20 -> 44
    //   27: ldc 120
    //   29: ldc 122
    //   31: iconst_1
    //   32: anewarray 4	java/lang/Object
    //   35: dup
    //   36: iconst_0
    //   37: aload_1
    //   38: aastore
    //   39: invokestatic 128	com/tencent/mm/ipcinvoker/h/b:i	(Ljava/lang/String;Ljava/lang/String;[Ljava/lang/Object;)V
    //   42: aconst_null
    //   43: areturn
    //   44: invokestatic 133	android/os/Looper:getMainLooper	()Landroid/os/Looper;
    //   47: invokestatic 136	android/os/Looper:myLooper	()Landroid/os/Looper;
    //   50: if_acmpne +16 -> 66
    //   53: ldc 120
    //   55: ldc 138
    //   57: iconst_0
    //   58: anewarray 4	java/lang/Object
    //   61: invokestatic 141	com/tencent/mm/ipcinvoker/h/b:w	(Ljava/lang/String;Ljava/lang/String;[Ljava/lang/Object;)V
    //   64: aconst_null
    //   65: areturn
    //   66: aload_0
    //   67: getfield 29	com/tencent/mm/ipcinvoker/b:dGr	Ljava/util/Map;
    //   70: aload_1
    //   71: invokeinterface 86 2 0
    //   76: checkcast 143	java/lang/Class
    //   79: astore 5
    //   81: aload 5
    //   83: ifnonnull +20 -> 103
    //   86: ldc 120
    //   88: ldc 145
    //   90: iconst_1
    //   91: anewarray 4	java/lang/Object
    //   94: dup
    //   95: iconst_0
    //   96: aload_1
    //   97: aastore
    //   98: invokestatic 141	com/tencent/mm/ipcinvoker/h/b:w	(Ljava/lang/String;Ljava/lang/String;[Ljava/lang/Object;)V
    //   101: aconst_null
    //   102: areturn
    //   103: new 6	com/tencent/mm/ipcinvoker/b$a
    //   106: dup
    //   107: iconst_0
    //   108: invokespecial 148	com/tencent/mm/ipcinvoker/b$a:<init>	(B)V
    //   111: astore 4
    //   113: aload_0
    //   114: getfield 34	com/tencent/mm/ipcinvoker/b:dGs	Ljava/util/Map;
    //   117: astore 6
    //   119: aload 6
    //   121: monitorenter
    //   122: aload_0
    //   123: getfield 34	com/tencent/mm/ipcinvoker/b:dGs	Ljava/util/Map;
    //   126: aload_1
    //   127: aload 4
    //   129: invokeinterface 152 3 0
    //   134: pop
    //   135: aload 6
    //   137: monitorexit
    //   138: aload 4
    //   140: monitorenter
    //   141: aload 4
    //   143: iconst_1
    //   144: putfield 155	com/tencent/mm/ipcinvoker/b$a:dGB	Z
    //   147: aload 4
    //   149: monitorexit
    //   150: invokestatic 161	com/tencent/mm/ipcinvoker/e:getContext	()Landroid/content/Context;
    //   153: astore 6
    //   155: aload 4
    //   157: new 163	com/tencent/mm/ipcinvoker/b$1
    //   160: dup
    //   161: aload_0
    //   162: aload 4
    //   164: aload 6
    //   166: aload_1
    //   167: invokespecial 166	com/tencent/mm/ipcinvoker/b$1:<init>	(Lcom/tencent/mm/ipcinvoker/b;Lcom/tencent/mm/ipcinvoker/b$a;Landroid/content/Context;Ljava/lang/String;)V
    //   170: putfield 170	com/tencent/mm/ipcinvoker/b$a:dGA	Landroid/content/ServiceConnection;
    //   173: new 172	android/content/Intent
    //   176: dup
    //   177: aload 6
    //   179: aload 5
    //   181: invokespecial 175	android/content/Intent:<init>	(Landroid/content/Context;Ljava/lang/Class;)V
    //   184: astore 5
    //   186: ldc 120
    //   188: ldc 177
    //   190: iconst_3
    //   191: anewarray 4	java/lang/Object
    //   194: dup
    //   195: iconst_0
    //   196: aload 4
    //   198: invokevirtual 47	java/lang/Object:hashCode	()I
    //   201: invokestatic 183	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
    //   204: aastore
    //   205: dup
    //   206: iconst_1
    //   207: invokestatic 189	java/lang/Thread:currentThread	()Ljava/lang/Thread;
    //   210: invokevirtual 193	java/lang/Thread:getId	()J
    //   213: invokestatic 198	java/lang/Long:valueOf	(J)Ljava/lang/Long;
    //   216: aastore
    //   217: dup
    //   218: iconst_2
    //   219: aload 5
    //   221: aastore
    //   222: invokestatic 128	com/tencent/mm/ipcinvoker/h/b:i	(Ljava/lang/String;Ljava/lang/String;[Ljava/lang/Object;)V
    //   225: aload 6
    //   227: aload 5
    //   229: aload 4
    //   231: getfield 170	com/tencent/mm/ipcinvoker/b$a:dGA	Landroid/content/ServiceConnection;
    //   234: bipush 33
    //   236: invokevirtual 204	android/content/Context:bindService	(Landroid/content/Intent;Landroid/content/ServiceConnection;I)Z
    //   239: pop
    //   240: aload 4
    //   242: new 206	com/tencent/mm/ipcinvoker/b$2
    //   245: dup
    //   246: aload_0
    //   247: aload 4
    //   249: aload_1
    //   250: invokespecial 209	com/tencent/mm/ipcinvoker/b$2:<init>	(Lcom/tencent/mm/ipcinvoker/b;Lcom/tencent/mm/ipcinvoker/b$a;Ljava/lang/String;)V
    //   253: putfield 213	com/tencent/mm/ipcinvoker/b$a:dGC	Ljava/lang/Runnable;
    //   256: aload_0
    //   257: getfield 70	com/tencent/mm/ipcinvoker/b:mHandler	Landroid/os/Handler;
    //   260: astore 5
    //   262: aload 4
    //   264: getfield 213	com/tencent/mm/ipcinvoker/b$a:dGC	Ljava/lang/Runnable;
    //   267: astore 6
    //   269: invokestatic 136	android/os/Looper:myLooper	()Landroid/os/Looper;
    //   272: invokestatic 133	android/os/Looper:getMainLooper	()Landroid/os/Looper;
    //   275: if_acmpne +67 -> 342
    //   278: ldc2_w 214
    //   281: lstore_2
    //   282: aload 5
    //   284: aload 6
    //   286: lload_2
    //   287: invokevirtual 219	android/os/Handler:postDelayed	(Ljava/lang/Runnable;J)Z
    //   290: pop
    //   291: aload 4
    //   293: monitorenter
    //   294: aload 4
    //   296: getfield 155	com/tencent/mm/ipcinvoker/b$a:dGB	Z
    //   299: ifeq +8 -> 307
    //   302: aload 4
    //   304: invokevirtual 222	java/lang/Object:wait	()V
    //   307: aload 4
    //   309: monitorexit
    //   310: aload 4
    //   312: monitorenter
    //   313: aload 4
    //   315: iconst_0
    //   316: putfield 155	com/tencent/mm/ipcinvoker/b$a:dGB	Z
    //   319: aload 4
    //   321: monitorexit
    //   322: aload 4
    //   324: astore_1
    //   325: aload_1
    //   326: getfield 226	com/tencent/mm/ipcinvoker/b$a:dGz	Lcom/tencent/mm/ipcinvoker/b/a;
    //   329: areturn
    //   330: astore_1
    //   331: aload 6
    //   333: monitorexit
    //   334: aload_1
    //   335: athrow
    //   336: astore_1
    //   337: aload 4
    //   339: monitorexit
    //   340: aload_1
    //   341: athrow
    //   342: ldc2_w 227
    //   345: lstore_2
    //   346: goto -64 -> 282
    //   349: astore 5
    //   351: aload 4
    //   353: monitorexit
    //   354: aload 5
    //   356: athrow
    //   357: astore 5
    //   359: ldc 120
    //   361: ldc 230
    //   363: iconst_1
    //   364: anewarray 4	java/lang/Object
    //   367: dup
    //   368: iconst_0
    //   369: aload 5
    //   371: aastore
    //   372: invokestatic 233	com/tencent/mm/ipcinvoker/h/b:e	(Ljava/lang/String;Ljava/lang/String;[Ljava/lang/Object;)V
    //   375: aload_0
    //   376: getfield 34	com/tencent/mm/ipcinvoker/b:dGs	Ljava/util/Map;
    //   379: astore 5
    //   381: aload 5
    //   383: monitorenter
    //   384: aload_0
    //   385: getfield 34	com/tencent/mm/ipcinvoker/b:dGs	Ljava/util/Map;
    //   388: aload_1
    //   389: invokeinterface 236 2 0
    //   394: pop
    //   395: aload 5
    //   397: monitorexit
    //   398: aload 4
    //   400: monitorenter
    //   401: aload 4
    //   403: iconst_0
    //   404: putfield 155	com/tencent/mm/ipcinvoker/b$a:dGB	Z
    //   407: aload 4
    //   409: monitorexit
    //   410: aconst_null
    //   411: areturn
    //   412: astore_1
    //   413: aload 4
    //   415: monitorexit
    //   416: aload_1
    //   417: athrow
    //   418: astore_1
    //   419: aload 5
    //   421: monitorexit
    //   422: aload_1
    //   423: athrow
    //   424: astore_1
    //   425: aload 4
    //   427: monitorenter
    //   428: aload 4
    //   430: iconst_0
    //   431: putfield 155	com/tencent/mm/ipcinvoker/b$a:dGB	Z
    //   434: aload 4
    //   436: monitorexit
    //   437: aload_1
    //   438: athrow
    //   439: astore_1
    //   440: aload 4
    //   442: monitorexit
    //   443: aload_1
    //   444: athrow
    //   445: astore 5
    //   447: ldc 120
    //   449: ldc 238
    //   451: iconst_1
    //   452: anewarray 4	java/lang/Object
    //   455: dup
    //   456: iconst_0
    //   457: aload 5
    //   459: invokestatic 244	android/util/Log:getStackTraceString	(Ljava/lang/Throwable;)Ljava/lang/String;
    //   462: aastore
    //   463: invokestatic 233	com/tencent/mm/ipcinvoker/h/b:e	(Ljava/lang/String;Ljava/lang/String;[Ljava/lang/Object;)V
    //   466: aload_0
    //   467: getfield 34	com/tencent/mm/ipcinvoker/b:dGs	Ljava/util/Map;
    //   470: astore 5
    //   472: aload 5
    //   474: monitorenter
    //   475: aload_0
    //   476: getfield 34	com/tencent/mm/ipcinvoker/b:dGs	Ljava/util/Map;
    //   479: aload_1
    //   480: invokeinterface 236 2 0
    //   485: pop
    //   486: aload 5
    //   488: monitorexit
    //   489: aload 4
    //   491: monitorenter
    //   492: aload 4
    //   494: iconst_0
    //   495: putfield 155	com/tencent/mm/ipcinvoker/b$a:dGB	Z
    //   498: aload 4
    //   500: monitorexit
    //   501: aconst_null
    //   502: areturn
    //   503: astore_1
    //   504: aload 5
    //   506: monitorexit
    //   507: aload_1
    //   508: athrow
    //   509: astore_1
    //   510: aload 4
    //   512: monitorexit
    //   513: aload_1
    //   514: athrow
    //   515: astore_1
    //   516: aload 4
    //   518: monitorexit
    //   519: aload_1
    //   520: athrow
    //   521: aload 4
    //   523: astore_1
    //   524: aload 4
    //   526: getfield 155	com/tencent/mm/ipcinvoker/b$a:dGB	Z
    //   529: ifeq -204 -> 325
    //   532: aload 4
    //   534: monitorenter
    //   535: aload 4
    //   537: getfield 155	com/tencent/mm/ipcinvoker/b$a:dGB	Z
    //   540: ifeq +8 -> 548
    //   543: aload 4
    //   545: invokevirtual 222	java/lang/Object:wait	()V
    //   548: aload 4
    //   550: monitorexit
    //   551: aload 4
    //   553: astore_1
    //   554: goto -229 -> 325
    //   557: astore_1
    //   558: aload 4
    //   560: monitorexit
    //   561: aload_1
    //   562: athrow
    //   563: astore_1
    //   564: ldc 120
    //   566: ldc 230
    //   568: iconst_1
    //   569: anewarray 4	java/lang/Object
    //   572: dup
    //   573: iconst_0
    //   574: aload_1
    //   575: aastore
    //   576: invokestatic 233	com/tencent/mm/ipcinvoker/h/b:e	(Ljava/lang/String;Ljava/lang/String;[Ljava/lang/Object;)V
    //   579: aload 4
    //   581: astore_1
    //   582: goto -257 -> 325
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	585	0	this	b
    //   0	585	1	paramString	String
    //   281	65	2	l	long
    //   13	567	4	locala	a
    //   79	204	5	localObject1	Object
    //   349	6	5	localObject2	Object
    //   357	13	5	localInterruptedException	java.lang.InterruptedException
    //   379	41	5	localMap1	Map
    //   445	13	5	localSecurityException	java.lang.SecurityException
    //   117	215	6	localObject3	Object
    // Exception table:
    //   from	to	target	type
    //   122	138	330	finally
    //   331	334	330	finally
    //   141	150	336	finally
    //   337	340	336	finally
    //   294	307	349	finally
    //   307	310	349	finally
    //   351	354	349	finally
    //   173	278	357	java/lang/InterruptedException
    //   282	294	357	java/lang/InterruptedException
    //   354	357	357	java/lang/InterruptedException
    //   313	322	412	finally
    //   413	416	412	finally
    //   384	398	418	finally
    //   419	422	418	finally
    //   173	278	424	finally
    //   282	294	424	finally
    //   354	357	424	finally
    //   359	384	424	finally
    //   422	424	424	finally
    //   447	475	424	finally
    //   507	509	424	finally
    //   401	410	439	finally
    //   440	443	439	finally
    //   173	278	445	java/lang/SecurityException
    //   282	294	445	java/lang/SecurityException
    //   354	357	445	java/lang/SecurityException
    //   475	489	503	finally
    //   504	507	503	finally
    //   492	501	509	finally
    //   510	513	509	finally
    //   428	437	515	finally
    //   516	519	515	finally
    //   535	548	557	finally
    //   548	551	557	finally
    //   558	561	557	finally
    //   532	535	563	java/lang/InterruptedException
    //   561	563	563	java/lang/InterruptedException
  }
  
  public final boolean fC(String paramString)
  {
    if (e.fE(paramString)) {}
    while (this.dGs.get(paramString) == null) {
      return false;
    }
    return true;
  }
  
  public final void fD(String paramString)
  {
    if (e.fE(paramString))
    {
      com.tencent.mm.ipcinvoker.h.b.i("IPC.IPCBridgeManager", "the same process(%s), do not need to release IPCBridge.", new Object[] { paramString });
      return;
    }
    a locala;
    synchronized (this.dGs)
    {
      locala = (a)this.dGs.get(paramString);
      if (locala == null)
      {
        com.tencent.mm.ipcinvoker.h.b.i("IPC.IPCBridgeManager", "releaseIPCBridge(%s) failed, IPCBridgeWrapper is null.", new Object[] { paramString });
        return;
      }
    }
    if (locala.dGB) {}
    try
    {
      locala.dGB = false;
      locala.notifyAll();
      if (locala.dGA == null)
      {
        com.tencent.mm.ipcinvoker.h.b.i("IPC.IPCBridgeManager", "releaseIPCBridge(%s) failed, ServiceConnection is null.", new Object[] { paramString });
        return;
      }
    }
    finally {}
    this.mHandler.post(new b.3(this, locala, paramString));
  }
  
  private static final class a
  {
    ServiceConnection dGA;
    public volatile boolean dGB;
    Runnable dGC;
    a dGz;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.ipcinvoker.b
 * JD-Core Version:    0.7.0.1
 */