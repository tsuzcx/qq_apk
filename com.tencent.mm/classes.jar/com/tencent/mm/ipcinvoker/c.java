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
import java.util.Iterator;
import java.util.Map;
import java.util.Set;
import java.util.concurrent.ConcurrentHashMap;

public class c
{
  private static volatile c gxn;
  Map<String, Class<?>> gxo;
  public Map<String, a> gxp;
  private volatile boolean gxq;
  Map<String, Set<n>> gxr;
  private Map<String, Set<m>> gxs;
  private Handler mHandler;
  
  private c()
  {
    AppMethodBeat.i(158722);
    this.gxo = new HashMap();
    this.gxp = new ConcurrentHashMap();
    this.mHandler = l.ahA();
    this.gxr = new HashMap();
    this.gxs = new HashMap();
    AppMethodBeat.o(158722);
  }
  
  public static c ahu()
  {
    AppMethodBeat.i(158721);
    if (gxn == null) {}
    try
    {
      if (gxn == null) {
        gxn = new c();
      }
      c localc = gxn;
      AppMethodBeat.o(158721);
      return localc;
    }
    finally
    {
      AppMethodBeat.o(158721);
    }
  }
  
  private void wr(String paramString)
  {
    try
    {
      AppMethodBeat.i(186707);
      paramString = (Set)this.gxs.get(paramString);
      if (paramString != null)
      {
        paramString = paramString.iterator();
        while (paramString.hasNext())
        {
          m localm = (m)paramString.next();
          if (localm != null) {
            localm.ahC();
          }
        }
      }
      AppMethodBeat.o(186707);
    }
    finally {}
  }
  
  public final void a(String paramString, m paramm)
  {
    try
    {
      AppMethodBeat.i(186708);
      Set localSet = (Set)this.gxs.get(paramString);
      Object localObject = localSet;
      if (localSet == null) {
        localObject = new HashSet();
      }
      ((Set)localObject).add(paramm);
      this.gxs.put(paramString, localObject);
      AppMethodBeat.o(186708);
      return;
    }
    finally {}
  }
  
  public final void ahv()
  {
    try
    {
      this.gxq = true;
      return;
    }
    finally
    {
      localObject = finally;
      throw localObject;
    }
  }
  
  /* Error */
  public final boolean b(String paramString, m paramm)
  {
    // Byte code:
    //   0: aload_0
    //   1: monitorenter
    //   2: ldc 134
    //   4: invokestatic 41	com/tencent/matrix/trace/core/AppMethodBeat:i	(I)V
    //   7: aload_0
    //   8: getfield 63	com/tencent/mm/ipcinvoker/c:gxs	Ljava/util/Map;
    //   11: aload_1
    //   12: invokeinterface 89 2 0
    //   17: checkcast 91	java/util/Set
    //   20: astore_1
    //   21: aload_1
    //   22: ifnull +20 -> 42
    //   25: aload_1
    //   26: aload_2
    //   27: invokeinterface 137 2 0
    //   32: istore_3
    //   33: ldc 134
    //   35: invokestatic 66	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   38: aload_0
    //   39: monitorexit
    //   40: iload_3
    //   41: ireturn
    //   42: iconst_0
    //   43: istore_3
    //   44: ldc 134
    //   46: invokestatic 66	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   49: goto -11 -> 38
    //   52: astore_1
    //   53: aload_0
    //   54: monitorexit
    //   55: aload_1
    //   56: athrow
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	57	0	this	c
    //   0	57	1	paramString	String
    //   0	57	2	paramm	m
    //   32	12	3	bool	boolean
    // Exception table:
    //   from	to	target	type
    //   2	21	52	finally
    //   25	38	52	finally
    //   44	49	52	finally
  }
  
  /* Error */
  public final com.tencent.mm.ipcinvoker.b.a wq(final String paramString)
  {
    // Byte code:
    //   0: ldc 146
    //   2: invokestatic 41	com/tencent/matrix/trace/core/AppMethodBeat:i	(I)V
    //   5: ldc 148
    //   7: ldc 150
    //   9: iconst_1
    //   10: anewarray 4	java/lang/Object
    //   13: dup
    //   14: iconst_0
    //   15: aload_1
    //   16: aastore
    //   17: invokestatic 155	com/tencent/mm/ipcinvoker/h/b:i	(Ljava/lang/String;Ljava/lang/String;[Ljava/lang/Object;)V
    //   20: aload_0
    //   21: getfield 51	com/tencent/mm/ipcinvoker/c:gxp	Ljava/util/Map;
    //   24: aload_1
    //   25: invokeinterface 89 2 0
    //   30: checkcast 14	com/tencent/mm/ipcinvoker/c$a
    //   33: astore 4
    //   35: aload 4
    //   37: ifnonnull +715 -> 752
    //   40: aload_0
    //   41: getfield 132	com/tencent/mm/ipcinvoker/c:gxq	Z
    //   44: ifeq +25 -> 69
    //   47: ldc 148
    //   49: ldc 157
    //   51: iconst_1
    //   52: anewarray 4	java/lang/Object
    //   55: dup
    //   56: iconst_0
    //   57: aload_1
    //   58: aastore
    //   59: invokestatic 155	com/tencent/mm/ipcinvoker/h/b:i	(Ljava/lang/String;Ljava/lang/String;[Ljava/lang/Object;)V
    //   62: ldc 146
    //   64: invokestatic 66	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   67: aconst_null
    //   68: areturn
    //   69: invokestatic 163	android/os/Looper:getMainLooper	()Landroid/os/Looper;
    //   72: invokestatic 166	android/os/Looper:myLooper	()Landroid/os/Looper;
    //   75: if_acmpne +21 -> 96
    //   78: ldc 148
    //   80: ldc 168
    //   82: iconst_0
    //   83: anewarray 4	java/lang/Object
    //   86: invokestatic 171	com/tencent/mm/ipcinvoker/h/b:w	(Ljava/lang/String;Ljava/lang/String;[Ljava/lang/Object;)V
    //   89: ldc 146
    //   91: invokestatic 66	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   94: aconst_null
    //   95: areturn
    //   96: aload_1
    //   97: invokestatic 177	com/tencent/mm/ipcinvoker/g:getContext	()Landroid/content/Context;
    //   100: invokevirtual 183	android/content/Context:getPackageName	()Ljava/lang/String;
    //   103: invokestatic 189	com/tencent/mm/ipcinvoker/h/c:ao	(Ljava/lang/String;Ljava/lang/String;)Ljava/lang/String;
    //   106: astore 5
    //   108: aload_0
    //   109: getfield 46	com/tencent/mm/ipcinvoker/c:gxo	Ljava/util/Map;
    //   112: new 191	java/lang/StringBuilder
    //   115: dup
    //   116: invokespecial 192	java/lang/StringBuilder:<init>	()V
    //   119: aload 5
    //   121: invokevirtual 196	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   124: bipush 47
    //   126: invokevirtual 199	java/lang/StringBuilder:append	(C)Ljava/lang/StringBuilder;
    //   129: aload_1
    //   130: invokevirtual 196	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   133: invokevirtual 202	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   136: invokeinterface 89 2 0
    //   141: checkcast 204	java/lang/Class
    //   144: astore 6
    //   146: aload 6
    //   148: ifnonnull +25 -> 173
    //   151: ldc 148
    //   153: ldc 206
    //   155: iconst_1
    //   156: anewarray 4	java/lang/Object
    //   159: dup
    //   160: iconst_0
    //   161: aload_1
    //   162: aastore
    //   163: invokestatic 171	com/tencent/mm/ipcinvoker/h/b:w	(Ljava/lang/String;Ljava/lang/String;[Ljava/lang/Object;)V
    //   166: ldc 146
    //   168: invokestatic 66	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   171: aconst_null
    //   172: areturn
    //   173: new 14	com/tencent/mm/ipcinvoker/c$a
    //   176: dup
    //   177: iconst_0
    //   178: invokespecial 209	com/tencent/mm/ipcinvoker/c$a:<init>	(B)V
    //   181: astore 4
    //   183: aload_0
    //   184: getfield 51	com/tencent/mm/ipcinvoker/c:gxp	Ljava/util/Map;
    //   187: astore 7
    //   189: aload 7
    //   191: monitorenter
    //   192: aload_0
    //   193: getfield 51	com/tencent/mm/ipcinvoker/c:gxp	Ljava/util/Map;
    //   196: aload_1
    //   197: aload 4
    //   199: invokeinterface 129 3 0
    //   204: pop
    //   205: aload 7
    //   207: monitorexit
    //   208: aload 4
    //   210: monitorenter
    //   211: aload 4
    //   213: iconst_1
    //   214: putfield 212	com/tencent/mm/ipcinvoker/c$a:gxz	Z
    //   217: aload 4
    //   219: monitorexit
    //   220: invokestatic 177	com/tencent/mm/ipcinvoker/g:getContext	()Landroid/content/Context;
    //   223: astore 7
    //   225: aload 4
    //   227: new 6	com/tencent/mm/ipcinvoker/c$1
    //   230: dup
    //   231: aload_0
    //   232: aload 4
    //   234: aload 7
    //   236: aload_1
    //   237: invokespecial 215	com/tencent/mm/ipcinvoker/c$1:<init>	(Lcom/tencent/mm/ipcinvoker/c;Lcom/tencent/mm/ipcinvoker/c$a;Landroid/content/Context;Ljava/lang/String;)V
    //   240: putfield 219	com/tencent/mm/ipcinvoker/c$a:serviceConnection	Landroid/content/ServiceConnection;
    //   243: new 221	android/content/Intent
    //   246: dup
    //   247: invokespecial 222	android/content/Intent:<init>	()V
    //   250: aload 5
    //   252: aload 6
    //   254: invokevirtual 225	java/lang/Class:getCanonicalName	()Ljava/lang/String;
    //   257: invokevirtual 229	android/content/Intent:setClassName	(Ljava/lang/String;Ljava/lang/String;)Landroid/content/Intent;
    //   260: astore 5
    //   262: ldc 148
    //   264: ldc 231
    //   266: iconst_3
    //   267: anewarray 4	java/lang/Object
    //   270: dup
    //   271: iconst_0
    //   272: aload 4
    //   274: invokevirtual 235	java/lang/Object:hashCode	()I
    //   277: invokestatic 241	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
    //   280: aastore
    //   281: dup
    //   282: iconst_1
    //   283: invokestatic 247	java/lang/Thread:currentThread	()Ljava/lang/Thread;
    //   286: invokevirtual 251	java/lang/Thread:getId	()J
    //   289: invokestatic 256	java/lang/Long:valueOf	(J)Ljava/lang/Long;
    //   292: aastore
    //   293: dup
    //   294: iconst_2
    //   295: aload 5
    //   297: aastore
    //   298: invokestatic 155	com/tencent/mm/ipcinvoker/h/b:i	(Ljava/lang/String;Ljava/lang/String;[Ljava/lang/Object;)V
    //   301: aload 7
    //   303: aload 5
    //   305: aload 4
    //   307: getfield 219	com/tencent/mm/ipcinvoker/c$a:serviceConnection	Landroid/content/ServiceConnection;
    //   310: bipush 33
    //   312: invokevirtual 260	android/content/Context:bindService	(Landroid/content/Intent;Landroid/content/ServiceConnection;I)Z
    //   315: pop
    //   316: aload 4
    //   318: new 10	com/tencent/mm/ipcinvoker/c$2
    //   321: dup
    //   322: aload_0
    //   323: aload 4
    //   325: aload_1
    //   326: invokespecial 263	com/tencent/mm/ipcinvoker/c$2:<init>	(Lcom/tencent/mm/ipcinvoker/c;Lcom/tencent/mm/ipcinvoker/c$a;Ljava/lang/String;)V
    //   329: putfield 267	com/tencent/mm/ipcinvoker/c$a:gxA	Ljava/lang/Runnable;
    //   332: aload_0
    //   333: getfield 59	com/tencent/mm/ipcinvoker/c:mHandler	Landroid/os/Handler;
    //   336: astore 5
    //   338: aload 4
    //   340: getfield 267	com/tencent/mm/ipcinvoker/c$a:gxA	Ljava/lang/Runnable;
    //   343: astore 6
    //   345: invokestatic 166	android/os/Looper:myLooper	()Landroid/os/Looper;
    //   348: invokestatic 163	android/os/Looper:getMainLooper	()Landroid/os/Looper;
    //   351: if_acmpne +84 -> 435
    //   354: ldc2_w 268
    //   357: lstore_2
    //   358: aload 5
    //   360: aload 6
    //   362: lload_2
    //   363: invokevirtual 275	android/os/Handler:postDelayed	(Ljava/lang/Runnable;J)Z
    //   366: pop
    //   367: aload 4
    //   369: monitorenter
    //   370: aload 4
    //   372: getfield 212	com/tencent/mm/ipcinvoker/c$a:gxz	Z
    //   375: ifeq +8 -> 383
    //   378: aload 4
    //   380: invokevirtual 278	java/lang/Object:wait	()V
    //   383: aload 4
    //   385: monitorexit
    //   386: aload 4
    //   388: monitorenter
    //   389: aload 4
    //   391: iconst_0
    //   392: putfield 212	com/tencent/mm/ipcinvoker/c$a:gxz	Z
    //   395: aload 4
    //   397: monitorexit
    //   398: aload 4
    //   400: astore_1
    //   401: aload_1
    //   402: getfield 282	com/tencent/mm/ipcinvoker/c$a:gxy	Lcom/tencent/mm/ipcinvoker/b/a;
    //   405: astore_1
    //   406: ldc 146
    //   408: invokestatic 66	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   411: aload_1
    //   412: areturn
    //   413: astore_1
    //   414: aload 7
    //   416: monitorexit
    //   417: ldc 146
    //   419: invokestatic 66	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   422: aload_1
    //   423: athrow
    //   424: astore_1
    //   425: aload 4
    //   427: monitorexit
    //   428: ldc 146
    //   430: invokestatic 66	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   433: aload_1
    //   434: athrow
    //   435: ldc2_w 283
    //   438: lstore_2
    //   439: goto -81 -> 358
    //   442: astore 5
    //   444: aload 4
    //   446: monitorexit
    //   447: ldc 146
    //   449: invokestatic 66	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   452: aload 5
    //   454: athrow
    //   455: astore 5
    //   457: ldc 148
    //   459: ldc_w 286
    //   462: iconst_1
    //   463: anewarray 4	java/lang/Object
    //   466: dup
    //   467: iconst_0
    //   468: aload 5
    //   470: aastore
    //   471: invokestatic 289	com/tencent/mm/ipcinvoker/h/b:e	(Ljava/lang/String;Ljava/lang/String;[Ljava/lang/Object;)V
    //   474: aload_0
    //   475: getfield 51	com/tencent/mm/ipcinvoker/c:gxp	Ljava/util/Map;
    //   478: astore 5
    //   480: aload 5
    //   482: monitorenter
    //   483: aload_0
    //   484: getfield 51	com/tencent/mm/ipcinvoker/c:gxp	Ljava/util/Map;
    //   487: aload_1
    //   488: invokeinterface 291 2 0
    //   493: pop
    //   494: aload 5
    //   496: monitorexit
    //   497: aload 4
    //   499: monitorenter
    //   500: aload 4
    //   502: iconst_0
    //   503: putfield 212	com/tencent/mm/ipcinvoker/c$a:gxz	Z
    //   506: aload 4
    //   508: monitorexit
    //   509: ldc 146
    //   511: invokestatic 66	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   514: aconst_null
    //   515: areturn
    //   516: astore_1
    //   517: aload 4
    //   519: monitorexit
    //   520: ldc 146
    //   522: invokestatic 66	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   525: aload_1
    //   526: athrow
    //   527: astore_1
    //   528: aload 5
    //   530: monitorexit
    //   531: ldc 146
    //   533: invokestatic 66	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   536: aload_1
    //   537: athrow
    //   538: astore_1
    //   539: aload 4
    //   541: monitorenter
    //   542: aload 4
    //   544: iconst_0
    //   545: putfield 212	com/tencent/mm/ipcinvoker/c$a:gxz	Z
    //   548: aload 4
    //   550: monitorexit
    //   551: ldc 146
    //   553: invokestatic 66	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   556: aload_1
    //   557: athrow
    //   558: astore_1
    //   559: aload 4
    //   561: monitorexit
    //   562: ldc 146
    //   564: invokestatic 66	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   567: aload_1
    //   568: athrow
    //   569: astore 5
    //   571: ldc 148
    //   573: ldc_w 293
    //   576: iconst_1
    //   577: anewarray 4	java/lang/Object
    //   580: dup
    //   581: iconst_0
    //   582: aload 5
    //   584: invokestatic 299	android/util/Log:getStackTraceString	(Ljava/lang/Throwable;)Ljava/lang/String;
    //   587: aastore
    //   588: invokestatic 289	com/tencent/mm/ipcinvoker/h/b:e	(Ljava/lang/String;Ljava/lang/String;[Ljava/lang/Object;)V
    //   591: aload_0
    //   592: getfield 51	com/tencent/mm/ipcinvoker/c:gxp	Ljava/util/Map;
    //   595: astore 5
    //   597: aload 5
    //   599: monitorenter
    //   600: aload_0
    //   601: getfield 51	com/tencent/mm/ipcinvoker/c:gxp	Ljava/util/Map;
    //   604: aload_1
    //   605: invokeinterface 291 2 0
    //   610: pop
    //   611: aload 5
    //   613: monitorexit
    //   614: aload 4
    //   616: monitorenter
    //   617: aload 4
    //   619: iconst_0
    //   620: putfield 212	com/tencent/mm/ipcinvoker/c$a:gxz	Z
    //   623: aload 4
    //   625: monitorexit
    //   626: ldc 146
    //   628: invokestatic 66	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   631: aconst_null
    //   632: areturn
    //   633: astore_1
    //   634: aload 5
    //   636: monitorexit
    //   637: ldc 146
    //   639: invokestatic 66	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   642: aload_1
    //   643: athrow
    //   644: astore_1
    //   645: aload 4
    //   647: monitorexit
    //   648: ldc 146
    //   650: invokestatic 66	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   653: aload_1
    //   654: athrow
    //   655: astore 5
    //   657: ldc 148
    //   659: ldc_w 293
    //   662: iconst_1
    //   663: anewarray 4	java/lang/Object
    //   666: dup
    //   667: iconst_0
    //   668: aload 5
    //   670: invokestatic 299	android/util/Log:getStackTraceString	(Ljava/lang/Throwable;)Ljava/lang/String;
    //   673: aastore
    //   674: invokestatic 289	com/tencent/mm/ipcinvoker/h/b:e	(Ljava/lang/String;Ljava/lang/String;[Ljava/lang/Object;)V
    //   677: aload_0
    //   678: getfield 51	com/tencent/mm/ipcinvoker/c:gxp	Ljava/util/Map;
    //   681: astore 5
    //   683: aload 5
    //   685: monitorenter
    //   686: aload_0
    //   687: getfield 51	com/tencent/mm/ipcinvoker/c:gxp	Ljava/util/Map;
    //   690: aload_1
    //   691: invokeinterface 291 2 0
    //   696: pop
    //   697: aload 5
    //   699: monitorexit
    //   700: aload 4
    //   702: monitorenter
    //   703: aload 4
    //   705: iconst_0
    //   706: putfield 212	com/tencent/mm/ipcinvoker/c$a:gxz	Z
    //   709: aload 4
    //   711: monitorexit
    //   712: ldc 146
    //   714: invokestatic 66	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   717: aconst_null
    //   718: areturn
    //   719: astore_1
    //   720: aload 5
    //   722: monitorexit
    //   723: ldc 146
    //   725: invokestatic 66	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   728: aload_1
    //   729: athrow
    //   730: astore_1
    //   731: aload 4
    //   733: monitorexit
    //   734: ldc 146
    //   736: invokestatic 66	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   739: aload_1
    //   740: athrow
    //   741: astore_1
    //   742: aload 4
    //   744: monitorexit
    //   745: ldc 146
    //   747: invokestatic 66	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   750: aload_1
    //   751: athrow
    //   752: aload 4
    //   754: astore_1
    //   755: aload 4
    //   757: getfield 212	com/tencent/mm/ipcinvoker/c$a:gxz	Z
    //   760: ifeq -359 -> 401
    //   763: aload 4
    //   765: monitorenter
    //   766: aload 4
    //   768: getfield 212	com/tencent/mm/ipcinvoker/c$a:gxz	Z
    //   771: ifeq +8 -> 779
    //   774: aload 4
    //   776: invokevirtual 278	java/lang/Object:wait	()V
    //   779: aload 4
    //   781: monitorexit
    //   782: aload 4
    //   784: astore_1
    //   785: goto -384 -> 401
    //   788: astore_1
    //   789: aload 4
    //   791: monitorexit
    //   792: ldc 146
    //   794: invokestatic 66	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   797: aload_1
    //   798: athrow
    //   799: astore_1
    //   800: ldc 148
    //   802: ldc_w 286
    //   805: iconst_1
    //   806: anewarray 4	java/lang/Object
    //   809: dup
    //   810: iconst_0
    //   811: aload_1
    //   812: aastore
    //   813: invokestatic 289	com/tencent/mm/ipcinvoker/h/b:e	(Ljava/lang/String;Ljava/lang/String;[Ljava/lang/Object;)V
    //   816: aload 4
    //   818: astore_1
    //   819: goto -418 -> 401
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	822	0	this	c
    //   0	822	1	paramString	String
    //   357	82	2	l	long
    //   33	784	4	locala	a
    //   106	253	5	localObject1	Object
    //   442	11	5	localObject2	Object
    //   455	14	5	localInterruptedException	java.lang.InterruptedException
    //   569	14	5	localSecurityException	java.lang.SecurityException
    //   655	14	5	localIllegalArgumentException	java.lang.IllegalArgumentException
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
    //   243	354	455	java/lang/InterruptedException
    //   358	370	455	java/lang/InterruptedException
    //   447	455	455	java/lang/InterruptedException
    //   389	398	516	finally
    //   517	520	516	finally
    //   483	497	527	finally
    //   528	531	527	finally
    //   243	354	538	finally
    //   358	370	538	finally
    //   447	455	538	finally
    //   457	483	538	finally
    //   531	538	538	finally
    //   571	600	538	finally
    //   637	644	538	finally
    //   657	686	538	finally
    //   723	730	538	finally
    //   500	509	558	finally
    //   559	562	558	finally
    //   243	354	569	java/lang/SecurityException
    //   358	370	569	java/lang/SecurityException
    //   447	455	569	java/lang/SecurityException
    //   600	614	633	finally
    //   634	637	633	finally
    //   617	626	644	finally
    //   645	648	644	finally
    //   243	354	655	java/lang/IllegalArgumentException
    //   358	370	655	java/lang/IllegalArgumentException
    //   447	455	655	java/lang/IllegalArgumentException
    //   686	700	719	finally
    //   720	723	719	finally
    //   703	712	730	finally
    //   731	734	730	finally
    //   542	551	741	finally
    //   742	745	741	finally
    //   766	779	788	finally
    //   779	782	788	finally
    //   789	792	788	finally
    //   763	766	799	java/lang/InterruptedException
    //   792	799	799	java/lang/InterruptedException
  }
  
  public final boolean ws(String paramString)
  {
    AppMethodBeat.i(158724);
    if (g.wu(paramString))
    {
      AppMethodBeat.o(158724);
      return false;
    }
    if (this.gxp.get(paramString) != null)
    {
      AppMethodBeat.o(158724);
      return true;
    }
    AppMethodBeat.o(158724);
    return false;
  }
  
  public final void wt(final String paramString)
  {
    AppMethodBeat.i(158725);
    if (g.wu(paramString))
    {
      com.tencent.mm.ipcinvoker.h.b.i("IPC.IPCBridgeManager", "the same process(%s), do not need to release IPCBridge.", new Object[] { paramString });
      AppMethodBeat.o(158725);
      return;
    }
    final a locala;
    synchronized (this.gxp)
    {
      locala = (a)this.gxp.get(paramString);
      if (locala == null)
      {
        com.tencent.mm.ipcinvoker.h.b.i("IPC.IPCBridgeManager", "releaseIPCBridge(%s) failed, IPCBridgeWrapper is null.", new Object[] { paramString });
        AppMethodBeat.o(158725);
        return;
      }
    }
    if (locala.gxz) {}
    try
    {
      locala.gxz = false;
      locala.notifyAll();
      if (locala.serviceConnection == null)
      {
        com.tencent.mm.ipcinvoker.h.b.i("IPC.IPCBridgeManager", "releaseIPCBridge(%s) failed, ServiceConnection is null.", new Object[] { paramString });
        AppMethodBeat.o(158725);
        return;
      }
    }
    finally
    {
      AppMethodBeat.o(158725);
    }
    try
    {
      this.gxr.put(paramString, new HashSet());
      this.mHandler.post(new Runnable()
      {
        /* Error */
        public final void run()
        {
          // Byte code:
          //   0: ldc 33
          //   2: invokestatic 39	com/tencent/matrix/trace/core/AppMethodBeat:i	(I)V
          //   5: aload_0
          //   6: getfield 23	com/tencent/mm/ipcinvoker/c$3:gxx	Lcom/tencent/mm/ipcinvoker/c$a;
          //   9: getfield 45	com/tencent/mm/ipcinvoker/c$a:serviceConnection	Landroid/content/ServiceConnection;
          //   12: astore_1
          //   13: aload_1
          //   14: ifnonnull +27 -> 41
          //   17: ldc 47
          //   19: ldc 49
          //   21: iconst_1
          //   22: anewarray 4	java/lang/Object
          //   25: dup
          //   26: iconst_0
          //   27: aload_0
          //   28: getfield 25	com/tencent/mm/ipcinvoker/c$3:gxu	Ljava/lang/String;
          //   31: aastore
          //   32: invokestatic 54	com/tencent/mm/ipcinvoker/h/b:i	(Ljava/lang/String;Ljava/lang/String;[Ljava/lang/Object;)V
          //   35: ldc 33
          //   37: invokestatic 57	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
          //   40: return
          //   41: invokestatic 63	com/tencent/mm/ipcinvoker/g:getContext	()Landroid/content/Context;
          //   44: aload_1
          //   45: invokevirtual 69	android/content/Context:unbindService	(Landroid/content/ServiceConnection;)V
          //   48: aload_0
          //   49: getfield 21	com/tencent/mm/ipcinvoker/c$3:gxv	Lcom/tencent/mm/ipcinvoker/c;
          //   52: invokestatic 73	com/tencent/mm/ipcinvoker/c:a	(Lcom/tencent/mm/ipcinvoker/c;)Ljava/util/Map;
          //   55: astore_1
          //   56: aload_1
          //   57: monitorenter
          //   58: aload_0
          //   59: getfield 21	com/tencent/mm/ipcinvoker/c$3:gxv	Lcom/tencent/mm/ipcinvoker/c;
          //   62: invokestatic 73	com/tencent/mm/ipcinvoker/c:a	(Lcom/tencent/mm/ipcinvoker/c;)Ljava/util/Map;
          //   65: aload_0
          //   66: getfield 25	com/tencent/mm/ipcinvoker/c$3:gxu	Ljava/lang/String;
          //   69: invokeinterface 79 2 0
          //   74: pop
          //   75: aload_1
          //   76: monitorexit
          //   77: aload_0
          //   78: getfield 23	com/tencent/mm/ipcinvoker/c$3:gxx	Lcom/tencent/mm/ipcinvoker/c$a;
          //   81: astore_1
          //   82: aload_1
          //   83: monitorenter
          //   84: aload_0
          //   85: getfield 23	com/tencent/mm/ipcinvoker/c$3:gxx	Lcom/tencent/mm/ipcinvoker/c$a;
          //   88: aconst_null
          //   89: putfield 83	com/tencent/mm/ipcinvoker/c$a:gxy	Lcom/tencent/mm/ipcinvoker/b/a;
          //   92: aload_0
          //   93: getfield 23	com/tencent/mm/ipcinvoker/c$3:gxx	Lcom/tencent/mm/ipcinvoker/c$a;
          //   96: iconst_0
          //   97: putfield 87	com/tencent/mm/ipcinvoker/c$a:gxz	Z
          //   100: aload_0
          //   101: getfield 23	com/tencent/mm/ipcinvoker/c$3:gxx	Lcom/tencent/mm/ipcinvoker/c$a;
          //   104: aconst_null
          //   105: putfield 45	com/tencent/mm/ipcinvoker/c$a:serviceConnection	Landroid/content/ServiceConnection;
          //   108: aload_1
          //   109: monitorexit
          //   110: ldc 33
          //   112: invokestatic 57	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
          //   115: return
          //   116: astore_1
          //   117: ldc 47
          //   119: ldc 89
          //   121: iconst_2
          //   122: anewarray 4	java/lang/Object
          //   125: dup
          //   126: iconst_0
          //   127: aload_0
          //   128: getfield 25	com/tencent/mm/ipcinvoker/c$3:gxu	Ljava/lang/String;
          //   131: aastore
          //   132: dup
          //   133: iconst_1
          //   134: aload_1
          //   135: invokestatic 95	android/util/Log:getStackTraceString	(Ljava/lang/Throwable;)Ljava/lang/String;
          //   138: aastore
          //   139: invokestatic 98	com/tencent/mm/ipcinvoker/h/b:e	(Ljava/lang/String;Ljava/lang/String;[Ljava/lang/Object;)V
          //   142: goto -94 -> 48
          //   145: astore_2
          //   146: aload_1
          //   147: monitorexit
          //   148: ldc 33
          //   150: invokestatic 57	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
          //   153: aload_2
          //   154: athrow
          //   155: astore_2
          //   156: aload_1
          //   157: monitorexit
          //   158: ldc 33
          //   160: invokestatic 57	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
          //   163: aload_2
          //   164: athrow
          // Local variable table:
          //   start	length	slot	name	signature
          //   0	165	0	this	3
          //   116	41	1	localException	java.lang.Exception
          //   145	9	2	localObject2	Object
          //   155	9	2	localObject3	Object
          // Exception table:
          //   from	to	target	type
          //   41	48	116	java/lang/Exception
          //   58	77	145	finally
          //   146	148	145	finally
          //   84	110	155	finally
          //   156	158	155	finally
        }
      });
      AppMethodBeat.o(158725);
      return;
    }
    finally
    {
      AppMethodBeat.o(158725);
    }
  }
  
  public static final class a
  {
    Runnable gxA;
    com.tencent.mm.ipcinvoker.b.a gxy;
    public volatile boolean gxz;
    ServiceConnection serviceConnection;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.ipcinvoker.c
 * JD-Core Version:    0.7.0.1
 */