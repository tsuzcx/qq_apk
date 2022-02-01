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
import com.google.android.exoplayer2.source.o;
import com.tencent.matrix.trace.core.AppMethodBeat;
import java.io.IOException;
import java.math.BigInteger;
import java.util.IdentityHashMap;
import java.util.List;

final class c
{
  private byte[] bik;
  private final List<Format> bxA;
  boolean bxB;
  byte[] bxC;
  IOException bxD;
  private a.a bxE;
  private boolean bxF;
  private Uri bxG;
  private String bxH;
  com.google.android.exoplayer2.g.f bxI;
  private byte[] bxs;
  private final g bxu;
  private final g bxv;
  private final k bxw;
  private final a.a[] bxx;
  private final e bxy;
  final o bxz;
  
  public c(e parame, a.a[] paramArrayOfa, d paramd, k paramk, List<Format> paramList)
  {
    AppMethodBeat.i(62827);
    this.bxy = parame;
    this.bxx = paramArrayOfa;
    this.bxw = paramk;
    this.bxA = paramList;
    parame = new Format[paramArrayOfa.length];
    paramk = new int[paramArrayOfa.length];
    int i = 0;
    while (i < paramArrayOfa.length)
    {
      parame[i] = paramArrayOfa[i].bdI;
      paramk[i] = i;
      i += 1;
    }
    this.bxu = paramd.vJ();
    this.bxv = paramd.vJ();
    this.bxz = new o(parame);
    this.bxI = new c(this.bxz, paramk);
    AppMethodBeat.o(62827);
  }
  
  final void a(Uri paramUri, String paramString, byte[] paramArrayOfByte)
  {
    AppMethodBeat.i(62830);
    Object localObject;
    byte[] arrayOfByte;
    if (x.bH(paramString).startsWith("0x"))
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
      this.bxG = paramUri;
      this.bik = paramArrayOfByte;
      this.bxH = paramString;
      this.bxs = arrayOfByte;
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
      this.bxE = null;
      if (paramf != null) {
        break label206;
      }
      l1 = 0L;
      this.bxI.af(l1);
      j = this.bxI.wv();
      if (i == j) {
        break label241;
      }
      k = 1;
      localObject1 = this.bxx[j];
      localObject2 = (e.a)this.bxy.bzH.get(localObject1);
      if (((e.a)localObject2).bzR == null) {
        break label247;
      }
      l1 = SystemClock.elapsedRealtime();
      long l2 = Math.max(30000L, com.google.android.exoplayer2.b.v(((e.a)localObject2).bzR.bdM));
      if ((!((e.a)localObject2).bzR.byV) && (((e.a)localObject2).bzR.byO != 2) && (((e.a)localObject2).bzR.byO != 1) && (l2 + ((e.a)localObject2).bzS <= l1)) {
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
      paramb.bxM = ((a.a)localObject1);
      this.bxE = ((a.a)localObject1);
      AppMethodBeat.o(62829);
      return;
      i = this.bxz.j(paramf.bxj);
      break;
      if (this.bxF) {}
      for (l1 = paramf.bxn;; l1 = paramf.bxm)
      {
        l1 = Math.max(0L, l1 - paramLong);
        break;
      }
      k = 0;
      break label56;
    }
    label253:
    Object localObject2 = this.bxy.c((a.a)localObject1);
    this.bxF = ((com.google.android.exoplayer2.source.b.a.b)localObject2).byU;
    Object localObject3;
    boolean bool;
    if ((paramf == null) || (k != 0))
    {
      if (paramf == null) {}
      while ((!((com.google.android.exoplayer2.source.b.a.b)localObject2).byV) && (paramLong >= ((com.google.android.exoplayer2.source.b.a.b)localObject2).vR()))
      {
        k = ((com.google.android.exoplayer2.source.b.a.b)localObject2).byS + ((com.google.android.exoplayer2.source.b.a.b)localObject2).segments.size();
        localObject3 = localObject2;
        i = j;
        localObject2 = localObject1;
        j = k;
        localObject1 = localObject3;
        if (j >= ((com.google.android.exoplayer2.source.b.a.b)localObject1).byS) {
          break label539;
        }
        this.bxD = new com.google.android.exoplayer2.source.b();
        AppMethodBeat.o(62829);
        return;
        if (this.bxF) {
          paramLong = paramf.bxn;
        } else {
          paramLong = paramf.bxm;
        }
      }
      localObject3 = ((com.google.android.exoplayer2.source.b.a.b)localObject2).segments;
      l1 = ((com.google.android.exoplayer2.source.b.a.b)localObject2).bxm;
      if ((!this.bxy.bzN) || (paramf == null))
      {
        bool = true;
        label423:
        k = x.a((List)localObject3, Long.valueOf(paramLong - l1), bool) + ((com.google.android.exoplayer2.source.b.a.b)localObject2).byS;
        if ((k >= ((com.google.android.exoplayer2.source.b.a.b)localObject2).byS) || (paramf == null)) {
          break label1035;
        }
        localObject1 = this.bxx[i];
        localObject2 = this.bxy.c((a.a)localObject1);
      }
    }
    for (int j = paramf.bxo + 1;; j = k)
    {
      localObject3 = localObject1;
      localObject1 = localObject2;
      localObject2 = localObject3;
      break;
      bool = false;
      break label423;
      k = paramf.bxo + 1;
      localObject3 = localObject1;
      i = j;
      localObject1 = localObject2;
      j = k;
      localObject2 = localObject3;
      break;
      label539:
      k = j - ((com.google.android.exoplayer2.source.b.a.b)localObject1).byS;
      if (k >= ((com.google.android.exoplayer2.source.b.a.b)localObject1).segments.size())
      {
        if (((com.google.android.exoplayer2.source.b.a.b)localObject1).byV)
        {
          paramb.bxL = true;
          AppMethodBeat.o(62829);
          return;
        }
        paramb.bxM = ((a.a)localObject2);
        this.bxE = ((a.a)localObject2);
        AppMethodBeat.o(62829);
        return;
      }
      b.a locala = (b.a)((com.google.android.exoplayer2.source.b.a.b)localObject1).segments.get(k);
      if (locala.boz)
      {
        localObject3 = w.m(((com.google.android.exoplayer2.source.b.a.b)localObject1).bze, locala.bza);
        if (!((Uri)localObject3).equals(this.bxG))
        {
          paramf = locala.bzb;
          j = this.bxI.vK();
          localObject1 = this.bxI.vL();
          localObject2 = new j((Uri)localObject3, 0L, -1L, null, 1);
          paramb.bxK = new c.a(this.bxv, (j)localObject2, this.bxx[i].bdI, j, localObject1, this.bxC, paramf);
          AppMethodBeat.o(62829);
          return;
        }
        if (!x.i(locala.bzb, this.bxH)) {
          a((Uri)localObject3, locala.bzb, this.bik);
        }
        localObject3 = ((com.google.android.exoplayer2.source.b.a.b)localObject1).byX;
        if (localObject3 == null) {
          break label1029;
        }
      }
      label1029:
      for (localObject3 = new j(w.m(((com.google.android.exoplayer2.source.b.a.b)localObject1).bze, ((b.a)localObject3).url), ((b.a)localObject3).bzc, ((b.a)localObject3).bzd, null);; localObject3 = null)
      {
        paramLong = ((com.google.android.exoplayer2.source.b.a.b)localObject1).bxm + locala.byZ;
        i = ((com.google.android.exoplayer2.source.b.a.b)localObject1).byR + locala.byY;
        k localk = this.bxw;
        u localu = (u)localk.byH.get(i);
        if (localu == null)
        {
          localu = new u(9223372036854775807L);
          localk.byH.put(i, localu);
        }
        for (;;)
        {
          localObject1 = new j(w.m(((com.google.android.exoplayer2.source.b.a.b)localObject1).bze, locala.url), locala.bzc, locala.bzd, null);
          paramb.bxK = new f(this.bxu, (j)localObject1, (j)localObject3, (a.a)localObject2, this.bxA, this.bxI.vK(), this.bxI.vL(), paramLong, paramLong + locala.bdM, j, i, this.bxB, localu, paramf, this.bik, this.bxs);
          AppMethodBeat.o(62829);
          return;
          this.bxG = null;
          this.bik = null;
          this.bxH = null;
          this.bxs = null;
          break;
        }
      }
      label1035:
      i = j;
    }
  }
  
  public final void vm()
  {
    AppMethodBeat.i(62828);
    if (this.bxD != null)
    {
      IOException localIOException = this.bxD;
      AppMethodBeat.o(62828);
      throw localIOException;
    }
    if (this.bxE != null) {
      this.bxy.d(this.bxE);
    }
    AppMethodBeat.o(62828);
  }
  
  public static final class b
  {
    public a bxK;
    public boolean bxL;
    public a.a bxM;
    
    public b()
    {
      AppMethodBeat.i(62824);
      clear();
      AppMethodBeat.o(62824);
    }
    
    public final void clear()
    {
      this.bxK = null;
      this.bxL = false;
      this.bxM = null;
    }
  }
  
  static final class c
    extends com.google.android.exoplayer2.g.b
  {
    private int bxN;
    
    public c(o paramo, int[] paramArrayOfInt)
    {
      super(paramArrayOfInt);
      AppMethodBeat.i(62825);
      this.bxN = j(paramo.bwC[0]);
      AppMethodBeat.o(62825);
    }
    
    public final void af(long paramLong)
    {
      AppMethodBeat.i(62826);
      paramLong = SystemClock.elapsedRealtime();
      if (!k(this.bxN, paramLong))
      {
        AppMethodBeat.o(62826);
        return;
      }
      int i = this.length - 1;
      while (i >= 0)
      {
        if (!k(i, paramLong))
        {
          this.bxN = i;
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
      return this.bxN;
    }
    
    public final int vK()
    {
      return 0;
    }
    
    public final Object vL()
    {
      return null;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.google.android.exoplayer2.source.b.c
 * JD-Core Version:    0.7.0.1
 */