package com.tencent.mm.audio.mix.e;

import android.os.Process;
import com.tencent.e.h;
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
  protected Object cTF;
  volatile LinkedList<String> cTl;
  protected AtomicBoolean cUG;
  protected AtomicBoolean cUH;
  private Runnable cVA;
  public i cVe;
  com.tencent.mm.audio.mix.f.d cVf;
  protected AtomicBoolean cVg;
  protected volatile HashMap<String, Boolean> cVh;
  private volatile LinkedList<String> cVi;
  private volatile HashMap<String, Object> cVj;
  public volatile HashMap<String, List<e>> cVk;
  private volatile HashMap<String, Boolean> cVl;
  public volatile HashMap<String, WeakReference<com.tencent.mm.audio.mix.d.c>> cVm;
  private Object cVn;
  private List<e> cVo;
  private volatile HashMap<String, Boolean> cVp;
  private volatile HashMap<String, Boolean> cVq;
  private volatile HashMap<String, Integer> cVr;
  private volatile HashMap<String, Long> cVs;
  public long cVt;
  private boolean cVu;
  private com.tencent.e.i.d cVv;
  int cVw;
  long cVx;
  private long cVy;
  private long cVz;
  
  public c(com.tencent.mm.audio.mix.f.d paramd)
  {
    AppMethodBeat.i(136837);
    this.cUH = new AtomicBoolean(false);
    this.cUG = new AtomicBoolean(false);
    this.cVg = new AtomicBoolean(false);
    this.cVh = new HashMap();
    this.cTF = new Object();
    this.cVi = new LinkedList();
    this.cVj = new HashMap();
    this.cVk = new HashMap();
    this.cVl = new HashMap();
    this.cVm = new HashMap();
    this.cVn = new Object();
    this.cVo = new ArrayList();
    this.cVp = new HashMap();
    this.cVq = new HashMap();
    this.cVr = new HashMap();
    this.cVs = new HashMap();
    this.cTl = new LinkedList();
    this.cVt = 0L;
    this.cVu = false;
    this.cVw = 0;
    this.cVx = 0L;
    this.cVy = 0L;
    this.cVz = 0L;
    this.cVA = new Runnable()
    {
      public final void run()
      {
        AppMethodBeat.i(136836);
        Process.setThreadPriority(-19);
        List localList;
        com.tencent.mm.audio.mix.a.b localb;
        com.tencent.mm.audio.mix.f.d locald;
        if (c.this.Nc())
        {
          com.tencent.mm.audio.mix.h.b.e("MicroMsg.Mix.AudioMixController", "stop and exit");
          AppMethodBeat.o(136836);
          return;
          System.nanoTime();
          localList = c.this.Nz();
          if (localList.size() > 0)
          {
            long l1 = System.nanoTime();
            localb = c.this.cVe.S(localList);
            long l2 = System.nanoTime();
            ??? = c.this;
            ((c)???).cVw += 1;
            c.this.cVx = (l2 - l1 + c.this.cVx);
            if (localb != null)
            {
              ??? = c.this;
              localb.cTl.addAll(((c)???).cTl);
              ((c)???).cTl.clear();
              locald = ((c)???).cVf;
              if (!locald.cWl.get()) {
                break label219;
              }
              com.tencent.mm.audio.mix.h.b.e("MicroMsg.Mix.AudioMixPlayerImpl", "exit, not to add MixBuff queue");
            }
          }
        }
        for (;;)
        {
          c.R(localList);
          localList.clear();
          if (c.this.Nc()) {
            break label327;
          }
          c.this.Nw();
          if (!c.this.Nc()) {
            break;
          }
          AppMethodBeat.o(136836);
          return;
          label219:
          synchronized (locald.cWn)
          {
            for (;;)
            {
              if (locald.cWm.size() >= 2)
              {
                boolean bool = locald.cWl.get();
                if (!bool) {
                  try
                  {
                    locald.cWn.wait();
                  }
                  catch (InterruptedException localInterruptedException)
                  {
                    com.tencent.mm.audio.mix.h.b.printErrStackTrace("MicroMsg.Mix.AudioMixPlayerImpl", localInterruptedException, "enqueueMixBuffer", new Object[0]);
                  }
                }
              }
            }
          }
          locald.cWm.add(localb);
          locald.cWn.notifyAll();
        }
        label327:
        com.tencent.mm.audio.mix.h.b.i("MicroMsg.Mix.AudioMixController", "mix thread stop and exit");
        AppMethodBeat.o(136836);
      }
    };
    this.cVf = paramd;
    AppMethodBeat.o(136837);
  }
  
  private void NA()
  {
    AppMethodBeat.i(136860);
    int i = 0;
    while (i < this.cVi.size())
    {
      ((List)this.cVk.get(this.cVi.get(i))).clear();
      i += 1;
    }
    AppMethodBeat.o(136860);
  }
  
  private void Nv()
  {
    AppMethodBeat.i(136841);
    synchronized (this.cTF)
    {
      try
      {
        this.cTF.notify();
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
  
  private void Nx()
  {
    AppMethodBeat.i(136843);
    try
    {
      this.cVn.notifyAll();
      AppMethodBeat.o(136843);
      return;
    }
    catch (Exception localException)
    {
      com.tencent.mm.audio.mix.h.b.printErrStackTrace("MicroMsg.Mix.AudioMixController", localException, "notifySyncPcmData", new Object[0]);
      AppMethodBeat.o(136843);
    }
  }
  
  static void R(List<e> paramList)
  {
    AppMethodBeat.i(136863);
    paramList = paramList.iterator();
    while (paramList.hasNext())
    {
      e locale = (e)paramList.next();
      if ((locale != null) && (locale.cTv)) {
        com.tencent.mm.audio.mix.b.c.MJ().b(locale);
      }
    }
    AppMethodBeat.o(136863);
  }
  
  private boolean fq(String paramString)
  {
    AppMethodBeat.i(136854);
    synchronized (this.cVn)
    {
      if ((this.cVp.containsKey(paramString)) && (((Boolean)this.cVp.get(paramString)).booleanValue()))
      {
        AppMethodBeat.o(136854);
        return true;
      }
      AppMethodBeat.o(136854);
      return false;
    }
  }
  
  private void fr(String paramString)
  {
    AppMethodBeat.i(136855);
    this.cVf.o(5, paramString);
    fn(paramString);
    AppMethodBeat.o(136855);
  }
  
  public final void NB()
  {
    AppMethodBeat.i(136861);
    if (this.cVv == null) {
      this.cVv = h.Iye.aS(this.cVA);
    }
    AppMethodBeat.o(136861);
  }
  
  public final void NC()
  {
    if (this.cVv != null) {
      this.cVv = null;
    }
  }
  
  public final boolean Nc()
  {
    AppMethodBeat.i(205843);
    boolean bool = this.cUH.get();
    AppMethodBeat.o(205843);
    return bool;
  }
  
  public final void Ns()
  {
    AppMethodBeat.i(136838);
    com.tencent.mm.audio.mix.h.b.i("MicroMsg.Mix.AudioMixController", "prepareMix");
    this.cUH.set(false);
    this.cUG.set(false);
    NB();
    Nv();
    AppMethodBeat.o(136838);
  }
  
  public final void Nt()
  {
    AppMethodBeat.i(136839);
    com.tencent.mm.audio.mix.h.b.i("MicroMsg.Mix.AudioMixController", "pauseMix");
    this.cUG.set(true);
    if (this.cVw > 0)
    {
      this.cVt = (this.cVx / this.cVw);
      com.tencent.mm.audio.mix.h.b.i("MicroMsg.Mix.AudioMixController", "mixAverageTime:%d", new Object[] { Long.valueOf(this.cVt) });
    }
    this.cVy = 0L;
    this.cVw = 0;
    this.cVx = 0L;
    this.cVz = 0L;
    AppMethodBeat.o(136839);
  }
  
  public final void Nu()
  {
    AppMethodBeat.i(136840);
    com.tencent.mm.audio.mix.h.b.i("MicroMsg.Mix.AudioMixController", "stopMix");
    this.cUH.set(true);
    this.cUG.set(false);
    Nv();
    synchronized (this.cVn)
    {
      Nx();
      NA();
      NC();
      AppMethodBeat.o(136840);
      return;
    }
  }
  
  public final void Nw()
  {
    AppMethodBeat.i(136842);
    synchronized (this.cTF)
    {
      for (;;)
      {
        if (!this.cUH.get())
        {
          boolean bool = this.cUG.get();
          if (bool) {
            try
            {
              com.tencent.mm.audio.mix.h.b.i("MicroMsg.Mix.AudioMixController", "waitMix");
              this.cTF.wait();
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
  
  public final boolean Ny()
  {
    AppMethodBeat.i(136847);
    boolean bool = this.cVg.get();
    AppMethodBeat.o(136847);
    return bool;
  }
  
  protected final List<e> Nz()
  {
    AppMethodBeat.i(136858);
    ArrayList localArrayList = new ArrayList();
    int i;
    synchronized (this.cVn)
    {
      localArrayList.addAll(this.cVi);
      i = 0;
      if (i >= localArrayList.size()) {
        break label414;
      }
      ??? = (String)localArrayList.get(i);
    }
    for (;;)
    {
      synchronized (this.cVn)
      {
        if ((this.cVl.containsKey(???)) && (((Boolean)this.cVl.get(???)).booleanValue()))
        {
          i += 1;
          break;
          localObject1 = finally;
          AppMethodBeat.o(136858);
          throw localObject1;
        }
        ??? = (List)this.cVk.get(???);
        if ((??? == null) || (((List)???).size() == 0))
        {
          if (!fq((String)???)) {
            continue;
          }
          m((String)???, false);
          fr((String)???);
        }
      }
      if (this.cVm.containsKey(???))
      {
        localObject8 = (WeakReference)this.cVm.get(???);
        if ((localObject8 != null) && (((WeakReference)localObject8).get() != null))
        {
          localObject8 = (com.tencent.mm.audio.mix.d.c)((WeakReference)localObject8).get();
          if (localObject8 != null) {
            ((com.tencent.mm.audio.mix.d.c)localObject8).hQ(((List)???).size());
          }
        }
      }
      Object localObject8 = this.cVj.get(???);
      if (localObject8 != null)
      {
        int j;
        try
        {
          j = ((List)???).size();
          if (j <= 0) {
            continue;
          }
        }
        finally
        {
          AppMethodBeat.o(136858);
        }
        ??? = (e)((List)???).remove(j - 1);
        if ((this.cVr.containsKey(???)) && (((Integer)this.cVr.get(???)).intValue() > ((e)???).cTu)) {}
        this.cVs.put(???, Long.valueOf(((e)???).cTu));
        this.cVo.add(???);
        this.cTl.add(???);
      }
    }
    label414:
    synchronized (this.cVn)
    {
      if (this.cVo.size() == 0)
      {
        boolean bool = this.cUH.get();
        if (bool) {}
      }
      try
      {
        com.tencent.mm.audio.mix.h.b.i("MicroMsg.Mix.AudioMixController", "wait read data");
        this.cVn.wait();
        ??? = this.cVo;
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
  
  /* Error */
  public final int a(String paramString, e arg2, com.tencent.mm.audio.mix.d.c paramc)
  {
    // Byte code:
    //   0: ldc_w 360
    //   3: invokestatic 65	com/tencent/matrix/trace/core/AppMethodBeat:i	(I)V
    //   6: aload_2
    //   7: ifnull +17 -> 24
    //   10: aload_1
    //   11: invokestatic 366	android/text/TextUtils:isEmpty	(Ljava/lang/CharSequence;)Z
    //   14: ifne +10 -> 24
    //   17: aload_2
    //   18: getfield 370	com/tencent/mm/audio/mix/a/e:cTk	[B
    //   21: ifnonnull +19 -> 40
    //   24: ldc 163
    //   26: ldc_w 372
    //   29: invokestatic 375	com/tencent/mm/audio/mix/h/b:e	(Ljava/lang/String;Ljava/lang/String;)V
    //   32: ldc_w 360
    //   35: invokestatic 135	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   38: iconst_0
    //   39: ireturn
    //   40: aconst_null
    //   41: astore 6
    //   43: aconst_null
    //   44: astore 5
    //   46: aload_0
    //   47: getfield 92	com/tencent/mm/audio/mix/e/c:cVk	Ljava/util/HashMap;
    //   50: aload_1
    //   51: invokevirtual 219	java/util/HashMap:containsKey	(Ljava/lang/Object;)Z
    //   54: ifne +102 -> 156
    //   57: ldc 163
    //   59: ldc_w 377
    //   62: iconst_1
    //   63: anewarray 4	java/lang/Object
    //   66: dup
    //   67: iconst_0
    //   68: aload_1
    //   69: aastore
    //   70: invokestatic 379	com/tencent/mm/audio/mix/h/b:e	(Ljava/lang/String;Ljava/lang/String;[Ljava/lang/Object;)V
    //   73: aload_0
    //   74: getfield 98	com/tencent/mm/audio/mix/e/c:cVn	Ljava/lang/Object;
    //   77: astore 7
    //   79: aload 7
    //   81: monitorenter
    //   82: aload_0
    //   83: getfield 92	com/tencent/mm/audio/mix/e/c:cVk	Ljava/util/HashMap;
    //   86: aload_1
    //   87: new 100	java/util/ArrayList
    //   90: dup
    //   91: invokespecial 101	java/util/ArrayList:<init>	()V
    //   94: invokevirtual 348	java/util/HashMap:put	(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;
    //   97: pop
    //   98: aload_0
    //   99: getfield 88	com/tencent/mm/audio/mix/e/c:cVi	Ljava/util/LinkedList;
    //   102: aload_1
    //   103: invokevirtual 382	java/util/LinkedList:contains	(Ljava/lang/Object;)Z
    //   106: ifne +12 -> 118
    //   109: aload_0
    //   110: getfield 88	com/tencent/mm/audio/mix/e/c:cVi	Ljava/util/LinkedList;
    //   113: aload_1
    //   114: invokevirtual 352	java/util/LinkedList:add	(Ljava/lang/Object;)Z
    //   117: pop
    //   118: aload 5
    //   120: astore 6
    //   122: aload_0
    //   123: getfield 90	com/tencent/mm/audio/mix/e/c:cVj	Ljava/util/HashMap;
    //   126: aload_1
    //   127: invokevirtual 219	java/util/HashMap:containsKey	(Ljava/lang/Object;)Z
    //   130: ifne +23 -> 153
    //   133: new 4	java/lang/Object
    //   136: dup
    //   137: invokespecial 58	java/lang/Object:<init>	()V
    //   140: astore 6
    //   142: aload_0
    //   143: getfield 90	com/tencent/mm/audio/mix/e/c:cVj	Ljava/util/HashMap;
    //   146: aload_1
    //   147: aload 6
    //   149: invokevirtual 348	java/util/HashMap:put	(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;
    //   152: pop
    //   153: aload 7
    //   155: monitorexit
    //   156: aload 6
    //   158: astore 5
    //   160: aload 6
    //   162: ifnonnull +57 -> 219
    //   165: aload_0
    //   166: getfield 90	com/tencent/mm/audio/mix/e/c:cVj	Ljava/util/HashMap;
    //   169: aload_1
    //   170: invokevirtual 219	java/util/HashMap:containsKey	(Ljava/lang/Object;)Z
    //   173: ifne +155 -> 328
    //   176: aload_0
    //   177: getfield 98	com/tencent/mm/audio/mix/e/c:cVn	Ljava/lang/Object;
    //   180: astore 6
    //   182: aload 6
    //   184: monitorenter
    //   185: aload_0
    //   186: getfield 90	com/tencent/mm/audio/mix/e/c:cVj	Ljava/util/HashMap;
    //   189: aload_1
    //   190: invokevirtual 219	java/util/HashMap:containsKey	(Ljava/lang/Object;)Z
    //   193: ifne +110 -> 303
    //   196: new 4	java/lang/Object
    //   199: dup
    //   200: invokespecial 58	java/lang/Object:<init>	()V
    //   203: astore 5
    //   205: aload_0
    //   206: getfield 90	com/tencent/mm/audio/mix/e/c:cVj	Ljava/util/HashMap;
    //   209: aload_1
    //   210: aload 5
    //   212: invokevirtual 348	java/util/HashMap:put	(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;
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
    //   234: getfield 96	com/tencent/mm/audio/mix/e/c:cVm	Ljava/util/HashMap;
    //   237: aload_1
    //   238: invokevirtual 219	java/util/HashMap:containsKey	(Ljava/lang/Object;)Z
    //   241: ifne +20 -> 261
    //   244: aload_0
    //   245: getfield 96	com/tencent/mm/audio/mix/e/c:cVm	Ljava/util/HashMap;
    //   248: aload_1
    //   249: new 326	java/lang/ref/WeakReference
    //   252: dup
    //   253: aload_3
    //   254: invokespecial 385	java/lang/ref/WeakReference:<init>	(Ljava/lang/Object;)V
    //   257: invokevirtual 348	java/util/HashMap:put	(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;
    //   260: pop
    //   261: aload_0
    //   262: getfield 92	com/tencent/mm/audio/mix/e/c:cVk	Ljava/util/HashMap;
    //   265: aload_1
    //   266: invokevirtual 149	java/util/HashMap:get	(Ljava/lang/Object;)Ljava/lang/Object;
    //   269: checkcast 151	java/util/List
    //   272: astore_1
    //   273: aload 5
    //   275: monitorenter
    //   276: aload_1
    //   277: ifnonnull +64 -> 341
    //   280: aload 5
    //   282: monitorexit
    //   283: ldc_w 360
    //   286: invokestatic 135	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   289: iconst_0
    //   290: ireturn
    //   291: astore_1
    //   292: aload 7
    //   294: monitorexit
    //   295: ldc_w 360
    //   298: invokestatic 135	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   301: aload_1
    //   302: athrow
    //   303: aload_0
    //   304: getfield 90	com/tencent/mm/audio/mix/e/c:cVj	Ljava/util/HashMap;
    //   307: aload_1
    //   308: invokevirtual 149	java/util/HashMap:get	(Ljava/lang/Object;)Ljava/lang/Object;
    //   311: astore 5
    //   313: goto -97 -> 216
    //   316: astore_1
    //   317: aload 6
    //   319: monitorexit
    //   320: ldc_w 360
    //   323: invokestatic 135	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   326: aload_1
    //   327: athrow
    //   328: aload_0
    //   329: getfield 90	com/tencent/mm/audio/mix/e/c:cVj	Ljava/util/HashMap;
    //   332: aload_1
    //   333: invokevirtual 149	java/util/HashMap:get	(Ljava/lang/Object;)Ljava/lang/Object;
    //   336: astore 5
    //   338: goto -119 -> 219
    //   341: aload_1
    //   342: iconst_0
    //   343: aload_2
    //   344: invokeinterface 388 3 0
    //   349: aload 5
    //   351: monitorexit
    //   352: aload_0
    //   353: getfield 98	com/tencent/mm/audio/mix/e/c:cVn	Ljava/lang/Object;
    //   356: astore_2
    //   357: aload_2
    //   358: monitorenter
    //   359: aload_0
    //   360: getfield 98	com/tencent/mm/audio/mix/e/c:cVn	Ljava/lang/Object;
    //   363: invokevirtual 176	java/lang/Object:notifyAll	()V
    //   366: aload_2
    //   367: monitorexit
    //   368: aload_1
    //   369: invokeinterface 316 1 0
    //   374: istore 4
    //   376: ldc_w 360
    //   379: invokestatic 135	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   382: iload 4
    //   384: ireturn
    //   385: astore_1
    //   386: aload 5
    //   388: monitorexit
    //   389: ldc_w 360
    //   392: invokestatic 135	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   395: aload_1
    //   396: athrow
    //   397: astore_3
    //   398: ldc 163
    //   400: aload_3
    //   401: ldc_w 390
    //   404: iconst_0
    //   405: anewarray 4	java/lang/Object
    //   408: invokestatic 171	com/tencent/mm/audio/mix/h/b:printErrStackTrace	(Ljava/lang/String;Ljava/lang/Throwable;Ljava/lang/String;[Ljava/lang/Object;)V
    //   411: goto -45 -> 366
    //   414: astore_1
    //   415: aload_2
    //   416: monitorexit
    //   417: ldc_w 360
    //   420: invokestatic 135	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   423: aload_1
    //   424: athrow
    //   425: goto -192 -> 233
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	428	0	this	c
    //   0	428	1	paramString	String
    //   0	428	3	paramc	com.tencent.mm.audio.mix.d.c
    //   374	9	4	i	int
    //   44	343	5	localObject1	Object
    //   41	277	6	localObject2	Object
    //   77	216	7	localObject3	Object
    // Exception table:
    //   from	to	target	type
    //   82	118	291	finally
    //   122	153	291	finally
    //   153	156	291	finally
    //   292	295	291	finally
    //   185	216	316	finally
    //   216	219	316	finally
    //   303	313	316	finally
    //   317	320	316	finally
    //   280	283	385	finally
    //   341	352	385	finally
    //   386	389	385	finally
    //   359	366	397	java/lang/Exception
    //   359	366	414	finally
    //   366	368	414	finally
    //   398	411	414	finally
    //   415	417	414	finally
  }
  
  public final void clearCache()
  {
    AppMethodBeat.i(136859);
    com.tencent.mm.audio.mix.h.b.i("MicroMsg.Mix.AudioMixController", "clearCache");
    synchronized (this.cVn)
    {
      NA();
      this.cVj.clear();
      AppMethodBeat.o(136859);
      return;
    }
  }
  
  public final void fj(String paramString)
  {
    AppMethodBeat.i(136844);
    if (this.cVt > 0L) {
      this.cVt = 0L;
    }
    for (;;)
    {
      synchronized (this.cVn)
      {
        this.cVg.set(false);
        this.cVh.put(paramString, Boolean.FALSE);
        if (!this.cVi.contains(paramString))
        {
          this.cVi.add(paramString);
          this.cVk.put(paramString, new ArrayList());
          this.cVj.put(paramString, new Object());
          this.cVp.put(paramString, Boolean.FALSE);
          this.cVl.put(paramString, Boolean.FALSE);
          this.cVq.put(paramString, Boolean.FALSE);
          if (this.cUG.get())
          {
            this.cUG.set(false);
            Nv();
            Nx();
            AppMethodBeat.o(136844);
          }
        }
        else
        {
          com.tencent.mm.audio.mix.h.b.e("MicroMsg.Mix.AudioMixController", "The audio of the Id is mixing");
        }
      }
      this.cVo.size();
    }
  }
  
  public final void fk(String paramString)
  {
    AppMethodBeat.i(136845);
    synchronized (this.cVn)
    {
      if (this.cVl.containsKey(paramString))
      {
        this.cVl.put(paramString, Boolean.TRUE);
        AppMethodBeat.o(136845);
        return;
      }
      com.tencent.mm.audio.mix.h.b.e("MicroMsg.Mix.AudioMixController", "The audio of the id is remove");
    }
  }
  
  public final void fl(String paramString)
  {
    AppMethodBeat.i(136846);
    this.cVh.put(paramString, Boolean.TRUE);
    fn(paramString);
    if (this.cVi.isEmpty())
    {
      com.tencent.mm.audio.mix.h.b.i("MicroMsg.Mix.AudioMixController", "stopMix isMute");
      this.cVg.set(true);
      this.cVf.Nm();
      AppMethodBeat.o(136846);
      return;
    }
    this.cVg.set(false);
    AppMethodBeat.o(136846);
  }
  
  public final boolean fm(String paramString)
  {
    AppMethodBeat.i(136848);
    synchronized (this.cVn)
    {
      if (this.cVl.containsKey(paramString))
      {
        boolean bool = ((Boolean)this.cVl.get(paramString)).booleanValue();
        AppMethodBeat.o(136848);
        return bool;
      }
      AppMethodBeat.o(136848);
      return false;
    }
  }
  
  public final void fn(String paramString)
  {
    AppMethodBeat.i(136849);
    for (;;)
    {
      List localList;
      synchronized (this.cVn)
      {
        if (!this.cVi.contains(paramString)) {
          break label189;
        }
        this.cVi.remove(paramString);
        Object localObject2 = this.cVj.get(paramString);
        localList = (List)this.cVk.remove(paramString);
        if (localObject2 != null) {
          try
          {
            R(localList);
            localList.clear();
            this.cVj.remove(paramString);
            this.cVl.remove(paramString);
            this.cVp.remove(paramString);
            this.cVq.remove(paramString);
            if (this.cUG.get()) {
              Nx();
            }
            this.cVr.remove(paramString);
            this.cVs.remove(paramString);
            return;
          }
          finally
          {
            AppMethodBeat.o(136849);
          }
        }
      }
      R(localList);
      localList.clear();
      continue;
      label189:
      com.tencent.mm.audio.mix.h.b.e("MicroMsg.Mix.AudioMixController", "The audio of the id is remove");
    }
  }
  
  public final long fo(String paramString)
  {
    AppMethodBeat.i(136851);
    synchronized (this.cVn)
    {
      if (this.cVs.containsKey(paramString))
      {
        paramString = (Long)this.cVs.get(paramString);
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
  
  public final boolean fp(String paramString)
  {
    AppMethodBeat.i(136852);
    if (!this.cVi.contains(paramString))
    {
      AppMethodBeat.o(136852);
      return true;
    }
    paramString = (List)this.cVk.get(paramString);
    if ((paramString == null) || (paramString.size() == 0))
    {
      com.tencent.mm.audio.mix.h.b.i("MicroMsg.Mix.AudioMixController", "queue size is 0");
      AppMethodBeat.o(136852);
      return true;
    }
    AppMethodBeat.o(136852);
    return false;
  }
  
  public final String fs(String paramString)
  {
    AppMethodBeat.i(136862);
    paramString = (WeakReference)this.cVm.get(paramString);
    if ((paramString != null) && (paramString.get() != null))
    {
      paramString = (com.tencent.mm.audio.mix.d.c)paramString.get();
      if (paramString != null)
      {
        paramString = paramString.cUD;
        AppMethodBeat.o(136862);
        return paramString;
      }
    }
    AppMethodBeat.o(136862);
    return "";
  }
  
  public final void m(String paramString, boolean paramBoolean)
  {
    AppMethodBeat.i(136853);
    synchronized (this.cVn)
    {
      this.cVp.put(paramString, Boolean.valueOf(paramBoolean));
      AppMethodBeat.o(136853);
      return;
    }
  }
  
  /* Error */
  public final boolean w(String arg1, int paramInt)
  {
    // Byte code:
    //   0: ldc_w 456
    //   3: invokestatic 65	com/tencent/matrix/trace/core/AppMethodBeat:i	(I)V
    //   6: aload_0
    //   7: getfield 88	com/tencent/mm/audio/mix/e/c:cVi	Ljava/util/LinkedList;
    //   10: aload_1
    //   11: invokevirtual 382	java/util/LinkedList:contains	(Ljava/lang/Object;)Z
    //   14: ifne +11 -> 25
    //   17: ldc_w 456
    //   20: invokestatic 135	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   23: iconst_0
    //   24: ireturn
    //   25: iload_2
    //   26: ifge +20 -> 46
    //   29: aload_0
    //   30: getfield 109	com/tencent/mm/audio/mix/e/c:cVr	Ljava/util/HashMap;
    //   33: aload_1
    //   34: invokevirtual 425	java/util/HashMap:remove	(Ljava/lang/Object;)Ljava/lang/Object;
    //   37: pop
    //   38: ldc_w 456
    //   41: invokestatic 135	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   44: iconst_0
    //   45: ireturn
    //   46: invokestatic 461	java/lang/System:currentTimeMillis	()J
    //   49: lstore 6
    //   51: iload_2
    //   52: ifne +57 -> 109
    //   55: aload_0
    //   56: getfield 109	com/tencent/mm/audio/mix/e/c:cVr	Ljava/util/HashMap;
    //   59: aload_1
    //   60: invokevirtual 425	java/util/HashMap:remove	(Ljava/lang/Object;)Ljava/lang/Object;
    //   63: pop
    //   64: aload_0
    //   65: getfield 92	com/tencent/mm/audio/mix/e/c:cVk	Ljava/util/HashMap;
    //   68: aload_1
    //   69: invokevirtual 149	java/util/HashMap:get	(Ljava/lang/Object;)Ljava/lang/Object;
    //   72: checkcast 151	java/util/List
    //   75: astore 10
    //   77: aload 10
    //   79: ifnull +13 -> 92
    //   82: aload 10
    //   84: invokeinterface 316 1 0
    //   89: ifne +36 -> 125
    //   92: aload_0
    //   93: getfield 109	com/tencent/mm/audio/mix/e/c:cVr	Ljava/util/HashMap;
    //   96: aload_1
    //   97: invokevirtual 425	java/util/HashMap:remove	(Ljava/lang/Object;)Ljava/lang/Object;
    //   100: pop
    //   101: ldc_w 456
    //   104: invokestatic 135	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   107: iconst_0
    //   108: ireturn
    //   109: aload_0
    //   110: getfield 109	com/tencent/mm/audio/mix/e/c:cVr	Ljava/util/HashMap;
    //   113: aload_1
    //   114: iload_2
    //   115: invokestatic 464	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
    //   118: invokevirtual 348	java/util/HashMap:put	(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;
    //   121: pop
    //   122: goto -58 -> 64
    //   125: aload_0
    //   126: getfield 132	com/tencent/mm/audio/mix/e/c:cVf	Lcom/tencent/mm/audio/mix/f/d;
    //   129: aload_1
    //   130: invokevirtual 468	com/tencent/mm/audio/mix/f/d:ft	(Ljava/lang/String;)Lcom/tencent/mm/aj/b;
    //   133: astore 9
    //   135: aload 9
    //   137: ifnonnull +20 -> 157
    //   140: aload_0
    //   141: getfield 109	com/tencent/mm/audio/mix/e/c:cVr	Ljava/util/HashMap;
    //   144: aload_1
    //   145: invokevirtual 425	java/util/HashMap:remove	(Ljava/lang/Object;)Ljava/lang/Object;
    //   148: pop
    //   149: ldc_w 456
    //   152: invokestatic 135	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   155: iconst_0
    //   156: ireturn
    //   157: ldc 163
    //   159: ldc_w 470
    //   162: invokestatic 263	com/tencent/mm/audio/mix/h/b:i	(Ljava/lang/String;Ljava/lang/String;)V
    //   165: aload_0
    //   166: aload_1
    //   167: invokevirtual 472	com/tencent/mm/audio/mix/e/c:fm	(Ljava/lang/String;)Z
    //   170: istore 8
    //   172: iload 8
    //   174: ifne +8 -> 182
    //   177: aload_0
    //   178: aload_1
    //   179: invokevirtual 474	com/tencent/mm/audio/mix/e/c:fk	(Ljava/lang/String;)V
    //   182: aload 10
    //   184: invokeinterface 316 1 0
    //   189: istore_3
    //   190: invokestatic 480	com/tencent/mm/audio/mix/b/e:MN	()Lcom/tencent/mm/audio/mix/b/e;
    //   193: aload 9
    //   195: getfield 485	com/tencent/mm/aj/b:filePath	Ljava/lang/String;
    //   198: invokevirtual 489	com/tencent/mm/audio/mix/b/e:eY	(Ljava/lang/String;)Lcom/tencent/mm/audio/mix/a/d;
    //   201: astore 11
    //   203: aload 11
    //   205: invokevirtual 492	com/tencent/mm/audio/mix/a/d:size	()I
    //   208: istore 5
    //   210: iload_2
    //   211: bipush 20
    //   213: idiv
    //   214: istore 4
    //   216: aload_0
    //   217: aload_1
    //   218: invokevirtual 494	com/tencent/mm/audio/mix/e/c:fo	(Ljava/lang/String;)J
    //   221: ldc2_w 495
    //   224: ldiv
    //   225: l2i
    //   226: istore_2
    //   227: aload_0
    //   228: getfield 90	com/tencent/mm/audio/mix/e/c:cVj	Ljava/util/HashMap;
    //   231: aload_1
    //   232: invokevirtual 149	java/util/HashMap:get	(Ljava/lang/Object;)Ljava/lang/Object;
    //   235: astore 9
    //   237: aload 9
    //   239: ifnonnull +20 -> 259
    //   242: aload_0
    //   243: getfield 109	com/tencent/mm/audio/mix/e/c:cVr	Ljava/util/HashMap;
    //   246: aload_1
    //   247: invokevirtual 425	java/util/HashMap:remove	(Ljava/lang/Object;)Ljava/lang/Object;
    //   250: pop
    //   251: ldc_w 456
    //   254: invokestatic 135	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   257: iconst_0
    //   258: ireturn
    //   259: iload 4
    //   261: iload_2
    //   262: if_icmple +165 -> 427
    //   265: iload 4
    //   267: iload 5
    //   269: if_icmpgt +158 -> 427
    //   272: ldc 163
    //   274: ldc_w 498
    //   277: invokestatic 375	com/tencent/mm/audio/mix/h/b:e	(Ljava/lang/String;Ljava/lang/String;)V
    //   280: iload 4
    //   282: iload_2
    //   283: isub
    //   284: istore 4
    //   286: aload 9
    //   288: monitorenter
    //   289: iconst_0
    //   290: istore_2
    //   291: iload_2
    //   292: iload 4
    //   294: if_icmpge +33 -> 327
    //   297: iload 4
    //   299: iload_3
    //   300: if_icmpgt +27 -> 327
    //   303: aload 10
    //   305: aload 10
    //   307: invokeinterface 316 1 0
    //   312: iconst_1
    //   313: isub
    //   314: invokeinterface 336 2 0
    //   319: pop
    //   320: iload_2
    //   321: iconst_1
    //   322: iadd
    //   323: istore_2
    //   324: goto -33 -> 291
    //   327: aload 9
    //   329: monitorexit
    //   330: iload 8
    //   332: ifne +51 -> 383
    //   335: aload_0
    //   336: getfield 98	com/tencent/mm/audio/mix/e/c:cVn	Ljava/lang/Object;
    //   339: astore 9
    //   341: aload 9
    //   343: monitorenter
    //   344: aload_0
    //   345: getfield 94	com/tencent/mm/audio/mix/e/c:cVl	Ljava/util/HashMap;
    //   348: aload_1
    //   349: invokevirtual 219	java/util/HashMap:containsKey	(Ljava/lang/Object;)Z
    //   352: ifeq +154 -> 506
    //   355: aload_0
    //   356: getfield 94	com/tencent/mm/audio/mix/e/c:cVl	Ljava/util/HashMap;
    //   359: aload_1
    //   360: getstatic 400	java/lang/Boolean:FALSE	Ljava/lang/Boolean;
    //   363: invokevirtual 348	java/util/HashMap:put	(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;
    //   366: pop
    //   367: aload 9
    //   369: monitorexit
    //   370: aload_0
    //   371: getfield 98	com/tencent/mm/audio/mix/e/c:cVn	Ljava/lang/Object;
    //   374: astore_1
    //   375: aload_1
    //   376: monitorenter
    //   377: aload_0
    //   378: invokespecial 291	com/tencent/mm/audio/mix/e/c:Nx	()V
    //   381: aload_1
    //   382: monitorexit
    //   383: ldc 163
    //   385: ldc_w 500
    //   388: iconst_1
    //   389: anewarray 4	java/lang/Object
    //   392: dup
    //   393: iconst_0
    //   394: invokestatic 461	java/lang/System:currentTimeMillis	()J
    //   397: lload 6
    //   399: lsub
    //   400: invokestatic 282	java/lang/Long:valueOf	(J)Ljava/lang/Long;
    //   403: aastore
    //   404: invokestatic 285	com/tencent/mm/audio/mix/h/b:i	(Ljava/lang/String;Ljava/lang/String;[Ljava/lang/Object;)V
    //   407: ldc_w 456
    //   410: invokestatic 135	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   413: iconst_1
    //   414: ireturn
    //   415: astore_1
    //   416: aload 9
    //   418: monitorexit
    //   419: ldc_w 456
    //   422: invokestatic 135	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   425: aload_1
    //   426: athrow
    //   427: iload 4
    //   429: iload_2
    //   430: if_icmpge -100 -> 330
    //   433: iload_2
    //   434: iload 5
    //   436: if_icmpgt -106 -> 330
    //   439: ldc 163
    //   441: ldc_w 502
    //   444: invokestatic 375	com/tencent/mm/audio/mix/h/b:e	(Ljava/lang/String;Ljava/lang/String;)V
    //   447: aload 9
    //   449: monitorenter
    //   450: iload_2
    //   451: iload 4
    //   453: if_icmple +35 -> 488
    //   456: aload 11
    //   458: iload_2
    //   459: invokevirtual 506	com/tencent/mm/audio/mix/a/d:hO	(I)Lcom/tencent/mm/audio/mix/a/e;
    //   462: astore 12
    //   464: aload 12
    //   466: ifnull +76 -> 542
    //   469: aload 10
    //   471: aload 10
    //   473: invokeinterface 316 1 0
    //   478: aload 12
    //   480: invokeinterface 388 3 0
    //   485: goto +57 -> 542
    //   488: aload 9
    //   490: monitorexit
    //   491: goto -161 -> 330
    //   494: astore_1
    //   495: aload 9
    //   497: monitorexit
    //   498: ldc_w 456
    //   501: invokestatic 135	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   504: aload_1
    //   505: athrow
    //   506: ldc 163
    //   508: ldc_w 409
    //   511: invokestatic 375	com/tencent/mm/audio/mix/h/b:e	(Ljava/lang/String;Ljava/lang/String;)V
    //   514: goto -147 -> 367
    //   517: astore_1
    //   518: aload 9
    //   520: monitorexit
    //   521: ldc_w 456
    //   524: invokestatic 135	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   527: aload_1
    //   528: athrow
    //   529: astore 9
    //   531: aload_1
    //   532: monitorexit
    //   533: ldc_w 456
    //   536: invokestatic 135	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   539: aload 9
    //   541: athrow
    //   542: iload_2
    //   543: iconst_1
    //   544: isub
    //   545: istore_2
    //   546: goto -96 -> 450
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	549	0	this	c
    //   0	549	2	paramInt	int
    //   189	112	3	i	int
    //   214	240	4	j	int
    //   208	229	5	k	int
    //   49	349	6	l	long
    //   170	161	8	bool	boolean
    //   529	11	9	localObject2	Object
    //   75	397	10	localList	List
    //   201	256	11	locald	com.tencent.mm.audio.mix.a.d
    //   462	17	12	locale	e
    // Exception table:
    //   from	to	target	type
    //   303	320	415	finally
    //   327	330	415	finally
    //   416	419	415	finally
    //   456	464	494	finally
    //   469	485	494	finally
    //   488	491	494	finally
    //   495	498	494	finally
    //   344	367	517	finally
    //   367	370	517	finally
    //   506	514	517	finally
    //   518	521	517	finally
    //   377	383	529	finally
    //   531	533	529	finally
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.audio.mix.e.c
 * JD-Core Version:    0.7.0.1
 */