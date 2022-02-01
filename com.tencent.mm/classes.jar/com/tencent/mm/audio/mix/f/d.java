package com.tencent.mm.audio.mix.f;

import android.media.AudioTrack;
import android.os.Handler;
import android.os.Looper;
import android.os.Process;
import android.text.TextUtils;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.audio.mix.b.f;
import com.tencent.mm.audio.mix.decode.a;
import com.tencent.mm.audio.mix.decode.m;
import com.tencent.mm.audio.mix.e.i;
import com.tencent.mm.autogen.a.ac;
import com.tencent.mm.autogen.a.ac.a;
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
  AudioTrack cIK;
  int channels;
  volatile HashMap<String, com.tencent.mm.al.b> hrV;
  public a htW;
  volatile HashMap<String, Boolean> hti;
  private short huA;
  volatile boolean huB;
  int huC;
  private Runnable huD;
  ArrayList<String> huE;
  private int hub;
  public AtomicBoolean huc;
  AtomicBoolean hud;
  public AtomicBoolean hue;
  public Queue<com.tencent.mm.audio.mix.a.b> huf;
  public Object hug;
  Object huh;
  private Thread hui;
  public com.tencent.mm.audio.mix.e.c huj;
  b huk;
  private m hul;
  public g hum;
  volatile HashMap<String, Boolean> hun;
  volatile HashMap<String, Boolean> huo;
  volatile HashMap<String, e<Integer>> hup;
  volatile HashMap<String, com.tencent.mm.al.d> huq;
  private ArrayList<String> hur;
  private volatile HashMap<String, Long> hus;
  private volatile HashMap<String, Integer> hut;
  private volatile HashMap<String, Integer> huu;
  private volatile HashMap<String, Integer> huv;
  private volatile HashMap<String, Integer> huw;
  private volatile HashMap<String, Integer> hux;
  private byte[] huy;
  byte[] huz;
  Handler mHandler;
  int sampleRate;
  
  public d()
  {
    AppMethodBeat.i(136920);
    this.channels = 2;
    this.sampleRate = 44100;
    this.hub = 4;
    this.huc = new AtomicBoolean(false);
    this.hud = new AtomicBoolean(false);
    this.hue = new AtomicBoolean(true);
    this.huf = new ArrayDeque();
    this.hug = new Object();
    this.huh = new Object();
    this.hrV = new HashMap();
    this.hun = new HashMap();
    this.huo = new HashMap();
    this.hup = new HashMap();
    this.huq = new HashMap();
    this.hti = new HashMap();
    this.hur = new ArrayList();
    this.hus = new HashMap();
    this.hut = new HashMap();
    this.huu = new HashMap();
    this.huv = new HashMap();
    this.huw = new HashMap();
    this.hux = new HashMap();
    this.huy = new byte[3536];
    this.huz = new byte[2];
    this.huA = 0;
    this.huB = false;
    this.huC = 0;
    this.huD = new Runnable()
    {
      public final void run()
      {
        AppMethodBeat.i(136917);
        Process.setThreadPriority(-19);
        if (d.this.hue.get())
        {
          com.tencent.mm.audio.mix.h.b.e("MicroMsg.Mix.AudioMixPlayerImpl", "stop and exit");
          AppMethodBeat.o(136917);
          return;
        }
        if (d.this.cIK == null) {
          d.a(d.this);
        }
        com.tencent.mm.audio.mix.h.b.i("MicroMsg.Mix.AudioMixPlayerImpl", "playback start");
        do
        {
          if (!d.this.hue.get())
          {
            d locald = d.this;
            synchronized (locald.hug)
            {
              for (;;)
              {
                if ((locald.hud.get()) && (!locald.hue.get()))
                {
                  com.tencent.mm.audio.mix.h.b.i("MicroMsg.Mix.AudioMixPlayerImpl", "waitPlay");
                  try
                  {
                    locald.hug.wait();
                  }
                  catch (Exception localException)
                  {
                    com.tencent.mm.audio.mix.h.b.printErrStackTrace("MicroMsg.Mix.AudioMixPlayerImpl", localException, "waitPlay", new Object[0]);
                  }
                }
              }
            }
            if (d.this.hue.get()) {
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
          ??? = d.this.aGu();
        } while (??? == null);
        byte[] arrayOfByte = ((com.tencent.mm.audio.mix.a.b)???).hqJ;
        if (d.this.cIK == null) {
          d.a(d.this);
        }
        Object localObject4;
        label462:
        String str;
        if ((arrayOfByte != null) && (arrayOfByte.length > 0))
        {
          if ((d.this.cIK != null) && ((d.this.cIK.getPlayState() == 1) || (d.this.cIK.getPlayState() == 2))) {
            d.this.cIK.play();
          }
          ??? = d.this;
          if ((((d)???).huk != null) && (((d)???).huB))
          {
            localObject4 = com.tencent.mm.audio.mix.b.c.aFl().aFm();
            if (localObject4 != null)
            {
              if ((((com.tencent.mm.audio.mix.a.c)localObject4).hqJ == null) || (((com.tencent.mm.audio.mix.a.c)localObject4).hqJ.length < ((com.tencent.mm.audio.mix.a.b)???).hqJ.length)) {
                ((com.tencent.mm.audio.mix.a.c)localObject4).hqJ = new byte[((com.tencent.mm.audio.mix.a.b)???).hqJ.length];
              }
              System.arraycopy(((com.tencent.mm.audio.mix.a.b)???).hqJ, 0, ((com.tencent.mm.audio.mix.a.c)localObject4).hqJ, 0, ((com.tencent.mm.audio.mix.a.b)???).hqJ.length);
              ((d)???).mHandler.post(new d.4((d)???, (com.tencent.mm.audio.mix.a.c)localObject4));
            }
          }
          ??? = d.this;
          ((d)???).huC += 1;
          localObject4 = d.this;
          Iterator localIterator = ((com.tencent.mm.audio.mix.a.b)???).hqK.iterator();
          for (;;)
          {
            if (!localIterator.hasNext()) {
              break label612;
            }
            str = (String)localIterator.next();
            synchronized (((d)localObject4).huh)
            {
              if (!TextUtils.isEmpty(str)) {
                if ((!((d)localObject4).hti.containsKey(str)) || (!((Boolean)((d)localObject4).hti.get(str)).booleanValue())) {
                  break;
                }
              }
            }
          }
          if (!((d)localObject4).hti.containsKey(str)) {
            break label833;
          }
          ((d)localObject4).hti.put(str, Boolean.TRUE);
        }
        label659:
        label833:
        for (int i = 1;; i = 0)
        {
          if (i == 0) {
            break label462;
          }
          ((d)localObject4).mHandler.post(new d.2((d)localObject4, str));
          break label462;
          label612:
          long l = System.currentTimeMillis();
          if (d.this.cIK != null) {
            if (d.this.huj.aGe())
            {
              com.tencent.mm.audio.mix.h.b.i("MicroMsg.Mix.AudioMixPlayerImpl", "isMute");
              d.this.cIK.setStereoVolume(0.0F, 0.0F);
            }
          }
          for (i = d.this.cIK.write(arrayOfByte, 0, arrayOfByte.length);; i = 0)
          {
            l = System.currentTimeMillis() - l;
            if (l > 100L) {
              com.tencent.mm.audio.mix.h.b.e("MicroMsg.Mix.AudioMixPlayerImpl", "write audio track after writeSize:%d, time:%d, writeCount:%d", new Object[] { Integer.valueOf(i), Long.valueOf(l), Integer.valueOf(d.this.huC) });
            }
            if (i < 0) {
              com.tencent.mm.audio.mix.h.b.e("MicroMsg.Mix.AudioMixPlayerImpl", "write audio track buffer failed, Size:%d", new Object[] { Integer.valueOf(i) });
            }
            if (d.this.huf.size() == 0)
            {
              d.this.huz[0] = arrayOfByte[(arrayOfByte.length - 2)];
              d.this.huz[1] = arrayOfByte[(arrayOfByte.length - 1)];
            }
            com.tencent.mm.audio.mix.b.b.aFj().a(localb);
            break;
            d.this.cIK.setStereoVolume(1.0F, 1.0F);
            break label659;
          }
        }
      }
    };
    this.huE = new ArrayList();
    this.huj = new com.tencent.mm.audio.mix.e.c(this);
    com.tencent.mm.audio.mix.e.c localc = this.huj;
    com.tencent.mm.audio.mix.h.b.i("MicroMsg.Mix.AudioMixController", "onInit");
    localc.aGh();
    localc.htc.clear();
    localc.hsV = new com.tencent.mm.audio.mix.e.d();
    localc.hsV.init();
    if (this.hul == null) {
      this.hul = new m()
      {
        public final void a(ac paramAnonymousac)
        {
          AppMethodBeat.i(136919);
          int j = paramAnonymousac.hzX.action;
          int i;
          if ((j == 12) || (j == 11) || (j == 10) || (j == 6)) {
            i = 1;
          }
          while (i == 0)
          {
            if (!d.this.hup.containsKey(paramAnonymousac.hzX.hqQ)) {
              break label178;
            }
            ??? = (e)d.this.hup.get(paramAnonymousac.hzX.hqQ);
            if (??? != null) {
              if (((e)???).i(new Integer[] { Integer.valueOf(j) }))
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
              ((e)???).cu(Integer.valueOf(j));
              d.this.hup.put(paramAnonymousac.hzX.hqQ, ???);
            }
          }
          while (d.this.huk == null)
          {
            AppMethodBeat.o(136919);
            return;
            label178:
            synchronized (d.this.huh)
            {
              e locale = new e(Integer.valueOf(j));
              d.this.hup.put(paramAnonymousac.hzX.hqQ, locale);
            }
          }
          com.tencent.mm.audio.mix.h.b.i("MicroMsg.Mix.AudioMixPlayerImpl", "onEventChange audioId:%s, state:%s", new Object[] { paramAnonymousac.hzX.hqQ, paramAnonymousac.hzX.state });
          if (j == 9)
          {
            d.this.huk.b(paramAnonymousac);
            AppMethodBeat.o(136919);
            return;
          }
          if (j == 7)
          {
            d.this.huk.c(paramAnonymousac);
            AppMethodBeat.o(136919);
            return;
          }
          if (j == 0)
          {
            d.this.huk.d(paramAnonymousac);
            AppMethodBeat.o(136919);
            return;
          }
          if (j == 1)
          {
            d.this.huk.d(paramAnonymousac);
            AppMethodBeat.o(136919);
            return;
          }
          if (j == 2)
          {
            d.this.huk.e(paramAnonymousac);
            AppMethodBeat.o(136919);
            return;
          }
          if (j == 3)
          {
            d.this.huo.put(paramAnonymousac.hzX.hqQ, Boolean.FALSE);
            d.this.huk.f(paramAnonymousac);
            AppMethodBeat.o(136919);
            return;
          }
          if (j == 5)
          {
            d.this.huo.put(paramAnonymousac.hzX.hqQ, Boolean.FALSE);
            d.this.huk.g(paramAnonymousac);
            AppMethodBeat.o(136919);
            return;
          }
          if (j == 4)
          {
            d.this.huo.put(paramAnonymousac.hzX.hqQ, Boolean.FALSE);
            d.this.huk.j(paramAnonymousac);
            AppMethodBeat.o(136919);
            return;
          }
          if (j == 10)
          {
            d.this.huk.h(paramAnonymousac);
            AppMethodBeat.o(136919);
            return;
          }
          if (j == 6)
          {
            d.this.huk.i(paramAnonymousac);
            AppMethodBeat.o(136919);
            return;
          }
          if (j == 11)
          {
            d.this.huk.k(paramAnonymousac);
            AppMethodBeat.o(136919);
            return;
          }
          if (j == 12)
          {
            AppMethodBeat.o(136919);
            return;
          }
          if (j == 13) {
            d.this.huk.l(paramAnonymousac);
          }
          AppMethodBeat.o(136919);
        }
      };
    }
    this.mHandler = new Handler(Looper.myLooper());
    AppMethodBeat.o(136920);
  }
  
  private void aGt()
  {
    AppMethodBeat.i(136929);
    try
    {
      if (this.hui != null)
      {
        com.tencent.mm.audio.mix.h.b.i("MicroMsg.Mix.AudioMixPlayerImpl", "stop playback thread id:%d", new Object[] { Long.valueOf(this.hui.getId()) });
        this.hui = null;
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
    //   8: ldc 225
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
    //   42: putfield 93	com/tencent/mm/audio/mix/f/d:hub	I
    //   45: ldc 225
    //   47: ldc_w 277
    //   50: iconst_3
    //   51: anewarray 4	java/lang/Object
    //   54: dup
    //   55: iconst_0
    //   56: iload_2
    //   57: invokestatic 233	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
    //   60: aastore
    //   61: dup
    //   62: iconst_1
    //   63: aload_0
    //   64: getfield 88	com/tencent/mm/audio/mix/f/d:channels	I
    //   67: invokestatic 233	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
    //   70: aastore
    //   71: dup
    //   72: iconst_2
    //   73: aload_0
    //   74: getfield 91	com/tencent/mm/audio/mix/f/d:sampleRate	I
    //   77: invokestatic 233	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
    //   80: aastore
    //   81: invokestatic 265	com/tencent/mm/audio/mix/h/b:i	(Ljava/lang/String;Ljava/lang/String;[Ljava/lang/Object;)V
    //   84: aload_0
    //   85: getfield 241	com/tencent/mm/audio/mix/f/d:cIK	Landroid/media/AudioTrack;
    //   88: ifnonnull +31 -> 119
    //   91: ldc 225
    //   93: ldc_w 279
    //   96: invokestatic 281	com/tencent/mm/audio/mix/h/b:e	(Ljava/lang/String;Ljava/lang/String;)V
    //   99: aload_0
    //   100: new 243	android/media/AudioTrack
    //   103: dup
    //   104: iconst_3
    //   105: aload_0
    //   106: getfield 91	com/tencent/mm/audio/mix/f/d:sampleRate	I
    //   109: iload_1
    //   110: iconst_2
    //   111: iload_2
    //   112: iconst_1
    //   113: invokespecial 284	android/media/AudioTrack:<init>	(IIIIII)V
    //   116: putfield 241	com/tencent/mm/audio/mix/f/d:cIK	Landroid/media/AudioTrack;
    //   119: aload_0
    //   120: getfield 241	com/tencent/mm/audio/mix/f/d:cIK	Landroid/media/AudioTrack;
    //   123: ifnull +14 -> 137
    //   126: aload_0
    //   127: getfield 241	com/tencent/mm/audio/mix/f/d:cIK	Landroid/media/AudioTrack;
    //   130: invokevirtual 288	android/media/AudioTrack:getState	()I
    //   133: iconst_1
    //   134: if_icmpeq +118 -> 252
    //   137: ldc 225
    //   139: ldc_w 290
    //   142: invokestatic 281	com/tencent/mm/audio/mix/h/b:e	(Ljava/lang/String;Ljava/lang/String;)V
    //   145: aload_0
    //   146: getfield 241	com/tencent/mm/audio/mix/f/d:cIK	Landroid/media/AudioTrack;
    //   149: ifnull +40 -> 189
    //   152: ldc 225
    //   154: ldc_w 292
    //   157: iconst_1
    //   158: anewarray 4	java/lang/Object
    //   161: dup
    //   162: iconst_0
    //   163: aload_0
    //   164: getfield 241	com/tencent/mm/audio/mix/f/d:cIK	Landroid/media/AudioTrack;
    //   167: invokevirtual 288	android/media/AudioTrack:getState	()I
    //   170: invokestatic 233	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
    //   173: aastore
    //   174: invokestatic 237	com/tencent/mm/audio/mix/h/b:e	(Ljava/lang/String;Ljava/lang/String;[Ljava/lang/Object;)V
    //   177: aload_0
    //   178: getfield 241	com/tencent/mm/audio/mix/f/d:cIK	Landroid/media/AudioTrack;
    //   181: invokevirtual 295	android/media/AudioTrack:release	()V
    //   184: aload_0
    //   185: aconst_null
    //   186: putfield 241	com/tencent/mm/audio/mix/f/d:cIK	Landroid/media/AudioTrack;
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
    //   209: ldc 225
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
    //   235: ldc 225
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
  
  public final void a(int paramInt1, String paramString1, int paramInt2, String paramString2)
  {
    AppMethodBeat.i(136939);
    com.tencent.mm.al.b localb = (com.tencent.mm.al.b)this.hrV.get(paramString1);
    if (localb == null)
    {
      AppMethodBeat.o(136939);
      return;
    }
    ac localac = new ac();
    localac.hzX.hqQ = paramString1;
    localac.hzX.action = paramInt1;
    localac.hzX.appId = localb.appId;
    localac.hzX.errCode = paramInt2;
    localac.hzX.errMsg = paramString2;
    localac.hzX.state = ac.oB(paramInt1);
    if (this.hul != null) {
      this.hul.a(localac);
    }
    AppMethodBeat.o(136939);
  }
  
  public final void aGr()
  {
    AppMethodBeat.i(136922);
    this.huc.set(false);
    this.hue.set(true);
    this.hud.set(false);
    aGw();
    aGt();
    AppMethodBeat.o(136922);
  }
  
  final void aGs()
  {
    AppMethodBeat.i(136928);
    try
    {
      if (this.hui == null)
      {
        this.hui = new Thread(this.huD, "audio_mix_player");
        this.hui.start();
        com.tencent.mm.audio.mix.h.b.i("MicroMsg.Mix.AudioMixPlayerImpl", "start playback thread id:%d", new Object[] { Long.valueOf(this.hui.getId()) });
      }
      return;
    }
    finally
    {
      AppMethodBeat.o(136928);
    }
  }
  
  public final com.tencent.mm.audio.mix.a.b aGu()
  {
    AppMethodBeat.i(136931);
    synchronized (this.hug)
    {
      for (;;)
      {
        if ((this.huf.size() == 0) || (this.hud.get()))
        {
          boolean bool = this.hue.get();
          if (!bool) {
            try
            {
              com.tencent.mm.audio.mix.h.b.i("MicroMsg.Mix.AudioMixPlayerImpl", "wait play");
              setVolume(0.0F, 0.0F);
              if ((this.cIK != null) && (this.cIK.getPlayState() == 3)) {
                this.cIK.stop();
              }
              this.hug.wait();
              this.huC = 0;
            }
            catch (InterruptedException localInterruptedException)
            {
              com.tencent.mm.audio.mix.h.b.printErrStackTrace("MicroMsg.Mix.AudioMixPlayerImpl", localInterruptedException, "waitPlay", new Object[0]);
            }
          }
        }
      }
    }
    com.tencent.mm.audio.mix.a.b localb = (com.tencent.mm.audio.mix.a.b)this.huf.poll();
    this.hug.notifyAll();
    AppMethodBeat.o(136931);
    return localb;
  }
  
  public final void aGv()
  {
    AppMethodBeat.i(136932);
    this.huf.clear();
    AppMethodBeat.o(136932);
  }
  
  public final void aGw()
  {
    AppMethodBeat.i(136933);
    synchronized (this.hug)
    {
      com.tencent.mm.audio.mix.h.b.i("MicroMsg.Mix.AudioMixPlayerImpl", "sync notify");
      try
      {
        this.hug.notifyAll();
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
  
  public final int aGx()
  {
    int i = 0;
    AppMethodBeat.i(136940);
    label168:
    label172:
    for (;;)
    {
      synchronized (this.huh)
      {
        Object localObject2 = this.hup.keySet();
        Object localObject4 = new ArrayList();
        ((ArrayList)localObject4).addAll((Collection)localObject2);
        localObject2 = ((ArrayList)localObject4).iterator();
        if (((Iterator)localObject2).hasNext())
        {
          localObject4 = (String)((Iterator)localObject2).next();
          localObject4 = (e)this.hup.get(localObject4);
          if (localObject4 != null)
          {
            if (((e)localObject4).i(new Integer[] { Integer.valueOf(0) })) {
              break label168;
            }
            if (((e)localObject4).i(new Integer[] { Integer.valueOf(1) })) {
              break label168;
            }
            if (((e)localObject4).i(new Integer[] { Integer.valueOf(2) })) {
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
  
  public final int aGy()
  {
    int i = 0;
    AppMethodBeat.i(236178);
    label149:
    label153:
    for (;;)
    {
      synchronized (this.huh)
      {
        Object localObject2 = this.hup.keySet();
        Object localObject4 = new ArrayList();
        ((ArrayList)localObject4).addAll((Collection)localObject2);
        localObject2 = ((ArrayList)localObject4).iterator();
        if (((Iterator)localObject2).hasNext())
        {
          localObject4 = (String)((Iterator)localObject2).next();
          localObject4 = (e)this.hup.get(localObject4);
          if (localObject4 != null)
          {
            if (((e)localObject4).i(new Integer[] { Integer.valueOf(0) })) {
              break label149;
            }
            if (((e)localObject4).i(new Integer[] { Integer.valueOf(1) })) {
              break label149;
            }
          }
        }
        else
        {
          AppMethodBeat.o(236178);
          return i;
        }
      }
      break label153;
      i += 1;
    }
  }
  
  public final ArrayList<String> aGz()
  {
    AppMethodBeat.i(136941);
    this.hur.clear();
    this.huE.clear();
    synchronized (this.huh)
    {
      Object localObject2 = this.hup.keySet();
      this.huE.addAll((Collection)localObject2);
      localObject2 = this.huE.iterator();
      while (((Iterator)localObject2).hasNext())
      {
        String str = (String)((Iterator)localObject2).next();
        e locale = (e)this.hup.get(str);
        if (locale != null) {
          if (locale.i(new Integer[] { Integer.valueOf(2) })) {
            this.hur.add(str);
          }
        }
      }
    }
    ??? = this.hur;
    AppMethodBeat.o(136941);
    return ???;
  }
  
  public final void clearCache()
  {
    AppMethodBeat.i(136921);
    this.huj.clearCache();
    this.hrV.clear();
    this.hun.clear();
    this.huo.clear();
    synchronized (this.huh)
    {
      this.hup.clear();
      this.huq.clear();
      this.hti.clear();
      AppMethodBeat.o(136921);
      return;
    }
  }
  
  public final void h(int paramInt, String paramString1, String paramString2)
  {
    AppMethodBeat.i(136938);
    com.tencent.mm.al.b localb = (com.tencent.mm.al.b)this.hrV.get(paramString1);
    if (localb == null)
    {
      AppMethodBeat.o(136938);
      return;
    }
    ac localac = new ac();
    localac.hzX.hqQ = paramString1;
    localac.hzX.action = paramInt;
    localac.hzX.appId = localb.appId;
    paramString1 = paramString2;
    if (TextUtils.isEmpty(paramString2)) {
      paramString1 = localb.hsg;
    }
    localac.hzX.hsg = paramString1;
    localac.hzX.state = ac.oB(paramInt);
    if (this.hul != null) {
      this.hul.a(localac);
    }
    AppMethodBeat.o(136938);
  }
  
  public final int jD(String paramString)
  {
    AppMethodBeat.i(136926);
    if (this.hrV.containsKey(paramString))
    {
      com.tencent.mm.al.b localb = (com.tencent.mm.al.b)this.hrV.get(paramString);
      if (localb == null)
      {
        AppMethodBeat.o(136926);
        return 0;
      }
      int i;
      label72:
      int j;
      if (localb.hqN)
      {
        i = (int)this.huj.ji(paramString);
        if (i == -1) {
          break label100;
        }
        localb.currentTime = i;
        if (i != -1) {
          break label109;
        }
        j = 0;
      }
      for (;;)
      {
        AppMethodBeat.o(136926);
        return j;
        i = (int)this.htW.jc(paramString);
        break;
        label100:
        i = localb.currentTime;
        break label72;
        label109:
        int k = jx(paramString);
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
  
  public final int jE(String paramString)
  {
    AppMethodBeat.i(136936);
    if (!this.hup.containsKey(paramString))
    {
      AppMethodBeat.o(136936);
      return -1;
    }
    paramString = (e)this.hup.get(paramString);
    if (paramString != null)
    {
      int i = ((Integer)paramString.get()).intValue();
      AppMethodBeat.o(136936);
      return i;
    }
    AppMethodBeat.o(136936);
    return -1;
  }
  
  final boolean jF(String paramString)
  {
    AppMethodBeat.i(236182);
    if (this.hrV.containsKey(paramString))
    {
      boolean bool = ((com.tencent.mm.al.b)this.hrV.get(paramString)).hqN;
      AppMethodBeat.o(236182);
      return bool;
    }
    AppMethodBeat.o(236182);
    return false;
  }
  
  public final boolean jb(String paramString)
  {
    AppMethodBeat.i(136925);
    if (this.hup.containsKey(paramString))
    {
      e locale = (e)this.hup.get(paramString);
      if (locale != null) {
        if ((locale.i(new Integer[] { Integer.valueOf(0) })) && (!this.huj.aFF()))
        {
          AppMethodBeat.o(136925);
          return true;
        }
      }
      if ((!this.huj.aFF()) && (!this.huj.jg(paramString)) && (this.htW.jb(paramString)))
      {
        AppMethodBeat.o(136925);
        return true;
      }
    }
    AppMethodBeat.o(136925);
    return false;
  }
  
  public final com.tencent.mm.al.b jo(String paramString)
  {
    AppMethodBeat.i(136923);
    if (this.hrV.containsKey(paramString))
    {
      paramString = (com.tencent.mm.al.b)this.hrV.get(paramString);
      AppMethodBeat.o(136923);
      return paramString;
    }
    AppMethodBeat.o(136923);
    return null;
  }
  
  public final void js(String paramString)
  {
    AppMethodBeat.i(136924);
    this.huj.jf(paramString);
    synchronized (this.huh)
    {
      this.hti.remove(paramString);
      this.hun.remove(paramString);
      this.huo.put(paramString, Boolean.FALSE);
      if (this.htW.ja(paramString)) {
        r(3, paramString);
      }
      AppMethodBeat.o(136924);
      return;
    }
  }
  
  public final int jx(String paramString)
  {
    AppMethodBeat.i(136927);
    if (this.hrV.containsKey(paramString))
    {
      paramString = (com.tencent.mm.al.b)this.hrV.get(paramString);
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
      paramString = f.aFr().iR(paramString);
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
  
  public final void r(int paramInt, String paramString)
  {
    AppMethodBeat.i(136937);
    h(paramInt, paramString, this.huj.jn(paramString));
    AppMethodBeat.o(136937);
  }
  
  final void releaseAudioTrack()
  {
    try
    {
      AppMethodBeat.i(136935);
      try
      {
        if (this.cIK != null)
        {
          this.cIK.flush();
          this.cIK.stop();
          this.cIK.release();
          this.cIK = null;
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
  
  public final void setVolume(float paramFloat1, float paramFloat2)
  {
    AppMethodBeat.i(236168);
    try
    {
      if (this.cIK != null) {
        this.cIK.setStereoVolume(paramFloat1, paramFloat2);
      }
      AppMethodBeat.o(236168);
      return;
    }
    catch (Exception localException)
    {
      com.tencent.mm.audio.mix.h.b.printErrStackTrace("MicroMsg.Mix.AudioMixPlayerImpl", localException, "setVolume", new Object[0]);
      AppMethodBeat.o(236168);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes9.jar
 * Qualified Name:     com.tencent.mm.audio.mix.f.d
 * JD-Core Version:    0.7.0.1
 */