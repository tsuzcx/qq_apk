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
import com.tencent.mm.kernel.g;
import com.tencent.mm.sdk.platformtools.ab;
import com.tencent.mm.sdk.platformtools.ah;
import com.tencent.mm.sdk.platformtools.al;
import com.tencent.mm.sdk.platformtools.bo;
import java.util.Iterator;
import java.util.List;
import java.util.concurrent.locks.ReentrantLock;

public final class e
  implements ServiceConnection
{
  private static boolean bXI;
  private static Object lock;
  private ReentrantLock bXJ;
  private boolean bXK;
  private IBinder bXL;
  private Runnable bXM;
  
  static
  {
    AppMethodBeat.i(57676);
    bXI = false;
    lock = new Object();
    AppMethodBeat.o(57676);
  }
  
  public e()
  {
    AppMethodBeat.i(57667);
    this.bXJ = new ReentrantLock();
    this.bXK = false;
    this.bXL = null;
    this.bXM = new e.6(this);
    AppMethodBeat.o(57667);
  }
  
  public static void Bb()
  {
    AppMethodBeat.i(57672);
    ab.e("MicroMsg.CoreServiceConnection", "killPushProcess() pid = %s, stack[%s]", new Object[] { Integer.valueOf(dv("com.tencent.mm:push")), bo.dtY() });
    Process.killProcess(dv("com.tencent.mm:push"));
    AppMethodBeat.o(57672);
  }
  
  public static int dv(String paramString)
  {
    AppMethodBeat.i(57671);
    if (bo.isNullOrNil(paramString))
    {
      ab.i("MicroMsg.CoreServiceConnection", "getPicByProcessName() processName == null");
      AppMethodBeat.o(57671);
      return -1;
    }
    for (;;)
    {
      try
      {
        Object localObject = ((ActivityManager)ah.getContext().getSystemService("activity")).getRunningAppProcesses();
        if (localObject == null)
        {
          ab.i("MicroMsg.CoreServiceConnection", "getPicByProcessName() processes == null");
          AppMethodBeat.o(57671);
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
        ab.e("MicroMsg.CoreServiceConnection", "getPidByProcessName() %s %s %s", new Object[] { paramString, localException.getClass().getSimpleName(), localException.getMessage() });
        int i = -1;
        continue;
      }
      AppMethodBeat.o(57671);
      return i;
      i = -1;
    }
  }
  
  /* Error */
  public final void aZ(Context paramContext)
  {
    // Byte code:
    //   0: ldc_w 616
    //   3: invokestatic 26	com/tencent/matrix/trace/core/AppMethodBeat:i	(I)V
    //   6: ldc_w 618
    //   9: invokestatic 157	com/tencent/mm/blink/a:ks	(Ljava/lang/String;)V
    //   12: aload_0
    //   13: getfield 43	com/tencent/mm/app/e:bXJ	Ljava/util/concurrent/locks/ReentrantLock;
    //   16: invokevirtual 620	java/util/concurrent/locks/ReentrantLock:lock	()V
    //   19: aload_0
    //   20: getfield 47	com/tencent/mm/app/e:bXL	Landroid/os/IBinder;
    //   23: ifnull +100 -> 123
    //   26: aload_0
    //   27: getfield 47	com/tencent/mm/app/e:bXL	Landroid/os/IBinder;
    //   30: invokeinterface 625 1 0
    //   35: ifeq +88 -> 123
    //   38: iconst_1
    //   39: istore_2
    //   40: ldc 58
    //   42: ldc_w 627
    //   45: iconst_2
    //   46: anewarray 4	java/lang/Object
    //   49: dup
    //   50: iconst_0
    //   51: aload_0
    //   52: getfield 45	com/tencent/mm/app/e:bXK	Z
    //   55: invokestatic 420	java/lang/Boolean:valueOf	(Z)Ljava/lang/Boolean;
    //   58: aastore
    //   59: dup
    //   60: iconst_1
    //   61: iload_2
    //   62: invokestatic 420	java/lang/Boolean:valueOf	(Z)Ljava/lang/Boolean;
    //   65: aastore
    //   66: invokestatic 461	com/tencent/mm/sdk/platformtools/ab:i	(Ljava/lang/String;Ljava/lang/String;[Ljava/lang/Object;)V
    //   69: aload_0
    //   70: getfield 45	com/tencent/mm/app/e:bXK	Z
    //   73: ifne +7 -> 80
    //   76: iload_2
    //   77: ifeq +51 -> 128
    //   80: ldc 58
    //   82: ldc_w 629
    //   85: iconst_2
    //   86: anewarray 4	java/lang/Object
    //   89: dup
    //   90: iconst_0
    //   91: aload_0
    //   92: getfield 45	com/tencent/mm/app/e:bXK	Z
    //   95: invokestatic 420	java/lang/Boolean:valueOf	(Z)Ljava/lang/Boolean;
    //   98: aastore
    //   99: dup
    //   100: iconst_1
    //   101: iload_2
    //   102: invokestatic 420	java/lang/Boolean:valueOf	(Z)Ljava/lang/Boolean;
    //   105: aastore
    //   106: invokestatic 422	com/tencent/mm/sdk/platformtools/ab:w	(Ljava/lang/String;Ljava/lang/String;[Ljava/lang/Object;)V
    //   109: aload_0
    //   110: getfield 43	com/tencent/mm/app/e:bXJ	Ljava/util/concurrent/locks/ReentrantLock;
    //   113: invokevirtual 632	java/util/concurrent/locks/ReentrantLock:unlock	()V
    //   116: ldc_w 616
    //   119: invokestatic 36	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   122: return
    //   123: iconst_0
    //   124: istore_2
    //   125: goto -85 -> 40
    //   128: aload_0
    //   129: getfield 43	com/tencent/mm/app/e:bXJ	Ljava/util/concurrent/locks/ReentrantLock;
    //   132: invokevirtual 632	java/util/concurrent/locks/ReentrantLock:unlock	()V
    //   135: invokestatic 637	com/tencent/mm/booter/c:Ii	()Z
    //   138: ifeq +180 -> 318
    //   141: new 639	android/content/Intent
    //   144: dup
    //   145: aload_1
    //   146: ldc_w 641
    //   149: invokespecial 644	android/content/Intent:<init>	(Landroid/content/Context;Ljava/lang/Class;)V
    //   152: astore_3
    //   153: ldc 58
    //   155: ldc_w 646
    //   158: invokestatic 557	com/tencent/mm/sdk/platformtools/ab:i	(Ljava/lang/String;Ljava/lang/String;)V
    //   161: aload_1
    //   162: aload_3
    //   163: aload_0
    //   164: iconst_1
    //   165: invokevirtual 650	android/content/Context:bindService	(Landroid/content/Intent;Landroid/content/ServiceConnection;I)Z
    //   168: ifne +61 -> 229
    //   171: ldc 58
    //   173: ldc_w 652
    //   176: invokestatic 290	com/tencent/mm/sdk/platformtools/ab:e	(Ljava/lang/String;Ljava/lang/String;)V
    //   179: ldc_w 616
    //   182: invokestatic 36	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   185: return
    //   186: astore_1
    //   187: aload_0
    //   188: getfield 43	com/tencent/mm/app/e:bXJ	Ljava/util/concurrent/locks/ReentrantLock;
    //   191: invokevirtual 632	java/util/concurrent/locks/ReentrantLock:unlock	()V
    //   194: ldc_w 616
    //   197: invokestatic 36	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   200: aload_1
    //   201: athrow
    //   202: astore_1
    //   203: ldc 58
    //   205: ldc_w 654
    //   208: iconst_1
    //   209: anewarray 4	java/lang/Object
    //   212: dup
    //   213: iconst_0
    //   214: aload_1
    //   215: invokevirtual 615	java/lang/Exception:getMessage	()Ljava/lang/String;
    //   218: aastore
    //   219: invokestatic 84	com/tencent/mm/sdk/platformtools/ab:e	(Ljava/lang/String;Ljava/lang/String;[Ljava/lang/Object;)V
    //   222: ldc_w 616
    //   225: invokestatic 36	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   228: return
    //   229: aload_0
    //   230: getfield 43	com/tencent/mm/app/e:bXJ	Ljava/util/concurrent/locks/ReentrantLock;
    //   233: invokevirtual 620	java/util/concurrent/locks/ReentrantLock:lock	()V
    //   236: aload_0
    //   237: iconst_1
    //   238: putfield 45	com/tencent/mm/app/e:bXK	Z
    //   241: aload_0
    //   242: getfield 43	com/tencent/mm/app/e:bXJ	Ljava/util/concurrent/locks/ReentrantLock;
    //   245: invokevirtual 632	java/util/concurrent/locks/ReentrantLock:unlock	()V
    //   248: getstatic 33	com/tencent/mm/app/e:lock	Ljava/lang/Object;
    //   251: astore_1
    //   252: aload_1
    //   253: monitorenter
    //   254: getstatic 28	com/tencent/mm/app/e:bXI	Z
    //   257: ifne +25 -> 282
    //   260: iconst_1
    //   261: putstatic 28	com/tencent/mm/app/e:bXI	Z
    //   264: ldc 58
    //   266: ldc_w 656
    //   269: invokestatic 557	com/tencent/mm/sdk/platformtools/ab:i	(Ljava/lang/String;Ljava/lang/String;)V
    //   272: aload_0
    //   273: getfield 54	com/tencent/mm/app/e:bXM	Ljava/lang/Runnable;
    //   276: ldc2_w 657
    //   279: invokestatic 664	com/tencent/mm/sdk/platformtools/al:p	(Ljava/lang/Runnable;J)V
    //   282: aload_1
    //   283: monitorexit
    //   284: ldc_w 616
    //   287: invokestatic 36	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   290: return
    //   291: astore_1
    //   292: aload_0
    //   293: getfield 43	com/tencent/mm/app/e:bXJ	Ljava/util/concurrent/locks/ReentrantLock;
    //   296: invokevirtual 632	java/util/concurrent/locks/ReentrantLock:unlock	()V
    //   299: ldc_w 616
    //   302: invokestatic 36	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   305: aload_1
    //   306: athrow
    //   307: astore_3
    //   308: aload_1
    //   309: monitorexit
    //   310: ldc_w 616
    //   313: invokestatic 36	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   316: aload_3
    //   317: athrow
    //   318: aload_1
    //   319: ldc_w 666
    //   322: iconst_0
    //   323: invokestatic 671	com/tencent/mm/booter/b:c	(Landroid/content/Context;Ljava/lang/String;Z)Z
    //   326: ifne +18 -> 344
    //   329: ldc 58
    //   331: ldc_w 673
    //   334: invokestatic 557	com/tencent/mm/sdk/platformtools/ab:i	(Ljava/lang/String;Ljava/lang/String;)V
    //   337: ldc_w 616
    //   340: invokestatic 36	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   343: return
    //   344: aload_0
    //   345: getfield 43	com/tencent/mm/app/e:bXJ	Ljava/util/concurrent/locks/ReentrantLock;
    //   348: invokevirtual 620	java/util/concurrent/locks/ReentrantLock:lock	()V
    //   351: aload_0
    //   352: iconst_1
    //   353: putfield 45	com/tencent/mm/app/e:bXK	Z
    //   356: aload_0
    //   357: getfield 43	com/tencent/mm/app/e:bXJ	Ljava/util/concurrent/locks/ReentrantLock;
    //   360: invokevirtual 632	java/util/concurrent/locks/ReentrantLock:unlock	()V
    //   363: getstatic 33	com/tencent/mm/app/e:lock	Ljava/lang/Object;
    //   366: astore_3
    //   367: aload_3
    //   368: monitorenter
    //   369: getstatic 28	com/tencent/mm/app/e:bXI	Z
    //   372: ifne +25 -> 397
    //   375: iconst_1
    //   376: putstatic 28	com/tencent/mm/app/e:bXI	Z
    //   379: ldc 58
    //   381: ldc_w 656
    //   384: invokestatic 557	com/tencent/mm/sdk/platformtools/ab:i	(Ljava/lang/String;Ljava/lang/String;)V
    //   387: aload_0
    //   388: getfield 54	com/tencent/mm/app/e:bXM	Ljava/lang/Runnable;
    //   391: ldc2_w 674
    //   394: invokestatic 664	com/tencent/mm/sdk/platformtools/al:p	(Ljava/lang/Runnable;J)V
    //   397: aload_3
    //   398: monitorexit
    //   399: new 639	android/content/Intent
    //   402: dup
    //   403: aload_1
    //   404: ldc_w 641
    //   407: invokespecial 644	android/content/Intent:<init>	(Landroid/content/Context;Ljava/lang/Class;)V
    //   410: astore_3
    //   411: ldc 58
    //   413: ldc_w 646
    //   416: invokestatic 557	com/tencent/mm/sdk/platformtools/ab:i	(Ljava/lang/String;Ljava/lang/String;)V
    //   419: aload_1
    //   420: aload_3
    //   421: aload_0
    //   422: iconst_1
    //   423: invokevirtual 650	android/content/Context:bindService	(Landroid/content/Intent;Landroid/content/ServiceConnection;I)Z
    //   426: ifne +45 -> 471
    //   429: ldc 58
    //   431: ldc_w 652
    //   434: invokestatic 290	com/tencent/mm/sdk/platformtools/ab:e	(Ljava/lang/String;Ljava/lang/String;)V
    //   437: ldc_w 616
    //   440: invokestatic 36	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   443: return
    //   444: astore_1
    //   445: aload_0
    //   446: getfield 43	com/tencent/mm/app/e:bXJ	Ljava/util/concurrent/locks/ReentrantLock;
    //   449: invokevirtual 632	java/util/concurrent/locks/ReentrantLock:unlock	()V
    //   452: ldc_w 616
    //   455: invokestatic 36	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   458: aload_1
    //   459: athrow
    //   460: astore_1
    //   461: aload_3
    //   462: monitorexit
    //   463: ldc_w 616
    //   466: invokestatic 36	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   469: aload_1
    //   470: athrow
    //   471: ldc_w 616
    //   474: invokestatic 36	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   477: return
    //   478: astore_1
    //   479: ldc 58
    //   481: ldc_w 677
    //   484: iconst_1
    //   485: anewarray 4	java/lang/Object
    //   488: dup
    //   489: iconst_0
    //   490: aload_1
    //   491: invokevirtual 615	java/lang/Exception:getMessage	()Ljava/lang/String;
    //   494: aastore
    //   495: invokestatic 84	com/tencent/mm/sdk/platformtools/ab:e	(Ljava/lang/String;Ljava/lang/String;[Ljava/lang/Object;)V
    //   498: ldc_w 616
    //   501: invokestatic 36	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   504: return
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	505	0	this	e
    //   0	505	1	paramContext	Context
    //   39	86	2	bool	boolean
    //   152	11	3	localIntent	android.content.Intent
    //   307	10	3	localObject1	Object
    // Exception table:
    //   from	to	target	type
    //   12	38	186	finally
    //   40	76	186	finally
    //   80	109	186	finally
    //   161	179	202	java/lang/Exception
    //   229	241	291	finally
    //   254	282	307	finally
    //   282	284	307	finally
    //   308	310	307	finally
    //   344	356	444	finally
    //   369	397	460	finally
    //   397	399	460	finally
    //   461	463	460	finally
    //   419	437	478	java/lang/Exception
  }
  
  public final void onServiceConnected(ComponentName paramComponentName, IBinder paramIBinder)
  {
    AppMethodBeat.i(57668);
    ab.w("MicroMsg.CoreServiceConnection", "onServiceConnected ");
    dv("com.tencent.mm:push");
    if (c.Ii())
    {
      if (paramIBinder == null)
      {
        ab.w("MicroMsg.CoreServiceConnection", "onServiceConnected binder == null");
        AppMethodBeat.o(57668);
        return;
      }
      if (!((h)g.RI().Rj()).SD()) {
        break label274;
      }
      synchronized (lock)
      {
        ab.i("MicroMsg.CoreServiceConnection", "remove zombie killer.");
        al.ae(this.bXM);
        bXI = false;
      }
      try
      {
        this.bXJ.lock();
        this.bXK = false;
        if ((this.bXL != null) && (bo.hl(this.bXL.hashCode(), paramIBinder.hashCode())))
        {
          ab.w("MicroMsg.CoreServiceConnection", "onServiceConnected binder == serviceBinder");
          return;
          paramComponentName = finally;
          AppMethodBeat.o(57668);
          throw paramComponentName;
        }
        this.bXL = paramIBinder;
        this.bXJ.unlock();
        b.HP().o(new e.1(this, paramComponentName, paramIBinder));
        AppMethodBeat.o(57668);
        return;
      }
      finally
      {
        this.bXJ.unlock();
        AppMethodBeat.o(57668);
      }
    }
    label274:
    synchronized (lock)
    {
      ab.i("MicroMsg.CoreServiceConnection", "remove zombie killer.");
      al.ae(this.bXM);
      bXI = false;
    }
  }
  
  public final void onServiceDisconnected(ComponentName paramComponentName)
  {
    AppMethodBeat.i(57669);
    ab.w("MicroMsg.CoreServiceConnection", "onServiceDisconnected ");
    if (((h)g.RI().Rj()).SD()) {}
    try
    {
      this.bXJ.lock();
      this.bXK = false;
      this.bXL = null;
      this.bXJ.unlock();
      b.HP().o(new e.5(this, paramComponentName));
      AppMethodBeat.o(57669);
      return;
    }
    finally
    {
      this.bXJ.unlock();
      AppMethodBeat.o(57669);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.app.e
 * JD-Core Version:    0.7.0.1
 */