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
import com.tencent.mm.ipcinvoker.f.b;
import com.tencent.mm.ipcinvoker.h.c;
import java.util.HashMap;
import java.util.Map;
import java.util.Set;
import java.util.concurrent.ConcurrentHashMap;

public class e
{
  private static volatile e mym;
  private Handler mHandler;
  Map<String, Class<?>> myn;
  final Map<String, a> myo;
  private volatile boolean myp;
  final Map<String, Set<p>> myq;
  final Map<String, Set<q>> myr;
  final Map<String, Set<o>> mys;
  
  private e()
  {
    AppMethodBeat.i(158722);
    this.myn = new HashMap();
    this.myo = new ConcurrentHashMap();
    this.mHandler = n.aYv();
    this.myq = new HashMap();
    this.mys = new HashMap();
    this.myr = new HashMap();
    AppMethodBeat.o(158722);
  }
  
  public static e aYp()
  {
    AppMethodBeat.i(158721);
    if (mym == null) {}
    try
    {
      if (mym == null) {
        mym = new e();
      }
      e locale = mym;
      AppMethodBeat.o(158721);
      return locale;
    }
    finally
    {
      AppMethodBeat.o(158721);
    }
  }
  
  /* Error */
  public final com.tencent.mm.ipcinvoker.b.a ES(final String paramString)
  {
    // Byte code:
    //   0: ldc 131
    //   2: invokestatic 45	com/tencent/matrix/trace/core/AppMethodBeat:i	(I)V
    //   5: aload_0
    //   6: getfield 55	com/tencent/mm/ipcinvoker/e:myo	Ljava/util/Map;
    //   9: aload_1
    //   10: invokeinterface 82 2 0
    //   15: checkcast 16	com/tencent/mm/ipcinvoker/e$a
    //   18: astore 5
    //   20: ldc 133
    //   22: ldc 135
    //   24: iconst_3
    //   25: anewarray 4	java/lang/Object
    //   28: dup
    //   29: iconst_0
    //   30: invokestatic 141	java/lang/Thread:currentThread	()Ljava/lang/Thread;
    //   33: invokevirtual 145	java/lang/Thread:getId	()J
    //   36: invokestatic 151	java/lang/Long:valueOf	(J)Ljava/lang/Long;
    //   39: aastore
    //   40: dup
    //   41: iconst_1
    //   42: invokestatic 157	com/tencent/mm/ipcinvoker/i:aYs	()Ljava/lang/String;
    //   45: aastore
    //   46: dup
    //   47: iconst_2
    //   48: aload_1
    //   49: aastore
    //   50: invokestatic 162	com/tencent/mm/ipcinvoker/h/c:i	(Ljava/lang/String;Ljava/lang/String;[Ljava/lang/Object;)V
    //   53: aload 5
    //   55: ifnonnull +557 -> 612
    //   58: aload_0
    //   59: getfield 164	com/tencent/mm/ipcinvoker/e:myp	Z
    //   62: ifeq +25 -> 87
    //   65: ldc 133
    //   67: ldc 166
    //   69: iconst_1
    //   70: anewarray 4	java/lang/Object
    //   73: dup
    //   74: iconst_0
    //   75: aload_1
    //   76: aastore
    //   77: invokestatic 162	com/tencent/mm/ipcinvoker/h/c:i	(Ljava/lang/String;Ljava/lang/String;[Ljava/lang/Object;)V
    //   80: ldc 131
    //   82: invokestatic 72	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   85: aconst_null
    //   86: areturn
    //   87: invokestatic 172	android/os/Looper:getMainLooper	()Landroid/os/Looper;
    //   90: invokestatic 175	android/os/Looper:myLooper	()Landroid/os/Looper;
    //   93: if_acmpne +34 -> 127
    //   96: ldc 133
    //   98: ldc 177
    //   100: iconst_0
    //   101: anewarray 4	java/lang/Object
    //   104: invokestatic 180	com/tencent/mm/ipcinvoker/h/c:w	(Ljava/lang/String;Ljava/lang/String;[Ljava/lang/Object;)V
    //   107: new 6	com/tencent/mm/ipcinvoker/e$1
    //   110: dup
    //   111: aload_0
    //   112: aload_1
    //   113: invokespecial 182	com/tencent/mm/ipcinvoker/e$1:<init>	(Lcom/tencent/mm/ipcinvoker/e;Ljava/lang/String;)V
    //   116: invokestatic 186	com/tencent/mm/ipcinvoker/n:post	(Ljava/lang/Runnable;)Z
    //   119: pop
    //   120: ldc 131
    //   122: invokestatic 72	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   125: aconst_null
    //   126: areturn
    //   127: aload_1
    //   128: invokestatic 190	com/tencent/mm/ipcinvoker/i:getContext	()Landroid/content/Context;
    //   131: invokevirtual 195	android/content/Context:getPackageName	()Ljava/lang/String;
    //   134: invokestatic 201	com/tencent/mm/ipcinvoker/h/d:aD	(Ljava/lang/String;Ljava/lang/String;)Ljava/lang/String;
    //   137: astore 5
    //   139: aload_0
    //   140: getfield 50	com/tencent/mm/ipcinvoker/e:myn	Ljava/util/Map;
    //   143: new 203	java/lang/StringBuilder
    //   146: dup
    //   147: invokespecial 204	java/lang/StringBuilder:<init>	()V
    //   150: aload 5
    //   152: invokevirtual 208	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   155: bipush 47
    //   157: invokevirtual 211	java/lang/StringBuilder:append	(C)Ljava/lang/StringBuilder;
    //   160: aload_1
    //   161: invokevirtual 208	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   164: invokevirtual 214	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   167: invokeinterface 82 2 0
    //   172: checkcast 216	java/lang/Class
    //   175: astore 6
    //   177: aload 6
    //   179: ifnonnull +25 -> 204
    //   182: ldc 133
    //   184: ldc 218
    //   186: iconst_1
    //   187: anewarray 4	java/lang/Object
    //   190: dup
    //   191: iconst_0
    //   192: aload_1
    //   193: aastore
    //   194: invokestatic 180	com/tencent/mm/ipcinvoker/h/c:w	(Ljava/lang/String;Ljava/lang/String;[Ljava/lang/Object;)V
    //   197: ldc 131
    //   199: invokestatic 72	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   202: aconst_null
    //   203: areturn
    //   204: new 16	com/tencent/mm/ipcinvoker/e$a
    //   207: dup
    //   208: iconst_0
    //   209: invokespecial 221	com/tencent/mm/ipcinvoker/e$a:<init>	(B)V
    //   212: astore 4
    //   214: aload_0
    //   215: getfield 55	com/tencent/mm/ipcinvoker/e:myo	Ljava/util/Map;
    //   218: astore 7
    //   220: aload 7
    //   222: monitorenter
    //   223: aload_0
    //   224: getfield 55	com/tencent/mm/ipcinvoker/e:myo	Ljava/util/Map;
    //   227: aload_1
    //   228: aload 4
    //   230: invokeinterface 225 3 0
    //   235: pop
    //   236: aload 7
    //   238: monitorexit
    //   239: aload 4
    //   241: monitorenter
    //   242: aload 4
    //   244: iconst_1
    //   245: putfield 228	com/tencent/mm/ipcinvoker/e$a:myA	Z
    //   248: aload 4
    //   250: monitorexit
    //   251: invokestatic 190	com/tencent/mm/ipcinvoker/i:getContext	()Landroid/content/Context;
    //   254: astore 7
    //   256: aload 4
    //   258: new 8	com/tencent/mm/ipcinvoker/e$2
    //   261: dup
    //   262: aload_0
    //   263: aload_1
    //   264: aload 4
    //   266: aload 7
    //   268: invokespecial 231	com/tencent/mm/ipcinvoker/e$2:<init>	(Lcom/tencent/mm/ipcinvoker/e;Ljava/lang/String;Lcom/tencent/mm/ipcinvoker/e$a;Landroid/content/Context;)V
    //   271: putfield 235	com/tencent/mm/ipcinvoker/e$a:myz	Landroid/content/ServiceConnection;
    //   274: new 237	android/content/Intent
    //   277: dup
    //   278: invokespecial 238	android/content/Intent:<init>	()V
    //   281: aload 5
    //   283: aload 6
    //   285: invokevirtual 241	java/lang/Class:getCanonicalName	()Ljava/lang/String;
    //   288: invokevirtual 245	android/content/Intent:setClassName	(Ljava/lang/String;Ljava/lang/String;)Landroid/content/Intent;
    //   291: astore 5
    //   293: ldc 133
    //   295: ldc 247
    //   297: iconst_3
    //   298: anewarray 4	java/lang/Object
    //   301: dup
    //   302: iconst_0
    //   303: aload 4
    //   305: invokevirtual 251	java/lang/Object:hashCode	()I
    //   308: invokestatic 256	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
    //   311: aastore
    //   312: dup
    //   313: iconst_1
    //   314: invokestatic 141	java/lang/Thread:currentThread	()Ljava/lang/Thread;
    //   317: invokevirtual 145	java/lang/Thread:getId	()J
    //   320: invokestatic 151	java/lang/Long:valueOf	(J)Ljava/lang/Long;
    //   323: aastore
    //   324: dup
    //   325: iconst_2
    //   326: aload 5
    //   328: aastore
    //   329: invokestatic 162	com/tencent/mm/ipcinvoker/h/c:i	(Ljava/lang/String;Ljava/lang/String;[Ljava/lang/Object;)V
    //   332: aload 7
    //   334: aload 5
    //   336: aload 4
    //   338: getfield 235	com/tencent/mm/ipcinvoker/e$a:myz	Landroid/content/ServiceConnection;
    //   341: bipush 33
    //   343: invokevirtual 260	android/content/Context:bindService	(Landroid/content/Intent;Landroid/content/ServiceConnection;I)Z
    //   346: pop
    //   347: aload 4
    //   349: new 12	com/tencent/mm/ipcinvoker/e$3
    //   352: dup
    //   353: aload_0
    //   354: aload 4
    //   356: aload_1
    //   357: invokespecial 263	com/tencent/mm/ipcinvoker/e$3:<init>	(Lcom/tencent/mm/ipcinvoker/e;Lcom/tencent/mm/ipcinvoker/e$a;Ljava/lang/String;)V
    //   360: putfield 267	com/tencent/mm/ipcinvoker/e$a:myB	Ljava/lang/Runnable;
    //   363: aload_0
    //   364: getfield 63	com/tencent/mm/ipcinvoker/e:mHandler	Landroid/os/Handler;
    //   367: astore 5
    //   369: aload 4
    //   371: getfield 267	com/tencent/mm/ipcinvoker/e$a:myB	Ljava/lang/Runnable;
    //   374: astore 6
    //   376: invokestatic 175	android/os/Looper:myLooper	()Landroid/os/Looper;
    //   379: invokestatic 172	android/os/Looper:getMainLooper	()Landroid/os/Looper;
    //   382: if_acmpne +82 -> 464
    //   385: ldc2_w 268
    //   388: lstore_2
    //   389: aload 5
    //   391: aload 6
    //   393: lload_2
    //   394: invokevirtual 275	android/os/Handler:postDelayed	(Ljava/lang/Runnable;J)Z
    //   397: pop
    //   398: aload 4
    //   400: monitorenter
    //   401: aload 4
    //   403: getfield 228	com/tencent/mm/ipcinvoker/e$a:myA	Z
    //   406: ifeq +8 -> 414
    //   409: aload 4
    //   411: invokevirtual 278	java/lang/Object:wait	()V
    //   414: aload 4
    //   416: monitorexit
    //   417: aload 4
    //   419: monitorenter
    //   420: aload 4
    //   422: iconst_0
    //   423: putfield 228	com/tencent/mm/ipcinvoker/e$a:myA	Z
    //   426: aload 4
    //   428: monitorexit
    //   429: aload 4
    //   431: getfield 282	com/tencent/mm/ipcinvoker/e$a:myy	Lcom/tencent/mm/ipcinvoker/b/a;
    //   434: astore_1
    //   435: ldc 131
    //   437: invokestatic 72	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   440: aload_1
    //   441: areturn
    //   442: astore_1
    //   443: aload 7
    //   445: monitorexit
    //   446: ldc 131
    //   448: invokestatic 72	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   451: aload_1
    //   452: athrow
    //   453: astore_1
    //   454: aload 4
    //   456: monitorexit
    //   457: ldc 131
    //   459: invokestatic 72	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   462: aload_1
    //   463: athrow
    //   464: ldc2_w 283
    //   467: lstore_2
    //   468: goto -79 -> 389
    //   471: astore 5
    //   473: aload 4
    //   475: monitorexit
    //   476: ldc 131
    //   478: invokestatic 72	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   481: aload 5
    //   483: athrow
    //   484: astore 5
    //   486: ldc 133
    //   488: ldc_w 286
    //   491: iconst_1
    //   492: anewarray 4	java/lang/Object
    //   495: dup
    //   496: iconst_0
    //   497: aload 5
    //   499: invokestatic 292	android/util/Log:getStackTraceString	(Ljava/lang/Throwable;)Ljava/lang/String;
    //   502: aastore
    //   503: invokestatic 295	com/tencent/mm/ipcinvoker/h/c:e	(Ljava/lang/String;Ljava/lang/String;[Ljava/lang/Object;)V
    //   506: aload_0
    //   507: getfield 55	com/tencent/mm/ipcinvoker/e:myo	Ljava/util/Map;
    //   510: astore 5
    //   512: aload 5
    //   514: monitorenter
    //   515: aload_0
    //   516: getfield 55	com/tencent/mm/ipcinvoker/e:myo	Ljava/util/Map;
    //   519: aload_1
    //   520: invokeinterface 298 2 0
    //   525: pop
    //   526: aload 5
    //   528: monitorexit
    //   529: aload 4
    //   531: monitorenter
    //   532: aload 4
    //   534: iconst_0
    //   535: putfield 228	com/tencent/mm/ipcinvoker/e$a:myA	Z
    //   538: aload 4
    //   540: monitorexit
    //   541: ldc 131
    //   543: invokestatic 72	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   546: aconst_null
    //   547: areturn
    //   548: astore_1
    //   549: aload 4
    //   551: monitorexit
    //   552: ldc 131
    //   554: invokestatic 72	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   557: aload_1
    //   558: athrow
    //   559: astore_1
    //   560: aload 5
    //   562: monitorexit
    //   563: ldc 131
    //   565: invokestatic 72	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   568: aload_1
    //   569: athrow
    //   570: astore_1
    //   571: aload 4
    //   573: monitorenter
    //   574: aload 4
    //   576: iconst_0
    //   577: putfield 228	com/tencent/mm/ipcinvoker/e$a:myA	Z
    //   580: aload 4
    //   582: monitorexit
    //   583: ldc 131
    //   585: invokestatic 72	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   588: aload_1
    //   589: athrow
    //   590: astore_1
    //   591: aload 4
    //   593: monitorexit
    //   594: ldc 131
    //   596: invokestatic 72	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   599: aload_1
    //   600: athrow
    //   601: astore_1
    //   602: aload 4
    //   604: monitorexit
    //   605: ldc 131
    //   607: invokestatic 72	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   610: aload_1
    //   611: athrow
    //   612: aload 5
    //   614: astore 4
    //   616: aload 5
    //   618: getfield 228	com/tencent/mm/ipcinvoker/e$a:myA	Z
    //   621: ifeq -192 -> 429
    //   624: ldc 133
    //   626: ldc_w 300
    //   629: iconst_0
    //   630: anewarray 4	java/lang/Object
    //   633: invokestatic 162	com/tencent/mm/ipcinvoker/h/c:i	(Ljava/lang/String;Ljava/lang/String;[Ljava/lang/Object;)V
    //   636: invokestatic 172	android/os/Looper:getMainLooper	()Landroid/os/Looper;
    //   639: invokestatic 175	android/os/Looper:myLooper	()Landroid/os/Looper;
    //   642: if_acmpne +35 -> 677
    //   645: ldc 133
    //   647: ldc_w 302
    //   650: iconst_0
    //   651: anewarray 4	java/lang/Object
    //   654: invokestatic 180	com/tencent/mm/ipcinvoker/h/c:w	(Ljava/lang/String;Ljava/lang/String;[Ljava/lang/Object;)V
    //   657: new 14	com/tencent/mm/ipcinvoker/e$4
    //   660: dup
    //   661: aload_0
    //   662: aload_1
    //   663: invokespecial 303	com/tencent/mm/ipcinvoker/e$4:<init>	(Lcom/tencent/mm/ipcinvoker/e;Ljava/lang/String;)V
    //   666: invokestatic 186	com/tencent/mm/ipcinvoker/n:post	(Ljava/lang/Runnable;)Z
    //   669: pop
    //   670: ldc 131
    //   672: invokestatic 72	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   675: aconst_null
    //   676: areturn
    //   677: aload 5
    //   679: monitorenter
    //   680: aload 5
    //   682: getfield 228	com/tencent/mm/ipcinvoker/e$a:myA	Z
    //   685: ifeq +8 -> 693
    //   688: aload 5
    //   690: invokevirtual 278	java/lang/Object:wait	()V
    //   693: aload 5
    //   695: monitorexit
    //   696: aload 5
    //   698: astore 4
    //   700: goto -271 -> 429
    //   703: astore_1
    //   704: aload 5
    //   706: monitorexit
    //   707: ldc 131
    //   709: invokestatic 72	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   712: aload_1
    //   713: athrow
    //   714: astore_1
    //   715: ldc 133
    //   717: ldc_w 305
    //   720: iconst_1
    //   721: anewarray 4	java/lang/Object
    //   724: dup
    //   725: iconst_0
    //   726: aload_1
    //   727: aastore
    //   728: invokestatic 295	com/tencent/mm/ipcinvoker/h/c:e	(Ljava/lang/String;Ljava/lang/String;[Ljava/lang/Object;)V
    //   731: aload 5
    //   733: astore 4
    //   735: goto -306 -> 429
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	738	0	this	e
    //   0	738	1	paramString	String
    //   388	80	2	l	long
    //   212	522	4	localObject1	Object
    //   18	372	5	localObject2	Object
    //   471	11	5	localObject3	Object
    //   484	14	5	localException	java.lang.Exception
    //   175	217	6	localObject4	Object
    //   218	226	7	localObject5	Object
    // Exception table:
    //   from	to	target	type
    //   223	239	442	finally
    //   242	251	453	finally
    //   401	414	471	finally
    //   414	417	471	finally
    //   274	385	484	java/lang/Exception
    //   389	401	484	java/lang/Exception
    //   473	484	484	java/lang/Exception
    //   420	429	548	finally
    //   515	529	559	finally
    //   274	385	570	finally
    //   389	401	570	finally
    //   473	484	570	finally
    //   486	515	570	finally
    //   560	570	570	finally
    //   532	541	590	finally
    //   574	583	601	finally
    //   680	693	703	finally
    //   693	696	703	finally
    //   677	680	714	java/lang/InterruptedException
    //   704	714	714	java/lang/InterruptedException
  }
  
  public final boolean ET(String paramString)
  {
    AppMethodBeat.i(158724);
    if (i.EW(paramString))
    {
      AppMethodBeat.o(158724);
      return false;
    }
    if (this.myo.get(paramString) != null)
    {
      AppMethodBeat.o(158724);
      return true;
    }
    AppMethodBeat.o(158724);
    return false;
  }
  
  public final boolean EU(String paramString)
  {
    AppMethodBeat.i(235692);
    if (!ET(paramString))
    {
      AppMethodBeat.o(235692);
      return false;
    }
    paramString = (a)this.myo.get(paramString);
    if ((paramString == null) || (paramString.myA))
    {
      AppMethodBeat.o(235692);
      return false;
    }
    if ((paramString.myz != null) && (paramString.myy != null))
    {
      AppMethodBeat.o(235692);
      return true;
    }
    AppMethodBeat.o(235692);
    return false;
  }
  
  /* Error */
  public final void EV(String paramString)
  {
    // Byte code:
    //   0: ldc_w 318
    //   3: invokestatic 45	com/tencent/matrix/trace/core/AppMethodBeat:i	(I)V
    //   6: aload_1
    //   7: invokestatic 311	com/tencent/mm/ipcinvoker/i:EW	(Ljava/lang/String;)Z
    //   10: ifeq +26 -> 36
    //   13: ldc 133
    //   15: ldc_w 320
    //   18: iconst_1
    //   19: anewarray 4	java/lang/Object
    //   22: dup
    //   23: iconst_0
    //   24: aload_1
    //   25: aastore
    //   26: invokestatic 162	com/tencent/mm/ipcinvoker/h/c:i	(Ljava/lang/String;Ljava/lang/String;[Ljava/lang/Object;)V
    //   29: ldc_w 318
    //   32: invokestatic 72	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   35: return
    //   36: aload_0
    //   37: getfield 55	com/tencent/mm/ipcinvoker/e:myo	Ljava/util/Map;
    //   40: astore_3
    //   41: aload_3
    //   42: monitorenter
    //   43: aload_0
    //   44: getfield 55	com/tencent/mm/ipcinvoker/e:myo	Ljava/util/Map;
    //   47: aload_1
    //   48: invokeinterface 82 2 0
    //   53: checkcast 16	com/tencent/mm/ipcinvoker/e$a
    //   56: astore_2
    //   57: aload_3
    //   58: monitorexit
    //   59: aload_2
    //   60: ifnonnull +37 -> 97
    //   63: ldc 133
    //   65: ldc_w 322
    //   68: iconst_1
    //   69: anewarray 4	java/lang/Object
    //   72: dup
    //   73: iconst_0
    //   74: aload_1
    //   75: aastore
    //   76: invokestatic 162	com/tencent/mm/ipcinvoker/h/c:i	(Ljava/lang/String;Ljava/lang/String;[Ljava/lang/Object;)V
    //   79: ldc_w 318
    //   82: invokestatic 72	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   85: return
    //   86: astore_1
    //   87: aload_3
    //   88: monitorexit
    //   89: ldc_w 318
    //   92: invokestatic 72	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   95: aload_1
    //   96: athrow
    //   97: aload_2
    //   98: getfield 228	com/tencent/mm/ipcinvoker/e$a:myA	Z
    //   101: ifeq +16 -> 117
    //   104: aload_2
    //   105: monitorenter
    //   106: aload_2
    //   107: iconst_0
    //   108: putfield 228	com/tencent/mm/ipcinvoker/e$a:myA	Z
    //   111: aload_2
    //   112: invokevirtual 325	java/lang/Object:notifyAll	()V
    //   115: aload_2
    //   116: monitorexit
    //   117: aload_2
    //   118: getfield 235	com/tencent/mm/ipcinvoker/e$a:myz	Landroid/content/ServiceConnection;
    //   121: ifnonnull +37 -> 158
    //   124: ldc 133
    //   126: ldc_w 327
    //   129: iconst_1
    //   130: anewarray 4	java/lang/Object
    //   133: dup
    //   134: iconst_0
    //   135: aload_1
    //   136: aastore
    //   137: invokestatic 162	com/tencent/mm/ipcinvoker/h/c:i	(Ljava/lang/String;Ljava/lang/String;[Ljava/lang/Object;)V
    //   140: ldc_w 318
    //   143: invokestatic 72	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   146: return
    //   147: astore_1
    //   148: aload_2
    //   149: monitorexit
    //   150: ldc_w 318
    //   153: invokestatic 72	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   156: aload_1
    //   157: athrow
    //   158: aload_2
    //   159: getfield 235	com/tencent/mm/ipcinvoker/e$a:myz	Landroid/content/ServiceConnection;
    //   162: astore_3
    //   163: invokestatic 190	com/tencent/mm/ipcinvoker/i:getContext	()Landroid/content/Context;
    //   166: aload_3
    //   167: invokevirtual 331	android/content/Context:unbindService	(Landroid/content/ServiceConnection;)V
    //   170: aload_0
    //   171: getfield 55	com/tencent/mm/ipcinvoker/e:myo	Ljava/util/Map;
    //   174: astore_3
    //   175: aload_3
    //   176: monitorenter
    //   177: aload_0
    //   178: getfield 55	com/tencent/mm/ipcinvoker/e:myo	Ljava/util/Map;
    //   181: aload_1
    //   182: invokeinterface 298 2 0
    //   187: pop
    //   188: aload_3
    //   189: monitorexit
    //   190: aload_2
    //   191: monitorenter
    //   192: aload_2
    //   193: aconst_null
    //   194: putfield 282	com/tencent/mm/ipcinvoker/e$a:myy	Lcom/tencent/mm/ipcinvoker/b/a;
    //   197: aload_2
    //   198: iconst_0
    //   199: putfield 228	com/tencent/mm/ipcinvoker/e$a:myA	Z
    //   202: aload_2
    //   203: aconst_null
    //   204: putfield 235	com/tencent/mm/ipcinvoker/e$a:myz	Landroid/content/ServiceConnection;
    //   207: aload_2
    //   208: monitorexit
    //   209: ldc_w 318
    //   212: invokestatic 72	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   215: return
    //   216: astore_3
    //   217: ldc 133
    //   219: ldc_w 333
    //   222: iconst_2
    //   223: anewarray 4	java/lang/Object
    //   226: dup
    //   227: iconst_0
    //   228: aload_1
    //   229: aastore
    //   230: dup
    //   231: iconst_1
    //   232: aload_3
    //   233: invokestatic 292	android/util/Log:getStackTraceString	(Ljava/lang/Throwable;)Ljava/lang/String;
    //   236: aastore
    //   237: invokestatic 295	com/tencent/mm/ipcinvoker/h/c:e	(Ljava/lang/String;Ljava/lang/String;[Ljava/lang/Object;)V
    //   240: goto -70 -> 170
    //   243: astore_1
    //   244: aload_3
    //   245: monitorexit
    //   246: ldc_w 318
    //   249: invokestatic 72	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   252: aload_1
    //   253: athrow
    //   254: astore_1
    //   255: aload_2
    //   256: monitorexit
    //   257: ldc_w 318
    //   260: invokestatic 72	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   263: aload_1
    //   264: athrow
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	265	0	this	e
    //   0	265	1	paramString	String
    //   56	200	2	locala	a
    //   216	29	3	localException	java.lang.Exception
    // Exception table:
    //   from	to	target	type
    //   43	59	86	finally
    //   106	117	147	finally
    //   163	170	216	java/lang/Exception
    //   177	190	243	finally
    //   192	209	254	finally
  }
  
  public final boolean a(String paramString, o paramo)
  {
    AppMethodBeat.i(235687);
    if (paramo == null)
    {
      AppMethodBeat.o(235687);
      return false;
    }
    synchronized (this.mys)
    {
      paramString = (Set)this.mys.get(paramString);
      if (paramString != null)
      {
        boolean bool = paramString.remove(paramo);
        AppMethodBeat.o(235687);
        return bool;
      }
      AppMethodBeat.o(235687);
      return false;
    }
  }
  
  public final boolean a(String paramString, p paramp)
  {
    AppMethodBeat.i(235690);
    if (paramp == null)
    {
      AppMethodBeat.o(235690);
      return false;
    }
    synchronized (this.myq)
    {
      paramString = (Set)this.myq.get(paramString);
      if (paramString != null)
      {
        boolean bool = paramString.remove(paramp);
        AppMethodBeat.o(235690);
        return bool;
      }
      AppMethodBeat.o(235690);
      return false;
    }
  }
  
  public final boolean a(String paramString, q paramq)
  {
    AppMethodBeat.i(235689);
    if (paramq == null)
    {
      AppMethodBeat.o(235689);
      return false;
    }
    synchronized (this.myr)
    {
      paramString = (Set)this.myr.get(paramString);
      if (paramString != null)
      {
        boolean bool = paramString.remove(paramq);
        AppMethodBeat.o(235689);
        return bool;
      }
      AppMethodBeat.o(235689);
      return false;
    }
  }
  
  public final void aYq()
  {
    try
    {
      this.myp = true;
      return;
    }
    finally
    {
      localObject = finally;
      throw localObject;
    }
  }
  
  static final class a
  {
    volatile boolean myA;
    Runnable myB;
    com.tencent.mm.ipcinvoker.b.a myy;
    ServiceConnection myz;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.ipcinvoker.e
 * JD-Core Version:    0.7.0.1
 */