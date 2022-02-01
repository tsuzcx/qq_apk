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
  volatile HashMap<String, com.tencent.mm.aj.b> dde;
  public com.tencent.mm.audio.mix.d.a deP;
  private int deU;
  public AtomicBoolean deV;
  AtomicBoolean deW;
  public AtomicBoolean deX;
  public Queue<com.tencent.mm.audio.mix.a.b> deY;
  public Object deZ;
  volatile HashMap<String, Boolean> dec;
  Object dfa;
  private Thread dfb;
  public com.tencent.mm.audio.mix.e.c dfc;
  b dfd;
  private m dfe;
  public g dff;
  volatile HashMap<String, Boolean> dfg;
  volatile HashMap<String, Boolean> dfh;
  volatile HashMap<String, e<Integer>> dfi;
  volatile HashMap<String, com.tencent.mm.aj.d> dfj;
  private ArrayList<String> dfk;
  private volatile HashMap<String, Long> dfl;
  private volatile HashMap<String, Integer> dfm;
  private volatile HashMap<String, Integer> dfn;
  private volatile HashMap<String, Integer> dfo;
  private volatile HashMap<String, Integer> dfp;
  private volatile HashMap<String, Integer> dfq;
  private byte[] dfr;
  byte[] dfs;
  private short dft;
  volatile boolean dfu;
  int dfv;
  private Runnable dfw;
  ArrayList<String> dfx;
  Handler mHandler;
  private int sampleRate;
  
  public d()
  {
    AppMethodBeat.i(136920);
    this.channels = 2;
    this.sampleRate = 44100;
    this.deU = 4;
    this.deV = new AtomicBoolean(false);
    this.deW = new AtomicBoolean(false);
    this.deX = new AtomicBoolean(true);
    this.deY = new ArrayDeque();
    this.deZ = new Object();
    this.dfa = new Object();
    this.dde = new HashMap();
    this.dfg = new HashMap();
    this.dfh = new HashMap();
    this.dfi = new HashMap();
    this.dfj = new HashMap();
    this.dec = new HashMap();
    this.dfk = new ArrayList();
    this.dfl = new HashMap();
    this.dfm = new HashMap();
    this.dfn = new HashMap();
    this.dfo = new HashMap();
    this.dfp = new HashMap();
    this.dfq = new HashMap();
    this.dfr = new byte[3536];
    this.dfs = new byte[2];
    this.dft = 0;
    this.dfu = false;
    this.dfv = 0;
    this.dfw = new Runnable()
    {
      public final void run()
      {
        AppMethodBeat.i(136917);
        Process.setThreadPriority(-19);
        if (d.this.deX.get())
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
          if (!d.this.deX.get())
          {
            d locald1 = d.this;
            synchronized (locald1.deZ)
            {
              for (;;)
              {
                if ((locald1.deW.get()) && (!locald1.deX.get()))
                {
                  com.tencent.mm.audio.mix.h.b.i("MicroMsg.Mix.AudioMixPlayerImpl", "waitPlay");
                  try
                  {
                    locald1.deZ.wait();
                  }
                  catch (Exception localException)
                  {
                    com.tencent.mm.audio.mix.h.b.printErrStackTrace("MicroMsg.Mix.AudioMixPlayerImpl", localException, "waitPlay", new Object[0]);
                  }
                }
              }
            }
            if (d.this.deX.get()) {
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
          ??? = d.this.Pw();
        } while (??? == null);
        Object localObject3 = ((com.tencent.mm.audio.mix.a.b)???).dbX;
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
          ((d)???).dfv += 1;
          locald2 = d.this;
          Iterator localIterator = ((com.tencent.mm.audio.mix.a.b)???).dbY.iterator();
          for (;;)
          {
            if (!localIterator.hasNext()) {
              break label500;
            }
            str = (String)localIterator.next();
            synchronized (locald2.dfa)
            {
              if (!TextUtils.isEmpty(str)) {
                if ((!locald2.dec.containsKey(str)) || (!((Boolean)locald2.dec.get(str)).booleanValue())) {
                  break;
                }
              }
            }
          }
          if (!locald2.dec.containsKey(str)) {
            break label831;
          }
          locald2.dec.put(str, Boolean.TRUE);
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
            if (d.this.dfc.Pf())
            {
              com.tencent.mm.audio.mix.h.b.i("MicroMsg.Mix.AudioMixPlayerImpl", "isMute");
              d.this.bfq.setStereoVolume(0.0F, 0.0F);
            }
          }
          for (i = d.this.bfq.write((byte[])localObject3, 0, localObject3.length);; i = 0)
          {
            l = System.currentTimeMillis() - l;
            if (l > 100L) {
              com.tencent.mm.audio.mix.h.b.e("MicroMsg.Mix.AudioMixPlayerImpl", "write audio track after writeSize:%d, time:%d, writeCount:%d", new Object[] { Integer.valueOf(i), Long.valueOf(l), Integer.valueOf(d.this.dfv) });
            }
            if (i < 0) {
              com.tencent.mm.audio.mix.h.b.e("MicroMsg.Mix.AudioMixPlayerImpl", "write audio track buffer failed, Size:%d", new Object[] { Integer.valueOf(i) });
            }
            if (d.this.deY.size() == 0)
            {
              d.this.dfs[0] = localObject3[(localObject3.length - 2)];
              d.this.dfs[1] = localObject3[(localObject3.length - 1)];
            }
            localObject3 = d.this;
            if ((((d)localObject3).dfd != null) && (((d)localObject3).dfu))
            {
              ??? = com.tencent.mm.audio.mix.b.b.Oo().Op();
              if (??? != null)
              {
                if ((((com.tencent.mm.audio.mix.a.c)???).dbX == null) || (((com.tencent.mm.audio.mix.a.c)???).dbX.length < localb.dbX.length)) {
                  ((com.tencent.mm.audio.mix.a.c)???).dbX = new byte[localb.dbX.length];
                }
                System.arraycopy(localb.dbX, 0, ((com.tencent.mm.audio.mix.a.c)???).dbX, 0, localb.dbX.length);
                ((d)localObject3).mHandler.post(new d.4((d)localObject3, (com.tencent.mm.audio.mix.a.c)???));
              }
            }
            com.tencent.mm.audio.mix.b.a.Om().a(localb);
            break;
            d.this.bfq.setStereoVolume(1.0F, 1.0F);
            break label547;
          }
        }
      }
    };
    this.dfx = new ArrayList();
    this.dfc = new com.tencent.mm.audio.mix.e.c(this);
    com.tencent.mm.audio.mix.e.c localc = this.dfc;
    com.tencent.mm.audio.mix.h.b.i("MicroMsg.Mix.AudioMixController", "onInit");
    localc.Pi();
    localc.ddW.clear();
    localc.ddQ = new com.tencent.mm.audio.mix.e.d();
    localc.ddQ.init();
    if (this.dfe == null) {
      this.dfe = new m()
      {
        public final void a(w paramAnonymousw)
        {
          AppMethodBeat.i(136919);
          int j = paramAnonymousw.dkE.action;
          int i;
          if ((j == 12) || (j == 11) || (j == 10) || (j == 6)) {
            i = 1;
          }
          while (i == 0)
          {
            if (!d.this.dfi.containsKey(paramAnonymousw.dkE.dce)) {
              break label178;
            }
            ??? = (e)d.this.dfi.get(paramAnonymousw.dkE.dce);
            if (??? != null) {
              if (((e)???).h(new Integer[] { Integer.valueOf(j) }))
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
              d.this.dfi.put(paramAnonymousw.dkE.dce, ???);
            }
          }
          while (d.this.dfd == null)
          {
            AppMethodBeat.o(136919);
            return;
            label178:
            synchronized (d.this.dfa)
            {
              e locale = new e(Integer.valueOf(j));
              d.this.dfi.put(paramAnonymousw.dkE.dce, locale);
            }
          }
          com.tencent.mm.audio.mix.h.b.i("MicroMsg.Mix.AudioMixPlayerImpl", "onEventChange audioId:%s, state:%s", new Object[] { paramAnonymousw.dkE.dce, paramAnonymousw.dkE.state });
          if (j == 9)
          {
            d.this.dfd.b(paramAnonymousw);
            AppMethodBeat.o(136919);
            return;
          }
          if (j == 7)
          {
            d.this.dfd.c(paramAnonymousw);
            AppMethodBeat.o(136919);
            return;
          }
          if (j == 0)
          {
            d.this.dfd.d(paramAnonymousw);
            AppMethodBeat.o(136919);
            return;
          }
          if (j == 1)
          {
            d.this.dfd.d(paramAnonymousw);
            AppMethodBeat.o(136919);
            return;
          }
          if (j == 2)
          {
            d.this.dfd.e(paramAnonymousw);
            AppMethodBeat.o(136919);
            return;
          }
          if (j == 3)
          {
            d.this.dfh.put(paramAnonymousw.dkE.dce, Boolean.FALSE);
            d.this.dfd.f(paramAnonymousw);
            AppMethodBeat.o(136919);
            return;
          }
          if (j == 5)
          {
            d.this.dfh.put(paramAnonymousw.dkE.dce, Boolean.FALSE);
            d.this.dfd.g(paramAnonymousw);
            AppMethodBeat.o(136919);
            return;
          }
          if (j == 4)
          {
            d.this.dfh.put(paramAnonymousw.dkE.dce, Boolean.FALSE);
            d.this.dfd.j(paramAnonymousw);
            AppMethodBeat.o(136919);
            return;
          }
          if (j == 10)
          {
            d.this.dfd.h(paramAnonymousw);
            AppMethodBeat.o(136919);
            return;
          }
          if (j == 6)
          {
            d.this.dfd.i(paramAnonymousw);
            AppMethodBeat.o(136919);
            return;
          }
          if (j == 11) {
            d.this.dfd.k(paramAnonymousw);
          }
          AppMethodBeat.o(136919);
        }
      };
    }
    this.mHandler = new Handler(Looper.myLooper());
    AppMethodBeat.o(136920);
  }
  
  private void Pv()
  {
    AppMethodBeat.i(136929);
    try
    {
      if (this.dfb != null)
      {
        com.tencent.mm.audio.mix.h.b.i("MicroMsg.Mix.AudioMixPlayerImpl", "stop playback thread id:%d", new Object[] { Long.valueOf(this.dfb.getId()) });
        this.dfb = null;
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
    //   42: putfield 93	com/tencent/mm/audio/mix/f/d:deU	I
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
  
  public final void OT()
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
  
  public final ArrayList<String> PA()
  {
    AppMethodBeat.i(136941);
    this.dfk.clear();
    this.dfx.clear();
    synchronized (this.dfa)
    {
      Object localObject2 = this.dfi.keySet();
      this.dfx.addAll((Collection)localObject2);
      localObject2 = this.dfx.iterator();
      while (((Iterator)localObject2).hasNext())
      {
        String str = (String)((Iterator)localObject2).next();
        e locale = (e)this.dfi.get(str);
        if (locale != null) {
          if (locale.h(new Integer[] { Integer.valueOf(2) })) {
            this.dfk.add(str);
          }
        }
      }
    }
    ??? = this.dfk;
    AppMethodBeat.o(136941);
    return ???;
  }
  
  public final void Pt()
  {
    AppMethodBeat.i(136922);
    this.deV.set(false);
    this.deX.set(true);
    this.deW.set(false);
    Py();
    Pv();
    AppMethodBeat.o(136922);
  }
  
  final void Pu()
  {
    AppMethodBeat.i(136928);
    try
    {
      if (this.dfb == null)
      {
        this.dfb = new Thread(this.dfw, "audio_mix_player");
        this.dfb.start();
        com.tencent.mm.audio.mix.h.b.i("MicroMsg.Mix.AudioMixPlayerImpl", "start playback thread id:%d", new Object[] { Long.valueOf(this.dfb.getId()) });
      }
      return;
    }
    finally
    {
      AppMethodBeat.o(136928);
    }
  }
  
  public final com.tencent.mm.audio.mix.a.b Pw()
  {
    AppMethodBeat.i(136931);
    synchronized (this.deZ)
    {
      for (;;)
      {
        if ((this.deY.size() == 0) || (this.deW.get()))
        {
          boolean bool = this.deX.get();
          if (!bool) {
            try
            {
              com.tencent.mm.audio.mix.h.b.i("MicroMsg.Mix.AudioMixPlayerImpl", "wait play");
              OT();
              if ((this.bfq != null) && (this.bfq.getPlayState() == 3)) {
                this.bfq.stop();
              }
              this.deZ.wait();
              this.dfv = 0;
            }
            catch (InterruptedException localInterruptedException)
            {
              com.tencent.mm.audio.mix.h.b.printErrStackTrace("MicroMsg.Mix.AudioMixPlayerImpl", localInterruptedException, "waitPlay", new Object[0]);
            }
          }
        }
      }
    }
    com.tencent.mm.audio.mix.a.b localb = (com.tencent.mm.audio.mix.a.b)this.deY.poll();
    this.deZ.notifyAll();
    AppMethodBeat.o(136931);
    return localb;
  }
  
  public final void Px()
  {
    AppMethodBeat.i(136932);
    this.deY.clear();
    AppMethodBeat.o(136932);
  }
  
  public final void Py()
  {
    AppMethodBeat.i(136933);
    synchronized (this.deZ)
    {
      com.tencent.mm.audio.mix.h.b.i("MicroMsg.Mix.AudioMixPlayerImpl", "sync notify");
      try
      {
        this.deZ.notifyAll();
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
  
  public final int Pz()
  {
    int i = 0;
    AppMethodBeat.i(136940);
    label168:
    label172:
    for (;;)
    {
      synchronized (this.dfa)
      {
        Object localObject2 = this.dfi.keySet();
        Object localObject4 = new ArrayList();
        ((ArrayList)localObject4).addAll((Collection)localObject2);
        localObject2 = ((ArrayList)localObject4).iterator();
        if (((Iterator)localObject2).hasNext())
        {
          localObject4 = (String)((Iterator)localObject2).next();
          localObject4 = (e)this.dfi.get(localObject4);
          if (localObject4 != null)
          {
            if (((e)localObject4).h(new Integer[] { Integer.valueOf(0) })) {
              break label168;
            }
            if (((e)localObject4).h(new Integer[] { Integer.valueOf(1) })) {
              break label168;
            }
            if (((e)localObject4).h(new Integer[] { Integer.valueOf(2) })) {
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
  
  public final void a(int paramInt1, String paramString1, int paramInt2, String paramString2)
  {
    AppMethodBeat.i(136939);
    com.tencent.mm.aj.b localb = (com.tencent.mm.aj.b)this.dde.get(paramString1);
    if (localb == null)
    {
      AppMethodBeat.o(136939);
      return;
    }
    w localw = new w();
    localw.dkE.dce = paramString1;
    localw.dkE.action = paramInt1;
    localw.dkE.appId = localb.appId;
    localw.dkE.errCode = paramInt2;
    localw.dkE.errMsg = paramString2;
    localw.dkE.state = w.ie(paramInt1);
    if (this.dfe != null) {
      this.dfe.a(localw);
    }
    AppMethodBeat.o(136939);
  }
  
  public final void clearCache()
  {
    AppMethodBeat.i(136921);
    this.dfc.clearCache();
    this.dde.clear();
    this.dfg.clear();
    this.dfh.clear();
    synchronized (this.dfa)
    {
      this.dfi.clear();
      this.dfj.clear();
      this.dec.clear();
      AppMethodBeat.o(136921);
      return;
    }
  }
  
  public final void f(int paramInt, String paramString1, String paramString2)
  {
    AppMethodBeat.i(136938);
    com.tencent.mm.aj.b localb = (com.tencent.mm.aj.b)this.dde.get(paramString1);
    if (localb == null)
    {
      AppMethodBeat.o(136938);
      return;
    }
    w localw = new w();
    localw.dkE.dce = paramString1;
    localw.dkE.action = paramInt;
    localw.dkE.appId = localb.appId;
    paramString1 = paramString2;
    if (TextUtils.isEmpty(paramString2)) {
      paramString1 = localb.ddp;
    }
    localw.dkE.ddp = paramString1;
    localw.dkE.state = w.ie(paramInt);
    if (this.dfe != null) {
      this.dfe.a(localw);
    }
    AppMethodBeat.o(136938);
  }
  
  public final boolean fS(String paramString)
  {
    AppMethodBeat.i(136925);
    if (this.dfi.containsKey(paramString))
    {
      e locale = (e)this.dfi.get(paramString);
      if (locale != null) {
        if ((locale.h(new Integer[] { Integer.valueOf(0) })) && (!this.dfc.OI()))
        {
          AppMethodBeat.o(136925);
          return true;
        }
      }
      if ((!this.dfc.OI()) && (!this.dfc.fX(paramString)) && (this.deP.fS(paramString)))
      {
        AppMethodBeat.o(136925);
        return true;
      }
    }
    AppMethodBeat.o(136925);
    return false;
  }
  
  public final com.tencent.mm.aj.b ge(String paramString)
  {
    AppMethodBeat.i(136923);
    if (this.dde.containsKey(paramString))
    {
      paramString = (com.tencent.mm.aj.b)this.dde.get(paramString);
      AppMethodBeat.o(136923);
      return paramString;
    }
    AppMethodBeat.o(136923);
    return null;
  }
  
  public final void gj(String paramString)
  {
    AppMethodBeat.i(136924);
    this.dfc.fW(paramString);
    synchronized (this.dfa)
    {
      this.dec.remove(paramString);
      this.dfg.remove(paramString);
      this.dfh.put(paramString, Boolean.FALSE);
      if (this.deP.fR(paramString)) {
        o(3, paramString);
      }
      AppMethodBeat.o(136924);
      return;
    }
  }
  
  public final int go(String paramString)
  {
    AppMethodBeat.i(136927);
    if (this.dde.containsKey(paramString))
    {
      paramString = (com.tencent.mm.aj.b)this.dde.get(paramString);
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
      paramString = com.tencent.mm.audio.mix.b.e.Ou().fJ(paramString);
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
  
  public final int gt(String paramString)
  {
    AppMethodBeat.i(136926);
    if (this.dde.containsKey(paramString))
    {
      com.tencent.mm.aj.b localb = (com.tencent.mm.aj.b)this.dde.get(paramString);
      if (localb == null)
      {
        AppMethodBeat.o(136926);
        return 0;
      }
      int i;
      label72:
      int j;
      if (localb.dcb)
      {
        i = (int)this.dfc.fZ(paramString);
        if (i == -1) {
          break label100;
        }
        localb.dkA = i;
        if (i != -1) {
          break label109;
        }
        j = 0;
      }
      for (;;)
      {
        AppMethodBeat.o(136926);
        return j;
        i = (int)this.deP.fT(paramString);
        break;
        label100:
        i = localb.dkA;
        break label72;
        label109:
        int k = go(paramString);
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
  
  public final int gu(String paramString)
  {
    AppMethodBeat.i(136936);
    if (!this.dfi.containsKey(paramString))
    {
      AppMethodBeat.o(136936);
      return -1;
    }
    paramString = (e)this.dfi.get(paramString);
    if (paramString != null)
    {
      int i = ((Integer)paramString.get()).intValue();
      AppMethodBeat.o(136936);
      return i;
    }
    AppMethodBeat.o(136936);
    return -1;
  }
  
  public final void o(int paramInt, String paramString)
  {
    AppMethodBeat.i(136937);
    f(paramInt, paramString, this.dfc.gd(paramString));
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


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.audio.mix.f.d
 * JD-Core Version:    0.7.0.1
 */