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
  private final com.google.android.exoplayer2.i.s bcA;
  private final HandlerThread bcB;
  private final f bcC;
  private final n bcD;
  private r bcE;
  private com.google.android.exoplayer2.i.i bcF;
  private k bcG;
  private r[] bcH;
  private boolean bcI;
  int bcJ;
  private int bcK;
  private long bcL;
  private int bcM;
  private c bcN;
  private long bcO;
  private a bcP;
  private a bcQ;
  private a bcR;
  private final r[] bcc;
  private final h bcd;
  private final w.b bch;
  private final w.a bci;
  private boolean bck;
  private w bco;
  private p bcs;
  private b bct;
  private final s[] bcy;
  private final m bcz;
  private final Handler eventHandler;
  final Handler handler;
  private boolean isLoading;
  boolean released;
  private int repeatMode;
  private int state;
  
  public i(r[] paramArrayOfr, h paramh, m paramm, boolean paramBoolean, int paramInt, Handler paramHandler, b paramb, f paramf)
  {
    AppMethodBeat.i(91918);
    this.bcc = paramArrayOfr;
    this.bcd = paramh;
    this.bcz = paramm;
    this.bck = paramBoolean;
    this.repeatMode = paramInt;
    this.eventHandler = paramHandler;
    this.state = 1;
    this.bct = paramb;
    this.bcC = paramf;
    this.bcy = new s[paramArrayOfr.length];
    paramInt = 0;
    while (paramInt < paramArrayOfr.length)
    {
      paramArrayOfr[paramInt].setIndex(paramInt);
      this.bcy[paramInt] = paramArrayOfr[paramInt].sW();
      paramInt += 1;
    }
    this.bcA = new com.google.android.exoplayer2.i.s();
    this.bcH = new r[0];
    this.bch = new w.b();
    this.bci = new w.a();
    this.bcD = new n();
    paramh.bEE = this;
    this.bcs = p.bdM;
    this.bcB = new HandlerThread("ExoPlayerImplInternal:Handler", -16);
    this.bcB.start();
    this.handler = new Handler(this.bcB.getLooper(), this);
    AppMethodBeat.o(91918);
  }
  
  private boolean A(long paramLong)
  {
    AppMethodBeat.i(91939);
    if ((paramLong == -9223372036854775807L) || (this.bct.bdg < paramLong) || ((this.bcR.bda != null) && ((this.bcR.bda.bcY) || (this.bcR.bda.bcX.bdH.isAd()))))
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
    int m = paramw1.tE();
    int k = 0;
    int i = -1;
    int j = paramInt;
    paramInt = k;
    while ((paramInt < m) && (i == -1))
    {
      j = paramw1.a(j, this.bci, this.bch, this.repeatMode);
      if (j == -1) {
        break;
      }
      i = paramw2.ae(paramw1.a(j, this.bci, true).bcT);
      paramInt += 1;
    }
    AppMethodBeat.o(91944);
    return i;
  }
  
  private long a(k.b paramb, long paramLong)
  {
    AppMethodBeat.i(91931);
    tm();
    this.bcI = false;
    setState(2);
    Object localObject;
    if (this.bcR == null)
    {
      if (this.bcP == null) {
        break label288;
      }
      this.bcP.release();
      localObject = null;
    }
    for (;;)
    {
      if ((this.bcR != localObject) || (this.bcR != this.bcQ))
      {
        paramb = this.bcH;
        int j = paramb.length;
        int i = 0;
        for (;;)
        {
          if (i < j)
          {
            paramb[i].disable();
            i += 1;
            continue;
            a locala1 = this.bcR;
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
              locala1 = locala1.bda;
              break;
              locala1.release();
            }
          }
        }
        this.bcH = new r[0];
        this.bcF = null;
        this.bcE = null;
        this.bcR = null;
      }
      if (localObject != null)
      {
        localObject.bda = null;
        this.bcP = localObject;
        this.bcQ = localObject;
        b(localObject);
        long l = paramLong;
        if (this.bcR.bcZ) {
          l = this.bcR.bcS.W(paramLong);
        }
        z(l);
        tq();
        paramLong = l;
      }
      for (;;)
      {
        this.handler.sendEmptyMessage(2);
        AppMethodBeat.o(91931);
        return paramLong;
        this.bcP = null;
        this.bcQ = null;
        this.bcR = null;
        z(paramLong);
      }
      label288:
      localObject = null;
    }
  }
  
  private Pair<Integer, Long> a(c paramc)
  {
    AppMethodBeat.i(91945);
    Object localObject2 = paramc.bco;
    Object localObject1 = localObject2;
    if (((w)localObject2).isEmpty()) {
      localObject1 = this.bco;
    }
    try
    {
      localObject2 = ((w)localObject1).a(this.bch, this.bci, paramc.bdi, paramc.bdj);
      if (this.bco == localObject1)
      {
        AppMethodBeat.o(91945);
        return localObject2;
      }
    }
    catch (IndexOutOfBoundsException localIndexOutOfBoundsException)
    {
      paramc = new l(this.bco, paramc.bdi, paramc.bdj);
      AppMethodBeat.o(91945);
      throw paramc;
    }
    int i = this.bco.ae(localIndexOutOfBoundsException.a(((Integer)((Pair)localObject2).first).intValue(), this.bci, true).bcT);
    if (i != -1)
    {
      paramc = Pair.create(Integer.valueOf(i), ((Pair)localObject2).second);
      AppMethodBeat.o(91945);
      return paramc;
    }
    i = a(((Integer)((Pair)localObject2).first).intValue(), localIndexOutOfBoundsException, this.bco);
    if (i != -1)
    {
      paramc = dE(this.bco.a(i, this.bci, false).bdi);
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
      parama.bcX = this.bcD.a(parama.bcX, paramInt);
      if ((parama.bcX.bdK) || (parama.bda == null))
      {
        AppMethodBeat.o(91941);
        return parama;
      }
      parama = parama.bda;
    }
  }
  
  private static void a(a parama)
  {
    AppMethodBeat.i(91948);
    while (parama != null)
    {
      parama.release();
      parama = parama.bda;
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
    this.bcH = new r[paramInt];
    int i = 0;
    paramInt = 0;
    while (paramInt < this.bcc.length)
    {
      r localr = this.bcc[paramInt];
      Object localObject = this.bcR.bdb.bEG.bED[paramInt];
      int j = i;
      if (localObject != null)
      {
        this.bcH[i] = localr;
        if (localr.getState() == 0)
        {
          t localt = this.bcR.bdb.bEH[paramInt];
          if ((this.bck) && (this.state == 3))
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
              arrayOfFormat[k] = ((com.google.android.exoplayer2.g.f)localObject).eU(k);
              k += 1;
            }
            j = 0;
            break;
          }
          localr.a(localt, arrayOfFormat, this.bcR.bcU[paramInt], this.bcO, bool, this.bcR.tr());
          localObject = localr.sX();
          if (localObject != null)
          {
            if (this.bcF != null)
            {
              paramArrayOfBoolean = e.a(new IllegalStateException("Multiple renderer media clocks enabled."));
              AppMethodBeat.o(91950);
              throw paramArrayOfBoolean;
            }
            this.bcF = ((com.google.android.exoplayer2.i.i)localObject);
            this.bcE = localr;
            this.bcF.c(this.bcs);
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
    if ((paramb.equals(parama.bcX.bdH)) && (parama.bcY))
    {
      this.bco.a(parama.bcX.bdH.bwx, this.bci, false);
      int i = this.bci.F(paramLong);
      if ((i == -1) || (this.bci.beo[i] == parama.bcX.bdI))
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
    this.bcI = false;
    this.bcA.stop();
    this.bcF = null;
    this.bcE = null;
    this.bcO = 60000000L;
    Object localObject = this.bcH;
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
        this.bcH = new r[0];
        if (this.bcR != null) {}
        for (localObject = this.bcR;; localObject = this.bcP)
        {
          a((a)localObject);
          this.bcP = null;
          this.bcQ = null;
          this.bcR = null;
          aP(false);
          if (paramBoolean)
          {
            if (this.bcG != null)
            {
              this.bcG.vu();
              this.bcG = null;
            }
            this.bcD.bco = null;
            this.bco = null;
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
    if (this.bcR == parama)
    {
      AppMethodBeat.o(91949);
      return;
    }
    boolean[] arrayOfBoolean = new boolean[this.bcc.length];
    int i = 0;
    int j = 0;
    if (i < this.bcc.length)
    {
      r localr = this.bcc[i];
      if (localr.getState() != 0) {}
      for (int m = 1;; m = 0)
      {
        arrayOfBoolean[i] = m;
        com.google.android.exoplayer2.g.f localf = parama.bdb.bEG.bED[i];
        int k = j;
        if (localf != null) {
          k = j + 1;
        }
        if ((arrayOfBoolean[i] != 0) && ((localf == null) || ((localr.tb()) && (localr.sY() == this.bcR.bcU[i]))))
        {
          if (localr == this.bcE)
          {
            this.bcA.a(this.bcF);
            this.bcF = null;
            this.bcE = null;
          }
          a(localr);
          localr.disable();
        }
        i += 1;
        j = k;
        break;
      }
    }
    this.bcR = parama;
    this.eventHandler.obtainMessage(3, parama.bdb).sendToTarget();
    a(arrayOfBoolean, j);
    AppMethodBeat.o(91949);
  }
  
  private void b(Object paramObject, int paramInt)
  {
    AppMethodBeat.i(91942);
    this.bct = new b(0L);
    c(paramObject, paramInt);
    this.bct = new b(-9223372036854775807L);
    setState(4);
    aQ(false);
    AppMethodBeat.o(91942);
  }
  
  private void c(Object paramObject, int paramInt)
  {
    AppMethodBeat.i(91943);
    this.eventHandler.obtainMessage(6, new d(this.bco, paramObject, this.bct, paramInt)).sendToTarget();
    AppMethodBeat.o(91943);
  }
  
  /* Error */
  private void c(f.c[] paramArrayOfc)
  {
    // Byte code:
    //   0: ldc_w 519
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
    //   23: getfield 525	com/google/android/exoplayer2/f$c:bbZ	Lcom/google/android/exoplayer2/f$b;
    //   26: aload 4
    //   28: getfield 528	com/google/android/exoplayer2/f$c:bca	I
    //   31: aload 4
    //   33: getfield 531	com/google/android/exoplayer2/f$c:bcb	Ljava/lang/Object;
    //   36: invokeinterface 536 3 0
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
    //   77: getfield 538	com/google/android/exoplayer2/i:bcK	I
    //   80: iconst_1
    //   81: iadd
    //   82: putfield 538	com/google/android/exoplayer2/i:bcK	I
    //   85: aload_0
    //   86: invokevirtual 541	java/lang/Object:notifyAll	()V
    //   89: aload_0
    //   90: monitorexit
    //   91: ldc_w 519
    //   94: invokestatic 184	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   97: return
    //   98: astore_1
    //   99: aload_0
    //   100: monitorexit
    //   101: ldc_w 519
    //   104: invokestatic 184	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   107: aload_1
    //   108: athrow
    //   109: astore_1
    //   110: aload_0
    //   111: monitorenter
    //   112: aload_0
    //   113: aload_0
    //   114: getfield 538	com/google/android/exoplayer2/i:bcK	I
    //   117: iconst_1
    //   118: iadd
    //   119: putfield 538	com/google/android/exoplayer2/i:bcK	I
    //   122: aload_0
    //   123: invokevirtual 541	java/lang/Object:notifyAll	()V
    //   126: aload_0
    //   127: monitorexit
    //   128: ldc_w 519
    //   131: invokestatic 184	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   134: aload_1
    //   135: athrow
    //   136: astore_1
    //   137: aload_0
    //   138: monitorexit
    //   139: ldc_w 519
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
  
  private Pair<Integer, Long> dE(int paramInt)
  {
    AppMethodBeat.i(91946);
    Pair localPair = this.bco.a(this.bch, this.bci, paramInt, -9223372036854775807L);
    AppMethodBeat.o(91946);
    return localPair;
  }
  
  private void oE()
  {
    AppMethodBeat.i(91935);
    aQ(true);
    this.bcz.tg();
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
  
  private void tl()
  {
    int i = 0;
    AppMethodBeat.i(91927);
    this.bcI = false;
    this.bcA.start();
    r[] arrayOfr = this.bcH;
    int j = arrayOfr.length;
    while (i < j)
    {
      arrayOfr[i].start();
      i += 1;
    }
    AppMethodBeat.o(91927);
  }
  
  private void tm()
  {
    AppMethodBeat.i(91928);
    this.bcA.stop();
    r[] arrayOfr = this.bcH;
    int j = arrayOfr.length;
    int i = 0;
    while (i < j)
    {
      a(arrayOfr[i]);
      i += 1;
    }
    AppMethodBeat.o(91928);
  }
  
  private void tn()
  {
    AppMethodBeat.i(91929);
    if (this.bcR == null)
    {
      AppMethodBeat.o(91929);
      return;
    }
    long l1 = this.bcR.bcS.vp();
    if (l1 != -9223372036854775807L)
    {
      z(l1);
      this.bct.bdg = l1;
      this.bcL = (SystemClock.elapsedRealtime() * 1000L);
      if (this.bcH.length != 0) {
        break label194;
      }
    }
    label194:
    for (l1 = -9223372036854775808L;; l1 = this.bcR.bcS.vq())
    {
      Object localObject = this.bct;
      long l2 = l1;
      if (l1 == -9223372036854775808L) {
        l2 = this.bcR.bcX.bdJ;
      }
      ((b)localObject).bdh = l2;
      AppMethodBeat.o(91929);
      return;
      if ((this.bcE != null) && (!this.bcE.tB()))
      {
        this.bcO = this.bcF.tV();
        this.bcA.ah(this.bcO);
      }
      for (;;)
      {
        localObject = this.bcR;
        l1 = this.bcO - ((a)localObject).tr();
        break;
        this.bcO = this.bcA.tV();
      }
    }
  }
  
  private void to()
  {
    AppMethodBeat.i(91934);
    aQ(true);
    this.bcz.onStopped();
    setState(1);
    AppMethodBeat.o(91934);
  }
  
  private void tp()
  {
    AppMethodBeat.i(91940);
    if ((this.bcP != null) && (!this.bcP.bcY) && ((this.bcQ == null) || (this.bcQ.bda == this.bcP)))
    {
      r[] arrayOfr = this.bcH;
      int j = arrayOfr.length;
      int i = 0;
      while (i < j)
      {
        if (!arrayOfr[i].sZ())
        {
          AppMethodBeat.o(91940);
          return;
        }
        i += 1;
      }
      this.bcP.bcS.vn();
    }
    AppMethodBeat.o(91940);
  }
  
  private void tq()
  {
    AppMethodBeat.i(91947);
    boolean bool = this.bcP.x(this.bcO);
    aP(bool);
    if (bool) {
      this.bcP.B(this.bcO);
    }
    AppMethodBeat.o(91947);
  }
  
  private void z(long paramLong)
  {
    AppMethodBeat.i(91933);
    if (this.bcR == null) {}
    for (paramLong = 60000000L + paramLong;; paramLong = this.bcR.tr() + paramLong)
    {
      this.bcO = paramLong;
      this.bcA.ah(this.bcO);
      r[] arrayOfr = this.bcH;
      int j = arrayOfr.length;
      int i = 0;
      while (i < j)
      {
        arrayOfr[i].u(this.bcO);
        i += 1;
      }
    }
    AppMethodBeat.o(91933);
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
    //   25: getfield 635	com/google/android/exoplayer2/i:bcJ	I
    //   28: istore_3
    //   29: aload_0
    //   30: iload_3
    //   31: iconst_1
    //   32: iadd
    //   33: putfield 635	com/google/android/exoplayer2/i:bcJ	I
    //   36: aload_0
    //   37: getfield 181	com/google/android/exoplayer2/i:handler	Landroid/os/Handler;
    //   40: bipush 11
    //   42: aload_1
    //   43: invokevirtual 503	android/os/Handler:obtainMessage	(ILjava/lang/Object;)Landroid/os/Message;
    //   46: invokevirtual 465	android/os/Message:sendToTarget	()V
    //   49: iconst_0
    //   50: istore_2
    //   51: aload_0
    //   52: getfield 538	com/google/android/exoplayer2/i:bcK	I
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
      to();
      AppMethodBeat.o(91924);
      return true;
      if (paramMessage.arg1 == 0) {
        break label300;
      }
      bool = true;
      this.bcI = false;
      this.bck = bool;
      if (bool) {
        break label306;
      }
      tm();
      tn();
      for (;;)
      {
        AppMethodBeat.o(91924);
        return true;
        bool = false;
        break;
        if (this.state != 3) {
          break label359;
        }
        tl();
        this.handler.sendEmptyMessage(2);
      }
    }
    catch (IOException paramMessage)
    {
      for (;;)
      {
        this.eventHandler.obtainMessage(8, e.a(paramMessage)).sendToTarget();
        to();
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
      to();
      AppMethodBeat.o(91924);
      return true;
    }
    Object localObject1 = (k)paramMessage.obj;
    if (paramMessage.arg1 != 0)
    {
      i = 1;
      this.eventHandler.sendEmptyMessage(0);
      aQ(true);
      this.bcz.tf();
      if (i == 0) {
        break label197;
      }
    }
    label197:
    for (this.bct = new b(-9223372036854775807L);; this.bct = new b(this.bct.bdd, this.bct.bdg, this.bct.bdf))
    {
      this.bcG = ((k)localObject1);
      if (localObject1 != null) {
        ((k)localObject1).a(this.bcC, this);
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
    this.bcD.repeatMode = i;
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
    if (this.bcR != null)
    {
      paramMessage = this.bcR;
    }
    else
    {
      for (;;)
      {
        j = this.bco.a(paramMessage.bcX.bdH.bwx, this.bci, this.bch, i);
        while ((paramMessage.bda != null) && (!paramMessage.bcX.bdK))
        {
          paramMessage = paramMessage.bda;
          continue;
          paramMessage = this.bcP;
          break label4822;
        }
        if ((j == -1) || (paramMessage.bda == null) || (paramMessage.bda.bcX.bdH.bwx != j)) {
          break;
        }
        paramMessage = paramMessage.bda;
      }
      j = this.bcP.index;
      if (this.bcQ != null)
      {
        i = this.bcQ.index;
        if (paramMessage.bda != null)
        {
          a(paramMessage.bda);
          paramMessage.bda = null;
        }
        localObject1 = this.bcD;
        localObject2 = paramMessage.bcX;
        paramMessage.bcX = ((n)localObject1).a((n.a)localObject2, ((n.a)localObject2).bdH);
        if (j > paramMessage.index) {
          break label708;
        }
        j = 1;
        if (j == 0) {
          this.bcP = paramMessage;
        }
        if ((i == -1) || (i > paramMessage.index)) {
          break label713;
        }
      }
      for (i = 1;; i = 0)
      {
        if ((i == 0) && (this.bcR != null))
        {
          paramMessage = this.bcR.bcX.bdH;
          this.bct = new b(paramMessage, a(paramMessage, this.bct.bdg), this.bct.bdf);
        }
        AppMethodBeat.o(91924);
        return true;
        i = -1;
        break;
        j = 0;
        break label618;
      }
      long l3 = SystemClock.elapsedRealtime();
      if ((this.bco == null) && (this.bcG != null)) {
        this.bcG.vt();
      }
      long l4;
      while (this.bcR == null)
      {
        tp();
        d(l3, 10L);
        AppMethodBeat.o(91924);
        return true;
        if (this.bcP == null)
        {
          paramMessage = this.bcD;
          localObject1 = this.bct;
          paramMessage = paramMessage.a(((b)localObject1).bdd, ((b)localObject1).bdf, ((b)localObject1).bde);
          if (paramMessage != null) {
            break label1556;
          }
          this.bcG.vt();
          if ((this.bcP != null) && (!this.bcP.ts())) {
            break label1719;
          }
          aP(false);
        }
        for (;;)
        {
          if (this.bcR == null) {
            break label1738;
          }
          while ((this.bcR != this.bcQ) && (this.bcO >= this.bcR.bda.bcW))
          {
            this.bcR.release();
            b(this.bcR.bda);
            this.bct = new b(this.bcR.bcX.bdH, this.bcR.bcX.bde, this.bcR.bcX.bdf);
            tn();
            this.eventHandler.obtainMessage(5, this.bct).sendToTarget();
          }
          if ((this.bcP.bcX.bdL) || (!this.bcP.ts()) || (this.bcP.bcX.bdJ == -9223372036854775807L) || ((this.bcR != null) && (this.bcP.index - this.bcR.index == 100))) {
            break label825;
          }
          paramMessage = this.bcD;
          localObject1 = this.bcP.bcX;
          l1 = this.bcP.tr();
          l2 = this.bcO;
          if (((n.a)localObject1).bdK)
          {
            i = paramMessage.bco.a(((n.a)localObject1).bdH.bwx, paramMessage.bci, paramMessage.bch, paramMessage.repeatMode);
            if (i == -1)
            {
              paramMessage = null;
              break;
            }
            j = paramMessage.bco.a(i, paramMessage.bci, false).bdi;
            if (paramMessage.bco.a(j, paramMessage.bch).bey != i) {
              break label4829;
            }
            l4 = ((n.a)localObject1).bdJ;
            localObject1 = paramMessage.bco.a(paramMessage.bch, paramMessage.bci, j, -9223372036854775807L, Math.max(0L, l4 + l1 - l2));
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
          localObject2 = ((n.a)localObject1).bdH;
          if (((k.b)localObject2).isAd())
          {
            i = ((k.b)localObject2).bwy;
            paramMessage.bco.a(((k.b)localObject2).bwx, paramMessage.bci, false);
            j = paramMessage.bci.bep[i];
            if (j == -1)
            {
              paramMessage = null;
              break;
            }
            k = ((k.b)localObject2).bwz + 1;
            if (k < j)
            {
              if (!paramMessage.bci.ba(i, k))
              {
                paramMessage = null;
                break;
              }
              paramMessage = paramMessage.b(((k.b)localObject2).bwx, i, k, ((n.a)localObject1).bdf);
              break;
            }
            i = paramMessage.bci.F(((n.a)localObject1).bdf);
            if (i == -1) {}
            for (l1 = -9223372036854775808L;; l1 = paramMessage.bci.beo[i])
            {
              paramMessage = paramMessage.c(((k.b)localObject2).bwx, ((n.a)localObject1).bdf, l1);
              break;
            }
          }
          if (((n.a)localObject1).bdI != -9223372036854775808L)
          {
            i = paramMessage.bci.E(((n.a)localObject1).bdI);
            if (!paramMessage.bci.ba(i, 0))
            {
              paramMessage = null;
              break;
            }
            paramMessage = paramMessage.b(((k.b)localObject2).bwx, i, 0, ((n.a)localObject1).bdI);
            break;
          }
          i = paramMessage.bci.tF();
          if ((i == 0) || (paramMessage.bci.beo[(i - 1)] != -9223372036854775808L) || (paramMessage.bci.dH(i - 1)) || (!paramMessage.bci.ba(i - 1, 0))) {
            break label4835;
          }
          l1 = paramMessage.bci.bdJ;
          paramMessage = paramMessage.b(((k.b)localObject2).bwx, i - 1, 0, l1);
          break;
          if (this.bcP == null)
          {
            l1 = 60000000L;
            if (this.bcP != null) {
              break label1706;
            }
          }
          for (i = 0;; i = this.bcP.index + 1)
          {
            localObject1 = this.bco.a(paramMessage.bdH.bwx, this.bci, true).bcT;
            localObject1 = new a(this.bcc, this.bcy, l1, this.bcd, this.bcz, this.bcG, localObject1, i, paramMessage);
            if (this.bcP != null) {
              this.bcP.bda = ((a)localObject1);
            }
            this.bcP = ((a)localObject1);
            this.bcP.bcS.a(this, paramMessage.bde);
            aP(true);
            break;
            l1 = this.bcP.tr() + this.bcP.bcX.bdJ;
            break label1568;
          }
          if ((this.bcP != null) && (!this.isLoading)) {
            tq();
          }
        }
        continue;
        if (!this.bcQ.bcX.bdL) {
          break label4847;
        }
        i = 0;
        if (i >= this.bcc.length) {
          break label4845;
        }
        paramMessage = this.bcc[i];
        localObject1 = this.bcQ.bcU[i];
        if ((localObject1 == null) || (paramMessage.sY() != localObject1) || (!paramMessage.sZ())) {
          break label4840;
        }
        paramMessage.ta();
        break label4840;
        if (i < this.bcc.length)
        {
          paramMessage = this.bcc[i];
          localObject1 = this.bcQ.bcU[i];
          if (paramMessage.sY() == localObject1)
          {
            if (localObject1 == null) {
              break label4852;
            }
            if (paramMessage.sZ()) {
              break label4852;
            }
          }
        }
        else if ((this.bcQ.bda != null) && (this.bcQ.bda.bcY))
        {
          paramMessage = this.bcQ.bdb;
          this.bcQ = this.bcQ.bda;
          localObject1 = this.bcQ.bdb;
          if (this.bcQ.bcS.vp() == -9223372036854775807L) {
            break label4864;
          }
          i = 1;
          break label4859;
          if (j >= this.bcc.length) {
            break label4874;
          }
          localObject2 = this.bcc[j];
          if (paramMessage.bEG.bED[j] == null) {
            break label4869;
          }
          if (i == 0)
          {
            if (((r)localObject2).tb()) {
              break label4869;
            }
            localObject3 = localObject1.bEG.bED[j];
            localObject4 = paramMessage.bEH[j];
            t localt = localObject1.bEH[j];
            if ((localObject3 != null) && (localt.equals(localObject4)))
            {
              localObject4 = new Format[((com.google.android.exoplayer2.g.f)localObject3).length()];
              k = 0;
              while (k < localObject4.length)
              {
                localObject4[k] = ((com.google.android.exoplayer2.g.f)localObject3).eU(k);
                k += 1;
              }
              ((r)localObject2).a((Format[])localObject4, this.bcQ.bcU[j], this.bcQ.tr());
              break label4869;
            }
          }
          ((r)localObject2).ta();
          break label4869;
        }
      }
      v.beginSection("doSomeWork");
      tn();
      this.bcR.bcS.V(this.bct.bdg);
      i = 1;
      bool = true;
      paramMessage = this.bcH;
      int m = paramMessage.length;
      j = 0;
      if (j < m)
      {
        localObject1 = paramMessage[j];
        ((r)localObject1).e(this.bcO, this.bcL);
        if ((i == 0) || (!((r)localObject1).tB())) {
          break label4902;
        }
        i = 1;
        label2204:
        if (((r)localObject1).isReady()) {
          break label4876;
        }
        if (!((r)localObject1).tB()) {
          break label4907;
        }
        break label4876;
        label2227:
        if (k != 0) {
          break label4882;
        }
        ((r)localObject1).tc();
        break label4882;
      }
      if (!bool) {
        tp();
      }
      if (this.bcF != null)
      {
        paramMessage = this.bcF.tZ();
        if (!paramMessage.equals(this.bcs))
        {
          this.bcs = paramMessage;
          this.bcA.a(this.bcF);
          this.eventHandler.obtainMessage(7, paramMessage).sendToTarget();
        }
      }
      l1 = this.bcR.bcX.bdJ;
      if ((i != 0) && ((l1 == -9223372036854775807L) || (l1 <= this.bct.bdg)) && (this.bcR.bcX.bdL))
      {
        setState(4);
        tm();
      }
      label2368:
      while (this.state == 2)
      {
        paramMessage = this.bcH;
        j = paramMessage.length;
        i = 0;
        while (i < j)
        {
          paramMessage[i].tc();
          i += 1;
        }
        if (this.state == 2)
        {
          if (this.bcH.length > 0)
          {
            if (!bool) {
              break label4930;
            }
            paramMessage = this.bcP;
            bool = this.bcI;
            l4 = this.bcO;
            if (!paramMessage.bcY)
            {
              l1 = paramMessage.bcX.bde;
              l2 = l1;
              if (l1 != -9223372036854775808L) {
                break label2536;
              }
              if (!paramMessage.bcX.bdL) {
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
            if (!this.bck) {
              break;
            }
            tl();
            break;
            l1 = paramMessage.bcS.vq();
            break label2460;
            label2527:
            l2 = paramMessage.bcX.bdJ;
            label2536:
            bool = paramMessage.bcz.b(l2 - (l4 - paramMessage.tr()), bool);
            break label4919;
            bool = A(l1);
          }
        }
        if (this.state == 3)
        {
          if (this.bcH.length > 0) {}
          for (;;)
          {
            if (bool) {
              break label2623;
            }
            this.bcI = this.bck;
            setState(2);
            tm();
            break;
            bool = A(l1);
          }
        }
      }
      label2460:
      label2489:
      label2623:
      if (((this.bck) && (this.state == 3)) || (this.state == 2)) {
        d(l3, 10L);
      }
      for (;;)
      {
        v.endSection();
        break;
        if ((this.bcH.length != 0) && (this.state != 4)) {
          d(l3, 1000L);
        } else {
          this.handler.removeMessages(2);
        }
      }
      paramMessage = (c)paramMessage.obj;
      if (this.bco == null)
      {
        this.bcM += 1;
        this.bcN = paramMessage;
      }
      for (;;)
      {
        AppMethodBeat.o(91924);
        return true;
        localObject1 = a(paramMessage);
        if (localObject1 == null)
        {
          this.bct = new b(0L);
          this.eventHandler.obtainMessage(4, 1, 0, this.bct).sendToTarget();
          this.bct = new b(-9223372036854775807L);
          setState(4);
          aQ(false);
        }
        else
        {
          if (paramMessage.bdj == -9223372036854775807L)
          {
            i = 1;
            label2821:
            j = ((Integer)((Pair)localObject1).first).intValue();
            l2 = ((Long)((Pair)localObject1).second).longValue();
            localObject1 = this.bcD.g(j, l2);
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
            if (((k.b)localObject1).equals(this.bct.bdd))
            {
              l3 = l1 / 1000L;
              l4 = this.bct.bdg / 1000L;
              if (l3 == l4)
              {
                this.bct = new b((k.b)localObject1, l1, l2);
                paramMessage = this.eventHandler;
                if (i != 0) {}
                for (i = 1;; i = 0)
                {
                  paramMessage.obtainMessage(4, i, 0, this.bct).sendToTarget();
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
            this.bct = new b((k.b)localObject1, l3, l2);
            paramMessage = this.eventHandler;
            if ((i | j) == 0) {
              break label4941;
            }
            i = 1;
            label3024:
            paramMessage.obtainMessage(4, i, 0, this.bct).sendToTarget();
          }
          finally
          {
            this.bct = new b((k.b)localObject1, l1, l2);
            localObject1 = this.eventHandler;
            if (i == 0) {
              break label4946;
            }
          }
        }
      }
      i = 1;
      label3071:
      ((Handler)localObject1).obtainMessage(4, i, 0, this.bct).sendToTarget();
      AppMethodBeat.o(91924);
      throw paramMessage;
      paramMessage = (p)paramMessage.obj;
      if (this.bcF != null) {}
      for (paramMessage = this.bcF.c(paramMessage);; paramMessage = this.bcA.c(paramMessage))
      {
        this.bcs = paramMessage;
        this.eventHandler.obtainMessage(7, paramMessage).sendToTarget();
        AppMethodBeat.o(91924);
        return true;
      }
      to();
      AppMethodBeat.o(91924);
      return true;
      oE();
      AppMethodBeat.o(91924);
      return true;
      paramMessage = (j)paramMessage.obj;
      if (this.bcP != null)
      {
        localObject1 = this.bcP.bcS;
        if (localObject1 == paramMessage) {
          break label3220;
        }
      }
      for (;;)
      {
        AppMethodBeat.o(91924);
        return true;
        label3220:
        paramMessage = this.bcP;
        paramMessage.bcY = true;
        paramMessage.tt();
        l1 = paramMessage.C(paramMessage.bcX.bde);
        localObject1 = paramMessage.bcX;
        paramMessage.bcX = new n.a(((n.a)localObject1).bdH, l1, ((n.a)localObject1).bdI, ((n.a)localObject1).bdf, ((n.a)localObject1).bdJ, ((n.a)localObject1).bdK, ((n.a)localObject1).bdL);
        if (this.bcR == null)
        {
          this.bcQ = this.bcP;
          z(this.bcQ.bcX.bde);
          b(this.bcQ);
        }
        tq();
      }
      paramMessage = (Pair)paramMessage.obj;
      localObject3 = this.bco;
      this.bco = ((w)paramMessage.first);
      this.bcD.bco = this.bco;
      localObject2 = paramMessage.second;
      if (localObject3 == null)
      {
        if (this.bcM > 0)
        {
          paramMessage = a(this.bcN);
          i = this.bcM;
          this.bcM = 0;
          this.bcN = null;
          if (paramMessage == null) {
            b(localObject2, i);
          }
        }
        for (;;)
        {
          AppMethodBeat.o(91924);
          return true;
          j = ((Integer)paramMessage.first).intValue();
          l2 = ((Long)paramMessage.second).longValue();
          paramMessage = this.bcD.g(j, l2);
          if (!paramMessage.isAd()) {
            break;
          }
          l1 = 0L;
          label3482:
          this.bct = new b(paramMessage, l1, l2);
          c(localObject2, i);
          continue;
          if (this.bct.bde == -9223372036854775807L)
          {
            if (this.bco.isEmpty())
            {
              b(localObject2, 0);
            }
            else
            {
              paramMessage = dE(0);
              i = ((Integer)paramMessage.first).intValue();
              l2 = ((Long)paramMessage.second).longValue();
              paramMessage = this.bcD.g(i, l2);
              if (!paramMessage.isAd()) {
                break label4958;
              }
              l1 = 0L;
              label3592:
              this.bct = new b(paramMessage, l1, l2);
            }
          }
          else {
            c(localObject2, 0);
          }
        }
      }
      j = this.bct.bdd.bwx;
      if (this.bcR != null)
      {
        paramMessage = this.bcR;
        label3641:
        if ((paramMessage == null) && (j >= ((w)localObject3).tE())) {
          break label3903;
        }
        if (paramMessage != null) {
          break label3724;
        }
      }
      label3724:
      for (localObject1 = ((w)localObject3).a(j, this.bci, true).bcT;; localObject1 = paramMessage.bcT)
      {
        i = this.bco.ae(localObject1);
        if (i != -1) {
          break label3913;
        }
        i = a(j, (w)localObject3, this.bco);
        if (i != -1) {
          break label3733;
        }
        b(localObject2, 0);
        break;
        paramMessage = this.bcP;
        break label3641;
      }
      label3733:
      localObject1 = dE(this.bco.a(i, this.bci, false).bdi);
      i = ((Integer)((Pair)localObject1).first).intValue();
      l1 = ((Long)((Pair)localObject1).second).longValue();
      this.bco.a(i, this.bci, true);
      if (paramMessage != null)
      {
        localObject1 = this.bci.bcT;
        paramMessage.bcX = paramMessage.bcX.tx();
        while (paramMessage.bda != null)
        {
          paramMessage = paramMessage.bda;
          if (paramMessage.bcT.equals(localObject1)) {
            paramMessage.bcX = this.bcD.a(paramMessage.bcX, i);
          } else {
            paramMessage.bcX = paramMessage.bcX.tx();
          }
        }
      }
      paramMessage = new k.b(i);
      this.bct = new b(paramMessage, a(paramMessage, l1));
      for (;;)
      {
        label3903:
        c(localObject2, 0);
        break;
        label3913:
        if (i != j)
        {
          localObject1 = this.bct;
          localObject3 = new b(((b)localObject1).bdd.eA(i), ((b)localObject1).bde, ((b)localObject1).bdf);
          ((b)localObject3).bdg = ((b)localObject1).bdg;
          ((b)localObject3).bdh = ((b)localObject1).bdh;
          this.bct = ((b)localObject3);
        }
        if (this.bct.bdd.isAd())
        {
          localObject1 = this.bcD.g(i, this.bct.bdf);
          if ((!((k.b)localObject1).isAd()) || (((k.b)localObject1).bwz != this.bct.bdd.bwz))
          {
            l2 = a((k.b)localObject1, this.bct.bdf);
            if (!((k.b)localObject1).isAd()) {
              break label4965;
            }
            l1 = this.bct.bdf;
            label4066:
            this.bct = new b((k.b)localObject1, l2, l1);
            continue;
          }
        }
        if (paramMessage != null)
        {
          for (paramMessage = a(paramMessage, i); paramMessage.bda != null; paramMessage = a((a)localObject1, i))
          {
            localObject1 = paramMessage.bda;
            i = this.bco.a(i, this.bci, this.bch, this.repeatMode);
            if ((i == -1) || (!((a)localObject1).bcT.equals(this.bco.a(i, this.bci, true).bcT))) {
              break label4174;
            }
          }
          continue;
          label4174:
          if ((this.bcQ == null) || (this.bcQ.index >= ((a)localObject1).index)) {
            break label4973;
          }
          i = 1;
          label4198:
          if (i == 0)
          {
            l1 = a(this.bcR.bcX.bdH, this.bct.bdg);
            this.bct = new b(this.bcR.bcX.bdH, l1, this.bct.bdf);
          }
          else
          {
            this.bcP = paramMessage;
            this.bcP.bda = null;
            a((a)localObject1);
          }
        }
      }
      paramMessage = (j)paramMessage.obj;
      if (this.bcP != null)
      {
        localObject1 = this.bcP.bcS;
        if (localObject1 == paramMessage) {
          break label4317;
        }
      }
      for (;;)
      {
        AppMethodBeat.o(91924);
        return true;
        label4317:
        tq();
      }
      if (this.bcR != null)
      {
        paramMessage = this.bcR;
        i = 1;
      }
      for (;;)
      {
        if (paramMessage != null)
        {
          bool = paramMessage.bcY;
          if (bool) {}
        }
        else
        {
          AppMethodBeat.o(91924);
          return true;
        }
        if (paramMessage.tt()) {
          break;
        }
        if (paramMessage == this.bcQ) {
          i = 0;
        }
        paramMessage = paramMessage.bda;
      }
      if (i != 0)
      {
        if (this.bcQ == this.bcR) {
          break label4988;
        }
        bool = true;
        label4404:
        a(this.bcR.bda);
        this.bcR.bda = null;
        this.bcP = this.bcR;
        this.bcQ = this.bcR;
        localObject1 = new boolean[this.bcc.length];
        l1 = this.bcR.a(this.bct.bdg, bool, (boolean[])localObject1);
        if (l1 != this.bct.bdg)
        {
          this.bct.bdg = l1;
          z(l1);
        }
        j = 0;
        localObject2 = new boolean[this.bcc.length];
        i = 0;
        label4508:
        if (i < this.bcc.length)
        {
          localObject3 = this.bcc[i];
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
      localObject4 = this.bcR.bcU[i];
      k = j;
      if (localObject4 != null) {
        k = j + 1;
      }
      if (localObject2[i] != 0) {
        if (localObject4 != ((r)localObject3).sY())
        {
          if (localObject3 == this.bcE)
          {
            if (localObject4 == null) {
              this.bcA.a(this.bcF);
            }
            this.bcF = null;
            this.bcE = null;
          }
          a((r)localObject3);
          ((r)localObject3).disable();
        }
        else if (localObject1[i] != 0)
        {
          ((r)localObject3).u(this.bcO);
          break label4978;
          this.eventHandler.obtainMessage(3, paramMessage.bdb).sendToTarget();
          a((boolean[])localObject2, j);
          for (;;)
          {
            tq();
            tn();
            this.handler.sendEmptyMessage(2);
            break;
            this.bcP = paramMessage;
            for (paramMessage = this.bcP.bda; paramMessage != null; paramMessage = paramMessage.bda) {
              paramMessage.release();
            }
            this.bcP.bda = null;
            if (this.bcP.bcY)
            {
              l1 = this.bcP.bcX.bde;
              paramMessage = this.bcP;
              l1 = Math.max(l1, this.bcO - paramMessage.tr());
              this.bcP.C(l1);
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
    //   69: getfield 167	com/google/android/exoplayer2/i:bcB	Landroid/os/HandlerThread;
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
    private final k bcG;
    public final j bcS;
    public final Object bcT;
    public final com.google.android.exoplayer2.source.n[] bcU;
    public final boolean[] bcV;
    public final long bcW;
    public n.a bcX;
    public boolean bcY;
    public boolean bcZ;
    private final r[] bcc;
    private final h bcd;
    private final s[] bcy;
    final m bcz;
    public a bda;
    public com.google.android.exoplayer2.g.i bdb;
    private com.google.android.exoplayer2.g.i bdc;
    public final int index;
    
    public a(r[] paramArrayOfr, s[] paramArrayOfs, long paramLong, h paramh, m paramm, k paramk, Object paramObject, int paramInt, n.a parama)
    {
      AppMethodBeat.i(91909);
      this.bcc = paramArrayOfr;
      this.bcy = paramArrayOfs;
      this.bcW = paramLong;
      this.bcd = paramh;
      this.bcz = paramm;
      this.bcG = paramk;
      this.bcT = a.checkNotNull(paramObject);
      this.index = paramInt;
      this.bcX = parama;
      this.bcU = new com.google.android.exoplayer2.source.n[paramArrayOfr.length];
      this.bcV = new boolean[paramArrayOfr.length];
      paramArrayOfr = paramk.a(parama.bdH, paramm.th());
      if (parama.bdI != -9223372036854775808L)
      {
        paramArrayOfr = new d(paramArrayOfr, true);
        paramArrayOfr.h(0L, parama.bdI);
      }
      for (;;)
      {
        this.bcS = paramArrayOfr;
        AppMethodBeat.o(91909);
        return;
      }
    }
    
    public final void B(long paramLong)
    {
      AppMethodBeat.i(91912);
      long l = tr();
      this.bcS.X(paramLong - l);
      AppMethodBeat.o(91912);
    }
    
    public final long C(long paramLong)
    {
      AppMethodBeat.i(91914);
      paramLong = a(paramLong, false, new boolean[this.bcc.length]);
      AppMethodBeat.o(91914);
      return paramLong;
    }
    
    public final long a(long paramLong, boolean paramBoolean, boolean[] paramArrayOfBoolean)
    {
      AppMethodBeat.i(91915);
      g localg = this.bdb.bEG;
      int i = 0;
      if (i < localg.length)
      {
        boolean[] arrayOfBoolean = this.bcV;
        if ((!paramBoolean) && (this.bdb.a(this.bdc, i))) {}
        for (int j = 1;; j = 0)
        {
          arrayOfBoolean[i] = j;
          i += 1;
          break;
        }
      }
      paramLong = this.bcS.a(localg.wB(), this.bcV, this.bcU, paramArrayOfBoolean, paramLong);
      this.bdc = this.bdb;
      this.bcZ = false;
      i = 0;
      if (i < this.bcU.length)
      {
        if (this.bcU[i] != null)
        {
          if (localg.bED[i] != null) {}
          for (paramBoolean = true;; paramBoolean = false)
          {
            a.checkState(paramBoolean);
            this.bcZ = true;
            i += 1;
            break;
          }
        }
        if (localg.bED[i] == null) {}
        for (paramBoolean = true;; paramBoolean = false)
        {
          a.checkState(paramBoolean);
          break;
        }
      }
      this.bcz.a(this.bcc, localg);
      AppMethodBeat.o(91915);
      return paramLong;
    }
    
    public final void release()
    {
      AppMethodBeat.i(91916);
      try
      {
        if (this.bcX.bdI != -9223372036854775808L)
        {
          this.bcG.b(((d)this.bcS).bcS);
          AppMethodBeat.o(91916);
          return;
        }
        this.bcG.b(this.bcS);
        AppMethodBeat.o(91916);
        return;
      }
      catch (RuntimeException localRuntimeException)
      {
        AppMethodBeat.o(91916);
      }
    }
    
    public final long tr()
    {
      if (this.index == 0) {
        return this.bcW;
      }
      return this.bcW - this.bcX.bde;
    }
    
    public final boolean ts()
    {
      AppMethodBeat.i(91910);
      if ((this.bcY) && ((!this.bcZ) || (this.bcS.vq() == -9223372036854775808L)))
      {
        AppMethodBeat.o(91910);
        return true;
      }
      AppMethodBeat.o(91910);
      return false;
    }
    
    public final boolean tt()
    {
      AppMethodBeat.i(91913);
      com.google.android.exoplayer2.g.i locali = this.bcd.a(this.bcy, this.bcS.vo());
      if (locali.a(this.bdc))
      {
        AppMethodBeat.o(91913);
        return false;
      }
      this.bdb = locali;
      AppMethodBeat.o(91913);
      return true;
    }
    
    public final boolean x(long paramLong)
    {
      AppMethodBeat.i(91911);
      if (!this.bcY) {}
      for (long l1 = 0L; l1 == -9223372036854775808L; l1 = this.bcS.vr())
      {
        AppMethodBeat.o(91911);
        return false;
      }
      long l2 = tr();
      boolean bool = this.bcz.x(l1 - (paramLong - l2));
      AppMethodBeat.o(91911);
      return bool;
    }
  }
  
  public static final class b
  {
    public final k.b bdd;
    public final long bde;
    public final long bdf;
    public volatile long bdg;
    public volatile long bdh;
    
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
      this.bdd = paramb;
      this.bde = paramLong1;
      this.bdf = paramLong2;
      this.bdg = paramLong1;
      this.bdh = paramLong1;
    }
  }
  
  static final class c
  {
    public final w bco;
    public final int bdi;
    public final long bdj;
    
    public c(w paramw, int paramInt, long paramLong)
    {
      this.bco = paramw;
      this.bdi = paramInt;
      this.bdj = paramLong;
    }
  }
  
  public static final class d
  {
    public final w bco;
    public final Object bcp;
    public final i.b bct;
    public final int bdk;
    
    public d(w paramw, Object paramObject, i.b paramb, int paramInt)
    {
      this.bco = paramw;
      this.bcp = paramObject;
      this.bct = paramb;
      this.bdk = paramInt;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes8.jar
 * Qualified Name:     com.google.android.exoplayer2.i
 * JD-Core Version:    0.7.0.1
 */