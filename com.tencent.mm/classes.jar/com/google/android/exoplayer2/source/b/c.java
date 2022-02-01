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
import java.util.IdentityHashMap;
import java.util.List;

final class c
{
  private byte[] bih;
  final q bxA;
  private final List<Format> bxB;
  boolean bxC;
  byte[] bxD;
  IOException bxE;
  private a.a bxF;
  private boolean bxG;
  private Uri bxH;
  private String bxI;
  com.google.android.exoplayer2.g.f bxJ;
  private byte[] bxt;
  private final g bxv;
  private final g bxw;
  private final k bxx;
  private final a.a[] bxy;
  private final e bxz;
  
  public c(e parame, a.a[] paramArrayOfa, d paramd, k paramk, List<Format> paramList)
  {
    AppMethodBeat.i(62827);
    this.bxz = parame;
    this.bxy = paramArrayOfa;
    this.bxx = paramk;
    this.bxB = paramList;
    parame = new Format[paramArrayOfa.length];
    paramk = new int[paramArrayOfa.length];
    int i = 0;
    while (i < paramArrayOfa.length)
    {
      parame[i] = paramArrayOfa[i].bdF;
      paramk[i] = i;
      i += 1;
    }
    this.bxv = paramd.vO();
    this.bxw = paramd.vO();
    this.bxA = new q(parame);
    this.bxJ = new c(this.bxA, paramk);
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
      this.bxH = paramUri;
      this.bih = paramArrayOfByte;
      this.bxI = paramString;
      this.bxt = arrayOfByte;
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
      this.bxF = null;
      if (paramf != null) {
        break label206;
      }
      l1 = 0L;
      this.bxJ.af(l1);
      j = this.bxJ.wA();
      if (i == j) {
        break label241;
      }
      k = 1;
      localObject1 = this.bxy[j];
      localObject2 = (e.a)this.bxz.bzJ.get(localObject1);
      if (((e.a)localObject2).bzT == null) {
        break label247;
      }
      l1 = SystemClock.elapsedRealtime();
      long l2 = Math.max(30000L, com.google.android.exoplayer2.b.v(((e.a)localObject2).bzT.bdJ));
      if ((!((e.a)localObject2).bzT.byX) && (((e.a)localObject2).bzT.byQ != 2) && (((e.a)localObject2).bzT.byQ != 1) && (l2 + ((e.a)localObject2).bzU <= l1)) {
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
      paramb.bxO = ((a.a)localObject1);
      this.bxF = ((a.a)localObject1);
      AppMethodBeat.o(62829);
      return;
      i = this.bxA.j(paramf.bxk);
      break;
      if (this.bxG) {}
      for (l1 = paramf.bxo;; l1 = paramf.bxn)
      {
        l1 = Math.max(0L, l1 - paramLong);
        break;
      }
      k = 0;
      break label56;
    }
    label253:
    Object localObject2 = this.bxz.c((a.a)localObject1);
    this.bxG = ((com.google.android.exoplayer2.source.b.a.b)localObject2).byW;
    Object localObject3;
    boolean bool;
    if ((paramf == null) || (k != 0))
    {
      if (paramf == null) {}
      while ((!((com.google.android.exoplayer2.source.b.a.b)localObject2).byX) && (paramLong >= ((com.google.android.exoplayer2.source.b.a.b)localObject2).vW()))
      {
        k = ((com.google.android.exoplayer2.source.b.a.b)localObject2).byU + ((com.google.android.exoplayer2.source.b.a.b)localObject2).segments.size();
        localObject3 = localObject2;
        i = j;
        localObject2 = localObject1;
        j = k;
        localObject1 = localObject3;
        if (j >= ((com.google.android.exoplayer2.source.b.a.b)localObject1).byU) {
          break label539;
        }
        this.bxE = new com.google.android.exoplayer2.source.c();
        AppMethodBeat.o(62829);
        return;
        if (this.bxG) {
          paramLong = paramf.bxo;
        } else {
          paramLong = paramf.bxn;
        }
      }
      localObject3 = ((com.google.android.exoplayer2.source.b.a.b)localObject2).segments;
      l1 = ((com.google.android.exoplayer2.source.b.a.b)localObject2).bxn;
      if ((!this.bxz.bzP) || (paramf == null))
      {
        bool = true;
        label423:
        k = x.a((List)localObject3, Long.valueOf(paramLong - l1), bool) + ((com.google.android.exoplayer2.source.b.a.b)localObject2).byU;
        if ((k >= ((com.google.android.exoplayer2.source.b.a.b)localObject2).byU) || (paramf == null)) {
          break label1035;
        }
        localObject1 = this.bxy[i];
        localObject2 = this.bxz.c((a.a)localObject1);
      }
    }
    for (int j = paramf.bxp + 1;; j = k)
    {
      localObject3 = localObject1;
      localObject1 = localObject2;
      localObject2 = localObject3;
      break;
      bool = false;
      break label423;
      k = paramf.bxp + 1;
      localObject3 = localObject1;
      i = j;
      localObject1 = localObject2;
      j = k;
      localObject2 = localObject3;
      break;
      label539:
      k = j - ((com.google.android.exoplayer2.source.b.a.b)localObject1).byU;
      if (k >= ((com.google.android.exoplayer2.source.b.a.b)localObject1).segments.size())
      {
        if (((com.google.android.exoplayer2.source.b.a.b)localObject1).byX)
        {
          paramb.bxN = true;
          AppMethodBeat.o(62829);
          return;
        }
        paramb.bxO = ((a.a)localObject2);
        this.bxF = ((a.a)localObject2);
        AppMethodBeat.o(62829);
        return;
      }
      b.a locala = (b.a)((com.google.android.exoplayer2.source.b.a.b)localObject1).segments.get(k);
      if (locala.bou)
      {
        localObject3 = w.m(((com.google.android.exoplayer2.source.b.a.b)localObject1).bzg, locala.bzc);
        if (!((Uri)localObject3).equals(this.bxH))
        {
          paramf = locala.bzd;
          j = this.bxJ.vP();
          localObject1 = this.bxJ.vQ();
          localObject2 = new j((Uri)localObject3, 0L, -1L, null, 1);
          paramb.bxM = new c.a(this.bxw, (j)localObject2, this.bxy[i].bdF, j, localObject1, this.bxD, paramf);
          AppMethodBeat.o(62829);
          return;
        }
        if (!x.j(locala.bzd, this.bxI)) {
          a((Uri)localObject3, locala.bzd, this.bih);
        }
        localObject3 = ((com.google.android.exoplayer2.source.b.a.b)localObject1).byZ;
        if (localObject3 == null) {
          break label1029;
        }
      }
      label1029:
      for (localObject3 = new j(w.m(((com.google.android.exoplayer2.source.b.a.b)localObject1).bzg, ((b.a)localObject3).url), ((b.a)localObject3).bze, ((b.a)localObject3).bzf, null);; localObject3 = null)
      {
        paramLong = ((com.google.android.exoplayer2.source.b.a.b)localObject1).bxn + locala.bzb;
        i = ((com.google.android.exoplayer2.source.b.a.b)localObject1).byT + locala.bza;
        k localk = this.bxx;
        u localu = (u)localk.byJ.get(i);
        if (localu == null)
        {
          localu = new u(9223372036854775807L);
          localk.byJ.put(i, localu);
        }
        for (;;)
        {
          localObject1 = new j(w.m(((com.google.android.exoplayer2.source.b.a.b)localObject1).bzg, locala.url), locala.bze, locala.bzf, null);
          paramb.bxM = new f(this.bxv, (j)localObject1, (j)localObject3, (a.a)localObject2, this.bxB, this.bxJ.vP(), this.bxJ.vQ(), paramLong, paramLong + locala.bdJ, j, i, this.bxC, localu, paramf, this.bih, this.bxt);
          AppMethodBeat.o(62829);
          return;
          this.bxH = null;
          this.bih = null;
          this.bxI = null;
          this.bxt = null;
          break;
        }
      }
      label1035:
      i = j;
    }
  }
  
  public final void vs()
  {
    AppMethodBeat.i(62828);
    if (this.bxE != null)
    {
      IOException localIOException = this.bxE;
      AppMethodBeat.o(62828);
      throw localIOException;
    }
    if (this.bxF != null) {
      this.bxz.d(this.bxF);
    }
    AppMethodBeat.o(62828);
  }
  
  public static final class b
  {
    public a bxM;
    public boolean bxN;
    public a.a bxO;
    
    public b()
    {
      AppMethodBeat.i(62824);
      clear();
      AppMethodBeat.o(62824);
    }
    
    public final void clear()
    {
      this.bxM = null;
      this.bxN = false;
      this.bxO = null;
    }
  }
  
  static final class c
    extends com.google.android.exoplayer2.g.b
  {
    private int bxP;
    
    public c(q paramq, int[] paramArrayOfInt)
    {
      super(paramArrayOfInt);
      AppMethodBeat.i(62825);
      this.bxP = j(paramq.bwD[0]);
      AppMethodBeat.o(62825);
    }
    
    public final void af(long paramLong)
    {
      AppMethodBeat.i(62826);
      paramLong = SystemClock.elapsedRealtime();
      if (!l(this.bxP, paramLong))
      {
        AppMethodBeat.o(62826);
        return;
      }
      int i = this.length - 1;
      while (i >= 0)
      {
        if (!l(i, paramLong))
        {
          this.bxP = i;
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
      return this.bxP;
    }
    
    public final int vP()
    {
      return 0;
    }
    
    public final Object vQ()
    {
      return null;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes8.jar
 * Qualified Name:     com.google.android.exoplayer2.source.b.c
 * JD-Core Version:    0.7.0.1
 */