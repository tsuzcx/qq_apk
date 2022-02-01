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
  public static final h aRP;
  private static final int aXL;
  private long aNk;
  private com.google.android.exoplayer2.c.g aRV;
  private int aRW;
  private final com.google.android.exoplayer2.i.m aSf;
  private final com.google.android.exoplayer2.i.m aSg;
  private int aTn;
  private int aTo;
  private final com.google.android.exoplayer2.i.m aWK;
  private final Stack<a.a> aWM;
  private int aWO;
  private long aWP;
  private int aWQ;
  private com.google.android.exoplayer2.i.m aWR;
  private a[] aXM;
  private boolean aXN;
  private final int flags;
  
  static
  {
    AppMethodBeat.i(92120);
    aRP = new h()
    {
      public final e[] ss()
      {
        AppMethodBeat.i(92112);
        g localg = new g();
        AppMethodBeat.o(92112);
        return new e[] { localg };
      }
    };
    aXL = x.bU("qt  ");
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
    this.aWK = new com.google.android.exoplayer2.i.m(16);
    this.aWM = new Stack();
    this.aSf = new com.google.android.exoplayer2.i.m(com.google.android.exoplayer2.i.k.bqC);
    this.aSg = new com.google.android.exoplayer2.i.m(4);
    AppMethodBeat.o(92113);
  }
  
  private void R(long paramLong)
  {
    AppMethodBeat.i(92118);
    while ((!this.aWM.isEmpty()) && (((a.a)this.aWM.peek()).aWa == paramLong))
    {
      a.a locala = (a.a)this.aWM.pop();
      if (locala.type == a.aUM)
      {
        f(locala);
        this.aWM.clear();
        this.aRW = 2;
      }
      else if (!this.aWM.isEmpty())
      {
        ((a.a)this.aWM.peek()).a(locala);
      }
    }
    if (this.aRW != 2) {
      sA();
    }
    AppMethodBeat.o(92118);
  }
  
  private void f(a.a parama)
  {
    AppMethodBeat.i(92119);
    ArrayList localArrayList = new ArrayList();
    com.google.android.exoplayer2.c.i locali = new com.google.android.exoplayer2.c.i();
    Object localObject1 = parama.et(a.aVL);
    Metadata localMetadata;
    if (localObject1 != null)
    {
      localMetadata = b.a((a.b)localObject1, this.aXN);
      if (localMetadata != null) {
        locali.c(localMetadata);
      }
    }
    for (;;)
    {
      int i = 0;
      long l1 = -9223372036854775807L;
      if (i < parama.aWc.size())
      {
        localObject1 = (a.a)parama.aWc.get(i);
        long l2 = l1;
        Object localObject2;
        if (((a.a)localObject1).type == a.aUO)
        {
          localObject2 = parama.et(a.aUN);
          if ((this.flags & 0x1) == 0) {
            break label349;
          }
        }
        label349:
        for (boolean bool = true;; bool = false)
        {
          j localj = b.a((a.a)localObject1, (a.b)localObject2, -9223372036854775807L, null, bool, this.aXN);
          l2 = l1;
          if (localj != null)
          {
            localObject1 = b.a(localj, ((a.a)localObject1).eu(a.aUP).eu(a.aUQ).eu(a.aUR), locali);
            l2 = l1;
            if (((m)localObject1).sampleCount != 0)
            {
              a locala = new a(localj, (m)localObject1, this.aRV.ej(i));
              int j = ((m)localObject1).aWy;
              Format localFormat = localj.aNg.dT(j + 30);
              localObject2 = localFormat;
              if (localj.type == 1)
              {
                localObject1 = localFormat;
                if (locali.su()) {
                  localObject1 = localFormat.be(locali.aNa, locali.aNb);
                }
                localObject2 = localObject1;
                if (localMetadata != null) {
                  localObject2 = ((Format)localObject1).a(localMetadata);
                }
              }
              locala.aUa.f((Format)localObject2);
              l2 = Math.max(l1, localj.aNk);
              localArrayList.add(locala);
            }
          }
          i += 1;
          l1 = l2;
          break;
        }
      }
      this.aNk = l1;
      this.aXM = ((a[])localArrayList.toArray(new a[localArrayList.size()]));
      this.aRV.st();
      this.aRV.a(this);
      AppMethodBeat.o(92119);
      return;
      localMetadata = null;
    }
  }
  
  private void sA()
  {
    this.aRW = 0;
    this.aWQ = 0;
  }
  
  public final long O(long paramLong)
  {
    AppMethodBeat.i(92117);
    long l1 = 9223372036854775807L;
    a[] arrayOfa = this.aXM;
    int m = arrayOfa.length;
    int i = 0;
    if (i < m)
    {
      m localm = arrayOfa[i].aXO;
      int k = localm.S(paramLong);
      int j = k;
      if (k == -1) {
        j = localm.T(paramLong);
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
      switch (this.aRW)
      {
      default: 
        paramf = new IllegalStateException();
        AppMethodBeat.o(92116);
        throw paramf;
      case 0: 
        if (this.aWQ != 0) {
          break label129;
        }
        if (paramf.a(this.aWK.data, 0, 8, true)) {
          break label93;
        }
        i = 0;
      }
    } while (i != 0);
    AppMethodBeat.o(92116);
    return -1;
    label93:
    this.aWQ = 8;
    this.aWK.setPosition(0);
    this.aWP = this.aWK.ii();
    this.aWO = this.aWK.readInt();
    label129:
    if (this.aWP == 1L)
    {
      paramf.readFully(this.aWK.data, 8, 8);
      this.aWQ += 8;
      this.aWP = this.aWK.vq();
    }
    while (this.aWP < this.aWQ)
    {
      paramf = new o("Atom size less than header length (unsupported).");
      AppMethodBeat.o(92116);
      throw paramf;
      if (this.aWP == 0L)
      {
        l2 = paramf.sr();
        l1 = l2;
        if (l2 == -1L)
        {
          l1 = l2;
          if (!this.aWM.isEmpty()) {
            l1 = ((a.a)this.aWM.peek()).aWa;
          }
        }
        if (l1 != -1L) {
          this.aWP = (l1 - paramf.getPosition() + this.aWQ);
        }
      }
    }
    int i = this.aWO;
    if ((i == a.aUM) || (i == a.aUO) || (i == a.aUP) || (i == a.aUQ) || (i == a.aUR) || (i == a.aVa))
    {
      i = 1;
      label348:
      if (i == 0) {
        break label428;
      }
      l1 = paramf.getPosition() + this.aWP - this.aWQ;
      this.aWM.add(new a.a(this.aWO, l1));
      if (this.aWP != this.aWQ) {
        break label421;
      }
      R(l1);
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
      sA();
      continue;
      i = this.aWO;
      if ((i == a.aVc) || (i == a.aUN) || (i == a.aVd) || (i == a.aVe) || (i == a.aVx) || (i == a.aVy) || (i == a.aVz) || (i == a.aVb) || (i == a.aVA) || (i == a.aVB) || (i == a.aVC) || (i == a.aVD) || (i == a.aVE) || (i == a.aUZ) || (i == a.aUl) || (i == a.aVL))
      {
        i = 1;
        label547:
        if (i == 0) {
          break label649;
        }
        if (this.aWQ != 8) {
          break label637;
        }
        bool = true;
        label563:
        com.google.android.exoplayer2.i.a.checkState(bool);
        if (this.aWP > 2147483647L) {
          break label643;
        }
      }
      label643:
      for (bool = true;; bool = false)
      {
        com.google.android.exoplayer2.i.a.checkState(bool);
        this.aWR = new com.google.android.exoplayer2.i.m((int)this.aWP);
        System.arraycopy(this.aWK.data, 0, this.aWR.data, 0, 8);
        this.aRW = 1;
        break;
        i = 0;
        break label547;
        label637:
        bool = false;
        break label563;
      }
      label649:
      this.aWR = null;
      this.aRW = 1;
    }
    long l1 = this.aWP - this.aWQ;
    long l2 = paramf.getPosition();
    Object localObject;
    if (this.aWR != null)
    {
      paramf.readFully(this.aWR.data, this.aWQ, (int)l1);
      if (this.aWO == a.aUl)
      {
        localObject = this.aWR;
        ((com.google.android.exoplayer2.i.m)localObject).setPosition(8);
        if (((com.google.android.exoplayer2.i.m)localObject).readInt() == aXL)
        {
          bool = true;
          label746:
          this.aXN = bool;
          i = 0;
        }
      }
    }
    for (;;)
    {
      label754:
      R(l2 + l1);
      if ((i != 0) && (this.aRW != 2)) {}
      for (i = 1; i != 0; i = 0)
      {
        AppMethodBeat.o(92116);
        return 1;
        ((com.google.android.exoplayer2.i.m)localObject).fu(4);
        for (;;)
        {
          if (((com.google.android.exoplayer2.i.m)localObject).vg() > 0) {
            if (((com.google.android.exoplayer2.i.m)localObject).readInt() == aXL)
            {
              bool = true;
              break;
            }
          }
        }
        bool = false;
        break label746;
        if (this.aWM.isEmpty()) {
          break label1470;
        }
        ((a.a)this.aWM.peek()).a(new a.b(this.aWO, this.aWR));
        i = 0;
        break label754;
        if (l1 < 262144L)
        {
          paramf.ed((int)l1);
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
      while (i < this.aXM.length)
      {
        localObject = this.aXM[i];
        m = ((a)localObject).aWv;
        k = j;
        l2 = l1;
        if (m != ((a)localObject).aXO.sampleCount)
        {
          long l3 = localObject.aXO.offsets[m];
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
      localObject = this.aXM[j];
      com.google.android.exoplayer2.c.m localm = ((a)localObject).aUa;
      int k = ((a)localObject).aWv;
      l2 = localObject.aXO.offsets[k];
      j = localObject.aXO.aRk[k];
      i = j;
      l1 = l2;
      if (((a)localObject).aXc.aXS == 1)
      {
        l1 = l2 + 8L;
        i = j - 8;
      }
      l2 = l1 - paramf.getPosition() + this.aTo;
      if ((l2 < 0L) || (l2 >= 262144L))
      {
        paramk.position = l1;
        AppMethodBeat.o(92116);
        return 1;
      }
      paramf.ed((int)l2);
      if (((a)localObject).aXc.aSh != 0)
      {
        paramk = this.aSg.data;
        paramk[0] = 0;
        paramk[1] = 0;
        paramk[2] = 0;
        j = ((a)localObject).aXc.aSh;
        m = 4 - ((a)localObject).aXc.aSh;
        while (this.aTo < i) {
          if (this.aTn == 0)
          {
            paramf.readFully(this.aSg.data, m, j);
            this.aSg.setPosition(0);
            this.aTn = this.aSg.vo();
            this.aSf.setPosition(0);
            localm.a(this.aSf, 4);
            this.aTo += 4;
            i += m;
          }
          else
          {
            int n = localm.a(paramf, this.aTn, false);
            this.aTo += n;
            this.aTn -= n;
          }
        }
      }
      for (;;)
      {
        localm.a(localObject.aXO.aYs[k], localObject.aXO.aWA[k], i, 0, null);
        ((a)localObject).aWv += 1;
        this.aTo = 0;
        this.aTn = 0;
        AppMethodBeat.o(92116);
        return 0;
        while (this.aTo < i)
        {
          j = localm.a(paramf, i - this.aTo, false);
          this.aTo += j;
          this.aTn -= j;
        }
      }
      label1470:
      i = 0;
    }
  }
  
  public final void a(com.google.android.exoplayer2.c.g paramg)
  {
    this.aRV = paramg;
  }
  
  public final boolean a(f paramf)
  {
    AppMethodBeat.i(92114);
    boolean bool = i.h(paramf);
    AppMethodBeat.o(92114);
    return bool;
  }
  
  public final void g(long paramLong1, long paramLong2)
  {
    AppMethodBeat.i(92115);
    this.aWM.clear();
    this.aWQ = 0;
    this.aTo = 0;
    this.aTn = 0;
    if (paramLong1 == 0L)
    {
      sA();
      AppMethodBeat.o(92115);
      return;
    }
    if (this.aXM != null)
    {
      a[] arrayOfa = this.aXM;
      int m = arrayOfa.length;
      int i = 0;
      while (i < m)
      {
        a locala = arrayOfa[i];
        m localm = locala.aXO;
        int k = localm.S(paramLong2);
        int j = k;
        if (k == -1) {
          j = localm.T(paramLong2);
        }
        locala.aWv = j;
        i += 1;
      }
    }
    AppMethodBeat.o(92115);
  }
  
  public final long getDurationUs()
  {
    return this.aNk;
  }
  
  public final boolean so()
  {
    return true;
  }
  
  static final class a
  {
    public final com.google.android.exoplayer2.c.m aUa;
    public int aWv;
    public final m aXO;
    public final j aXc;
    
    public a(j paramj, m paramm, com.google.android.exoplayer2.c.m paramm1)
    {
      this.aXc = paramj;
      this.aXO = paramm;
      this.aUa = paramm1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes9.jar
 * Qualified Name:     com.google.android.exoplayer2.c.d.g
 * JD-Core Version:    0.7.0.1
 */