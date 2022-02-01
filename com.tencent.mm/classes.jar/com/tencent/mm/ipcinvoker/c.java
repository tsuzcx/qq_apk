package com.tencent.mm.ipcinvoker;

import android.content.ComponentName;
import android.content.Context;
import android.content.ServiceConnection;
import android.os.Handler;
import android.os.IBinder;
import android.os.IBinder.DeathRecipient;
import android.os.RemoteException;
import android.util.Log;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ipcinvoker.b.a.a;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;
import java.util.concurrent.ConcurrentHashMap;

public class c
{
  private static volatile c hmH;
  Map<String, Class<?>> hmI;
  public final Map<String, a> hmJ;
  private volatile boolean hmK;
  final Map<String, Set<n>> hmL;
  final Map<String, Set<m>> hmM;
  private Handler mHandler;
  
  private c()
  {
    AppMethodBeat.i(158722);
    this.hmI = new HashMap();
    this.hmJ = new ConcurrentHashMap();
    this.mHandler = l.ayc();
    this.hmL = new HashMap();
    this.hmM = new HashMap();
    AppMethodBeat.o(158722);
  }
  
  public static c axW()
  {
    AppMethodBeat.i(158721);
    if (hmH == null) {}
    try
    {
      if (hmH == null) {
        hmH = new c();
      }
      c localc = hmH;
      AppMethodBeat.o(158721);
      return localc;
    }
    finally
    {
      AppMethodBeat.o(158721);
    }
  }
  
  /* Error */
  public final com.tencent.mm.ipcinvoker.b.a Fn(final String paramString)
  {
    // Byte code:
    //   0: ldc 126
    //   2: invokestatic 43	com/tencent/matrix/trace/core/AppMethodBeat:i	(I)V
    //   5: ldc 128
    //   7: ldc 130
    //   9: iconst_1
    //   10: anewarray 4	java/lang/Object
    //   13: dup
    //   14: iconst_0
    //   15: aload_1
    //   16: aastore
    //   17: invokestatic 135	com/tencent/mm/ipcinvoker/h/b:i	(Ljava/lang/String;Ljava/lang/String;[Ljava/lang/Object;)V
    //   20: aload_0
    //   21: getfield 53	com/tencent/mm/ipcinvoker/c:hmJ	Ljava/util/Map;
    //   24: aload_1
    //   25: invokeinterface 91 2 0
    //   30: checkcast 16	com/tencent/mm/ipcinvoker/c$a
    //   33: astore 4
    //   35: aload 4
    //   37: ifnonnull +546 -> 583
    //   40: aload_0
    //   41: getfield 137	com/tencent/mm/ipcinvoker/c:hmK	Z
    //   44: ifeq +25 -> 69
    //   47: ldc 128
    //   49: ldc 139
    //   51: iconst_1
    //   52: anewarray 4	java/lang/Object
    //   55: dup
    //   56: iconst_0
    //   57: aload_1
    //   58: aastore
    //   59: invokestatic 135	com/tencent/mm/ipcinvoker/h/b:i	(Ljava/lang/String;Ljava/lang/String;[Ljava/lang/Object;)V
    //   62: ldc 126
    //   64: invokestatic 68	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   67: aconst_null
    //   68: areturn
    //   69: invokestatic 145	android/os/Looper:getMainLooper	()Landroid/os/Looper;
    //   72: invokestatic 148	android/os/Looper:myLooper	()Landroid/os/Looper;
    //   75: if_acmpne +21 -> 96
    //   78: ldc 128
    //   80: ldc 150
    //   82: iconst_0
    //   83: anewarray 4	java/lang/Object
    //   86: invokestatic 153	com/tencent/mm/ipcinvoker/h/b:w	(Ljava/lang/String;Ljava/lang/String;[Ljava/lang/Object;)V
    //   89: ldc 126
    //   91: invokestatic 68	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   94: aconst_null
    //   95: areturn
    //   96: aload_1
    //   97: invokestatic 159	com/tencent/mm/ipcinvoker/g:getContext	()Landroid/content/Context;
    //   100: invokevirtual 165	android/content/Context:getPackageName	()Ljava/lang/String;
    //   103: invokestatic 171	com/tencent/mm/ipcinvoker/h/c:ar	(Ljava/lang/String;Ljava/lang/String;)Ljava/lang/String;
    //   106: astore 5
    //   108: aload_0
    //   109: getfield 48	com/tencent/mm/ipcinvoker/c:hmI	Ljava/util/Map;
    //   112: new 173	java/lang/StringBuilder
    //   115: dup
    //   116: invokespecial 174	java/lang/StringBuilder:<init>	()V
    //   119: aload 5
    //   121: invokevirtual 178	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   124: bipush 47
    //   126: invokevirtual 181	java/lang/StringBuilder:append	(C)Ljava/lang/StringBuilder;
    //   129: aload_1
    //   130: invokevirtual 178	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   133: invokevirtual 184	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   136: invokeinterface 91 2 0
    //   141: checkcast 186	java/lang/Class
    //   144: astore 6
    //   146: aload 6
    //   148: ifnonnull +25 -> 173
    //   151: ldc 128
    //   153: ldc 188
    //   155: iconst_1
    //   156: anewarray 4	java/lang/Object
    //   159: dup
    //   160: iconst_0
    //   161: aload_1
    //   162: aastore
    //   163: invokestatic 153	com/tencent/mm/ipcinvoker/h/b:w	(Ljava/lang/String;Ljava/lang/String;[Ljava/lang/Object;)V
    //   166: ldc 126
    //   168: invokestatic 68	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   171: aconst_null
    //   172: areturn
    //   173: new 16	com/tencent/mm/ipcinvoker/c$a
    //   176: dup
    //   177: iconst_0
    //   178: invokespecial 191	com/tencent/mm/ipcinvoker/c$a:<init>	(B)V
    //   181: astore 4
    //   183: aload_0
    //   184: getfield 53	com/tencent/mm/ipcinvoker/c:hmJ	Ljava/util/Map;
    //   187: astore 7
    //   189: aload 7
    //   191: monitorenter
    //   192: aload_0
    //   193: getfield 53	com/tencent/mm/ipcinvoker/c:hmJ	Ljava/util/Map;
    //   196: aload_1
    //   197: aload 4
    //   199: invokeinterface 195 3 0
    //   204: pop
    //   205: aload 7
    //   207: monitorexit
    //   208: aload 4
    //   210: monitorenter
    //   211: aload 4
    //   213: iconst_1
    //   214: putfield 198	com/tencent/mm/ipcinvoker/c$a:hmV	Z
    //   217: aload 4
    //   219: monitorexit
    //   220: invokestatic 159	com/tencent/mm/ipcinvoker/g:getContext	()Landroid/content/Context;
    //   223: astore 7
    //   225: aload 4
    //   227: new 6	com/tencent/mm/ipcinvoker/c$1
    //   230: dup
    //   231: aload_0
    //   232: aload 4
    //   234: aload 7
    //   236: aload_1
    //   237: invokespecial 201	com/tencent/mm/ipcinvoker/c$1:<init>	(Lcom/tencent/mm/ipcinvoker/c;Lcom/tencent/mm/ipcinvoker/c$a;Landroid/content/Context;Ljava/lang/String;)V
    //   240: putfield 205	com/tencent/mm/ipcinvoker/c$a:serviceConnection	Landroid/content/ServiceConnection;
    //   243: new 207	android/content/Intent
    //   246: dup
    //   247: invokespecial 208	android/content/Intent:<init>	()V
    //   250: aload 5
    //   252: aload 6
    //   254: invokevirtual 211	java/lang/Class:getCanonicalName	()Ljava/lang/String;
    //   257: invokevirtual 215	android/content/Intent:setClassName	(Ljava/lang/String;Ljava/lang/String;)Landroid/content/Intent;
    //   260: astore 5
    //   262: ldc 128
    //   264: ldc 217
    //   266: iconst_3
    //   267: anewarray 4	java/lang/Object
    //   270: dup
    //   271: iconst_0
    //   272: aload 4
    //   274: invokevirtual 221	java/lang/Object:hashCode	()I
    //   277: invokestatic 227	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
    //   280: aastore
    //   281: dup
    //   282: iconst_1
    //   283: invokestatic 233	java/lang/Thread:currentThread	()Ljava/lang/Thread;
    //   286: invokevirtual 237	java/lang/Thread:getId	()J
    //   289: invokestatic 242	java/lang/Long:valueOf	(J)Ljava/lang/Long;
    //   292: aastore
    //   293: dup
    //   294: iconst_2
    //   295: aload 5
    //   297: aastore
    //   298: invokestatic 135	com/tencent/mm/ipcinvoker/h/b:i	(Ljava/lang/String;Ljava/lang/String;[Ljava/lang/Object;)V
    //   301: aload 7
    //   303: aload 5
    //   305: aload 4
    //   307: getfield 205	com/tencent/mm/ipcinvoker/c$a:serviceConnection	Landroid/content/ServiceConnection;
    //   310: bipush 33
    //   312: invokevirtual 246	android/content/Context:bindService	(Landroid/content/Intent;Landroid/content/ServiceConnection;I)Z
    //   315: pop
    //   316: aload 4
    //   318: new 10	com/tencent/mm/ipcinvoker/c$2
    //   321: dup
    //   322: aload_0
    //   323: aload 4
    //   325: aload_1
    //   326: invokespecial 249	com/tencent/mm/ipcinvoker/c$2:<init>	(Lcom/tencent/mm/ipcinvoker/c;Lcom/tencent/mm/ipcinvoker/c$a;Ljava/lang/String;)V
    //   329: putfield 253	com/tencent/mm/ipcinvoker/c$a:hmW	Ljava/lang/Runnable;
    //   332: aload_0
    //   333: getfield 61	com/tencent/mm/ipcinvoker/c:mHandler	Landroid/os/Handler;
    //   336: astore 5
    //   338: aload 4
    //   340: getfield 253	com/tencent/mm/ipcinvoker/c$a:hmW	Ljava/lang/Runnable;
    //   343: astore 6
    //   345: invokestatic 148	android/os/Looper:myLooper	()Landroid/os/Looper;
    //   348: invokestatic 145	android/os/Looper:getMainLooper	()Landroid/os/Looper;
    //   351: if_acmpne +84 -> 435
    //   354: ldc2_w 254
    //   357: lstore_2
    //   358: aload 5
    //   360: aload 6
    //   362: lload_2
    //   363: invokevirtual 261	android/os/Handler:postDelayed	(Ljava/lang/Runnable;J)Z
    //   366: pop
    //   367: aload 4
    //   369: monitorenter
    //   370: aload 4
    //   372: getfield 198	com/tencent/mm/ipcinvoker/c$a:hmV	Z
    //   375: ifeq +8 -> 383
    //   378: aload 4
    //   380: invokevirtual 264	java/lang/Object:wait	()V
    //   383: aload 4
    //   385: monitorexit
    //   386: aload 4
    //   388: monitorenter
    //   389: aload 4
    //   391: iconst_0
    //   392: putfield 198	com/tencent/mm/ipcinvoker/c$a:hmV	Z
    //   395: aload 4
    //   397: monitorexit
    //   398: aload 4
    //   400: astore_1
    //   401: aload_1
    //   402: getfield 268	com/tencent/mm/ipcinvoker/c$a:hmU	Lcom/tencent/mm/ipcinvoker/b/a;
    //   405: astore_1
    //   406: ldc 126
    //   408: invokestatic 68	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   411: aload_1
    //   412: areturn
    //   413: astore_1
    //   414: aload 7
    //   416: monitorexit
    //   417: ldc 126
    //   419: invokestatic 68	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   422: aload_1
    //   423: athrow
    //   424: astore_1
    //   425: aload 4
    //   427: monitorexit
    //   428: ldc 126
    //   430: invokestatic 68	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   433: aload_1
    //   434: athrow
    //   435: ldc2_w 269
    //   438: lstore_2
    //   439: goto -81 -> 358
    //   442: astore 5
    //   444: aload 4
    //   446: monitorexit
    //   447: ldc 126
    //   449: invokestatic 68	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   452: aload 5
    //   454: athrow
    //   455: astore 5
    //   457: ldc 128
    //   459: ldc_w 272
    //   462: iconst_1
    //   463: anewarray 4	java/lang/Object
    //   466: dup
    //   467: iconst_0
    //   468: aload 5
    //   470: invokestatic 278	android/util/Log:getStackTraceString	(Ljava/lang/Throwable;)Ljava/lang/String;
    //   473: aastore
    //   474: invokestatic 281	com/tencent/mm/ipcinvoker/h/b:e	(Ljava/lang/String;Ljava/lang/String;[Ljava/lang/Object;)V
    //   477: aload_0
    //   478: getfield 53	com/tencent/mm/ipcinvoker/c:hmJ	Ljava/util/Map;
    //   481: astore 5
    //   483: aload 5
    //   485: monitorenter
    //   486: aload_0
    //   487: getfield 53	com/tencent/mm/ipcinvoker/c:hmJ	Ljava/util/Map;
    //   490: aload_1
    //   491: invokeinterface 284 2 0
    //   496: pop
    //   497: aload 5
    //   499: monitorexit
    //   500: aload 4
    //   502: monitorenter
    //   503: aload 4
    //   505: iconst_0
    //   506: putfield 198	com/tencent/mm/ipcinvoker/c$a:hmV	Z
    //   509: aload 4
    //   511: monitorexit
    //   512: ldc 126
    //   514: invokestatic 68	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   517: aconst_null
    //   518: areturn
    //   519: astore_1
    //   520: aload 4
    //   522: monitorexit
    //   523: ldc 126
    //   525: invokestatic 68	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   528: aload_1
    //   529: athrow
    //   530: astore_1
    //   531: aload 5
    //   533: monitorexit
    //   534: ldc 126
    //   536: invokestatic 68	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   539: aload_1
    //   540: athrow
    //   541: astore_1
    //   542: aload 4
    //   544: monitorenter
    //   545: aload 4
    //   547: iconst_0
    //   548: putfield 198	com/tencent/mm/ipcinvoker/c$a:hmV	Z
    //   551: aload 4
    //   553: monitorexit
    //   554: ldc 126
    //   556: invokestatic 68	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   559: aload_1
    //   560: athrow
    //   561: astore_1
    //   562: aload 4
    //   564: monitorexit
    //   565: ldc 126
    //   567: invokestatic 68	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   570: aload_1
    //   571: athrow
    //   572: astore_1
    //   573: aload 4
    //   575: monitorexit
    //   576: ldc 126
    //   578: invokestatic 68	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   581: aload_1
    //   582: athrow
    //   583: aload 4
    //   585: astore_1
    //   586: aload 4
    //   588: getfield 198	com/tencent/mm/ipcinvoker/c$a:hmV	Z
    //   591: ifeq -190 -> 401
    //   594: aload 4
    //   596: monitorenter
    //   597: aload 4
    //   599: getfield 198	com/tencent/mm/ipcinvoker/c$a:hmV	Z
    //   602: ifeq +8 -> 610
    //   605: aload 4
    //   607: invokevirtual 264	java/lang/Object:wait	()V
    //   610: aload 4
    //   612: monitorexit
    //   613: aload 4
    //   615: astore_1
    //   616: goto -215 -> 401
    //   619: astore_1
    //   620: aload 4
    //   622: monitorexit
    //   623: ldc 126
    //   625: invokestatic 68	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   628: aload_1
    //   629: athrow
    //   630: astore_1
    //   631: ldc 128
    //   633: ldc_w 286
    //   636: iconst_1
    //   637: anewarray 4	java/lang/Object
    //   640: dup
    //   641: iconst_0
    //   642: aload_1
    //   643: aastore
    //   644: invokestatic 281	com/tencent/mm/ipcinvoker/h/b:e	(Ljava/lang/String;Ljava/lang/String;[Ljava/lang/Object;)V
    //   647: aload 4
    //   649: astore_1
    //   650: goto -249 -> 401
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	653	0	this	c
    //   0	653	1	paramString	String
    //   357	82	2	l	long
    //   33	615	4	locala	a
    //   106	253	5	localObject1	Object
    //   442	11	5	localObject2	Object
    //   455	14	5	localException	Exception
    //   144	217	6	localObject3	Object
    //   187	228	7	localObject4	Object
    // Exception table:
    //   from	to	target	type
    //   192	208	413	finally
    //   414	417	413	finally
    //   211	220	424	finally
    //   425	428	424	finally
    //   370	383	442	finally
    //   383	386	442	finally
    //   444	447	442	finally
    //   243	354	455	java/lang/Exception
    //   358	370	455	java/lang/Exception
    //   447	455	455	java/lang/Exception
    //   389	398	519	finally
    //   520	523	519	finally
    //   486	500	530	finally
    //   531	534	530	finally
    //   243	354	541	finally
    //   358	370	541	finally
    //   447	455	541	finally
    //   457	486	541	finally
    //   534	541	541	finally
    //   503	512	561	finally
    //   562	565	561	finally
    //   545	554	572	finally
    //   573	576	572	finally
    //   597	610	619	finally
    //   610	613	619	finally
    //   620	623	619	finally
    //   594	597	630	java/lang/InterruptedException
    //   623	630	630	java/lang/InterruptedException
  }
  
  public final boolean Fo(String paramString)
  {
    AppMethodBeat.i(158724);
    if (g.Fp(paramString))
    {
      AppMethodBeat.o(158724);
      return false;
    }
    if (this.hmJ.get(paramString) != null)
    {
      AppMethodBeat.o(158724);
      return true;
    }
    AppMethodBeat.o(158724);
    return false;
  }
  
  public final boolean a(String paramString, m paramm)
  {
    AppMethodBeat.i(240214);
    if (paramm == null)
    {
      AppMethodBeat.o(240214);
      return false;
    }
    synchronized (this.hmM)
    {
      paramString = (Set)this.hmM.get(paramString);
      if (paramString != null)
      {
        boolean bool = paramString.remove(paramm);
        AppMethodBeat.o(240214);
        return bool;
      }
      AppMethodBeat.o(240214);
      return false;
    }
  }
  
  public final void axX()
  {
    try
    {
      this.hmK = true;
      return;
    }
    finally
    {
      localObject = finally;
      throw localObject;
    }
  }
  
  final void t(final String paramString, boolean paramBoolean)
  {
    AppMethodBeat.i(240215);
    if (g.Fp(paramString))
    {
      com.tencent.mm.ipcinvoker.h.b.i("IPC.IPCBridgeManager", "the same process(%s), do not need to release IPCBridge.", new Object[] { paramString });
      AppMethodBeat.o(240215);
      return;
    }
    final a locala;
    synchronized (this.hmJ)
    {
      locala = (a)this.hmJ.get(paramString);
      if (locala == null)
      {
        com.tencent.mm.ipcinvoker.h.b.i("IPC.IPCBridgeManager", "releaseIPCBridge(%s) failed, IPCBridgeWrapper is null.", new Object[] { paramString });
        AppMethodBeat.o(240215);
        return;
      }
    }
    if (locala.hmV) {}
    try
    {
      locala.hmV = false;
      locala.notifyAll();
      if (locala.serviceConnection == null)
      {
        com.tencent.mm.ipcinvoker.h.b.i("IPC.IPCBridgeManager", "releaseIPCBridge(%s) failed, ServiceConnection is null.", new Object[] { paramString });
        AppMethodBeat.o(240215);
        return;
      }
    }
    finally
    {
      AppMethodBeat.o(240215);
    }
    synchronized (this.hmL)
    {
      this.hmL.put(paramString, new HashSet());
      ??? = new Runnable()
      {
        public final void run()
        {
          AppMethodBeat.i(158720);
          synchronized (c.a(c.this))
          {
            c.a(c.this).remove(paramString);
          }
          synchronized (locala)
          {
            locala.hmU = null;
            locala.hmV = false;
            locala.serviceConnection = null;
            AppMethodBeat.o(158720);
            return;
            localObject2 = finally;
            AppMethodBeat.o(158720);
            throw localObject2;
          }
        }
      };
      if (paramBoolean)
      {
        ((Runnable)???).run();
        AppMethodBeat.o(240215);
        return;
      }
    }
    this.mHandler.post(new Runnable()
    {
      public final void run()
      {
        AppMethodBeat.i(240213);
        ServiceConnection localServiceConnection = locala.serviceConnection;
        if (localServiceConnection == null)
        {
          com.tencent.mm.ipcinvoker.h.b.i("IPC.IPCBridgeManager", "releaseIPCBridge(%s) failed, ServiceConnection is null.", new Object[] { paramString });
          AppMethodBeat.o(240213);
          return;
        }
        try
        {
          g.getContext().unbindService(localServiceConnection);
          this.hmT.run();
          AppMethodBeat.o(240213);
          return;
        }
        catch (Exception localException)
        {
          for (;;)
          {
            com.tencent.mm.ipcinvoker.h.b.e("IPC.IPCBridgeManager", "unbindService(%s) error, %s", new Object[] { paramString, Log.getStackTraceString(localException) });
          }
        }
      }
    });
    AppMethodBeat.o(240215);
  }
  
  public static final class a
  {
    com.tencent.mm.ipcinvoker.b.a hmU;
    public volatile boolean hmV;
    Runnable hmW;
    ServiceConnection serviceConnection;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.ipcinvoker.c
 * JD-Core Version:    0.7.0.1
 */