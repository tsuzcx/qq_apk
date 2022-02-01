package com.tencent.mm.audio.mix.f;

import android.os.Process;
import com.tencent.f.h;
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
  volatile LinkedList<String> dtR;
  protected Object dup;
  protected AtomicBoolean dvq;
  protected AtomicBoolean dvr;
  public i dwc;
  com.tencent.mm.audio.mix.g.d dwd;
  protected AtomicBoolean dwe;
  protected volatile HashMap<String, Boolean> dwf;
  private volatile LinkedList<String> dwg;
  private volatile HashMap<String, Object> dwh;
  public volatile HashMap<String, List<e>> dwi;
  private volatile HashMap<String, Boolean> dwj;
  public volatile HashMap<String, WeakReference<com.tencent.mm.audio.mix.d.c>> dwk;
  private Object dwl;
  private List<e> dwm;
  private volatile HashMap<String, Boolean> dwn;
  private volatile HashMap<String, Boolean> dwo;
  private volatile HashMap<String, Integer> dwp;
  private volatile HashMap<String, Long> dwq;
  public long dwr;
  private boolean dws;
  private com.tencent.f.i.d dwt;
  int dwu;
  long dwv;
  private long dww;
  private long dwx;
  private Runnable dwy;
  
  public c(com.tencent.mm.audio.mix.g.d paramd)
  {
    AppMethodBeat.i(136837);
    this.dvr = new AtomicBoolean(false);
    this.dvq = new AtomicBoolean(false);
    this.dwe = new AtomicBoolean(false);
    this.dwf = new HashMap();
    this.dup = new Object();
    this.dwg = new LinkedList();
    this.dwh = new HashMap();
    this.dwi = new HashMap();
    this.dwj = new HashMap();
    this.dwk = new HashMap();
    this.dwl = new Object();
    this.dwm = new ArrayList();
    this.dwn = new HashMap();
    this.dwo = new HashMap();
    this.dwp = new HashMap();
    this.dwq = new HashMap();
    this.dtR = new LinkedList();
    this.dwr = 0L;
    this.dws = false;
    this.dwu = 0;
    this.dwv = 0L;
    this.dww = 0L;
    this.dwx = 0L;
    this.dwy = new Runnable()
    {
      public final void run()
      {
        AppMethodBeat.i(136836);
        Process.setThreadPriority(-19);
        List localList;
        com.tencent.mm.audio.mix.a.b localb;
        com.tencent.mm.audio.mix.g.d locald;
        if (c.this.YZ())
        {
          com.tencent.mm.audio.mix.i.b.e("MicroMsg.Mix.AudioMixController", "stop and exit");
          AppMethodBeat.o(136836);
          return;
          System.nanoTime();
          localList = c.this.Zy();
          if (localList.size() > 0)
          {
            long l1 = System.nanoTime();
            localb = c.this.dwc.P(localList);
            long l2 = System.nanoTime();
            ??? = c.this;
            ((c)???).dwu += 1;
            c.this.dwv = (l2 - l1 + c.this.dwv);
            if (localb != null)
            {
              ??? = c.this;
              localb.dtR.addAll(((c)???).dtR);
              ((c)???).dtR.clear();
              locald = ((c)???).dwd;
              if (!locald.dxj.get()) {
                break label219;
              }
              com.tencent.mm.audio.mix.i.b.e("MicroMsg.Mix.AudioMixPlayerImpl", "exit, not to add MixBuff queue");
            }
          }
        }
        for (;;)
        {
          c.O(localList);
          localList.clear();
          if (c.this.YZ()) {
            break label327;
          }
          c.this.Zv();
          if (!c.this.YZ()) {
            break;
          }
          AppMethodBeat.o(136836);
          return;
          label219:
          synchronized (locald.dxl)
          {
            for (;;)
            {
              if (locald.dxk.size() >= 2)
              {
                boolean bool = locald.dxj.get();
                if (!bool) {
                  try
                  {
                    locald.dxl.wait();
                  }
                  catch (InterruptedException localInterruptedException)
                  {
                    com.tencent.mm.audio.mix.i.b.printErrStackTrace("MicroMsg.Mix.AudioMixPlayerImpl", localInterruptedException, "enqueueMixBuffer", new Object[0]);
                  }
                }
              }
            }
          }
          locald.dxk.add(localb);
          locald.dxl.notifyAll();
        }
        label327:
        com.tencent.mm.audio.mix.i.b.i("MicroMsg.Mix.AudioMixController", "mix thread stop and exit");
        AppMethodBeat.o(136836);
      }
    };
    this.dwd = paramd;
    AppMethodBeat.o(136837);
  }
  
  static void O(List<e> paramList)
  {
    AppMethodBeat.i(136863);
    paramList = paramList.iterator();
    while (paramList.hasNext())
    {
      e locale = (e)paramList.next();
      if ((locale != null) && (locale.dub)) {
        com.tencent.mm.audio.mix.b.d.YH().b(locale);
      }
    }
    AppMethodBeat.o(136863);
  }
  
  private void Zu()
  {
    AppMethodBeat.i(136841);
    synchronized (this.dup)
    {
      try
      {
        this.dup.notify();
        AppMethodBeat.o(136841);
        return;
      }
      catch (Exception localException)
      {
        for (;;)
        {
          com.tencent.mm.audio.mix.i.b.printErrStackTrace("MicroMsg.Mix.AudioMixController", localException, "notifyMix", new Object[0]);
        }
      }
    }
  }
  
  private void Zw()
  {
    AppMethodBeat.i(136843);
    try
    {
      this.dwl.notifyAll();
      AppMethodBeat.o(136843);
      return;
    }
    catch (Exception localException)
    {
      com.tencent.mm.audio.mix.i.b.printErrStackTrace("MicroMsg.Mix.AudioMixController", localException, "notifySyncPcmData", new Object[0]);
      AppMethodBeat.o(136843);
    }
  }
  
  private void Zz()
  {
    AppMethodBeat.i(136860);
    int i = 0;
    while (i < this.dwg.size())
    {
      ((List)this.dwi.get(this.dwg.get(i))).clear();
      i += 1;
    }
    AppMethodBeat.o(136860);
  }
  
  private boolean gX(String paramString)
  {
    AppMethodBeat.i(136854);
    synchronized (this.dwl)
    {
      if ((this.dwn.containsKey(paramString)) && (((Boolean)this.dwn.get(paramString)).booleanValue()))
      {
        AppMethodBeat.o(136854);
        return true;
      }
      AppMethodBeat.o(136854);
      return false;
    }
  }
  
  private void gY(String paramString)
  {
    AppMethodBeat.i(136855);
    this.dwd.q(5, paramString);
    gU(paramString);
    AppMethodBeat.o(136855);
  }
  
  public final boolean YY()
  {
    AppMethodBeat.i(258229);
    boolean bool = this.dvq.get();
    AppMethodBeat.o(258229);
    return bool;
  }
  
  public final boolean YZ()
  {
    AppMethodBeat.i(258230);
    boolean bool = this.dvr.get();
    AppMethodBeat.o(258230);
    return bool;
  }
  
  public final void ZA()
  {
    AppMethodBeat.i(136861);
    if (this.dwt == null) {
      this.dwt = h.RTc.ba(this.dwy);
    }
    AppMethodBeat.o(136861);
  }
  
  public final void ZB()
  {
    if (this.dwt != null) {
      this.dwt = null;
    }
  }
  
  public final void Zr()
  {
    AppMethodBeat.i(136838);
    com.tencent.mm.audio.mix.i.b.i("MicroMsg.Mix.AudioMixController", "prepareMix");
    this.dvr.set(false);
    this.dvq.set(false);
    ZA();
    Zu();
    AppMethodBeat.o(136838);
  }
  
  public final void Zs()
  {
    AppMethodBeat.i(136839);
    com.tencent.mm.audio.mix.i.b.i("MicroMsg.Mix.AudioMixController", "pauseMix");
    this.dvq.set(true);
    if (this.dwu > 0)
    {
      this.dwr = (this.dwv / this.dwu);
      com.tencent.mm.audio.mix.i.b.i("MicroMsg.Mix.AudioMixController", "mixAverageTime:%d", new Object[] { Long.valueOf(this.dwr) });
    }
    this.dww = 0L;
    this.dwu = 0;
    this.dwv = 0L;
    this.dwx = 0L;
    AppMethodBeat.o(136839);
  }
  
  public final void Zt()
  {
    AppMethodBeat.i(136840);
    com.tencent.mm.audio.mix.i.b.i("MicroMsg.Mix.AudioMixController", "stopMix");
    this.dvr.set(true);
    this.dvq.set(false);
    Zu();
    synchronized (this.dwl)
    {
      Zw();
      Zz();
      ZB();
      AppMethodBeat.o(136840);
      return;
    }
  }
  
  public final void Zv()
  {
    AppMethodBeat.i(136842);
    synchronized (this.dup)
    {
      for (;;)
      {
        if (!this.dvr.get())
        {
          boolean bool = this.dvq.get();
          if (bool) {
            try
            {
              com.tencent.mm.audio.mix.i.b.i("MicroMsg.Mix.AudioMixController", "waitMix");
              this.dup.wait();
            }
            catch (Exception localException)
            {
              com.tencent.mm.audio.mix.i.b.printErrStackTrace("MicroMsg.Mix.AudioMixController", localException, "waitMix", new Object[0]);
            }
          }
        }
      }
    }
    AppMethodBeat.o(136842);
  }
  
  public final boolean Zx()
  {
    AppMethodBeat.i(136847);
    boolean bool = this.dwe.get();
    AppMethodBeat.o(136847);
    return bool;
  }
  
  protected final List<e> Zy()
  {
    AppMethodBeat.i(136858);
    ArrayList localArrayList = new ArrayList();
    int i;
    synchronized (this.dwl)
    {
      localArrayList.addAll(this.dwg);
      i = 0;
      if (i >= localArrayList.size()) {
        break label557;
      }
      ??? = (String)localArrayList.get(i);
    }
    Object localObject8;
    for (;;)
    {
      synchronized (this.dwl)
      {
        if ((this.dwj.containsKey(???)) && (((Boolean)this.dwj.get(???)).booleanValue()))
        {
          i += 1;
          break;
          localObject1 = finally;
          AppMethodBeat.o(136858);
          throw localObject1;
        }
        localObject8 = (List)this.dwi.get(???);
        if ((localObject8 == null) || (((List)localObject8).size() == 0))
        {
          if (!gX((String)???)) {
            continue;
          }
          m((String)???, false);
          gY((String)???);
        }
      }
      if (this.dwk.containsKey(???))
      {
        ??? = (WeakReference)this.dwk.get(???);
        if ((??? != null) && (((WeakReference)???).get() != null))
        {
          ??? = (com.tencent.mm.audio.mix.d.c)((WeakReference)???).get();
          if (??? != null) {
            ((com.tencent.mm.audio.mix.d.c)???).jd(((List)localObject8).size());
          }
        }
      }
      ??? = this.dwh.get(???);
      if (??? != null)
      {
        int j;
        try
        {
          j = ((List)localObject8).size();
          if (j <= 0) {
            continue;
          }
        }
        finally
        {
          AppMethodBeat.o(136858);
        }
        localObject8 = (e)((List)localObject8).remove(j - 1);
        if ((!this.dwp.containsKey(???)) || (((Integer)this.dwp.get(???)).intValue() <= ((e)localObject8).dua)) {
          break label368;
        }
      }
    }
    label368:
    this.dwq.put(???, Long.valueOf(((e)localObject8).dua));
    Object localObject9 = this.dwd.ha((String)???);
    if ((localObject9 != null) && (((com.tencent.mm.ai.b)localObject9).iJG == 0.0D) && (!((e)localObject8).dub))
    {
      localObject9 = com.tencent.mm.audio.mix.b.d.YH().YI();
      if (localObject9 != null)
      {
        if (((e)localObject9).dtQ == null) {
          ((e)localObject9).dtQ = new byte[3536];
        }
        ((e)localObject9).reset();
        this.dwm.add(localObject9);
      }
    }
    for (;;)
    {
      this.dtR.add(???);
      break;
      this.dwm.add(localObject8);
      continue;
      if ((localObject9 != null) && (((com.tencent.mm.ai.b)localObject9).iJG == 0.0D) && (((e)localObject8).dub))
      {
        ((e)localObject8).reset();
        this.dwm.add(localObject8);
      }
      else
      {
        this.dwm.add(localObject8);
      }
    }
    label557:
    synchronized (this.dwl)
    {
      if (this.dwm.size() == 0)
      {
        boolean bool = this.dvr.get();
        if (bool) {}
      }
      try
      {
        com.tencent.mm.audio.mix.i.b.i("MicroMsg.Mix.AudioMixController", "wait read data");
        this.dwl.wait();
        ??? = this.dwm;
        AppMethodBeat.o(136858);
        return ???;
      }
      catch (Exception localException)
      {
        for (;;)
        {
          com.tencent.mm.audio.mix.i.b.printErrStackTrace("MicroMsg.Mix.AudioMixController", localException, "readMixDataFromPcmTrack", new Object[0]);
        }
      }
    }
  }
  
  /* Error */
  public final int a(String paramString, e arg2, com.tencent.mm.audio.mix.d.c paramc)
  {
    // Byte code:
    //   0: ldc_w 384
    //   3: invokestatic 65	com/tencent/matrix/trace/core/AppMethodBeat:i	(I)V
    //   6: aload_2
    //   7: ifnull +17 -> 24
    //   10: aload_1
    //   11: invokestatic 390	android/text/TextUtils:isEmpty	(Ljava/lang/CharSequence;)Z
    //   14: ifne +10 -> 24
    //   17: aload_2
    //   18: getfield 369	com/tencent/mm/audio/mix/a/e:dtQ	[B
    //   21: ifnonnull +19 -> 40
    //   24: ldc 181
    //   26: ldc_w 392
    //   29: invokestatic 395	com/tencent/mm/audio/mix/i/b:e	(Ljava/lang/String;Ljava/lang/String;)V
    //   32: ldc_w 384
    //   35: invokestatic 135	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   38: iconst_0
    //   39: ireturn
    //   40: aconst_null
    //   41: astore 6
    //   43: aconst_null
    //   44: astore 5
    //   46: aload_0
    //   47: getfield 92	com/tencent/mm/audio/mix/f/c:dwi	Ljava/util/HashMap;
    //   50: aload_1
    //   51: invokevirtual 219	java/util/HashMap:containsKey	(Ljava/lang/Object;)Z
    //   54: ifne +102 -> 156
    //   57: ldc 181
    //   59: ldc_w 397
    //   62: iconst_1
    //   63: anewarray 4	java/lang/Object
    //   66: dup
    //   67: iconst_0
    //   68: aload_1
    //   69: aastore
    //   70: invokestatic 399	com/tencent/mm/audio/mix/i/b:e	(Ljava/lang/String;Ljava/lang/String;[Ljava/lang/Object;)V
    //   73: aload_0
    //   74: getfield 98	com/tencent/mm/audio/mix/f/c:dwl	Ljava/lang/Object;
    //   77: astore 7
    //   79: aload 7
    //   81: monitorenter
    //   82: aload_0
    //   83: getfield 92	com/tencent/mm/audio/mix/f/c:dwi	Ljava/util/HashMap;
    //   86: aload_1
    //   87: new 100	java/util/ArrayList
    //   90: dup
    //   91: invokespecial 101	java/util/ArrayList:<init>	()V
    //   94: invokevirtual 351	java/util/HashMap:put	(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;
    //   97: pop
    //   98: aload_0
    //   99: getfield 88	com/tencent/mm/audio/mix/f/c:dwg	Ljava/util/LinkedList;
    //   102: aload_1
    //   103: invokevirtual 402	java/util/LinkedList:contains	(Ljava/lang/Object;)Z
    //   106: ifne +12 -> 118
    //   109: aload_0
    //   110: getfield 88	com/tencent/mm/audio/mix/f/c:dwg	Ljava/util/LinkedList;
    //   113: aload_1
    //   114: invokevirtual 376	java/util/LinkedList:add	(Ljava/lang/Object;)Z
    //   117: pop
    //   118: aload 5
    //   120: astore 6
    //   122: aload_0
    //   123: getfield 90	com/tencent/mm/audio/mix/f/c:dwh	Ljava/util/HashMap;
    //   126: aload_1
    //   127: invokevirtual 219	java/util/HashMap:containsKey	(Ljava/lang/Object;)Z
    //   130: ifne +23 -> 153
    //   133: new 4	java/lang/Object
    //   136: dup
    //   137: invokespecial 58	java/lang/Object:<init>	()V
    //   140: astore 6
    //   142: aload_0
    //   143: getfield 90	com/tencent/mm/audio/mix/f/c:dwh	Ljava/util/HashMap;
    //   146: aload_1
    //   147: aload 6
    //   149: invokevirtual 351	java/util/HashMap:put	(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;
    //   152: pop
    //   153: aload 7
    //   155: monitorexit
    //   156: aload 6
    //   158: astore 5
    //   160: aload 6
    //   162: ifnonnull +57 -> 219
    //   165: aload_0
    //   166: getfield 90	com/tencent/mm/audio/mix/f/c:dwh	Ljava/util/HashMap;
    //   169: aload_1
    //   170: invokevirtual 219	java/util/HashMap:containsKey	(Ljava/lang/Object;)Z
    //   173: ifne +155 -> 328
    //   176: aload_0
    //   177: getfield 98	com/tencent/mm/audio/mix/f/c:dwl	Ljava/lang/Object;
    //   180: astore 6
    //   182: aload 6
    //   184: monitorenter
    //   185: aload_0
    //   186: getfield 90	com/tencent/mm/audio/mix/f/c:dwh	Ljava/util/HashMap;
    //   189: aload_1
    //   190: invokevirtual 219	java/util/HashMap:containsKey	(Ljava/lang/Object;)Z
    //   193: ifne +110 -> 303
    //   196: new 4	java/lang/Object
    //   199: dup
    //   200: invokespecial 58	java/lang/Object:<init>	()V
    //   203: astore 5
    //   205: aload_0
    //   206: getfield 90	com/tencent/mm/audio/mix/f/c:dwh	Ljava/util/HashMap;
    //   209: aload_1
    //   210: aload 5
    //   212: invokevirtual 351	java/util/HashMap:put	(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;
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
    //   234: getfield 96	com/tencent/mm/audio/mix/f/c:dwk	Ljava/util/HashMap;
    //   237: aload_1
    //   238: invokevirtual 219	java/util/HashMap:containsKey	(Ljava/lang/Object;)Z
    //   241: ifne +20 -> 261
    //   244: aload_0
    //   245: getfield 96	com/tencent/mm/audio/mix/f/c:dwk	Ljava/util/HashMap;
    //   248: aload_1
    //   249: new 329	java/lang/ref/WeakReference
    //   252: dup
    //   253: aload_3
    //   254: invokespecial 405	java/lang/ref/WeakReference:<init>	(Ljava/lang/Object;)V
    //   257: invokevirtual 351	java/util/HashMap:put	(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;
    //   260: pop
    //   261: aload_0
    //   262: getfield 92	com/tencent/mm/audio/mix/f/c:dwi	Ljava/util/HashMap;
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
    //   283: ldc_w 384
    //   286: invokestatic 135	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   289: iconst_0
    //   290: ireturn
    //   291: astore_1
    //   292: aload 7
    //   294: monitorexit
    //   295: ldc_w 384
    //   298: invokestatic 135	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   301: aload_1
    //   302: athrow
    //   303: aload_0
    //   304: getfield 90	com/tencent/mm/audio/mix/f/c:dwh	Ljava/util/HashMap;
    //   307: aload_1
    //   308: invokevirtual 209	java/util/HashMap:get	(Ljava/lang/Object;)Ljava/lang/Object;
    //   311: astore 5
    //   313: goto -97 -> 216
    //   316: astore_1
    //   317: aload 6
    //   319: monitorexit
    //   320: ldc_w 384
    //   323: invokestatic 135	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   326: aload_1
    //   327: athrow
    //   328: aload_0
    //   329: getfield 90	com/tencent/mm/audio/mix/f/c:dwh	Ljava/util/HashMap;
    //   332: aload_1
    //   333: invokevirtual 209	java/util/HashMap:get	(Ljava/lang/Object;)Ljava/lang/Object;
    //   336: astore 5
    //   338: goto -119 -> 219
    //   341: aload_1
    //   342: iconst_0
    //   343: aload_2
    //   344: invokeinterface 408 3 0
    //   349: aload 5
    //   351: monitorexit
    //   352: aload_0
    //   353: getfield 98	com/tencent/mm/audio/mix/f/c:dwl	Ljava/lang/Object;
    //   356: astore_2
    //   357: aload_2
    //   358: monitorenter
    //   359: aload_0
    //   360: getfield 98	com/tencent/mm/audio/mix/f/c:dwl	Ljava/lang/Object;
    //   363: invokevirtual 194	java/lang/Object:notifyAll	()V
    //   366: aload_2
    //   367: monitorexit
    //   368: aload_1
    //   369: invokeinterface 319 1 0
    //   374: istore 4
    //   376: ldc_w 384
    //   379: invokestatic 135	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   382: iload 4
    //   384: ireturn
    //   385: astore_1
    //   386: aload 5
    //   388: monitorexit
    //   389: ldc_w 384
    //   392: invokestatic 135	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   395: aload_1
    //   396: athrow
    //   397: astore_3
    //   398: ldc 181
    //   400: aload_3
    //   401: ldc_w 410
    //   404: iconst_0
    //   405: anewarray 4	java/lang/Object
    //   408: invokestatic 189	com/tencent/mm/audio/mix/i/b:printErrStackTrace	(Ljava/lang/String;Ljava/lang/Throwable;Ljava/lang/String;[Ljava/lang/Object;)V
    //   411: goto -45 -> 366
    //   414: astore_1
    //   415: aload_2
    //   416: monitorexit
    //   417: ldc_w 384
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
  
  /* Error */
  public final boolean c(String arg1, int paramInt, boolean paramBoolean)
  {
    // Byte code:
    //   0: ldc_w 413
    //   3: invokestatic 65	com/tencent/matrix/trace/core/AppMethodBeat:i	(I)V
    //   6: aload_0
    //   7: getfield 88	com/tencent/mm/audio/mix/f/c:dwg	Ljava/util/LinkedList;
    //   10: aload_1
    //   11: invokevirtual 402	java/util/LinkedList:contains	(Ljava/lang/Object;)Z
    //   14: ifne +11 -> 25
    //   17: ldc_w 413
    //   20: invokestatic 135	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   23: iconst_0
    //   24: ireturn
    //   25: iload_2
    //   26: ifge +20 -> 46
    //   29: aload_0
    //   30: getfield 109	com/tencent/mm/audio/mix/f/c:dwp	Ljava/util/HashMap;
    //   33: aload_1
    //   34: invokevirtual 415	java/util/HashMap:remove	(Ljava/lang/Object;)Ljava/lang/Object;
    //   37: pop
    //   38: ldc_w 413
    //   41: invokestatic 135	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   44: iconst_0
    //   45: ireturn
    //   46: invokestatic 421	java/lang/System:currentTimeMillis	()J
    //   49: lstore 9
    //   51: iload_2
    //   52: ifne +57 -> 109
    //   55: aload_0
    //   56: getfield 109	com/tencent/mm/audio/mix/f/c:dwp	Ljava/util/HashMap;
    //   59: aload_1
    //   60: invokevirtual 415	java/util/HashMap:remove	(Ljava/lang/Object;)Ljava/lang/Object;
    //   63: pop
    //   64: aload_0
    //   65: getfield 92	com/tencent/mm/audio/mix/f/c:dwi	Ljava/util/HashMap;
    //   68: aload_1
    //   69: invokevirtual 209	java/util/HashMap:get	(Ljava/lang/Object;)Ljava/lang/Object;
    //   72: checkcast 141	java/util/List
    //   75: astore 12
    //   77: aload 12
    //   79: ifnull +13 -> 92
    //   82: aload 12
    //   84: invokeinterface 319 1 0
    //   89: ifne +36 -> 125
    //   92: aload_0
    //   93: getfield 109	com/tencent/mm/audio/mix/f/c:dwp	Ljava/util/HashMap;
    //   96: aload_1
    //   97: invokevirtual 415	java/util/HashMap:remove	(Ljava/lang/Object;)Ljava/lang/Object;
    //   100: pop
    //   101: ldc_w 413
    //   104: invokestatic 135	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   107: iconst_0
    //   108: ireturn
    //   109: aload_0
    //   110: getfield 109	com/tencent/mm/audio/mix/f/c:dwp	Ljava/util/HashMap;
    //   113: aload_1
    //   114: iload_2
    //   115: invokestatic 424	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
    //   118: invokevirtual 351	java/util/HashMap:put	(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;
    //   121: pop
    //   122: goto -58 -> 64
    //   125: aload_0
    //   126: getfield 132	com/tencent/mm/audio/mix/f/c:dwd	Lcom/tencent/mm/audio/mix/g/d;
    //   129: aload_1
    //   130: invokevirtual 355	com/tencent/mm/audio/mix/g/d:ha	(Ljava/lang/String;)Lcom/tencent/mm/ai/b;
    //   133: astore 11
    //   135: aload 11
    //   137: ifnonnull +20 -> 157
    //   140: aload_0
    //   141: getfield 109	com/tencent/mm/audio/mix/f/c:dwp	Ljava/util/HashMap;
    //   144: aload_1
    //   145: invokevirtual 415	java/util/HashMap:remove	(Ljava/lang/Object;)Ljava/lang/Object;
    //   148: pop
    //   149: ldc_w 413
    //   152: invokestatic 135	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   155: iconst_0
    //   156: ireturn
    //   157: ldc 181
    //   159: ldc_w 426
    //   162: invokestatic 266	com/tencent/mm/audio/mix/i/b:i	(Ljava/lang/String;Ljava/lang/String;)V
    //   165: aload_0
    //   166: aload_1
    //   167: invokevirtual 429	com/tencent/mm/audio/mix/f/c:gT	(Ljava/lang/String;)Z
    //   170: istore 8
    //   172: iload 8
    //   174: ifne +8 -> 182
    //   177: aload_0
    //   178: aload_1
    //   179: invokevirtual 432	com/tencent/mm/audio/mix/f/c:gR	(Ljava/lang/String;)V
    //   182: aload 12
    //   184: invokeinterface 319 1 0
    //   189: istore 6
    //   191: invokestatic 438	com/tencent/mm/audio/mix/b/f:YL	()Lcom/tencent/mm/audio/mix/b/f;
    //   194: aload 11
    //   196: getfield 442	com/tencent/mm/ai/b:filePath	Ljava/lang/String;
    //   199: invokevirtual 446	com/tencent/mm/audio/mix/b/f:gE	(Ljava/lang/String;)Lcom/tencent/mm/audio/mix/a/d;
    //   202: astore 13
    //   204: aload 13
    //   206: invokevirtual 449	com/tencent/mm/audio/mix/a/d:size	()I
    //   209: istore 7
    //   211: iload_2
    //   212: bipush 20
    //   214: idiv
    //   215: istore 5
    //   217: aload_0
    //   218: aload_1
    //   219: invokevirtual 453	com/tencent/mm/audio/mix/f/c:gV	(Ljava/lang/String;)J
    //   222: ldc2_w 454
    //   225: ldiv
    //   226: l2i
    //   227: istore 4
    //   229: aload_0
    //   230: getfield 90	com/tencent/mm/audio/mix/f/c:dwh	Ljava/util/HashMap;
    //   233: aload_1
    //   234: invokevirtual 209	java/util/HashMap:get	(Ljava/lang/Object;)Ljava/lang/Object;
    //   237: astore 11
    //   239: aload 11
    //   241: ifnonnull +20 -> 261
    //   244: aload_0
    //   245: getfield 109	com/tencent/mm/audio/mix/f/c:dwp	Ljava/util/HashMap;
    //   248: aload_1
    //   249: invokevirtual 415	java/util/HashMap:remove	(Ljava/lang/Object;)Ljava/lang/Object;
    //   252: pop
    //   253: ldc_w 413
    //   256: invokestatic 135	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   259: iconst_0
    //   260: ireturn
    //   261: iload 5
    //   263: iload 4
    //   265: if_icmple +191 -> 456
    //   268: iload 5
    //   270: iload 7
    //   272: if_icmpgt +184 -> 456
    //   275: ldc 181
    //   277: ldc_w 457
    //   280: invokestatic 395	com/tencent/mm/audio/mix/i/b:e	(Ljava/lang/String;Ljava/lang/String;)V
    //   283: aload 11
    //   285: monitorenter
    //   286: iconst_0
    //   287: istore_2
    //   288: iload_2
    //   289: iload 5
    //   291: iload 4
    //   293: isub
    //   294: if_icmpge +54 -> 348
    //   297: iload_2
    //   298: iload 6
    //   300: if_icmpge +48 -> 348
    //   303: aload 12
    //   305: aload 12
    //   307: invokeinterface 319 1 0
    //   312: iconst_1
    //   313: isub
    //   314: invokeinterface 339 2 0
    //   319: checkcast 157	com/tencent/mm/audio/mix/a/e
    //   322: astore 13
    //   324: aload 13
    //   326: ifnull +309 -> 635
    //   329: aload 13
    //   331: getfield 160	com/tencent/mm/audio/mix/a/e:dub	Z
    //   334: ifeq +301 -> 635
    //   337: invokestatic 166	com/tencent/mm/audio/mix/b/d:YH	()Lcom/tencent/mm/audio/mix/b/d;
    //   340: aload 13
    //   342: invokevirtual 170	com/tencent/mm/audio/mix/b/d:b	(Lcom/tencent/mm/audio/mix/a/e;)V
    //   345: goto +290 -> 635
    //   348: aload 11
    //   350: monitorexit
    //   351: iload 8
    //   353: ifne +59 -> 412
    //   356: ldc 181
    //   358: ldc_w 459
    //   361: invokestatic 266	com/tencent/mm/audio/mix/i/b:i	(Ljava/lang/String;Ljava/lang/String;)V
    //   364: aload_0
    //   365: getfield 98	com/tencent/mm/audio/mix/f/c:dwl	Ljava/lang/Object;
    //   368: astore 11
    //   370: aload 11
    //   372: monitorenter
    //   373: aload_0
    //   374: getfield 94	com/tencent/mm/audio/mix/f/c:dwj	Ljava/util/HashMap;
    //   377: aload_1
    //   378: invokevirtual 219	java/util/HashMap:containsKey	(Ljava/lang/Object;)Z
    //   381: ifeq +218 -> 599
    //   384: aload_0
    //   385: getfield 94	com/tencent/mm/audio/mix/f/c:dwj	Ljava/util/HashMap;
    //   388: aload_1
    //   389: getstatic 463	java/lang/Boolean:FALSE	Ljava/lang/Boolean;
    //   392: invokevirtual 351	java/util/HashMap:put	(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;
    //   395: pop
    //   396: aload 11
    //   398: monitorexit
    //   399: aload_0
    //   400: getfield 98	com/tencent/mm/audio/mix/f/c:dwl	Ljava/lang/Object;
    //   403: astore_1
    //   404: aload_1
    //   405: monitorenter
    //   406: aload_0
    //   407: invokespecial 294	com/tencent/mm/audio/mix/f/c:Zw	()V
    //   410: aload_1
    //   411: monitorexit
    //   412: ldc 181
    //   414: ldc_w 465
    //   417: iconst_1
    //   418: anewarray 4	java/lang/Object
    //   421: dup
    //   422: iconst_0
    //   423: invokestatic 421	java/lang/System:currentTimeMillis	()J
    //   426: lload 9
    //   428: lsub
    //   429: invokestatic 285	java/lang/Long:valueOf	(J)Ljava/lang/Long;
    //   432: aastore
    //   433: invokestatic 288	com/tencent/mm/audio/mix/i/b:i	(Ljava/lang/String;Ljava/lang/String;[Ljava/lang/Object;)V
    //   436: ldc_w 413
    //   439: invokestatic 135	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   442: iconst_1
    //   443: ireturn
    //   444: astore_1
    //   445: aload 11
    //   447: monitorexit
    //   448: ldc_w 413
    //   451: invokestatic 135	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   454: aload_1
    //   455: athrow
    //   456: iload 5
    //   458: iload 4
    //   460: if_icmpge +55 -> 515
    //   463: iload 4
    //   465: iload 7
    //   467: if_icmpgt +48 -> 515
    //   470: iload_3
    //   471: ifne +44 -> 515
    //   474: ldc 181
    //   476: ldc_w 467
    //   479: invokestatic 395	com/tencent/mm/audio/mix/i/b:e	(Ljava/lang/String;Ljava/lang/String;)V
    //   482: aload 11
    //   484: monitorenter
    //   485: aload 12
    //   487: invokestatic 469	com/tencent/mm/audio/mix/f/c:O	(Ljava/util/List;)V
    //   490: aload 12
    //   492: invokeinterface 212 1 0
    //   497: aload 11
    //   499: monitorexit
    //   500: goto -149 -> 351
    //   503: astore_1
    //   504: aload 11
    //   506: monitorexit
    //   507: ldc_w 413
    //   510: invokestatic 135	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   513: aload_1
    //   514: athrow
    //   515: iload 5
    //   517: iload 4
    //   519: if_icmpge -168 -> 351
    //   522: iload 4
    //   524: iload 7
    //   526: if_icmpgt -175 -> 351
    //   529: ldc 181
    //   531: ldc_w 471
    //   534: invokestatic 395	com/tencent/mm/audio/mix/i/b:e	(Ljava/lang/String;Ljava/lang/String;)V
    //   537: aload 11
    //   539: monitorenter
    //   540: iload 4
    //   542: istore_2
    //   543: iload_2
    //   544: iload 5
    //   546: if_icmple +35 -> 581
    //   549: aload 13
    //   551: iload_2
    //   552: invokevirtual 475	com/tencent/mm/audio/mix/a/d:jb	(I)Lcom/tencent/mm/audio/mix/a/e;
    //   555: astore 14
    //   557: aload 14
    //   559: ifnull +83 -> 642
    //   562: aload 12
    //   564: aload 12
    //   566: invokeinterface 319 1 0
    //   571: aload 14
    //   573: invokeinterface 408 3 0
    //   578: goto +64 -> 642
    //   581: aload 11
    //   583: monitorexit
    //   584: goto -233 -> 351
    //   587: astore_1
    //   588: aload 11
    //   590: monitorexit
    //   591: ldc_w 413
    //   594: invokestatic 135	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   597: aload_1
    //   598: athrow
    //   599: ldc 181
    //   601: ldc_w 477
    //   604: invokestatic 395	com/tencent/mm/audio/mix/i/b:e	(Ljava/lang/String;Ljava/lang/String;)V
    //   607: goto -211 -> 396
    //   610: astore_1
    //   611: aload 11
    //   613: monitorexit
    //   614: ldc_w 413
    //   617: invokestatic 135	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   620: aload_1
    //   621: athrow
    //   622: astore 11
    //   624: aload_1
    //   625: monitorexit
    //   626: ldc_w 413
    //   629: invokestatic 135	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   632: aload 11
    //   634: athrow
    //   635: iload_2
    //   636: iconst_1
    //   637: iadd
    //   638: istore_2
    //   639: goto -351 -> 288
    //   642: iload_2
    //   643: iconst_1
    //   644: isub
    //   645: istore_2
    //   646: goto -103 -> 543
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	649	0	this	c
    //   0	649	2	paramInt	int
    //   0	649	3	paramBoolean	boolean
    //   227	314	4	i	int
    //   215	332	5	j	int
    //   189	112	6	k	int
    //   209	318	7	m	int
    //   170	182	8	bool	boolean
    //   49	378	9	l	long
    //   622	11	11	localObject2	Object
    //   75	490	12	localList	List
    //   202	348	13	localObject3	Object
    //   555	17	14	locale	e
    // Exception table:
    //   from	to	target	type
    //   303	324	444	finally
    //   329	345	444	finally
    //   348	351	444	finally
    //   445	448	444	finally
    //   485	500	503	finally
    //   504	507	503	finally
    //   549	557	587	finally
    //   562	578	587	finally
    //   581	584	587	finally
    //   588	591	587	finally
    //   373	396	610	finally
    //   396	399	610	finally
    //   599	607	610	finally
    //   611	614	610	finally
    //   406	412	622	finally
    //   624	626	622	finally
  }
  
  public final void clearCache()
  {
    AppMethodBeat.i(136859);
    com.tencent.mm.audio.mix.i.b.i("MicroMsg.Mix.AudioMixController", "clearCache");
    synchronized (this.dwl)
    {
      Zz();
      this.dwh.clear();
      AppMethodBeat.o(136859);
      return;
    }
  }
  
  public final void gQ(String paramString)
  {
    AppMethodBeat.i(136844);
    if (this.dwr > 0L) {
      this.dwr = 0L;
    }
    for (;;)
    {
      synchronized (this.dwl)
      {
        this.dwe.set(false);
        this.dwf.put(paramString, Boolean.FALSE);
        if (!this.dwg.contains(paramString))
        {
          this.dwg.add(paramString);
          this.dwi.put(paramString, new ArrayList());
          this.dwh.put(paramString, new Object());
          this.dwn.put(paramString, Boolean.FALSE);
          this.dwj.put(paramString, Boolean.FALSE);
          this.dwo.put(paramString, Boolean.FALSE);
          if (this.dvq.get())
          {
            this.dvq.set(false);
            Zu();
            Zw();
            AppMethodBeat.o(136844);
          }
        }
        else
        {
          com.tencent.mm.audio.mix.i.b.e("MicroMsg.Mix.AudioMixController", "The audio of the Id is mixing");
        }
      }
      this.dwm.size();
    }
  }
  
  public final void gR(String paramString)
  {
    AppMethodBeat.i(136845);
    synchronized (this.dwl)
    {
      if (this.dwj.containsKey(paramString))
      {
        this.dwj.put(paramString, Boolean.TRUE);
        AppMethodBeat.o(136845);
        return;
      }
      com.tencent.mm.audio.mix.i.b.e("MicroMsg.Mix.AudioMixController", "The audio of the id is remove");
    }
  }
  
  public final void gS(String paramString)
  {
    AppMethodBeat.i(136846);
    this.dwf.put(paramString, Boolean.TRUE);
    gU(paramString);
    if (this.dwg.isEmpty())
    {
      com.tencent.mm.audio.mix.i.b.i("MicroMsg.Mix.AudioMixController", "stopMix isMute");
      this.dwe.set(true);
      this.dwd.Zj();
      AppMethodBeat.o(136846);
      return;
    }
    this.dwe.set(false);
    AppMethodBeat.o(136846);
  }
  
  public final boolean gT(String paramString)
  {
    AppMethodBeat.i(136848);
    synchronized (this.dwl)
    {
      if (this.dwj.containsKey(paramString))
      {
        boolean bool = ((Boolean)this.dwj.get(paramString)).booleanValue();
        AppMethodBeat.o(136848);
        return bool;
      }
      AppMethodBeat.o(136848);
      return false;
    }
  }
  
  public final void gU(String paramString)
  {
    AppMethodBeat.i(136849);
    for (;;)
    {
      List localList;
      synchronized (this.dwl)
      {
        if (!this.dwg.contains(paramString)) {
          break label189;
        }
        this.dwg.remove(paramString);
        Object localObject2 = this.dwh.get(paramString);
        localList = (List)this.dwi.remove(paramString);
        if (localObject2 != null) {
          try
          {
            O(localList);
            localList.clear();
            this.dwh.remove(paramString);
            this.dwj.remove(paramString);
            this.dwn.remove(paramString);
            this.dwo.remove(paramString);
            if (this.dvq.get()) {
              Zw();
            }
            this.dwp.remove(paramString);
            this.dwq.remove(paramString);
            return;
          }
          finally
          {
            AppMethodBeat.o(136849);
          }
        }
      }
      O(localList);
      localList.clear();
      continue;
      label189:
      com.tencent.mm.audio.mix.i.b.e("MicroMsg.Mix.AudioMixController", "The audio of the id is remove");
    }
  }
  
  public final long gV(String paramString)
  {
    AppMethodBeat.i(136851);
    synchronized (this.dwl)
    {
      if (this.dwq.containsKey(paramString))
      {
        paramString = (Long)this.dwq.get(paramString);
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
  
  public final boolean gW(String paramString)
  {
    AppMethodBeat.i(136852);
    if (!this.dwg.contains(paramString))
    {
      AppMethodBeat.o(136852);
      return true;
    }
    paramString = (List)this.dwi.get(paramString);
    if ((paramString == null) || (paramString.size() == 0))
    {
      com.tencent.mm.audio.mix.i.b.i("MicroMsg.Mix.AudioMixController", "queue size is 0");
      AppMethodBeat.o(136852);
      return true;
    }
    AppMethodBeat.o(136852);
    return false;
  }
  
  public final String gZ(String paramString)
  {
    AppMethodBeat.i(136862);
    paramString = (WeakReference)this.dwk.get(paramString);
    if ((paramString != null) && (paramString.get() != null))
    {
      paramString = (com.tencent.mm.audio.mix.d.c)paramString.get();
      if (paramString != null)
      {
        paramString = paramString.dvn;
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
    synchronized (this.dwl)
    {
      this.dwn.put(paramString, Boolean.valueOf(paramBoolean));
      AppMethodBeat.o(136853);
      return;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.audio.mix.f.c
 * JD-Core Version:    0.7.0.1
 */