package com.google.android.exoplayer2.source;

import com.google.android.exoplayer2.f;
import com.google.android.exoplayer2.i.a;
import com.google.android.exoplayer2.w;
import com.google.android.exoplayer2.w.a;
import com.google.android.exoplayer2.w.b;
import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.ArrayList;

public final class d
  implements i, i.a
{
  private final i bcJ;
  private final boolean bvE;
  private final ArrayList<c> bvF;
  private i.a bvG;
  private a bvH;
  private final long bvy;
  private final long bvz;
  
  public d(i parami, long paramLong1, long paramLong2)
  {
    this(parami, paramLong1, paramLong2, (byte)0);
  }
  
  private d(i parami, long paramLong1, long paramLong2, byte paramByte)
  {
    AppMethodBeat.i(92633);
    if (paramLong1 >= 0L) {}
    for (boolean bool = true;; bool = false)
    {
      a.checkArgument(bool);
      this.bcJ = ((i)a.checkNotNull(parami));
      this.bvy = paramLong1;
      this.bvz = paramLong2;
      this.bvE = true;
      this.bvF = new ArrayList();
      AppMethodBeat.o(92633);
      return;
    }
  }
  
  public final h a(i.b paramb, com.google.android.exoplayer2.h.b paramb1)
  {
    AppMethodBeat.i(92636);
    paramb = new c(this.bcJ.a(paramb, paramb1), this.bvE);
    this.bvF.add(paramb);
    paramb.h(a.a(this.bvH), a.b(this.bvH));
    AppMethodBeat.o(92636);
    return paramb;
  }
  
  public final void a(f paramf, i.a parama)
  {
    AppMethodBeat.i(92634);
    this.bvG = parama;
    this.bcJ.a(paramf, this);
    AppMethodBeat.o(92634);
  }
  
  public final void a(w paramw, Object paramObject)
  {
    AppMethodBeat.i(92639);
    this.bvH = new a(paramw, this.bvy, this.bvz);
    this.bvG.a(this.bvH, paramObject);
    long l2 = a.a(this.bvH);
    if (a.b(this.bvH) == -9223372036854775807L) {}
    for (long l1 = -9223372036854775808L;; l1 = a.b(this.bvH))
    {
      int j = this.bvF.size();
      int i = 0;
      while (i < j)
      {
        ((c)this.bvF.get(i)).h(l2, l1);
        i += 1;
      }
    }
    AppMethodBeat.o(92639);
  }
  
  public final void b(h paramh)
  {
    AppMethodBeat.i(92637);
    a.checkState(this.bvF.remove(paramh));
    this.bcJ.b(((c)paramh).bcV);
    AppMethodBeat.o(92637);
  }
  
  public final void vn()
  {
    AppMethodBeat.i(92635);
    this.bcJ.vn();
    AppMethodBeat.o(92635);
  }
  
  public final void vo()
  {
    AppMethodBeat.i(92638);
    this.bcJ.vo();
    AppMethodBeat.o(92638);
  }
  
  static final class a
    extends w
  {
    private final w bcr;
    private final long bvy;
    private final long bvz;
    
    public a(w paramw, long paramLong1, long paramLong2)
    {
      AppMethodBeat.i(92628);
      if (paramw.ty() == 1)
      {
        bool = true;
        a.checkArgument(bool);
        if (paramw.tz() != 1) {
          break label223;
        }
        bool = true;
        label36:
        a.checkArgument(bool);
        w.b localb = paramw.a(0, new w.b());
        if (localb.beA) {
          break label229;
        }
        bool = true;
        label66:
        a.checkArgument(bool);
        long l = paramLong2;
        if (paramLong2 == -9223372036854775808L) {
          l = localb.bdM;
        }
        paramLong2 = l;
        if (localb.bdM != -9223372036854775807L)
        {
          paramLong2 = l;
          if (l > localb.bdM) {
            paramLong2 = localb.bdM;
          }
          if ((paramLong1 != 0L) && (!localb.bez)) {
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
        if (paramw.a(0, new w.a(), false).beq != 0L) {
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
        this.bcr = paramw;
        this.bvy = paramLong1;
        this.bvz = paramLong2;
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
      parama = this.bcr.a(0, parama, paramBoolean);
      if (this.bvz != -9223372036854775807L) {
        l = this.bvz - this.bvy;
      }
      parama.bdM = l;
      AppMethodBeat.o(92631);
      return parama;
    }
    
    public final w.b a(int paramInt, w.b paramb, boolean paramBoolean, long paramLong)
    {
      AppMethodBeat.i(92630);
      paramb = this.bcr.a(0, paramb, paramBoolean, paramLong);
      if (this.bvz != -9223372036854775807L)
      {
        paramLong = this.bvz - this.bvy;
        paramb.bdM = paramLong;
        if (paramb.beD != -9223372036854775807L)
        {
          paramb.beD = Math.max(paramb.beD, this.bvy);
          if (this.bvz != -9223372036854775807L) {
            break label176;
          }
        }
      }
      label176:
      for (paramLong = paramb.beD;; paramLong = Math.min(paramb.beD, this.bvz))
      {
        paramb.beD = paramLong;
        paramb.beD -= this.bvy;
        paramLong = com.google.android.exoplayer2.b.v(this.bvy);
        if (paramb.bex != -9223372036854775807L) {
          paramb.bex += paramLong;
        }
        if (paramb.bey != -9223372036854775807L) {
          paramb.bey = (paramLong + paramb.bey);
        }
        AppMethodBeat.o(92630);
        return paramb;
        paramLong = -9223372036854775807L;
        break;
      }
    }
    
    public final int ae(Object paramObject)
    {
      AppMethodBeat.i(92632);
      int i = this.bcr.ae(paramObject);
      AppMethodBeat.o(92632);
      return i;
    }
    
    public final int bf(int paramInt1, int paramInt2)
    {
      AppMethodBeat.i(92629);
      paramInt1 = this.bcr.bf(paramInt1, paramInt2);
      AppMethodBeat.o(92629);
      return paramInt1;
    }
    
    public final int ty()
    {
      return 1;
    }
    
    public final int tz()
    {
      return 1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.google.android.exoplayer2.source.d
 * JD-Core Version:    0.7.0.1
 */