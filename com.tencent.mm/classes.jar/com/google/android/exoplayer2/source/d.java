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
  private final i aSo;
  private final long bld;
  private final long ble;
  private final boolean blj;
  private final ArrayList<c> blk;
  private i.a bll;
  private a blm;
  
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
      this.aSo = ((i)a.checkNotNull(parami));
      this.bld = paramLong1;
      this.ble = paramLong2;
      this.blj = true;
      this.blk = new ArrayList();
      AppMethodBeat.o(92633);
      return;
    }
  }
  
  public final h a(i.b paramb, com.google.android.exoplayer2.h.b paramb1)
  {
    AppMethodBeat.i(92636);
    paramb = new c(this.aSo.a(paramb, paramb1), this.blj);
    this.blk.add(paramb);
    paramb.h(a.a(this.blm), a.b(this.blm));
    AppMethodBeat.o(92636);
    return paramb;
  }
  
  public final void a(f paramf, i.a parama)
  {
    AppMethodBeat.i(92634);
    this.bll = parama;
    this.aSo.a(paramf, this);
    AppMethodBeat.o(92634);
  }
  
  public final void a(w paramw, Object paramObject)
  {
    AppMethodBeat.i(92639);
    this.blm = new a(paramw, this.bld, this.ble);
    this.bll.a(this.blm, paramObject);
    long l2 = a.a(this.blm);
    if (a.b(this.blm) == -9223372036854775807L) {}
    for (long l1 = -9223372036854775808L;; l1 = a.b(this.blm))
    {
      int j = this.blk.size();
      int i = 0;
      while (i < j)
      {
        ((c)this.blk.get(i)).h(l2, l1);
        i += 1;
      }
    }
    AppMethodBeat.o(92639);
  }
  
  public final void b(h paramh)
  {
    AppMethodBeat.i(92637);
    a.checkState(this.blk.remove(paramh));
    this.aSo.b(((c)paramh).aSA);
    AppMethodBeat.o(92637);
  }
  
  public final void tO()
  {
    AppMethodBeat.i(92635);
    this.aSo.tO();
    AppMethodBeat.o(92635);
  }
  
  public final void tP()
  {
    AppMethodBeat.i(92638);
    this.aSo.tP();
    AppMethodBeat.o(92638);
  }
  
  static final class a
    extends w
  {
    private final w aRW;
    private final long bld;
    private final long ble;
    
    public a(w paramw, long paramLong1, long paramLong2)
    {
      AppMethodBeat.i(92628);
      if (paramw.rZ() == 1)
      {
        bool = true;
        a.checkArgument(bool);
        if (paramw.sa() != 1) {
          break label223;
        }
        bool = true;
        label36:
        a.checkArgument(bool);
        w.b localb = paramw.a(0, new w.b());
        if (localb.aUg) {
          break label229;
        }
        bool = true;
        label66:
        a.checkArgument(bool);
        long l = paramLong2;
        if (paramLong2 == -9223372036854775808L) {
          l = localb.aTs;
        }
        paramLong2 = l;
        if (localb.aTs != -9223372036854775807L)
        {
          paramLong2 = l;
          if (l > localb.aTs) {
            paramLong2 = localb.aTs;
          }
          if ((paramLong1 != 0L) && (!localb.aUf)) {
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
        if (paramw.a(0, new w.a(), false).aTW != 0L) {
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
        this.aRW = paramw;
        this.bld = paramLong1;
        this.ble = paramLong2;
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
      parama = this.aRW.a(0, parama, paramBoolean);
      if (this.ble != -9223372036854775807L) {
        l = this.ble - this.bld;
      }
      parama.aTs = l;
      AppMethodBeat.o(92631);
      return parama;
    }
    
    public final w.b a(int paramInt, w.b paramb, boolean paramBoolean, long paramLong)
    {
      AppMethodBeat.i(92630);
      paramb = this.aRW.a(0, paramb, paramBoolean, paramLong);
      if (this.ble != -9223372036854775807L)
      {
        paramLong = this.ble - this.bld;
        paramb.aTs = paramLong;
        if (paramb.aUj != -9223372036854775807L)
        {
          paramb.aUj = Math.max(paramb.aUj, this.bld);
          if (this.ble != -9223372036854775807L) {
            break label176;
          }
        }
      }
      label176:
      for (paramLong = paramb.aUj;; paramLong = Math.min(paramb.aUj, this.ble))
      {
        paramb.aUj = paramLong;
        paramb.aUj -= this.bld;
        paramLong = com.google.android.exoplayer2.b.v(this.bld);
        if (paramb.aUd != -9223372036854775807L) {
          paramb.aUd += paramLong;
        }
        if (paramb.aUe != -9223372036854775807L) {
          paramb.aUe = (paramLong + paramb.aUe);
        }
        AppMethodBeat.o(92630);
        return paramb;
        paramLong = -9223372036854775807L;
        break;
      }
    }
    
    public final int ac(Object paramObject)
    {
      AppMethodBeat.i(92632);
      int i = this.aRW.ac(paramObject);
      AppMethodBeat.o(92632);
      return i;
    }
    
    public final int bd(int paramInt1, int paramInt2)
    {
      AppMethodBeat.i(92629);
      paramInt1 = this.aRW.bd(paramInt1, paramInt2);
      AppMethodBeat.o(92629);
      return paramInt1;
    }
    
    public final int rZ()
    {
      return 1;
    }
    
    public final int sa()
    {
      return 1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.google.android.exoplayer2.source.d
 * JD-Core Version:    0.7.0.1
 */