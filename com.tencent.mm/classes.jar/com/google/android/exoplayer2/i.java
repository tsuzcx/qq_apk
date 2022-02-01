package com.google.android.exoplayer2;

import android.os.Handler;
import android.os.Handler.Callback;
import android.os.HandlerThread;
import android.os.Message;
import android.os.SystemClock;
import android.util.Pair;
import com.google.android.exoplayer2.g.g;
import com.google.android.exoplayer2.i.a;
import com.google.android.exoplayer2.i.v;
import com.google.android.exoplayer2.source.c;
import com.tencent.matrix.trace.core.AppMethodBeat;
import java.io.IOException;

final class i
  implements Handler.Callback, com.google.android.exoplayer2.g.h.a, com.google.android.exoplayer2.source.h.a, com.google.android.exoplayer2.source.i.a
{
  private final r[] aRK;
  private final com.google.android.exoplayer2.g.h aRL;
  private final w.b aRP;
  private final w.a aRQ;
  private boolean aRS;
  private w aRW;
  private p aSa;
  private b aSb;
  private final s[] aSg;
  private final m aSh;
  private final com.google.android.exoplayer2.i.s aSi;
  private final HandlerThread aSj;
  private final f aSk;
  private final n aSl;
  private r aSm;
  private com.google.android.exoplayer2.i.i aSn;
  private com.google.android.exoplayer2.source.i aSo;
  private r[] aSp;
  private boolean aSq;
  int aSr;
  private int aSs;
  private long aSt;
  private int aSu;
  private c aSv;
  private long aSw;
  private a aSx;
  private a aSy;
  private a aSz;
  private final Handler eventHandler;
  final Handler handler;
  private boolean isLoading;
  boolean released;
  private int repeatMode;
  private int state;
  
  public i(r[] paramArrayOfr, com.google.android.exoplayer2.g.h paramh, m paramm, boolean paramBoolean, int paramInt, Handler paramHandler, b paramb, f paramf)
  {
    AppMethodBeat.i(91918);
    this.aRK = paramArrayOfr;
    this.aRL = paramh;
    this.aSh = paramm;
    this.aRS = paramBoolean;
    this.repeatMode = paramInt;
    this.eventHandler = paramHandler;
    this.state = 1;
    this.aSb = paramb;
    this.aSk = paramf;
    this.aSg = new s[paramArrayOfr.length];
    paramInt = 0;
    while (paramInt < paramArrayOfr.length)
    {
      paramArrayOfr[paramInt].setIndex(paramInt);
      this.aSg[paramInt] = paramArrayOfr[paramInt].rs();
      paramInt += 1;
    }
    this.aSi = new com.google.android.exoplayer2.i.s();
    this.aSp = new r[0];
    this.aRP = new w.b();
    this.aRQ = new w.a();
    this.aSl = new n();
    paramh.bun = this;
    this.aSa = p.aTv;
    this.aSj = new HandlerThread("ExoPlayerImplInternal:Handler", -16);
    this.aSj.start();
    this.handler = new Handler(this.aSj.getLooper(), this);
    AppMethodBeat.o(91918);
  }
  
  private boolean A(long paramLong)
  {
    AppMethodBeat.i(91939);
    if ((paramLong == -9223372036854775807L) || (this.aSb.aSO < paramLong) || ((this.aSz.aSI != null) && ((this.aSz.aSI.aSG) || (this.aSz.aSI.aSF.aTq.tY()))))
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
    int m = paramw1.sa();
    int k = 0;
    int i = -1;
    int j = paramInt;
    paramInt = k;
    while ((paramInt < m) && (i == -1))
    {
      j = paramw1.a(j, this.aRQ, this.aRP, this.repeatMode);
      if (j == -1) {
        break;
      }
      i = paramw2.ac(paramw1.a(j, this.aRQ, true).aSB);
      paramInt += 1;
    }
    AppMethodBeat.o(91944);
    return i;
  }
  
  private long a(com.google.android.exoplayer2.source.i.b paramb, long paramLong)
  {
    AppMethodBeat.i(91931);
    rI();
    this.aSq = false;
    setState(2);
    Object localObject;
    if (this.aSz == null)
    {
      if (this.aSx == null) {
        break label288;
      }
      this.aSx.release();
      localObject = null;
    }
    for (;;)
    {
      if ((this.aSz != localObject) || (this.aSz != this.aSy))
      {
        paramb = this.aSp;
        int j = paramb.length;
        int i = 0;
        for (;;)
        {
          if (i < j)
          {
            paramb[i].disable();
            i += 1;
            continue;
            a locala1 = this.aSz;
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
              locala1 = locala1.aSI;
              break;
              locala1.release();
            }
          }
        }
        this.aSp = new r[0];
        this.aSn = null;
        this.aSm = null;
        this.aSz = null;
      }
      if (localObject != null)
      {
        localObject.aSI = null;
        this.aSx = localObject;
        this.aSy = localObject;
        b(localObject);
        long l = paramLong;
        if (this.aSz.aSH) {
          l = this.aSz.aSA.W(paramLong);
        }
        z(l);
        rM();
        paramLong = l;
      }
      for (;;)
      {
        this.handler.sendEmptyMessage(2);
        AppMethodBeat.o(91931);
        return paramLong;
        this.aSx = null;
        this.aSy = null;
        this.aSz = null;
        z(paramLong);
      }
      label288:
      localObject = null;
    }
  }
  
  private Pair<Integer, Long> a(c paramc)
  {
    AppMethodBeat.i(91945);
    Object localObject2 = paramc.aRW;
    Object localObject1 = localObject2;
    if (((w)localObject2).isEmpty()) {
      localObject1 = this.aRW;
    }
    try
    {
      localObject2 = ((w)localObject1).a(this.aRP, this.aRQ, paramc.aSQ, paramc.aSR);
      if (this.aRW == localObject1)
      {
        AppMethodBeat.o(91945);
        return localObject2;
      }
    }
    catch (IndexOutOfBoundsException localIndexOutOfBoundsException)
    {
      paramc = new l(this.aRW, paramc.aSQ, paramc.aSR);
      AppMethodBeat.o(91945);
      throw paramc;
    }
    int i = this.aRW.ac(localIndexOutOfBoundsException.a(((Integer)((Pair)localObject2).first).intValue(), this.aRQ, true).aSB);
    if (i != -1)
    {
      paramc = Pair.create(Integer.valueOf(i), ((Pair)localObject2).second);
      AppMethodBeat.o(91945);
      return paramc;
    }
    i = a(((Integer)((Pair)localObject2).first).intValue(), localIndexOutOfBoundsException, this.aRW);
    if (i != -1)
    {
      paramc = dF(this.aRW.a(i, this.aRQ, false).aSQ);
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
      parama.aSF = this.aSl.a(parama.aSF, paramInt);
      if ((parama.aSF.aTt) || (parama.aSI == null))
      {
        AppMethodBeat.o(91941);
        return parama;
      }
      parama = parama.aSI;
    }
  }
  
  private static void a(a parama)
  {
    AppMethodBeat.i(91948);
    while (parama != null)
    {
      parama.release();
      parama = parama.aSI;
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
    this.aSp = new r[paramInt];
    int i = 0;
    paramInt = 0;
    while (paramInt < this.aRK.length)
    {
      r localr = this.aRK[paramInt];
      Object localObject = this.aSz.aSJ.bup.bum[paramInt];
      int j = i;
      if (localObject != null)
      {
        this.aSp[i] = localr;
        if (localr.getState() == 0)
        {
          t localt = this.aSz.aSJ.buq[paramInt];
          if ((this.aRS) && (this.state == 3))
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
              arrayOfFormat[k] = ((com.google.android.exoplayer2.g.f)localObject).eR(k);
              k += 1;
            }
            j = 0;
            break;
          }
          localr.a(localt, arrayOfFormat, this.aSz.aSC[paramInt], this.aSw, bool, this.aSz.rN());
          localObject = localr.rt();
          if (localObject != null)
          {
            if (this.aSn != null)
            {
              paramArrayOfBoolean = e.a(new IllegalStateException("Multiple renderer media clocks enabled."));
              AppMethodBeat.o(91950);
              throw paramArrayOfBoolean;
            }
            this.aSn = ((com.google.android.exoplayer2.i.i)localObject);
            this.aSm = localr;
            this.aSn.c(this.aSa);
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
  
  private boolean a(com.google.android.exoplayer2.source.i.b paramb, long paramLong, a parama)
  {
    AppMethodBeat.i(91932);
    if ((paramb.equals(parama.aSF.aTq)) && (parama.aSG))
    {
      this.aRW.a(parama.aSF.aTq.bmb, this.aRQ, false);
      int i = this.aRQ.F(paramLong);
      if ((i == -1) || (this.aRQ.aTX[i] == parama.aSF.aTr))
      {
        AppMethodBeat.o(91932);
        return true;
      }
    }
    AppMethodBeat.o(91932);
    return false;
  }
  
  private void aP(boolean paramBoolean)
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
  
  private void aQ(boolean paramBoolean)
  {
    AppMethodBeat.i(91936);
    this.handler.removeMessages(2);
    this.aSq = false;
    this.aSi.stop();
    this.aSn = null;
    this.aSm = null;
    this.aSw = 60000000L;
    Object localObject = this.aSp;
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
        this.aSp = new r[0];
        if (this.aSz != null) {}
        for (localObject = this.aSz;; localObject = this.aSx)
        {
          a((a)localObject);
          this.aSx = null;
          this.aSy = null;
          this.aSz = null;
          aP(false);
          if (paramBoolean)
          {
            if (this.aSo != null)
            {
              this.aSo.tP();
              this.aSo = null;
            }
            this.aSl.aRW = null;
            this.aRW = null;
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
    if (this.aSz == parama)
    {
      AppMethodBeat.o(91949);
      return;
    }
    boolean[] arrayOfBoolean = new boolean[this.aRK.length];
    int i = 0;
    int j = 0;
    if (i < this.aRK.length)
    {
      r localr = this.aRK[i];
      if (localr.getState() != 0) {}
      for (int m = 1;; m = 0)
      {
        arrayOfBoolean[i] = m;
        com.google.android.exoplayer2.g.f localf = parama.aSJ.bup.bum[i];
        int k = j;
        if (localf != null) {
          k = j + 1;
        }
        if ((arrayOfBoolean[i] != 0) && ((localf == null) || ((localr.rx()) && (localr.ru() == this.aSz.aSC[i]))))
        {
          if (localr == this.aSm)
          {
            this.aSi.a(this.aSn);
            this.aSn = null;
            this.aSm = null;
          }
          a(localr);
          localr.disable();
        }
        i += 1;
        j = k;
        break;
      }
    }
    this.aSz = parama;
    this.eventHandler.obtainMessage(3, parama.aSJ).sendToTarget();
    a(arrayOfBoolean, j);
    AppMethodBeat.o(91949);
  }
  
  private void c(Object paramObject, int paramInt)
  {
    AppMethodBeat.i(91942);
    this.aSb = new b(0L);
    d(paramObject, paramInt);
    this.aSb = new b(-9223372036854775807L);
    setState(4);
    aQ(false);
    AppMethodBeat.o(91942);
  }
  
  /* Error */
  private void c(f.c[] paramArrayOfc)
  {
    // Byte code:
    //   0: ldc_w 515
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
    //   23: getfield 521	com/google/android/exoplayer2/f$c:aRH	Lcom/google/android/exoplayer2/f$b;
    //   26: aload 4
    //   28: getfield 524	com/google/android/exoplayer2/f$c:aRI	I
    //   31: aload 4
    //   33: getfield 527	com/google/android/exoplayer2/f$c:aRJ	Ljava/lang/Object;
    //   36: invokeinterface 532 3 0
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
    //   69: invokevirtual 293	android/os/Handler:sendEmptyMessage	(I)Z
    //   72: pop
    //   73: aload_0
    //   74: monitorenter
    //   75: aload_0
    //   76: aload_0
    //   77: getfield 534	com/google/android/exoplayer2/i:aSs	I
    //   80: iconst_1
    //   81: iadd
    //   82: putfield 534	com/google/android/exoplayer2/i:aSs	I
    //   85: aload_0
    //   86: invokevirtual 537	java/lang/Object:notifyAll	()V
    //   89: aload_0
    //   90: monitorexit
    //   91: ldc_w 515
    //   94: invokestatic 184	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   97: return
    //   98: astore_1
    //   99: aload_0
    //   100: monitorexit
    //   101: ldc_w 515
    //   104: invokestatic 184	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   107: aload_1
    //   108: athrow
    //   109: astore_1
    //   110: aload_0
    //   111: monitorenter
    //   112: aload_0
    //   113: aload_0
    //   114: getfield 534	com/google/android/exoplayer2/i:aSs	I
    //   117: iconst_1
    //   118: iadd
    //   119: putfield 534	com/google/android/exoplayer2/i:aSs	I
    //   122: aload_0
    //   123: invokevirtual 537	java/lang/Object:notifyAll	()V
    //   126: aload_0
    //   127: monitorexit
    //   128: ldc_w 515
    //   131: invokestatic 184	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   134: aload_1
    //   135: athrow
    //   136: astore_1
    //   137: aload_0
    //   138: monitorexit
    //   139: ldc_w 515
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
    //   99	101	98	finally
    //   6	9	109	finally
    //   21	41	109	finally
    //   48	64	109	finally
    //   64	73	109	finally
    //   112	128	136	finally
    //   137	139	136	finally
  }
  
  private void d(long paramLong1, long paramLong2)
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
  
  private void d(Object paramObject, int paramInt)
  {
    AppMethodBeat.i(91943);
    this.eventHandler.obtainMessage(6, new d(this.aRW, paramObject, this.aSb, paramInt)).sendToTarget();
    AppMethodBeat.o(91943);
  }
  
  private Pair<Integer, Long> dF(int paramInt)
  {
    AppMethodBeat.i(91946);
    Pair localPair = this.aRW.a(this.aRP, this.aRQ, paramInt, -9223372036854775807L);
    AppMethodBeat.o(91946);
    return localPair;
  }
  
  private void og()
  {
    AppMethodBeat.i(91935);
    aQ(true);
    this.aSh.rC();
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
  
  private void rH()
  {
    int i = 0;
    AppMethodBeat.i(91927);
    this.aSq = false;
    this.aSi.start();
    r[] arrayOfr = this.aSp;
    int j = arrayOfr.length;
    while (i < j)
    {
      arrayOfr[i].start();
      i += 1;
    }
    AppMethodBeat.o(91927);
  }
  
  private void rI()
  {
    AppMethodBeat.i(91928);
    this.aSi.stop();
    r[] arrayOfr = this.aSp;
    int j = arrayOfr.length;
    int i = 0;
    while (i < j)
    {
      a(arrayOfr[i]);
      i += 1;
    }
    AppMethodBeat.o(91928);
  }
  
  private void rJ()
  {
    AppMethodBeat.i(91929);
    if (this.aSz == null)
    {
      AppMethodBeat.o(91929);
      return;
    }
    long l1 = this.aSz.aSA.tK();
    if (l1 != -9223372036854775807L)
    {
      z(l1);
      this.aSb.aSO = l1;
      this.aSt = (SystemClock.elapsedRealtime() * 1000L);
      if (this.aSp.length != 0) {
        break label194;
      }
    }
    label194:
    for (l1 = -9223372036854775808L;; l1 = this.aSz.aSA.tL())
    {
      Object localObject = this.aSb;
      long l2 = l1;
      if (l1 == -9223372036854775808L) {
        l2 = this.aSz.aSF.aTs;
      }
      ((b)localObject).aSP = l2;
      AppMethodBeat.o(91929);
      return;
      if ((this.aSm != null) && (!this.aSm.rX()))
      {
        this.aSw = this.aSn.sr();
        this.aSi.ah(this.aSw);
      }
      for (;;)
      {
        localObject = this.aSz;
        l1 = this.aSw - ((a)localObject).rN();
        break;
        this.aSw = this.aSi.sr();
      }
    }
  }
  
  private void rK()
  {
    AppMethodBeat.i(91934);
    aQ(true);
    this.aSh.onStopped();
    setState(1);
    AppMethodBeat.o(91934);
  }
  
  private void rL()
  {
    AppMethodBeat.i(91940);
    if ((this.aSx != null) && (!this.aSx.aSG) && ((this.aSy == null) || (this.aSy.aSI == this.aSx)))
    {
      r[] arrayOfr = this.aSp;
      int j = arrayOfr.length;
      int i = 0;
      while (i < j)
      {
        if (!arrayOfr[i].rv())
        {
          AppMethodBeat.o(91940);
          return;
        }
        i += 1;
      }
      this.aSx.aSA.tI();
    }
    AppMethodBeat.o(91940);
  }
  
  private void rM()
  {
    AppMethodBeat.i(91947);
    boolean bool = this.aSx.x(this.aSw);
    aP(bool);
    if (bool) {
      this.aSx.B(this.aSw);
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
  
  private void z(long paramLong)
  {
    AppMethodBeat.i(91933);
    if (this.aSz == null) {}
    for (paramLong = 60000000L + paramLong;; paramLong = this.aSz.rN() + paramLong)
    {
      this.aSw = paramLong;
      this.aSi.ah(this.aSw);
      r[] arrayOfr = this.aSp;
      int j = arrayOfr.length;
      int i = 0;
      while (i < j)
      {
        arrayOfr[i].u(this.aSw);
        i += 1;
      }
    }
    AppMethodBeat.o(91933);
  }
  
  public final void a(com.google.android.exoplayer2.source.h paramh)
  {
    AppMethodBeat.i(91923);
    this.handler.obtainMessage(8, paramh).sendToTarget();
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
    //   2: ldc_w 633
    //   5: invokestatic 92	com/tencent/matrix/trace/core/AppMethodBeat:i	(I)V
    //   8: aload_0
    //   9: getfield 563	com/google/android/exoplayer2/i:released	Z
    //   12: ifeq +12 -> 24
    //   15: ldc_w 633
    //   18: invokestatic 184	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   21: aload_0
    //   22: monitorexit
    //   23: return
    //   24: aload_0
    //   25: getfield 635	com/google/android/exoplayer2/i:aSr	I
    //   28: istore_3
    //   29: aload_0
    //   30: iload_3
    //   31: iconst_1
    //   32: iadd
    //   33: putfield 635	com/google/android/exoplayer2/i:aSr	I
    //   36: aload_0
    //   37: getfield 181	com/google/android/exoplayer2/i:handler	Landroid/os/Handler;
    //   40: bipush 11
    //   42: aload_1
    //   43: invokevirtual 503	android/os/Handler:obtainMessage	(ILjava/lang/Object;)Landroid/os/Message;
    //   46: invokevirtual 465	android/os/Message:sendToTarget	()V
    //   49: iconst_0
    //   50: istore_2
    //   51: aload_0
    //   52: getfield 534	com/google/android/exoplayer2/i:aSs	I
    //   55: istore 4
    //   57: iload 4
    //   59: iload_3
    //   60: if_icmpgt +16 -> 76
    //   63: aload_0
    //   64: invokevirtual 638	java/lang/Object:wait	()V
    //   67: goto -16 -> 51
    //   70: astore_1
    //   71: iconst_1
    //   72: istore_2
    //   73: goto -22 -> 51
    //   76: iload_2
    //   77: ifeq +9 -> 86
    //   80: invokestatic 644	java/lang/Thread:currentThread	()Ljava/lang/Thread;
    //   83: invokevirtual 647	java/lang/Thread:interrupt	()V
    //   86: ldc_w 633
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
      rK();
      AppMethodBeat.o(91924);
      return true;
      if (paramMessage.arg1 == 0) {
        break label300;
      }
      bool = true;
      this.aSq = false;
      this.aRS = bool;
      if (bool) {
        break label306;
      }
      rI();
      rJ();
      for (;;)
      {
        AppMethodBeat.o(91924);
        return true;
        bool = false;
        break;
        if (this.state != 3) {
          break label359;
        }
        rH();
        this.handler.sendEmptyMessage(2);
      }
    }
    catch (IOException paramMessage)
    {
      for (;;)
      {
        this.eventHandler.obtainMessage(8, e.a(paramMessage)).sendToTarget();
        rK();
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
      rK();
      AppMethodBeat.o(91924);
      return true;
    }
    Object localObject1 = (com.google.android.exoplayer2.source.i)paramMessage.obj;
    if (paramMessage.arg1 != 0)
    {
      i = 1;
      this.eventHandler.sendEmptyMessage(0);
      aQ(true);
      this.aSh.rB();
      if (i == 0) {
        break label197;
      }
    }
    label197:
    for (this.aSb = new b(-9223372036854775807L);; this.aSb = new b(this.aSb.aSL, this.aSb.aSO, this.aSb.aSN))
    {
      this.aSo = ((com.google.android.exoplayer2.source.i)localObject1);
      if (localObject1 != null) {
        ((com.google.android.exoplayer2.source.i)localObject1).a(this.aSk, this);
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
    this.repeatMode = i;
    this.aSl.repeatMode = i;
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
    if (this.aSz != null)
    {
      paramMessage = this.aSz;
    }
    else
    {
      for (;;)
      {
        j = this.aRW.a(paramMessage.aSF.aTq.bmb, this.aRQ, this.aRP, i);
        while ((paramMessage.aSI != null) && (!paramMessage.aSF.aTt))
        {
          paramMessage = paramMessage.aSI;
          continue;
          paramMessage = this.aSx;
          break label4822;
        }
        if ((j == -1) || (paramMessage.aSI == null) || (paramMessage.aSI.aSF.aTq.bmb != j)) {
          break;
        }
        paramMessage = paramMessage.aSI;
      }
      j = this.aSx.index;
      if (this.aSy != null)
      {
        i = this.aSy.index;
        if (paramMessage.aSI != null)
        {
          a(paramMessage.aSI);
          paramMessage.aSI = null;
        }
        localObject1 = this.aSl;
        localObject2 = paramMessage.aSF;
        paramMessage.aSF = ((n)localObject1).a((n.a)localObject2, ((n.a)localObject2).aTq);
        if (j > paramMessage.index) {
          break label708;
        }
        j = 1;
        if (j == 0) {
          this.aSx = paramMessage;
        }
        if ((i == -1) || (i > paramMessage.index)) {
          break label713;
        }
      }
      for (i = 1;; i = 0)
      {
        if ((i == 0) && (this.aSz != null))
        {
          paramMessage = this.aSz.aSF.aTq;
          this.aSb = new b(paramMessage, a(paramMessage, this.aSb.aSO), this.aSb.aSN);
        }
        AppMethodBeat.o(91924);
        return true;
        i = -1;
        break;
        j = 0;
        break label618;
      }
      long l3 = SystemClock.elapsedRealtime();
      if ((this.aRW == null) && (this.aSo != null)) {
        this.aSo.tO();
      }
      long l4;
      while (this.aSz == null)
      {
        rL();
        d(l3, 10L);
        AppMethodBeat.o(91924);
        return true;
        if (this.aSx == null)
        {
          paramMessage = this.aSl;
          localObject1 = this.aSb;
          paramMessage = paramMessage.a(((b)localObject1).aSL, ((b)localObject1).aSN, ((b)localObject1).aSM);
          if (paramMessage != null) {
            break label1556;
          }
          this.aSo.tO();
          if ((this.aSx != null) && (!this.aSx.rO())) {
            break label1719;
          }
          aP(false);
        }
        for (;;)
        {
          if (this.aSz == null) {
            break label1738;
          }
          while ((this.aSz != this.aSy) && (this.aSw >= this.aSz.aSI.aSE))
          {
            this.aSz.release();
            b(this.aSz.aSI);
            this.aSb = new b(this.aSz.aSF.aTq, this.aSz.aSF.aSM, this.aSz.aSF.aSN);
            rJ();
            this.eventHandler.obtainMessage(5, this.aSb).sendToTarget();
          }
          if ((this.aSx.aSF.aTu) || (!this.aSx.rO()) || (this.aSx.aSF.aTs == -9223372036854775807L) || ((this.aSz != null) && (this.aSx.index - this.aSz.index == 100))) {
            break label825;
          }
          paramMessage = this.aSl;
          localObject1 = this.aSx.aSF;
          l1 = this.aSx.rN();
          l2 = this.aSw;
          if (((n.a)localObject1).aTt)
          {
            i = paramMessage.aRW.a(((n.a)localObject1).aTq.bmb, paramMessage.aRQ, paramMessage.aRP, paramMessage.repeatMode);
            if (i == -1)
            {
              paramMessage = null;
              break;
            }
            j = paramMessage.aRW.a(i, paramMessage.aRQ, false).aSQ;
            if (paramMessage.aRW.a(j, paramMessage.aRP).aUh != i) {
              break label4829;
            }
            l4 = ((n.a)localObject1).aTs;
            localObject1 = paramMessage.aRW.a(paramMessage.aRP, paramMessage.aRQ, j, -9223372036854775807L, Math.max(0L, l4 + l1 - l2));
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
          localObject2 = ((n.a)localObject1).aTq;
          if (((com.google.android.exoplayer2.source.i.b)localObject2).tY())
          {
            i = ((com.google.android.exoplayer2.source.i.b)localObject2).bmc;
            paramMessage.aRW.a(((com.google.android.exoplayer2.source.i.b)localObject2).bmb, paramMessage.aRQ, false);
            j = paramMessage.aRQ.aTY[i];
            if (j == -1)
            {
              paramMessage = null;
              break;
            }
            k = ((com.google.android.exoplayer2.source.i.b)localObject2).bmd + 1;
            if (k < j)
            {
              if (!paramMessage.aRQ.be(i, k))
              {
                paramMessage = null;
                break;
              }
              paramMessage = paramMessage.b(((com.google.android.exoplayer2.source.i.b)localObject2).bmb, i, k, ((n.a)localObject1).aSN);
              break;
            }
            i = paramMessage.aRQ.F(((n.a)localObject1).aSN);
            if (i == -1) {}
            for (l1 = -9223372036854775808L;; l1 = paramMessage.aRQ.aTX[i])
            {
              paramMessage = paramMessage.b(((com.google.android.exoplayer2.source.i.b)localObject2).bmb, ((n.a)localObject1).aSN, l1);
              break;
            }
          }
          if (((n.a)localObject1).aTr != -9223372036854775808L)
          {
            i = paramMessage.aRQ.E(((n.a)localObject1).aTr);
            if (!paramMessage.aRQ.be(i, 0))
            {
              paramMessage = null;
              break;
            }
            paramMessage = paramMessage.b(((com.google.android.exoplayer2.source.i.b)localObject2).bmb, i, 0, ((n.a)localObject1).aTr);
            break;
          }
          i = paramMessage.aRQ.sb();
          if ((i == 0) || (paramMessage.aRQ.aTX[(i - 1)] != -9223372036854775808L) || (paramMessage.aRQ.dI(i - 1)) || (!paramMessage.aRQ.be(i - 1, 0))) {
            break label4835;
          }
          l1 = paramMessage.aRQ.aTs;
          paramMessage = paramMessage.b(((com.google.android.exoplayer2.source.i.b)localObject2).bmb, i - 1, 0, l1);
          break;
          if (this.aSx == null)
          {
            l1 = 60000000L;
            if (this.aSx != null) {
              break label1706;
            }
          }
          for (i = 0;; i = this.aSx.index + 1)
          {
            localObject1 = this.aRW.a(paramMessage.aTq.bmb, this.aRQ, true).aSB;
            localObject1 = new a(this.aRK, this.aSg, l1, this.aRL, this.aSh, this.aSo, localObject1, i, paramMessage);
            if (this.aSx != null) {
              this.aSx.aSI = ((a)localObject1);
            }
            this.aSx = ((a)localObject1);
            this.aSx.aSA.a(this, paramMessage.aSM);
            aP(true);
            break;
            l1 = this.aSx.rN() + this.aSx.aSF.aTs;
            break label1568;
          }
          if ((this.aSx != null) && (!this.isLoading)) {
            rM();
          }
        }
        continue;
        if (!this.aSy.aSF.aTu) {
          break label4847;
        }
        i = 0;
        if (i >= this.aRK.length) {
          break label4845;
        }
        paramMessage = this.aRK[i];
        localObject1 = this.aSy.aSC[i];
        if ((localObject1 == null) || (paramMessage.ru() != localObject1) || (!paramMessage.rv())) {
          break label4840;
        }
        paramMessage.rw();
        break label4840;
        if (i < this.aRK.length)
        {
          paramMessage = this.aRK[i];
          localObject1 = this.aSy.aSC[i];
          if (paramMessage.ru() == localObject1)
          {
            if (localObject1 == null) {
              break label4852;
            }
            if (paramMessage.rv()) {
              break label4852;
            }
          }
        }
        else if ((this.aSy.aSI != null) && (this.aSy.aSI.aSG))
        {
          paramMessage = this.aSy.aSJ;
          this.aSy = this.aSy.aSI;
          localObject1 = this.aSy.aSJ;
          if (this.aSy.aSA.tK() == -9223372036854775807L) {
            break label4864;
          }
          i = 1;
          break label4859;
          if (j >= this.aRK.length) {
            break label4874;
          }
          localObject2 = this.aRK[j];
          if (paramMessage.bup.bum[j] == null) {
            break label4869;
          }
          if (i == 0)
          {
            if (((r)localObject2).rx()) {
              break label4869;
            }
            localObject3 = localObject1.bup.bum[j];
            localObject4 = paramMessage.buq[j];
            t localt = localObject1.buq[j];
            if ((localObject3 != null) && (localt.equals(localObject4)))
            {
              localObject4 = new Format[((com.google.android.exoplayer2.g.f)localObject3).length()];
              k = 0;
              while (k < localObject4.length)
              {
                localObject4[k] = ((com.google.android.exoplayer2.g.f)localObject3).eR(k);
                k += 1;
              }
              ((r)localObject2).a((Format[])localObject4, this.aSy.aSC[j], this.aSy.rN());
              break label4869;
            }
          }
          ((r)localObject2).rw();
          break label4869;
        }
      }
      v.beginSection("doSomeWork");
      rJ();
      this.aSz.aSA.V(this.aSb.aSO);
      i = 1;
      bool = true;
      paramMessage = this.aSp;
      int m = paramMessage.length;
      j = 0;
      if (j < m)
      {
        localObject1 = paramMessage[j];
        ((r)localObject1).e(this.aSw, this.aSt);
        if ((i == 0) || (!((r)localObject1).rX())) {
          break label4902;
        }
        i = 1;
        label2204:
        if (((r)localObject1).isReady()) {
          break label4876;
        }
        if (!((r)localObject1).rX()) {
          break label4907;
        }
        break label4876;
        label2227:
        if (k != 0) {
          break label4882;
        }
        ((r)localObject1).ry();
        break label4882;
      }
      if (!bool) {
        rL();
      }
      if (this.aSn != null)
      {
        paramMessage = this.aSn.sv();
        if (!paramMessage.equals(this.aSa))
        {
          this.aSa = paramMessage;
          this.aSi.a(this.aSn);
          this.eventHandler.obtainMessage(7, paramMessage).sendToTarget();
        }
      }
      l1 = this.aSz.aSF.aTs;
      if ((i != 0) && ((l1 == -9223372036854775807L) || (l1 <= this.aSb.aSO)) && (this.aSz.aSF.aTu))
      {
        setState(4);
        rI();
      }
      label2368:
      while (this.state == 2)
      {
        paramMessage = this.aSp;
        j = paramMessage.length;
        i = 0;
        while (i < j)
        {
          paramMessage[i].ry();
          i += 1;
        }
        if (this.state == 2)
        {
          if (this.aSp.length > 0)
          {
            if (!bool) {
              break label4930;
            }
            paramMessage = this.aSx;
            bool = this.aSq;
            l4 = this.aSw;
            if (!paramMessage.aSG)
            {
              l1 = paramMessage.aSF.aSM;
              l2 = l1;
              if (l1 != -9223372036854775808L) {
                break label2536;
              }
              if (!paramMessage.aSF.aTu) {
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
            if (!this.aRS) {
              break;
            }
            rH();
            break;
            l1 = paramMessage.aSA.tL();
            break label2460;
            label2527:
            l2 = paramMessage.aSF.aTs;
            label2536:
            bool = paramMessage.aSh.b(l2 - (l4 - paramMessage.rN()), bool);
            break label4919;
            bool = A(l1);
          }
        }
        if (this.state == 3)
        {
          if (this.aSp.length > 0) {}
          for (;;)
          {
            if (bool) {
              break label2623;
            }
            this.aSq = this.aRS;
            setState(2);
            rI();
            break;
            bool = A(l1);
          }
        }
      }
      label2460:
      label2489:
      label2623:
      if (((this.aRS) && (this.state == 3)) || (this.state == 2)) {
        d(l3, 10L);
      }
      for (;;)
      {
        v.endSection();
        break;
        if ((this.aSp.length != 0) && (this.state != 4)) {
          d(l3, 1000L);
        } else {
          this.handler.removeMessages(2);
        }
      }
      paramMessage = (c)paramMessage.obj;
      if (this.aRW == null)
      {
        this.aSu += 1;
        this.aSv = paramMessage;
      }
      for (;;)
      {
        AppMethodBeat.o(91924);
        return true;
        localObject1 = a(paramMessage);
        if (localObject1 == null)
        {
          this.aSb = new b(0L);
          this.eventHandler.obtainMessage(4, 1, 0, this.aSb).sendToTarget();
          this.aSb = new b(-9223372036854775807L);
          setState(4);
          aQ(false);
        }
        else
        {
          if (paramMessage.aSR == -9223372036854775807L)
          {
            i = 1;
            label2821:
            j = ((Integer)((Pair)localObject1).first).intValue();
            l2 = ((Long)((Pair)localObject1).second).longValue();
            localObject1 = this.aSl.g(j, l2);
            bool = ((com.google.android.exoplayer2.source.i.b)localObject1).tY();
            if (!bool) {
              break label4815;
            }
            l1 = 0L;
            i = 1;
          }
          try
          {
            label2875:
            if (((com.google.android.exoplayer2.source.i.b)localObject1).equals(this.aSb.aSL))
            {
              l3 = l1 / 1000L;
              l4 = this.aSb.aSO / 1000L;
              if (l3 == l4)
              {
                this.aSb = new b((com.google.android.exoplayer2.source.i.b)localObject1, l1, l2);
                paramMessage = this.eventHandler;
                if (i != 0) {}
                for (i = 1;; i = 0)
                {
                  paramMessage.obtainMessage(4, i, 0, this.aSb).sendToTarget();
                  break;
                  i = 0;
                  break label2821;
                }
              }
            }
            l3 = a((com.google.android.exoplayer2.source.i.b)localObject1, l1);
            if (l1 == l3) {
              break label4936;
            }
            j = 1;
            label2994:
            this.aSb = new b((com.google.android.exoplayer2.source.i.b)localObject1, l3, l2);
            paramMessage = this.eventHandler;
            if ((i | j) == 0) {
              break label4941;
            }
            i = 1;
            label3024:
            paramMessage.obtainMessage(4, i, 0, this.aSb).sendToTarget();
          }
          finally
          {
            this.aSb = new b((com.google.android.exoplayer2.source.i.b)localObject1, l1, l2);
            localObject1 = this.eventHandler;
            if (i == 0) {
              break label4946;
            }
          }
        }
      }
      i = 1;
      label3071:
      ((Handler)localObject1).obtainMessage(4, i, 0, this.aSb).sendToTarget();
      AppMethodBeat.o(91924);
      throw paramMessage;
      paramMessage = (p)paramMessage.obj;
      if (this.aSn != null) {}
      for (paramMessage = this.aSn.c(paramMessage);; paramMessage = this.aSi.c(paramMessage))
      {
        this.aSa = paramMessage;
        this.eventHandler.obtainMessage(7, paramMessage).sendToTarget();
        AppMethodBeat.o(91924);
        return true;
      }
      rK();
      AppMethodBeat.o(91924);
      return true;
      og();
      AppMethodBeat.o(91924);
      return true;
      paramMessage = (com.google.android.exoplayer2.source.h)paramMessage.obj;
      if (this.aSx != null)
      {
        localObject1 = this.aSx.aSA;
        if (localObject1 == paramMessage) {
          break label3220;
        }
      }
      for (;;)
      {
        AppMethodBeat.o(91924);
        return true;
        label3220:
        paramMessage = this.aSx;
        paramMessage.aSG = true;
        paramMessage.rP();
        l1 = paramMessage.C(paramMessage.aSF.aSM);
        localObject1 = paramMessage.aSF;
        paramMessage.aSF = new n.a(((n.a)localObject1).aTq, l1, ((n.a)localObject1).aTr, ((n.a)localObject1).aSN, ((n.a)localObject1).aTs, ((n.a)localObject1).aTt, ((n.a)localObject1).aTu);
        if (this.aSz == null)
        {
          this.aSy = this.aSx;
          z(this.aSy.aSF.aSM);
          b(this.aSy);
        }
        rM();
      }
      paramMessage = (Pair)paramMessage.obj;
      localObject3 = this.aRW;
      this.aRW = ((w)paramMessage.first);
      this.aSl.aRW = this.aRW;
      localObject2 = paramMessage.second;
      if (localObject3 == null)
      {
        if (this.aSu > 0)
        {
          paramMessage = a(this.aSv);
          i = this.aSu;
          this.aSu = 0;
          this.aSv = null;
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
          paramMessage = this.aSl.g(j, l2);
          if (!paramMessage.tY()) {
            break;
          }
          l1 = 0L;
          label3482:
          this.aSb = new b(paramMessage, l1, l2);
          d(localObject2, i);
          continue;
          if (this.aSb.aSM == -9223372036854775807L)
          {
            if (this.aRW.isEmpty())
            {
              c(localObject2, 0);
            }
            else
            {
              paramMessage = dF(0);
              i = ((Integer)paramMessage.first).intValue();
              l2 = ((Long)paramMessage.second).longValue();
              paramMessage = this.aSl.g(i, l2);
              if (!paramMessage.tY()) {
                break label4958;
              }
              l1 = 0L;
              label3592:
              this.aSb = new b(paramMessage, l1, l2);
            }
          }
          else {
            d(localObject2, 0);
          }
        }
      }
      j = this.aSb.aSL.bmb;
      if (this.aSz != null)
      {
        paramMessage = this.aSz;
        label3641:
        if ((paramMessage == null) && (j >= ((w)localObject3).sa())) {
          break label3903;
        }
        if (paramMessage != null) {
          break label3724;
        }
      }
      label3724:
      for (localObject1 = ((w)localObject3).a(j, this.aRQ, true).aSB;; localObject1 = paramMessage.aSB)
      {
        i = this.aRW.ac(localObject1);
        if (i != -1) {
          break label3913;
        }
        i = a(j, (w)localObject3, this.aRW);
        if (i != -1) {
          break label3733;
        }
        c(localObject2, 0);
        break;
        paramMessage = this.aSx;
        break label3641;
      }
      label3733:
      localObject1 = dF(this.aRW.a(i, this.aRQ, false).aSQ);
      i = ((Integer)((Pair)localObject1).first).intValue();
      l1 = ((Long)((Pair)localObject1).second).longValue();
      this.aRW.a(i, this.aRQ, true);
      if (paramMessage != null)
      {
        localObject1 = this.aRQ.aSB;
        paramMessage.aSF = paramMessage.aSF.rT();
        while (paramMessage.aSI != null)
        {
          paramMessage = paramMessage.aSI;
          if (paramMessage.aSB.equals(localObject1)) {
            paramMessage.aSF = this.aSl.a(paramMessage.aSF, i);
          } else {
            paramMessage.aSF = paramMessage.aSF.rT();
          }
        }
      }
      paramMessage = new com.google.android.exoplayer2.source.i.b(i);
      this.aSb = new b(paramMessage, a(paramMessage, l1));
      for (;;)
      {
        label3903:
        d(localObject2, 0);
        break;
        label3913:
        if (i != j)
        {
          localObject1 = this.aSb;
          localObject3 = new b(((b)localObject1).aSL.ex(i), ((b)localObject1).aSM, ((b)localObject1).aSN);
          ((b)localObject3).aSO = ((b)localObject1).aSO;
          ((b)localObject3).aSP = ((b)localObject1).aSP;
          this.aSb = ((b)localObject3);
        }
        if (this.aSb.aSL.tY())
        {
          localObject1 = this.aSl.g(i, this.aSb.aSN);
          if ((!((com.google.android.exoplayer2.source.i.b)localObject1).tY()) || (((com.google.android.exoplayer2.source.i.b)localObject1).bmd != this.aSb.aSL.bmd))
          {
            l2 = a((com.google.android.exoplayer2.source.i.b)localObject1, this.aSb.aSN);
            if (!((com.google.android.exoplayer2.source.i.b)localObject1).tY()) {
              break label4965;
            }
            l1 = this.aSb.aSN;
            label4066:
            this.aSb = new b((com.google.android.exoplayer2.source.i.b)localObject1, l2, l1);
            continue;
          }
        }
        if (paramMessage != null)
        {
          for (paramMessage = a(paramMessage, i); paramMessage.aSI != null; paramMessage = a((a)localObject1, i))
          {
            localObject1 = paramMessage.aSI;
            i = this.aRW.a(i, this.aRQ, this.aRP, this.repeatMode);
            if ((i == -1) || (!((a)localObject1).aSB.equals(this.aRW.a(i, this.aRQ, true).aSB))) {
              break label4174;
            }
          }
          continue;
          label4174:
          if ((this.aSy == null) || (this.aSy.index >= ((a)localObject1).index)) {
            break label4973;
          }
          i = 1;
          label4198:
          if (i == 0)
          {
            l1 = a(this.aSz.aSF.aTq, this.aSb.aSO);
            this.aSb = new b(this.aSz.aSF.aTq, l1, this.aSb.aSN);
          }
          else
          {
            this.aSx = paramMessage;
            this.aSx.aSI = null;
            a((a)localObject1);
          }
        }
      }
      paramMessage = (com.google.android.exoplayer2.source.h)paramMessage.obj;
      if (this.aSx != null)
      {
        localObject1 = this.aSx.aSA;
        if (localObject1 == paramMessage) {
          break label4317;
        }
      }
      for (;;)
      {
        AppMethodBeat.o(91924);
        return true;
        label4317:
        rM();
      }
      if (this.aSz != null)
      {
        paramMessage = this.aSz;
        i = 1;
      }
      for (;;)
      {
        if (paramMessage != null)
        {
          bool = paramMessage.aSG;
          if (bool) {}
        }
        else
        {
          AppMethodBeat.o(91924);
          return true;
        }
        if (paramMessage.rP()) {
          break;
        }
        if (paramMessage == this.aSy) {
          i = 0;
        }
        paramMessage = paramMessage.aSI;
      }
      if (i != 0)
      {
        if (this.aSy == this.aSz) {
          break label4988;
        }
        bool = true;
        label4404:
        a(this.aSz.aSI);
        this.aSz.aSI = null;
        this.aSx = this.aSz;
        this.aSy = this.aSz;
        localObject1 = new boolean[this.aRK.length];
        l1 = this.aSz.a(this.aSb.aSO, bool, (boolean[])localObject1);
        if (l1 != this.aSb.aSO)
        {
          this.aSb.aSO = l1;
          z(l1);
        }
        j = 0;
        localObject2 = new boolean[this.aRK.length];
        i = 0;
        label4508:
        if (i < this.aRK.length)
        {
          localObject3 = this.aRK[i];
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
      localObject4 = this.aSz.aSC[i];
      k = j;
      if (localObject4 != null) {
        k = j + 1;
      }
      if (localObject2[i] != 0) {
        if (localObject4 != ((r)localObject3).ru())
        {
          if (localObject3 == this.aSm)
          {
            if (localObject4 == null) {
              this.aSi.a(this.aSn);
            }
            this.aSn = null;
            this.aSm = null;
          }
          a((r)localObject3);
          ((r)localObject3).disable();
        }
        else if (localObject1[i] != 0)
        {
          ((r)localObject3).u(this.aSw);
          break label4978;
          this.eventHandler.obtainMessage(3, paramMessage.aSJ).sendToTarget();
          a((boolean[])localObject2, j);
          for (;;)
          {
            rM();
            rJ();
            this.handler.sendEmptyMessage(2);
            break;
            this.aSx = paramMessage;
            for (paramMessage = this.aSx.aSI; paramMessage != null; paramMessage = paramMessage.aSI) {
              paramMessage.release();
            }
            this.aSx.aSI = null;
            if (this.aSx.aSG)
            {
              l1 = this.aSx.aSF.aSM;
              paramMessage = this.aSx;
              l1 = Math.max(l1, this.aSw - paramMessage.rN());
              this.aSx.C(l1);
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
    //   2: ldc_w 872
    //   5: invokestatic 92	com/tencent/matrix/trace/core/AppMethodBeat:i	(I)V
    //   8: aload_0
    //   9: getfield 563	com/google/android/exoplayer2/i:released	Z
    //   12: ifeq +12 -> 24
    //   15: ldc_w 872
    //   18: invokestatic 184	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   21: aload_0
    //   22: monitorexit
    //   23: return
    //   24: aload_0
    //   25: getfield 181	com/google/android/exoplayer2/i:handler	Landroid/os/Handler;
    //   28: bipush 6
    //   30: invokevirtual 293	android/os/Handler:sendEmptyMessage	(I)Z
    //   33: pop
    //   34: iconst_0
    //   35: istore_1
    //   36: aload_0
    //   37: getfield 563	com/google/android/exoplayer2/i:released	Z
    //   40: istore_2
    //   41: iload_2
    //   42: ifne +16 -> 58
    //   45: aload_0
    //   46: invokevirtual 638	java/lang/Object:wait	()V
    //   49: goto -13 -> 36
    //   52: astore_3
    //   53: iconst_1
    //   54: istore_1
    //   55: goto -19 -> 36
    //   58: iload_1
    //   59: ifeq +9 -> 68
    //   62: invokestatic 644	java/lang/Thread:currentThread	()Ljava/lang/Thread;
    //   65: invokevirtual 647	java/lang/Thread:interrupt	()V
    //   68: aload_0
    //   69: getfield 167	com/google/android/exoplayer2/i:aSj	Landroid/os/HandlerThread;
    //   72: invokevirtual 875	android/os/HandlerThread:quit	()Z
    //   75: pop
    //   76: ldc_w 872
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
    private final r[] aRK;
    private final com.google.android.exoplayer2.g.h aRL;
    public final com.google.android.exoplayer2.source.h aSA;
    public final Object aSB;
    public final com.google.android.exoplayer2.source.l[] aSC;
    public final boolean[] aSD;
    public final long aSE;
    public n.a aSF;
    public boolean aSG;
    public boolean aSH;
    public a aSI;
    public com.google.android.exoplayer2.g.i aSJ;
    private com.google.android.exoplayer2.g.i aSK;
    private final s[] aSg;
    final m aSh;
    private final com.google.android.exoplayer2.source.i aSo;
    public final int index;
    
    public a(r[] paramArrayOfr, s[] paramArrayOfs, long paramLong, com.google.android.exoplayer2.g.h paramh, m paramm, com.google.android.exoplayer2.source.i parami, Object paramObject, int paramInt, n.a parama)
    {
      AppMethodBeat.i(91909);
      this.aRK = paramArrayOfr;
      this.aSg = paramArrayOfs;
      this.aSE = paramLong;
      this.aRL = paramh;
      this.aSh = paramm;
      this.aSo = parami;
      this.aSB = a.checkNotNull(paramObject);
      this.index = paramInt;
      this.aSF = parama;
      this.aSC = new com.google.android.exoplayer2.source.l[paramArrayOfr.length];
      this.aSD = new boolean[paramArrayOfr.length];
      paramArrayOfr = parami.a(parama.aTq, paramm.rD());
      if (parama.aTr != -9223372036854775808L)
      {
        paramArrayOfr = new c(paramArrayOfr, true);
        paramArrayOfr.h(0L, parama.aTr);
      }
      for (;;)
      {
        this.aSA = paramArrayOfr;
        AppMethodBeat.o(91909);
        return;
      }
    }
    
    public final void B(long paramLong)
    {
      AppMethodBeat.i(91912);
      long l = rN();
      this.aSA.X(paramLong - l);
      AppMethodBeat.o(91912);
    }
    
    public final long C(long paramLong)
    {
      AppMethodBeat.i(91914);
      paramLong = a(paramLong, false, new boolean[this.aRK.length]);
      AppMethodBeat.o(91914);
      return paramLong;
    }
    
    public final long a(long paramLong, boolean paramBoolean, boolean[] paramArrayOfBoolean)
    {
      AppMethodBeat.i(91915);
      g localg = this.aSJ.bup;
      int i = 0;
      if (i < localg.length)
      {
        boolean[] arrayOfBoolean = this.aSD;
        if ((!paramBoolean) && (this.aSJ.a(this.aSK, i))) {}
        for (int j = 1;; j = 0)
        {
          arrayOfBoolean[i] = j;
          i += 1;
          break;
        }
      }
      paramLong = this.aSA.a(localg.uX(), this.aSD, this.aSC, paramArrayOfBoolean, paramLong);
      this.aSK = this.aSJ;
      this.aSH = false;
      i = 0;
      if (i < this.aSC.length)
      {
        if (this.aSC[i] != null)
        {
          if (localg.bum[i] != null) {}
          for (paramBoolean = true;; paramBoolean = false)
          {
            a.checkState(paramBoolean);
            this.aSH = true;
            i += 1;
            break;
          }
        }
        if (localg.bum[i] == null) {}
        for (paramBoolean = true;; paramBoolean = false)
        {
          a.checkState(paramBoolean);
          break;
        }
      }
      this.aSh.a(this.aRK, localg);
      AppMethodBeat.o(91915);
      return paramLong;
    }
    
    public final long rN()
    {
      if (this.index == 0) {
        return this.aSE;
      }
      return this.aSE - this.aSF.aSM;
    }
    
    public final boolean rO()
    {
      AppMethodBeat.i(91910);
      if ((this.aSG) && ((!this.aSH) || (this.aSA.tL() == -9223372036854775808L)))
      {
        AppMethodBeat.o(91910);
        return true;
      }
      AppMethodBeat.o(91910);
      return false;
    }
    
    public final boolean rP()
    {
      AppMethodBeat.i(91913);
      com.google.android.exoplayer2.g.i locali = this.aRL.a(this.aSg, this.aSA.tJ());
      if (locali.a(this.aSK))
      {
        AppMethodBeat.o(91913);
        return false;
      }
      this.aSJ = locali;
      AppMethodBeat.o(91913);
      return true;
    }
    
    public final void release()
    {
      AppMethodBeat.i(91916);
      try
      {
        if (this.aSF.aTr != -9223372036854775808L)
        {
          this.aSo.b(((c)this.aSA).aSA);
          AppMethodBeat.o(91916);
          return;
        }
        this.aSo.b(this.aSA);
        AppMethodBeat.o(91916);
        return;
      }
      catch (RuntimeException localRuntimeException)
      {
        AppMethodBeat.o(91916);
      }
    }
    
    public final boolean x(long paramLong)
    {
      AppMethodBeat.i(91911);
      if (!this.aSG) {}
      for (long l1 = 0L; l1 == -9223372036854775808L; l1 = this.aSA.tM())
      {
        AppMethodBeat.o(91911);
        return false;
      }
      long l2 = rN();
      boolean bool = this.aSh.x(l1 - (paramLong - l2));
      AppMethodBeat.o(91911);
      return bool;
    }
  }
  
  public static final class b
  {
    public final com.google.android.exoplayer2.source.i.b aSL;
    public final long aSM;
    public final long aSN;
    public volatile long aSO;
    public volatile long aSP;
    
    public b(long paramLong)
    {
      this(new com.google.android.exoplayer2.source.i.b(0), paramLong);
      AppMethodBeat.i(91917);
      AppMethodBeat.o(91917);
    }
    
    public b(com.google.android.exoplayer2.source.i.b paramb, long paramLong)
    {
      this(paramb, paramLong, -9223372036854775807L);
    }
    
    public b(com.google.android.exoplayer2.source.i.b paramb, long paramLong1, long paramLong2)
    {
      this.aSL = paramb;
      this.aSM = paramLong1;
      this.aSN = paramLong2;
      this.aSO = paramLong1;
      this.aSP = paramLong1;
    }
  }
  
  static final class c
  {
    public final w aRW;
    public final int aSQ;
    public final long aSR;
    
    public c(w paramw, int paramInt, long paramLong)
    {
      this.aRW = paramw;
      this.aSQ = paramInt;
      this.aSR = paramLong;
    }
  }
  
  public static final class d
  {
    public final w aRW;
    public final Object aRX;
    public final int aSS;
    public final i.b aSb;
    
    public d(w paramw, Object paramObject, i.b paramb, int paramInt)
    {
      this.aRW = paramw;
      this.aRX = paramObject;
      this.aSb = paramb;
      this.aSS = paramInt;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.google.android.exoplayer2.i
 * JD-Core Version:    0.7.0.1
 */