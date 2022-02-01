package com.tencent.matrix.trace.tracer;

import android.app.Activity;
import android.app.Application;
import android.app.Application.ActivityLifecycleCallbacks;
import android.os.Bundle;
import android.os.Handler;
import android.os.HandlerThread;
import android.view.Display;
import android.view.FrameMetrics;
import android.view.Window;
import android.view.Window.OnFrameMetricsAvailableListener;
import android.view.WindowManager;
import com.tencent.b.a.a.a;
import java.util.Arrays;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.concurrent.Executor;
import org.json.JSONException;
import org.json.JSONObject;

public final class b
  extends g
  implements Application.ActivityLifecycleCallbacks
{
  private static boolean feF;
  private long aft;
  private final com.tencent.matrix.trace.a.b fdU;
  private int ffA;
  private final long ffB;
  private boolean ffC;
  private long ffD;
  private long ffE;
  private long ffF;
  private long ffG;
  public int ffH = 0;
  private long ffI = 0L;
  private Map<String, Long> ffJ = new HashMap();
  private Map<Integer, Window.OnFrameMetricsAvailableListener> ffK = new HashMap();
  public a ffy;
  public int ffz = 0;
  private final HashSet<com.tencent.matrix.trace.e.b> listeners = new HashSet();
  
  public b(com.tencent.matrix.trace.a.b paramb, boolean paramBoolean)
  {
    feF = paramBoolean;
    this.fdU = paramb;
    this.aft = com.tencent.matrix.trace.core.b.azL().eLi;
    if (paramb.fbi == null)
    {
      i = 10000;
      this.ffB = i;
      this.ffC = paramb.fdB;
      if (paramb.fbi != null) {
        break label233;
      }
      i = 42;
      label106:
      this.ffD = i;
      if (paramb.fbi != null) {
        break label254;
      }
      i = 24;
      label122:
      this.ffE = i;
      if (paramb.fbi != null) {
        break label275;
      }
      i = 3;
      label137:
      this.ffG = i;
      if (paramb.fbi != null) {
        break label295;
      }
    }
    label275:
    label295:
    for (int i = 9;; i = paramb.fbi.L(a.a.ahac.name(), 9))
    {
      this.ffF = i;
      com.tencent.matrix.e.c.i("Matrix.FrameTracer", "[init] frameIntervalMs:%s isFPSEnable:%s", new Object[] { Long.valueOf(this.aft), Boolean.valueOf(this.ffC) });
      if (this.ffC) {
        a(new c((byte)0));
      }
      return;
      i = paramb.fbi.L(a.a.agZZ.name(), 10000);
      break;
      label233:
      i = paramb.fbi.L(a.a.ahae.name(), 42);
      break label106;
      label254:
      i = paramb.fbi.L(a.a.ahad.name(), 24);
      break label122;
      i = paramb.fbi.L(a.a.ahab.name(), 3);
      break label137;
    }
  }
  
  /* Error */
  private void b(final String paramString, final long paramLong1, long paramLong2, boolean paramBoolean, final long paramLong3, final long paramLong4, final long paramLong5, long paramLong6)
  {
    // Byte code:
    //   0: invokestatic 181	java/lang/System:currentTimeMillis	()J
    //   3: lstore 17
    //   5: lload 4
    //   7: lload 7
    //   9: lsub
    //   10: lstore 19
    //   12: lload 19
    //   14: aload_0
    //   15: getfield 89	com/tencent/matrix/trace/tracer/b:aft	J
    //   18: ldiv
    //   19: l2i
    //   20: istore 15
    //   22: aload_0
    //   23: getfield 183	com/tencent/matrix/trace/tracer/b:ffy	Lcom/tencent/matrix/trace/tracer/b$a;
    //   26: ifnull +60 -> 86
    //   29: aload_0
    //   30: getfield 63	com/tencent/matrix/trace/tracer/b:ffz	I
    //   33: istore 16
    //   35: iload 15
    //   37: iload 16
    //   39: if_icmple +47 -> 86
    //   42: invokestatic 188	com/tencent/matrix/a:avV	()Ljava/lang/String;
    //   45: ifnull +41 -> 86
    //   48: aload_0
    //   49: getfield 72	com/tencent/matrix/trace/tracer/b:ffJ	Ljava/util/Map;
    //   52: invokestatic 188	com/tencent/matrix/a:avV	()Ljava/lang/String;
    //   55: invokeinterface 194 2 0
    //   60: checkcast 118	java/lang/Long
    //   63: invokevirtual 197	java/lang/Long:longValue	()J
    //   66: lstore 21
    //   68: aload_0
    //   69: getfield 183	com/tencent/matrix/trace/tracer/b:ffy	Lcom/tencent/matrix/trace/tracer/b$a;
    //   72: iload 15
    //   74: lload 19
    //   76: invokestatic 188	com/tencent/matrix/a:avV	()Ljava/lang/String;
    //   79: lload 21
    //   81: invokeinterface 200 7 0
    //   86: aload_0
    //   87: aload_0
    //   88: getfield 65	com/tencent/matrix/trace/tracer/b:ffH	I
    //   91: iload 15
    //   93: iadd
    //   94: putfield 65	com/tencent/matrix/trace/tracer/b:ffH	I
    //   97: aload_0
    //   98: getfield 67	com/tencent/matrix/trace/tracer/b:ffI	J
    //   101: lstore 21
    //   103: aload_0
    //   104: lload 19
    //   106: aload_0
    //   107: getfield 89	com/tencent/matrix/trace/tracer/b:aft	J
    //   110: invokestatic 206	java/lang/Math:max	(JJ)J
    //   113: lload 21
    //   115: ladd
    //   116: putfield 67	com/tencent/matrix/trace/tracer/b:ffI	J
    //   119: aload_0
    //   120: getfield 61	com/tencent/matrix/trace/tracer/b:listeners	Ljava/util/HashSet;
    //   123: astore 23
    //   125: aload 23
    //   127: monitorenter
    //   128: aload_0
    //   129: getfield 61	com/tencent/matrix/trace/tracer/b:listeners	Ljava/util/HashSet;
    //   132: invokevirtual 210	java/util/HashSet:iterator	()Ljava/util/Iterator;
    //   135: astore 24
    //   137: aload 24
    //   139: invokeinterface 216 1 0
    //   144: ifeq +281 -> 425
    //   147: aload 24
    //   149: invokeinterface 220 1 0
    //   154: checkcast 222	com/tencent/matrix/trace/e/b
    //   157: astore 25
    //   159: aload_0
    //   160: getfield 78	com/tencent/matrix/trace/tracer/b:fdU	Lcom/tencent/matrix/trace/a/b;
    //   163: getfield 225	com/tencent/matrix/trace/a/b:fdK	Z
    //   166: ifeq +11 -> 177
    //   169: aload 25
    //   171: invokestatic 230	android/os/SystemClock:uptimeMillis	()J
    //   174: putfield 233	com/tencent/matrix/trace/e/b:time	J
    //   177: aload 25
    //   179: invokevirtual 237	com/tencent/matrix/trace/e/b:hI	()Ljava/util/concurrent/Executor;
    //   182: ifnull +226 -> 408
    //   185: aload 25
    //   187: invokevirtual 241	com/tencent/matrix/trace/e/b:azS	()I
    //   190: ifle +179 -> 369
    //   193: aload 25
    //   195: aload_1
    //   196: lload_2
    //   197: lload 4
    //   199: iload 15
    //   201: iload 6
    //   203: lload 7
    //   205: lload 9
    //   207: lload 11
    //   209: lload 13
    //   211: invokevirtual 244	com/tencent/matrix/trace/e/b:a	(Ljava/lang/String;JJIZJJJJ)V
    //   214: aload_0
    //   215: getfield 78	com/tencent/matrix/trace/tracer/b:fdU	Lcom/tencent/matrix/trace/a/b;
    //   218: getfield 225	com/tencent/matrix/trace/a/b:fdK	Z
    //   221: ifeq -84 -> 137
    //   224: aload 25
    //   226: invokestatic 230	android/os/SystemClock:uptimeMillis	()J
    //   229: aload 25
    //   231: getfield 233	com/tencent/matrix/trace/e/b:time	J
    //   234: lsub
    //   235: putfield 233	com/tencent/matrix/trace/e/b:time	J
    //   238: ldc 112
    //   240: ldc 246
    //   242: iconst_2
    //   243: anewarray 116	java/lang/Object
    //   246: dup
    //   247: iconst_0
    //   248: aload 25
    //   250: getfield 233	com/tencent/matrix/trace/e/b:time	J
    //   253: invokestatic 122	java/lang/Long:valueOf	(J)Ljava/lang/Long;
    //   256: aastore
    //   257: dup
    //   258: iconst_1
    //   259: aload 25
    //   261: aastore
    //   262: invokestatic 248	com/tencent/matrix/e/c:d	(Ljava/lang/String;Ljava/lang/String;[Ljava/lang/Object;)V
    //   265: goto -128 -> 137
    //   268: astore_1
    //   269: aload 23
    //   271: monitorexit
    //   272: aload_1
    //   273: athrow
    //   274: astore_1
    //   275: invokestatic 181	java/lang/System:currentTimeMillis	()J
    //   278: lload 17
    //   280: lsub
    //   281: lstore_2
    //   282: aload_0
    //   283: getfield 78	com/tencent/matrix/trace/tracer/b:fdU	Lcom/tencent/matrix/trace/a/b;
    //   286: getfield 251	com/tencent/matrix/trace/a/b:eYL	Z
    //   289: ifeq +43 -> 332
    //   292: lload_2
    //   293: aload_0
    //   294: getfield 89	com/tencent/matrix/trace/tracer/b:aft	J
    //   297: lcmp
    //   298: ifle +34 -> 332
    //   301: ldc 112
    //   303: ldc 253
    //   305: iconst_2
    //   306: anewarray 116	java/lang/Object
    //   309: dup
    //   310: iconst_0
    //   311: aload_0
    //   312: getfield 61	com/tencent/matrix/trace/tracer/b:listeners	Ljava/util/HashSet;
    //   315: invokevirtual 256	java/util/HashSet:size	()I
    //   318: invokestatic 261	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
    //   321: aastore
    //   322: dup
    //   323: iconst_1
    //   324: lload_2
    //   325: invokestatic 122	java/lang/Long:valueOf	(J)Ljava/lang/Long;
    //   328: aastore
    //   329: invokestatic 264	com/tencent/matrix/e/c:w	(Ljava/lang/String;Ljava/lang/String;[Ljava/lang/Object;)V
    //   332: aload_1
    //   333: athrow
    //   334: astore 23
    //   336: ldc 112
    //   338: new 266	java/lang/StringBuilder
    //   341: dup
    //   342: ldc_w 268
    //   345: invokespecial 271	java/lang/StringBuilder:<init>	(Ljava/lang/String;)V
    //   348: aload 23
    //   350: invokevirtual 274	java/lang/Exception:getMessage	()Ljava/lang/String;
    //   353: invokevirtual 278	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   356: invokevirtual 281	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   359: iconst_0
    //   360: anewarray 116	java/lang/Object
    //   363: invokestatic 284	com/tencent/matrix/e/c:e	(Ljava/lang/String;Ljava/lang/String;[Ljava/lang/Object;)V
    //   366: goto -280 -> 86
    //   369: aload 25
    //   371: invokevirtual 237	com/tencent/matrix/trace/e/b:hI	()Ljava/util/concurrent/Executor;
    //   374: new 8	com/tencent/matrix/trace/tracer/b$1
    //   377: dup
    //   378: aload_0
    //   379: aload 25
    //   381: aload_1
    //   382: lload_2
    //   383: lload 4
    //   385: iload 15
    //   387: iload 6
    //   389: lload 7
    //   391: lload 9
    //   393: lload 11
    //   395: lload 13
    //   397: invokespecial 287	com/tencent/matrix/trace/tracer/b$1:<init>	(Lcom/tencent/matrix/trace/tracer/b;Lcom/tencent/matrix/trace/e/b;Ljava/lang/String;JJIZJJJJ)V
    //   400: invokeinterface 293 2 0
    //   405: goto -191 -> 214
    //   408: aload 25
    //   410: aload_1
    //   411: lload 4
    //   413: iload 15
    //   415: iload 6
    //   417: lload 7
    //   419: invokevirtual 296	com/tencent/matrix/trace/e/b:a	(Ljava/lang/String;JIZJ)V
    //   422: goto -208 -> 214
    //   425: aload 23
    //   427: monitorexit
    //   428: invokestatic 181	java/lang/System:currentTimeMillis	()J
    //   431: lload 17
    //   433: lsub
    //   434: lstore_2
    //   435: aload_0
    //   436: getfield 78	com/tencent/matrix/trace/tracer/b:fdU	Lcom/tencent/matrix/trace/a/b;
    //   439: getfield 251	com/tencent/matrix/trace/a/b:eYL	Z
    //   442: ifeq +43 -> 485
    //   445: lload_2
    //   446: aload_0
    //   447: getfield 89	com/tencent/matrix/trace/tracer/b:aft	J
    //   450: lcmp
    //   451: ifle +34 -> 485
    //   454: ldc 112
    //   456: ldc 253
    //   458: iconst_2
    //   459: anewarray 116	java/lang/Object
    //   462: dup
    //   463: iconst_0
    //   464: aload_0
    //   465: getfield 61	com/tencent/matrix/trace/tracer/b:listeners	Ljava/util/HashSet;
    //   468: invokevirtual 256	java/util/HashSet:size	()I
    //   471: invokestatic 261	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
    //   474: aastore
    //   475: dup
    //   476: iconst_1
    //   477: lload_2
    //   478: invokestatic 122	java/lang/Long:valueOf	(J)Ljava/lang/Long;
    //   481: aastore
    //   482: invokestatic 264	com/tencent/matrix/e/c:w	(Ljava/lang/String;Ljava/lang/String;[Ljava/lang/Object;)V
    //   485: return
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	486	0	this	b
    //   0	486	1	paramString	String
    //   0	486	2	paramLong1	long
    //   0	486	4	paramLong2	long
    //   0	486	6	paramBoolean	boolean
    //   0	486	7	paramLong3	long
    //   0	486	9	paramLong4	long
    //   0	486	11	paramLong5	long
    //   0	486	13	paramLong6	long
    //   20	394	15	i	int
    //   33	7	16	j	int
    //   3	429	17	l1	long
    //   10	95	19	l2	long
    //   66	48	21	l3	long
    //   334	92	23	localException	java.lang.Exception
    //   135	13	24	localIterator	Iterator
    //   157	252	25	localb	com.tencent.matrix.trace.e.b
    // Exception table:
    //   from	to	target	type
    //   128	137	268	finally
    //   137	177	268	finally
    //   177	214	268	finally
    //   214	265	268	finally
    //   369	405	268	finally
    //   408	422	268	finally
    //   425	428	268	finally
    //   12	35	274	finally
    //   42	86	274	finally
    //   86	128	274	finally
    //   269	274	274	finally
    //   336	366	274	finally
    //   42	86	334	java/lang/Exception
  }
  
  public final void a(com.tencent.matrix.trace.e.b paramb)
  {
    synchronized (this.listeners)
    {
      this.listeners.add(paramb);
      return;
    }
  }
  
  public final void a(String paramString, long paramLong1, long paramLong2, boolean paramBoolean, long paramLong3, long paramLong4, long paramLong5, long paramLong6)
  {
    if (com.tencent.matrix.a.eLw.eLx) {
      b(paramString, paramLong1, paramLong2, paramBoolean, paramLong3, paramLong4, paramLong5, paramLong6);
    }
  }
  
  public final void b(com.tencent.matrix.trace.e.b paramb)
  {
    synchronized (this.listeners)
    {
      this.listeners.remove(paramb);
      return;
    }
  }
  
  public final void onActivityCreated(Activity paramActivity, Bundle paramBundle)
  {
    if (feF)
    {
      this.ffA = ((int)paramActivity.getWindowManager().getDefaultDisplay().getRefreshRate());
      this.aft = (1000000000L / this.ffA);
      paramBundle = new Window.OnFrameMetricsAvailableListener()
      {
        public final void onFrameMetricsAvailable(Window paramAnonymousWindow, FrameMetrics paramAnonymousFrameMetrics, int paramAnonymousInt)
        {
          paramAnonymousWindow = new FrameMetrics(paramAnonymousFrameMetrics);
          long l1 = paramAnonymousWindow.getMetric(11);
          long l2 = paramAnonymousWindow.getMetric(10);
          paramAnonymousWindow.getMetric(4);
          b.a(b.this, com.tencent.matrix.a.eLw.eLy, l2, l1, l2);
        }
      };
      this.ffK.put(Integer.valueOf(paramActivity.hashCode()), paramBundle);
      paramActivity.getWindow().addOnFrameMetricsAvailableListener(paramBundle, new Handler());
      com.tencent.matrix.e.c.i("Matrix.FrameTracer", "onActivityCreated addOnFrameMetricsAvailableListener", new Object[0]);
    }
  }
  
  public final void onActivityDestroyed(Activity paramActivity)
  {
    if (feF) {}
    try
    {
      paramActivity.getWindow().removeOnFrameMetricsAvailableListener((Window.OnFrameMetricsAvailableListener)this.ffK.remove(Integer.valueOf(paramActivity.hashCode())));
      return;
    }
    finally
    {
      com.tencent.matrix.e.c.e("Matrix.FrameTracer", "removeOnFrameMetricsAvailableListener error : " + paramActivity.getMessage(), new Object[0]);
    }
  }
  
  public final void onActivityPaused(Activity paramActivity) {}
  
  public final void onActivityResumed(Activity paramActivity)
  {
    this.ffJ.put(paramActivity.getClass().getName(), Long.valueOf(System.currentTimeMillis()));
  }
  
  public final void onActivitySaveInstanceState(Activity paramActivity, Bundle paramBundle) {}
  
  public final void onActivityStarted(Activity paramActivity) {}
  
  public final void onActivityStopped(Activity paramActivity) {}
  
  public final void onAlive()
  {
    super.onAlive();
    if (this.ffC)
    {
      if (!feF) {
        com.tencent.matrix.trace.core.b.azL().a(this);
      }
      com.tencent.matrix.c.avW().application.registerActivityLifecycleCallbacks(this);
    }
  }
  
  public final void onDead()
  {
    super.onDead();
    this.ffy = null;
    if (this.ffC)
    {
      com.tencent.matrix.trace.core.b.azL().b(this);
      com.tencent.matrix.c.avW().application.unregisterActivityLifecycleCallbacks(this);
    }
  }
  
  public static abstract interface a
  {
    public abstract void a(int paramInt, long paramLong1, String paramString, long paramLong2);
  }
  
  public static enum b
  {
    public int index;
    
    private b(int paramInt)
    {
      this.index = paramInt;
    }
  }
  
  final class c
    extends com.tencent.matrix.trace.e.b
  {
    Executor executor = new Executor()
    {
      public final void execute(Runnable paramAnonymousRunnable)
      {
        b.c.a(b.c.this).post(paramAnonymousRunnable);
      }
    };
    private Handler fgc = new Handler(com.tencent.matrix.e.b.aAo().getLooper());
    private HashMap<String, b.d> map = new HashMap();
    
    private c() {}
    
    public final int azS()
    {
      return 300;
    }
    
    public final void bj(List<com.tencent.matrix.trace.e.b.a> paramList)
    {
      super.bj(paramList);
      Iterator localIterator = paramList.iterator();
      Object localObject2;
      int i;
      while (localIterator.hasNext())
      {
        paramList = (com.tencent.matrix.trace.e.b.a)localIterator.next();
        localObject2 = paramList.ffg;
        i = paramList.ffj;
        boolean bool = paramList.feD;
        if ((!com.tencent.matrix.trace.f.c.hm((String)localObject2)) && (bool))
        {
          paramList = (b.d)this.map.get(localObject2);
          if (paramList != null) {
            break label1031;
          }
          paramList = new b.d(b.this, (String)localObject2);
          this.map.put(localObject2, paramList);
        }
      }
      label1031:
      for (;;)
      {
        for (;;)
        {
          float f1 = 1.0F * (float)b.b(paramList.ffV) / 1000000.0F;
          float f2 = (float)paramList.fge;
          paramList.fge = ((f1 * (i + 1) + f2));
          paramList.fgg += i;
          paramList.fgf += 1;
          Object localObject3;
          int j;
          if (i >= b.c(paramList.ffV))
          {
            localObject3 = paramList.fgh;
            j = b.b.ffW.index;
            localObject3[j] += 1;
            localObject3 = paramList.fgi;
            j = b.b.ffW.index;
            localObject3[j] = (i + localObject3[j]);
            label229:
            if (paramList.fge < b.a(b.this)) {
              break;
            }
            this.map.remove(localObject2);
            f1 = Math.min(b.g(paramList.ffV), 1000.0F * paramList.fgf / (float)paramList.fge);
            com.tencent.matrix.e.c.i("Matrix.FrameTracer", "[report] FPS:%s %s", new Object[] { Float.valueOf(f1), paramList.toString() });
          }
          try
          {
            localObject2 = (com.tencent.matrix.trace.b)com.tencent.matrix.c.avW().ai(com.tencent.matrix.trace.b.class);
            if (localObject2 == null)
            {
              paramList.fgf = 0;
              paramList.fgg = 0;
              paramList.fge = 0L;
              break;
              if (i >= b.d(paramList.ffV))
              {
                localObject3 = paramList.fgh;
                j = b.b.ffX.index;
                localObject3[j] += 1;
                localObject3 = paramList.fgi;
                j = b.b.ffX.index;
                localObject3[j] = (i + localObject3[j]);
                break label229;
              }
              if (i >= b.e(paramList.ffV))
              {
                localObject3 = paramList.fgh;
                j = b.b.ffY.index;
                localObject3[j] += 1;
                localObject3 = paramList.fgi;
                j = b.b.ffY.index;
                localObject3[j] = (i + localObject3[j]);
                break label229;
              }
              if (i >= b.f(paramList.ffV))
              {
                localObject3 = paramList.fgh;
                j = b.b.ffZ.index;
                localObject3[j] += 1;
                localObject3 = paramList.fgi;
                j = b.b.ffZ.index;
                localObject3[j] = (i + localObject3[j]);
                break label229;
              }
              localObject3 = paramList.fgh;
              j = b.b.fga.index;
              localObject3[j] += 1;
              localObject3 = paramList.fgi;
              j = b.b.fga.index;
              int k = localObject3[j];
              localObject3[j] = (Math.max(i, 0) + k);
              break label229;
            }
            Object localObject4 = new JSONObject();
            ((JSONObject)localObject4).put(b.b.ffW.name(), paramList.fgh[b.b.ffW.index]);
            ((JSONObject)localObject4).put(b.b.ffX.name(), paramList.fgh[b.b.ffX.index]);
            ((JSONObject)localObject4).put(b.b.ffY.name(), paramList.fgh[b.b.ffY.index]);
            ((JSONObject)localObject4).put(b.b.ffZ.name(), paramList.fgh[b.b.ffZ.index]);
            ((JSONObject)localObject4).put(b.b.fga.name(), paramList.fgh[b.b.fga.index]);
            JSONObject localJSONObject = new JSONObject();
            localJSONObject.put(b.b.ffW.name(), paramList.fgi[b.b.ffW.index]);
            localJSONObject.put(b.b.ffX.name(), paramList.fgi[b.b.ffX.index]);
            localJSONObject.put(b.b.ffY.name(), paramList.fgi[b.b.ffY.index]);
            localJSONObject.put(b.b.ffZ.name(), paramList.fgi[b.b.ffZ.index]);
            localJSONObject.put(b.b.fga.name(), paramList.fgi[b.b.fga.index]);
            localObject3 = com.tencent.matrix.e.a.a(new JSONObject(), ((com.tencent.matrix.trace.b)localObject2).getApplication());
            ((JSONObject)localObject3).put("scene", paramList.eLy);
            ((JSONObject)localObject3).put("dropLevel", localObject4);
            ((JSONObject)localObject3).put("dropSum", localJSONObject);
            ((JSONObject)localObject3).put("fps", f1);
            localObject4 = new com.tencent.matrix.report.g();
            ((com.tencent.matrix.report.g)localObject4).tag = "Trace_FPS";
            ((com.tencent.matrix.report.g)localObject4).eYz = ((JSONObject)localObject3);
            ((com.tencent.matrix.trace.b)localObject2).onDetectIssue((com.tencent.matrix.report.g)localObject4);
            paramList.fgf = 0;
            paramList.fgg = 0;
            paramList.fge = 0L;
            break;
          }
          catch (JSONException localJSONException)
          {
            com.tencent.matrix.e.c.e("Matrix.FrameTracer", "json error", new Object[] { localJSONException });
            paramList.fgf = 0;
            paramList.fgg = 0;
            paramList.fge = 0L;
            break;
          }
          finally
          {
            paramList.fgf = 0;
            paramList.fgg = 0;
            paramList.fge = 0L;
          }
        }
        return;
      }
    }
    
    public final Executor hI()
    {
      return this.executor;
    }
  }
  
  final class d
  {
    String eLy;
    long fge;
    int fgf = 0;
    int fgg;
    int[] fgh = new int[b.b.values().length];
    int[] fgi = new int[b.b.values().length];
    
    d(String paramString)
    {
      this.eLy = paramString;
    }
    
    public final String toString()
    {
      return "visibleScene=" + this.eLy + ", sumFrame=" + this.fgf + ", sumDroppedFrames=" + this.fgg + ", sumFrameCost=" + this.fge + ", dropLevel=" + Arrays.toString(this.fgh);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.matrix.trace.tracer.b
 * JD-Core Version:    0.7.0.1
 */