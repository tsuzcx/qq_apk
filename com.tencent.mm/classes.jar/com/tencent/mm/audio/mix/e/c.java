package com.tencent.mm.audio.mix.e;

import com.tencent.matrix.trace.core.AppMethodBeat;
import java.lang.ref.WeakReference;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import java.util.concurrent.atomic.AtomicBoolean;

public final class c
{
  protected Object ceG;
  volatile LinkedList<String> cen;
  protected AtomicBoolean cfJ;
  protected AtomicBoolean cfK;
  long cgA;
  private long cgB;
  private long cgC;
  private Runnable cgD;
  public i cgg;
  com.tencent.mm.audio.mix.f.d cgh;
  protected AtomicBoolean cgj;
  protected volatile HashMap<String, Boolean> cgk;
  private Thread cgl;
  private volatile LinkedList<String> cgm;
  private volatile HashMap<String, Object> cgn;
  public volatile HashMap<String, List<com.tencent.mm.audio.mix.a.d>> cgo;
  private volatile HashMap<String, Boolean> cgp;
  public volatile HashMap<String, WeakReference<com.tencent.mm.audio.mix.d.c>> cgq;
  private Object cgr;
  private List<com.tencent.mm.audio.mix.a.d> cgs;
  private volatile HashMap<String, Boolean> cgt;
  private volatile HashMap<String, Boolean> cgu;
  private volatile HashMap<String, Integer> cgv;
  private volatile HashMap<String, Long> cgw;
  public long cgx;
  private boolean cgy;
  int cgz;
  
  public c(com.tencent.mm.audio.mix.f.d paramd)
  {
    AppMethodBeat.i(137088);
    this.cfK = new AtomicBoolean(false);
    this.cfJ = new AtomicBoolean(false);
    this.cgj = new AtomicBoolean(false);
    this.cgk = new HashMap();
    this.ceG = new Object();
    this.cgm = new LinkedList();
    this.cgn = new HashMap();
    this.cgo = new HashMap();
    this.cgp = new HashMap();
    this.cgq = new HashMap();
    this.cgr = new Object();
    this.cgs = new ArrayList();
    this.cgt = new HashMap();
    this.cgu = new HashMap();
    this.cgv = new HashMap();
    this.cgw = new HashMap();
    this.cen = new LinkedList();
    this.cgx = 0L;
    this.cgy = false;
    this.cgz = 0;
    this.cgA = 0L;
    this.cgB = 0L;
    this.cgC = 0L;
    this.cgD = new c.1(this);
    this.cgh = paramd;
    AppMethodBeat.o(137088);
  }
  
  private void DM()
  {
    AppMethodBeat.i(137092);
    synchronized (this.ceG)
    {
      try
      {
        this.ceG.notify();
        AppMethodBeat.o(137092);
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
  
  private void DO()
  {
    AppMethodBeat.i(137094);
    try
    {
      this.cgr.notifyAll();
      AppMethodBeat.o(137094);
      return;
    }
    catch (Exception localException)
    {
      com.tencent.mm.audio.mix.h.b.printErrStackTrace("MicroMsg.Mix.AudioMixController", localException, "notifySyncPcmData", new Object[0]);
      AppMethodBeat.o(137094);
    }
  }
  
  private void DR()
  {
    AppMethodBeat.i(137111);
    int i = 0;
    while (i < this.cgm.size())
    {
      ((List)this.cgo.get(this.cgm.get(i))).clear();
      i += 1;
    }
    AppMethodBeat.o(137111);
  }
  
  static void F(List<com.tencent.mm.audio.mix.a.d> paramList)
  {
    AppMethodBeat.i(137114);
    paramList = paramList.iterator();
    while (paramList.hasNext())
    {
      com.tencent.mm.audio.mix.a.d locald = (com.tencent.mm.audio.mix.a.d)paramList.next();
      if ((locald != null) && (locald.cey)) {
        com.tencent.mm.audio.mix.b.b.Da().b(locald);
      }
    }
    AppMethodBeat.o(137114);
  }
  
  private boolean ej(String paramString)
  {
    AppMethodBeat.i(137105);
    synchronized (this.cgr)
    {
      if ((this.cgt.containsKey(paramString)) && (((Boolean)this.cgt.get(paramString)).booleanValue()))
      {
        AppMethodBeat.o(137105);
        return true;
      }
      AppMethodBeat.o(137105);
      return false;
    }
  }
  
  private void ek(String paramString)
  {
    AppMethodBeat.i(137106);
    this.cgh.m(5, paramString);
    eg(paramString);
    AppMethodBeat.o(137106);
  }
  
  public final void DJ()
  {
    AppMethodBeat.i(137089);
    com.tencent.mm.audio.mix.h.b.i("MicroMsg.Mix.AudioMixController", "prepareMix");
    this.cfK.set(false);
    this.cfJ.set(false);
    DS();
    DM();
    AppMethodBeat.o(137089);
  }
  
  public final void DK()
  {
    AppMethodBeat.i(137090);
    com.tencent.mm.audio.mix.h.b.i("MicroMsg.Mix.AudioMixController", "pauseMix");
    this.cfJ.set(true);
    if (this.cgz > 0)
    {
      this.cgx = (this.cgA / this.cgz);
      com.tencent.mm.audio.mix.h.b.i("MicroMsg.Mix.AudioMixController", "mixAverageTime:%d", new Object[] { Long.valueOf(this.cgx) });
    }
    this.cgB = 0L;
    this.cgz = 0;
    this.cgA = 0L;
    this.cgC = 0L;
    AppMethodBeat.o(137090);
  }
  
  public final void DL()
  {
    AppMethodBeat.i(137091);
    com.tencent.mm.audio.mix.h.b.i("MicroMsg.Mix.AudioMixController", "stopMix");
    this.cfK.set(true);
    this.cfJ.set(false);
    DM();
    synchronized (this.cgr)
    {
      DO();
      DR();
      DT();
      AppMethodBeat.o(137091);
      return;
    }
  }
  
  public final void DN()
  {
    AppMethodBeat.i(137093);
    synchronized (this.ceG)
    {
      for (;;)
      {
        if (!this.cfK.get())
        {
          boolean bool = this.cfJ.get();
          if (bool) {
            try
            {
              com.tencent.mm.audio.mix.h.b.i("MicroMsg.Mix.AudioMixController", "waitMix");
              this.ceG.wait();
            }
            catch (Exception localException)
            {
              com.tencent.mm.audio.mix.h.b.printErrStackTrace("MicroMsg.Mix.AudioMixController", localException, "waitMix", new Object[0]);
            }
          }
        }
      }
    }
    AppMethodBeat.o(137093);
  }
  
  public final boolean DP()
  {
    AppMethodBeat.i(137098);
    boolean bool = this.cgj.get();
    AppMethodBeat.o(137098);
    return bool;
  }
  
  protected final List<com.tencent.mm.audio.mix.a.d> DQ()
  {
    AppMethodBeat.i(137109);
    ArrayList localArrayList = new ArrayList();
    int i;
    synchronized (this.cgr)
    {
      localArrayList.addAll(this.cgm);
      i = 0;
      if (i >= localArrayList.size()) {
        break label414;
      }
      ??? = (String)localArrayList.get(i);
    }
    for (;;)
    {
      synchronized (this.cgr)
      {
        if ((this.cgp.containsKey(???)) && (((Boolean)this.cgp.get(???)).booleanValue()))
        {
          i += 1;
          break;
          localObject1 = finally;
          AppMethodBeat.o(137109);
          throw localObject1;
        }
        ??? = (List)this.cgo.get(???);
        if ((??? == null) || (((List)???).size() == 0))
        {
          if (!ej((String)???)) {
            continue;
          }
          m((String)???, false);
          ek((String)???);
        }
      }
      if (this.cgq.containsKey(???))
      {
        localObject8 = (WeakReference)this.cgq.get(???);
        if ((localObject8 != null) && (((WeakReference)localObject8).get() != null))
        {
          localObject8 = (com.tencent.mm.audio.mix.d.c)((WeakReference)localObject8).get();
          if (localObject8 != null) {
            ((com.tencent.mm.audio.mix.d.c)localObject8).gr(((List)???).size());
          }
        }
      }
      Object localObject8 = this.cgn.get(???);
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
          AppMethodBeat.o(137109);
        }
        ??? = (com.tencent.mm.audio.mix.a.d)((List)???).remove(j - 1);
        if ((this.cgv.containsKey(???)) && (((Integer)this.cgv.get(???)).intValue() > ((com.tencent.mm.audio.mix.a.d)???).cex)) {}
        this.cgw.put(???, Long.valueOf(((com.tencent.mm.audio.mix.a.d)???).cex));
        this.cgs.add(???);
        this.cen.add(???);
      }
    }
    label414:
    synchronized (this.cgr)
    {
      if (this.cgs.size() == 0)
      {
        boolean bool = this.cfK.get();
        if (bool) {}
      }
      try
      {
        com.tencent.mm.audio.mix.h.b.i("MicroMsg.Mix.AudioMixController", "wait read data");
        this.cgr.wait();
        ??? = this.cgs;
        AppMethodBeat.o(137109);
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
  
  public final void DS()
  {
    AppMethodBeat.i(137112);
    if (this.cgl == null)
    {
      this.cgl = new Thread(this.cgD, "audio_mix_controller");
      this.cgl.start();
    }
    AppMethodBeat.o(137112);
  }
  
  public final void DT()
  {
    if (this.cgl != null) {
      this.cgl = null;
    }
  }
  
  public final boolean Dt()
  {
    AppMethodBeat.i(156865);
    boolean bool = this.cfK.get();
    AppMethodBeat.o(156865);
    return bool;
  }
  
  /* Error */
  public final int a(String paramString, com.tencent.mm.audio.mix.a.d arg2, com.tencent.mm.audio.mix.d.c paramc)
  {
    // Byte code:
    //   0: ldc_w 358
    //   3: invokestatic 63	com/tencent/matrix/trace/core/AppMethodBeat:i	(I)V
    //   6: aload_2
    //   7: ifnull +17 -> 24
    //   10: aload_1
    //   11: invokestatic 364	android/text/TextUtils:isEmpty	(Ljava/lang/CharSequence;)Z
    //   14: ifne +10 -> 24
    //   17: aload_2
    //   18: getfield 368	com/tencent/mm/audio/mix/a/d:cem	[B
    //   21: ifnonnull +19 -> 40
    //   24: ldc 145
    //   26: ldc_w 370
    //   29: invokestatic 373	com/tencent/mm/audio/mix/h/b:e	(Ljava/lang/String;Ljava/lang/String;)V
    //   32: ldc_w 358
    //   35: invokestatic 135	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   38: iconst_0
    //   39: ireturn
    //   40: aconst_null
    //   41: astore 6
    //   43: aconst_null
    //   44: astore 5
    //   46: aload_0
    //   47: getfield 90	com/tencent/mm/audio/mix/e/c:cgo	Ljava/util/HashMap;
    //   50: aload_1
    //   51: invokevirtual 219	java/util/HashMap:containsKey	(Ljava/lang/Object;)Z
    //   54: ifne +102 -> 156
    //   57: ldc 145
    //   59: ldc_w 375
    //   62: iconst_1
    //   63: anewarray 4	java/lang/Object
    //   66: dup
    //   67: iconst_0
    //   68: aload_1
    //   69: aastore
    //   70: invokestatic 377	com/tencent/mm/audio/mix/h/b:e	(Ljava/lang/String;Ljava/lang/String;[Ljava/lang/Object;)V
    //   73: aload_0
    //   74: getfield 96	com/tencent/mm/audio/mix/e/c:cgr	Ljava/lang/Object;
    //   77: astore 7
    //   79: aload 7
    //   81: monitorenter
    //   82: aload_0
    //   83: getfield 90	com/tencent/mm/audio/mix/e/c:cgo	Ljava/util/HashMap;
    //   86: aload_1
    //   87: new 98	java/util/ArrayList
    //   90: dup
    //   91: invokespecial 99	java/util/ArrayList:<init>	()V
    //   94: invokevirtual 331	java/util/HashMap:put	(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;
    //   97: pop
    //   98: aload_0
    //   99: getfield 86	com/tencent/mm/audio/mix/e/c:cgm	Ljava/util/LinkedList;
    //   102: aload_1
    //   103: invokevirtual 380	java/util/LinkedList:contains	(Ljava/lang/Object;)Z
    //   106: ifne +12 -> 118
    //   109: aload_0
    //   110: getfield 86	com/tencent/mm/audio/mix/e/c:cgm	Ljava/util/LinkedList;
    //   113: aload_1
    //   114: invokevirtual 335	java/util/LinkedList:add	(Ljava/lang/Object;)Z
    //   117: pop
    //   118: aload 5
    //   120: astore 6
    //   122: aload_0
    //   123: getfield 88	com/tencent/mm/audio/mix/e/c:cgn	Ljava/util/HashMap;
    //   126: aload_1
    //   127: invokevirtual 219	java/util/HashMap:containsKey	(Ljava/lang/Object;)Z
    //   130: ifne +23 -> 153
    //   133: new 4	java/lang/Object
    //   136: dup
    //   137: invokespecial 56	java/lang/Object:<init>	()V
    //   140: astore 6
    //   142: aload_0
    //   143: getfield 88	com/tencent/mm/audio/mix/e/c:cgn	Ljava/util/HashMap;
    //   146: aload_1
    //   147: aload 6
    //   149: invokevirtual 331	java/util/HashMap:put	(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;
    //   152: pop
    //   153: aload 7
    //   155: monitorexit
    //   156: aload 6
    //   158: astore 5
    //   160: aload 6
    //   162: ifnonnull +57 -> 219
    //   165: aload_0
    //   166: getfield 88	com/tencent/mm/audio/mix/e/c:cgn	Ljava/util/HashMap;
    //   169: aload_1
    //   170: invokevirtual 219	java/util/HashMap:containsKey	(Ljava/lang/Object;)Z
    //   173: ifne +155 -> 328
    //   176: aload_0
    //   177: getfield 96	com/tencent/mm/audio/mix/e/c:cgr	Ljava/lang/Object;
    //   180: astore 6
    //   182: aload 6
    //   184: monitorenter
    //   185: aload_0
    //   186: getfield 88	com/tencent/mm/audio/mix/e/c:cgn	Ljava/util/HashMap;
    //   189: aload_1
    //   190: invokevirtual 219	java/util/HashMap:containsKey	(Ljava/lang/Object;)Z
    //   193: ifne +110 -> 303
    //   196: new 4	java/lang/Object
    //   199: dup
    //   200: invokespecial 56	java/lang/Object:<init>	()V
    //   203: astore 5
    //   205: aload_0
    //   206: getfield 88	com/tencent/mm/audio/mix/e/c:cgn	Ljava/util/HashMap;
    //   209: aload_1
    //   210: aload 5
    //   212: invokevirtual 331	java/util/HashMap:put	(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;
    //   215: pop
    //   216: aload 6
    //   218: monitorexit
    //   219: aload 5
    //   221: ifnonnull +204 -> 425
    //   224: new 4	java/lang/Object
    //   227: dup
    //   228: invokespecial 56	java/lang/Object:<init>	()V
    //   231: astore 5
    //   233: aload_0
    //   234: getfield 94	com/tencent/mm/audio/mix/e/c:cgq	Ljava/util/HashMap;
    //   237: aload_1
    //   238: invokevirtual 219	java/util/HashMap:containsKey	(Ljava/lang/Object;)Z
    //   241: ifne +20 -> 261
    //   244: aload_0
    //   245: getfield 94	com/tencent/mm/audio/mix/e/c:cgq	Ljava/util/HashMap;
    //   248: aload_1
    //   249: new 309	java/lang/ref/WeakReference
    //   252: dup
    //   253: aload_3
    //   254: invokespecial 383	java/lang/ref/WeakReference:<init>	(Ljava/lang/Object;)V
    //   257: invokevirtual 331	java/util/HashMap:put	(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;
    //   260: pop
    //   261: aload_0
    //   262: getfield 90	com/tencent/mm/audio/mix/e/c:cgo	Ljava/util/HashMap;
    //   265: aload_1
    //   266: invokevirtual 173	java/util/HashMap:get	(Ljava/lang/Object;)Ljava/lang/Object;
    //   269: checkcast 175	java/util/List
    //   272: astore_1
    //   273: aload 5
    //   275: monitorenter
    //   276: aload_1
    //   277: ifnonnull +64 -> 341
    //   280: aload 5
    //   282: monitorexit
    //   283: ldc_w 358
    //   286: invokestatic 135	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   289: iconst_0
    //   290: ireturn
    //   291: astore_1
    //   292: aload 7
    //   294: monitorexit
    //   295: ldc_w 358
    //   298: invokestatic 135	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   301: aload_1
    //   302: athrow
    //   303: aload_0
    //   304: getfield 88	com/tencent/mm/audio/mix/e/c:cgn	Ljava/util/HashMap;
    //   307: aload_1
    //   308: invokevirtual 173	java/util/HashMap:get	(Ljava/lang/Object;)Ljava/lang/Object;
    //   311: astore 5
    //   313: goto -97 -> 216
    //   316: astore_1
    //   317: aload 6
    //   319: monitorexit
    //   320: ldc_w 358
    //   323: invokestatic 135	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   326: aload_1
    //   327: athrow
    //   328: aload_0
    //   329: getfield 88	com/tencent/mm/audio/mix/e/c:cgn	Ljava/util/HashMap;
    //   332: aload_1
    //   333: invokevirtual 173	java/util/HashMap:get	(Ljava/lang/Object;)Ljava/lang/Object;
    //   336: astore 5
    //   338: goto -119 -> 219
    //   341: aload_1
    //   342: iconst_0
    //   343: aload_2
    //   344: invokeinterface 386 3 0
    //   349: aload 5
    //   351: monitorexit
    //   352: aload_0
    //   353: getfield 96	com/tencent/mm/audio/mix/e/c:cgr	Ljava/lang/Object;
    //   356: astore_2
    //   357: aload_2
    //   358: monitorenter
    //   359: aload_0
    //   360: getfield 96	com/tencent/mm/audio/mix/e/c:cgr	Ljava/lang/Object;
    //   363: invokevirtual 158	java/lang/Object:notifyAll	()V
    //   366: aload_2
    //   367: monitorexit
    //   368: aload_1
    //   369: invokeinterface 300 1 0
    //   374: istore 4
    //   376: ldc_w 358
    //   379: invokestatic 135	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   382: iload 4
    //   384: ireturn
    //   385: astore_1
    //   386: aload 5
    //   388: monitorexit
    //   389: ldc_w 358
    //   392: invokestatic 135	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   395: aload_1
    //   396: athrow
    //   397: astore_3
    //   398: ldc 145
    //   400: aload_3
    //   401: ldc_w 388
    //   404: iconst_0
    //   405: anewarray 4	java/lang/Object
    //   408: invokestatic 153	com/tencent/mm/audio/mix/h/b:printErrStackTrace	(Ljava/lang/String;Ljava/lang/Throwable;Ljava/lang/String;[Ljava/lang/Object;)V
    //   411: goto -45 -> 366
    //   414: astore_1
    //   415: aload_2
    //   416: monitorexit
    //   417: ldc_w 358
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
    AppMethodBeat.i(137110);
    com.tencent.mm.audio.mix.h.b.i("MicroMsg.Mix.AudioMixController", "clearCache");
    synchronized (this.cgr)
    {
      DR();
      this.cgn.clear();
      AppMethodBeat.o(137110);
      return;
    }
  }
  
  public final void ec(String paramString)
  {
    AppMethodBeat.i(137095);
    if (this.cgx > 0L) {
      this.cgx = 0L;
    }
    for (;;)
    {
      synchronized (this.cgr)
      {
        this.cgj.set(false);
        this.cgk.put(paramString, Boolean.FALSE);
        if (!this.cgm.contains(paramString))
        {
          this.cgm.add(paramString);
          this.cgo.put(paramString, new ArrayList());
          this.cgn.put(paramString, new Object());
          this.cgt.put(paramString, Boolean.FALSE);
          this.cgp.put(paramString, Boolean.FALSE);
          this.cgu.put(paramString, Boolean.FALSE);
          if (this.cfJ.get())
          {
            this.cfJ.set(false);
            DM();
            DO();
            AppMethodBeat.o(137095);
          }
        }
        else
        {
          com.tencent.mm.audio.mix.h.b.e("MicroMsg.Mix.AudioMixController", "The audio of the Id is mixing");
        }
      }
      this.cgs.size();
    }
  }
  
  public final void ed(String paramString)
  {
    AppMethodBeat.i(137096);
    synchronized (this.cgr)
    {
      if (this.cgp.containsKey(paramString))
      {
        this.cgp.put(paramString, Boolean.TRUE);
        AppMethodBeat.o(137096);
        return;
      }
      com.tencent.mm.audio.mix.h.b.e("MicroMsg.Mix.AudioMixController", "The audio of the id is remove");
    }
  }
  
  public final void ee(String paramString)
  {
    AppMethodBeat.i(137097);
    this.cgk.put(paramString, Boolean.TRUE);
    eg(paramString);
    if (this.cgm.isEmpty())
    {
      com.tencent.mm.audio.mix.h.b.i("MicroMsg.Mix.AudioMixController", "stopMix isMute");
      this.cgj.set(true);
      this.cgh.DD();
      AppMethodBeat.o(137097);
      return;
    }
    this.cgj.set(false);
    AppMethodBeat.o(137097);
  }
  
  public final boolean ef(String paramString)
  {
    AppMethodBeat.i(137099);
    synchronized (this.cgr)
    {
      if (this.cgp.containsKey(paramString))
      {
        boolean bool = ((Boolean)this.cgp.get(paramString)).booleanValue();
        AppMethodBeat.o(137099);
        return bool;
      }
      AppMethodBeat.o(137099);
      return false;
    }
  }
  
  public final void eg(String paramString)
  {
    AppMethodBeat.i(137100);
    for (;;)
    {
      List localList;
      synchronized (this.cgr)
      {
        if (!this.cgm.contains(paramString)) {
          break label189;
        }
        this.cgm.remove(paramString);
        Object localObject2 = this.cgn.get(paramString);
        localList = (List)this.cgo.remove(paramString);
        if (localObject2 != null) {
          try
          {
            F(localList);
            localList.clear();
            this.cgn.remove(paramString);
            this.cgp.remove(paramString);
            this.cgt.remove(paramString);
            this.cgu.remove(paramString);
            if (this.cfJ.get()) {
              DO();
            }
            this.cgv.remove(paramString);
            this.cgw.remove(paramString);
            return;
          }
          finally
          {
            AppMethodBeat.o(137100);
          }
        }
      }
      F(localList);
      localList.clear();
      continue;
      label189:
      com.tencent.mm.audio.mix.h.b.e("MicroMsg.Mix.AudioMixController", "The audio of the id is remove");
    }
  }
  
  public final long eh(String paramString)
  {
    AppMethodBeat.i(137102);
    synchronized (this.cgr)
    {
      if (this.cgw.containsKey(paramString))
      {
        long l = ((Long)this.cgw.get(paramString)).longValue();
        AppMethodBeat.o(137102);
        return l;
      }
      AppMethodBeat.o(137102);
      return 0L;
    }
  }
  
  public final boolean ei(String paramString)
  {
    AppMethodBeat.i(137103);
    if (!this.cgm.contains(paramString))
    {
      AppMethodBeat.o(137103);
      return true;
    }
    paramString = (List)this.cgo.get(paramString);
    if ((paramString == null) || (paramString.size() == 0))
    {
      com.tencent.mm.audio.mix.h.b.i("MicroMsg.Mix.AudioMixController", "queue size is 0");
      AppMethodBeat.o(137103);
      return true;
    }
    AppMethodBeat.o(137103);
    return false;
  }
  
  public final String el(String paramString)
  {
    AppMethodBeat.i(137113);
    paramString = (WeakReference)this.cgq.get(paramString);
    if ((paramString != null) && (paramString.get() != null))
    {
      paramString = (com.tencent.mm.audio.mix.d.c)paramString.get();
      if (paramString != null)
      {
        paramString = paramString.cfG;
        AppMethodBeat.o(137113);
        return paramString;
      }
    }
    AppMethodBeat.o(137113);
    return "";
  }
  
  public final void m(String paramString, boolean paramBoolean)
  {
    AppMethodBeat.i(137104);
    synchronized (this.cgr)
    {
      this.cgt.put(paramString, Boolean.valueOf(paramBoolean));
      AppMethodBeat.o(137104);
      return;
    }
  }
  
  /* Error */
  public final boolean w(String arg1, int paramInt)
  {
    // Byte code:
    //   0: ldc_w 452
    //   3: invokestatic 63	com/tencent/matrix/trace/core/AppMethodBeat:i	(I)V
    //   6: aload_0
    //   7: getfield 86	com/tencent/mm/audio/mix/e/c:cgm	Ljava/util/LinkedList;
    //   10: aload_1
    //   11: invokevirtual 380	java/util/LinkedList:contains	(Ljava/lang/Object;)Z
    //   14: ifne +11 -> 25
    //   17: ldc_w 452
    //   20: invokestatic 135	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   23: iconst_0
    //   24: ireturn
    //   25: iload_2
    //   26: ifge +20 -> 46
    //   29: aload_0
    //   30: getfield 107	com/tencent/mm/audio/mix/e/c:cgv	Ljava/util/HashMap;
    //   33: aload_1
    //   34: invokevirtual 423	java/util/HashMap:remove	(Ljava/lang/Object;)Ljava/lang/Object;
    //   37: pop
    //   38: ldc_w 452
    //   41: invokestatic 135	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   44: iconst_0
    //   45: ireturn
    //   46: invokestatic 457	java/lang/System:currentTimeMillis	()J
    //   49: lstore 6
    //   51: iload_2
    //   52: ifne +57 -> 109
    //   55: aload_0
    //   56: getfield 107	com/tencent/mm/audio/mix/e/c:cgv	Ljava/util/HashMap;
    //   59: aload_1
    //   60: invokevirtual 423	java/util/HashMap:remove	(Ljava/lang/Object;)Ljava/lang/Object;
    //   63: pop
    //   64: aload_0
    //   65: getfield 90	com/tencent/mm/audio/mix/e/c:cgo	Ljava/util/HashMap;
    //   68: aload_1
    //   69: invokevirtual 173	java/util/HashMap:get	(Ljava/lang/Object;)Ljava/lang/Object;
    //   72: checkcast 175	java/util/List
    //   75: astore 10
    //   77: aload 10
    //   79: ifnull +13 -> 92
    //   82: aload 10
    //   84: invokeinterface 300 1 0
    //   89: ifne +36 -> 125
    //   92: aload_0
    //   93: getfield 107	com/tencent/mm/audio/mix/e/c:cgv	Ljava/util/HashMap;
    //   96: aload_1
    //   97: invokevirtual 423	java/util/HashMap:remove	(Ljava/lang/Object;)Ljava/lang/Object;
    //   100: pop
    //   101: ldc_w 452
    //   104: invokestatic 135	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   107: iconst_0
    //   108: ireturn
    //   109: aload_0
    //   110: getfield 107	com/tencent/mm/audio/mix/e/c:cgv	Ljava/util/HashMap;
    //   113: aload_1
    //   114: iload_2
    //   115: invokestatic 460	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
    //   118: invokevirtual 331	java/util/HashMap:put	(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;
    //   121: pop
    //   122: goto -58 -> 64
    //   125: aload_0
    //   126: getfield 132	com/tencent/mm/audio/mix/e/c:cgh	Lcom/tencent/mm/audio/mix/f/d;
    //   129: aload_1
    //   130: invokevirtual 464	com/tencent/mm/audio/mix/f/d:em	(Ljava/lang/String;)Lcom/tencent/mm/ag/b;
    //   133: astore 9
    //   135: aload 9
    //   137: ifnonnull +20 -> 157
    //   140: aload_0
    //   141: getfield 107	com/tencent/mm/audio/mix/e/c:cgv	Ljava/util/HashMap;
    //   144: aload_1
    //   145: invokevirtual 423	java/util/HashMap:remove	(Ljava/lang/Object;)Ljava/lang/Object;
    //   148: pop
    //   149: ldc_w 452
    //   152: invokestatic 135	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   155: iconst_0
    //   156: ireturn
    //   157: ldc 145
    //   159: ldc_w 466
    //   162: invokestatic 243	com/tencent/mm/audio/mix/h/b:i	(Ljava/lang/String;Ljava/lang/String;)V
    //   165: aload_0
    //   166: aload_1
    //   167: invokevirtual 468	com/tencent/mm/audio/mix/e/c:ef	(Ljava/lang/String;)Z
    //   170: istore 8
    //   172: iload 8
    //   174: ifne +8 -> 182
    //   177: aload_0
    //   178: aload_1
    //   179: invokevirtual 470	com/tencent/mm/audio/mix/e/c:ed	(Ljava/lang/String;)V
    //   182: aload 10
    //   184: invokeinterface 300 1 0
    //   189: istore_3
    //   190: invokestatic 476	com/tencent/mm/audio/mix/b/d:De	()Lcom/tencent/mm/audio/mix/b/d;
    //   193: aload 9
    //   195: getfield 481	com/tencent/mm/ag/b:filePath	Ljava/lang/String;
    //   198: invokevirtual 485	com/tencent/mm/audio/mix/b/d:dR	(Ljava/lang/String;)Lcom/tencent/mm/audio/mix/a/c;
    //   201: astore 11
    //   203: aload 11
    //   205: invokevirtual 488	com/tencent/mm/audio/mix/a/c:size	()I
    //   208: istore 5
    //   210: iload_2
    //   211: bipush 20
    //   213: idiv
    //   214: istore 4
    //   216: aload_0
    //   217: aload_1
    //   218: invokevirtual 490	com/tencent/mm/audio/mix/e/c:eh	(Ljava/lang/String;)J
    //   221: ldc2_w 491
    //   224: ldiv
    //   225: l2i
    //   226: istore_2
    //   227: aload_0
    //   228: getfield 88	com/tencent/mm/audio/mix/e/c:cgn	Ljava/util/HashMap;
    //   231: aload_1
    //   232: invokevirtual 173	java/util/HashMap:get	(Ljava/lang/Object;)Ljava/lang/Object;
    //   235: astore 9
    //   237: aload 9
    //   239: ifnonnull +20 -> 259
    //   242: aload_0
    //   243: getfield 107	com/tencent/mm/audio/mix/e/c:cgv	Ljava/util/HashMap;
    //   246: aload_1
    //   247: invokevirtual 423	java/util/HashMap:remove	(Ljava/lang/Object;)Ljava/lang/Object;
    //   250: pop
    //   251: ldc_w 452
    //   254: invokestatic 135	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   257: iconst_0
    //   258: ireturn
    //   259: iload 4
    //   261: iload_2
    //   262: if_icmple +165 -> 427
    //   265: iload 4
    //   267: iload 5
    //   269: if_icmpgt +158 -> 427
    //   272: ldc 145
    //   274: ldc_w 494
    //   277: invokestatic 373	com/tencent/mm/audio/mix/h/b:e	(Ljava/lang/String;Ljava/lang/String;)V
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
    //   307: invokeinterface 300 1 0
    //   312: iconst_1
    //   313: isub
    //   314: invokeinterface 319 2 0
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
    //   336: getfield 96	com/tencent/mm/audio/mix/e/c:cgr	Ljava/lang/Object;
    //   339: astore 9
    //   341: aload 9
    //   343: monitorenter
    //   344: aload_0
    //   345: getfield 92	com/tencent/mm/audio/mix/e/c:cgp	Ljava/util/HashMap;
    //   348: aload_1
    //   349: invokevirtual 219	java/util/HashMap:containsKey	(Ljava/lang/Object;)Z
    //   352: ifeq +154 -> 506
    //   355: aload_0
    //   356: getfield 92	com/tencent/mm/audio/mix/e/c:cgp	Ljava/util/HashMap;
    //   359: aload_1
    //   360: getstatic 398	java/lang/Boolean:FALSE	Ljava/lang/Boolean;
    //   363: invokevirtual 331	java/util/HashMap:put	(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;
    //   366: pop
    //   367: aload 9
    //   369: monitorexit
    //   370: aload_0
    //   371: getfield 96	com/tencent/mm/audio/mix/e/c:cgr	Ljava/lang/Object;
    //   374: astore_1
    //   375: aload_1
    //   376: monitorenter
    //   377: aload_0
    //   378: invokespecial 272	com/tencent/mm/audio/mix/e/c:DO	()V
    //   381: aload_1
    //   382: monitorexit
    //   383: ldc 145
    //   385: ldc_w 496
    //   388: iconst_1
    //   389: anewarray 4	java/lang/Object
    //   392: dup
    //   393: iconst_0
    //   394: invokestatic 457	java/lang/System:currentTimeMillis	()J
    //   397: lload 6
    //   399: lsub
    //   400: invokestatic 263	java/lang/Long:valueOf	(J)Ljava/lang/Long;
    //   403: aastore
    //   404: invokestatic 266	com/tencent/mm/audio/mix/h/b:i	(Ljava/lang/String;Ljava/lang/String;[Ljava/lang/Object;)V
    //   407: ldc_w 452
    //   410: invokestatic 135	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   413: iconst_1
    //   414: ireturn
    //   415: astore_1
    //   416: aload 9
    //   418: monitorexit
    //   419: ldc_w 452
    //   422: invokestatic 135	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   425: aload_1
    //   426: athrow
    //   427: iload 4
    //   429: iload_2
    //   430: if_icmpge -100 -> 330
    //   433: iload_2
    //   434: iload 5
    //   436: if_icmpgt -106 -> 330
    //   439: ldc 145
    //   441: ldc_w 498
    //   444: invokestatic 373	com/tencent/mm/audio/mix/h/b:e	(Ljava/lang/String;Ljava/lang/String;)V
    //   447: aload 9
    //   449: monitorenter
    //   450: iload_2
    //   451: iload 4
    //   453: if_icmple +35 -> 488
    //   456: aload 11
    //   458: iload_2
    //   459: invokevirtual 502	com/tencent/mm/audio/mix/a/c:gp	(I)Lcom/tencent/mm/audio/mix/a/d;
    //   462: astore 12
    //   464: aload 12
    //   466: ifnull +76 -> 542
    //   469: aload 10
    //   471: aload 10
    //   473: invokeinterface 300 1 0
    //   478: aload 12
    //   480: invokeinterface 386 3 0
    //   485: goto +57 -> 542
    //   488: aload 9
    //   490: monitorexit
    //   491: goto -161 -> 330
    //   494: astore_1
    //   495: aload 9
    //   497: monitorexit
    //   498: ldc_w 452
    //   501: invokestatic 135	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   504: aload_1
    //   505: athrow
    //   506: ldc 145
    //   508: ldc_w 407
    //   511: invokestatic 373	com/tencent/mm/audio/mix/h/b:e	(Ljava/lang/String;Ljava/lang/String;)V
    //   514: goto -147 -> 367
    //   517: astore_1
    //   518: aload 9
    //   520: monitorexit
    //   521: ldc_w 452
    //   524: invokestatic 135	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   527: aload_1
    //   528: athrow
    //   529: astore 9
    //   531: aload_1
    //   532: monitorexit
    //   533: ldc_w 452
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
    //   201	256	11	localc	com.tencent.mm.audio.mix.a.c
    //   462	17	12	locald	com.tencent.mm.audio.mix.a.d
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


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.audio.mix.e.c
 * JD-Core Version:    0.7.0.1
 */