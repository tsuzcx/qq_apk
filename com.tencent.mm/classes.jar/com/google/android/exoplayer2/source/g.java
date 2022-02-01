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
import java.util.Arrays;

final class g
  implements com.google.android.exoplayer2.c.g, t.a<a>, t.d, j, m.b
{
  boolean cGv;
  long cHg;
  private final com.google.android.exoplayer2.h.g cLk;
  j.a cYN;
  private final int cYZ;
  final h.a cZa;
  final c cZb;
  private final b cZc;
  final String cZd;
  final long cZe;
  final t cZf;
  private final b cZg;
  final com.google.android.exoplayer2.i.f cZh;
  private final Runnable cZi;
  final Runnable cZj;
  com.google.android.exoplayer2.c.l cZk;
  m[] cZl;
  private int[] cZm;
  boolean cZn;
  private boolean cZo;
  boolean cZp;
  private int cZq;
  r cZr;
  boolean[] cZs;
  boolean[] cZt;
  boolean cZu;
  long cZv;
  private long cZw;
  private int cZx;
  boolean cZy;
  private final Handler eventHandler;
  final Handler handler;
  private long length;
  boolean released;
  private final Uri uri;
  
  public g(Uri paramUri, com.google.android.exoplayer2.h.g paramg, com.google.android.exoplayer2.c.e[] paramArrayOfe, int paramInt1, Handler paramHandler, h.a parama, c paramc, b paramb, String paramString, int paramInt2)
  {
    AppMethodBeat.i(92652);
    this.uri = paramUri;
    this.cLk = paramg;
    this.cYZ = paramInt1;
    this.eventHandler = paramHandler;
    this.cZa = parama;
    this.cZb = paramc;
    this.cZc = paramb;
    this.cZd = paramString;
    this.cZe = paramInt2;
    this.cZf = new t("Loader:ExtractorMediaPeriod");
    this.cZg = new b(paramArrayOfe, this);
    this.cZh = new com.google.android.exoplayer2.i.f();
    this.cZi = new Runnable()
    {
      public final void run()
      {
        AppMethodBeat.i(92643);
        g localg = g.this;
        if ((localg.released) || (localg.cGv) || (localg.cZk == null) || (!localg.cZn))
        {
          AppMethodBeat.o(92643);
          return;
        }
        Object localObject1 = localg.cZl;
        int j = localObject1.length;
        int i = 0;
        while (i < j)
        {
          if (localObject1[i].daj.Th() == null) {
            break label296;
          }
          i += 1;
        }
        localg.cZh.close();
        j = localg.cZl.length;
        localObject1 = new q[j];
        localg.cZt = new boolean[j];
        localg.cZs = new boolean[j];
        localg.cHg = localg.cZk.getDurationUs();
        i = 0;
        if (i < j)
        {
          Object localObject2 = localg.cZl[i].daj.Th();
          localObject1[i] = new q(new Format[] { localObject2 });
          localObject2 = ((Format)localObject2).cGN;
          if ((com.google.android.exoplayer2.i.j.isVideo((String)localObject2)) || (com.google.android.exoplayer2.i.j.df((String)localObject2))) {}
          for (int k = 1;; k = 0)
          {
            localg.cZt[i] = k;
            localg.cZu = (k | localg.cZu);
            i += 1;
            break;
          }
        }
        localg.cZr = new r((q[])localObject1);
        localg.cGv = true;
        localg.cZb.i(localg.cHg, localg.cZk.RR());
        localg.cYN.a(localg);
        label296:
        AppMethodBeat.o(92643);
      }
    };
    this.cZj = new Runnable()
    {
      public final void run()
      {
        AppMethodBeat.i(92644);
        if (!g.this.released) {
          g.this.cYN.a(g.this);
        }
        AppMethodBeat.o(92644);
      }
    };
    this.handler = new Handler();
    this.cZm = new int[0];
    this.cZl = new m[0];
    this.cZw = -9223372036854775807L;
    this.length = -1L;
    AppMethodBeat.o(92652);
  }
  
  private int SY()
  {
    AppMethodBeat.i(92667);
    m[] arrayOfm = this.cZl;
    int k = arrayOfm.length;
    int j = 0;
    int m;
    for (int i = 0; j < k; i = m + i)
    {
      m = arrayOfm[j].daj.Te();
      j += 1;
    }
    AppMethodBeat.o(92667);
    return i;
  }
  
  private long SZ()
  {
    AppMethodBeat.i(92668);
    long l = -9223372036854775808L;
    m[] arrayOfm = this.cZl;
    int j = arrayOfm.length;
    int i = 0;
    while (i < j)
    {
      l = Math.max(l, arrayOfm[i].daj.SZ());
      i += 1;
    }
    AppMethodBeat.o(92668);
    return l;
  }
  
  private void a(a parama)
  {
    if (this.length == -1L) {
      this.length = parama.length;
    }
  }
  
  private boolean cq(long paramLong)
  {
    AppMethodBeat.i(92666);
    int j = this.cZl.length;
    int i = 0;
    while (i < j)
    {
      m localm = this.cZl[i];
      localm.bh();
      if ((!localm.k(paramLong, false)) && ((this.cZt[i] != 0) || (!this.cZu)))
      {
        AppMethodBeat.o(92666);
        return false;
      }
      localm.Tl();
      i += 1;
    }
    AppMethodBeat.o(92666);
    return true;
  }
  
  private void startLoading()
  {
    AppMethodBeat.i(92665);
    a locala = new a(this.uri, this.cLk, this.cZg, this.cZh);
    if (this.cGv)
    {
      a.checkState(Ta());
      if ((this.cHg != -9223372036854775807L) && (this.cZw >= this.cHg))
      {
        this.cZy = true;
        this.cZw = -9223372036854775807L;
        AppMethodBeat.o(92665);
        return;
      }
      locala.F(this.cZk.cc(this.cZw), this.cZw);
      this.cZw = -9223372036854775807L;
    }
    this.cZx = SY();
    int j = this.cYZ;
    int i = j;
    if (j == -1) {
      if ((this.cGv) && (this.length == -1L) && ((this.cZk == null) || (this.cZk.getDurationUs() == -9223372036854775807L))) {
        break label193;
      }
    }
    label193:
    for (i = 3;; i = 6)
    {
      this.cZf.a(locala, this, i);
      AppMethodBeat.o(92665);
      return;
    }
  }
  
  public final void RW()
  {
    AppMethodBeat.i(92662);
    this.cZn = true;
    this.handler.post(this.cZi);
    AppMethodBeat.o(92662);
  }
  
  public final void SO()
  {
    AppMethodBeat.i(210360);
    this.cZf.Un();
    AppMethodBeat.o(210360);
  }
  
  public final r SP()
  {
    return this.cZr;
  }
  
  public final long SQ()
  {
    if (this.cZp)
    {
      this.cZp = false;
      return this.cZv;
    }
    return -9223372036854775807L;
  }
  
  public final long SR()
  {
    AppMethodBeat.i(92659);
    if (this.cZy)
    {
      AppMethodBeat.o(92659);
      return -9223372036854775808L;
    }
    long l1;
    if (Ta())
    {
      l1 = this.cZw;
      AppMethodBeat.o(92659);
      return l1;
    }
    if (this.cZu)
    {
      l1 = 9223372036854775807L;
      int j = this.cZl.length;
      int i = 0;
      for (;;)
      {
        l2 = l1;
        if (i >= j) {
          break;
        }
        l2 = l1;
        if (this.cZt[i] != 0) {
          l2 = Math.min(l1, this.cZl[i].daj.SZ());
        }
        i += 1;
        l1 = l2;
      }
    }
    long l2 = SZ();
    if (l2 == -9223372036854775808L)
    {
      l1 = this.cZv;
      AppMethodBeat.o(92659);
      return l1;
    }
    AppMethodBeat.o(92659);
    return l2;
  }
  
  public final long SS()
  {
    AppMethodBeat.i(92658);
    if (this.cZq == 0)
    {
      AppMethodBeat.o(92658);
      return -9223372036854775808L;
    }
    long l = SR();
    AppMethodBeat.o(92658);
    return l;
  }
  
  public final void SW()
  {
    AppMethodBeat.i(92653);
    Object localObject = this.cZg;
    if (((b)localObject).cZF != null) {
      ((b)localObject).cZF = null;
    }
    localObject = this.cZl;
    int j = localObject.length;
    int i = 0;
    while (i < j)
    {
      localObject[i].reset(false);
      i += 1;
    }
    AppMethodBeat.o(92653);
  }
  
  public final void SX()
  {
    AppMethodBeat.i(92664);
    this.handler.post(this.cZi);
    AppMethodBeat.o(92664);
  }
  
  final boolean Ta()
  {
    return this.cZw != -9223372036854775807L;
  }
  
  public final long a(com.google.android.exoplayer2.g.f[] paramArrayOff, boolean[] paramArrayOfBoolean1, n[] paramArrayOfn, boolean[] paramArrayOfBoolean2, long paramLong)
  {
    int m = 0;
    int k = 0;
    AppMethodBeat.i(92655);
    a.checkState(this.cGv);
    int j = this.cZq;
    int i = 0;
    int n;
    while (i < paramArrayOff.length)
    {
      if ((paramArrayOfn[i] != null) && ((paramArrayOff[i] == null) || (paramArrayOfBoolean1[i] == 0)))
      {
        n = ((d)paramArrayOfn[i]).track;
        a.checkState(this.cZs[n]);
        this.cZq -= 1;
        this.cZs[n] = false;
        paramArrayOfn[i] = null;
      }
      i += 1;
    }
    label128:
    boolean bool;
    if (this.cZo) {
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
        if (paramArrayOfBoolean1.iC(0) != 0) {
          break label341;
        }
        bool = true;
        label185:
        a.checkState(bool);
        n = this.cZr.a(paramArrayOfBoolean1.Uc());
        if (this.cZs[n] != 0) {
          break label347;
        }
        bool = true;
        label218:
        a.checkState(bool);
        this.cZq += 1;
        this.cZs[n] = true;
        paramArrayOfn[j] = new d(n);
        paramArrayOfBoolean2[j] = true;
        if (i != 0) {
          break label536;
        }
        paramArrayOfBoolean1 = this.cZl[n];
        paramArrayOfBoolean1.bh();
        if ((paramArrayOfBoolean1.k(paramLong, true)) || (paramArrayOfBoolean1.daj.Tf() == 0)) {
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
      if (this.cZq == 0)
      {
        this.cZp = false;
        if (this.cZf.isLoading())
        {
          paramArrayOff = this.cZl;
          j = paramArrayOff.length;
          i = k;
          while (i < j)
          {
            paramArrayOff[i].Tm();
            i += 1;
          }
          this.cZf.cancelLoading();
          l = paramLong;
        }
      }
      do
      {
        this.cZo = true;
        AppMethodBeat.o(92655);
        return l;
        paramArrayOff = this.cZl;
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
      paramLong = cn(paramLong);
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
    this.cZk = paraml;
    this.handler.post(this.cZi);
    AppMethodBeat.o(92663);
  }
  
  public final void a(j.a parama, long paramLong)
  {
    AppMethodBeat.i(92654);
    this.cYN = parama;
    this.cZh.open();
    startLoading();
    AppMethodBeat.o(92654);
  }
  
  public final void cm(long paramLong)
  {
    AppMethodBeat.i(92656);
    int j = this.cZl.length;
    int i = 0;
    while (i < j)
    {
      this.cZl[i].m(paramLong, this.cZs[i]);
      i += 1;
    }
    AppMethodBeat.o(92656);
  }
  
  public final long cn(long paramLong)
  {
    AppMethodBeat.i(92660);
    if (this.cZk.RR()) {}
    for (;;)
    {
      this.cZv = paramLong;
      this.cZp = false;
      if ((Ta()) || (!cq(paramLong))) {
        break;
      }
      AppMethodBeat.o(92660);
      return paramLong;
      paramLong = 0L;
    }
    this.cZw = paramLong;
    this.cZy = false;
    if (this.cZf.isLoading()) {
      this.cZf.cancelLoading();
    }
    for (;;)
    {
      AppMethodBeat.o(92660);
      return paramLong;
      m[] arrayOfm = this.cZl;
      int j = arrayOfm.length;
      int i = 0;
      while (i < j)
      {
        arrayOfm[i].reset(false);
        i += 1;
      }
    }
  }
  
  public final boolean co(long paramLong)
  {
    AppMethodBeat.i(92657);
    if ((this.cZy) || ((this.cGv) && (this.cZq == 0)))
    {
      AppMethodBeat.o(92657);
      return false;
    }
    boolean bool = this.cZh.open();
    if (!this.cZf.isLoading())
    {
      startLoading();
      bool = true;
    }
    AppMethodBeat.o(92657);
    return bool;
  }
  
  public final com.google.android.exoplayer2.c.m hz(int paramInt)
  {
    AppMethodBeat.i(210365);
    int j = this.cZl.length;
    int i = 0;
    while (i < j)
    {
      if (this.cZm[i] == paramInt)
      {
        localm = this.cZl[i];
        AppMethodBeat.o(210365);
        return localm;
      }
      i += 1;
    }
    m localm = new m(this.cZc);
    localm.dat = this;
    this.cZm = Arrays.copyOf(this.cZm, j + 1);
    this.cZm[j] = paramInt;
    this.cZl = ((m[])Arrays.copyOf(this.cZl, j + 1));
    this.cZl[j] = localm;
    AppMethodBeat.o(210365);
    return localm;
  }
  
  final class a
    implements t.c
  {
    private final com.google.android.exoplayer2.h.g cLk;
    private final com.google.android.exoplayer2.c.k cZA;
    private volatile boolean cZB;
    private boolean cZC;
    private long cZD;
    private final g.b cZg;
    private final com.google.android.exoplayer2.i.f cZh;
    long length;
    private final Uri uri;
    
    public a(Uri paramUri, com.google.android.exoplayer2.h.g paramg, g.b paramb, com.google.android.exoplayer2.i.f paramf)
    {
      AppMethodBeat.i(92646);
      this.uri = ((Uri)a.checkNotNull(paramUri));
      this.cLk = ((com.google.android.exoplayer2.h.g)a.checkNotNull(paramg));
      this.cZg = ((g.b)a.checkNotNull(paramb));
      this.cZh = paramf;
      this.cZA = new com.google.android.exoplayer2.c.k();
      this.cZC = true;
      this.length = -1L;
      AppMethodBeat.o(92646);
    }
    
    public final void F(long paramLong1, long paramLong2)
    {
      this.cZA.position = paramLong1;
      this.cZD = paramLong2;
      this.cZC = true;
    }
    
    public final void Tb()
    {
      this.cZB = true;
    }
    
    public final boolean Tc()
    {
      return this.cZB;
    }
    
    /* Error */
    public final void Td()
    {
      // Byte code:
      //   0: ldc 90
      //   2: invokestatic 41	com/tencent/matrix/trace/core/AppMethodBeat:i	(I)V
      //   5: iconst_0
      //   6: istore_1
      //   7: iload_1
      //   8: ifne +305 -> 313
      //   11: aload_0
      //   12: getfield 86	com/google/android/exoplayer2/source/g$a:cZB	Z
      //   15: ifne +298 -> 313
      //   18: aload_0
      //   19: getfield 66	com/google/android/exoplayer2/source/g$a:cZA	Lcom/google/android/exoplayer2/c/k;
      //   22: getfield 81	com/google/android/exoplayer2/c/k:position	J
      //   25: lstore_3
      //   26: aload_0
      //   27: aload_0
      //   28: getfield 55	com/google/android/exoplayer2/source/g$a:cLk	Lcom/google/android/exoplayer2/h/g;
      //   31: new 92	com/google/android/exoplayer2/h/j
      //   34: dup
      //   35: aload_0
      //   36: getfield 51	com/google/android/exoplayer2/source/g$a:uri	Landroid/net/Uri;
      //   39: lload_3
      //   40: ldc2_w 69
      //   43: aload_0
      //   44: getfield 31	com/google/android/exoplayer2/source/g$a:cZz	Lcom/google/android/exoplayer2/source/g;
      //   47: getfield 96	com/google/android/exoplayer2/source/g:cZd	Ljava/lang/String;
      //   50: invokespecial 99	com/google/android/exoplayer2/h/j:<init>	(Landroid/net/Uri;JJLjava/lang/String;)V
      //   53: invokeinterface 102 2 0
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
      //   82: new 104	com/google/android/exoplayer2/c/b
      //   85: dup
      //   86: aload_0
      //   87: getfield 55	com/google/android/exoplayer2/source/g$a:cLk	Lcom/google/android/exoplayer2/h/g;
      //   90: lload_3
      //   91: aload_0
      //   92: getfield 72	com/google/android/exoplayer2/source/g$a:length	J
      //   95: invokespecial 107	com/google/android/exoplayer2/c/b:<init>	(Lcom/google/android/exoplayer2/h/g;JJ)V
      //   98: astore 5
      //   100: aload_0
      //   101: getfield 59	com/google/android/exoplayer2/source/g$a:cZg	Lcom/google/android/exoplayer2/source/g$b;
      //   104: aload 5
      //   106: aload_0
      //   107: getfield 55	com/google/android/exoplayer2/source/g$a:cLk	Lcom/google/android/exoplayer2/h/g;
      //   110: invokeinterface 111 1 0
      //   115: invokevirtual 114	com/google/android/exoplayer2/source/g$b:a	(Lcom/google/android/exoplayer2/c/f;Landroid/net/Uri;)Lcom/google/android/exoplayer2/c/e;
      //   118: astore 6
      //   120: aload_0
      //   121: getfield 68	com/google/android/exoplayer2/source/g$a:cZC	Z
      //   124: ifeq +20 -> 144
      //   127: aload 6
      //   129: lload_3
      //   130: aload_0
      //   131: getfield 83	com/google/android/exoplayer2/source/g$a:cZD	J
      //   134: invokeinterface 119 5 0
      //   139: aload_0
      //   140: iconst_0
      //   141: putfield 68	com/google/android/exoplayer2/source/g$a:cZC	Z
      //   144: iload_1
      //   145: ifne +90 -> 235
      //   148: aload_0
      //   149: getfield 86	com/google/android/exoplayer2/source/g$a:cZB	Z
      //   152: ifne +83 -> 235
      //   155: aload_0
      //   156: getfield 61	com/google/android/exoplayer2/source/g$a:cZh	Lcom/google/android/exoplayer2/i/f;
      //   159: invokevirtual 124	com/google/android/exoplayer2/i/f:block	()V
      //   162: aload 6
      //   164: aload 5
      //   166: aload_0
      //   167: getfield 66	com/google/android/exoplayer2/source/g$a:cZA	Lcom/google/android/exoplayer2/c/k;
      //   170: invokeinterface 127 3 0
      //   175: istore_2
      //   176: iload_2
      //   177: istore_1
      //   178: aload 5
      //   180: invokeinterface 133 1 0
      //   185: aload_0
      //   186: getfield 31	com/google/android/exoplayer2/source/g$a:cZz	Lcom/google/android/exoplayer2/source/g;
      //   189: getfield 136	com/google/android/exoplayer2/source/g:cZe	J
      //   192: lload_3
      //   193: ladd
      //   194: lcmp
      //   195: ifle +171 -> 366
      //   198: aload 5
      //   200: invokeinterface 133 1 0
      //   205: lstore_3
      //   206: aload_0
      //   207: getfield 61	com/google/android/exoplayer2/source/g$a:cZh	Lcom/google/android/exoplayer2/i/f;
      //   210: invokevirtual 139	com/google/android/exoplayer2/i/f:close	()Z
      //   213: pop
      //   214: aload_0
      //   215: getfield 31	com/google/android/exoplayer2/source/g$a:cZz	Lcom/google/android/exoplayer2/source/g;
      //   218: getfield 143	com/google/android/exoplayer2/source/g:handler	Landroid/os/Handler;
      //   221: aload_0
      //   222: getfield 31	com/google/android/exoplayer2/source/g$a:cZz	Lcom/google/android/exoplayer2/source/g;
      //   225: getfield 147	com/google/android/exoplayer2/source/g:cZj	Ljava/lang/Runnable;
      //   228: invokevirtual 153	android/os/Handler:post	(Ljava/lang/Runnable;)Z
      //   231: pop
      //   232: goto -88 -> 144
      //   235: iload_1
      //   236: iconst_1
      //   237: if_icmpne +15 -> 252
      //   240: iconst_0
      //   241: istore_1
      //   242: aload_0
      //   243: getfield 55	com/google/android/exoplayer2/source/g$a:cLk	Lcom/google/android/exoplayer2/h/g;
      //   246: invokestatic 158	com/google/android/exoplayer2/i/x:a	(Lcom/google/android/exoplayer2/h/g;)V
      //   249: goto -242 -> 7
      //   252: aload_0
      //   253: getfield 66	com/google/android/exoplayer2/source/g$a:cZA	Lcom/google/android/exoplayer2/c/k;
      //   256: aload 5
      //   258: invokeinterface 133 1 0
      //   263: putfield 81	com/google/android/exoplayer2/c/k:position	J
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
      //   285: getfield 66	com/google/android/exoplayer2/source/g$a:cZA	Lcom/google/android/exoplayer2/c/k;
      //   288: aload 6
      //   290: invokeinterface 133 1 0
      //   295: putfield 81	com/google/android/exoplayer2/c/k:position	J
      //   298: aload_0
      //   299: getfield 55	com/google/android/exoplayer2/source/g$a:cLk	Lcom/google/android/exoplayer2/h/g;
      //   302: invokestatic 158	com/google/android/exoplayer2/i/x:a	(Lcom/google/android/exoplayer2/h/g;)V
      //   305: ldc 90
      //   307: invokestatic 75	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
      //   310: aload 5
      //   312: athrow
      //   313: ldc 90
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
    private final com.google.android.exoplayer2.c.g cLR;
    private final com.google.android.exoplayer2.c.e[] cZE;
    com.google.android.exoplayer2.c.e cZF;
    
    public b(com.google.android.exoplayer2.c.e[] paramArrayOfe, com.google.android.exoplayer2.c.g paramg)
    {
      this.cZE = paramArrayOfe;
      this.cLR = paramg;
    }
    
    /* Error */
    public final com.google.android.exoplayer2.c.e a(com.google.android.exoplayer2.c.f paramf, Uri paramUri)
    {
      // Byte code:
      //   0: ldc 28
      //   2: invokestatic 34	com/tencent/matrix/trace/core/AppMethodBeat:i	(I)V
      //   5: aload_0
      //   6: getfield 36	com/google/android/exoplayer2/source/g$b:cZF	Lcom/google/android/exoplayer2/c/e;
      //   9: ifnull +15 -> 24
      //   12: aload_0
      //   13: getfield 36	com/google/android/exoplayer2/source/g$b:cZF	Lcom/google/android/exoplayer2/c/e;
      //   16: astore_1
      //   17: ldc 28
      //   19: invokestatic 39	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
      //   22: aload_1
      //   23: areturn
      //   24: aload_0
      //   25: getfield 20	com/google/android/exoplayer2/source/g$b:cZE	[Lcom/google/android/exoplayer2/c/e;
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
      //   63: putfield 36	com/google/android/exoplayer2/source/g$b:cZF	Lcom/google/android/exoplayer2/c/e;
      //   66: aload_1
      //   67: invokeinterface 49 1 0
      //   72: aload_0
      //   73: getfield 36	com/google/android/exoplayer2/source/g$b:cZF	Lcom/google/android/exoplayer2/c/e;
      //   76: ifnonnull +84 -> 160
      //   79: new 51	com/google/android/exoplayer2/source/s
      //   82: dup
      //   83: new 53	java/lang/StringBuilder
      //   86: dup
      //   87: ldc 55
      //   89: invokespecial 58	java/lang/StringBuilder:<init>	(Ljava/lang/String;)V
      //   92: aload_0
      //   93: getfield 20	com/google/android/exoplayer2/source/g$b:cZE	[Lcom/google/android/exoplayer2/c/e;
      //   96: invokestatic 64	com/google/android/exoplayer2/i/x:g	([Ljava/lang/Object;)Ljava/lang/String;
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
      //   161: getfield 36	com/google/android/exoplayer2/source/g$b:cZF	Lcom/google/android/exoplayer2/c/e;
      //   164: aload_0
      //   165: getfield 22	com/google/android/exoplayer2/source/g$b:cLR	Lcom/google/android/exoplayer2/c/g;
      //   168: invokeinterface 80 2 0
      //   173: aload_0
      //   174: getfield 36	com/google/android/exoplayer2/source/g$b:cZF	Lcom/google/android/exoplayer2/c/e;
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
    public abstract void i(long paramLong, boolean paramBoolean);
  }
  
  final class d
    implements n
  {
    final int track;
    
    public d(int paramInt)
    {
      this.track = paramInt;
    }
    
    public final void ST()
    {
      AppMethodBeat.i(210346);
      g.this.cZf.Un();
      AppMethodBeat.o(210346);
    }
    
    public final int b(com.google.android.exoplayer2.k paramk, com.google.android.exoplayer2.b.e parame, boolean paramBoolean)
    {
      AppMethodBeat.i(92650);
      g localg = g.this;
      int i = this.track;
      if ((localg.cZp) || (localg.Ta()))
      {
        AppMethodBeat.o(92650);
        return -3;
      }
      i = localg.cZl[i].a(paramk, parame, paramBoolean, localg.cZy, localg.cZv);
      AppMethodBeat.o(92650);
      return i;
    }
    
    public final void cp(long paramLong)
    {
      AppMethodBeat.i(92651);
      g localg = g.this;
      int i = this.track;
      m localm = localg.cZl[i];
      if ((localg.cZy) && (paramLong > localm.daj.SZ()))
      {
        localm.daj.Ti();
        AppMethodBeat.o(92651);
        return;
      }
      localm.k(paramLong, true);
      AppMethodBeat.o(92651);
    }
    
    public final boolean isReady()
    {
      AppMethodBeat.i(92649);
      g localg = g.this;
      int i = this.track;
      if ((localg.cZy) || ((!localg.Ta()) && (localg.cZl[i].daj.Tg())))
      {
        AppMethodBeat.o(92649);
        return true;
      }
      AppMethodBeat.o(92649);
      return false;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes12.jar
 * Qualified Name:     com.google.android.exoplayer2.source.g
 * JD-Core Version:    0.7.0.1
 */