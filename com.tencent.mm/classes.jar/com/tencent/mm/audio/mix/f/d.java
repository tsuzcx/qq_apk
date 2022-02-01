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
import com.tencent.mm.f.a.z;
import com.tencent.mm.f.a.z.a;
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
  AudioTrack aOO;
  int channels;
  volatile HashMap<String, com.tencent.mm.al.b> fnK;
  volatile HashMap<String, Boolean> foY;
  public a fpN;
  private int fpS;
  public AtomicBoolean fpT;
  AtomicBoolean fpU;
  public AtomicBoolean fpV;
  public Queue<com.tencent.mm.audio.mix.a.b> fpW;
  public Object fpX;
  Object fpY;
  private Thread fpZ;
  public com.tencent.mm.audio.mix.e.c fqa;
  b fqb;
  private m fqc;
  public g fqd;
  volatile HashMap<String, Boolean> fqe;
  volatile HashMap<String, Boolean> fqf;
  volatile HashMap<String, e<Integer>> fqg;
  volatile HashMap<String, com.tencent.mm.al.d> fqh;
  private ArrayList<String> fqi;
  private volatile HashMap<String, Long> fqj;
  private volatile HashMap<String, Integer> fqk;
  private volatile HashMap<String, Integer> fql;
  private volatile HashMap<String, Integer> fqm;
  private volatile HashMap<String, Integer> fqn;
  private volatile HashMap<String, Integer> fqo;
  private byte[] fqp;
  byte[] fqq;
  private short fqr;
  volatile boolean fqs;
  int fqt;
  private Runnable fqu;
  ArrayList<String> fqv;
  Handler mHandler;
  int sampleRate;
  
  public d()
  {
    AppMethodBeat.i(136920);
    this.channels = 2;
    this.sampleRate = 44100;
    this.fpS = 4;
    this.fpT = new AtomicBoolean(false);
    this.fpU = new AtomicBoolean(false);
    this.fpV = new AtomicBoolean(true);
    this.fpW = new ArrayDeque();
    this.fpX = new Object();
    this.fpY = new Object();
    this.fnK = new HashMap();
    this.fqe = new HashMap();
    this.fqf = new HashMap();
    this.fqg = new HashMap();
    this.fqh = new HashMap();
    this.foY = new HashMap();
    this.fqi = new ArrayList();
    this.fqj = new HashMap();
    this.fqk = new HashMap();
    this.fql = new HashMap();
    this.fqm = new HashMap();
    this.fqn = new HashMap();
    this.fqo = new HashMap();
    this.fqp = new byte[3536];
    this.fqq = new byte[2];
    this.fqr = 0;
    this.fqs = false;
    this.fqt = 0;
    this.fqu = new Runnable()
    {
      public final void run()
      {
        AppMethodBeat.i(136917);
        Process.setThreadPriority(-19);
        if (d.this.fpV.get())
        {
          com.tencent.mm.audio.mix.h.b.e("MicroMsg.Mix.AudioMixPlayerImpl", "stop and exit");
          AppMethodBeat.o(136917);
          return;
        }
        if (d.this.aOO == null) {
          d.a(d.this);
        }
        com.tencent.mm.audio.mix.h.b.i("MicroMsg.Mix.AudioMixPlayerImpl", "playback start");
        do
        {
          if (!d.this.fpV.get())
          {
            d locald = d.this;
            synchronized (locald.fpX)
            {
              for (;;)
              {
                if ((locald.fpU.get()) && (!locald.fpV.get()))
                {
                  com.tencent.mm.audio.mix.h.b.i("MicroMsg.Mix.AudioMixPlayerImpl", "waitPlay");
                  try
                  {
                    locald.fpX.wait();
                  }
                  catch (Exception localException)
                  {
                    com.tencent.mm.audio.mix.h.b.printErrStackTrace("MicroMsg.Mix.AudioMixPlayerImpl", localException, "waitPlay", new Object[0]);
                  }
                }
              }
            }
            if (d.this.fpV.get()) {
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
          ??? = d.this.aex();
        } while (??? == null);
        byte[] arrayOfByte = ((com.tencent.mm.audio.mix.a.b)???).fmy;
        if (d.this.aOO == null) {
          d.a(d.this);
        }
        Object localObject4;
        label462:
        String str;
        if ((arrayOfByte != null) && (arrayOfByte.length > 0))
        {
          if ((d.this.aOO != null) && ((d.this.aOO.getPlayState() == 1) || (d.this.aOO.getPlayState() == 2))) {
            d.this.aOO.play();
          }
          ??? = d.this;
          if ((((d)???).fqb != null) && (((d)???).fqs))
          {
            localObject4 = com.tencent.mm.audio.mix.b.c.adm().adn();
            if (localObject4 != null)
            {
              if ((((com.tencent.mm.audio.mix.a.c)localObject4).fmy == null) || (((com.tencent.mm.audio.mix.a.c)localObject4).fmy.length < ((com.tencent.mm.audio.mix.a.b)???).fmy.length)) {
                ((com.tencent.mm.audio.mix.a.c)localObject4).fmy = new byte[((com.tencent.mm.audio.mix.a.b)???).fmy.length];
              }
              System.arraycopy(((com.tencent.mm.audio.mix.a.b)???).fmy, 0, ((com.tencent.mm.audio.mix.a.c)localObject4).fmy, 0, ((com.tencent.mm.audio.mix.a.b)???).fmy.length);
              ((d)???).mHandler.post(new d.4((d)???, (com.tencent.mm.audio.mix.a.c)localObject4));
            }
          }
          ??? = d.this;
          ((d)???).fqt += 1;
          localObject4 = d.this;
          Iterator localIterator = ((com.tencent.mm.audio.mix.a.b)???).fmz.iterator();
          for (;;)
          {
            if (!localIterator.hasNext()) {
              break label612;
            }
            str = (String)localIterator.next();
            synchronized (((d)localObject4).fpY)
            {
              if (!TextUtils.isEmpty(str)) {
                if ((!((d)localObject4).foY.containsKey(str)) || (!((Boolean)((d)localObject4).foY.get(str)).booleanValue())) {
                  break;
                }
              }
            }
          }
          if (!((d)localObject4).foY.containsKey(str)) {
            break label833;
          }
          ((d)localObject4).foY.put(str, Boolean.TRUE);
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
          if (d.this.aOO != null) {
            if (d.this.fqa.aeg())
            {
              com.tencent.mm.audio.mix.h.b.i("MicroMsg.Mix.AudioMixPlayerImpl", "isMute");
              d.this.aOO.setStereoVolume(0.0F, 0.0F);
            }
          }
          for (i = d.this.aOO.write(arrayOfByte, 0, arrayOfByte.length);; i = 0)
          {
            l = System.currentTimeMillis() - l;
            if (l > 100L) {
              com.tencent.mm.audio.mix.h.b.e("MicroMsg.Mix.AudioMixPlayerImpl", "write audio track after writeSize:%d, time:%d, writeCount:%d", new Object[] { Integer.valueOf(i), Long.valueOf(l), Integer.valueOf(d.this.fqt) });
            }
            if (i < 0) {
              com.tencent.mm.audio.mix.h.b.e("MicroMsg.Mix.AudioMixPlayerImpl", "write audio track buffer failed, Size:%d", new Object[] { Integer.valueOf(i) });
            }
            if (d.this.fpW.size() == 0)
            {
              d.this.fqq[0] = arrayOfByte[(arrayOfByte.length - 2)];
              d.this.fqq[1] = arrayOfByte[(arrayOfByte.length - 1)];
            }
            com.tencent.mm.audio.mix.b.b.adk().a(localb);
            break;
            d.this.aOO.setStereoVolume(1.0F, 1.0F);
            break label659;
          }
        }
      }
    };
    this.fqv = new ArrayList();
    this.fqa = new com.tencent.mm.audio.mix.e.c(this);
    com.tencent.mm.audio.mix.e.c localc = this.fqa;
    com.tencent.mm.audio.mix.h.b.i("MicroMsg.Mix.AudioMixController", "onInit");
    localc.aej();
    localc.foS.clear();
    localc.foL = new com.tencent.mm.audio.mix.e.d();
    localc.foL.init();
    if (this.fqc == null) {
      this.fqc = new m()
      {
        public final void a(z paramAnonymousz)
        {
          AppMethodBeat.i(136919);
          int j = paramAnonymousz.fvC.action;
          int i;
          if ((j == 12) || (j == 11) || (j == 10) || (j == 6)) {
            i = 1;
          }
          while (i == 0)
          {
            if (!d.this.fqg.containsKey(paramAnonymousz.fvC.fmF)) {
              break label178;
            }
            ??? = (e)d.this.fqg.get(paramAnonymousz.fvC.fmF);
            if (??? != null) {
              if (((e)???).f(new Integer[] { Integer.valueOf(j) }))
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
              ((e)???).aY(Integer.valueOf(j));
              d.this.fqg.put(paramAnonymousz.fvC.fmF, ???);
            }
          }
          while (d.this.fqb == null)
          {
            AppMethodBeat.o(136919);
            return;
            label178:
            synchronized (d.this.fpY)
            {
              e locale = new e(Integer.valueOf(j));
              d.this.fqg.put(paramAnonymousz.fvC.fmF, locale);
            }
          }
          com.tencent.mm.audio.mix.h.b.i("MicroMsg.Mix.AudioMixPlayerImpl", "onEventChange audioId:%s, state:%s", new Object[] { paramAnonymousz.fvC.fmF, paramAnonymousz.fvC.state });
          if (j == 9)
          {
            d.this.fqb.b(paramAnonymousz);
            AppMethodBeat.o(136919);
            return;
          }
          if (j == 7)
          {
            d.this.fqb.c(paramAnonymousz);
            AppMethodBeat.o(136919);
            return;
          }
          if (j == 0)
          {
            d.this.fqb.d(paramAnonymousz);
            AppMethodBeat.o(136919);
            return;
          }
          if (j == 1)
          {
            d.this.fqb.d(paramAnonymousz);
            AppMethodBeat.o(136919);
            return;
          }
          if (j == 2)
          {
            d.this.fqb.e(paramAnonymousz);
            AppMethodBeat.o(136919);
            return;
          }
          if (j == 3)
          {
            d.this.fqf.put(paramAnonymousz.fvC.fmF, Boolean.FALSE);
            d.this.fqb.f(paramAnonymousz);
            AppMethodBeat.o(136919);
            return;
          }
          if (j == 5)
          {
            d.this.fqf.put(paramAnonymousz.fvC.fmF, Boolean.FALSE);
            d.this.fqb.g(paramAnonymousz);
            AppMethodBeat.o(136919);
            return;
          }
          if (j == 4)
          {
            d.this.fqf.put(paramAnonymousz.fvC.fmF, Boolean.FALSE);
            d.this.fqb.j(paramAnonymousz);
            AppMethodBeat.o(136919);
            return;
          }
          if (j == 10)
          {
            d.this.fqb.h(paramAnonymousz);
            AppMethodBeat.o(136919);
            return;
          }
          if (j == 6)
          {
            d.this.fqb.i(paramAnonymousz);
            AppMethodBeat.o(136919);
            return;
          }
          if (j == 11)
          {
            d.this.fqb.k(paramAnonymousz);
            AppMethodBeat.o(136919);
            return;
          }
          if (j == 12)
          {
            AppMethodBeat.o(136919);
            return;
          }
          if (j == 13) {
            d.this.fqb.l(paramAnonymousz);
          }
          AppMethodBeat.o(136919);
        }
      };
    }
    this.mHandler = new Handler(Looper.myLooper());
    AppMethodBeat.o(136920);
  }
  
  private void aew()
  {
    AppMethodBeat.i(136929);
    try
    {
      if (this.fpZ != null)
      {
        com.tencent.mm.audio.mix.h.b.i("MicroMsg.Mix.AudioMixPlayerImpl", "stop playback thread id:%d", new Object[] { Long.valueOf(this.fpZ.getId()) });
        this.fpZ = null;
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
    //   42: putfield 93	com/tencent/mm/audio/mix/f/d:fpS	I
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
    //   85: getfield 241	com/tencent/mm/audio/mix/f/d:aOO	Landroid/media/AudioTrack;
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
    //   116: putfield 241	com/tencent/mm/audio/mix/f/d:aOO	Landroid/media/AudioTrack;
    //   119: aload_0
    //   120: getfield 241	com/tencent/mm/audio/mix/f/d:aOO	Landroid/media/AudioTrack;
    //   123: ifnull +14 -> 137
    //   126: aload_0
    //   127: getfield 241	com/tencent/mm/audio/mix/f/d:aOO	Landroid/media/AudioTrack;
    //   130: invokevirtual 288	android/media/AudioTrack:getState	()I
    //   133: iconst_1
    //   134: if_icmpeq +118 -> 252
    //   137: ldc 225
    //   139: ldc_w 290
    //   142: invokestatic 281	com/tencent/mm/audio/mix/h/b:e	(Ljava/lang/String;Ljava/lang/String;)V
    //   145: aload_0
    //   146: getfield 241	com/tencent/mm/audio/mix/f/d:aOO	Landroid/media/AudioTrack;
    //   149: ifnull +40 -> 189
    //   152: ldc 225
    //   154: ldc_w 292
    //   157: iconst_1
    //   158: anewarray 4	java/lang/Object
    //   161: dup
    //   162: iconst_0
    //   163: aload_0
    //   164: getfield 241	com/tencent/mm/audio/mix/f/d:aOO	Landroid/media/AudioTrack;
    //   167: invokevirtual 288	android/media/AudioTrack:getState	()I
    //   170: invokestatic 233	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
    //   173: aastore
    //   174: invokestatic 237	com/tencent/mm/audio/mix/h/b:e	(Ljava/lang/String;Ljava/lang/String;[Ljava/lang/Object;)V
    //   177: aload_0
    //   178: getfield 241	com/tencent/mm/audio/mix/f/d:aOO	Landroid/media/AudioTrack;
    //   181: invokevirtual 295	android/media/AudioTrack:release	()V
    //   184: aload_0
    //   185: aconst_null
    //   186: putfield 241	com/tencent/mm/audio/mix/f/d:aOO	Landroid/media/AudioTrack;
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
    com.tencent.mm.al.b localb = (com.tencent.mm.al.b)this.fnK.get(paramString1);
    if (localb == null)
    {
      AppMethodBeat.o(136939);
      return;
    }
    z localz = new z();
    localz.fvC.fmF = paramString1;
    localz.fvC.action = paramInt1;
    localz.fvC.appId = localb.appId;
    localz.fvC.errCode = paramInt2;
    localz.fvC.errMsg = paramString2;
    localz.fvC.state = z.kU(paramInt1);
    if (this.fqc != null) {
      this.fqc.a(localz);
    }
    AppMethodBeat.o(136939);
  }
  
  public final void adS()
  {
    AppMethodBeat.i(136930);
    try
    {
      if (this.aOO != null) {
        this.aOO.setStereoVolume(0.0F, 0.0F);
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
  
  public final int aeA()
  {
    int i = 0;
    AppMethodBeat.i(136940);
    label168:
    label172:
    for (;;)
    {
      synchronized (this.fpY)
      {
        Object localObject2 = this.fqg.keySet();
        Object localObject4 = new ArrayList();
        ((ArrayList)localObject4).addAll((Collection)localObject2);
        localObject2 = ((ArrayList)localObject4).iterator();
        if (((Iterator)localObject2).hasNext())
        {
          localObject4 = (String)((Iterator)localObject2).next();
          localObject4 = (e)this.fqg.get(localObject4);
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
  
  public final ArrayList<String> aeB()
  {
    AppMethodBeat.i(136941);
    this.fqi.clear();
    this.fqv.clear();
    synchronized (this.fpY)
    {
      Object localObject2 = this.fqg.keySet();
      this.fqv.addAll((Collection)localObject2);
      localObject2 = this.fqv.iterator();
      while (((Iterator)localObject2).hasNext())
      {
        String str = (String)((Iterator)localObject2).next();
        e locale = (e)this.fqg.get(str);
        if (locale != null) {
          if (locale.f(new Integer[] { Integer.valueOf(2) })) {
            this.fqi.add(str);
          }
        }
      }
    }
    ??? = this.fqi;
    AppMethodBeat.o(136941);
    return ???;
  }
  
  public final void aeu()
  {
    AppMethodBeat.i(136922);
    this.fpT.set(false);
    this.fpV.set(true);
    this.fpU.set(false);
    aez();
    aew();
    AppMethodBeat.o(136922);
  }
  
  final void aev()
  {
    AppMethodBeat.i(136928);
    try
    {
      if (this.fpZ == null)
      {
        this.fpZ = new Thread(this.fqu, "audio_mix_player");
        this.fpZ.start();
        com.tencent.mm.audio.mix.h.b.i("MicroMsg.Mix.AudioMixPlayerImpl", "start playback thread id:%d", new Object[] { Long.valueOf(this.fpZ.getId()) });
      }
      return;
    }
    finally
    {
      AppMethodBeat.o(136928);
    }
  }
  
  public final com.tencent.mm.audio.mix.a.b aex()
  {
    AppMethodBeat.i(136931);
    synchronized (this.fpX)
    {
      for (;;)
      {
        if ((this.fpW.size() == 0) || (this.fpU.get()))
        {
          boolean bool = this.fpV.get();
          if (!bool) {
            try
            {
              com.tencent.mm.audio.mix.h.b.i("MicroMsg.Mix.AudioMixPlayerImpl", "wait play");
              adS();
              if ((this.aOO != null) && (this.aOO.getPlayState() == 3)) {
                this.aOO.stop();
              }
              this.fpX.wait();
              this.fqt = 0;
            }
            catch (InterruptedException localInterruptedException)
            {
              com.tencent.mm.audio.mix.h.b.printErrStackTrace("MicroMsg.Mix.AudioMixPlayerImpl", localInterruptedException, "waitPlay", new Object[0]);
            }
          }
        }
      }
    }
    com.tencent.mm.audio.mix.a.b localb = (com.tencent.mm.audio.mix.a.b)this.fpW.poll();
    this.fpX.notifyAll();
    AppMethodBeat.o(136931);
    return localb;
  }
  
  public final void aey()
  {
    AppMethodBeat.i(136932);
    this.fpW.clear();
    AppMethodBeat.o(136932);
  }
  
  public final void aez()
  {
    AppMethodBeat.i(136933);
    synchronized (this.fpX)
    {
      com.tencent.mm.audio.mix.h.b.i("MicroMsg.Mix.AudioMixPlayerImpl", "sync notify");
      try
      {
        this.fpX.notifyAll();
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
  
  public final void clearCache()
  {
    AppMethodBeat.i(136921);
    this.fqa.clearCache();
    this.fnK.clear();
    this.fqe.clear();
    this.fqf.clear();
    synchronized (this.fpY)
    {
      this.fqg.clear();
      this.fqh.clear();
      this.foY.clear();
      AppMethodBeat.o(136921);
      return;
    }
  }
  
  public final void f(int paramInt, String paramString1, String paramString2)
  {
    AppMethodBeat.i(136938);
    com.tencent.mm.al.b localb = (com.tencent.mm.al.b)this.fnK.get(paramString1);
    if (localb == null)
    {
      AppMethodBeat.o(136938);
      return;
    }
    z localz = new z();
    localz.fvC.fmF = paramString1;
    localz.fvC.action = paramInt;
    localz.fvC.appId = localb.appId;
    paramString1 = paramString2;
    if (TextUtils.isEmpty(paramString2)) {
      paramString1 = localb.fnV;
    }
    localz.fvC.fnV = paramString1;
    localz.fvC.state = z.kU(paramInt);
    if (this.fqc != null) {
      this.fqc.a(localz);
    }
    AppMethodBeat.o(136938);
  }
  
  public final boolean hA(String paramString)
  {
    AppMethodBeat.i(136925);
    if (this.fqg.containsKey(paramString))
    {
      e locale = (e)this.fqg.get(paramString);
      if (locale != null) {
        if ((locale.f(new Integer[] { Integer.valueOf(0) })) && (!this.fqa.adH()))
        {
          AppMethodBeat.o(136925);
          return true;
        }
      }
      if ((!this.fqa.adH()) && (!this.fqa.hF(paramString)) && (this.fpN.hA(paramString)))
      {
        AppMethodBeat.o(136925);
        return true;
      }
    }
    AppMethodBeat.o(136925);
    return false;
  }
  
  public final com.tencent.mm.al.b hN(String paramString)
  {
    AppMethodBeat.i(136923);
    if (this.fnK.containsKey(paramString))
    {
      paramString = (com.tencent.mm.al.b)this.fnK.get(paramString);
      AppMethodBeat.o(136923);
      return paramString;
    }
    AppMethodBeat.o(136923);
    return null;
  }
  
  public final void hR(String paramString)
  {
    AppMethodBeat.i(136924);
    this.fqa.hE(paramString);
    synchronized (this.fpY)
    {
      this.foY.remove(paramString);
      this.fqe.remove(paramString);
      this.fqf.put(paramString, Boolean.FALSE);
      if (this.fpN.hz(paramString)) {
        r(3, paramString);
      }
      AppMethodBeat.o(136924);
      return;
    }
  }
  
  public final int hW(String paramString)
  {
    AppMethodBeat.i(136927);
    if (this.fnK.containsKey(paramString))
    {
      paramString = (com.tencent.mm.al.b)this.fnK.get(paramString);
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
      paramString = f.ads().hq(paramString);
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
  
  public final int ic(String paramString)
  {
    AppMethodBeat.i(136926);
    if (this.fnK.containsKey(paramString))
    {
      com.tencent.mm.al.b localb = (com.tencent.mm.al.b)this.fnK.get(paramString);
      if (localb == null)
      {
        AppMethodBeat.o(136926);
        return 0;
      }
      int i;
      label72:
      int j;
      if (localb.fmC)
      {
        i = (int)this.fqa.hH(paramString);
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
        i = (int)this.fpN.hB(paramString);
        break;
        label100:
        i = localb.currentTime;
        break label72;
        label109:
        int k = hW(paramString);
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
  
  public final int ie(String paramString)
  {
    AppMethodBeat.i(136936);
    if (!this.fqg.containsKey(paramString))
    {
      AppMethodBeat.o(136936);
      return -1;
    }
    paramString = (e)this.fqg.get(paramString);
    if (paramString != null)
    {
      int i = ((Integer)paramString.get()).intValue();
      AppMethodBeat.o(136936);
      return i;
    }
    AppMethodBeat.o(136936);
    return -1;
  }
  
  public final void r(int paramInt, String paramString)
  {
    AppMethodBeat.i(136937);
    f(paramInt, paramString, this.fqa.hM(paramString));
    AppMethodBeat.o(136937);
  }
  
  final void releaseAudioTrack()
  {
    try
    {
      AppMethodBeat.i(136935);
      try
      {
        if (this.aOO != null)
        {
          this.aOO.flush();
          this.aOO.stop();
          this.aOO.release();
          this.aOO = null;
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


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes9.jar
 * Qualified Name:     com.tencent.mm.audio.mix.f.d
 * JD-Core Version:    0.7.0.1
 */