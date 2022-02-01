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
  private final w.b cFD;
  private final w.a cFE;
  private boolean cFG;
  private int cFH;
  private w cFL;
  private p cFP;
  private b cFQ;
  private final s[] cFV;
  private final m cFW;
  private final com.google.android.exoplayer2.i.s cFX;
  private final HandlerThread cFY;
  private final f cFZ;
  private final r[] cFy;
  private final h cFz;
  private final n cGa;
  private r cGb;
  private com.google.android.exoplayer2.i.i cGc;
  private k cGd;
  private r[] cGe;
  private boolean cGf;
  int cGg;
  private int cGh;
  private long cGi;
  private int cGj;
  private c cGk;
  private long cGl;
  private a cGm;
  private a cGn;
  private a cGo;
  private final Handler eventHandler;
  final Handler handler;
  private boolean isLoading;
  boolean released;
  private int state;
  
  public i(r[] paramArrayOfr, h paramh, m paramm, boolean paramBoolean, int paramInt, Handler paramHandler, b paramb, f paramf)
  {
    AppMethodBeat.i(91918);
    this.cFy = paramArrayOfr;
    this.cFz = paramh;
    this.cFW = paramm;
    this.cFG = paramBoolean;
    this.cFH = paramInt;
    this.eventHandler = paramHandler;
    this.state = 1;
    this.cFQ = paramb;
    this.cFZ = paramf;
    this.cFV = new s[paramArrayOfr.length];
    paramInt = 0;
    while (paramInt < paramArrayOfr.length)
    {
      paramArrayOfr[paramInt].setIndex(paramInt);
      this.cFV[paramInt] = paramArrayOfr[paramInt].Qm();
      paramInt += 1;
    }
    this.cFX = new com.google.android.exoplayer2.i.s();
    this.cGe = new r[0];
    this.cFD = new w.b();
    this.cFE = new w.a();
    this.cGa = new n();
    paramh.dhZ = this;
    this.cFP = p.cHj;
    this.cFY = new HandlerThread("ExoPlayerImplInternal:Handler", -16);
    this.cFY.start();
    this.handler = new Handler(this.cFY.getLooper(), this);
    AppMethodBeat.o(91918);
  }
  
  private void A(long paramLong1, long paramLong2)
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
  
  private void QG()
  {
    int i = 0;
    AppMethodBeat.i(91927);
    this.cGf = false;
    this.cFX.start();
    r[] arrayOfr = this.cGe;
    int j = arrayOfr.length;
    while (i < j)
    {
      arrayOfr[i].start();
      i += 1;
    }
    AppMethodBeat.o(91927);
  }
  
  private void QH()
  {
    AppMethodBeat.i(91928);
    this.cFX.stop();
    r[] arrayOfr = this.cGe;
    int j = arrayOfr.length;
    int i = 0;
    while (i < j)
    {
      a(arrayOfr[i]);
      i += 1;
    }
    AppMethodBeat.o(91928);
  }
  
  private void QI()
  {
    AppMethodBeat.i(91929);
    if (this.cGo == null)
    {
      AppMethodBeat.o(91929);
      return;
    }
    long l1 = this.cGo.cGp.SQ();
    if (l1 != -9223372036854775807L)
    {
      bQ(l1);
      this.cFQ.cGD = l1;
      this.cGi = (SystemClock.elapsedRealtime() * 1000L);
      if (this.cGe.length != 0) {
        break label191;
      }
    }
    label191:
    for (l1 = -9223372036854775808L;; l1 = this.cGo.cGp.SR())
    {
      Object localObject = this.cFQ;
      long l2 = l1;
      if (l1 == -9223372036854775808L) {
        l2 = this.cGo.cGu.cHg;
      }
      ((b)localObject).cGE = l2;
      AppMethodBeat.o(91929);
      return;
      if ((this.cGb != null) && (!this.cGb.QU()))
      {
        this.cGl = this.cGc.Rq();
        this.cFX.cy(this.cGl);
      }
      for (;;)
      {
        localObject = this.cGo;
        l1 = this.cGl - ((a)localObject).QN();
        break;
        this.cGl = this.cFX.Rq();
      }
    }
  }
  
  private void QJ()
  {
    AppMethodBeat.i(91934);
    bx(true);
    this.cFW.Qv();
    setState(1);
    AppMethodBeat.o(91934);
  }
  
  private void QK()
  {
    AppMethodBeat.i(91935);
    bx(true);
    this.cFW.QA();
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
  
  private void QL()
  {
    AppMethodBeat.i(91940);
    if ((this.cGm != null) && (!this.cGm.cGv) && ((this.cGn == null) || (this.cGn.cGx == this.cGm)))
    {
      r[] arrayOfr = this.cGe;
      int j = arrayOfr.length;
      int i = 0;
      while (i < j)
      {
        if (!arrayOfr[i].Qp())
        {
          AppMethodBeat.o(91940);
          return;
        }
        i += 1;
      }
      this.cGm.cGp.SO();
    }
    AppMethodBeat.o(91940);
  }
  
  private void QM()
  {
    AppMethodBeat.i(91947);
    boolean bool = this.cGm.bO(this.cGl);
    bw(bool);
    if (bool) {
      this.cGm.bS(this.cGl);
    }
    AppMethodBeat.o(91947);
  }
  
  private int a(int paramInt, w paramw1, w paramw2)
  {
    AppMethodBeat.i(91944);
    int m = paramw1.QX();
    int k = 0;
    int i = -1;
    int j = paramInt;
    paramInt = k;
    while ((paramInt < m) && (i == -1))
    {
      j = paramw1.a(j, this.cFE, this.cFD, this.cFH);
      if (j == -1) {
        break;
      }
      i = paramw2.bf(paramw1.a(j, this.cFE, true).cGq);
      paramInt += 1;
    }
    AppMethodBeat.o(91944);
    return i;
  }
  
  private long a(k.b paramb, long paramLong)
  {
    AppMethodBeat.i(91931);
    QH();
    this.cGf = false;
    setState(2);
    Object localObject;
    if (this.cGo == null)
    {
      if (this.cGm == null) {
        break label290;
      }
      this.cGm.release();
      localObject = null;
    }
    for (;;)
    {
      if ((this.cGo != localObject) || (this.cGo != this.cGn))
      {
        paramb = this.cGe;
        int j = paramb.length;
        int i = 0;
        for (;;)
        {
          if (i < j)
          {
            paramb[i].disable();
            i += 1;
            continue;
            a locala1 = this.cGo;
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
              locala1 = locala1.cGx;
              break;
              locala1.release();
            }
          }
        }
        this.cGe = new r[0];
        this.cGc = null;
        this.cGb = null;
        this.cGo = null;
      }
      if (localObject != null)
      {
        localObject.cGx = null;
        this.cGm = localObject;
        this.cGn = localObject;
        b(localObject);
        long l = paramLong;
        if (this.cGo.cGw) {
          l = this.cGo.cGp.cn(paramLong);
        }
        bQ(l);
        QM();
        paramLong = l;
      }
      for (;;)
      {
        this.handler.sendEmptyMessage(2);
        AppMethodBeat.o(91931);
        return paramLong;
        this.cGm = null;
        this.cGn = null;
        this.cGo = null;
        bQ(paramLong);
      }
      label290:
      localObject = null;
    }
  }
  
  private Pair<Integer, Long> a(c paramc)
  {
    AppMethodBeat.i(91945);
    Object localObject2 = paramc.cFL;
    Object localObject1 = localObject2;
    if (((w)localObject2).isEmpty()) {
      localObject1 = this.cFL;
    }
    try
    {
      localObject2 = ((w)localObject1).a(this.cFD, this.cFE, paramc.cGF, paramc.cGG);
      if (this.cFL == localObject1)
      {
        AppMethodBeat.o(91945);
        return localObject2;
      }
    }
    catch (IndexOutOfBoundsException localIndexOutOfBoundsException)
    {
      paramc = new l(this.cFL, paramc.cGF, paramc.cGG);
      AppMethodBeat.o(91945);
      throw paramc;
    }
    int i = this.cFL.bf(localIndexOutOfBoundsException.a(((Integer)((Pair)localObject2).first).intValue(), this.cFE, true).cGq);
    if (i != -1)
    {
      paramc = Pair.create(Integer.valueOf(i), ((Pair)localObject2).second);
      AppMethodBeat.o(91945);
      return paramc;
    }
    i = a(((Integer)((Pair)localObject2).first).intValue(), localIndexOutOfBoundsException, this.cFL);
    if (i != -1)
    {
      paramc = hj(this.cFL.a(i, this.cFE, false).cGF);
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
      parama.cGu = this.cGa.a(parama.cGu, paramInt);
      if ((parama.cGu.cHh) || (parama.cGx == null))
      {
        AppMethodBeat.o(91941);
        return parama;
      }
      parama = parama.cGx;
    }
  }
  
  private static void a(a parama)
  {
    AppMethodBeat.i(91948);
    while (parama != null)
    {
      parama.release();
      parama = parama.cGx;
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
  
  private boolean a(k.b paramb, long paramLong, a parama)
  {
    AppMethodBeat.i(91932);
    if ((paramb.equals(parama.cGu.cHe)) && (parama.cGv))
    {
      this.cFL.a(parama.cGu.cHe.cZS, this.cFE, false);
      int i = this.cFE.bW(paramLong);
      if ((i == -1) || (this.cFE.cHL[i] == parama.cGu.cHf))
      {
        AppMethodBeat.o(91932);
        return true;
      }
    }
    AppMethodBeat.o(91932);
    return false;
  }
  
  private void b(a parama)
  {
    AppMethodBeat.i(91949);
    if (this.cGo == parama)
    {
      AppMethodBeat.o(91949);
      return;
    }
    boolean[] arrayOfBoolean = new boolean[this.cFy.length];
    int i = 0;
    int j = 0;
    if (i < this.cFy.length)
    {
      r localr = this.cFy[i];
      if (localr.getState() != 0) {}
      for (int m = 1;; m = 0)
      {
        arrayOfBoolean[i] = m;
        com.google.android.exoplayer2.g.f localf = parama.cGy.dib.dhY[i];
        int k = j;
        if (localf != null) {
          k = j + 1;
        }
        if ((arrayOfBoolean[i] != 0) && ((localf == null) || ((localr.Qr()) && (localr.Qo() == this.cGo.cGr[i]))))
        {
          if (localr == this.cGb)
          {
            this.cFX.a(this.cGc);
            this.cGc = null;
            this.cGb = null;
          }
          a(localr);
          localr.disable();
        }
        i += 1;
        j = k;
        break;
      }
    }
    this.cGo = parama;
    this.eventHandler.obtainMessage(3, parama.cGy).sendToTarget();
    b(arrayOfBoolean, j);
    AppMethodBeat.o(91949);
  }
  
  private void b(boolean[] paramArrayOfBoolean, int paramInt)
  {
    AppMethodBeat.i(91950);
    this.cGe = new r[paramInt];
    int i = 0;
    paramInt = 0;
    while (paramInt < this.cFy.length)
    {
      r localr = this.cFy[paramInt];
      Object localObject = this.cGo.cGy.dib.dhY[paramInt];
      int j = i;
      if (localObject != null)
      {
        this.cGe[i] = localr;
        if (localr.getState() == 0)
        {
          t localt = this.cGo.cGy.dic[paramInt];
          if ((this.cFG) && (this.state == 3))
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
              arrayOfFormat[k] = ((com.google.android.exoplayer2.g.f)localObject).iB(k);
              k += 1;
            }
            j = 0;
            break;
          }
          localr.a(localt, arrayOfFormat, this.cGo.cGr[paramInt], this.cGl, bool, this.cGo.QN());
          localObject = localr.Qn();
          if (localObject != null)
          {
            if (this.cGc != null)
            {
              paramArrayOfBoolean = e.b(new IllegalStateException("Multiple renderer media clocks enabled."));
              AppMethodBeat.o(91950);
              throw paramArrayOfBoolean;
            }
            this.cGc = ((com.google.android.exoplayer2.i.i)localObject);
            this.cGb = localr;
            this.cGc.b(this.cFP);
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
  
  private void bQ(long paramLong)
  {
    AppMethodBeat.i(91933);
    if (this.cGo == null) {}
    for (paramLong = 60000000L + paramLong;; paramLong = this.cGo.QN() + paramLong)
    {
      this.cGl = paramLong;
      this.cFX.cy(this.cGl);
      r[] arrayOfr = this.cGe;
      int j = arrayOfr.length;
      int i = 0;
      while (i < j)
      {
        arrayOfr[i].bK(this.cGl);
        i += 1;
      }
    }
    AppMethodBeat.o(91933);
  }
  
  private boolean bR(long paramLong)
  {
    AppMethodBeat.i(91939);
    if ((paramLong == -9223372036854775807L) || (this.cFQ.cGD < paramLong) || ((this.cGo.cGx != null) && ((this.cGo.cGx.cGv) || (this.cGo.cGx.cGu.cHe.isAd()))))
    {
      AppMethodBeat.o(91939);
      return true;
    }
    AppMethodBeat.o(91939);
    return false;
  }
  
  private void bw(boolean paramBoolean)
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
  
  private void bx(boolean paramBoolean)
  {
    AppMethodBeat.i(91936);
    this.handler.removeMessages(2);
    this.cGf = false;
    this.cFX.stop();
    this.cGc = null;
    this.cGb = null;
    this.cGl = 60000000L;
    Object localObject = this.cGe;
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
        this.cGe = new r[0];
        if (this.cGo != null) {}
        for (localObject = this.cGo;; localObject = this.cGm)
        {
          a((a)localObject);
          this.cGm = null;
          this.cGn = null;
          this.cGo = null;
          bw(false);
          if (paramBoolean)
          {
            if (this.cGd != null)
            {
              this.cGd.SV();
              this.cGd = null;
            }
            this.cGa.cFL = null;
            this.cFL = null;
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
  
  /* Error */
  private void c(f.c[] paramArrayOfc)
  {
    // Byte code:
    //   0: ldc_w 591
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
    //   23: getfield 597	com/google/android/exoplayer2/f$c:cFv	Lcom/google/android/exoplayer2/f$b;
    //   26: aload 4
    //   28: getfield 600	com/google/android/exoplayer2/f$c:cFw	I
    //   31: aload 4
    //   33: getfield 603	com/google/android/exoplayer2/f$c:cFx	Ljava/lang/Object;
    //   36: invokeinterface 609 3 0
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
    //   69: invokevirtual 201	android/os/Handler:sendEmptyMessage	(I)Z
    //   72: pop
    //   73: aload_0
    //   74: monitorenter
    //   75: aload_0
    //   76: aload_0
    //   77: getfield 611	com/google/android/exoplayer2/i:cGh	I
    //   80: iconst_1
    //   81: iadd
    //   82: putfield 611	com/google/android/exoplayer2/i:cGh	I
    //   85: aload_0
    //   86: invokevirtual 308	java/lang/Object:notifyAll	()V
    //   89: aload_0
    //   90: monitorexit
    //   91: ldc_w 591
    //   94: invokestatic 184	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   97: return
    //   98: astore_1
    //   99: aload_0
    //   100: monitorexit
    //   101: ldc_w 591
    //   104: invokestatic 184	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   107: aload_1
    //   108: athrow
    //   109: astore_1
    //   110: aload_0
    //   111: monitorenter
    //   112: aload_0
    //   113: aload_0
    //   114: getfield 611	com/google/android/exoplayer2/i:cGh	I
    //   117: iconst_1
    //   118: iadd
    //   119: putfield 611	com/google/android/exoplayer2/i:cGh	I
    //   122: aload_0
    //   123: invokevirtual 308	java/lang/Object:notifyAll	()V
    //   126: aload_0
    //   127: monitorexit
    //   128: ldc_w 591
    //   131: invokestatic 184	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   134: aload_1
    //   135: athrow
    //   136: astore_1
    //   137: aload_0
    //   138: monitorexit
    //   139: ldc_w 591
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
    AppMethodBeat.i(91942);
    this.cFQ = new b(0L);
    e(paramObject, paramInt);
    this.cFQ = new b(-9223372036854775807L);
    setState(4);
    bx(false);
    AppMethodBeat.o(91942);
  }
  
  private void e(Object paramObject, int paramInt)
  {
    AppMethodBeat.i(91943);
    this.eventHandler.obtainMessage(6, new d(this.cFL, paramObject, this.cFQ, paramInt)).sendToTarget();
    AppMethodBeat.o(91943);
  }
  
  private Pair<Integer, Long> hj(int paramInt)
  {
    AppMethodBeat.i(91946);
    Pair localPair = this.cFL.a(this.cFD, this.cFE, paramInt, -9223372036854775807L);
    AppMethodBeat.o(91946);
    return localPair;
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
    //   2: ldc_w 636
    //   5: invokestatic 92	com/tencent/matrix/trace/core/AppMethodBeat:i	(I)V
    //   8: aload_0
    //   9: getfield 305	com/google/android/exoplayer2/i:released	Z
    //   12: ifeq +12 -> 24
    //   15: ldc_w 636
    //   18: invokestatic 184	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   21: aload_0
    //   22: monitorexit
    //   23: return
    //   24: aload_0
    //   25: getfield 638	com/google/android/exoplayer2/i:cGg	I
    //   28: istore_3
    //   29: aload_0
    //   30: iload_3
    //   31: iconst_1
    //   32: iadd
    //   33: putfield 638	com/google/android/exoplayer2/i:cGg	I
    //   36: aload_0
    //   37: getfield 181	com/google/android/exoplayer2/i:handler	Landroid/os/Handler;
    //   40: bipush 11
    //   42: aload_1
    //   43: invokevirtual 513	android/os/Handler:obtainMessage	(ILjava/lang/Object;)Landroid/os/Message;
    //   46: invokevirtual 518	android/os/Message:sendToTarget	()V
    //   49: iconst_0
    //   50: istore_2
    //   51: aload_0
    //   52: getfield 611	com/google/android/exoplayer2/i:cGh	I
    //   55: istore 4
    //   57: iload 4
    //   59: iload_3
    //   60: if_icmpgt +16 -> 76
    //   63: aload_0
    //   64: invokevirtual 641	java/lang/Object:wait	()V
    //   67: goto -16 -> 51
    //   70: astore_1
    //   71: iconst_1
    //   72: istore_2
    //   73: goto -22 -> 51
    //   76: iload_2
    //   77: ifeq +9 -> 86
    //   80: invokestatic 647	java/lang/Thread:currentThread	()Ljava/lang/Thread;
    //   83: invokevirtual 650	java/lang/Thread:interrupt	()V
    //   86: ldc_w 636
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
      QJ();
      AppMethodBeat.o(91924);
      return true;
      if (paramMessage.arg1 == 0) {
        break label300;
      }
      bool = true;
      this.cGf = false;
      this.cFG = bool;
      if (bool) {
        break label306;
      }
      QH();
      QI();
      for (;;)
      {
        AppMethodBeat.o(91924);
        return true;
        bool = false;
        break;
        if (this.state != 3) {
          break label359;
        }
        QG();
        this.handler.sendEmptyMessage(2);
      }
    }
    catch (IOException paramMessage)
    {
      for (;;)
      {
        this.eventHandler.obtainMessage(8, e.a(paramMessage)).sendToTarget();
        QJ();
        AppMethodBeat.o(91924);
        return true;
        if (this.state == 2) {
          this.handler.sendEmptyMessage(2);
        }
      }
    }
    catch (RuntimeException paramMessage)
    {
      this.eventHandler.obtainMessage(8, e.b(paramMessage)).sendToTarget();
      QJ();
      AppMethodBeat.o(91924);
      return true;
    }
    Object localObject1 = (k)paramMessage.obj;
    if (paramMessage.arg1 != 0)
    {
      i = 1;
      this.eventHandler.sendEmptyMessage(0);
      bx(true);
      this.cFW.Qz();
      if (i == 0) {
        break label197;
      }
    }
    label197:
    for (this.cFQ = new b(-9223372036854775807L);; this.cFQ = new b(this.cFQ.cGA, this.cFQ.cGD, this.cFQ.cGC))
    {
      this.cGd = ((k)localObject1);
      if (localObject1 != null) {
        ((k)localObject1).a(this.cFZ, this);
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
    this.cFH = i;
    this.cGa.cFH = i;
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
    if (this.cGo != null)
    {
      paramMessage = this.cGo;
    }
    else
    {
      for (;;)
      {
        j = this.cFL.a(paramMessage.cGu.cHe.cZS, this.cFE, this.cFD, i);
        while ((paramMessage.cGx != null) && (!paramMessage.cGu.cHh))
        {
          paramMessage = paramMessage.cGx;
          continue;
          paramMessage = this.cGm;
          break label4822;
        }
        if ((j == -1) || (paramMessage.cGx == null) || (paramMessage.cGx.cGu.cHe.cZS != j)) {
          break;
        }
        paramMessage = paramMessage.cGx;
      }
      j = this.cGm.index;
      if (this.cGn != null)
      {
        i = this.cGn.index;
        if (paramMessage.cGx != null)
        {
          a(paramMessage.cGx);
          paramMessage.cGx = null;
        }
        localObject1 = this.cGa;
        localObject2 = paramMessage.cGu;
        paramMessage.cGu = ((n)localObject1).a((n.a)localObject2, ((n.a)localObject2).cHe);
        if (j > paramMessage.index) {
          break label708;
        }
        j = 1;
        if (j == 0) {
          this.cGm = paramMessage;
        }
        if ((i == -1) || (i > paramMessage.index)) {
          break label713;
        }
      }
      for (i = 1;; i = 0)
      {
        if ((i == 0) && (this.cGo != null))
        {
          paramMessage = this.cGo.cGu.cHe;
          this.cFQ = new b(paramMessage, a(paramMessage, this.cFQ.cGD), this.cFQ.cGC);
        }
        AppMethodBeat.o(91924);
        return true;
        i = -1;
        break;
        j = 0;
        break label618;
      }
      long l3 = SystemClock.elapsedRealtime();
      if ((this.cFL == null) && (this.cGd != null)) {
        this.cGd.SU();
      }
      long l4;
      while (this.cGo == null)
      {
        QL();
        A(l3, 10L);
        AppMethodBeat.o(91924);
        return true;
        if (this.cGm == null)
        {
          paramMessage = this.cGa;
          localObject1 = this.cFQ;
          paramMessage = paramMessage.a(((b)localObject1).cGA, ((b)localObject1).cGC, ((b)localObject1).cGB);
          if (paramMessage != null) {
            break label1556;
          }
          this.cGd.SU();
          if ((this.cGm != null) && (!this.cGm.QO())) {
            break label1719;
          }
          bw(false);
        }
        for (;;)
        {
          if (this.cGo == null) {
            break label1738;
          }
          while ((this.cGo != this.cGn) && (this.cGl >= this.cGo.cGx.cGt))
          {
            this.cGo.release();
            b(this.cGo.cGx);
            this.cFQ = new b(this.cGo.cGu.cHe, this.cGo.cGu.cGB, this.cGo.cGu.cGC);
            QI();
            this.eventHandler.obtainMessage(5, this.cFQ).sendToTarget();
          }
          if ((this.cGm.cGu.cHi) || (!this.cGm.QO()) || (this.cGm.cGu.cHg == -9223372036854775807L) || ((this.cGo != null) && (this.cGm.index - this.cGo.index == 100))) {
            break label825;
          }
          paramMessage = this.cGa;
          localObject2 = this.cGm.cGu;
          l1 = this.cGm.QN();
          l2 = this.cGl;
          if (((n.a)localObject2).cHh)
          {
            i = paramMessage.cFL.a(((n.a)localObject2).cHe.cZS, paramMessage.cFE, paramMessage.cFD, paramMessage.cFH);
            if (i == -1)
            {
              paramMessage = null;
              break;
            }
            j = paramMessage.cFL.a(i, paramMessage.cFE, false).cGF;
            if (paramMessage.cFL.a(j, paramMessage.cFD).cHV != i) {
              break label4829;
            }
            l4 = ((n.a)localObject2).cHg;
            localObject1 = paramMessage.cFL.a(paramMessage.cFD, paramMessage.cFE, j, -9223372036854775807L, Math.max(0L, l4 + l1 - l2));
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
          localObject1 = ((n.a)localObject2).cHe;
          if (((k.b)localObject1).isAd())
          {
            i = ((k.b)localObject1).cZT;
            paramMessage.cFL.a(((k.b)localObject1).cZS, paramMessage.cFE, false);
            j = paramMessage.cFE.cHM[i];
            if (j == -1)
            {
              paramMessage = null;
              break;
            }
            k = ((k.b)localObject1).cZU + 1;
            if (k < j)
            {
              if (!paramMessage.cFE.cb(i, k))
              {
                paramMessage = null;
                break;
              }
              paramMessage = paramMessage.b(((k.b)localObject1).cZS, i, k, ((n.a)localObject2).cGC);
              break;
            }
            i = paramMessage.cFE.bW(((n.a)localObject2).cGC);
            if (i == -1) {}
            for (l1 = -9223372036854775808L;; l1 = paramMessage.cFE.cHL[i])
            {
              paramMessage = paramMessage.c(((k.b)localObject1).cZS, ((n.a)localObject2).cGC, l1);
              break;
            }
          }
          if (((n.a)localObject2).cHf != -9223372036854775808L)
          {
            i = paramMessage.cFE.bV(((n.a)localObject2).cHf);
            if (!paramMessage.cFE.cb(i, 0))
            {
              paramMessage = null;
              break;
            }
            paramMessage = paramMessage.b(((k.b)localObject1).cZS, i, 0, ((n.a)localObject2).cHf);
            break;
          }
          i = paramMessage.cFE.QY();
          if (i == 0) {
            break label4835;
          }
          localObject2 = paramMessage.cFE;
          i -= 1;
          if ((localObject2.cHL[i] != -9223372036854775808L) || (paramMessage.cFE.hm(i)) || (!paramMessage.cFE.cb(i, 0))) {
            break label4835;
          }
          l1 = paramMessage.cFE.cHg;
          paramMessage = paramMessage.b(((k.b)localObject1).cZS, i, 0, l1);
          break;
          if (this.cGm == null)
          {
            l1 = 60000000L;
            if (this.cGm != null) {
              break label1706;
            }
          }
          for (i = 0;; i = this.cGm.index + 1)
          {
            localObject1 = this.cFL.a(paramMessage.cHe.cZS, this.cFE, true).cGq;
            localObject1 = new a(this.cFy, this.cFV, l1, this.cFz, this.cFW, this.cGd, localObject1, i, paramMessage);
            if (this.cGm != null) {
              this.cGm.cGx = ((a)localObject1);
            }
            this.cGm = ((a)localObject1);
            this.cGm.cGp.a(this, paramMessage.cGB);
            bw(true);
            break;
            l1 = this.cGm.QN() + this.cGm.cGu.cHg;
            break label1568;
          }
          if ((this.cGm != null) && (!this.isLoading)) {
            QM();
          }
        }
        continue;
        if (!this.cGn.cGu.cHi) {
          break label4847;
        }
        i = 0;
        if (i >= this.cFy.length) {
          break label4845;
        }
        paramMessage = this.cFy[i];
        localObject1 = this.cGn.cGr[i];
        if ((localObject1 == null) || (paramMessage.Qo() != localObject1) || (!paramMessage.Qp())) {
          break label4840;
        }
        paramMessage.Qq();
        break label4840;
        if (i < this.cFy.length)
        {
          paramMessage = this.cFy[i];
          localObject1 = this.cGn.cGr[i];
          if (paramMessage.Qo() == localObject1)
          {
            if (localObject1 == null) {
              break label4852;
            }
            if (paramMessage.Qp()) {
              break label4852;
            }
          }
        }
        else if ((this.cGn.cGx != null) && (this.cGn.cGx.cGv))
        {
          paramMessage = this.cGn.cGy;
          this.cGn = this.cGn.cGx;
          localObject1 = this.cGn.cGy;
          if (this.cGn.cGp.SQ() == -9223372036854775807L) {
            break label4864;
          }
          i = 1;
          break label4859;
          if (j >= this.cFy.length) {
            break label4874;
          }
          localObject2 = this.cFy[j];
          if (paramMessage.dib.dhY[j] == null) {
            break label4869;
          }
          if (i == 0)
          {
            if (((r)localObject2).Qr()) {
              break label4869;
            }
            localObject3 = localObject1.dib.dhY[j];
            localObject4 = paramMessage.dic[j];
            t localt = localObject1.dic[j];
            if ((localObject3 != null) && (localt.equals(localObject4)))
            {
              localObject4 = new Format[((com.google.android.exoplayer2.g.f)localObject3).length()];
              k = 0;
              while (k < localObject4.length)
              {
                localObject4[k] = ((com.google.android.exoplayer2.g.f)localObject3).iB(k);
                k += 1;
              }
              ((r)localObject2).a((Format[])localObject4, this.cGn.cGr[j], this.cGn.QN());
              break label4869;
            }
          }
          ((r)localObject2).Qq();
          break label4869;
        }
      }
      v.ax("doSomeWork");
      QI();
      this.cGo.cGp.cm(this.cFQ.cGD);
      i = 1;
      bool = true;
      paramMessage = this.cGe;
      int m = paramMessage.length;
      j = 0;
      if (j < m)
      {
        localObject1 = paramMessage[j];
        ((r)localObject1).B(this.cGl, this.cGi);
        if ((i == 0) || (!((r)localObject1).QU())) {
          break label4902;
        }
        i = 1;
        label2204:
        if (((r)localObject1).isReady()) {
          break label4876;
        }
        if (!((r)localObject1).QU()) {
          break label4907;
        }
        break label4876;
        label2227:
        if (k != 0) {
          break label4882;
        }
        ((r)localObject1).Qs();
        break label4882;
      }
      if (!bool) {
        QL();
      }
      if (this.cGc != null)
      {
        paramMessage = this.cGc.Ru();
        if (!paramMessage.equals(this.cFP))
        {
          this.cFP = paramMessage;
          this.cFX.a(this.cGc);
          this.eventHandler.obtainMessage(7, paramMessage).sendToTarget();
        }
      }
      l1 = this.cGo.cGu.cHg;
      if ((i != 0) && ((l1 == -9223372036854775807L) || (l1 <= this.cFQ.cGD)) && (this.cGo.cGu.cHi))
      {
        setState(4);
        QH();
      }
      label2368:
      while (this.state == 2)
      {
        paramMessage = this.cGe;
        j = paramMessage.length;
        i = 0;
        while (i < j)
        {
          paramMessage[i].Qs();
          i += 1;
        }
        if (this.state == 2)
        {
          if (this.cGe.length > 0)
          {
            if (!bool) {
              break label4930;
            }
            paramMessage = this.cGm;
            bool = this.cGf;
            l4 = this.cGl;
            if (!paramMessage.cGv)
            {
              l1 = paramMessage.cGu.cGB;
              l2 = l1;
              if (l1 != -9223372036854775808L) {
                break label2536;
              }
              if (!paramMessage.cGu.cHi) {
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
            if (!this.cFG) {
              break;
            }
            QG();
            break;
            l1 = paramMessage.cGp.SR();
            break label2460;
            label2527:
            l2 = paramMessage.cGu.cHg;
            label2536:
            bool = paramMessage.cFW.g(l2 - (l4 - paramMessage.QN()), bool);
            break label4919;
            bool = bR(l1);
          }
        }
        if (this.state == 3)
        {
          if (this.cGe.length > 0) {}
          for (;;)
          {
            if (bool) {
              break label2623;
            }
            this.cGf = this.cFG;
            setState(2);
            QH();
            break;
            bool = bR(l1);
          }
        }
      }
      label2460:
      label2489:
      label2623:
      if (((this.cFG) && (this.state == 3)) || (this.state == 2)) {
        A(l3, 10L);
      }
      for (;;)
      {
        v.DS();
        break;
        if ((this.cGe.length != 0) && (this.state != 4)) {
          A(l3, 1000L);
        } else {
          this.handler.removeMessages(2);
        }
      }
      paramMessage = (c)paramMessage.obj;
      if (this.cFL == null)
      {
        this.cGj += 1;
        this.cGk = paramMessage;
      }
      for (;;)
      {
        AppMethodBeat.o(91924);
        return true;
        localObject1 = a(paramMessage);
        if (localObject1 == null)
        {
          this.cFQ = new b(0L);
          this.eventHandler.obtainMessage(4, 1, 0, this.cFQ).sendToTarget();
          this.cFQ = new b(-9223372036854775807L);
          setState(4);
          bx(false);
        }
        else
        {
          if (paramMessage.cGG == -9223372036854775807L)
          {
            i = 1;
            label2821:
            j = ((Integer)((Pair)localObject1).first).intValue();
            l2 = ((Long)((Pair)localObject1).second).longValue();
            localObject1 = this.cGa.g(j, l2);
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
            if (((k.b)localObject1).equals(this.cFQ.cGA))
            {
              l3 = l1 / 1000L;
              l4 = this.cFQ.cGD / 1000L;
              if (l3 == l4)
              {
                this.cFQ = new b((k.b)localObject1, l1, l2);
                paramMessage = this.eventHandler;
                if (i != 0) {}
                for (i = 1;; i = 0)
                {
                  paramMessage.obtainMessage(4, i, 0, this.cFQ).sendToTarget();
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
            this.cFQ = new b((k.b)localObject1, l3, l2);
            paramMessage = this.eventHandler;
            if ((i | j) == 0) {
              break label4941;
            }
            i = 1;
            label3024:
            paramMessage.obtainMessage(4, i, 0, this.cFQ).sendToTarget();
          }
          finally
          {
            this.cFQ = new b((k.b)localObject1, l1, l2);
            localObject1 = this.eventHandler;
            if (i == 0) {
              break label4946;
            }
          }
        }
      }
      i = 1;
      label3071:
      ((Handler)localObject1).obtainMessage(4, i, 0, this.cFQ).sendToTarget();
      AppMethodBeat.o(91924);
      throw paramMessage;
      paramMessage = (p)paramMessage.obj;
      if (this.cGc != null) {}
      for (paramMessage = this.cGc.b(paramMessage);; paramMessage = this.cFX.b(paramMessage))
      {
        this.cFP = paramMessage;
        this.eventHandler.obtainMessage(7, paramMessage).sendToTarget();
        AppMethodBeat.o(91924);
        return true;
      }
      QJ();
      AppMethodBeat.o(91924);
      return true;
      QK();
      AppMethodBeat.o(91924);
      return true;
      paramMessage = (j)paramMessage.obj;
      if (this.cGm != null)
      {
        localObject1 = this.cGm.cGp;
        if (localObject1 == paramMessage) {
          break label3220;
        }
      }
      for (;;)
      {
        AppMethodBeat.o(91924);
        return true;
        label3220:
        paramMessage = this.cGm;
        paramMessage.cGv = true;
        paramMessage.QP();
        l1 = paramMessage.bT(paramMessage.cGu.cGB);
        localObject1 = paramMessage.cGu;
        paramMessage.cGu = new n.a(((n.a)localObject1).cHe, l1, ((n.a)localObject1).cHf, ((n.a)localObject1).cGC, ((n.a)localObject1).cHg, ((n.a)localObject1).cHh, ((n.a)localObject1).cHi);
        if (this.cGo == null)
        {
          this.cGn = this.cGm;
          bQ(this.cGn.cGu.cGB);
          b(this.cGn);
        }
        QM();
      }
      paramMessage = (Pair)paramMessage.obj;
      localObject3 = this.cFL;
      this.cFL = ((w)paramMessage.first);
      this.cGa.cFL = this.cFL;
      localObject2 = paramMessage.second;
      if (localObject3 == null)
      {
        if (this.cGj > 0)
        {
          paramMessage = a(this.cGk);
          i = this.cGj;
          this.cGj = 0;
          this.cGk = null;
          if (paramMessage == null) {
            d(localObject2, i);
          }
        }
        for (;;)
        {
          AppMethodBeat.o(91924);
          return true;
          j = ((Integer)paramMessage.first).intValue();
          l2 = ((Long)paramMessage.second).longValue();
          paramMessage = this.cGa.g(j, l2);
          if (!paramMessage.isAd()) {
            break;
          }
          l1 = 0L;
          label3482:
          this.cFQ = new b(paramMessage, l1, l2);
          e(localObject2, i);
          continue;
          if (this.cFQ.cGB == -9223372036854775807L)
          {
            if (this.cFL.isEmpty())
            {
              d(localObject2, 0);
            }
            else
            {
              paramMessage = hj(0);
              i = ((Integer)paramMessage.first).intValue();
              l2 = ((Long)paramMessage.second).longValue();
              paramMessage = this.cGa.g(i, l2);
              if (!paramMessage.isAd()) {
                break label4958;
              }
              l1 = 0L;
              label3592:
              this.cFQ = new b(paramMessage, l1, l2);
            }
          }
          else {
            e(localObject2, 0);
          }
        }
      }
      j = this.cFQ.cGA.cZS;
      if (this.cGo != null)
      {
        paramMessage = this.cGo;
        label3641:
        if ((paramMessage == null) && (j >= ((w)localObject3).QX())) {
          break label3903;
        }
        if (paramMessage != null) {
          break label3724;
        }
      }
      label3724:
      for (localObject1 = ((w)localObject3).a(j, this.cFE, true).cGq;; localObject1 = paramMessage.cGq)
      {
        i = this.cFL.bf(localObject1);
        if (i != -1) {
          break label3913;
        }
        i = a(j, (w)localObject3, this.cFL);
        if (i != -1) {
          break label3733;
        }
        d(localObject2, 0);
        break;
        paramMessage = this.cGm;
        break label3641;
      }
      label3733:
      localObject1 = hj(this.cFL.a(i, this.cFE, false).cGF);
      i = ((Integer)((Pair)localObject1).first).intValue();
      l1 = ((Long)((Pair)localObject1).second).longValue();
      this.cFL.a(i, this.cFE, true);
      if (paramMessage != null)
      {
        localObject1 = this.cFE.cGq;
        paramMessage.cGu = paramMessage.cGu.QT();
        while (paramMessage.cGx != null)
        {
          paramMessage = paramMessage.cGx;
          if (paramMessage.cGq.equals(localObject1)) {
            paramMessage.cGu = this.cGa.a(paramMessage.cGu, i);
          } else {
            paramMessage.cGu = paramMessage.cGu.QT();
          }
        }
      }
      paramMessage = new k.b(i);
      this.cFQ = new b(paramMessage, a(paramMessage, l1));
      for (;;)
      {
        label3903:
        e(localObject2, 0);
        break;
        label3913:
        if (i != j)
        {
          localObject1 = this.cFQ;
          localObject3 = new b(((b)localObject1).cGA.ig(i), ((b)localObject1).cGB, ((b)localObject1).cGC);
          ((b)localObject3).cGD = ((b)localObject1).cGD;
          ((b)localObject3).cGE = ((b)localObject1).cGE;
          this.cFQ = ((b)localObject3);
        }
        if (this.cFQ.cGA.isAd())
        {
          localObject1 = this.cGa.g(i, this.cFQ.cGC);
          if ((!((k.b)localObject1).isAd()) || (((k.b)localObject1).cZU != this.cFQ.cGA.cZU))
          {
            l2 = a((k.b)localObject1, this.cFQ.cGC);
            if (!((k.b)localObject1).isAd()) {
              break label4965;
            }
            l1 = this.cFQ.cGC;
            label4066:
            this.cFQ = new b((k.b)localObject1, l2, l1);
            continue;
          }
        }
        if (paramMessage != null)
        {
          for (paramMessage = a(paramMessage, i); paramMessage.cGx != null; paramMessage = a((a)localObject1, i))
          {
            localObject1 = paramMessage.cGx;
            i = this.cFL.a(i, this.cFE, this.cFD, this.cFH);
            if ((i == -1) || (!((a)localObject1).cGq.equals(this.cFL.a(i, this.cFE, true).cGq))) {
              break label4174;
            }
          }
          continue;
          label4174:
          if ((this.cGn == null) || (this.cGn.index >= ((a)localObject1).index)) {
            break label4973;
          }
          i = 1;
          label4198:
          if (i == 0)
          {
            l1 = a(this.cGo.cGu.cHe, this.cFQ.cGD);
            this.cFQ = new b(this.cGo.cGu.cHe, l1, this.cFQ.cGC);
          }
          else
          {
            this.cGm = paramMessage;
            this.cGm.cGx = null;
            a((a)localObject1);
          }
        }
      }
      paramMessage = (j)paramMessage.obj;
      if (this.cGm != null)
      {
        localObject1 = this.cGm.cGp;
        if (localObject1 == paramMessage) {
          break label4317;
        }
      }
      for (;;)
      {
        AppMethodBeat.o(91924);
        return true;
        label4317:
        QM();
      }
      if (this.cGo != null)
      {
        paramMessage = this.cGo;
        i = 1;
      }
      for (;;)
      {
        if (paramMessage != null)
        {
          bool = paramMessage.cGv;
          if (bool) {}
        }
        else
        {
          AppMethodBeat.o(91924);
          return true;
        }
        if (paramMessage.QP()) {
          break;
        }
        if (paramMessage == this.cGn) {
          i = 0;
        }
        paramMessage = paramMessage.cGx;
      }
      if (i != 0)
      {
        if (this.cGn == this.cGo) {
          break label4988;
        }
        bool = true;
        label4404:
        a(this.cGo.cGx);
        this.cGo.cGx = null;
        this.cGm = this.cGo;
        this.cGn = this.cGo;
        localObject1 = new boolean[this.cFy.length];
        l1 = this.cGo.a(this.cFQ.cGD, bool, (boolean[])localObject1);
        if (l1 != this.cFQ.cGD)
        {
          this.cFQ.cGD = l1;
          bQ(l1);
        }
        j = 0;
        localObject2 = new boolean[this.cFy.length];
        i = 0;
        label4508:
        if (i < this.cFy.length)
        {
          localObject3 = this.cFy[i];
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
      localObject4 = this.cGo.cGr[i];
      k = j;
      if (localObject4 != null) {
        k = j + 1;
      }
      if (localObject2[i] != 0) {
        if (localObject4 != ((r)localObject3).Qo())
        {
          if (localObject3 == this.cGb)
          {
            if (localObject4 == null) {
              this.cFX.a(this.cGc);
            }
            this.cGc = null;
            this.cGb = null;
          }
          a((r)localObject3);
          ((r)localObject3).disable();
        }
        else if (localObject1[i] != 0)
        {
          ((r)localObject3).bK(this.cGl);
          break label4978;
          this.eventHandler.obtainMessage(3, paramMessage.cGy).sendToTarget();
          b((boolean[])localObject2, j);
          for (;;)
          {
            QM();
            QI();
            this.handler.sendEmptyMessage(2);
            break;
            this.cGm = paramMessage;
            for (paramMessage = this.cGm.cGx; paramMessage != null; paramMessage = paramMessage.cGx) {
              paramMessage.release();
            }
            this.cGm.cGx = null;
            if (this.cGm.cGv)
            {
              l1 = this.cGm.cGu.cGB;
              paramMessage = this.cGm;
              l1 = Math.max(l1, this.cGl - paramMessage.QN());
              this.cGm.bT(l1);
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
    //   2: ldc_w 875
    //   5: invokestatic 92	com/tencent/matrix/trace/core/AppMethodBeat:i	(I)V
    //   8: aload_0
    //   9: getfield 305	com/google/android/exoplayer2/i:released	Z
    //   12: ifeq +12 -> 24
    //   15: ldc_w 875
    //   18: invokestatic 184	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   21: aload_0
    //   22: monitorexit
    //   23: return
    //   24: aload_0
    //   25: getfield 181	com/google/android/exoplayer2/i:handler	Landroid/os/Handler;
    //   28: bipush 6
    //   30: invokevirtual 201	android/os/Handler:sendEmptyMessage	(I)Z
    //   33: pop
    //   34: iconst_0
    //   35: istore_1
    //   36: aload_0
    //   37: getfield 305	com/google/android/exoplayer2/i:released	Z
    //   40: istore_2
    //   41: iload_2
    //   42: ifne +16 -> 58
    //   45: aload_0
    //   46: invokevirtual 641	java/lang/Object:wait	()V
    //   49: goto -13 -> 36
    //   52: astore_3
    //   53: iconst_1
    //   54: istore_1
    //   55: goto -19 -> 36
    //   58: iload_1
    //   59: ifeq +9 -> 68
    //   62: invokestatic 647	java/lang/Thread:currentThread	()Ljava/lang/Thread;
    //   65: invokevirtual 650	java/lang/Thread:interrupt	()V
    //   68: aload_0
    //   69: getfield 167	com/google/android/exoplayer2/i:cFY	Landroid/os/HandlerThread;
    //   72: invokevirtual 878	android/os/HandlerThread:quit	()Z
    //   75: pop
    //   76: ldc_w 875
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
    private final s[] cFV;
    final m cFW;
    private final r[] cFy;
    private final h cFz;
    private final k cGd;
    public final j cGp;
    public final Object cGq;
    public final com.google.android.exoplayer2.source.n[] cGr;
    public final boolean[] cGs;
    public final long cGt;
    public n.a cGu;
    public boolean cGv;
    public boolean cGw;
    public a cGx;
    public com.google.android.exoplayer2.g.i cGy;
    private com.google.android.exoplayer2.g.i cGz;
    public final int index;
    
    public a(r[] paramArrayOfr, s[] paramArrayOfs, long paramLong, h paramh, m paramm, k paramk, Object paramObject, int paramInt, n.a parama)
    {
      AppMethodBeat.i(91909);
      this.cFy = paramArrayOfr;
      this.cFV = paramArrayOfs;
      this.cGt = paramLong;
      this.cFz = paramh;
      this.cFW = paramm;
      this.cGd = paramk;
      this.cGq = a.checkNotNull(paramObject);
      this.index = paramInt;
      this.cGu = parama;
      this.cGr = new com.google.android.exoplayer2.source.n[paramArrayOfr.length];
      this.cGs = new boolean[paramArrayOfr.length];
      paramArrayOfr = paramk.a(parama.cHe, paramm.QB());
      if (parama.cHf != -9223372036854775808L)
      {
        paramArrayOfr = new d(paramArrayOfr, true);
        paramArrayOfr.E(0L, parama.cHf);
      }
      for (;;)
      {
        this.cGp = paramArrayOfr;
        AppMethodBeat.o(91909);
        return;
      }
    }
    
    public final long QN()
    {
      if (this.index == 0) {
        return this.cGt;
      }
      return this.cGt - this.cGu.cGB;
    }
    
    public final boolean QO()
    {
      AppMethodBeat.i(91910);
      if ((this.cGv) && ((!this.cGw) || (this.cGp.SR() == -9223372036854775808L)))
      {
        AppMethodBeat.o(91910);
        return true;
      }
      AppMethodBeat.o(91910);
      return false;
    }
    
    public final boolean QP()
    {
      AppMethodBeat.i(91913);
      com.google.android.exoplayer2.g.i locali = this.cFz.a(this.cFV, this.cGp.SP());
      if (locali.a(this.cGz))
      {
        AppMethodBeat.o(91913);
        return false;
      }
      this.cGy = locali;
      AppMethodBeat.o(91913);
      return true;
    }
    
    public final long a(long paramLong, boolean paramBoolean, boolean[] paramArrayOfBoolean)
    {
      AppMethodBeat.i(91915);
      g localg = this.cGy.dib;
      int i = 0;
      if (i < localg.length)
      {
        boolean[] arrayOfBoolean = this.cGs;
        if ((!paramBoolean) && (this.cGy.a(this.cGz, i))) {}
        for (int j = 1;; j = 0)
        {
          arrayOfBoolean[i] = j;
          i += 1;
          break;
        }
      }
      paramLong = this.cGp.a(localg.Uf(), this.cGs, this.cGr, paramArrayOfBoolean, paramLong);
      this.cGz = this.cGy;
      this.cGw = false;
      i = 0;
      if (i < this.cGr.length)
      {
        if (this.cGr[i] != null)
        {
          if (localg.dhY[i] != null) {}
          for (paramBoolean = true;; paramBoolean = false)
          {
            a.checkState(paramBoolean);
            this.cGw = true;
            i += 1;
            break;
          }
        }
        if (localg.dhY[i] == null) {}
        for (paramBoolean = true;; paramBoolean = false)
        {
          a.checkState(paramBoolean);
          break;
        }
      }
      this.cFW.a(this.cFy, localg);
      AppMethodBeat.o(91915);
      return paramLong;
    }
    
    public final boolean bO(long paramLong)
    {
      AppMethodBeat.i(91911);
      if (!this.cGv) {}
      for (long l1 = 0L; l1 == -9223372036854775808L; l1 = this.cGp.SS())
      {
        AppMethodBeat.o(91911);
        return false;
      }
      long l2 = QN();
      boolean bool = this.cFW.bO(l1 - (paramLong - l2));
      AppMethodBeat.o(91911);
      return bool;
    }
    
    public final void bS(long paramLong)
    {
      AppMethodBeat.i(91912);
      long l = QN();
      this.cGp.co(paramLong - l);
      AppMethodBeat.o(91912);
    }
    
    public final long bT(long paramLong)
    {
      AppMethodBeat.i(91914);
      paramLong = a(paramLong, false, new boolean[this.cFy.length]);
      AppMethodBeat.o(91914);
      return paramLong;
    }
    
    public final void release()
    {
      AppMethodBeat.i(91916);
      try
      {
        if (this.cGu.cHf != -9223372036854775808L)
        {
          this.cGd.b(((d)this.cGp).cGp);
          AppMethodBeat.o(91916);
          return;
        }
        this.cGd.b(this.cGp);
        AppMethodBeat.o(91916);
        return;
      }
      catch (RuntimeException localRuntimeException)
      {
        AppMethodBeat.o(91916);
      }
    }
  }
  
  public static final class b
  {
    public final k.b cGA;
    public final long cGB;
    public final long cGC;
    public volatile long cGD;
    public volatile long cGE;
    
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
      this.cGA = paramb;
      this.cGB = paramLong1;
      this.cGC = paramLong2;
      this.cGD = paramLong1;
      this.cGE = paramLong1;
    }
  }
  
  static final class c
  {
    public final w cFL;
    public final int cGF;
    public final long cGG;
    
    public c(w paramw, int paramInt, long paramLong)
    {
      this.cFL = paramw;
      this.cGF = paramInt;
      this.cGG = paramLong;
    }
  }
  
  public static final class d
  {
    public final w cFL;
    public final Object cFM;
    public final i.b cFQ;
    public final int cGH;
    
    public d(w paramw, Object paramObject, i.b paramb, int paramInt)
    {
      this.cFL = paramw;
      this.cFM = paramObject;
      this.cFQ = paramb;
      this.cGH = paramInt;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes12.jar
 * Qualified Name:     com.google.android.exoplayer2.i
 * JD-Core Version:    0.7.0.1
 */