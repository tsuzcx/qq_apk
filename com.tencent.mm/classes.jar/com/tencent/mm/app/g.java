package com.tencent.mm.app;

import android.app.ActivityManager;
import android.app.ActivityManager.RunningAppProcessInfo;
import android.content.ComponentName;
import android.content.Context;
import android.content.ServiceConnection;
import android.os.IBinder;
import android.os.Process;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.kernel.b.h;
import com.tencent.mm.kernel.d;
import com.tencent.mm.model.av;
import com.tencent.mm.network.i.a;
import com.tencent.mm.network.u.a;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.MMApplicationContext;
import com.tencent.mm.sdk.platformtools.MMHandlerThread;
import com.tencent.mm.sdk.platformtools.Util;
import java.util.Iterator;
import java.util.List;
import java.util.concurrent.locks.ReentrantLock;

public final class g
  implements ServiceConnection
{
  private static final String dkC;
  private static int dkD;
  private static int dkE;
  private static boolean dkx;
  private static Object lock;
  private IBinder dkA;
  private a dkB;
  private ReentrantLock dky;
  private boolean dkz;
  
  static
  {
    AppMethodBeat.i(131782);
    dkx = false;
    lock = new Object();
    dkC = MMApplicationContext.getApplicationId() + ":push";
    dkD = 0;
    dkE = 40000;
    AppMethodBeat.o(131782);
  }
  
  public g()
  {
    AppMethodBeat.i(131773);
    this.dky = new ReentrantLock();
    this.dkz = false;
    this.dkA = null;
    this.dkB = new a();
    AppMethodBeat.o(131773);
  }
  
  public static void Wj()
  {
    AppMethodBeat.i(131778);
    int i = gb(dkC);
    Log.e("MicroMsg.CoreServiceConnection", "killPushProcess() pid = %s, stack[%s]", new Object[] { Integer.valueOf(i), Util.getStack() });
    killProcess(i);
    AppMethodBeat.o(131778);
  }
  
  private void Wk()
  {
    AppMethodBeat.i(196971);
    MMHandlerThread.removeRunnable(this.dkB);
    this.dkB.dkI = 0;
    AppMethodBeat.o(196971);
  }
  
  public static int cL(boolean paramBoolean)
  {
    AppMethodBeat.i(196970);
    int i = dkE;
    if (paramBoolean)
    {
      int j = dkD + 1;
      dkD = j;
      if ((j == 5) && (i < 600000))
      {
        dkE += 20000;
        dkD = 0;
        Log.i("MicroMsg.CoreServiceConnection", "ZOMBIE_CHECK_TIME:%s", new Object[] { Integer.valueOf(dkE) });
      }
    }
    AppMethodBeat.o(196970);
    return i;
  }
  
  public static int gb(String paramString)
  {
    AppMethodBeat.i(131777);
    if (Util.isNullOrNil(paramString))
    {
      Log.i("MicroMsg.CoreServiceConnection", "getPicByProcessName() processName == null");
      AppMethodBeat.o(131777);
      return -1;
    }
    for (;;)
    {
      try
      {
        Object localObject = ((ActivityManager)MMApplicationContext.getContext().getSystemService("activity")).getRunningAppProcesses();
        if (localObject == null)
        {
          Log.i("MicroMsg.CoreServiceConnection", "getPicByProcessName() processes == null");
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
        Log.e("MicroMsg.CoreServiceConnection", "getPidByProcessName() %s %s %s", new Object[] { paramString, localException.getClass().getSimpleName(), localException.getMessage() });
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
      com.tencent.mm.hellhoundlib.a.a.a(localObject, locala.axQ(), "com/tencent/mm/app/CoreServiceConnection", "killProcess", "(I)V", "android/os/Process_EXEC_", "killProcess", "(I)V");
      Process.killProcess(((Integer)locala.pG(0)).intValue());
      com.tencent.mm.hellhoundlib.a.a.a(localObject, "com/tencent/mm/app/CoreServiceConnection", "killProcess", "(I)V", "android/os/Process_EXEC_", "killProcess", "(I)V");
      AppMethodBeat.o(131779);
      return;
    }
    catch (Exception localException)
    {
      Log.e("MicroMsg.CoreServiceConnection", "killProcess %s, %s %s", new Object[] { Integer.valueOf(paramInt), localException.getClass().getSimpleName(), localException.getMessage() });
      AppMethodBeat.o(131779);
    }
  }
  
  /* Error */
  public final void bG(Context paramContext)
  {
    // Byte code:
    //   0: ldc_w 697
    //   3: invokestatic 46	com/tencent/matrix/trace/core/AppMethodBeat:i	(I)V
    //   6: ldc_w 699
    //   9: invokestatic 204	com/tencent/mm/blink/a:CM	(Ljava/lang/String;)V
    //   12: aload_0
    //   13: getfield 88	com/tencent/mm/app/g:dky	Ljava/util/concurrent/locks/ReentrantLock;
    //   16: invokevirtual 701	java/util/concurrent/locks/ReentrantLock:lock	()V
    //   19: aload_0
    //   20: getfield 92	com/tencent/mm/app/g:dkA	Landroid/os/IBinder;
    //   23: ifnull +100 -> 123
    //   26: aload_0
    //   27: getfield 92	com/tencent/mm/app/g:dkA	Landroid/os/IBinder;
    //   30: invokeinterface 706 1 0
    //   35: ifeq +88 -> 123
    //   38: iconst_1
    //   39: istore_3
    //   40: ldc 105
    //   42: ldc_w 708
    //   45: iconst_2
    //   46: anewarray 4	java/lang/Object
    //   49: dup
    //   50: iconst_0
    //   51: aload_0
    //   52: getfield 90	com/tencent/mm/app/g:dkz	Z
    //   55: invokestatic 457	java/lang/Boolean:valueOf	(Z)Ljava/lang/Boolean;
    //   58: aastore
    //   59: dup
    //   60: iconst_1
    //   61: iload_3
    //   62: invokestatic 457	java/lang/Boolean:valueOf	(Z)Ljava/lang/Boolean;
    //   65: aastore
    //   66: invokestatic 498	com/tencent/mm/sdk/platformtools/Log:i	(Ljava/lang/String;Ljava/lang/String;[Ljava/lang/Object;)V
    //   69: aload_0
    //   70: getfield 90	com/tencent/mm/app/g:dkz	Z
    //   73: ifne +7 -> 80
    //   76: iload_3
    //   77: ifeq +51 -> 128
    //   80: ldc 105
    //   82: ldc_w 710
    //   85: iconst_2
    //   86: anewarray 4	java/lang/Object
    //   89: dup
    //   90: iconst_0
    //   91: aload_0
    //   92: getfield 90	com/tencent/mm/app/g:dkz	Z
    //   95: invokestatic 457	java/lang/Boolean:valueOf	(Z)Ljava/lang/Boolean;
    //   98: aastore
    //   99: dup
    //   100: iconst_1
    //   101: iload_3
    //   102: invokestatic 457	java/lang/Boolean:valueOf	(Z)Ljava/lang/Boolean;
    //   105: aastore
    //   106: invokestatic 459	com/tencent/mm/sdk/platformtools/Log:w	(Ljava/lang/String;Ljava/lang/String;[Ljava/lang/Object;)V
    //   109: aload_0
    //   110: getfield 88	com/tencent/mm/app/g:dky	Ljava/util/concurrent/locks/ReentrantLock;
    //   113: invokevirtual 713	java/util/concurrent/locks/ReentrantLock:unlock	()V
    //   116: ldc_w 697
    //   119: invokestatic 81	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   122: return
    //   123: iconst_0
    //   124: istore_3
    //   125: goto -85 -> 40
    //   128: aload_0
    //   129: getfield 88	com/tencent/mm/app/g:dky	Ljava/util/concurrent/locks/ReentrantLock;
    //   132: invokevirtual 713	java/util/concurrent/locks/ReentrantLock:unlock	()V
    //   135: invokestatic 718	com/tencent/mm/booter/c:akA	()Z
    //   138: ifeq +186 -> 324
    //   141: new 720	android/content/Intent
    //   144: dup
    //   145: aload_1
    //   146: ldc_w 722
    //   149: invokespecial 725	android/content/Intent:<init>	(Landroid/content/Context;Ljava/lang/Class;)V
    //   152: astore 4
    //   154: ldc 105
    //   156: ldc_w 727
    //   159: invokestatic 601	com/tencent/mm/sdk/platformtools/Log:i	(Ljava/lang/String;Ljava/lang/String;)V
    //   162: aload_1
    //   163: aload 4
    //   165: aload_0
    //   166: iconst_1
    //   167: invokevirtual 731	android/content/Context:bindService	(Landroid/content/Intent;Landroid/content/ServiceConnection;I)Z
    //   170: ifne +61 -> 231
    //   173: ldc 105
    //   175: ldc_w 733
    //   178: invokestatic 333	com/tencent/mm/sdk/platformtools/Log:e	(Ljava/lang/String;Ljava/lang/String;)V
    //   181: ldc_w 697
    //   184: invokestatic 81	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   187: return
    //   188: astore_1
    //   189: aload_0
    //   190: getfield 88	com/tencent/mm/app/g:dky	Ljava/util/concurrent/locks/ReentrantLock;
    //   193: invokevirtual 713	java/util/concurrent/locks/ReentrantLock:unlock	()V
    //   196: ldc_w 697
    //   199: invokestatic 81	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   202: aload_1
    //   203: athrow
    //   204: astore_1
    //   205: ldc 105
    //   207: ldc_w 735
    //   210: iconst_1
    //   211: anewarray 4	java/lang/Object
    //   214: dup
    //   215: iconst_0
    //   216: aload_1
    //   217: invokevirtual 658	java/lang/Exception:getMessage	()Ljava/lang/String;
    //   220: aastore
    //   221: invokestatic 125	com/tencent/mm/sdk/platformtools/Log:e	(Ljava/lang/String;Ljava/lang/String;[Ljava/lang/Object;)V
    //   224: ldc_w 697
    //   227: invokestatic 81	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   230: return
    //   231: aload_0
    //   232: getfield 88	com/tencent/mm/app/g:dky	Ljava/util/concurrent/locks/ReentrantLock;
    //   235: invokevirtual 701	java/util/concurrent/locks/ReentrantLock:lock	()V
    //   238: aload_0
    //   239: iconst_1
    //   240: putfield 90	com/tencent/mm/app/g:dkz	Z
    //   243: aload_0
    //   244: getfield 88	com/tencent/mm/app/g:dky	Ljava/util/concurrent/locks/ReentrantLock;
    //   247: invokevirtual 713	java/util/concurrent/locks/ReentrantLock:unlock	()V
    //   250: getstatic 53	com/tencent/mm/app/g:lock	Ljava/lang/Object;
    //   253: astore_1
    //   254: aload_1
    //   255: monitorenter
    //   256: getstatic 48	com/tencent/mm/app/g:dkx	Z
    //   259: ifne +27 -> 286
    //   262: iconst_1
    //   263: putstatic 48	com/tencent/mm/app/g:dkx	Z
    //   266: ldc 105
    //   268: ldc_w 737
    //   271: invokestatic 601	com/tencent/mm/sdk/platformtools/Log:i	(Ljava/lang/String;Ljava/lang/String;)V
    //   274: aload_0
    //   275: getfield 97	com/tencent/mm/app/g:dkB	Lcom/tencent/mm/app/g$a;
    //   278: iconst_0
    //   279: invokestatic 739	com/tencent/mm/app/g:cL	(Z)I
    //   282: i2l
    //   283: invokestatic 743	com/tencent/mm/sdk/platformtools/MMHandlerThread:postToMainThreadDelayed	(Ljava/lang/Runnable;J)V
    //   286: aload_1
    //   287: monitorexit
    //   288: ldc_w 697
    //   291: invokestatic 81	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   294: return
    //   295: astore_1
    //   296: aload_0
    //   297: getfield 88	com/tencent/mm/app/g:dky	Ljava/util/concurrent/locks/ReentrantLock;
    //   300: invokevirtual 713	java/util/concurrent/locks/ReentrantLock:unlock	()V
    //   303: ldc_w 697
    //   306: invokestatic 81	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   309: aload_1
    //   310: athrow
    //   311: astore 4
    //   313: aload_1
    //   314: monitorexit
    //   315: ldc_w 697
    //   318: invokestatic 81	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   321: aload 4
    //   323: athrow
    //   324: aload_1
    //   325: ldc_w 745
    //   328: iconst_0
    //   329: invokestatic 750	com/tencent/mm/booter/b:c	(Landroid/content/Context;Ljava/lang/String;Z)Z
    //   332: ifne +18 -> 350
    //   335: ldc 105
    //   337: ldc_w 752
    //   340: invokestatic 601	com/tencent/mm/sdk/platformtools/Log:i	(Ljava/lang/String;Ljava/lang/String;)V
    //   343: ldc_w 697
    //   346: invokestatic 81	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   349: return
    //   350: aload_0
    //   351: getfield 88	com/tencent/mm/app/g:dky	Ljava/util/concurrent/locks/ReentrantLock;
    //   354: invokevirtual 701	java/util/concurrent/locks/ReentrantLock:lock	()V
    //   357: aload_0
    //   358: iconst_1
    //   359: putfield 90	com/tencent/mm/app/g:dkz	Z
    //   362: aload_0
    //   363: getfield 88	com/tencent/mm/app/g:dky	Ljava/util/concurrent/locks/ReentrantLock;
    //   366: invokevirtual 713	java/util/concurrent/locks/ReentrantLock:unlock	()V
    //   369: getstatic 53	com/tencent/mm/app/g:lock	Ljava/lang/Object;
    //   372: astore 4
    //   374: aload 4
    //   376: monitorenter
    //   377: getstatic 48	com/tencent/mm/app/g:dkx	Z
    //   380: ifne +27 -> 407
    //   383: iconst_1
    //   384: putstatic 48	com/tencent/mm/app/g:dkx	Z
    //   387: ldc 105
    //   389: ldc_w 737
    //   392: invokestatic 601	com/tencent/mm/sdk/platformtools/Log:i	(Ljava/lang/String;Ljava/lang/String;)V
    //   395: aload_0
    //   396: getfield 97	com/tencent/mm/app/g:dkB	Lcom/tencent/mm/app/g$a;
    //   399: iconst_0
    //   400: invokestatic 739	com/tencent/mm/app/g:cL	(Z)I
    //   403: i2l
    //   404: invokestatic 743	com/tencent/mm/sdk/platformtools/MMHandlerThread:postToMainThreadDelayed	(Ljava/lang/Runnable;J)V
    //   407: aload 4
    //   409: monitorexit
    //   410: new 720	android/content/Intent
    //   413: dup
    //   414: aload_1
    //   415: ldc_w 722
    //   418: invokespecial 725	android/content/Intent:<init>	(Landroid/content/Context;Ljava/lang/Class;)V
    //   421: astore 4
    //   423: ldc 105
    //   425: ldc_w 727
    //   428: invokestatic 601	com/tencent/mm/sdk/platformtools/Log:i	(Ljava/lang/String;Ljava/lang/String;)V
    //   431: aload_1
    //   432: aload 4
    //   434: aload_0
    //   435: iconst_1
    //   436: invokevirtual 731	android/content/Context:bindService	(Landroid/content/Intent;Landroid/content/ServiceConnection;I)Z
    //   439: ifne +272 -> 711
    //   442: ldc 105
    //   444: ldc_w 733
    //   447: invokestatic 333	com/tencent/mm/sdk/platformtools/Log:e	(Ljava/lang/String;Ljava/lang/String;)V
    //   450: aload_0
    //   451: getfield 88	com/tencent/mm/app/g:dky	Ljava/util/concurrent/locks/ReentrantLock;
    //   454: invokevirtual 701	java/util/concurrent/locks/ReentrantLock:lock	()V
    //   457: aload_0
    //   458: iconst_0
    //   459: putfield 90	com/tencent/mm/app/g:dkz	Z
    //   462: aload_0
    //   463: getfield 88	com/tencent/mm/app/g:dky	Ljava/util/concurrent/locks/ReentrantLock;
    //   466: invokevirtual 713	java/util/concurrent/locks/ReentrantLock:unlock	()V
    //   469: getstatic 757	android/os/Build:BRAND	Ljava/lang/String;
    //   472: invokevirtual 760	java/lang/String:toLowerCase	()Ljava/lang/String;
    //   475: astore_1
    //   476: aload_1
    //   477: ldc_w 762
    //   480: invokevirtual 766	java/lang/String:contains	(Ljava/lang/CharSequence;)Z
    //   483: ifne +235 -> 718
    //   486: aload_1
    //   487: ldc_w 768
    //   490: invokevirtual 766	java/lang/String:contains	(Ljava/lang/CharSequence;)Z
    //   493: ifeq +117 -> 610
    //   496: goto +222 -> 718
    //   499: getstatic 339	com/tencent/mm/plugin/report/e:Cxv	Lcom/tencent/mm/plugin/report/e;
    //   502: ldc2_w 769
    //   505: iload_2
    //   506: i2l
    //   507: lconst_1
    //   508: iconst_0
    //   509: invokevirtual 347	com/tencent/mm/plugin/report/e:idkeyStat	(JJJZ)V
    //   512: getstatic 339	com/tencent/mm/plugin/report/e:Cxv	Lcom/tencent/mm/plugin/report/e;
    //   515: sipush 20661
    //   518: iconst_1
    //   519: anewarray 4	java/lang/Object
    //   522: dup
    //   523: iconst_0
    //   524: iconst_0
    //   525: invokestatic 113	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
    //   528: aastore
    //   529: invokevirtual 773	com/tencent/mm/plugin/report/e:a	(I[Ljava/lang/Object;)V
    //   532: ldc_w 697
    //   535: invokestatic 81	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   538: return
    //   539: astore_1
    //   540: ldc 105
    //   542: ldc_w 775
    //   545: iconst_1
    //   546: anewarray 4	java/lang/Object
    //   549: dup
    //   550: iconst_0
    //   551: aload_1
    //   552: invokevirtual 658	java/lang/Exception:getMessage	()Ljava/lang/String;
    //   555: aastore
    //   556: invokestatic 125	com/tencent/mm/sdk/platformtools/Log:e	(Ljava/lang/String;Ljava/lang/String;[Ljava/lang/Object;)V
    //   559: ldc_w 697
    //   562: invokestatic 81	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   565: return
    //   566: astore_1
    //   567: aload_0
    //   568: getfield 88	com/tencent/mm/app/g:dky	Ljava/util/concurrent/locks/ReentrantLock;
    //   571: invokevirtual 713	java/util/concurrent/locks/ReentrantLock:unlock	()V
    //   574: ldc_w 697
    //   577: invokestatic 81	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   580: aload_1
    //   581: athrow
    //   582: astore_1
    //   583: aload 4
    //   585: monitorexit
    //   586: ldc_w 697
    //   589: invokestatic 81	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   592: aload_1
    //   593: athrow
    //   594: astore_1
    //   595: aload_0
    //   596: getfield 88	com/tencent/mm/app/g:dky	Ljava/util/concurrent/locks/ReentrantLock;
    //   599: invokevirtual 713	java/util/concurrent/locks/ReentrantLock:unlock	()V
    //   602: ldc_w 697
    //   605: invokestatic 81	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   608: aload_1
    //   609: athrow
    //   610: aload_1
    //   611: ldc_w 777
    //   614: invokevirtual 766	java/lang/String:contains	(Ljava/lang/CharSequence;)Z
    //   617: ifne +107 -> 724
    //   620: aload_1
    //   621: ldc_w 779
    //   624: invokevirtual 766	java/lang/String:contains	(Ljava/lang/CharSequence;)Z
    //   627: ifeq +6 -> 633
    //   630: goto +94 -> 724
    //   633: aload_1
    //   634: ldc_w 781
    //   637: invokevirtual 766	java/lang/String:contains	(Ljava/lang/CharSequence;)Z
    //   640: ifeq +9 -> 649
    //   643: bipush 43
    //   645: istore_2
    //   646: goto -147 -> 499
    //   649: aload_1
    //   650: ldc_w 783
    //   653: invokevirtual 766	java/lang/String:contains	(Ljava/lang/CharSequence;)Z
    //   656: ifeq +9 -> 665
    //   659: bipush 42
    //   661: istore_2
    //   662: goto -163 -> 499
    //   665: aload_1
    //   666: ldc_w 785
    //   669: invokevirtual 766	java/lang/String:contains	(Ljava/lang/CharSequence;)Z
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
    //   690: ldc_w 787
    //   693: aload_1
    //   694: ldc_w 789
    //   697: iconst_0
    //   698: anewarray 4	java/lang/Object
    //   701: invokestatic 793	com/tencent/mm/sdk/platformtools/Log:printErrStackTrace	(Ljava/lang/String;Ljava/lang/Throwable;Ljava/lang/String;[Ljava/lang/Object;)V
    //   704: ldc_w 697
    //   707: invokestatic 81	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   710: return
    //   711: ldc_w 697
    //   714: invokestatic 81	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
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
    Log.w("MicroMsg.CoreServiceConnection", "onServiceConnected ");
    gb(dkC);
    if (com.tencent.mm.booter.c.akA())
    {
      if (paramIBinder == null)
      {
        Log.w("MicroMsg.CoreServiceConnection", "onServiceConnected binder == null");
        AppMethodBeat.o(131774);
        return;
      }
      if (!((h)com.tencent.mm.kernel.g.aAe().azG()).aBb()) {
        break label269;
      }
      synchronized (lock)
      {
        Log.i("MicroMsg.CoreServiceConnection", "remove zombie killer.");
        Wk();
        dkx = false;
      }
      try
      {
        this.dky.lock();
        this.dkz = false;
        if ((this.dkA != null) && (Util.isEqual(this.dkA.hashCode(), paramIBinder.hashCode())))
        {
          Log.w("MicroMsg.CoreServiceConnection", "onServiceConnected binder == serviceBinder");
          return;
          paramComponentName = finally;
          AppMethodBeat.o(131774);
          throw paramComponentName;
        }
        this.dkA = paramIBinder;
        this.dky.unlock();
        com.tencent.mm.blink.b.ake().arrange(new Runnable()
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
        this.dky.unlock();
        AppMethodBeat.o(131774);
      }
    }
    label269:
    synchronized (lock)
    {
      Log.i("MicroMsg.CoreServiceConnection", "remove zombie killer.");
      Wk();
      dkx = false;
    }
  }
  
  public final void onServiceDisconnected(final ComponentName paramComponentName)
  {
    AppMethodBeat.i(131775);
    Log.w("MicroMsg.CoreServiceConnection", "onServiceDisconnected ");
    if (((h)com.tencent.mm.kernel.g.aAe().azG()).aBb()) {}
    try
    {
      this.dky.lock();
      this.dkz = false;
      this.dkA = null;
      this.dky.unlock();
      com.tencent.mm.blink.b.ake().arrange(new Runnable()
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
      this.dky.unlock();
      AppMethodBeat.o(131775);
    }
  }
  
  final class a
    implements Runnable
  {
    int dkI = 0;
    
    a() {}
    
    /* Error */
    public final void run()
    {
      // Byte code:
      //   0: ldc 27
      //   2: invokestatic 33	com/tencent/matrix/trace/core/AppMethodBeat:i	(I)V
      //   5: aload_0
      //   6: getfield 17	com/tencent/mm/app/g$a:dkF	Lcom/tencent/mm/app/g;
      //   9: invokestatic 37	com/tencent/mm/app/g:b	(Lcom/tencent/mm/app/g;)Ljava/util/concurrent/locks/ReentrantLock;
      //   12: invokevirtual 42	java/util/concurrent/locks/ReentrantLock:lock	()V
      //   15: aload_0
      //   16: getfield 17	com/tencent/mm/app/g$a:dkF	Lcom/tencent/mm/app/g;
      //   19: invokestatic 46	com/tencent/mm/app/g:c	(Lcom/tencent/mm/app/g;)Landroid/os/IBinder;
      //   22: ifnull +75 -> 97
      //   25: aload_0
      //   26: getfield 17	com/tencent/mm/app/g$a:dkF	Lcom/tencent/mm/app/g;
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
      //   53: getfield 17	com/tencent/mm/app/g$a:dkF	Lcom/tencent/mm/app/g;
      //   56: invokestatic 46	com/tencent/mm/app/g:c	(Lcom/tencent/mm/app/g;)Landroid/os/IBinder;
      //   59: aastore
      //   60: dup
      //   61: iconst_1
      //   62: iload_2
      //   63: invokestatic 62	java/lang/Boolean:valueOf	(Z)Ljava/lang/Boolean;
      //   66: aastore
      //   67: invokestatic 67	com/tencent/mm/sdk/platformtools/Log:i	(Ljava/lang/String;Ljava/lang/String;[Ljava/lang/Object;)V
      //   70: iload_2
      //   71: ifeq +31 -> 102
      //   74: ldc 54
      //   76: ldc 69
      //   78: invokestatic 73	com/tencent/mm/sdk/platformtools/Log:w	(Ljava/lang/String;Ljava/lang/String;)V
      //   81: aload_0
      //   82: getfield 17	com/tencent/mm/app/g$a:dkF	Lcom/tencent/mm/app/g;
      //   85: invokestatic 37	com/tencent/mm/app/g:b	(Lcom/tencent/mm/app/g;)Ljava/util/concurrent/locks/ReentrantLock;
      //   88: invokevirtual 76	java/util/concurrent/locks/ReentrantLock:unlock	()V
      //   91: ldc 27
      //   93: invokestatic 79	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
      //   96: return
      //   97: iconst_0
      //   98: istore_2
      //   99: goto -57 -> 42
      //   102: aload_0
      //   103: getfield 17	com/tencent/mm/app/g$a:dkF	Lcom/tencent/mm/app/g;
      //   106: invokestatic 37	com/tencent/mm/app/g:b	(Lcom/tencent/mm/app/g;)Ljava/util/concurrent/locks/ReentrantLock;
      //   109: invokevirtual 76	java/util/concurrent/locks/ReentrantLock:unlock	()V
      //   112: ldc 54
      //   114: ldc 81
      //   116: iconst_1
      //   117: anewarray 4	java/lang/Object
      //   120: dup
      //   121: iconst_0
      //   122: aload_0
      //   123: getfield 22	com/tencent/mm/app/g$a:dkI	I
      //   126: invokestatic 86	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
      //   129: aastore
      //   130: invokestatic 92	java/lang/String:format	(Ljava/lang/String;[Ljava/lang/Object;)Ljava/lang/String;
      //   133: invokestatic 95	com/tencent/mm/sdk/platformtools/Log:e	(Ljava/lang/String;Ljava/lang/String;)V
      //   136: aload_0
      //   137: getfield 22	com/tencent/mm/app/g$a:dkI	I
      //   140: iconst_1
      //   141: if_icmpne +43 -> 184
      //   144: invokestatic 99	com/tencent/mm/app/g:access$400	()Ljava/lang/String;
      //   147: invokestatic 103	com/tencent/mm/app/g:gb	(Ljava/lang/String;)I
      //   150: istore_1
      //   151: iload_1
      //   152: iconst_m1
      //   153: if_icmpeq +150 -> 303
      //   156: ldc 54
      //   158: ldc 105
      //   160: iconst_1
      //   161: anewarray 4	java/lang/Object
      //   164: dup
      //   165: iconst_0
      //   166: iload_1
      //   167: invokestatic 86	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
      //   170: aastore
      //   171: invokestatic 92	java/lang/String:format	(Ljava/lang/String;[Ljava/lang/Object;)Ljava/lang/String;
      //   174: invokestatic 107	com/tencent/mm/sdk/platformtools/Log:i	(Ljava/lang/String;Ljava/lang/String;)V
      //   177: invokestatic 110	com/tencent/mm/sdk/platformtools/Log:appenderFlush	()V
      //   180: iload_1
      //   181: invokestatic 113	com/tencent/mm/app/g:killProcess	(I)V
      //   184: invokestatic 119	com/tencent/mm/sdk/platformtools/MMApplicationContext:getContext	()Landroid/content/Context;
      //   187: astore_3
      //   188: new 121	android/content/Intent
      //   191: dup
      //   192: aload_3
      //   193: ldc 123
      //   195: invokespecial 126	android/content/Intent:<init>	(Landroid/content/Context;Ljava/lang/Class;)V
      //   198: astore 4
      //   200: ldc 54
      //   202: ldc 128
      //   204: invokestatic 107	com/tencent/mm/sdk/platformtools/Log:i	(Ljava/lang/String;Ljava/lang/String;)V
      //   207: aload_3
      //   208: aload_0
      //   209: getfield 17	com/tencent/mm/app/g$a:dkF	Lcom/tencent/mm/app/g;
      //   212: invokevirtual 134	android/content/Context:unbindService	(Landroid/content/ServiceConnection;)V
      //   215: invokestatic 139	com/tencent/mm/booter/c:akA	()Z
      //   218: ifeq +95 -> 313
      //   221: aload_3
      //   222: aload 4
      //   224: aload_0
      //   225: getfield 17	com/tencent/mm/app/g$a:dkF	Lcom/tencent/mm/app/g;
      //   228: iconst_1
      //   229: invokevirtual 143	android/content/Context:bindService	(Landroid/content/Intent;Landroid/content/ServiceConnection;I)Z
      //   232: pop
      //   233: aload_0
      //   234: getfield 22	com/tencent/mm/app/g$a:dkI	I
      //   237: iconst_1
      //   238: if_icmpne +279 -> 517
      //   241: aload_0
      //   242: iconst_0
      //   243: putfield 22	com/tencent/mm/app/g$a:dkI	I
      //   246: aload_0
      //   247: iconst_1
      //   248: invokestatic 147	com/tencent/mm/app/g:cL	(Z)I
      //   251: i2l
      //   252: invokestatic 153	com/tencent/mm/sdk/platformtools/MMHandlerThread:postToMainThreadDelayed	(Ljava/lang/Runnable;J)V
      //   255: ldc 54
      //   257: ldc 155
      //   259: iconst_1
      //   260: anewarray 4	java/lang/Object
      //   263: dup
      //   264: iconst_0
      //   265: aload_0
      //   266: getfield 22	com/tencent/mm/app/g$a:dkI	I
      //   269: invokestatic 86	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
      //   272: aastore
      //   273: invokestatic 92	java/lang/String:format	(Ljava/lang/String;[Ljava/lang/Object;)Ljava/lang/String;
      //   276: invokestatic 107	com/tencent/mm/sdk/platformtools/Log:i	(Ljava/lang/String;Ljava/lang/String;)V
      //   279: ldc 27
      //   281: invokestatic 79	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
      //   284: return
      //   285: astore_3
      //   286: aload_0
      //   287: getfield 17	com/tencent/mm/app/g$a:dkF	Lcom/tencent/mm/app/g;
      //   290: invokestatic 37	com/tencent/mm/app/g:b	(Lcom/tencent/mm/app/g;)Ljava/util/concurrent/locks/ReentrantLock;
      //   293: invokevirtual 76	java/util/concurrent/locks/ReentrantLock:unlock	()V
      //   296: ldc 27
      //   298: invokestatic 79	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
      //   301: aload_3
      //   302: athrow
      //   303: ldc 54
      //   305: ldc 157
      //   307: invokestatic 107	com/tencent/mm/sdk/platformtools/Log:i	(Ljava/lang/String;Ljava/lang/String;)V
      //   310: goto -126 -> 184
      //   313: aload_3
      //   314: aload 4
      //   316: invokevirtual 161	android/content/Context:stopService	(Landroid/content/Intent;)Z
      //   319: pop
      //   320: aload_3
      //   321: aload 4
      //   323: aload_0
      //   324: getfield 17	com/tencent/mm/app/g$a:dkF	Lcom/tencent/mm/app/g;
      //   327: iconst_1
      //   328: invokevirtual 143	android/content/Context:bindService	(Landroid/content/Intent;Landroid/content/ServiceConnection;I)Z
      //   331: pop
      //   332: aload_3
      //   333: aload 4
      //   335: invokevirtual 165	android/content/Context:startService	(Landroid/content/Intent;)Landroid/content/ComponentName;
      //   338: pop
      //   339: goto -106 -> 233
      //   342: astore_3
      //   343: ldc 54
      //   345: ldc 167
      //   347: iconst_1
      //   348: anewarray 4	java/lang/Object
      //   351: dup
      //   352: iconst_0
      //   353: aload_3
      //   354: invokevirtual 170	java/lang/Exception:getMessage	()Ljava/lang/String;
      //   357: aastore
      //   358: invokestatic 172	com/tencent/mm/sdk/platformtools/Log:e	(Ljava/lang/String;Ljava/lang/String;[Ljava/lang/Object;)V
      //   361: goto -128 -> 233
      //   364: astore 5
      //   366: invokestatic 139	com/tencent/mm/booter/c:akA	()Z
      //   369: ifeq +40 -> 409
      //   372: aload_3
      //   373: aload 4
      //   375: aload_0
      //   376: getfield 17	com/tencent/mm/app/g$a:dkF	Lcom/tencent/mm/app/g;
      //   379: iconst_1
      //   380: invokevirtual 143	android/content/Context:bindService	(Landroid/content/Intent;Landroid/content/ServiceConnection;I)Z
      //   383: pop
      //   384: goto -151 -> 233
      //   387: astore_3
      //   388: ldc 54
      //   390: ldc 167
      //   392: iconst_1
      //   393: anewarray 4	java/lang/Object
      //   396: dup
      //   397: iconst_0
      //   398: aload_3
      //   399: invokevirtual 170	java/lang/Exception:getMessage	()Ljava/lang/String;
      //   402: aastore
      //   403: invokestatic 172	com/tencent/mm/sdk/platformtools/Log:e	(Ljava/lang/String;Ljava/lang/String;[Ljava/lang/Object;)V
      //   406: goto -173 -> 233
      //   409: aload_3
      //   410: aload 4
      //   412: invokevirtual 161	android/content/Context:stopService	(Landroid/content/Intent;)Z
      //   415: pop
      //   416: aload_3
      //   417: aload 4
      //   419: aload_0
      //   420: getfield 17	com/tencent/mm/app/g$a:dkF	Lcom/tencent/mm/app/g;
      //   423: iconst_1
      //   424: invokevirtual 143	android/content/Context:bindService	(Landroid/content/Intent;Landroid/content/ServiceConnection;I)Z
      //   427: pop
      //   428: aload_3
      //   429: aload 4
      //   431: invokevirtual 165	android/content/Context:startService	(Landroid/content/Intent;)Landroid/content/ComponentName;
      //   434: pop
      //   435: goto -202 -> 233
      //   438: astore 5
      //   440: invokestatic 139	com/tencent/mm/booter/c:akA	()Z
      //   443: ifeq +23 -> 466
      //   446: aload_3
      //   447: aload 4
      //   449: aload_0
      //   450: getfield 17	com/tencent/mm/app/g$a:dkF	Lcom/tencent/mm/app/g;
      //   453: iconst_1
      //   454: invokevirtual 143	android/content/Context:bindService	(Landroid/content/Intent;Landroid/content/ServiceConnection;I)Z
      //   457: pop
      //   458: ldc 27
      //   460: invokestatic 79	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
      //   463: aload 5
      //   465: athrow
      //   466: aload_3
      //   467: aload 4
      //   469: invokevirtual 161	android/content/Context:stopService	(Landroid/content/Intent;)Z
      //   472: pop
      //   473: aload_3
      //   474: aload 4
      //   476: aload_0
      //   477: getfield 17	com/tencent/mm/app/g$a:dkF	Lcom/tencent/mm/app/g;
      //   480: iconst_1
      //   481: invokevirtual 143	android/content/Context:bindService	(Landroid/content/Intent;Landroid/content/ServiceConnection;I)Z
      //   484: pop
      //   485: aload_3
      //   486: aload 4
      //   488: invokevirtual 165	android/content/Context:startService	(Landroid/content/Intent;)Landroid/content/ComponentName;
      //   491: pop
      //   492: goto -34 -> 458
      //   495: astore_3
      //   496: ldc 54
      //   498: ldc 167
      //   500: iconst_1
      //   501: anewarray 4	java/lang/Object
      //   504: dup
      //   505: iconst_0
      //   506: aload_3
      //   507: invokevirtual 170	java/lang/Exception:getMessage	()Ljava/lang/String;
      //   510: aastore
      //   511: invokestatic 172	com/tencent/mm/sdk/platformtools/Log:e	(Ljava/lang/String;Ljava/lang/String;[Ljava/lang/Object;)V
      //   514: goto -56 -> 458
      //   517: aload_0
      //   518: aload_0
      //   519: getfield 22	com/tencent/mm/app/g$a:dkI	I
      //   522: iconst_1
      //   523: iadd
      //   524: putfield 22	com/tencent/mm/app/g$a:dkI	I
      //   527: goto -281 -> 246
      // Local variable table:
      //   start	length	slot	name	signature
      //   0	530	0	this	a
      //   150	31	1	i	int
      //   41	58	2	bool	boolean
      //   187	35	3	localContext	Context
      //   285	48	3	localObject1	Object
      //   342	31	3	localException1	Exception
      //   387	99	3	localException2	Exception
      //   495	12	3	localException3	Exception
      //   198	289	4	localIntent	android.content.Intent
      //   364	1	5	localException4	Exception
      //   438	26	5	localObject2	Object
      // Exception table:
      //   from	to	target	type
      //   5	40	285	finally
      //   42	70	285	finally
      //   74	81	285	finally
      //   215	233	342	java/lang/Exception
      //   313	339	342	java/lang/Exception
      //   200	215	364	java/lang/Exception
      //   366	384	387	java/lang/Exception
      //   409	435	387	java/lang/Exception
      //   200	215	438	finally
      //   440	458	495	java/lang/Exception
      //   466	492	495	java/lang/Exception
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.app.g
 * JD-Core Version:    0.7.0.1
 */