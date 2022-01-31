package com.google.android.exoplayer2.source;

import com.google.android.exoplayer2.f;
import com.google.android.exoplayer2.h.b;
import com.google.android.exoplayer2.i.a;
import com.google.android.exoplayer2.w;
import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.ArrayList;

public final class d
  implements i, i.a
{
  private final long aOY;
  private final long aOZ;
  private final boolean aPe;
  private final ArrayList<c> aPf;
  private i.a aPg;
  private d.a aPh;
  private final i awb;
  
  public d(i parami, long paramLong1, long paramLong2)
  {
    this(parami, paramLong1, paramLong2, (byte)0);
  }
  
  private d(i parami, long paramLong1, long paramLong2, byte paramByte)
  {
    AppMethodBeat.i(95467);
    if (paramLong1 >= 0L) {}
    for (boolean bool = true;; bool = false)
    {
      a.checkArgument(bool);
      this.awb = ((i)a.checkNotNull(parami));
      this.aOY = paramLong1;
      this.aOZ = paramLong2;
      this.aPe = true;
      this.aPf = new ArrayList();
      AppMethodBeat.o(95467);
      return;
    }
  }
  
  public final h a(i.b paramb, b paramb1)
  {
    AppMethodBeat.i(95470);
    paramb = new c(this.awb.a(paramb, paramb1), this.aPe);
    this.aPf.add(paramb);
    paramb.i(d.a.a(this.aPh), d.a.b(this.aPh));
    AppMethodBeat.o(95470);
    return paramb;
  }
  
  public final void a(f paramf, i.a parama)
  {
    AppMethodBeat.i(95468);
    this.aPg = parama;
    this.awb.a(paramf, this);
    AppMethodBeat.o(95468);
  }
  
  public final void a(w paramw, Object paramObject)
  {
    AppMethodBeat.i(95473);
    this.aPh = new d.a(paramw, this.aOY, this.aOZ);
    this.aPg.a(this.aPh, paramObject);
    long l2 = d.a.a(this.aPh);
    if (d.a.b(this.aPh) == -9223372036854775807L) {}
    for (long l1 = -9223372036854775808L;; l1 = d.a.b(this.aPh))
    {
      int j = this.aPf.size();
      int i = 0;
      while (i < j)
      {
        ((c)this.aPf.get(i)).i(l2, l1);
        i += 1;
      }
    }
    AppMethodBeat.o(95473);
  }
  
  public final void b(h paramh)
  {
    AppMethodBeat.i(95471);
    a.checkState(this.aPf.remove(paramh));
    this.awb.b(((c)paramh).awn);
    AppMethodBeat.o(95471);
  }
  
  public final void oY()
  {
    AppMethodBeat.i(95469);
    this.awb.oY();
    AppMethodBeat.o(95469);
  }
  
  public final void oZ()
  {
    AppMethodBeat.i(95472);
    this.awb.oZ();
    AppMethodBeat.o(95472);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.google.android.exoplayer2.source.d
 * JD-Core Version:    0.7.0.1
 */