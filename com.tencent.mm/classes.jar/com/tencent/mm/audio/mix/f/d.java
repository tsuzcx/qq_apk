package com.tencent.mm.audio.mix.f;

import android.media.AudioTrack;
import android.os.Handler;
import android.os.Looper;
import android.text.TextUtils;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.audio.mix.d.a;
import com.tencent.mm.audio.mix.d.m;
import com.tencent.mm.audio.mix.e.i;
import com.tencent.mm.g.a.t;
import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Queue;
import java.util.concurrent.atomic.AtomicBoolean;

public final class d
{
  AudioTrack ayN;
  volatile HashMap<String, com.tencent.mm.ag.b> cfu;
  volatile HashMap<String, Boolean> cgu;
  private ArrayList<String> chA;
  private volatile HashMap<String, Long> chB;
  private volatile HashMap<String, Integer> chC;
  private volatile HashMap<String, Integer> chD;
  private volatile HashMap<String, Integer> chE;
  private volatile HashMap<String, Integer> chF;
  private volatile HashMap<String, Integer> chG;
  private byte[] chH;
  byte[] chI;
  private short chJ;
  int chK;
  private Runnable chL;
  ArrayList<String> chM;
  private int channels;
  public a chg;
  private int chk;
  public AtomicBoolean chl;
  AtomicBoolean chm;
  public AtomicBoolean chn;
  public Queue<com.tencent.mm.audio.mix.a.b> cho;
  public Object chp;
  Object chq;
  private Thread chr;
  public com.tencent.mm.audio.mix.e.c chs;
  b cht;
  private m chu;
  public g chv;
  volatile HashMap<String, Boolean> chw;
  volatile HashMap<String, Boolean> chx;
  volatile HashMap<String, e<Integer>> chy;
  volatile HashMap<String, com.tencent.mm.ag.d> chz;
  Handler mHandler;
  private int sampleRate;
  
  public d()
  {
    AppMethodBeat.i(137171);
    this.channels = 2;
    this.sampleRate = 44100;
    this.chk = 4;
    this.chl = new AtomicBoolean(false);
    this.chm = new AtomicBoolean(false);
    this.chn = new AtomicBoolean(true);
    this.cho = new ArrayDeque();
    this.chp = new Object();
    this.chq = new Object();
    this.cfu = new HashMap();
    this.chw = new HashMap();
    this.chx = new HashMap();
    this.chy = new HashMap();
    this.chz = new HashMap();
    this.cgu = new HashMap();
    this.chA = new ArrayList();
    this.chB = new HashMap();
    this.chC = new HashMap();
    this.chD = new HashMap();
    this.chE = new HashMap();
    this.chF = new HashMap();
    this.chG = new HashMap();
    this.chH = new byte[3536];
    this.chI = new byte[2];
    this.chJ = 0;
    this.chK = 0;
    this.chL = new d.1(this);
    this.chM = new ArrayList();
    this.chs = new com.tencent.mm.audio.mix.e.c(this);
    com.tencent.mm.audio.mix.e.c localc = this.chs;
    com.tencent.mm.audio.mix.h.b.i("MicroMsg.Mix.AudioMixController", "onInit");
    localc.DS();
    localc.cgo.clear();
    localc.cgg = new com.tencent.mm.audio.mix.e.d();
    localc.cgg.init();
    if (this.chu == null) {
      this.chu = new d.3(this);
    }
    this.mHandler = new Handler(Looper.myLooper());
    AppMethodBeat.o(137171);
  }
  
  private void Ef()
  {
    AppMethodBeat.i(137180);
    try
    {
      if (this.chr != null)
      {
        com.tencent.mm.audio.mix.h.b.i("MicroMsg.Mix.AudioMixPlayerImpl", "stop playback thread id:%d", new Object[] { Long.valueOf(this.chr.getId()) });
        this.chr = null;
      }
      return;
    }
    finally
    {
      AppMethodBeat.o(137180);
    }
  }
  
  /* Error */
  private boolean createAudioTrack()
  {
    // Byte code:
    //   0: aload_0
    //   1: monitorenter
    //   2: ldc_w 264
    //   5: invokestatic 78	com/tencent/matrix/trace/core/AppMethodBeat:i	(I)V
    //   8: ldc 217
    //   10: ldc_w 265
    //   13: invokestatic 168	com/tencent/mm/audio/mix/h/b:i	(Ljava/lang/String;Ljava/lang/String;)V
    //   16: aload_0
    //   17: getfield 80	com/tencent/mm/audio/mix/f/d:channels	I
    //   20: iconst_1
    //   21: if_icmpne +180 -> 201
    //   24: iconst_4
    //   25: istore_1
    //   26: aload_0
    //   27: getfield 83	com/tencent/mm/audio/mix/f/d:sampleRate	I
    //   30: iload_1
    //   31: iconst_2
    //   32: invokestatic 269	android/media/AudioTrack:getMinBufferSize	(III)I
    //   35: istore_2
    //   36: aload_0
    //   37: iload_2
    //   38: sipush 3536
    //   41: idiv
    //   42: putfield 85	com/tencent/mm/audio/mix/f/d:chk	I
    //   45: ldc 217
    //   47: ldc_w 271
    //   50: iconst_3
    //   51: anewarray 4	java/lang/Object
    //   54: dup
    //   55: iconst_0
    //   56: iload_2
    //   57: invokestatic 247	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
    //   60: aastore
    //   61: dup
    //   62: iconst_1
    //   63: aload_0
    //   64: getfield 80	com/tencent/mm/audio/mix/f/d:channels	I
    //   67: invokestatic 247	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
    //   70: aastore
    //   71: dup
    //   72: iconst_2
    //   73: aload_0
    //   74: getfield 83	com/tencent/mm/audio/mix/f/d:sampleRate	I
    //   77: invokestatic 247	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
    //   80: aastore
    //   81: invokestatic 234	com/tencent/mm/audio/mix/h/b:i	(Ljava/lang/String;Ljava/lang/String;[Ljava/lang/Object;)V
    //   84: aload_0
    //   85: getfield 254	com/tencent/mm/audio/mix/f/d:ayN	Landroid/media/AudioTrack;
    //   88: ifnonnull +31 -> 119
    //   91: ldc 217
    //   93: ldc_w 273
    //   96: invokestatic 275	com/tencent/mm/audio/mix/h/b:e	(Ljava/lang/String;Ljava/lang/String;)V
    //   99: aload_0
    //   100: new 256	android/media/AudioTrack
    //   103: dup
    //   104: iconst_3
    //   105: aload_0
    //   106: getfield 83	com/tencent/mm/audio/mix/f/d:sampleRate	I
    //   109: iload_1
    //   110: iconst_2
    //   111: iload_2
    //   112: iconst_1
    //   113: invokespecial 278	android/media/AudioTrack:<init>	(IIIIII)V
    //   116: putfield 254	com/tencent/mm/audio/mix/f/d:ayN	Landroid/media/AudioTrack;
    //   119: aload_0
    //   120: getfield 254	com/tencent/mm/audio/mix/f/d:ayN	Landroid/media/AudioTrack;
    //   123: ifnull +14 -> 137
    //   126: aload_0
    //   127: getfield 254	com/tencent/mm/audio/mix/f/d:ayN	Landroid/media/AudioTrack;
    //   130: invokevirtual 282	android/media/AudioTrack:getState	()I
    //   133: iconst_1
    //   134: if_icmpeq +118 -> 252
    //   137: ldc 217
    //   139: ldc_w 284
    //   142: invokestatic 275	com/tencent/mm/audio/mix/h/b:e	(Ljava/lang/String;Ljava/lang/String;)V
    //   145: aload_0
    //   146: getfield 254	com/tencent/mm/audio/mix/f/d:ayN	Landroid/media/AudioTrack;
    //   149: ifnull +40 -> 189
    //   152: ldc 217
    //   154: ldc_w 286
    //   157: iconst_1
    //   158: anewarray 4	java/lang/Object
    //   161: dup
    //   162: iconst_0
    //   163: aload_0
    //   164: getfield 254	com/tencent/mm/audio/mix/f/d:ayN	Landroid/media/AudioTrack;
    //   167: invokevirtual 282	android/media/AudioTrack:getState	()I
    //   170: invokestatic 247	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
    //   173: aastore
    //   174: invokestatic 250	com/tencent/mm/audio/mix/h/b:e	(Ljava/lang/String;Ljava/lang/String;[Ljava/lang/Object;)V
    //   177: aload_0
    //   178: getfield 254	com/tencent/mm/audio/mix/f/d:ayN	Landroid/media/AudioTrack;
    //   181: invokevirtual 289	android/media/AudioTrack:release	()V
    //   184: aload_0
    //   185: aconst_null
    //   186: putfield 254	com/tencent/mm/audio/mix/f/d:ayN	Landroid/media/AudioTrack;
    //   189: ldc_w 264
    //   192: invokestatic 210	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
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
    //   209: ldc 217
    //   211: aload 4
    //   213: ldc_w 291
    //   216: iconst_0
    //   217: anewarray 4	java/lang/Object
    //   220: invokestatic 295	com/tencent/mm/audio/mix/h/b:printErrStackTrace	(Ljava/lang/String;Ljava/lang/Throwable;Ljava/lang/String;[Ljava/lang/Object;)V
    //   223: goto -104 -> 119
    //   226: astore 4
    //   228: aload_0
    //   229: monitorexit
    //   230: aload 4
    //   232: athrow
    //   233: astore 4
    //   235: ldc 217
    //   237: aload 4
    //   239: ldc_w 297
    //   242: iconst_0
    //   243: anewarray 4	java/lang/Object
    //   246: invokestatic 295	com/tencent/mm/audio/mix/h/b:printErrStackTrace	(Ljava/lang/String;Ljava/lang/Throwable;Ljava/lang/String;[Ljava/lang/Object;)V
    //   249: goto -60 -> 189
    //   252: ldc_w 264
    //   255: invokestatic 210	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
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
  
  public final void DD()
  {
    AppMethodBeat.i(137181);
    try
    {
      if (this.ayN != null) {
        this.ayN.setStereoVolume(0.0F, 0.0F);
      }
      AppMethodBeat.o(137181);
      return;
    }
    catch (Exception localException)
    {
      com.tencent.mm.audio.mix.h.b.printErrStackTrace("MicroMsg.Mix.AudioMixPlayerImpl", localException, "setVolume", new Object[0]);
      AppMethodBeat.o(137181);
    }
  }
  
  public final void Ed()
  {
    AppMethodBeat.i(137173);
    this.chl.set(false);
    this.chn.set(true);
    this.chm.set(false);
    Ei();
    Ef();
    AppMethodBeat.o(137173);
  }
  
  final void Ee()
  {
    AppMethodBeat.i(137179);
    try
    {
      if (this.chr == null)
      {
        this.chr = new Thread(this.chL, "audio_mix_player");
        this.chr.start();
        com.tencent.mm.audio.mix.h.b.i("MicroMsg.Mix.AudioMixPlayerImpl", "start playback thread id:%d", new Object[] { Long.valueOf(this.chr.getId()) });
      }
      return;
    }
    finally
    {
      AppMethodBeat.o(137179);
    }
  }
  
  public final com.tencent.mm.audio.mix.a.b Eg()
  {
    AppMethodBeat.i(137182);
    synchronized (this.chp)
    {
      for (;;)
      {
        if ((this.cho.size() == 0) || (this.chm.get()))
        {
          boolean bool = this.chn.get();
          if (!bool) {
            try
            {
              com.tencent.mm.audio.mix.h.b.i("MicroMsg.Mix.AudioMixPlayerImpl", "wait play");
              DD();
              if ((this.ayN != null) && (this.ayN.getPlayState() == 3)) {
                this.ayN.stop();
              }
              this.chp.wait();
              this.chK = 0;
            }
            catch (InterruptedException localInterruptedException)
            {
              com.tencent.mm.audio.mix.h.b.printErrStackTrace("MicroMsg.Mix.AudioMixPlayerImpl", localInterruptedException, "waitPlay", new Object[0]);
            }
          }
        }
      }
    }
    com.tencent.mm.audio.mix.a.b localb = (com.tencent.mm.audio.mix.a.b)this.cho.poll();
    this.chp.notifyAll();
    AppMethodBeat.o(137182);
    return localb;
  }
  
  public final void Eh()
  {
    AppMethodBeat.i(137183);
    this.cho.clear();
    AppMethodBeat.o(137183);
  }
  
  public final void Ei()
  {
    AppMethodBeat.i(137184);
    synchronized (this.chp)
    {
      com.tencent.mm.audio.mix.h.b.i("MicroMsg.Mix.AudioMixPlayerImpl", "sync notify");
      try
      {
        this.chp.notifyAll();
        AppMethodBeat.o(137184);
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
  
  final void Ej()
  {
    try
    {
      AppMethodBeat.i(137186);
      try
      {
        if (this.ayN != null)
        {
          this.ayN.flush();
          this.ayN.stop();
          this.ayN.release();
          this.ayN = null;
        }
        AppMethodBeat.o(137186);
      }
      catch (Exception localException)
      {
        for (;;)
        {
          com.tencent.mm.audio.mix.h.b.printErrStackTrace("MicroMsg.Mix.AudioMixPlayerImpl", localException, "releaseAudioTrack", new Object[0]);
          AppMethodBeat.o(137186);
        }
      }
      return;
    }
    finally {}
  }
  
  public final int Ek()
  {
    int i = 0;
    AppMethodBeat.i(137191);
    label168:
    label172:
    for (;;)
    {
      synchronized (this.chq)
      {
        Object localObject2 = this.chy.keySet();
        Object localObject4 = new ArrayList();
        ((ArrayList)localObject4).addAll((Collection)localObject2);
        localObject2 = ((ArrayList)localObject4).iterator();
        if (((Iterator)localObject2).hasNext())
        {
          localObject4 = (String)((Iterator)localObject2).next();
          localObject4 = (e)this.chy.get(localObject4);
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
          AppMethodBeat.o(137191);
          return i;
        }
      }
      break label172;
      i += 1;
    }
  }
  
  public final ArrayList<String> El()
  {
    AppMethodBeat.i(137192);
    this.chA.clear();
    this.chM.clear();
    synchronized (this.chq)
    {
      Object localObject2 = this.chy.keySet();
      this.chM.addAll((Collection)localObject2);
      localObject2 = this.chM.iterator();
      while (((Iterator)localObject2).hasNext())
      {
        String str = (String)((Iterator)localObject2).next();
        e locale = (e)this.chy.get(str);
        if (locale != null) {
          if (locale.g(new Integer[] { Integer.valueOf(2) })) {
            this.chA.add(str);
          }
        }
      }
    }
    ??? = this.chA;
    AppMethodBeat.o(137192);
    return ???;
  }
  
  public final void a(int paramInt1, String paramString1, int paramInt2, String paramString2)
  {
    AppMethodBeat.i(137190);
    com.tencent.mm.ag.b localb = (com.tencent.mm.ag.b)this.cfu.get(paramString1);
    if (localb == null)
    {
      AppMethodBeat.o(137190);
      return;
    }
    t localt = new t();
    localt.cmZ.ceu = paramString1;
    localt.cmZ.action = paramInt1;
    localt.cmZ.appId = localb.appId;
    localt.cmZ.errCode = paramInt2;
    localt.cmZ.errMsg = paramString2;
    localt.cmZ.state = t.gC(paramInt1);
    if (this.chu != null) {
      this.chu.a(localt);
    }
    AppMethodBeat.o(137190);
  }
  
  public final void clearCache()
  {
    AppMethodBeat.i(137172);
    this.chs.clearCache();
    this.cfu.clear();
    this.chw.clear();
    this.chx.clear();
    synchronized (this.chq)
    {
      this.chy.clear();
      this.chz.clear();
      this.cgu.clear();
      AppMethodBeat.o(137172);
      return;
    }
  }
  
  public final void e(int paramInt, String paramString1, String paramString2)
  {
    AppMethodBeat.i(137189);
    com.tencent.mm.ag.b localb = (com.tencent.mm.ag.b)this.cfu.get(paramString1);
    if (localb == null)
    {
      AppMethodBeat.o(137189);
      return;
    }
    t localt = new t();
    localt.cmZ.ceu = paramString1;
    localt.cmZ.action = paramInt;
    localt.cmZ.appId = localb.appId;
    paramString1 = paramString2;
    if (TextUtils.isEmpty(paramString2)) {
      paramString1 = localb.cfG;
    }
    localt.cmZ.cfG = paramString1;
    localt.cmZ.state = t.gC(paramInt);
    if (this.chu != null) {
      this.chu.a(localt);
    }
    AppMethodBeat.o(137189);
  }
  
  public final int eB(String paramString)
  {
    AppMethodBeat.i(137177);
    int i = (int)this.chs.eh(paramString);
    AppMethodBeat.o(137177);
    return i;
  }
  
  public final int eC(String paramString)
  {
    AppMethodBeat.i(137187);
    if (!this.chy.containsKey(paramString))
    {
      AppMethodBeat.o(137187);
      return -1;
    }
    paramString = (e)this.chy.get(paramString);
    if (paramString != null)
    {
      int i = ((Integer)paramString.get()).intValue();
      AppMethodBeat.o(137187);
      return i;
    }
    AppMethodBeat.o(137187);
    return -1;
  }
  
  public final boolean eb(String paramString)
  {
    AppMethodBeat.i(137176);
    if (this.chy.containsKey(paramString))
    {
      e locale = (e)this.chy.get(paramString);
      if (locale != null) {
        if (locale.g(new Integer[] { Integer.valueOf(0) }))
        {
          AppMethodBeat.o(137176);
          return true;
        }
      }
      if ((!this.chs.ef(paramString)) && (this.chg.eb(paramString)))
      {
        AppMethodBeat.o(137176);
        return true;
      }
    }
    AppMethodBeat.o(137176);
    return false;
  }
  
  public final com.tencent.mm.ag.b em(String paramString)
  {
    AppMethodBeat.i(137174);
    if (this.cfu.containsKey(paramString))
    {
      paramString = (com.tencent.mm.ag.b)this.cfu.get(paramString);
      AppMethodBeat.o(137174);
      return paramString;
    }
    AppMethodBeat.o(137174);
    return null;
  }
  
  public final void er(String paramString)
  {
    AppMethodBeat.i(137175);
    this.chs.ee(paramString);
    synchronized (this.chq)
    {
      this.cgu.remove(paramString);
      this.chw.remove(paramString);
      this.chx.put(paramString, Boolean.FALSE);
      if (this.chg.ea(paramString)) {
        m(3, paramString);
      }
      AppMethodBeat.o(137175);
      return;
    }
  }
  
  public final int ew(String paramString)
  {
    AppMethodBeat.i(137178);
    if (this.cfu.containsKey(paramString))
    {
      paramString = ((com.tencent.mm.ag.b)this.cfu.get(paramString)).filePath;
      if (TextUtils.isEmpty(paramString))
      {
        AppMethodBeat.o(137178);
        return 0;
      }
      paramString = com.tencent.mm.audio.mix.b.d.De().dR(paramString);
      if (paramString != null)
      {
        int i = (int)paramString.duration;
        AppMethodBeat.o(137178);
        return i;
      }
    }
    AppMethodBeat.o(137178);
    return 0;
  }
  
  public final void m(int paramInt, String paramString)
  {
    AppMethodBeat.i(137188);
    e(paramInt, paramString, this.chs.el(paramString));
    AppMethodBeat.o(137188);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes9.jar
 * Qualified Name:     com.tencent.mm.audio.mix.f.d
 * JD-Core Version:    0.7.0.1
 */