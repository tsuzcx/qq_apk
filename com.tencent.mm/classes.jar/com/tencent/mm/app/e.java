package com.tencent.mm.app;

import android.content.ComponentName;
import android.content.ServiceConnection;
import android.os.IBinder;
import com.tencent.mm.blink.b;
import com.tencent.mm.sdk.platformtools.ai;
import com.tencent.mm.sdk.platformtools.y;
import java.util.concurrent.locks.ReentrantLock;

public final class e
  implements ServiceConnection
{
  private static boolean bwd = false;
  private static Object lock = new Object();
  private ReentrantLock bwe = new ReentrantLock();
  private boolean bwf = false;
  private IBinder bwg = null;
  private Runnable bwh = new e.5(this);
  
  /* Error */
  private static int cj(java.lang.String paramString)
  {
    // Byte code:
    //   0: new 504	java/io/File
    //   3: dup
    //   4: ldc_w 506
    //   7: invokespecial 507	java/io/File:<init>	(Ljava/lang/String;)V
    //   10: invokevirtual 511	java/io/File:listFiles	()[Ljava/io/File;
    //   13: astore 9
    //   15: aload 9
    //   17: arraylength
    //   18: istore_2
    //   19: iconst_0
    //   20: istore_1
    //   21: aconst_null
    //   22: astore 7
    //   24: iload_1
    //   25: iload_2
    //   26: if_icmpge +351 -> 377
    //   29: aload 9
    //   31: iload_1
    //   32: aaload
    //   33: astore 8
    //   35: aload 8
    //   37: invokevirtual 514	java/io/File:getName	()Ljava/lang/String;
    //   40: iconst_m1
    //   41: invokestatic 518	com/tencent/mm/sdk/platformtools/bk:getInt	(Ljava/lang/String;I)I
    //   44: istore_3
    //   45: aload 7
    //   47: astore 6
    //   49: new 504	java/io/File
    //   52: dup
    //   53: aload 8
    //   55: ldc_w 520
    //   58: invokespecial 523	java/io/File:<init>	(Ljava/io/File;Ljava/lang/String;)V
    //   61: astore 8
    //   63: aload 7
    //   65: astore 6
    //   67: aload 8
    //   69: invokevirtual 526	java/io/File:canRead	()Z
    //   72: istore 5
    //   74: iload 5
    //   76: ifne +31 -> 107
    //   79: aload 7
    //   81: astore 6
    //   83: aload 7
    //   85: ifnull +11 -> 96
    //   88: aload 7
    //   90: invokevirtual 531	java/io/BufferedReader:close	()V
    //   93: aconst_null
    //   94: astore 6
    //   96: iload_1
    //   97: iconst_1
    //   98: iadd
    //   99: istore_1
    //   100: aload 6
    //   102: astore 7
    //   104: goto -80 -> 24
    //   107: aload 7
    //   109: astore 6
    //   111: new 528	java/io/BufferedReader
    //   114: dup
    //   115: new 533	java/io/FileReader
    //   118: dup
    //   119: aload 8
    //   121: invokespecial 536	java/io/FileReader:<init>	(Ljava/io/File;)V
    //   124: invokespecial 539	java/io/BufferedReader:<init>	(Ljava/io/Reader;)V
    //   127: astore 8
    //   129: aload 8
    //   131: invokevirtual 542	java/io/BufferedReader:readLine	()Ljava/lang/String;
    //   134: astore 6
    //   136: aload 6
    //   138: ifnull +117 -> 255
    //   141: aload 6
    //   143: aload_0
    //   144: invokevirtual 546	java/lang/String:startsWith	(Ljava/lang/String;)Z
    //   147: ifeq +108 -> 255
    //   150: aload 6
    //   152: invokevirtual 549	java/lang/String:length	()I
    //   155: aload_0
    //   156: invokevirtual 549	java/lang/String:length	()I
    //   159: if_icmpne +37 -> 196
    //   162: ldc_w 551
    //   165: ldc_w 553
    //   168: iconst_2
    //   169: anewarray 4	java/lang/Object
    //   172: dup
    //   173: iconst_0
    //   174: aload_0
    //   175: aastore
    //   176: dup
    //   177: iconst_1
    //   178: iconst_m1
    //   179: invokestatic 331	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
    //   182: aastore
    //   183: invokestatic 413	com/tencent/mm/sdk/platformtools/y:i	(Ljava/lang/String;Ljava/lang/String;[Ljava/lang/Object;)V
    //   186: aload 8
    //   188: invokevirtual 531	java/io/BufferedReader:close	()V
    //   191: iload_3
    //   192: ireturn
    //   193: astore_0
    //   194: iload_3
    //   195: ireturn
    //   196: aload 6
    //   198: aload_0
    //   199: invokevirtual 549	java/lang/String:length	()I
    //   202: invokevirtual 557	java/lang/String:charAt	(I)C
    //   205: istore 4
    //   207: iload 4
    //   209: bipush 32
    //   211: if_icmple +10 -> 221
    //   214: iload 4
    //   216: bipush 127
    //   218: if_icmplt +37 -> 255
    //   221: ldc_w 551
    //   224: ldc_w 553
    //   227: iconst_2
    //   228: anewarray 4	java/lang/Object
    //   231: dup
    //   232: iconst_0
    //   233: aload_0
    //   234: aastore
    //   235: dup
    //   236: iconst_1
    //   237: iconst_m1
    //   238: invokestatic 331	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
    //   241: aastore
    //   242: invokestatic 413	com/tencent/mm/sdk/platformtools/y:i	(Ljava/lang/String;Ljava/lang/String;[Ljava/lang/Object;)V
    //   245: aload 8
    //   247: invokevirtual 531	java/io/BufferedReader:close	()V
    //   250: iload_3
    //   251: ireturn
    //   252: astore_0
    //   253: iload_3
    //   254: ireturn
    //   255: aload 8
    //   257: invokevirtual 531	java/io/BufferedReader:close	()V
    //   260: aconst_null
    //   261: astore 6
    //   263: goto -167 -> 96
    //   266: astore 6
    //   268: aload 8
    //   270: astore 7
    //   272: aload 6
    //   274: astore 8
    //   276: aload 7
    //   278: astore 6
    //   280: ldc_w 551
    //   283: aload 8
    //   285: ldc_w 559
    //   288: iconst_0
    //   289: anewarray 4	java/lang/Object
    //   292: invokestatic 563	com/tencent/mm/sdk/platformtools/y:printErrStackTrace	(Ljava/lang/String;Ljava/lang/Throwable;Ljava/lang/String;[Ljava/lang/Object;)V
    //   295: aload 7
    //   297: astore 6
    //   299: invokestatic 566	com/tencent/mm/sdk/platformtools/y:cqL	()V
    //   302: aload 7
    //   304: astore 6
    //   306: aload 7
    //   308: ifnull -212 -> 96
    //   311: aload 7
    //   313: invokevirtual 531	java/io/BufferedReader:close	()V
    //   316: aconst_null
    //   317: astore 6
    //   319: goto -223 -> 96
    //   322: astore_0
    //   323: aload 8
    //   325: ifnull +8 -> 333
    //   328: aload 8
    //   330: invokevirtual 531	java/io/BufferedReader:close	()V
    //   333: aload_0
    //   334: athrow
    //   335: astore 6
    //   337: goto -244 -> 93
    //   340: astore 6
    //   342: goto -82 -> 260
    //   345: astore 6
    //   347: goto -31 -> 316
    //   350: astore 6
    //   352: goto -19 -> 333
    //   355: astore_0
    //   356: aload 6
    //   358: astore 8
    //   360: goto -37 -> 323
    //   363: astore 8
    //   365: goto -89 -> 276
    //   368: astore 6
    //   370: aload 7
    //   372: astore 6
    //   374: goto -278 -> 96
    //   377: iconst_m1
    //   378: ireturn
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	379	0	paramString	java.lang.String
    //   20	80	1	i	int
    //   18	9	2	j	int
    //   44	210	3	k	int
    //   205	14	4	m	int
    //   72	3	5	bool	boolean
    //   47	215	6	localObject1	Object
    //   266	7	6	localThrowable1	java.lang.Throwable
    //   278	40	6	localObject2	Object
    //   335	1	6	localThrowable2	java.lang.Throwable
    //   340	1	6	localThrowable3	java.lang.Throwable
    //   345	1	6	localThrowable4	java.lang.Throwable
    //   350	7	6	localThrowable5	java.lang.Throwable
    //   368	1	6	localThrowable6	java.lang.Throwable
    //   372	1	6	localObject3	Object
    //   22	349	7	localObject4	Object
    //   33	326	8	localObject5	Object
    //   363	1	8	localThrowable7	java.lang.Throwable
    //   13	17	9	arrayOfFile	java.io.File[]
    // Exception table:
    //   from	to	target	type
    //   186	191	193	java/lang/Throwable
    //   245	250	252	java/lang/Throwable
    //   129	136	266	java/lang/Throwable
    //   141	186	266	java/lang/Throwable
    //   196	207	266	java/lang/Throwable
    //   221	245	266	java/lang/Throwable
    //   129	136	322	finally
    //   141	186	322	finally
    //   196	207	322	finally
    //   221	245	322	finally
    //   88	93	335	java/lang/Throwable
    //   255	260	340	java/lang/Throwable
    //   311	316	345	java/lang/Throwable
    //   328	333	350	java/lang/Throwable
    //   49	63	355	finally
    //   67	74	355	finally
    //   111	129	355	finally
    //   280	295	355	finally
    //   299	302	355	finally
    //   49	63	363	java/lang/Throwable
    //   67	74	363	java/lang/Throwable
    //   111	129	363	java/lang/Throwable
    //   35	45	368	java/lang/Throwable
  }
  
  /* Error */
  public final void aB(android.content.Context paramContext)
  {
    // Byte code:
    //   0: iconst_0
    //   1: istore_3
    //   2: ldc_w 571
    //   5: invokestatic 109	com/tencent/mm/blink/a:el	(Ljava/lang/String;)V
    //   8: aload_0
    //   9: getfield 32	com/tencent/mm/app/e:bwe	Ljava/util/concurrent/locks/ReentrantLock;
    //   12: invokevirtual 573	java/util/concurrent/locks/ReentrantLock:lock	()V
    //   15: iload_3
    //   16: istore_2
    //   17: aload_0
    //   18: getfield 36	com/tencent/mm/app/e:bwg	Landroid/os/IBinder;
    //   21: ifnull +19 -> 40
    //   24: iload_3
    //   25: istore_2
    //   26: aload_0
    //   27: getfield 36	com/tencent/mm/app/e:bwg	Landroid/os/IBinder;
    //   30: invokeinterface 578 1 0
    //   35: ifeq +5 -> 40
    //   38: iconst_1
    //   39: istore_2
    //   40: ldc_w 551
    //   43: ldc_w 580
    //   46: iconst_2
    //   47: anewarray 4	java/lang/Object
    //   50: dup
    //   51: iconst_0
    //   52: aload_0
    //   53: getfield 34	com/tencent/mm/app/e:bwf	Z
    //   56: invokestatic 370	java/lang/Boolean:valueOf	(Z)Ljava/lang/Boolean;
    //   59: aastore
    //   60: dup
    //   61: iconst_1
    //   62: iload_2
    //   63: invokestatic 370	java/lang/Boolean:valueOf	(Z)Ljava/lang/Boolean;
    //   66: aastore
    //   67: invokestatic 413	com/tencent/mm/sdk/platformtools/y:i	(Ljava/lang/String;Ljava/lang/String;[Ljava/lang/Object;)V
    //   70: aload_0
    //   71: getfield 34	com/tencent/mm/app/e:bwf	Z
    //   74: ifne +7 -> 81
    //   77: iload_2
    //   78: ifeq +41 -> 119
    //   81: ldc_w 551
    //   84: ldc_w 582
    //   87: iconst_2
    //   88: anewarray 4	java/lang/Object
    //   91: dup
    //   92: iconst_0
    //   93: aload_0
    //   94: getfield 34	com/tencent/mm/app/e:bwf	Z
    //   97: invokestatic 370	java/lang/Boolean:valueOf	(Z)Ljava/lang/Boolean;
    //   100: aastore
    //   101: dup
    //   102: iconst_1
    //   103: iload_2
    //   104: invokestatic 370	java/lang/Boolean:valueOf	(Z)Ljava/lang/Boolean;
    //   107: aastore
    //   108: invokestatic 372	com/tencent/mm/sdk/platformtools/y:w	(Ljava/lang/String;Ljava/lang/String;[Ljava/lang/Object;)V
    //   111: aload_0
    //   112: getfield 32	com/tencent/mm/app/e:bwe	Ljava/util/concurrent/locks/ReentrantLock;
    //   115: invokevirtual 585	java/util/concurrent/locks/ReentrantLock:unlock	()V
    //   118: return
    //   119: aload_0
    //   120: getfield 32	com/tencent/mm/app/e:bwe	Ljava/util/concurrent/locks/ReentrantLock;
    //   123: invokevirtual 585	java/util/concurrent/locks/ReentrantLock:unlock	()V
    //   126: aload_1
    //   127: ldc_w 587
    //   130: invokestatic 593	com/tencent/mm/booter/b:s	(Landroid/content/Context;Ljava/lang/String;)Z
    //   133: ifne +23 -> 156
    //   136: ldc_w 551
    //   139: ldc_w 595
    //   142: invokestatic 597	com/tencent/mm/sdk/platformtools/y:i	(Ljava/lang/String;Ljava/lang/String;)V
    //   145: return
    //   146: astore_1
    //   147: aload_0
    //   148: getfield 32	com/tencent/mm/app/e:bwe	Ljava/util/concurrent/locks/ReentrantLock;
    //   151: invokevirtual 585	java/util/concurrent/locks/ReentrantLock:unlock	()V
    //   154: aload_1
    //   155: athrow
    //   156: aload_0
    //   157: getfield 32	com/tencent/mm/app/e:bwe	Ljava/util/concurrent/locks/ReentrantLock;
    //   160: invokevirtual 573	java/util/concurrent/locks/ReentrantLock:lock	()V
    //   163: aload_0
    //   164: iconst_1
    //   165: putfield 34	com/tencent/mm/app/e:bwf	Z
    //   168: aload_0
    //   169: getfield 32	com/tencent/mm/app/e:bwe	Ljava/util/concurrent/locks/ReentrantLock;
    //   172: invokevirtual 585	java/util/concurrent/locks/ReentrantLock:unlock	()V
    //   175: getstatic 26	com/tencent/mm/app/e:lock	Ljava/lang/Object;
    //   178: astore 4
    //   180: aload 4
    //   182: monitorenter
    //   183: getstatic 21	com/tencent/mm/app/e:bwd	Z
    //   186: ifne +26 -> 212
    //   189: iconst_1
    //   190: putstatic 21	com/tencent/mm/app/e:bwd	Z
    //   193: ldc_w 551
    //   196: ldc_w 599
    //   199: invokestatic 597	com/tencent/mm/sdk/platformtools/y:i	(Ljava/lang/String;Ljava/lang/String;)V
    //   202: aload_0
    //   203: getfield 43	com/tencent/mm/app/e:bwh	Ljava/lang/Runnable;
    //   206: ldc2_w 600
    //   209: invokestatic 606	com/tencent/mm/sdk/platformtools/ai:l	(Ljava/lang/Runnable;J)V
    //   212: aload 4
    //   214: monitorexit
    //   215: new 608	android/content/Intent
    //   218: dup
    //   219: aload_1
    //   220: ldc_w 610
    //   223: invokespecial 613	android/content/Intent:<init>	(Landroid/content/Context;Ljava/lang/Class;)V
    //   226: astore 4
    //   228: ldc_w 551
    //   231: ldc_w 615
    //   234: invokestatic 597	com/tencent/mm/sdk/platformtools/y:i	(Ljava/lang/String;Ljava/lang/String;)V
    //   237: aload_1
    //   238: aload 4
    //   240: aload_0
    //   241: iconst_1
    //   242: invokevirtual 621	android/content/Context:bindService	(Landroid/content/Intent;Landroid/content/ServiceConnection;I)Z
    //   245: ifne -127 -> 118
    //   248: ldc_w 551
    //   251: ldc_w 623
    //   254: invokestatic 250	com/tencent/mm/sdk/platformtools/y:e	(Ljava/lang/String;Ljava/lang/String;)V
    //   257: return
    //   258: astore_1
    //   259: aload_0
    //   260: getfield 32	com/tencent/mm/app/e:bwe	Ljava/util/concurrent/locks/ReentrantLock;
    //   263: invokevirtual 585	java/util/concurrent/locks/ReentrantLock:unlock	()V
    //   266: aload_1
    //   267: athrow
    //   268: astore_1
    //   269: aload 4
    //   271: monitorexit
    //   272: aload_1
    //   273: athrow
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	274	0	this	e
    //   0	274	1	paramContext	android.content.Context
    //   16	88	2	bool1	boolean
    //   1	24	3	bool2	boolean
    // Exception table:
    //   from	to	target	type
    //   8	15	146	finally
    //   17	24	146	finally
    //   26	38	146	finally
    //   40	77	146	finally
    //   81	111	146	finally
    //   156	168	258	finally
    //   183	212	268	finally
    //   212	215	268	finally
    //   269	272	268	finally
  }
  
  public final void onServiceConnected(ComponentName paramComponentName, IBinder paramIBinder)
  {
    y.w("MicroMsg.CoreServiceConnection", "onServiceConnected ");
    synchronized (lock)
    {
      y.i("MicroMsg.CoreServiceConnection", "remove zombie killer.");
      ai.S(this.bwh);
      bwd = false;
    }
  }
  
  public final void onServiceDisconnected(ComponentName paramComponentName)
  {
    y.w("MicroMsg.CoreServiceConnection", "onServiceDisconnected ");
    try
    {
      this.bwe.lock();
      this.bwf = false;
      this.bwg = null;
      this.bwe.unlock();
      b.vG().k(new e.4(this, paramComponentName));
      return;
    }
    finally
    {
      this.bwe.unlock();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.app.e
 * JD-Core Version:    0.7.0.1
 */