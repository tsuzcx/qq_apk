package com.tencent.mm.audio.mix.f;

import android.media.AudioTrack;
import android.os.Handler;
import android.os.Looper;
import android.os.Process;
import android.text.TextUtils;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.audio.mix.d.m;
import com.tencent.mm.audio.mix.e.i;
import com.tencent.mm.g.a.w;
import com.tencent.mm.g.a.w.a;
import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.Queue;
import java.util.concurrent.atomic.AtomicBoolean;

public final class d
{
  AudioTrack bfq;
  private int channels;
  volatile HashMap<String, com.tencent.mm.ai.b> deg;
  public com.tencent.mm.audio.mix.d.a dfR;
  private int dfW;
  public AtomicBoolean dfX;
  AtomicBoolean dfY;
  public AtomicBoolean dfZ;
  volatile HashMap<String, Boolean> dfe;
  public Queue<com.tencent.mm.audio.mix.a.b> dga;
  public Object dgb;
  Object dgc;
  private Thread dgd;
  public com.tencent.mm.audio.mix.e.c dge;
  b dgf;
  private m dgg;
  public g dgh;
  volatile HashMap<String, Boolean> dgi;
  volatile HashMap<String, Boolean> dgj;
  volatile HashMap<String, e<Integer>> dgk;
  volatile HashMap<String, com.tencent.mm.ai.d> dgl;
  private ArrayList<String> dgm;
  private volatile HashMap<String, Long> dgn;
  private volatile HashMap<String, Integer> dgo;
  private volatile HashMap<String, Integer> dgp;
  private volatile HashMap<String, Integer> dgq;
  private volatile HashMap<String, Integer> dgr;
  private volatile HashMap<String, Integer> dgs;
  private byte[] dgt;
  byte[] dgu;
  private short dgv;
  volatile boolean dgw;
  int dgx;
  private Runnable dgy;
  ArrayList<String> dgz;
  Handler mHandler;
  private int sampleRate;
  
  public d()
  {
    AppMethodBeat.i(136920);
    this.channels = 2;
    this.sampleRate = 44100;
    this.dfW = 4;
    this.dfX = new AtomicBoolean(false);
    this.dfY = new AtomicBoolean(false);
    this.dfZ = new AtomicBoolean(true);
    this.dga = new ArrayDeque();
    this.dgb = new Object();
    this.dgc = new Object();
    this.deg = new HashMap();
    this.dgi = new HashMap();
    this.dgj = new HashMap();
    this.dgk = new HashMap();
    this.dgl = new HashMap();
    this.dfe = new HashMap();
    this.dgm = new ArrayList();
    this.dgn = new HashMap();
    this.dgo = new HashMap();
    this.dgp = new HashMap();
    this.dgq = new HashMap();
    this.dgr = new HashMap();
    this.dgs = new HashMap();
    this.dgt = new byte[3536];
    this.dgu = new byte[2];
    this.dgv = 0;
    this.dgw = false;
    this.dgx = 0;
    this.dgy = new Runnable()
    {
      public final void run()
      {
        AppMethodBeat.i(136917);
        Process.setThreadPriority(-19);
        if (d.this.dfZ.get())
        {
          com.tencent.mm.audio.mix.h.b.e("MicroMsg.Mix.AudioMixPlayerImpl", "stop and exit");
          AppMethodBeat.o(136917);
          return;
        }
        if (d.this.bfq == null) {
          d.a(d.this);
        }
        com.tencent.mm.audio.mix.h.b.i("MicroMsg.Mix.AudioMixPlayerImpl", "playback start");
        do
        {
          if (!d.this.dfZ.get())
          {
            d locald1 = d.this;
            synchronized (locald1.dgb)
            {
              for (;;)
              {
                if ((locald1.dfY.get()) && (!locald1.dfZ.get()))
                {
                  com.tencent.mm.audio.mix.h.b.i("MicroMsg.Mix.AudioMixPlayerImpl", "waitPlay");
                  try
                  {
                    locald1.dgb.wait();
                  }
                  catch (Exception localException)
                  {
                    com.tencent.mm.audio.mix.h.b.printErrStackTrace("MicroMsg.Mix.AudioMixPlayerImpl", localException, "waitPlay", new Object[0]);
                  }
                }
              }
            }
            if (d.this.dfZ.get()) {
              com.tencent.mm.audio.mix.h.b.e("MicroMsg.Mix.AudioMixPlayerImpl", "playback break");
            }
          }
          else
          {
            d.this.releaseAudioTrack();
            com.tencent.mm.audio.mix.h.b.i("MicroMsg.Mix.AudioMixPlayerImpl", "release AudioTrack and exit playback thread id:%d", new Object[] { Long.valueOf(Thread.currentThread().getId()) });
            AppMethodBeat.o(136917);
            return;
          }
          ??? = d.this.Pu();
        } while (??? == null);
        Object localObject3 = ((com.tencent.mm.audio.mix.a.b)???).dcZ;
        if (d.this.bfq == null) {
          d.a(d.this);
        }
        d locald2;
        label350:
        String str;
        if ((localObject3 != null) && (localObject3.length > 0))
        {
          if ((d.this.bfq != null) && ((d.this.bfq.getPlayState() == 1) || (d.this.bfq.getPlayState() == 2))) {
            d.this.bfq.play();
          }
          ??? = d.this;
          ((d)???).dgx += 1;
          locald2 = d.this;
          Iterator localIterator = ((com.tencent.mm.audio.mix.a.b)???).dda.iterator();
          for (;;)
          {
            if (!localIterator.hasNext()) {
              break label500;
            }
            str = (String)localIterator.next();
            synchronized (locald2.dgc)
            {
              if (!TextUtils.isEmpty(str)) {
                if ((!locald2.dfe.containsKey(str)) || (!((Boolean)locald2.dfe.get(str)).booleanValue())) {
                  break;
                }
              }
            }
          }
          if (!locald2.dfe.containsKey(str)) {
            break label831;
          }
          locald2.dfe.put(str, Boolean.TRUE);
        }
        label547:
        label831:
        for (int i = 1;; i = 0)
        {
          if (i == 0) {
            break label350;
          }
          locald2.mHandler.post(new d.2(locald2, str));
          break label350;
          label500:
          long l = System.currentTimeMillis();
          if (d.this.bfq != null) {
            if (d.this.dge.Pd())
            {
              com.tencent.mm.audio.mix.h.b.i("MicroMsg.Mix.AudioMixPlayerImpl", "isMute");
              d.this.bfq.setStereoVolume(0.0F, 0.0F);
            }
          }
          for (i = d.this.bfq.write((byte[])localObject3, 0, localObject3.length);; i = 0)
          {
            l = System.currentTimeMillis() - l;
            if (l > 100L) {
              com.tencent.mm.audio.mix.h.b.e("MicroMsg.Mix.AudioMixPlayerImpl", "write audio track after writeSize:%d, time:%d, writeCount:%d", new Object[] { Integer.valueOf(i), Long.valueOf(l), Integer.valueOf(d.this.dgx) });
            }
            if (i < 0) {
              com.tencent.mm.audio.mix.h.b.e("MicroMsg.Mix.AudioMixPlayerImpl", "write audio track buffer failed, Size:%d", new Object[] { Integer.valueOf(i) });
            }
            if (d.this.dga.size() == 0)
            {
              d.this.dgu[0] = localObject3[(localObject3.length - 2)];
              d.this.dgu[1] = localObject3[(localObject3.length - 1)];
            }
            localObject3 = d.this;
            if ((((d)localObject3).dgf != null) && (((d)localObject3).dgw))
            {
              ??? = com.tencent.mm.audio.mix.b.b.Om().On();
              if (??? != null)
              {
                if ((((com.tencent.mm.audio.mix.a.c)???).dcZ == null) || (((com.tencent.mm.audio.mix.a.c)???).dcZ.length < localb.dcZ.length)) {
                  ((com.tencent.mm.audio.mix.a.c)???).dcZ = new byte[localb.dcZ.length];
                }
                System.arraycopy(localb.dcZ, 0, ((com.tencent.mm.audio.mix.a.c)???).dcZ, 0, localb.dcZ.length);
                ((d)localObject3).mHandler.post(new d.4((d)localObject3, (com.tencent.mm.audio.mix.a.c)???));
              }
            }
            com.tencent.mm.audio.mix.b.a.Ok().a(localb);
            break;
            d.this.bfq.setStereoVolume(1.0F, 1.0F);
            break label547;
          }
        }
      }
    };
    this.dgz = new ArrayList();
    this.dge = new com.tencent.mm.audio.mix.e.c(this);
    com.tencent.mm.audio.mix.e.c localc = this.dge;
    com.tencent.mm.audio.mix.h.b.i("MicroMsg.Mix.AudioMixController", "onInit");
    localc.Pg();
    localc.deY.clear();
    localc.deS = new com.tencent.mm.audio.mix.e.d();
    localc.deS.init();
    if (this.dgg == null) {
      this.dgg = new m()
      {
        public final void a(w paramAnonymousw)
        {
          AppMethodBeat.i(136919);
          int j = paramAnonymousw.dlG.action;
          int i;
          if ((j == 12) || (j == 11) || (j == 10) || (j == 6)) {
            i = 1;
          }
          while (i == 0)
          {
            if (!d.this.dgk.containsKey(paramAnonymousw.dlG.ddg)) {
              break label178;
            }
            ??? = (e)d.this.dgk.get(paramAnonymousw.dlG.ddg);
            if (??? != null) {
              if (((e)???).g(new Integer[] { Integer.valueOf(j) }))
              {
                com.tencent.mm.audio.mix.h.b.e("MicroMsg.Mix.AudioMixPlayerImpl", "don't callback again");
                AppMethodBeat.o(136919);
                return;
                i = 0;
                continue;
              }
            }
            if (??? != null)
            {
              ((e)???).aO(Integer.valueOf(j));
              d.this.dgk.put(paramAnonymousw.dlG.ddg, ???);
            }
          }
          while (d.this.dgf == null)
          {
            AppMethodBeat.o(136919);
            return;
            label178:
            synchronized (d.this.dgc)
            {
              e locale = new e(Integer.valueOf(j));
              d.this.dgk.put(paramAnonymousw.dlG.ddg, locale);
            }
          }
          com.tencent.mm.audio.mix.h.b.i("MicroMsg.Mix.AudioMixPlayerImpl", "onEventChange audioId:%s, state:%s", new Object[] { paramAnonymousw.dlG.ddg, paramAnonymousw.dlG.state });
          if (j == 9)
          {
            d.this.dgf.b(paramAnonymousw);
            AppMethodBeat.o(136919);
            return;
          }
          if (j == 7)
          {
            d.this.dgf.c(paramAnonymousw);
            AppMethodBeat.o(136919);
            return;
          }
          if (j == 0)
          {
            d.this.dgf.d(paramAnonymousw);
            AppMethodBeat.o(136919);
            return;
          }
          if (j == 1)
          {
            d.this.dgf.d(paramAnonymousw);
            AppMethodBeat.o(136919);
            return;
          }
          if (j == 2)
          {
            d.this.dgf.e(paramAnonymousw);
            AppMethodBeat.o(136919);
            return;
          }
          if (j == 3)
          {
            d.this.dgj.put(paramAnonymousw.dlG.ddg, Boolean.FALSE);
            d.this.dgf.f(paramAnonymousw);
            AppMethodBeat.o(136919);
            return;
          }
          if (j == 5)
          {
            d.this.dgj.put(paramAnonymousw.dlG.ddg, Boolean.FALSE);
            d.this.dgf.g(paramAnonymousw);
            AppMethodBeat.o(136919);
            return;
          }
          if (j == 4)
          {
            d.this.dgj.put(paramAnonymousw.dlG.ddg, Boolean.FALSE);
            d.this.dgf.j(paramAnonymousw);
            AppMethodBeat.o(136919);
            return;
          }
          if (j == 10)
          {
            d.this.dgf.h(paramAnonymousw);
            AppMethodBeat.o(136919);
            return;
          }
          if (j == 6)
          {
            d.this.dgf.i(paramAnonymousw);
            AppMethodBeat.o(136919);
            return;
          }
          if (j == 11) {
            d.this.dgf.k(paramAnonymousw);
          }
          AppMethodBeat.o(136919);
        }
      };
    }
    this.mHandler = new Handler(Looper.myLooper());
    AppMethodBeat.o(136920);
  }
  
  private void Pt()
  {
    AppMethodBeat.i(136929);
    try
    {
      if (this.dgd != null)
      {
        com.tencent.mm.audio.mix.h.b.i("MicroMsg.Mix.AudioMixPlayerImpl", "stop playback thread id:%d", new Object[] { Long.valueOf(this.dgd.getId()) });
        this.dgd = null;
      }
      return;
    }
    finally
    {
      AppMethodBeat.o(136929);
    }
  }
  
  /* Error */
  private boolean createAudioTrack()
  {
    // Byte code:
    //   0: aload_0
    //   1: monitorenter
    //   2: ldc_w 270
    //   5: invokestatic 86	com/tencent/matrix/trace/core/AppMethodBeat:i	(I)V
    //   8: ldc 223
    //   10: ldc_w 271
    //   13: invokestatic 176	com/tencent/mm/audio/mix/h/b:i	(Ljava/lang/String;Ljava/lang/String;)V
    //   16: aload_0
    //   17: getfield 88	com/tencent/mm/audio/mix/f/d:channels	I
    //   20: iconst_1
    //   21: if_icmpne +180 -> 201
    //   24: iconst_4
    //   25: istore_1
    //   26: aload_0
    //   27: getfield 91	com/tencent/mm/audio/mix/f/d:sampleRate	I
    //   30: iload_1
    //   31: iconst_2
    //   32: invokestatic 275	android/media/AudioTrack:getMinBufferSize	(III)I
    //   35: istore_2
    //   36: aload_0
    //   37: iload_2
    //   38: sipush 3536
    //   41: idiv
    //   42: putfield 93	com/tencent/mm/audio/mix/f/d:dfW	I
    //   45: ldc 223
    //   47: ldc_w 277
    //   50: iconst_3
    //   51: anewarray 4	java/lang/Object
    //   54: dup
    //   55: iconst_0
    //   56: iload_2
    //   57: invokestatic 253	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
    //   60: aastore
    //   61: dup
    //   62: iconst_1
    //   63: aload_0
    //   64: getfield 88	com/tencent/mm/audio/mix/f/d:channels	I
    //   67: invokestatic 253	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
    //   70: aastore
    //   71: dup
    //   72: iconst_2
    //   73: aload_0
    //   74: getfield 91	com/tencent/mm/audio/mix/f/d:sampleRate	I
    //   77: invokestatic 253	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
    //   80: aastore
    //   81: invokestatic 240	com/tencent/mm/audio/mix/h/b:i	(Ljava/lang/String;Ljava/lang/String;[Ljava/lang/Object;)V
    //   84: aload_0
    //   85: getfield 260	com/tencent/mm/audio/mix/f/d:bfq	Landroid/media/AudioTrack;
    //   88: ifnonnull +31 -> 119
    //   91: ldc 223
    //   93: ldc_w 279
    //   96: invokestatic 281	com/tencent/mm/audio/mix/h/b:e	(Ljava/lang/String;Ljava/lang/String;)V
    //   99: aload_0
    //   100: new 262	android/media/AudioTrack
    //   103: dup
    //   104: iconst_3
    //   105: aload_0
    //   106: getfield 91	com/tencent/mm/audio/mix/f/d:sampleRate	I
    //   109: iload_1
    //   110: iconst_2
    //   111: iload_2
    //   112: iconst_1
    //   113: invokespecial 284	android/media/AudioTrack:<init>	(IIIIII)V
    //   116: putfield 260	com/tencent/mm/audio/mix/f/d:bfq	Landroid/media/AudioTrack;
    //   119: aload_0
    //   120: getfield 260	com/tencent/mm/audio/mix/f/d:bfq	Landroid/media/AudioTrack;
    //   123: ifnull +14 -> 137
    //   126: aload_0
    //   127: getfield 260	com/tencent/mm/audio/mix/f/d:bfq	Landroid/media/AudioTrack;
    //   130: invokevirtual 288	android/media/AudioTrack:getState	()I
    //   133: iconst_1
    //   134: if_icmpeq +118 -> 252
    //   137: ldc 223
    //   139: ldc_w 290
    //   142: invokestatic 281	com/tencent/mm/audio/mix/h/b:e	(Ljava/lang/String;Ljava/lang/String;)V
    //   145: aload_0
    //   146: getfield 260	com/tencent/mm/audio/mix/f/d:bfq	Landroid/media/AudioTrack;
    //   149: ifnull +40 -> 189
    //   152: ldc 223
    //   154: ldc_w 292
    //   157: iconst_1
    //   158: anewarray 4	java/lang/Object
    //   161: dup
    //   162: iconst_0
    //   163: aload_0
    //   164: getfield 260	com/tencent/mm/audio/mix/f/d:bfq	Landroid/media/AudioTrack;
    //   167: invokevirtual 288	android/media/AudioTrack:getState	()I
    //   170: invokestatic 253	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
    //   173: aastore
    //   174: invokestatic 256	com/tencent/mm/audio/mix/h/b:e	(Ljava/lang/String;Ljava/lang/String;[Ljava/lang/Object;)V
    //   177: aload_0
    //   178: getfield 260	com/tencent/mm/audio/mix/f/d:bfq	Landroid/media/AudioTrack;
    //   181: invokevirtual 295	android/media/AudioTrack:release	()V
    //   184: aload_0
    //   185: aconst_null
    //   186: putfield 260	com/tencent/mm/audio/mix/f/d:bfq	Landroid/media/AudioTrack;
    //   189: ldc_w 270
    //   192: invokestatic 216	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   195: iconst_0
    //   196: istore_3
    //   197: aload_0
    //   198: monitorexit
    //   199: iload_3
    //   200: ireturn
    //   201: bipush 12
    //   203: istore_1
    //   204: goto -178 -> 26
    //   207: astore 4
    //   209: ldc 223
    //   211: aload 4
    //   213: ldc_w 297
    //   216: iconst_0
    //   217: anewarray 4	java/lang/Object
    //   220: invokestatic 301	com/tencent/mm/audio/mix/h/b:printErrStackTrace	(Ljava/lang/String;Ljava/lang/Throwable;Ljava/lang/String;[Ljava/lang/Object;)V
    //   223: goto -104 -> 119
    //   226: astore 4
    //   228: aload_0
    //   229: monitorexit
    //   230: aload 4
    //   232: athrow
    //   233: astore 4
    //   235: ldc 223
    //   237: aload 4
    //   239: ldc_w 303
    //   242: iconst_0
    //   243: anewarray 4	java/lang/Object
    //   246: invokestatic 301	com/tencent/mm/audio/mix/h/b:printErrStackTrace	(Ljava/lang/String;Ljava/lang/Throwable;Ljava/lang/String;[Ljava/lang/Object;)V
    //   249: goto -60 -> 189
    //   252: ldc_w 270
    //   255: invokestatic 216	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   258: iconst_1
    //   259: istore_3
    //   260: goto -63 -> 197
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	263	0	this	d
    //   25	179	1	i	int
    //   35	77	2	j	int
    //   196	64	3	bool	boolean
    //   207	5	4	localIllegalArgumentException	java.lang.IllegalArgumentException
    //   226	5	4	localObject	Object
    //   233	5	4	localException	Exception
    // Exception table:
    //   from	to	target	type
    //   99	119	207	java/lang/IllegalArgumentException
    //   2	24	226	finally
    //   26	99	226	finally
    //   99	119	226	finally
    //   119	137	226	finally
    //   137	177	226	finally
    //   177	189	226	finally
    //   189	195	226	finally
    //   209	223	226	finally
    //   235	249	226	finally
    //   252	258	226	finally
    //   177	189	233	java/lang/Exception
  }
  
  public final void OR()
  {
    AppMethodBeat.i(136930);
    try
    {
      if (this.bfq != null) {
        this.bfq.setStereoVolume(0.0F, 0.0F);
      }
      AppMethodBeat.o(136930);
      return;
    }
    catch (Exception localException)
    {
      com.tencent.mm.audio.mix.h.b.printErrStackTrace("MicroMsg.Mix.AudioMixPlayerImpl", localException, "setVolume", new Object[0]);
      AppMethodBeat.o(136930);
    }
  }
  
  public final void Pr()
  {
    AppMethodBeat.i(136922);
    this.dfX.set(false);
    this.dfZ.set(true);
    this.dfY.set(false);
    Pw();
    Pt();
    AppMethodBeat.o(136922);
  }
  
  final void Ps()
  {
    AppMethodBeat.i(136928);
    try
    {
      if (this.dgd == null)
      {
        this.dgd = new Thread(this.dgy, "audio_mix_player");
        this.dgd.start();
        com.tencent.mm.audio.mix.h.b.i("MicroMsg.Mix.AudioMixPlayerImpl", "start playback thread id:%d", new Object[] { Long.valueOf(this.dgd.getId()) });
      }
      return;
    }
    finally
    {
      AppMethodBeat.o(136928);
    }
  }
  
  public final com.tencent.mm.audio.mix.a.b Pu()
  {
    AppMethodBeat.i(136931);
    synchronized (this.dgb)
    {
      for (;;)
      {
        if ((this.dga.size() == 0) || (this.dfY.get()))
        {
          boolean bool = this.dfZ.get();
          if (!bool) {
            try
            {
              com.tencent.mm.audio.mix.h.b.i("MicroMsg.Mix.AudioMixPlayerImpl", "wait play");
              OR();
              if ((this.bfq != null) && (this.bfq.getPlayState() == 3)) {
                this.bfq.stop();
              }
              this.dgb.wait();
              this.dgx = 0;
            }
            catch (InterruptedException localInterruptedException)
            {
              com.tencent.mm.audio.mix.h.b.printErrStackTrace("MicroMsg.Mix.AudioMixPlayerImpl", localInterruptedException, "waitPlay", new Object[0]);
            }
          }
        }
      }
    }
    com.tencent.mm.audio.mix.a.b localb = (com.tencent.mm.audio.mix.a.b)this.dga.poll();
    this.dgb.notifyAll();
    AppMethodBeat.o(136931);
    return localb;
  }
  
  public final void Pv()
  {
    AppMethodBeat.i(136932);
    this.dga.clear();
    AppMethodBeat.o(136932);
  }
  
  public final void Pw()
  {
    AppMethodBeat.i(136933);
    synchronized (this.dgb)
    {
      com.tencent.mm.audio.mix.h.b.i("MicroMsg.Mix.AudioMixPlayerImpl", "sync notify");
      try
      {
        this.dgb.notifyAll();
        AppMethodBeat.o(136933);
        return;
      }
      catch (Exception localException)
      {
        for (;;)
        {
          com.tencent.mm.audio.mix.h.b.printErrStackTrace("MicroMsg.Mix.AudioMixPlayerImpl", localException, "syncNotify", new Object[0]);
        }
      }
    }
  }
  
  public final int Px()
  {
    int i = 0;
    AppMethodBeat.i(136940);
    label168:
    label172:
    for (;;)
    {
      synchronized (this.dgc)
      {
        Object localObject2 = this.dgk.keySet();
        Object localObject4 = new ArrayList();
        ((ArrayList)localObject4).addAll((Collection)localObject2);
        localObject2 = ((ArrayList)localObject4).iterator();
        if (((Iterator)localObject2).hasNext())
        {
          localObject4 = (String)((Iterator)localObject2).next();
          localObject4 = (e)this.dgk.get(localObject4);
          if (localObject4 != null)
          {
            if (((e)localObject4).g(new Integer[] { Integer.valueOf(0) })) {
              break label168;
            }
            if (((e)localObject4).g(new Integer[] { Integer.valueOf(1) })) {
              break label168;
            }
            if (((e)localObject4).g(new Integer[] { Integer.valueOf(2) })) {
              break label168;
            }
          }
        }
        else
        {
          AppMethodBeat.o(136940);
          return i;
        }
      }
      break label172;
      i += 1;
    }
  }
  
  public final ArrayList<String> Py()
  {
    AppMethodBeat.i(136941);
    this.dgm.clear();
    this.dgz.clear();
    synchronized (this.dgc)
    {
      Object localObject2 = this.dgk.keySet();
      this.dgz.addAll((Collection)localObject2);
      localObject2 = this.dgz.iterator();
      while (((Iterator)localObject2).hasNext())
      {
        String str = (String)((Iterator)localObject2).next();
        e locale = (e)this.dgk.get(str);
        if (locale != null) {
          if (locale.g(new Integer[] { Integer.valueOf(2) })) {
            this.dgm.add(str);
          }
        }
      }
    }
    ??? = this.dgm;
    AppMethodBeat.o(136941);
    return ???;
  }
  
  public final void a(int paramInt1, String paramString1, int paramInt2, String paramString2)
  {
    AppMethodBeat.i(136939);
    com.tencent.mm.ai.b localb = (com.tencent.mm.ai.b)this.deg.get(paramString1);
    if (localb == null)
    {
      AppMethodBeat.o(136939);
      return;
    }
    w localw = new w();
    localw.dlG.ddg = paramString1;
    localw.dlG.action = paramInt1;
    localw.dlG.appId = localb.appId;
    localw.dlG.errCode = paramInt2;
    localw.dlG.errMsg = paramString2;
    localw.dlG.state = w.ig(paramInt1);
    if (this.dgg != null) {
      this.dgg.a(localw);
    }
    AppMethodBeat.o(136939);
  }
  
  public final void clearCache()
  {
    AppMethodBeat.i(136921);
    this.dge.clearCache();
    this.deg.clear();
    this.dgi.clear();
    this.dgj.clear();
    synchronized (this.dgc)
    {
      this.dgk.clear();
      this.dgl.clear();
      this.dfe.clear();
      AppMethodBeat.o(136921);
      return;
    }
  }
  
  public final void f(int paramInt, String paramString1, String paramString2)
  {
    AppMethodBeat.i(136938);
    com.tencent.mm.ai.b localb = (com.tencent.mm.ai.b)this.deg.get(paramString1);
    if (localb == null)
    {
      AppMethodBeat.o(136938);
      return;
    }
    w localw = new w();
    localw.dlG.ddg = paramString1;
    localw.dlG.action = paramInt;
    localw.dlG.appId = localb.appId;
    paramString1 = paramString2;
    if (TextUtils.isEmpty(paramString2)) {
      paramString1 = localb.der;
    }
    localw.dlG.der = paramString1;
    localw.dlG.state = w.ig(paramInt);
    if (this.dgg != null) {
      this.dgg.a(localw);
    }
    AppMethodBeat.o(136938);
  }
  
  public final boolean fY(String paramString)
  {
    AppMethodBeat.i(136925);
    if (this.dgk.containsKey(paramString))
    {
      e locale = (e)this.dgk.get(paramString);
      if (locale != null) {
        if ((locale.g(new Integer[] { Integer.valueOf(0) })) && (!this.dge.OG()))
        {
          AppMethodBeat.o(136925);
          return true;
        }
      }
      if ((!this.dge.OG()) && (!this.dge.gd(paramString)) && (this.dfR.fY(paramString)))
      {
        AppMethodBeat.o(136925);
        return true;
      }
    }
    AppMethodBeat.o(136925);
    return false;
  }
  
  public final int gA(String paramString)
  {
    AppMethodBeat.i(136936);
    if (!this.dgk.containsKey(paramString))
    {
      AppMethodBeat.o(136936);
      return -1;
    }
    paramString = (e)this.dgk.get(paramString);
    if (paramString != null)
    {
      int i = ((Integer)paramString.get()).intValue();
      AppMethodBeat.o(136936);
      return i;
    }
    AppMethodBeat.o(136936);
    return -1;
  }
  
  public final com.tencent.mm.ai.b gk(String paramString)
  {
    AppMethodBeat.i(136923);
    if (this.deg.containsKey(paramString))
    {
      paramString = (com.tencent.mm.ai.b)this.deg.get(paramString);
      AppMethodBeat.o(136923);
      return paramString;
    }
    AppMethodBeat.o(136923);
    return null;
  }
  
  public final void gp(String paramString)
  {
    AppMethodBeat.i(136924);
    this.dge.gc(paramString);
    synchronized (this.dgc)
    {
      this.dfe.remove(paramString);
      this.dgi.remove(paramString);
      this.dgj.put(paramString, Boolean.FALSE);
      if (this.dfR.fX(paramString)) {
        o(3, paramString);
      }
      AppMethodBeat.o(136924);
      return;
    }
  }
  
  public final int gu(String paramString)
  {
    AppMethodBeat.i(136927);
    if (this.deg.containsKey(paramString))
    {
      paramString = (com.tencent.mm.ai.b)this.deg.get(paramString);
      if (paramString == null)
      {
        AppMethodBeat.o(136927);
        return 0;
      }
      paramString = paramString.filePath;
      if (TextUtils.isEmpty(paramString))
      {
        AppMethodBeat.o(136927);
        return 0;
      }
      paramString = com.tencent.mm.audio.mix.b.e.Os().fP(paramString);
      if (paramString != null)
      {
        int i = (int)paramString.duration;
        AppMethodBeat.o(136927);
        return i;
      }
    }
    AppMethodBeat.o(136927);
    return 0;
  }
  
  public final int gz(String paramString)
  {
    AppMethodBeat.i(136926);
    if (this.deg.containsKey(paramString))
    {
      com.tencent.mm.ai.b localb = (com.tencent.mm.ai.b)this.deg.get(paramString);
      if (localb == null)
      {
        AppMethodBeat.o(136926);
        return 0;
      }
      int i;
      label72:
      int j;
      if (localb.ddd)
      {
        i = (int)this.dge.gf(paramString);
        if (i == -1) {
          break label100;
        }
        localb.dlC = i;
        if (i != -1) {
          break label109;
        }
        j = 0;
      }
      for (;;)
      {
        AppMethodBeat.o(136926);
        return j;
        i = (int)this.dfR.fZ(paramString);
        break;
        label100:
        i = localb.dlC;
        break label72;
        label109:
        int k = gu(paramString);
        if (k > 0)
        {
          j = k;
          if (i > k) {}
        }
        else
        {
          j = i;
        }
      }
    }
    AppMethodBeat.o(136926);
    return 0;
  }
  
  public final void o(int paramInt, String paramString)
  {
    AppMethodBeat.i(136937);
    f(paramInt, paramString, this.dge.gj(paramString));
    AppMethodBeat.o(136937);
  }
  
  final void releaseAudioTrack()
  {
    try
    {
      AppMethodBeat.i(136935);
      try
      {
        if (this.bfq != null)
        {
          this.bfq.flush();
          this.bfq.stop();
          this.bfq.release();
          this.bfq = null;
        }
        AppMethodBeat.o(136935);
      }
      catch (Exception localException)
      {
        for (;;)
        {
          com.tencent.mm.audio.mix.h.b.printErrStackTrace("MicroMsg.Mix.AudioMixPlayerImpl", localException, "releaseAudioTrack", new Object[0]);
          AppMethodBeat.o(136935);
        }
      }
      return;
    }
    finally {}
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.audio.mix.f.d
 * JD-Core Version:    0.7.0.1
 */