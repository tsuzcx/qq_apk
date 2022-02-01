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
import com.google.android.exoplayer2.source.c;
import com.google.android.exoplayer2.source.j;
import com.google.android.exoplayer2.source.j.a;
import com.google.android.exoplayer2.source.j.b;
import com.tencent.matrix.trace.core.AppMethodBeat;
import java.io.IOException;

final class i
  implements Handler.Callback, h.a, com.google.android.exoplayer2.source.i.a, j.a
{
  private final r[] aQP;
  private final h aQQ;
  private final w.b aQU;
  private final w.a aQV;
  private boolean aQX;
  private c aRA;
  private long aRB;
  private a aRC;
  private a aRD;
  private a aRE;
  private w aRb;
  private p aRf;
  private b aRg;
  private final s[] aRl;
  private final m aRm;
  private final com.google.android.exoplayer2.i.s aRn;
  private final HandlerThread aRo;
  private final f aRp;
  private final n aRq;
  private r aRr;
  private com.google.android.exoplayer2.i.i aRs;
  private j aRt;
  private r[] aRu;
  private boolean aRv;
  int aRw;
  private int aRx;
  private long aRy;
  private int aRz;
  private final Handler eventHandler;
  final Handler handler;
  private boolean isLoading;
  boolean released;
  private int repeatMode;
  private int state;
  
  public i(r[] paramArrayOfr, h paramh, m paramm, boolean paramBoolean, int paramInt, Handler paramHandler, b paramb, f paramf)
  {
    AppMethodBeat.i(91918);
    this.aQP = paramArrayOfr;
    this.aQQ = paramh;
    this.aRm = paramm;
    this.aQX = paramBoolean;
    this.repeatMode = paramInt;
    this.eventHandler = paramHandler;
    this.state = 1;
    this.aRg = paramb;
    this.aRp = paramf;
    this.aRl = new s[paramArrayOfr.length];
    paramInt = 0;
    while (paramInt < paramArrayOfr.length)
    {
      paramArrayOfr[paramInt].setIndex(paramInt);
      this.aRl[paramInt] = paramArrayOfr[paramInt].rh();
      paramInt += 1;
    }
    this.aRn = new com.google.android.exoplayer2.i.s();
    this.aRu = new r[0];
    this.aQU = new w.b();
    this.aQV = new w.a();
    this.aRq = new n();
    paramh.bwo = this;
    this.aRf = p.aSC;
    this.aRo = new HandlerThread("ExoPlayerImplInternal:Handler", -16);
    this.aRo.start();
    this.handler = new Handler(this.aRo.getLooper(), this);
    AppMethodBeat.o(91918);
  }
  
  private int a(int paramInt, w paramw1, w paramw2)
  {
    AppMethodBeat.i(91944);
    int m = paramw1.rQ();
    int k = 0;
    int i = -1;
    int j = paramInt;
    paramInt = k;
    while ((paramInt < m) && (i == -1))
    {
      j = paramw1.a(j, this.aQV, this.aQU, this.repeatMode);
      if (j == -1) {
        break;
      }
      i = paramw2.aa(paramw1.a(j, this.aQV, true).aRG);
      paramInt += 1;
    }
    AppMethodBeat.o(91944);
    return i;
  }
  
  private long a(j.b paramb, long paramLong)
  {
    AppMethodBeat.i(91931);
    rx();
    this.aRv = false;
    setState(2);
    Object localObject;
    if (this.aRE == null)
    {
      if (this.aRC == null) {
        break label288;
      }
      this.aRC.release();
      localObject = null;
    }
    for (;;)
    {
      if ((this.aRE != localObject) || (this.aRE != this.aRD))
      {
        paramb = this.aRu;
        int j = paramb.length;
        int i = 0;
        for (;;)
        {
          if (i < j)
          {
            paramb[i].disable();
            i += 1;
            continue;
            a locala1 = this.aRE;
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
              locala1 = locala1.aRN;
              break;
              locala1.release();
            }
          }
        }
        this.aRu = new r[0];
        this.aRs = null;
        this.aRr = null;
        this.aRE = null;
      }
      if (localObject != null)
      {
        localObject.aRN = null;
        this.aRC = localObject;
        this.aRD = localObject;
        b(localObject);
        long l = paramLong;
        if (this.aRE.aRM) {
          l = this.aRE.aRF.V(paramLong);
        }
        x(l);
        rB();
        paramLong = l;
      }
      for (;;)
      {
        this.handler.sendEmptyMessage(2);
        AppMethodBeat.o(91931);
        return paramLong;
        this.aRC = null;
        this.aRD = null;
        this.aRE = null;
        x(paramLong);
      }
      label288:
      localObject = null;
    }
  }
  
  private Pair<Integer, Long> a(c paramc)
  {
    AppMethodBeat.i(91945);
    Object localObject2 = paramc.aRb;
    Object localObject1 = localObject2;
    if (((w)localObject2).isEmpty()) {
      localObject1 = this.aRb;
    }
    try
    {
      localObject2 = ((w)localObject1).a(this.aQU, this.aQV, paramc.aRV, paramc.aRW);
      if (this.aRb == localObject1)
      {
        AppMethodBeat.o(91945);
        return localObject2;
      }
    }
    catch (IndexOutOfBoundsException localIndexOutOfBoundsException)
    {
      paramc = new l(this.aRb, paramc.aRV, paramc.aRW);
      AppMethodBeat.o(91945);
      throw paramc;
    }
    int i = this.aRb.aa(localIndexOutOfBoundsException.a(((Integer)((Pair)localObject2).first).intValue(), this.aQV, true).aRG);
    if (i != -1)
    {
      paramc = Pair.create(Integer.valueOf(i), ((Pair)localObject2).second);
      AppMethodBeat.o(91945);
      return paramc;
    }
    i = a(((Integer)((Pair)localObject2).first).intValue(), localIndexOutOfBoundsException, this.aRb);
    if (i != -1)
    {
      paramc = dG(this.aRb.a(i, this.aQV, false).aRV);
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
      parama.aRK = this.aRq.a(parama.aRK, paramInt);
      if ((parama.aRK.aSA) || (parama.aRN == null))
      {
        AppMethodBeat.o(91941);
        return parama;
      }
      parama = parama.aRN;
    }
  }
  
  private static void a(a parama)
  {
    AppMethodBeat.i(91948);
    while (parama != null)
    {
      parama.release();
      parama = parama.aRN;
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
    this.aRu = new r[paramInt];
    int i = 0;
    paramInt = 0;
    while (paramInt < this.aQP.length)
    {
      r localr = this.aQP[paramInt];
      Object localObject = this.aRE.aRO.bwq.bwn[paramInt];
      int j = i;
      if (localObject != null)
      {
        this.aRu[i] = localr;
        if (localr.getState() == 0)
        {
          t localt = this.aRE.aRO.bwr[paramInt];
          if ((this.aQX) && (this.state == 3))
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
              arrayOfFormat[k] = ((com.google.android.exoplayer2.g.f)localObject).fe(k);
              k += 1;
            }
            j = 0;
            break;
          }
          localr.a(localt, arrayOfFormat, this.aRE.aRH[paramInt], this.aRB, bool, this.aRE.rC());
          localObject = localr.ri();
          if (localObject != null)
          {
            if (this.aRs != null)
            {
              paramArrayOfBoolean = e.a(new IllegalStateException("Multiple renderer media clocks enabled."));
              AppMethodBeat.o(91950);
              throw paramArrayOfBoolean;
            }
            this.aRs = ((com.google.android.exoplayer2.i.i)localObject);
            this.aRr = localr;
            this.aRs.c(this.aRf);
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
  
  private boolean a(j.b paramb, long paramLong, a parama)
  {
    AppMethodBeat.i(91932);
    if ((paramb.equals(parama.aRK.aSx)) && (parama.aRL))
    {
      this.aRb.a(parama.aRK.aSx.blw, this.aQV, false);
      int i = this.aQV.D(paramLong);
      if ((i == -1) || (this.aQV.aTf[i] == parama.aRK.aSy))
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
    this.aRv = false;
    this.aRn.stop();
    this.aRs = null;
    this.aRr = null;
    this.aRB = 60000000L;
    Object localObject = this.aRu;
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
        this.aRu = new r[0];
        if (this.aRE != null) {}
        for (localObject = this.aRE;; localObject = this.aRC)
        {
          a((a)localObject);
          this.aRC = null;
          this.aRD = null;
          this.aRE = null;
          aP(false);
          if (paramBoolean)
          {
            if (this.aRt != null)
            {
              this.aRt.tH();
              this.aRt = null;
            }
            this.aRq.aRb = null;
            this.aRb = null;
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
    if (this.aRE == parama)
    {
      AppMethodBeat.o(91949);
      return;
    }
    boolean[] arrayOfBoolean = new boolean[this.aQP.length];
    int i = 0;
    int j = 0;
    if (i < this.aQP.length)
    {
      r localr = this.aQP[i];
      if (localr.getState() != 0) {}
      for (int m = 1;; m = 0)
      {
        arrayOfBoolean[i] = m;
        com.google.android.exoplayer2.g.f localf = parama.aRO.bwq.bwn[i];
        int k = j;
        if (localf != null) {
          k = j + 1;
        }
        if ((arrayOfBoolean[i] != 0) && ((localf == null) || ((localr.rm()) && (localr.rj() == this.aRE.aRH[i]))))
        {
          if (localr == this.aRr)
          {
            this.aRn.a(this.aRs);
            this.aRs = null;
            this.aRr = null;
          }
          a(localr);
          localr.disable();
        }
        i += 1;
        j = k;
        break;
      }
    }
    this.aRE = parama;
    this.eventHandler.obtainMessage(3, parama.aRO).sendToTarget();
    a(arrayOfBoolean, j);
    AppMethodBeat.o(91949);
  }
  
  private void c(Object paramObject, int paramInt)
  {
    AppMethodBeat.i(91942);
    this.aRg = new b(0L);
    d(paramObject, paramInt);
    this.aRg = new b(-9223372036854775807L);
    setState(4);
    aQ(false);
    AppMethodBeat.o(91942);
  }
  
  /* Error */
  private void c(f.c[] paramArrayOfc)
  {
    // Byte code:
    //   0: ldc_w 506
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
    //   23: getfield 512	com/google/android/exoplayer2/f$c:aQM	Lcom/google/android/exoplayer2/f$b;
    //   26: aload 4
    //   28: getfield 515	com/google/android/exoplayer2/f$c:aQN	I
    //   31: aload 4
    //   33: getfield 518	com/google/android/exoplayer2/f$c:aQO	Ljava/lang/Object;
    //   36: invokeinterface 523 3 0
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
    //   69: invokevirtual 266	android/os/Handler:sendEmptyMessage	(I)Z
    //   72: pop
    //   73: aload_0
    //   74: monitorenter
    //   75: aload_0
    //   76: aload_0
    //   77: getfield 525	com/google/android/exoplayer2/i:aRx	I
    //   80: iconst_1
    //   81: iadd
    //   82: putfield 525	com/google/android/exoplayer2/i:aRx	I
    //   85: aload_0
    //   86: invokevirtual 528	java/lang/Object:notifyAll	()V
    //   89: aload_0
    //   90: monitorexit
    //   91: ldc_w 506
    //   94: invokestatic 184	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   97: return
    //   98: astore_1
    //   99: aload_0
    //   100: monitorexit
    //   101: ldc_w 506
    //   104: invokestatic 184	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   107: aload_1
    //   108: athrow
    //   109: astore_1
    //   110: aload_0
    //   111: monitorenter
    //   112: aload_0
    //   113: aload_0
    //   114: getfield 525	com/google/android/exoplayer2/i:aRx	I
    //   117: iconst_1
    //   118: iadd
    //   119: putfield 525	com/google/android/exoplayer2/i:aRx	I
    //   122: aload_0
    //   123: invokevirtual 528	java/lang/Object:notifyAll	()V
    //   126: aload_0
    //   127: monitorexit
    //   128: ldc_w 506
    //   131: invokestatic 184	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   134: aload_1
    //   135: athrow
    //   136: astore_1
    //   137: aload_0
    //   138: monitorexit
    //   139: ldc_w 506
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
    this.eventHandler.obtainMessage(6, new d(this.aRb, paramObject, this.aRg, paramInt)).sendToTarget();
    AppMethodBeat.o(91943);
  }
  
  private Pair<Integer, Long> dG(int paramInt)
  {
    AppMethodBeat.i(91946);
    Pair localPair = this.aRb.a(this.aQU, this.aQV, paramInt, -9223372036854775807L);
    AppMethodBeat.o(91946);
    return localPair;
  }
  
  private void nW()
  {
    AppMethodBeat.i(91935);
    aQ(true);
    this.aRm.rr();
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
  
  private void rA()
  {
    AppMethodBeat.i(91940);
    if ((this.aRC != null) && (!this.aRC.aRL) && ((this.aRD == null) || (this.aRD.aRN == this.aRC)))
    {
      r[] arrayOfr = this.aRu;
      int j = arrayOfr.length;
      int i = 0;
      while (i < j)
      {
        if (!arrayOfr[i].rk())
        {
          AppMethodBeat.o(91940);
          return;
        }
        i += 1;
      }
      this.aRC.aRF.tA();
    }
    AppMethodBeat.o(91940);
  }
  
  private void rB()
  {
    AppMethodBeat.i(91947);
    boolean bool = this.aRC.v(this.aRB);
    aP(bool);
    if (bool) {
      this.aRC.z(this.aRB);
    }
    AppMethodBeat.o(91947);
  }
  
  private void rw()
  {
    int i = 0;
    AppMethodBeat.i(91927);
    this.aRv = false;
    this.aRn.start();
    r[] arrayOfr = this.aRu;
    int j = arrayOfr.length;
    while (i < j)
    {
      arrayOfr[i].start();
      i += 1;
    }
    AppMethodBeat.o(91927);
  }
  
  private void rx()
  {
    AppMethodBeat.i(91928);
    this.aRn.stop();
    r[] arrayOfr = this.aRu;
    int j = arrayOfr.length;
    int i = 0;
    while (i < j)
    {
      a(arrayOfr[i]);
      i += 1;
    }
    AppMethodBeat.o(91928);
  }
  
  private void ry()
  {
    AppMethodBeat.i(91929);
    if (this.aRE == null)
    {
      AppMethodBeat.o(91929);
      return;
    }
    long l1 = this.aRE.aRF.tC();
    if (l1 != -9223372036854775807L)
    {
      x(l1);
      this.aRg.aRT = l1;
      this.aRy = (SystemClock.elapsedRealtime() * 1000L);
      if (this.aRu.length != 0) {
        break label194;
      }
    }
    label194:
    for (l1 = -9223372036854775808L;; l1 = this.aRE.aRF.tD())
    {
      Object localObject = this.aRg;
      long l2 = l1;
      if (l1 == -9223372036854775808L) {
        l2 = this.aRE.aRK.aSz;
      }
      ((b)localObject).aRU = l2;
      AppMethodBeat.o(91929);
      return;
      if ((this.aRr != null) && (!this.aRr.rM()))
      {
        this.aRB = this.aRs.si();
        this.aRn.al(this.aRB);
      }
      for (;;)
      {
        localObject = this.aRE;
        l1 = this.aRB - ((a)localObject).rC();
        break;
        this.aRB = this.aRn.si();
      }
    }
  }
  
  private void rz()
  {
    AppMethodBeat.i(91934);
    aQ(true);
    this.aRm.onStopped();
    setState(1);
    AppMethodBeat.o(91934);
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
  
  private void x(long paramLong)
  {
    AppMethodBeat.i(91933);
    if (this.aRE == null) {}
    for (paramLong = 60000000L + paramLong;; paramLong = this.aRE.rC() + paramLong)
    {
      this.aRB = paramLong;
      this.aRn.al(this.aRB);
      r[] arrayOfr = this.aRu;
      int j = arrayOfr.length;
      int i = 0;
      while (i < j)
      {
        arrayOfr[i].s(this.aRB);
        i += 1;
      }
    }
    AppMethodBeat.o(91933);
  }
  
  private boolean y(long paramLong)
  {
    AppMethodBeat.i(91939);
    if ((paramLong == -9223372036854775807L) || (this.aRg.aRT < paramLong) || ((this.aRE.aRN != null) && ((this.aRE.aRN.aRL) || (this.aRE.aRN.aRK.aSx.tQ()))))
    {
      AppMethodBeat.o(91939);
      return true;
    }
    AppMethodBeat.o(91939);
    return false;
  }
  
  public final void a(com.google.android.exoplayer2.source.i parami)
  {
    AppMethodBeat.i(91923);
    this.handler.obtainMessage(8, parami).sendToTarget();
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
    //   9: getfield 554	com/google/android/exoplayer2/i:released	Z
    //   12: ifeq +12 -> 24
    //   15: ldc_w 633
    //   18: invokestatic 184	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   21: aload_0
    //   22: monitorexit
    //   23: return
    //   24: aload_0
    //   25: getfield 635	com/google/android/exoplayer2/i:aRw	I
    //   28: istore_3
    //   29: aload_0
    //   30: iload_3
    //   31: iconst_1
    //   32: iadd
    //   33: putfield 635	com/google/android/exoplayer2/i:aRw	I
    //   36: aload_0
    //   37: getfield 181	com/google/android/exoplayer2/i:handler	Landroid/os/Handler;
    //   40: bipush 11
    //   42: aload_1
    //   43: invokevirtual 492	android/os/Handler:obtainMessage	(ILjava/lang/Object;)Landroid/os/Message;
    //   46: invokevirtual 454	android/os/Message:sendToTarget	()V
    //   49: iconst_0
    //   50: istore_2
    //   51: aload_0
    //   52: getfield 525	com/google/android/exoplayer2/i:aRx	I
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
      rz();
      AppMethodBeat.o(91924);
      return true;
      if (paramMessage.arg1 == 0) {
        break label300;
      }
      bool = true;
      this.aRv = false;
      this.aQX = bool;
      if (bool) {
        break label306;
      }
      rx();
      ry();
      for (;;)
      {
        AppMethodBeat.o(91924);
        return true;
        bool = false;
        break;
        if (this.state != 3) {
          break label359;
        }
        rw();
        this.handler.sendEmptyMessage(2);
      }
    }
    catch (IOException paramMessage)
    {
      for (;;)
      {
        this.eventHandler.obtainMessage(8, e.a(paramMessage)).sendToTarget();
        rz();
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
      rz();
      AppMethodBeat.o(91924);
      return true;
    }
    Object localObject1 = (j)paramMessage.obj;
    if (paramMessage.arg1 != 0)
    {
      i = 1;
      this.eventHandler.sendEmptyMessage(0);
      aQ(true);
      this.aRm.rq();
      if (i == 0) {
        break label197;
      }
    }
    label197:
    for (this.aRg = new b(-9223372036854775807L);; this.aRg = new b(this.aRg.aRQ, this.aRg.aRT, this.aRg.aRS))
    {
      this.aRt = ((j)localObject1);
      if (localObject1 != null) {
        ((j)localObject1).a(this.aRp, this);
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
    this.aRq.repeatMode = i;
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
    if (this.aRE != null)
    {
      paramMessage = this.aRE;
    }
    else
    {
      for (;;)
      {
        j = this.aRb.a(paramMessage.aRK.aSx.blw, this.aQV, this.aQU, i);
        while ((paramMessage.aRN != null) && (!paramMessage.aRK.aSA))
        {
          paramMessage = paramMessage.aRN;
          continue;
          paramMessage = this.aRC;
          break label4822;
        }
        if ((j == -1) || (paramMessage.aRN == null) || (paramMessage.aRN.aRK.aSx.blw != j)) {
          break;
        }
        paramMessage = paramMessage.aRN;
      }
      j = this.aRC.index;
      if (this.aRD != null)
      {
        i = this.aRD.index;
        if (paramMessage.aRN != null)
        {
          a(paramMessage.aRN);
          paramMessage.aRN = null;
        }
        localObject1 = this.aRq;
        localObject2 = paramMessage.aRK;
        paramMessage.aRK = ((n)localObject1).a((n.a)localObject2, ((n.a)localObject2).aSx);
        if (j > paramMessage.index) {
          break label708;
        }
        j = 1;
        if (j == 0) {
          this.aRC = paramMessage;
        }
        if ((i == -1) || (i > paramMessage.index)) {
          break label713;
        }
      }
      for (i = 1;; i = 0)
      {
        if ((i == 0) && (this.aRE != null))
        {
          paramMessage = this.aRE.aRK.aSx;
          this.aRg = new b(paramMessage, a(paramMessage, this.aRg.aRT), this.aRg.aRS);
        }
        AppMethodBeat.o(91924);
        return true;
        i = -1;
        break;
        j = 0;
        break label618;
      }
      long l3 = SystemClock.elapsedRealtime();
      if ((this.aRb == null) && (this.aRt != null)) {
        this.aRt.tG();
      }
      long l4;
      while (this.aRE == null)
      {
        rA();
        d(l3, 10L);
        AppMethodBeat.o(91924);
        return true;
        if (this.aRC == null)
        {
          paramMessage = this.aRq;
          localObject1 = this.aRg;
          paramMessage = paramMessage.a(((b)localObject1).aRQ, ((b)localObject1).aRS, ((b)localObject1).aRR);
          if (paramMessage != null) {
            break label1556;
          }
          this.aRt.tG();
          if ((this.aRC != null) && (!this.aRC.rD())) {
            break label1719;
          }
          aP(false);
        }
        for (;;)
        {
          if (this.aRE == null) {
            break label1738;
          }
          while ((this.aRE != this.aRD) && (this.aRB >= this.aRE.aRN.aRJ))
          {
            this.aRE.release();
            b(this.aRE.aRN);
            this.aRg = new b(this.aRE.aRK.aSx, this.aRE.aRK.aRR, this.aRE.aRK.aRS);
            ry();
            this.eventHandler.obtainMessage(5, this.aRg).sendToTarget();
          }
          if ((this.aRC.aRK.aSB) || (!this.aRC.rD()) || (this.aRC.aRK.aSz == -9223372036854775807L) || ((this.aRE != null) && (this.aRC.index - this.aRE.index == 100))) {
            break label825;
          }
          paramMessage = this.aRq;
          localObject1 = this.aRC.aRK;
          l1 = this.aRC.rC();
          l2 = this.aRB;
          if (((n.a)localObject1).aSA)
          {
            i = paramMessage.aRb.a(((n.a)localObject1).aSx.blw, paramMessage.aQV, paramMessage.aQU, paramMessage.repeatMode);
            if (i == -1)
            {
              paramMessage = null;
              break;
            }
            j = paramMessage.aRb.a(i, paramMessage.aQV, false).aRV;
            if (paramMessage.aRb.a(j, paramMessage.aQU).aTp != i) {
              break label4829;
            }
            l4 = ((n.a)localObject1).aSz;
            localObject1 = paramMessage.aRb.a(paramMessage.aQU, paramMessage.aQV, j, -9223372036854775807L, Math.max(0L, l4 + l1 - l2));
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
          localObject2 = ((n.a)localObject1).aSx;
          if (((j.b)localObject2).tQ())
          {
            i = ((j.b)localObject2).blx;
            paramMessage.aRb.a(((j.b)localObject2).blw, paramMessage.aQV, false);
            j = paramMessage.aQV.aTg[i];
            if (j == -1)
            {
              paramMessage = null;
              break;
            }
            k = ((j.b)localObject2).bly + 1;
            if (k < j)
            {
              if (!paramMessage.aQV.be(i, k))
              {
                paramMessage = null;
                break;
              }
              paramMessage = paramMessage.b(((j.b)localObject2).blw, i, k, ((n.a)localObject1).aRS);
              break;
            }
            i = paramMessage.aQV.D(((n.a)localObject1).aRS);
            if (i == -1) {}
            for (l1 = -9223372036854775808L;; l1 = paramMessage.aQV.aTf[i])
            {
              paramMessage = paramMessage.b(((j.b)localObject2).blw, ((n.a)localObject1).aRS, l1);
              break;
            }
          }
          if (((n.a)localObject1).aSy != -9223372036854775808L)
          {
            i = paramMessage.aQV.C(((n.a)localObject1).aSy);
            if (!paramMessage.aQV.be(i, 0))
            {
              paramMessage = null;
              break;
            }
            paramMessage = paramMessage.b(((j.b)localObject2).blw, i, 0, ((n.a)localObject1).aSy);
            break;
          }
          i = paramMessage.aQV.rR();
          if ((i == 0) || (paramMessage.aQV.aTf[(i - 1)] != -9223372036854775808L) || (paramMessage.aQV.dJ(i - 1)) || (!paramMessage.aQV.be(i - 1, 0))) {
            break label4835;
          }
          l1 = paramMessage.aQV.aSz;
          paramMessage = paramMessage.b(((j.b)localObject2).blw, i - 1, 0, l1);
          break;
          if (this.aRC == null)
          {
            l1 = 60000000L;
            if (this.aRC != null) {
              break label1706;
            }
          }
          for (i = 0;; i = this.aRC.index + 1)
          {
            localObject1 = this.aRb.a(paramMessage.aSx.blw, this.aQV, true).aRG;
            localObject1 = new a(this.aQP, this.aRl, l1, this.aQQ, this.aRm, this.aRt, localObject1, i, paramMessage);
            if (this.aRC != null) {
              this.aRC.aRN = ((a)localObject1);
            }
            this.aRC = ((a)localObject1);
            this.aRC.aRF.a(this, paramMessage.aRR);
            aP(true);
            break;
            l1 = this.aRC.rC() + this.aRC.aRK.aSz;
            break label1568;
          }
          if ((this.aRC != null) && (!this.isLoading)) {
            rB();
          }
        }
        continue;
        if (!this.aRD.aRK.aSB) {
          break label4847;
        }
        i = 0;
        if (i >= this.aQP.length) {
          break label4845;
        }
        paramMessage = this.aQP[i];
        localObject1 = this.aRD.aRH[i];
        if ((localObject1 == null) || (paramMessage.rj() != localObject1) || (!paramMessage.rk())) {
          break label4840;
        }
        paramMessage.rl();
        break label4840;
        if (i < this.aQP.length)
        {
          paramMessage = this.aQP[i];
          localObject1 = this.aRD.aRH[i];
          if (paramMessage.rj() == localObject1)
          {
            if (localObject1 == null) {
              break label4852;
            }
            if (paramMessage.rk()) {
              break label4852;
            }
          }
        }
        else if ((this.aRD.aRN != null) && (this.aRD.aRN.aRL))
        {
          paramMessage = this.aRD.aRO;
          this.aRD = this.aRD.aRN;
          localObject1 = this.aRD.aRO;
          if (this.aRD.aRF.tC() == -9223372036854775807L) {
            break label4864;
          }
          i = 1;
          break label4859;
          if (j >= this.aQP.length) {
            break label4874;
          }
          localObject2 = this.aQP[j];
          if (paramMessage.bwq.bwn[j] == null) {
            break label4869;
          }
          if (i == 0)
          {
            if (((r)localObject2).rm()) {
              break label4869;
            }
            localObject3 = localObject1.bwq.bwn[j];
            localObject4 = paramMessage.bwr[j];
            t localt = localObject1.bwr[j];
            if ((localObject3 != null) && (localt.equals(localObject4)))
            {
              localObject4 = new Format[((com.google.android.exoplayer2.g.f)localObject3).length()];
              k = 0;
              while (k < localObject4.length)
              {
                localObject4[k] = ((com.google.android.exoplayer2.g.f)localObject3).fe(k);
                k += 1;
              }
              ((r)localObject2).a((Format[])localObject4, this.aRD.aRH[j], this.aRD.rC());
              break label4869;
            }
          }
          ((r)localObject2).rl();
          break label4869;
        }
      }
      v.beginSection("doSomeWork");
      ry();
      this.aRE.aRF.U(this.aRg.aRT);
      i = 1;
      bool = true;
      paramMessage = this.aRu;
      int m = paramMessage.length;
      j = 0;
      if (j < m)
      {
        localObject1 = paramMessage[j];
        ((r)localObject1).e(this.aRB, this.aRy);
        if ((i == 0) || (!((r)localObject1).rM())) {
          break label4902;
        }
        i = 1;
        label2204:
        if (((r)localObject1).isReady()) {
          break label4876;
        }
        if (!((r)localObject1).rM()) {
          break label4907;
        }
        break label4876;
        label2227:
        if (k != 0) {
          break label4882;
        }
        ((r)localObject1).rn();
        break label4882;
      }
      if (!bool) {
        rA();
      }
      if (this.aRs != null)
      {
        paramMessage = this.aRs.sm();
        if (!paramMessage.equals(this.aRf))
        {
          this.aRf = paramMessage;
          this.aRn.a(this.aRs);
          this.eventHandler.obtainMessage(7, paramMessage).sendToTarget();
        }
      }
      l1 = this.aRE.aRK.aSz;
      if ((i != 0) && ((l1 == -9223372036854775807L) || (l1 <= this.aRg.aRT)) && (this.aRE.aRK.aSB))
      {
        setState(4);
        rx();
      }
      label2368:
      while (this.state == 2)
      {
        paramMessage = this.aRu;
        j = paramMessage.length;
        i = 0;
        while (i < j)
        {
          paramMessage[i].rn();
          i += 1;
        }
        if (this.state == 2)
        {
          if (this.aRu.length > 0)
          {
            if (!bool) {
              break label4930;
            }
            paramMessage = this.aRC;
            bool = this.aRv;
            l4 = this.aRB;
            if (!paramMessage.aRL)
            {
              l1 = paramMessage.aRK.aRR;
              l2 = l1;
              if (l1 != -9223372036854775808L) {
                break label2536;
              }
              if (!paramMessage.aRK.aSB) {
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
            if (!this.aQX) {
              break;
            }
            rw();
            break;
            l1 = paramMessage.aRF.tD();
            break label2460;
            label2527:
            l2 = paramMessage.aRK.aSz;
            label2536:
            bool = paramMessage.aRm.b(l2 - (l4 - paramMessage.rC()), bool);
            break label4919;
            bool = y(l1);
          }
        }
        if (this.state == 3)
        {
          if (this.aRu.length > 0) {}
          for (;;)
          {
            if (bool) {
              break label2623;
            }
            this.aRv = this.aQX;
            setState(2);
            rx();
            break;
            bool = y(l1);
          }
        }
      }
      label2460:
      label2489:
      label2623:
      if (((this.aQX) && (this.state == 3)) || (this.state == 2)) {
        d(l3, 10L);
      }
      for (;;)
      {
        v.endSection();
        break;
        if ((this.aRu.length != 0) && (this.state != 4)) {
          d(l3, 1000L);
        } else {
          this.handler.removeMessages(2);
        }
      }
      paramMessage = (c)paramMessage.obj;
      if (this.aRb == null)
      {
        this.aRz += 1;
        this.aRA = paramMessage;
      }
      for (;;)
      {
        AppMethodBeat.o(91924);
        return true;
        localObject1 = a(paramMessage);
        if (localObject1 == null)
        {
          this.aRg = new b(0L);
          this.eventHandler.obtainMessage(4, 1, 0, this.aRg).sendToTarget();
          this.aRg = new b(-9223372036854775807L);
          setState(4);
          aQ(false);
        }
        else
        {
          if (paramMessage.aRW == -9223372036854775807L)
          {
            i = 1;
            label2821:
            j = ((Integer)((Pair)localObject1).first).intValue();
            l2 = ((Long)((Pair)localObject1).second).longValue();
            localObject1 = this.aRq.g(j, l2);
            bool = ((j.b)localObject1).tQ();
            if (!bool) {
              break label4815;
            }
            l1 = 0L;
            i = 1;
          }
          try
          {
            label2875:
            if (((j.b)localObject1).equals(this.aRg.aRQ))
            {
              l3 = l1 / 1000L;
              l4 = this.aRg.aRT / 1000L;
              if (l3 == l4)
              {
                this.aRg = new b((j.b)localObject1, l1, l2);
                paramMessage = this.eventHandler;
                if (i != 0) {}
                for (i = 1;; i = 0)
                {
                  paramMessage.obtainMessage(4, i, 0, this.aRg).sendToTarget();
                  break;
                  i = 0;
                  break label2821;
                }
              }
            }
            l3 = a((j.b)localObject1, l1);
            if (l1 == l3) {
              break label4936;
            }
            j = 1;
            label2994:
            this.aRg = new b((j.b)localObject1, l3, l2);
            paramMessage = this.eventHandler;
            if ((i | j) == 0) {
              break label4941;
            }
            i = 1;
            label3024:
            paramMessage.obtainMessage(4, i, 0, this.aRg).sendToTarget();
          }
          finally
          {
            this.aRg = new b((j.b)localObject1, l1, l2);
            localObject1 = this.eventHandler;
            if (i == 0) {
              break label4946;
            }
          }
        }
      }
      i = 1;
      label3071:
      ((Handler)localObject1).obtainMessage(4, i, 0, this.aRg).sendToTarget();
      AppMethodBeat.o(91924);
      throw paramMessage;
      paramMessage = (p)paramMessage.obj;
      if (this.aRs != null) {}
      for (paramMessage = this.aRs.c(paramMessage);; paramMessage = this.aRn.c(paramMessage))
      {
        this.aRf = paramMessage;
        this.eventHandler.obtainMessage(7, paramMessage).sendToTarget();
        AppMethodBeat.o(91924);
        return true;
      }
      rz();
      AppMethodBeat.o(91924);
      return true;
      nW();
      AppMethodBeat.o(91924);
      return true;
      paramMessage = (com.google.android.exoplayer2.source.i)paramMessage.obj;
      if (this.aRC != null)
      {
        localObject1 = this.aRC.aRF;
        if (localObject1 == paramMessage) {
          break label3220;
        }
      }
      for (;;)
      {
        AppMethodBeat.o(91924);
        return true;
        label3220:
        paramMessage = this.aRC;
        paramMessage.aRL = true;
        paramMessage.rE();
        l1 = paramMessage.A(paramMessage.aRK.aRR);
        localObject1 = paramMessage.aRK;
        paramMessage.aRK = new n.a(((n.a)localObject1).aSx, l1, ((n.a)localObject1).aSy, ((n.a)localObject1).aRS, ((n.a)localObject1).aSz, ((n.a)localObject1).aSA, ((n.a)localObject1).aSB);
        if (this.aRE == null)
        {
          this.aRD = this.aRC;
          x(this.aRD.aRK.aRR);
          b(this.aRD);
        }
        rB();
      }
      paramMessage = (Pair)paramMessage.obj;
      localObject3 = this.aRb;
      this.aRb = ((w)paramMessage.first);
      this.aRq.aRb = this.aRb;
      localObject2 = paramMessage.second;
      if (localObject3 == null)
      {
        if (this.aRz > 0)
        {
          paramMessage = a(this.aRA);
          i = this.aRz;
          this.aRz = 0;
          this.aRA = null;
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
          paramMessage = this.aRq.g(j, l2);
          if (!paramMessage.tQ()) {
            break;
          }
          l1 = 0L;
          label3482:
          this.aRg = new b(paramMessage, l1, l2);
          d(localObject2, i);
          continue;
          if (this.aRg.aRR == -9223372036854775807L)
          {
            if (this.aRb.isEmpty())
            {
              c(localObject2, 0);
            }
            else
            {
              paramMessage = dG(0);
              i = ((Integer)paramMessage.first).intValue();
              l2 = ((Long)paramMessage.second).longValue();
              paramMessage = this.aRq.g(i, l2);
              if (!paramMessage.tQ()) {
                break label4958;
              }
              l1 = 0L;
              label3592:
              this.aRg = new b(paramMessage, l1, l2);
            }
          }
          else {
            d(localObject2, 0);
          }
        }
      }
      j = this.aRg.aRQ.blw;
      if (this.aRE != null)
      {
        paramMessage = this.aRE;
        label3641:
        if ((paramMessage == null) && (j >= ((w)localObject3).rQ())) {
          break label3903;
        }
        if (paramMessage != null) {
          break label3724;
        }
      }
      label3724:
      for (localObject1 = ((w)localObject3).a(j, this.aQV, true).aRG;; localObject1 = paramMessage.aRG)
      {
        i = this.aRb.aa(localObject1);
        if (i != -1) {
          break label3913;
        }
        i = a(j, (w)localObject3, this.aRb);
        if (i != -1) {
          break label3733;
        }
        c(localObject2, 0);
        break;
        paramMessage = this.aRC;
        break label3641;
      }
      label3733:
      localObject1 = dG(this.aRb.a(i, this.aQV, false).aRV);
      i = ((Integer)((Pair)localObject1).first).intValue();
      l1 = ((Long)((Pair)localObject1).second).longValue();
      this.aRb.a(i, this.aQV, true);
      if (paramMessage != null)
      {
        localObject1 = this.aQV.aRG;
        paramMessage.aRK = paramMessage.aRK.rI();
        while (paramMessage.aRN != null)
        {
          paramMessage = paramMessage.aRN;
          if (paramMessage.aRG.equals(localObject1)) {
            paramMessage.aRK = this.aRq.a(paramMessage.aRK, i);
          } else {
            paramMessage.aRK = paramMessage.aRK.rI();
          }
        }
      }
      paramMessage = new j.b(i);
      this.aRg = new b(paramMessage, a(paramMessage, l1));
      for (;;)
      {
        label3903:
        d(localObject2, 0);
        break;
        label3913:
        if (i != j)
        {
          localObject1 = this.aRg;
          localObject3 = new b(((b)localObject1).aRQ.ex(i), ((b)localObject1).aRR, ((b)localObject1).aRS);
          ((b)localObject3).aRT = ((b)localObject1).aRT;
          ((b)localObject3).aRU = ((b)localObject1).aRU;
          this.aRg = ((b)localObject3);
        }
        if (this.aRg.aRQ.tQ())
        {
          localObject1 = this.aRq.g(i, this.aRg.aRS);
          if ((!((j.b)localObject1).tQ()) || (((j.b)localObject1).bly != this.aRg.aRQ.bly))
          {
            l2 = a((j.b)localObject1, this.aRg.aRS);
            if (!((j.b)localObject1).tQ()) {
              break label4965;
            }
            l1 = this.aRg.aRS;
            label4066:
            this.aRg = new b((j.b)localObject1, l2, l1);
            continue;
          }
        }
        if (paramMessage != null)
        {
          for (paramMessage = a(paramMessage, i); paramMessage.aRN != null; paramMessage = a((a)localObject1, i))
          {
            localObject1 = paramMessage.aRN;
            i = this.aRb.a(i, this.aQV, this.aQU, this.repeatMode);
            if ((i == -1) || (!((a)localObject1).aRG.equals(this.aRb.a(i, this.aQV, true).aRG))) {
              break label4174;
            }
          }
          continue;
          label4174:
          if ((this.aRD == null) || (this.aRD.index >= ((a)localObject1).index)) {
            break label4973;
          }
          i = 1;
          label4198:
          if (i == 0)
          {
            l1 = a(this.aRE.aRK.aSx, this.aRg.aRT);
            this.aRg = new b(this.aRE.aRK.aSx, l1, this.aRg.aRS);
          }
          else
          {
            this.aRC = paramMessage;
            this.aRC.aRN = null;
            a((a)localObject1);
          }
        }
      }
      paramMessage = (com.google.android.exoplayer2.source.i)paramMessage.obj;
      if (this.aRC != null)
      {
        localObject1 = this.aRC.aRF;
        if (localObject1 == paramMessage) {
          break label4317;
        }
      }
      for (;;)
      {
        AppMethodBeat.o(91924);
        return true;
        label4317:
        rB();
      }
      if (this.aRE != null)
      {
        paramMessage = this.aRE;
        i = 1;
      }
      for (;;)
      {
        if (paramMessage != null)
        {
          bool = paramMessage.aRL;
          if (bool) {}
        }
        else
        {
          AppMethodBeat.o(91924);
          return true;
        }
        if (paramMessage.rE()) {
          break;
        }
        if (paramMessage == this.aRD) {
          i = 0;
        }
        paramMessage = paramMessage.aRN;
      }
      if (i != 0)
      {
        if (this.aRD == this.aRE) {
          break label4988;
        }
        bool = true;
        label4404:
        a(this.aRE.aRN);
        this.aRE.aRN = null;
        this.aRC = this.aRE;
        this.aRD = this.aRE;
        localObject1 = new boolean[this.aQP.length];
        l1 = this.aRE.a(this.aRg.aRT, bool, (boolean[])localObject1);
        if (l1 != this.aRg.aRT)
        {
          this.aRg.aRT = l1;
          x(l1);
        }
        j = 0;
        localObject2 = new boolean[this.aQP.length];
        i = 0;
        label4508:
        if (i < this.aQP.length)
        {
          localObject3 = this.aQP[i];
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
      localObject4 = this.aRE.aRH[i];
      k = j;
      if (localObject4 != null) {
        k = j + 1;
      }
      if (localObject2[i] != 0) {
        if (localObject4 != ((r)localObject3).rj())
        {
          if (localObject3 == this.aRr)
          {
            if (localObject4 == null) {
              this.aRn.a(this.aRs);
            }
            this.aRs = null;
            this.aRr = null;
          }
          a((r)localObject3);
          ((r)localObject3).disable();
        }
        else if (localObject1[i] != 0)
        {
          ((r)localObject3).s(this.aRB);
          break label4978;
          this.eventHandler.obtainMessage(3, paramMessage.aRO).sendToTarget();
          a((boolean[])localObject2, j);
          for (;;)
          {
            rB();
            ry();
            this.handler.sendEmptyMessage(2);
            break;
            this.aRC = paramMessage;
            for (paramMessage = this.aRC.aRN; paramMessage != null; paramMessage = paramMessage.aRN) {
              paramMessage.release();
            }
            this.aRC.aRN = null;
            if (this.aRC.aRL)
            {
              l1 = this.aRC.aRK.aRR;
              paramMessage = this.aRC;
              l1 = Math.max(l1, this.aRB - paramMessage.rC());
              this.aRC.A(l1);
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
    //   9: getfield 554	com/google/android/exoplayer2/i:released	Z
    //   12: ifeq +12 -> 24
    //   15: ldc_w 872
    //   18: invokestatic 184	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   21: aload_0
    //   22: monitorexit
    //   23: return
    //   24: aload_0
    //   25: getfield 181	com/google/android/exoplayer2/i:handler	Landroid/os/Handler;
    //   28: bipush 6
    //   30: invokevirtual 266	android/os/Handler:sendEmptyMessage	(I)Z
    //   33: pop
    //   34: iconst_0
    //   35: istore_1
    //   36: aload_0
    //   37: getfield 554	com/google/android/exoplayer2/i:released	Z
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
    //   69: getfield 167	com/google/android/exoplayer2/i:aRo	Landroid/os/HandlerThread;
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
    private final r[] aQP;
    private final h aQQ;
    public final com.google.android.exoplayer2.source.i aRF;
    public final Object aRG;
    public final com.google.android.exoplayer2.source.m[] aRH;
    public final boolean[] aRI;
    public final long aRJ;
    public n.a aRK;
    public boolean aRL;
    public boolean aRM;
    public a aRN;
    public com.google.android.exoplayer2.g.i aRO;
    private com.google.android.exoplayer2.g.i aRP;
    private final s[] aRl;
    final m aRm;
    private final j aRt;
    public final int index;
    
    public a(r[] paramArrayOfr, s[] paramArrayOfs, long paramLong, h paramh, m paramm, j paramj, Object paramObject, int paramInt, n.a parama)
    {
      AppMethodBeat.i(91909);
      this.aQP = paramArrayOfr;
      this.aRl = paramArrayOfs;
      this.aRJ = paramLong;
      this.aQQ = paramh;
      this.aRm = paramm;
      this.aRt = paramj;
      this.aRG = a.checkNotNull(paramObject);
      this.index = paramInt;
      this.aRK = parama;
      this.aRH = new com.google.android.exoplayer2.source.m[paramArrayOfr.length];
      this.aRI = new boolean[paramArrayOfr.length];
      paramArrayOfr = paramj.a(parama.aSx, paramm.rs());
      if (parama.aSy != -9223372036854775808L)
      {
        paramArrayOfr = new c(paramArrayOfr, true);
        paramArrayOfr.h(0L, parama.aSy);
      }
      for (;;)
      {
        this.aRF = paramArrayOfr;
        AppMethodBeat.o(91909);
        return;
      }
    }
    
    public final long A(long paramLong)
    {
      AppMethodBeat.i(91914);
      paramLong = a(paramLong, false, new boolean[this.aQP.length]);
      AppMethodBeat.o(91914);
      return paramLong;
    }
    
    public final long a(long paramLong, boolean paramBoolean, boolean[] paramArrayOfBoolean)
    {
      AppMethodBeat.i(91915);
      g localg = this.aRO.bwq;
      int i = 0;
      if (i < localg.length)
      {
        boolean[] arrayOfBoolean = this.aRI;
        if ((!paramBoolean) && (this.aRO.a(this.aRP, i))) {}
        for (int j = 1;; j = 0)
        {
          arrayOfBoolean[i] = j;
          i += 1;
          break;
        }
      }
      paramLong = this.aRF.a(localg.vd(), this.aRI, this.aRH, paramArrayOfBoolean, paramLong);
      this.aRP = this.aRO;
      this.aRM = false;
      i = 0;
      if (i < this.aRH.length)
      {
        if (this.aRH[i] != null)
        {
          if (localg.bwn[i] != null) {}
          for (paramBoolean = true;; paramBoolean = false)
          {
            a.checkState(paramBoolean);
            this.aRM = true;
            i += 1;
            break;
          }
        }
        if (localg.bwn[i] == null) {}
        for (paramBoolean = true;; paramBoolean = false)
        {
          a.checkState(paramBoolean);
          break;
        }
      }
      this.aRm.a(this.aQP, localg);
      AppMethodBeat.o(91915);
      return paramLong;
    }
    
    public final long rC()
    {
      if (this.index == 0) {
        return this.aRJ;
      }
      return this.aRJ - this.aRK.aRR;
    }
    
    public final boolean rD()
    {
      AppMethodBeat.i(91910);
      if ((this.aRL) && ((!this.aRM) || (this.aRF.tD() == -9223372036854775808L)))
      {
        AppMethodBeat.o(91910);
        return true;
      }
      AppMethodBeat.o(91910);
      return false;
    }
    
    public final boolean rE()
    {
      AppMethodBeat.i(91913);
      com.google.android.exoplayer2.g.i locali = this.aQQ.a(this.aRl, this.aRF.tB());
      if (locali.a(this.aRP))
      {
        AppMethodBeat.o(91913);
        return false;
      }
      this.aRO = locali;
      AppMethodBeat.o(91913);
      return true;
    }
    
    public final void release()
    {
      AppMethodBeat.i(91916);
      try
      {
        if (this.aRK.aSy != -9223372036854775808L)
        {
          this.aRt.b(((c)this.aRF).aRF);
          AppMethodBeat.o(91916);
          return;
        }
        this.aRt.b(this.aRF);
        AppMethodBeat.o(91916);
        return;
      }
      catch (RuntimeException localRuntimeException)
      {
        AppMethodBeat.o(91916);
      }
    }
    
    public final boolean v(long paramLong)
    {
      AppMethodBeat.i(91911);
      if (!this.aRL) {}
      for (long l1 = 0L; l1 == -9223372036854775808L; l1 = this.aRF.tE())
      {
        AppMethodBeat.o(91911);
        return false;
      }
      long l2 = rC();
      boolean bool = this.aRm.v(l1 - (paramLong - l2));
      AppMethodBeat.o(91911);
      return bool;
    }
    
    public final void z(long paramLong)
    {
      AppMethodBeat.i(91912);
      long l = rC();
      this.aRF.W(paramLong - l);
      AppMethodBeat.o(91912);
    }
  }
  
  public static final class b
  {
    public final j.b aRQ;
    public final long aRR;
    public final long aRS;
    public volatile long aRT;
    public volatile long aRU;
    
    public b(long paramLong)
    {
      this(new j.b(0), paramLong);
      AppMethodBeat.i(91917);
      AppMethodBeat.o(91917);
    }
    
    public b(j.b paramb, long paramLong)
    {
      this(paramb, paramLong, -9223372036854775807L);
    }
    
    public b(j.b paramb, long paramLong1, long paramLong2)
    {
      this.aRQ = paramb;
      this.aRR = paramLong1;
      this.aRS = paramLong2;
      this.aRT = paramLong1;
      this.aRU = paramLong1;
    }
  }
  
  static final class c
  {
    public final int aRV;
    public final long aRW;
    public final w aRb;
    
    public c(w paramw, int paramInt, long paramLong)
    {
      this.aRb = paramw;
      this.aRV = paramInt;
      this.aRW = paramLong;
    }
  }
  
  public static final class d
  {
    public final int aRX;
    public final w aRb;
    public final Object aRc;
    public final i.b aRg;
    
    public d(w paramw, Object paramObject, i.b paramb, int paramInt)
    {
      this.aRb = paramw;
      this.aRc = paramObject;
      this.aRg = paramb;
      this.aRX = paramInt;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.google.android.exoplayer2.i
 * JD-Core Version:    0.7.0.1
 */