package com.google.android.exoplayer2.source;

import com.google.android.exoplayer2.f;
import com.google.android.exoplayer2.i.a;
import com.google.android.exoplayer2.w;
import com.google.android.exoplayer2.w.a;
import com.google.android.exoplayer2.w.b;
import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.ArrayList;

public final class d
  implements j, j.a
{
  private final j aRt;
  private final boolean bkE;
  private final ArrayList<c> bkF;
  private j.a bkG;
  private a bkH;
  private final long bky;
  private final long bkz;
  
  public d(j paramj, long paramLong1, long paramLong2)
  {
    this(paramj, paramLong1, paramLong2, (byte)0);
  }
  
  private d(j paramj, long paramLong1, long paramLong2, byte paramByte)
  {
    AppMethodBeat.i(92633);
    if (paramLong1 >= 0L) {}
    for (boolean bool = true;; bool = false)
    {
      a.checkArgument(bool);
      this.aRt = ((j)a.checkNotNull(paramj));
      this.bky = paramLong1;
      this.bkz = paramLong2;
      this.bkE = true;
      this.bkF = new ArrayList();
      AppMethodBeat.o(92633);
      return;
    }
  }
  
  public final i a(j.b paramb, com.google.android.exoplayer2.h.b paramb1)
  {
    AppMethodBeat.i(92636);
    paramb = new c(this.aRt.a(paramb, paramb1), this.bkE);
    this.bkF.add(paramb);
    paramb.h(a.a(this.bkH), a.b(this.bkH));
    AppMethodBeat.o(92636);
    return paramb;
  }
  
  public final void a(f paramf, j.a parama)
  {
    AppMethodBeat.i(92634);
    this.bkG = parama;
    this.aRt.a(paramf, this);
    AppMethodBeat.o(92634);
  }
  
  public final void a(w paramw, Object paramObject)
  {
    AppMethodBeat.i(92639);
    this.bkH = new a(paramw, this.bky, this.bkz);
    this.bkG.a(this.bkH, paramObject);
    long l2 = a.a(this.bkH);
    if (a.b(this.bkH) == -9223372036854775807L) {}
    for (long l1 = -9223372036854775808L;; l1 = a.b(this.bkH))
    {
      int j = this.bkF.size();
      int i = 0;
      while (i < j)
      {
        ((c)this.bkF.get(i)).h(l2, l1);
        i += 1;
      }
    }
    AppMethodBeat.o(92639);
  }
  
  public final void b(i parami)
  {
    AppMethodBeat.i(92637);
    a.checkState(this.bkF.remove(parami));
    this.aRt.b(((c)parami).aRF);
    AppMethodBeat.o(92637);
  }
  
  public final void tG()
  {
    AppMethodBeat.i(92635);
    this.aRt.tG();
    AppMethodBeat.o(92635);
  }
  
  public final void tH()
  {
    AppMethodBeat.i(92638);
    this.aRt.tH();
    AppMethodBeat.o(92638);
  }
  
  static final class a
    extends w
  {
    private final w aRb;
    private final long bky;
    private final long bkz;
    
    public a(w paramw, long paramLong1, long paramLong2)
    {
      AppMethodBeat.i(92628);
      if (paramw.rP() == 1)
      {
        bool = true;
        a.checkArgument(bool);
        if (paramw.rQ() != 1) {
          break label223;
        }
        bool = true;
        label36:
        a.checkArgument(bool);
        w.b localb = paramw.a(0, new w.b());
        if (localb.aTo) {
          break label229;
        }
        bool = true;
        label66:
        a.checkArgument(bool);
        long l = paramLong2;
        if (paramLong2 == -9223372036854775808L) {
          l = localb.aSz;
        }
        paramLong2 = l;
        if (localb.aSz != -9223372036854775807L)
        {
          paramLong2 = l;
          if (l > localb.aSz) {
            paramLong2 = localb.aSz;
          }
          if ((paramLong1 != 0L) && (!localb.aTn)) {
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
        if (paramw.a(0, new w.a(), false).aTe != 0L) {
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
        this.aRb = paramw;
        this.bky = paramLong1;
        this.bkz = paramLong2;
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
      parama = this.aRb.a(0, parama, paramBoolean);
      if (this.bkz != -9223372036854775807L) {
        l = this.bkz - this.bky;
      }
      parama.aSz = l;
      AppMethodBeat.o(92631);
      return parama;
    }
    
    public final w.b a(int paramInt, w.b paramb, boolean paramBoolean, long paramLong)
    {
      AppMethodBeat.i(92630);
      paramb = this.aRb.a(0, paramb, paramBoolean, paramLong);
      if (this.bkz != -9223372036854775807L)
      {
        paramLong = this.bkz - this.bky;
        paramb.aSz = paramLong;
        if (paramb.aTr != -9223372036854775807L)
        {
          paramb.aTr = Math.max(paramb.aTr, this.bky);
          if (this.bkz != -9223372036854775807L) {
            break label176;
          }
        }
      }
      label176:
      for (paramLong = paramb.aTr;; paramLong = Math.min(paramb.aTr, this.bkz))
      {
        paramb.aTr = paramLong;
        paramb.aTr -= this.bky;
        paramLong = com.google.android.exoplayer2.b.t(this.bky);
        if (paramb.aTl != -9223372036854775807L) {
          paramb.aTl += paramLong;
        }
        if (paramb.aTm != -9223372036854775807L) {
          paramb.aTm = (paramLong + paramb.aTm);
        }
        AppMethodBeat.o(92630);
        return paramb;
        paramLong = -9223372036854775807L;
        break;
      }
    }
    
    public final int aa(Object paramObject)
    {
      AppMethodBeat.i(92632);
      int i = this.aRb.aa(paramObject);
      AppMethodBeat.o(92632);
      return i;
    }
    
    public final int bd(int paramInt1, int paramInt2)
    {
      AppMethodBeat.i(92629);
      paramInt1 = this.aRb.bd(paramInt1, paramInt2);
      AppMethodBeat.o(92629);
      return paramInt1;
    }
    
    public final int rP()
    {
      return 1;
    }
    
    public final int rQ()
    {
      return 1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.google.android.exoplayer2.source.d
 * JD-Core Version:    0.7.0.1
 */