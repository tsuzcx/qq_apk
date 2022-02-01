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
  public static final h aXT;
  private static final int bdT;
  private long aTs;
  private com.google.android.exoplayer2.c.g aXZ;
  private int aYa;
  private final com.google.android.exoplayer2.i.m aYj;
  private final com.google.android.exoplayer2.i.m aYk;
  private int aZr;
  private int aZs;
  private final com.google.android.exoplayer2.i.m bcS;
  private final Stack<a.a> bcU;
  private int bcW;
  private long bcX;
  private int bcY;
  private com.google.android.exoplayer2.i.m bcZ;
  private a[] bdU;
  private boolean bdV;
  private final int flags;
  
  static
  {
    AppMethodBeat.i(92120);
    aXT = new h()
    {
      public final e[] sT()
      {
        AppMethodBeat.i(92112);
        g localg = new g();
        AppMethodBeat.o(92112);
        return new e[] { localg };
      }
    };
    bdT = x.aQ("qt  ");
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
    this.bcS = new com.google.android.exoplayer2.i.m(16);
    this.bcU = new Stack();
    this.aYj = new com.google.android.exoplayer2.i.m(com.google.android.exoplayer2.i.k.bwo);
    this.aYk = new com.google.android.exoplayer2.i.m(4);
    AppMethodBeat.o(92113);
  }
  
  private void O(long paramLong)
  {
    AppMethodBeat.i(92118);
    while ((!this.bcU.isEmpty()) && (((a.a)this.bcU.peek()).bci == paramLong))
    {
      a.a locala = (a.a)this.bcU.pop();
      if (locala.type == a.baU)
      {
        f(locala);
        this.bcU.clear();
        this.aYa = 2;
      }
      else if (!this.bcU.isEmpty())
      {
        ((a.a)this.bcU.peek()).a(locala);
      }
    }
    if (this.aYa != 2) {
      tb();
    }
    AppMethodBeat.o(92118);
  }
  
  private void f(a.a parama)
  {
    AppMethodBeat.i(92119);
    ArrayList localArrayList = new ArrayList();
    com.google.android.exoplayer2.c.i locali = new com.google.android.exoplayer2.c.i();
    Object localObject1 = parama.eh(a.bbT);
    Metadata localMetadata;
    if (localObject1 != null)
    {
      localMetadata = b.a((a.b)localObject1, this.bdV);
      if (localMetadata != null) {
        locali.c(localMetadata);
      }
    }
    for (;;)
    {
      int i = 0;
      long l1 = -9223372036854775807L;
      if (i < parama.bck.size())
      {
        localObject1 = (a.a)parama.bck.get(i);
        long l2 = l1;
        Object localObject2;
        if (((a.a)localObject1).type == a.baW)
        {
          localObject2 = parama.eh(a.baV);
          if ((this.flags & 0x1) == 0) {
            break label349;
          }
        }
        label349:
        for (boolean bool = true;; bool = false)
        {
          j localj = b.a((a.a)localObject1, (a.b)localObject2, -9223372036854775807L, null, bool, this.bdV);
          l2 = l1;
          if (localj != null)
          {
            localObject1 = b.a(localj, ((a.a)localObject1).ei(a.baX).ei(a.baY).ei(a.baZ), locali);
            l2 = l1;
            if (((m)localObject1).sampleCount != 0)
            {
              a locala = new a(localj, (m)localObject1, this.aXZ.dW(i));
              int j = ((m)localObject1).bcG;
              Format localFormat = localj.aTo.dG(j + 30);
              localObject2 = localFormat;
              if (localj.type == 1)
              {
                localObject1 = localFormat;
                if (locali.sV()) {
                  localObject1 = localFormat.bc(locali.aTi, locali.aTj);
                }
                localObject2 = localObject1;
                if (localMetadata != null) {
                  localObject2 = ((Format)localObject1).a(localMetadata);
                }
              }
              locala.bai.f((Format)localObject2);
              l2 = Math.max(l1, localj.aTs);
              localArrayList.add(locala);
            }
          }
          i += 1;
          l1 = l2;
          break;
        }
      }
      this.aTs = l1;
      this.bdU = ((a[])localArrayList.toArray(new a[localArrayList.size()]));
      this.aXZ.sU();
      this.aXZ.a(this);
      AppMethodBeat.o(92119);
      return;
      localMetadata = null;
    }
  }
  
  private void tb()
  {
    this.aYa = 0;
    this.bcY = 0;
  }
  
  public final long L(long paramLong)
  {
    AppMethodBeat.i(92117);
    long l1 = 9223372036854775807L;
    a[] arrayOfa = this.bdU;
    int m = arrayOfa.length;
    int i = 0;
    if (i < m)
    {
      m localm = arrayOfa[i].bdW;
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
      switch (this.aYa)
      {
      default: 
        paramf = new IllegalStateException();
        AppMethodBeat.o(92116);
        throw paramf;
      case 0: 
        if (this.bcY != 0) {
          break label129;
        }
        if (paramf.a(this.bcS.data, 0, 8, true)) {
          break label93;
        }
        i = 0;
      }
    } while (i != 0);
    AppMethodBeat.o(92116);
    return -1;
    label93:
    this.bcY = 8;
    this.bcS.setPosition(0);
    this.bcX = this.bcS.dm();
    this.bcW = this.bcS.readInt();
    label129:
    if (this.bcX == 1L)
    {
      paramf.readFully(this.bcS.data, 8, 8);
      this.bcY += 8;
      this.bcX = this.bcS.vH();
    }
    while (this.bcX < this.bcY)
    {
      paramf = new o("Atom size less than header length (unsupported).");
      AppMethodBeat.o(92116);
      throw paramf;
      if (this.bcX == 0L)
      {
        l2 = paramf.getLength();
        l1 = l2;
        if (l2 == -1L)
        {
          l1 = l2;
          if (!this.bcU.isEmpty()) {
            l1 = ((a.a)this.bcU.peek()).bci;
          }
        }
        if (l1 != -1L) {
          this.bcX = (l1 - paramf.getPosition() + this.bcY);
        }
      }
    }
    int i = this.bcW;
    if ((i == a.baU) || (i == a.baW) || (i == a.baX) || (i == a.baY) || (i == a.baZ) || (i == a.bbi))
    {
      i = 1;
      label348:
      if (i == 0) {
        break label428;
      }
      l1 = paramf.getPosition() + this.bcX - this.bcY;
      this.bcU.add(new a.a(this.bcW, l1));
      if (this.bcX != this.bcY) {
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
      tb();
      continue;
      i = this.bcW;
      if ((i == a.bbk) || (i == a.baV) || (i == a.bbl) || (i == a.bbm) || (i == a.bbF) || (i == a.bbG) || (i == a.bbH) || (i == a.bbj) || (i == a.bbI) || (i == a.bbJ) || (i == a.bbK) || (i == a.bbL) || (i == a.bbM) || (i == a.bbh) || (i == a.bat) || (i == a.bbT))
      {
        i = 1;
        label547:
        if (i == 0) {
          break label649;
        }
        if (this.bcY != 8) {
          break label637;
        }
        bool = true;
        label563:
        com.google.android.exoplayer2.i.a.checkState(bool);
        if (this.bcX > 2147483647L) {
          break label643;
        }
      }
      label643:
      for (bool = true;; bool = false)
      {
        com.google.android.exoplayer2.i.a.checkState(bool);
        this.bcZ = new com.google.android.exoplayer2.i.m((int)this.bcX);
        System.arraycopy(this.bcS.data, 0, this.bcZ.data, 0, 8);
        this.aYa = 1;
        break;
        i = 0;
        break label547;
        label637:
        bool = false;
        break label563;
      }
      label649:
      this.bcZ = null;
      this.aYa = 1;
    }
    long l1 = this.bcX - this.bcY;
    long l2 = paramf.getPosition();
    Object localObject;
    if (this.bcZ != null)
    {
      paramf.readFully(this.bcZ.data, this.bcY, (int)l1);
      if (this.bcW == a.bat)
      {
        localObject = this.bcZ;
        ((com.google.android.exoplayer2.i.m)localObject).setPosition(8);
        if (((com.google.android.exoplayer2.i.m)localObject).readInt() == bdT)
        {
          bool = true;
          label746:
          this.bdV = bool;
          i = 0;
        }
      }
    }
    for (;;)
    {
      label754:
      O(l2 + l1);
      if ((i != 0) && (this.aYa != 2)) {}
      for (i = 1; i != 0; i = 0)
      {
        AppMethodBeat.o(92116);
        return 1;
        ((com.google.android.exoplayer2.i.m)localObject).eX(4);
        for (;;)
        {
          if (((com.google.android.exoplayer2.i.m)localObject).vy() > 0) {
            if (((com.google.android.exoplayer2.i.m)localObject).readInt() == bdT)
            {
              bool = true;
              break;
            }
          }
        }
        bool = false;
        break label746;
        if (this.bcU.isEmpty()) {
          break label1470;
        }
        ((a.a)this.bcU.peek()).a(new a.b(this.bcW, this.bcZ));
        i = 0;
        break label754;
        if (l1 < 262144L)
        {
          paramf.dQ((int)l1);
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
      while (i < this.bdU.length)
      {
        localObject = this.bdU[i];
        m = ((a)localObject).bcD;
        k = j;
        l2 = l1;
        if (m != ((a)localObject).bdW.sampleCount)
        {
          long l3 = localObject.bdW.offsets[m];
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
      localObject = this.bdU[j];
      com.google.android.exoplayer2.c.m localm = ((a)localObject).bai;
      int k = ((a)localObject).bcD;
      l2 = localObject.bdW.offsets[k];
      j = localObject.bdW.aXo[k];
      i = j;
      l1 = l2;
      if (((a)localObject).bdk.bea == 1)
      {
        l1 = l2 + 8L;
        i = j - 8;
      }
      l2 = l1 - paramf.getPosition() + this.aZs;
      if ((l2 < 0L) || (l2 >= 262144L))
      {
        paramk.position = l1;
        AppMethodBeat.o(92116);
        return 1;
      }
      paramf.dQ((int)l2);
      if (((a)localObject).bdk.aYl != 0)
      {
        paramk = this.aYk.data;
        paramk[0] = 0;
        paramk[1] = 0;
        paramk[2] = 0;
        j = ((a)localObject).bdk.aYl;
        m = 4 - ((a)localObject).bdk.aYl;
        while (this.aZs < i) {
          if (this.aZr == 0)
          {
            paramf.readFully(this.aYk.data, m, j);
            this.aYk.setPosition(0);
            this.aZr = this.aYk.vF();
            this.aYj.setPosition(0);
            localm.a(this.aYj, 4);
            this.aZs += 4;
            i += m;
          }
          else
          {
            int n = localm.a(paramf, this.aZr, false);
            this.aZs += n;
            this.aZr -= n;
          }
        }
      }
      for (;;)
      {
        localm.a(localObject.bdW.beA[k], localObject.bdW.bcI[k], i, 0, null);
        ((a)localObject).bcD += 1;
        this.aZs = 0;
        this.aZr = 0;
        AppMethodBeat.o(92116);
        return 0;
        while (this.aZs < i)
        {
          j = localm.a(paramf, i - this.aZs, false);
          this.aZs += j;
          this.aZr -= j;
        }
      }
      label1470:
      i = 0;
    }
  }
  
  public final void a(com.google.android.exoplayer2.c.g paramg)
  {
    this.aXZ = paramg;
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
    this.bcU.clear();
    this.bcY = 0;
    this.aZs = 0;
    this.aZr = 0;
    if (paramLong1 == 0L)
    {
      tb();
      AppMethodBeat.o(92115);
      return;
    }
    if (this.bdU != null)
    {
      a[] arrayOfa = this.bdU;
      int m = arrayOfa.length;
      int i = 0;
      while (i < m)
      {
        a locala = arrayOfa[i];
        m localm = locala.bdW;
        int k = localm.P(paramLong2);
        int j = k;
        if (k == -1) {
          j = localm.Q(paramLong2);
        }
        locala.bcD = j;
        i += 1;
      }
    }
    AppMethodBeat.o(92115);
  }
  
  public final long getDurationUs()
  {
    return this.aTs;
  }
  
  public final boolean sQ()
  {
    return true;
  }
  
  static final class a
  {
    public final com.google.android.exoplayer2.c.m bai;
    public int bcD;
    public final m bdW;
    public final j bdk;
    
    public a(j paramj, m paramm, com.google.android.exoplayer2.c.m paramm1)
    {
      this.bdk = paramj;
      this.bdW = paramm;
      this.bai = paramm1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.google.android.exoplayer2.c.d.g
 * JD-Core Version:    0.7.0.1
 */