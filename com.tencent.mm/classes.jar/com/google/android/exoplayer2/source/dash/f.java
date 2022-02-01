package com.google.android.exoplayer2.source.dash;

import android.os.SystemClock;
import com.google.android.exoplayer2.Format;
import com.google.android.exoplayer2.h.g.a;
import com.google.android.exoplayer2.h.s.e;
import com.google.android.exoplayer2.h.u;
import com.google.android.exoplayer2.i.x;
import com.google.android.exoplayer2.source.a.c;
import com.google.android.exoplayer2.source.a.h;
import com.google.android.exoplayer2.source.a.i;
import com.google.android.exoplayer2.source.a.k;
import com.google.android.exoplayer2.source.a.m;
import com.tencent.matrix.trace.core.AppMethodBeat;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public final class f
  implements a
{
  private final int aQq;
  private final com.google.android.exoplayer2.h.g aWG;
  private int blw;
  private final u bmW;
  private final com.google.android.exoplayer2.g.f bnC;
  private final int bnD;
  protected final b[] bnE;
  private IOException bnF;
  private boolean bnG;
  private com.google.android.exoplayer2.source.dash.manifest.b bna;
  private final int[] bnc;
  private final long bnu;
  
  public f(u paramu, com.google.android.exoplayer2.source.dash.manifest.b paramb, int paramInt1, int[] paramArrayOfInt, com.google.android.exoplayer2.g.f paramf, int paramInt2, com.google.android.exoplayer2.h.g paramg, long paramLong, int paramInt3, boolean paramBoolean1, boolean paramBoolean2)
  {
    AppMethodBeat.i(10509);
    this.bmW = paramu;
    this.bna = paramb;
    this.bnc = paramArrayOfInt;
    this.bnC = paramf;
    this.aQq = paramInt2;
    this.aWG = paramg;
    this.blw = paramInt1;
    this.bnu = paramLong;
    this.bnD = paramInt3;
    paramLong = paramb.eN(paramInt1);
    paramu = uk();
    this.bnE = new b[paramf.length()];
    paramInt1 = 0;
    while (paramInt1 < this.bnE.length)
    {
      paramb = (com.google.android.exoplayer2.source.dash.manifest.g)paramu.get(paramf.ff(paramInt1));
      this.bnE[paramInt1] = new b(paramLong, paramb, paramBoolean1, paramBoolean2);
      paramInt1 += 1;
    }
    AppMethodBeat.o(10509);
  }
  
  private ArrayList<com.google.android.exoplayer2.source.dash.manifest.g> uk()
  {
    AppMethodBeat.i(10514);
    List localList = this.bna.eL(this.blw).bnb;
    ArrayList localArrayList = new ArrayList();
    int[] arrayOfInt = this.bnc;
    int j = arrayOfInt.length;
    int i = 0;
    while (i < j)
    {
      localArrayList.addAll(((com.google.android.exoplayer2.source.dash.manifest.a)localList.get(arrayOfInt[i])).bnK);
      i += 1;
    }
    AppMethodBeat.o(10514);
    return localArrayList;
  }
  
  public final void a(c paramc)
  {
    AppMethodBeat.i(10512);
    if ((paramc instanceof k))
    {
      paramc = (k)paramc;
      paramc = this.bnE[this.bnC.j(paramc.bmm)];
      if (paramc.bnI == null)
      {
        com.google.android.exoplayer2.c.l locall = paramc.bmQ.bkU;
        if (locall != null) {
          paramc.bnI = new e((com.google.android.exoplayer2.c.a)locall);
        }
      }
    }
    AppMethodBeat.o(10512);
  }
  
  public final void a(com.google.android.exoplayer2.source.a.l paraml, long paramLong, com.google.android.exoplayer2.source.a.e parame)
  {
    AppMethodBeat.i(10511);
    if (this.bnF != null)
    {
      AppMethodBeat.o(10511);
      return;
    }
    long l;
    b localb;
    Object localObject2;
    com.google.android.exoplayer2.source.dash.manifest.f localf;
    Object localObject1;
    Object localObject3;
    int i;
    Object localObject4;
    String str;
    if (paraml != null)
    {
      l = paraml.bmq - paramLong;
      this.bnC.aj(l);
      localb = this.bnE[this.bnC.getSelectedIndex()];
      if (localb.bmQ == null) {
        break label267;
      }
      localObject2 = localb.bnH;
      localf = null;
      localObject1 = null;
      if (localb.bmQ.bmv == null) {
        localf = ((com.google.android.exoplayer2.source.dash.manifest.g)localObject2).bok;
      }
      if (localb.bnI == null) {
        localObject1 = ((com.google.android.exoplayer2.source.dash.manifest.g)localObject2).um();
      }
      if ((localf == null) && (localObject1 == null)) {
        break label267;
      }
      localObject2 = this.aWG;
      localObject3 = this.bnC.vb();
      i = this.bnC.up();
      localObject4 = this.bnC.uq();
      str = localb.bnH.bob;
      if (localf == null) {
        break label261;
      }
      paraml = localf.a((com.google.android.exoplayer2.source.dash.manifest.f)localObject1, str);
      if (paraml != null) {
        break label912;
      }
      paraml = localf;
    }
    label261:
    label267:
    label909:
    label912:
    for (;;)
    {
      parame.bmx = new k((com.google.android.exoplayer2.h.g)localObject2, new com.google.android.exoplayer2.h.j(paraml.ap(str), paraml.start, paraml.length, localb.bnH.getCacheKey()), (Format)localObject3, i, localObject4, localb.bmQ);
      AppMethodBeat.o(10511);
      return;
      l = 0L;
      break;
      paraml = (com.google.android.exoplayer2.source.a.l)localObject1;
      continue;
      int j;
      if (this.bnu != 0L)
      {
        l = (SystemClock.elapsedRealtime() + this.bnu) * 1000L;
        j = localb.ul();
        if (j != 0) {
          break label363;
        }
        if ((this.bna.bnP) && (this.blw >= this.bna.rQ() - 1)) {
          break label357;
        }
      }
      label357:
      for (boolean bool = true;; bool = false)
      {
        parame.bmy = bool;
        AppMethodBeat.o(10511);
        return;
        l = System.currentTimeMillis() * 1000L;
        break;
      }
      label363:
      i = localb.ui();
      if (j == -1)
      {
        l = l - this.bna.bnN * 1000L - this.bna.eL(this.blw).bof * 1000L;
        if (this.bna.bnR == -9223372036854775807L) {
          break label909;
        }
        i = Math.max(i, localb.ai(l - this.bna.bnR * 1000L));
      }
      for (;;)
      {
        j = localb.ai(l) - 1;
        int k = i;
        if (paraml == null)
        {
          i = x.v(localb.ai(paramLong), k, j);
          label485:
          if ((i <= j) && ((!this.bnG) || (i < j))) {
            break label606;
          }
          if ((this.bna.bnP) && (this.blw >= this.bna.rQ() - 1)) {
            break label600;
          }
        }
        label600:
        for (bool = true;; bool = false)
        {
          parame.bmy = bool;
          AppMethodBeat.o(10511);
          return;
          j = i + j - 1;
          k = i;
          break;
          m = paraml.uc();
          i = m;
          if (m >= k) {
            break label485;
          }
          this.bnF = new com.google.android.exoplayer2.source.b();
          AppMethodBeat.o(10511);
          return;
        }
        label606:
        int m = Math.min(this.bnD, j - i + 1);
        localObject1 = this.aWG;
        j = this.aQq;
        localObject2 = this.bnC.vb();
        int n = this.bnC.up();
        localObject3 = this.bnC.uq();
        localObject4 = localb.bnH;
        paramLong = localb.eJ(i);
        paraml = localb.eI(i);
        str = ((com.google.android.exoplayer2.source.dash.manifest.g)localObject4).bob;
        if (localb.bmQ == null) {
          l = localb.eK(i);
        }
        for (paraml = new m((com.google.android.exoplayer2.h.g)localObject1, new com.google.android.exoplayer2.h.j(paraml.ap(str), paraml.start, paraml.length, ((com.google.android.exoplayer2.source.dash.manifest.g)localObject4).getCacheKey()), (Format)localObject2, n, localObject3, paramLong, l, i, j, (Format)localObject2);; paraml = new i((com.google.android.exoplayer2.h.g)localObject1, new com.google.android.exoplayer2.h.j(paraml.ap(str), paraml.start, paraml.length, ((com.google.android.exoplayer2.source.dash.manifest.g)localObject4).getCacheKey()), (Format)localObject2, n, localObject3, paramLong, l, i, k, -((com.google.android.exoplayer2.source.dash.manifest.g)localObject4).boi, localb.bmQ))
        {
          parame.bmx = paraml;
          AppMethodBeat.o(10511);
          return;
          k = 1;
          j = 1;
          while (j < m)
          {
            localf = paraml.a(localb.eI(i + j), str);
            if (localf == null) {
              break;
            }
            k += 1;
            j += 1;
            paraml = localf;
          }
          l = localb.eK(i + k - 1);
        }
      }
    }
  }
  
  public final void a(com.google.android.exoplayer2.source.dash.manifest.b paramb, int paramInt)
  {
    AppMethodBeat.i(10510);
    for (;;)
    {
      b localb;
      d locald1;
      int j;
      long l3;
      try
      {
        this.bna = paramb;
        this.blw = paramInt;
        long l1 = this.bna.eN(this.blw);
        paramb = uk();
        paramInt = 0;
        if (paramInt >= this.bnE.length) {
          break label296;
        }
        com.google.android.exoplayer2.source.dash.manifest.g localg = (com.google.android.exoplayer2.source.dash.manifest.g)paramb.get(this.bnC.ff(paramInt));
        localb = this.bnE[paramInt];
        locald1 = localb.bnH.un();
        d locald2 = localg.un();
        localb.bmc = l1;
        localb.bnH = localg;
        if (locald1 == null) {
          break label303;
        }
        localb.bnI = locald2;
        if (!locald1.uj()) {
          break label303;
        }
        int i = locald1.ah(localb.bmc);
        if (i == 0) {
          break label303;
        }
        i = i + locald1.ui() - 1;
        long l2 = locald1.eH(i) + locald1.k(i, localb.bmc);
        j = locald2.ui();
        l3 = locald2.eH(j);
        if (l2 == l3)
        {
          localb.bnJ = (i + 1 - j + localb.bnJ);
          break label303;
        }
        if (l2 < l3)
        {
          paramb = new com.google.android.exoplayer2.source.b();
          AppMethodBeat.o(10510);
          throw paramb;
        }
      }
      catch (com.google.android.exoplayer2.source.b paramb)
      {
        this.bnF = paramb;
        AppMethodBeat.o(10510);
        return;
      }
      localb.bnJ += locald1.j(l3, localb.bmc) - j;
      break label303;
      label296:
      AppMethodBeat.o(10510);
      return;
      label303:
      paramInt += 1;
    }
  }
  
  public final boolean a(c paramc, boolean paramBoolean, Exception paramException)
  {
    AppMethodBeat.i(10513);
    if (!paramBoolean)
    {
      AppMethodBeat.o(10513);
      return false;
    }
    if ((!this.bna.bnP) && ((paramc instanceof com.google.android.exoplayer2.source.a.l)) && ((paramException instanceof s.e)) && (((s.e)paramException).responseCode == 404))
    {
      b localb = this.bnE[this.bnC.j(paramc.bmm)];
      int i = localb.ul();
      if ((i != -1) && (i != 0))
      {
        int j = localb.ui();
        if (((com.google.android.exoplayer2.source.a.l)paramc).uc() > j + i - 1)
        {
          this.bnG = true;
          AppMethodBeat.o(10513);
          return true;
        }
      }
    }
    paramBoolean = h.a(this.bnC, this.bnC.j(paramc.bmm), paramException);
    AppMethodBeat.o(10513);
    return paramBoolean;
  }
  
  public static final class a
    implements a.a
  {
    private final g.a blq;
    private final int bnD;
    
    public a(g.a parama)
    {
      this(parama, (byte)0);
    }
    
    private a(g.a parama, byte paramByte)
    {
      this.blq = parama;
      this.bnD = 1;
    }
    
    public final a a(u paramu, com.google.android.exoplayer2.source.dash.manifest.b paramb, int paramInt1, int[] paramArrayOfInt, com.google.android.exoplayer2.g.f paramf, int paramInt2, long paramLong, boolean paramBoolean1, boolean paramBoolean2)
    {
      AppMethodBeat.i(10501);
      paramu = new f(paramu, paramb, paramInt1, paramArrayOfInt, paramf, paramInt2, this.blq.vi(), paramLong, this.bnD, paramBoolean1, paramBoolean2);
      AppMethodBeat.o(10501);
      return paramu;
    }
  }
  
  protected static final class b
  {
    final com.google.android.exoplayer2.source.a.d bmQ;
    long bmc;
    public com.google.android.exoplayer2.source.dash.manifest.g bnH;
    public d bnI;
    int bnJ;
    
    b(long paramLong, com.google.android.exoplayer2.source.dash.manifest.g paramg, boolean paramBoolean1, boolean paramBoolean2)
    {
      AppMethodBeat.i(10502);
      this.bmc = paramLong;
      this.bnH = paramg;
      Object localObject = paramg.aSv.aSc;
      if ((com.google.android.exoplayer2.i.j.aL((String)localObject)) || ("application/ttml+xml".equals(localObject))) {}
      for (int i = 1; i != 0; i = 0)
      {
        this.bmQ = null;
        this.bnI = paramg.un();
        AppMethodBeat.o(10502);
        return;
      }
      if ("application/x-rawcc".equals(localObject)) {
        localObject = new com.google.android.exoplayer2.c.f.a(paramg.aSv);
      }
      for (;;)
      {
        this.bmQ = new com.google.android.exoplayer2.source.a.d((com.google.android.exoplayer2.c.e)localObject, paramg.aSv);
        break;
        if ((((String)localObject).startsWith("video/webm")) || (((String)localObject).startsWith("audio/webm")) || (((String)localObject).startsWith("application/webm"))) {}
        for (i = 1;; i = 0)
        {
          if (i == 0) {
            break label184;
          }
          localObject = new com.google.android.exoplayer2.c.b.d(1);
          break;
        }
        label184:
        i = j;
        if (paramBoolean1) {
          i = 4;
        }
        j = i;
        if (paramBoolean2) {
          j = i | 0x8;
        }
        localObject = new com.google.android.exoplayer2.c.d.e(j);
      }
    }
    
    public final int ai(long paramLong)
    {
      AppMethodBeat.i(10507);
      int i = this.bnI.j(paramLong, this.bmc);
      int j = this.bnJ;
      AppMethodBeat.o(10507);
      return i + j;
    }
    
    public final com.google.android.exoplayer2.source.dash.manifest.f eI(int paramInt)
    {
      AppMethodBeat.i(10508);
      com.google.android.exoplayer2.source.dash.manifest.f localf = this.bnI.eI(paramInt - this.bnJ);
      AppMethodBeat.o(10508);
      return localf;
    }
    
    public final long eJ(int paramInt)
    {
      AppMethodBeat.i(10505);
      long l = this.bnI.eH(paramInt - this.bnJ);
      AppMethodBeat.o(10505);
      return l;
    }
    
    public final long eK(int paramInt)
    {
      AppMethodBeat.i(10506);
      long l1 = eJ(paramInt);
      long l2 = this.bnI.k(paramInt - this.bnJ, this.bmc);
      AppMethodBeat.o(10506);
      return l1 + l2;
    }
    
    public final int ui()
    {
      AppMethodBeat.i(10503);
      int i = this.bnI.ui();
      int j = this.bnJ;
      AppMethodBeat.o(10503);
      return i + j;
    }
    
    public final int ul()
    {
      AppMethodBeat.i(10504);
      int i = this.bnI.ah(this.bmc);
      AppMethodBeat.o(10504);
      return i;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.google.android.exoplayer2.source.dash.f
 * JD-Core Version:    0.7.0.1
 */