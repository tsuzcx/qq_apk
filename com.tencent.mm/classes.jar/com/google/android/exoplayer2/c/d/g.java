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
  public static final h bio;
  private static final int boo;
  private long bdM;
  private final com.google.android.exoplayer2.i.m biE;
  private final com.google.android.exoplayer2.i.m biF;
  private com.google.android.exoplayer2.c.g biu;
  private int biv;
  private int bjM;
  private int bjN;
  private final com.google.android.exoplayer2.i.m bnn;
  private final Stack<a.a> bnp;
  private int bnr;
  private long bns;
  private int bnt;
  private com.google.android.exoplayer2.i.m bnu;
  private a[] bop;
  private boolean boq;
  private final int flags;
  
  static
  {
    AppMethodBeat.i(92120);
    bio = new h()
    {
      public final e[] us()
      {
        AppMethodBeat.i(92112);
        g localg = new g();
        AppMethodBeat.o(92112);
        return new e[] { localg };
      }
    };
    boo = x.bJ("qt  ");
    AppMethodBeat.o(92120);
  }
  
  public g()
  {
    this(0);
  }
  
  public g(int paramInt)
  {
    AppMethodBeat.i(92113);
    this.flags = paramInt;
    this.bnn = new com.google.android.exoplayer2.i.m(16);
    this.bnp = new Stack();
    this.biE = new com.google.android.exoplayer2.i.m(com.google.android.exoplayer2.i.k.bGC);
    this.biF = new com.google.android.exoplayer2.i.m(4);
    AppMethodBeat.o(92113);
  }
  
  private void O(long paramLong)
  {
    AppMethodBeat.i(92118);
    while ((!this.bnp.isEmpty()) && (((a.a)this.bnp.peek()).bmD == paramLong))
    {
      a.a locala = (a.a)this.bnp.pop();
      if (locala.type == a.blp)
      {
        f(locala);
        this.bnp.clear();
        this.biv = 2;
      }
      else if (!this.bnp.isEmpty())
      {
        ((a.a)this.bnp.peek()).a(locala);
      }
    }
    if (this.biv != 2) {
      uA();
    }
    AppMethodBeat.o(92118);
  }
  
  private void f(a.a parama)
  {
    AppMethodBeat.i(92119);
    ArrayList localArrayList = new ArrayList();
    com.google.android.exoplayer2.c.i locali = new com.google.android.exoplayer2.c.i();
    Object localObject1 = parama.el(a.bmo);
    Metadata localMetadata;
    if (localObject1 != null)
    {
      localMetadata = b.a((a.b)localObject1, this.boq);
      if (localMetadata != null) {
        locali.c(localMetadata);
      }
    }
    for (;;)
    {
      int i = 0;
      long l1 = -9223372036854775807L;
      if (i < parama.bmF.size())
      {
        localObject1 = (a.a)parama.bmF.get(i);
        long l2 = l1;
        Object localObject2;
        if (((a.a)localObject1).type == a.blr)
        {
          localObject2 = parama.el(a.blq);
          if ((this.flags & 0x1) == 0) {
            break label349;
          }
        }
        label349:
        for (boolean bool = true;; bool = false)
        {
          j localj = b.a((a.a)localObject1, (a.b)localObject2, -9223372036854775807L, null, bool, this.boq);
          l2 = l1;
          if (localj != null)
          {
            localObject1 = b.a(localj, ((a.a)localObject1).em(a.bls).em(a.blt).em(a.blu), locali);
            l2 = l1;
            if (((m)localObject1).sampleCount != 0)
            {
              a locala = new a(localj, (m)localObject1, this.biu.eb(i));
              int j = ((m)localObject1).bnb;
              Format localFormat = localj.bdI.dK(j + 30);
              localObject2 = localFormat;
              if (localj.type == 1)
              {
                localObject1 = localFormat;
                if (locali.uu()) {
                  localObject1 = localFormat.be(locali.bdD, locali.bdE);
                }
                localObject2 = localObject1;
                if (localMetadata != null) {
                  localObject2 = ((Format)localObject1).a(localMetadata);
                }
              }
              locala.bkD.f((Format)localObject2);
              l2 = Math.max(l1, localj.bdM);
              localArrayList.add(locala);
            }
          }
          i += 1;
          l1 = l2;
          break;
        }
      }
      this.bdM = l1;
      this.bop = ((a[])localArrayList.toArray(new a[localArrayList.size()]));
      this.biu.ut();
      this.biu.a(this);
      AppMethodBeat.o(92119);
      return;
      localMetadata = null;
    }
  }
  
  private void uA()
  {
    this.biv = 0;
    this.bnt = 0;
  }
  
  public final long L(long paramLong)
  {
    AppMethodBeat.i(92117);
    long l1 = 9223372036854775807L;
    a[] arrayOfa = this.bop;
    int m = arrayOfa.length;
    int i = 0;
    if (i < m)
    {
      m localm = arrayOfa[i].bor;
      int k = localm.P(paramLong);
      int j = k;
      if (k == -1) {
        j = localm.Q(paramLong);
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
      AppMethodBeat.o(92117);
      return l1;
    }
  }
  
  public final int a(f paramf, com.google.android.exoplayer2.c.k paramk)
  {
    AppMethodBeat.i(92116);
    do
    {
      switch (this.biv)
      {
      default: 
        paramf = new IllegalStateException();
        AppMethodBeat.o(92116);
        throw paramf;
      case 0: 
        if (this.bnt != 0) {
          break label129;
        }
        if (paramf.a(this.bnn.data, 0, 8, true)) {
          break label93;
        }
        i = 0;
      }
    } while (i != 0);
    AppMethodBeat.o(92116);
    return -1;
    label93:
    this.bnt = 8;
    this.bnn.setPosition(0);
    this.bns = this.bnn.dB();
    this.bnr = this.bnn.readInt();
    label129:
    if (this.bns == 1L)
    {
      paramf.readFully(this.bnn.data, 8, 8);
      this.bnt += 8;
      this.bns = this.bnn.xe();
    }
    while (this.bns < this.bnt)
    {
      paramf = new o("Atom size less than header length (unsupported).");
      AppMethodBeat.o(92116);
      throw paramf;
      if (this.bns == 0L)
      {
        l2 = paramf.getLength();
        l1 = l2;
        if (l2 == -1L)
        {
          l1 = l2;
          if (!this.bnp.isEmpty()) {
            l1 = ((a.a)this.bnp.peek()).bmD;
          }
        }
        if (l1 != -1L) {
          this.bns = (l1 - paramf.getPosition() + this.bnt);
        }
      }
    }
    int i = this.bnr;
    if ((i == a.blp) || (i == a.blr) || (i == a.bls) || (i == a.blt) || (i == a.blu) || (i == a.blD))
    {
      i = 1;
      label348:
      if (i == 0) {
        break label428;
      }
      l1 = paramf.getPosition() + this.bns - this.bnt;
      this.bnp.add(new a.a(this.bnr, l1));
      if (this.bns != this.bnt) {
        break label421;
      }
      O(l1);
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
      uA();
      continue;
      i = this.bnr;
      if ((i == a.blF) || (i == a.blq) || (i == a.blG) || (i == a.blH) || (i == a.bma) || (i == a.bmb) || (i == a.bmc) || (i == a.blE) || (i == a.bmd) || (i == a.bme) || (i == a.bmf) || (i == a.bmg) || (i == a.bmh) || (i == a.blC) || (i == a.bkO) || (i == a.bmo))
      {
        i = 1;
        label547:
        if (i == 0) {
          break label649;
        }
        if (this.bnt != 8) {
          break label637;
        }
        bool = true;
        label563:
        com.google.android.exoplayer2.i.a.checkState(bool);
        if (this.bns > 2147483647L) {
          break label643;
        }
      }
      label643:
      for (bool = true;; bool = false)
      {
        com.google.android.exoplayer2.i.a.checkState(bool);
        this.bnu = new com.google.android.exoplayer2.i.m((int)this.bns);
        System.arraycopy(this.bnn.data, 0, this.bnu.data, 0, 8);
        this.biv = 1;
        break;
        i = 0;
        break label547;
        label637:
        bool = false;
        break label563;
      }
      label649:
      this.bnu = null;
      this.biv = 1;
    }
    long l1 = this.bns - this.bnt;
    long l2 = paramf.getPosition();
    Object localObject;
    if (this.bnu != null)
    {
      paramf.readFully(this.bnu.data, this.bnt, (int)l1);
      if (this.bnr == a.bkO)
      {
        localObject = this.bnu;
        ((com.google.android.exoplayer2.i.m)localObject).setPosition(8);
        if (((com.google.android.exoplayer2.i.m)localObject).readInt() == boo)
        {
          bool = true;
          label746:
          this.boq = bool;
          i = 0;
        }
      }
    }
    for (;;)
    {
      label754:
      O(l2 + l1);
      if ((i != 0) && (this.biv != 2)) {}
      for (i = 1; i != 0; i = 0)
      {
        AppMethodBeat.o(92116);
        return 1;
        ((com.google.android.exoplayer2.i.m)localObject).fa(4);
        for (;;)
        {
          if (((com.google.android.exoplayer2.i.m)localObject).wV() > 0) {
            if (((com.google.android.exoplayer2.i.m)localObject).readInt() == boo)
            {
              bool = true;
              break;
            }
          }
        }
        bool = false;
        break label746;
        if (this.bnp.isEmpty()) {
          break label1470;
        }
        ((a.a)this.bnp.peek()).a(new a.b(this.bnr, this.bnu));
        i = 0;
        break label754;
        if (l1 < 262144L)
        {
          paramf.dU((int)l1);
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
      while (i < this.bop.length)
      {
        localObject = this.bop[i];
        m = ((a)localObject).bmY;
        k = j;
        l2 = l1;
        if (m != ((a)localObject).bor.sampleCount)
        {
          long l3 = localObject.bor.offsets[m];
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
        AppMethodBeat.o(92116);
        return -1;
      }
      localObject = this.bop[j];
      com.google.android.exoplayer2.c.m localm = ((a)localObject).bkD;
      int k = ((a)localObject).bmY;
      l2 = localObject.bor.offsets[k];
      j = localObject.bor.bhJ[k];
      i = j;
      l1 = l2;
      if (((a)localObject).bnF.bov == 1)
      {
        l1 = l2 + 8L;
        i = j - 8;
      }
      l2 = l1 - paramf.getPosition() + this.bjN;
      if ((l2 < 0L) || (l2 >= 262144L))
      {
        paramk.position = l1;
        AppMethodBeat.o(92116);
        return 1;
      }
      paramf.dU((int)l2);
      if (((a)localObject).bnF.biG != 0)
      {
        paramk = this.biF.data;
        paramk[0] = 0;
        paramk[1] = 0;
        paramk[2] = 0;
        j = ((a)localObject).bnF.biG;
        m = 4 - ((a)localObject).bnF.biG;
        while (this.bjN < i) {
          if (this.bjM == 0)
          {
            paramf.readFully(this.biF.data, m, j);
            this.biF.setPosition(0);
            this.bjM = this.biF.xc();
            this.biE.setPosition(0);
            localm.a(this.biE, 4);
            this.bjN += 4;
            i += m;
          }
          else
          {
            int n = localm.a(paramf, this.bjM, false);
            this.bjN += n;
            this.bjM -= n;
          }
        }
      }
      for (;;)
      {
        localm.a(localObject.bor.boV[k], localObject.bor.bnd[k], i, 0, null);
        ((a)localObject).bmY += 1;
        this.bjN = 0;
        this.bjM = 0;
        AppMethodBeat.o(92116);
        return 0;
        while (this.bjN < i)
        {
          j = localm.a(paramf, i - this.bjN, false);
          this.bjN += j;
          this.bjM -= j;
        }
      }
      label1470:
      i = 0;
    }
  }
  
  public final void a(com.google.android.exoplayer2.c.g paramg)
  {
    this.biu = paramg;
  }
  
  public final boolean a(f paramf)
  {
    AppMethodBeat.i(92114);
    boolean bool = i.h(paramf);
    AppMethodBeat.o(92114);
    return bool;
  }
  
  public final void f(long paramLong1, long paramLong2)
  {
    AppMethodBeat.i(92115);
    this.bnp.clear();
    this.bnt = 0;
    this.bjN = 0;
    this.bjM = 0;
    if (paramLong1 == 0L)
    {
      uA();
      AppMethodBeat.o(92115);
      return;
    }
    if (this.bop != null)
    {
      a[] arrayOfa = this.bop;
      int m = arrayOfa.length;
      int i = 0;
      while (i < m)
      {
        a locala = arrayOfa[i];
        m localm = locala.bor;
        int k = localm.P(paramLong2);
        int j = k;
        if (k == -1) {
          j = localm.Q(paramLong2);
        }
        locala.bmY = j;
        i += 1;
      }
    }
    AppMethodBeat.o(92115);
  }
  
  public final long getDurationUs()
  {
    return this.bdM;
  }
  
  public final boolean up()
  {
    return true;
  }
  
  static final class a
  {
    public final com.google.android.exoplayer2.c.m bkD;
    public int bmY;
    public final j bnF;
    public final m bor;
    
    public a(j paramj, m paramm, com.google.android.exoplayer2.c.m paramm1)
    {
      this.bnF = paramj;
      this.bor = paramm;
      this.bkD = paramm1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.google.android.exoplayer2.c.d.g
 * JD-Core Version:    0.7.0.1
 */