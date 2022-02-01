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
  private final k cGd;
  private final long cYO;
  private final long cYP;
  private final boolean cYU;
  private final ArrayList<d> cYV;
  private k.a cYW;
  private a cYX;
  
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
      this.cGd = ((k)a.checkNotNull(paramk));
      this.cYO = paramLong1;
      this.cYP = paramLong2;
      this.cYU = true;
      this.cYV = new ArrayList();
      AppMethodBeat.o(92633);
      return;
    }
  }
  
  public final void SU()
  {
    AppMethodBeat.i(92635);
    this.cGd.SU();
    AppMethodBeat.o(92635);
  }
  
  public final void SV()
  {
    AppMethodBeat.i(92638);
    this.cGd.SV();
    AppMethodBeat.o(92638);
  }
  
  public final j a(k.b paramb, com.google.android.exoplayer2.h.b paramb1)
  {
    AppMethodBeat.i(92636);
    paramb = new d(this.cGd.a(paramb, paramb1), this.cYU);
    this.cYV.add(paramb);
    paramb.E(a.a(this.cYX), a.b(this.cYX));
    AppMethodBeat.o(92636);
    return paramb;
  }
  
  public final void a(f paramf, k.a parama)
  {
    AppMethodBeat.i(92634);
    this.cYW = parama;
    this.cGd.a(paramf, this);
    AppMethodBeat.o(92634);
  }
  
  public final void a(w paramw, Object paramObject)
  {
    AppMethodBeat.i(92639);
    this.cYX = new a(paramw, this.cYO, this.cYP);
    this.cYW.a(this.cYX, paramObject);
    long l2 = a.a(this.cYX);
    if (a.b(this.cYX) == -9223372036854775807L) {}
    for (long l1 = -9223372036854775808L;; l1 = a.b(this.cYX))
    {
      int j = this.cYV.size();
      int i = 0;
      while (i < j)
      {
        ((d)this.cYV.get(i)).E(l2, l1);
        i += 1;
      }
    }
    AppMethodBeat.o(92639);
  }
  
  public final void b(j paramj)
  {
    AppMethodBeat.i(92637);
    a.checkState(this.cYV.remove(paramj));
    this.cGd.b(((d)paramj).cGp);
    AppMethodBeat.o(92637);
  }
  
  static final class a
    extends w
  {
    private final w cFL;
    private final long cYO;
    private final long cYP;
    
    public a(w paramw, long paramLong1, long paramLong2)
    {
      AppMethodBeat.i(92628);
      if (paramw.QW() == 1)
      {
        bool = true;
        a.checkArgument(bool);
        if (paramw.QX() != 1) {
          break label223;
        }
        bool = true;
        label36:
        a.checkArgument(bool);
        w.b localb = paramw.a(0, new w.b());
        if (localb.cHU) {
          break label229;
        }
        bool = true;
        label66:
        a.checkArgument(bool);
        long l = paramLong2;
        if (paramLong2 == -9223372036854775808L) {
          l = localb.cHg;
        }
        paramLong2 = l;
        if (localb.cHg != -9223372036854775807L)
        {
          paramLong2 = l;
          if (l > localb.cHg) {
            paramLong2 = localb.cHg;
          }
          if ((paramLong1 != 0L) && (!localb.cHT)) {
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
        if (paramw.a(0, new w.a(), false).cHK != 0L) {
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
        this.cFL = paramw;
        this.cYO = paramLong1;
        this.cYP = paramLong2;
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
    
    public final int QW()
    {
      return 1;
    }
    
    public final int QX()
    {
      return 1;
    }
    
    public final w.a a(int paramInt, w.a parama, boolean paramBoolean)
    {
      long l = -9223372036854775807L;
      AppMethodBeat.i(92631);
      parama = this.cFL.a(0, parama, paramBoolean);
      if (this.cYP != -9223372036854775807L) {
        l = this.cYP - this.cYO;
      }
      parama.cHg = l;
      AppMethodBeat.o(92631);
      return parama;
    }
    
    public final w.b a(int paramInt, w.b paramb, boolean paramBoolean, long paramLong)
    {
      AppMethodBeat.i(92630);
      paramb = this.cFL.a(0, paramb, paramBoolean, paramLong);
      if (this.cYP != -9223372036854775807L)
      {
        paramLong = this.cYP - this.cYO;
        paramb.cHg = paramLong;
        if (paramb.cHX != -9223372036854775807L)
        {
          paramb.cHX = Math.max(paramb.cHX, this.cYO);
          if (this.cYP != -9223372036854775807L) {
            break label176;
          }
        }
      }
      label176:
      for (paramLong = paramb.cHX;; paramLong = Math.min(paramb.cHX, this.cYP))
      {
        paramb.cHX = paramLong;
        paramb.cHX -= this.cYO;
        paramLong = com.google.android.exoplayer2.b.bM(this.cYO);
        if (paramb.cHR != -9223372036854775807L) {
          paramb.cHR += paramLong;
        }
        if (paramb.cHS != -9223372036854775807L) {
          paramb.cHS = (paramLong + paramb.cHS);
        }
        AppMethodBeat.o(92630);
        return paramb;
        paramLong = -9223372036854775807L;
        break;
      }
    }
    
    public final int bf(Object paramObject)
    {
      AppMethodBeat.i(92632);
      int i = this.cFL.bf(paramObject);
      AppMethodBeat.o(92632);
      return i;
    }
    
    public final int ca(int paramInt1, int paramInt2)
    {
      AppMethodBeat.i(92629);
      paramInt1 = this.cFL.ca(paramInt1, paramInt2);
      AppMethodBeat.o(92629);
      return paramInt1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes12.jar
 * Qualified Name:     com.google.android.exoplayer2.source.e
 * JD-Core Version:    0.7.0.1
 */