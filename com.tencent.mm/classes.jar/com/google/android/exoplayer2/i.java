package com.google.android.exoplayer2;

import android.os.Handler;
import android.os.Handler.Callback;
import android.os.HandlerThread;
import android.os.Message;
import android.os.SystemClock;
import android.util.Pair;
import com.google.android.exoplayer2.g.g;
import com.google.android.exoplayer2.g.h;
import com.google.android.exoplayer2.g.h.a;
import com.google.android.exoplayer2.i.a;
import com.google.android.exoplayer2.i.v;
import com.google.android.exoplayer2.source.d;
import com.google.android.exoplayer2.source.j;
import com.google.android.exoplayer2.source.j.a;
import com.google.android.exoplayer2.source.k;
import com.google.android.exoplayer2.source.k.a;
import com.google.android.exoplayer2.source.k.b;
import com.tencent.matrix.trace.core.AppMethodBeat;
import java.io.IOException;

final class i
  implements Handler.Callback, h.a, j.a, k.a
{
  private final r[] aLB;
  private final h aLC;
  private final w.b aLG;
  private final w.a aLH;
  private boolean aLJ;
  private int aLK;
  private w aLO;
  private p aLS;
  private b aLT;
  private final s[] aLY;
  private final m aLZ;
  private final com.google.android.exoplayer2.i.s aMa;
  private final HandlerThread aMb;
  private final f aMc;
  private final n aMd;
  private r aMe;
  private com.google.android.exoplayer2.i.i aMf;
  private k aMg;
  private r[] aMh;
  private boolean aMi;
  int aMj;
  private int aMk;
  private long aMl;
  private int aMm;
  private c aMn;
  private long aMo;
  private a aMp;
  private a aMq;
  private a aMr;
  private final Handler eventHandler;
  final Handler handler;
  private boolean isLoading;
  boolean released;
  private int state;
  
  public i(r[] paramArrayOfr, h paramh, m paramm, boolean paramBoolean, int paramInt, Handler paramHandler, b paramb, f paramf)
  {
    AppMethodBeat.i(91918);
    this.aLB = paramArrayOfr;
    this.aLC = paramh;
    this.aLZ = paramm;
    this.aLJ = paramBoolean;
    this.aLK = paramInt;
    this.eventHandler = paramHandler;
    this.state = 1;
    this.aLT = paramb;
    this.aMc = paramf;
    this.aLY = new s[paramArrayOfr.length];
    paramInt = 0;
    while (paramInt < paramArrayOfr.length)
    {
      paramArrayOfr[paramInt].setIndex(paramInt);
      this.aLY[paramInt] = paramArrayOfr[paramInt].qK();
      paramInt += 1;
    }
    this.aMa = new com.google.android.exoplayer2.i.s();
    this.aMh = new r[0];
    this.aLG = new w.b();
    this.aLH = new w.a();
    this.aMd = new n();
    paramh.bog = this;
    this.aLS = p.aNn;
    this.aMb = new HandlerThread("ExoPlayerImplInternal:Handler", -16);
    this.aMb.start();
    this.handler = new Handler(this.aMb.getLooper(), this);
    AppMethodBeat.o(91918);
  }
  
  private void C(long paramLong)
  {
    AppMethodBeat.i(91933);
    if (this.aMr == null) {}
    for (paramLong = 60000000L + paramLong;; paramLong = this.aMr.rl() + paramLong)
    {
      this.aMo = paramLong;
      this.aMa.ak(this.aMo);
      r[] arrayOfr = this.aMh;
      int j = arrayOfr.length;
      int i = 0;
      while (i < j)
      {
        arrayOfr[i].w(this.aMo);
        i += 1;
      }
    }
    AppMethodBeat.o(91933);
  }
  
  private boolean D(long paramLong)
  {
    AppMethodBeat.i(91939);
    if ((paramLong == -9223372036854775807L) || (this.aLT.aMG < paramLong) || ((this.aMr.aMA != null) && ((this.aMr.aMA.aMy) || (this.aMr.aMA.aMx.aNi.isAd()))))
    {
      AppMethodBeat.o(91939);
      return true;
    }
    AppMethodBeat.o(91939);
    return false;
  }
  
  private int a(int paramInt, w paramw1, w paramw2)
  {
    AppMethodBeat.i(91944);
    int m = paramw1.rw();
    int k = 0;
    int i = -1;
    int j = paramInt;
    paramInt = k;
    while ((paramInt < m) && (i == -1))
    {
      j = paramw1.a(j, this.aLH, this.aLG, this.aLK);
      if (j == -1) {
        break;
      }
      i = paramw2.W(paramw1.a(j, this.aLH, true).aMt);
      paramInt += 1;
    }
    AppMethodBeat.o(91944);
    return i;
  }
  
  private long a(k.b paramb, long paramLong)
  {
    AppMethodBeat.i(91931);
    rf();
    this.aMi = false;
    setState(2);
    Object localObject;
    if (this.aMr == null)
    {
      if (this.aMp == null) {
        break label290;
      }
      this.aMp.release();
      localObject = null;
    }
    for (;;)
    {
      if ((this.aMr != localObject) || (this.aMr != this.aMq))
      {
        paramb = this.aMh;
        int j = paramb.length;
        int i = 0;
        for (;;)
        {
          if (i < j)
          {
            paramb[i].disable();
            i += 1;
            continue;
            a locala1 = this.aMr;
            a locala2 = null;
            localObject = locala2;
            if (locala1 == null) {
              break;
            }
            if ((locala2 == null) && (a(paramb, paramLong, locala1))) {
              locala2 = locala1;
            }
            for (;;)
            {
              locala1 = locala1.aMA;
              break;
              locala1.release();
            }
          }
        }
        this.aMh = new r[0];
        this.aMf = null;
        this.aMe = null;
        this.aMr = null;
      }
      if (localObject != null)
      {
        localObject.aMA = null;
        this.aMp = localObject;
        this.aMq = localObject;
        b(localObject);
        long l = paramLong;
        if (this.aMr.aMz) {
          l = this.aMr.aMs.Z(paramLong);
        }
        C(l);
        rk();
        paramLong = l;
      }
      for (;;)
      {
        this.handler.sendEmptyMessage(2);
        AppMethodBeat.o(91931);
        return paramLong;
        this.aMp = null;
        this.aMq = null;
        this.aMr = null;
        C(paramLong);
      }
      label290:
      localObject = null;
    }
  }
  
  private Pair<Integer, Long> a(c paramc)
  {
    AppMethodBeat.i(91945);
    Object localObject2 = paramc.aLO;
    Object localObject1 = localObject2;
    if (((w)localObject2).isEmpty()) {
      localObject1 = this.aLO;
    }
    try
    {
      localObject2 = ((w)localObject1).a(this.aLG, this.aLH, paramc.aMI, paramc.aMJ);
      if (this.aLO == localObject1)
      {
        AppMethodBeat.o(91945);
        return localObject2;
      }
    }
    catch (IndexOutOfBoundsException localIndexOutOfBoundsException)
    {
      paramc = new l(this.aLO, paramc.aMI, paramc.aMJ);
      AppMethodBeat.o(91945);
      throw paramc;
    }
    int i = this.aLO.W(localIndexOutOfBoundsException.a(((Integer)((Pair)localObject2).first).intValue(), this.aLH, true).aMt);
    if (i != -1)
    {
      paramc = Pair.create(Integer.valueOf(i), ((Pair)localObject2).second);
      AppMethodBeat.o(91945);
      return paramc;
    }
    i = a(((Integer)((Pair)localObject2).first).intValue(), localIndexOutOfBoundsException, this.aLO);
    if (i != -1)
    {
      paramc = dS(this.aLO.a(i, this.aLH, false).aMI);
      AppMethodBeat.o(91945);
      return paramc;
    }
    AppMethodBeat.o(91945);
    return null;
  }
  
  private a a(a parama, int paramInt)
  {
    AppMethodBeat.i(91941);
    for (;;)
    {
      parama.aMx = this.aMd.a(parama.aMx, paramInt);
      if ((parama.aMx.aNl) || (parama.aMA == null))
      {
        AppMethodBeat.o(91941);
        return parama;
      }
      parama = parama.aMA;
    }
  }
  
  private static void a(a parama)
  {
    AppMethodBeat.i(91948);
    while (parama != null)
    {
      parama.release();
      parama = parama.aMA;
    }
    AppMethodBeat.o(91948);
  }
  
  private static void a(r paramr)
  {
    AppMethodBeat.i(91938);
    if (paramr.getState() == 2) {
      paramr.stop();
    }
    AppMethodBeat.o(91938);
  }
  
  private void a(boolean[] paramArrayOfBoolean, int paramInt)
  {
    AppMethodBeat.i(91950);
    this.aMh = new r[paramInt];
    int i = 0;
    paramInt = 0;
    while (paramInt < this.aLB.length)
    {
      r localr = this.aLB[paramInt];
      Object localObject = this.aMr.aMB.boi.bof[paramInt];
      int j = i;
      if (localObject != null)
      {
        this.aMh[i] = localr;
        if (localr.getState() == 0)
        {
          t localt = this.aMr.aMB.boj[paramInt];
          if ((this.aLJ) && (this.state == 3))
          {
            j = 1;
            if ((paramArrayOfBoolean[paramInt] != 0) || (j == 0)) {
              break label176;
            }
          }
          Format[] arrayOfFormat;
          label176:
          for (boolean bool = true;; bool = false)
          {
            arrayOfFormat = new Format[((com.google.android.exoplayer2.g.f)localObject).length()];
            int k = 0;
            while (k < arrayOfFormat.length)
            {
              arrayOfFormat[k] = ((com.google.android.exoplayer2.g.f)localObject).fm(k);
              k += 1;
            }
            j = 0;
            break;
          }
          localr.a(localt, arrayOfFormat, this.aMr.aMu[paramInt], this.aMo, bool, this.aMr.rl());
          localObject = localr.qL();
          if (localObject != null)
          {
            if (this.aMf != null)
            {
              paramArrayOfBoolean = e.a(new IllegalStateException("Multiple renderer media clocks enabled."));
              AppMethodBeat.o(91950);
              throw paramArrayOfBoolean;
            }
            this.aMf = ((com.google.android.exoplayer2.i.i)localObject);
            this.aMe = localr;
            this.aMf.c(this.aLS);
          }
          if (j != 0) {
            localr.start();
          }
        }
        j = i + 1;
      }
      paramInt += 1;
      i = j;
    }
    AppMethodBeat.o(91950);
  }
  
  private boolean a(k.b paramb, long paramLong, a parama)
  {
    AppMethodBeat.i(91932);
    if ((paramb.equals(parama.aMx.aNi)) && (parama.aMy))
    {
      this.aLO.a(parama.aMx.aNi.bfZ, this.aLH, false);
      int i = this.aLH.I(paramLong);
      if ((i == -1) || (this.aLH.aNP[i] == parama.aMx.aNj))
      {
        AppMethodBeat.o(91932);
        return true;
      }
    }
    AppMethodBeat.o(91932);
    return false;
  }
  
  private void aN(boolean paramBoolean)
  {
    AppMethodBeat.i(91926);
    Handler localHandler;
    if (this.isLoading != paramBoolean)
    {
      this.isLoading = paramBoolean;
      localHandler = this.eventHandler;
      if (!paramBoolean) {
        break label47;
      }
    }
    label47:
    for (int i = 1;; i = 0)
    {
      localHandler.obtainMessage(2, i, 0).sendToTarget();
      AppMethodBeat.o(91926);
      return;
    }
  }
  
  private void aO(boolean paramBoolean)
  {
    AppMethodBeat.i(91936);
    this.handler.removeMessages(2);
    this.aMi = false;
    this.aMa.stop();
    this.aMf = null;
    this.aMe = null;
    this.aMo = 60000000L;
    Object localObject = this.aMh;
    int j = localObject.length;
    int i = 0;
    for (;;)
    {
      r localr;
      if (i < j) {
        localr = localObject[i];
      }
      try
      {
        a(localr);
        localr.disable();
        label78:
        i += 1;
        continue;
        this.aMh = new r[0];
        if (this.aMr != null) {}
        for (localObject = this.aMr;; localObject = this.aMp)
        {
          a((a)localObject);
          this.aMp = null;
          this.aMq = null;
          this.aMr = null;
          aN(false);
          if (paramBoolean)
          {
            if (this.aMg != null)
            {
              this.aMg.ts();
              this.aMg = null;
            }
            this.aMd.aLO = null;
            this.aLO = null;
          }
          AppMethodBeat.o(91936);
          return;
        }
      }
      catch (RuntimeException localRuntimeException)
      {
        break label78;
      }
      catch (e locale)
      {
        break label78;
      }
    }
  }
  
  private void b(a parama)
  {
    AppMethodBeat.i(91949);
    if (this.aMr == parama)
    {
      AppMethodBeat.o(91949);
      return;
    }
    boolean[] arrayOfBoolean = new boolean[this.aLB.length];
    int i = 0;
    int j = 0;
    if (i < this.aLB.length)
    {
      r localr = this.aLB[i];
      if (localr.getState() != 0) {}
      for (int m = 1;; m = 0)
      {
        arrayOfBoolean[i] = m;
        com.google.android.exoplayer2.g.f localf = parama.aMB.boi.bof[i];
        int k = j;
        if (localf != null) {
          k = j + 1;
        }
        if ((arrayOfBoolean[i] != 0) && ((localf == null) || ((localr.qP()) && (localr.qM() == this.aMr.aMu[i]))))
        {
          if (localr == this.aMe)
          {
            this.aMa.a(this.aMf);
            this.aMf = null;
            this.aMe = null;
          }
          a(localr);
          localr.disable();
        }
        i += 1;
        j = k;
        break;
      }
    }
    this.aMr = parama;
    this.eventHandler.obtainMessage(3, parama.aMB).sendToTarget();
    a(arrayOfBoolean, j);
    AppMethodBeat.o(91949);
  }
  
  private void c(Object paramObject, int paramInt)
  {
    AppMethodBeat.i(91942);
    this.aLT = new b(0L);
    d(paramObject, paramInt);
    this.aLT = new b(-9223372036854775807L);
    setState(4);
    aO(false);
    AppMethodBeat.o(91942);
  }
  
  /* Error */
  private void c(f.c[] paramArrayOfc)
  {
    // Byte code:
    //   0: ldc_w 520
    //   3: invokestatic 92	com/tencent/matrix/trace/core/AppMethodBeat:i	(I)V
    //   6: aload_1
    //   7: arraylength
    //   8: istore_3
    //   9: iconst_0
    //   10: istore_2
    //   11: iload_2
    //   12: iload_3
    //   13: if_icmpge +35 -> 48
    //   16: aload_1
    //   17: iload_2
    //   18: aaload
    //   19: astore 4
    //   21: aload 4
    //   23: getfield 526	com/google/android/exoplayer2/f$c:aLy	Lcom/google/android/exoplayer2/f$b;
    //   26: aload 4
    //   28: getfield 529	com/google/android/exoplayer2/f$c:aLz	I
    //   31: aload 4
    //   33: getfield 532	com/google/android/exoplayer2/f$c:aLA	Ljava/lang/Object;
    //   36: invokeinterface 538 3 0
    //   41: iload_2
    //   42: iconst_1
    //   43: iadd
    //   44: istore_2
    //   45: goto -34 -> 11
    //   48: aload_0
    //   49: getfield 106	com/google/android/exoplayer2/i:state	I
    //   52: iconst_3
    //   53: if_icmpeq +11 -> 64
    //   56: aload_0
    //   57: getfield 106	com/google/android/exoplayer2/i:state	I
    //   60: iconst_2
    //   61: if_icmpne +12 -> 73
    //   64: aload_0
    //   65: getfield 181	com/google/android/exoplayer2/i:handler	Landroid/os/Handler;
    //   68: iconst_2
    //   69: invokevirtual 307	android/os/Handler:sendEmptyMessage	(I)Z
    //   72: pop
    //   73: aload_0
    //   74: monitorenter
    //   75: aload_0
    //   76: aload_0
    //   77: getfield 540	com/google/android/exoplayer2/i:aMk	I
    //   80: iconst_1
    //   81: iadd
    //   82: putfield 540	com/google/android/exoplayer2/i:aMk	I
    //   85: aload_0
    //   86: invokevirtual 543	java/lang/Object:notifyAll	()V
    //   89: aload_0
    //   90: monitorexit
    //   91: ldc_w 520
    //   94: invokestatic 184	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   97: return
    //   98: astore_1
    //   99: aload_0
    //   100: monitorexit
    //   101: ldc_w 520
    //   104: invokestatic 184	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   107: aload_1
    //   108: athrow
    //   109: astore_1
    //   110: aload_0
    //   111: monitorenter
    //   112: aload_0
    //   113: aload_0
    //   114: getfield 540	com/google/android/exoplayer2/i:aMk	I
    //   117: iconst_1
    //   118: iadd
    //   119: putfield 540	com/google/android/exoplayer2/i:aMk	I
    //   122: aload_0
    //   123: invokevirtual 543	java/lang/Object:notifyAll	()V
    //   126: aload_0
    //   127: monitorexit
    //   128: ldc_w 520
    //   131: invokestatic 184	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   134: aload_1
    //   135: athrow
    //   136: astore_1
    //   137: aload_0
    //   138: monitorexit
    //   139: ldc_w 520
    //   142: invokestatic 184	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   145: aload_1
    //   146: athrow
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	147	0	this	i
    //   0	147	1	paramArrayOfc	f.c[]
    //   10	35	2	i	int
    //   8	6	3	j	int
    //   19	13	4	localc	f.c
    // Exception table:
    //   from	to	target	type
    //   75	91	98	finally
    //   6	9	109	finally
    //   21	41	109	finally
    //   48	64	109	finally
    //   64	73	109	finally
    //   112	128	136	finally
  }
  
  private void d(Object paramObject, int paramInt)
  {
    AppMethodBeat.i(91943);
    this.eventHandler.obtainMessage(6, new d(this.aLO, paramObject, this.aLT, paramInt)).sendToTarget();
    AppMethodBeat.o(91943);
  }
  
  private Pair<Integer, Long> dS(int paramInt)
  {
    AppMethodBeat.i(91946);
    Pair localPair = this.aLO.a(this.aLG, this.aLH, paramInt, -9223372036854775807L);
    AppMethodBeat.o(91946);
    return localPair;
  }
  
  private void e(long paramLong1, long paramLong2)
  {
    AppMethodBeat.i(91930);
    this.handler.removeMessages(2);
    paramLong1 = paramLong1 + paramLong2 - SystemClock.elapsedRealtime();
    if (paramLong1 <= 0L)
    {
      this.handler.sendEmptyMessage(2);
      AppMethodBeat.o(91930);
      return;
    }
    this.handler.sendEmptyMessageDelayed(2, paramLong1);
    AppMethodBeat.o(91930);
  }
  
  private void re()
  {
    int i = 0;
    AppMethodBeat.i(91927);
    this.aMi = false;
    this.aMa.start();
    r[] arrayOfr = this.aMh;
    int j = arrayOfr.length;
    while (i < j)
    {
      arrayOfr[i].start();
      i += 1;
    }
    AppMethodBeat.o(91927);
  }
  
  private void rf()
  {
    AppMethodBeat.i(91928);
    this.aMa.stop();
    r[] arrayOfr = this.aMh;
    int j = arrayOfr.length;
    int i = 0;
    while (i < j)
    {
      a(arrayOfr[i]);
      i += 1;
    }
    AppMethodBeat.o(91928);
  }
  
  private void rg()
  {
    AppMethodBeat.i(91929);
    if (this.aMr == null)
    {
      AppMethodBeat.o(91929);
      return;
    }
    long l1 = this.aMr.aMs.tn();
    if (l1 != -9223372036854775807L)
    {
      C(l1);
      this.aLT.aMG = l1;
      this.aMl = (SystemClock.elapsedRealtime() * 1000L);
      if (this.aMh.length != 0) {
        break label194;
      }
    }
    label194:
    for (l1 = -9223372036854775808L;; l1 = this.aMr.aMs.to())
    {
      Object localObject = this.aLT;
      long l2 = l1;
      if (l1 == -9223372036854775808L) {
        l2 = this.aMr.aMx.aNk;
      }
      ((b)localObject).aMH = l2;
      AppMethodBeat.o(91929);
      return;
      if ((this.aMe != null) && (!this.aMe.rt()))
      {
        this.aMo = this.aMf.rN();
        this.aMa.ak(this.aMo);
      }
      for (;;)
      {
        localObject = this.aMr;
        l1 = this.aMo - ((a)localObject).rl();
        break;
        this.aMo = this.aMa.rN();
      }
    }
  }
  
  private void rh()
  {
    AppMethodBeat.i(91934);
    aO(true);
    this.aLZ.qT();
    setState(1);
    AppMethodBeat.o(91934);
  }
  
  private void ri()
  {
    AppMethodBeat.i(91935);
    aO(true);
    this.aLZ.qY();
    setState(1);
    try
    {
      this.released = true;
      notifyAll();
      return;
    }
    finally
    {
      AppMethodBeat.o(91935);
    }
  }
  
  private void rj()
  {
    AppMethodBeat.i(91940);
    if ((this.aMp != null) && (!this.aMp.aMy) && ((this.aMq == null) || (this.aMq.aMA == this.aMp)))
    {
      r[] arrayOfr = this.aMh;
      int j = arrayOfr.length;
      int i = 0;
      while (i < j)
      {
        if (!arrayOfr[i].qN())
        {
          AppMethodBeat.o(91940);
          return;
        }
        i += 1;
      }
      this.aMp.aMs.tl();
    }
    AppMethodBeat.o(91940);
  }
  
  private void rk()
  {
    AppMethodBeat.i(91947);
    boolean bool = this.aMp.A(this.aMo);
    aN(bool);
    if (bool) {
      this.aMp.E(this.aMo);
    }
    AppMethodBeat.o(91947);
  }
  
  private void setState(int paramInt)
  {
    AppMethodBeat.i(91925);
    if (this.state != paramInt)
    {
      this.state = paramInt;
      this.eventHandler.obtainMessage(1, paramInt, 0).sendToTarget();
    }
    AppMethodBeat.o(91925);
  }
  
  public final void a(j paramj)
  {
    AppMethodBeat.i(91923);
    this.handler.obtainMessage(8, paramj).sendToTarget();
    AppMethodBeat.o(91923);
  }
  
  public final void a(w paramw, int paramInt, long paramLong)
  {
    AppMethodBeat.i(91919);
    this.handler.obtainMessage(3, new c(paramw, paramInt, paramLong)).sendToTarget();
    AppMethodBeat.o(91919);
  }
  
  public final void a(w paramw, Object paramObject)
  {
    AppMethodBeat.i(91922);
    this.handler.obtainMessage(7, Pair.create(paramw, paramObject)).sendToTarget();
    AppMethodBeat.o(91922);
  }
  
  /* Error */
  public final void b(f.c... paramVarArgs)
  {
    // Byte code:
    //   0: aload_0
    //   1: monitorenter
    //   2: ldc_w 632
    //   5: invokestatic 92	com/tencent/matrix/trace/core/AppMethodBeat:i	(I)V
    //   8: aload_0
    //   9: getfield 605	com/google/android/exoplayer2/i:released	Z
    //   12: ifeq +12 -> 24
    //   15: ldc_w 632
    //   18: invokestatic 184	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   21: aload_0
    //   22: monitorexit
    //   23: return
    //   24: aload_0
    //   25: getfield 634	com/google/android/exoplayer2/i:aMj	I
    //   28: istore_3
    //   29: aload_0
    //   30: iload_3
    //   31: iconst_1
    //   32: iadd
    //   33: putfield 634	com/google/android/exoplayer2/i:aMj	I
    //   36: aload_0
    //   37: getfield 181	com/google/android/exoplayer2/i:handler	Landroid/os/Handler;
    //   40: bipush 11
    //   42: aload_1
    //   43: invokevirtual 508	android/os/Handler:obtainMessage	(ILjava/lang/Object;)Landroid/os/Message;
    //   46: invokevirtual 472	android/os/Message:sendToTarget	()V
    //   49: iconst_0
    //   50: istore_2
    //   51: aload_0
    //   52: getfield 540	com/google/android/exoplayer2/i:aMk	I
    //   55: istore 4
    //   57: iload 4
    //   59: iload_3
    //   60: if_icmpgt +16 -> 76
    //   63: aload_0
    //   64: invokevirtual 637	java/lang/Object:wait	()V
    //   67: goto -16 -> 51
    //   70: astore_1
    //   71: iconst_1
    //   72: istore_2
    //   73: goto -22 -> 51
    //   76: iload_2
    //   77: ifeq +9 -> 86
    //   80: invokestatic 643	java/lang/Thread:currentThread	()Ljava/lang/Thread;
    //   83: invokevirtual 646	java/lang/Thread:interrupt	()V
    //   86: ldc_w 632
    //   89: invokestatic 184	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   92: goto -71 -> 21
    //   95: astore_1
    //   96: aload_0
    //   97: monitorexit
    //   98: aload_1
    //   99: athrow
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	100	0	this	i
    //   0	100	1	paramVarArgs	f.c[]
    //   50	27	2	i	int
    //   28	33	3	j	int
    //   55	6	4	k	int
    // Exception table:
    //   from	to	target	type
    //   63	67	70	java/lang/InterruptedException
    //   2	21	95	finally
    //   24	49	95	finally
    //   51	57	95	finally
    //   63	67	95	finally
    //   80	86	95	finally
    //   86	92	95	finally
  }
  
  public final boolean handleMessage(Message paramMessage)
  {
    AppMethodBeat.i(91924);
    try
    {
      i = paramMessage.what;
      switch (i)
      {
      default: 
        AppMethodBeat.o(91924);
        return false;
      }
    }
    catch (e paramMessage)
    {
      this.eventHandler.obtainMessage(8, paramMessage).sendToTarget();
      rh();
      AppMethodBeat.o(91924);
      return true;
      if (paramMessage.arg1 == 0) {
        break label300;
      }
      bool = true;
      this.aMi = false;
      this.aLJ = bool;
      if (bool) {
        break label306;
      }
      rf();
      rg();
      for (;;)
      {
        AppMethodBeat.o(91924);
        return true;
        bool = false;
        break;
        if (this.state != 3) {
          break label359;
        }
        re();
        this.handler.sendEmptyMessage(2);
      }
    }
    catch (IOException paramMessage)
    {
      for (;;)
      {
        this.eventHandler.obtainMessage(8, e.a(paramMessage)).sendToTarget();
        rh();
        AppMethodBeat.o(91924);
        return true;
        if (this.state == 2) {
          this.handler.sendEmptyMessage(2);
        }
      }
    }
    catch (RuntimeException paramMessage)
    {
      this.eventHandler.obtainMessage(8, e.a(paramMessage)).sendToTarget();
      rh();
      AppMethodBeat.o(91924);
      return true;
    }
    Object localObject1 = (k)paramMessage.obj;
    if (paramMessage.arg1 != 0)
    {
      i = 1;
      this.eventHandler.sendEmptyMessage(0);
      aO(true);
      this.aLZ.qX();
      if (i == 0) {
        break label197;
      }
    }
    label197:
    for (this.aLT = new b(-9223372036854775807L);; this.aLT = new b(this.aLT.aMD, this.aLT.aMG, this.aLT.aMF))
    {
      this.aMg = ((k)localObject1);
      if (localObject1 != null) {
        ((k)localObject1).a(this.aMc, this);
      }
      setState(2);
      this.handler.sendEmptyMessage(2);
      AppMethodBeat.o(91924);
      return true;
      i = 0;
      break;
    }
    label300:
    label306:
    label359:
    int i = paramMessage.arg1;
    this.aLK = i;
    this.aMd.aLK = i;
    int j;
    Object localObject2;
    label618:
    label746:
    long l1;
    label695:
    label708:
    label713:
    long l2;
    label812:
    label825:
    label1217:
    int k;
    label1556:
    label1568:
    label1706:
    label1719:
    label1738:
    label1755:
    Object localObject3;
    label1816:
    label1946:
    Object localObject4;
    if (this.aMr != null)
    {
      paramMessage = this.aMr;
    }
    else
    {
      for (;;)
      {
        j = this.aLO.a(paramMessage.aMx.aNi.bfZ, this.aLH, this.aLG, i);
        while ((paramMessage.aMA != null) && (!paramMessage.aMx.aNl))
        {
          paramMessage = paramMessage.aMA;
          continue;
          paramMessage = this.aMp;
          break label4822;
        }
        if ((j == -1) || (paramMessage.aMA == null) || (paramMessage.aMA.aMx.aNi.bfZ != j)) {
          break;
        }
        paramMessage = paramMessage.aMA;
      }
      j = this.aMp.index;
      if (this.aMq != null)
      {
        i = this.aMq.index;
        if (paramMessage.aMA != null)
        {
          a(paramMessage.aMA);
          paramMessage.aMA = null;
        }
        localObject1 = this.aMd;
        localObject2 = paramMessage.aMx;
        paramMessage.aMx = ((n)localObject1).a((n.a)localObject2, ((n.a)localObject2).aNi);
        if (j > paramMessage.index) {
          break label708;
        }
        j = 1;
        if (j == 0) {
          this.aMp = paramMessage;
        }
        if ((i == -1) || (i > paramMessage.index)) {
          break label713;
        }
      }
      for (i = 1;; i = 0)
      {
        if ((i == 0) && (this.aMr != null))
        {
          paramMessage = this.aMr.aMx.aNi;
          this.aLT = new b(paramMessage, a(paramMessage, this.aLT.aMG), this.aLT.aMF);
        }
        AppMethodBeat.o(91924);
        return true;
        i = -1;
        break;
        j = 0;
        break label618;
      }
      long l3 = SystemClock.elapsedRealtime();
      if ((this.aLO == null) && (this.aMg != null)) {
        this.aMg.tr();
      }
      long l4;
      while (this.aMr == null)
      {
        rj();
        e(l3, 10L);
        AppMethodBeat.o(91924);
        return true;
        if (this.aMp == null)
        {
          paramMessage = this.aMd;
          localObject1 = this.aLT;
          paramMessage = paramMessage.a(((b)localObject1).aMD, ((b)localObject1).aMF, ((b)localObject1).aME);
          if (paramMessage != null) {
            break label1556;
          }
          this.aMg.tr();
          if ((this.aMp != null) && (!this.aMp.rm())) {
            break label1719;
          }
          aN(false);
        }
        for (;;)
        {
          if (this.aMr == null) {
            break label1738;
          }
          while ((this.aMr != this.aMq) && (this.aMo >= this.aMr.aMA.aMw))
          {
            this.aMr.release();
            b(this.aMr.aMA);
            this.aLT = new b(this.aMr.aMx.aNi, this.aMr.aMx.aME, this.aMr.aMx.aMF);
            rg();
            this.eventHandler.obtainMessage(5, this.aLT).sendToTarget();
          }
          if ((this.aMp.aMx.aNm) || (!this.aMp.rm()) || (this.aMp.aMx.aNk == -9223372036854775807L) || ((this.aMr != null) && (this.aMp.index - this.aMr.index == 100))) {
            break label825;
          }
          paramMessage = this.aMd;
          localObject1 = this.aMp.aMx;
          l1 = this.aMp.rl();
          l2 = this.aMo;
          if (((n.a)localObject1).aNl)
          {
            i = paramMessage.aLO.a(((n.a)localObject1).aNi.bfZ, paramMessage.aLH, paramMessage.aLG, paramMessage.aLK);
            if (i == -1)
            {
              paramMessage = null;
              break;
            }
            j = paramMessage.aLO.a(i, paramMessage.aLH, false).aMI;
            if (paramMessage.aLO.a(j, paramMessage.aLG).aNZ != i) {
              break label4829;
            }
            l4 = ((n.a)localObject1).aNk;
            localObject1 = paramMessage.aLO.a(paramMessage.aLG, paramMessage.aLH, j, -9223372036854775807L, Math.max(0L, l4 + l1 - l2));
            if (localObject1 == null)
            {
              paramMessage = null;
              break;
            }
            i = ((Integer)((Pair)localObject1).first).intValue();
            l1 = ((Long)((Pair)localObject1).second).longValue();
            paramMessage = paramMessage.a(paramMessage.g(i, l1), l1, l1);
            break;
          }
          localObject2 = ((n.a)localObject1).aNi;
          if (((k.b)localObject2).isAd())
          {
            i = ((k.b)localObject2).bga;
            paramMessage.aLO.a(((k.b)localObject2).bfZ, paramMessage.aLH, false);
            j = paramMessage.aLH.aNQ[i];
            if (j == -1)
            {
              paramMessage = null;
              break;
            }
            k = ((k.b)localObject2).bgb + 1;
            if (k < j)
            {
              if (!paramMessage.aLH.bg(i, k))
              {
                paramMessage = null;
                break;
              }
              paramMessage = paramMessage.b(((k.b)localObject2).bfZ, i, k, ((n.a)localObject1).aMF);
              break;
            }
            i = paramMessage.aLH.I(((n.a)localObject1).aMF);
            if (i == -1) {}
            for (l1 = -9223372036854775808L;; l1 = paramMessage.aLH.aNP[i])
            {
              paramMessage = paramMessage.c(((k.b)localObject2).bfZ, ((n.a)localObject1).aMF, l1);
              break;
            }
          }
          if (((n.a)localObject1).aNj != -9223372036854775808L)
          {
            i = paramMessage.aLH.H(((n.a)localObject1).aNj);
            if (!paramMessage.aLH.bg(i, 0))
            {
              paramMessage = null;
              break;
            }
            paramMessage = paramMessage.b(((k.b)localObject2).bfZ, i, 0, ((n.a)localObject1).aNj);
            break;
          }
          i = paramMessage.aLH.rx();
          if ((i == 0) || (paramMessage.aLH.aNP[(i - 1)] != -9223372036854775808L) || (paramMessage.aLH.dV(i - 1)) || (!paramMessage.aLH.bg(i - 1, 0))) {
            break label4835;
          }
          l1 = paramMessage.aLH.aNk;
          paramMessage = paramMessage.b(((k.b)localObject2).bfZ, i - 1, 0, l1);
          break;
          if (this.aMp == null)
          {
            l1 = 60000000L;
            if (this.aMp != null) {
              break label1706;
            }
          }
          for (i = 0;; i = this.aMp.index + 1)
          {
            localObject1 = this.aLO.a(paramMessage.aNi.bfZ, this.aLH, true).aMt;
            localObject1 = new a(this.aLB, this.aLY, l1, this.aLC, this.aLZ, this.aMg, localObject1, i, paramMessage);
            if (this.aMp != null) {
              this.aMp.aMA = ((a)localObject1);
            }
            this.aMp = ((a)localObject1);
            this.aMp.aMs.a(this, paramMessage.aME);
            aN(true);
            break;
            l1 = this.aMp.rl() + this.aMp.aMx.aNk;
            break label1568;
          }
          if ((this.aMp != null) && (!this.isLoading)) {
            rk();
          }
        }
        continue;
        if (!this.aMq.aMx.aNm) {
          break label4847;
        }
        i = 0;
        if (i >= this.aLB.length) {
          break label4845;
        }
        paramMessage = this.aLB[i];
        localObject1 = this.aMq.aMu[i];
        if ((localObject1 == null) || (paramMessage.qM() != localObject1) || (!paramMessage.qN())) {
          break label4840;
        }
        paramMessage.qO();
        break label4840;
        if (i < this.aLB.length)
        {
          paramMessage = this.aLB[i];
          localObject1 = this.aMq.aMu[i];
          if (paramMessage.qM() == localObject1)
          {
            if (localObject1 == null) {
              break label4852;
            }
            if (paramMessage.qN()) {
              break label4852;
            }
          }
        }
        else if ((this.aMq.aMA != null) && (this.aMq.aMA.aMy))
        {
          paramMessage = this.aMq.aMB;
          this.aMq = this.aMq.aMA;
          localObject1 = this.aMq.aMB;
          if (this.aMq.aMs.tn() == -9223372036854775807L) {
            break label4864;
          }
          i = 1;
          break label4859;
          if (j >= this.aLB.length) {
            break label4874;
          }
          localObject2 = this.aLB[j];
          if (paramMessage.boi.bof[j] == null) {
            break label4869;
          }
          if (i == 0)
          {
            if (((r)localObject2).qP()) {
              break label4869;
            }
            localObject3 = localObject1.boi.bof[j];
            localObject4 = paramMessage.boj[j];
            t localt = localObject1.boj[j];
            if ((localObject3 != null) && (localt.equals(localObject4)))
            {
              localObject4 = new Format[((com.google.android.exoplayer2.g.f)localObject3).length()];
              k = 0;
              while (k < localObject4.length)
              {
                localObject4[k] = ((com.google.android.exoplayer2.g.f)localObject3).fm(k);
                k += 1;
              }
              ((r)localObject2).a((Format[])localObject4, this.aMq.aMu[j], this.aMq.rl());
              break label4869;
            }
          }
          ((r)localObject2).qO();
          break label4869;
        }
      }
      v.D("doSomeWork");
      rg();
      this.aMr.aMs.Y(this.aLT.aMG);
      i = 1;
      bool = true;
      paramMessage = this.aMh;
      int m = paramMessage.length;
      j = 0;
      if (j < m)
      {
        localObject1 = paramMessage[j];
        ((r)localObject1).f(this.aMo, this.aMl);
        if ((i == 0) || (!((r)localObject1).rt())) {
          break label4902;
        }
        i = 1;
        label2204:
        if (((r)localObject1).isReady()) {
          break label4876;
        }
        if (!((r)localObject1).rt()) {
          break label4907;
        }
        break label4876;
        label2227:
        if (k != 0) {
          break label4882;
        }
        ((r)localObject1).qQ();
        break label4882;
      }
      if (!bool) {
        rj();
      }
      if (this.aMf != null)
      {
        paramMessage = this.aMf.rR();
        if (!paramMessage.equals(this.aLS))
        {
          this.aLS = paramMessage;
          this.aMa.a(this.aMf);
          this.eventHandler.obtainMessage(7, paramMessage).sendToTarget();
        }
      }
      l1 = this.aMr.aMx.aNk;
      if ((i != 0) && ((l1 == -9223372036854775807L) || (l1 <= this.aLT.aMG)) && (this.aMr.aMx.aNm))
      {
        setState(4);
        rf();
      }
      label2368:
      while (this.state == 2)
      {
        paramMessage = this.aMh;
        j = paramMessage.length;
        i = 0;
        while (i < j)
        {
          paramMessage[i].qQ();
          i += 1;
        }
        if (this.state == 2)
        {
          if (this.aMh.length > 0)
          {
            if (!bool) {
              break label4930;
            }
            paramMessage = this.aMp;
            bool = this.aMi;
            l4 = this.aMo;
            if (!paramMessage.aMy)
            {
              l1 = paramMessage.aMx.aME;
              l2 = l1;
              if (l1 != -9223372036854775808L) {
                break label2536;
              }
              if (!paramMessage.aMx.aNm) {
                break label2527;
              }
              bool = true;
              break label4919;
            }
          }
          for (;;)
          {
            if (!bool) {
              break label4934;
            }
            setState(3);
            if (!this.aLJ) {
              break;
            }
            re();
            break;
            l1 = paramMessage.aMs.to();
            break label2460;
            label2527:
            l2 = paramMessage.aMx.aNk;
            label2536:
            bool = paramMessage.aLZ.b(l2 - (l4 - paramMessage.rl()), bool);
            break label4919;
            bool = D(l1);
          }
        }
        if (this.state == 3)
        {
          if (this.aMh.length > 0) {}
          for (;;)
          {
            if (bool) {
              break label2623;
            }
            this.aMi = this.aLJ;
            setState(2);
            rf();
            break;
            bool = D(l1);
          }
        }
      }
      label2460:
      label2489:
      label2623:
      if (((this.aLJ) && (this.state == 3)) || (this.state == 2)) {
        e(l3, 10L);
      }
      for (;;)
      {
        v.gH();
        break;
        if ((this.aMh.length != 0) && (this.state != 4)) {
          e(l3, 1000L);
        } else {
          this.handler.removeMessages(2);
        }
      }
      paramMessage = (c)paramMessage.obj;
      if (this.aLO == null)
      {
        this.aMm += 1;
        this.aMn = paramMessage;
      }
      for (;;)
      {
        AppMethodBeat.o(91924);
        return true;
        localObject1 = a(paramMessage);
        if (localObject1 == null)
        {
          this.aLT = new b(0L);
          this.eventHandler.obtainMessage(4, 1, 0, this.aLT).sendToTarget();
          this.aLT = new b(-9223372036854775807L);
          setState(4);
          aO(false);
        }
        else
        {
          if (paramMessage.aMJ == -9223372036854775807L)
          {
            i = 1;
            label2821:
            j = ((Integer)((Pair)localObject1).first).intValue();
            l2 = ((Long)((Pair)localObject1).second).longValue();
            localObject1 = this.aMd.g(j, l2);
            bool = ((k.b)localObject1).isAd();
            if (!bool) {
              break label4815;
            }
            l1 = 0L;
            i = 1;
          }
          try
          {
            label2875:
            if (((k.b)localObject1).equals(this.aLT.aMD))
            {
              l3 = l1 / 1000L;
              l4 = this.aLT.aMG / 1000L;
              if (l3 == l4)
              {
                this.aLT = new b((k.b)localObject1, l1, l2);
                paramMessage = this.eventHandler;
                if (i != 0) {}
                for (i = 1;; i = 0)
                {
                  paramMessage.obtainMessage(4, i, 0, this.aLT).sendToTarget();
                  break;
                  i = 0;
                  break label2821;
                }
              }
            }
            l3 = a((k.b)localObject1, l1);
            if (l1 == l3) {
              break label4936;
            }
            j = 1;
            label2994:
            this.aLT = new b((k.b)localObject1, l3, l2);
            paramMessage = this.eventHandler;
            if ((i | j) == 0) {
              break label4941;
            }
            i = 1;
            label3024:
            paramMessage.obtainMessage(4, i, 0, this.aLT).sendToTarget();
          }
          finally
          {
            this.aLT = new b((k.b)localObject1, l1, l2);
            localObject1 = this.eventHandler;
            if (i == 0) {
              break label4946;
            }
          }
        }
      }
      i = 1;
      label3071:
      ((Handler)localObject1).obtainMessage(4, i, 0, this.aLT).sendToTarget();
      AppMethodBeat.o(91924);
      throw paramMessage;
      paramMessage = (p)paramMessage.obj;
      if (this.aMf != null) {}
      for (paramMessage = this.aMf.c(paramMessage);; paramMessage = this.aMa.c(paramMessage))
      {
        this.aLS = paramMessage;
        this.eventHandler.obtainMessage(7, paramMessage).sendToTarget();
        AppMethodBeat.o(91924);
        return true;
      }
      rh();
      AppMethodBeat.o(91924);
      return true;
      ri();
      AppMethodBeat.o(91924);
      return true;
      paramMessage = (j)paramMessage.obj;
      if (this.aMp != null)
      {
        localObject1 = this.aMp.aMs;
        if (localObject1 == paramMessage) {
          break label3220;
        }
      }
      for (;;)
      {
        AppMethodBeat.o(91924);
        return true;
        label3220:
        paramMessage = this.aMp;
        paramMessage.aMy = true;
        paramMessage.rn();
        l1 = paramMessage.F(paramMessage.aMx.aME);
        localObject1 = paramMessage.aMx;
        paramMessage.aMx = new n.a(((n.a)localObject1).aNi, l1, ((n.a)localObject1).aNj, ((n.a)localObject1).aMF, ((n.a)localObject1).aNk, ((n.a)localObject1).aNl, ((n.a)localObject1).aNm);
        if (this.aMr == null)
        {
          this.aMq = this.aMp;
          C(this.aMq.aMx.aME);
          b(this.aMq);
        }
        rk();
      }
      paramMessage = (Pair)paramMessage.obj;
      localObject3 = this.aLO;
      this.aLO = ((w)paramMessage.first);
      this.aMd.aLO = this.aLO;
      localObject2 = paramMessage.second;
      if (localObject3 == null)
      {
        if (this.aMm > 0)
        {
          paramMessage = a(this.aMn);
          i = this.aMm;
          this.aMm = 0;
          this.aMn = null;
          if (paramMessage == null) {
            c(localObject2, i);
          }
        }
        for (;;)
        {
          AppMethodBeat.o(91924);
          return true;
          j = ((Integer)paramMessage.first).intValue();
          l2 = ((Long)paramMessage.second).longValue();
          paramMessage = this.aMd.g(j, l2);
          if (!paramMessage.isAd()) {
            break;
          }
          l1 = 0L;
          label3482:
          this.aLT = new b(paramMessage, l1, l2);
          d(localObject2, i);
          continue;
          if (this.aLT.aME == -9223372036854775807L)
          {
            if (this.aLO.isEmpty())
            {
              c(localObject2, 0);
            }
            else
            {
              paramMessage = dS(0);
              i = ((Integer)paramMessage.first).intValue();
              l2 = ((Long)paramMessage.second).longValue();
              paramMessage = this.aMd.g(i, l2);
              if (!paramMessage.isAd()) {
                break label4958;
              }
              l1 = 0L;
              label3592:
              this.aLT = new b(paramMessage, l1, l2);
            }
          }
          else {
            d(localObject2, 0);
          }
        }
      }
      j = this.aLT.aMD.bfZ;
      if (this.aMr != null)
      {
        paramMessage = this.aMr;
        label3641:
        if ((paramMessage == null) && (j >= ((w)localObject3).rw())) {
          break label3903;
        }
        if (paramMessage != null) {
          break label3724;
        }
      }
      label3724:
      for (localObject1 = ((w)localObject3).a(j, this.aLH, true).aMt;; localObject1 = paramMessage.aMt)
      {
        i = this.aLO.W(localObject1);
        if (i != -1) {
          break label3913;
        }
        i = a(j, (w)localObject3, this.aLO);
        if (i != -1) {
          break label3733;
        }
        c(localObject2, 0);
        break;
        paramMessage = this.aMp;
        break label3641;
      }
      label3733:
      localObject1 = dS(this.aLO.a(i, this.aLH, false).aMI);
      i = ((Integer)((Pair)localObject1).first).intValue();
      l1 = ((Long)((Pair)localObject1).second).longValue();
      this.aLO.a(i, this.aLH, true);
      if (paramMessage != null)
      {
        localObject1 = this.aLH.aMt;
        paramMessage.aMx = paramMessage.aMx.rr();
        while (paramMessage.aMA != null)
        {
          paramMessage = paramMessage.aMA;
          if (paramMessage.aMt.equals(localObject1)) {
            paramMessage.aMx = this.aMd.a(paramMessage.aMx, i);
          } else {
            paramMessage.aMx = paramMessage.aMx.rr();
          }
        }
      }
      paramMessage = new k.b(i);
      this.aLT = new b(paramMessage, a(paramMessage, l1));
      for (;;)
      {
        label3903:
        d(localObject2, 0);
        break;
        label3913:
        if (i != j)
        {
          localObject1 = this.aLT;
          localObject3 = new b(((b)localObject1).aMD.eQ(i), ((b)localObject1).aME, ((b)localObject1).aMF);
          ((b)localObject3).aMG = ((b)localObject1).aMG;
          ((b)localObject3).aMH = ((b)localObject1).aMH;
          this.aLT = ((b)localObject3);
        }
        if (this.aLT.aMD.isAd())
        {
          localObject1 = this.aMd.g(i, this.aLT.aMF);
          if ((!((k.b)localObject1).isAd()) || (((k.b)localObject1).bgb != this.aLT.aMD.bgb))
          {
            l2 = a((k.b)localObject1, this.aLT.aMF);
            if (!((k.b)localObject1).isAd()) {
              break label4965;
            }
            l1 = this.aLT.aMF;
            label4066:
            this.aLT = new b((k.b)localObject1, l2, l1);
            continue;
          }
        }
        if (paramMessage != null)
        {
          for (paramMessage = a(paramMessage, i); paramMessage.aMA != null; paramMessage = a((a)localObject1, i))
          {
            localObject1 = paramMessage.aMA;
            i = this.aLO.a(i, this.aLH, this.aLG, this.aLK);
            if ((i == -1) || (!((a)localObject1).aMt.equals(this.aLO.a(i, this.aLH, true).aMt))) {
              break label4174;
            }
          }
          continue;
          label4174:
          if ((this.aMq == null) || (this.aMq.index >= ((a)localObject1).index)) {
            break label4973;
          }
          i = 1;
          label4198:
          if (i == 0)
          {
            l1 = a(this.aMr.aMx.aNi, this.aLT.aMG);
            this.aLT = new b(this.aMr.aMx.aNi, l1, this.aLT.aMF);
          }
          else
          {
            this.aMp = paramMessage;
            this.aMp.aMA = null;
            a((a)localObject1);
          }
        }
      }
      paramMessage = (j)paramMessage.obj;
      if (this.aMp != null)
      {
        localObject1 = this.aMp.aMs;
        if (localObject1 == paramMessage) {
          break label4317;
        }
      }
      for (;;)
      {
        AppMethodBeat.o(91924);
        return true;
        label4317:
        rk();
      }
      if (this.aMr != null)
      {
        paramMessage = this.aMr;
        i = 1;
      }
      for (;;)
      {
        if (paramMessage != null)
        {
          bool = paramMessage.aMy;
          if (bool) {}
        }
        else
        {
          AppMethodBeat.o(91924);
          return true;
        }
        if (paramMessage.rn()) {
          break;
        }
        if (paramMessage == this.aMq) {
          i = 0;
        }
        paramMessage = paramMessage.aMA;
      }
      if (i != 0)
      {
        if (this.aMq == this.aMr) {
          break label4988;
        }
        bool = true;
        label4404:
        a(this.aMr.aMA);
        this.aMr.aMA = null;
        this.aMp = this.aMr;
        this.aMq = this.aMr;
        localObject1 = new boolean[this.aLB.length];
        l1 = this.aMr.a(this.aLT.aMG, bool, (boolean[])localObject1);
        if (l1 != this.aLT.aMG)
        {
          this.aLT.aMG = l1;
          C(l1);
        }
        j = 0;
        localObject2 = new boolean[this.aLB.length];
        i = 0;
        label4508:
        if (i < this.aLB.length)
        {
          localObject3 = this.aLB[i];
          if (((r)localObject3).getState() == 0) {
            break label4994;
          }
        }
      }
    }
    label4864:
    label4994:
    for (boolean bool = true;; bool = false)
    {
      localObject2[i] = bool;
      localObject4 = this.aMr.aMu[i];
      k = j;
      if (localObject4 != null) {
        k = j + 1;
      }
      if (localObject2[i] != 0) {
        if (localObject4 != ((r)localObject3).qM())
        {
          if (localObject3 == this.aMe)
          {
            if (localObject4 == null) {
              this.aMa.a(this.aMf);
            }
            this.aMf = null;
            this.aMe = null;
          }
          a((r)localObject3);
          ((r)localObject3).disable();
        }
        else if (localObject1[i] != 0)
        {
          ((r)localObject3).w(this.aMo);
          break label4978;
          this.eventHandler.obtainMessage(3, paramMessage.aMB).sendToTarget();
          a((boolean[])localObject2, j);
          for (;;)
          {
            rk();
            rg();
            this.handler.sendEmptyMessage(2);
            break;
            this.aMp = paramMessage;
            for (paramMessage = this.aMp.aMA; paramMessage != null; paramMessage = paramMessage.aMA) {
              paramMessage.release();
            }
            this.aMp.aMA = null;
            if (this.aMp.aMy)
            {
              l1 = this.aMp.aMx.aME;
              paramMessage = this.aMp;
              l1 = Math.max(l1, this.aMo - paramMessage.rl());
              this.aMp.F(l1);
            }
          }
          c((f.c[])paramMessage.obj);
          AppMethodBeat.o(91924);
          return true;
          label4815:
          l1 = l2;
          break label2875;
          label4822:
          if (paramMessage == null) {
            break label695;
          }
          break;
          label4829:
          l1 = 0L;
          break label1217;
          label4835:
          paramMessage = null;
          break label812;
          label4840:
          i += 1;
          break label1755;
          label4845:
          break label746;
          label4847:
          i = 0;
          break label1816;
          label4852:
          i += 1;
          break label1816;
          for (;;)
          {
            label4859:
            j = 0;
            break;
            i = 0;
          }
          label4869:
          j += 1;
          break label1946;
          label4874:
          break label746;
          label4876:
          k = 1;
          break label2227;
          label4882:
          if ((bool) && (k != 0)) {}
          for (bool = true;; bool = false)
          {
            j += 1;
            break;
            label4902:
            i = 0;
            break label2204;
            label4907:
            k = 0;
            break label2227;
          }
          label4919:
          if (bool)
          {
            bool = true;
            break label2489;
          }
          label4930:
          bool = false;
          break label2489;
          label4934:
          break label2368;
          label4936:
          j = 0;
          break label2994;
          label4941:
          i = 0;
          break label3024;
          label4946:
          i = 0;
          break label3071;
          l1 = l2;
          break label3482;
          label4958:
          l1 = l2;
          break label3592;
          label4965:
          l1 = -9223372036854775807L;
          break label4066;
          label4973:
          i = 0;
          break label4198;
        }
      }
      label4978:
      i += 1;
      j = k;
      break label4508;
      label4988:
      bool = false;
      break label4404;
    }
  }
  
  /* Error */
  public final void release()
  {
    // Byte code:
    //   0: aload_0
    //   1: monitorenter
    //   2: ldc_w 870
    //   5: invokestatic 92	com/tencent/matrix/trace/core/AppMethodBeat:i	(I)V
    //   8: aload_0
    //   9: getfield 605	com/google/android/exoplayer2/i:released	Z
    //   12: ifeq +12 -> 24
    //   15: ldc_w 870
    //   18: invokestatic 184	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   21: aload_0
    //   22: monitorexit
    //   23: return
    //   24: aload_0
    //   25: getfield 181	com/google/android/exoplayer2/i:handler	Landroid/os/Handler;
    //   28: bipush 6
    //   30: invokevirtual 307	android/os/Handler:sendEmptyMessage	(I)Z
    //   33: pop
    //   34: iconst_0
    //   35: istore_1
    //   36: aload_0
    //   37: getfield 605	com/google/android/exoplayer2/i:released	Z
    //   40: istore_2
    //   41: iload_2
    //   42: ifne +16 -> 58
    //   45: aload_0
    //   46: invokevirtual 637	java/lang/Object:wait	()V
    //   49: goto -13 -> 36
    //   52: astore_3
    //   53: iconst_1
    //   54: istore_1
    //   55: goto -19 -> 36
    //   58: iload_1
    //   59: ifeq +9 -> 68
    //   62: invokestatic 643	java/lang/Thread:currentThread	()Ljava/lang/Thread;
    //   65: invokevirtual 646	java/lang/Thread:interrupt	()V
    //   68: aload_0
    //   69: getfield 167	com/google/android/exoplayer2/i:aMb	Landroid/os/HandlerThread;
    //   72: invokevirtual 873	android/os/HandlerThread:quit	()Z
    //   75: pop
    //   76: ldc_w 870
    //   79: invokestatic 184	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   82: goto -61 -> 21
    //   85: astore_3
    //   86: aload_0
    //   87: monitorexit
    //   88: aload_3
    //   89: athrow
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	90	0	this	i
    //   35	24	1	i	int
    //   40	2	2	bool	boolean
    //   52	1	3	localInterruptedException	java.lang.InterruptedException
    //   85	4	3	localObject	Object
    // Exception table:
    //   from	to	target	type
    //   45	49	52	java/lang/InterruptedException
    //   2	21	85	finally
    //   24	34	85	finally
    //   36	41	85	finally
    //   45	49	85	finally
    //   62	68	85	finally
    //   68	82	85	finally
  }
  
  static final class a
  {
    private final r[] aLB;
    private final h aLC;
    private final s[] aLY;
    final m aLZ;
    public a aMA;
    public com.google.android.exoplayer2.g.i aMB;
    private com.google.android.exoplayer2.g.i aMC;
    private final k aMg;
    public final j aMs;
    public final Object aMt;
    public final com.google.android.exoplayer2.source.n[] aMu;
    public final boolean[] aMv;
    public final long aMw;
    public n.a aMx;
    public boolean aMy;
    public boolean aMz;
    public final int index;
    
    public a(r[] paramArrayOfr, s[] paramArrayOfs, long paramLong, h paramh, m paramm, k paramk, Object paramObject, int paramInt, n.a parama)
    {
      AppMethodBeat.i(91909);
      this.aLB = paramArrayOfr;
      this.aLY = paramArrayOfs;
      this.aMw = paramLong;
      this.aLC = paramh;
      this.aLZ = paramm;
      this.aMg = paramk;
      this.aMt = a.checkNotNull(paramObject);
      this.index = paramInt;
      this.aMx = parama;
      this.aMu = new com.google.android.exoplayer2.source.n[paramArrayOfr.length];
      this.aMv = new boolean[paramArrayOfr.length];
      paramArrayOfr = paramk.a(parama.aNi, paramm.qZ());
      if (parama.aNj != -9223372036854775808L)
      {
        paramArrayOfr = new d(paramArrayOfr, true);
        paramArrayOfr.i(0L, parama.aNj);
      }
      for (;;)
      {
        this.aMs = paramArrayOfr;
        AppMethodBeat.o(91909);
        return;
      }
    }
    
    public final boolean A(long paramLong)
    {
      AppMethodBeat.i(91911);
      if (!this.aMy) {}
      for (long l1 = 0L; l1 == -9223372036854775808L; l1 = this.aMs.tp())
      {
        AppMethodBeat.o(91911);
        return false;
      }
      long l2 = rl();
      boolean bool = this.aLZ.A(l1 - (paramLong - l2));
      AppMethodBeat.o(91911);
      return bool;
    }
    
    public final void E(long paramLong)
    {
      AppMethodBeat.i(91912);
      long l = rl();
      this.aMs.aa(paramLong - l);
      AppMethodBeat.o(91912);
    }
    
    public final long F(long paramLong)
    {
      AppMethodBeat.i(91914);
      paramLong = a(paramLong, false, new boolean[this.aLB.length]);
      AppMethodBeat.o(91914);
      return paramLong;
    }
    
    public final long a(long paramLong, boolean paramBoolean, boolean[] paramArrayOfBoolean)
    {
      AppMethodBeat.i(91915);
      g localg = this.aMB.boi;
      int i = 0;
      if (i < localg.length)
      {
        boolean[] arrayOfBoolean = this.aMv;
        if ((!paramBoolean) && (this.aMB.a(this.aMC, i))) {}
        for (int j = 1;; j = 0)
        {
          arrayOfBoolean[i] = j;
          i += 1;
          break;
        }
      }
      paramLong = this.aMs.a(localg.uC(), this.aMv, this.aMu, paramArrayOfBoolean, paramLong);
      this.aMC = this.aMB;
      this.aMz = false;
      i = 0;
      if (i < this.aMu.length)
      {
        if (this.aMu[i] != null)
        {
          if (localg.bof[i] != null) {}
          for (paramBoolean = true;; paramBoolean = false)
          {
            a.checkState(paramBoolean);
            this.aMz = true;
            i += 1;
            break;
          }
        }
        if (localg.bof[i] == null) {}
        for (paramBoolean = true;; paramBoolean = false)
        {
          a.checkState(paramBoolean);
          break;
        }
      }
      this.aLZ.a(this.aLB, localg);
      AppMethodBeat.o(91915);
      return paramLong;
    }
    
    public final void release()
    {
      AppMethodBeat.i(91916);
      try
      {
        if (this.aMx.aNj != -9223372036854775808L)
        {
          this.aMg.b(((d)this.aMs).aMs);
          AppMethodBeat.o(91916);
          return;
        }
        this.aMg.b(this.aMs);
        AppMethodBeat.o(91916);
        return;
      }
      catch (RuntimeException localRuntimeException)
      {
        AppMethodBeat.o(91916);
      }
    }
    
    public final long rl()
    {
      if (this.index == 0) {
        return this.aMw;
      }
      return this.aMw - this.aMx.aME;
    }
    
    public final boolean rm()
    {
      AppMethodBeat.i(91910);
      if ((this.aMy) && ((!this.aMz) || (this.aMs.to() == -9223372036854775808L)))
      {
        AppMethodBeat.o(91910);
        return true;
      }
      AppMethodBeat.o(91910);
      return false;
    }
    
    public final boolean rn()
    {
      AppMethodBeat.i(91913);
      com.google.android.exoplayer2.g.i locali = this.aLC.a(this.aLY, this.aMs.tm());
      if (locali.a(this.aMC))
      {
        AppMethodBeat.o(91913);
        return false;
      }
      this.aMB = locali;
      AppMethodBeat.o(91913);
      return true;
    }
  }
  
  public static final class b
  {
    public final k.b aMD;
    public final long aME;
    public final long aMF;
    public volatile long aMG;
    public volatile long aMH;
    
    public b(long paramLong)
    {
      this(new k.b(0), paramLong);
      AppMethodBeat.i(91917);
      AppMethodBeat.o(91917);
    }
    
    public b(k.b paramb, long paramLong)
    {
      this(paramb, paramLong, -9223372036854775807L);
    }
    
    public b(k.b paramb, long paramLong1, long paramLong2)
    {
      this.aMD = paramb;
      this.aME = paramLong1;
      this.aMF = paramLong2;
      this.aMG = paramLong1;
      this.aMH = paramLong1;
    }
  }
  
  static final class c
  {
    public final w aLO;
    public final int aMI;
    public final long aMJ;
    
    public c(w paramw, int paramInt, long paramLong)
    {
      this.aLO = paramw;
      this.aMI = paramInt;
      this.aMJ = paramLong;
    }
  }
  
  public static final class d
  {
    public final w aLO;
    public final Object aLP;
    public final i.b aLT;
    public final int aMK;
    
    public d(w paramw, Object paramObject, i.b paramb, int paramInt)
    {
      this.aLO = paramw;
      this.aLP = paramObject;
      this.aLT = paramb;
      this.aMK = paramInt;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes9.jar
 * Qualified Name:     com.google.android.exoplayer2.i
 * JD-Core Version:    0.7.0.1
 */