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
import com.tencent.mm.kernel.e;
import com.tencent.mm.model.aw;
import com.tencent.mm.network.i.a;
import com.tencent.mm.network.u.a;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.MMApplicationContext;
import com.tencent.mm.sdk.platformtools.MMHandlerThread;
import com.tencent.mm.sdk.platformtools.Util;
import java.util.Iterator;
import java.util.List;
import java.util.concurrent.locks.ReentrantLock;

public class g
  implements ServiceConnection
{
  private static boolean fcg;
  private static final String fcl;
  private static int fcm;
  private static int fcn;
  private static Object lock;
  private ReentrantLock fch;
  private boolean fci;
  private IBinder fcj;
  private a fck;
  
  static
  {
    AppMethodBeat.i(131782);
    fcg = false;
    lock = new Object();
    fcl = MMApplicationContext.getApplicationId() + ":push";
    fcm = 0;
    fcn = 40000;
    AppMethodBeat.o(131782);
  }
  
  public g()
  {
    AppMethodBeat.i(131773);
    this.fch = new ReentrantLock();
    this.fci = false;
    this.fcj = null;
    this.fck = new a();
    AppMethodBeat.o(131773);
  }
  
  public static void aaF()
  {
    AppMethodBeat.i(131778);
    int i = gL(fcl);
    Log.e("MicroMsg.CoreServiceConnection", "killPushProcess() pid = %s, stack[%s]", new Object[] { Integer.valueOf(i), Util.getStack() });
    jZ(i);
    AppMethodBeat.o(131778);
  }
  
  private void aaG()
  {
    AppMethodBeat.i(211675);
    MMHandlerThread.removeRunnable(this.fck);
    this.fck.fcr = 0;
    AppMethodBeat.o(211675);
  }
  
  public static int dh(boolean paramBoolean)
  {
    AppMethodBeat.i(211673);
    int i = fcn;
    if (paramBoolean)
    {
      int j = fcm + 1;
      fcm = j;
      if ((j == 5) && (i < 600000))
      {
        fcn += 20000;
        fcm = 0;
        Log.i("MicroMsg.CoreServiceConnection", "ZOMBIE_CHECK_TIME:%s", new Object[] { Integer.valueOf(fcn) });
      }
    }
    AppMethodBeat.o(211673);
    return i;
  }
  
  public static int gL(String paramString)
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
  
  public static void jZ(int paramInt)
  {
    AppMethodBeat.i(131779);
    try
    {
      com.tencent.mm.hellhoundlib.b.a locala = com.tencent.mm.hellhoundlib.b.c.a(paramInt, new com.tencent.mm.hellhoundlib.b.a());
      Object localObject = new Object();
      com.tencent.mm.hellhoundlib.a.a.b(localObject, locala.aFh(), "com/tencent/mm/app/CoreServiceConnection", "killProcess", "(I)V", "android/os/Process_EXEC_", "killProcess", "(I)V");
      Process.killProcess(((Integer)locala.sf(0)).intValue());
      com.tencent.mm.hellhoundlib.a.a.c(localObject, "com/tencent/mm/app/CoreServiceConnection", "killProcess", "(I)V", "android/os/Process_EXEC_", "killProcess", "(I)V");
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
  public final void bF(Context paramContext)
  {
    // Byte code:
    //   0: ldc_w 699
    //   3: invokestatic 46	com/tencent/matrix/trace/core/AppMethodBeat:i	(I)V
    //   6: ldc_w 701
    //   9: invokestatic 162	com/tencent/mm/blink/a:JB	(Ljava/lang/String;)V
    //   12: aload_0
    //   13: getfield 88	com/tencent/mm/app/g:fch	Ljava/util/concurrent/locks/ReentrantLock;
    //   16: invokevirtual 703	java/util/concurrent/locks/ReentrantLock:lock	()V
    //   19: aload_0
    //   20: getfield 92	com/tencent/mm/app/g:fcj	Landroid/os/IBinder;
    //   23: ifnull +102 -> 125
    //   26: aload_0
    //   27: getfield 92	com/tencent/mm/app/g:fcj	Landroid/os/IBinder;
    //   30: invokeinterface 708 1 0
    //   35: ifeq +90 -> 125
    //   38: iconst_1
    //   39: istore_3
    //   40: ldc_w 567
    //   43: ldc_w 710
    //   46: iconst_2
    //   47: anewarray 4	java/lang/Object
    //   50: dup
    //   51: iconst_0
    //   52: aload_0
    //   53: getfield 90	com/tencent/mm/app/g:fci	Z
    //   56: invokestatic 433	java/lang/Boolean:valueOf	(Z)Ljava/lang/Boolean;
    //   59: aastore
    //   60: dup
    //   61: iconst_1
    //   62: iload_3
    //   63: invokestatic 433	java/lang/Boolean:valueOf	(Z)Ljava/lang/Boolean;
    //   66: aastore
    //   67: invokestatic 474	com/tencent/mm/sdk/platformtools/Log:i	(Ljava/lang/String;Ljava/lang/String;[Ljava/lang/Object;)V
    //   70: aload_0
    //   71: getfield 90	com/tencent/mm/app/g:fci	Z
    //   74: ifne +7 -> 81
    //   77: iload_3
    //   78: ifeq +52 -> 130
    //   81: ldc_w 567
    //   84: ldc_w 712
    //   87: iconst_2
    //   88: anewarray 4	java/lang/Object
    //   91: dup
    //   92: iconst_0
    //   93: aload_0
    //   94: getfield 90	com/tencent/mm/app/g:fci	Z
    //   97: invokestatic 433	java/lang/Boolean:valueOf	(Z)Ljava/lang/Boolean;
    //   100: aastore
    //   101: dup
    //   102: iconst_1
    //   103: iload_3
    //   104: invokestatic 433	java/lang/Boolean:valueOf	(Z)Ljava/lang/Boolean;
    //   107: aastore
    //   108: invokestatic 435	com/tencent/mm/sdk/platformtools/Log:w	(Ljava/lang/String;Ljava/lang/String;[Ljava/lang/Object;)V
    //   111: aload_0
    //   112: getfield 88	com/tencent/mm/app/g:fch	Ljava/util/concurrent/locks/ReentrantLock;
    //   115: invokevirtual 715	java/util/concurrent/locks/ReentrantLock:unlock	()V
    //   118: ldc_w 699
    //   121: invokestatic 81	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   124: return
    //   125: iconst_0
    //   126: istore_3
    //   127: goto -87 -> 40
    //   130: aload_0
    //   131: getfield 88	com/tencent/mm/app/g:fch	Ljava/util/concurrent/locks/ReentrantLock;
    //   134: invokevirtual 715	java/util/concurrent/locks/ReentrantLock:unlock	()V
    //   137: invokestatic 720	com/tencent/mm/booter/c:aqw	()Z
    //   140: ifeq +190 -> 330
    //   143: new 722	android/content/Intent
    //   146: dup
    //   147: aload_1
    //   148: ldc_w 724
    //   151: invokespecial 727	android/content/Intent:<init>	(Landroid/content/Context;Ljava/lang/Class;)V
    //   154: astore 4
    //   156: ldc_w 567
    //   159: ldc_w 729
    //   162: invokestatic 601	com/tencent/mm/sdk/platformtools/Log:i	(Ljava/lang/String;Ljava/lang/String;)V
    //   165: aload_1
    //   166: aload 4
    //   168: aload_0
    //   169: iconst_1
    //   170: invokevirtual 733	android/content/Context:bindService	(Landroid/content/Intent;Landroid/content/ServiceConnection;I)Z
    //   173: ifne +63 -> 236
    //   176: ldc_w 567
    //   179: ldc_w 735
    //   182: invokestatic 297	com/tencent/mm/sdk/platformtools/Log:e	(Ljava/lang/String;Ljava/lang/String;)V
    //   185: ldc_w 699
    //   188: invokestatic 81	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   191: return
    //   192: astore_1
    //   193: aload_0
    //   194: getfield 88	com/tencent/mm/app/g:fch	Ljava/util/concurrent/locks/ReentrantLock;
    //   197: invokevirtual 715	java/util/concurrent/locks/ReentrantLock:unlock	()V
    //   200: ldc_w 699
    //   203: invokestatic 81	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   206: aload_1
    //   207: athrow
    //   208: astore_1
    //   209: ldc_w 567
    //   212: ldc_w 737
    //   215: iconst_1
    //   216: anewarray 4	java/lang/Object
    //   219: dup
    //   220: iconst_0
    //   221: aload_1
    //   222: invokevirtual 658	java/lang/Exception:getMessage	()Ljava/lang/String;
    //   225: aastore
    //   226: invokestatic 344	com/tencent/mm/sdk/platformtools/Log:e	(Ljava/lang/String;Ljava/lang/String;[Ljava/lang/Object;)V
    //   229: ldc_w 699
    //   232: invokestatic 81	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   235: return
    //   236: aload_0
    //   237: getfield 88	com/tencent/mm/app/g:fch	Ljava/util/concurrent/locks/ReentrantLock;
    //   240: invokevirtual 703	java/util/concurrent/locks/ReentrantLock:lock	()V
    //   243: aload_0
    //   244: iconst_1
    //   245: putfield 90	com/tencent/mm/app/g:fci	Z
    //   248: aload_0
    //   249: getfield 88	com/tencent/mm/app/g:fch	Ljava/util/concurrent/locks/ReentrantLock;
    //   252: invokevirtual 715	java/util/concurrent/locks/ReentrantLock:unlock	()V
    //   255: getstatic 53	com/tencent/mm/app/g:lock	Ljava/lang/Object;
    //   258: astore_1
    //   259: aload_1
    //   260: monitorenter
    //   261: getstatic 48	com/tencent/mm/app/g:fcg	Z
    //   264: ifne +28 -> 292
    //   267: iconst_1
    //   268: putstatic 48	com/tencent/mm/app/g:fcg	Z
    //   271: ldc_w 567
    //   274: ldc_w 739
    //   277: invokestatic 601	com/tencent/mm/sdk/platformtools/Log:i	(Ljava/lang/String;Ljava/lang/String;)V
    //   280: aload_0
    //   281: getfield 97	com/tencent/mm/app/g:fck	Lcom/tencent/mm/app/g$a;
    //   284: iconst_0
    //   285: invokestatic 741	com/tencent/mm/app/g:dh	(Z)I
    //   288: i2l
    //   289: invokestatic 745	com/tencent/mm/sdk/platformtools/MMHandlerThread:postToMainThreadDelayed	(Ljava/lang/Runnable;J)V
    //   292: aload_1
    //   293: monitorexit
    //   294: ldc_w 699
    //   297: invokestatic 81	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   300: return
    //   301: astore_1
    //   302: aload_0
    //   303: getfield 88	com/tencent/mm/app/g:fch	Ljava/util/concurrent/locks/ReentrantLock;
    //   306: invokevirtual 715	java/util/concurrent/locks/ReentrantLock:unlock	()V
    //   309: ldc_w 699
    //   312: invokestatic 81	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   315: aload_1
    //   316: athrow
    //   317: astore 4
    //   319: aload_1
    //   320: monitorexit
    //   321: ldc_w 699
    //   324: invokestatic 81	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   327: aload 4
    //   329: athrow
    //   330: aload_1
    //   331: ldc_w 747
    //   334: iconst_0
    //   335: invokestatic 752	com/tencent/mm/booter/b:c	(Landroid/content/Context;Ljava/lang/String;Z)Z
    //   338: ifne +19 -> 357
    //   341: ldc_w 567
    //   344: ldc_w 754
    //   347: invokestatic 601	com/tencent/mm/sdk/platformtools/Log:i	(Ljava/lang/String;Ljava/lang/String;)V
    //   350: ldc_w 699
    //   353: invokestatic 81	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   356: return
    //   357: aload_0
    //   358: getfield 88	com/tencent/mm/app/g:fch	Ljava/util/concurrent/locks/ReentrantLock;
    //   361: invokevirtual 703	java/util/concurrent/locks/ReentrantLock:lock	()V
    //   364: aload_0
    //   365: iconst_1
    //   366: putfield 90	com/tencent/mm/app/g:fci	Z
    //   369: aload_0
    //   370: getfield 88	com/tencent/mm/app/g:fch	Ljava/util/concurrent/locks/ReentrantLock;
    //   373: invokevirtual 715	java/util/concurrent/locks/ReentrantLock:unlock	()V
    //   376: getstatic 53	com/tencent/mm/app/g:lock	Ljava/lang/Object;
    //   379: astore 4
    //   381: aload 4
    //   383: monitorenter
    //   384: getstatic 48	com/tencent/mm/app/g:fcg	Z
    //   387: ifne +28 -> 415
    //   390: iconst_1
    //   391: putstatic 48	com/tencent/mm/app/g:fcg	Z
    //   394: ldc_w 567
    //   397: ldc_w 739
    //   400: invokestatic 601	com/tencent/mm/sdk/platformtools/Log:i	(Ljava/lang/String;Ljava/lang/String;)V
    //   403: aload_0
    //   404: getfield 97	com/tencent/mm/app/g:fck	Lcom/tencent/mm/app/g$a;
    //   407: iconst_0
    //   408: invokestatic 741	com/tencent/mm/app/g:dh	(Z)I
    //   411: i2l
    //   412: invokestatic 745	com/tencent/mm/sdk/platformtools/MMHandlerThread:postToMainThreadDelayed	(Ljava/lang/Runnable;J)V
    //   415: aload 4
    //   417: monitorexit
    //   418: new 722	android/content/Intent
    //   421: dup
    //   422: aload_1
    //   423: ldc_w 724
    //   426: invokespecial 727	android/content/Intent:<init>	(Landroid/content/Context;Ljava/lang/Class;)V
    //   429: astore 4
    //   431: ldc_w 567
    //   434: ldc_w 729
    //   437: invokestatic 601	com/tencent/mm/sdk/platformtools/Log:i	(Ljava/lang/String;Ljava/lang/String;)V
    //   440: aload_1
    //   441: aload 4
    //   443: aload_0
    //   444: iconst_1
    //   445: invokevirtual 733	android/content/Context:bindService	(Landroid/content/Intent;Landroid/content/ServiceConnection;I)Z
    //   448: ifne +286 -> 734
    //   451: ldc_w 567
    //   454: ldc_w 735
    //   457: invokestatic 297	com/tencent/mm/sdk/platformtools/Log:e	(Ljava/lang/String;Ljava/lang/String;)V
    //   460: aload_0
    //   461: getfield 88	com/tencent/mm/app/g:fch	Ljava/util/concurrent/locks/ReentrantLock;
    //   464: invokevirtual 703	java/util/concurrent/locks/ReentrantLock:lock	()V
    //   467: aload_0
    //   468: iconst_0
    //   469: putfield 90	com/tencent/mm/app/g:fci	Z
    //   472: aload_0
    //   473: getfield 88	com/tencent/mm/app/g:fch	Ljava/util/concurrent/locks/ReentrantLock;
    //   476: invokevirtual 715	java/util/concurrent/locks/ReentrantLock:unlock	()V
    //   479: getstatic 759	android/os/Build:BRAND	Ljava/lang/String;
    //   482: invokevirtual 762	java/lang/String:toLowerCase	()Ljava/lang/String;
    //   485: astore_1
    //   486: getstatic 768	com/tencent/mm/sdk/vendor/Honor:INSTANCE	Lcom/tencent/mm/sdk/vendor/Honor;
    //   489: invokevirtual 771	com/tencent/mm/sdk/vendor/Honor:ifHONOR	()Z
    //   492: ifeq +118 -> 610
    //   495: bipush 46
    //   497: istore_2
    //   498: getstatic 303	com/tencent/mm/plugin/report/f:Iyx	Lcom/tencent/mm/plugin/report/f;
    //   501: ldc2_w 772
    //   504: iload_2
    //   505: i2l
    //   506: lconst_1
    //   507: iconst_0
    //   508: invokevirtual 311	com/tencent/mm/plugin/report/f:idkeyStat	(JJJZ)V
    //   511: getstatic 303	com/tencent/mm/plugin/report/f:Iyx	Lcom/tencent/mm/plugin/report/f;
    //   514: sipush 20661
    //   517: iconst_1
    //   518: anewarray 4	java/lang/Object
    //   521: dup
    //   522: iconst_0
    //   523: iconst_0
    //   524: invokestatic 395	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
    //   527: aastore
    //   528: invokevirtual 776	com/tencent/mm/plugin/report/f:a	(I[Ljava/lang/Object;)V
    //   531: ldc_w 699
    //   534: invokestatic 81	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   537: return
    //   538: astore_1
    //   539: ldc_w 567
    //   542: ldc_w 778
    //   545: iconst_1
    //   546: anewarray 4	java/lang/Object
    //   549: dup
    //   550: iconst_0
    //   551: aload_1
    //   552: invokevirtual 658	java/lang/Exception:getMessage	()Ljava/lang/String;
    //   555: aastore
    //   556: invokestatic 344	com/tencent/mm/sdk/platformtools/Log:e	(Ljava/lang/String;Ljava/lang/String;[Ljava/lang/Object;)V
    //   559: ldc_w 699
    //   562: invokestatic 81	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   565: return
    //   566: astore_1
    //   567: aload_0
    //   568: getfield 88	com/tencent/mm/app/g:fch	Ljava/util/concurrent/locks/ReentrantLock;
    //   571: invokevirtual 715	java/util/concurrent/locks/ReentrantLock:unlock	()V
    //   574: ldc_w 699
    //   577: invokestatic 81	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   580: aload_1
    //   581: athrow
    //   582: astore_1
    //   583: aload 4
    //   585: monitorexit
    //   586: ldc_w 699
    //   589: invokestatic 81	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   592: aload_1
    //   593: athrow
    //   594: astore_1
    //   595: aload_0
    //   596: getfield 88	com/tencent/mm/app/g:fch	Ljava/util/concurrent/locks/ReentrantLock;
    //   599: invokevirtual 715	java/util/concurrent/locks/ReentrantLock:unlock	()V
    //   602: ldc_w 699
    //   605: invokestatic 81	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   608: aload_1
    //   609: athrow
    //   610: aload_1
    //   611: ldc_w 780
    //   614: invokevirtual 784	java/lang/String:contains	(Ljava/lang/CharSequence;)Z
    //   617: ifne +124 -> 741
    //   620: aload_1
    //   621: ldc_w 786
    //   624: invokevirtual 784	java/lang/String:contains	(Ljava/lang/CharSequence;)Z
    //   627: ifeq +6 -> 633
    //   630: goto +111 -> 741
    //   633: aload_1
    //   634: ldc_w 788
    //   637: invokevirtual 784	java/lang/String:contains	(Ljava/lang/CharSequence;)Z
    //   640: ifne +107 -> 747
    //   643: aload_1
    //   644: ldc_w 790
    //   647: invokevirtual 784	java/lang/String:contains	(Ljava/lang/CharSequence;)Z
    //   650: ifeq +6 -> 656
    //   653: goto +94 -> 747
    //   656: aload_1
    //   657: ldc_w 792
    //   660: invokevirtual 784	java/lang/String:contains	(Ljava/lang/CharSequence;)Z
    //   663: ifeq +9 -> 672
    //   666: bipush 43
    //   668: istore_2
    //   669: goto -171 -> 498
    //   672: aload_1
    //   673: ldc_w 794
    //   676: invokevirtual 784	java/lang/String:contains	(Ljava/lang/CharSequence;)Z
    //   679: ifeq +9 -> 688
    //   682: bipush 42
    //   684: istore_2
    //   685: goto -187 -> 498
    //   688: aload_1
    //   689: ldc_w 796
    //   692: invokevirtual 784	java/lang/String:contains	(Ljava/lang/CharSequence;)Z
    //   695: istore_3
    //   696: iload_3
    //   697: ifeq +9 -> 706
    //   700: bipush 44
    //   702: istore_2
    //   703: goto -205 -> 498
    //   706: bipush 45
    //   708: istore_2
    //   709: goto -211 -> 498
    //   712: astore_1
    //   713: ldc_w 798
    //   716: aload_1
    //   717: ldc_w 800
    //   720: iconst_0
    //   721: anewarray 4	java/lang/Object
    //   724: invokestatic 804	com/tencent/mm/sdk/platformtools/Log:printErrStackTrace	(Ljava/lang/String;Ljava/lang/Throwable;Ljava/lang/String;[Ljava/lang/Object;)V
    //   727: ldc_w 699
    //   730: invokestatic 81	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   733: return
    //   734: ldc_w 699
    //   737: invokestatic 81	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   740: return
    //   741: bipush 41
    //   743: istore_2
    //   744: goto -246 -> 498
    //   747: bipush 40
    //   749: istore_2
    //   750: goto -252 -> 498
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	753	0	this	g
    //   0	753	1	paramContext	Context
    //   497	253	2	i	int
    //   39	658	3	bool	boolean
    //   154	13	4	localIntent	android.content.Intent
    //   317	11	4	localObject1	Object
    //   379	205	4	localObject2	Object
    // Exception table:
    //   from	to	target	type
    //   12	38	192	finally
    //   40	77	192	finally
    //   81	111	192	finally
    //   165	185	208	java/lang/Exception
    //   236	248	301	finally
    //   261	292	317	finally
    //   292	294	317	finally
    //   440	460	538	java/lang/Exception
    //   472	479	538	java/lang/Exception
    //   479	495	538	java/lang/Exception
    //   498	531	538	java/lang/Exception
    //   531	537	538	java/lang/Exception
    //   595	610	538	java/lang/Exception
    //   610	630	538	java/lang/Exception
    //   633	653	538	java/lang/Exception
    //   656	666	538	java/lang/Exception
    //   672	682	538	java/lang/Exception
    //   688	696	538	java/lang/Exception
    //   713	727	538	java/lang/Exception
    //   357	369	566	finally
    //   384	415	582	finally
    //   415	418	582	finally
    //   460	472	594	finally
    //   479	495	712	java/lang/Throwable
    //   498	531	712	java/lang/Throwable
    //   610	630	712	java/lang/Throwable
    //   633	653	712	java/lang/Throwable
    //   656	666	712	java/lang/Throwable
    //   672	682	712	java/lang/Throwable
    //   688	696	712	java/lang/Throwable
  }
  
  public void onServiceConnected(final ComponentName paramComponentName, final IBinder paramIBinder)
  {
    AppMethodBeat.i(131774);
    Log.w("MicroMsg.CoreServiceConnection", "onServiceConnected ");
    gL(fcl);
    if (com.tencent.mm.booter.c.aqw())
    {
      if (paramIBinder == null)
      {
        Log.w("MicroMsg.CoreServiceConnection", "onServiceConnected binder == null");
        AppMethodBeat.o(131774);
        return;
      }
      if (!((com.tencent.mm.kernel.b.h)com.tencent.mm.kernel.h.aHD().aHf()).aIE()) {
        break label274;
      }
      synchronized (lock)
      {
        Log.i("MicroMsg.CoreServiceConnection", "remove zombie killer.");
        aaG();
        fcg = false;
      }
      try
      {
        this.fch.lock();
        this.fci = false;
        if ((this.fcj != null) && (Util.isEqual(this.fcj.hashCode(), paramIBinder.hashCode())))
        {
          Log.w("MicroMsg.CoreServiceConnection", "onServiceConnected binder == serviceBinder");
          return;
          paramComponentName = finally;
          AppMethodBeat.o(131774);
          throw paramComponentName;
        }
        this.fcj = paramIBinder;
        this.fch.unlock();
        b.aqa().arrange(new Runnable()
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
        this.fch.unlock();
        AppMethodBeat.o(131774);
      }
    }
    label274:
    synchronized (lock)
    {
      Log.i("MicroMsg.CoreServiceConnection", "remove zombie killer.");
      aaG();
      fcg = false;
    }
  }
  
  public void onServiceDisconnected(final ComponentName paramComponentName)
  {
    AppMethodBeat.i(131775);
    Log.w("MicroMsg.CoreServiceConnection", "onServiceDisconnected ");
    if (((com.tencent.mm.kernel.b.h)com.tencent.mm.kernel.h.aHD().aHf()).aIE()) {}
    try
    {
      this.fch.lock();
      this.fci = false;
      this.fcj = null;
      this.fch.unlock();
      b.aqa().arrange(new Runnable()
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
      this.fch.unlock();
      AppMethodBeat.o(131775);
    }
  }
  
  final class a
    implements Runnable
  {
    int fcr = 0;
    
    a() {}
    
    /* Error */
    public final void run()
    {
      // Byte code:
      //   0: ldc 27
      //   2: invokestatic 33	com/tencent/matrix/trace/core/AppMethodBeat:i	(I)V
      //   5: aload_0
      //   6: getfield 17	com/tencent/mm/app/g$a:fco	Lcom/tencent/mm/app/g;
      //   9: invokestatic 37	com/tencent/mm/app/g:b	(Lcom/tencent/mm/app/g;)Ljava/util/concurrent/locks/ReentrantLock;
      //   12: invokevirtual 42	java/util/concurrent/locks/ReentrantLock:lock	()V
      //   15: aload_0
      //   16: getfield 17	com/tencent/mm/app/g$a:fco	Lcom/tencent/mm/app/g;
      //   19: invokestatic 46	com/tencent/mm/app/g:c	(Lcom/tencent/mm/app/g;)Landroid/os/IBinder;
      //   22: ifnull +75 -> 97
      //   25: aload_0
      //   26: getfield 17	com/tencent/mm/app/g$a:fco	Lcom/tencent/mm/app/g;
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
      //   53: getfield 17	com/tencent/mm/app/g$a:fco	Lcom/tencent/mm/app/g;
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
      //   82: getfield 17	com/tencent/mm/app/g$a:fco	Lcom/tencent/mm/app/g;
      //   85: invokestatic 37	com/tencent/mm/app/g:b	(Lcom/tencent/mm/app/g;)Ljava/util/concurrent/locks/ReentrantLock;
      //   88: invokevirtual 76	java/util/concurrent/locks/ReentrantLock:unlock	()V
      //   91: ldc 27
      //   93: invokestatic 79	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
      //   96: return
      //   97: iconst_0
      //   98: istore_2
      //   99: goto -57 -> 42
      //   102: aload_0
      //   103: getfield 17	com/tencent/mm/app/g$a:fco	Lcom/tencent/mm/app/g;
      //   106: invokestatic 37	com/tencent/mm/app/g:b	(Lcom/tencent/mm/app/g;)Ljava/util/concurrent/locks/ReentrantLock;
      //   109: invokevirtual 76	java/util/concurrent/locks/ReentrantLock:unlock	()V
      //   112: ldc 54
      //   114: ldc 81
      //   116: iconst_1
      //   117: anewarray 4	java/lang/Object
      //   120: dup
      //   121: iconst_0
      //   122: aload_0
      //   123: getfield 22	com/tencent/mm/app/g$a:fcr	I
      //   126: invokestatic 86	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
      //   129: aastore
      //   130: invokestatic 92	java/lang/String:format	(Ljava/lang/String;[Ljava/lang/Object;)Ljava/lang/String;
      //   133: invokestatic 95	com/tencent/mm/sdk/platformtools/Log:e	(Ljava/lang/String;Ljava/lang/String;)V
      //   136: aload_0
      //   137: getfield 22	com/tencent/mm/app/g$a:fcr	I
      //   140: iconst_1
      //   141: if_icmpne +43 -> 184
      //   144: invokestatic 99	com/tencent/mm/app/g:access$400	()Ljava/lang/String;
      //   147: invokestatic 103	com/tencent/mm/app/g:gL	(Ljava/lang/String;)I
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
      //   181: invokestatic 113	com/tencent/mm/app/g:jZ	(I)V
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
      //   209: getfield 17	com/tencent/mm/app/g$a:fco	Lcom/tencent/mm/app/g;
      //   212: invokevirtual 134	android/content/Context:unbindService	(Landroid/content/ServiceConnection;)V
      //   215: invokestatic 139	com/tencent/mm/booter/c:aqw	()Z
      //   218: ifeq +95 -> 313
      //   221: aload_3
      //   222: aload 4
      //   224: aload_0
      //   225: getfield 17	com/tencent/mm/app/g$a:fco	Lcom/tencent/mm/app/g;
      //   228: iconst_1
      //   229: invokevirtual 143	android/content/Context:bindService	(Landroid/content/Intent;Landroid/content/ServiceConnection;I)Z
      //   232: pop
      //   233: aload_0
      //   234: getfield 22	com/tencent/mm/app/g$a:fcr	I
      //   237: iconst_1
      //   238: if_icmpne +279 -> 517
      //   241: aload_0
      //   242: iconst_0
      //   243: putfield 22	com/tencent/mm/app/g$a:fcr	I
      //   246: aload_0
      //   247: iconst_1
      //   248: invokestatic 147	com/tencent/mm/app/g:dh	(Z)I
      //   251: i2l
      //   252: invokestatic 153	com/tencent/mm/sdk/platformtools/MMHandlerThread:postToMainThreadDelayed	(Ljava/lang/Runnable;J)V
      //   255: ldc 54
      //   257: ldc 155
      //   259: iconst_1
      //   260: anewarray 4	java/lang/Object
      //   263: dup
      //   264: iconst_0
      //   265: aload_0
      //   266: getfield 22	com/tencent/mm/app/g$a:fcr	I
      //   269: invokestatic 86	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
      //   272: aastore
      //   273: invokestatic 92	java/lang/String:format	(Ljava/lang/String;[Ljava/lang/Object;)Ljava/lang/String;
      //   276: invokestatic 107	com/tencent/mm/sdk/platformtools/Log:i	(Ljava/lang/String;Ljava/lang/String;)V
      //   279: ldc 27
      //   281: invokestatic 79	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
      //   284: return
      //   285: astore_3
      //   286: aload_0
      //   287: getfield 17	com/tencent/mm/app/g$a:fco	Lcom/tencent/mm/app/g;
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
      //   324: getfield 17	com/tencent/mm/app/g$a:fco	Lcom/tencent/mm/app/g;
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
      //   366: invokestatic 139	com/tencent/mm/booter/c:aqw	()Z
      //   369: ifeq +40 -> 409
      //   372: aload_3
      //   373: aload 4
      //   375: aload_0
      //   376: getfield 17	com/tencent/mm/app/g$a:fco	Lcom/tencent/mm/app/g;
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
      //   420: getfield 17	com/tencent/mm/app/g$a:fco	Lcom/tencent/mm/app/g;
      //   423: iconst_1
      //   424: invokevirtual 143	android/content/Context:bindService	(Landroid/content/Intent;Landroid/content/ServiceConnection;I)Z
      //   427: pop
      //   428: aload_3
      //   429: aload 4
      //   431: invokevirtual 165	android/content/Context:startService	(Landroid/content/Intent;)Landroid/content/ComponentName;
      //   434: pop
      //   435: goto -202 -> 233
      //   438: astore 5
      //   440: invokestatic 139	com/tencent/mm/booter/c:aqw	()Z
      //   443: ifeq +23 -> 466
      //   446: aload_3
      //   447: aload 4
      //   449: aload_0
      //   450: getfield 17	com/tencent/mm/app/g$a:fco	Lcom/tencent/mm/app/g;
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
      //   477: getfield 17	com/tencent/mm/app/g$a:fco	Lcom/tencent/mm/app/g;
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
      //   519: getfield 22	com/tencent/mm/app/g$a:fcr	I
      //   522: iconst_1
      //   523: iadd
      //   524: putfield 22	com/tencent/mm/app/g$a:fcr	I
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


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.app.g
 * JD-Core Version:    0.7.0.1
 */