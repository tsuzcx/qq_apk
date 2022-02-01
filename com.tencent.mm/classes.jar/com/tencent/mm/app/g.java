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
import com.tencent.mm.kernel.b.h;
import com.tencent.mm.kernel.d;
import com.tencent.mm.sdk.platformtools.ad;
import com.tencent.mm.sdk.platformtools.aj;
import com.tencent.mm.sdk.platformtools.aq;
import com.tencent.mm.sdk.platformtools.bt;
import java.util.Iterator;
import java.util.List;
import java.util.concurrent.locks.ReentrantLock;

public final class g
  implements ServiceConnection
{
  private static boolean cTt;
  private static int cTy;
  private static int cTz;
  private static Object lock;
  private ReentrantLock cTu;
  private boolean cTv;
  private IBinder cTw;
  private a cTx;
  
  static
  {
    AppMethodBeat.i(131782);
    cTt = false;
    lock = new Object();
    cTy = 0;
    cTz = 40000;
    AppMethodBeat.o(131782);
  }
  
  public g()
  {
    AppMethodBeat.i(131773);
    this.cTu = new ReentrantLock();
    this.cTv = false;
    this.cTw = null;
    this.cTx = new a();
    AppMethodBeat.o(131773);
  }
  
  public static void LO()
  {
    AppMethodBeat.i(131778);
    int i = fi("com.tencent.mm:push");
    ad.e("MicroMsg.CoreServiceConnection", "killPushProcess() pid = %s, stack[%s]", new Object[] { Integer.valueOf(i), bt.flS() });
    killProcess(i);
    AppMethodBeat.o(131778);
  }
  
  private void LP()
  {
    AppMethodBeat.i(189815);
    aq.aA(this.cTx);
    this.cTx.cTD = 0;
    AppMethodBeat.o(189815);
  }
  
  public static int cc(boolean paramBoolean)
  {
    AppMethodBeat.i(189814);
    int i = cTz;
    if (paramBoolean)
    {
      int j = cTy + 1;
      cTy = j;
      if ((j == 5) && (i < 600000))
      {
        cTz += 20000;
        cTy = 0;
        ad.i("MicroMsg.CoreServiceConnection", "ZOMBIE_CHECK_TIME:%s", new Object[] { Integer.valueOf(cTz) });
      }
    }
    AppMethodBeat.o(189814);
    return i;
  }
  
  public static int fi(String paramString)
  {
    AppMethodBeat.i(131777);
    if (bt.isNullOrNil(paramString))
    {
      ad.i("MicroMsg.CoreServiceConnection", "getPicByProcessName() processName == null");
      AppMethodBeat.o(131777);
      return -1;
    }
    for (;;)
    {
      try
      {
        Object localObject = ((ActivityManager)aj.getContext().getSystemService("activity")).getRunningAppProcesses();
        if (localObject == null)
        {
          ad.i("MicroMsg.CoreServiceConnection", "getPicByProcessName() processes == null");
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
        ad.e("MicroMsg.CoreServiceConnection", "getPidByProcessName() %s %s %s", new Object[] { paramString, localException.getClass().getSimpleName(), localException.getMessage() });
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
      com.tencent.mm.hellhoundlib.b.a locala = com.tencent.mm.hellhoundlib.b.c.a(paramInt, new com.tencent.mm.hellhoundlib.b.a());
      Object localObject = new Object();
      com.tencent.mm.hellhoundlib.a.a.a(localObject, locala.ahp(), "com/tencent/mm/app/CoreServiceConnection", "killProcess", "(I)V", "android/os/Process_EXEC_", "killProcess", "(I)V");
      Process.killProcess(((Integer)locala.mq(0)).intValue());
      com.tencent.mm.hellhoundlib.a.a.a(localObject, "com/tencent/mm/app/CoreServiceConnection", "killProcess", "(I)V", "android/os/Process_EXEC_", "killProcess", "(I)V");
      AppMethodBeat.o(131779);
      return;
    }
    catch (Exception localException)
    {
      ad.e("MicroMsg.CoreServiceConnection", "killProcess %s, %s %s", new Object[] { Integer.valueOf(paramInt), localException.getClass().getSimpleName(), localException.getMessage() });
      AppMethodBeat.o(131779);
    }
  }
  
  /* Error */
  public final void bl(Context paramContext)
  {
    // Byte code:
    //   0: ldc_w 683
    //   3: invokestatic 38	com/tencent/matrix/trace/core/AppMethodBeat:i	(I)V
    //   6: ldc_w 685
    //   9: invokestatic 180	com/tencent/mm/blink/a:ub	(Ljava/lang/String;)V
    //   12: aload_0
    //   13: getfield 60	com/tencent/mm/app/g:cTu	Ljava/util/concurrent/locks/ReentrantLock;
    //   16: invokevirtual 687	java/util/concurrent/locks/ReentrantLock:lock	()V
    //   19: aload_0
    //   20: getfield 64	com/tencent/mm/app/g:cTw	Landroid/os/IBinder;
    //   23: ifnull +100 -> 123
    //   26: aload_0
    //   27: getfield 64	com/tencent/mm/app/g:cTw	Landroid/os/IBinder;
    //   30: invokeinterface 692 1 0
    //   35: ifeq +88 -> 123
    //   38: iconst_1
    //   39: istore_3
    //   40: ldc 79
    //   42: ldc_w 694
    //   45: iconst_2
    //   46: anewarray 4	java/lang/Object
    //   49: dup
    //   50: iconst_0
    //   51: aload_0
    //   52: getfield 62	com/tencent/mm/app/g:cTv	Z
    //   55: invokestatic 443	java/lang/Boolean:valueOf	(Z)Ljava/lang/Boolean;
    //   58: aastore
    //   59: dup
    //   60: iconst_1
    //   61: iload_3
    //   62: invokestatic 443	java/lang/Boolean:valueOf	(Z)Ljava/lang/Boolean;
    //   65: aastore
    //   66: invokestatic 484	com/tencent/mm/sdk/platformtools/ad:i	(Ljava/lang/String;Ljava/lang/String;[Ljava/lang/Object;)V
    //   69: aload_0
    //   70: getfield 62	com/tencent/mm/app/g:cTv	Z
    //   73: ifne +7 -> 80
    //   76: iload_3
    //   77: ifeq +51 -> 128
    //   80: ldc 79
    //   82: ldc_w 696
    //   85: iconst_2
    //   86: anewarray 4	java/lang/Object
    //   89: dup
    //   90: iconst_0
    //   91: aload_0
    //   92: getfield 62	com/tencent/mm/app/g:cTv	Z
    //   95: invokestatic 443	java/lang/Boolean:valueOf	(Z)Ljava/lang/Boolean;
    //   98: aastore
    //   99: dup
    //   100: iconst_1
    //   101: iload_3
    //   102: invokestatic 443	java/lang/Boolean:valueOf	(Z)Ljava/lang/Boolean;
    //   105: aastore
    //   106: invokestatic 445	com/tencent/mm/sdk/platformtools/ad:w	(Ljava/lang/String;Ljava/lang/String;[Ljava/lang/Object;)V
    //   109: aload_0
    //   110: getfield 60	com/tencent/mm/app/g:cTu	Ljava/util/concurrent/locks/ReentrantLock;
    //   113: invokevirtual 699	java/util/concurrent/locks/ReentrantLock:unlock	()V
    //   116: ldc_w 683
    //   119: invokestatic 53	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   122: return
    //   123: iconst_0
    //   124: istore_3
    //   125: goto -85 -> 40
    //   128: aload_0
    //   129: getfield 60	com/tencent/mm/app/g:cTu	Ljava/util/concurrent/locks/ReentrantLock;
    //   132: invokevirtual 699	java/util/concurrent/locks/ReentrantLock:unlock	()V
    //   135: invokestatic 704	com/tencent/mm/booter/c:WE	()Z
    //   138: ifeq +186 -> 324
    //   141: new 706	android/content/Intent
    //   144: dup
    //   145: aload_1
    //   146: ldc_w 708
    //   149: invokespecial 711	android/content/Intent:<init>	(Landroid/content/Context;Ljava/lang/Class;)V
    //   152: astore 4
    //   154: ldc 79
    //   156: ldc_w 713
    //   159: invokestatic 586	com/tencent/mm/sdk/platformtools/ad:i	(Ljava/lang/String;Ljava/lang/String;)V
    //   162: aload_1
    //   163: aload 4
    //   165: aload_0
    //   166: iconst_1
    //   167: invokevirtual 717	android/content/Context:bindService	(Landroid/content/Intent;Landroid/content/ServiceConnection;I)Z
    //   170: ifne +61 -> 231
    //   173: ldc 79
    //   175: ldc_w 719
    //   178: invokestatic 313	com/tencent/mm/sdk/platformtools/ad:e	(Ljava/lang/String;Ljava/lang/String;)V
    //   181: ldc_w 683
    //   184: invokestatic 53	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   187: return
    //   188: astore_1
    //   189: aload_0
    //   190: getfield 60	com/tencent/mm/app/g:cTu	Ljava/util/concurrent/locks/ReentrantLock;
    //   193: invokevirtual 699	java/util/concurrent/locks/ReentrantLock:unlock	()V
    //   196: ldc_w 683
    //   199: invokestatic 53	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   202: aload_1
    //   203: athrow
    //   204: astore_1
    //   205: ldc 79
    //   207: ldc_w 721
    //   210: iconst_1
    //   211: anewarray 4	java/lang/Object
    //   214: dup
    //   215: iconst_0
    //   216: aload_1
    //   217: invokevirtual 644	java/lang/Exception:getMessage	()Ljava/lang/String;
    //   220: aastore
    //   221: invokestatic 99	com/tencent/mm/sdk/platformtools/ad:e	(Ljava/lang/String;Ljava/lang/String;[Ljava/lang/Object;)V
    //   224: ldc_w 683
    //   227: invokestatic 53	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   230: return
    //   231: aload_0
    //   232: getfield 60	com/tencent/mm/app/g:cTu	Ljava/util/concurrent/locks/ReentrantLock;
    //   235: invokevirtual 687	java/util/concurrent/locks/ReentrantLock:lock	()V
    //   238: aload_0
    //   239: iconst_1
    //   240: putfield 62	com/tencent/mm/app/g:cTv	Z
    //   243: aload_0
    //   244: getfield 60	com/tencent/mm/app/g:cTu	Ljava/util/concurrent/locks/ReentrantLock;
    //   247: invokevirtual 699	java/util/concurrent/locks/ReentrantLock:unlock	()V
    //   250: getstatic 45	com/tencent/mm/app/g:lock	Ljava/lang/Object;
    //   253: astore_1
    //   254: aload_1
    //   255: monitorenter
    //   256: getstatic 40	com/tencent/mm/app/g:cTt	Z
    //   259: ifne +27 -> 286
    //   262: iconst_1
    //   263: putstatic 40	com/tencent/mm/app/g:cTt	Z
    //   266: ldc 79
    //   268: ldc_w 723
    //   271: invokestatic 586	com/tencent/mm/sdk/platformtools/ad:i	(Ljava/lang/String;Ljava/lang/String;)V
    //   274: aload_0
    //   275: getfield 69	com/tencent/mm/app/g:cTx	Lcom/tencent/mm/app/g$a;
    //   278: iconst_0
    //   279: invokestatic 725	com/tencent/mm/app/g:cc	(Z)I
    //   282: i2l
    //   283: invokestatic 728	com/tencent/mm/sdk/platformtools/aq:o	(Ljava/lang/Runnable;J)V
    //   286: aload_1
    //   287: monitorexit
    //   288: ldc_w 683
    //   291: invokestatic 53	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   294: return
    //   295: astore_1
    //   296: aload_0
    //   297: getfield 60	com/tencent/mm/app/g:cTu	Ljava/util/concurrent/locks/ReentrantLock;
    //   300: invokevirtual 699	java/util/concurrent/locks/ReentrantLock:unlock	()V
    //   303: ldc_w 683
    //   306: invokestatic 53	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   309: aload_1
    //   310: athrow
    //   311: astore 4
    //   313: aload_1
    //   314: monitorexit
    //   315: ldc_w 683
    //   318: invokestatic 53	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   321: aload 4
    //   323: athrow
    //   324: aload_1
    //   325: ldc_w 730
    //   328: iconst_0
    //   329: invokestatic 735	com/tencent/mm/booter/b:c	(Landroid/content/Context;Ljava/lang/String;Z)Z
    //   332: ifne +18 -> 350
    //   335: ldc 79
    //   337: ldc_w 737
    //   340: invokestatic 586	com/tencent/mm/sdk/platformtools/ad:i	(Ljava/lang/String;Ljava/lang/String;)V
    //   343: ldc_w 683
    //   346: invokestatic 53	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   349: return
    //   350: aload_0
    //   351: getfield 60	com/tencent/mm/app/g:cTu	Ljava/util/concurrent/locks/ReentrantLock;
    //   354: invokevirtual 687	java/util/concurrent/locks/ReentrantLock:lock	()V
    //   357: aload_0
    //   358: iconst_1
    //   359: putfield 62	com/tencent/mm/app/g:cTv	Z
    //   362: aload_0
    //   363: getfield 60	com/tencent/mm/app/g:cTu	Ljava/util/concurrent/locks/ReentrantLock;
    //   366: invokevirtual 699	java/util/concurrent/locks/ReentrantLock:unlock	()V
    //   369: getstatic 45	com/tencent/mm/app/g:lock	Ljava/lang/Object;
    //   372: astore 4
    //   374: aload 4
    //   376: monitorenter
    //   377: getstatic 40	com/tencent/mm/app/g:cTt	Z
    //   380: ifne +27 -> 407
    //   383: iconst_1
    //   384: putstatic 40	com/tencent/mm/app/g:cTt	Z
    //   387: ldc 79
    //   389: ldc_w 723
    //   392: invokestatic 586	com/tencent/mm/sdk/platformtools/ad:i	(Ljava/lang/String;Ljava/lang/String;)V
    //   395: aload_0
    //   396: getfield 69	com/tencent/mm/app/g:cTx	Lcom/tencent/mm/app/g$a;
    //   399: iconst_0
    //   400: invokestatic 725	com/tencent/mm/app/g:cc	(Z)I
    //   403: i2l
    //   404: invokestatic 728	com/tencent/mm/sdk/platformtools/aq:o	(Ljava/lang/Runnable;J)V
    //   407: aload 4
    //   409: monitorexit
    //   410: new 706	android/content/Intent
    //   413: dup
    //   414: aload_1
    //   415: ldc_w 708
    //   418: invokespecial 711	android/content/Intent:<init>	(Landroid/content/Context;Ljava/lang/Class;)V
    //   421: astore 4
    //   423: ldc 79
    //   425: ldc_w 713
    //   428: invokestatic 586	com/tencent/mm/sdk/platformtools/ad:i	(Ljava/lang/String;Ljava/lang/String;)V
    //   431: aload_1
    //   432: aload 4
    //   434: aload_0
    //   435: iconst_1
    //   436: invokevirtual 717	android/content/Context:bindService	(Landroid/content/Intent;Landroid/content/ServiceConnection;I)Z
    //   439: ifne +272 -> 711
    //   442: ldc 79
    //   444: ldc_w 719
    //   447: invokestatic 313	com/tencent/mm/sdk/platformtools/ad:e	(Ljava/lang/String;Ljava/lang/String;)V
    //   450: aload_0
    //   451: getfield 60	com/tencent/mm/app/g:cTu	Ljava/util/concurrent/locks/ReentrantLock;
    //   454: invokevirtual 687	java/util/concurrent/locks/ReentrantLock:lock	()V
    //   457: aload_0
    //   458: iconst_0
    //   459: putfield 62	com/tencent/mm/app/g:cTv	Z
    //   462: aload_0
    //   463: getfield 60	com/tencent/mm/app/g:cTu	Ljava/util/concurrent/locks/ReentrantLock;
    //   466: invokevirtual 699	java/util/concurrent/locks/ReentrantLock:unlock	()V
    //   469: getstatic 742	android/os/Build:BRAND	Ljava/lang/String;
    //   472: invokevirtual 745	java/lang/String:toLowerCase	()Ljava/lang/String;
    //   475: astore_1
    //   476: aload_1
    //   477: ldc_w 747
    //   480: invokevirtual 751	java/lang/String:contains	(Ljava/lang/CharSequence;)Z
    //   483: ifne +235 -> 718
    //   486: aload_1
    //   487: ldc_w 753
    //   490: invokevirtual 751	java/lang/String:contains	(Ljava/lang/CharSequence;)Z
    //   493: ifeq +117 -> 610
    //   496: goto +222 -> 718
    //   499: getstatic 319	com/tencent/mm/plugin/report/e:ygI	Lcom/tencent/mm/plugin/report/e;
    //   502: ldc2_w 754
    //   505: iload_2
    //   506: i2l
    //   507: lconst_1
    //   508: iconst_0
    //   509: invokevirtual 327	com/tencent/mm/plugin/report/e:idkeyStat	(JJJZ)V
    //   512: getstatic 319	com/tencent/mm/plugin/report/e:ygI	Lcom/tencent/mm/plugin/report/e;
    //   515: sipush 20661
    //   518: iconst_1
    //   519: anewarray 4	java/lang/Object
    //   522: dup
    //   523: iconst_0
    //   524: iconst_0
    //   525: invokestatic 87	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
    //   528: aastore
    //   529: invokevirtual 758	com/tencent/mm/plugin/report/e:f	(I[Ljava/lang/Object;)V
    //   532: ldc_w 683
    //   535: invokestatic 53	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   538: return
    //   539: astore_1
    //   540: ldc 79
    //   542: ldc_w 760
    //   545: iconst_1
    //   546: anewarray 4	java/lang/Object
    //   549: dup
    //   550: iconst_0
    //   551: aload_1
    //   552: invokevirtual 644	java/lang/Exception:getMessage	()Ljava/lang/String;
    //   555: aastore
    //   556: invokestatic 99	com/tencent/mm/sdk/platformtools/ad:e	(Ljava/lang/String;Ljava/lang/String;[Ljava/lang/Object;)V
    //   559: ldc_w 683
    //   562: invokestatic 53	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   565: return
    //   566: astore_1
    //   567: aload_0
    //   568: getfield 60	com/tencent/mm/app/g:cTu	Ljava/util/concurrent/locks/ReentrantLock;
    //   571: invokevirtual 699	java/util/concurrent/locks/ReentrantLock:unlock	()V
    //   574: ldc_w 683
    //   577: invokestatic 53	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   580: aload_1
    //   581: athrow
    //   582: astore_1
    //   583: aload 4
    //   585: monitorexit
    //   586: ldc_w 683
    //   589: invokestatic 53	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   592: aload_1
    //   593: athrow
    //   594: astore_1
    //   595: aload_0
    //   596: getfield 60	com/tencent/mm/app/g:cTu	Ljava/util/concurrent/locks/ReentrantLock;
    //   599: invokevirtual 699	java/util/concurrent/locks/ReentrantLock:unlock	()V
    //   602: ldc_w 683
    //   605: invokestatic 53	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   608: aload_1
    //   609: athrow
    //   610: aload_1
    //   611: ldc_w 762
    //   614: invokevirtual 751	java/lang/String:contains	(Ljava/lang/CharSequence;)Z
    //   617: ifne +107 -> 724
    //   620: aload_1
    //   621: ldc_w 764
    //   624: invokevirtual 751	java/lang/String:contains	(Ljava/lang/CharSequence;)Z
    //   627: ifeq +6 -> 633
    //   630: goto +94 -> 724
    //   633: aload_1
    //   634: ldc_w 766
    //   637: invokevirtual 751	java/lang/String:contains	(Ljava/lang/CharSequence;)Z
    //   640: ifeq +9 -> 649
    //   643: bipush 43
    //   645: istore_2
    //   646: goto -147 -> 499
    //   649: aload_1
    //   650: ldc_w 768
    //   653: invokevirtual 751	java/lang/String:contains	(Ljava/lang/CharSequence;)Z
    //   656: ifeq +9 -> 665
    //   659: bipush 42
    //   661: istore_2
    //   662: goto -163 -> 499
    //   665: aload_1
    //   666: ldc_w 770
    //   669: invokevirtual 751	java/lang/String:contains	(Ljava/lang/CharSequence;)Z
    //   672: istore_3
    //   673: iload_3
    //   674: ifeq +9 -> 683
    //   677: bipush 44
    //   679: istore_2
    //   680: goto -181 -> 499
    //   683: bipush 45
    //   685: istore_2
    //   686: goto -187 -> 499
    //   689: astore_1
    //   690: ldc_w 772
    //   693: aload_1
    //   694: ldc_w 774
    //   697: iconst_0
    //   698: anewarray 4	java/lang/Object
    //   701: invokestatic 778	com/tencent/mm/sdk/platformtools/ad:printErrStackTrace	(Ljava/lang/String;Ljava/lang/Throwable;Ljava/lang/String;[Ljava/lang/Object;)V
    //   704: ldc_w 683
    //   707: invokestatic 53	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   710: return
    //   711: ldc_w 683
    //   714: invokestatic 53	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   717: return
    //   718: bipush 41
    //   720: istore_2
    //   721: goto -222 -> 499
    //   724: bipush 40
    //   726: istore_2
    //   727: goto -228 -> 499
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	730	0	this	g
    //   0	730	1	paramContext	Context
    //   505	222	2	i	int
    //   39	635	3	bool	boolean
    //   152	12	4	localIntent	android.content.Intent
    //   311	11	4	localObject1	Object
    //   372	212	4	localObject2	Object
    // Exception table:
    //   from	to	target	type
    //   12	38	188	finally
    //   40	76	188	finally
    //   80	109	188	finally
    //   162	181	204	java/lang/Exception
    //   231	243	295	finally
    //   256	286	311	finally
    //   286	288	311	finally
    //   313	315	311	finally
    //   431	450	539	java/lang/Exception
    //   462	469	539	java/lang/Exception
    //   469	496	539	java/lang/Exception
    //   499	532	539	java/lang/Exception
    //   532	538	539	java/lang/Exception
    //   595	610	539	java/lang/Exception
    //   610	630	539	java/lang/Exception
    //   633	643	539	java/lang/Exception
    //   649	659	539	java/lang/Exception
    //   665	673	539	java/lang/Exception
    //   690	704	539	java/lang/Exception
    //   350	362	566	finally
    //   377	407	582	finally
    //   407	410	582	finally
    //   583	586	582	finally
    //   450	462	594	finally
    //   469	496	689	java/lang/Throwable
    //   499	532	689	java/lang/Throwable
    //   610	630	689	java/lang/Throwable
    //   633	643	689	java/lang/Throwable
    //   649	659	689	java/lang/Throwable
    //   665	673	689	java/lang/Throwable
  }
  
  public final void onServiceConnected(final ComponentName paramComponentName, final IBinder paramIBinder)
  {
    AppMethodBeat.i(131774);
    ad.w("MicroMsg.CoreServiceConnection", "onServiceConnected ");
    fi("com.tencent.mm:push");
    if (com.tencent.mm.booter.c.WE())
    {
      if (paramIBinder == null)
      {
        ad.w("MicroMsg.CoreServiceConnection", "onServiceConnected binder == null");
        AppMethodBeat.o(131774);
        return;
      }
      if (!((h)com.tencent.mm.kernel.g.ajz().ajb()).akw()) {
        break label268;
      }
      synchronized (lock)
      {
        ad.i("MicroMsg.CoreServiceConnection", "remove zombie killer.");
        LP();
        cTt = false;
      }
      try
      {
        this.cTu.lock();
        this.cTv = false;
        if ((this.cTw != null) && (bt.jx(this.cTw.hashCode(), paramIBinder.hashCode())))
        {
          ad.w("MicroMsg.CoreServiceConnection", "onServiceConnected binder == serviceBinder");
          return;
          paramComponentName = finally;
          AppMethodBeat.o(131774);
          throw paramComponentName;
        }
        this.cTw = paramIBinder;
        this.cTu.unlock();
        b.Wi().w(new Runnable()
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
        this.cTu.unlock();
        AppMethodBeat.o(131774);
      }
    }
    label268:
    synchronized (lock)
    {
      ad.i("MicroMsg.CoreServiceConnection", "remove zombie killer.");
      LP();
      cTt = false;
    }
  }
  
  public final void onServiceDisconnected(final ComponentName paramComponentName)
  {
    AppMethodBeat.i(131775);
    ad.w("MicroMsg.CoreServiceConnection", "onServiceDisconnected ");
    if (((h)com.tencent.mm.kernel.g.ajz().ajb()).akw()) {}
    try
    {
      this.cTu.lock();
      this.cTv = false;
      this.cTw = null;
      this.cTu.unlock();
      b.Wi().w(new Runnable()
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
      this.cTu.unlock();
      AppMethodBeat.o(131775);
    }
  }
  
  final class a
    implements Runnable
  {
    int cTD = 0;
    
    a() {}
    
    /* Error */
    public final void run()
    {
      // Byte code:
      //   0: ldc 27
      //   2: invokestatic 33	com/tencent/matrix/trace/core/AppMethodBeat:i	(I)V
      //   5: aload_0
      //   6: getfield 17	com/tencent/mm/app/g$a:cTA	Lcom/tencent/mm/app/g;
      //   9: invokestatic 37	com/tencent/mm/app/g:b	(Lcom/tencent/mm/app/g;)Ljava/util/concurrent/locks/ReentrantLock;
      //   12: invokevirtual 42	java/util/concurrent/locks/ReentrantLock:lock	()V
      //   15: aload_0
      //   16: getfield 17	com/tencent/mm/app/g$a:cTA	Lcom/tencent/mm/app/g;
      //   19: invokestatic 46	com/tencent/mm/app/g:c	(Lcom/tencent/mm/app/g;)Landroid/os/IBinder;
      //   22: ifnull +75 -> 97
      //   25: aload_0
      //   26: getfield 17	com/tencent/mm/app/g$a:cTA	Lcom/tencent/mm/app/g;
      //   29: invokestatic 46	com/tencent/mm/app/g:c	(Lcom/tencent/mm/app/g;)Landroid/os/IBinder;
      //   32: invokeinterface 52 1 0
      //   37: ifeq +60 -> 97
      //   40: iconst_1
      //   41: istore_2
      //   42: ldc 54
      //   44: ldc 56
      //   46: iconst_2
      //   47: anewarray 4	java/lang/Object
      //   50: dup
      //   51: iconst_0
      //   52: aload_0
      //   53: getfield 17	com/tencent/mm/app/g$a:cTA	Lcom/tencent/mm/app/g;
      //   56: invokestatic 46	com/tencent/mm/app/g:c	(Lcom/tencent/mm/app/g;)Landroid/os/IBinder;
      //   59: aastore
      //   60: dup
      //   61: iconst_1
      //   62: iload_2
      //   63: invokestatic 62	java/lang/Boolean:valueOf	(Z)Ljava/lang/Boolean;
      //   66: aastore
      //   67: invokestatic 67	com/tencent/mm/sdk/platformtools/ad:i	(Ljava/lang/String;Ljava/lang/String;[Ljava/lang/Object;)V
      //   70: iload_2
      //   71: ifeq +31 -> 102
      //   74: ldc 54
      //   76: ldc 69
      //   78: invokestatic 73	com/tencent/mm/sdk/platformtools/ad:w	(Ljava/lang/String;Ljava/lang/String;)V
      //   81: aload_0
      //   82: getfield 17	com/tencent/mm/app/g$a:cTA	Lcom/tencent/mm/app/g;
      //   85: invokestatic 37	com/tencent/mm/app/g:b	(Lcom/tencent/mm/app/g;)Ljava/util/concurrent/locks/ReentrantLock;
      //   88: invokevirtual 76	java/util/concurrent/locks/ReentrantLock:unlock	()V
      //   91: ldc 27
      //   93: invokestatic 79	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
      //   96: return
      //   97: iconst_0
      //   98: istore_2
      //   99: goto -57 -> 42
      //   102: aload_0
      //   103: getfield 17	com/tencent/mm/app/g$a:cTA	Lcom/tencent/mm/app/g;
      //   106: invokestatic 37	com/tencent/mm/app/g:b	(Lcom/tencent/mm/app/g;)Ljava/util/concurrent/locks/ReentrantLock;
      //   109: invokevirtual 76	java/util/concurrent/locks/ReentrantLock:unlock	()V
      //   112: ldc 54
      //   114: ldc 81
      //   116: iconst_1
      //   117: anewarray 4	java/lang/Object
      //   120: dup
      //   121: iconst_0
      //   122: aload_0
      //   123: getfield 22	com/tencent/mm/app/g$a:cTD	I
      //   126: invokestatic 86	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
      //   129: aastore
      //   130: invokestatic 92	java/lang/String:format	(Ljava/lang/String;[Ljava/lang/Object;)Ljava/lang/String;
      //   133: invokestatic 95	com/tencent/mm/sdk/platformtools/ad:e	(Ljava/lang/String;Ljava/lang/String;)V
      //   136: aload_0
      //   137: getfield 22	com/tencent/mm/app/g$a:cTD	I
      //   140: iconst_1
      //   141: if_icmpne +42 -> 183
      //   144: ldc 97
      //   146: invokestatic 101	com/tencent/mm/app/g:fi	(Ljava/lang/String;)I
      //   149: istore_1
      //   150: iload_1
      //   151: iconst_m1
      //   152: if_icmpeq +150 -> 302
      //   155: ldc 54
      //   157: ldc 103
      //   159: iconst_1
      //   160: anewarray 4	java/lang/Object
      //   163: dup
      //   164: iconst_0
      //   165: iload_1
      //   166: invokestatic 86	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
      //   169: aastore
      //   170: invokestatic 92	java/lang/String:format	(Ljava/lang/String;[Ljava/lang/Object;)Ljava/lang/String;
      //   173: invokestatic 105	com/tencent/mm/sdk/platformtools/ad:i	(Ljava/lang/String;Ljava/lang/String;)V
      //   176: invokestatic 108	com/tencent/mm/sdk/platformtools/ad:fku	()V
      //   179: iload_1
      //   180: invokestatic 111	com/tencent/mm/app/g:killProcess	(I)V
      //   183: invokestatic 117	com/tencent/mm/sdk/platformtools/aj:getContext	()Landroid/content/Context;
      //   186: astore_3
      //   187: new 119	android/content/Intent
      //   190: dup
      //   191: aload_3
      //   192: ldc 121
      //   194: invokespecial 124	android/content/Intent:<init>	(Landroid/content/Context;Ljava/lang/Class;)V
      //   197: astore 4
      //   199: ldc 54
      //   201: ldc 126
      //   203: invokestatic 105	com/tencent/mm/sdk/platformtools/ad:i	(Ljava/lang/String;Ljava/lang/String;)V
      //   206: aload_3
      //   207: aload_0
      //   208: getfield 17	com/tencent/mm/app/g$a:cTA	Lcom/tencent/mm/app/g;
      //   211: invokevirtual 132	android/content/Context:unbindService	(Landroid/content/ServiceConnection;)V
      //   214: invokestatic 137	com/tencent/mm/booter/c:WE	()Z
      //   217: ifeq +95 -> 312
      //   220: aload_3
      //   221: aload 4
      //   223: aload_0
      //   224: getfield 17	com/tencent/mm/app/g$a:cTA	Lcom/tencent/mm/app/g;
      //   227: iconst_1
      //   228: invokevirtual 141	android/content/Context:bindService	(Landroid/content/Intent;Landroid/content/ServiceConnection;I)Z
      //   231: pop
      //   232: aload_0
      //   233: getfield 22	com/tencent/mm/app/g$a:cTD	I
      //   236: iconst_1
      //   237: if_icmpne +279 -> 516
      //   240: aload_0
      //   241: iconst_0
      //   242: putfield 22	com/tencent/mm/app/g$a:cTD	I
      //   245: aload_0
      //   246: iconst_1
      //   247: invokestatic 145	com/tencent/mm/app/g:cc	(Z)I
      //   250: i2l
      //   251: invokestatic 150	com/tencent/mm/sdk/platformtools/aq:o	(Ljava/lang/Runnable;J)V
      //   254: ldc 54
      //   256: ldc 152
      //   258: iconst_1
      //   259: anewarray 4	java/lang/Object
      //   262: dup
      //   263: iconst_0
      //   264: aload_0
      //   265: getfield 22	com/tencent/mm/app/g$a:cTD	I
      //   268: invokestatic 86	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
      //   271: aastore
      //   272: invokestatic 92	java/lang/String:format	(Ljava/lang/String;[Ljava/lang/Object;)Ljava/lang/String;
      //   275: invokestatic 105	com/tencent/mm/sdk/platformtools/ad:i	(Ljava/lang/String;Ljava/lang/String;)V
      //   278: ldc 27
      //   280: invokestatic 79	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
      //   283: return
      //   284: astore_3
      //   285: aload_0
      //   286: getfield 17	com/tencent/mm/app/g$a:cTA	Lcom/tencent/mm/app/g;
      //   289: invokestatic 37	com/tencent/mm/app/g:b	(Lcom/tencent/mm/app/g;)Ljava/util/concurrent/locks/ReentrantLock;
      //   292: invokevirtual 76	java/util/concurrent/locks/ReentrantLock:unlock	()V
      //   295: ldc 27
      //   297: invokestatic 79	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
      //   300: aload_3
      //   301: athrow
      //   302: ldc 54
      //   304: ldc 154
      //   306: invokestatic 105	com/tencent/mm/sdk/platformtools/ad:i	(Ljava/lang/String;Ljava/lang/String;)V
      //   309: goto -126 -> 183
      //   312: aload_3
      //   313: aload 4
      //   315: invokevirtual 158	android/content/Context:stopService	(Landroid/content/Intent;)Z
      //   318: pop
      //   319: aload_3
      //   320: aload 4
      //   322: aload_0
      //   323: getfield 17	com/tencent/mm/app/g$a:cTA	Lcom/tencent/mm/app/g;
      //   326: iconst_1
      //   327: invokevirtual 141	android/content/Context:bindService	(Landroid/content/Intent;Landroid/content/ServiceConnection;I)Z
      //   330: pop
      //   331: aload_3
      //   332: aload 4
      //   334: invokevirtual 162	android/content/Context:startService	(Landroid/content/Intent;)Landroid/content/ComponentName;
      //   337: pop
      //   338: goto -106 -> 232
      //   341: astore_3
      //   342: ldc 54
      //   344: ldc 164
      //   346: iconst_1
      //   347: anewarray 4	java/lang/Object
      //   350: dup
      //   351: iconst_0
      //   352: aload_3
      //   353: invokevirtual 168	java/lang/Exception:getMessage	()Ljava/lang/String;
      //   356: aastore
      //   357: invokestatic 170	com/tencent/mm/sdk/platformtools/ad:e	(Ljava/lang/String;Ljava/lang/String;[Ljava/lang/Object;)V
      //   360: goto -128 -> 232
      //   363: astore 5
      //   365: invokestatic 137	com/tencent/mm/booter/c:WE	()Z
      //   368: ifeq +40 -> 408
      //   371: aload_3
      //   372: aload 4
      //   374: aload_0
      //   375: getfield 17	com/tencent/mm/app/g$a:cTA	Lcom/tencent/mm/app/g;
      //   378: iconst_1
      //   379: invokevirtual 141	android/content/Context:bindService	(Landroid/content/Intent;Landroid/content/ServiceConnection;I)Z
      //   382: pop
      //   383: goto -151 -> 232
      //   386: astore_3
      //   387: ldc 54
      //   389: ldc 164
      //   391: iconst_1
      //   392: anewarray 4	java/lang/Object
      //   395: dup
      //   396: iconst_0
      //   397: aload_3
      //   398: invokevirtual 168	java/lang/Exception:getMessage	()Ljava/lang/String;
      //   401: aastore
      //   402: invokestatic 170	com/tencent/mm/sdk/platformtools/ad:e	(Ljava/lang/String;Ljava/lang/String;[Ljava/lang/Object;)V
      //   405: goto -173 -> 232
      //   408: aload_3
      //   409: aload 4
      //   411: invokevirtual 158	android/content/Context:stopService	(Landroid/content/Intent;)Z
      //   414: pop
      //   415: aload_3
      //   416: aload 4
      //   418: aload_0
      //   419: getfield 17	com/tencent/mm/app/g$a:cTA	Lcom/tencent/mm/app/g;
      //   422: iconst_1
      //   423: invokevirtual 141	android/content/Context:bindService	(Landroid/content/Intent;Landroid/content/ServiceConnection;I)Z
      //   426: pop
      //   427: aload_3
      //   428: aload 4
      //   430: invokevirtual 162	android/content/Context:startService	(Landroid/content/Intent;)Landroid/content/ComponentName;
      //   433: pop
      //   434: goto -202 -> 232
      //   437: astore 5
      //   439: invokestatic 137	com/tencent/mm/booter/c:WE	()Z
      //   442: ifeq +23 -> 465
      //   445: aload_3
      //   446: aload 4
      //   448: aload_0
      //   449: getfield 17	com/tencent/mm/app/g$a:cTA	Lcom/tencent/mm/app/g;
      //   452: iconst_1
      //   453: invokevirtual 141	android/content/Context:bindService	(Landroid/content/Intent;Landroid/content/ServiceConnection;I)Z
      //   456: pop
      //   457: ldc 27
      //   459: invokestatic 79	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
      //   462: aload 5
      //   464: athrow
      //   465: aload_3
      //   466: aload 4
      //   468: invokevirtual 158	android/content/Context:stopService	(Landroid/content/Intent;)Z
      //   471: pop
      //   472: aload_3
      //   473: aload 4
      //   475: aload_0
      //   476: getfield 17	com/tencent/mm/app/g$a:cTA	Lcom/tencent/mm/app/g;
      //   479: iconst_1
      //   480: invokevirtual 141	android/content/Context:bindService	(Landroid/content/Intent;Landroid/content/ServiceConnection;I)Z
      //   483: pop
      //   484: aload_3
      //   485: aload 4
      //   487: invokevirtual 162	android/content/Context:startService	(Landroid/content/Intent;)Landroid/content/ComponentName;
      //   490: pop
      //   491: goto -34 -> 457
      //   494: astore_3
      //   495: ldc 54
      //   497: ldc 164
      //   499: iconst_1
      //   500: anewarray 4	java/lang/Object
      //   503: dup
      //   504: iconst_0
      //   505: aload_3
      //   506: invokevirtual 168	java/lang/Exception:getMessage	()Ljava/lang/String;
      //   509: aastore
      //   510: invokestatic 170	com/tencent/mm/sdk/platformtools/ad:e	(Ljava/lang/String;Ljava/lang/String;[Ljava/lang/Object;)V
      //   513: goto -56 -> 457
      //   516: aload_0
      //   517: aload_0
      //   518: getfield 22	com/tencent/mm/app/g$a:cTD	I
      //   521: iconst_1
      //   522: iadd
      //   523: putfield 22	com/tencent/mm/app/g$a:cTD	I
      //   526: goto -281 -> 245
      // Local variable table:
      //   start	length	slot	name	signature
      //   0	529	0	this	a
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
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.app.g
 * JD-Core Version:    0.7.0.1
 */