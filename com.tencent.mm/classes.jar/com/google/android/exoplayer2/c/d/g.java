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
  public static final h bil;
  private static final int boj;
  private long bdJ;
  private final com.google.android.exoplayer2.i.m biB;
  private final com.google.android.exoplayer2.i.m biC;
  private com.google.android.exoplayer2.c.g bir;
  private int bis;
  private int bjJ;
  private int bjK;
  private final com.google.android.exoplayer2.i.m bni;
  private final Stack<a.a> bnk;
  private int bnm;
  private long bnn;
  private int bno;
  private com.google.android.exoplayer2.i.m bnp;
  private a[] bok;
  private boolean bol;
  private final int flags;
  
  static
  {
    AppMethodBeat.i(92120);
    bil = new h()
    {
      public final e[] ux()
      {
        AppMethodBeat.i(92112);
        g localg = new g();
        AppMethodBeat.o(92112);
        return new e[] { localg };
      }
    };
    boj = x.bJ("qt  ");
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
    this.bni = new com.google.android.exoplayer2.i.m(16);
    this.bnk = new Stack();
    this.biB = new com.google.android.exoplayer2.i.m(com.google.android.exoplayer2.i.k.bGT);
    this.biC = new com.google.android.exoplayer2.i.m(4);
    AppMethodBeat.o(92113);
  }
  
  private void O(long paramLong)
  {
    AppMethodBeat.i(92118);
    while ((!this.bnk.isEmpty()) && (((a.a)this.bnk.peek()).bmy == paramLong))
    {
      a.a locala = (a.a)this.bnk.pop();
      if (locala.type == a.blk)
      {
        f(locala);
        this.bnk.clear();
        this.bis = 2;
      }
      else if (!this.bnk.isEmpty())
      {
        ((a.a)this.bnk.peek()).a(locala);
      }
    }
    if (this.bis != 2) {
      uF();
    }
    AppMethodBeat.o(92118);
  }
  
  private void f(a.a parama)
  {
    AppMethodBeat.i(92119);
    ArrayList localArrayList = new ArrayList();
    com.google.android.exoplayer2.c.i locali = new com.google.android.exoplayer2.c.i();
    Object localObject1 = parama.ef(a.bmj);
    Metadata localMetadata;
    if (localObject1 != null)
    {
      localMetadata = b.a((a.b)localObject1, this.bol);
      if (localMetadata != null) {
        locali.c(localMetadata);
      }
    }
    for (;;)
    {
      int i = 0;
      long l1 = -9223372036854775807L;
      if (i < parama.bmA.size())
      {
        localObject1 = (a.a)parama.bmA.get(i);
        long l2 = l1;
        Object localObject2;
        if (((a.a)localObject1).type == a.blm)
        {
          localObject2 = parama.ef(a.bll);
          if ((this.flags & 0x1) == 0) {
            break label349;
          }
        }
        label349:
        for (boolean bool = true;; bool = false)
        {
          j localj = b.a((a.a)localObject1, (a.b)localObject2, -9223372036854775807L, null, bool, this.bol);
          l2 = l1;
          if (localj != null)
          {
            localObject1 = b.a(localj, ((a.a)localObject1).eg(a.bln).eg(a.blo).eg(a.blp), locali);
            l2 = l1;
            if (((m)localObject1).sampleCount != 0)
            {
              a locala = new a(localj, (m)localObject1, this.bir.dV(i));
              int j = ((m)localObject1).bmW;
              Format localFormat = localj.bdF.dF(j + 30);
              localObject2 = localFormat;
              if (localj.type == 1)
              {
                localObject1 = localFormat;
                if (locali.uz()) {
                  localObject1 = localFormat.aY(locali.bdA, locali.bdB);
                }
                localObject2 = localObject1;
                if (localMetadata != null) {
                  localObject2 = ((Format)localObject1).a(localMetadata);
                }
              }
              locala.bky.f((Format)localObject2);
              l2 = Math.max(l1, localj.bdJ);
              localArrayList.add(locala);
            }
          }
          i += 1;
          l1 = l2;
          break;
        }
      }
      this.bdJ = l1;
      this.bok = ((a[])localArrayList.toArray(new a[localArrayList.size()]));
      this.bir.uy();
      this.bir.a(this);
      AppMethodBeat.o(92119);
      return;
      localMetadata = null;
    }
  }
  
  private void uF()
  {
    this.bis = 0;
    this.bno = 0;
  }
  
  public final long L(long paramLong)
  {
    AppMethodBeat.i(92117);
    long l1 = 9223372036854775807L;
    a[] arrayOfa = this.bok;
    int m = arrayOfa.length;
    int i = 0;
    if (i < m)
    {
      m localm = arrayOfa[i].bom;
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
      switch (this.bis)
      {
      default: 
        paramf = new IllegalStateException();
        AppMethodBeat.o(92116);
        throw paramf;
      case 0: 
        if (this.bno != 0) {
          break label129;
        }
        if (paramf.a(this.bni.data, 0, 8, true)) {
          break label93;
        }
        i = 0;
      }
    } while (i != 0);
    AppMethodBeat.o(92116);
    return -1;
    label93:
    this.bno = 8;
    this.bni.setPosition(0);
    this.bnn = this.bni.dE();
    this.bnm = this.bni.readInt();
    label129:
    if (this.bnn == 1L)
    {
      paramf.readFully(this.bni.data, 8, 8);
      this.bno += 8;
      this.bnn = this.bni.xm();
    }
    while (this.bnn < this.bno)
    {
      paramf = new o("Atom size less than header length (unsupported).");
      AppMethodBeat.o(92116);
      throw paramf;
      if (this.bnn == 0L)
      {
        l2 = paramf.getLength();
        l1 = l2;
        if (l2 == -1L)
        {
          l1 = l2;
          if (!this.bnk.isEmpty()) {
            l1 = ((a.a)this.bnk.peek()).bmy;
          }
        }
        if (l1 != -1L) {
          this.bnn = (l1 - paramf.getPosition() + this.bno);
        }
      }
    }
    int i = this.bnm;
    if ((i == a.blk) || (i == a.blm) || (i == a.bln) || (i == a.blo) || (i == a.blp) || (i == a.bly))
    {
      i = 1;
      label348:
      if (i == 0) {
        break label428;
      }
      l1 = paramf.getPosition() + this.bnn - this.bno;
      this.bnk.add(new a.a(this.bnm, l1));
      if (this.bnn != this.bno) {
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
      uF();
      continue;
      i = this.bnm;
      if ((i == a.blA) || (i == a.bll) || (i == a.blB) || (i == a.blC) || (i == a.blV) || (i == a.blW) || (i == a.blX) || (i == a.blz) || (i == a.blY) || (i == a.blZ) || (i == a.bma) || (i == a.bmb) || (i == a.bmc) || (i == a.blx) || (i == a.bkJ) || (i == a.bmj))
      {
        i = 1;
        label547:
        if (i == 0) {
          break label649;
        }
        if (this.bno != 8) {
          break label637;
        }
        bool = true;
        label563:
        com.google.android.exoplayer2.i.a.checkState(bool);
        if (this.bnn > 2147483647L) {
          break label643;
        }
      }
      label643:
      for (bool = true;; bool = false)
      {
        com.google.android.exoplayer2.i.a.checkState(bool);
        this.bnp = new com.google.android.exoplayer2.i.m((int)this.bnn);
        System.arraycopy(this.bni.data, 0, this.bnp.data, 0, 8);
        this.bis = 1;
        break;
        i = 0;
        break label547;
        label637:
        bool = false;
        break label563;
      }
      label649:
      this.bnp = null;
      this.bis = 1;
    }
    long l1 = this.bnn - this.bno;
    long l2 = paramf.getPosition();
    Object localObject;
    if (this.bnp != null)
    {
      paramf.readFully(this.bnp.data, this.bno, (int)l1);
      if (this.bnm == a.bkJ)
      {
        localObject = this.bnp;
        ((com.google.android.exoplayer2.i.m)localObject).setPosition(8);
        if (((com.google.android.exoplayer2.i.m)localObject).readInt() == boj)
        {
          bool = true;
          label746:
          this.bol = bool;
          i = 0;
        }
      }
    }
    for (;;)
    {
      label754:
      O(l2 + l1);
      if ((i != 0) && (this.bis != 2)) {}
      for (i = 1; i != 0; i = 0)
      {
        AppMethodBeat.o(92116);
        return 1;
        ((com.google.android.exoplayer2.i.m)localObject).eZ(4);
        for (;;)
        {
          if (((com.google.android.exoplayer2.i.m)localObject).xd() > 0) {
            if (((com.google.android.exoplayer2.i.m)localObject).readInt() == boj)
            {
              bool = true;
              break;
            }
          }
        }
        bool = false;
        break label746;
        if (this.bnk.isEmpty()) {
          break label1470;
        }
        ((a.a)this.bnk.peek()).a(new a.b(this.bnm, this.bnp));
        i = 0;
        break label754;
        if (l1 < 262144L)
        {
          paramf.dP((int)l1);
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
      while (i < this.bok.length)
      {
        localObject = this.bok[i];
        m = ((a)localObject).bmT;
        k = j;
        l2 = l1;
        if (m != ((a)localObject).bom.sampleCount)
        {
          long l3 = localObject.bom.offsets[m];
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
      localObject = this.bok[j];
      com.google.android.exoplayer2.c.m localm = ((a)localObject).bky;
      int k = ((a)localObject).bmT;
      l2 = localObject.bom.offsets[k];
      j = localObject.bom.bhG[k];
      i = j;
      l1 = l2;
      if (((a)localObject).bnA.boq == 1)
      {
        l1 = l2 + 8L;
        i = j - 8;
      }
      l2 = l1 - paramf.getPosition() + this.bjK;
      if ((l2 < 0L) || (l2 >= 262144L))
      {
        paramk.position = l1;
        AppMethodBeat.o(92116);
        return 1;
      }
      paramf.dP((int)l2);
      if (((a)localObject).bnA.biD != 0)
      {
        paramk = this.biC.data;
        paramk[0] = 0;
        paramk[1] = 0;
        paramk[2] = 0;
        j = ((a)localObject).bnA.biD;
        m = 4 - ((a)localObject).bnA.biD;
        while (this.bjK < i) {
          if (this.bjJ == 0)
          {
            paramf.readFully(this.biC.data, m, j);
            this.biC.setPosition(0);
            this.bjJ = this.biC.xk();
            this.biB.setPosition(0);
            localm.a(this.biB, 4);
            this.bjK += 4;
            i += m;
          }
          else
          {
            int n = localm.a(paramf, this.bjJ, false);
            this.bjK += n;
            this.bjJ -= n;
          }
        }
      }
      for (;;)
      {
        localm.a(localObject.bom.boQ[k], localObject.bom.bmY[k], i, 0, null);
        ((a)localObject).bmT += 1;
        this.bjK = 0;
        this.bjJ = 0;
        AppMethodBeat.o(92116);
        return 0;
        while (this.bjK < i)
        {
          j = localm.a(paramf, i - this.bjK, false);
          this.bjK += j;
          this.bjJ -= j;
        }
      }
      label1470:
      i = 0;
    }
  }
  
  public final void a(com.google.android.exoplayer2.c.g paramg)
  {
    this.bir = paramg;
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
    this.bnk.clear();
    this.bno = 0;
    this.bjK = 0;
    this.bjJ = 0;
    if (paramLong1 == 0L)
    {
      uF();
      AppMethodBeat.o(92115);
      return;
    }
    if (this.bok != null)
    {
      a[] arrayOfa = this.bok;
      int m = arrayOfa.length;
      int i = 0;
      while (i < m)
      {
        a locala = arrayOfa[i];
        m localm = locala.bom;
        int k = localm.P(paramLong2);
        int j = k;
        if (k == -1) {
          j = localm.Q(paramLong2);
        }
        locala.bmT = j;
        i += 1;
      }
    }
    AppMethodBeat.o(92115);
  }
  
  public final long getDurationUs()
  {
    return this.bdJ;
  }
  
  public final boolean uu()
  {
    return true;
  }
  
  static final class a
  {
    public final com.google.android.exoplayer2.c.m bky;
    public int bmT;
    public final j bnA;
    public final m bom;
    
    public a(j paramj, m paramm, com.google.android.exoplayer2.c.m paramm1)
    {
      this.bnA = paramj;
      this.bom = paramm;
      this.bky = paramm1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes8.jar
 * Qualified Name:     com.google.android.exoplayer2.c.d.g
 * JD-Core Version:    0.7.0.1
 */