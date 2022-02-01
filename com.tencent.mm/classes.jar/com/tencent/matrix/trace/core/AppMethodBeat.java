package com.tencent.matrix.trace.core;

import android.app.Activity;
import android.os.Handler;
import android.os.HandlerThread;
import android.os.Looper;
import android.os.SystemClock;
import com.tencent.matrix.g.c;
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
    sTimerUpdateThread = com.tencent.matrix.g.b.dt("matrix_time_update_thread");
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
    sHandler.postDelayed(new Runnable()
    {
      public final void run() {}
    }, 15000L);
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
          c.e("Matrix.AppMethodBeat", localException.toString(), new Object[0]);
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
        c.i("Matrix.AppMethodBeat", "[at] visibleScene[%s] has %s focus!", new Object[] { getVisibleScene(), "attach" });
      }
    }
    while (!sFocusActivitySet.remove(???))
    {
      Iterator localIterator;
      return;
    }
    c.i("Matrix.AppMethodBeat", "[at] visibleScene[%s] has %s focus!", new Object[] { getVisibleScene(), "detach" });
  }
  
  private static void checkPileup(int paramInt)
  {
    a locala = sIndexRecordHead;
    while ((locala != null) && ((locala.index == paramInt) || ((locala.index == -1) && (sLastIndex == 999999))))
    {
      locala.cBN = false;
      c.w("Matrix.AppMethodBeat", "[checkPileup] %s", new Object[] { locala.toString() });
      locala = locala.cBM;
      sIndexRecordHead = locala;
    }
  }
  
  /* Error */
  private long[] copyData(a parama1, a parama2)
  {
    // Byte code:
    //   0: invokestatic 288	java/lang/System:currentTimeMillis	()J
    //   3: lstore 5
    //   5: iconst_0
    //   6: newarray long
    //   8: astore 9
    //   10: aload 9
    //   12: astore 8
    //   14: aload 9
    //   16: astore 7
    //   18: aload_1
    //   19: getfield 268	com/tencent/matrix/trace/core/AppMethodBeat$a:cBN	Z
    //   22: ifeq +336 -> 358
    //   25: aload 9
    //   27: astore 8
    //   29: aload 9
    //   31: astore 7
    //   33: aload_2
    //   34: getfield 268	com/tencent/matrix/trace/core/AppMethodBeat$a:cBN	Z
    //   37: ifeq +321 -> 358
    //   40: aload 9
    //   42: astore 8
    //   44: aload 9
    //   46: astore 7
    //   48: iconst_0
    //   49: aload_1
    //   50: getfield 264	com/tencent/matrix/trace/core/AppMethodBeat$a:index	I
    //   53: invokestatic 294	java/lang/Math:max	(II)I
    //   56: istore_3
    //   57: aload 9
    //   59: astore 8
    //   61: aload 9
    //   63: astore 7
    //   65: iconst_0
    //   66: aload_2
    //   67: getfield 264	com/tencent/matrix/trace/core/AppMethodBeat$a:index	I
    //   70: invokestatic 294	java/lang/Math:max	(II)I
    //   73: istore 4
    //   75: iload 4
    //   77: iload_3
    //   78: if_icmple +109 -> 187
    //   81: iload 4
    //   83: iload_3
    //   84: isub
    //   85: iconst_1
    //   86: iadd
    //   87: istore 4
    //   89: aload 9
    //   91: astore 8
    //   93: aload 9
    //   95: astore 7
    //   97: iload 4
    //   99: newarray long
    //   101: astore 9
    //   103: aload 9
    //   105: astore 8
    //   107: aload 9
    //   109: astore 7
    //   111: getstatic 93	com/tencent/matrix/trace/core/AppMethodBeat:sBuffer	[J
    //   114: iload_3
    //   115: aload 9
    //   117: iconst_0
    //   118: iload 4
    //   120: invokestatic 298	java/lang/System:arraycopy	(Ljava/lang/Object;ILjava/lang/Object;II)V
    //   123: aload 9
    //   125: astore 7
    //   127: ldc 39
    //   129: ldc_w 300
    //   132: iconst_4
    //   133: anewarray 4	java/lang/Object
    //   136: dup
    //   137: iconst_0
    //   138: iconst_0
    //   139: aload_1
    //   140: getfield 264	com/tencent/matrix/trace/core/AppMethodBeat$a:index	I
    //   143: invokestatic 294	java/lang/Math:max	(II)I
    //   146: invokestatic 306	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
    //   149: aastore
    //   150: dup
    //   151: iconst_1
    //   152: aload_2
    //   153: getfield 264	com/tencent/matrix/trace/core/AppMethodBeat$a:index	I
    //   156: invokestatic 306	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
    //   159: aastore
    //   160: dup
    //   161: iconst_2
    //   162: aload 7
    //   164: arraylength
    //   165: invokestatic 306	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
    //   168: aastore
    //   169: dup
    //   170: iconst_3
    //   171: invokestatic 288	java/lang/System:currentTimeMillis	()J
    //   174: lload 5
    //   176: lsub
    //   177: invokestatic 311	java/lang/Long:valueOf	(J)Ljava/lang/Long;
    //   180: aastore
    //   181: invokestatic 254	com/tencent/matrix/g/c:i	(Ljava/lang/String;Ljava/lang/String;[Ljava/lang/Object;)V
    //   184: aload 7
    //   186: areturn
    //   187: aload 9
    //   189: astore 7
    //   191: iload 4
    //   193: iload_3
    //   194: if_icmpge -67 -> 127
    //   197: aload 9
    //   199: astore 8
    //   201: aload 9
    //   203: astore 7
    //   205: iload 4
    //   207: iconst_1
    //   208: iadd
    //   209: getstatic 93	com/tencent/matrix/trace/core/AppMethodBeat:sBuffer	[J
    //   212: arraylength
    //   213: iload_3
    //   214: isub
    //   215: iadd
    //   216: newarray long
    //   218: astore 9
    //   220: aload 9
    //   222: astore 8
    //   224: aload 9
    //   226: astore 7
    //   228: getstatic 93	com/tencent/matrix/trace/core/AppMethodBeat:sBuffer	[J
    //   231: iload_3
    //   232: aload 9
    //   234: iconst_0
    //   235: getstatic 93	com/tencent/matrix/trace/core/AppMethodBeat:sBuffer	[J
    //   238: arraylength
    //   239: iload_3
    //   240: isub
    //   241: invokestatic 298	java/lang/System:arraycopy	(Ljava/lang/Object;ILjava/lang/Object;II)V
    //   244: aload 9
    //   246: astore 8
    //   248: aload 9
    //   250: astore 7
    //   252: getstatic 93	com/tencent/matrix/trace/core/AppMethodBeat:sBuffer	[J
    //   255: iconst_0
    //   256: aload 9
    //   258: getstatic 93	com/tencent/matrix/trace/core/AppMethodBeat:sBuffer	[J
    //   261: arraylength
    //   262: iload_3
    //   263: isub
    //   264: iload 4
    //   266: iconst_1
    //   267: iadd
    //   268: invokestatic 298	java/lang/System:arraycopy	(Ljava/lang/Object;ILjava/lang/Object;II)V
    //   271: aload 9
    //   273: astore 7
    //   275: goto -148 -> 127
    //   278: astore 9
    //   280: aload 8
    //   282: astore 7
    //   284: ldc 39
    //   286: aload 9
    //   288: invokevirtual 312	java/lang/OutOfMemoryError:toString	()Ljava/lang/String;
    //   291: iconst_0
    //   292: anewarray 4	java/lang/Object
    //   295: invokestatic 315	com/tencent/matrix/g/c:e	(Ljava/lang/String;Ljava/lang/String;[Ljava/lang/Object;)V
    //   298: ldc 39
    //   300: ldc_w 300
    //   303: iconst_4
    //   304: anewarray 4	java/lang/Object
    //   307: dup
    //   308: iconst_0
    //   309: iconst_0
    //   310: aload_1
    //   311: getfield 264	com/tencent/matrix/trace/core/AppMethodBeat$a:index	I
    //   314: invokestatic 294	java/lang/Math:max	(II)I
    //   317: invokestatic 306	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
    //   320: aastore
    //   321: dup
    //   322: iconst_1
    //   323: aload_2
    //   324: getfield 264	com/tencent/matrix/trace/core/AppMethodBeat$a:index	I
    //   327: invokestatic 306	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
    //   330: aastore
    //   331: dup
    //   332: iconst_2
    //   333: aload 8
    //   335: arraylength
    //   336: invokestatic 306	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
    //   339: aastore
    //   340: dup
    //   341: iconst_3
    //   342: invokestatic 288	java/lang/System:currentTimeMillis	()J
    //   345: lload 5
    //   347: lsub
    //   348: invokestatic 311	java/lang/Long:valueOf	(J)Ljava/lang/Long;
    //   351: aastore
    //   352: invokestatic 254	com/tencent/matrix/g/c:i	(Ljava/lang/String;Ljava/lang/String;[Ljava/lang/Object;)V
    //   355: aload 8
    //   357: areturn
    //   358: ldc 39
    //   360: ldc_w 300
    //   363: iconst_4
    //   364: anewarray 4	java/lang/Object
    //   367: dup
    //   368: iconst_0
    //   369: iconst_0
    //   370: aload_1
    //   371: getfield 264	com/tencent/matrix/trace/core/AppMethodBeat$a:index	I
    //   374: invokestatic 294	java/lang/Math:max	(II)I
    //   377: invokestatic 306	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
    //   380: aastore
    //   381: dup
    //   382: iconst_1
    //   383: aload_2
    //   384: getfield 264	com/tencent/matrix/trace/core/AppMethodBeat$a:index	I
    //   387: invokestatic 306	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
    //   390: aastore
    //   391: dup
    //   392: iconst_2
    //   393: iconst_0
    //   394: invokestatic 306	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
    //   397: aastore
    //   398: dup
    //   399: iconst_3
    //   400: invokestatic 288	java/lang/System:currentTimeMillis	()J
    //   403: lload 5
    //   405: lsub
    //   406: invokestatic 311	java/lang/Long:valueOf	(J)Ljava/lang/Long;
    //   409: aastore
    //   410: invokestatic 254	com/tencent/matrix/g/c:i	(Ljava/lang/String;Ljava/lang/String;[Ljava/lang/Object;)V
    //   413: aload 9
    //   415: areturn
    //   416: astore 8
    //   418: ldc 39
    //   420: ldc_w 300
    //   423: iconst_4
    //   424: anewarray 4	java/lang/Object
    //   427: dup
    //   428: iconst_0
    //   429: iconst_0
    //   430: aload_1
    //   431: getfield 264	com/tencent/matrix/trace/core/AppMethodBeat$a:index	I
    //   434: invokestatic 294	java/lang/Math:max	(II)I
    //   437: invokestatic 306	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
    //   440: aastore
    //   441: dup
    //   442: iconst_1
    //   443: aload_2
    //   444: getfield 264	com/tencent/matrix/trace/core/AppMethodBeat$a:index	I
    //   447: invokestatic 306	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
    //   450: aastore
    //   451: dup
    //   452: iconst_2
    //   453: aload 7
    //   455: arraylength
    //   456: invokestatic 306	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
    //   459: aastore
    //   460: dup
    //   461: iconst_3
    //   462: invokestatic 288	java/lang/System:currentTimeMillis	()J
    //   465: lload 5
    //   467: lsub
    //   468: invokestatic 311	java/lang/Long:valueOf	(J)Ljava/lang/Long;
    //   471: aastore
    //   472: invokestatic 254	com/tencent/matrix/g/c:i	(Ljava/lang/String;Ljava/lang/String;[Ljava/lang/Object;)V
    //   475: aload 8
    //   477: athrow
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	478	0	this	AppMethodBeat
    //   0	478	1	parama1	a
    //   0	478	2	parama2	a
    //   56	208	3	i	int
    //   73	195	4	j	int
    //   3	463	5	l	long
    //   16	438	7	arrayOfLong1	long[]
    //   12	344	8	arrayOfLong2	long[]
    //   416	60	8	localObject	Object
    //   8	264	9	arrayOfLong3	long[]
    //   278	136	9	localOutOfMemoryError	java.lang.OutOfMemoryError
    // Exception table:
    //   from	to	target	type
    //   18	25	278	java/lang/OutOfMemoryError
    //   33	40	278	java/lang/OutOfMemoryError
    //   48	57	278	java/lang/OutOfMemoryError
    //   65	75	278	java/lang/OutOfMemoryError
    //   97	103	278	java/lang/OutOfMemoryError
    //   111	123	278	java/lang/OutOfMemoryError
    //   205	220	278	java/lang/OutOfMemoryError
    //   228	244	278	java/lang/OutOfMemoryError
    //   252	271	278	java/lang/OutOfMemoryError
    //   18	25	416	finally
    //   33	40	416	finally
    //   48	57	416	finally
    //   65	75	416	finally
    //   97	103	416	finally
    //   111	123	416	finally
    //   205	220	416	finally
    //   228	244	416	finally
    //   252	271	416	finally
    //   284	298	416	finally
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
    return com.tencent.matrix.a.csS.csV;
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
        long l = Thread.currentThread().getId();
        if (sMethodEnterListener != null) {
          sMethodEnterListener.s(paramInt, l);
        }
        if ((l != sMainThreadId) || (assertIn)) {
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
    long l3 = sCurrentDiffTime;
    sBuffer[paramInt2] = (l1 | l2 << 43 | l3 & 0xFFFFFFFF);
    checkPileup(paramInt2);
    sLastIndex = paramInt2;
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
    c.i("Matrix.AppMethodBeat", "[realExecute] timestamp:%s", new Object[] { Long.valueOf(System.currentTimeMillis()) });
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
          c.i("Matrix.AppMethodBeat", "[startExpired] timestamp:%s status:%s", new Object[] { Long.valueOf(System.currentTimeMillis()), Integer.valueOf(AppMethodBeat.status) });
          if ((AppMethodBeat.status == 2147483647) || (AppMethodBeat.status == 1)) {
            AppMethodBeat.access$002(-2);
          }
          return;
        }
      }
    };
    checkStartExpiredRunnable = local4;
    localHandler.postDelayed(local4, 15000L);
    com.tencent.matrix.trace.c.a.HV();
    a.a(looperMonitorListener);
  }
  
  private static void realRelease()
  {
    synchronized (statusLock)
    {
      if (status == 2147483647)
      {
        c.i("Matrix.AppMethodBeat", "[realRelease] timestamp:%s", new Object[] { Long.valueOf(System.currentTimeMillis()) });
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
          locala2.cBM = paramString;
          return locala2;
        }
        paramString = ((a)localObject).cBM;
        ((a)localObject).cBM = locala2;
        locala2.cBM = paramString;
        return locala2;
      }
      a locala1 = paramString.cBM;
      localObject = paramString;
      paramString = locala1;
    }
    ((a)localObject).cBM = locala2;
    return locala2;
  }
  
  public void onStart()
  {
    synchronized (statusLock)
    {
      if ((status >= 2) || (status < -2)) {
        break label86;
      }
      sHandler.removeCallbacks(checkStartExpiredRunnable);
      if (sBuffer == null) {
        throw new RuntimeException("Matrix.AppMethodBeat sBuffer == null");
      }
    }
    c.i("Matrix.AppMethodBeat", "[onStart] preStatus:%s", new Object[] { Integer.valueOf(status), com.tencent.matrix.trace.g.b.getStack() });
    status = 2;
    for (;;)
    {
      return;
      label86:
      c.w("Matrix.AppMethodBeat", "[onStart] current status:%s", new Object[] { Integer.valueOf(status) });
    }
  }
  
  public void onStop()
  {
    synchronized (statusLock)
    {
      if (status == 2)
      {
        c.i("Matrix.AppMethodBeat", "[onStop] %s", new Object[] { com.tencent.matrix.trace.g.b.getStack() });
        status = -1;
        return;
      }
      c.w("Matrix.AppMethodBeat", "[onStop] current status:%s", new Object[] { Integer.valueOf(status) });
    }
  }
  
  public void printIndexRecord()
  {
    StringBuilder localStringBuilder = new StringBuilder(" \n");
    for (a locala = sIndexRecordHead; locala != null; locala = locala.cBM) {
      localStringBuilder.append(locala).append("\n");
    }
    c.i("Matrix.AppMethodBeat", "[printIndexRecord] %s", new Object[] { localStringBuilder.toString() });
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
    a cBM;
    public boolean cBN = true;
    public int index;
    public String source;
    
    public a()
    {
      this.cBN = false;
    }
    
    public a(int paramInt)
    {
      this.index = paramInt;
    }
    
    public final void release()
    {
      this.cBN = false;
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
          localObject2.cBM = ((a)localObject1).cBM;
        }
        for (;;)
        {
          ((a)localObject1).cBM = null;
          return;
          label38:
          AppMethodBeat.access$1002(((a)localObject1).cBM);
        }
        label49:
        a locala = ((a)localObject1).cBM;
        localObject2 = localObject1;
        localObject1 = locala;
      }
    }
    
    public final String toString()
    {
      return "index:" + this.index + ",\tisValid:" + this.cBN + " source:" + this.source;
    }
  }
  
  public static abstract interface b
  {
    public abstract void s(int paramInt, long paramLong);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.matrix.trace.core.AppMethodBeat
 * JD-Core Version:    0.7.0.1
 */