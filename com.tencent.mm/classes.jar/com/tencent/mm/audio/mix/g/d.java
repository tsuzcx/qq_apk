package com.tencent.mm.audio.mix.g;

import android.media.AudioTrack;
import android.os.Handler;
import android.os.Looper;
import android.os.Process;
import android.text.TextUtils;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.audio.mix.b.f;
import com.tencent.mm.audio.mix.d.a;
import com.tencent.mm.audio.mix.d.n;
import com.tencent.mm.audio.mix.f.i;
import com.tencent.mm.g.a.y;
import com.tencent.mm.g.a.y.a;
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
  AudioTrack bfn;
  private int channels;
  volatile HashMap<String, com.tencent.mm.ai.b> dvc;
  volatile HashMap<String, Boolean> dwo;
  private volatile HashMap<String, Integer> dxA;
  private volatile HashMap<String, Integer> dxB;
  private volatile HashMap<String, Integer> dxC;
  private byte[] dxD;
  byte[] dxE;
  private short dxF;
  volatile boolean dxG;
  int dxH;
  private Runnable dxI;
  ArrayList<String> dxJ;
  public a dxb;
  private int dxg;
  public AtomicBoolean dxh;
  AtomicBoolean dxi;
  public AtomicBoolean dxj;
  public Queue<com.tencent.mm.audio.mix.a.b> dxk;
  public Object dxl;
  Object dxm;
  private Thread dxn;
  public com.tencent.mm.audio.mix.f.c dxo;
  b dxp;
  private n dxq;
  public g dxr;
  volatile HashMap<String, Boolean> dxs;
  volatile HashMap<String, Boolean> dxt;
  volatile HashMap<String, e<Integer>> dxu;
  volatile HashMap<String, com.tencent.mm.ai.d> dxv;
  private ArrayList<String> dxw;
  private volatile HashMap<String, Long> dxx;
  private volatile HashMap<String, Integer> dxy;
  private volatile HashMap<String, Integer> dxz;
  Handler mHandler;
  private int sampleRate;
  
  public d()
  {
    AppMethodBeat.i(136920);
    this.channels = 2;
    this.sampleRate = 44100;
    this.dxg = 4;
    this.dxh = new AtomicBoolean(false);
    this.dxi = new AtomicBoolean(false);
    this.dxj = new AtomicBoolean(true);
    this.dxk = new ArrayDeque();
    this.dxl = new Object();
    this.dxm = new Object();
    this.dvc = new HashMap();
    this.dxs = new HashMap();
    this.dxt = new HashMap();
    this.dxu = new HashMap();
    this.dxv = new HashMap();
    this.dwo = new HashMap();
    this.dxw = new ArrayList();
    this.dxx = new HashMap();
    this.dxy = new HashMap();
    this.dxz = new HashMap();
    this.dxA = new HashMap();
    this.dxB = new HashMap();
    this.dxC = new HashMap();
    this.dxD = new byte[3536];
    this.dxE = new byte[2];
    this.dxF = 0;
    this.dxG = false;
    this.dxH = 0;
    this.dxI = new Runnable()
    {
      public final void run()
      {
        AppMethodBeat.i(136917);
        Process.setThreadPriority(-19);
        if (d.this.dxj.get())
        {
          com.tencent.mm.audio.mix.i.b.e("MicroMsg.Mix.AudioMixPlayerImpl", "stop and exit");
          AppMethodBeat.o(136917);
          return;
        }
        if (d.this.bfn == null) {
          d.a(d.this);
        }
        com.tencent.mm.audio.mix.i.b.i("MicroMsg.Mix.AudioMixPlayerImpl", "playback start");
        do
        {
          if (!d.this.dxj.get())
          {
            d locald1 = d.this;
            synchronized (locald1.dxl)
            {
              for (;;)
              {
                if ((locald1.dxi.get()) && (!locald1.dxj.get()))
                {
                  com.tencent.mm.audio.mix.i.b.i("MicroMsg.Mix.AudioMixPlayerImpl", "waitPlay");
                  try
                  {
                    locald1.dxl.wait();
                  }
                  catch (Exception localException)
                  {
                    com.tencent.mm.audio.mix.i.b.printErrStackTrace("MicroMsg.Mix.AudioMixPlayerImpl", localException, "waitPlay", new Object[0]);
                  }
                }
              }
            }
            if (d.this.dxj.get()) {
              com.tencent.mm.audio.mix.i.b.e("MicroMsg.Mix.AudioMixPlayerImpl", "playback break");
            }
          }
          else
          {
            d.this.releaseAudioTrack();
            com.tencent.mm.audio.mix.i.b.i("MicroMsg.Mix.AudioMixPlayerImpl", "release AudioTrack and exit playback thread id:%d", new Object[] { Long.valueOf(Thread.currentThread().getId()) });
            AppMethodBeat.o(136917);
            return;
          }
          ??? = d.this.ZO();
        } while (??? == null);
        Object localObject3 = ((com.tencent.mm.audio.mix.a.b)???).dtQ;
        if (d.this.bfn == null) {
          d.a(d.this);
        }
        d locald2;
        label350:
        String str;
        if ((localObject3 != null) && (localObject3.length > 0))
        {
          if ((d.this.bfn != null) && ((d.this.bfn.getPlayState() == 1) || (d.this.bfn.getPlayState() == 2))) {
            d.this.bfn.play();
          }
          ??? = d.this;
          ((d)???).dxH += 1;
          locald2 = d.this;
          Iterator localIterator = ((com.tencent.mm.audio.mix.a.b)???).dtR.iterator();
          for (;;)
          {
            if (!localIterator.hasNext()) {
              break label500;
            }
            str = (String)localIterator.next();
            synchronized (locald2.dxm)
            {
              if (!TextUtils.isEmpty(str)) {
                if ((!locald2.dwo.containsKey(str)) || (!((Boolean)locald2.dwo.get(str)).booleanValue())) {
                  break;
                }
              }
            }
          }
          if (!locald2.dwo.containsKey(str)) {
            break label831;
          }
          locald2.dwo.put(str, Boolean.TRUE);
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
          if (d.this.bfn != null) {
            if (d.this.dxo.Zx())
            {
              com.tencent.mm.audio.mix.i.b.i("MicroMsg.Mix.AudioMixPlayerImpl", "isMute");
              d.this.bfn.setStereoVolume(0.0F, 0.0F);
            }
          }
          for (i = d.this.bfn.write((byte[])localObject3, 0, localObject3.length);; i = 0)
          {
            l = System.currentTimeMillis() - l;
            if (l > 100L) {
              com.tencent.mm.audio.mix.i.b.e("MicroMsg.Mix.AudioMixPlayerImpl", "write audio track after writeSize:%d, time:%d, writeCount:%d", new Object[] { Integer.valueOf(i), Long.valueOf(l), Integer.valueOf(d.this.dxH) });
            }
            if (i < 0) {
              com.tencent.mm.audio.mix.i.b.e("MicroMsg.Mix.AudioMixPlayerImpl", "write audio track buffer failed, Size:%d", new Object[] { Integer.valueOf(i) });
            }
            if (d.this.dxk.size() == 0)
            {
              d.this.dxE[0] = localObject3[(localObject3.length - 2)];
              d.this.dxE[1] = localObject3[(localObject3.length - 1)];
            }
            localObject3 = d.this;
            if ((((d)localObject3).dxp != null) && (((d)localObject3).dxG))
            {
              ??? = com.tencent.mm.audio.mix.b.c.YF().YG();
              if (??? != null)
              {
                if ((((com.tencent.mm.audio.mix.a.c)???).dtQ == null) || (((com.tencent.mm.audio.mix.a.c)???).dtQ.length < localb.dtQ.length)) {
                  ((com.tencent.mm.audio.mix.a.c)???).dtQ = new byte[localb.dtQ.length];
                }
                System.arraycopy(localb.dtQ, 0, ((com.tencent.mm.audio.mix.a.c)???).dtQ, 0, localb.dtQ.length);
                ((d)localObject3).mHandler.post(new d.4((d)localObject3, (com.tencent.mm.audio.mix.a.c)???));
              }
            }
            com.tencent.mm.audio.mix.b.b.YD().a(localb);
            break;
            d.this.bfn.setStereoVolume(1.0F, 1.0F);
            break label547;
          }
        }
      }
    };
    this.dxJ = new ArrayList();
    this.dxo = new com.tencent.mm.audio.mix.f.c(this);
    com.tencent.mm.audio.mix.f.c localc = this.dxo;
    com.tencent.mm.audio.mix.i.b.i("MicroMsg.Mix.AudioMixController", "onInit");
    localc.ZA();
    localc.dwi.clear();
    localc.dwc = new com.tencent.mm.audio.mix.f.d();
    localc.dwc.init();
    if (this.dxq == null) {
      this.dxq = new n()
      {
        public final void a(y paramAnonymousy)
        {
          AppMethodBeat.i(136919);
          int j = paramAnonymousy.dCW.action;
          int i;
          if ((j == 12) || (j == 11) || (j == 10) || (j == 6)) {
            i = 1;
          }
          while (i == 0)
          {
            if (!d.this.dxu.containsKey(paramAnonymousy.dCW.dtX)) {
              break label178;
            }
            ??? = (e)d.this.dxu.get(paramAnonymousy.dCW.dtX);
            if (??? != null) {
              if (((e)???).f(new Integer[] { Integer.valueOf(j) }))
              {
                com.tencent.mm.audio.mix.i.b.e("MicroMsg.Mix.AudioMixPlayerImpl", "don't callback again");
                AppMethodBeat.o(136919);
                return;
                i = 0;
                continue;
              }
            }
            if (??? != null)
            {
              ((e)???).aU(Integer.valueOf(j));
              d.this.dxu.put(paramAnonymousy.dCW.dtX, ???);
            }
          }
          while (d.this.dxp == null)
          {
            AppMethodBeat.o(136919);
            return;
            label178:
            synchronized (d.this.dxm)
            {
              e locale = new e(Integer.valueOf(j));
              d.this.dxu.put(paramAnonymousy.dCW.dtX, locale);
            }
          }
          com.tencent.mm.audio.mix.i.b.i("MicroMsg.Mix.AudioMixPlayerImpl", "onEventChange audioId:%s, state:%s", new Object[] { paramAnonymousy.dCW.dtX, paramAnonymousy.dCW.state });
          if (j == 9)
          {
            d.this.dxp.b(paramAnonymousy);
            AppMethodBeat.o(136919);
            return;
          }
          if (j == 7)
          {
            d.this.dxp.c(paramAnonymousy);
            AppMethodBeat.o(136919);
            return;
          }
          if (j == 0)
          {
            d.this.dxp.d(paramAnonymousy);
            AppMethodBeat.o(136919);
            return;
          }
          if (j == 1)
          {
            d.this.dxp.d(paramAnonymousy);
            AppMethodBeat.o(136919);
            return;
          }
          if (j == 2)
          {
            d.this.dxp.e(paramAnonymousy);
            AppMethodBeat.o(136919);
            return;
          }
          if (j == 3)
          {
            d.this.dxt.put(paramAnonymousy.dCW.dtX, Boolean.FALSE);
            d.this.dxp.f(paramAnonymousy);
            AppMethodBeat.o(136919);
            return;
          }
          if (j == 5)
          {
            d.this.dxt.put(paramAnonymousy.dCW.dtX, Boolean.FALSE);
            d.this.dxp.g(paramAnonymousy);
            AppMethodBeat.o(136919);
            return;
          }
          if (j == 4)
          {
            d.this.dxt.put(paramAnonymousy.dCW.dtX, Boolean.FALSE);
            d.this.dxp.j(paramAnonymousy);
            AppMethodBeat.o(136919);
            return;
          }
          if (j == 10)
          {
            d.this.dxp.h(paramAnonymousy);
            AppMethodBeat.o(136919);
            return;
          }
          if (j == 6)
          {
            d.this.dxp.i(paramAnonymousy);
            AppMethodBeat.o(136919);
            return;
          }
          if (j == 11)
          {
            d.this.dxp.k(paramAnonymousy);
            AppMethodBeat.o(136919);
            return;
          }
          if ((j != 12) && (j == 13)) {
            d.this.dxp.l(paramAnonymousy);
          }
          AppMethodBeat.o(136919);
        }
      };
    }
    this.mHandler = new Handler(Looper.myLooper());
    AppMethodBeat.o(136920);
  }
  
  private void ZN()
  {
    AppMethodBeat.i(136929);
    try
    {
      if (this.dxn != null)
      {
        com.tencent.mm.audio.mix.i.b.i("MicroMsg.Mix.AudioMixPlayerImpl", "stop playback thread id:%d", new Object[] { Long.valueOf(this.dxn.getId()) });
        this.dxn = null;
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
    //   13: invokestatic 176	com/tencent/mm/audio/mix/i/b:i	(Ljava/lang/String;Ljava/lang/String;)V
    //   16: aload_0
    //   17: getfield 88	com/tencent/mm/audio/mix/g/d:channels	I
    //   20: iconst_1
    //   21: if_icmpne +180 -> 201
    //   24: iconst_4
    //   25: istore_1
    //   26: aload_0
    //   27: getfield 91	com/tencent/mm/audio/mix/g/d:sampleRate	I
    //   30: iload_1
    //   31: iconst_2
    //   32: invokestatic 275	android/media/AudioTrack:getMinBufferSize	(III)I
    //   35: istore_2
    //   36: aload_0
    //   37: iload_2
    //   38: sipush 3536
    //   41: idiv
    //   42: putfield 93	com/tencent/mm/audio/mix/g/d:dxg	I
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
    //   64: getfield 88	com/tencent/mm/audio/mix/g/d:channels	I
    //   67: invokestatic 253	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
    //   70: aastore
    //   71: dup
    //   72: iconst_2
    //   73: aload_0
    //   74: getfield 91	com/tencent/mm/audio/mix/g/d:sampleRate	I
    //   77: invokestatic 253	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
    //   80: aastore
    //   81: invokestatic 240	com/tencent/mm/audio/mix/i/b:i	(Ljava/lang/String;Ljava/lang/String;[Ljava/lang/Object;)V
    //   84: aload_0
    //   85: getfield 260	com/tencent/mm/audio/mix/g/d:bfn	Landroid/media/AudioTrack;
    //   88: ifnonnull +31 -> 119
    //   91: ldc 223
    //   93: ldc_w 279
    //   96: invokestatic 281	com/tencent/mm/audio/mix/i/b:e	(Ljava/lang/String;Ljava/lang/String;)V
    //   99: aload_0
    //   100: new 262	android/media/AudioTrack
    //   103: dup
    //   104: iconst_3
    //   105: aload_0
    //   106: getfield 91	com/tencent/mm/audio/mix/g/d:sampleRate	I
    //   109: iload_1
    //   110: iconst_2
    //   111: iload_2
    //   112: iconst_1
    //   113: invokespecial 284	android/media/AudioTrack:<init>	(IIIIII)V
    //   116: putfield 260	com/tencent/mm/audio/mix/g/d:bfn	Landroid/media/AudioTrack;
    //   119: aload_0
    //   120: getfield 260	com/tencent/mm/audio/mix/g/d:bfn	Landroid/media/AudioTrack;
    //   123: ifnull +14 -> 137
    //   126: aload_0
    //   127: getfield 260	com/tencent/mm/audio/mix/g/d:bfn	Landroid/media/AudioTrack;
    //   130: invokevirtual 288	android/media/AudioTrack:getState	()I
    //   133: iconst_1
    //   134: if_icmpeq +118 -> 252
    //   137: ldc 223
    //   139: ldc_w 290
    //   142: invokestatic 281	com/tencent/mm/audio/mix/i/b:e	(Ljava/lang/String;Ljava/lang/String;)V
    //   145: aload_0
    //   146: getfield 260	com/tencent/mm/audio/mix/g/d:bfn	Landroid/media/AudioTrack;
    //   149: ifnull +40 -> 189
    //   152: ldc 223
    //   154: ldc_w 292
    //   157: iconst_1
    //   158: anewarray 4	java/lang/Object
    //   161: dup
    //   162: iconst_0
    //   163: aload_0
    //   164: getfield 260	com/tencent/mm/audio/mix/g/d:bfn	Landroid/media/AudioTrack;
    //   167: invokevirtual 288	android/media/AudioTrack:getState	()I
    //   170: invokestatic 253	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
    //   173: aastore
    //   174: invokestatic 256	com/tencent/mm/audio/mix/i/b:e	(Ljava/lang/String;Ljava/lang/String;[Ljava/lang/Object;)V
    //   177: aload_0
    //   178: getfield 260	com/tencent/mm/audio/mix/g/d:bfn	Landroid/media/AudioTrack;
    //   181: invokevirtual 295	android/media/AudioTrack:release	()V
    //   184: aload_0
    //   185: aconst_null
    //   186: putfield 260	com/tencent/mm/audio/mix/g/d:bfn	Landroid/media/AudioTrack;
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
    //   220: invokestatic 301	com/tencent/mm/audio/mix/i/b:printErrStackTrace	(Ljava/lang/String;Ljava/lang/Throwable;Ljava/lang/String;[Ljava/lang/Object;)V
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
    //   246: invokestatic 301	com/tencent/mm/audio/mix/i/b:printErrStackTrace	(Ljava/lang/String;Ljava/lang/Throwable;Ljava/lang/String;[Ljava/lang/Object;)V
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
  
  public final void ZL()
  {
    AppMethodBeat.i(136922);
    this.dxh.set(false);
    this.dxj.set(true);
    this.dxi.set(false);
    ZQ();
    ZN();
    AppMethodBeat.o(136922);
  }
  
  final void ZM()
  {
    AppMethodBeat.i(136928);
    try
    {
      if (this.dxn == null)
      {
        this.dxn = new Thread(this.dxI, "audio_mix_player");
        this.dxn.start();
        com.tencent.mm.audio.mix.i.b.i("MicroMsg.Mix.AudioMixPlayerImpl", "start playback thread id:%d", new Object[] { Long.valueOf(this.dxn.getId()) });
      }
      return;
    }
    finally
    {
      AppMethodBeat.o(136928);
    }
  }
  
  public final com.tencent.mm.audio.mix.a.b ZO()
  {
    AppMethodBeat.i(136931);
    synchronized (this.dxl)
    {
      for (;;)
      {
        if ((this.dxk.size() == 0) || (this.dxi.get()))
        {
          boolean bool = this.dxj.get();
          if (!bool) {
            try
            {
              com.tencent.mm.audio.mix.i.b.i("MicroMsg.Mix.AudioMixPlayerImpl", "wait play");
              Zj();
              if ((this.bfn != null) && (this.bfn.getPlayState() == 3)) {
                this.bfn.stop();
              }
              this.dxl.wait();
              this.dxH = 0;
            }
            catch (InterruptedException localInterruptedException)
            {
              com.tencent.mm.audio.mix.i.b.printErrStackTrace("MicroMsg.Mix.AudioMixPlayerImpl", localInterruptedException, "waitPlay", new Object[0]);
            }
          }
        }
      }
    }
    com.tencent.mm.audio.mix.a.b localb = (com.tencent.mm.audio.mix.a.b)this.dxk.poll();
    this.dxl.notifyAll();
    AppMethodBeat.o(136931);
    return localb;
  }
  
  public final void ZP()
  {
    AppMethodBeat.i(136932);
    this.dxk.clear();
    AppMethodBeat.o(136932);
  }
  
  public final void ZQ()
  {
    AppMethodBeat.i(136933);
    synchronized (this.dxl)
    {
      com.tencent.mm.audio.mix.i.b.i("MicroMsg.Mix.AudioMixPlayerImpl", "sync notify");
      try
      {
        this.dxl.notifyAll();
        AppMethodBeat.o(136933);
        return;
      }
      catch (Exception localException)
      {
        for (;;)
        {
          com.tencent.mm.audio.mix.i.b.printErrStackTrace("MicroMsg.Mix.AudioMixPlayerImpl", localException, "syncNotify", new Object[0]);
        }
      }
    }
  }
  
  public final int ZR()
  {
    int i = 0;
    AppMethodBeat.i(136940);
    label168:
    label172:
    for (;;)
    {
      synchronized (this.dxm)
      {
        Object localObject2 = this.dxu.keySet();
        Object localObject4 = new ArrayList();
        ((ArrayList)localObject4).addAll((Collection)localObject2);
        localObject2 = ((ArrayList)localObject4).iterator();
        if (((Iterator)localObject2).hasNext())
        {
          localObject4 = (String)((Iterator)localObject2).next();
          localObject4 = (e)this.dxu.get(localObject4);
          if (localObject4 != null)
          {
            if (((e)localObject4).f(new Integer[] { Integer.valueOf(0) })) {
              break label168;
            }
            if (((e)localObject4).f(new Integer[] { Integer.valueOf(1) })) {
              break label168;
            }
            if (((e)localObject4).f(new Integer[] { Integer.valueOf(2) })) {
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
  
  public final ArrayList<String> ZS()
  {
    AppMethodBeat.i(136941);
    this.dxw.clear();
    this.dxJ.clear();
    synchronized (this.dxm)
    {
      Object localObject2 = this.dxu.keySet();
      this.dxJ.addAll((Collection)localObject2);
      localObject2 = this.dxJ.iterator();
      while (((Iterator)localObject2).hasNext())
      {
        String str = (String)((Iterator)localObject2).next();
        e locale = (e)this.dxu.get(str);
        if (locale != null) {
          if (locale.f(new Integer[] { Integer.valueOf(2) })) {
            this.dxw.add(str);
          }
        }
      }
    }
    ??? = this.dxw;
    AppMethodBeat.o(136941);
    return ???;
  }
  
  public final void Zj()
  {
    AppMethodBeat.i(136930);
    try
    {
      if (this.bfn != null) {
        this.bfn.setStereoVolume(0.0F, 0.0F);
      }
      AppMethodBeat.o(136930);
      return;
    }
    catch (Exception localException)
    {
      com.tencent.mm.audio.mix.i.b.printErrStackTrace("MicroMsg.Mix.AudioMixPlayerImpl", localException, "setVolume", new Object[0]);
      AppMethodBeat.o(136930);
    }
  }
  
  public final void a(int paramInt1, String paramString1, int paramInt2, String paramString2)
  {
    AppMethodBeat.i(136939);
    com.tencent.mm.ai.b localb = (com.tencent.mm.ai.b)this.dvc.get(paramString1);
    if (localb == null)
    {
      AppMethodBeat.o(136939);
      return;
    }
    y localy = new y();
    localy.dCW.dtX = paramString1;
    localy.dCW.action = paramInt1;
    localy.dCW.appId = localb.appId;
    localy.dCW.errCode = paramInt2;
    localy.dCW.errMsg = paramString2;
    localy.dCW.state = y.jA(paramInt1);
    if (this.dxq != null) {
      this.dxq.a(localy);
    }
    AppMethodBeat.o(136939);
  }
  
  public final void clearCache()
  {
    AppMethodBeat.i(136921);
    this.dxo.clearCache();
    this.dvc.clear();
    this.dxs.clear();
    this.dxt.clear();
    synchronized (this.dxm)
    {
      this.dxu.clear();
      this.dxv.clear();
      this.dwo.clear();
      AppMethodBeat.o(136921);
      return;
    }
  }
  
  public final void f(int paramInt, String paramString1, String paramString2)
  {
    AppMethodBeat.i(136938);
    com.tencent.mm.ai.b localb = (com.tencent.mm.ai.b)this.dvc.get(paramString1);
    if (localb == null)
    {
      AppMethodBeat.o(136938);
      return;
    }
    y localy = new y();
    localy.dCW.dtX = paramString1;
    localy.dCW.action = paramInt;
    localy.dCW.appId = localb.appId;
    paramString1 = paramString2;
    if (TextUtils.isEmpty(paramString2)) {
      paramString1 = localb.dvn;
    }
    localy.dCW.dvn = paramString1;
    localy.dCW.state = y.jA(paramInt);
    if (this.dxq != null) {
      this.dxq.a(localy);
    }
    AppMethodBeat.o(136938);
  }
  
  public final boolean gO(String paramString)
  {
    AppMethodBeat.i(136925);
    if (this.dxu.containsKey(paramString))
    {
      e locale = (e)this.dxu.get(paramString);
      if (locale != null) {
        if ((locale.f(new Integer[] { Integer.valueOf(0) })) && (!this.dxo.YY()))
        {
          AppMethodBeat.o(136925);
          return true;
        }
      }
      if ((!this.dxo.YY()) && (!this.dxo.gT(paramString)) && (this.dxb.gO(paramString)))
      {
        AppMethodBeat.o(136925);
        return true;
      }
    }
    AppMethodBeat.o(136925);
    return false;
  }
  
  public final com.tencent.mm.ai.b ha(String paramString)
  {
    AppMethodBeat.i(136923);
    if (this.dvc.containsKey(paramString))
    {
      paramString = (com.tencent.mm.ai.b)this.dvc.get(paramString);
      AppMethodBeat.o(136923);
      return paramString;
    }
    AppMethodBeat.o(136923);
    return null;
  }
  
  public final void he(String paramString)
  {
    AppMethodBeat.i(136924);
    this.dxo.gS(paramString);
    synchronized (this.dxm)
    {
      this.dwo.remove(paramString);
      this.dxs.remove(paramString);
      this.dxt.put(paramString, Boolean.FALSE);
      if (this.dxb.gN(paramString)) {
        q(3, paramString);
      }
      AppMethodBeat.o(136924);
      return;
    }
  }
  
  public final int hj(String paramString)
  {
    AppMethodBeat.i(136927);
    if (this.dvc.containsKey(paramString))
    {
      paramString = (com.tencent.mm.ai.b)this.dvc.get(paramString);
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
      paramString = f.YL().gE(paramString);
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
  
  public final int hp(String paramString)
  {
    AppMethodBeat.i(136926);
    if (this.dvc.containsKey(paramString))
    {
      com.tencent.mm.ai.b localb = (com.tencent.mm.ai.b)this.dvc.get(paramString);
      if (localb == null)
      {
        AppMethodBeat.o(136926);
        return 0;
      }
      int i;
      label72:
      int j;
      if (localb.dtU)
      {
        i = (int)this.dxo.gV(paramString);
        if (i == -1) {
          break label100;
        }
        localb.dCS = i;
        if (i != -1) {
          break label109;
        }
        j = 0;
      }
      for (;;)
      {
        AppMethodBeat.o(136926);
        return j;
        i = (int)this.dxb.gP(paramString);
        break;
        label100:
        i = localb.dCS;
        break label72;
        label109:
        int k = hj(paramString);
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
  
  public final int hq(String paramString)
  {
    AppMethodBeat.i(136936);
    if (!this.dxu.containsKey(paramString))
    {
      AppMethodBeat.o(136936);
      return -1;
    }
    paramString = (e)this.dxu.get(paramString);
    if (paramString != null)
    {
      int i = ((Integer)paramString.get()).intValue();
      AppMethodBeat.o(136936);
      return i;
    }
    AppMethodBeat.o(136936);
    return -1;
  }
  
  public final void q(int paramInt, String paramString)
  {
    AppMethodBeat.i(136937);
    f(paramInt, paramString, this.dxo.gZ(paramString));
    AppMethodBeat.o(136937);
  }
  
  final void releaseAudioTrack()
  {
    try
    {
      AppMethodBeat.i(136935);
      try
      {
        if (this.bfn != null)
        {
          this.bfn.flush();
          this.bfn.stop();
          this.bfn.release();
          this.bfn = null;
        }
        AppMethodBeat.o(136935);
      }
      catch (Exception localException)
      {
        for (;;)
        {
          com.tencent.mm.audio.mix.i.b.printErrStackTrace("MicroMsg.Mix.AudioMixPlayerImpl", localException, "releaseAudioTrack", new Object[0]);
          AppMethodBeat.o(136935);
        }
      }
      return;
    }
    finally {}
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.audio.mix.g.d
 * JD-Core Version:    0.7.0.1
 */