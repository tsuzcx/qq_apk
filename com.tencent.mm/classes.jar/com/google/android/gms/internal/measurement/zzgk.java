package com.google.android.gms.internal.measurement;

import com.google.android.gms.common.internal.Preconditions;
import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.concurrent.BlockingQueue;

final class zzgk
  extends Thread
{
  private final Object zzamc;
  private final BlockingQueue<zzgj<?>> zzamd;
  
  public zzgk(String paramString, BlockingQueue<zzgj<?>> paramBlockingQueue)
  {
    AppMethodBeat.i(1582);
    Preconditions.checkNotNull(paramBlockingQueue);
    Object localObject;
    Preconditions.checkNotNull(localObject);
    this.zzamc = new Object();
    this.zzamd = localObject;
    setName(paramBlockingQueue);
    AppMethodBeat.o(1582);
  }
  
  private final void zza(InterruptedException paramInterruptedException)
  {
    AppMethodBeat.i(1585);
    this.zzalz.zzge().zzip().zzg(String.valueOf(getName()).concat(" was interrupted"), paramInterruptedException);
    AppMethodBeat.o(1585);
  }
  
  /* Error */
  public final void run()
  {
    // Byte code:
    //   0: sipush 1583
    //   3: invokestatic 24	com/tencent/matrix/trace/core/AppMethodBeat:i	(I)V
    //   6: iconst_0
    //   7: istore_1
    //   8: iload_1
    //   9: ifne +29 -> 38
    //   12: aload_0
    //   13: getfield 15	com/google/android/gms/internal/measurement/zzgk:zzalz	Lcom/google/android/gms/internal/measurement/zzgg;
    //   16: invokestatic 91	com/google/android/gms/internal/measurement/zzgg:zza	(Lcom/google/android/gms/internal/measurement/zzgg;)Ljava/util/concurrent/Semaphore;
    //   19: invokevirtual 96	java/util/concurrent/Semaphore:acquire	()V
    //   22: iconst_1
    //   23: istore_1
    //   24: goto -16 -> 8
    //   27: astore 4
    //   29: aload_0
    //   30: aload 4
    //   32: invokespecial 98	com/google/android/gms/internal/measurement/zzgk:zza	(Ljava/lang/InterruptedException;)V
    //   35: goto -27 -> 8
    //   38: invokestatic 104	android/os/Process:myTid	()I
    //   41: invokestatic 108	android/os/Process:getThreadPriority	(I)I
    //   44: istore_2
    //   45: aload_0
    //   46: getfield 37	com/google/android/gms/internal/measurement/zzgk:zzamd	Ljava/util/concurrent/BlockingQueue;
    //   49: invokeinterface 114 1 0
    //   54: checkcast 116	com/google/android/gms/internal/measurement/zzgj
    //   57: astore 4
    //   59: aload 4
    //   61: ifnull +97 -> 158
    //   64: aload 4
    //   66: getfield 120	com/google/android/gms/internal/measurement/zzgj:zzamb	Z
    //   69: ifeq +83 -> 152
    //   72: iload_2
    //   73: istore_1
    //   74: iload_1
    //   75: invokestatic 123	android/os/Process:setThreadPriority	(I)V
    //   78: aload 4
    //   80: invokevirtual 125	com/google/android/gms/internal/measurement/zzgj:run	()V
    //   83: goto -38 -> 45
    //   86: astore 5
    //   88: aload_0
    //   89: getfield 15	com/google/android/gms/internal/measurement/zzgk:zzalz	Lcom/google/android/gms/internal/measurement/zzgg;
    //   92: invokestatic 129	com/google/android/gms/internal/measurement/zzgg:zzc	(Lcom/google/android/gms/internal/measurement/zzgg;)Ljava/lang/Object;
    //   95: astore 4
    //   97: aload 4
    //   99: monitorenter
    //   100: aload_0
    //   101: getfield 15	com/google/android/gms/internal/measurement/zzgk:zzalz	Lcom/google/android/gms/internal/measurement/zzgg;
    //   104: invokestatic 91	com/google/android/gms/internal/measurement/zzgg:zza	(Lcom/google/android/gms/internal/measurement/zzgg;)Ljava/util/concurrent/Semaphore;
    //   107: invokevirtual 132	java/util/concurrent/Semaphore:release	()V
    //   110: aload_0
    //   111: getfield 15	com/google/android/gms/internal/measurement/zzgk:zzalz	Lcom/google/android/gms/internal/measurement/zzgg;
    //   114: invokestatic 129	com/google/android/gms/internal/measurement/zzgg:zzc	(Lcom/google/android/gms/internal/measurement/zzgg;)Ljava/lang/Object;
    //   117: invokevirtual 135	java/lang/Object:notifyAll	()V
    //   120: aload_0
    //   121: aload_0
    //   122: getfield 15	com/google/android/gms/internal/measurement/zzgk:zzalz	Lcom/google/android/gms/internal/measurement/zzgg;
    //   125: invokestatic 139	com/google/android/gms/internal/measurement/zzgg:zzd	(Lcom/google/android/gms/internal/measurement/zzgg;)Lcom/google/android/gms/internal/measurement/zzgk;
    //   128: if_acmpne +265 -> 393
    //   131: aload_0
    //   132: getfield 15	com/google/android/gms/internal/measurement/zzgk:zzalz	Lcom/google/android/gms/internal/measurement/zzgg;
    //   135: aconst_null
    //   136: invokestatic 142	com/google/android/gms/internal/measurement/zzgg:zza	(Lcom/google/android/gms/internal/measurement/zzgg;Lcom/google/android/gms/internal/measurement/zzgk;)Lcom/google/android/gms/internal/measurement/zzgk;
    //   139: pop
    //   140: aload 4
    //   142: monitorexit
    //   143: sipush 1583
    //   146: invokestatic 44	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   149: aload 5
    //   151: athrow
    //   152: bipush 10
    //   154: istore_1
    //   155: goto -81 -> 74
    //   158: aload_0
    //   159: getfield 35	com/google/android/gms/internal/measurement/zzgk:zzamc	Ljava/lang/Object;
    //   162: astore 4
    //   164: aload 4
    //   166: monitorenter
    //   167: aload_0
    //   168: getfield 37	com/google/android/gms/internal/measurement/zzgk:zzamd	Ljava/util/concurrent/BlockingQueue;
    //   171: invokeinterface 145 1 0
    //   176: ifnonnull +25 -> 201
    //   179: aload_0
    //   180: getfield 15	com/google/android/gms/internal/measurement/zzgk:zzalz	Lcom/google/android/gms/internal/measurement/zzgg;
    //   183: invokestatic 149	com/google/android/gms/internal/measurement/zzgg:zzb	(Lcom/google/android/gms/internal/measurement/zzgg;)Z
    //   186: istore_3
    //   187: iload_3
    //   188: ifne +13 -> 201
    //   191: aload_0
    //   192: getfield 35	com/google/android/gms/internal/measurement/zzgk:zzamc	Ljava/lang/Object;
    //   195: ldc2_w 150
    //   198: invokevirtual 155	java/lang/Object:wait	(J)V
    //   201: aload 4
    //   203: monitorexit
    //   204: aload_0
    //   205: getfield 15	com/google/android/gms/internal/measurement/zzgk:zzalz	Lcom/google/android/gms/internal/measurement/zzgg;
    //   208: invokestatic 129	com/google/android/gms/internal/measurement/zzgg:zzc	(Lcom/google/android/gms/internal/measurement/zzgg;)Ljava/lang/Object;
    //   211: astore 4
    //   213: aload 4
    //   215: monitorenter
    //   216: aload_0
    //   217: getfield 37	com/google/android/gms/internal/measurement/zzgk:zzamd	Ljava/util/concurrent/BlockingQueue;
    //   220: invokeinterface 145 1 0
    //   225: ifnonnull +148 -> 373
    //   228: aload 4
    //   230: monitorexit
    //   231: aload_0
    //   232: getfield 15	com/google/android/gms/internal/measurement/zzgk:zzalz	Lcom/google/android/gms/internal/measurement/zzgg;
    //   235: invokestatic 129	com/google/android/gms/internal/measurement/zzgg:zzc	(Lcom/google/android/gms/internal/measurement/zzgg;)Ljava/lang/Object;
    //   238: astore 4
    //   240: aload 4
    //   242: monitorenter
    //   243: aload_0
    //   244: getfield 15	com/google/android/gms/internal/measurement/zzgk:zzalz	Lcom/google/android/gms/internal/measurement/zzgg;
    //   247: invokestatic 91	com/google/android/gms/internal/measurement/zzgg:zza	(Lcom/google/android/gms/internal/measurement/zzgg;)Ljava/util/concurrent/Semaphore;
    //   250: invokevirtual 132	java/util/concurrent/Semaphore:release	()V
    //   253: aload_0
    //   254: getfield 15	com/google/android/gms/internal/measurement/zzgk:zzalz	Lcom/google/android/gms/internal/measurement/zzgg;
    //   257: invokestatic 129	com/google/android/gms/internal/measurement/zzgg:zzc	(Lcom/google/android/gms/internal/measurement/zzgg;)Ljava/lang/Object;
    //   260: invokevirtual 135	java/lang/Object:notifyAll	()V
    //   263: aload_0
    //   264: aload_0
    //   265: getfield 15	com/google/android/gms/internal/measurement/zzgk:zzalz	Lcom/google/android/gms/internal/measurement/zzgg;
    //   268: invokestatic 139	com/google/android/gms/internal/measurement/zzgg:zzd	(Lcom/google/android/gms/internal/measurement/zzgg;)Lcom/google/android/gms/internal/measurement/zzgk;
    //   271: if_acmpne +47 -> 318
    //   274: aload_0
    //   275: getfield 15	com/google/android/gms/internal/measurement/zzgk:zzalz	Lcom/google/android/gms/internal/measurement/zzgg;
    //   278: aconst_null
    //   279: invokestatic 142	com/google/android/gms/internal/measurement/zzgg:zza	(Lcom/google/android/gms/internal/measurement/zzgg;Lcom/google/android/gms/internal/measurement/zzgk;)Lcom/google/android/gms/internal/measurement/zzgk;
    //   282: pop
    //   283: aload 4
    //   285: monitorexit
    //   286: sipush 1583
    //   289: invokestatic 44	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   292: return
    //   293: astore 5
    //   295: aload_0
    //   296: aload 5
    //   298: invokespecial 98	com/google/android/gms/internal/measurement/zzgk:zza	(Ljava/lang/InterruptedException;)V
    //   301: goto -100 -> 201
    //   304: astore 5
    //   306: aload 4
    //   308: monitorexit
    //   309: sipush 1583
    //   312: invokestatic 44	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   315: aload 5
    //   317: athrow
    //   318: aload_0
    //   319: aload_0
    //   320: getfield 15	com/google/android/gms/internal/measurement/zzgk:zzalz	Lcom/google/android/gms/internal/measurement/zzgg;
    //   323: invokestatic 158	com/google/android/gms/internal/measurement/zzgg:zze	(Lcom/google/android/gms/internal/measurement/zzgg;)Lcom/google/android/gms/internal/measurement/zzgk;
    //   326: if_acmpne +29 -> 355
    //   329: aload_0
    //   330: getfield 15	com/google/android/gms/internal/measurement/zzgk:zzalz	Lcom/google/android/gms/internal/measurement/zzgg;
    //   333: aconst_null
    //   334: invokestatic 160	com/google/android/gms/internal/measurement/zzgg:zzb	(Lcom/google/android/gms/internal/measurement/zzgg;Lcom/google/android/gms/internal/measurement/zzgk;)Lcom/google/android/gms/internal/measurement/zzgk;
    //   337: pop
    //   338: goto -55 -> 283
    //   341: astore 5
    //   343: aload 4
    //   345: monitorexit
    //   346: sipush 1583
    //   349: invokestatic 44	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   352: aload 5
    //   354: athrow
    //   355: aload_0
    //   356: getfield 15	com/google/android/gms/internal/measurement/zzgk:zzalz	Lcom/google/android/gms/internal/measurement/zzgg;
    //   359: invokevirtual 55	com/google/android/gms/internal/measurement/zzhg:zzge	()Lcom/google/android/gms/internal/measurement/zzfg;
    //   362: invokevirtual 163	com/google/android/gms/internal/measurement/zzfg:zzim	()Lcom/google/android/gms/internal/measurement/zzfi;
    //   365: ldc 165
    //   367: invokevirtual 168	com/google/android/gms/internal/measurement/zzfi:log	(Ljava/lang/String;)V
    //   370: goto -87 -> 283
    //   373: aload 4
    //   375: monitorexit
    //   376: goto -331 -> 45
    //   379: astore 5
    //   381: aload 4
    //   383: monitorexit
    //   384: sipush 1583
    //   387: invokestatic 44	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   390: aload 5
    //   392: athrow
    //   393: aload_0
    //   394: aload_0
    //   395: getfield 15	com/google/android/gms/internal/measurement/zzgk:zzalz	Lcom/google/android/gms/internal/measurement/zzgg;
    //   398: invokestatic 158	com/google/android/gms/internal/measurement/zzgg:zze	(Lcom/google/android/gms/internal/measurement/zzgg;)Lcom/google/android/gms/internal/measurement/zzgk;
    //   401: if_acmpne +29 -> 430
    //   404: aload_0
    //   405: getfield 15	com/google/android/gms/internal/measurement/zzgk:zzalz	Lcom/google/android/gms/internal/measurement/zzgg;
    //   408: aconst_null
    //   409: invokestatic 160	com/google/android/gms/internal/measurement/zzgg:zzb	(Lcom/google/android/gms/internal/measurement/zzgg;Lcom/google/android/gms/internal/measurement/zzgk;)Lcom/google/android/gms/internal/measurement/zzgk;
    //   412: pop
    //   413: goto -273 -> 140
    //   416: astore 5
    //   418: aload 4
    //   420: monitorexit
    //   421: sipush 1583
    //   424: invokestatic 44	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   427: aload 5
    //   429: athrow
    //   430: aload_0
    //   431: getfield 15	com/google/android/gms/internal/measurement/zzgk:zzalz	Lcom/google/android/gms/internal/measurement/zzgg;
    //   434: invokevirtual 55	com/google/android/gms/internal/measurement/zzhg:zzge	()Lcom/google/android/gms/internal/measurement/zzfg;
    //   437: invokevirtual 163	com/google/android/gms/internal/measurement/zzfg:zzim	()Lcom/google/android/gms/internal/measurement/zzfi;
    //   440: ldc 165
    //   442: invokevirtual 168	com/google/android/gms/internal/measurement/zzfi:log	(Ljava/lang/String;)V
    //   445: goto -305 -> 140
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	448	0	this	zzgk
    //   7	148	1	i	int
    //   44	29	2	j	int
    //   186	2	3	bool	boolean
    //   27	4	4	localInterruptedException1	InterruptedException
    //   86	64	5	localObject2	Object
    //   293	4	5	localInterruptedException2	InterruptedException
    //   304	12	5	localObject3	Object
    //   341	12	5	localObject4	Object
    //   379	12	5	localObject5	Object
    //   416	12	5	localObject6	Object
    // Exception table:
    //   from	to	target	type
    //   12	22	27	java/lang/InterruptedException
    //   38	45	86	finally
    //   45	59	86	finally
    //   64	72	86	finally
    //   74	83	86	finally
    //   158	167	86	finally
    //   204	216	86	finally
    //   306	318	86	finally
    //   373	376	86	finally
    //   381	393	86	finally
    //   191	201	293	java/lang/InterruptedException
    //   167	187	304	finally
    //   191	201	304	finally
    //   201	204	304	finally
    //   295	301	304	finally
    //   243	283	341	finally
    //   283	286	341	finally
    //   318	338	341	finally
    //   355	370	341	finally
    //   216	231	379	finally
    //   100	140	416	finally
    //   140	143	416	finally
    //   393	413	416	finally
    //   430	445	416	finally
  }
  
  public final void zzjn()
  {
    AppMethodBeat.i(1584);
    synchronized (this.zzamc)
    {
      this.zzamc.notifyAll();
      AppMethodBeat.o(1584);
      return;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes11.jar
 * Qualified Name:     com.google.android.gms.internal.measurement.zzgk
 * JD-Core Version:    0.7.0.1
 */