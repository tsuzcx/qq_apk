package com.tencent.matrix.trace.core;

import android.app.Activity;
import android.os.Handler;
import android.os.HandlerThread;
import android.os.Looper;
import android.os.SystemClock;
import com.tencent.matrix.e.b;
import java.util.HashSet;
import java.util.Iterator;
import java.util.Set;

public class AppMethodBeat
{
  public static final int METHOD_ID_DISPATCH = 1048574;
  private static final int METHOD_ID_MAX = 1048575;
  private static final int STATUS_DEFAULT = 2147483647;
  private static final int STATUS_EXPIRED_START = -2;
  private static final int STATUS_OUT_RELEASE = -3;
  private static final int STATUS_READY = 1;
  private static final int STATUS_STARTED = 2;
  private static final int STATUS_STOPPED = -1;
  private static final String TAG = "Matrix.AppMethodBeat";
  private static boolean assertIn;
  private static Runnable checkStartExpiredRunnable;
  public static boolean isDev = false;
  private static volatile boolean isPauseUpdateTime;
  private static final HashSet<com.tencent.matrix.trace.e.a> listeners;
  private static a.a looperMonitorListener;
  private static Runnable realReleaseRunnable;
  private static long[] sBuffer;
  private static volatile long sCurrentDiffTime;
  private static volatile long sDiffTime;
  private static Set<String> sFocusActivitySet;
  private static Handler sHandler;
  private static int sIndex;
  private static a sIndexRecordHead = null;
  private static AppMethodBeat sInstance = new AppMethodBeat();
  private static int sLastIndex;
  private static long sMainThreadId;
  public static b sMethodEnterListener;
  private static HandlerThread sTimerUpdateThread;
  private static Runnable sUpdateDiffTimeRunnable;
  private static volatile int status = 2147483647;
  private static final Object statusLock = new Object();
  private static final Object updateTimeLock;
  
  static
  {
    sBuffer = new long[1000000];
    sIndex = 0;
    sLastIndex = -1;
    assertIn = false;
    long l = SystemClock.uptimeMillis();
    sCurrentDiffTime = l;
    sDiffTime = l;
    sMainThreadId = Looper.getMainLooper().getThread().getId();
    sTimerUpdateThread = b.T("matrix_time_update_thread", 3);
    sHandler = new Handler(sTimerUpdateThread.getLooper());
    sFocusActivitySet = new HashSet();
    listeners = new HashSet();
    updateTimeLock = new Object();
    isPauseUpdateTime = false;
    checkStartExpiredRunnable = null;
    looperMonitorListener = new a.a()
    {
      public final void dispatchEnd()
      {
        super.dispatchEnd();
        AppMethodBeat.access$200();
      }
      
      public final void dispatchStart()
      {
        super.dispatchStart();
        AppMethodBeat.access$100();
      }
      
      public final boolean isValid()
      {
        return AppMethodBeat.status > 0;
      }
    };
    realReleaseRunnable = new Runnable()
    {
      public final void run() {}
    };
    b.aAp().postDelayed(realReleaseRunnable, 10000L);
    sUpdateDiffTimeRunnable = new Runnable()
    {
      public final void run()
      {
        try
        {
          for (;;)
          {
            if ((!AppMethodBeat.isPauseUpdateTime) && (AppMethodBeat.status >= 0))
            {
              AppMethodBeat.access$502(SystemClock.uptimeMillis() - AppMethodBeat.sDiffTime);
              SystemClock.sleep(5L);
              continue;
            }
            synchronized (AppMethodBeat.updateTimeLock)
            {
              AppMethodBeat.updateTimeLock.wait();
            }
          }
        }
        catch (Exception localException)
        {
          com.tencent.matrix.e.c.e("Matrix.AppMethodBeat", localException.toString(), new Object[0]);
          return;
        }
      }
    };
  }
  
  public static void at(Activity paramActivity, boolean paramBoolean)
  {
    ??? = paramActivity.getClass().getName();
    if (paramBoolean) {
      if (sFocusActivitySet.add(???))
      {
        synchronized (listeners)
        {
          localIterator = listeners.iterator();
          if (localIterator.hasNext()) {
            ((com.tencent.matrix.trace.e.a)localIterator.next()).n(paramActivity);
          }
        }
        com.tencent.matrix.e.c.i("Matrix.AppMethodBeat", "[at] visibleScene[%s] has %s focus!", new Object[] { getVisibleScene(), "attach" });
      }
    }
    while (!sFocusActivitySet.remove(???))
    {
      Iterator localIterator;
      return;
    }
    com.tencent.matrix.e.c.i("Matrix.AppMethodBeat", "[at] visibleScene[%s] has %s focus!", new Object[] { getVisibleScene(), "detach" });
  }
  
  private static void checkPileup(int paramInt)
  {
    a locala = sIndexRecordHead;
    while ((locala != null) && ((locala.index == paramInt) || ((locala.index == -1) && (sLastIndex == 999999))))
    {
      locala.clZ = false;
      com.tencent.matrix.e.c.w("Matrix.AppMethodBeat", "[checkPileup] %s", new Object[] { locala.toString() });
      locala = a.a(locala);
      sIndexRecordHead = locala;
    }
  }
  
  /* Error */
  private long[] copyData(a parama1, a parama2)
  {
    // Byte code:
    //   0: invokestatic 292	java/lang/System:currentTimeMillis	()J
    //   3: lstore 5
    //   5: iconst_0
    //   6: newarray long
    //   8: astore 8
    //   10: aload 8
    //   12: astore 7
    //   14: aload_1
    //   15: getfield 275	com/tencent/matrix/trace/core/AppMethodBeat$a:clZ	Z
    //   18: ifeq +300 -> 318
    //   21: aload 8
    //   23: astore 7
    //   25: aload_2
    //   26: getfield 275	com/tencent/matrix/trace/core/AppMethodBeat$a:clZ	Z
    //   29: ifeq +289 -> 318
    //   32: aload 8
    //   34: astore 7
    //   36: iconst_0
    //   37: aload_1
    //   38: getfield 271	com/tencent/matrix/trace/core/AppMethodBeat$a:index	I
    //   41: invokestatic 298	java/lang/Math:max	(II)I
    //   44: istore_3
    //   45: aload 8
    //   47: astore 7
    //   49: iconst_0
    //   50: aload_2
    //   51: getfield 271	com/tencent/matrix/trace/core/AppMethodBeat$a:index	I
    //   54: invokestatic 298	java/lang/Math:max	(II)I
    //   57: istore 4
    //   59: iload 4
    //   61: iload_3
    //   62: if_icmple +101 -> 163
    //   65: iload 4
    //   67: iload_3
    //   68: isub
    //   69: iconst_1
    //   70: iadd
    //   71: istore 4
    //   73: aload 8
    //   75: astore 7
    //   77: iload 4
    //   79: newarray long
    //   81: astore 8
    //   83: aload 8
    //   85: astore 7
    //   87: getstatic 94	com/tencent/matrix/trace/core/AppMethodBeat:sBuffer	[J
    //   90: iload_3
    //   91: aload 8
    //   93: iconst_0
    //   94: iload 4
    //   96: invokestatic 302	java/lang/System:arraycopy	(Ljava/lang/Object;ILjava/lang/Object;II)V
    //   99: aload 8
    //   101: astore 7
    //   103: ldc 39
    //   105: ldc_w 304
    //   108: iconst_4
    //   109: anewarray 4	java/lang/Object
    //   112: dup
    //   113: iconst_0
    //   114: iconst_0
    //   115: aload_1
    //   116: getfield 271	com/tencent/matrix/trace/core/AppMethodBeat$a:index	I
    //   119: invokestatic 298	java/lang/Math:max	(II)I
    //   122: invokestatic 310	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
    //   125: aastore
    //   126: dup
    //   127: iconst_1
    //   128: aload_2
    //   129: getfield 271	com/tencent/matrix/trace/core/AppMethodBeat$a:index	I
    //   132: invokestatic 310	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
    //   135: aastore
    //   136: dup
    //   137: iconst_2
    //   138: aload 7
    //   140: arraylength
    //   141: invokestatic 310	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
    //   144: aastore
    //   145: dup
    //   146: iconst_3
    //   147: invokestatic 292	java/lang/System:currentTimeMillis	()J
    //   150: lload 5
    //   152: lsub
    //   153: invokestatic 315	java/lang/Long:valueOf	(J)Ljava/lang/Long;
    //   156: aastore
    //   157: invokestatic 261	com/tencent/matrix/e/c:i	(Ljava/lang/String;Ljava/lang/String;[Ljava/lang/Object;)V
    //   160: aload 7
    //   162: areturn
    //   163: aload 8
    //   165: astore 7
    //   167: iload 4
    //   169: iload_3
    //   170: if_icmpge -67 -> 103
    //   173: aload 8
    //   175: astore 7
    //   177: iload 4
    //   179: iconst_1
    //   180: iadd
    //   181: getstatic 94	com/tencent/matrix/trace/core/AppMethodBeat:sBuffer	[J
    //   184: arraylength
    //   185: iload_3
    //   186: isub
    //   187: iadd
    //   188: newarray long
    //   190: astore 8
    //   192: aload 8
    //   194: astore 7
    //   196: getstatic 94	com/tencent/matrix/trace/core/AppMethodBeat:sBuffer	[J
    //   199: iload_3
    //   200: aload 8
    //   202: iconst_0
    //   203: getstatic 94	com/tencent/matrix/trace/core/AppMethodBeat:sBuffer	[J
    //   206: arraylength
    //   207: iload_3
    //   208: isub
    //   209: invokestatic 302	java/lang/System:arraycopy	(Ljava/lang/Object;ILjava/lang/Object;II)V
    //   212: aload 8
    //   214: astore 7
    //   216: getstatic 94	com/tencent/matrix/trace/core/AppMethodBeat:sBuffer	[J
    //   219: iconst_0
    //   220: aload 8
    //   222: getstatic 94	com/tencent/matrix/trace/core/AppMethodBeat:sBuffer	[J
    //   225: arraylength
    //   226: iload_3
    //   227: isub
    //   228: iload 4
    //   230: iconst_1
    //   231: iadd
    //   232: invokestatic 302	java/lang/System:arraycopy	(Ljava/lang/Object;ILjava/lang/Object;II)V
    //   235: aload 8
    //   237: astore 7
    //   239: goto -136 -> 103
    //   242: astore 8
    //   244: ldc 39
    //   246: aload 8
    //   248: invokevirtual 318	java/lang/Throwable:toString	()Ljava/lang/String;
    //   251: iconst_0
    //   252: anewarray 4	java/lang/Object
    //   255: invokestatic 321	com/tencent/matrix/e/c:e	(Ljava/lang/String;Ljava/lang/String;[Ljava/lang/Object;)V
    //   258: ldc 39
    //   260: ldc_w 304
    //   263: iconst_4
    //   264: anewarray 4	java/lang/Object
    //   267: dup
    //   268: iconst_0
    //   269: iconst_0
    //   270: aload_1
    //   271: getfield 271	com/tencent/matrix/trace/core/AppMethodBeat$a:index	I
    //   274: invokestatic 298	java/lang/Math:max	(II)I
    //   277: invokestatic 310	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
    //   280: aastore
    //   281: dup
    //   282: iconst_1
    //   283: aload_2
    //   284: getfield 271	com/tencent/matrix/trace/core/AppMethodBeat$a:index	I
    //   287: invokestatic 310	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
    //   290: aastore
    //   291: dup
    //   292: iconst_2
    //   293: aload 7
    //   295: arraylength
    //   296: invokestatic 310	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
    //   299: aastore
    //   300: dup
    //   301: iconst_3
    //   302: invokestatic 292	java/lang/System:currentTimeMillis	()J
    //   305: lload 5
    //   307: lsub
    //   308: invokestatic 315	java/lang/Long:valueOf	(J)Ljava/lang/Long;
    //   311: aastore
    //   312: invokestatic 261	com/tencent/matrix/e/c:i	(Ljava/lang/String;Ljava/lang/String;[Ljava/lang/Object;)V
    //   315: aload 7
    //   317: areturn
    //   318: ldc 39
    //   320: ldc_w 304
    //   323: iconst_4
    //   324: anewarray 4	java/lang/Object
    //   327: dup
    //   328: iconst_0
    //   329: iconst_0
    //   330: aload_1
    //   331: getfield 271	com/tencent/matrix/trace/core/AppMethodBeat$a:index	I
    //   334: invokestatic 298	java/lang/Math:max	(II)I
    //   337: invokestatic 310	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
    //   340: aastore
    //   341: dup
    //   342: iconst_1
    //   343: aload_2
    //   344: getfield 271	com/tencent/matrix/trace/core/AppMethodBeat$a:index	I
    //   347: invokestatic 310	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
    //   350: aastore
    //   351: dup
    //   352: iconst_2
    //   353: iconst_0
    //   354: invokestatic 310	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
    //   357: aastore
    //   358: dup
    //   359: iconst_3
    //   360: invokestatic 292	java/lang/System:currentTimeMillis	()J
    //   363: lload 5
    //   365: lsub
    //   366: invokestatic 315	java/lang/Long:valueOf	(J)Ljava/lang/Long;
    //   369: aastore
    //   370: invokestatic 261	com/tencent/matrix/e/c:i	(Ljava/lang/String;Ljava/lang/String;[Ljava/lang/Object;)V
    //   373: aload 8
    //   375: areturn
    //   376: astore 8
    //   378: ldc 39
    //   380: ldc_w 304
    //   383: iconst_4
    //   384: anewarray 4	java/lang/Object
    //   387: dup
    //   388: iconst_0
    //   389: iconst_0
    //   390: aload_1
    //   391: getfield 271	com/tencent/matrix/trace/core/AppMethodBeat$a:index	I
    //   394: invokestatic 298	java/lang/Math:max	(II)I
    //   397: invokestatic 310	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
    //   400: aastore
    //   401: dup
    //   402: iconst_1
    //   403: aload_2
    //   404: getfield 271	com/tencent/matrix/trace/core/AppMethodBeat$a:index	I
    //   407: invokestatic 310	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
    //   410: aastore
    //   411: dup
    //   412: iconst_2
    //   413: aload 7
    //   415: arraylength
    //   416: invokestatic 310	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
    //   419: aastore
    //   420: dup
    //   421: iconst_3
    //   422: invokestatic 292	java/lang/System:currentTimeMillis	()J
    //   425: lload 5
    //   427: lsub
    //   428: invokestatic 315	java/lang/Long:valueOf	(J)Ljava/lang/Long;
    //   431: aastore
    //   432: invokestatic 261	com/tencent/matrix/e/c:i	(Ljava/lang/String;Ljava/lang/String;[Ljava/lang/Object;)V
    //   435: aload 8
    //   437: athrow
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	438	0	this	AppMethodBeat
    //   0	438	1	parama1	a
    //   0	438	2	parama2	a
    //   44	184	3	i	int
    //   57	175	4	j	int
    //   3	423	5	l	long
    //   12	402	7	arrayOfLong1	long[]
    //   8	228	8	arrayOfLong2	long[]
    //   242	132	8	arrayOfLong3	long[]
    //   376	60	8	localObject	Object
    // Exception table:
    //   from	to	target	type
    //   14	21	242	finally
    //   25	32	242	finally
    //   36	45	242	finally
    //   49	59	242	finally
    //   77	83	242	finally
    //   87	99	242	finally
    //   177	192	242	finally
    //   196	212	242	finally
    //   216	235	242	finally
    //   244	258	376	finally
  }
  
  private static void dispatchBegin()
  {
    sCurrentDiffTime = SystemClock.uptimeMillis() - sDiffTime;
    isPauseUpdateTime = false;
    synchronized (updateTimeLock)
    {
      updateTimeLock.notify();
      return;
    }
  }
  
  private static void dispatchEnd()
  {
    isPauseUpdateTime = true;
  }
  
  public static long getDiffTime()
  {
    return sDiffTime;
  }
  
  public static AppMethodBeat getInstance()
  {
    return sInstance;
  }
  
  public static String getVisibleScene()
  {
    return com.tencent.matrix.a.eLw.eLy;
  }
  
  public static void i(int paramInt)
  {
    if (status < 0) {}
    while (paramInt >= 1048575) {
      return;
    }
    if (status == 2147483647) {}
    for (;;)
    {
      synchronized (statusLock)
      {
        if (status == 2147483647)
        {
          realExecute();
          status = 1;
        }
        if ((Thread.currentThread().getId() != sMainThreadId) || (assertIn)) {
          break;
        }
        assertIn = true;
        if (sIndex < 1000000)
        {
          mergeData(paramInt, sIndex, true);
          sIndex += 1;
          assertIn = false;
          return;
        }
      }
      sIndex = 0;
      mergeData(paramInt, sIndex, true);
    }
  }
  
  public static boolean isRealTrace()
  {
    return status > 0;
  }
  
  private static void mergeData(int paramInt1, int paramInt2, boolean paramBoolean)
  {
    if (paramInt1 == 1048574) {
      sCurrentDiffTime = SystemClock.uptimeMillis() - sDiffTime;
    }
    long l1 = 0L;
    if (paramBoolean) {
      l1 = -9223372036854775808L;
    }
    long l2 = paramInt1;
    try
    {
      long l3 = sCurrentDiffTime;
      sBuffer[paramInt2] = (l1 | l2 << 43 | l3 & 0xFFFFFFFF);
      checkPileup(paramInt2);
      sLastIndex = paramInt2;
      return;
    }
    finally
    {
      com.tencent.matrix.e.c.e("Matrix.AppMethodBeat", localObject.getMessage(), new Object[0]);
    }
  }
  
  public static void o(int paramInt)
  {
    if (status < 0) {}
    while ((paramInt >= 1048575) || (Thread.currentThread().getId() != sMainThreadId)) {
      return;
    }
    if (sIndex < 1000000) {
      mergeData(paramInt, sIndex, false);
    }
    for (;;)
    {
      sIndex += 1;
      return;
      sIndex = 0;
      mergeData(paramInt, sIndex, false);
    }
  }
  
  private static void realExecute()
  {
    com.tencent.matrix.e.c.i("Matrix.AppMethodBeat", "[realExecute] timestamp:%s", new Object[] { Long.valueOf(System.currentTimeMillis()) });
    sCurrentDiffTime = SystemClock.uptimeMillis() - sDiffTime;
    sHandler.removeCallbacksAndMessages(null);
    sHandler.postDelayed(sUpdateDiffTimeRunnable, 5L);
    Handler localHandler = sHandler;
    Runnable local4 = new Runnable()
    {
      public final void run()
      {
        synchronized (AppMethodBeat.statusLock)
        {
          com.tencent.matrix.e.c.i("Matrix.AppMethodBeat", "[startExpired] timestamp:%s status:%s", new Object[] { Long.valueOf(System.currentTimeMillis()), Integer.valueOf(AppMethodBeat.status) });
          if ((AppMethodBeat.status == 2147483647) || (AppMethodBeat.status == 1)) {
            AppMethodBeat.access$002(-2);
          }
          return;
        }
      }
    };
    checkStartExpiredRunnable = local4;
    localHandler.postDelayed(local4, 10000L);
    com.tencent.matrix.trace.c.a.azM();
    a.a(looperMonitorListener);
  }
  
  private static void realRelease()
  {
    synchronized (statusLock)
    {
      if ((status == 2147483647) || (status <= 1))
      {
        com.tencent.matrix.e.c.i("Matrix.AppMethodBeat", "[realRelease] timestamp:%s", new Object[] { Long.valueOf(System.currentTimeMillis()) });
        sHandler.removeCallbacksAndMessages(null);
        a.b(looperMonitorListener);
        sTimerUpdateThread.quit();
        sBuffer = null;
        status = -3;
      }
      return;
    }
  }
  
  public void addListener(com.tencent.matrix.trace.e.a parama)
  {
    synchronized (listeners)
    {
      listeners.add(parama);
      return;
    }
  }
  
  public long[] copyData(a parama)
  {
    return copyData(parama, new a(sIndex - 1));
  }
  
  public void forceStop()
  {
    synchronized (statusLock)
    {
      status = -1;
      return;
    }
  }
  
  public boolean isAlive()
  {
    return status >= 2;
  }
  
  public a maskIndex(String paramString)
  {
    if (sIndexRecordHead == null)
    {
      localObject = new a(sIndex - 1);
      sIndexRecordHead = (a)localObject;
      ((a)localObject).source = paramString;
      return sIndexRecordHead;
    }
    a locala2 = new a(sIndex - 1);
    locala2.source = paramString;
    paramString = sIndexRecordHead;
    Object localObject = null;
    while (paramString != null)
    {
      if (locala2.index <= paramString.index)
      {
        if (localObject == null)
        {
          paramString = sIndexRecordHead;
          sIndexRecordHead = locala2;
          a.a(locala2, paramString);
          return locala2;
        }
        paramString = a.a((a)localObject);
        a.a((a)localObject, locala2);
        a.a(locala2, paramString);
        return locala2;
      }
      a locala1 = a.a(paramString);
      localObject = paramString;
      paramString = locala1;
    }
    a.a((a)localObject, locala2);
    return locala2;
  }
  
  public void onStart()
  {
    synchronized (statusLock)
    {
      if ((status >= 2) || (status < -2)) {
        break label95;
      }
      sHandler.removeCallbacks(checkStartExpiredRunnable);
      b.aAp().removeCallbacks(realReleaseRunnable);
      if (sBuffer == null) {
        throw new RuntimeException("Matrix.AppMethodBeat sBuffer == null");
      }
    }
    com.tencent.matrix.e.c.i("Matrix.AppMethodBeat", "[onStart] preStatus:%s", new Object[] { Integer.valueOf(status), com.tencent.matrix.trace.f.c.getStack() });
    status = 2;
    for (;;)
    {
      return;
      label95:
      com.tencent.matrix.e.c.w("Matrix.AppMethodBeat", "[onStart] current status:%s", new Object[] { Integer.valueOf(status) });
    }
  }
  
  public void onStop()
  {
    synchronized (statusLock)
    {
      if (status == 2)
      {
        com.tencent.matrix.e.c.i("Matrix.AppMethodBeat", "[onStop] %s", new Object[] { com.tencent.matrix.trace.f.c.getStack() });
        status = -1;
        return;
      }
      com.tencent.matrix.e.c.w("Matrix.AppMethodBeat", "[onStop] current status:%s", new Object[] { Integer.valueOf(status) });
    }
  }
  
  public void printIndexRecord()
  {
    StringBuilder localStringBuilder = new StringBuilder(" \n");
    for (a locala = sIndexRecordHead; locala != null; locala = a.a(locala)) {
      localStringBuilder.append(locala).append("\n");
    }
    com.tencent.matrix.e.c.i("Matrix.AppMethodBeat", "[printIndexRecord] %s", new Object[] { localStringBuilder.toString() });
  }
  
  public void removeListener(com.tencent.matrix.trace.e.a parama)
  {
    synchronized (listeners)
    {
      listeners.remove(parama);
      return;
    }
  }
  
  public static final class a
  {
    public boolean clZ = true;
    private a feh;
    public int index;
    public String source;
    
    public a()
    {
      this.clZ = false;
    }
    
    public a(int paramInt)
    {
      this.index = paramInt;
    }
    
    public final void release()
    {
      this.clZ = false;
      Object localObject1 = AppMethodBeat.sIndexRecordHead;
      Object localObject2 = null;
      for (;;)
      {
        if (localObject1 != null)
        {
          if (localObject1 != this) {
            break label49;
          }
          if (localObject2 == null) {
            break label38;
          }
          localObject2.feh = ((a)localObject1).feh;
        }
        for (;;)
        {
          ((a)localObject1).feh = null;
          return;
          label38:
          AppMethodBeat.access$1002(((a)localObject1).feh);
        }
        label49:
        a locala = ((a)localObject1).feh;
        localObject2 = localObject1;
        localObject1 = locala;
      }
    }
    
    public final String toString()
    {
      return "index:" + this.index + ",\tisValid:" + this.clZ + " source:" + this.source;
    }
  }
  
  public static abstract interface b {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.matrix.trace.core.AppMethodBeat
 * JD-Core Version:    0.7.0.1
 */