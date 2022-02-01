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
  public static final h cLL;
  private static final int cRH;
  private long cHg;
  private com.google.android.exoplayer2.c.g cLR;
  private int cLS;
  private final com.google.android.exoplayer2.i.m cMb;
  private final com.google.android.exoplayer2.i.m cMc;
  private int cNj;
  private int cNk;
  private final com.google.android.exoplayer2.i.m cQG;
  private final Stack<a.a> cQI;
  private int cQK;
  private long cQL;
  private int cQM;
  private com.google.android.exoplayer2.i.m cQN;
  private a[] cRI;
  private boolean cRJ;
  private final int flags;
  
  static
  {
    AppMethodBeat.i(92120);
    cLL = new h()
    {
      public final e[] RV()
      {
        AppMethodBeat.i(92112);
        g localg = new g();
        AppMethodBeat.o(92112);
        return new e[] { localg };
      }
    };
    cRH = x.du("qt  ");
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
    this.cQG = new com.google.android.exoplayer2.i.m(16);
    this.cQI = new Stack();
    this.cMb = new com.google.android.exoplayer2.i.m(com.google.android.exoplayer2.i.k.dkg);
    this.cMc = new com.google.android.exoplayer2.i.m(4);
    AppMethodBeat.o(92113);
  }
  
  private void Sd()
  {
    this.cLS = 0;
    this.cQM = 0;
  }
  
  private void cf(long paramLong)
  {
    AppMethodBeat.i(92118);
    while ((!this.cQI.isEmpty()) && (((a.a)this.cQI.peek()).cPW == paramLong))
    {
      a.a locala = (a.a)this.cQI.pop();
      if (locala.type == a.cOI)
      {
        f(locala);
        this.cQI.clear();
        this.cLS = 2;
      }
      else if (!this.cQI.isEmpty())
      {
        ((a.a)this.cQI.peek()).a(locala);
      }
    }
    if (this.cLS != 2) {
      Sd();
    }
    AppMethodBeat.o(92118);
  }
  
  private void f(a.a parama)
  {
    AppMethodBeat.i(92119);
    ArrayList localArrayList = new ArrayList();
    com.google.android.exoplayer2.c.i locali = new com.google.android.exoplayer2.c.i();
    Object localObject1 = parama.hJ(a.cPH);
    Metadata localMetadata;
    if (localObject1 != null)
    {
      localMetadata = b.a((a.b)localObject1, this.cRJ);
      if (localMetadata != null) {
        locali.c(localMetadata);
      }
    }
    for (;;)
    {
      int i = 0;
      long l1 = -9223372036854775807L;
      if (i < parama.cPY.size())
      {
        localObject1 = (a.a)parama.cPY.get(i);
        long l2 = l1;
        Object localObject2;
        if (((a.a)localObject1).type == a.cOK)
        {
          localObject2 = parama.hJ(a.cOJ);
          if ((this.flags & 0x1) == 0) {
            break label349;
          }
        }
        label349:
        for (boolean bool = true;; bool = false)
        {
          j localj = b.a((a.a)localObject1, (a.b)localObject2, -9223372036854775807L, null, bool, this.cRJ);
          l2 = l1;
          if (localj != null)
          {
            localObject1 = b.a(localj, ((a.a)localObject1).hK(a.cOL).hK(a.cOM).hK(a.cON), locali);
            l2 = l1;
            if (((m)localObject1).sampleCount != 0)
            {
              a locala = new a(localj, (m)localObject1, this.cLR.hz(i));
              int j = ((m)localObject1).cQu;
              Format localFormat = localj.cHc.hk(j + 30);
              localObject2 = localFormat;
              if (localj.type == 1)
              {
                localObject1 = localFormat;
                if (locali.RX()) {
                  localObject1 = localFormat.bZ(locali.cGW, locali.cGX);
                }
                localObject2 = localObject1;
                if (localMetadata != null) {
                  localObject2 = ((Format)localObject1).a(localMetadata);
                }
              }
              locala.cNW.f((Format)localObject2);
              l2 = Math.max(l1, localj.cHg);
              localArrayList.add(locala);
            }
          }
          i += 1;
          l1 = l2;
          break;
        }
      }
      this.cHg = l1;
      this.cRI = ((a[])localArrayList.toArray(new a[localArrayList.size()]));
      this.cLR.RW();
      this.cLR.a(this);
      AppMethodBeat.o(92119);
      return;
      localMetadata = null;
    }
  }
  
  public final void C(long paramLong1, long paramLong2)
  {
    AppMethodBeat.i(92115);
    this.cQI.clear();
    this.cQM = 0;
    this.cNk = 0;
    this.cNj = 0;
    if (paramLong1 == 0L)
    {
      Sd();
      AppMethodBeat.o(92115);
      return;
    }
    if (this.cRI != null)
    {
      a[] arrayOfa = this.cRI;
      int m = arrayOfa.length;
      int i = 0;
      while (i < m)
      {
        a locala = arrayOfa[i];
        m localm = locala.cRK;
        int k = localm.cg(paramLong2);
        int j = k;
        if (k == -1) {
          j = localm.ch(paramLong2);
        }
        locala.cQr = j;
        i += 1;
      }
    }
    AppMethodBeat.o(92115);
  }
  
  public final boolean RR()
  {
    return true;
  }
  
  public final int a(f paramf, com.google.android.exoplayer2.c.k paramk)
  {
    AppMethodBeat.i(92116);
    do
    {
      switch (this.cLS)
      {
      default: 
        paramf = new IllegalStateException();
        AppMethodBeat.o(92116);
        throw paramf;
      case 0: 
        if (this.cQM != 0) {
          break label129;
        }
        if (paramf.a(this.cQG.data, 0, 8, true)) {
          break label93;
        }
        i = 0;
      }
    } while (i != 0);
    AppMethodBeat.o(92116);
    return -1;
    label93:
    this.cQM = 8;
    this.cQG.setPosition(0);
    this.cQL = this.cQG.FT();
    this.cQK = this.cQG.readInt();
    label129:
    if (this.cQL == 1L)
    {
      paramf.readFully(this.cQG.data, 8, 8);
      this.cQM += 8;
      this.cQL = this.cQG.UP();
    }
    while (this.cQL < this.cQM)
    {
      paramf = new o("Atom size less than header length (unsupported).");
      AppMethodBeat.o(92116);
      throw paramf;
      if (this.cQL == 0L)
      {
        l2 = paramf.RU();
        l1 = l2;
        if (l2 == -1L)
        {
          l1 = l2;
          if (!this.cQI.isEmpty()) {
            l1 = ((a.a)this.cQI.peek()).cPW;
          }
        }
        if (l1 != -1L) {
          this.cQL = (l1 - paramf.getPosition() + this.cQM);
        }
      }
    }
    int i = this.cQK;
    if ((i == a.cOI) || (i == a.cOK) || (i == a.cOL) || (i == a.cOM) || (i == a.cON) || (i == a.cOW))
    {
      i = 1;
      label348:
      if (i == 0) {
        break label428;
      }
      l1 = paramf.getPosition() + this.cQL - this.cQM;
      this.cQI.add(new a.a(this.cQK, l1));
      if (this.cQL != this.cQM) {
        break label421;
      }
      cf(l1);
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
      Sd();
      continue;
      i = this.cQK;
      if ((i == a.cOY) || (i == a.cOJ) || (i == a.cOZ) || (i == a.cPa) || (i == a.cPt) || (i == a.cPu) || (i == a.cPv) || (i == a.cOX) || (i == a.cPw) || (i == a.cPx) || (i == a.cPy) || (i == a.cPz) || (i == a.cPA) || (i == a.cOV) || (i == a.cOh) || (i == a.cPH))
      {
        i = 1;
        label547:
        if (i == 0) {
          break label649;
        }
        if (this.cQM != 8) {
          break label637;
        }
        bool = true;
        label563:
        com.google.android.exoplayer2.i.a.checkState(bool);
        if (this.cQL > 2147483647L) {
          break label643;
        }
      }
      label643:
      for (bool = true;; bool = false)
      {
        com.google.android.exoplayer2.i.a.checkState(bool);
        this.cQN = new com.google.android.exoplayer2.i.m((int)this.cQL);
        System.arraycopy(this.cQG.data, 0, this.cQN.data, 0, 8);
        this.cLS = 1;
        break;
        i = 0;
        break label547;
        label637:
        bool = false;
        break label563;
      }
      label649:
      this.cQN = null;
      this.cLS = 1;
    }
    long l1 = this.cQL - this.cQM;
    long l2 = paramf.getPosition();
    Object localObject;
    if (this.cQN != null)
    {
      paramf.readFully(this.cQN.data, this.cQM, (int)l1);
      if (this.cQK == a.cOh)
      {
        localObject = this.cQN;
        ((com.google.android.exoplayer2.i.m)localObject).setPosition(8);
        if (((com.google.android.exoplayer2.i.m)localObject).readInt() == cRH)
        {
          bool = true;
          label746:
          this.cRJ = bool;
          i = 0;
        }
      }
    }
    for (;;)
    {
      label754:
      cf(l2 + l1);
      if ((i != 0) && (this.cLS != 2)) {}
      for (i = 1; i != 0; i = 0)
      {
        AppMethodBeat.o(92116);
        return 1;
        ((com.google.android.exoplayer2.i.m)localObject).iH(4);
        for (;;)
        {
          if (((com.google.android.exoplayer2.i.m)localObject).UF() > 0) {
            if (((com.google.android.exoplayer2.i.m)localObject).readInt() == cRH)
            {
              bool = true;
              break;
            }
          }
        }
        bool = false;
        break label746;
        if (this.cQI.isEmpty()) {
          break label1470;
        }
        ((a.a)this.cQI.peek()).a(new a.b(this.cQK, this.cQN));
        i = 0;
        break label754;
        if (l1 < 262144L)
        {
          paramf.eP((int)l1);
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
      while (i < this.cRI.length)
      {
        localObject = this.cRI[i];
        m = ((a)localObject).cQr;
        k = j;
        l2 = l1;
        if (m != ((a)localObject).cRK.sampleCount)
        {
          long l3 = localObject.cRK.offsets[m];
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
      localObject = this.cRI[j];
      com.google.android.exoplayer2.c.m localm = ((a)localObject).cNW;
      int k = ((a)localObject).cQr;
      l2 = localObject.cRK.offsets[k];
      j = localObject.cRK.cLg[k];
      i = j;
      l1 = l2;
      if (((a)localObject).cQY.cRO == 1)
      {
        l1 = l2 + 8L;
        i = j - 8;
      }
      l2 = l1 - paramf.getPosition() + this.cNk;
      if ((l2 < 0L) || (l2 >= 262144L))
      {
        paramk.position = l1;
        AppMethodBeat.o(92116);
        return 1;
      }
      paramf.eP((int)l2);
      if (((a)localObject).cQY.cMd != 0)
      {
        paramk = this.cMc.data;
        paramk[0] = 0;
        paramk[1] = 0;
        paramk[2] = 0;
        j = ((a)localObject).cQY.cMd;
        m = 4 - ((a)localObject).cQY.cMd;
        while (this.cNk < i) {
          if (this.cNj == 0)
          {
            paramf.readFully(this.cMc.data, m, j);
            this.cMc.setPosition(0);
            this.cNj = this.cMc.UN();
            this.cMb.setPosition(0);
            localm.a(this.cMb, 4);
            this.cNk += 4;
            i += m;
          }
          else
          {
            int n = localm.a(paramf, this.cNj, false);
            this.cNk += n;
            this.cNj -= n;
          }
        }
      }
      for (;;)
      {
        localm.a(localObject.cRK.cSo[k], localObject.cRK.cQw[k], i, 0, null);
        ((a)localObject).cQr += 1;
        this.cNk = 0;
        this.cNj = 0;
        AppMethodBeat.o(92116);
        return 0;
        while (this.cNk < i)
        {
          j = localm.a(paramf, i - this.cNk, false);
          this.cNk += j;
          this.cNj -= j;
        }
      }
      label1470:
      i = 0;
    }
  }
  
  public final void a(com.google.android.exoplayer2.c.g paramg)
  {
    this.cLR = paramg;
  }
  
  public final boolean a(f paramf)
  {
    AppMethodBeat.i(92114);
    boolean bool = i.h(paramf);
    AppMethodBeat.o(92114);
    return bool;
  }
  
  public final long cc(long paramLong)
  {
    AppMethodBeat.i(92117);
    long l1 = 9223372036854775807L;
    a[] arrayOfa = this.cRI;
    int m = arrayOfa.length;
    int i = 0;
    if (i < m)
    {
      m localm = arrayOfa[i].cRK;
      int k = localm.cg(paramLong);
      int j = k;
      if (k == -1) {
        j = localm.ch(paramLong);
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
  
  public final long getDurationUs()
  {
    return this.cHg;
  }
  
  static final class a
  {
    public final com.google.android.exoplayer2.c.m cNW;
    public final j cQY;
    public int cQr;
    public final m cRK;
    
    public a(j paramj, m paramm, com.google.android.exoplayer2.c.m paramm1)
    {
      this.cQY = paramj;
      this.cRK = paramm;
      this.cNW = paramm1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes12.jar
 * Qualified Name:     com.google.android.exoplayer2.c.d.g
 * JD-Core Version:    0.7.0.1
 */