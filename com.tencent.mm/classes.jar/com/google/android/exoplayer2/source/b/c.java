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
  private byte[] cLH;
  private byte[] daP;
  private final g daR;
  private final g daS;
  private final k daT;
  private final a.a[] daU;
  private final e daV;
  final q daW;
  private final List<Format> daX;
  boolean daY;
  byte[] daZ;
  IOException dba;
  private a.a dbb;
  private boolean dbc;
  private Uri dbd;
  private String dbe;
  com.google.android.exoplayer2.g.f dbf;
  
  public c(e parame, a.a[] paramArrayOfa, d paramd, k paramk, List<Format> paramList)
  {
    AppMethodBeat.i(62827);
    this.daV = parame;
    this.daU = paramArrayOfa;
    this.daT = paramk;
    this.daX = paramList;
    parame = new Format[paramArrayOfa.length];
    paramk = new int[paramArrayOfa.length];
    int i = 0;
    while (i < paramArrayOfa.length)
    {
      parame[i] = paramArrayOfa[i].cHc;
      paramk[i] = i;
      i += 1;
    }
    this.daR = paramd.Tp();
    this.daS = paramd.Tp();
    this.daW = new q(parame);
    this.dbf = new c.c(this.daW, paramk);
    AppMethodBeat.o(62827);
  }
  
  public final void ST()
  {
    AppMethodBeat.i(62828);
    if (this.dba != null)
    {
      IOException localIOException = this.dba;
      AppMethodBeat.o(62828);
      throw localIOException;
    }
    if (this.dbb != null) {
      this.daV.d(this.dbb);
    }
    AppMethodBeat.o(62828);
  }
  
  final void a(Uri paramUri, String paramString, byte[] paramArrayOfByte)
  {
    AppMethodBeat.i(62830);
    Object localObject;
    byte[] arrayOfByte;
    if (x.ds(paramString).startsWith("0x"))
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
      this.dbd = paramUri;
      this.cLH = paramArrayOfByte;
      this.dbe = paramString;
      this.daP = arrayOfByte;
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
      this.dbb = null;
      if (paramf != null) {
        break label206;
      }
      l1 = 0L;
      this.dbf.cw(l1);
      j = this.dbf.Ue();
      if (i == j) {
        break label241;
      }
      k = 1;
      localObject1 = this.daU[j];
      localObject2 = (e.a)this.daV.dde.get(localObject1);
      if (((e.a)localObject2).ddo == null) {
        break label247;
      }
      l1 = SystemClock.elapsedRealtime();
      long l2 = Math.max(30000L, com.google.android.exoplayer2.b.bM(((e.a)localObject2).ddo.cHg));
      if ((!((e.a)localObject2).ddo.dcs) && (((e.a)localObject2).ddo.dcl != 2) && (((e.a)localObject2).ddo.dcl != 1) && (l2 + ((e.a)localObject2).ddp <= l1)) {
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
      paramb.dbj = ((a.a)localObject1);
      this.dbb = ((a.a)localObject1);
      AppMethodBeat.o(62829);
      return;
      i = this.daW.j(paramf.daG);
      break;
      if (this.dbc) {}
      for (l1 = paramf.daK;; l1 = paramf.daJ)
      {
        l1 = Math.max(0L, l1 - paramLong);
        break;
      }
      k = 0;
      break label56;
    }
    label253:
    Object localObject2 = this.daV.c((a.a)localObject1);
    this.dbc = ((com.google.android.exoplayer2.source.b.a.b)localObject2).dcr;
    Object localObject3;
    boolean bool;
    if ((paramf == null) || (k != 0))
    {
      if (paramf == null) {}
      while ((!((com.google.android.exoplayer2.source.b.a.b)localObject2).dcs) && (paramLong >= ((com.google.android.exoplayer2.source.b.a.b)localObject2).Tx()))
      {
        k = ((com.google.android.exoplayer2.source.b.a.b)localObject2).dcp + ((com.google.android.exoplayer2.source.b.a.b)localObject2).segments.size();
        localObject3 = localObject2;
        i = j;
        localObject2 = localObject1;
        j = k;
        localObject1 = localObject3;
        if (j >= ((com.google.android.exoplayer2.source.b.a.b)localObject1).dcp) {
          break label539;
        }
        this.dba = new com.google.android.exoplayer2.source.c();
        AppMethodBeat.o(62829);
        return;
        if (this.dbc) {
          paramLong = paramf.daK;
        } else {
          paramLong = paramf.daJ;
        }
      }
      localObject3 = ((com.google.android.exoplayer2.source.b.a.b)localObject2).segments;
      l1 = ((com.google.android.exoplayer2.source.b.a.b)localObject2).daJ;
      if ((!this.daV.ddk) || (paramf == null))
      {
        bool = true;
        label423:
        k = x.a((List)localObject3, Long.valueOf(paramLong - l1), bool) + ((com.google.android.exoplayer2.source.b.a.b)localObject2).dcp;
        if ((k >= ((com.google.android.exoplayer2.source.b.a.b)localObject2).dcp) || (paramf == null)) {
          break label1035;
        }
        localObject1 = this.daU[i];
        localObject2 = this.daV.c((a.a)localObject1);
      }
    }
    for (int j = paramf.daL + 1;; j = k)
    {
      localObject3 = localObject1;
      localObject1 = localObject2;
      localObject2 = localObject3;
      break;
      bool = false;
      break label423;
      k = paramf.daL + 1;
      localObject3 = localObject1;
      i = j;
      localObject1 = localObject2;
      j = k;
      localObject2 = localObject3;
      break;
      label539:
      k = j - ((com.google.android.exoplayer2.source.b.a.b)localObject1).dcp;
      if (k >= ((com.google.android.exoplayer2.source.b.a.b)localObject1).segments.size())
      {
        if (((com.google.android.exoplayer2.source.b.a.b)localObject1).dcs)
        {
          paramb.dbi = true;
          AppMethodBeat.o(62829);
          return;
        }
        paramb.dbj = ((a.a)localObject2);
        this.dbb = ((a.a)localObject2);
        AppMethodBeat.o(62829);
        return;
      }
      b.a locala = (b.a)((com.google.android.exoplayer2.source.b.a.b)localObject1).segments.get(k);
      if (locala.cRS)
      {
        localObject3 = w.x(((com.google.android.exoplayer2.source.b.a.b)localObject1).dcB, locala.dcx);
        if (!((Uri)localObject3).equals(this.dbd))
        {
          paramf = locala.dcy;
          j = this.dbf.Tq();
          localObject1 = this.dbf.Tr();
          localObject2 = new j((Uri)localObject3, 0L, -1L, null, 1);
          paramb.dbh = new c.a(this.daS, (j)localObject2, this.daU[i].cHc, j, localObject1, this.daZ, paramf);
          AppMethodBeat.o(62829);
          return;
        }
        if (!x.p(locala.dcy, this.dbe)) {
          a((Uri)localObject3, locala.dcy, this.cLH);
        }
        localObject3 = ((com.google.android.exoplayer2.source.b.a.b)localObject1).dcu;
        if (localObject3 == null) {
          break label1029;
        }
      }
      label1029:
      for (localObject3 = new j(w.x(((com.google.android.exoplayer2.source.b.a.b)localObject1).dcB, ((b.a)localObject3).url), ((b.a)localObject3).dcz, ((b.a)localObject3).dcA, null);; localObject3 = null)
      {
        paramLong = ((com.google.android.exoplayer2.source.b.a.b)localObject1).daJ + locala.dcw;
        i = ((com.google.android.exoplayer2.source.b.a.b)localObject1).dco + locala.dcv;
        k localk = this.daT;
        u localu = (u)localk.dce.get(i);
        if (localu == null)
        {
          localu = new u(9223372036854775807L);
          localk.dce.put(i, localu);
        }
        for (;;)
        {
          localObject1 = new j(w.x(((com.google.android.exoplayer2.source.b.a.b)localObject1).dcB, locala.url), locala.dcz, locala.dcA, null);
          paramb.dbh = new f(this.daR, (j)localObject1, (j)localObject3, (a.a)localObject2, this.daX, this.dbf.Tq(), this.dbf.Tr(), paramLong, paramLong + locala.cHg, j, i, this.daY, localu, paramf, this.cLH, this.daP);
          AppMethodBeat.o(62829);
          return;
          this.dbd = null;
          this.cLH = null;
          this.dbe = null;
          this.daP = null;
          break;
        }
      }
      label1035:
      i = j;
    }
  }
  
  public static final class b
  {
    public a dbh;
    public boolean dbi;
    public a.a dbj;
    
    public b()
    {
      AppMethodBeat.i(62824);
      clear();
      AppMethodBeat.o(62824);
    }
    
    public final void clear()
    {
      this.dbh = null;
      this.dbi = false;
      this.dbj = null;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes12.jar
 * Qualified Name:     com.google.android.exoplayer2.source.b.c
 * JD-Core Version:    0.7.0.1
 */