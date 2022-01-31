package com.google.android.exoplayer2;

import android.os.Handler;
import android.os.Handler.Callback;
import android.os.HandlerThread;
import android.os.Message;
import android.os.SystemClock;
import android.util.Pair;
import com.google.android.exoplayer2.i.v;
import com.tencent.matrix.trace.core.AppMethodBeat;
import java.io.IOException;

final class i
  implements Handler.Callback, com.google.android.exoplayer2.g.h.a, com.google.android.exoplayer2.source.h.a, com.google.android.exoplayer2.source.i.a
{
  private final w.b avC;
  private final w.a avD;
  private boolean avF;
  private w avJ;
  private p avN;
  private i.b avO;
  private final s[] avT;
  private final m avU;
  private final com.google.android.exoplayer2.i.s avV;
  private final HandlerThread avW;
  private final f avX;
  private final n avY;
  private r avZ;
  private final r[] avx;
  private final com.google.android.exoplayer2.g.h avy;
  private com.google.android.exoplayer2.i.i awa;
  private com.google.android.exoplayer2.source.i awb;
  private r[] awc;
  private boolean awd;
  int awe;
  private int awf;
  private long awg;
  private int awh;
  private i.c awi;
  private long awj;
  private i.a awk;
  private i.a awl;
  private i.a awm;
  private final Handler eventHandler;
  final Handler handler;
  private boolean isLoading;
  boolean released;
  private int repeatMode;
  private int state;
  
  public i(r[] paramArrayOfr, com.google.android.exoplayer2.g.h paramh, m paramm, boolean paramBoolean, int paramInt, Handler paramHandler, i.b paramb, f paramf)
  {
    AppMethodBeat.i(94804);
    this.avx = paramArrayOfr;
    this.avy = paramh;
    this.avU = paramm;
    this.avF = paramBoolean;
    this.repeatMode = paramInt;
    this.eventHandler = paramHandler;
    this.state = 1;
    this.avO = paramb;
    this.avX = paramf;
    this.avT = new s[paramArrayOfr.length];
    paramInt = 0;
    while (paramInt < paramArrayOfr.length)
    {
      paramArrayOfr[paramInt].setIndex(paramInt);
      this.avT[paramInt] = paramArrayOfr[paramInt].mx();
      paramInt += 1;
    }
    this.avV = new com.google.android.exoplayer2.i.s();
    this.awc = new r[0];
    this.avC = new w.b();
    this.avD = new w.a();
    this.avY = new n();
    paramh.aYl = this;
    this.avN = p.axk;
    this.avW = new HandlerThread("ExoPlayerImplInternal:Handler", -16);
    this.avW.start();
    this.handler = new Handler(this.avW.getLooper(), this);
    AppMethodBeat.o(94804);
  }
  
  private int a(int paramInt, w paramw1, w paramw2)
  {
    AppMethodBeat.i(94830);
    int m = paramw1.nf();
    int k = 0;
    int i = -1;
    int j = paramInt;
    paramInt = k;
    while ((paramInt < m) && (i == -1))
    {
      j = paramw1.a(j, this.avD, this.avC, this.repeatMode);
      if (j == -1) {
        break;
      }
      i = paramw2.O(paramw1.a(j, this.avD, true).awo);
      paramInt += 1;
    }
    AppMethodBeat.o(94830);
    return i;
  }
  
  private long a(com.google.android.exoplayer2.source.i.b paramb, long paramLong)
  {
    AppMethodBeat.i(94817);
    mN();
    this.awd = false;
    setState(2);
    Object localObject;
    if (this.awm == null)
    {
      if (this.awk == null) {
        break label288;
      }
      this.awk.release();
      localObject = null;
    }
    for (;;)
    {
      if ((this.awm != localObject) || (this.awm != this.awl))
      {
        paramb = this.awc;
        int j = paramb.length;
        int i = 0;
        for (;;)
        {
          if (i < j)
          {
            paramb[i].disable();
            i += 1;
            continue;
            i.a locala1 = this.awm;
            i.a locala2 = null;
            localObject = locala2;
            if (locala1 == null) {
              break;
            }
            if ((locala2 == null) && (a(paramb, paramLong, locala1))) {
              locala2 = locala1;
            }
            for (;;)
            {
              locala1 = locala1.awu;
              break;
              locala1.release();
            }
          }
        }
        this.awc = new r[0];
        this.awa = null;
        this.avZ = null;
        this.awm = null;
      }
      if (localObject != null)
      {
        localObject.awu = null;
        this.awk = localObject;
        this.awl = localObject;
        b(localObject);
        long l = paramLong;
        if (this.awm.awt) {
          l = this.awm.awn.P(paramLong);
        }
        s(l);
        mS();
        paramLong = l;
      }
      for (;;)
      {
        this.handler.sendEmptyMessage(2);
        AppMethodBeat.o(94817);
        return paramLong;
        this.awk = null;
        this.awl = null;
        this.awm = null;
        s(paramLong);
      }
      label288:
      localObject = null;
    }
  }
  
  private Pair<Integer, Long> a(i.c paramc)
  {
    AppMethodBeat.i(94831);
    Object localObject2 = paramc.avJ;
    Object localObject1 = localObject2;
    if (((w)localObject2).isEmpty()) {
      localObject1 = this.avJ;
    }
    try
    {
      localObject2 = ((w)localObject1).a(this.avC, this.avD, paramc.awC, paramc.awD);
      if (this.avJ == localObject1)
      {
        AppMethodBeat.o(94831);
        return localObject2;
      }
    }
    catch (IndexOutOfBoundsException localIndexOutOfBoundsException)
    {
      paramc = new l(this.avJ, paramc.awC, paramc.awD);
      AppMethodBeat.o(94831);
      throw paramc;
    }
    int i = this.avJ.O(localIndexOutOfBoundsException.a(((Integer)((Pair)localObject2).first).intValue(), this.avD, true).awo);
    if (i != -1)
    {
      paramc = Pair.create(Integer.valueOf(i), ((Pair)localObject2).second);
      AppMethodBeat.o(94831);
      return paramc;
    }
    i = a(((Integer)((Pair)localObject2).first).intValue(), localIndexOutOfBoundsException, this.avJ);
    if (i != -1)
    {
      paramc = cV(this.avJ.a(i, this.avD, false).awC);
      AppMethodBeat.o(94831);
      return paramc;
    }
    AppMethodBeat.o(94831);
    return null;
  }
  
  private i.a a(i.a parama, int paramInt)
  {
    AppMethodBeat.i(94827);
    for (;;)
    {
      parama.aws = this.avY.a(parama.aws, paramInt);
      if ((parama.aws.axi) || (parama.awu == null))
      {
        AppMethodBeat.o(94827);
        return parama;
      }
      parama = parama.awu;
    }
  }
  
  private static void a(i.a parama)
  {
    AppMethodBeat.i(94834);
    while (parama != null)
    {
      parama.release();
      parama = parama.awu;
    }
    AppMethodBeat.o(94834);
  }
  
  private static void a(r paramr)
  {
    AppMethodBeat.i(94824);
    if (paramr.getState() == 2) {
      paramr.stop();
    }
    AppMethodBeat.o(94824);
  }
  
  private boolean a(com.google.android.exoplayer2.source.i.b paramb, long paramLong, i.a parama)
  {
    AppMethodBeat.i(94818);
    if ((paramb.equals(parama.aws.axf)) && (parama.prepared))
    {
      this.avJ.a(parama.aws.axf.aPX, this.avD, false);
      int i = this.avD.y(paramLong);
      if ((i == -1) || (this.avD.axM[i] == parama.aws.axg))
      {
        AppMethodBeat.o(94818);
        return true;
      }
    }
    AppMethodBeat.o(94818);
    return false;
  }
  
  private void aD(boolean paramBoolean)
  {
    AppMethodBeat.i(94812);
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
      AppMethodBeat.o(94812);
      return;
    }
  }
  
  private void aE(boolean paramBoolean)
  {
    AppMethodBeat.i(94822);
    this.handler.removeMessages(2);
    this.awd = false;
    this.avV.stop();
    this.awa = null;
    this.avZ = null;
    this.awj = 60000000L;
    Object localObject = this.awc;
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
        this.awc = new r[0];
        if (this.awm != null) {}
        for (localObject = this.awm;; localObject = this.awk)
        {
          a((i.a)localObject);
          this.awk = null;
          this.awl = null;
          this.awm = null;
          aD(false);
          if (paramBoolean)
          {
            if (this.awb != null)
            {
              this.awb.oZ();
              this.awb = null;
            }
            this.avY.avJ = null;
            this.avJ = null;
          }
          AppMethodBeat.o(94822);
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
  
  private void b(i.a parama)
  {
    AppMethodBeat.i(94835);
    if (this.awm == parama)
    {
      AppMethodBeat.o(94835);
      return;
    }
    boolean[] arrayOfBoolean = new boolean[this.avx.length];
    int i = 0;
    int j = 0;
    if (i < this.avx.length)
    {
      r localr = this.avx[i];
      if (localr.getState() != 0) {}
      for (int m = 1;; m = 0)
      {
        arrayOfBoolean[i] = m;
        com.google.android.exoplayer2.g.f localf = parama.awv.aYn.aYk[i];
        int k = j;
        if (localf != null) {
          k = j + 1;
        }
        if ((arrayOfBoolean[i] != 0) && ((localf == null) || ((localr.mC()) && (localr.mz() == this.awm.awp[i]))))
        {
          if (localr == this.avZ)
          {
            this.avV.a(this.awa);
            this.awa = null;
            this.avZ = null;
          }
          a(localr);
          localr.disable();
        }
        i += 1;
        j = k;
        break;
      }
    }
    this.awm = parama;
    this.eventHandler.obtainMessage(3, parama.awv).sendToTarget();
    b(arrayOfBoolean, j);
    AppMethodBeat.o(94835);
  }
  
  private void b(Object paramObject, int paramInt)
  {
    AppMethodBeat.i(94828);
    this.avO = new i.b(0L);
    c(paramObject, paramInt);
    this.avO = new i.b(-9223372036854775807L);
    setState(4);
    aE(false);
    AppMethodBeat.o(94828);
  }
  
  private void b(boolean[] paramArrayOfBoolean, int paramInt)
  {
    AppMethodBeat.i(94836);
    this.awc = new r[paramInt];
    int i = 0;
    paramInt = 0;
    while (paramInt < this.avx.length)
    {
      r localr = this.avx[paramInt];
      Object localObject = this.awm.awv.aYn.aYk[paramInt];
      int j = i;
      if (localObject != null)
      {
        this.awc[i] = localr;
        if (localr.getState() == 0)
        {
          t localt = this.awm.awv.aYo[paramInt];
          if ((this.avF) && (this.state == 3))
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
              arrayOfFormat[k] = ((com.google.android.exoplayer2.g.f)localObject).eg(k);
              k += 1;
            }
            j = 0;
            break;
          }
          localr.a(localt, arrayOfFormat, this.awm.awp[paramInt], this.awj, bool, this.awm.mT());
          localObject = localr.my();
          if (localObject != null)
          {
            if (this.awa != null)
            {
              paramArrayOfBoolean = e.a(new IllegalStateException("Multiple renderer media clocks enabled."));
              AppMethodBeat.o(94836);
              throw paramArrayOfBoolean;
            }
            this.awa = ((com.google.android.exoplayer2.i.i)localObject);
            this.avZ = localr;
            this.awa.c(this.avN);
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
    AppMethodBeat.o(94836);
  }
  
  private void c(Object paramObject, int paramInt)
  {
    AppMethodBeat.i(94829);
    this.eventHandler.obtainMessage(6, new i.d(this.avJ, paramObject, this.avO, paramInt)).sendToTarget();
    AppMethodBeat.o(94829);
  }
  
  /* Error */
  private void c(f.c[] paramArrayOfc)
  {
    // Byte code:
    //   0: ldc_w 509
    //   3: invokestatic 88	com/tencent/matrix/trace/core/AppMethodBeat:i	(I)V
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
    //   23: getfield 515	com/google/android/exoplayer2/f$c:avu	Lcom/google/android/exoplayer2/f$b;
    //   26: aload 4
    //   28: getfield 518	com/google/android/exoplayer2/f$c:avv	I
    //   31: aload 4
    //   33: getfield 521	com/google/android/exoplayer2/f$c:avw	Ljava/lang/Object;
    //   36: invokeinterface 527 3 0
    //   41: iload_2
    //   42: iconst_1
    //   43: iadd
    //   44: istore_2
    //   45: goto -34 -> 11
    //   48: aload_0
    //   49: getfield 102	com/google/android/exoplayer2/i:state	I
    //   52: iconst_3
    //   53: if_icmpeq +11 -> 64
    //   56: aload_0
    //   57: getfield 102	com/google/android/exoplayer2/i:state	I
    //   60: iconst_2
    //   61: if_icmpne +12 -> 73
    //   64: aload_0
    //   65: getfield 177	com/google/android/exoplayer2/i:handler	Landroid/os/Handler;
    //   68: iconst_2
    //   69: invokevirtual 264	android/os/Handler:sendEmptyMessage	(I)Z
    //   72: pop
    //   73: aload_0
    //   74: monitorenter
    //   75: aload_0
    //   76: aload_0
    //   77: getfield 529	com/google/android/exoplayer2/i:awf	I
    //   80: iconst_1
    //   81: iadd
    //   82: putfield 529	com/google/android/exoplayer2/i:awf	I
    //   85: aload_0
    //   86: invokevirtual 532	java/lang/Object:notifyAll	()V
    //   89: aload_0
    //   90: monitorexit
    //   91: ldc_w 509
    //   94: invokestatic 180	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   97: return
    //   98: astore_1
    //   99: aload_0
    //   100: monitorexit
    //   101: ldc_w 509
    //   104: invokestatic 180	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   107: aload_1
    //   108: athrow
    //   109: astore_1
    //   110: aload_0
    //   111: monitorenter
    //   112: aload_0
    //   113: aload_0
    //   114: getfield 529	com/google/android/exoplayer2/i:awf	I
    //   117: iconst_1
    //   118: iadd
    //   119: putfield 529	com/google/android/exoplayer2/i:awf	I
    //   122: aload_0
    //   123: invokevirtual 532	java/lang/Object:notifyAll	()V
    //   126: aload_0
    //   127: monitorexit
    //   128: ldc_w 509
    //   131: invokestatic 180	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   134: aload_1
    //   135: athrow
    //   136: astore_1
    //   137: aload_0
    //   138: monitorexit
    //   139: ldc_w 509
    //   142: invokestatic 180	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
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
  
  private Pair<Integer, Long> cV(int paramInt)
  {
    AppMethodBeat.i(94832);
    Pair localPair = this.avJ.a(this.avC, this.avD, paramInt, -9223372036854775807L);
    AppMethodBeat.o(94832);
    return localPair;
  }
  
  private void e(long paramLong1, long paramLong2)
  {
    AppMethodBeat.i(94816);
    this.handler.removeMessages(2);
    paramLong1 = paramLong1 + paramLong2 - SystemClock.elapsedRealtime();
    if (paramLong1 <= 0L)
    {
      this.handler.sendEmptyMessage(2);
      AppMethodBeat.o(94816);
      return;
    }
    this.handler.sendEmptyMessageDelayed(2, paramLong1);
    AppMethodBeat.o(94816);
  }
  
  private void mM()
  {
    int i = 0;
    AppMethodBeat.i(94813);
    this.awd = false;
    this.avV.start();
    r[] arrayOfr = this.awc;
    int j = arrayOfr.length;
    while (i < j)
    {
      arrayOfr[i].start();
      i += 1;
    }
    AppMethodBeat.o(94813);
  }
  
  private void mN()
  {
    AppMethodBeat.i(94814);
    this.avV.stop();
    r[] arrayOfr = this.awc;
    int j = arrayOfr.length;
    int i = 0;
    while (i < j)
    {
      a(arrayOfr[i]);
      i += 1;
    }
    AppMethodBeat.o(94814);
  }
  
  private void mO()
  {
    AppMethodBeat.i(94815);
    if (this.awm == null)
    {
      AppMethodBeat.o(94815);
      return;
    }
    long l1 = this.awm.awn.oU();
    if (l1 != -9223372036854775807L)
    {
      s(l1);
      this.avO.awA = l1;
      this.awg = (SystemClock.elapsedRealtime() * 1000L);
      if (this.awc.length != 0) {
        break label194;
      }
    }
    label194:
    for (l1 = -9223372036854775808L;; l1 = this.awm.awn.oV())
    {
      Object localObject = this.avO;
      long l2 = l1;
      if (l1 == -9223372036854775808L) {
        l2 = this.awm.aws.axh;
      }
      ((i.b)localObject).awB = l2;
      AppMethodBeat.o(94815);
      return;
      if ((this.avZ != null) && (!this.avZ.nd()))
      {
        this.awj = this.awa.nw();
        this.avV.aa(this.awj);
      }
      for (;;)
      {
        localObject = this.awm;
        l1 = this.awj - ((i.a)localObject).mT();
        break;
        this.awj = this.avV.nw();
      }
    }
  }
  
  private void mP()
  {
    AppMethodBeat.i(94820);
    aE(true);
    this.avU.onStopped();
    setState(1);
    AppMethodBeat.o(94820);
  }
  
  private void mQ()
  {
    AppMethodBeat.i(94821);
    aE(true);
    this.avU.mH();
    setState(1);
    try
    {
      this.released = true;
      notifyAll();
      return;
    }
    finally
    {
      AppMethodBeat.o(94821);
    }
  }
  
  private void mR()
  {
    AppMethodBeat.i(94826);
    if ((this.awk != null) && (!this.awk.prepared) && ((this.awl == null) || (this.awl.awu == this.awk)))
    {
      r[] arrayOfr = this.awc;
      int j = arrayOfr.length;
      int i = 0;
      while (i < j)
      {
        if (!arrayOfr[i].mA())
        {
          AppMethodBeat.o(94826);
          return;
        }
        i += 1;
      }
      this.awk.awn.oS();
    }
    AppMethodBeat.o(94826);
  }
  
  private void mS()
  {
    AppMethodBeat.i(94833);
    boolean bool = this.awk.q(this.awj);
    aD(bool);
    if (bool) {
      this.awk.u(this.awj);
    }
    AppMethodBeat.o(94833);
  }
  
  private void s(long paramLong)
  {
    AppMethodBeat.i(94819);
    if (this.awm == null) {}
    for (paramLong = 60000000L + paramLong;; paramLong = this.awm.mT() + paramLong)
    {
      this.awj = paramLong;
      this.avV.aa(this.awj);
      r[] arrayOfr = this.awc;
      int j = arrayOfr.length;
      int i = 0;
      while (i < j)
      {
        arrayOfr[i].n(this.awj);
        i += 1;
      }
    }
    AppMethodBeat.o(94819);
  }
  
  private void setState(int paramInt)
  {
    AppMethodBeat.i(94811);
    if (this.state != paramInt)
    {
      this.state = paramInt;
      this.eventHandler.obtainMessage(1, paramInt, 0).sendToTarget();
    }
    AppMethodBeat.o(94811);
  }
  
  private boolean t(long paramLong)
  {
    AppMethodBeat.i(94825);
    if ((paramLong == -9223372036854775807L) || (this.avO.awA < paramLong) || ((this.awm.awu != null) && ((this.awm.awu.prepared) || (this.awm.awu.aws.axf.pi()))))
    {
      AppMethodBeat.o(94825);
      return true;
    }
    AppMethodBeat.o(94825);
    return false;
  }
  
  public final void a(com.google.android.exoplayer2.source.h paramh)
  {
    AppMethodBeat.i(94809);
    this.handler.obtainMessage(8, paramh).sendToTarget();
    AppMethodBeat.o(94809);
  }
  
  public final void a(w paramw, int paramInt, long paramLong)
  {
    AppMethodBeat.i(94805);
    this.handler.obtainMessage(3, new i.c(paramw, paramInt, paramLong)).sendToTarget();
    AppMethodBeat.o(94805);
  }
  
  public final void a(w paramw, Object paramObject)
  {
    AppMethodBeat.i(94808);
    this.handler.obtainMessage(7, Pair.create(paramw, paramObject)).sendToTarget();
    AppMethodBeat.o(94808);
  }
  
  /* Error */
  public final void b(f.c... paramVarArgs)
  {
    // Byte code:
    //   0: aload_0
    //   1: monitorenter
    //   2: ldc_w 634
    //   5: invokestatic 88	com/tencent/matrix/trace/core/AppMethodBeat:i	(I)V
    //   8: aload_0
    //   9: getfield 597	com/google/android/exoplayer2/i:released	Z
    //   12: ifeq +12 -> 24
    //   15: ldc_w 634
    //   18: invokestatic 180	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   21: aload_0
    //   22: monitorexit
    //   23: return
    //   24: aload_0
    //   25: getfield 636	com/google/android/exoplayer2/i:awe	I
    //   28: istore_3
    //   29: aload_0
    //   30: iload_3
    //   31: iconst_1
    //   32: iadd
    //   33: putfield 636	com/google/android/exoplayer2/i:awe	I
    //   36: aload_0
    //   37: getfield 177	com/google/android/exoplayer2/i:handler	Landroid/os/Handler;
    //   40: bipush 11
    //   42: aload_1
    //   43: invokevirtual 446	android/os/Handler:obtainMessage	(ILjava/lang/Object;)Landroid/os/Message;
    //   46: invokevirtual 384	android/os/Message:sendToTarget	()V
    //   49: iconst_0
    //   50: istore_2
    //   51: aload_0
    //   52: getfield 529	com/google/android/exoplayer2/i:awf	I
    //   55: istore 4
    //   57: iload 4
    //   59: iload_3
    //   60: if_icmpgt +16 -> 76
    //   63: aload_0
    //   64: invokevirtual 639	java/lang/Object:wait	()V
    //   67: goto -16 -> 51
    //   70: astore_1
    //   71: iconst_1
    //   72: istore_2
    //   73: goto -22 -> 51
    //   76: iload_2
    //   77: ifeq +9 -> 86
    //   80: invokestatic 645	java/lang/Thread:currentThread	()Ljava/lang/Thread;
    //   83: invokevirtual 648	java/lang/Thread:interrupt	()V
    //   86: ldc_w 634
    //   89: invokestatic 180	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
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
    AppMethodBeat.i(94810);
    try
    {
      i = paramMessage.what;
      switch (i)
      {
      default: 
        AppMethodBeat.o(94810);
        return false;
      }
    }
    catch (e paramMessage)
    {
      this.eventHandler.obtainMessage(8, paramMessage).sendToTarget();
      mP();
      AppMethodBeat.o(94810);
      return true;
      if (paramMessage.arg1 == 0) {
        break label300;
      }
      bool = true;
      this.awd = false;
      this.avF = bool;
      if (bool) {
        break label306;
      }
      mN();
      mO();
      for (;;)
      {
        AppMethodBeat.o(94810);
        return true;
        bool = false;
        break;
        if (this.state != 3) {
          break label359;
        }
        mM();
        this.handler.sendEmptyMessage(2);
      }
    }
    catch (IOException paramMessage)
    {
      for (;;)
      {
        this.eventHandler.obtainMessage(8, e.a(paramMessage)).sendToTarget();
        mP();
        AppMethodBeat.o(94810);
        return true;
        if (this.state == 2) {
          this.handler.sendEmptyMessage(2);
        }
      }
    }
    catch (RuntimeException paramMessage)
    {
      this.eventHandler.obtainMessage(8, e.a(paramMessage)).sendToTarget();
      mP();
      AppMethodBeat.o(94810);
      return true;
    }
    Object localObject1 = (com.google.android.exoplayer2.source.i)paramMessage.obj;
    if (paramMessage.arg1 != 0)
    {
      i = 1;
      this.eventHandler.sendEmptyMessage(0);
      aE(true);
      this.avU.mG();
      if (i == 0) {
        break label197;
      }
    }
    label197:
    for (this.avO = new i.b(-9223372036854775807L);; this.avO = new i.b(this.avO.awx, this.avO.awA, this.avO.awz))
    {
      this.awb = ((com.google.android.exoplayer2.source.i)localObject1);
      if (localObject1 != null) {
        ((com.google.android.exoplayer2.source.i)localObject1).a(this.avX, this);
      }
      setState(2);
      this.handler.sendEmptyMessage(2);
      AppMethodBeat.o(94810);
      return true;
      i = 0;
      break;
    }
    label300:
    label306:
    label359:
    int i = paramMessage.arg1;
    this.repeatMode = i;
    this.avY.repeatMode = i;
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
    if (this.awm != null)
    {
      paramMessage = this.awm;
    }
    else
    {
      for (;;)
      {
        j = this.avJ.a(paramMessage.aws.axf.aPX, this.avD, this.avC, i);
        while ((paramMessage.awu != null) && (!paramMessage.aws.axi))
        {
          paramMessage = paramMessage.awu;
          continue;
          paramMessage = this.awk;
          break label4822;
        }
        if ((j == -1) || (paramMessage.awu == null) || (paramMessage.awu.aws.axf.aPX != j)) {
          break;
        }
        paramMessage = paramMessage.awu;
      }
      j = this.awk.index;
      if (this.awl != null)
      {
        i = this.awl.index;
        if (paramMessage.awu != null)
        {
          a(paramMessage.awu);
          paramMessage.awu = null;
        }
        localObject1 = this.avY;
        localObject2 = paramMessage.aws;
        paramMessage.aws = ((n)localObject1).a((n.a)localObject2, ((n.a)localObject2).axf);
        if (j > paramMessage.index) {
          break label708;
        }
        j = 1;
        if (j == 0) {
          this.awk = paramMessage;
        }
        if ((i == -1) || (i > paramMessage.index)) {
          break label713;
        }
      }
      for (i = 1;; i = 0)
      {
        if ((i == 0) && (this.awm != null))
        {
          paramMessage = this.awm.aws.axf;
          this.avO = new i.b(paramMessage, a(paramMessage, this.avO.awA), this.avO.awz);
        }
        AppMethodBeat.o(94810);
        return true;
        i = -1;
        break;
        j = 0;
        break label618;
      }
      long l3 = SystemClock.elapsedRealtime();
      if ((this.avJ == null) && (this.awb != null)) {
        this.awb.oY();
      }
      long l4;
      while (this.awm == null)
      {
        mR();
        e(l3, 10L);
        AppMethodBeat.o(94810);
        return true;
        if (this.awk == null)
        {
          paramMessage = this.avY;
          localObject1 = this.avO;
          paramMessage = paramMessage.a(((i.b)localObject1).awx, ((i.b)localObject1).awz, ((i.b)localObject1).awy);
          if (paramMessage != null) {
            break label1556;
          }
          this.awb.oY();
          if ((this.awk != null) && (!this.awk.mU())) {
            break label1719;
          }
          aD(false);
        }
        for (;;)
        {
          if (this.awm == null) {
            break label1738;
          }
          while ((this.awm != this.awl) && (this.awj >= this.awm.awu.awr))
          {
            this.awm.release();
            b(this.awm.awu);
            this.avO = new i.b(this.awm.aws.axf, this.awm.aws.awy, this.awm.aws.awz);
            mO();
            this.eventHandler.obtainMessage(5, this.avO).sendToTarget();
          }
          if ((this.awk.aws.axj) || (!this.awk.mU()) || (this.awk.aws.axh == -9223372036854775807L) || ((this.awm != null) && (this.awk.index - this.awm.index == 100))) {
            break label825;
          }
          paramMessage = this.avY;
          localObject1 = this.awk.aws;
          l1 = this.awk.mT();
          l2 = this.awj;
          if (((n.a)localObject1).axi)
          {
            i = paramMessage.avJ.a(((n.a)localObject1).axf.aPX, paramMessage.avD, paramMessage.avC, paramMessage.repeatMode);
            if (i == -1)
            {
              paramMessage = null;
              break;
            }
            j = paramMessage.avJ.a(i, paramMessage.avD, false).awC;
            if (paramMessage.avJ.a(j, paramMessage.avC).axW != i) {
              break label4829;
            }
            l4 = ((n.a)localObject1).axh;
            localObject1 = paramMessage.avJ.a(paramMessage.avC, paramMessage.avD, j, -9223372036854775807L, Math.max(0L, l4 + l1 - l2));
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
          localObject2 = ((n.a)localObject1).axf;
          if (((com.google.android.exoplayer2.source.i.b)localObject2).pi())
          {
            i = ((com.google.android.exoplayer2.source.i.b)localObject2).aPY;
            paramMessage.avJ.a(((com.google.android.exoplayer2.source.i.b)localObject2).aPX, paramMessage.avD, false);
            j = paramMessage.avD.axN[i];
            if (j == -1)
            {
              paramMessage = null;
              break;
            }
            k = ((com.google.android.exoplayer2.source.i.b)localObject2).aPZ + 1;
            if (k < j)
            {
              if (!paramMessage.avD.aT(i, k))
              {
                paramMessage = null;
                break;
              }
              paramMessage = paramMessage.b(((com.google.android.exoplayer2.source.i.b)localObject2).aPX, i, k, ((n.a)localObject1).awz);
              break;
            }
            i = paramMessage.avD.y(((n.a)localObject1).awz);
            if (i == -1) {}
            for (l1 = -9223372036854775808L;; l1 = paramMessage.avD.axM[i])
            {
              paramMessage = paramMessage.b(((com.google.android.exoplayer2.source.i.b)localObject2).aPX, ((n.a)localObject1).awz, l1);
              break;
            }
          }
          if (((n.a)localObject1).axg != -9223372036854775808L)
          {
            i = paramMessage.avD.x(((n.a)localObject1).axg);
            if (!paramMessage.avD.aT(i, 0))
            {
              paramMessage = null;
              break;
            }
            paramMessage = paramMessage.b(((com.google.android.exoplayer2.source.i.b)localObject2).aPX, i, 0, ((n.a)localObject1).axg);
            break;
          }
          i = paramMessage.avD.ng();
          if ((i == 0) || (paramMessage.avD.axM[(i - 1)] != -9223372036854775808L) || (paramMessage.avD.cY(i - 1)) || (!paramMessage.avD.aT(i - 1, 0))) {
            break label4835;
          }
          l1 = paramMessage.avD.axh;
          paramMessage = paramMessage.b(((com.google.android.exoplayer2.source.i.b)localObject2).aPX, i - 1, 0, l1);
          break;
          if (this.awk == null)
          {
            l1 = 60000000L;
            if (this.awk != null) {
              break label1706;
            }
          }
          for (i = 0;; i = this.awk.index + 1)
          {
            localObject1 = this.avJ.a(paramMessage.axf.aPX, this.avD, true).awo;
            localObject1 = new i.a(this.avx, this.avT, l1, this.avy, this.avU, this.awb, localObject1, i, paramMessage);
            if (this.awk != null) {
              this.awk.awu = ((i.a)localObject1);
            }
            this.awk = ((i.a)localObject1);
            this.awk.awn.a(this, paramMessage.awy);
            aD(true);
            break;
            l1 = this.awk.mT() + this.awk.aws.axh;
            break label1568;
          }
          if ((this.awk != null) && (!this.isLoading)) {
            mS();
          }
        }
        continue;
        if (!this.awl.aws.axj) {
          break label4847;
        }
        i = 0;
        if (i >= this.avx.length) {
          break label4845;
        }
        paramMessage = this.avx[i];
        localObject1 = this.awl.awp[i];
        if ((localObject1 == null) || (paramMessage.mz() != localObject1) || (!paramMessage.mA())) {
          break label4840;
        }
        paramMessage.mB();
        break label4840;
        if (i < this.avx.length)
        {
          paramMessage = this.avx[i];
          localObject1 = this.awl.awp[i];
          if (paramMessage.mz() == localObject1)
          {
            if (localObject1 == null) {
              break label4852;
            }
            if (paramMessage.mA()) {
              break label4852;
            }
          }
        }
        else if ((this.awl.awu != null) && (this.awl.awu.prepared))
        {
          paramMessage = this.awl.awv;
          this.awl = this.awl.awu;
          localObject1 = this.awl.awv;
          if (this.awl.awn.oU() == -9223372036854775807L) {
            break label4864;
          }
          i = 1;
          break label4859;
          if (j >= this.avx.length) {
            break label4874;
          }
          localObject2 = this.avx[j];
          if (paramMessage.aYn.aYk[j] == null) {
            break label4869;
          }
          if (i == 0)
          {
            if (((r)localObject2).mC()) {
              break label4869;
            }
            localObject3 = localObject1.aYn.aYk[j];
            localObject4 = paramMessage.aYo[j];
            t localt = localObject1.aYo[j];
            if ((localObject3 != null) && (localt.equals(localObject4)))
            {
              localObject4 = new Format[((com.google.android.exoplayer2.g.f)localObject3).length()];
              k = 0;
              while (k < localObject4.length)
              {
                localObject4[k] = ((com.google.android.exoplayer2.g.f)localObject3).eg(k);
                k += 1;
              }
              ((r)localObject2).a((Format[])localObject4, this.awl.awp[j], this.awl.mT());
              break label4869;
            }
          }
          ((r)localObject2).mB();
          break label4869;
        }
      }
      v.beginSection("doSomeWork");
      mO();
      this.awm.awn.O(this.avO.awA);
      i = 1;
      bool = true;
      paramMessage = this.awc;
      int m = paramMessage.length;
      j = 0;
      if (j < m)
      {
        localObject1 = paramMessage[j];
        ((r)localObject1).f(this.awj, this.awg);
        if ((i == 0) || (!((r)localObject1).nd())) {
          break label4902;
        }
        i = 1;
        label2204:
        if (((r)localObject1).isReady()) {
          break label4876;
        }
        if (!((r)localObject1).nd()) {
          break label4907;
        }
        break label4876;
        label2227:
        if (k != 0) {
          break label4882;
        }
        ((r)localObject1).mD();
        break label4882;
      }
      if (!bool) {
        mR();
      }
      if (this.awa != null)
      {
        paramMessage = this.awa.nA();
        if (!paramMessage.equals(this.avN))
        {
          this.avN = paramMessage;
          this.avV.a(this.awa);
          this.eventHandler.obtainMessage(7, paramMessage).sendToTarget();
        }
      }
      l1 = this.awm.aws.axh;
      if ((i != 0) && ((l1 == -9223372036854775807L) || (l1 <= this.avO.awA)) && (this.awm.aws.axj))
      {
        setState(4);
        mN();
      }
      label2368:
      while (this.state == 2)
      {
        paramMessage = this.awc;
        j = paramMessage.length;
        i = 0;
        while (i < j)
        {
          paramMessage[i].mD();
          i += 1;
        }
        if (this.state == 2)
        {
          if (this.awc.length > 0)
          {
            if (!bool) {
              break label4930;
            }
            paramMessage = this.awk;
            bool = this.awd;
            l4 = this.awj;
            if (!paramMessage.prepared)
            {
              l1 = paramMessage.aws.awy;
              l2 = l1;
              if (l1 != -9223372036854775808L) {
                break label2536;
              }
              if (!paramMessage.aws.axj) {
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
            if (!this.avF) {
              break;
            }
            mM();
            break;
            l1 = paramMessage.awn.oV();
            break label2460;
            label2527:
            l2 = paramMessage.aws.axh;
            label2536:
            bool = paramMessage.avU.c(l2 - (l4 - paramMessage.mT()), bool);
            break label4919;
            bool = t(l1);
          }
        }
        if (this.state == 3)
        {
          if (this.awc.length > 0) {}
          for (;;)
          {
            if (bool) {
              break label2623;
            }
            this.awd = this.avF;
            setState(2);
            mN();
            break;
            bool = t(l1);
          }
        }
      }
      label2460:
      label2489:
      label2623:
      if (((this.avF) && (this.state == 3)) || (this.state == 2)) {
        e(l3, 10L);
      }
      for (;;)
      {
        v.endSection();
        break;
        if ((this.awc.length != 0) && (this.state != 4)) {
          e(l3, 1000L);
        } else {
          this.handler.removeMessages(2);
        }
      }
      paramMessage = (i.c)paramMessage.obj;
      if (this.avJ == null)
      {
        this.awh += 1;
        this.awi = paramMessage;
      }
      for (;;)
      {
        AppMethodBeat.o(94810);
        return true;
        localObject1 = a(paramMessage);
        if (localObject1 == null)
        {
          this.avO = new i.b(0L);
          this.eventHandler.obtainMessage(4, 1, 0, this.avO).sendToTarget();
          this.avO = new i.b(-9223372036854775807L);
          setState(4);
          aE(false);
        }
        else
        {
          if (paramMessage.awD == -9223372036854775807L)
          {
            i = 1;
            label2821:
            j = ((Integer)((Pair)localObject1).first).intValue();
            l2 = ((Long)((Pair)localObject1).second).longValue();
            localObject1 = this.avY.g(j, l2);
            bool = ((com.google.android.exoplayer2.source.i.b)localObject1).pi();
            if (!bool) {
              break label4815;
            }
            l1 = 0L;
            i = 1;
          }
          try
          {
            label2875:
            if (((com.google.android.exoplayer2.source.i.b)localObject1).equals(this.avO.awx))
            {
              l3 = l1 / 1000L;
              l4 = this.avO.awA / 1000L;
              if (l3 == l4)
              {
                this.avO = new i.b((com.google.android.exoplayer2.source.i.b)localObject1, l1, l2);
                paramMessage = this.eventHandler;
                if (i != 0) {}
                for (i = 1;; i = 0)
                {
                  paramMessage.obtainMessage(4, i, 0, this.avO).sendToTarget();
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
            this.avO = new i.b((com.google.android.exoplayer2.source.i.b)localObject1, l3, l2);
            paramMessage = this.eventHandler;
            if ((i | j) == 0) {
              break label4941;
            }
            i = 1;
            label3024:
            paramMessage.obtainMessage(4, i, 0, this.avO).sendToTarget();
          }
          finally
          {
            this.avO = new i.b((com.google.android.exoplayer2.source.i.b)localObject1, l1, l2);
            localObject1 = this.eventHandler;
            if (i == 0) {
              break label4946;
            }
          }
        }
      }
      i = 1;
      label3071:
      ((Handler)localObject1).obtainMessage(4, i, 0, this.avO).sendToTarget();
      AppMethodBeat.o(94810);
      throw paramMessage;
      paramMessage = (p)paramMessage.obj;
      if (this.awa != null) {}
      for (paramMessage = this.awa.c(paramMessage);; paramMessage = this.avV.c(paramMessage))
      {
        this.avN = paramMessage;
        this.eventHandler.obtainMessage(7, paramMessage).sendToTarget();
        AppMethodBeat.o(94810);
        return true;
      }
      mP();
      AppMethodBeat.o(94810);
      return true;
      mQ();
      AppMethodBeat.o(94810);
      return true;
      paramMessage = (com.google.android.exoplayer2.source.h)paramMessage.obj;
      if (this.awk != null)
      {
        localObject1 = this.awk.awn;
        if (localObject1 == paramMessage) {
          break label3220;
        }
      }
      for (;;)
      {
        AppMethodBeat.o(94810);
        return true;
        label3220:
        paramMessage = this.awk;
        paramMessage.prepared = true;
        paramMessage.mV();
        l1 = paramMessage.v(paramMessage.aws.awy);
        localObject1 = paramMessage.aws;
        paramMessage.aws = new n.a(((n.a)localObject1).axf, l1, ((n.a)localObject1).axg, ((n.a)localObject1).awz, ((n.a)localObject1).axh, ((n.a)localObject1).axi, ((n.a)localObject1).axj);
        if (this.awm == null)
        {
          this.awl = this.awk;
          s(this.awl.aws.awy);
          b(this.awl);
        }
        mS();
      }
      paramMessage = (Pair)paramMessage.obj;
      localObject3 = this.avJ;
      this.avJ = ((w)paramMessage.first);
      this.avY.avJ = this.avJ;
      localObject2 = paramMessage.second;
      if (localObject3 == null)
      {
        if (this.awh > 0)
        {
          paramMessage = a(this.awi);
          i = this.awh;
          this.awh = 0;
          this.awi = null;
          if (paramMessage == null) {
            b(localObject2, i);
          }
        }
        for (;;)
        {
          AppMethodBeat.o(94810);
          return true;
          j = ((Integer)paramMessage.first).intValue();
          l2 = ((Long)paramMessage.second).longValue();
          paramMessage = this.avY.g(j, l2);
          if (!paramMessage.pi()) {
            break;
          }
          l1 = 0L;
          label3482:
          this.avO = new i.b(paramMessage, l1, l2);
          c(localObject2, i);
          continue;
          if (this.avO.awy == -9223372036854775807L)
          {
            if (this.avJ.isEmpty())
            {
              b(localObject2, 0);
            }
            else
            {
              paramMessage = cV(0);
              i = ((Integer)paramMessage.first).intValue();
              l2 = ((Long)paramMessage.second).longValue();
              paramMessage = this.avY.g(i, l2);
              if (!paramMessage.pi()) {
                break label4958;
              }
              l1 = 0L;
              label3592:
              this.avO = new i.b(paramMessage, l1, l2);
            }
          }
          else {
            c(localObject2, 0);
          }
        }
      }
      j = this.avO.awx.aPX;
      if (this.awm != null)
      {
        paramMessage = this.awm;
        label3641:
        if ((paramMessage == null) && (j >= ((w)localObject3).nf())) {
          break label3903;
        }
        if (paramMessage != null) {
          break label3724;
        }
      }
      label3724:
      for (localObject1 = ((w)localObject3).a(j, this.avD, true).awo;; localObject1 = paramMessage.awo)
      {
        i = this.avJ.O(localObject1);
        if (i != -1) {
          break label3913;
        }
        i = a(j, (w)localObject3, this.avJ);
        if (i != -1) {
          break label3733;
        }
        b(localObject2, 0);
        break;
        paramMessage = this.awk;
        break label3641;
      }
      label3733:
      localObject1 = cV(this.avJ.a(i, this.avD, false).awC);
      i = ((Integer)((Pair)localObject1).first).intValue();
      l1 = ((Long)((Pair)localObject1).second).longValue();
      this.avJ.a(i, this.avD, true);
      if (paramMessage != null)
      {
        localObject1 = this.avD.awo;
        paramMessage.aws = paramMessage.aws.mZ();
        while (paramMessage.awu != null)
        {
          paramMessage = paramMessage.awu;
          if (paramMessage.awo.equals(localObject1)) {
            paramMessage.aws = this.avY.a(paramMessage.aws, i);
          } else {
            paramMessage.aws = paramMessage.aws.mZ();
          }
        }
      }
      paramMessage = new com.google.android.exoplayer2.source.i.b(i);
      this.avO = new i.b(paramMessage, a(paramMessage, l1));
      for (;;)
      {
        label3903:
        c(localObject2, 0);
        break;
        label3913:
        if (i != j)
        {
          localObject1 = this.avO;
          localObject3 = new i.b(((i.b)localObject1).awx.dM(i), ((i.b)localObject1).awy, ((i.b)localObject1).awz);
          ((i.b)localObject3).awA = ((i.b)localObject1).awA;
          ((i.b)localObject3).awB = ((i.b)localObject1).awB;
          this.avO = ((i.b)localObject3);
        }
        if (this.avO.awx.pi())
        {
          localObject1 = this.avY.g(i, this.avO.awz);
          if ((!((com.google.android.exoplayer2.source.i.b)localObject1).pi()) || (((com.google.android.exoplayer2.source.i.b)localObject1).aPZ != this.avO.awx.aPZ))
          {
            l2 = a((com.google.android.exoplayer2.source.i.b)localObject1, this.avO.awz);
            if (!((com.google.android.exoplayer2.source.i.b)localObject1).pi()) {
              break label4965;
            }
            l1 = this.avO.awz;
            label4066:
            this.avO = new i.b((com.google.android.exoplayer2.source.i.b)localObject1, l2, l1);
            continue;
          }
        }
        if (paramMessage != null)
        {
          for (paramMessage = a(paramMessage, i); paramMessage.awu != null; paramMessage = a((i.a)localObject1, i))
          {
            localObject1 = paramMessage.awu;
            i = this.avJ.a(i, this.avD, this.avC, this.repeatMode);
            if ((i == -1) || (!((i.a)localObject1).awo.equals(this.avJ.a(i, this.avD, true).awo))) {
              break label4174;
            }
          }
          continue;
          label4174:
          if ((this.awl == null) || (this.awl.index >= ((i.a)localObject1).index)) {
            break label4973;
          }
          i = 1;
          label4198:
          if (i == 0)
          {
            l1 = a(this.awm.aws.axf, this.avO.awA);
            this.avO = new i.b(this.awm.aws.axf, l1, this.avO.awz);
          }
          else
          {
            this.awk = paramMessage;
            this.awk.awu = null;
            a((i.a)localObject1);
          }
        }
      }
      paramMessage = (com.google.android.exoplayer2.source.h)paramMessage.obj;
      if (this.awk != null)
      {
        localObject1 = this.awk.awn;
        if (localObject1 == paramMessage) {
          break label4317;
        }
      }
      for (;;)
      {
        AppMethodBeat.o(94810);
        return true;
        label4317:
        mS();
      }
      if (this.awm != null)
      {
        paramMessage = this.awm;
        i = 1;
      }
      for (;;)
      {
        if (paramMessage != null)
        {
          bool = paramMessage.prepared;
          if (bool) {}
        }
        else
        {
          AppMethodBeat.o(94810);
          return true;
        }
        if (paramMessage.mV()) {
          break;
        }
        if (paramMessage == this.awl) {
          i = 0;
        }
        paramMessage = paramMessage.awu;
      }
      if (i != 0)
      {
        if (this.awl == this.awm) {
          break label4988;
        }
        bool = true;
        label4404:
        a(this.awm.awu);
        this.awm.awu = null;
        this.awk = this.awm;
        this.awl = this.awm;
        localObject1 = new boolean[this.avx.length];
        l1 = this.awm.a(this.avO.awA, bool, (boolean[])localObject1);
        if (l1 != this.avO.awA)
        {
          this.avO.awA = l1;
          s(l1);
        }
        j = 0;
        localObject2 = new boolean[this.avx.length];
        i = 0;
        label4508:
        if (i < this.avx.length)
        {
          localObject3 = this.avx[i];
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
      localObject4 = this.awm.awp[i];
      k = j;
      if (localObject4 != null) {
        k = j + 1;
      }
      if (localObject2[i] != 0) {
        if (localObject4 != ((r)localObject3).mz())
        {
          if (localObject3 == this.avZ)
          {
            if (localObject4 == null) {
              this.avV.a(this.awa);
            }
            this.awa = null;
            this.avZ = null;
          }
          a((r)localObject3);
          ((r)localObject3).disable();
        }
        else if (localObject1[i] != 0)
        {
          ((r)localObject3).n(this.awj);
          break label4978;
          this.eventHandler.obtainMessage(3, paramMessage.awv).sendToTarget();
          b((boolean[])localObject2, j);
          for (;;)
          {
            mS();
            mO();
            this.handler.sendEmptyMessage(2);
            break;
            this.awk = paramMessage;
            for (paramMessage = this.awk.awu; paramMessage != null; paramMessage = paramMessage.awu) {
              paramMessage.release();
            }
            this.awk.awu = null;
            if (this.awk.prepared)
            {
              l1 = this.awk.aws.awy;
              paramMessage = this.awk;
              l1 = Math.max(l1, this.awj - paramMessage.mT());
              this.awk.v(l1);
            }
          }
          c((f.c[])paramMessage.obj);
          AppMethodBeat.o(94810);
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
    //   5: invokestatic 88	com/tencent/matrix/trace/core/AppMethodBeat:i	(I)V
    //   8: aload_0
    //   9: getfield 597	com/google/android/exoplayer2/i:released	Z
    //   12: ifeq +12 -> 24
    //   15: ldc_w 872
    //   18: invokestatic 180	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   21: aload_0
    //   22: monitorexit
    //   23: return
    //   24: aload_0
    //   25: getfield 177	com/google/android/exoplayer2/i:handler	Landroid/os/Handler;
    //   28: bipush 6
    //   30: invokevirtual 264	android/os/Handler:sendEmptyMessage	(I)Z
    //   33: pop
    //   34: iconst_0
    //   35: istore_1
    //   36: aload_0
    //   37: getfield 597	com/google/android/exoplayer2/i:released	Z
    //   40: istore_2
    //   41: iload_2
    //   42: ifne +16 -> 58
    //   45: aload_0
    //   46: invokevirtual 639	java/lang/Object:wait	()V
    //   49: goto -13 -> 36
    //   52: astore_3
    //   53: iconst_1
    //   54: istore_1
    //   55: goto -19 -> 36
    //   58: iload_1
    //   59: ifeq +9 -> 68
    //   62: invokestatic 645	java/lang/Thread:currentThread	()Ljava/lang/Thread;
    //   65: invokevirtual 648	java/lang/Thread:interrupt	()V
    //   68: aload_0
    //   69: getfield 163	com/google/android/exoplayer2/i:avW	Landroid/os/HandlerThread;
    //   72: invokevirtual 875	android/os/HandlerThread:quit	()Z
    //   75: pop
    //   76: ldc_w 872
    //   79: invokestatic 180	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
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
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes8.jar
 * Qualified Name:     com.google.android.exoplayer2.i
 * JD-Core Version:    0.7.0.1
 */