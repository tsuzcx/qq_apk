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
  private byte[] aBL;
  private byte[] aQS;
  private final g aQU;
  private final g aQV;
  private final k aQW;
  private final a.a[] aQX;
  private final e aQY;
  final o aQZ;
  private final List<Format> aRa;
  boolean aRb;
  byte[] aRc;
  IOException aRd;
  private a.a aRe;
  private boolean aRf;
  private Uri aRg;
  private String aRh;
  com.google.android.exoplayer2.g.f aRi;
  
  public c(e parame, a.a[] paramArrayOfa, d paramd, k paramk, List<Format> paramList)
  {
    AppMethodBeat.i(125903);
    this.aQY = parame;
    this.aQX = paramArrayOfa;
    this.aQW = paramk;
    this.aRa = paramList;
    parame = new Format[paramArrayOfa.length];
    paramk = new int[paramArrayOfa.length];
    int i = 0;
    while (i < paramArrayOfa.length)
    {
      parame[i] = paramArrayOfa[i].axd;
      paramk[i] = i;
      i += 1;
    }
    this.aQU = paramd.pu();
    this.aQV = paramd.pu();
    this.aQZ = new o(parame);
    this.aRi = new c.c(this.aQZ, paramk);
    AppMethodBeat.o(125903);
  }
  
  final void a(Uri paramUri, String paramString, byte[] paramArrayOfByte)
  {
    AppMethodBeat.i(125906);
    Object localObject;
    byte[] arrayOfByte;
    if (x.aQ(paramString).startsWith("0x"))
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
      this.aRg = paramUri;
      this.aBL = paramArrayOfByte;
      this.aRh = paramString;
      this.aQS = arrayOfByte;
      AppMethodBeat.o(125906);
      return;
      localObject = paramString;
      break;
    }
  }
  
  public final void a(f paramf, long paramLong, c.b paramb)
  {
    AppMethodBeat.i(125905);
    int i;
    long l1;
    int k;
    label56:
    Object localObject1;
    if (paramf == null)
    {
      i = -1;
      this.aRe = null;
      if (paramf != null) {
        break label206;
      }
      l1 = 0L;
      this.aRi.Y(l1);
      j = this.aRi.qi();
      if (i == j) {
        break label241;
      }
      k = 1;
      localObject1 = this.aQX[j];
      localObject2 = (e.a)this.aQY.aTj.get(localObject1);
      if (((e.a)localObject2).aTu == null) {
        break label247;
      }
      l1 = SystemClock.elapsedRealtime();
      long l2 = Math.max(30000L, com.google.android.exoplayer2.b.o(((e.a)localObject2).aTu.axh));
      if ((!((e.a)localObject2).aTu.aSw) && (((e.a)localObject2).aTu.aSp != 2) && (((e.a)localObject2).aTu.aSp != 1) && (l2 + ((e.a)localObject2).aTv <= l1)) {
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
      paramb.aRm = ((a.a)localObject1);
      this.aRe = ((a.a)localObject1);
      AppMethodBeat.o(125905);
      return;
      i = this.aQZ.j(paramf.aQJ);
      break;
      if (this.aRf) {}
      for (l1 = paramf.aQN;; l1 = paramf.aQM)
      {
        l1 = Math.max(0L, l1 - paramLong);
        break;
      }
      k = 0;
      break label56;
    }
    label253:
    Object localObject2 = this.aQY.c((a.a)localObject1);
    this.aRf = ((com.google.android.exoplayer2.source.b.a.b)localObject2).aSv;
    Object localObject3;
    boolean bool;
    if ((paramf == null) || (k != 0))
    {
      if (paramf == null) {}
      while ((!((com.google.android.exoplayer2.source.b.a.b)localObject2).aSw) && (paramLong >= ((com.google.android.exoplayer2.source.b.a.b)localObject2).pD()))
      {
        k = ((com.google.android.exoplayer2.source.b.a.b)localObject2).aSt + ((com.google.android.exoplayer2.source.b.a.b)localObject2).aSz.size();
        localObject3 = localObject2;
        i = j;
        localObject2 = localObject1;
        j = k;
        localObject1 = localObject3;
        if (j >= ((com.google.android.exoplayer2.source.b.a.b)localObject1).aSt) {
          break label539;
        }
        this.aRd = new com.google.android.exoplayer2.source.b();
        AppMethodBeat.o(125905);
        return;
        if (this.aRf) {
          paramLong = paramf.aQN;
        } else {
          paramLong = paramf.aQM;
        }
      }
      localObject3 = ((com.google.android.exoplayer2.source.b.a.b)localObject2).aSz;
      l1 = ((com.google.android.exoplayer2.source.b.a.b)localObject2).aQM;
      if ((!this.aQY.aTq) || (paramf == null))
      {
        bool = true;
        label423:
        k = x.a((List)localObject3, Long.valueOf(paramLong - l1), bool) + ((com.google.android.exoplayer2.source.b.a.b)localObject2).aSt;
        if ((k >= ((com.google.android.exoplayer2.source.b.a.b)localObject2).aSt) || (paramf == null)) {
          break label1035;
        }
        localObject1 = this.aQX[i];
        localObject2 = this.aQY.c((a.a)localObject1);
      }
    }
    for (int j = paramf.aQO + 1;; j = k)
    {
      localObject3 = localObject1;
      localObject1 = localObject2;
      localObject2 = localObject3;
      break;
      bool = false;
      break label423;
      k = paramf.aQO + 1;
      localObject3 = localObject1;
      i = j;
      localObject1 = localObject2;
      j = k;
      localObject2 = localObject3;
      break;
      label539:
      k = j - ((com.google.android.exoplayer2.source.b.a.b)localObject1).aSt;
      if (k >= ((com.google.android.exoplayer2.source.b.a.b)localObject1).aSz.size())
      {
        if (((com.google.android.exoplayer2.source.b.a.b)localObject1).aSw)
        {
          paramb.aRl = true;
          AppMethodBeat.o(125905);
          return;
        }
        paramb.aRm = ((a.a)localObject2);
        this.aRe = ((a.a)localObject2);
        AppMethodBeat.o(125905);
        return;
      }
      b.a locala = (b.a)((com.google.android.exoplayer2.source.b.a.b)localObject1).aSz.get(k);
      if (locala.aIa)
      {
        localObject3 = w.m(((com.google.android.exoplayer2.source.b.a.b)localObject1).aSG, locala.aSC);
        if (!((Uri)localObject3).equals(this.aRg))
        {
          paramf = locala.aSD;
          j = this.aRi.pw();
          localObject1 = this.aRi.px();
          localObject2 = new j((Uri)localObject3, 0L, -1L, null, 1);
          paramb.aRk = new c.a(this.aQV, (j)localObject2, this.aQX[i].axd, j, localObject1, this.aRc, paramf);
          AppMethodBeat.o(125905);
          return;
        }
        if (!x.e(locala.aSD, this.aRh)) {
          a((Uri)localObject3, locala.aSD, this.aBL);
        }
        localObject3 = ((com.google.android.exoplayer2.source.b.a.b)localObject1).aSy;
        if (localObject3 == null) {
          break label1029;
        }
      }
      label1029:
      for (localObject3 = new j(w.m(((com.google.android.exoplayer2.source.b.a.b)localObject1).aSG, ((b.a)localObject3).url), ((b.a)localObject3).aSE, ((b.a)localObject3).aSF, null);; localObject3 = null)
      {
        paramLong = ((com.google.android.exoplayer2.source.b.a.b)localObject1).aQM + locala.aSB;
        i = ((com.google.android.exoplayer2.source.b.a.b)localObject1).aSs + locala.aSA;
        k localk = this.aQW;
        u localu = (u)localk.aSh.get(i);
        if (localu == null)
        {
          localu = new u(9223372036854775807L);
          localk.aSh.put(i, localu);
        }
        for (;;)
        {
          localObject1 = new j(w.m(((com.google.android.exoplayer2.source.b.a.b)localObject1).aSG, locala.url), locala.aSE, locala.aSF, null);
          paramb.aRk = new f(this.aQU, (j)localObject1, (j)localObject3, (a.a)localObject2, this.aRa, this.aRi.pw(), this.aRi.px(), paramLong, paramLong + locala.axh, j, i, this.aRb, localu, paramf, this.aBL, this.aQS);
          AppMethodBeat.o(125905);
          return;
          this.aRg = null;
          this.aBL = null;
          this.aRh = null;
          this.aQS = null;
          break;
        }
      }
      label1035:
      i = j;
    }
  }
  
  public final void oX()
  {
    AppMethodBeat.i(125904);
    if (this.aRd != null)
    {
      IOException localIOException = this.aRd;
      AppMethodBeat.o(125904);
      throw localIOException;
    }
    if (this.aRe != null) {
      this.aQY.d(this.aRe);
    }
    AppMethodBeat.o(125904);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.google.android.exoplayer2.source.b.c
 * JD-Core Version:    0.7.0.1
 */