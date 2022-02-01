package com.tencent.mm.audio.mix.e;

import android.os.Process;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.audio.mix.a.e;
import java.lang.ref.WeakReference;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
import java.util.concurrent.atomic.AtomicBoolean;

public final class c
{
  protected Object fmX;
  volatile LinkedList<String> fmz;
  protected AtomicBoolean fnY;
  protected AtomicBoolean fnZ;
  public i foL;
  com.tencent.mm.audio.mix.f.d foM;
  protected AtomicBoolean foN;
  protected volatile HashMap<String, Boolean> foO;
  private Thread foP;
  private volatile LinkedList<String> foQ;
  private volatile HashMap<String, Object> foR;
  public volatile HashMap<String, List<e>> foS;
  private volatile HashMap<String, Boolean> foT;
  public volatile HashMap<String, WeakReference<com.tencent.mm.audio.mix.decode.c>> foU;
  private Object foV;
  private List<e> foW;
  private volatile HashMap<String, Boolean> foX;
  private volatile HashMap<String, Boolean> foY;
  private volatile HashMap<String, Integer> foZ;
  private volatile HashMap<String, Long> fpa;
  public long fpb;
  private boolean fpc;
  int fpd;
  long fpe;
  private long fpf;
  private long fpg;
  private Runnable fph;
  
  public c(com.tencent.mm.audio.mix.f.d paramd)
  {
    AppMethodBeat.i(136837);
    this.fnZ = new AtomicBoolean(false);
    this.fnY = new AtomicBoolean(false);
    this.foN = new AtomicBoolean(false);
    this.foO = new HashMap();
    this.fmX = new Object();
    this.foQ = new LinkedList();
    this.foR = new HashMap();
    this.foS = new HashMap();
    this.foT = new HashMap();
    this.foU = new HashMap();
    this.foV = new Object();
    this.foW = new ArrayList();
    this.foX = new HashMap();
    this.foY = new HashMap();
    this.foZ = new HashMap();
    this.fpa = new HashMap();
    this.fmz = new LinkedList();
    this.fpb = 0L;
    this.fpc = false;
    this.fpd = 0;
    this.fpe = 0L;
    this.fpf = 0L;
    this.fpg = 0L;
    this.fph = new Runnable()
    {
      public final void run()
      {
        AppMethodBeat.i(136836);
        Process.setThreadPriority(-19);
        List localList;
        com.tencent.mm.audio.mix.a.b localb;
        com.tencent.mm.audio.mix.f.d locald;
        if (c.this.adI())
        {
          com.tencent.mm.audio.mix.h.b.e("MicroMsg.Mix.AudioMixController", "stop and exit");
          AppMethodBeat.o(136836);
          return;
          System.nanoTime();
          localList = c.this.aeh();
          if (localList.size() > 0)
          {
            long l1 = System.nanoTime();
            localb = c.this.foL.M(localList);
            long l2 = System.nanoTime();
            ??? = c.this;
            ((c)???).fpd += 1;
            c.this.fpe = (l2 - l1 + c.this.fpe);
            if (localb != null)
            {
              ??? = c.this;
              localb.fmz.addAll(((c)???).fmz);
              ((c)???).fmz.clear();
              locald = ((c)???).foM;
              if (!locald.fpV.get()) {
                break label219;
              }
              com.tencent.mm.audio.mix.h.b.e("MicroMsg.Mix.AudioMixPlayerImpl", "exit, not to add MixBuff queue");
            }
          }
        }
        for (;;)
        {
          c.L(localList);
          localList.clear();
          if (c.this.adI()) {
            break label327;
          }
          c.this.aee();
          if (!c.this.adI()) {
            break;
          }
          AppMethodBeat.o(136836);
          return;
          label219:
          synchronized (locald.fpX)
          {
            for (;;)
            {
              if (locald.fpW.size() >= 2)
              {
                boolean bool = locald.fpV.get();
                if (!bool) {
                  try
                  {
                    locald.fpX.wait();
                  }
                  catch (InterruptedException localInterruptedException)
                  {
                    com.tencent.mm.audio.mix.h.b.printErrStackTrace("MicroMsg.Mix.AudioMixPlayerImpl", localInterruptedException, "enqueueMixBuffer", new Object[0]);
                  }
                }
              }
            }
          }
          locald.fpW.add(localb);
          locald.fpX.notifyAll();
        }
        label327:
        com.tencent.mm.audio.mix.h.b.i("MicroMsg.Mix.AudioMixController", "mix thread stop and exit");
        AppMethodBeat.o(136836);
      }
    };
    this.foM = paramd;
    AppMethodBeat.o(136837);
  }
  
  static void L(List<e> paramList)
  {
    AppMethodBeat.i(136863);
    paramList = paramList.iterator();
    while (paramList.hasNext())
    {
      e locale = (e)paramList.next();
      if ((locale != null) && (locale.fmJ)) {
        com.tencent.mm.audio.mix.b.d.ado().b(locale);
      }
    }
    AppMethodBeat.o(136863);
  }
  
  private void aed()
  {
    AppMethodBeat.i(136841);
    synchronized (this.fmX)
    {
      try
      {
        this.fmX.notify();
        AppMethodBeat.o(136841);
        return;
      }
      catch (Exception localException)
      {
        for (;;)
        {
          com.tencent.mm.audio.mix.h.b.printErrStackTrace("MicroMsg.Mix.AudioMixController", localException, "notifyMix", new Object[0]);
        }
      }
    }
  }
  
  private void aef()
  {
    AppMethodBeat.i(136843);
    try
    {
      this.foV.notifyAll();
      AppMethodBeat.o(136843);
      return;
    }
    catch (Exception localException)
    {
      com.tencent.mm.audio.mix.h.b.printErrStackTrace("MicroMsg.Mix.AudioMixController", localException, "notifySyncPcmData", new Object[0]);
      AppMethodBeat.o(136843);
    }
  }
  
  private void aei()
  {
    AppMethodBeat.i(136860);
    int i = 0;
    while (i < this.foQ.size())
    {
      ((List)this.foS.get(this.foQ.get(i))).clear();
      i += 1;
    }
    AppMethodBeat.o(136860);
  }
  
  private com.tencent.mm.audio.mix.decode.c hI(String paramString)
  {
    AppMethodBeat.i(257316);
    if (this.foU.containsKey(paramString))
    {
      paramString = (WeakReference)this.foU.get(paramString);
      if ((paramString == null) || (paramString.get() == null)) {}
    }
    for (paramString = (com.tencent.mm.audio.mix.decode.c)paramString.get();; paramString = null)
    {
      AppMethodBeat.o(257316);
      return paramString;
    }
  }
  
  private boolean hK(String paramString)
  {
    AppMethodBeat.i(136854);
    synchronized (this.foV)
    {
      if ((this.foX.containsKey(paramString)) && (((Boolean)this.foX.get(paramString)).booleanValue()))
      {
        AppMethodBeat.o(136854);
        return true;
      }
      AppMethodBeat.o(136854);
      return false;
    }
  }
  
  private void hL(String paramString)
  {
    AppMethodBeat.i(136855);
    this.foM.r(5, paramString);
    com.tencent.mm.al.b localb = this.foM.hN(paramString);
    if (localb != null) {
      localb.currentTime = ((int)hH(paramString));
    }
    hG(paramString);
    AppMethodBeat.o(136855);
  }
  
  /* Error */
  public final int a(String paramString, e arg2, com.tencent.mm.audio.mix.decode.c paramc)
  {
    // Byte code:
    //   0: ldc_w 261
    //   3: invokestatic 65	com/tencent/matrix/trace/core/AppMethodBeat:i	(I)V
    //   6: aload_2
    //   7: ifnull +17 -> 24
    //   10: aload_1
    //   11: invokestatic 267	android/text/TextUtils:isEmpty	(Ljava/lang/CharSequence;)Z
    //   14: ifne +10 -> 24
    //   17: aload_2
    //   18: getfield 271	com/tencent/mm/audio/mix/a/e:fmy	[B
    //   21: ifnonnull +19 -> 40
    //   24: ldc 181
    //   26: ldc_w 273
    //   29: invokestatic 277	com/tencent/mm/audio/mix/h/b:e	(Ljava/lang/String;Ljava/lang/String;)V
    //   32: ldc_w 261
    //   35: invokestatic 135	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   38: iconst_0
    //   39: ireturn
    //   40: aconst_null
    //   41: astore 6
    //   43: aconst_null
    //   44: astore 5
    //   46: aload_0
    //   47: getfield 92	com/tencent/mm/audio/mix/e/c:foS	Ljava/util/HashMap;
    //   50: aload_1
    //   51: invokevirtual 219	java/util/HashMap:containsKey	(Ljava/lang/Object;)Z
    //   54: ifne +102 -> 156
    //   57: ldc 181
    //   59: ldc_w 279
    //   62: iconst_1
    //   63: anewarray 4	java/lang/Object
    //   66: dup
    //   67: iconst_0
    //   68: aload_1
    //   69: aastore
    //   70: invokestatic 282	com/tencent/mm/audio/mix/h/b:e	(Ljava/lang/String;Ljava/lang/String;[Ljava/lang/Object;)V
    //   73: aload_0
    //   74: getfield 98	com/tencent/mm/audio/mix/e/c:foV	Ljava/lang/Object;
    //   77: astore 7
    //   79: aload 7
    //   81: monitorenter
    //   82: aload_0
    //   83: getfield 92	com/tencent/mm/audio/mix/e/c:foS	Ljava/util/HashMap;
    //   86: aload_1
    //   87: new 100	java/util/ArrayList
    //   90: dup
    //   91: invokespecial 101	java/util/ArrayList:<init>	()V
    //   94: invokevirtual 286	java/util/HashMap:put	(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;
    //   97: pop
    //   98: aload_0
    //   99: getfield 88	com/tencent/mm/audio/mix/e/c:foQ	Ljava/util/LinkedList;
    //   102: aload_1
    //   103: invokevirtual 289	java/util/LinkedList:contains	(Ljava/lang/Object;)Z
    //   106: ifne +12 -> 118
    //   109: aload_0
    //   110: getfield 88	com/tencent/mm/audio/mix/e/c:foQ	Ljava/util/LinkedList;
    //   113: aload_1
    //   114: invokevirtual 292	java/util/LinkedList:add	(Ljava/lang/Object;)Z
    //   117: pop
    //   118: aload 5
    //   120: astore 6
    //   122: aload_0
    //   123: getfield 90	com/tencent/mm/audio/mix/e/c:foR	Ljava/util/HashMap;
    //   126: aload_1
    //   127: invokevirtual 219	java/util/HashMap:containsKey	(Ljava/lang/Object;)Z
    //   130: ifne +23 -> 153
    //   133: new 4	java/lang/Object
    //   136: dup
    //   137: invokespecial 58	java/lang/Object:<init>	()V
    //   140: astore 6
    //   142: aload_0
    //   143: getfield 90	com/tencent/mm/audio/mix/e/c:foR	Ljava/util/HashMap;
    //   146: aload_1
    //   147: aload 6
    //   149: invokevirtual 286	java/util/HashMap:put	(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;
    //   152: pop
    //   153: aload 7
    //   155: monitorexit
    //   156: aload 6
    //   158: astore 5
    //   160: aload 6
    //   162: ifnonnull +57 -> 219
    //   165: aload_0
    //   166: getfield 90	com/tencent/mm/audio/mix/e/c:foR	Ljava/util/HashMap;
    //   169: aload_1
    //   170: invokevirtual 219	java/util/HashMap:containsKey	(Ljava/lang/Object;)Z
    //   173: ifne +155 -> 328
    //   176: aload_0
    //   177: getfield 98	com/tencent/mm/audio/mix/e/c:foV	Ljava/lang/Object;
    //   180: astore 6
    //   182: aload 6
    //   184: monitorenter
    //   185: aload_0
    //   186: getfield 90	com/tencent/mm/audio/mix/e/c:foR	Ljava/util/HashMap;
    //   189: aload_1
    //   190: invokevirtual 219	java/util/HashMap:containsKey	(Ljava/lang/Object;)Z
    //   193: ifne +110 -> 303
    //   196: new 4	java/lang/Object
    //   199: dup
    //   200: invokespecial 58	java/lang/Object:<init>	()V
    //   203: astore 5
    //   205: aload_0
    //   206: getfield 90	com/tencent/mm/audio/mix/e/c:foR	Ljava/util/HashMap;
    //   209: aload_1
    //   210: aload 5
    //   212: invokevirtual 286	java/util/HashMap:put	(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;
    //   215: pop
    //   216: aload 6
    //   218: monitorexit
    //   219: aload 5
    //   221: ifnonnull +204 -> 425
    //   224: new 4	java/lang/Object
    //   227: dup
    //   228: invokespecial 58	java/lang/Object:<init>	()V
    //   231: astore 5
    //   233: aload_0
    //   234: getfield 96	com/tencent/mm/audio/mix/e/c:foU	Ljava/util/HashMap;
    //   237: aload_1
    //   238: invokevirtual 219	java/util/HashMap:containsKey	(Ljava/lang/Object;)Z
    //   241: ifne +20 -> 261
    //   244: aload_0
    //   245: getfield 96	com/tencent/mm/audio/mix/e/c:foU	Ljava/util/HashMap;
    //   248: aload_1
    //   249: new 221	java/lang/ref/WeakReference
    //   252: dup
    //   253: aload_3
    //   254: invokespecial 295	java/lang/ref/WeakReference:<init>	(Ljava/lang/Object;)V
    //   257: invokevirtual 286	java/util/HashMap:put	(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;
    //   260: pop
    //   261: aload_0
    //   262: getfield 92	com/tencent/mm/audio/mix/e/c:foS	Ljava/util/HashMap;
    //   265: aload_1
    //   266: invokevirtual 209	java/util/HashMap:get	(Ljava/lang/Object;)Ljava/lang/Object;
    //   269: checkcast 141	java/util/List
    //   272: astore_1
    //   273: aload 5
    //   275: monitorenter
    //   276: aload_1
    //   277: ifnonnull +64 -> 341
    //   280: aload 5
    //   282: monitorexit
    //   283: ldc_w 261
    //   286: invokestatic 135	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   289: iconst_0
    //   290: ireturn
    //   291: astore_1
    //   292: aload 7
    //   294: monitorexit
    //   295: ldc_w 261
    //   298: invokestatic 135	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   301: aload_1
    //   302: athrow
    //   303: aload_0
    //   304: getfield 90	com/tencent/mm/audio/mix/e/c:foR	Ljava/util/HashMap;
    //   307: aload_1
    //   308: invokevirtual 209	java/util/HashMap:get	(Ljava/lang/Object;)Ljava/lang/Object;
    //   311: astore 5
    //   313: goto -97 -> 216
    //   316: astore_1
    //   317: aload 6
    //   319: monitorexit
    //   320: ldc_w 261
    //   323: invokestatic 135	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   326: aload_1
    //   327: athrow
    //   328: aload_0
    //   329: getfield 90	com/tencent/mm/audio/mix/e/c:foR	Ljava/util/HashMap;
    //   332: aload_1
    //   333: invokevirtual 209	java/util/HashMap:get	(Ljava/lang/Object;)Ljava/lang/Object;
    //   336: astore 5
    //   338: goto -119 -> 219
    //   341: aload_1
    //   342: iconst_0
    //   343: aload_2
    //   344: invokeinterface 298 3 0
    //   349: aload 5
    //   351: monitorexit
    //   352: aload_0
    //   353: getfield 98	com/tencent/mm/audio/mix/e/c:foV	Ljava/lang/Object;
    //   356: astore_2
    //   357: aload_2
    //   358: monitorenter
    //   359: aload_0
    //   360: getfield 98	com/tencent/mm/audio/mix/e/c:foV	Ljava/lang/Object;
    //   363: invokevirtual 194	java/lang/Object:notifyAll	()V
    //   366: aload_2
    //   367: monitorexit
    //   368: aload_1
    //   369: invokeinterface 299 1 0
    //   374: istore 4
    //   376: ldc_w 261
    //   379: invokestatic 135	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   382: iload 4
    //   384: ireturn
    //   385: astore_1
    //   386: aload 5
    //   388: monitorexit
    //   389: ldc_w 261
    //   392: invokestatic 135	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   395: aload_1
    //   396: athrow
    //   397: astore_3
    //   398: ldc 181
    //   400: aload_3
    //   401: ldc_w 301
    //   404: iconst_0
    //   405: anewarray 4	java/lang/Object
    //   408: invokestatic 189	com/tencent/mm/audio/mix/h/b:printErrStackTrace	(Ljava/lang/String;Ljava/lang/Throwable;Ljava/lang/String;[Ljava/lang/Object;)V
    //   411: goto -45 -> 366
    //   414: astore_1
    //   415: aload_2
    //   416: monitorexit
    //   417: ldc_w 261
    //   420: invokestatic 135	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   423: aload_1
    //   424: athrow
    //   425: goto -192 -> 233
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	428	0	this	c
    //   0	428	1	paramString	String
    //   0	428	3	paramc	com.tencent.mm.audio.mix.decode.c
    //   374	9	4	i	int
    //   44	343	5	localObject1	Object
    //   41	277	6	localObject2	Object
    //   77	216	7	localObject3	Object
    // Exception table:
    //   from	to	target	type
    //   82	118	291	finally
    //   122	153	291	finally
    //   153	156	291	finally
    //   185	216	316	finally
    //   216	219	316	finally
    //   303	313	316	finally
    //   341	352	385	finally
    //   359	366	397	java/lang/Exception
    //   359	366	414	finally
    //   366	368	414	finally
    //   398	411	414	finally
  }
  
  public final boolean adH()
  {
    AppMethodBeat.i(293032);
    boolean bool = this.fnY.get();
    AppMethodBeat.o(293032);
    return bool;
  }
  
  public final boolean adI()
  {
    AppMethodBeat.i(293033);
    boolean bool = this.fnZ.get();
    AppMethodBeat.o(293033);
    return bool;
  }
  
  public final void aea()
  {
    AppMethodBeat.i(136838);
    com.tencent.mm.audio.mix.h.b.i("MicroMsg.Mix.AudioMixController", "prepareMix");
    this.fnZ.set(false);
    this.fnY.set(false);
    aej();
    aed();
    AppMethodBeat.o(136838);
  }
  
  public final void aeb()
  {
    AppMethodBeat.i(136839);
    com.tencent.mm.audio.mix.h.b.i("MicroMsg.Mix.AudioMixController", "pauseMix");
    this.fnY.set(true);
    if (this.fpd > 0)
    {
      this.fpb = (this.fpe / this.fpd);
      com.tencent.mm.audio.mix.h.b.i("MicroMsg.Mix.AudioMixController", "mixAverageTime:%d", new Object[] { Long.valueOf(this.fpb) });
    }
    this.fpf = 0L;
    this.fpd = 0;
    this.fpe = 0L;
    this.fpg = 0L;
    AppMethodBeat.o(136839);
  }
  
  public final void aec()
  {
    AppMethodBeat.i(136840);
    com.tencent.mm.audio.mix.h.b.i("MicroMsg.Mix.AudioMixController", "stopMix");
    this.fnZ.set(true);
    this.fnY.set(false);
    aed();
    synchronized (this.foV)
    {
      aef();
      aei();
      aek();
      AppMethodBeat.o(136840);
      return;
    }
  }
  
  public final void aee()
  {
    AppMethodBeat.i(136842);
    synchronized (this.fmX)
    {
      for (;;)
      {
        if (!this.fnZ.get())
        {
          boolean bool = this.fnY.get();
          if (bool) {
            try
            {
              com.tencent.mm.audio.mix.h.b.i("MicroMsg.Mix.AudioMixController", "waitMix");
              this.fmX.wait();
            }
            catch (Exception localException)
            {
              com.tencent.mm.audio.mix.h.b.printErrStackTrace("MicroMsg.Mix.AudioMixController", localException, "waitMix", new Object[0]);
            }
          }
        }
      }
    }
    AppMethodBeat.o(136842);
  }
  
  public final boolean aeg()
  {
    AppMethodBeat.i(136847);
    boolean bool = this.foN.get();
    AppMethodBeat.o(136847);
    return bool;
  }
  
  protected final List<e> aeh()
  {
    AppMethodBeat.i(136858);
    ArrayList localArrayList = new ArrayList();
    for (;;)
    {
      String str;
      List localList;
      com.tencent.mm.audio.mix.decode.c localc;
      synchronized (this.foV)
      {
        localArrayList.addAll(this.foQ);
        int i = 0;
        if (i >= localArrayList.size()) {
          break;
        }
        str = (String)localArrayList.get(i);
        if (!hF(str))
        {
          localList = (List)this.foS.get(str);
          if ((localList != null) && (localList.size() != 0)) {
            continue;
          }
          if (hK(str))
          {
            p(str, false);
            hL(str);
          }
        }
        i += 1;
      }
      localc.kt(localList.size());
      Object localObject7 = this.foR.get(str);
      if (localObject7 != null)
      {
        int j;
        try
        {
          j = localList.size();
          if (j <= 0) {
            continue;
          }
        }
        finally
        {
          AppMethodBeat.o(136858);
        }
        Object localObject5;
        for (;;)
        {
          ??? = null;
          if (j <= 0) {
            break;
          }
          localObject5 = (e)localList.remove(j - 1);
          ??? = localObject5;
          if (!this.foZ.containsKey(str)) {
            break;
          }
          ??? = localObject5;
          if (((Integer)this.foZ.get(str)).intValue() <= ((e)localObject5).fmI) {
            break;
          }
          j -= 1;
        }
        if (??? == null)
        {
          if (localc != null) {
            localc.kt(localList.size());
          }
        }
        else
        {
          this.fpa.put(str, Long.valueOf(((e)???).fmI));
          localObject5 = this.foM.hN(str);
          if ((localObject5 != null) && (((com.tencent.mm.al.b)localObject5).lzK == 0.0D) && (!((e)???).fmJ))
          {
            localObject5 = com.tencent.mm.audio.mix.b.d.ado().adp();
            if (localObject5 != null)
            {
              if (((e)localObject5).fmy == null) {
                ((e)localObject5).fmy = new byte[3536];
              }
              ((e)localObject5).reset();
              this.foW.add(localObject5);
            }
          }
          for (;;)
          {
            this.fmz.add(str);
            break;
            this.foW.add(???);
            continue;
            if ((localObject5 != null) && (((com.tencent.mm.al.b)localObject5).lzK == 0.0D) && (((e)???).fmJ))
            {
              ((e)???).reset();
              this.foW.add(???);
            }
            else
            {
              this.foW.add(???);
            }
          }
        }
      }
    }
    synchronized (this.foV)
    {
      if (this.foW.size() == 0)
      {
        boolean bool = this.fnZ.get();
        if (bool) {}
      }
      try
      {
        com.tencent.mm.audio.mix.h.b.i("MicroMsg.Mix.AudioMixController", "wait read data");
        this.foV.wait();
        ??? = this.foW;
        AppMethodBeat.o(136858);
        return ???;
      }
      catch (Exception localException)
      {
        for (;;)
        {
          com.tencent.mm.audio.mix.h.b.printErrStackTrace("MicroMsg.Mix.AudioMixController", localException, "readMixDataFromPcmTrack", new Object[0]);
        }
      }
    }
  }
  
  public final void aej()
  {
    AppMethodBeat.i(136861);
    if (this.foP == null)
    {
      this.foP = new Thread(this.fph, "audio_mix_controller");
      this.foP.start();
    }
    AppMethodBeat.o(136861);
  }
  
  public final void aek()
  {
    if (this.foP != null) {
      this.foP = null;
    }
  }
  
  public final void clearCache()
  {
    AppMethodBeat.i(136859);
    com.tencent.mm.audio.mix.h.b.i("MicroMsg.Mix.AudioMixController", "clearCache");
    synchronized (this.foV)
    {
      aei();
      this.foR.clear();
      AppMethodBeat.o(136859);
      return;
    }
  }
  
  /* Error */
  public final boolean f(String arg1, int paramInt, boolean paramBoolean)
  {
    // Byte code:
    //   0: ldc_w 430
    //   3: invokestatic 65	com/tencent/matrix/trace/core/AppMethodBeat:i	(I)V
    //   6: aload_0
    //   7: getfield 88	com/tencent/mm/audio/mix/e/c:foQ	Ljava/util/LinkedList;
    //   10: aload_1
    //   11: invokevirtual 289	java/util/LinkedList:contains	(Ljava/lang/Object;)Z
    //   14: ifne +11 -> 25
    //   17: ldc_w 430
    //   20: invokestatic 135	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   23: iconst_0
    //   24: ireturn
    //   25: iload_2
    //   26: ifge +20 -> 46
    //   29: aload_0
    //   30: getfield 109	com/tencent/mm/audio/mix/e/c:foZ	Ljava/util/HashMap;
    //   33: aload_1
    //   34: invokevirtual 432	java/util/HashMap:remove	(Ljava/lang/Object;)Ljava/lang/Object;
    //   37: pop
    //   38: ldc_w 430
    //   41: invokestatic 135	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   44: iconst_0
    //   45: ireturn
    //   46: invokestatic 438	java/lang/System:currentTimeMillis	()J
    //   49: lstore 9
    //   51: iload_2
    //   52: ifne +57 -> 109
    //   55: aload_0
    //   56: getfield 109	com/tencent/mm/audio/mix/e/c:foZ	Ljava/util/HashMap;
    //   59: aload_1
    //   60: invokevirtual 432	java/util/HashMap:remove	(Ljava/lang/Object;)Ljava/lang/Object;
    //   63: pop
    //   64: aload_0
    //   65: getfield 92	com/tencent/mm/audio/mix/e/c:foS	Ljava/util/HashMap;
    //   68: aload_1
    //   69: invokevirtual 209	java/util/HashMap:get	(Ljava/lang/Object;)Ljava/lang/Object;
    //   72: checkcast 141	java/util/List
    //   75: astore 12
    //   77: aload 12
    //   79: ifnull +13 -> 92
    //   82: aload 12
    //   84: invokeinterface 299 1 0
    //   89: ifne +36 -> 125
    //   92: aload_0
    //   93: getfield 109	com/tencent/mm/audio/mix/e/c:foZ	Ljava/util/HashMap;
    //   96: aload_1
    //   97: invokevirtual 432	java/util/HashMap:remove	(Ljava/lang/Object;)Ljava/lang/Object;
    //   100: pop
    //   101: ldc_w 430
    //   104: invokestatic 135	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   107: iconst_0
    //   108: ireturn
    //   109: aload_0
    //   110: getfield 109	com/tencent/mm/audio/mix/e/c:foZ	Ljava/util/HashMap;
    //   113: aload_1
    //   114: iload_2
    //   115: invokestatic 441	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
    //   118: invokevirtual 286	java/util/HashMap:put	(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;
    //   121: pop
    //   122: goto -58 -> 64
    //   125: aload_0
    //   126: getfield 132	com/tencent/mm/audio/mix/e/c:foM	Lcom/tencent/mm/audio/mix/f/d;
    //   129: aload_1
    //   130: invokevirtual 246	com/tencent/mm/audio/mix/f/d:hN	(Ljava/lang/String;)Lcom/tencent/mm/al/b;
    //   133: astore 11
    //   135: aload 11
    //   137: ifnonnull +20 -> 157
    //   140: aload_0
    //   141: getfield 109	com/tencent/mm/audio/mix/e/c:foZ	Ljava/util/HashMap;
    //   144: aload_1
    //   145: invokevirtual 432	java/util/HashMap:remove	(Ljava/lang/Object;)Ljava/lang/Object;
    //   148: pop
    //   149: ldc_w 430
    //   152: invokestatic 135	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   155: iconst_0
    //   156: ireturn
    //   157: ldc 181
    //   159: ldc_w 443
    //   162: invokestatic 313	com/tencent/mm/audio/mix/h/b:i	(Ljava/lang/String;Ljava/lang/String;)V
    //   165: aload_0
    //   166: aload_1
    //   167: invokevirtual 369	com/tencent/mm/audio/mix/e/c:hF	(Ljava/lang/String;)Z
    //   170: istore 8
    //   172: iload 8
    //   174: ifne +8 -> 182
    //   177: aload_0
    //   178: aload_1
    //   179: invokevirtual 446	com/tencent/mm/audio/mix/e/c:hD	(Ljava/lang/String;)V
    //   182: aload 12
    //   184: invokeinterface 299 1 0
    //   189: istore 6
    //   191: invokestatic 452	com/tencent/mm/audio/mix/b/f:ads	()Lcom/tencent/mm/audio/mix/b/f;
    //   194: aload 11
    //   196: getfield 456	com/tencent/mm/al/b:filePath	Ljava/lang/String;
    //   199: invokevirtual 460	com/tencent/mm/audio/mix/b/f:hq	(Ljava/lang/String;)Lcom/tencent/mm/audio/mix/a/d;
    //   202: astore 13
    //   204: aload 13
    //   206: invokevirtual 463	com/tencent/mm/audio/mix/a/d:size	()I
    //   209: istore 7
    //   211: iload_2
    //   212: bipush 20
    //   214: idiv
    //   215: istore 5
    //   217: aload_0
    //   218: aload_1
    //   219: invokevirtual 250	com/tencent/mm/audio/mix/e/c:hH	(Ljava/lang/String;)J
    //   222: ldc2_w 464
    //   225: ldiv
    //   226: l2i
    //   227: istore 4
    //   229: aload_0
    //   230: getfield 90	com/tencent/mm/audio/mix/e/c:foR	Ljava/util/HashMap;
    //   233: aload_1
    //   234: invokevirtual 209	java/util/HashMap:get	(Ljava/lang/Object;)Ljava/lang/Object;
    //   237: astore 11
    //   239: aload 11
    //   241: ifnonnull +20 -> 261
    //   244: aload_0
    //   245: getfield 109	com/tencent/mm/audio/mix/e/c:foZ	Ljava/util/HashMap;
    //   248: aload_1
    //   249: invokevirtual 432	java/util/HashMap:remove	(Ljava/lang/Object;)Ljava/lang/Object;
    //   252: pop
    //   253: ldc_w 430
    //   256: invokestatic 135	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   259: iconst_0
    //   260: ireturn
    //   261: aload_0
    //   262: aload_1
    //   263: invokespecial 379	com/tencent/mm/audio/mix/e/c:hI	(Ljava/lang/String;)Lcom/tencent/mm/audio/mix/decode/c;
    //   266: astore 14
    //   268: iload 5
    //   270: iload 4
    //   272: if_icmple +208 -> 480
    //   275: iload 5
    //   277: iload 7
    //   279: if_icmpgt +201 -> 480
    //   282: ldc 181
    //   284: ldc_w 467
    //   287: invokestatic 277	com/tencent/mm/audio/mix/h/b:e	(Ljava/lang/String;Ljava/lang/String;)V
    //   290: aload 11
    //   292: monitorenter
    //   293: iconst_0
    //   294: istore_2
    //   295: iload_2
    //   296: iload 5
    //   298: iload 4
    //   300: isub
    //   301: if_icmpge +54 -> 355
    //   304: iload_2
    //   305: iload 6
    //   307: if_icmpge +48 -> 355
    //   310: aload 12
    //   312: aload 12
    //   314: invokeinterface 299 1 0
    //   319: iconst_1
    //   320: isub
    //   321: invokeinterface 385 2 0
    //   326: checkcast 157	com/tencent/mm/audio/mix/a/e
    //   329: astore 13
    //   331: aload 13
    //   333: ifnull +343 -> 676
    //   336: aload 13
    //   338: getfield 160	com/tencent/mm/audio/mix/a/e:fmJ	Z
    //   341: ifeq +335 -> 676
    //   344: invokestatic 166	com/tencent/mm/audio/mix/b/d:ado	()Lcom/tencent/mm/audio/mix/b/d;
    //   347: aload 13
    //   349: invokevirtual 170	com/tencent/mm/audio/mix/b/d:b	(Lcom/tencent/mm/audio/mix/a/e;)V
    //   352: goto +324 -> 676
    //   355: aload 11
    //   357: monitorexit
    //   358: aload 14
    //   360: ifnull +15 -> 375
    //   363: aload 14
    //   365: aload 12
    //   367: invokeinterface 299 1 0
    //   372: invokevirtual 382	com/tencent/mm/audio/mix/decode/c:kt	(I)V
    //   375: iload 8
    //   377: ifne +59 -> 436
    //   380: ldc 181
    //   382: ldc_w 469
    //   385: invokestatic 313	com/tencent/mm/audio/mix/h/b:i	(Ljava/lang/String;Ljava/lang/String;)V
    //   388: aload_0
    //   389: getfield 98	com/tencent/mm/audio/mix/e/c:foV	Ljava/lang/Object;
    //   392: astore 11
    //   394: aload 11
    //   396: monitorenter
    //   397: aload_0
    //   398: getfield 94	com/tencent/mm/audio/mix/e/c:foT	Ljava/util/HashMap;
    //   401: aload_1
    //   402: invokevirtual 219	java/util/HashMap:containsKey	(Ljava/lang/Object;)Z
    //   405: ifeq +235 -> 640
    //   408: aload_0
    //   409: getfield 94	com/tencent/mm/audio/mix/e/c:foT	Ljava/util/HashMap;
    //   412: aload_1
    //   413: getstatic 473	java/lang/Boolean:FALSE	Ljava/lang/Boolean;
    //   416: invokevirtual 286	java/util/HashMap:put	(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;
    //   419: pop
    //   420: aload 11
    //   422: monitorexit
    //   423: aload_0
    //   424: getfield 98	com/tencent/mm/audio/mix/e/c:foV	Ljava/lang/Object;
    //   427: astore_1
    //   428: aload_1
    //   429: monitorenter
    //   430: aload_0
    //   431: invokespecial 341	com/tencent/mm/audio/mix/e/c:aef	()V
    //   434: aload_1
    //   435: monitorexit
    //   436: ldc 181
    //   438: ldc_w 475
    //   441: iconst_1
    //   442: anewarray 4	java/lang/Object
    //   445: dup
    //   446: iconst_0
    //   447: invokestatic 438	java/lang/System:currentTimeMillis	()J
    //   450: lload 9
    //   452: lsub
    //   453: invokestatic 333	java/lang/Long:valueOf	(J)Ljava/lang/Long;
    //   456: aastore
    //   457: invokestatic 335	com/tencent/mm/audio/mix/h/b:i	(Ljava/lang/String;Ljava/lang/String;[Ljava/lang/Object;)V
    //   460: ldc_w 430
    //   463: invokestatic 135	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   466: iconst_1
    //   467: ireturn
    //   468: astore_1
    //   469: aload 11
    //   471: monitorexit
    //   472: ldc_w 430
    //   475: invokestatic 135	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   478: aload_1
    //   479: athrow
    //   480: iload 5
    //   482: iload 4
    //   484: if_icmpge +72 -> 556
    //   487: iload 4
    //   489: iload 7
    //   491: if_icmpgt +65 -> 556
    //   494: iload_3
    //   495: ifne +61 -> 556
    //   498: ldc 181
    //   500: ldc_w 477
    //   503: invokestatic 277	com/tencent/mm/audio/mix/h/b:e	(Ljava/lang/String;Ljava/lang/String;)V
    //   506: aload 11
    //   508: monitorenter
    //   509: aload 12
    //   511: invokestatic 479	com/tencent/mm/audio/mix/e/c:L	(Ljava/util/List;)V
    //   514: aload 12
    //   516: invokeinterface 212 1 0
    //   521: aload 11
    //   523: monitorexit
    //   524: aload 14
    //   526: ifnull -151 -> 375
    //   529: aload 14
    //   531: aload 12
    //   533: invokeinterface 299 1 0
    //   538: invokevirtual 382	com/tencent/mm/audio/mix/decode/c:kt	(I)V
    //   541: goto -166 -> 375
    //   544: astore_1
    //   545: aload 11
    //   547: monitorexit
    //   548: ldc_w 430
    //   551: invokestatic 135	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   554: aload_1
    //   555: athrow
    //   556: iload 5
    //   558: iload 4
    //   560: if_icmpge -185 -> 375
    //   563: iload 4
    //   565: iload 7
    //   567: if_icmpgt -192 -> 375
    //   570: ldc 181
    //   572: ldc_w 481
    //   575: invokestatic 277	com/tencent/mm/audio/mix/h/b:e	(Ljava/lang/String;Ljava/lang/String;)V
    //   578: aload 11
    //   580: monitorenter
    //   581: iload 4
    //   583: istore_2
    //   584: iload_2
    //   585: iload 5
    //   587: if_icmple +35 -> 622
    //   590: aload 13
    //   592: iload_2
    //   593: invokevirtual 485	com/tencent/mm/audio/mix/a/d:kr	(I)Lcom/tencent/mm/audio/mix/a/e;
    //   596: astore 14
    //   598: aload 14
    //   600: ifnull +83 -> 683
    //   603: aload 12
    //   605: aload 12
    //   607: invokeinterface 299 1 0
    //   612: aload 14
    //   614: invokeinterface 298 3 0
    //   619: goto +64 -> 683
    //   622: aload 11
    //   624: monitorexit
    //   625: goto -250 -> 375
    //   628: astore_1
    //   629: aload 11
    //   631: monitorexit
    //   632: ldc_w 430
    //   635: invokestatic 135	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   638: aload_1
    //   639: athrow
    //   640: ldc 181
    //   642: ldc_w 487
    //   645: invokestatic 277	com/tencent/mm/audio/mix/h/b:e	(Ljava/lang/String;Ljava/lang/String;)V
    //   648: goto -228 -> 420
    //   651: astore_1
    //   652: aload 11
    //   654: monitorexit
    //   655: ldc_w 430
    //   658: invokestatic 135	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   661: aload_1
    //   662: athrow
    //   663: astore 11
    //   665: aload_1
    //   666: monitorexit
    //   667: ldc_w 430
    //   670: invokestatic 135	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   673: aload 11
    //   675: athrow
    //   676: iload_2
    //   677: iconst_1
    //   678: iadd
    //   679: istore_2
    //   680: goto -385 -> 295
    //   683: iload_2
    //   684: iconst_1
    //   685: isub
    //   686: istore_2
    //   687: goto -103 -> 584
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	690	0	this	c
    //   0	690	2	paramInt	int
    //   0	690	3	paramBoolean	boolean
    //   227	355	4	i	int
    //   215	373	5	j	int
    //   189	119	6	k	int
    //   209	359	7	m	int
    //   170	206	8	bool	boolean
    //   49	402	9	l	long
    //   663	11	11	localObject2	Object
    //   75	531	12	localList	List
    //   202	389	13	localObject3	Object
    //   266	347	14	localObject4	Object
    // Exception table:
    //   from	to	target	type
    //   310	331	468	finally
    //   336	352	468	finally
    //   355	358	468	finally
    //   509	524	544	finally
    //   590	598	628	finally
    //   603	619	628	finally
    //   622	625	628	finally
    //   397	420	651	finally
    //   420	423	651	finally
    //   640	648	651	finally
    //   430	436	663	finally
  }
  
  public final void hC(String paramString)
  {
    AppMethodBeat.i(136844);
    if (this.fpb > 0L) {
      this.fpb = 0L;
    }
    for (;;)
    {
      synchronized (this.foV)
      {
        this.foN.set(false);
        this.foO.put(paramString, Boolean.FALSE);
        if (!this.foQ.contains(paramString))
        {
          this.foQ.add(paramString);
          this.foS.put(paramString, new ArrayList());
          this.foR.put(paramString, new Object());
          this.foX.put(paramString, Boolean.FALSE);
          this.foT.put(paramString, Boolean.FALSE);
          this.foY.put(paramString, Boolean.FALSE);
          if (this.fnY.get())
          {
            this.fnY.set(false);
            aed();
            aef();
            AppMethodBeat.o(136844);
          }
        }
        else
        {
          com.tencent.mm.audio.mix.h.b.e("MicroMsg.Mix.AudioMixController", "The audio of the Id is mixing");
        }
      }
      this.foW.size();
    }
  }
  
  public final void hD(String paramString)
  {
    AppMethodBeat.i(136845);
    synchronized (this.foV)
    {
      if (this.foT.containsKey(paramString))
      {
        this.foT.put(paramString, Boolean.TRUE);
        AppMethodBeat.o(136845);
        return;
      }
      com.tencent.mm.audio.mix.h.b.e("MicroMsg.Mix.AudioMixController", "The audio of the id is remove");
    }
  }
  
  public final void hE(String paramString)
  {
    AppMethodBeat.i(136846);
    this.foO.put(paramString, Boolean.TRUE);
    hG(paramString);
    if (this.foQ.isEmpty())
    {
      com.tencent.mm.audio.mix.h.b.i("MicroMsg.Mix.AudioMixController", "stopMix isMute");
      this.foN.set(true);
      this.foM.adS();
      AppMethodBeat.o(136846);
      return;
    }
    this.foN.set(false);
    AppMethodBeat.o(136846);
  }
  
  public final boolean hF(String paramString)
  {
    AppMethodBeat.i(136848);
    synchronized (this.foV)
    {
      if (this.foT.containsKey(paramString))
      {
        boolean bool = ((Boolean)this.foT.get(paramString)).booleanValue();
        AppMethodBeat.o(136848);
        return bool;
      }
      AppMethodBeat.o(136848);
      return false;
    }
  }
  
  public final void hG(String paramString)
  {
    AppMethodBeat.i(136849);
    for (;;)
    {
      List localList;
      synchronized (this.foV)
      {
        if (!this.foQ.contains(paramString)) {
          break label189;
        }
        this.foQ.remove(paramString);
        Object localObject2 = this.foR.get(paramString);
        localList = (List)this.foS.remove(paramString);
        if (localObject2 != null) {
          try
          {
            L(localList);
            localList.clear();
            this.foR.remove(paramString);
            this.foT.remove(paramString);
            this.foX.remove(paramString);
            this.foY.remove(paramString);
            if (this.fnY.get()) {
              aef();
            }
            this.foZ.remove(paramString);
            this.fpa.remove(paramString);
            return;
          }
          finally
          {
            AppMethodBeat.o(136849);
          }
        }
      }
      L(localList);
      localList.clear();
      continue;
      label189:
      com.tencent.mm.audio.mix.h.b.e("MicroMsg.Mix.AudioMixController", "The audio of the id is remove");
    }
  }
  
  public final long hH(String paramString)
  {
    AppMethodBeat.i(136851);
    synchronized (this.foV)
    {
      if (this.fpa.containsKey(paramString))
      {
        paramString = (Long)this.fpa.get(paramString);
        if (paramString == null)
        {
          AppMethodBeat.o(136851);
          return -1L;
        }
        long l = paramString.longValue();
        AppMethodBeat.o(136851);
        return l;
      }
      AppMethodBeat.o(136851);
      return -1L;
    }
  }
  
  public final boolean hJ(String paramString)
  {
    AppMethodBeat.i(136852);
    if (!this.foQ.contains(paramString))
    {
      AppMethodBeat.o(136852);
      return true;
    }
    paramString = (List)this.foS.get(paramString);
    if ((paramString == null) || (paramString.size() == 0))
    {
      com.tencent.mm.audio.mix.h.b.i("MicroMsg.Mix.AudioMixController", "queue size is 0");
      AppMethodBeat.o(136852);
      return true;
    }
    AppMethodBeat.o(136852);
    return false;
  }
  
  public final String hM(String paramString)
  {
    AppMethodBeat.i(136862);
    paramString = (WeakReference)this.foU.get(paramString);
    if ((paramString != null) && (paramString.get() != null))
    {
      paramString = (com.tencent.mm.audio.mix.decode.c)paramString.get();
      if (paramString != null)
      {
        paramString = paramString.fnV;
        AppMethodBeat.o(136862);
        return paramString;
      }
    }
    AppMethodBeat.o(136862);
    return "";
  }
  
  public final void p(String paramString, boolean paramBoolean)
  {
    AppMethodBeat.i(136853);
    synchronized (this.foV)
    {
      this.foX.put(paramString, Boolean.valueOf(paramBoolean));
      AppMethodBeat.o(136853);
      return;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes9.jar
 * Qualified Name:     com.tencent.mm.audio.mix.e.c
 * JD-Core Version:    0.7.0.1
 */