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
  public static final h aXh;
  private static final int bdh;
  private long aSz;
  private com.google.android.exoplayer2.c.g aXn;
  private int aXo;
  private final com.google.android.exoplayer2.i.m aXx;
  private final com.google.android.exoplayer2.i.m aXy;
  private int aYF;
  private int aYG;
  private final com.google.android.exoplayer2.i.m bcg;
  private final Stack<a.a> bci;
  private int bck;
  private long bcl;
  private int bcm;
  private com.google.android.exoplayer2.i.m bcn;
  private a[] bdi;
  private boolean bdj;
  private final int flags;
  
  static
  {
    AppMethodBeat.i(92120);
    aXh = new h()
    {
      public final e[] sK()
      {
        AppMethodBeat.i(92112);
        g localg = new g();
        AppMethodBeat.o(92112);
        return new e[] { localg };
      }
    };
    bdh = x.aY("qt  ");
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
    this.bcg = new com.google.android.exoplayer2.i.m(16);
    this.bci = new Stack();
    this.aXx = new com.google.android.exoplayer2.i.m(com.google.android.exoplayer2.i.k.byG);
    this.aXy = new com.google.android.exoplayer2.i.m(4);
    AppMethodBeat.o(92113);
  }
  
  private void N(long paramLong)
  {
    AppMethodBeat.i(92118);
    while ((!this.bci.isEmpty()) && (((a.a)this.bci.peek()).bbw == paramLong))
    {
      a.a locala = (a.a)this.bci.pop();
      if (locala.type == a.bai)
      {
        f(locala);
        this.bci.clear();
        this.aXo = 2;
      }
      else if (!this.bci.isEmpty())
      {
        ((a.a)this.bci.peek()).a(locala);
      }
    }
    if (this.aXo != 2) {
      sS();
    }
    AppMethodBeat.o(92118);
  }
  
  private void f(a.a parama)
  {
    AppMethodBeat.i(92119);
    ArrayList localArrayList = new ArrayList();
    com.google.android.exoplayer2.c.i locali = new com.google.android.exoplayer2.c.i();
    Object localObject1 = parama.eh(a.bbh);
    Metadata localMetadata;
    if (localObject1 != null)
    {
      localMetadata = b.a((a.b)localObject1, this.bdj);
      if (localMetadata != null) {
        locali.c(localMetadata);
      }
    }
    for (;;)
    {
      int i = 0;
      long l1 = -9223372036854775807L;
      if (i < parama.bby.size())
      {
        localObject1 = (a.a)parama.bby.get(i);
        long l2 = l1;
        Object localObject2;
        if (((a.a)localObject1).type == a.bak)
        {
          localObject2 = parama.eh(a.baj);
          if ((this.flags & 0x1) == 0) {
            break label354;
          }
        }
        label354:
        for (boolean bool = true;; bool = false)
        {
          j localj = b.a((a.a)localObject1, (a.b)localObject2, -9223372036854775807L, null, bool, this.bdj);
          l2 = l1;
          if (localj != null)
          {
            localObject1 = b.a(localj, ((a.a)localObject1).ei(a.bal).ei(a.bam).ei(a.ban), locali);
            l2 = l1;
            if (((m)localObject1).sampleCount != 0)
            {
              a locala = new a(localj, (m)localObject1, this.aXn.bh(i, localj.type));
              int j = ((m)localObject1).bbU;
              Format localFormat = localj.aSv.dH(j + 30);
              localObject2 = localFormat;
              if (localj.type == 1)
              {
                localObject1 = localFormat;
                if (locali.sM()) {
                  localObject1 = localFormat.bc(locali.aSp, locali.aSq);
                }
                localObject2 = localObject1;
                if (localMetadata != null) {
                  localObject2 = ((Format)localObject1).a(localMetadata);
                }
              }
              locala.aZw.f((Format)localObject2);
              l2 = Math.max(l1, localj.aSz);
              localArrayList.add(locala);
            }
          }
          i += 1;
          l1 = l2;
          break;
        }
      }
      this.aSz = l1;
      this.bdi = ((a[])localArrayList.toArray(new a[localArrayList.size()]));
      this.aXn.sL();
      this.aXn.a(this);
      AppMethodBeat.o(92119);
      return;
      localMetadata = null;
    }
  }
  
  private void sS()
  {
    this.aXo = 0;
    this.bcm = 0;
  }
  
  public final long K(long paramLong)
  {
    AppMethodBeat.i(92117);
    long l1 = 9223372036854775807L;
    a[] arrayOfa = this.bdi;
    int m = arrayOfa.length;
    int i = 0;
    if (i < m)
    {
      m localm = arrayOfa[i].bdk;
      int k = localm.O(paramLong);
      int j = k;
      if (k == -1) {
        j = localm.P(paramLong);
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
      switch (this.aXo)
      {
      default: 
        paramf = new IllegalStateException();
        AppMethodBeat.o(92116);
        throw paramf;
      case 0: 
        if (this.bcm != 0) {
          break label129;
        }
        if (paramf.a(this.bcg.data, 0, 8, true)) {
          break label93;
        }
        i = 0;
      }
    } while (i != 0);
    AppMethodBeat.o(92116);
    return -1;
    label93:
    this.bcm = 8;
    this.bcg.setPosition(0);
    this.bcl = this.bcg.df();
    this.bck = this.bcg.readInt();
    label129:
    if (this.bcl == 1L)
    {
      paramf.readFully(this.bcg.data, 8, 8);
      this.bcm += 8;
      this.bcl = this.bcg.vS();
    }
    while (this.bcl < this.bcm)
    {
      paramf = new o("Atom size less than header length (unsupported).");
      AppMethodBeat.o(92116);
      throw paramf;
      if (this.bcl == 0L)
      {
        l2 = paramf.getLength();
        l1 = l2;
        if (l2 == -1L)
        {
          l1 = l2;
          if (!this.bci.isEmpty()) {
            l1 = ((a.a)this.bci.peek()).bbw;
          }
        }
        if (l1 != -1L) {
          this.bcl = (l1 - paramf.getPosition() + this.bcm);
        }
      }
    }
    int i = this.bck;
    if ((i == a.bai) || (i == a.bak) || (i == a.bal) || (i == a.bam) || (i == a.ban) || (i == a.baw))
    {
      i = 1;
      label348:
      if (i == 0) {
        break label428;
      }
      l1 = paramf.getPosition() + this.bcl - this.bcm;
      this.bci.add(new a.a(this.bck, l1));
      if (this.bcl != this.bcm) {
        break label421;
      }
      N(l1);
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
      sS();
      continue;
      i = this.bck;
      if ((i == a.bay) || (i == a.baj) || (i == a.baz) || (i == a.baA) || (i == a.baT) || (i == a.baU) || (i == a.baV) || (i == a.bax) || (i == a.baW) || (i == a.baX) || (i == a.baY) || (i == a.baZ) || (i == a.bba) || (i == a.bav) || (i == a.aZH) || (i == a.bbh))
      {
        i = 1;
        label547:
        if (i == 0) {
          break label649;
        }
        if (this.bcm != 8) {
          break label637;
        }
        bool = true;
        label563:
        com.google.android.exoplayer2.i.a.checkState(bool);
        if (this.bcl > 2147483647L) {
          break label643;
        }
      }
      label643:
      for (bool = true;; bool = false)
      {
        com.google.android.exoplayer2.i.a.checkState(bool);
        this.bcn = new com.google.android.exoplayer2.i.m((int)this.bcl);
        System.arraycopy(this.bcg.data, 0, this.bcn.data, 0, 8);
        this.aXo = 1;
        break;
        i = 0;
        break label547;
        label637:
        bool = false;
        break label563;
      }
      label649:
      this.bcn = null;
      this.aXo = 1;
    }
    long l1 = this.bcl - this.bcm;
    long l2 = paramf.getPosition();
    Object localObject;
    if (this.bcn != null)
    {
      paramf.readFully(this.bcn.data, this.bcm, (int)l1);
      if (this.bck == a.aZH)
      {
        localObject = this.bcn;
        ((com.google.android.exoplayer2.i.m)localObject).setPosition(8);
        if (((com.google.android.exoplayer2.i.m)localObject).readInt() == bdh)
        {
          bool = true;
          label746:
          this.bdj = bool;
          i = 0;
        }
      }
    }
    for (;;)
    {
      label754:
      N(l2 + l1);
      if ((i != 0) && (this.aXo != 2)) {}
      for (i = 1; i != 0; i = 0)
      {
        AppMethodBeat.o(92116);
        return 1;
        ((com.google.android.exoplayer2.i.m)localObject).fl(4);
        for (;;)
        {
          if (((com.google.android.exoplayer2.i.m)localObject).vJ() > 0) {
            if (((com.google.android.exoplayer2.i.m)localObject).readInt() == bdh)
            {
              bool = true;
              break;
            }
          }
        }
        bool = false;
        break label746;
        if (this.bci.isEmpty()) {
          break label1470;
        }
        ((a.a)this.bci.peek()).a(new a.b(this.bck, this.bcn));
        i = 0;
        break label754;
        if (l1 < 262144L)
        {
          paramf.dR((int)l1);
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
      while (i < this.bdi.length)
      {
        localObject = this.bdi[i];
        m = ((a)localObject).bbR;
        k = j;
        l2 = l1;
        if (m != ((a)localObject).bdk.sampleCount)
        {
          long l3 = localObject.bdk.offsets[m];
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
      localObject = this.bdi[j];
      com.google.android.exoplayer2.c.m localm = ((a)localObject).aZw;
      int k = ((a)localObject).bbR;
      l2 = localObject.bdk.offsets[k];
      j = localObject.bdk.aWC[k];
      i = j;
      l1 = l2;
      if (((a)localObject).bcy.bdo == 1)
      {
        l1 = l2 + 8L;
        i = j - 8;
      }
      l2 = l1 - paramf.getPosition() + this.aYG;
      if ((l2 < 0L) || (l2 >= 262144L))
      {
        paramk.position = l1;
        AppMethodBeat.o(92116);
        return 1;
      }
      paramf.dR((int)l2);
      if (((a)localObject).bcy.aXz != 0)
      {
        paramk = this.aXy.data;
        paramk[0] = 0;
        paramk[1] = 0;
        paramk[2] = 0;
        j = ((a)localObject).bcy.aXz;
        m = 4 - ((a)localObject).bcy.aXz;
        while (this.aYG < i) {
          if (this.aYF == 0)
          {
            paramf.readFully(this.aXy.data, m, j);
            this.aXy.setPosition(0);
            this.aYF = this.aXy.vQ();
            this.aXx.setPosition(0);
            localm.a(this.aXx, 4);
            this.aYG += 4;
            i += m;
          }
          else
          {
            int n = localm.a(paramf, this.aYF, false);
            this.aYG += n;
            this.aYF -= n;
          }
        }
      }
      for (;;)
      {
        localm.a(localObject.bdk.bdO[k], localObject.bdk.bbW[k], i, 0, null);
        ((a)localObject).bbR += 1;
        this.aYG = 0;
        this.aYF = 0;
        AppMethodBeat.o(92116);
        return 0;
        while (this.aYG < i)
        {
          j = localm.a(paramf, i - this.aYG, false);
          this.aYG += j;
          this.aYF -= j;
        }
      }
      label1470:
      i = 0;
    }
  }
  
  public final void a(com.google.android.exoplayer2.c.g paramg)
  {
    this.aXn = paramg;
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
    this.bci.clear();
    this.bcm = 0;
    this.aYG = 0;
    this.aYF = 0;
    if (paramLong1 == 0L)
    {
      sS();
      AppMethodBeat.o(92115);
      return;
    }
    if (this.bdi != null)
    {
      a[] arrayOfa = this.bdi;
      int m = arrayOfa.length;
      int i = 0;
      while (i < m)
      {
        a locala = arrayOfa[i];
        m localm = locala.bdk;
        int k = localm.O(paramLong2);
        int j = k;
        if (k == -1) {
          j = localm.P(paramLong2);
        }
        locala.bbR = j;
        i += 1;
      }
    }
    AppMethodBeat.o(92115);
  }
  
  public final long getDurationUs()
  {
    return this.aSz;
  }
  
  public final boolean sH()
  {
    return true;
  }
  
  static final class a
  {
    public final com.google.android.exoplayer2.c.m aZw;
    public int bbR;
    public final j bcy;
    public final m bdk;
    
    public a(j paramj, m paramm, com.google.android.exoplayer2.c.m paramm1)
    {
      this.bcy = paramj;
      this.bdk = paramm;
      this.aZw = paramm1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.google.android.exoplayer2.c.d.g
 * JD-Core Version:    0.7.0.1
 */