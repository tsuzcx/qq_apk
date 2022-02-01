package com.tencent.matrix.resource.f;

import android.app.Activity;
import android.app.Application;
import android.app.Application.ActivityLifecycleCallbacks;
import android.os.Handler;
import android.os.HandlerThread;
import com.tencent.matrix.resource.analyzer.model.DestroyedActivityInfo;
import com.tencent.matrix.resource.b.a.b;
import com.tencent.matrix.resource.processor.ManualDumpProcessor;
import com.tencent.matrix.resource.processor.d;
import com.tencent.matrix.resource.processor.e;
import com.tencent.matrix.resource.processor.g;
import java.util.concurrent.ConcurrentLinkedQueue;
import java.util.concurrent.TimeUnit;

public final class b
  extends com.tencent.matrix.report.f
{
  private static final long fcN = TimeUnit.DAYS.toMillis(1L);
  private final a.b fbd;
  public final com.tencent.matrix.resource.c fcO;
  public final c fcP;
  private final int fcQ;
  public final long fcR;
  public final long fcS;
  private final ConcurrentLinkedQueue<DestroyedActivityInfo> fcT;
  public final com.tencent.matrix.resource.processor.b fcU;
  public final Application.ActivityLifecycleCallbacks fcV = new a()
  {
    public final void onActivityDestroyed(Activity paramAnonymousActivity)
    {
      b.a(b.this, paramAnonymousActivity);
      b.a(b.this).postDelayed(new Runnable()
      {
        public final void run() {}
      }, 2000L);
    }
  };
  public final c.a fcW = new c.a()
  {
    /* Error */
    public final c.a.a azy()
    {
      // Byte code:
      //   0: aload_0
      //   1: getfield 14	com/tencent/matrix/resource/f/b$2:fcX	Lcom/tencent/matrix/resource/f/b;
      //   4: invokestatic 24	com/tencent/matrix/resource/f/b:b	(Lcom/tencent/matrix/resource/f/b;)Ljava/util/concurrent/ConcurrentLinkedQueue;
      //   7: invokevirtual 30	java/util/concurrent/ConcurrentLinkedQueue:isEmpty	()Z
      //   10: ifeq +73 -> 83
      //   13: ldc 32
      //   15: ldc 34
      //   17: iconst_0
      //   18: anewarray 4	java/lang/Object
      //   21: invokestatic 40	com/tencent/matrix/e/c:i	(Ljava/lang/String;Ljava/lang/String;[Ljava/lang/Object;)V
      //   24: aload_0
      //   25: getfield 14	com/tencent/matrix/resource/f/b$2:fcX	Lcom/tencent/matrix/resource/f/b;
      //   28: invokestatic 24	com/tencent/matrix/resource/f/b:b	(Lcom/tencent/matrix/resource/f/b;)Ljava/util/concurrent/ConcurrentLinkedQueue;
      //   31: astore_1
      //   32: aload_1
      //   33: monitorenter
      //   34: aload_0
      //   35: getfield 14	com/tencent/matrix/resource/f/b$2:fcX	Lcom/tencent/matrix/resource/f/b;
      //   38: invokestatic 24	com/tencent/matrix/resource/f/b:b	(Lcom/tencent/matrix/resource/f/b;)Ljava/util/concurrent/ConcurrentLinkedQueue;
      //   41: invokevirtual 30	java/util/concurrent/ConcurrentLinkedQueue:isEmpty	()Z
      //   44: ifeq +17 -> 61
      //   47: aload_0
      //   48: getfield 14	com/tencent/matrix/resource/f/b$2:fcX	Lcom/tencent/matrix/resource/f/b;
      //   51: invokestatic 24	com/tencent/matrix/resource/f/b:b	(Lcom/tencent/matrix/resource/f/b;)Ljava/util/concurrent/ConcurrentLinkedQueue;
      //   54: invokevirtual 43	java/lang/Object:wait	()V
      //   57: goto -23 -> 34
      //   60: astore_2
      //   61: aload_1
      //   62: monitorexit
      //   63: ldc 32
      //   65: ldc 45
      //   67: iconst_0
      //   68: anewarray 4	java/lang/Object
      //   71: invokestatic 40	com/tencent/matrix/e/c:i	(Ljava/lang/String;Ljava/lang/String;[Ljava/lang/Object;)V
      //   74: getstatic 51	com/tencent/matrix/resource/f/c$a$a:fdg	Lcom/tencent/matrix/resource/f/c$a$a;
      //   77: areturn
      //   78: astore_2
      //   79: aload_1
      //   80: monitorexit
      //   81: aload_2
      //   82: athrow
      //   83: invokestatic 56	android/os/Debug:isDebuggerConnected	()Z
      //   86: ifeq +34 -> 120
      //   89: aload_0
      //   90: getfield 14	com/tencent/matrix/resource/f/b$2:fcX	Lcom/tencent/matrix/resource/f/b;
      //   93: invokestatic 60	com/tencent/matrix/resource/f/b:c	(Lcom/tencent/matrix/resource/f/b;)Lcom/tencent/matrix/resource/c;
      //   96: getfield 66	com/tencent/matrix/resource/c:eZp	Lcom/tencent/matrix/resource/b/a;
      //   99: getfield 72	com/tencent/matrix/resource/b/a:fbe	Z
      //   102: ifne +18 -> 120
      //   105: ldc 32
      //   107: ldc 74
      //   109: iconst_0
      //   110: anewarray 4	java/lang/Object
      //   113: invokestatic 77	com/tencent/matrix/e/c:w	(Ljava/lang/String;Ljava/lang/String;[Ljava/lang/Object;)V
      //   116: getstatic 51	com/tencent/matrix/resource/f/c$a$a:fdg	Lcom/tencent/matrix/resource/f/c$a$a;
      //   119: areturn
      //   120: invokestatic 80	com/tencent/matrix/resource/f/b:azx	()V
      //   123: invokestatic 80	com/tencent/matrix/resource/f/b:azx	()V
      //   126: invokestatic 80	com/tencent/matrix/resource/f/b:azx	()V
      //   129: aload_0
      //   130: getfield 14	com/tencent/matrix/resource/f/b$2:fcX	Lcom/tencent/matrix/resource/f/b;
      //   133: invokestatic 24	com/tencent/matrix/resource/f/b:b	(Lcom/tencent/matrix/resource/f/b;)Ljava/util/concurrent/ConcurrentLinkedQueue;
      //   136: invokevirtual 84	java/util/concurrent/ConcurrentLinkedQueue:iterator	()Ljava/util/Iterator;
      //   139: astore_1
      //   140: aload_1
      //   141: invokeinterface 89 1 0
      //   146: ifeq +309 -> 455
      //   149: aload_1
      //   150: invokeinterface 93 1 0
      //   155: checkcast 95	com/tencent/matrix/resource/analyzer/model/DestroyedActivityInfo
      //   158: astore_2
      //   159: aload_0
      //   160: getfield 14	com/tencent/matrix/resource/f/b$2:fcX	Lcom/tencent/matrix/resource/f/b;
      //   163: invokestatic 99	com/tencent/matrix/resource/f/b:d	(Lcom/tencent/matrix/resource/f/b;)Lcom/tencent/matrix/resource/b/a$b;
      //   166: getstatic 105	com/tencent/matrix/resource/b/a$b:fbj	Lcom/tencent/matrix/resource/b/a$b;
      //   169: if_acmpeq +16 -> 185
      //   172: aload_0
      //   173: getfield 14	com/tencent/matrix/resource/f/b$2:fcX	Lcom/tencent/matrix/resource/f/b;
      //   176: invokestatic 99	com/tencent/matrix/resource/f/b:d	(Lcom/tencent/matrix/resource/f/b;)Lcom/tencent/matrix/resource/b/a$b;
      //   179: getstatic 108	com/tencent/matrix/resource/b/a$b:fbk	Lcom/tencent/matrix/resource/b/a$b;
      //   182: if_acmpne +60 -> 242
      //   185: aload_0
      //   186: getfield 14	com/tencent/matrix/resource/f/b$2:fcX	Lcom/tencent/matrix/resource/f/b;
      //   189: invokestatic 60	com/tencent/matrix/resource/f/b:c	(Lcom/tencent/matrix/resource/f/b;)Lcom/tencent/matrix/resource/c;
      //   192: getfield 66	com/tencent/matrix/resource/c:eZp	Lcom/tencent/matrix/resource/b/a;
      //   195: getfield 72	com/tencent/matrix/resource/b/a:fbe	Z
      //   198: ifne +44 -> 242
      //   201: aload_0
      //   202: getfield 14	com/tencent/matrix/resource/f/b$2:fcX	Lcom/tencent/matrix/resource/f/b;
      //   205: aload_2
      //   206: getfield 112	com/tencent/matrix/resource/analyzer/model/DestroyedActivityInfo:mActivityName	Ljava/lang/String;
      //   209: invokevirtual 116	com/tencent/matrix/resource/f/b:gY	(Ljava/lang/String;)Z
      //   212: ifeq +30 -> 242
      //   215: ldc 32
      //   217: ldc 118
      //   219: iconst_1
      //   220: anewarray 4	java/lang/Object
      //   223: dup
      //   224: iconst_0
      //   225: aload_2
      //   226: getfield 112	com/tencent/matrix/resource/analyzer/model/DestroyedActivityInfo:mActivityName	Ljava/lang/String;
      //   229: aastore
      //   230: invokestatic 121	com/tencent/matrix/e/c:v	(Ljava/lang/String;Ljava/lang/String;[Ljava/lang/Object;)V
      //   233: aload_1
      //   234: invokeinterface 124 1 0
      //   239: goto -99 -> 140
      //   242: invokestatic 80	com/tencent/matrix/resource/f/b:azx	()V
      //   245: aload_2
      //   246: getfield 128	com/tencent/matrix/resource/analyzer/model/DestroyedActivityInfo:mActivityRef	Ljava/lang/ref/WeakReference;
      //   249: invokevirtual 133	java/lang/ref/WeakReference:get	()Ljava/lang/Object;
      //   252: ifnonnull +30 -> 282
      //   255: ldc 32
      //   257: ldc 135
      //   259: iconst_1
      //   260: anewarray 4	java/lang/Object
      //   263: dup
      //   264: iconst_0
      //   265: aload_2
      //   266: getfield 138	com/tencent/matrix/resource/analyzer/model/DestroyedActivityInfo:mKey	Ljava/lang/String;
      //   269: aastore
      //   270: invokestatic 121	com/tencent/matrix/e/c:v	(Ljava/lang/String;Ljava/lang/String;[Ljava/lang/Object;)V
      //   273: aload_1
      //   274: invokeinterface 124 1 0
      //   279: goto -139 -> 140
      //   282: aload_2
      //   283: aload_2
      //   284: getfield 142	com/tencent/matrix/resource/analyzer/model/DestroyedActivityInfo:mDetectedCount	I
      //   287: iconst_1
      //   288: iadd
      //   289: putfield 142	com/tencent/matrix/resource/analyzer/model/DestroyedActivityInfo:mDetectedCount	I
      //   292: aload_2
      //   293: getfield 142	com/tencent/matrix/resource/analyzer/model/DestroyedActivityInfo:mDetectedCount	I
      //   296: aload_0
      //   297: getfield 14	com/tencent/matrix/resource/f/b$2:fcX	Lcom/tencent/matrix/resource/f/b;
      //   300: invokestatic 146	com/tencent/matrix/resource/f/b:e	(Lcom/tencent/matrix/resource/f/b;)I
      //   303: if_icmpge +53 -> 356
      //   306: aload_0
      //   307: getfield 14	com/tencent/matrix/resource/f/b$2:fcX	Lcom/tencent/matrix/resource/f/b;
      //   310: invokestatic 60	com/tencent/matrix/resource/f/b:c	(Lcom/tencent/matrix/resource/f/b;)Lcom/tencent/matrix/resource/c;
      //   313: getfield 66	com/tencent/matrix/resource/c:eZp	Lcom/tencent/matrix/resource/b/a;
      //   316: getfield 72	com/tencent/matrix/resource/b/a:fbe	Z
      //   319: ifne +37 -> 356
      //   322: ldc 32
      //   324: ldc 148
      //   326: iconst_2
      //   327: anewarray 4	java/lang/Object
      //   330: dup
      //   331: iconst_0
      //   332: aload_2
      //   333: getfield 138	com/tencent/matrix/resource/analyzer/model/DestroyedActivityInfo:mKey	Ljava/lang/String;
      //   336: aastore
      //   337: dup
      //   338: iconst_1
      //   339: aload_2
      //   340: getfield 142	com/tencent/matrix/resource/analyzer/model/DestroyedActivityInfo:mDetectedCount	I
      //   343: invokestatic 154	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
      //   346: aastore
      //   347: invokestatic 40	com/tencent/matrix/e/c:i	(Ljava/lang/String;Ljava/lang/String;[Ljava/lang/Object;)V
      //   350: invokestatic 80	com/tencent/matrix/resource/f/b:azx	()V
      //   353: goto -213 -> 140
      //   356: ldc 32
      //   358: ldc 156
      //   360: iconst_2
      //   361: anewarray 4	java/lang/Object
      //   364: dup
      //   365: iconst_0
      //   366: aload_2
      //   367: getfield 138	com/tencent/matrix/resource/analyzer/model/DestroyedActivityInfo:mKey	Ljava/lang/String;
      //   370: aastore
      //   371: dup
      //   372: iconst_1
      //   373: aload_0
      //   374: getfield 14	com/tencent/matrix/resource/f/b$2:fcX	Lcom/tencent/matrix/resource/f/b;
      //   377: invokestatic 99	com/tencent/matrix/resource/f/b:d	(Lcom/tencent/matrix/resource/f/b;)Lcom/tencent/matrix/resource/b/a$b;
      //   380: aastore
      //   381: invokestatic 40	com/tencent/matrix/e/c:i	(Ljava/lang/String;Ljava/lang/String;[Ljava/lang/Object;)V
      //   384: aload_0
      //   385: getfield 14	com/tencent/matrix/resource/f/b$2:fcX	Lcom/tencent/matrix/resource/f/b;
      //   388: invokestatic 160	com/tencent/matrix/resource/f/b:f	(Lcom/tencent/matrix/resource/f/b;)Lcom/tencent/matrix/resource/processor/b;
      //   391: ifnonnull +13 -> 404
      //   394: new 162	java/lang/NullPointerException
      //   397: dup
      //   398: ldc 164
      //   400: invokespecial 167	java/lang/NullPointerException:<init>	(Ljava/lang/String;)V
      //   403: athrow
      //   404: invokestatic 80	com/tencent/matrix/resource/f/b:azx	()V
      //   407: aload_0
      //   408: getfield 14	com/tencent/matrix/resource/f/b$2:fcX	Lcom/tencent/matrix/resource/f/b;
      //   411: invokestatic 160	com/tencent/matrix/resource/f/b:f	(Lcom/tencent/matrix/resource/f/b;)Lcom/tencent/matrix/resource/processor/b;
      //   414: aload_2
      //   415: invokevirtual 173	com/tencent/matrix/resource/processor/b:a	(Lcom/tencent/matrix/resource/analyzer/model/DestroyedActivityInfo;)Z
      //   418: ifeq -278 -> 140
      //   421: ldc 32
      //   423: ldc 175
      //   425: iconst_2
      //   426: anewarray 4	java/lang/Object
      //   429: dup
      //   430: iconst_0
      //   431: aload_2
      //   432: getfield 112	com/tencent/matrix/resource/analyzer/model/DestroyedActivityInfo:mActivityName	Ljava/lang/String;
      //   435: aastore
      //   436: dup
      //   437: iconst_1
      //   438: aload_2
      //   439: getfield 138	com/tencent/matrix/resource/analyzer/model/DestroyedActivityInfo:mKey	Ljava/lang/String;
      //   442: aastore
      //   443: invokestatic 40	com/tencent/matrix/e/c:i	(Ljava/lang/String;Ljava/lang/String;[Ljava/lang/Object;)V
      //   446: aload_1
      //   447: invokeinterface 124 1 0
      //   452: goto -312 -> 140
      //   455: invokestatic 80	com/tencent/matrix/resource/f/b:azx	()V
      //   458: getstatic 51	com/tencent/matrix/resource/f/c$a$a:fdg	Lcom/tencent/matrix/resource/f/c$a$a;
      //   461: areturn
      // Local variable table:
      //   start	length	slot	name	signature
      //   0	462	0	this	2
      //   31	416	1	localObject1	Object
      //   60	1	2	localObject2	Object
      //   78	4	2	localObject3	Object
      //   158	281	2	localDestroyedActivityInfo	DestroyedActivityInfo
      // Exception table:
      //   from	to	target	type
      //   34	57	60	finally
      //   61	63	78	finally
    }
  };
  private final Handler mHandler;
  public final HandlerThread mHandlerThread;
  
  public b(Application paramApplication, com.tencent.matrix.resource.c paramc)
  {
    this(paramApplication, paramc, (byte)0);
  }
  
  private b(Application paramApplication, com.tencent.matrix.resource.c paramc, byte paramByte)
  {
    super(paramApplication, fcN, paramc.getTag(), paramc);
    this.fcO = paramc;
    paramApplication = paramc.eZp;
    this.mHandlerThread = com.tencent.matrix.e.b.T("matrix_res", 5);
    this.mHandler = new Handler(this.mHandlerThread.getLooper());
    this.fbd = paramApplication.fbd;
    this.fcR = paramApplication.azl();
    this.fcS = paramApplication.azk();
    paramc = this.mHandlerThread;
    this.fcP = new c(paramApplication.azk(), paramc);
    this.fcQ = paramApplication.azm();
    paramApplication = this.fbd;
    switch (3.fcZ[paramApplication.ordinal()])
    {
    default: 
      paramApplication = new com.tencent.matrix.resource.processor.f(this);
    }
    for (;;)
    {
      this.fcU = paramApplication;
      this.fcT = new ConcurrentLinkedQueue();
      return;
      paramApplication = new com.tencent.matrix.resource.processor.a(this);
      continue;
      paramApplication = new ManualDumpProcessor(this, this.fcO.eZp.fbf);
      continue;
      paramApplication = new g(this);
      continue;
      paramApplication = new d(this);
      continue;
      paramApplication = new com.tencent.matrix.resource.processor.c(this);
      continue;
      paramApplication = new e(this);
    }
  }
  
  private void azw()
  {
    this.fcP.azz();
    this.fcT.clear();
  }
  
  public static void azx()
  {
    com.tencent.matrix.e.c.v("Matrix.ActivityRefWatcher", "triggering gc...", new Object[0]);
    Runtime.getRuntime().gc();
    try
    {
      Thread.sleep(100L);
      Runtime.getRuntime().runFinalization();
      com.tencent.matrix.e.c.v("Matrix.ActivityRefWatcher", "gc was triggered.", new Object[0]);
      return;
    }
    catch (InterruptedException localInterruptedException)
    {
      for (;;)
      {
        com.tencent.matrix.e.c.printErrStackTrace("Matrix.ActivityRefWatcher", localInterruptedException, "", new Object[0]);
      }
    }
  }
  
  public final void azv()
  {
    Application localApplication = this.fcO.getApplication();
    if (localApplication != null)
    {
      localApplication.unregisterActivityLifecycleCallbacks(this.fcV);
      azw();
    }
  }
  
  public static final class a {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.matrix.resource.f.b
 * JD-Core Version:    0.7.0.1
 */