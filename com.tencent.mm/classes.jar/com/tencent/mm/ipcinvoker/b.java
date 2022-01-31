package com.tencent.mm.ipcinvoker;

import android.content.ServiceConnection;
import android.os.Handler;
import android.os.HandlerThread;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ipcinvoker.b.a;
import java.util.HashMap;
import java.util.Map;
import java.util.Set;
import java.util.concurrent.ConcurrentHashMap;

public class b
{
  private static volatile b eDT;
  Map<String, Class<?>> eDU;
  public Map<String, a> eDV;
  private volatile boolean eDW;
  Map<String, Set<j>> eDX;
  private Handler mHandler;
  
  private b()
  {
    AppMethodBeat.i(114012);
    this.eDU = new HashMap();
    this.eDV = new ConcurrentHashMap();
    HandlerThread localHandlerThread = new HandlerThread("IPCBridgeThread#" + hashCode());
    localHandlerThread.start();
    this.mHandler = new Handler(localHandlerThread.getLooper());
    this.eDX = new HashMap();
    AppMethodBeat.o(114012);
  }
  
  public static b PK()
  {
    AppMethodBeat.i(114011);
    if (eDT == null) {}
    try
    {
      if (eDT == null) {
        eDT = new b();
      }
      b localb = eDT;
      AppMethodBeat.o(114011);
      return localb;
    }
    finally
    {
      AppMethodBeat.o(114011);
    }
  }
  
  public final void PL()
  {
    try
    {
      this.eDW = true;
      return;
    }
    finally
    {
      localObject = finally;
      throw localObject;
    }
  }
  
  /* Error */
  public final a lW(String paramString)
  {
    // Byte code:
    //   0: ldc 133
    //   2: invokestatic 31	com/tencent/matrix/trace/core/AppMethodBeat:i	(I)V
    //   5: ldc 135
    //   7: ldc 137
    //   9: iconst_1
    //   10: anewarray 4	java/lang/Object
    //   13: dup
    //   14: iconst_0
    //   15: aload_1
    //   16: aastore
    //   17: invokestatic 142	com/tencent/mm/ipcinvoker/h/b:i	(Ljava/lang/String;Ljava/lang/String;[Ljava/lang/Object;)V
    //   20: aload_0
    //   21: getfield 41	com/tencent/mm/ipcinvoker/b:eDV	Ljava/util/Map;
    //   24: aload_1
    //   25: invokeinterface 98 2 0
    //   30: checkcast 6	com/tencent/mm/ipcinvoker/b$a
    //   33: astore 4
    //   35: aload 4
    //   37: ifnonnull +715 -> 752
    //   40: aload_0
    //   41: getfield 124	com/tencent/mm/ipcinvoker/b:eDW	Z
    //   44: ifeq +25 -> 69
    //   47: ldc 135
    //   49: ldc 144
    //   51: iconst_1
    //   52: anewarray 4	java/lang/Object
    //   55: dup
    //   56: iconst_0
    //   57: aload_1
    //   58: aastore
    //   59: invokestatic 142	com/tencent/mm/ipcinvoker/h/b:i	(Ljava/lang/String;Ljava/lang/String;[Ljava/lang/Object;)V
    //   62: ldc 133
    //   64: invokestatic 82	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   67: aconst_null
    //   68: areturn
    //   69: invokestatic 149	android/os/Looper:getMainLooper	()Landroid/os/Looper;
    //   72: invokestatic 152	android/os/Looper:myLooper	()Landroid/os/Looper;
    //   75: if_acmpne +21 -> 96
    //   78: ldc 135
    //   80: ldc 154
    //   82: iconst_0
    //   83: anewarray 4	java/lang/Object
    //   86: invokestatic 157	com/tencent/mm/ipcinvoker/h/b:w	(Ljava/lang/String;Ljava/lang/String;[Ljava/lang/Object;)V
    //   89: ldc 133
    //   91: invokestatic 82	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   94: aconst_null
    //   95: areturn
    //   96: aload_1
    //   97: invokestatic 163	com/tencent/mm/ipcinvoker/e:getContext	()Landroid/content/Context;
    //   100: invokevirtual 168	android/content/Context:getPackageName	()Ljava/lang/String;
    //   103: invokestatic 174	com/tencent/mm/ipcinvoker/h/c:T	(Ljava/lang/String;Ljava/lang/String;)Ljava/lang/String;
    //   106: astore 5
    //   108: aload_0
    //   109: getfield 36	com/tencent/mm/ipcinvoker/b:eDU	Ljava/util/Map;
    //   112: new 45	java/lang/StringBuilder
    //   115: dup
    //   116: invokespecial 175	java/lang/StringBuilder:<init>	()V
    //   119: aload 5
    //   121: invokevirtual 178	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   124: bipush 47
    //   126: invokevirtual 181	java/lang/StringBuilder:append	(C)Ljava/lang/StringBuilder;
    //   129: aload_1
    //   130: invokevirtual 178	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   133: invokevirtual 62	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   136: invokeinterface 98 2 0
    //   141: checkcast 183	java/lang/Class
    //   144: astore 6
    //   146: aload 6
    //   148: ifnonnull +25 -> 173
    //   151: ldc 135
    //   153: ldc 185
    //   155: iconst_1
    //   156: anewarray 4	java/lang/Object
    //   159: dup
    //   160: iconst_0
    //   161: aload_1
    //   162: aastore
    //   163: invokestatic 157	com/tencent/mm/ipcinvoker/h/b:w	(Ljava/lang/String;Ljava/lang/String;[Ljava/lang/Object;)V
    //   166: ldc 133
    //   168: invokestatic 82	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   171: aconst_null
    //   172: areturn
    //   173: new 6	com/tencent/mm/ipcinvoker/b$a
    //   176: dup
    //   177: iconst_0
    //   178: invokespecial 188	com/tencent/mm/ipcinvoker/b$a:<init>	(B)V
    //   181: astore 4
    //   183: aload_0
    //   184: getfield 41	com/tencent/mm/ipcinvoker/b:eDV	Ljava/util/Map;
    //   187: astore 7
    //   189: aload 7
    //   191: monitorenter
    //   192: aload_0
    //   193: getfield 41	com/tencent/mm/ipcinvoker/b:eDV	Ljava/util/Map;
    //   196: aload_1
    //   197: aload 4
    //   199: invokeinterface 192 3 0
    //   204: pop
    //   205: aload 7
    //   207: monitorexit
    //   208: aload 4
    //   210: monitorenter
    //   211: aload 4
    //   213: iconst_1
    //   214: putfield 195	com/tencent/mm/ipcinvoker/b$a:eEd	Z
    //   217: aload 4
    //   219: monitorexit
    //   220: invokestatic 163	com/tencent/mm/ipcinvoker/e:getContext	()Landroid/content/Context;
    //   223: astore 7
    //   225: aload 4
    //   227: new 197	com/tencent/mm/ipcinvoker/b$1
    //   230: dup
    //   231: aload_0
    //   232: aload 4
    //   234: aload 7
    //   236: aload_1
    //   237: invokespecial 200	com/tencent/mm/ipcinvoker/b$1:<init>	(Lcom/tencent/mm/ipcinvoker/b;Lcom/tencent/mm/ipcinvoker/b$a;Landroid/content/Context;Ljava/lang/String;)V
    //   240: putfield 204	com/tencent/mm/ipcinvoker/b$a:serviceConnection	Landroid/content/ServiceConnection;
    //   243: new 206	android/content/Intent
    //   246: dup
    //   247: invokespecial 207	android/content/Intent:<init>	()V
    //   250: aload 5
    //   252: aload 6
    //   254: invokevirtual 210	java/lang/Class:getCanonicalName	()Ljava/lang/String;
    //   257: invokevirtual 214	android/content/Intent:setClassName	(Ljava/lang/String;Ljava/lang/String;)Landroid/content/Intent;
    //   260: astore 5
    //   262: ldc 135
    //   264: ldc 216
    //   266: iconst_3
    //   267: anewarray 4	java/lang/Object
    //   270: dup
    //   271: iconst_0
    //   272: aload 4
    //   274: invokevirtual 54	java/lang/Object:hashCode	()I
    //   277: invokestatic 222	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
    //   280: aastore
    //   281: dup
    //   282: iconst_1
    //   283: invokestatic 228	java/lang/Thread:currentThread	()Ljava/lang/Thread;
    //   286: invokevirtual 232	java/lang/Thread:getId	()J
    //   289: invokestatic 237	java/lang/Long:valueOf	(J)Ljava/lang/Long;
    //   292: aastore
    //   293: dup
    //   294: iconst_2
    //   295: aload 5
    //   297: aastore
    //   298: invokestatic 142	com/tencent/mm/ipcinvoker/h/b:i	(Ljava/lang/String;Ljava/lang/String;[Ljava/lang/Object;)V
    //   301: aload 7
    //   303: aload 5
    //   305: aload 4
    //   307: getfield 204	com/tencent/mm/ipcinvoker/b$a:serviceConnection	Landroid/content/ServiceConnection;
    //   310: bipush 33
    //   312: invokevirtual 241	android/content/Context:bindService	(Landroid/content/Intent;Landroid/content/ServiceConnection;I)Z
    //   315: pop
    //   316: aload 4
    //   318: new 243	com/tencent/mm/ipcinvoker/b$2
    //   321: dup
    //   322: aload_0
    //   323: aload 4
    //   325: aload_1
    //   326: invokespecial 246	com/tencent/mm/ipcinvoker/b$2:<init>	(Lcom/tencent/mm/ipcinvoker/b;Lcom/tencent/mm/ipcinvoker/b$a;Ljava/lang/String;)V
    //   329: putfield 250	com/tencent/mm/ipcinvoker/b$a:eEe	Ljava/lang/Runnable;
    //   332: aload_0
    //   333: getfield 77	com/tencent/mm/ipcinvoker/b:mHandler	Landroid/os/Handler;
    //   336: astore 5
    //   338: aload 4
    //   340: getfield 250	com/tencent/mm/ipcinvoker/b$a:eEe	Ljava/lang/Runnable;
    //   343: astore 6
    //   345: invokestatic 152	android/os/Looper:myLooper	()Landroid/os/Looper;
    //   348: invokestatic 149	android/os/Looper:getMainLooper	()Landroid/os/Looper;
    //   351: if_acmpne +84 -> 435
    //   354: ldc2_w 251
    //   357: lstore_2
    //   358: aload 5
    //   360: aload 6
    //   362: lload_2
    //   363: invokevirtual 256	android/os/Handler:postDelayed	(Ljava/lang/Runnable;J)Z
    //   366: pop
    //   367: aload 4
    //   369: monitorenter
    //   370: aload 4
    //   372: getfield 195	com/tencent/mm/ipcinvoker/b$a:eEd	Z
    //   375: ifeq +8 -> 383
    //   378: aload 4
    //   380: invokevirtual 259	java/lang/Object:wait	()V
    //   383: aload 4
    //   385: monitorexit
    //   386: aload 4
    //   388: monitorenter
    //   389: aload 4
    //   391: iconst_0
    //   392: putfield 195	com/tencent/mm/ipcinvoker/b$a:eEd	Z
    //   395: aload 4
    //   397: monitorexit
    //   398: aload 4
    //   400: astore_1
    //   401: aload_1
    //   402: getfield 263	com/tencent/mm/ipcinvoker/b$a:eEc	Lcom/tencent/mm/ipcinvoker/b/a;
    //   405: astore_1
    //   406: ldc 133
    //   408: invokestatic 82	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   411: aload_1
    //   412: areturn
    //   413: astore_1
    //   414: aload 7
    //   416: monitorexit
    //   417: ldc 133
    //   419: invokestatic 82	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   422: aload_1
    //   423: athrow
    //   424: astore_1
    //   425: aload 4
    //   427: monitorexit
    //   428: ldc 133
    //   430: invokestatic 82	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   433: aload_1
    //   434: athrow
    //   435: ldc2_w 264
    //   438: lstore_2
    //   439: goto -81 -> 358
    //   442: astore 5
    //   444: aload 4
    //   446: monitorexit
    //   447: ldc 133
    //   449: invokestatic 82	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   452: aload 5
    //   454: athrow
    //   455: astore 5
    //   457: ldc 135
    //   459: ldc_w 267
    //   462: iconst_1
    //   463: anewarray 4	java/lang/Object
    //   466: dup
    //   467: iconst_0
    //   468: aload 5
    //   470: aastore
    //   471: invokestatic 270	com/tencent/mm/ipcinvoker/h/b:e	(Ljava/lang/String;Ljava/lang/String;[Ljava/lang/Object;)V
    //   474: aload_0
    //   475: getfield 41	com/tencent/mm/ipcinvoker/b:eDV	Ljava/util/Map;
    //   478: astore 5
    //   480: aload 5
    //   482: monitorenter
    //   483: aload_0
    //   484: getfield 41	com/tencent/mm/ipcinvoker/b:eDV	Ljava/util/Map;
    //   487: aload_1
    //   488: invokeinterface 273 2 0
    //   493: pop
    //   494: aload 5
    //   496: monitorexit
    //   497: aload 4
    //   499: monitorenter
    //   500: aload 4
    //   502: iconst_0
    //   503: putfield 195	com/tencent/mm/ipcinvoker/b$a:eEd	Z
    //   506: aload 4
    //   508: monitorexit
    //   509: ldc 133
    //   511: invokestatic 82	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   514: aconst_null
    //   515: areturn
    //   516: astore_1
    //   517: aload 4
    //   519: monitorexit
    //   520: ldc 133
    //   522: invokestatic 82	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   525: aload_1
    //   526: athrow
    //   527: astore_1
    //   528: aload 5
    //   530: monitorexit
    //   531: ldc 133
    //   533: invokestatic 82	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   536: aload_1
    //   537: athrow
    //   538: astore_1
    //   539: aload 4
    //   541: monitorenter
    //   542: aload 4
    //   544: iconst_0
    //   545: putfield 195	com/tencent/mm/ipcinvoker/b$a:eEd	Z
    //   548: aload 4
    //   550: monitorexit
    //   551: ldc 133
    //   553: invokestatic 82	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   556: aload_1
    //   557: athrow
    //   558: astore_1
    //   559: aload 4
    //   561: monitorexit
    //   562: ldc 133
    //   564: invokestatic 82	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   567: aload_1
    //   568: athrow
    //   569: astore 5
    //   571: ldc 135
    //   573: ldc_w 275
    //   576: iconst_1
    //   577: anewarray 4	java/lang/Object
    //   580: dup
    //   581: iconst_0
    //   582: aload 5
    //   584: invokestatic 281	android/util/Log:getStackTraceString	(Ljava/lang/Throwable;)Ljava/lang/String;
    //   587: aastore
    //   588: invokestatic 270	com/tencent/mm/ipcinvoker/h/b:e	(Ljava/lang/String;Ljava/lang/String;[Ljava/lang/Object;)V
    //   591: aload_0
    //   592: getfield 41	com/tencent/mm/ipcinvoker/b:eDV	Ljava/util/Map;
    //   595: astore 5
    //   597: aload 5
    //   599: monitorenter
    //   600: aload_0
    //   601: getfield 41	com/tencent/mm/ipcinvoker/b:eDV	Ljava/util/Map;
    //   604: aload_1
    //   605: invokeinterface 273 2 0
    //   610: pop
    //   611: aload 5
    //   613: monitorexit
    //   614: aload 4
    //   616: monitorenter
    //   617: aload 4
    //   619: iconst_0
    //   620: putfield 195	com/tencent/mm/ipcinvoker/b$a:eEd	Z
    //   623: aload 4
    //   625: monitorexit
    //   626: ldc 133
    //   628: invokestatic 82	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   631: aconst_null
    //   632: areturn
    //   633: astore_1
    //   634: aload 5
    //   636: monitorexit
    //   637: ldc 133
    //   639: invokestatic 82	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   642: aload_1
    //   643: athrow
    //   644: astore_1
    //   645: aload 4
    //   647: monitorexit
    //   648: ldc 133
    //   650: invokestatic 82	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   653: aload_1
    //   654: athrow
    //   655: astore 5
    //   657: ldc 135
    //   659: ldc_w 275
    //   662: iconst_1
    //   663: anewarray 4	java/lang/Object
    //   666: dup
    //   667: iconst_0
    //   668: aload 5
    //   670: invokestatic 281	android/util/Log:getStackTraceString	(Ljava/lang/Throwable;)Ljava/lang/String;
    //   673: aastore
    //   674: invokestatic 270	com/tencent/mm/ipcinvoker/h/b:e	(Ljava/lang/String;Ljava/lang/String;[Ljava/lang/Object;)V
    //   677: aload_0
    //   678: getfield 41	com/tencent/mm/ipcinvoker/b:eDV	Ljava/util/Map;
    //   681: astore 5
    //   683: aload 5
    //   685: monitorenter
    //   686: aload_0
    //   687: getfield 41	com/tencent/mm/ipcinvoker/b:eDV	Ljava/util/Map;
    //   690: aload_1
    //   691: invokeinterface 273 2 0
    //   696: pop
    //   697: aload 5
    //   699: monitorexit
    //   700: aload 4
    //   702: monitorenter
    //   703: aload 4
    //   705: iconst_0
    //   706: putfield 195	com/tencent/mm/ipcinvoker/b$a:eEd	Z
    //   709: aload 4
    //   711: monitorexit
    //   712: ldc 133
    //   714: invokestatic 82	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   717: aconst_null
    //   718: areturn
    //   719: astore_1
    //   720: aload 5
    //   722: monitorexit
    //   723: ldc 133
    //   725: invokestatic 82	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   728: aload_1
    //   729: athrow
    //   730: astore_1
    //   731: aload 4
    //   733: monitorexit
    //   734: ldc 133
    //   736: invokestatic 82	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   739: aload_1
    //   740: athrow
    //   741: astore_1
    //   742: aload 4
    //   744: monitorexit
    //   745: ldc 133
    //   747: invokestatic 82	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   750: aload_1
    //   751: athrow
    //   752: aload 4
    //   754: astore_1
    //   755: aload 4
    //   757: getfield 195	com/tencent/mm/ipcinvoker/b$a:eEd	Z
    //   760: ifeq -359 -> 401
    //   763: aload 4
    //   765: monitorenter
    //   766: aload 4
    //   768: getfield 195	com/tencent/mm/ipcinvoker/b$a:eEd	Z
    //   771: ifeq +8 -> 779
    //   774: aload 4
    //   776: invokevirtual 259	java/lang/Object:wait	()V
    //   779: aload 4
    //   781: monitorexit
    //   782: aload 4
    //   784: astore_1
    //   785: goto -384 -> 401
    //   788: astore_1
    //   789: aload 4
    //   791: monitorexit
    //   792: ldc 133
    //   794: invokestatic 82	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   797: aload_1
    //   798: athrow
    //   799: astore_1
    //   800: ldc 135
    //   802: ldc_w 267
    //   805: iconst_1
    //   806: anewarray 4	java/lang/Object
    //   809: dup
    //   810: iconst_0
    //   811: aload_1
    //   812: aastore
    //   813: invokestatic 270	com/tencent/mm/ipcinvoker/h/b:e	(Ljava/lang/String;Ljava/lang/String;[Ljava/lang/Object;)V
    //   816: aload 4
    //   818: astore_1
    //   819: goto -418 -> 401
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	822	0	this	b
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
  
  public final boolean lX(String paramString)
  {
    AppMethodBeat.i(114014);
    if (e.lZ(paramString))
    {
      AppMethodBeat.o(114014);
      return false;
    }
    if (this.eDV.get(paramString) != null)
    {
      AppMethodBeat.o(114014);
      return true;
    }
    AppMethodBeat.o(114014);
    return false;
  }
  
  public final void lY(String paramString)
  {
    AppMethodBeat.i(114015);
    if (e.lZ(paramString))
    {
      com.tencent.mm.ipcinvoker.h.b.i("IPC.IPCBridgeManager", "the same process(%s), do not need to release IPCBridge.", new Object[] { paramString });
      AppMethodBeat.o(114015);
      return;
    }
    a locala;
    synchronized (this.eDV)
    {
      locala = (a)this.eDV.get(paramString);
      if (locala == null)
      {
        com.tencent.mm.ipcinvoker.h.b.i("IPC.IPCBridgeManager", "releaseIPCBridge(%s) failed, IPCBridgeWrapper is null.", new Object[] { paramString });
        AppMethodBeat.o(114015);
        return;
      }
    }
    if (locala.eEd) {}
    try
    {
      locala.eEd = false;
      locala.notifyAll();
      if (locala.serviceConnection == null)
      {
        com.tencent.mm.ipcinvoker.h.b.i("IPC.IPCBridgeManager", "releaseIPCBridge(%s) failed, ServiceConnection is null.", new Object[] { paramString });
        AppMethodBeat.o(114015);
        return;
      }
    }
    finally
    {
      AppMethodBeat.o(114015);
    }
    this.mHandler.post(new b.3(this, locala, paramString));
    AppMethodBeat.o(114015);
  }
  
  public static final class a
  {
    a eEc;
    public volatile boolean eEd;
    Runnable eEe;
    ServiceConnection serviceConnection;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.ipcinvoker.b
 * JD-Core Version:    0.7.0.1
 */