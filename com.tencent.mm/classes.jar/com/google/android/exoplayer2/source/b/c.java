package com.google.android.exoplayer2.source.b;

import android.net.Uri;
import android.os.SystemClock;
import android.util.SparseArray;
import com.google.android.exoplayer2.Format;
import com.google.android.exoplayer2.h.g;
import com.google.android.exoplayer2.h.j;
import com.google.android.exoplayer2.i.u;
import com.google.android.exoplayer2.i.w;
import com.google.android.exoplayer2.i.x;
import com.google.android.exoplayer2.source.a.a;
import com.google.android.exoplayer2.source.b.a.a.a;
import com.google.android.exoplayer2.source.b.a.b.a;
import com.google.android.exoplayer2.source.b.a.e;
import com.google.android.exoplayer2.source.b.a.e.a;
import com.google.android.exoplayer2.source.q;
import com.tencent.matrix.trace.core.AppMethodBeat;
import java.io.IOException;
import java.math.BigInteger;
import java.util.Arrays;
import java.util.IdentityHashMap;
import java.util.List;

final class c
{
  private byte[] aRL;
  private byte[] bgV;
  private final g bgX;
  private final g bgY;
  private final k bgZ;
  private final a.a[] bha;
  private final e bhb;
  final q bhc;
  private final List<Format> bhd;
  boolean bhe;
  byte[] bhf;
  IOException bhg;
  private a.a bhh;
  private boolean bhi;
  private Uri bhj;
  private String bhk;
  com.google.android.exoplayer2.g.f bhl;
  
  public c(e parame, a.a[] paramArrayOfa, d paramd, k paramk, List<Format> paramList)
  {
    AppMethodBeat.i(62827);
    this.bhb = parame;
    this.bha = paramArrayOfa;
    this.bgZ = paramk;
    this.bhd = paramList;
    parame = new Format[paramArrayOfa.length];
    paramk = new int[paramArrayOfa.length];
    int i = 0;
    while (i < paramArrayOfa.length)
    {
      parame[i] = paramArrayOfa[i].aNg;
      paramk[i] = i;
      i += 1;
    }
    this.bgX = paramd.tM();
    this.bgY = paramd.tM();
    this.bhc = new q(parame);
    this.bhl = new c(this.bhc, paramk);
    AppMethodBeat.o(62827);
  }
  
  final void a(Uri paramUri, String paramString, byte[] paramArrayOfByte)
  {
    AppMethodBeat.i(62830);
    Object localObject;
    byte[] arrayOfByte;
    if (x.bS(paramString).startsWith("0x"))
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
      this.bhj = paramUri;
      this.aRL = paramArrayOfByte;
      this.bhk = paramString;
      this.bgV = arrayOfByte;
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
      this.bhh = null;
      if (paramf != null) {
        break label206;
      }
      l1 = 0L;
      this.bhl.ai(l1);
      j = this.bhl.uB();
      if (i == j) {
        break label241;
      }
      k = 1;
      localObject1 = this.bha[j];
      localObject2 = (e.a)this.bhb.bjk.get(localObject1);
      if (((e.a)localObject2).bju == null) {
        break label247;
      }
      l1 = SystemClock.elapsedRealtime();
      long l2 = Math.max(30000L, com.google.android.exoplayer2.b.y(((e.a)localObject2).bju.aNk));
      if ((!((e.a)localObject2).bju.biy) && (((e.a)localObject2).bju.bir != 2) && (((e.a)localObject2).bju.bir != 1) && (l2 + ((e.a)localObject2).bjv <= l1)) {
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
      paramb.bhq = ((a.a)localObject1);
      this.bhh = ((a.a)localObject1);
      AppMethodBeat.o(62829);
      return;
      i = this.bhc.j(paramf.bgM);
      break;
      if (this.bhi) {}
      for (l1 = paramf.bgQ;; l1 = paramf.bgP)
      {
        l1 = Math.max(0L, l1 - paramLong);
        break;
      }
      k = 0;
      break label56;
    }
    label253:
    Object localObject2 = this.bhb.c((a.a)localObject1);
    this.bhi = ((com.google.android.exoplayer2.source.b.a.b)localObject2).bix;
    Object localObject3;
    boolean bool;
    if ((paramf == null) || (k != 0))
    {
      if (paramf == null) {}
      while ((!((com.google.android.exoplayer2.source.b.a.b)localObject2).biy) && (paramLong >= ((com.google.android.exoplayer2.source.b.a.b)localObject2).tU()))
      {
        k = ((com.google.android.exoplayer2.source.b.a.b)localObject2).biv + ((com.google.android.exoplayer2.source.b.a.b)localObject2).segments.size();
        localObject3 = localObject2;
        i = j;
        localObject2 = localObject1;
        j = k;
        localObject1 = localObject3;
        if (j >= ((com.google.android.exoplayer2.source.b.a.b)localObject1).biv) {
          break label539;
        }
        this.bhg = new com.google.android.exoplayer2.source.c();
        AppMethodBeat.o(62829);
        return;
        if (this.bhi) {
          paramLong = paramf.bgQ;
        } else {
          paramLong = paramf.bgP;
        }
      }
      localObject3 = ((com.google.android.exoplayer2.source.b.a.b)localObject2).segments;
      l1 = ((com.google.android.exoplayer2.source.b.a.b)localObject2).bgP;
      if ((!this.bhb.bjq) || (paramf == null))
      {
        bool = true;
        label423:
        k = x.a((List)localObject3, Long.valueOf(paramLong - l1), bool) + ((com.google.android.exoplayer2.source.b.a.b)localObject2).biv;
        if ((k >= ((com.google.android.exoplayer2.source.b.a.b)localObject2).biv) || (paramf == null)) {
          break label1035;
        }
        localObject1 = this.bha[i];
        localObject2 = this.bhb.c((a.a)localObject1);
      }
    }
    for (int j = paramf.bgR + 1;; j = k)
    {
      localObject3 = localObject1;
      localObject1 = localObject2;
      localObject2 = localObject3;
      break;
      bool = false;
      break label423;
      k = paramf.bgR + 1;
      localObject3 = localObject1;
      i = j;
      localObject1 = localObject2;
      j = k;
      localObject2 = localObject3;
      break;
      label539:
      k = j - ((com.google.android.exoplayer2.source.b.a.b)localObject1).biv;
      if (k >= ((com.google.android.exoplayer2.source.b.a.b)localObject1).segments.size())
      {
        if (((com.google.android.exoplayer2.source.b.a.b)localObject1).biy)
        {
          paramb.bhp = true;
          AppMethodBeat.o(62829);
          return;
        }
        paramb.bhq = ((a.a)localObject2);
        this.bhh = ((a.a)localObject2);
        AppMethodBeat.o(62829);
        return;
      }
      b.a locala = (b.a)((com.google.android.exoplayer2.source.b.a.b)localObject1).segments.get(k);
      if (locala.aXW)
      {
        localObject3 = w.q(((com.google.android.exoplayer2.source.b.a.b)localObject1).biH, locala.biD);
        if (!((Uri)localObject3).equals(this.bhj))
        {
          paramf = locala.biE;
          j = this.bhl.tN();
          localObject1 = this.bhl.tO();
          localObject2 = new j((Uri)localObject3, 0L, -1L, null, 1);
          paramb.bho = new a(this.bgY, (j)localObject2, this.bha[i].aNg, j, localObject1, this.bhf, paramf);
          AppMethodBeat.o(62829);
          return;
        }
        if (!x.h(locala.biE, this.bhk)) {
          a((Uri)localObject3, locala.biE, this.aRL);
        }
        localObject3 = ((com.google.android.exoplayer2.source.b.a.b)localObject1).biA;
        if (localObject3 == null) {
          break label1029;
        }
      }
      label1029:
      for (localObject3 = new j(w.q(((com.google.android.exoplayer2.source.b.a.b)localObject1).biH, ((b.a)localObject3).url), ((b.a)localObject3).biF, ((b.a)localObject3).biG, null);; localObject3 = null)
      {
        paramLong = ((com.google.android.exoplayer2.source.b.a.b)localObject1).bgP + locala.biC;
        i = ((com.google.android.exoplayer2.source.b.a.b)localObject1).biu + locala.biB;
        k localk = this.bgZ;
        u localu = (u)localk.bik.get(i);
        if (localu == null)
        {
          localu = new u(9223372036854775807L);
          localk.bik.put(i, localu);
        }
        for (;;)
        {
          localObject1 = new j(w.q(((com.google.android.exoplayer2.source.b.a.b)localObject1).biH, locala.url), locala.biF, locala.biG, null);
          paramb.bho = new f(this.bgX, (j)localObject1, (j)localObject3, (a.a)localObject2, this.bhd, this.bhl.tN(), this.bhl.tO(), paramLong, paramLong + locala.aNk, j, i, this.bhe, localu, paramf, this.aRL, this.bgV);
          AppMethodBeat.o(62829);
          return;
          this.bhj = null;
          this.aRL = null;
          this.bhk = null;
          this.bgV = null;
          break;
        }
      }
      label1035:
      i = j;
    }
  }
  
  public final void tq()
  {
    AppMethodBeat.i(62828);
    if (this.bhg != null)
    {
      IOException localIOException = this.bhg;
      AppMethodBeat.o(62828);
      throw localIOException;
    }
    if (this.bhh != null) {
      this.bhb.d(this.bhh);
    }
    AppMethodBeat.o(62828);
  }
  
  static final class a
    extends com.google.android.exoplayer2.source.a.c
  {
    public final String bhm;
    byte[] bhn;
    
    public a(g paramg, j paramj, Format paramFormat, int paramInt, Object paramObject, byte[] paramArrayOfByte, String paramString)
    {
      super(paramj, paramFormat, paramInt, paramObject, paramArrayOfByte);
      this.bhm = paramString;
    }
    
    public final void f(byte[] paramArrayOfByte, int paramInt)
    {
      AppMethodBeat.i(62823);
      this.bhn = Arrays.copyOf(paramArrayOfByte, paramInt);
      AppMethodBeat.o(62823);
    }
  }
  
  public static final class b
  {
    public a bho;
    public boolean bhp;
    public a.a bhq;
    
    public b()
    {
      AppMethodBeat.i(62824);
      clear();
      AppMethodBeat.o(62824);
    }
    
    public final void clear()
    {
      this.bho = null;
      this.bhp = false;
      this.bhq = null;
    }
  }
  
  static final class c
    extends com.google.android.exoplayer2.g.b
  {
    private int bhr;
    
    public c(q paramq, int[] paramArrayOfInt)
    {
      super(paramArrayOfInt);
      AppMethodBeat.i(62825);
      this.bhr = j(paramq.bgf[0]);
      AppMethodBeat.o(62825);
    }
    
    public final void ai(long paramLong)
    {
      AppMethodBeat.i(62826);
      paramLong = SystemClock.elapsedRealtime();
      if (!l(this.bhr, paramLong))
      {
        AppMethodBeat.o(62826);
        return;
      }
      int i = this.length - 1;
      while (i >= 0)
      {
        if (!l(i, paramLong))
        {
          this.bhr = i;
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
      return this.bhr;
    }
    
    public final int tN()
    {
      return 0;
    }
    
    public final Object tO()
    {
      return null;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes9.jar
 * Qualified Name:     com.google.android.exoplayer2.source.b.c
 * JD-Core Version:    0.7.0.1
 */