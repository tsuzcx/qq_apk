package com.google.android.exoplayer2.c.d;

import com.google.android.exoplayer2.Format;
import com.google.android.exoplayer2.c.e;
import com.google.android.exoplayer2.c.f;
import com.google.android.exoplayer2.c.h;
import com.google.android.exoplayer2.c.l;
import com.google.android.exoplayer2.i.x;
import com.google.android.exoplayer2.metadata.Metadata;
import com.google.android.exoplayer2.o;
import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

public final class g
  implements e, l
{
  public static final h aBP;
  private static final int aHP;
  private com.google.android.exoplayer2.c.g aBV;
  private int aBW;
  private final com.google.android.exoplayer2.i.m aCf;
  private final com.google.android.exoplayer2.i.m aCg;
  private int aDn;
  private int aDo;
  private final com.google.android.exoplayer2.i.m aGO;
  private final Stack<a.a> aGQ;
  private int aGS;
  private long aGT;
  private int aGU;
  private com.google.android.exoplayer2.i.m aGV;
  private g.a[] aHQ;
  private boolean aHR;
  private long axh;
  private final int flags;
  
  static
  {
    AppMethodBeat.i(95005);
    aBP = new h()
    {
      public final e[] nY()
      {
        AppMethodBeat.i(94997);
        g localg = new g();
        AppMethodBeat.o(94997);
        return new e[] { localg };
      }
    };
    aHP = x.aS("qt  ");
    AppMethodBeat.o(95005);
  }
  
  public g()
  {
    this(0);
  }
  
  public g(int paramInt)
  {
    AppMethodBeat.i(94998);
    this.flags = paramInt;
    this.aGO = new com.google.android.exoplayer2.i.m(16);
    this.aGQ = new Stack();
    this.aCf = new com.google.android.exoplayer2.i.m(com.google.android.exoplayer2.i.k.baF);
    this.aCg = new com.google.android.exoplayer2.i.m(4);
    AppMethodBeat.o(94998);
  }
  
  private void H(long paramLong)
  {
    AppMethodBeat.i(95003);
    while ((!this.aGQ.isEmpty()) && (((a.a)this.aGQ.peek()).aGe == paramLong))
    {
      a.a locala = (a.a)this.aGQ.pop();
      if (locala.type == a.aEQ)
      {
        f(locala);
        this.aGQ.clear();
        this.aBW = 2;
      }
      else if (!this.aGQ.isEmpty())
      {
        ((a.a)this.aGQ.peek()).a(locala);
      }
    }
    if (this.aBW != 2) {
      og();
    }
    AppMethodBeat.o(95003);
  }
  
  private void f(a.a parama)
  {
    AppMethodBeat.i(95004);
    ArrayList localArrayList = new ArrayList();
    com.google.android.exoplayer2.c.i locali = new com.google.android.exoplayer2.c.i();
    Object localObject1 = parama.dw(a.aFP);
    Metadata localMetadata;
    if (localObject1 != null)
    {
      localMetadata = b.a((a.b)localObject1, this.aHR);
      if (localMetadata != null) {
        locali.c(localMetadata);
      }
    }
    for (;;)
    {
      int i = 0;
      long l1 = -9223372036854775807L;
      if (i < parama.aGg.size())
      {
        localObject1 = (a.a)parama.aGg.get(i);
        long l2 = l1;
        Object localObject2;
        if (((a.a)localObject1).type == a.aES)
        {
          localObject2 = parama.dw(a.aER);
          if ((this.flags & 0x1) == 0) {
            break label349;
          }
        }
        label349:
        for (boolean bool = true;; bool = false)
        {
          j localj = b.a((a.a)localObject1, (a.b)localObject2, -9223372036854775807L, null, bool, this.aHR);
          l2 = l1;
          if (localj != null)
          {
            localObject1 = b.a(localj, ((a.a)localObject1).dx(a.aET).dx(a.aEU).dx(a.aEV), locali);
            l2 = l1;
            if (((m)localObject1).sampleCount != 0)
            {
              g.a locala = new g.a(localj, (m)localObject1, this.aBV.dm(i));
              int j = ((m)localObject1).aGC;
              Format localFormat = localj.axd.cW(j + 30);
              localObject2 = localFormat;
              if (localj.type == 1)
              {
                localObject1 = localFormat;
                if (locali.oa()) {
                  localObject1 = localFormat.aR(locali.awW, locali.awX);
                }
                localObject2 = localObject1;
                if (localMetadata != null) {
                  localObject2 = ((Format)localObject1).a(localMetadata);
                }
              }
              locala.aEe.f((Format)localObject2);
              l2 = Math.max(l1, localj.axh);
              localArrayList.add(locala);
            }
          }
          i += 1;
          l1 = l2;
          break;
        }
      }
      this.axh = l1;
      this.aHQ = ((g.a[])localArrayList.toArray(new g.a[localArrayList.size()]));
      this.aBV.nZ();
      this.aBV.a(this);
      AppMethodBeat.o(95004);
      return;
      localMetadata = null;
    }
  }
  
  private void og()
  {
    this.aBW = 0;
    this.aGU = 0;
  }
  
  public final long E(long paramLong)
  {
    AppMethodBeat.i(95002);
    long l1 = 9223372036854775807L;
    g.a[] arrayOfa = this.aHQ;
    int m = arrayOfa.length;
    int i = 0;
    if (i < m)
    {
      m localm = arrayOfa[i].aHS;
      int k = localm.I(paramLong);
      int j = k;
      if (k == -1) {
        j = localm.J(paramLong);
      }
      long l2 = localm.offsets[j];
      if (l2 >= l1) {
        break label103;
      }
      l1 = l2;
    }
    label103:
    for (;;)
    {
      i += 1;
      break;
      AppMethodBeat.o(95002);
      return l1;
    }
  }
  
  public final int a(f paramf, com.google.android.exoplayer2.c.k paramk)
  {
    AppMethodBeat.i(95001);
    do
    {
      switch (this.aBW)
      {
      default: 
        paramf = new IllegalStateException();
        AppMethodBeat.o(95001);
        throw paramf;
      case 0: 
        if (this.aGU != 0) {
          break label129;
        }
        if (paramf.a(this.aGO.data, 0, 8, true)) {
          break label93;
        }
        i = 0;
      }
    } while (i != 0);
    AppMethodBeat.o(95001);
    return -1;
    label93:
    this.aGU = 8;
    this.aGO.setPosition(0);
    this.aGT = this.aGO.cc();
    this.aGS = this.aGO.readInt();
    label129:
    if (this.aGT == 1L)
    {
      paramf.readFully(this.aGO.data, 8, 8);
      this.aGU += 8;
      this.aGT = this.aGO.qV();
    }
    while (this.aGT < this.aGU)
    {
      paramf = new o("Atom size less than header length (unsupported).");
      AppMethodBeat.o(95001);
      throw paramf;
      if (this.aGT == 0L)
      {
        l2 = paramf.getLength();
        l1 = l2;
        if (l2 == -1L)
        {
          l1 = l2;
          if (!this.aGQ.isEmpty()) {
            l1 = ((a.a)this.aGQ.peek()).aGe;
          }
        }
        if (l1 != -1L) {
          this.aGT = (l1 - paramf.getPosition() + this.aGU);
        }
      }
    }
    int i = this.aGS;
    if ((i == a.aEQ) || (i == a.aES) || (i == a.aET) || (i == a.aEU) || (i == a.aEV) || (i == a.aFe))
    {
      i = 1;
      label348:
      if (i == 0) {
        break label428;
      }
      l1 = paramf.getPosition() + this.aGT - this.aGU;
      this.aGQ.add(new a.a(this.aGS, l1));
      if (this.aGT != this.aGU) {
        break label421;
      }
      H(l1);
    }
    label421:
    label428:
    boolean bool;
    for (;;)
    {
      i = 1;
      break;
      i = 0;
      break label348;
      og();
      continue;
      i = this.aGS;
      if ((i == a.aFg) || (i == a.aER) || (i == a.aFh) || (i == a.aFi) || (i == a.aFB) || (i == a.aFC) || (i == a.aFD) || (i == a.aFf) || (i == a.aFE) || (i == a.aFF) || (i == a.aFG) || (i == a.aFH) || (i == a.aFI) || (i == a.aFd) || (i == a.aEp) || (i == a.aFP))
      {
        i = 1;
        label547:
        if (i == 0) {
          break label649;
        }
        if (this.aGU != 8) {
          break label637;
        }
        bool = true;
        label563:
        com.google.android.exoplayer2.i.a.checkState(bool);
        if (this.aGT > 2147483647L) {
          break label643;
        }
      }
      label643:
      for (bool = true;; bool = false)
      {
        com.google.android.exoplayer2.i.a.checkState(bool);
        this.aGV = new com.google.android.exoplayer2.i.m((int)this.aGT);
        System.arraycopy(this.aGO.data, 0, this.aGV.data, 0, 8);
        this.aBW = 1;
        break;
        i = 0;
        break label547;
        label637:
        bool = false;
        break label563;
      }
      label649:
      this.aGV = null;
      this.aBW = 1;
    }
    long l1 = this.aGT - this.aGU;
    long l2 = paramf.getPosition();
    Object localObject;
    if (this.aGV != null)
    {
      paramf.readFully(this.aGV.data, this.aGU, (int)l1);
      if (this.aGS == a.aEp)
      {
        localObject = this.aGV;
        ((com.google.android.exoplayer2.i.m)localObject).setPosition(8);
        if (((com.google.android.exoplayer2.i.m)localObject).readInt() == aHP)
        {
          bool = true;
          label746:
          this.aHR = bool;
          i = 0;
        }
      }
    }
    for (;;)
    {
      label754:
      H(l2 + l1);
      if ((i != 0) && (this.aBW != 2)) {}
      for (i = 1; i != 0; i = 0)
      {
        AppMethodBeat.o(95001);
        return 1;
        ((com.google.android.exoplayer2.i.m)localObject).en(4);
        for (;;)
        {
          if (((com.google.android.exoplayer2.i.m)localObject).qM() > 0) {
            if (((com.google.android.exoplayer2.i.m)localObject).readInt() == aHP)
            {
              bool = true;
              break;
            }
          }
        }
        bool = false;
        break label746;
        if (this.aGQ.isEmpty()) {
          break label1470;
        }
        ((a.a)this.aGQ.peek()).a(new a.b(this.aGS, this.aGV));
        i = 0;
        break label754;
        if (l1 < 262144L)
        {
          paramf.dg((int)l1);
          i = 0;
          break label754;
        }
        paramk.position = (paramf.getPosition() + l1);
        i = 1;
        break label754;
      }
      int j = -1;
      l1 = 9223372036854775807L;
      i = 0;
      int m;
      while (i < this.aHQ.length)
      {
        localObject = this.aHQ[i];
        m = ((g.a)localObject).aGz;
        k = j;
        l2 = l1;
        if (m != ((g.a)localObject).aHS.sampleCount)
        {
          long l3 = localObject.aHS.offsets[m];
          k = j;
          l2 = l1;
          if (l3 < l1)
          {
            l2 = l3;
            k = i;
          }
        }
        i += 1;
        j = k;
        l1 = l2;
      }
      if (j == -1)
      {
        AppMethodBeat.o(95001);
        return -1;
      }
      localObject = this.aHQ[j];
      com.google.android.exoplayer2.c.m localm = ((g.a)localObject).aEe;
      int k = ((g.a)localObject).aGz;
      l2 = localObject.aHS.offsets[k];
      j = localObject.aHS.aBk[k];
      i = j;
      l1 = l2;
      if (((g.a)localObject).aHg.aHW == 1)
      {
        l1 = l2 + 8L;
        i = j - 8;
      }
      l2 = l1 - paramf.getPosition() + this.aDo;
      if ((l2 < 0L) || (l2 >= 262144L))
      {
        paramk.position = l1;
        AppMethodBeat.o(95001);
        return 1;
      }
      paramf.dg((int)l2);
      if (((g.a)localObject).aHg.aCh != 0)
      {
        paramk = this.aCg.data;
        paramk[0] = 0;
        paramk[1] = 0;
        paramk[2] = 0;
        j = ((g.a)localObject).aHg.aCh;
        m = 4 - ((g.a)localObject).aHg.aCh;
        while (this.aDo < i) {
          if (this.aDn == 0)
          {
            paramf.readFully(this.aCg.data, m, j);
            this.aCg.setPosition(0);
            this.aDn = this.aCg.qT();
            this.aCf.setPosition(0);
            localm.a(this.aCf, 4);
            this.aDo += 4;
            i += m;
          }
          else
          {
            int n = localm.a(paramf, this.aDn, false);
            this.aDo += n;
            this.aDn -= n;
          }
        }
      }
      for (;;)
      {
        localm.a(localObject.aHS.aIw[k], localObject.aHS.aGE[k], i, 0, null);
        ((g.a)localObject).aGz += 1;
        this.aDo = 0;
        this.aDn = 0;
        AppMethodBeat.o(95001);
        return 0;
        while (this.aDo < i)
        {
          j = localm.a(paramf, i - this.aDo, false);
          this.aDo += j;
          this.aDn -= j;
        }
      }
      label1470:
      i = 0;
    }
  }
  
  public final void a(com.google.android.exoplayer2.c.g paramg)
  {
    this.aBV = paramg;
  }
  
  public final boolean a(f paramf)
  {
    AppMethodBeat.i(94999);
    boolean bool = i.h(paramf);
    AppMethodBeat.o(94999);
    return bool;
  }
  
  public final void g(long paramLong1, long paramLong2)
  {
    AppMethodBeat.i(95000);
    this.aGQ.clear();
    this.aGU = 0;
    this.aDo = 0;
    this.aDn = 0;
    if (paramLong1 == 0L)
    {
      og();
      AppMethodBeat.o(95000);
      return;
    }
    if (this.aHQ != null)
    {
      g.a[] arrayOfa = this.aHQ;
      int m = arrayOfa.length;
      int i = 0;
      while (i < m)
      {
        g.a locala = arrayOfa[i];
        m localm = locala.aHS;
        int k = localm.I(paramLong2);
        int j = k;
        if (k == -1) {
          j = localm.J(paramLong2);
        }
        locala.aGz = j;
        i += 1;
      }
    }
    AppMethodBeat.o(95000);
  }
  
  public final long getDurationUs()
  {
    return this.axh;
  }
  
  public final boolean nV()
  {
    return true;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.google.android.exoplayer2.c.d.g
 * JD-Core Version:    0.7.0.1
 */