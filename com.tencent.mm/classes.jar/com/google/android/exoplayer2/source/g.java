package com.google.android.exoplayer2.source;

import android.net.Uri;
import android.os.Handler;
import com.google.android.exoplayer2.Format;
import com.google.android.exoplayer2.h.b;
import com.google.android.exoplayer2.h.t;
import com.google.android.exoplayer2.h.t.a;
import com.google.android.exoplayer2.h.t.c;
import com.google.android.exoplayer2.h.t.d;
import com.google.android.exoplayer2.i.a;
import com.tencent.matrix.trace.core.AppMethodBeat;
import java.io.IOException;
import java.util.Arrays;

final class g
  implements com.google.android.exoplayer2.c.g, t.a<a>, t.d, j, m.b
{
  boolean bcY;
  long bdJ;
  private final com.google.android.exoplayer2.h.g bhK;
  private final int bvE;
  final h.a bvF;
  final c bvG;
  private final b bvH;
  final String bvI;
  final long bvJ;
  final t bvK;
  private final b bvL;
  final com.google.android.exoplayer2.i.f bvM;
  private final Runnable bvN;
  final Runnable bvO;
  com.google.android.exoplayer2.c.l bvP;
  m[] bvQ;
  private int[] bvR;
  boolean bvS;
  private boolean bvT;
  boolean bvU;
  private int bvV;
  r bvW;
  boolean[] bvX;
  boolean[] bvY;
  boolean bvZ;
  j.a bvs;
  long bwa;
  private long bwb;
  private int bwc;
  boolean bwd;
  private final Handler eventHandler;
  final Handler handler;
  private long length;
  boolean released;
  private final Uri uri;
  
  public g(Uri paramUri, com.google.android.exoplayer2.h.g paramg, com.google.android.exoplayer2.c.e[] paramArrayOfe, int paramInt1, Handler paramHandler, h.a parama, c paramc, b paramb, String paramString, int paramInt2)
  {
    AppMethodBeat.i(92652);
    this.uri = paramUri;
    this.bhK = paramg;
    this.bvE = paramInt1;
    this.eventHandler = paramHandler;
    this.bvF = parama;
    this.bvG = paramc;
    this.bvH = paramb;
    this.bvI = paramString;
    this.bvJ = paramInt2;
    this.bvK = new t("Loader:ExtractorMediaPeriod");
    this.bvL = new b(paramArrayOfe, this);
    this.bvM = new com.google.android.exoplayer2.i.f();
    this.bvN = new Runnable()
    {
      public final void run()
      {
        AppMethodBeat.i(92643);
        g localg = g.this;
        if ((localg.released) || (localg.bcY) || (localg.bvP == null) || (!localg.bvS))
        {
          AppMethodBeat.o(92643);
          return;
        }
        Object localObject1 = localg.bvQ;
        int j = localObject1.length;
        int i = 0;
        while (i < j)
        {
          if (localObject1[i].bwO.vG() == null) {
            break label296;
          }
          i += 1;
        }
        localg.bvM.close();
        j = localg.bvQ.length;
        localObject1 = new q[j];
        localg.bvY = new boolean[j];
        localg.bvX = new boolean[j];
        localg.bdJ = localg.bvP.getDurationUs();
        i = 0;
        if (i < j)
        {
          Object localObject2 = localg.bvQ[i].bwO.vG();
          localObject1[i] = new q(new Format[] { localObject2 });
          localObject2 = ((Format)localObject2).bdq;
          if ((com.google.android.exoplayer2.i.j.by((String)localObject2)) || (com.google.android.exoplayer2.i.j.bx((String)localObject2))) {}
          for (int k = 1;; k = 0)
          {
            localg.bvY[i] = k;
            localg.bvZ = (k | localg.bvZ);
            i += 1;
            break;
          }
        }
        localg.bvW = new r((q[])localObject1);
        localg.bcY = true;
        localg.bvG.d(localg.bdJ, localg.bvP.uu());
        localg.bvs.a(localg);
        label296:
        AppMethodBeat.o(92643);
      }
    };
    this.bvO = new Runnable()
    {
      public final void run()
      {
        AppMethodBeat.i(92644);
        if (!g.this.released) {
          g.this.bvs.a(g.this);
        }
        AppMethodBeat.o(92644);
      }
    };
    this.handler = new Handler();
    this.bvR = new int[0];
    this.bvQ = new m[0];
    this.bwb = -9223372036854775807L;
    this.length = -1L;
    AppMethodBeat.o(92652);
  }
  
  private boolean Z(long paramLong)
  {
    AppMethodBeat.i(92666);
    int j = this.bvQ.length;
    int i = 0;
    while (i < j)
    {
      m localm = this.bvQ[i];
      localm.rewind();
      if ((!localm.f(paramLong, false)) && ((this.bvY[i] != 0) || (!this.bvZ)))
      {
        AppMethodBeat.o(92666);
        return false;
      }
      localm.vK();
      i += 1;
    }
    AppMethodBeat.o(92666);
    return true;
  }
  
  private void a(a parama)
  {
    if (this.length == -1L) {
      this.length = parama.length;
    }
  }
  
  private void startLoading()
  {
    AppMethodBeat.i(92665);
    a locala = new a(this.uri, this.bhK, this.bvL, this.bvM);
    if (this.bcY)
    {
      a.checkState(vz());
      if ((this.bdJ != -9223372036854775807L) && (this.bwb >= this.bdJ))
      {
        this.bwd = true;
        this.bwb = -9223372036854775807L;
        AppMethodBeat.o(92665);
        return;
      }
      locala.i(this.bvP.L(this.bwb), this.bwb);
      this.bwb = -9223372036854775807L;
    }
    this.bwc = vx();
    int j = this.bvE;
    int i = j;
    if (j == -1) {
      if ((this.bcY) && (this.length == -1L) && ((this.bvP == null) || (this.bvP.getDurationUs() == -9223372036854775807L))) {
        break label193;
      }
    }
    label193:
    for (i = 3;; i = 6)
    {
      this.bvK.a(locala, this, i);
      AppMethodBeat.o(92665);
      return;
    }
  }
  
  private int vx()
  {
    AppMethodBeat.i(92667);
    m[] arrayOfm = this.bvQ;
    int k = arrayOfm.length;
    int j = 0;
    int m;
    for (int i = 0; j < k; i = m + i)
    {
      m = arrayOfm[j].bwO.vD();
      j += 1;
    }
    AppMethodBeat.o(92667);
    return i;
  }
  
  private long vy()
  {
    AppMethodBeat.i(92668);
    long l = -9223372036854775808L;
    m[] arrayOfm = this.bvQ;
    int j = arrayOfm.length;
    int i = 0;
    while (i < j)
    {
      l = Math.max(l, arrayOfm[i].bwO.vy());
      i += 1;
    }
    AppMethodBeat.o(92668);
    return l;
  }
  
  public final void V(long paramLong)
  {
    AppMethodBeat.i(92656);
    int j = this.bvQ.length;
    int i = 0;
    while (i < j)
    {
      this.bvQ[i].h(paramLong, this.bvX[i]);
      i += 1;
    }
    AppMethodBeat.o(92656);
  }
  
  public final long W(long paramLong)
  {
    AppMethodBeat.i(92660);
    if (this.bvP.uu()) {}
    for (;;)
    {
      this.bwa = paramLong;
      this.bvU = false;
      if ((vz()) || (!Z(paramLong))) {
        break;
      }
      AppMethodBeat.o(92660);
      return paramLong;
      paramLong = 0L;
    }
    this.bwb = paramLong;
    this.bwd = false;
    if (this.bvK.isLoading()) {
      this.bvK.cancelLoading();
    }
    for (;;)
    {
      AppMethodBeat.o(92660);
      return paramLong;
      m[] arrayOfm = this.bvQ;
      int j = arrayOfm.length;
      int i = 0;
      while (i < j)
      {
        arrayOfm[i].reset(false);
        i += 1;
      }
    }
  }
  
  public final boolean X(long paramLong)
  {
    AppMethodBeat.i(92657);
    if ((this.bwd) || ((this.bcY) && (this.bvV == 0)))
    {
      AppMethodBeat.o(92657);
      return false;
    }
    boolean bool = this.bvM.open();
    if (!this.bvK.isLoading())
    {
      startLoading();
      bool = true;
    }
    AppMethodBeat.o(92657);
    return bool;
  }
  
  public final long a(com.google.android.exoplayer2.g.f[] paramArrayOff, boolean[] paramArrayOfBoolean1, n[] paramArrayOfn, boolean[] paramArrayOfBoolean2, long paramLong)
  {
    int m = 0;
    int k = 0;
    AppMethodBeat.i(92655);
    a.checkState(this.bcY);
    int j = this.bvV;
    int i = 0;
    int n;
    while (i < paramArrayOff.length)
    {
      if ((paramArrayOfn[i] != null) && ((paramArrayOff[i] == null) || (paramArrayOfBoolean1[i] == 0)))
      {
        n = ((d)paramArrayOfn[i]).track;
        a.checkState(this.bvX[n]);
        this.bvV -= 1;
        this.bvX[n] = false;
        paramArrayOfn[i] = null;
      }
      i += 1;
    }
    label128:
    boolean bool;
    if (this.bvT) {
      if (j == 0)
      {
        i = 1;
        j = 0;
        if (j >= paramArrayOff.length) {
          break label359;
        }
        if ((paramArrayOfn[j] != null) || (paramArrayOff[j] == null)) {
          break label536;
        }
        paramArrayOfBoolean1 = paramArrayOff[j];
        if (paramArrayOfBoolean1.length() != 1) {
          break label335;
        }
        bool = true;
        label167:
        a.checkState(bool);
        if (paramArrayOfBoolean1.eV(0) != 0) {
          break label341;
        }
        bool = true;
        label185:
        a.checkState(bool);
        n = this.bvW.a(paramArrayOfBoolean1.wy());
        if (this.bvX[n] != 0) {
          break label347;
        }
        bool = true;
        label218:
        a.checkState(bool);
        this.bvV += 1;
        this.bvX[n] = true;
        paramArrayOfn[j] = new d(n);
        paramArrayOfBoolean2[j] = true;
        if (i != 0) {
          break label536;
        }
        paramArrayOfBoolean1 = this.bvQ[n];
        paramArrayOfBoolean1.rewind();
        if ((paramArrayOfBoolean1.f(paramLong, true)) || (paramArrayOfBoolean1.bwO.vE() == 0)) {
          break label353;
        }
        i = 1;
      }
    }
    label536:
    for (;;)
    {
      j += 1;
      break label128;
      i = 0;
      break;
      if (paramLong != 0L)
      {
        i = 1;
        break;
      }
      i = 0;
      break;
      label335:
      bool = false;
      break label167;
      label341:
      bool = false;
      break label185;
      label347:
      bool = false;
      break label218;
      label353:
      i = 0;
      continue;
      label359:
      long l;
      if (this.bvV == 0)
      {
        this.bvU = false;
        if (this.bvK.isLoading())
        {
          paramArrayOff = this.bvQ;
          j = paramArrayOff.length;
          i = k;
          while (i < j)
          {
            paramArrayOff[i].vL();
            i += 1;
          }
          this.bvK.cancelLoading();
          l = paramLong;
        }
      }
      do
      {
        this.bvT = true;
        AppMethodBeat.o(92655);
        return l;
        paramArrayOff = this.bvQ;
        j = paramArrayOff.length;
        i = 0;
        for (;;)
        {
          l = paramLong;
          if (i >= j) {
            break;
          }
          paramArrayOff[i].reset(false);
          i += 1;
        }
        l = paramLong;
      } while (i == 0);
      paramLong = W(paramLong);
      i = m;
      for (;;)
      {
        l = paramLong;
        if (i >= paramArrayOfn.length) {
          break;
        }
        if (paramArrayOfn[i] != null) {
          paramArrayOfBoolean2[i] = true;
        }
        i += 1;
      }
    }
  }
  
  public final void a(com.google.android.exoplayer2.c.l paraml)
  {
    AppMethodBeat.i(92663);
    this.bvP = paraml;
    this.handler.post(this.bvN);
    AppMethodBeat.o(92663);
  }
  
  public final void a(j.a parama, long paramLong)
  {
    AppMethodBeat.i(92654);
    this.bvs = parama;
    this.bvM.open();
    startLoading();
    AppMethodBeat.o(92654);
  }
  
  public final com.google.android.exoplayer2.c.m dV(int paramInt)
  {
    AppMethodBeat.i(196042);
    int j = this.bvQ.length;
    int i = 0;
    while (i < j)
    {
      if (this.bvR[i] == paramInt)
      {
        localm = this.bvQ[i];
        AppMethodBeat.o(196042);
        return localm;
      }
      i += 1;
    }
    m localm = new m(this.bvH);
    localm.bwY = this;
    this.bvR = Arrays.copyOf(this.bvR, j + 1);
    this.bvR[j] = paramInt;
    this.bvQ = ((m[])Arrays.copyOf(this.bvQ, j + 1));
    this.bvQ[j] = localm;
    AppMethodBeat.o(196042);
    return localm;
  }
  
  public final void uy()
  {
    AppMethodBeat.i(92662);
    this.bvS = true;
    this.handler.post(this.bvN);
    AppMethodBeat.o(92662);
  }
  
  public final void vn() {}
  
  public final r vo()
  {
    return this.bvW;
  }
  
  public final long vp()
  {
    if (this.bvU)
    {
      this.bvU = false;
      return this.bwa;
    }
    return -9223372036854775807L;
  }
  
  public final long vq()
  {
    AppMethodBeat.i(92659);
    if (this.bwd)
    {
      AppMethodBeat.o(92659);
      return -9223372036854775808L;
    }
    long l1;
    if (vz())
    {
      l1 = this.bwb;
      AppMethodBeat.o(92659);
      return l1;
    }
    if (this.bvZ)
    {
      l1 = 9223372036854775807L;
      int j = this.bvQ.length;
      int i = 0;
      for (;;)
      {
        l2 = l1;
        if (i >= j) {
          break;
        }
        l2 = l1;
        if (this.bvY[i] != 0) {
          l2 = Math.min(l1, this.bvQ[i].bwO.vy());
        }
        i += 1;
        l1 = l2;
      }
    }
    long l2 = vy();
    if (l2 == -9223372036854775808L)
    {
      l1 = this.bwa;
      AppMethodBeat.o(92659);
      return l1;
    }
    AppMethodBeat.o(92659);
    return l2;
  }
  
  public final long vr()
  {
    AppMethodBeat.i(92658);
    if (this.bvV == 0)
    {
      AppMethodBeat.o(92658);
      return -9223372036854775808L;
    }
    long l = vq();
    AppMethodBeat.o(92658);
    return l;
  }
  
  public final void vv()
  {
    AppMethodBeat.i(92653);
    Object localObject = this.bvL;
    if (((b)localObject).bwk != null) {
      ((b)localObject).bwk = null;
    }
    localObject = this.bvQ;
    int j = localObject.length;
    int i = 0;
    while (i < j)
    {
      localObject[i].reset(false);
      i += 1;
    }
    AppMethodBeat.o(92653);
  }
  
  public final void vw()
  {
    AppMethodBeat.i(92664);
    this.handler.post(this.bvN);
    AppMethodBeat.o(92664);
  }
  
  final boolean vz()
  {
    return this.bwb != -9223372036854775807L;
  }
  
  final class a
    implements t.c
  {
    private final com.google.android.exoplayer2.h.g bhK;
    private final g.b bvL;
    private final com.google.android.exoplayer2.i.f bvM;
    private final com.google.android.exoplayer2.c.k bwf;
    private volatile boolean bwg;
    private boolean bwh;
    private long bwi;
    long length;
    private final Uri uri;
    
    public a(Uri paramUri, com.google.android.exoplayer2.h.g paramg, g.b paramb, com.google.android.exoplayer2.i.f paramf)
    {
      AppMethodBeat.i(92646);
      this.uri = ((Uri)a.checkNotNull(paramUri));
      this.bhK = ((com.google.android.exoplayer2.h.g)a.checkNotNull(paramg));
      this.bvL = ((g.b)a.checkNotNull(paramb));
      this.bvM = paramf;
      this.bwf = new com.google.android.exoplayer2.c.k();
      this.bwh = true;
      this.length = -1L;
      AppMethodBeat.o(92646);
    }
    
    public final void i(long paramLong1, long paramLong2)
    {
      this.bwf.position = paramLong1;
      this.bwi = paramLong2;
      this.bwh = true;
    }
    
    public final void vA()
    {
      this.bwg = true;
    }
    
    public final boolean vB()
    {
      return this.bwg;
    }
    
    /* Error */
    public final void vC()
    {
      // Byte code:
      //   0: ldc 89
      //   2: invokestatic 41	com/tencent/matrix/trace/core/AppMethodBeat:i	(I)V
      //   5: iconst_0
      //   6: istore_1
      //   7: iload_1
      //   8: ifne +305 -> 313
      //   11: aload_0
      //   12: getfield 85	com/google/android/exoplayer2/source/g$a:bwg	Z
      //   15: ifne +298 -> 313
      //   18: aload_0
      //   19: getfield 66	com/google/android/exoplayer2/source/g$a:bwf	Lcom/google/android/exoplayer2/c/k;
      //   22: getfield 80	com/google/android/exoplayer2/c/k:position	J
      //   25: lstore_3
      //   26: aload_0
      //   27: aload_0
      //   28: getfield 55	com/google/android/exoplayer2/source/g$a:bhK	Lcom/google/android/exoplayer2/h/g;
      //   31: new 91	com/google/android/exoplayer2/h/j
      //   34: dup
      //   35: aload_0
      //   36: getfield 51	com/google/android/exoplayer2/source/g$a:uri	Landroid/net/Uri;
      //   39: lload_3
      //   40: ldc2_w 69
      //   43: aload_0
      //   44: getfield 31	com/google/android/exoplayer2/source/g$a:bwe	Lcom/google/android/exoplayer2/source/g;
      //   47: getfield 95	com/google/android/exoplayer2/source/g:bvI	Ljava/lang/String;
      //   50: invokespecial 98	com/google/android/exoplayer2/h/j:<init>	(Landroid/net/Uri;JJLjava/lang/String;)V
      //   53: invokeinterface 101 2 0
      //   58: putfield 72	com/google/android/exoplayer2/source/g$a:length	J
      //   61: aload_0
      //   62: getfield 72	com/google/android/exoplayer2/source/g$a:length	J
      //   65: ldc2_w 69
      //   68: lcmp
      //   69: ifeq +13 -> 82
      //   72: aload_0
      //   73: aload_0
      //   74: getfield 72	com/google/android/exoplayer2/source/g$a:length	J
      //   77: lload_3
      //   78: ladd
      //   79: putfield 72	com/google/android/exoplayer2/source/g$a:length	J
      //   82: new 103	com/google/android/exoplayer2/c/b
      //   85: dup
      //   86: aload_0
      //   87: getfield 55	com/google/android/exoplayer2/source/g$a:bhK	Lcom/google/android/exoplayer2/h/g;
      //   90: lload_3
      //   91: aload_0
      //   92: getfield 72	com/google/android/exoplayer2/source/g$a:length	J
      //   95: invokespecial 106	com/google/android/exoplayer2/c/b:<init>	(Lcom/google/android/exoplayer2/h/g;JJ)V
      //   98: astore 5
      //   100: aload_0
      //   101: getfield 59	com/google/android/exoplayer2/source/g$a:bvL	Lcom/google/android/exoplayer2/source/g$b;
      //   104: aload 5
      //   106: aload_0
      //   107: getfield 55	com/google/android/exoplayer2/source/g$a:bhK	Lcom/google/android/exoplayer2/h/g;
      //   110: invokeinterface 110 1 0
      //   115: invokevirtual 113	com/google/android/exoplayer2/source/g$b:a	(Lcom/google/android/exoplayer2/c/f;Landroid/net/Uri;)Lcom/google/android/exoplayer2/c/e;
      //   118: astore 6
      //   120: aload_0
      //   121: getfield 68	com/google/android/exoplayer2/source/g$a:bwh	Z
      //   124: ifeq +20 -> 144
      //   127: aload 6
      //   129: lload_3
      //   130: aload_0
      //   131: getfield 82	com/google/android/exoplayer2/source/g$a:bwi	J
      //   134: invokeinterface 118 5 0
      //   139: aload_0
      //   140: iconst_0
      //   141: putfield 68	com/google/android/exoplayer2/source/g$a:bwh	Z
      //   144: iload_1
      //   145: ifne +90 -> 235
      //   148: aload_0
      //   149: getfield 85	com/google/android/exoplayer2/source/g$a:bwg	Z
      //   152: ifne +83 -> 235
      //   155: aload_0
      //   156: getfield 61	com/google/android/exoplayer2/source/g$a:bvM	Lcom/google/android/exoplayer2/i/f;
      //   159: invokevirtual 123	com/google/android/exoplayer2/i/f:block	()V
      //   162: aload 6
      //   164: aload 5
      //   166: aload_0
      //   167: getfield 66	com/google/android/exoplayer2/source/g$a:bwf	Lcom/google/android/exoplayer2/c/k;
      //   170: invokeinterface 126 3 0
      //   175: istore_2
      //   176: iload_2
      //   177: istore_1
      //   178: aload 5
      //   180: invokeinterface 132 1 0
      //   185: aload_0
      //   186: getfield 31	com/google/android/exoplayer2/source/g$a:bwe	Lcom/google/android/exoplayer2/source/g;
      //   189: getfield 135	com/google/android/exoplayer2/source/g:bvJ	J
      //   192: lload_3
      //   193: ladd
      //   194: lcmp
      //   195: ifle +171 -> 366
      //   198: aload 5
      //   200: invokeinterface 132 1 0
      //   205: lstore_3
      //   206: aload_0
      //   207: getfield 61	com/google/android/exoplayer2/source/g$a:bvM	Lcom/google/android/exoplayer2/i/f;
      //   210: invokevirtual 138	com/google/android/exoplayer2/i/f:close	()Z
      //   213: pop
      //   214: aload_0
      //   215: getfield 31	com/google/android/exoplayer2/source/g$a:bwe	Lcom/google/android/exoplayer2/source/g;
      //   218: getfield 142	com/google/android/exoplayer2/source/g:handler	Landroid/os/Handler;
      //   221: aload_0
      //   222: getfield 31	com/google/android/exoplayer2/source/g$a:bwe	Lcom/google/android/exoplayer2/source/g;
      //   225: getfield 146	com/google/android/exoplayer2/source/g:bvO	Ljava/lang/Runnable;
      //   228: invokevirtual 152	android/os/Handler:post	(Ljava/lang/Runnable;)Z
      //   231: pop
      //   232: goto -88 -> 144
      //   235: iload_1
      //   236: iconst_1
      //   237: if_icmpne +15 -> 252
      //   240: iconst_0
      //   241: istore_1
      //   242: aload_0
      //   243: getfield 55	com/google/android/exoplayer2/source/g$a:bhK	Lcom/google/android/exoplayer2/h/g;
      //   246: invokestatic 157	com/google/android/exoplayer2/i/x:a	(Lcom/google/android/exoplayer2/h/g;)V
      //   249: goto -242 -> 7
      //   252: aload_0
      //   253: getfield 66	com/google/android/exoplayer2/source/g$a:bwf	Lcom/google/android/exoplayer2/c/k;
      //   256: aload 5
      //   258: invokeinterface 132 1 0
      //   263: putfield 80	com/google/android/exoplayer2/c/k:position	J
      //   266: goto -24 -> 242
      //   269: astore 5
      //   271: aconst_null
      //   272: astore 6
      //   274: iload_1
      //   275: iconst_1
      //   276: if_icmpeq +22 -> 298
      //   279: aload 6
      //   281: ifnull +17 -> 298
      //   284: aload_0
      //   285: getfield 66	com/google/android/exoplayer2/source/g$a:bwf	Lcom/google/android/exoplayer2/c/k;
      //   288: aload 6
      //   290: invokeinterface 132 1 0
      //   295: putfield 80	com/google/android/exoplayer2/c/k:position	J
      //   298: aload_0
      //   299: getfield 55	com/google/android/exoplayer2/source/g$a:bhK	Lcom/google/android/exoplayer2/h/g;
      //   302: invokestatic 157	com/google/android/exoplayer2/i/x:a	(Lcom/google/android/exoplayer2/h/g;)V
      //   305: ldc 89
      //   307: invokestatic 75	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
      //   310: aload 5
      //   312: athrow
      //   313: ldc 89
      //   315: invokestatic 75	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
      //   318: return
      //   319: astore 6
      //   321: aload 5
      //   323: astore 7
      //   325: aload 6
      //   327: astore 5
      //   329: aload 7
      //   331: astore 6
      //   333: goto -59 -> 274
      //   336: astore 7
      //   338: aload 5
      //   340: astore 6
      //   342: aload 7
      //   344: astore 5
      //   346: goto -72 -> 274
      //   349: astore 6
      //   351: aload 5
      //   353: astore 7
      //   355: aload 6
      //   357: astore 5
      //   359: aload 7
      //   361: astore 6
      //   363: goto -89 -> 274
      //   366: goto -222 -> 144
      // Local variable table:
      //   start	length	slot	name	signature
      //   0	369	0	this	a
      //   6	271	1	i	int
      //   175	2	2	j	int
      //   25	181	3	l	long
      //   98	159	5	localb	com.google.android.exoplayer2.c.b
      //   269	53	5	localObject1	Object
      //   327	31	5	localObject2	Object
      //   118	171	6	locale	com.google.android.exoplayer2.c.e
      //   319	7	6	localObject3	Object
      //   331	10	6	localObject4	Object
      //   349	7	6	localObject5	Object
      //   361	1	6	localObject6	Object
      //   323	7	7	localObject7	Object
      //   336	7	7	localObject8	Object
      //   353	7	7	localObject9	Object
      // Exception table:
      //   from	to	target	type
      //   18	82	269	finally
      //   82	100	269	finally
      //   100	144	319	finally
      //   148	176	336	finally
      //   178	232	349	finally
    }
  }
  
  static final class b
  {
    private final com.google.android.exoplayer2.c.g bir;
    private final com.google.android.exoplayer2.c.e[] bwj;
    com.google.android.exoplayer2.c.e bwk;
    
    public b(com.google.android.exoplayer2.c.e[] paramArrayOfe, com.google.android.exoplayer2.c.g paramg)
    {
      this.bwj = paramArrayOfe;
      this.bir = paramg;
    }
    
    /* Error */
    public final com.google.android.exoplayer2.c.e a(com.google.android.exoplayer2.c.f paramf, Uri paramUri)
    {
      // Byte code:
      //   0: ldc 28
      //   2: invokestatic 34	com/tencent/matrix/trace/core/AppMethodBeat:i	(I)V
      //   5: aload_0
      //   6: getfield 36	com/google/android/exoplayer2/source/g$b:bwk	Lcom/google/android/exoplayer2/c/e;
      //   9: ifnull +15 -> 24
      //   12: aload_0
      //   13: getfield 36	com/google/android/exoplayer2/source/g$b:bwk	Lcom/google/android/exoplayer2/c/e;
      //   16: astore_1
      //   17: ldc 28
      //   19: invokestatic 39	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
      //   22: aload_1
      //   23: areturn
      //   24: aload_0
      //   25: getfield 20	com/google/android/exoplayer2/source/g$b:bwj	[Lcom/google/android/exoplayer2/c/e;
      //   28: astore 5
      //   30: aload 5
      //   32: arraylength
      //   33: istore 4
      //   35: iconst_0
      //   36: istore_3
      //   37: iload_3
      //   38: iload 4
      //   40: if_icmpge +32 -> 72
      //   43: aload 5
      //   45: iload_3
      //   46: aaload
      //   47: astore 6
      //   49: aload 6
      //   51: aload_1
      //   52: invokeinterface 44 2 0
      //   57: ifeq +65 -> 122
      //   60: aload_0
      //   61: aload 6
      //   63: putfield 36	com/google/android/exoplayer2/source/g$b:bwk	Lcom/google/android/exoplayer2/c/e;
      //   66: aload_1
      //   67: invokeinterface 49 1 0
      //   72: aload_0
      //   73: getfield 36	com/google/android/exoplayer2/source/g$b:bwk	Lcom/google/android/exoplayer2/c/e;
      //   76: ifnonnull +84 -> 160
      //   79: new 51	com/google/android/exoplayer2/source/s
      //   82: dup
      //   83: new 53	java/lang/StringBuilder
      //   86: dup
      //   87: ldc 55
      //   89: invokespecial 58	java/lang/StringBuilder:<init>	(Ljava/lang/String;)V
      //   92: aload_0
      //   93: getfield 20	com/google/android/exoplayer2/source/g$b:bwj	[Lcom/google/android/exoplayer2/c/e;
      //   96: invokestatic 64	com/google/android/exoplayer2/i/x:d	([Ljava/lang/Object;)Ljava/lang/String;
      //   99: invokevirtual 68	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
      //   102: ldc 70
      //   104: invokevirtual 68	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
      //   107: invokevirtual 74	java/lang/StringBuilder:toString	()Ljava/lang/String;
      //   110: aload_2
      //   111: invokespecial 77	com/google/android/exoplayer2/source/s:<init>	(Ljava/lang/String;Landroid/net/Uri;)V
      //   114: astore_1
      //   115: ldc 28
      //   117: invokestatic 39	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
      //   120: aload_1
      //   121: athrow
      //   122: aload_1
      //   123: invokeinterface 49 1 0
      //   128: iload_3
      //   129: iconst_1
      //   130: iadd
      //   131: istore_3
      //   132: goto -95 -> 37
      //   135: astore 6
      //   137: aload_1
      //   138: invokeinterface 49 1 0
      //   143: goto -15 -> 128
      //   146: astore_2
      //   147: aload_1
      //   148: invokeinterface 49 1 0
      //   153: ldc 28
      //   155: invokestatic 39	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
      //   158: aload_2
      //   159: athrow
      //   160: aload_0
      //   161: getfield 36	com/google/android/exoplayer2/source/g$b:bwk	Lcom/google/android/exoplayer2/c/e;
      //   164: aload_0
      //   165: getfield 22	com/google/android/exoplayer2/source/g$b:bir	Lcom/google/android/exoplayer2/c/g;
      //   168: invokeinterface 80 2 0
      //   173: aload_0
      //   174: getfield 36	com/google/android/exoplayer2/source/g$b:bwk	Lcom/google/android/exoplayer2/c/e;
      //   177: astore_1
      //   178: ldc 28
      //   180: invokestatic 39	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
      //   183: aload_1
      //   184: areturn
      // Local variable table:
      //   start	length	slot	name	signature
      //   0	185	0	this	b
      //   0	185	1	paramf	com.google.android.exoplayer2.c.f
      //   0	185	2	paramUri	Uri
      //   36	96	3	i	int
      //   33	8	4	j	int
      //   28	16	5	arrayOfe	com.google.android.exoplayer2.c.e[]
      //   47	15	6	locale	com.google.android.exoplayer2.c.e
      //   135	1	6	localEOFException	java.io.EOFException
      // Exception table:
      //   from	to	target	type
      //   49	66	135	java/io/EOFException
      //   49	66	146	finally
    }
  }
  
  static abstract interface c
  {
    public abstract void d(long paramLong, boolean paramBoolean);
  }
  
  final class d
    implements n
  {
    final int track;
    
    public d(int paramInt)
    {
      this.track = paramInt;
    }
    
    public final void Y(long paramLong)
    {
      AppMethodBeat.i(92651);
      g localg = g.this;
      int i = this.track;
      m localm = localg.bvQ[i];
      if ((localg.bwd) && (paramLong > localm.bwO.vy()))
      {
        localm.bwO.vH();
        AppMethodBeat.o(92651);
        return;
      }
      localm.f(paramLong, true);
      AppMethodBeat.o(92651);
    }
    
    public final int b(com.google.android.exoplayer2.k paramk, com.google.android.exoplayer2.b.e parame, boolean paramBoolean)
    {
      AppMethodBeat.i(92650);
      g localg = g.this;
      int i = this.track;
      if ((localg.bvU) || (localg.vz()))
      {
        AppMethodBeat.o(92650);
        return -3;
      }
      i = localg.bvQ[i].a(paramk, parame, paramBoolean, localg.bwd, localg.bwa);
      AppMethodBeat.o(92650);
      return i;
    }
    
    public final boolean isReady()
    {
      AppMethodBeat.i(92649);
      g localg = g.this;
      int i = this.track;
      if ((localg.bwd) || ((!localg.vz()) && (localg.bvQ[i].bwO.vF())))
      {
        AppMethodBeat.o(92649);
        return true;
      }
      AppMethodBeat.o(92649);
      return false;
    }
    
    public final void vs() {}
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes8.jar
 * Qualified Name:     com.google.android.exoplayer2.source.g
 * JD-Core Version:    0.7.0.1
 */