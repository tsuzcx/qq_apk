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
    AppMethodBeat.i(69059);
    Preconditions.checkNotNull(paramBlockingQueue);
    Object localObject;
    Preconditions.checkNotNull(localObject);
    this.zzamc = new Object();
    this.zzamd = localObject;
    setName(paramBlockingQueue);
    AppMethodBeat.o(69059);
  }
  
  private final void zza(InterruptedException paramInterruptedException)
  {
    AppMethodBeat.i(69062);
    this.zzalz.zzge().zzip().zzg(String.valueOf(getName()).concat(" was interrupted"), paramInterruptedException);
    AppMethodBeat.o(69062);
  }
  
  /* Error */
  public final void run()
  {
    // Byte code:
    //   0: ldc 89
    //   2: invokestatic 25	com/tencent/matrix/trace/core/AppMethodBeat:i	(I)V
    //   5: iconst_0
    //   6: istore_1
    //   7: iload_1
    //   8: ifne +29 -> 37
    //   11: aload_0
    //   12: getfield 15	com/google/android/gms/internal/measurement/zzgk:zzalz	Lcom/google/android/gms/internal/measurement/zzgg;
    //   15: invokestatic 94	com/google/android/gms/internal/measurement/zzgg:zza	(Lcom/google/android/gms/internal/measurement/zzgg;)Ljava/util/concurrent/Semaphore;
    //   18: invokevirtual 99	java/util/concurrent/Semaphore:acquire	()V
    //   21: iconst_1
    //   22: istore_1
    //   23: goto -16 -> 7
    //   26: astore 4
    //   28: aload_0
    //   29: aload 4
    //   31: invokespecial 101	com/google/android/gms/internal/measurement/zzgk:zza	(Ljava/lang/InterruptedException;)V
    //   34: goto -27 -> 7
    //   37: invokestatic 107	android/os/Process:myTid	()I
    //   40: invokestatic 111	android/os/Process:getThreadPriority	(I)I
    //   43: istore_2
    //   44: aload_0
    //   45: getfield 38	com/google/android/gms/internal/measurement/zzgk:zzamd	Ljava/util/concurrent/BlockingQueue;
    //   48: invokeinterface 117 1 0
    //   53: checkcast 119	com/google/android/gms/internal/measurement/zzgj
    //   56: astore 4
    //   58: aload 4
    //   60: ifnull +96 -> 156
    //   63: aload 4
    //   65: getfield 123	com/google/android/gms/internal/measurement/zzgj:zzamb	Z
    //   68: ifeq +82 -> 150
    //   71: iload_2
    //   72: istore_1
    //   73: iload_1
    //   74: invokestatic 126	android/os/Process:setThreadPriority	(I)V
    //   77: aload 4
    //   79: invokevirtual 128	com/google/android/gms/internal/measurement/zzgj:run	()V
    //   82: goto -38 -> 44
    //   85: astore 5
    //   87: aload_0
    //   88: getfield 15	com/google/android/gms/internal/measurement/zzgk:zzalz	Lcom/google/android/gms/internal/measurement/zzgg;
    //   91: invokestatic 132	com/google/android/gms/internal/measurement/zzgg:zzc	(Lcom/google/android/gms/internal/measurement/zzgg;)Ljava/lang/Object;
    //   94: astore 4
    //   96: aload 4
    //   98: monitorenter
    //   99: aload_0
    //   100: getfield 15	com/google/android/gms/internal/measurement/zzgk:zzalz	Lcom/google/android/gms/internal/measurement/zzgg;
    //   103: invokestatic 94	com/google/android/gms/internal/measurement/zzgg:zza	(Lcom/google/android/gms/internal/measurement/zzgg;)Ljava/util/concurrent/Semaphore;
    //   106: invokevirtual 135	java/util/concurrent/Semaphore:release	()V
    //   109: aload_0
    //   110: getfield 15	com/google/android/gms/internal/measurement/zzgk:zzalz	Lcom/google/android/gms/internal/measurement/zzgg;
    //   113: invokestatic 132	com/google/android/gms/internal/measurement/zzgg:zzc	(Lcom/google/android/gms/internal/measurement/zzgg;)Ljava/lang/Object;
    //   116: invokevirtual 138	java/lang/Object:notifyAll	()V
    //   119: aload_0
    //   120: aload_0
    //   121: getfield 15	com/google/android/gms/internal/measurement/zzgk:zzalz	Lcom/google/android/gms/internal/measurement/zzgg;
    //   124: invokestatic 142	com/google/android/gms/internal/measurement/zzgg:zzd	(Lcom/google/android/gms/internal/measurement/zzgg;)Lcom/google/android/gms/internal/measurement/zzgk;
    //   127: if_acmpne +260 -> 387
    //   130: aload_0
    //   131: getfield 15	com/google/android/gms/internal/measurement/zzgk:zzalz	Lcom/google/android/gms/internal/measurement/zzgg;
    //   134: aconst_null
    //   135: invokestatic 145	com/google/android/gms/internal/measurement/zzgg:zza	(Lcom/google/android/gms/internal/measurement/zzgg;Lcom/google/android/gms/internal/measurement/zzgk;)Lcom/google/android/gms/internal/measurement/zzgk;
    //   138: pop
    //   139: aload 4
    //   141: monitorexit
    //   142: ldc 89
    //   144: invokestatic 45	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   147: aload 5
    //   149: athrow
    //   150: bipush 10
    //   152: istore_1
    //   153: goto -80 -> 73
    //   156: aload_0
    //   157: getfield 36	com/google/android/gms/internal/measurement/zzgk:zzamc	Ljava/lang/Object;
    //   160: astore 4
    //   162: aload 4
    //   164: monitorenter
    //   165: aload_0
    //   166: getfield 38	com/google/android/gms/internal/measurement/zzgk:zzamd	Ljava/util/concurrent/BlockingQueue;
    //   169: invokeinterface 148 1 0
    //   174: ifnonnull +25 -> 199
    //   177: aload_0
    //   178: getfield 15	com/google/android/gms/internal/measurement/zzgk:zzalz	Lcom/google/android/gms/internal/measurement/zzgg;
    //   181: invokestatic 152	com/google/android/gms/internal/measurement/zzgg:zzb	(Lcom/google/android/gms/internal/measurement/zzgg;)Z
    //   184: istore_3
    //   185: iload_3
    //   186: ifne +13 -> 199
    //   189: aload_0
    //   190: getfield 36	com/google/android/gms/internal/measurement/zzgk:zzamc	Ljava/lang/Object;
    //   193: ldc2_w 153
    //   196: invokevirtual 158	java/lang/Object:wait	(J)V
    //   199: aload 4
    //   201: monitorexit
    //   202: aload_0
    //   203: getfield 15	com/google/android/gms/internal/measurement/zzgk:zzalz	Lcom/google/android/gms/internal/measurement/zzgg;
    //   206: invokestatic 132	com/google/android/gms/internal/measurement/zzgg:zzc	(Lcom/google/android/gms/internal/measurement/zzgg;)Ljava/lang/Object;
    //   209: astore 4
    //   211: aload 4
    //   213: monitorenter
    //   214: aload_0
    //   215: getfield 38	com/google/android/gms/internal/measurement/zzgk:zzamd	Ljava/util/concurrent/BlockingQueue;
    //   218: invokeinterface 148 1 0
    //   223: ifnonnull +145 -> 368
    //   226: aload 4
    //   228: monitorexit
    //   229: aload_0
    //   230: getfield 15	com/google/android/gms/internal/measurement/zzgk:zzalz	Lcom/google/android/gms/internal/measurement/zzgg;
    //   233: invokestatic 132	com/google/android/gms/internal/measurement/zzgg:zzc	(Lcom/google/android/gms/internal/measurement/zzgg;)Ljava/lang/Object;
    //   236: astore 4
    //   238: aload 4
    //   240: monitorenter
    //   241: aload_0
    //   242: getfield 15	com/google/android/gms/internal/measurement/zzgk:zzalz	Lcom/google/android/gms/internal/measurement/zzgg;
    //   245: invokestatic 94	com/google/android/gms/internal/measurement/zzgg:zza	(Lcom/google/android/gms/internal/measurement/zzgg;)Ljava/util/concurrent/Semaphore;
    //   248: invokevirtual 135	java/util/concurrent/Semaphore:release	()V
    //   251: aload_0
    //   252: getfield 15	com/google/android/gms/internal/measurement/zzgk:zzalz	Lcom/google/android/gms/internal/measurement/zzgg;
    //   255: invokestatic 132	com/google/android/gms/internal/measurement/zzgg:zzc	(Lcom/google/android/gms/internal/measurement/zzgg;)Ljava/lang/Object;
    //   258: invokevirtual 138	java/lang/Object:notifyAll	()V
    //   261: aload_0
    //   262: aload_0
    //   263: getfield 15	com/google/android/gms/internal/measurement/zzgk:zzalz	Lcom/google/android/gms/internal/measurement/zzgg;
    //   266: invokestatic 142	com/google/android/gms/internal/measurement/zzgg:zzd	(Lcom/google/android/gms/internal/measurement/zzgg;)Lcom/google/android/gms/internal/measurement/zzgk;
    //   269: if_acmpne +45 -> 314
    //   272: aload_0
    //   273: getfield 15	com/google/android/gms/internal/measurement/zzgk:zzalz	Lcom/google/android/gms/internal/measurement/zzgg;
    //   276: aconst_null
    //   277: invokestatic 145	com/google/android/gms/internal/measurement/zzgg:zza	(Lcom/google/android/gms/internal/measurement/zzgg;Lcom/google/android/gms/internal/measurement/zzgk;)Lcom/google/android/gms/internal/measurement/zzgk;
    //   280: pop
    //   281: aload 4
    //   283: monitorexit
    //   284: ldc 89
    //   286: invokestatic 45	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   289: return
    //   290: astore 5
    //   292: aload_0
    //   293: aload 5
    //   295: invokespecial 101	com/google/android/gms/internal/measurement/zzgk:zza	(Ljava/lang/InterruptedException;)V
    //   298: goto -99 -> 199
    //   301: astore 5
    //   303: aload 4
    //   305: monitorexit
    //   306: ldc 89
    //   308: invokestatic 45	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   311: aload 5
    //   313: athrow
    //   314: aload_0
    //   315: aload_0
    //   316: getfield 15	com/google/android/gms/internal/measurement/zzgk:zzalz	Lcom/google/android/gms/internal/measurement/zzgg;
    //   319: invokestatic 161	com/google/android/gms/internal/measurement/zzgg:zze	(Lcom/google/android/gms/internal/measurement/zzgg;)Lcom/google/android/gms/internal/measurement/zzgk;
    //   322: if_acmpne +28 -> 350
    //   325: aload_0
    //   326: getfield 15	com/google/android/gms/internal/measurement/zzgk:zzalz	Lcom/google/android/gms/internal/measurement/zzgg;
    //   329: aconst_null
    //   330: invokestatic 163	com/google/android/gms/internal/measurement/zzgg:zzb	(Lcom/google/android/gms/internal/measurement/zzgg;Lcom/google/android/gms/internal/measurement/zzgk;)Lcom/google/android/gms/internal/measurement/zzgk;
    //   333: pop
    //   334: goto -53 -> 281
    //   337: astore 5
    //   339: aload 4
    //   341: monitorexit
    //   342: ldc 89
    //   344: invokestatic 45	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   347: aload 5
    //   349: athrow
    //   350: aload_0
    //   351: getfield 15	com/google/android/gms/internal/measurement/zzgk:zzalz	Lcom/google/android/gms/internal/measurement/zzgg;
    //   354: invokevirtual 57	com/google/android/gms/internal/measurement/zzhg:zzge	()Lcom/google/android/gms/internal/measurement/zzfg;
    //   357: invokevirtual 166	com/google/android/gms/internal/measurement/zzfg:zzim	()Lcom/google/android/gms/internal/measurement/zzfi;
    //   360: ldc 168
    //   362: invokevirtual 171	com/google/android/gms/internal/measurement/zzfi:log	(Ljava/lang/String;)V
    //   365: goto -84 -> 281
    //   368: aload 4
    //   370: monitorexit
    //   371: goto -327 -> 44
    //   374: astore 5
    //   376: aload 4
    //   378: monitorexit
    //   379: ldc 89
    //   381: invokestatic 45	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   384: aload 5
    //   386: athrow
    //   387: aload_0
    //   388: aload_0
    //   389: getfield 15	com/google/android/gms/internal/measurement/zzgk:zzalz	Lcom/google/android/gms/internal/measurement/zzgg;
    //   392: invokestatic 161	com/google/android/gms/internal/measurement/zzgg:zze	(Lcom/google/android/gms/internal/measurement/zzgg;)Lcom/google/android/gms/internal/measurement/zzgk;
    //   395: if_acmpne +28 -> 423
    //   398: aload_0
    //   399: getfield 15	com/google/android/gms/internal/measurement/zzgk:zzalz	Lcom/google/android/gms/internal/measurement/zzgg;
    //   402: aconst_null
    //   403: invokestatic 163	com/google/android/gms/internal/measurement/zzgg:zzb	(Lcom/google/android/gms/internal/measurement/zzgg;Lcom/google/android/gms/internal/measurement/zzgk;)Lcom/google/android/gms/internal/measurement/zzgk;
    //   406: pop
    //   407: goto -268 -> 139
    //   410: astore 5
    //   412: aload 4
    //   414: monitorexit
    //   415: ldc 89
    //   417: invokestatic 45	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   420: aload 5
    //   422: athrow
    //   423: aload_0
    //   424: getfield 15	com/google/android/gms/internal/measurement/zzgk:zzalz	Lcom/google/android/gms/internal/measurement/zzgg;
    //   427: invokevirtual 57	com/google/android/gms/internal/measurement/zzhg:zzge	()Lcom/google/android/gms/internal/measurement/zzfg;
    //   430: invokevirtual 166	com/google/android/gms/internal/measurement/zzfg:zzim	()Lcom/google/android/gms/internal/measurement/zzfi;
    //   433: ldc 168
    //   435: invokevirtual 171	com/google/android/gms/internal/measurement/zzfi:log	(Ljava/lang/String;)V
    //   438: goto -299 -> 139
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	441	0	this	zzgk
    //   6	147	1	i	int
    //   43	29	2	j	int
    //   184	2	3	bool	boolean
    //   26	4	4	localInterruptedException1	InterruptedException
    //   85	63	5	localObject2	Object
    //   290	4	5	localInterruptedException2	InterruptedException
    //   301	11	5	localObject3	Object
    //   337	11	5	localObject4	Object
    //   374	11	5	localObject5	Object
    //   410	11	5	localObject6	Object
    // Exception table:
    //   from	to	target	type
    //   11	21	26	java/lang/InterruptedException
    //   37	44	85	finally
    //   44	58	85	finally
    //   63	71	85	finally
    //   73	82	85	finally
    //   156	165	85	finally
    //   202	214	85	finally
    //   306	314	85	finally
    //   379	387	85	finally
    //   189	199	290	java/lang/InterruptedException
    //   165	185	301	finally
    //   189	199	301	finally
    //   199	202	301	finally
    //   292	298	301	finally
    //   303	306	301	finally
    //   241	281	337	finally
    //   281	284	337	finally
    //   314	334	337	finally
    //   339	342	337	finally
    //   350	365	337	finally
    //   214	229	374	finally
    //   368	371	374	finally
    //   376	379	374	finally
    //   99	139	410	finally
    //   139	142	410	finally
    //   387	407	410	finally
    //   412	415	410	finally
    //   423	438	410	finally
  }
  
  public final void zzjn()
  {
    AppMethodBeat.i(69061);
    synchronized (this.zzamc)
    {
      this.zzamc.notifyAll();
      AppMethodBeat.o(69061);
      return;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.google.android.gms.internal.measurement.zzgk
 * JD-Core Version:    0.7.0.1
 */