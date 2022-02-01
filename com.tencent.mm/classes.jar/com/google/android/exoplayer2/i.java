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
  private final s[] bcB;
  private final m bcC;
  private final com.google.android.exoplayer2.i.s bcD;
  private final HandlerThread bcE;
  private final f bcF;
  private final n bcG;
  private r bcH;
  private com.google.android.exoplayer2.i.i bcI;
  private com.google.android.exoplayer2.source.i bcJ;
  private r[] bcK;
  private boolean bcL;
  int bcM;
  private int bcN;
  private long bcO;
  private int bcP;
  private c bcQ;
  private long bcR;
  private a bcS;
  private a bcT;
  private a bcU;
  private final r[] bcf;
  private final com.google.android.exoplayer2.g.h bcg;
  private final w.b bck;
  private final w.a bcl;
  private boolean bcn;
  private w bcr;
  private p bcv;
  private b bcw;
  private final Handler eventHandler;
  final Handler handler;
  private boolean isLoading;
  boolean released;
  private int repeatMode;
  private int state;
  
  public i(r[] paramArrayOfr, com.google.android.exoplayer2.g.h paramh, m paramm, boolean paramBoolean, int paramInt, Handler paramHandler, b paramb, f paramf)
  {
    AppMethodBeat.i(91918);
    this.bcf = paramArrayOfr;
    this.bcg = paramh;
    this.bcC = paramm;
    this.bcn = paramBoolean;
    this.repeatMode = paramInt;
    this.eventHandler = paramHandler;
    this.state = 1;
    this.bcw = paramb;
    this.bcF = paramf;
    this.bcB = new s[paramArrayOfr.length];
    paramInt = 0;
    while (paramInt < paramArrayOfr.length)
    {
      paramArrayOfr[paramInt].setIndex(paramInt);
      this.bcB[paramInt] = paramArrayOfr[paramInt].sR();
      paramInt += 1;
    }
    this.bcD = new com.google.android.exoplayer2.i.s();
    this.bcK = new r[0];
    this.bck = new w.b();
    this.bcl = new w.a();
    this.bcG = new n();
    paramh.bEC = this;
    this.bcv = p.bdP;
    this.bcE = new HandlerThread("ExoPlayerImplInternal:Handler", -16);
    this.bcE.start();
    this.handler = new Handler(this.bcE.getLooper(), this);
    AppMethodBeat.o(91918);
  }
  
  private boolean A(long paramLong)
  {
    AppMethodBeat.i(91939);
    if ((paramLong == -9223372036854775807L) || (this.bcw.bdj < paramLong) || ((this.bcU.bdd != null) && ((this.bcU.bdd.bdb) || (this.bcU.bdd.bda.bdK.vx()))))
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
    int m = paramw1.tz();
    int k = 0;
    int i = -1;
    int j = paramInt;
    paramInt = k;
    while ((paramInt < m) && (i == -1))
    {
      j = paramw1.a(j, this.bcl, this.bck, this.repeatMode);
      if (j == -1) {
        break;
      }
      i = paramw2.ae(paramw1.a(j, this.bcl, true).bcW);
      paramInt += 1;
    }
    AppMethodBeat.o(91944);
    return i;
  }
  
  private long a(com.google.android.exoplayer2.source.i.b paramb, long paramLong)
  {
    AppMethodBeat.i(91931);
    th();
    this.bcL = false;
    setState(2);
    Object localObject;
    if (this.bcU == null)
    {
      if (this.bcS == null) {
        break label288;
      }
      this.bcS.release();
      localObject = null;
    }
    for (;;)
    {
      if ((this.bcU != localObject) || (this.bcU != this.bcT))
      {
        paramb = this.bcK;
        int j = paramb.length;
        int i = 0;
        for (;;)
        {
          if (i < j)
          {
            paramb[i].disable();
            i += 1;
            continue;
            a locala1 = this.bcU;
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
              locala1 = locala1.bdd;
              break;
              locala1.release();
            }
          }
        }
        this.bcK = new r[0];
        this.bcI = null;
        this.bcH = null;
        this.bcU = null;
      }
      if (localObject != null)
      {
        localObject.bdd = null;
        this.bcS = localObject;
        this.bcT = localObject;
        b(localObject);
        long l = paramLong;
        if (this.bcU.bdc) {
          l = this.bcU.bcV.W(paramLong);
        }
        z(l);
        tl();
        paramLong = l;
      }
      for (;;)
      {
        this.handler.sendEmptyMessage(2);
        AppMethodBeat.o(91931);
        return paramLong;
        this.bcS = null;
        this.bcT = null;
        this.bcU = null;
        z(paramLong);
      }
      label288:
      localObject = null;
    }
  }
  
  private Pair<Integer, Long> a(c paramc)
  {
    AppMethodBeat.i(91945);
    Object localObject2 = paramc.bcr;
    Object localObject1 = localObject2;
    if (((w)localObject2).isEmpty()) {
      localObject1 = this.bcr;
    }
    try
    {
      localObject2 = ((w)localObject1).a(this.bck, this.bcl, paramc.bdl, paramc.bdm);
      if (this.bcr == localObject1)
      {
        AppMethodBeat.o(91945);
        return localObject2;
      }
    }
    catch (IndexOutOfBoundsException localIndexOutOfBoundsException)
    {
      paramc = new l(this.bcr, paramc.bdl, paramc.bdm);
      AppMethodBeat.o(91945);
      throw paramc;
    }
    int i = this.bcr.ae(localIndexOutOfBoundsException.a(((Integer)((Pair)localObject2).first).intValue(), this.bcl, true).bcW);
    if (i != -1)
    {
      paramc = Pair.create(Integer.valueOf(i), ((Pair)localObject2).second);
      AppMethodBeat.o(91945);
      return paramc;
    }
    i = a(((Integer)((Pair)localObject2).first).intValue(), localIndexOutOfBoundsException, this.bcr);
    if (i != -1)
    {
      paramc = dJ(this.bcr.a(i, this.bcl, false).bdl);
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
      parama.bda = this.bcG.a(parama.bda, paramInt);
      if ((parama.bda.bdN) || (parama.bdd == null))
      {
        AppMethodBeat.o(91941);
        return parama;
      }
      parama = parama.bdd;
    }
  }
  
  private static void a(a parama)
  {
    AppMethodBeat.i(91948);
    while (parama != null)
    {
      parama.release();
      parama = parama.bdd;
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
    this.bcK = new r[paramInt];
    int i = 0;
    paramInt = 0;
    while (paramInt < this.bcf.length)
    {
      r localr = this.bcf[paramInt];
      Object localObject = this.bcU.bde.bEE.bEB[paramInt];
      int j = i;
      if (localObject != null)
      {
        this.bcK[i] = localr;
        if (localr.getState() == 0)
        {
          t localt = this.bcU.bde.bEF[paramInt];
          if ((this.bcn) && (this.state == 3))
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
              arrayOfFormat[k] = ((com.google.android.exoplayer2.g.f)localObject).eV(k);
              k += 1;
            }
            j = 0;
            break;
          }
          localr.a(localt, arrayOfFormat, this.bcU.bcX[paramInt], this.bcR, bool, this.bcU.tm());
          localObject = localr.sS();
          if (localObject != null)
          {
            if (this.bcI != null)
            {
              paramArrayOfBoolean = e.a(new IllegalStateException("Multiple renderer media clocks enabled."));
              AppMethodBeat.o(91950);
              throw paramArrayOfBoolean;
            }
            this.bcI = ((com.google.android.exoplayer2.i.i)localObject);
            this.bcH = localr;
            this.bcI.c(this.bcv);
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
    if ((paramb.equals(parama.bda.bdK)) && (parama.bdb))
    {
      this.bcr.a(parama.bda.bdK.bww, this.bcl, false);
      int i = this.bcl.F(paramLong);
      if ((i == -1) || (this.bcl.ber[i] == parama.bda.bdL))
      {
        AppMethodBeat.o(91932);
        return true;
      }
    }
    AppMethodBeat.o(91932);
    return false;
  }
  
  private void aQ(boolean paramBoolean)
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
  
  private void aR(boolean paramBoolean)
  {
    AppMethodBeat.i(91936);
    this.handler.removeMessages(2);
    this.bcL = false;
    this.bcD.stop();
    this.bcI = null;
    this.bcH = null;
    this.bcR = 60000000L;
    Object localObject = this.bcK;
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
        this.bcK = new r[0];
        if (this.bcU != null) {}
        for (localObject = this.bcU;; localObject = this.bcS)
        {
          a((a)localObject);
          this.bcS = null;
          this.bcT = null;
          this.bcU = null;
          aQ(false);
          if (paramBoolean)
          {
            if (this.bcJ != null)
            {
              this.bcJ.vo();
              this.bcJ = null;
            }
            this.bcG.bcr = null;
            this.bcr = null;
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
    if (this.bcU == parama)
    {
      AppMethodBeat.o(91949);
      return;
    }
    boolean[] arrayOfBoolean = new boolean[this.bcf.length];
    int i = 0;
    int j = 0;
    if (i < this.bcf.length)
    {
      r localr = this.bcf[i];
      if (localr.getState() != 0) {}
      for (int m = 1;; m = 0)
      {
        arrayOfBoolean[i] = m;
        com.google.android.exoplayer2.g.f localf = parama.bde.bEE.bEB[i];
        int k = j;
        if (localf != null) {
          k = j + 1;
        }
        if ((arrayOfBoolean[i] != 0) && ((localf == null) || ((localr.sW()) && (localr.sT() == this.bcU.bcX[i]))))
        {
          if (localr == this.bcH)
          {
            this.bcD.a(this.bcI);
            this.bcI = null;
            this.bcH = null;
          }
          a(localr);
          localr.disable();
        }
        i += 1;
        j = k;
        break;
      }
    }
    this.bcU = parama;
    this.eventHandler.obtainMessage(3, parama.bde).sendToTarget();
    a(arrayOfBoolean, j);
    AppMethodBeat.o(91949);
  }
  
  private void c(Object paramObject, int paramInt)
  {
    AppMethodBeat.i(91942);
    this.bcw = new b(0L);
    d(paramObject, paramInt);
    this.bcw = new b(-9223372036854775807L);
    setState(4);
    aR(false);
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
    //   23: getfield 521	com/google/android/exoplayer2/f$c:bcc	Lcom/google/android/exoplayer2/f$b;
    //   26: aload 4
    //   28: getfield 524	com/google/android/exoplayer2/f$c:bcd	I
    //   31: aload 4
    //   33: getfield 527	com/google/android/exoplayer2/f$c:bce	Ljava/lang/Object;
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
    //   77: getfield 534	com/google/android/exoplayer2/i:bcN	I
    //   80: iconst_1
    //   81: iadd
    //   82: putfield 534	com/google/android/exoplayer2/i:bcN	I
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
    //   114: getfield 534	com/google/android/exoplayer2/i:bcN	I
    //   117: iconst_1
    //   118: iadd
    //   119: putfield 534	com/google/android/exoplayer2/i:bcN	I
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
    this.eventHandler.obtainMessage(6, new d(this.bcr, paramObject, this.bcw, paramInt)).sendToTarget();
    AppMethodBeat.o(91943);
  }
  
  private Pair<Integer, Long> dJ(int paramInt)
  {
    AppMethodBeat.i(91946);
    Pair localPair = this.bcr.a(this.bck, this.bcl, paramInt, -9223372036854775807L);
    AppMethodBeat.o(91946);
    return localPair;
  }
  
  private void oy()
  {
    AppMethodBeat.i(91935);
    aR(true);
    this.bcC.tb();
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
  
  private void tg()
  {
    int i = 0;
    AppMethodBeat.i(91927);
    this.bcL = false;
    this.bcD.start();
    r[] arrayOfr = this.bcK;
    int j = arrayOfr.length;
    while (i < j)
    {
      arrayOfr[i].start();
      i += 1;
    }
    AppMethodBeat.o(91927);
  }
  
  private void th()
  {
    AppMethodBeat.i(91928);
    this.bcD.stop();
    r[] arrayOfr = this.bcK;
    int j = arrayOfr.length;
    int i = 0;
    while (i < j)
    {
      a(arrayOfr[i]);
      i += 1;
    }
    AppMethodBeat.o(91928);
  }
  
  private void ti()
  {
    AppMethodBeat.i(91929);
    if (this.bcU == null)
    {
      AppMethodBeat.o(91929);
      return;
    }
    long l1 = this.bcU.bcV.vj();
    if (l1 != -9223372036854775807L)
    {
      z(l1);
      this.bcw.bdj = l1;
      this.bcO = (SystemClock.elapsedRealtime() * 1000L);
      if (this.bcK.length != 0) {
        break label194;
      }
    }
    label194:
    for (l1 = -9223372036854775808L;; l1 = this.bcU.bcV.vk())
    {
      Object localObject = this.bcw;
      long l2 = l1;
      if (l1 == -9223372036854775808L) {
        l2 = this.bcU.bda.bdM;
      }
      ((b)localObject).bdk = l2;
      AppMethodBeat.o(91929);
      return;
      if ((this.bcH != null) && (!this.bcH.tw()))
      {
        this.bcR = this.bcI.tQ();
        this.bcD.ah(this.bcR);
      }
      for (;;)
      {
        localObject = this.bcU;
        l1 = this.bcR - ((a)localObject).tm();
        break;
        this.bcR = this.bcD.tQ();
      }
    }
  }
  
  private void tj()
  {
    AppMethodBeat.i(91934);
    aR(true);
    this.bcC.onStopped();
    setState(1);
    AppMethodBeat.o(91934);
  }
  
  private void tk()
  {
    AppMethodBeat.i(91940);
    if ((this.bcS != null) && (!this.bcS.bdb) && ((this.bcT == null) || (this.bcT.bdd == this.bcS)))
    {
      r[] arrayOfr = this.bcK;
      int j = arrayOfr.length;
      int i = 0;
      while (i < j)
      {
        if (!arrayOfr[i].sU())
        {
          AppMethodBeat.o(91940);
          return;
        }
        i += 1;
      }
      this.bcS.bcV.vh();
    }
    AppMethodBeat.o(91940);
  }
  
  private void tl()
  {
    AppMethodBeat.i(91947);
    boolean bool = this.bcS.x(this.bcR);
    aQ(bool);
    if (bool) {
      this.bcS.B(this.bcR);
    }
    AppMethodBeat.o(91947);
  }
  
  private void z(long paramLong)
  {
    AppMethodBeat.i(91933);
    if (this.bcU == null) {}
    for (paramLong = 60000000L + paramLong;; paramLong = this.bcU.tm() + paramLong)
    {
      this.bcR = paramLong;
      this.bcD.ah(this.bcR);
      r[] arrayOfr = this.bcK;
      int j = arrayOfr.length;
      int i = 0;
      while (i < j)
      {
        arrayOfr[i].u(this.bcR);
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
    //   25: getfield 635	com/google/android/exoplayer2/i:bcM	I
    //   28: istore_3
    //   29: aload_0
    //   30: iload_3
    //   31: iconst_1
    //   32: iadd
    //   33: putfield 635	com/google/android/exoplayer2/i:bcM	I
    //   36: aload_0
    //   37: getfield 181	com/google/android/exoplayer2/i:handler	Landroid/os/Handler;
    //   40: bipush 11
    //   42: aload_1
    //   43: invokevirtual 503	android/os/Handler:obtainMessage	(ILjava/lang/Object;)Landroid/os/Message;
    //   46: invokevirtual 465	android/os/Message:sendToTarget	()V
    //   49: iconst_0
    //   50: istore_2
    //   51: aload_0
    //   52: getfield 534	com/google/android/exoplayer2/i:bcN	I
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
      tj();
      AppMethodBeat.o(91924);
      return true;
      if (paramMessage.arg1 == 0) {
        break label300;
      }
      bool = true;
      this.bcL = false;
      this.bcn = bool;
      if (bool) {
        break label306;
      }
      th();
      ti();
      for (;;)
      {
        AppMethodBeat.o(91924);
        return true;
        bool = false;
        break;
        if (this.state != 3) {
          break label359;
        }
        tg();
        this.handler.sendEmptyMessage(2);
      }
    }
    catch (IOException paramMessage)
    {
      for (;;)
      {
        this.eventHandler.obtainMessage(8, e.a(paramMessage)).sendToTarget();
        tj();
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
      tj();
      AppMethodBeat.o(91924);
      return true;
    }
    Object localObject1 = (com.google.android.exoplayer2.source.i)paramMessage.obj;
    if (paramMessage.arg1 != 0)
    {
      i = 1;
      this.eventHandler.sendEmptyMessage(0);
      aR(true);
      this.bcC.ta();
      if (i == 0) {
        break label197;
      }
    }
    label197:
    for (this.bcw = new b(-9223372036854775807L);; this.bcw = new b(this.bcw.bdg, this.bcw.bdj, this.bcw.bdi))
    {
      this.bcJ = ((com.google.android.exoplayer2.source.i)localObject1);
      if (localObject1 != null) {
        ((com.google.android.exoplayer2.source.i)localObject1).a(this.bcF, this);
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
    this.bcG.repeatMode = i;
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
    if (this.bcU != null)
    {
      paramMessage = this.bcU;
    }
    else
    {
      for (;;)
      {
        j = this.bcr.a(paramMessage.bda.bdK.bww, this.bcl, this.bck, i);
        while ((paramMessage.bdd != null) && (!paramMessage.bda.bdN))
        {
          paramMessage = paramMessage.bdd;
          continue;
          paramMessage = this.bcS;
          break label4822;
        }
        if ((j == -1) || (paramMessage.bdd == null) || (paramMessage.bdd.bda.bdK.bww != j)) {
          break;
        }
        paramMessage = paramMessage.bdd;
      }
      j = this.bcS.index;
      if (this.bcT != null)
      {
        i = this.bcT.index;
        if (paramMessage.bdd != null)
        {
          a(paramMessage.bdd);
          paramMessage.bdd = null;
        }
        localObject1 = this.bcG;
        localObject2 = paramMessage.bda;
        paramMessage.bda = ((n)localObject1).a((n.a)localObject2, ((n.a)localObject2).bdK);
        if (j > paramMessage.index) {
          break label708;
        }
        j = 1;
        if (j == 0) {
          this.bcS = paramMessage;
        }
        if ((i == -1) || (i > paramMessage.index)) {
          break label713;
        }
      }
      for (i = 1;; i = 0)
      {
        if ((i == 0) && (this.bcU != null))
        {
          paramMessage = this.bcU.bda.bdK;
          this.bcw = new b(paramMessage, a(paramMessage, this.bcw.bdj), this.bcw.bdi);
        }
        AppMethodBeat.o(91924);
        return true;
        i = -1;
        break;
        j = 0;
        break label618;
      }
      long l3 = SystemClock.elapsedRealtime();
      if ((this.bcr == null) && (this.bcJ != null)) {
        this.bcJ.vn();
      }
      long l4;
      while (this.bcU == null)
      {
        tk();
        d(l3, 10L);
        AppMethodBeat.o(91924);
        return true;
        if (this.bcS == null)
        {
          paramMessage = this.bcG;
          localObject1 = this.bcw;
          paramMessage = paramMessage.a(((b)localObject1).bdg, ((b)localObject1).bdi, ((b)localObject1).bdh);
          if (paramMessage != null) {
            break label1556;
          }
          this.bcJ.vn();
          if ((this.bcS != null) && (!this.bcS.tn())) {
            break label1719;
          }
          aQ(false);
        }
        for (;;)
        {
          if (this.bcU == null) {
            break label1738;
          }
          while ((this.bcU != this.bcT) && (this.bcR >= this.bcU.bdd.bcZ))
          {
            this.bcU.release();
            b(this.bcU.bdd);
            this.bcw = new b(this.bcU.bda.bdK, this.bcU.bda.bdh, this.bcU.bda.bdi);
            ti();
            this.eventHandler.obtainMessage(5, this.bcw).sendToTarget();
          }
          if ((this.bcS.bda.bdO) || (!this.bcS.tn()) || (this.bcS.bda.bdM == -9223372036854775807L) || ((this.bcU != null) && (this.bcS.index - this.bcU.index == 100))) {
            break label825;
          }
          paramMessage = this.bcG;
          localObject1 = this.bcS.bda;
          l1 = this.bcS.tm();
          l2 = this.bcR;
          if (((n.a)localObject1).bdN)
          {
            i = paramMessage.bcr.a(((n.a)localObject1).bdK.bww, paramMessage.bcl, paramMessage.bck, paramMessage.repeatMode);
            if (i == -1)
            {
              paramMessage = null;
              break;
            }
            j = paramMessage.bcr.a(i, paramMessage.bcl, false).bdl;
            if (paramMessage.bcr.a(j, paramMessage.bck).beB != i) {
              break label4829;
            }
            l4 = ((n.a)localObject1).bdM;
            localObject1 = paramMessage.bcr.a(paramMessage.bck, paramMessage.bcl, j, -9223372036854775807L, Math.max(0L, l4 + l1 - l2));
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
          localObject2 = ((n.a)localObject1).bdK;
          if (((com.google.android.exoplayer2.source.i.b)localObject2).vx())
          {
            i = ((com.google.android.exoplayer2.source.i.b)localObject2).bwx;
            paramMessage.bcr.a(((com.google.android.exoplayer2.source.i.b)localObject2).bww, paramMessage.bcl, false);
            j = paramMessage.bcl.bes[i];
            if (j == -1)
            {
              paramMessage = null;
              break;
            }
            k = ((com.google.android.exoplayer2.source.i.b)localObject2).bwy + 1;
            if (k < j)
            {
              if (!paramMessage.bcl.bg(i, k))
              {
                paramMessage = null;
                break;
              }
              paramMessage = paramMessage.b(((com.google.android.exoplayer2.source.i.b)localObject2).bww, i, k, ((n.a)localObject1).bdi);
              break;
            }
            i = paramMessage.bcl.F(((n.a)localObject1).bdi);
            if (i == -1) {}
            for (l1 = -9223372036854775808L;; l1 = paramMessage.bcl.ber[i])
            {
              paramMessage = paramMessage.b(((com.google.android.exoplayer2.source.i.b)localObject2).bww, ((n.a)localObject1).bdi, l1);
              break;
            }
          }
          if (((n.a)localObject1).bdL != -9223372036854775808L)
          {
            i = paramMessage.bcl.E(((n.a)localObject1).bdL);
            if (!paramMessage.bcl.bg(i, 0))
            {
              paramMessage = null;
              break;
            }
            paramMessage = paramMessage.b(((com.google.android.exoplayer2.source.i.b)localObject2).bww, i, 0, ((n.a)localObject1).bdL);
            break;
          }
          i = paramMessage.bcl.tA();
          if ((i == 0) || (paramMessage.bcl.ber[(i - 1)] != -9223372036854775808L) || (paramMessage.bcl.dM(i - 1)) || (!paramMessage.bcl.bg(i - 1, 0))) {
            break label4835;
          }
          l1 = paramMessage.bcl.bdM;
          paramMessage = paramMessage.b(((com.google.android.exoplayer2.source.i.b)localObject2).bww, i - 1, 0, l1);
          break;
          if (this.bcS == null)
          {
            l1 = 60000000L;
            if (this.bcS != null) {
              break label1706;
            }
          }
          for (i = 0;; i = this.bcS.index + 1)
          {
            localObject1 = this.bcr.a(paramMessage.bdK.bww, this.bcl, true).bcW;
            localObject1 = new a(this.bcf, this.bcB, l1, this.bcg, this.bcC, this.bcJ, localObject1, i, paramMessage);
            if (this.bcS != null) {
              this.bcS.bdd = ((a)localObject1);
            }
            this.bcS = ((a)localObject1);
            this.bcS.bcV.a(this, paramMessage.bdh);
            aQ(true);
            break;
            l1 = this.bcS.tm() + this.bcS.bda.bdM;
            break label1568;
          }
          if ((this.bcS != null) && (!this.isLoading)) {
            tl();
          }
        }
        continue;
        if (!this.bcT.bda.bdO) {
          break label4847;
        }
        i = 0;
        if (i >= this.bcf.length) {
          break label4845;
        }
        paramMessage = this.bcf[i];
        localObject1 = this.bcT.bcX[i];
        if ((localObject1 == null) || (paramMessage.sT() != localObject1) || (!paramMessage.sU())) {
          break label4840;
        }
        paramMessage.sV();
        break label4840;
        if (i < this.bcf.length)
        {
          paramMessage = this.bcf[i];
          localObject1 = this.bcT.bcX[i];
          if (paramMessage.sT() == localObject1)
          {
            if (localObject1 == null) {
              break label4852;
            }
            if (paramMessage.sU()) {
              break label4852;
            }
          }
        }
        else if ((this.bcT.bdd != null) && (this.bcT.bdd.bdb))
        {
          paramMessage = this.bcT.bde;
          this.bcT = this.bcT.bdd;
          localObject1 = this.bcT.bde;
          if (this.bcT.bcV.vj() == -9223372036854775807L) {
            break label4864;
          }
          i = 1;
          break label4859;
          if (j >= this.bcf.length) {
            break label4874;
          }
          localObject2 = this.bcf[j];
          if (paramMessage.bEE.bEB[j] == null) {
            break label4869;
          }
          if (i == 0)
          {
            if (((r)localObject2).sW()) {
              break label4869;
            }
            localObject3 = localObject1.bEE.bEB[j];
            localObject4 = paramMessage.bEF[j];
            t localt = localObject1.bEF[j];
            if ((localObject3 != null) && (localt.equals(localObject4)))
            {
              localObject4 = new Format[((com.google.android.exoplayer2.g.f)localObject3).length()];
              k = 0;
              while (k < localObject4.length)
              {
                localObject4[k] = ((com.google.android.exoplayer2.g.f)localObject3).eV(k);
                k += 1;
              }
              ((r)localObject2).a((Format[])localObject4, this.bcT.bcX[j], this.bcT.tm());
              break label4869;
            }
          }
          ((r)localObject2).sV();
          break label4869;
        }
      }
      v.beginSection("doSomeWork");
      ti();
      this.bcU.bcV.V(this.bcw.bdj);
      i = 1;
      bool = true;
      paramMessage = this.bcK;
      int m = paramMessage.length;
      j = 0;
      if (j < m)
      {
        localObject1 = paramMessage[j];
        ((r)localObject1).e(this.bcR, this.bcO);
        if ((i == 0) || (!((r)localObject1).tw())) {
          break label4902;
        }
        i = 1;
        label2204:
        if (((r)localObject1).isReady()) {
          break label4876;
        }
        if (!((r)localObject1).tw()) {
          break label4907;
        }
        break label4876;
        label2227:
        if (k != 0) {
          break label4882;
        }
        ((r)localObject1).sX();
        break label4882;
      }
      if (!bool) {
        tk();
      }
      if (this.bcI != null)
      {
        paramMessage = this.bcI.tU();
        if (!paramMessage.equals(this.bcv))
        {
          this.bcv = paramMessage;
          this.bcD.a(this.bcI);
          this.eventHandler.obtainMessage(7, paramMessage).sendToTarget();
        }
      }
      l1 = this.bcU.bda.bdM;
      if ((i != 0) && ((l1 == -9223372036854775807L) || (l1 <= this.bcw.bdj)) && (this.bcU.bda.bdO))
      {
        setState(4);
        th();
      }
      label2368:
      while (this.state == 2)
      {
        paramMessage = this.bcK;
        j = paramMessage.length;
        i = 0;
        while (i < j)
        {
          paramMessage[i].sX();
          i += 1;
        }
        if (this.state == 2)
        {
          if (this.bcK.length > 0)
          {
            if (!bool) {
              break label4930;
            }
            paramMessage = this.bcS;
            bool = this.bcL;
            l4 = this.bcR;
            if (!paramMessage.bdb)
            {
              l1 = paramMessage.bda.bdh;
              l2 = l1;
              if (l1 != -9223372036854775808L) {
                break label2536;
              }
              if (!paramMessage.bda.bdO) {
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
            if (!this.bcn) {
              break;
            }
            tg();
            break;
            l1 = paramMessage.bcV.vk();
            break label2460;
            label2527:
            l2 = paramMessage.bda.bdM;
            label2536:
            bool = paramMessage.bcC.b(l2 - (l4 - paramMessage.tm()), bool);
            break label4919;
            bool = A(l1);
          }
        }
        if (this.state == 3)
        {
          if (this.bcK.length > 0) {}
          for (;;)
          {
            if (bool) {
              break label2623;
            }
            this.bcL = this.bcn;
            setState(2);
            th();
            break;
            bool = A(l1);
          }
        }
      }
      label2460:
      label2489:
      label2623:
      if (((this.bcn) && (this.state == 3)) || (this.state == 2)) {
        d(l3, 10L);
      }
      for (;;)
      {
        v.endSection();
        break;
        if ((this.bcK.length != 0) && (this.state != 4)) {
          d(l3, 1000L);
        } else {
          this.handler.removeMessages(2);
        }
      }
      paramMessage = (c)paramMessage.obj;
      if (this.bcr == null)
      {
        this.bcP += 1;
        this.bcQ = paramMessage;
      }
      for (;;)
      {
        AppMethodBeat.o(91924);
        return true;
        localObject1 = a(paramMessage);
        if (localObject1 == null)
        {
          this.bcw = new b(0L);
          this.eventHandler.obtainMessage(4, 1, 0, this.bcw).sendToTarget();
          this.bcw = new b(-9223372036854775807L);
          setState(4);
          aR(false);
        }
        else
        {
          if (paramMessage.bdm == -9223372036854775807L)
          {
            i = 1;
            label2821:
            j = ((Integer)((Pair)localObject1).first).intValue();
            l2 = ((Long)((Pair)localObject1).second).longValue();
            localObject1 = this.bcG.g(j, l2);
            bool = ((com.google.android.exoplayer2.source.i.b)localObject1).vx();
            if (!bool) {
              break label4815;
            }
            l1 = 0L;
            i = 1;
          }
          try
          {
            label2875:
            if (((com.google.android.exoplayer2.source.i.b)localObject1).equals(this.bcw.bdg))
            {
              l3 = l1 / 1000L;
              l4 = this.bcw.bdj / 1000L;
              if (l3 == l4)
              {
                this.bcw = new b((com.google.android.exoplayer2.source.i.b)localObject1, l1, l2);
                paramMessage = this.eventHandler;
                if (i != 0) {}
                for (i = 1;; i = 0)
                {
                  paramMessage.obtainMessage(4, i, 0, this.bcw).sendToTarget();
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
            this.bcw = new b((com.google.android.exoplayer2.source.i.b)localObject1, l3, l2);
            paramMessage = this.eventHandler;
            if ((i | j) == 0) {
              break label4941;
            }
            i = 1;
            label3024:
            paramMessage.obtainMessage(4, i, 0, this.bcw).sendToTarget();
          }
          finally
          {
            this.bcw = new b((com.google.android.exoplayer2.source.i.b)localObject1, l1, l2);
            localObject1 = this.eventHandler;
            if (i == 0) {
              break label4946;
            }
          }
        }
      }
      i = 1;
      label3071:
      ((Handler)localObject1).obtainMessage(4, i, 0, this.bcw).sendToTarget();
      AppMethodBeat.o(91924);
      throw paramMessage;
      paramMessage = (p)paramMessage.obj;
      if (this.bcI != null) {}
      for (paramMessage = this.bcI.c(paramMessage);; paramMessage = this.bcD.c(paramMessage))
      {
        this.bcv = paramMessage;
        this.eventHandler.obtainMessage(7, paramMessage).sendToTarget();
        AppMethodBeat.o(91924);
        return true;
      }
      tj();
      AppMethodBeat.o(91924);
      return true;
      oy();
      AppMethodBeat.o(91924);
      return true;
      paramMessage = (com.google.android.exoplayer2.source.h)paramMessage.obj;
      if (this.bcS != null)
      {
        localObject1 = this.bcS.bcV;
        if (localObject1 == paramMessage) {
          break label3220;
        }
      }
      for (;;)
      {
        AppMethodBeat.o(91924);
        return true;
        label3220:
        paramMessage = this.bcS;
        paramMessage.bdb = true;
        paramMessage.to();
        l1 = paramMessage.C(paramMessage.bda.bdh);
        localObject1 = paramMessage.bda;
        paramMessage.bda = new n.a(((n.a)localObject1).bdK, l1, ((n.a)localObject1).bdL, ((n.a)localObject1).bdi, ((n.a)localObject1).bdM, ((n.a)localObject1).bdN, ((n.a)localObject1).bdO);
        if (this.bcU == null)
        {
          this.bcT = this.bcS;
          z(this.bcT.bda.bdh);
          b(this.bcT);
        }
        tl();
      }
      paramMessage = (Pair)paramMessage.obj;
      localObject3 = this.bcr;
      this.bcr = ((w)paramMessage.first);
      this.bcG.bcr = this.bcr;
      localObject2 = paramMessage.second;
      if (localObject3 == null)
      {
        if (this.bcP > 0)
        {
          paramMessage = a(this.bcQ);
          i = this.bcP;
          this.bcP = 0;
          this.bcQ = null;
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
          paramMessage = this.bcG.g(j, l2);
          if (!paramMessage.vx()) {
            break;
          }
          l1 = 0L;
          label3482:
          this.bcw = new b(paramMessage, l1, l2);
          d(localObject2, i);
          continue;
          if (this.bcw.bdh == -9223372036854775807L)
          {
            if (this.bcr.isEmpty())
            {
              c(localObject2, 0);
            }
            else
            {
              paramMessage = dJ(0);
              i = ((Integer)paramMessage.first).intValue();
              l2 = ((Long)paramMessage.second).longValue();
              paramMessage = this.bcG.g(i, l2);
              if (!paramMessage.vx()) {
                break label4958;
              }
              l1 = 0L;
              label3592:
              this.bcw = new b(paramMessage, l1, l2);
            }
          }
          else {
            d(localObject2, 0);
          }
        }
      }
      j = this.bcw.bdg.bww;
      if (this.bcU != null)
      {
        paramMessage = this.bcU;
        label3641:
        if ((paramMessage == null) && (j >= ((w)localObject3).tz())) {
          break label3903;
        }
        if (paramMessage != null) {
          break label3724;
        }
      }
      label3724:
      for (localObject1 = ((w)localObject3).a(j, this.bcl, true).bcW;; localObject1 = paramMessage.bcW)
      {
        i = this.bcr.ae(localObject1);
        if (i != -1) {
          break label3913;
        }
        i = a(j, (w)localObject3, this.bcr);
        if (i != -1) {
          break label3733;
        }
        c(localObject2, 0);
        break;
        paramMessage = this.bcS;
        break label3641;
      }
      label3733:
      localObject1 = dJ(this.bcr.a(i, this.bcl, false).bdl);
      i = ((Integer)((Pair)localObject1).first).intValue();
      l1 = ((Long)((Pair)localObject1).second).longValue();
      this.bcr.a(i, this.bcl, true);
      if (paramMessage != null)
      {
        localObject1 = this.bcl.bcW;
        paramMessage.bda = paramMessage.bda.ts();
        while (paramMessage.bdd != null)
        {
          paramMessage = paramMessage.bdd;
          if (paramMessage.bcW.equals(localObject1)) {
            paramMessage.bda = this.bcG.a(paramMessage.bda, i);
          } else {
            paramMessage.bda = paramMessage.bda.ts();
          }
        }
      }
      paramMessage = new com.google.android.exoplayer2.source.i.b(i);
      this.bcw = new b(paramMessage, a(paramMessage, l1));
      for (;;)
      {
        label3903:
        d(localObject2, 0);
        break;
        label3913:
        if (i != j)
        {
          localObject1 = this.bcw;
          localObject3 = new b(((b)localObject1).bdg.eB(i), ((b)localObject1).bdh, ((b)localObject1).bdi);
          ((b)localObject3).bdj = ((b)localObject1).bdj;
          ((b)localObject3).bdk = ((b)localObject1).bdk;
          this.bcw = ((b)localObject3);
        }
        if (this.bcw.bdg.vx())
        {
          localObject1 = this.bcG.g(i, this.bcw.bdi);
          if ((!((com.google.android.exoplayer2.source.i.b)localObject1).vx()) || (((com.google.android.exoplayer2.source.i.b)localObject1).bwy != this.bcw.bdg.bwy))
          {
            l2 = a((com.google.android.exoplayer2.source.i.b)localObject1, this.bcw.bdi);
            if (!((com.google.android.exoplayer2.source.i.b)localObject1).vx()) {
              break label4965;
            }
            l1 = this.bcw.bdi;
            label4066:
            this.bcw = new b((com.google.android.exoplayer2.source.i.b)localObject1, l2, l1);
            continue;
          }
        }
        if (paramMessage != null)
        {
          for (paramMessage = a(paramMessage, i); paramMessage.bdd != null; paramMessage = a((a)localObject1, i))
          {
            localObject1 = paramMessage.bdd;
            i = this.bcr.a(i, this.bcl, this.bck, this.repeatMode);
            if ((i == -1) || (!((a)localObject1).bcW.equals(this.bcr.a(i, this.bcl, true).bcW))) {
              break label4174;
            }
          }
          continue;
          label4174:
          if ((this.bcT == null) || (this.bcT.index >= ((a)localObject1).index)) {
            break label4973;
          }
          i = 1;
          label4198:
          if (i == 0)
          {
            l1 = a(this.bcU.bda.bdK, this.bcw.bdj);
            this.bcw = new b(this.bcU.bda.bdK, l1, this.bcw.bdi);
          }
          else
          {
            this.bcS = paramMessage;
            this.bcS.bdd = null;
            a((a)localObject1);
          }
        }
      }
      paramMessage = (com.google.android.exoplayer2.source.h)paramMessage.obj;
      if (this.bcS != null)
      {
        localObject1 = this.bcS.bcV;
        if (localObject1 == paramMessage) {
          break label4317;
        }
      }
      for (;;)
      {
        AppMethodBeat.o(91924);
        return true;
        label4317:
        tl();
      }
      if (this.bcU != null)
      {
        paramMessage = this.bcU;
        i = 1;
      }
      for (;;)
      {
        if (paramMessage != null)
        {
          bool = paramMessage.bdb;
          if (bool) {}
        }
        else
        {
          AppMethodBeat.o(91924);
          return true;
        }
        if (paramMessage.to()) {
          break;
        }
        if (paramMessage == this.bcT) {
          i = 0;
        }
        paramMessage = paramMessage.bdd;
      }
      if (i != 0)
      {
        if (this.bcT == this.bcU) {
          break label4988;
        }
        bool = true;
        label4404:
        a(this.bcU.bdd);
        this.bcU.bdd = null;
        this.bcS = this.bcU;
        this.bcT = this.bcU;
        localObject1 = new boolean[this.bcf.length];
        l1 = this.bcU.a(this.bcw.bdj, bool, (boolean[])localObject1);
        if (l1 != this.bcw.bdj)
        {
          this.bcw.bdj = l1;
          z(l1);
        }
        j = 0;
        localObject2 = new boolean[this.bcf.length];
        i = 0;
        label4508:
        if (i < this.bcf.length)
        {
          localObject3 = this.bcf[i];
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
      localObject4 = this.bcU.bcX[i];
      k = j;
      if (localObject4 != null) {
        k = j + 1;
      }
      if (localObject2[i] != 0) {
        if (localObject4 != ((r)localObject3).sT())
        {
          if (localObject3 == this.bcH)
          {
            if (localObject4 == null) {
              this.bcD.a(this.bcI);
            }
            this.bcI = null;
            this.bcH = null;
          }
          a((r)localObject3);
          ((r)localObject3).disable();
        }
        else if (localObject1[i] != 0)
        {
          ((r)localObject3).u(this.bcR);
          break label4978;
          this.eventHandler.obtainMessage(3, paramMessage.bde).sendToTarget();
          a((boolean[])localObject2, j);
          for (;;)
          {
            tl();
            ti();
            this.handler.sendEmptyMessage(2);
            break;
            this.bcS = paramMessage;
            for (paramMessage = this.bcS.bdd; paramMessage != null; paramMessage = paramMessage.bdd) {
              paramMessage.release();
            }
            this.bcS.bdd = null;
            if (this.bcS.bdb)
            {
              l1 = this.bcS.bda.bdh;
              paramMessage = this.bcS;
              l1 = Math.max(l1, this.bcR - paramMessage.tm());
              this.bcS.C(l1);
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
    //   69: getfield 167	com/google/android/exoplayer2/i:bcE	Landroid/os/HandlerThread;
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
    private final s[] bcB;
    final m bcC;
    private final com.google.android.exoplayer2.source.i bcJ;
    public final com.google.android.exoplayer2.source.h bcV;
    public final Object bcW;
    public final com.google.android.exoplayer2.source.l[] bcX;
    public final boolean[] bcY;
    public final long bcZ;
    private final r[] bcf;
    private final com.google.android.exoplayer2.g.h bcg;
    public n.a bda;
    public boolean bdb;
    public boolean bdc;
    public a bdd;
    public com.google.android.exoplayer2.g.i bde;
    private com.google.android.exoplayer2.g.i bdf;
    public final int index;
    
    public a(r[] paramArrayOfr, s[] paramArrayOfs, long paramLong, com.google.android.exoplayer2.g.h paramh, m paramm, com.google.android.exoplayer2.source.i parami, Object paramObject, int paramInt, n.a parama)
    {
      AppMethodBeat.i(91909);
      this.bcf = paramArrayOfr;
      this.bcB = paramArrayOfs;
      this.bcZ = paramLong;
      this.bcg = paramh;
      this.bcC = paramm;
      this.bcJ = parami;
      this.bcW = a.checkNotNull(paramObject);
      this.index = paramInt;
      this.bda = parama;
      this.bcX = new com.google.android.exoplayer2.source.l[paramArrayOfr.length];
      this.bcY = new boolean[paramArrayOfr.length];
      paramArrayOfr = parami.a(parama.bdK, paramm.tc());
      if (parama.bdL != -9223372036854775808L)
      {
        paramArrayOfr = new c(paramArrayOfr, true);
        paramArrayOfr.h(0L, parama.bdL);
      }
      for (;;)
      {
        this.bcV = paramArrayOfr;
        AppMethodBeat.o(91909);
        return;
      }
    }
    
    public final void B(long paramLong)
    {
      AppMethodBeat.i(91912);
      long l = tm();
      this.bcV.X(paramLong - l);
      AppMethodBeat.o(91912);
    }
    
    public final long C(long paramLong)
    {
      AppMethodBeat.i(91914);
      paramLong = a(paramLong, false, new boolean[this.bcf.length]);
      AppMethodBeat.o(91914);
      return paramLong;
    }
    
    public final long a(long paramLong, boolean paramBoolean, boolean[] paramArrayOfBoolean)
    {
      AppMethodBeat.i(91915);
      g localg = this.bde.bEE;
      int i = 0;
      if (i < localg.length)
      {
        boolean[] arrayOfBoolean = this.bcY;
        if ((!paramBoolean) && (this.bde.a(this.bdf, i))) {}
        for (int j = 1;; j = 0)
        {
          arrayOfBoolean[i] = j;
          i += 1;
          break;
        }
      }
      paramLong = this.bcV.a(localg.ww(), this.bcY, this.bcX, paramArrayOfBoolean, paramLong);
      this.bdf = this.bde;
      this.bdc = false;
      i = 0;
      if (i < this.bcX.length)
      {
        if (this.bcX[i] != null)
        {
          if (localg.bEB[i] != null) {}
          for (paramBoolean = true;; paramBoolean = false)
          {
            a.checkState(paramBoolean);
            this.bdc = true;
            i += 1;
            break;
          }
        }
        if (localg.bEB[i] == null) {}
        for (paramBoolean = true;; paramBoolean = false)
        {
          a.checkState(paramBoolean);
          break;
        }
      }
      this.bcC.a(this.bcf, localg);
      AppMethodBeat.o(91915);
      return paramLong;
    }
    
    public final void release()
    {
      AppMethodBeat.i(91916);
      try
      {
        if (this.bda.bdL != -9223372036854775808L)
        {
          this.bcJ.b(((c)this.bcV).bcV);
          AppMethodBeat.o(91916);
          return;
        }
        this.bcJ.b(this.bcV);
        AppMethodBeat.o(91916);
        return;
      }
      catch (RuntimeException localRuntimeException)
      {
        AppMethodBeat.o(91916);
      }
    }
    
    public final long tm()
    {
      if (this.index == 0) {
        return this.bcZ;
      }
      return this.bcZ - this.bda.bdh;
    }
    
    public final boolean tn()
    {
      AppMethodBeat.i(91910);
      if ((this.bdb) && ((!this.bdc) || (this.bcV.vk() == -9223372036854775808L)))
      {
        AppMethodBeat.o(91910);
        return true;
      }
      AppMethodBeat.o(91910);
      return false;
    }
    
    public final boolean to()
    {
      AppMethodBeat.i(91913);
      com.google.android.exoplayer2.g.i locali = this.bcg.a(this.bcB, this.bcV.vi());
      if (locali.a(this.bdf))
      {
        AppMethodBeat.o(91913);
        return false;
      }
      this.bde = locali;
      AppMethodBeat.o(91913);
      return true;
    }
    
    public final boolean x(long paramLong)
    {
      AppMethodBeat.i(91911);
      if (!this.bdb) {}
      for (long l1 = 0L; l1 == -9223372036854775808L; l1 = this.bcV.vl())
      {
        AppMethodBeat.o(91911);
        return false;
      }
      long l2 = tm();
      boolean bool = this.bcC.x(l1 - (paramLong - l2));
      AppMethodBeat.o(91911);
      return bool;
    }
  }
  
  public static final class b
  {
    public final com.google.android.exoplayer2.source.i.b bdg;
    public final long bdh;
    public final long bdi;
    public volatile long bdj;
    public volatile long bdk;
    
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
      this.bdg = paramb;
      this.bdh = paramLong1;
      this.bdi = paramLong2;
      this.bdj = paramLong1;
      this.bdk = paramLong1;
    }
  }
  
  static final class c
  {
    public final w bcr;
    public final int bdl;
    public final long bdm;
    
    public c(w paramw, int paramInt, long paramLong)
    {
      this.bcr = paramw;
      this.bdl = paramInt;
      this.bdm = paramLong;
    }
  }
  
  public static final class d
  {
    public final w bcr;
    public final Object bcs;
    public final i.b bcw;
    public final int bdn;
    
    public d(w paramw, Object paramObject, i.b paramb, int paramInt)
    {
      this.bcr = paramw;
      this.bcs = paramObject;
      this.bcw = paramb;
      this.bdn = paramInt;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.google.android.exoplayer2.i
 * JD-Core Version:    0.7.0.1
 */