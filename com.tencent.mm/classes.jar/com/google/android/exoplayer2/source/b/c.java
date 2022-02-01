package com.google.android.exoplayer2.source.b;

import android.net.Uri;
import android.os.SystemClock;
import android.util.SparseArray;
import com.google.android.exoplayer2.Format;
import com.google.android.exoplayer2.h.g;
import com.google.android.exoplayer2.i.u;
import com.google.android.exoplayer2.i.w;
import com.google.android.exoplayer2.i.x;
import com.google.android.exoplayer2.source.b.a.a.a;
import com.google.android.exoplayer2.source.b.a.b.a;
import com.google.android.exoplayer2.source.b.a.e;
import com.google.android.exoplayer2.source.b.a.e.a;
import com.google.android.exoplayer2.source.p;
import com.tencent.matrix.trace.core.AppMethodBeat;
import java.io.IOException;
import java.math.BigInteger;
import java.util.Arrays;
import java.util.IdentityHashMap;
import java.util.List;

final class c
{
  private byte[] aXd;
  com.google.android.exoplayer2.g.f bnC;
  IOException bnF;
  private byte[] boF;
  private final g boH;
  private final g boI;
  private final k boJ;
  private final a.a[] boK;
  private final e boL;
  final p boM;
  private final List<Format> boN;
  boolean boO;
  byte[] boP;
  private a.a boQ;
  private boolean boR;
  private Uri boS;
  private String boT;
  
  public c(e parame, a.a[] paramArrayOfa, d paramd, k paramk, List<Format> paramList)
  {
    AppMethodBeat.i(62827);
    this.boL = parame;
    this.boK = paramArrayOfa;
    this.boJ = paramk;
    this.boN = paramList;
    parame = new Format[paramArrayOfa.length];
    paramk = new int[paramArrayOfa.length];
    int i = 0;
    while (i < paramArrayOfa.length)
    {
      parame[i] = paramArrayOfa[i].aSv;
      paramk[i] = i;
      i += 1;
    }
    this.boH = paramd.uo();
    this.boI = paramd.uo();
    this.boM = new p(parame);
    this.bnC = new c(this.boM, paramk);
    AppMethodBeat.o(62827);
  }
  
  final void a(Uri paramUri, String paramString, byte[] paramArrayOfByte)
  {
    AppMethodBeat.i(62830);
    Object localObject;
    byte[] arrayOfByte;
    if (x.aV(paramString).startsWith("0x"))
    {
      localObject = paramString.substring(2);
      localObject = new BigInteger((String)localObject, 16).toByteArray();
      arrayOfByte = new byte[16];
      if (localObject.length <= 16) {
        break label119;
      }
    }
    label119:
    for (int i = localObject.length - 16;; i = 0)
    {
      System.arraycopy(localObject, i, arrayOfByte, 16 - localObject.length + i, localObject.length - i);
      this.boS = paramUri;
      this.aXd = paramArrayOfByte;
      this.boT = paramString;
      this.boF = arrayOfByte;
      AppMethodBeat.o(62830);
      return;
      localObject = paramString;
      break;
    }
  }
  
  public final void a(f paramf, long paramLong, b paramb)
  {
    AppMethodBeat.i(62829);
    int i;
    long l1;
    int k;
    label56:
    Object localObject1;
    if (paramf == null)
    {
      i = -1;
      this.boQ = null;
      if (paramf != null) {
        break label206;
      }
      l1 = 0L;
      this.bnC.aj(l1);
      j = this.bnC.vc();
      if (i == j) {
        break label241;
      }
      k = 1;
      localObject1 = this.boK[j];
      localObject2 = (e.a)this.boL.bqM.get(localObject1);
      if (((e.a)localObject2).bqW == null) {
        break label247;
      }
      l1 = SystemClock.elapsedRealtime();
      long l2 = Math.max(30000L, com.google.android.exoplayer2.b.t(((e.a)localObject2).bqW.aSz));
      if ((!((e.a)localObject2).bqW.bpZ) && (((e.a)localObject2).bqW.bpS != 2) && (((e.a)localObject2).bqW.bpS != 1) && (l2 + ((e.a)localObject2).bqX <= l1)) {
        break label247;
      }
    }
    label206:
    label241:
    label247:
    for (int m = 1;; m = 0)
    {
      if (m != 0) {
        break label253;
      }
      paramb.boW = ((a.a)localObject1);
      this.boQ = ((a.a)localObject1);
      AppMethodBeat.o(62829);
      return;
      i = this.boM.j(paramf.bmm);
      break;
      if (this.boR) {}
      for (l1 = paramf.bmq;; l1 = paramf.bmp)
      {
        l1 = Math.max(0L, l1 - paramLong);
        break;
      }
      k = 0;
      break label56;
    }
    label253:
    Object localObject2 = this.boL.c((a.a)localObject1);
    this.boR = ((com.google.android.exoplayer2.source.b.a.b)localObject2).bpY;
    Object localObject3;
    boolean bool;
    if ((paramf == null) || (k != 0))
    {
      if (paramf == null) {}
      while ((!((com.google.android.exoplayer2.source.b.a.b)localObject2).bpZ) && (paramLong >= ((com.google.android.exoplayer2.source.b.a.b)localObject2).uw()))
      {
        k = ((com.google.android.exoplayer2.source.b.a.b)localObject2).bpW + ((com.google.android.exoplayer2.source.b.a.b)localObject2).segments.size();
        localObject3 = localObject2;
        i = j;
        localObject2 = localObject1;
        j = k;
        localObject1 = localObject3;
        if (j >= ((com.google.android.exoplayer2.source.b.a.b)localObject1).bpW) {
          break label535;
        }
        this.bnF = new com.google.android.exoplayer2.source.b();
        AppMethodBeat.o(62829);
        return;
        if (this.boR) {
          paramLong = paramf.bmq;
        } else {
          paramLong = paramf.bmp;
        }
      }
      localObject3 = ((com.google.android.exoplayer2.source.b.a.b)localObject2).segments;
      l1 = ((com.google.android.exoplayer2.source.b.a.b)localObject2).bmp;
      if ((!this.boL.bqS) || (paramf == null))
      {
        bool = true;
        label423:
        k = x.a((List)localObject3, Long.valueOf(paramLong - l1), bool) + ((com.google.android.exoplayer2.source.b.a.b)localObject2).bpW;
        if ((k >= ((com.google.android.exoplayer2.source.b.a.b)localObject2).bpW) || (paramf == null)) {
          break label1031;
        }
        localObject1 = this.boK[i];
        localObject2 = this.boL.c((a.a)localObject1);
      }
    }
    for (int j = paramf.uc();; j = k)
    {
      localObject3 = localObject1;
      localObject1 = localObject2;
      localObject2 = localObject3;
      break;
      bool = false;
      break label423;
      k = paramf.uc();
      localObject3 = localObject1;
      i = j;
      localObject1 = localObject2;
      j = k;
      localObject2 = localObject3;
      break;
      label535:
      k = j - ((com.google.android.exoplayer2.source.b.a.b)localObject1).bpW;
      if (k >= ((com.google.android.exoplayer2.source.b.a.b)localObject1).segments.size())
      {
        if (((com.google.android.exoplayer2.source.b.a.b)localObject1).bpZ)
        {
          paramb.bmy = true;
          AppMethodBeat.o(62829);
          return;
        }
        paramb.boW = ((a.a)localObject2);
        this.boQ = ((a.a)localObject2);
        AppMethodBeat.o(62829);
        return;
      }
      b.a locala = (b.a)((com.google.android.exoplayer2.source.b.a.b)localObject1).segments.get(k);
      if (locala.bds)
      {
        localObject3 = w.l(((com.google.android.exoplayer2.source.b.a.b)localObject1).bqj, locala.bqf);
        if (!((Uri)localObject3).equals(this.boS))
        {
          paramf = locala.bqg;
          j = this.bnC.up();
          localObject1 = this.bnC.uq();
          localObject2 = new com.google.android.exoplayer2.h.j((Uri)localObject3, 0L, -1L, null, 1);
          paramb.bmx = new a(this.boI, (com.google.android.exoplayer2.h.j)localObject2, this.boK[i].aSv, j, localObject1, this.boP, paramf);
          AppMethodBeat.o(62829);
          return;
        }
        if (!x.g(locala.bqg, this.boT)) {
          a((Uri)localObject3, locala.bqg, this.aXd);
        }
        localObject3 = ((com.google.android.exoplayer2.source.b.a.b)localObject1).bqb;
        if (localObject3 == null) {
          break label1025;
        }
      }
      label1025:
      for (localObject3 = new com.google.android.exoplayer2.h.j(w.l(((com.google.android.exoplayer2.source.b.a.b)localObject1).bqj, ((b.a)localObject3).url), ((b.a)localObject3).bqh, ((b.a)localObject3).bqi, null);; localObject3 = null)
      {
        paramLong = ((com.google.android.exoplayer2.source.b.a.b)localObject1).bmp + locala.bqe;
        i = ((com.google.android.exoplayer2.source.b.a.b)localObject1).bpV + locala.bqd;
        k localk = this.boJ;
        u localu = (u)localk.bpK.get(i);
        if (localu == null)
        {
          localu = new u(9223372036854775807L);
          localk.bpK.put(i, localu);
        }
        for (;;)
        {
          localObject1 = new com.google.android.exoplayer2.h.j(w.l(((com.google.android.exoplayer2.source.b.a.b)localObject1).bqj, locala.url), locala.bqh, locala.bqi, null);
          paramb.bmx = new f(this.boH, (com.google.android.exoplayer2.h.j)localObject1, (com.google.android.exoplayer2.h.j)localObject3, (a.a)localObject2, this.boN, this.bnC.up(), this.bnC.uq(), paramLong, paramLong + locala.aSz, j, i, this.boO, localu, paramf, this.aXd, this.boF);
          AppMethodBeat.o(62829);
          return;
          this.boS = null;
          this.aXd = null;
          this.boT = null;
          this.boF = null;
          break;
        }
      }
      label1031:
      i = j;
    }
  }
  
  public final void tF()
  {
    AppMethodBeat.i(62828);
    if (this.bnF != null)
    {
      IOException localIOException = this.bnF;
      AppMethodBeat.o(62828);
      throw localIOException;
    }
    if (this.boQ != null) {
      this.boL.d(this.boQ);
    }
    AppMethodBeat.o(62828);
  }
  
  static final class a
    extends com.google.android.exoplayer2.source.a.j
  {
    public final String boU;
    byte[] boV;
    
    public a(g paramg, com.google.android.exoplayer2.h.j paramj, Format paramFormat, int paramInt, Object paramObject, byte[] paramArrayOfByte, String paramString)
    {
      super(paramj, paramFormat, paramInt, paramObject, paramArrayOfByte);
      this.boU = paramString;
    }
    
    public final void f(byte[] paramArrayOfByte, int paramInt)
    {
      AppMethodBeat.i(62823);
      this.boV = Arrays.copyOf(paramArrayOfByte, paramInt);
      AppMethodBeat.o(62823);
    }
  }
  
  public static final class b
  {
    public com.google.android.exoplayer2.source.a.c bmx;
    public boolean bmy;
    public a.a boW;
    
    public b()
    {
      AppMethodBeat.i(62824);
      clear();
      AppMethodBeat.o(62824);
    }
    
    public final void clear()
    {
      this.bmx = null;
      this.bmy = false;
      this.boW = null;
    }
  }
  
  static final class c
    extends com.google.android.exoplayer2.g.b
  {
    private int boX;
    
    public c(p paramp, int[] paramArrayOfInt)
    {
      super(paramArrayOfInt);
      AppMethodBeat.i(62825);
      this.boX = j(paramp.blC[0]);
      AppMethodBeat.o(62825);
    }
    
    public final void aj(long paramLong)
    {
      AppMethodBeat.i(62826);
      paramLong = SystemClock.elapsedRealtime();
      if (!l(this.boX, paramLong))
      {
        AppMethodBeat.o(62826);
        return;
      }
      int i = this.length - 1;
      while (i >= 0)
      {
        if (!l(i, paramLong))
        {
          this.boX = i;
          AppMethodBeat.o(62826);
          return;
        }
        i -= 1;
      }
      IllegalStateException localIllegalStateException = new IllegalStateException();
      AppMethodBeat.o(62826);
      throw localIllegalStateException;
    }
    
    public final int getSelectedIndex()
    {
      return this.boX;
    }
    
    public final int up()
    {
      return 0;
    }
    
    public final Object uq()
    {
      return null;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.google.android.exoplayer2.source.b.c
 * JD-Core Version:    0.7.0.1
 */