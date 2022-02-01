package com.tencent.matrix.trace.f;

import android.app.Activity;
import android.app.Application;
import android.app.Application.ActivityLifecycleCallbacks;
import android.os.Bundle;
import android.os.Handler;
import android.os.HandlerThread;
import com.tencent.c.a.a.a;
import com.tencent.matrix.trace.e.b.a;
import java.util.Arrays;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.concurrent.Executor;
import org.json.JSONException;
import org.json.JSONObject;

public final class c
  extends f
  implements Application.ActivityLifecycleCallbacks
{
  private final com.tencent.matrix.trace.a.b daS;
  public a dco;
  public int dcp = 0;
  private final long dcq;
  private long dcr;
  private boolean dcs;
  private long dct;
  private long dcu;
  private long dcv;
  private long dcw;
  public int dcx = 0;
  private long dcy = 0L;
  private Map<String, Long> dcz = new HashMap();
  private final HashSet<com.tencent.matrix.trace.e.b> listeners = new HashSet();
  
  public c(com.tencent.matrix.trace.a.b paramb)
  {
    this.daS = paramb;
    this.dcq = com.tencent.matrix.trace.core.b.Tw().cPm;
    if (paramb.cVx == null)
    {
      i = 10000;
      this.dcr = i;
      this.dcs = paramb.daK;
      if (paramb.cVx != null) {
        break label218;
      }
      i = 42;
      label91:
      this.dct = i;
      if (paramb.cVx != null) {
        break label239;
      }
      i = 24;
      label107:
      this.dcu = i;
      if (paramb.cVx != null) {
        break label260;
      }
      i = 3;
      label122:
      this.dcw = i;
      if (paramb.cVx != null) {
        break label280;
      }
    }
    label260:
    label280:
    for (int i = 9;; i = paramb.cVx.get(a.a.RzP.name(), 9))
    {
      this.dcv = i;
      com.tencent.matrix.g.c.i("Matrix.FrameTracer", "[init] frameIntervalMs:%s isFPSEnable:%s", new Object[] { Long.valueOf(this.dcq), Boolean.valueOf(this.dcs) });
      if (this.dcs) {
        a(new c((byte)0));
      }
      return;
      i = paramb.cVx.get(a.a.RzM.name(), 10000);
      break;
      label218:
      i = paramb.cVx.get(a.a.RzR.name(), 42);
      break label91;
      label239:
      i = paramb.cVx.get(a.a.RzQ.name(), 24);
      break label107;
      i = paramb.cVx.get(a.a.RzO.name(), 3);
      break label122;
    }
  }
  
  public final void a(com.tencent.matrix.trace.e.b paramb)
  {
    synchronized (this.listeners)
    {
      this.listeners.add(paramb);
      return;
    }
  }
  
  /* Error */
  public final void a(final String paramString, final long paramLong1, long paramLong2, boolean paramBoolean, final long paramLong3, final long paramLong4, final long paramLong5, long paramLong6)
  {
    // Byte code:
    //   0: getstatic 173	com/tencent/matrix/a:cPA	Lcom/tencent/matrix/a;
    //   3: getfield 176	com/tencent/matrix/a:cPB	Z
    //   6: ifeq +625 -> 631
    //   9: invokestatic 182	java/lang/System:currentTimeMillis	()J
    //   12: lstore 17
    //   14: lload 4
    //   16: lload 7
    //   18: lsub
    //   19: lstore 19
    //   21: lload 19
    //   23: aload_0
    //   24: getfield 79	com/tencent/matrix/trace/f/c:dcq	J
    //   27: ldiv
    //   28: l2i
    //   29: istore 15
    //   31: aload_0
    //   32: getfield 184	com/tencent/matrix/trace/f/c:dco	Lcom/tencent/matrix/trace/f/c$a;
    //   35: ifnull +58 -> 93
    //   38: aload_0
    //   39: getfield 57	com/tencent/matrix/trace/f/c:dcp	I
    //   42: istore 16
    //   44: iload 15
    //   46: iload 16
    //   48: if_icmple +45 -> 93
    //   51: invokestatic 187	com/tencent/matrix/a:RF	()Ljava/lang/String;
    //   54: ifnull +39 -> 93
    //   57: aload_0
    //   58: getfield 66	com/tencent/matrix/trace/f/c:dcz	Ljava/util/Map;
    //   61: invokestatic 187	com/tencent/matrix/a:RF	()Ljava/lang/String;
    //   64: invokeinterface 192 2 0
    //   69: checkcast 108	java/lang/Long
    //   72: invokevirtual 195	java/lang/Long:longValue	()J
    //   75: lstore 21
    //   77: aload_0
    //   78: getfield 184	com/tencent/matrix/trace/f/c:dco	Lcom/tencent/matrix/trace/f/c$a;
    //   81: iload 15
    //   83: invokestatic 187	com/tencent/matrix/a:RF	()Ljava/lang/String;
    //   86: lload 21
    //   88: invokeinterface 198 5 0
    //   93: aload_0
    //   94: aload_0
    //   95: getfield 59	com/tencent/matrix/trace/f/c:dcx	I
    //   98: iload 15
    //   100: iadd
    //   101: putfield 59	com/tencent/matrix/trace/f/c:dcx	I
    //   104: aload_0
    //   105: aload_0
    //   106: getfield 61	com/tencent/matrix/trace/f/c:dcy	J
    //   109: lload 19
    //   111: aload_0
    //   112: getfield 79	com/tencent/matrix/trace/f/c:dcq	J
    //   115: invokestatic 204	java/lang/Math:max	(JJ)J
    //   118: ladd
    //   119: putfield 61	com/tencent/matrix/trace/f/c:dcy	J
    //   122: aload_0
    //   123: getfield 55	com/tencent/matrix/trace/f/c:listeners	Ljava/util/HashSet;
    //   126: astore 23
    //   128: aload 23
    //   130: monitorenter
    //   131: aload_0
    //   132: getfield 55	com/tencent/matrix/trace/f/c:listeners	Ljava/util/HashSet;
    //   135: invokevirtual 208	java/util/HashSet:iterator	()Ljava/util/Iterator;
    //   138: astore 24
    //   140: aload 24
    //   142: invokeinterface 214 1 0
    //   147: ifeq +423 -> 570
    //   150: aload 24
    //   152: invokeinterface 218 1 0
    //   157: checkcast 220	com/tencent/matrix/trace/e/b
    //   160: astore 25
    //   162: aload_0
    //   163: getfield 68	com/tencent/matrix/trace/f/c:daS	Lcom/tencent/matrix/trace/a/b;
    //   166: getfield 223	com/tencent/matrix/trace/a/b:daO	Z
    //   169: ifeq +11 -> 180
    //   172: aload 25
    //   174: invokestatic 228	android/os/SystemClock:uptimeMillis	()J
    //   177: putfield 231	com/tencent/matrix/trace/e/b:time	J
    //   180: aload 25
    //   182: invokevirtual 235	com/tencent/matrix/trace/e/b:getExecutor	()Ljava/util/concurrent/Executor;
    //   185: ifnull +357 -> 542
    //   188: aload 25
    //   190: invokevirtual 239	com/tencent/matrix/trace/e/b:TD	()I
    //   193: ifle +310 -> 503
    //   196: invokestatic 245	com/tencent/matrix/trace/e/b$a:TF	()Lcom/tencent/matrix/trace/e/b$a;
    //   199: astore 26
    //   201: aload 26
    //   203: aload_1
    //   204: putfield 249	com/tencent/matrix/trace/e/b$a:dbP	Ljava/lang/String;
    //   207: aload 26
    //   209: lload_2
    //   210: putfield 252	com/tencent/matrix/trace/e/b$a:dbQ	J
    //   213: aload 26
    //   215: lload 4
    //   217: putfield 255	com/tencent/matrix/trace/e/b$a:dbR	J
    //   220: aload 26
    //   222: iload 15
    //   224: putfield 258	com/tencent/matrix/trace/e/b$a:dbS	I
    //   227: aload 26
    //   229: iload 6
    //   231: putfield 261	com/tencent/matrix/trace/e/b$a:dbn	Z
    //   234: aload 26
    //   236: lload 7
    //   238: putfield 264	com/tencent/matrix/trace/e/b$a:dbT	J
    //   241: aload 26
    //   243: lload 9
    //   245: putfield 267	com/tencent/matrix/trace/e/b$a:dbU	J
    //   248: aload 26
    //   250: lload 11
    //   252: putfield 270	com/tencent/matrix/trace/e/b$a:dbV	J
    //   255: aload 26
    //   257: lload 13
    //   259: putfield 273	com/tencent/matrix/trace/e/b$a:dbW	J
    //   262: aload 25
    //   264: getfield 277	com/tencent/matrix/trace/e/b:list	Ljava/util/List;
    //   267: aload 26
    //   269: invokeinterface 280 2 0
    //   274: pop
    //   275: aload 25
    //   277: getfield 277	com/tencent/matrix/trace/e/b:list	Ljava/util/List;
    //   280: invokeinterface 283 1 0
    //   285: aload 25
    //   287: getfield 286	com/tencent/matrix/trace/e/b:dbL	I
    //   290: if_icmplt +56 -> 346
    //   293: aload 25
    //   295: invokevirtual 235	com/tencent/matrix/trace/e/b:getExecutor	()Ljava/util/concurrent/Executor;
    //   298: ifnull +48 -> 346
    //   301: new 288	java/util/LinkedList
    //   304: dup
    //   305: aload 25
    //   307: getfield 277	com/tencent/matrix/trace/e/b:list	Ljava/util/List;
    //   310: invokespecial 291	java/util/LinkedList:<init>	(Ljava/util/Collection;)V
    //   313: astore 26
    //   315: aload 25
    //   317: getfield 277	com/tencent/matrix/trace/e/b:list	Ljava/util/List;
    //   320: invokeinterface 294 1 0
    //   325: aload 25
    //   327: invokevirtual 235	com/tencent/matrix/trace/e/b:getExecutor	()Ljava/util/concurrent/Executor;
    //   330: new 296	com/tencent/matrix/trace/e/b$1
    //   333: dup
    //   334: aload 25
    //   336: aload 26
    //   338: invokespecial 299	com/tencent/matrix/trace/e/b$1:<init>	(Lcom/tencent/matrix/trace/e/b;Ljava/util/List;)V
    //   341: invokeinterface 305 2 0
    //   346: aload_0
    //   347: getfield 68	com/tencent/matrix/trace/f/c:daS	Lcom/tencent/matrix/trace/a/b;
    //   350: getfield 223	com/tencent/matrix/trace/a/b:daO	Z
    //   353: ifeq -213 -> 140
    //   356: aload 25
    //   358: invokestatic 228	android/os/SystemClock:uptimeMillis	()J
    //   361: aload 25
    //   363: getfield 231	com/tencent/matrix/trace/e/b:time	J
    //   366: lsub
    //   367: putfield 231	com/tencent/matrix/trace/e/b:time	J
    //   370: ldc 102
    //   372: ldc_w 307
    //   375: iconst_2
    //   376: anewarray 106	java/lang/Object
    //   379: dup
    //   380: iconst_0
    //   381: aload 25
    //   383: getfield 231	com/tencent/matrix/trace/e/b:time	J
    //   386: invokestatic 112	java/lang/Long:valueOf	(J)Ljava/lang/Long;
    //   389: aastore
    //   390: dup
    //   391: iconst_1
    //   392: aload 25
    //   394: aastore
    //   395: invokestatic 309	com/tencent/matrix/g/c:d	(Ljava/lang/String;Ljava/lang/String;[Ljava/lang/Object;)V
    //   398: goto -258 -> 140
    //   401: astore_1
    //   402: aload 23
    //   404: monitorexit
    //   405: aload_1
    //   406: athrow
    //   407: astore_1
    //   408: invokestatic 182	java/lang/System:currentTimeMillis	()J
    //   411: lload 17
    //   413: lsub
    //   414: lstore_2
    //   415: aload_0
    //   416: getfield 68	com/tencent/matrix/trace/f/c:daS	Lcom/tencent/matrix/trace/a/b;
    //   419: getfield 312	com/tencent/matrix/trace/a/b:cWq	Z
    //   422: ifeq +44 -> 466
    //   425: lload_2
    //   426: aload_0
    //   427: getfield 79	com/tencent/matrix/trace/f/c:dcq	J
    //   430: lcmp
    //   431: ifle +35 -> 466
    //   434: ldc 102
    //   436: ldc_w 314
    //   439: iconst_2
    //   440: anewarray 106	java/lang/Object
    //   443: dup
    //   444: iconst_0
    //   445: aload_0
    //   446: getfield 55	com/tencent/matrix/trace/f/c:listeners	Ljava/util/HashSet;
    //   449: invokevirtual 315	java/util/HashSet:size	()I
    //   452: invokestatic 320	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
    //   455: aastore
    //   456: dup
    //   457: iconst_1
    //   458: lload_2
    //   459: invokestatic 112	java/lang/Long:valueOf	(J)Ljava/lang/Long;
    //   462: aastore
    //   463: invokestatic 323	com/tencent/matrix/g/c:w	(Ljava/lang/String;Ljava/lang/String;[Ljava/lang/Object;)V
    //   466: aload_1
    //   467: athrow
    //   468: astore 23
    //   470: ldc 102
    //   472: new 325	java/lang/StringBuilder
    //   475: dup
    //   476: ldc_w 327
    //   479: invokespecial 330	java/lang/StringBuilder:<init>	(Ljava/lang/String;)V
    //   482: aload 23
    //   484: invokevirtual 333	java/lang/Exception:getMessage	()Ljava/lang/String;
    //   487: invokevirtual 337	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   490: invokevirtual 340	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   493: iconst_0
    //   494: anewarray 106	java/lang/Object
    //   497: invokestatic 342	com/tencent/matrix/g/c:e	(Ljava/lang/String;Ljava/lang/String;[Ljava/lang/Object;)V
    //   500: goto -407 -> 93
    //   503: aload 25
    //   505: invokevirtual 235	com/tencent/matrix/trace/e/b:getExecutor	()Ljava/util/concurrent/Executor;
    //   508: new 8	com/tencent/matrix/trace/f/c$1
    //   511: dup
    //   512: aload_0
    //   513: aload 25
    //   515: aload_1
    //   516: lload_2
    //   517: lload 4
    //   519: iload 15
    //   521: iload 6
    //   523: lload 7
    //   525: lload 9
    //   527: lload 11
    //   529: lload 13
    //   531: invokespecial 345	com/tencent/matrix/trace/f/c$1:<init>	(Lcom/tencent/matrix/trace/f/c;Lcom/tencent/matrix/trace/e/b;Ljava/lang/String;JJIZJJJJ)V
    //   534: invokeinterface 305 2 0
    //   539: goto -193 -> 346
    //   542: lload 4
    //   544: lload 7
    //   546: lsub
    //   547: ldc2_w 346
    //   550: ldiv
    //   551: lstore 19
    //   553: aload 25
    //   555: aload_1
    //   556: lload 19
    //   558: lload 19
    //   560: iload 15
    //   562: iload 6
    //   564: invokevirtual 350	com/tencent/matrix/trace/e/b:a	(Ljava/lang/String;JJIZ)V
    //   567: goto -221 -> 346
    //   570: aload 23
    //   572: monitorexit
    //   573: invokestatic 182	java/lang/System:currentTimeMillis	()J
    //   576: lload 17
    //   578: lsub
    //   579: lstore_2
    //   580: aload_0
    //   581: getfield 68	com/tencent/matrix/trace/f/c:daS	Lcom/tencent/matrix/trace/a/b;
    //   584: getfield 312	com/tencent/matrix/trace/a/b:cWq	Z
    //   587: ifeq +44 -> 631
    //   590: lload_2
    //   591: aload_0
    //   592: getfield 79	com/tencent/matrix/trace/f/c:dcq	J
    //   595: lcmp
    //   596: ifle +35 -> 631
    //   599: ldc 102
    //   601: ldc_w 314
    //   604: iconst_2
    //   605: anewarray 106	java/lang/Object
    //   608: dup
    //   609: iconst_0
    //   610: aload_0
    //   611: getfield 55	com/tencent/matrix/trace/f/c:listeners	Ljava/util/HashSet;
    //   614: invokevirtual 315	java/util/HashSet:size	()I
    //   617: invokestatic 320	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
    //   620: aastore
    //   621: dup
    //   622: iconst_1
    //   623: lload_2
    //   624: invokestatic 112	java/lang/Long:valueOf	(J)Ljava/lang/Long;
    //   627: aastore
    //   628: invokestatic 323	com/tencent/matrix/g/c:w	(Ljava/lang/String;Ljava/lang/String;[Ljava/lang/Object;)V
    //   631: return
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	632	0	this	c
    //   0	632	1	paramString	String
    //   0	632	2	paramLong1	long
    //   0	632	4	paramLong2	long
    //   0	632	6	paramBoolean	boolean
    //   0	632	7	paramLong3	long
    //   0	632	9	paramLong4	long
    //   0	632	11	paramLong5	long
    //   0	632	13	paramLong6	long
    //   29	532	15	i	int
    //   42	7	16	j	int
    //   12	565	17	l1	long
    //   19	540	19	l2	long
    //   75	12	21	l3	long
    //   468	103	23	localException	java.lang.Exception
    //   138	13	24	localIterator	Iterator
    //   160	394	25	localb	com.tencent.matrix.trace.e.b
    //   199	138	26	localObject	Object
    // Exception table:
    //   from	to	target	type
    //   131	140	401	finally
    //   140	180	401	finally
    //   180	346	401	finally
    //   346	398	401	finally
    //   402	405	401	finally
    //   503	539	401	finally
    //   542	567	401	finally
    //   570	573	401	finally
    //   21	44	407	finally
    //   51	93	407	finally
    //   93	131	407	finally
    //   405	407	407	finally
    //   470	500	407	finally
    //   51	93	468	java/lang/Exception
  }
  
  public final void b(com.tencent.matrix.trace.e.b paramb)
  {
    synchronized (this.listeners)
    {
      this.listeners.remove(paramb);
      return;
    }
  }
  
  public final void onActivityCreated(Activity paramActivity, Bundle paramBundle) {}
  
  public final void onActivityDestroyed(Activity paramActivity) {}
  
  public final void onActivityPaused(Activity paramActivity) {}
  
  public final void onActivityResumed(Activity paramActivity)
  {
    this.dcz.put(paramActivity.getClass().getName(), Long.valueOf(System.currentTimeMillis()));
  }
  
  public final void onActivitySaveInstanceState(Activity paramActivity, Bundle paramBundle) {}
  
  public final void onActivityStarted(Activity paramActivity) {}
  
  public final void onActivityStopped(Activity paramActivity) {}
  
  public final void onAlive()
  {
    super.onAlive();
    com.tencent.matrix.trace.core.b.Tw().a(this);
    if (this.dcs) {
      com.tencent.matrix.b.RG().application.registerActivityLifecycleCallbacks(this);
    }
  }
  
  public final void onDead()
  {
    super.onDead();
    com.tencent.matrix.trace.core.b.Tw().b(this);
    this.dco = null;
    if (this.dcs) {
      com.tencent.matrix.b.RG().application.unregisterActivityLifecycleCallbacks(this);
    }
  }
  
  public static abstract interface a
  {
    public abstract void a(int paramInt, String paramString, long paramLong);
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
    private Handler dcQ = new Handler(com.tencent.matrix.g.b.TP().getLooper());
    Executor executor = new Executor()
    {
      public final void execute(Runnable paramAnonymousRunnable)
      {
        c.c.a(c.c.this).post(paramAnonymousRunnable);
      }
    };
    private HashMap<String, c.d> map = new HashMap();
    
    private c() {}
    
    public final void L(List<b.a> paramList)
    {
      super.L(paramList);
      Iterator localIterator = paramList.iterator();
      Object localObject2;
      int i;
      while (localIterator.hasNext())
      {
        paramList = (b.a)localIterator.next();
        localObject2 = paramList.dbP;
        i = paramList.dbS;
        boolean bool = paramList.dbn;
        if ((!com.tencent.matrix.trace.g.b.eP((String)localObject2)) && (bool))
        {
          paramList = (c.d)this.map.get(localObject2);
          if (paramList != null) {
            break label1024;
          }
          paramList = new c.d(c.this, (String)localObject2);
          this.map.put(localObject2, paramList);
        }
      }
      label1024:
      for (;;)
      {
        for (;;)
        {
          float f1 = 1.0F * (float)com.tencent.matrix.trace.core.b.Tw().cPm / 1000000.0F;
          float f2 = (float)paramList.dcS;
          paramList.dcS = ((f1 * (i + 1) + f2));
          paramList.dcU += i;
          paramList.dcT += 1;
          Object localObject3;
          int j;
          if (i >= c.b(paramList.dcJ))
          {
            localObject3 = paramList.dcV;
            j = c.b.dcK.index;
            localObject3[j] += 1;
            localObject3 = paramList.dcW;
            j = c.b.dcK.index;
            localObject3[j] = (i + localObject3[j]);
            label228:
            if (paramList.dcS < c.a(c.this)) {
              break;
            }
            this.map.remove(localObject2);
            f1 = Math.min(60.0F, 1000.0F * paramList.dcT / (float)paramList.dcS);
            com.tencent.matrix.g.c.i("Matrix.FrameTracer", "[report] FPS:%s %s", new Object[] { Float.valueOf(f1), paramList.toString() });
          }
          try
          {
            localObject2 = (com.tencent.matrix.trace.a)com.tencent.matrix.b.RG().Y(com.tencent.matrix.trace.a.class);
            if (localObject2 == null)
            {
              paramList.dcT = 0;
              paramList.dcU = 0;
              paramList.dcS = 0L;
              break;
              if (i >= c.c(paramList.dcJ))
              {
                localObject3 = paramList.dcV;
                j = c.b.dcL.index;
                localObject3[j] += 1;
                localObject3 = paramList.dcW;
                j = c.b.dcL.index;
                localObject3[j] = (i + localObject3[j]);
                break label228;
              }
              if (i >= c.d(paramList.dcJ))
              {
                localObject3 = paramList.dcV;
                j = c.b.dcM.index;
                localObject3[j] += 1;
                localObject3 = paramList.dcW;
                j = c.b.dcM.index;
                localObject3[j] = (i + localObject3[j]);
                break label228;
              }
              if (i >= c.e(paramList.dcJ))
              {
                localObject3 = paramList.dcV;
                j = c.b.dcN.index;
                localObject3[j] += 1;
                localObject3 = paramList.dcW;
                j = c.b.dcN.index;
                localObject3[j] = (i + localObject3[j]);
                break label228;
              }
              localObject3 = paramList.dcV;
              j = c.b.dcO.index;
              localObject3[j] += 1;
              localObject3 = paramList.dcW;
              j = c.b.dcO.index;
              int k = localObject3[j];
              localObject3[j] = (Math.max(i, 0) + k);
              break label228;
            }
            Object localObject4 = new JSONObject();
            ((JSONObject)localObject4).put(c.b.dcK.name(), paramList.dcV[c.b.dcK.index]);
            ((JSONObject)localObject4).put(c.b.dcL.name(), paramList.dcV[c.b.dcL.index]);
            ((JSONObject)localObject4).put(c.b.dcM.name(), paramList.dcV[c.b.dcM.index]);
            ((JSONObject)localObject4).put(c.b.dcN.name(), paramList.dcV[c.b.dcN.index]);
            ((JSONObject)localObject4).put(c.b.dcO.name(), paramList.dcV[c.b.dcO.index]);
            JSONObject localJSONObject = new JSONObject();
            localJSONObject.put(c.b.dcK.name(), paramList.dcW[c.b.dcK.index]);
            localJSONObject.put(c.b.dcL.name(), paramList.dcW[c.b.dcL.index]);
            localJSONObject.put(c.b.dcM.name(), paramList.dcW[c.b.dcM.index]);
            localJSONObject.put(c.b.dcN.name(), paramList.dcW[c.b.dcN.index]);
            localJSONObject.put(c.b.dcO.name(), paramList.dcW[c.b.dcO.index]);
            localObject3 = com.tencent.matrix.g.a.a(new JSONObject(), ((com.tencent.matrix.trace.a)localObject2).getApplication());
            ((JSONObject)localObject3).put("scene", paramList.cPC);
            ((JSONObject)localObject3).put("dropLevel", localObject4);
            ((JSONObject)localObject3).put("dropSum", localJSONObject);
            ((JSONObject)localObject3).put("fps", f1);
            localObject4 = new com.tencent.matrix.report.c();
            ((com.tencent.matrix.report.c)localObject4).tag = "Trace_FPS";
            ((com.tencent.matrix.report.c)localObject4).cWe = ((JSONObject)localObject3);
            ((com.tencent.matrix.trace.a)localObject2).onDetectIssue((com.tencent.matrix.report.c)localObject4);
            paramList.dcT = 0;
            paramList.dcU = 0;
            paramList.dcS = 0L;
            break;
          }
          catch (JSONException localJSONException)
          {
            com.tencent.matrix.g.c.e("Matrix.FrameTracer", "json error", new Object[] { localJSONException });
            paramList.dcT = 0;
            paramList.dcU = 0;
            paramList.dcS = 0L;
            break;
          }
          finally
          {
            paramList.dcT = 0;
            paramList.dcU = 0;
            paramList.dcS = 0L;
          }
        }
        return;
      }
    }
    
    public final int TD()
    {
      return 300;
    }
    
    public final Executor getExecutor()
    {
      return this.executor;
    }
  }
  
  final class d
  {
    String cPC;
    long dcS;
    int dcT = 0;
    int dcU;
    int[] dcV = new int[c.b.values().length];
    int[] dcW = new int[c.b.values().length];
    
    d(String paramString)
    {
      this.cPC = paramString;
    }
    
    public final String toString()
    {
      return "visibleScene=" + this.cPC + ", sumFrame=" + this.dcT + ", sumDroppedFrames=" + this.dcU + ", sumFrameCost=" + this.dcS + ", dropLevel=" + Arrays.toString(this.dcV);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.matrix.trace.f.c
 * JD-Core Version:    0.7.0.1
 */