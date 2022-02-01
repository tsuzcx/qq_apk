package com.google.android.exoplayer2.source;

import com.google.android.exoplayer2.f;
import com.google.android.exoplayer2.i.a;
import com.google.android.exoplayer2.w;
import com.google.android.exoplayer2.w.a;
import com.google.android.exoplayer2.w.b;
import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.ArrayList;

public final class e
  implements k, k.a
{
  private final k bcG;
  private final ArrayList<d> bvA;
  private k.a bvB;
  private a bvC;
  private final long bvt;
  private final long bvu;
  private final boolean bvz;
  
  public e(k paramk, long paramLong1, long paramLong2)
  {
    this(paramk, paramLong1, paramLong2, (byte)0);
  }
  
  private e(k paramk, long paramLong1, long paramLong2, byte paramByte)
  {
    AppMethodBeat.i(92633);
    if (paramLong1 >= 0L) {}
    for (boolean bool = true;; bool = false)
    {
      a.checkArgument(bool);
      this.bcG = ((k)a.checkNotNull(paramk));
      this.bvt = paramLong1;
      this.bvu = paramLong2;
      this.bvz = true;
      this.bvA = new ArrayList();
      AppMethodBeat.o(92633);
      return;
    }
  }
  
  public final j a(k.b paramb, com.google.android.exoplayer2.h.b paramb1)
  {
    AppMethodBeat.i(92636);
    paramb = new d(this.bcG.a(paramb, paramb1), this.bvz);
    this.bvA.add(paramb);
    paramb.h(a.a(this.bvC), a.b(this.bvC));
    AppMethodBeat.o(92636);
    return paramb;
  }
  
  public final void a(f paramf, k.a parama)
  {
    AppMethodBeat.i(92634);
    this.bvB = parama;
    this.bcG.a(paramf, this);
    AppMethodBeat.o(92634);
  }
  
  public final void a(w paramw, Object paramObject)
  {
    AppMethodBeat.i(92639);
    this.bvC = new a(paramw, this.bvt, this.bvu);
    this.bvB.a(this.bvC, paramObject);
    long l2 = a.a(this.bvC);
    if (a.b(this.bvC) == -9223372036854775807L) {}
    for (long l1 = -9223372036854775808L;; l1 = a.b(this.bvC))
    {
      int j = this.bvA.size();
      int i = 0;
      while (i < j)
      {
        ((d)this.bvA.get(i)).h(l2, l1);
        i += 1;
      }
    }
    AppMethodBeat.o(92639);
  }
  
  public final void b(j paramj)
  {
    AppMethodBeat.i(92637);
    a.checkState(this.bvA.remove(paramj));
    this.bcG.b(((d)paramj).bcS);
    AppMethodBeat.o(92637);
  }
  
  public final void vt()
  {
    AppMethodBeat.i(92635);
    this.bcG.vt();
    AppMethodBeat.o(92635);
  }
  
  public final void vu()
  {
    AppMethodBeat.i(92638);
    this.bcG.vu();
    AppMethodBeat.o(92638);
  }
  
  static final class a
    extends w
  {
    private final w bco;
    private final long bvt;
    private final long bvu;
    
    public a(w paramw, long paramLong1, long paramLong2)
    {
      AppMethodBeat.i(92628);
      if (paramw.tD() == 1)
      {
        bool = true;
        a.checkArgument(bool);
        if (paramw.tE() != 1) {
          break label223;
        }
        bool = true;
        label36:
        a.checkArgument(bool);
        w.b localb = paramw.a(0, new w.b());
        if (localb.bex) {
          break label229;
        }
        bool = true;
        label66:
        a.checkArgument(bool);
        long l = paramLong2;
        if (paramLong2 == -9223372036854775808L) {
          l = localb.bdJ;
        }
        paramLong2 = l;
        if (localb.bdJ != -9223372036854775807L)
        {
          paramLong2 = l;
          if (l > localb.bdJ) {
            paramLong2 = localb.bdJ;
          }
          if ((paramLong1 != 0L) && (!localb.bew)) {
            break label235;
          }
          bool = true;
          label146:
          a.checkArgument(bool);
          if (paramLong1 > paramLong2) {
            break label241;
          }
          bool = true;
          label161:
          a.checkArgument(bool);
        }
        if (paramw.a(0, new w.a(), false).ben != 0L) {
          break label247;
        }
      }
      label223:
      label229:
      label235:
      label241:
      label247:
      for (boolean bool = true;; bool = false)
      {
        a.checkArgument(bool);
        this.bco = paramw;
        this.bvt = paramLong1;
        this.bvu = paramLong2;
        AppMethodBeat.o(92628);
        return;
        bool = false;
        break;
        bool = false;
        break label36;
        bool = false;
        break label66;
        bool = false;
        break label146;
        bool = false;
        break label161;
      }
    }
    
    public final w.a a(int paramInt, w.a parama, boolean paramBoolean)
    {
      long l = -9223372036854775807L;
      AppMethodBeat.i(92631);
      parama = this.bco.a(0, parama, paramBoolean);
      if (this.bvu != -9223372036854775807L) {
        l = this.bvu - this.bvt;
      }
      parama.bdJ = l;
      AppMethodBeat.o(92631);
      return parama;
    }
    
    public final w.b a(int paramInt, w.b paramb, boolean paramBoolean, long paramLong)
    {
      AppMethodBeat.i(92630);
      paramb = this.bco.a(0, paramb, paramBoolean, paramLong);
      if (this.bvu != -9223372036854775807L)
      {
        paramLong = this.bvu - this.bvt;
        paramb.bdJ = paramLong;
        if (paramb.beA != -9223372036854775807L)
        {
          paramb.beA = Math.max(paramb.beA, this.bvt);
          if (this.bvu != -9223372036854775807L) {
            break label176;
          }
        }
      }
      label176:
      for (paramLong = paramb.beA;; paramLong = Math.min(paramb.beA, this.bvu))
      {
        paramb.beA = paramLong;
        paramb.beA -= this.bvt;
        paramLong = com.google.android.exoplayer2.b.v(this.bvt);
        if (paramb.beu != -9223372036854775807L) {
          paramb.beu += paramLong;
        }
        if (paramb.bev != -9223372036854775807L) {
          paramb.bev = (paramLong + paramb.bev);
        }
        AppMethodBeat.o(92630);
        return paramb;
        paramLong = -9223372036854775807L;
        break;
      }
    }
    
    public final int aZ(int paramInt1, int paramInt2)
    {
      AppMethodBeat.i(92629);
      paramInt1 = this.bco.aZ(paramInt1, paramInt2);
      AppMethodBeat.o(92629);
      return paramInt1;
    }
    
    public final int ae(Object paramObject)
    {
      AppMethodBeat.i(92632);
      int i = this.bco.ae(paramObject);
      AppMethodBeat.o(92632);
      return i;
    }
    
    public final int tD()
    {
      return 1;
    }
    
    public final int tE()
    {
      return 1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes8.jar
 * Qualified Name:     com.google.android.exoplayer2.source.e
 * JD-Core Version:    0.7.0.1
 */