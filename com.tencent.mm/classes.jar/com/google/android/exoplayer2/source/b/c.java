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
import java.util.Arrays;
import java.util.IdentityHashMap;
import java.util.List;

final class c
{
  private byte[] aXP;
  private byte[] bmX;
  private final g bmZ;
  private final g bna;
  private final k bnb;
  private final a.a[] bnc;
  private final e bnd;
  final o bne;
  private final List<Format> bnf;
  boolean bng;
  byte[] bnh;
  IOException bni;
  private a.a bnj;
  private boolean bnk;
  private Uri bnl;
  private String bnm;
  com.google.android.exoplayer2.g.f bnn;
  
  public c(e parame, a.a[] paramArrayOfa, d paramd, k paramk, List<Format> paramList)
  {
    AppMethodBeat.i(62827);
    this.bnd = parame;
    this.bnc = paramArrayOfa;
    this.bnb = paramk;
    this.bnf = paramList;
    parame = new Format[paramArrayOfa.length];
    paramk = new int[paramArrayOfa.length];
    int i = 0;
    while (i < paramArrayOfa.length)
    {
      parame[i] = paramArrayOfa[i].aTo;
      paramk[i] = i;
      i += 1;
    }
    this.bmZ = paramd.uk();
    this.bna = paramd.uk();
    this.bne = new o(parame);
    this.bnn = new c(this.bne, paramk);
    AppMethodBeat.o(62827);
  }
  
  final void a(Uri paramUri, String paramString, byte[] paramArrayOfByte)
  {
    AppMethodBeat.i(62830);
    Object localObject;
    byte[] arrayOfByte;
    if (x.aO(paramString).startsWith("0x"))
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
      this.bnl = paramUri;
      this.aXP = paramArrayOfByte;
      this.bnm = paramString;
      this.bmX = arrayOfByte;
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
      this.bnj = null;
      if (paramf != null) {
        break label206;
      }
      l1 = 0L;
      this.bnn.af(l1);
      j = this.bnn.uW();
      if (i == j) {
        break label241;
      }
      k = 1;
      localObject1 = this.bnc[j];
      localObject2 = (e.a)this.bnd.bpm.get(localObject1);
      if (((e.a)localObject2).bpw == null) {
        break label247;
      }
      l1 = SystemClock.elapsedRealtime();
      long l2 = Math.max(30000L, com.google.android.exoplayer2.b.v(((e.a)localObject2).bpw.aTs));
      if ((!((e.a)localObject2).bpw.boA) && (((e.a)localObject2).bpw.bot != 2) && (((e.a)localObject2).bpw.bot != 1) && (l2 + ((e.a)localObject2).bpx <= l1)) {
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
      paramb.bnr = ((a.a)localObject1);
      this.bnj = ((a.a)localObject1);
      AppMethodBeat.o(62829);
      return;
      i = this.bne.j(paramf.bmO);
      break;
      if (this.bnk) {}
      for (l1 = paramf.bmS;; l1 = paramf.bmR)
      {
        l1 = Math.max(0L, l1 - paramLong);
        break;
      }
      k = 0;
      break label56;
    }
    label253:
    Object localObject2 = this.bnd.c((a.a)localObject1);
    this.bnk = ((com.google.android.exoplayer2.source.b.a.b)localObject2).boz;
    Object localObject3;
    boolean bool;
    if ((paramf == null) || (k != 0))
    {
      if (paramf == null) {}
      while ((!((com.google.android.exoplayer2.source.b.a.b)localObject2).boA) && (paramLong >= ((com.google.android.exoplayer2.source.b.a.b)localObject2).us()))
      {
        k = ((com.google.android.exoplayer2.source.b.a.b)localObject2).box + ((com.google.android.exoplayer2.source.b.a.b)localObject2).segments.size();
        localObject3 = localObject2;
        i = j;
        localObject2 = localObject1;
        j = k;
        localObject1 = localObject3;
        if (j >= ((com.google.android.exoplayer2.source.b.a.b)localObject1).box) {
          break label539;
        }
        this.bni = new com.google.android.exoplayer2.source.b();
        AppMethodBeat.o(62829);
        return;
        if (this.bnk) {
          paramLong = paramf.bmS;
        } else {
          paramLong = paramf.bmR;
        }
      }
      localObject3 = ((com.google.android.exoplayer2.source.b.a.b)localObject2).segments;
      l1 = ((com.google.android.exoplayer2.source.b.a.b)localObject2).bmR;
      if ((!this.bnd.bps) || (paramf == null))
      {
        bool = true;
        label423:
        k = x.a((List)localObject3, Long.valueOf(paramLong - l1), bool) + ((com.google.android.exoplayer2.source.b.a.b)localObject2).box;
        if ((k >= ((com.google.android.exoplayer2.source.b.a.b)localObject2).box) || (paramf == null)) {
          break label1035;
        }
        localObject1 = this.bnc[i];
        localObject2 = this.bnd.c((a.a)localObject1);
      }
    }
    for (int j = paramf.bmT + 1;; j = k)
    {
      localObject3 = localObject1;
      localObject1 = localObject2;
      localObject2 = localObject3;
      break;
      bool = false;
      break label423;
      k = paramf.bmT + 1;
      localObject3 = localObject1;
      i = j;
      localObject1 = localObject2;
      j = k;
      localObject2 = localObject3;
      break;
      label539:
      k = j - ((com.google.android.exoplayer2.source.b.a.b)localObject1).box;
      if (k >= ((com.google.android.exoplayer2.source.b.a.b)localObject1).segments.size())
      {
        if (((com.google.android.exoplayer2.source.b.a.b)localObject1).boA)
        {
          paramb.bnq = true;
          AppMethodBeat.o(62829);
          return;
        }
        paramb.bnr = ((a.a)localObject2);
        this.bnj = ((a.a)localObject2);
        AppMethodBeat.o(62829);
        return;
      }
      b.a locala = (b.a)((com.google.android.exoplayer2.source.b.a.b)localObject1).segments.get(k);
      if (locala.bee)
      {
        localObject3 = w.m(((com.google.android.exoplayer2.source.b.a.b)localObject1).boJ, locala.boF);
        if (!((Uri)localObject3).equals(this.bnl))
        {
          paramf = locala.boG;
          j = this.bnn.ul();
          localObject1 = this.bnn.um();
          localObject2 = new j((Uri)localObject3, 0L, -1L, null, 1);
          paramb.bnp = new a(this.bna, (j)localObject2, this.bnc[i].aTo, j, localObject1, this.bnh, paramf);
          AppMethodBeat.o(62829);
          return;
        }
        if (!x.g(locala.boG, this.bnm)) {
          a((Uri)localObject3, locala.boG, this.aXP);
        }
        localObject3 = ((com.google.android.exoplayer2.source.b.a.b)localObject1).boC;
        if (localObject3 == null) {
          break label1029;
        }
      }
      label1029:
      for (localObject3 = new j(w.m(((com.google.android.exoplayer2.source.b.a.b)localObject1).boJ, ((b.a)localObject3).url), ((b.a)localObject3).boH, ((b.a)localObject3).boI, null);; localObject3 = null)
      {
        paramLong = ((com.google.android.exoplayer2.source.b.a.b)localObject1).bmR + locala.boE;
        i = ((com.google.android.exoplayer2.source.b.a.b)localObject1).bow + locala.boD;
        k localk = this.bnb;
        u localu = (u)localk.bom.get(i);
        if (localu == null)
        {
          localu = new u(9223372036854775807L);
          localk.bom.put(i, localu);
        }
        for (;;)
        {
          localObject1 = new j(w.m(((com.google.android.exoplayer2.source.b.a.b)localObject1).boJ, locala.url), locala.boH, locala.boI, null);
          paramb.bnp = new f(this.bmZ, (j)localObject1, (j)localObject3, (a.a)localObject2, this.bnf, this.bnn.ul(), this.bnn.um(), paramLong, paramLong + locala.aTs, j, i, this.bng, localu, paramf, this.aXP, this.bmX);
          AppMethodBeat.o(62829);
          return;
          this.bnl = null;
          this.aXP = null;
          this.bnm = null;
          this.bmX = null;
          break;
        }
      }
      label1035:
      i = j;
    }
  }
  
  public final void tN()
  {
    AppMethodBeat.i(62828);
    if (this.bni != null)
    {
      IOException localIOException = this.bni;
      AppMethodBeat.o(62828);
      throw localIOException;
    }
    if (this.bnj != null) {
      this.bnd.d(this.bnj);
    }
    AppMethodBeat.o(62828);
  }
  
  static final class a
    extends com.google.android.exoplayer2.source.a.c
  {
    public final String bno;
    byte[] result;
    
    public a(g paramg, j paramj, Format paramFormat, int paramInt, Object paramObject, byte[] paramArrayOfByte, String paramString)
    {
      super(paramj, paramFormat, paramInt, paramObject, paramArrayOfByte);
      this.bno = paramString;
    }
    
    public final void f(byte[] paramArrayOfByte, int paramInt)
    {
      AppMethodBeat.i(62823);
      this.result = Arrays.copyOf(paramArrayOfByte, paramInt);
      AppMethodBeat.o(62823);
    }
  }
  
  public static final class b
  {
    public a bnp;
    public boolean bnq;
    public a.a bnr;
    
    public b()
    {
      AppMethodBeat.i(62824);
      clear();
      AppMethodBeat.o(62824);
    }
    
    public final void clear()
    {
      this.bnp = null;
      this.bnq = false;
      this.bnr = null;
    }
  }
  
  static final class c
    extends com.google.android.exoplayer2.g.b
  {
    private int bns;
    
    public c(o paramo, int[] paramArrayOfInt)
    {
      super(paramArrayOfInt);
      AppMethodBeat.i(62825);
      this.bns = j(paramo.bmh[0]);
      AppMethodBeat.o(62825);
    }
    
    public final void af(long paramLong)
    {
      AppMethodBeat.i(62826);
      paramLong = SystemClock.elapsedRealtime();
      if (!k(this.bns, paramLong))
      {
        AppMethodBeat.o(62826);
        return;
      }
      int i = this.length - 1;
      while (i >= 0)
      {
        if (!k(i, paramLong))
        {
          this.bns = i;
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
      return this.bns;
    }
    
    public final int ul()
    {
      return 0;
    }
    
    public final Object um()
    {
      return null;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.google.android.exoplayer2.source.b.c
 * JD-Core Version:    0.7.0.1
 */