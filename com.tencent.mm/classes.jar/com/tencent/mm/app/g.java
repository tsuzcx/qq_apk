package com.tencent.mm.app;

import android.app.ActivityManager;
import android.app.ActivityManager.RunningAppProcessInfo;
import android.content.ComponentName;
import android.content.Context;
import android.content.ServiceConnection;
import android.os.IBinder;
import android.os.Process;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.blink.b;
import com.tencent.mm.booter.c;
import com.tencent.mm.kernel.b.h;
import com.tencent.mm.kernel.d;
import com.tencent.mm.sdk.platformtools.ac;
import com.tencent.mm.sdk.platformtools.ai;
import com.tencent.mm.sdk.platformtools.ap;
import com.tencent.mm.sdk.platformtools.bs;
import java.util.Iterator;
import java.util.List;
import java.util.concurrent.locks.ReentrantLock;

public final class g
  implements ServiceConnection
{
  private static boolean cIl;
  private static int cIq;
  private static int cIr;
  private static Object lock;
  private ReentrantLock cIm;
  private boolean cIn;
  private IBinder cIo;
  private Runnable cIp;
  
  static
  {
    AppMethodBeat.i(131782);
    cIl = false;
    lock = new Object();
    cIq = 0;
    cIr = 40000;
    AppMethodBeat.o(131782);
  }
  
  public g()
  {
    AppMethodBeat.i(131773);
    this.cIm = new ReentrantLock();
    this.cIn = false;
    this.cIo = null;
    this.cIp = new Runnable()
    {
      private int cIv = 0;
      
      /* Error */
      public final void run()
      {
        // Byte code:
        //   0: ldc 26
        //   2: invokestatic 32	com/tencent/matrix/trace/core/AppMethodBeat:i	(I)V
        //   5: aload_0
        //   6: getfield 16	com/tencent/mm/app/g$6:cIs	Lcom/tencent/mm/app/g;
        //   9: invokestatic 36	com/tencent/mm/app/g:b	(Lcom/tencent/mm/app/g;)Ljava/util/concurrent/locks/ReentrantLock;
        //   12: invokevirtual 41	java/util/concurrent/locks/ReentrantLock:lock	()V
        //   15: aload_0
        //   16: getfield 16	com/tencent/mm/app/g$6:cIs	Lcom/tencent/mm/app/g;
        //   19: invokestatic 45	com/tencent/mm/app/g:c	(Lcom/tencent/mm/app/g;)Landroid/os/IBinder;
        //   22: ifnull +75 -> 97
        //   25: aload_0
        //   26: getfield 16	com/tencent/mm/app/g$6:cIs	Lcom/tencent/mm/app/g;
        //   29: invokestatic 45	com/tencent/mm/app/g:c	(Lcom/tencent/mm/app/g;)Landroid/os/IBinder;
        //   32: invokeinterface 51 1 0
        //   37: ifeq +60 -> 97
        //   40: iconst_1
        //   41: istore_2
        //   42: ldc 53
        //   44: ldc 55
        //   46: iconst_2
        //   47: anewarray 4	java/lang/Object
        //   50: dup
        //   51: iconst_0
        //   52: aload_0
        //   53: getfield 16	com/tencent/mm/app/g$6:cIs	Lcom/tencent/mm/app/g;
        //   56: invokestatic 45	com/tencent/mm/app/g:c	(Lcom/tencent/mm/app/g;)Landroid/os/IBinder;
        //   59: aastore
        //   60: dup
        //   61: iconst_1
        //   62: iload_2
        //   63: invokestatic 61	java/lang/Boolean:valueOf	(Z)Ljava/lang/Boolean;
        //   66: aastore
        //   67: invokestatic 66	com/tencent/mm/sdk/platformtools/ac:i	(Ljava/lang/String;Ljava/lang/String;[Ljava/lang/Object;)V
        //   70: iload_2
        //   71: ifeq +31 -> 102
        //   74: ldc 53
        //   76: ldc 68
        //   78: invokestatic 72	com/tencent/mm/sdk/platformtools/ac:w	(Ljava/lang/String;Ljava/lang/String;)V
        //   81: aload_0
        //   82: getfield 16	com/tencent/mm/app/g$6:cIs	Lcom/tencent/mm/app/g;
        //   85: invokestatic 36	com/tencent/mm/app/g:b	(Lcom/tencent/mm/app/g;)Ljava/util/concurrent/locks/ReentrantLock;
        //   88: invokevirtual 75	java/util/concurrent/locks/ReentrantLock:unlock	()V
        //   91: ldc 26
        //   93: invokestatic 78	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
        //   96: return
        //   97: iconst_0
        //   98: istore_2
        //   99: goto -57 -> 42
        //   102: aload_0
        //   103: getfield 16	com/tencent/mm/app/g$6:cIs	Lcom/tencent/mm/app/g;
        //   106: invokestatic 36	com/tencent/mm/app/g:b	(Lcom/tencent/mm/app/g;)Ljava/util/concurrent/locks/ReentrantLock;
        //   109: invokevirtual 75	java/util/concurrent/locks/ReentrantLock:unlock	()V
        //   112: ldc 53
        //   114: ldc 80
        //   116: iconst_1
        //   117: anewarray 4	java/lang/Object
        //   120: dup
        //   121: iconst_0
        //   122: aload_0
        //   123: getfield 21	com/tencent/mm/app/g$6:cIv	I
        //   126: invokestatic 85	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
        //   129: aastore
        //   130: invokestatic 91	java/lang/String:format	(Ljava/lang/String;[Ljava/lang/Object;)Ljava/lang/String;
        //   133: invokestatic 94	com/tencent/mm/sdk/platformtools/ac:e	(Ljava/lang/String;Ljava/lang/String;)V
        //   136: aload_0
        //   137: getfield 21	com/tencent/mm/app/g$6:cIv	I
        //   140: iconst_1
        //   141: if_icmpne +42 -> 183
        //   144: ldc 96
        //   146: invokestatic 100	com/tencent/mm/app/g:en	(Ljava/lang/String;)I
        //   149: istore_1
        //   150: iload_1
        //   151: iconst_m1
        //   152: if_icmpeq +150 -> 302
        //   155: ldc 53
        //   157: ldc 102
        //   159: iconst_1
        //   160: anewarray 4	java/lang/Object
        //   163: dup
        //   164: iconst_0
        //   165: iload_1
        //   166: invokestatic 85	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
        //   169: aastore
        //   170: invokestatic 91	java/lang/String:format	(Ljava/lang/String;[Ljava/lang/Object;)Ljava/lang/String;
        //   173: invokestatic 104	com/tencent/mm/sdk/platformtools/ac:i	(Ljava/lang/String;Ljava/lang/String;)V
        //   176: invokestatic 107	com/tencent/mm/sdk/platformtools/ac:eUQ	()V
        //   179: iload_1
        //   180: invokestatic 110	com/tencent/mm/app/g:killProcess	(I)V
        //   183: invokestatic 116	com/tencent/mm/sdk/platformtools/ai:getContext	()Landroid/content/Context;
        //   186: astore_3
        //   187: new 118	android/content/Intent
        //   190: dup
        //   191: aload_3
        //   192: ldc 120
        //   194: invokespecial 123	android/content/Intent:<init>	(Landroid/content/Context;Ljava/lang/Class;)V
        //   197: astore 4
        //   199: ldc 53
        //   201: ldc 125
        //   203: invokestatic 104	com/tencent/mm/sdk/platformtools/ac:i	(Ljava/lang/String;Ljava/lang/String;)V
        //   206: aload_3
        //   207: aload_0
        //   208: getfield 16	com/tencent/mm/app/g$6:cIs	Lcom/tencent/mm/app/g;
        //   211: invokevirtual 131	android/content/Context:unbindService	(Landroid/content/ServiceConnection;)V
        //   214: invokestatic 136	com/tencent/mm/booter/c:Un	()Z
        //   217: ifeq +95 -> 312
        //   220: aload_3
        //   221: aload 4
        //   223: aload_0
        //   224: getfield 16	com/tencent/mm/app/g$6:cIs	Lcom/tencent/mm/app/g;
        //   227: iconst_1
        //   228: invokevirtual 140	android/content/Context:bindService	(Landroid/content/Intent;Landroid/content/ServiceConnection;I)Z
        //   231: pop
        //   232: aload_0
        //   233: getfield 21	com/tencent/mm/app/g$6:cIv	I
        //   236: iconst_1
        //   237: if_icmpne +279 -> 516
        //   240: aload_0
        //   241: iconst_0
        //   242: putfield 21	com/tencent/mm/app/g$6:cIv	I
        //   245: aload_0
        //   246: iconst_1
        //   247: invokestatic 144	com/tencent/mm/app/g:ca	(Z)I
        //   250: i2l
        //   251: invokestatic 150	com/tencent/mm/sdk/platformtools/ap:n	(Ljava/lang/Runnable;J)V
        //   254: ldc 53
        //   256: ldc 152
        //   258: iconst_1
        //   259: anewarray 4	java/lang/Object
        //   262: dup
        //   263: iconst_0
        //   264: aload_0
        //   265: getfield 21	com/tencent/mm/app/g$6:cIv	I
        //   268: invokestatic 85	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
        //   271: aastore
        //   272: invokestatic 91	java/lang/String:format	(Ljava/lang/String;[Ljava/lang/Object;)Ljava/lang/String;
        //   275: invokestatic 104	com/tencent/mm/sdk/platformtools/ac:i	(Ljava/lang/String;Ljava/lang/String;)V
        //   278: ldc 26
        //   280: invokestatic 78	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
        //   283: return
        //   284: astore_3
        //   285: aload_0
        //   286: getfield 16	com/tencent/mm/app/g$6:cIs	Lcom/tencent/mm/app/g;
        //   289: invokestatic 36	com/tencent/mm/app/g:b	(Lcom/tencent/mm/app/g;)Ljava/util/concurrent/locks/ReentrantLock;
        //   292: invokevirtual 75	java/util/concurrent/locks/ReentrantLock:unlock	()V
        //   295: ldc 26
        //   297: invokestatic 78	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
        //   300: aload_3
        //   301: athrow
        //   302: ldc 53
        //   304: ldc 154
        //   306: invokestatic 104	com/tencent/mm/sdk/platformtools/ac:i	(Ljava/lang/String;Ljava/lang/String;)V
        //   309: goto -126 -> 183
        //   312: aload_3
        //   313: aload 4
        //   315: invokevirtual 158	android/content/Context:stopService	(Landroid/content/Intent;)Z
        //   318: pop
        //   319: aload_3
        //   320: aload 4
        //   322: aload_0
        //   323: getfield 16	com/tencent/mm/app/g$6:cIs	Lcom/tencent/mm/app/g;
        //   326: iconst_1
        //   327: invokevirtual 140	android/content/Context:bindService	(Landroid/content/Intent;Landroid/content/ServiceConnection;I)Z
        //   330: pop
        //   331: aload_3
        //   332: aload 4
        //   334: invokevirtual 162	android/content/Context:startService	(Landroid/content/Intent;)Landroid/content/ComponentName;
        //   337: pop
        //   338: goto -106 -> 232
        //   341: astore_3
        //   342: ldc 53
        //   344: ldc 164
        //   346: iconst_1
        //   347: anewarray 4	java/lang/Object
        //   350: dup
        //   351: iconst_0
        //   352: aload_3
        //   353: invokevirtual 168	java/lang/Exception:getMessage	()Ljava/lang/String;
        //   356: aastore
        //   357: invokestatic 170	com/tencent/mm/sdk/platformtools/ac:e	(Ljava/lang/String;Ljava/lang/String;[Ljava/lang/Object;)V
        //   360: goto -128 -> 232
        //   363: astore 5
        //   365: invokestatic 136	com/tencent/mm/booter/c:Un	()Z
        //   368: ifeq +40 -> 408
        //   371: aload_3
        //   372: aload 4
        //   374: aload_0
        //   375: getfield 16	com/tencent/mm/app/g$6:cIs	Lcom/tencent/mm/app/g;
        //   378: iconst_1
        //   379: invokevirtual 140	android/content/Context:bindService	(Landroid/content/Intent;Landroid/content/ServiceConnection;I)Z
        //   382: pop
        //   383: goto -151 -> 232
        //   386: astore_3
        //   387: ldc 53
        //   389: ldc 164
        //   391: iconst_1
        //   392: anewarray 4	java/lang/Object
        //   395: dup
        //   396: iconst_0
        //   397: aload_3
        //   398: invokevirtual 168	java/lang/Exception:getMessage	()Ljava/lang/String;
        //   401: aastore
        //   402: invokestatic 170	com/tencent/mm/sdk/platformtools/ac:e	(Ljava/lang/String;Ljava/lang/String;[Ljava/lang/Object;)V
        //   405: goto -173 -> 232
        //   408: aload_3
        //   409: aload 4
        //   411: invokevirtual 158	android/content/Context:stopService	(Landroid/content/Intent;)Z
        //   414: pop
        //   415: aload_3
        //   416: aload 4
        //   418: aload_0
        //   419: getfield 16	com/tencent/mm/app/g$6:cIs	Lcom/tencent/mm/app/g;
        //   422: iconst_1
        //   423: invokevirtual 140	android/content/Context:bindService	(Landroid/content/Intent;Landroid/content/ServiceConnection;I)Z
        //   426: pop
        //   427: aload_3
        //   428: aload 4
        //   430: invokevirtual 162	android/content/Context:startService	(Landroid/content/Intent;)Landroid/content/ComponentName;
        //   433: pop
        //   434: goto -202 -> 232
        //   437: astore 5
        //   439: invokestatic 136	com/tencent/mm/booter/c:Un	()Z
        //   442: ifeq +23 -> 465
        //   445: aload_3
        //   446: aload 4
        //   448: aload_0
        //   449: getfield 16	com/tencent/mm/app/g$6:cIs	Lcom/tencent/mm/app/g;
        //   452: iconst_1
        //   453: invokevirtual 140	android/content/Context:bindService	(Landroid/content/Intent;Landroid/content/ServiceConnection;I)Z
        //   456: pop
        //   457: ldc 26
        //   459: invokestatic 78	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
        //   462: aload 5
        //   464: athrow
        //   465: aload_3
        //   466: aload 4
        //   468: invokevirtual 158	android/content/Context:stopService	(Landroid/content/Intent;)Z
        //   471: pop
        //   472: aload_3
        //   473: aload 4
        //   475: aload_0
        //   476: getfield 16	com/tencent/mm/app/g$6:cIs	Lcom/tencent/mm/app/g;
        //   479: iconst_1
        //   480: invokevirtual 140	android/content/Context:bindService	(Landroid/content/Intent;Landroid/content/ServiceConnection;I)Z
        //   483: pop
        //   484: aload_3
        //   485: aload 4
        //   487: invokevirtual 162	android/content/Context:startService	(Landroid/content/Intent;)Landroid/content/ComponentName;
        //   490: pop
        //   491: goto -34 -> 457
        //   494: astore_3
        //   495: ldc 53
        //   497: ldc 164
        //   499: iconst_1
        //   500: anewarray 4	java/lang/Object
        //   503: dup
        //   504: iconst_0
        //   505: aload_3
        //   506: invokevirtual 168	java/lang/Exception:getMessage	()Ljava/lang/String;
        //   509: aastore
        //   510: invokestatic 170	com/tencent/mm/sdk/platformtools/ac:e	(Ljava/lang/String;Ljava/lang/String;[Ljava/lang/Object;)V
        //   513: goto -56 -> 457
        //   516: aload_0
        //   517: aload_0
        //   518: getfield 21	com/tencent/mm/app/g$6:cIv	I
        //   521: iconst_1
        //   522: iadd
        //   523: putfield 21	com/tencent/mm/app/g$6:cIv	I
        //   526: goto -281 -> 245
        // Local variable table:
        //   start	length	slot	name	signature
        //   0	529	0	this	6
        //   149	31	1	i	int
        //   41	58	2	bool	boolean
        //   186	35	3	localContext	Context
        //   284	48	3	localObject1	Object
        //   341	31	3	localException1	Exception
        //   386	99	3	localException2	Exception
        //   494	12	3	localException3	Exception
        //   197	289	4	localIntent	android.content.Intent
        //   363	1	5	localException4	Exception
        //   437	26	5	localObject2	Object
        // Exception table:
        //   from	to	target	type
        //   5	40	284	finally
        //   42	70	284	finally
        //   74	81	284	finally
        //   214	232	341	java/lang/Exception
        //   312	338	341	java/lang/Exception
        //   199	214	363	java/lang/Exception
        //   365	383	386	java/lang/Exception
        //   408	434	386	java/lang/Exception
        //   199	214	437	finally
        //   439	457	494	java/lang/Exception
        //   465	491	494	java/lang/Exception
      }
    };
    AppMethodBeat.o(131773);
  }
  
  public static void Km()
  {
    AppMethodBeat.i(131778);
    int i = en("com.tencent.mm:push");
    ac.e("MicroMsg.CoreServiceConnection", "killPushProcess() pid = %s, stack[%s]", new Object[] { Integer.valueOf(i), bs.eWi() });
    killProcess(i);
    AppMethodBeat.o(131778);
  }
  
  public static int ca(boolean paramBoolean)
  {
    AppMethodBeat.i(206867);
    int i = cIr;
    if (paramBoolean)
    {
      int j = cIq + 1;
      cIq = j;
      if ((j == 5) && (i < 600000))
      {
        cIr += 40000;
        cIq = 0;
        ac.i("MicroMsg.CoreServiceConnection", "ZOMBIE_CHECK_TIME:%s", new Object[] { Integer.valueOf(cIr) });
      }
    }
    AppMethodBeat.o(206867);
    return i;
  }
  
  public static int en(String paramString)
  {
    AppMethodBeat.i(131777);
    if (bs.isNullOrNil(paramString))
    {
      ac.i("MicroMsg.CoreServiceConnection", "getPicByProcessName() processName == null");
      AppMethodBeat.o(131777);
      return -1;
    }
    for (;;)
    {
      try
      {
        Object localObject = ((ActivityManager)ai.getContext().getSystemService("activity")).getRunningAppProcesses();
        if (localObject == null)
        {
          ac.i("MicroMsg.CoreServiceConnection", "getPicByProcessName() processes == null");
          AppMethodBeat.o(131777);
          return -1;
        }
        localObject = ((List)localObject).iterator();
        if (!((Iterator)localObject).hasNext()) {
          continue;
        }
        ActivityManager.RunningAppProcessInfo localRunningAppProcessInfo = (ActivityManager.RunningAppProcessInfo)((Iterator)localObject).next();
        if (!localRunningAppProcessInfo.processName.equals(paramString)) {
          continue;
        }
        i = localRunningAppProcessInfo.pid;
      }
      catch (Exception localException)
      {
        ac.e("MicroMsg.CoreServiceConnection", "getPidByProcessName() %s %s %s", new Object[] { paramString, localException.getClass().getSimpleName(), localException.getMessage() });
        int i = -1;
        continue;
      }
      AppMethodBeat.o(131777);
      return i;
      i = -1;
    }
  }
  
  public static void killProcess(int paramInt)
  {
    AppMethodBeat.i(131779);
    try
    {
      Process.killProcess(paramInt);
      AppMethodBeat.o(131779);
      return;
    }
    catch (Exception localException)
    {
      ac.e("MicroMsg.CoreServiceConnection", "killProcess %s, %s %s", new Object[] { Integer.valueOf(paramInt), localException.getClass().getSimpleName(), localException.getMessage() });
      AppMethodBeat.o(131779);
    }
  }
  
  /* Error */
  public final void bl(Context paramContext)
  {
    // Byte code:
    //   0: ldc_w 639
    //   3: invokestatic 37	com/tencent/matrix/trace/core/AppMethodBeat:i	(I)V
    //   6: ldc_w 641
    //   9: invokestatic 169	com/tencent/mm/blink/a:rp	(Ljava/lang/String;)V
    //   12: aload_0
    //   13: getfield 59	com/tencent/mm/app/g:cIm	Ljava/util/concurrent/locks/ReentrantLock;
    //   16: invokevirtual 643	java/util/concurrent/locks/ReentrantLock:lock	()V
    //   19: aload_0
    //   20: getfield 63	com/tencent/mm/app/g:cIo	Landroid/os/IBinder;
    //   23: ifnull +100 -> 123
    //   26: aload_0
    //   27: getfield 63	com/tencent/mm/app/g:cIo	Landroid/os/IBinder;
    //   30: invokeinterface 648 1 0
    //   35: ifeq +88 -> 123
    //   38: iconst_1
    //   39: istore_2
    //   40: ldc 78
    //   42: ldc_w 650
    //   45: iconst_2
    //   46: anewarray 4	java/lang/Object
    //   49: dup
    //   50: iconst_0
    //   51: aload_0
    //   52: getfield 61	com/tencent/mm/app/g:cIn	Z
    //   55: invokestatic 431	java/lang/Boolean:valueOf	(Z)Ljava/lang/Boolean;
    //   58: aastore
    //   59: dup
    //   60: iconst_1
    //   61: iload_2
    //   62: invokestatic 431	java/lang/Boolean:valueOf	(Z)Ljava/lang/Boolean;
    //   65: aastore
    //   66: invokestatic 472	com/tencent/mm/sdk/platformtools/ac:i	(Ljava/lang/String;Ljava/lang/String;[Ljava/lang/Object;)V
    //   69: aload_0
    //   70: getfield 61	com/tencent/mm/app/g:cIn	Z
    //   73: ifne +7 -> 80
    //   76: iload_2
    //   77: ifeq +51 -> 128
    //   80: ldc 78
    //   82: ldc_w 652
    //   85: iconst_2
    //   86: anewarray 4	java/lang/Object
    //   89: dup
    //   90: iconst_0
    //   91: aload_0
    //   92: getfield 61	com/tencent/mm/app/g:cIn	Z
    //   95: invokestatic 431	java/lang/Boolean:valueOf	(Z)Ljava/lang/Boolean;
    //   98: aastore
    //   99: dup
    //   100: iconst_1
    //   101: iload_2
    //   102: invokestatic 431	java/lang/Boolean:valueOf	(Z)Ljava/lang/Boolean;
    //   105: aastore
    //   106: invokestatic 433	com/tencent/mm/sdk/platformtools/ac:w	(Ljava/lang/String;Ljava/lang/String;[Ljava/lang/Object;)V
    //   109: aload_0
    //   110: getfield 59	com/tencent/mm/app/g:cIm	Ljava/util/concurrent/locks/ReentrantLock;
    //   113: invokevirtual 655	java/util/concurrent/locks/ReentrantLock:unlock	()V
    //   116: ldc_w 639
    //   119: invokestatic 52	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   122: return
    //   123: iconst_0
    //   124: istore_2
    //   125: goto -85 -> 40
    //   128: aload_0
    //   129: getfield 59	com/tencent/mm/app/g:cIm	Ljava/util/concurrent/locks/ReentrantLock;
    //   132: invokevirtual 655	java/util/concurrent/locks/ReentrantLock:unlock	()V
    //   135: invokestatic 660	com/tencent/mm/booter/c:Un	()Z
    //   138: ifeq +182 -> 320
    //   141: new 662	android/content/Intent
    //   144: dup
    //   145: aload_1
    //   146: ldc_w 664
    //   149: invokespecial 667	android/content/Intent:<init>	(Landroid/content/Context;Ljava/lang/Class;)V
    //   152: astore_3
    //   153: ldc 78
    //   155: ldc_w 669
    //   158: invokestatic 574	com/tencent/mm/sdk/platformtools/ac:i	(Ljava/lang/String;Ljava/lang/String;)V
    //   161: aload_1
    //   162: aload_3
    //   163: aload_0
    //   164: iconst_1
    //   165: invokevirtual 673	android/content/Context:bindService	(Landroid/content/Intent;Landroid/content/ServiceConnection;I)Z
    //   168: ifne +61 -> 229
    //   171: ldc 78
    //   173: ldc_w 675
    //   176: invokestatic 302	com/tencent/mm/sdk/platformtools/ac:e	(Ljava/lang/String;Ljava/lang/String;)V
    //   179: ldc_w 639
    //   182: invokestatic 52	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   185: return
    //   186: astore_1
    //   187: aload_0
    //   188: getfield 59	com/tencent/mm/app/g:cIm	Ljava/util/concurrent/locks/ReentrantLock;
    //   191: invokevirtual 655	java/util/concurrent/locks/ReentrantLock:unlock	()V
    //   194: ldc_w 639
    //   197: invokestatic 52	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   200: aload_1
    //   201: athrow
    //   202: astore_1
    //   203: ldc 78
    //   205: ldc_w 677
    //   208: iconst_1
    //   209: anewarray 4	java/lang/Object
    //   212: dup
    //   213: iconst_0
    //   214: aload_1
    //   215: invokevirtual 632	java/lang/Exception:getMessage	()Ljava/lang/String;
    //   218: aastore
    //   219: invokestatic 98	com/tencent/mm/sdk/platformtools/ac:e	(Ljava/lang/String;Ljava/lang/String;[Ljava/lang/Object;)V
    //   222: ldc_w 639
    //   225: invokestatic 52	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   228: return
    //   229: aload_0
    //   230: getfield 59	com/tencent/mm/app/g:cIm	Ljava/util/concurrent/locks/ReentrantLock;
    //   233: invokevirtual 643	java/util/concurrent/locks/ReentrantLock:lock	()V
    //   236: aload_0
    //   237: iconst_1
    //   238: putfield 61	com/tencent/mm/app/g:cIn	Z
    //   241: aload_0
    //   242: getfield 59	com/tencent/mm/app/g:cIm	Ljava/util/concurrent/locks/ReentrantLock;
    //   245: invokevirtual 655	java/util/concurrent/locks/ReentrantLock:unlock	()V
    //   248: getstatic 44	com/tencent/mm/app/g:lock	Ljava/lang/Object;
    //   251: astore_1
    //   252: aload_1
    //   253: monitorenter
    //   254: getstatic 39	com/tencent/mm/app/g:cIl	Z
    //   257: ifne +27 -> 284
    //   260: iconst_1
    //   261: putstatic 39	com/tencent/mm/app/g:cIl	Z
    //   264: ldc 78
    //   266: ldc_w 679
    //   269: invokestatic 574	com/tencent/mm/sdk/platformtools/ac:i	(Ljava/lang/String;Ljava/lang/String;)V
    //   272: aload_0
    //   273: getfield 68	com/tencent/mm/app/g:cIp	Ljava/lang/Runnable;
    //   276: iconst_0
    //   277: invokestatic 681	com/tencent/mm/app/g:ca	(Z)I
    //   280: i2l
    //   281: invokestatic 687	com/tencent/mm/sdk/platformtools/ap:n	(Ljava/lang/Runnable;J)V
    //   284: aload_1
    //   285: monitorexit
    //   286: ldc_w 639
    //   289: invokestatic 52	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   292: return
    //   293: astore_1
    //   294: aload_0
    //   295: getfield 59	com/tencent/mm/app/g:cIm	Ljava/util/concurrent/locks/ReentrantLock;
    //   298: invokevirtual 655	java/util/concurrent/locks/ReentrantLock:unlock	()V
    //   301: ldc_w 639
    //   304: invokestatic 52	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   307: aload_1
    //   308: athrow
    //   309: astore_3
    //   310: aload_1
    //   311: monitorexit
    //   312: ldc_w 639
    //   315: invokestatic 52	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   318: aload_3
    //   319: athrow
    //   320: aload_1
    //   321: ldc_w 689
    //   324: iconst_0
    //   325: invokestatic 694	com/tencent/mm/booter/b:c	(Landroid/content/Context;Ljava/lang/String;Z)Z
    //   328: ifne +18 -> 346
    //   331: ldc 78
    //   333: ldc_w 696
    //   336: invokestatic 574	com/tencent/mm/sdk/platformtools/ac:i	(Ljava/lang/String;Ljava/lang/String;)V
    //   339: ldc_w 639
    //   342: invokestatic 52	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   345: return
    //   346: aload_0
    //   347: getfield 59	com/tencent/mm/app/g:cIm	Ljava/util/concurrent/locks/ReentrantLock;
    //   350: invokevirtual 643	java/util/concurrent/locks/ReentrantLock:lock	()V
    //   353: aload_0
    //   354: iconst_1
    //   355: putfield 61	com/tencent/mm/app/g:cIn	Z
    //   358: aload_0
    //   359: getfield 59	com/tencent/mm/app/g:cIm	Ljava/util/concurrent/locks/ReentrantLock;
    //   362: invokevirtual 655	java/util/concurrent/locks/ReentrantLock:unlock	()V
    //   365: getstatic 44	com/tencent/mm/app/g:lock	Ljava/lang/Object;
    //   368: astore_3
    //   369: aload_3
    //   370: monitorenter
    //   371: getstatic 39	com/tencent/mm/app/g:cIl	Z
    //   374: ifne +27 -> 401
    //   377: iconst_1
    //   378: putstatic 39	com/tencent/mm/app/g:cIl	Z
    //   381: ldc 78
    //   383: ldc_w 679
    //   386: invokestatic 574	com/tencent/mm/sdk/platformtools/ac:i	(Ljava/lang/String;Ljava/lang/String;)V
    //   389: aload_0
    //   390: getfield 68	com/tencent/mm/app/g:cIp	Ljava/lang/Runnable;
    //   393: iconst_0
    //   394: invokestatic 681	com/tencent/mm/app/g:ca	(Z)I
    //   397: i2l
    //   398: invokestatic 687	com/tencent/mm/sdk/platformtools/ap:n	(Ljava/lang/Runnable;J)V
    //   401: aload_3
    //   402: monitorexit
    //   403: new 662	android/content/Intent
    //   406: dup
    //   407: aload_1
    //   408: ldc_w 664
    //   411: invokespecial 667	android/content/Intent:<init>	(Landroid/content/Context;Ljava/lang/Class;)V
    //   414: astore_3
    //   415: ldc 78
    //   417: ldc_w 669
    //   420: invokestatic 574	com/tencent/mm/sdk/platformtools/ac:i	(Ljava/lang/String;Ljava/lang/String;)V
    //   423: aload_1
    //   424: aload_3
    //   425: aload_0
    //   426: iconst_1
    //   427: invokevirtual 673	android/content/Context:bindService	(Landroid/content/Intent;Landroid/content/ServiceConnection;I)Z
    //   430: ifne +45 -> 475
    //   433: ldc 78
    //   435: ldc_w 675
    //   438: invokestatic 302	com/tencent/mm/sdk/platformtools/ac:e	(Ljava/lang/String;Ljava/lang/String;)V
    //   441: ldc_w 639
    //   444: invokestatic 52	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   447: return
    //   448: astore_1
    //   449: aload_0
    //   450: getfield 59	com/tencent/mm/app/g:cIm	Ljava/util/concurrent/locks/ReentrantLock;
    //   453: invokevirtual 655	java/util/concurrent/locks/ReentrantLock:unlock	()V
    //   456: ldc_w 639
    //   459: invokestatic 52	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   462: aload_1
    //   463: athrow
    //   464: astore_1
    //   465: aload_3
    //   466: monitorexit
    //   467: ldc_w 639
    //   470: invokestatic 52	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   473: aload_1
    //   474: athrow
    //   475: ldc_w 639
    //   478: invokestatic 52	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   481: return
    //   482: astore_1
    //   483: ldc 78
    //   485: ldc_w 698
    //   488: iconst_1
    //   489: anewarray 4	java/lang/Object
    //   492: dup
    //   493: iconst_0
    //   494: aload_1
    //   495: invokevirtual 632	java/lang/Exception:getMessage	()Ljava/lang/String;
    //   498: aastore
    //   499: invokestatic 98	com/tencent/mm/sdk/platformtools/ac:e	(Ljava/lang/String;Ljava/lang/String;[Ljava/lang/Object;)V
    //   502: ldc_w 639
    //   505: invokestatic 52	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   508: return
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	509	0	this	g
    //   0	509	1	paramContext	Context
    //   39	86	2	bool	boolean
    //   152	11	3	localIntent	android.content.Intent
    //   309	10	3	localObject1	Object
    // Exception table:
    //   from	to	target	type
    //   12	38	186	finally
    //   40	76	186	finally
    //   80	109	186	finally
    //   161	179	202	java/lang/Exception
    //   229	241	293	finally
    //   254	284	309	finally
    //   284	286	309	finally
    //   310	312	309	finally
    //   346	358	448	finally
    //   371	401	464	finally
    //   401	403	464	finally
    //   465	467	464	finally
    //   423	441	482	java/lang/Exception
  }
  
  public final void onServiceConnected(final ComponentName paramComponentName, final IBinder paramIBinder)
  {
    AppMethodBeat.i(131774);
    ac.w("MicroMsg.CoreServiceConnection", "onServiceConnected ");
    en("com.tencent.mm:push");
    if (c.Un())
    {
      if (paramIBinder == null)
      {
        ac.w("MicroMsg.CoreServiceConnection", "onServiceConnected binder == null");
        AppMethodBeat.o(131774);
        return;
      }
      if (!((h)com.tencent.mm.kernel.g.agO().agp()).ahL()) {
        break label274;
      }
      synchronized (lock)
      {
        ac.i("MicroMsg.CoreServiceConnection", "remove zombie killer.");
        ap.aB(this.cIp);
        cIl = false;
      }
      try
      {
        this.cIm.lock();
        this.cIn = false;
        if ((this.cIo != null) && (bs.jl(this.cIo.hashCode(), paramIBinder.hashCode())))
        {
          ac.w("MicroMsg.CoreServiceConnection", "onServiceConnected binder == serviceBinder");
          return;
          paramComponentName = finally;
          AppMethodBeat.o(131774);
          throw paramComponentName;
        }
        this.cIo = paramIBinder;
        this.cIm.unlock();
        b.TR().w(new Runnable()
        {
          public final void run()
          {
            AppMethodBeat.i(131767);
            g.a(g.this, paramIBinder);
            AppMethodBeat.o(131767);
          }
        });
        AppMethodBeat.o(131774);
        return;
      }
      finally
      {
        this.cIm.unlock();
        AppMethodBeat.o(131774);
      }
    }
    label274:
    synchronized (lock)
    {
      ac.i("MicroMsg.CoreServiceConnection", "remove zombie killer.");
      ap.aB(this.cIp);
      cIl = false;
    }
  }
  
  public final void onServiceDisconnected(final ComponentName paramComponentName)
  {
    AppMethodBeat.i(131775);
    ac.w("MicroMsg.CoreServiceConnection", "onServiceDisconnected ");
    if (((h)com.tencent.mm.kernel.g.agO().agp()).ahL()) {}
    try
    {
      this.cIm.lock();
      this.cIn = false;
      this.cIo = null;
      this.cIm.unlock();
      b.TR().w(new Runnable()
      {
        public final void run()
        {
          AppMethodBeat.i(131771);
          g.a(g.this);
          AppMethodBeat.o(131771);
        }
      });
      AppMethodBeat.o(131775);
      return;
    }
    finally
    {
      this.cIm.unlock();
      AppMethodBeat.o(131775);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.app.g
 * JD-Core Version:    0.7.0.1
 */