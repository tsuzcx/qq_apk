package com.google.android.exoplayer2.source;

import android.net.Uri;
import android.os.Handler;
import com.google.android.exoplayer2.Format;
import com.google.android.exoplayer2.c.m;
import com.google.android.exoplayer2.h.b;
import com.google.android.exoplayer2.h.t;
import com.google.android.exoplayer2.h.t.a;
import com.google.android.exoplayer2.h.t.c;
import com.google.android.exoplayer2.h.t.d;
import com.google.android.exoplayer2.i.a;
import com.tencent.matrix.trace.core.AppMethodBeat;
import java.io.IOException;
import java.util.Arrays;

final class f
  implements com.google.android.exoplayer2.c.g, t.a<a>, t.d, h, k.b
{
  boolean aSG;
  long aTs;
  private final com.google.android.exoplayer2.h.g aXs;
  k[] blA;
  private int[] blB;
  boolean blC;
  private boolean blD;
  boolean blE;
  private int blF;
  p blG;
  boolean[] blH;
  boolean[] blI;
  boolean blJ;
  long blK;
  private long blL;
  private int blM;
  boolean blN;
  h.a blc;
  private final int blo;
  final g.a blp;
  final c blq;
  private final b blr;
  final String bls;
  final long blt;
  final t blu;
  private final b blv;
  final com.google.android.exoplayer2.i.f blw;
  private final Runnable blx;
  final Runnable bly;
  com.google.android.exoplayer2.c.l blz;
  private final Handler eventHandler;
  final Handler handler;
  private long length;
  boolean released;
  private final Uri uri;
  
  public f(Uri paramUri, com.google.android.exoplayer2.h.g paramg, com.google.android.exoplayer2.c.e[] paramArrayOfe, int paramInt1, Handler paramHandler, g.a parama, c paramc, b paramb, String paramString, int paramInt2)
  {
    AppMethodBeat.i(92652);
    this.uri = paramUri;
    this.aXs = paramg;
    this.blo = paramInt1;
    this.eventHandler = paramHandler;
    this.blp = parama;
    this.blq = paramc;
    this.blr = paramb;
    this.bls = paramString;
    this.blt = paramInt2;
    this.blu = new t("Loader:ExtractorMediaPeriod");
    this.blv = new b(paramArrayOfe, this);
    this.blw = new com.google.android.exoplayer2.i.f();
    this.blx = new Runnable()
    {
      public final void run()
      {
        AppMethodBeat.i(92643);
        f localf = f.this;
        if ((localf.released) || (localf.aSG) || (localf.blz == null) || (!localf.blC))
        {
          AppMethodBeat.o(92643);
          return;
        }
        Object localObject1 = localf.blA;
        int j = localObject1.length;
        int i = 0;
        while (i < j)
        {
          if (localObject1[i].bms.uc() == null) {
            break label296;
          }
          i += 1;
        }
        localf.blw.close();
        j = localf.blA.length;
        localObject1 = new o[j];
        localf.blI = new boolean[j];
        localf.blH = new boolean[j];
        localf.aTs = localf.blz.getDurationUs();
        i = 0;
        if (i < j)
        {
          Object localObject2 = localf.blA[i].bms.uc();
          localObject1[i] = new o(new Format[] { localObject2 });
          localObject2 = ((Format)localObject2).aSY;
          if ((com.google.android.exoplayer2.i.j.aF((String)localObject2)) || (com.google.android.exoplayer2.i.j.aE((String)localObject2))) {}
          for (int k = 1;; k = 0)
          {
            localf.blI[i] = k;
            localf.blJ = (k | localf.blJ);
            i += 1;
            break;
          }
        }
        localf.blG = new p((o[])localObject1);
        localf.aSG = true;
        localf.blq.d(localf.aTs, localf.blz.sQ());
        localf.blc.a(localf);
        label296:
        AppMethodBeat.o(92643);
      }
    };
    this.bly = new Runnable()
    {
      public final void run()
      {
        AppMethodBeat.i(92644);
        if (!f.this.released) {
          f.this.blc.a(f.this);
        }
        AppMethodBeat.o(92644);
      }
    };
    this.handler = new Handler();
    this.blB = new int[0];
    this.blA = new k[0];
    this.blL = -9223372036854775807L;
    this.length = -1L;
    AppMethodBeat.o(92652);
  }
  
  private boolean Z(long paramLong)
  {
    AppMethodBeat.i(92666);
    int j = this.blA.length;
    int i = 0;
    while (i < j)
    {
      k localk = this.blA[i];
      localk.rewind();
      if ((!localk.f(paramLong, false)) && ((this.blI[i] != 0) || (!this.blJ)))
      {
        AppMethodBeat.o(92666);
        return false;
      }
      localk.ug();
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
    a locala = new a(this.uri, this.aXs, this.blv, this.blw);
    if (this.aSG)
    {
      a.checkState(tU());
      if ((this.aTs != -9223372036854775807L) && (this.blL >= this.aTs))
      {
        this.blN = true;
        this.blL = -9223372036854775807L;
        AppMethodBeat.o(92665);
        return;
      }
      locala.i(this.blz.L(this.blL), this.blL);
      this.blL = -9223372036854775807L;
    }
    this.blM = tS();
    int j = this.blo;
    int i = j;
    if (j == -1) {
      if ((this.aSG) && (this.length == -1L) && ((this.blz == null) || (this.blz.getDurationUs() == -9223372036854775807L))) {
        break label193;
      }
    }
    label193:
    for (i = 3;; i = 6)
    {
      this.blu.a(locala, this, i);
      AppMethodBeat.o(92665);
      return;
    }
  }
  
  private int tS()
  {
    AppMethodBeat.i(92667);
    k[] arrayOfk = this.blA;
    int k = arrayOfk.length;
    int j = 0;
    int m;
    for (int i = 0; j < k; i = m + i)
    {
      m = arrayOfk[j].bms.tZ();
      j += 1;
    }
    AppMethodBeat.o(92667);
    return i;
  }
  
  private long tT()
  {
    AppMethodBeat.i(92668);
    long l = -9223372036854775808L;
    k[] arrayOfk = this.blA;
    int j = arrayOfk.length;
    int i = 0;
    while (i < j)
    {
      l = Math.max(l, arrayOfk[i].bms.tT());
      i += 1;
    }
    AppMethodBeat.o(92668);
    return l;
  }
  
  public final void V(long paramLong)
  {
    AppMethodBeat.i(92656);
    int j = this.blA.length;
    int i = 0;
    while (i < j)
    {
      this.blA[i].h(paramLong, this.blH[i]);
      i += 1;
    }
    AppMethodBeat.o(92656);
  }
  
  public final long W(long paramLong)
  {
    AppMethodBeat.i(92660);
    if (this.blz.sQ()) {}
    for (;;)
    {
      this.blK = paramLong;
      this.blE = false;
      if ((tU()) || (!Z(paramLong))) {
        break;
      }
      AppMethodBeat.o(92660);
      return paramLong;
      paramLong = 0L;
    }
    this.blL = paramLong;
    this.blN = false;
    if (this.blu.isLoading()) {
      this.blu.cancelLoading();
    }
    for (;;)
    {
      AppMethodBeat.o(92660);
      return paramLong;
      k[] arrayOfk = this.blA;
      int j = arrayOfk.length;
      int i = 0;
      while (i < j)
      {
        arrayOfk[i].reset(false);
        i += 1;
      }
    }
  }
  
  public final boolean X(long paramLong)
  {
    AppMethodBeat.i(92657);
    if ((this.blN) || ((this.aSG) && (this.blF == 0)))
    {
      AppMethodBeat.o(92657);
      return false;
    }
    boolean bool = this.blw.open();
    if (!this.blu.isLoading())
    {
      startLoading();
      bool = true;
    }
    AppMethodBeat.o(92657);
    return bool;
  }
  
  public final long a(com.google.android.exoplayer2.g.f[] paramArrayOff, boolean[] paramArrayOfBoolean1, l[] paramArrayOfl, boolean[] paramArrayOfBoolean2, long paramLong)
  {
    int m = 0;
    int k = 0;
    AppMethodBeat.i(92655);
    a.checkState(this.aSG);
    int j = this.blF;
    int i = 0;
    int n;
    while (i < paramArrayOff.length)
    {
      if ((paramArrayOfl[i] != null) && ((paramArrayOff[i] == null) || (paramArrayOfBoolean1[i] == 0)))
      {
        n = ((d)paramArrayOfl[i]).track;
        a.checkState(this.blH[n]);
        this.blF -= 1;
        this.blH[n] = false;
        paramArrayOfl[i] = null;
      }
      i += 1;
    }
    label128:
    boolean bool;
    if (this.blD) {
      if (j == 0)
      {
        i = 1;
        j = 0;
        if (j >= paramArrayOff.length) {
          break label359;
        }
        if ((paramArrayOfl[j] != null) || (paramArrayOff[j] == null)) {
          break label536;
        }
        paramArrayOfBoolean1 = paramArrayOff[j];
        if (paramArrayOfBoolean1.length() != 1) {
          break label335;
        }
        bool = true;
        label167:
        a.checkState(bool);
        if (paramArrayOfBoolean1.eS(0) != 0) {
          break label341;
        }
        bool = true;
        label185:
        a.checkState(bool);
        n = this.blG.a(paramArrayOfBoolean1.uU());
        if (this.blH[n] != 0) {
          break label347;
        }
        bool = true;
        label218:
        a.checkState(bool);
        this.blF += 1;
        this.blH[n] = true;
        paramArrayOfl[j] = new d(n);
        paramArrayOfBoolean2[j] = true;
        if (i != 0) {
          break label536;
        }
        paramArrayOfBoolean1 = this.blA[n];
        paramArrayOfBoolean1.rewind();
        if ((paramArrayOfBoolean1.f(paramLong, true)) || (paramArrayOfBoolean1.bms.ua() == 0)) {
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
      if (this.blF == 0)
      {
        this.blE = false;
        if (this.blu.isLoading())
        {
          paramArrayOff = this.blA;
          j = paramArrayOff.length;
          i = k;
          while (i < j)
          {
            paramArrayOff[i].uh();
            i += 1;
          }
          this.blu.cancelLoading();
          l = paramLong;
        }
      }
      do
      {
        this.blD = true;
        AppMethodBeat.o(92655);
        return l;
        paramArrayOff = this.blA;
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
        if (i >= paramArrayOfl.length) {
          break;
        }
        if (paramArrayOfl[i] != null) {
          paramArrayOfBoolean2[i] = true;
        }
        i += 1;
      }
    }
  }
  
  public final void a(com.google.android.exoplayer2.c.l paraml)
  {
    AppMethodBeat.i(92663);
    this.blz = paraml;
    this.handler.post(this.blx);
    AppMethodBeat.o(92663);
  }
  
  public final void a(h.a parama, long paramLong)
  {
    AppMethodBeat.i(92654);
    this.blc = parama;
    this.blw.open();
    startLoading();
    AppMethodBeat.o(92654);
  }
  
  public final m dW(int paramInt)
  {
    AppMethodBeat.i(195773);
    int j = this.blA.length;
    int i = 0;
    while (i < j)
    {
      if (this.blB[i] == paramInt)
      {
        localk = this.blA[i];
        AppMethodBeat.o(195773);
        return localk;
      }
      i += 1;
    }
    k localk = new k(this.blr);
    localk.bmC = this;
    this.blB = Arrays.copyOf(this.blB, j + 1);
    this.blB[j] = paramInt;
    this.blA = ((k[])Arrays.copyOf(this.blA, j + 1));
    this.blA[j] = localk;
    AppMethodBeat.o(195773);
    return localk;
  }
  
  public final void sU()
  {
    AppMethodBeat.i(92662);
    this.blC = true;
    this.handler.post(this.blx);
    AppMethodBeat.o(92662);
  }
  
  public final void tI() {}
  
  public final p tJ()
  {
    return this.blG;
  }
  
  public final long tK()
  {
    if (this.blE)
    {
      this.blE = false;
      return this.blK;
    }
    return -9223372036854775807L;
  }
  
  public final long tL()
  {
    AppMethodBeat.i(92659);
    if (this.blN)
    {
      AppMethodBeat.o(92659);
      return -9223372036854775808L;
    }
    long l1;
    if (tU())
    {
      l1 = this.blL;
      AppMethodBeat.o(92659);
      return l1;
    }
    if (this.blJ)
    {
      l1 = 9223372036854775807L;
      int j = this.blA.length;
      int i = 0;
      for (;;)
      {
        l2 = l1;
        if (i >= j) {
          break;
        }
        l2 = l1;
        if (this.blI[i] != 0) {
          l2 = Math.min(l1, this.blA[i].bms.tT());
        }
        i += 1;
        l1 = l2;
      }
    }
    long l2 = tT();
    if (l2 == -9223372036854775808L)
    {
      l1 = this.blK;
      AppMethodBeat.o(92659);
      return l1;
    }
    AppMethodBeat.o(92659);
    return l2;
  }
  
  public final long tM()
  {
    AppMethodBeat.i(92658);
    if (this.blF == 0)
    {
      AppMethodBeat.o(92658);
      return -9223372036854775808L;
    }
    long l = tL();
    AppMethodBeat.o(92658);
    return l;
  }
  
  public final void tQ()
  {
    AppMethodBeat.i(92653);
    Object localObject = this.blv;
    if (((b)localObject).blU != null) {
      ((b)localObject).blU = null;
    }
    localObject = this.blA;
    int j = localObject.length;
    int i = 0;
    while (i < j)
    {
      localObject[i].reset(false);
      i += 1;
    }
    AppMethodBeat.o(92653);
  }
  
  public final void tR()
  {
    AppMethodBeat.i(92664);
    this.handler.post(this.blx);
    AppMethodBeat.o(92664);
  }
  
  final boolean tU()
  {
    return this.blL != -9223372036854775807L;
  }
  
  final class a
    implements t.c
  {
    private final com.google.android.exoplayer2.h.g aXs;
    private final com.google.android.exoplayer2.c.k blP;
    private volatile boolean blQ;
    private boolean blR;
    private long blS;
    private final f.b blv;
    private final com.google.android.exoplayer2.i.f blw;
    long length;
    private final Uri uri;
    
    public a(Uri paramUri, com.google.android.exoplayer2.h.g paramg, f.b paramb, com.google.android.exoplayer2.i.f paramf)
    {
      AppMethodBeat.i(92646);
      this.uri = ((Uri)a.checkNotNull(paramUri));
      this.aXs = ((com.google.android.exoplayer2.h.g)a.checkNotNull(paramg));
      this.blv = ((f.b)a.checkNotNull(paramb));
      this.blw = paramf;
      this.blP = new com.google.android.exoplayer2.c.k();
      this.blR = true;
      this.length = -1L;
      AppMethodBeat.o(92646);
    }
    
    public final void i(long paramLong1, long paramLong2)
    {
      this.blP.position = paramLong1;
      this.blS = paramLong2;
      this.blR = true;
    }
    
    public final void tV()
    {
      this.blQ = true;
    }
    
    public final boolean tW()
    {
      return this.blQ;
    }
    
    /* Error */
    public final void tX()
    {
      // Byte code:
      //   0: ldc 89
      //   2: invokestatic 41	com/tencent/matrix/trace/core/AppMethodBeat:i	(I)V
      //   5: iconst_0
      //   6: istore_1
      //   7: iload_1
      //   8: ifne +305 -> 313
      //   11: aload_0
      //   12: getfield 85	com/google/android/exoplayer2/source/f$a:blQ	Z
      //   15: ifne +298 -> 313
      //   18: aload_0
      //   19: getfield 66	com/google/android/exoplayer2/source/f$a:blP	Lcom/google/android/exoplayer2/c/k;
      //   22: getfield 80	com/google/android/exoplayer2/c/k:position	J
      //   25: lstore_3
      //   26: aload_0
      //   27: aload_0
      //   28: getfield 55	com/google/android/exoplayer2/source/f$a:aXs	Lcom/google/android/exoplayer2/h/g;
      //   31: new 91	com/google/android/exoplayer2/h/j
      //   34: dup
      //   35: aload_0
      //   36: getfield 51	com/google/android/exoplayer2/source/f$a:uri	Landroid/net/Uri;
      //   39: lload_3
      //   40: ldc2_w 69
      //   43: aload_0
      //   44: getfield 31	com/google/android/exoplayer2/source/f$a:blO	Lcom/google/android/exoplayer2/source/f;
      //   47: getfield 95	com/google/android/exoplayer2/source/f:bls	Ljava/lang/String;
      //   50: invokespecial 98	com/google/android/exoplayer2/h/j:<init>	(Landroid/net/Uri;JJLjava/lang/String;)V
      //   53: invokeinterface 101 2 0
      //   58: putfield 72	com/google/android/exoplayer2/source/f$a:length	J
      //   61: aload_0
      //   62: getfield 72	com/google/android/exoplayer2/source/f$a:length	J
      //   65: ldc2_w 69
      //   68: lcmp
      //   69: ifeq +13 -> 82
      //   72: aload_0
      //   73: aload_0
      //   74: getfield 72	com/google/android/exoplayer2/source/f$a:length	J
      //   77: lload_3
      //   78: ladd
      //   79: putfield 72	com/google/android/exoplayer2/source/f$a:length	J
      //   82: new 103	com/google/android/exoplayer2/c/b
      //   85: dup
      //   86: aload_0
      //   87: getfield 55	com/google/android/exoplayer2/source/f$a:aXs	Lcom/google/android/exoplayer2/h/g;
      //   90: lload_3
      //   91: aload_0
      //   92: getfield 72	com/google/android/exoplayer2/source/f$a:length	J
      //   95: invokespecial 106	com/google/android/exoplayer2/c/b:<init>	(Lcom/google/android/exoplayer2/h/g;JJ)V
      //   98: astore 5
      //   100: aload_0
      //   101: getfield 59	com/google/android/exoplayer2/source/f$a:blv	Lcom/google/android/exoplayer2/source/f$b;
      //   104: aload 5
      //   106: aload_0
      //   107: getfield 55	com/google/android/exoplayer2/source/f$a:aXs	Lcom/google/android/exoplayer2/h/g;
      //   110: invokeinterface 110 1 0
      //   115: invokevirtual 113	com/google/android/exoplayer2/source/f$b:a	(Lcom/google/android/exoplayer2/c/f;Landroid/net/Uri;)Lcom/google/android/exoplayer2/c/e;
      //   118: astore 6
      //   120: aload_0
      //   121: getfield 68	com/google/android/exoplayer2/source/f$a:blR	Z
      //   124: ifeq +20 -> 144
      //   127: aload 6
      //   129: lload_3
      //   130: aload_0
      //   131: getfield 82	com/google/android/exoplayer2/source/f$a:blS	J
      //   134: invokeinterface 118 5 0
      //   139: aload_0
      //   140: iconst_0
      //   141: putfield 68	com/google/android/exoplayer2/source/f$a:blR	Z
      //   144: iload_1
      //   145: ifne +90 -> 235
      //   148: aload_0
      //   149: getfield 85	com/google/android/exoplayer2/source/f$a:blQ	Z
      //   152: ifne +83 -> 235
      //   155: aload_0
      //   156: getfield 61	com/google/android/exoplayer2/source/f$a:blw	Lcom/google/android/exoplayer2/i/f;
      //   159: invokevirtual 123	com/google/android/exoplayer2/i/f:block	()V
      //   162: aload 6
      //   164: aload 5
      //   166: aload_0
      //   167: getfield 66	com/google/android/exoplayer2/source/f$a:blP	Lcom/google/android/exoplayer2/c/k;
      //   170: invokeinterface 126 3 0
      //   175: istore_2
      //   176: iload_2
      //   177: istore_1
      //   178: aload 5
      //   180: invokeinterface 132 1 0
      //   185: aload_0
      //   186: getfield 31	com/google/android/exoplayer2/source/f$a:blO	Lcom/google/android/exoplayer2/source/f;
      //   189: getfield 135	com/google/android/exoplayer2/source/f:blt	J
      //   192: lload_3
      //   193: ladd
      //   194: lcmp
      //   195: ifle +171 -> 366
      //   198: aload 5
      //   200: invokeinterface 132 1 0
      //   205: lstore_3
      //   206: aload_0
      //   207: getfield 61	com/google/android/exoplayer2/source/f$a:blw	Lcom/google/android/exoplayer2/i/f;
      //   210: invokevirtual 138	com/google/android/exoplayer2/i/f:close	()Z
      //   213: pop
      //   214: aload_0
      //   215: getfield 31	com/google/android/exoplayer2/source/f$a:blO	Lcom/google/android/exoplayer2/source/f;
      //   218: getfield 142	com/google/android/exoplayer2/source/f:handler	Landroid/os/Handler;
      //   221: aload_0
      //   222: getfield 31	com/google/android/exoplayer2/source/f$a:blO	Lcom/google/android/exoplayer2/source/f;
      //   225: getfield 146	com/google/android/exoplayer2/source/f:bly	Ljava/lang/Runnable;
      //   228: invokevirtual 152	android/os/Handler:post	(Ljava/lang/Runnable;)Z
      //   231: pop
      //   232: goto -88 -> 144
      //   235: iload_1
      //   236: iconst_1
      //   237: if_icmpne +15 -> 252
      //   240: iconst_0
      //   241: istore_1
      //   242: aload_0
      //   243: getfield 55	com/google/android/exoplayer2/source/f$a:aXs	Lcom/google/android/exoplayer2/h/g;
      //   246: invokestatic 157	com/google/android/exoplayer2/i/x:a	(Lcom/google/android/exoplayer2/h/g;)V
      //   249: goto -242 -> 7
      //   252: aload_0
      //   253: getfield 66	com/google/android/exoplayer2/source/f$a:blP	Lcom/google/android/exoplayer2/c/k;
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
      //   285: getfield 66	com/google/android/exoplayer2/source/f$a:blP	Lcom/google/android/exoplayer2/c/k;
      //   288: aload 6
      //   290: invokeinterface 132 1 0
      //   295: putfield 80	com/google/android/exoplayer2/c/k:position	J
      //   298: aload_0
      //   299: getfield 55	com/google/android/exoplayer2/source/f$a:aXs	Lcom/google/android/exoplayer2/h/g;
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
    private final com.google.android.exoplayer2.c.g aXZ;
    private final com.google.android.exoplayer2.c.e[] blT;
    com.google.android.exoplayer2.c.e blU;
    
    public b(com.google.android.exoplayer2.c.e[] paramArrayOfe, com.google.android.exoplayer2.c.g paramg)
    {
      this.blT = paramArrayOfe;
      this.aXZ = paramg;
    }
    
    /* Error */
    public final com.google.android.exoplayer2.c.e a(com.google.android.exoplayer2.c.f paramf, Uri paramUri)
    {
      // Byte code:
      //   0: ldc 28
      //   2: invokestatic 34	com/tencent/matrix/trace/core/AppMethodBeat:i	(I)V
      //   5: aload_0
      //   6: getfield 36	com/google/android/exoplayer2/source/f$b:blU	Lcom/google/android/exoplayer2/c/e;
      //   9: ifnull +15 -> 24
      //   12: aload_0
      //   13: getfield 36	com/google/android/exoplayer2/source/f$b:blU	Lcom/google/android/exoplayer2/c/e;
      //   16: astore_1
      //   17: ldc 28
      //   19: invokestatic 39	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
      //   22: aload_1
      //   23: areturn
      //   24: aload_0
      //   25: getfield 20	com/google/android/exoplayer2/source/f$b:blT	[Lcom/google/android/exoplayer2/c/e;
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
      //   63: putfield 36	com/google/android/exoplayer2/source/f$b:blU	Lcom/google/android/exoplayer2/c/e;
      //   66: aload_1
      //   67: invokeinterface 49 1 0
      //   72: aload_0
      //   73: getfield 36	com/google/android/exoplayer2/source/f$b:blU	Lcom/google/android/exoplayer2/c/e;
      //   76: ifnonnull +84 -> 160
      //   79: new 51	com/google/android/exoplayer2/source/q
      //   82: dup
      //   83: new 53	java/lang/StringBuilder
      //   86: dup
      //   87: ldc 55
      //   89: invokespecial 58	java/lang/StringBuilder:<init>	(Ljava/lang/String;)V
      //   92: aload_0
      //   93: getfield 20	com/google/android/exoplayer2/source/f$b:blT	[Lcom/google/android/exoplayer2/c/e;
      //   96: invokestatic 64	com/google/android/exoplayer2/i/x:d	([Ljava/lang/Object;)Ljava/lang/String;
      //   99: invokevirtual 68	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
      //   102: ldc 70
      //   104: invokevirtual 68	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
      //   107: invokevirtual 74	java/lang/StringBuilder:toString	()Ljava/lang/String;
      //   110: aload_2
      //   111: invokespecial 77	com/google/android/exoplayer2/source/q:<init>	(Ljava/lang/String;Landroid/net/Uri;)V
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
      //   161: getfield 36	com/google/android/exoplayer2/source/f$b:blU	Lcom/google/android/exoplayer2/c/e;
      //   164: aload_0
      //   165: getfield 22	com/google/android/exoplayer2/source/f$b:aXZ	Lcom/google/android/exoplayer2/c/g;
      //   168: invokeinterface 80 2 0
      //   173: aload_0
      //   174: getfield 36	com/google/android/exoplayer2/source/f$b:blU	Lcom/google/android/exoplayer2/c/e;
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
    implements l
  {
    final int track;
    
    public d(int paramInt)
    {
      this.track = paramInt;
    }
    
    public final void Y(long paramLong)
    {
      AppMethodBeat.i(92651);
      f localf = f.this;
      int i = this.track;
      k localk = localf.blA[i];
      if ((localf.blN) && (paramLong > localk.bms.tT()))
      {
        localk.bms.ud();
        AppMethodBeat.o(92651);
        return;
      }
      localk.f(paramLong, true);
      AppMethodBeat.o(92651);
    }
    
    public final int b(com.google.android.exoplayer2.k paramk, com.google.android.exoplayer2.b.e parame, boolean paramBoolean)
    {
      AppMethodBeat.i(92650);
      f localf = f.this;
      int i = this.track;
      if ((localf.blE) || (localf.tU()))
      {
        AppMethodBeat.o(92650);
        return -3;
      }
      i = localf.blA[i].a(paramk, parame, paramBoolean, localf.blN, localf.blK);
      AppMethodBeat.o(92650);
      return i;
    }
    
    public final boolean isReady()
    {
      AppMethodBeat.i(92649);
      f localf = f.this;
      int i = this.track;
      if ((localf.blN) || ((!localf.tU()) && (localf.blA[i].bms.ub())))
      {
        AppMethodBeat.o(92649);
        return true;
      }
      AppMethodBeat.o(92649);
      return false;
    }
    
    public final void tN() {}
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.google.android.exoplayer2.source.f
 * JD-Core Version:    0.7.0.1
 */