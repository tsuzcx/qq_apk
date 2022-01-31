package com.google.android.exoplayer2.source;

import com.google.android.exoplayer2.b;
import com.google.android.exoplayer2.i.a;
import com.google.android.exoplayer2.w;
import com.google.android.exoplayer2.w.a;
import com.google.android.exoplayer2.w.b;
import com.tencent.matrix.trace.core.AppMethodBeat;

final class d$a
  extends w
{
  private final long aOY;
  private final long aOZ;
  private final w avJ;
  
  public d$a(w paramw, long paramLong1, long paramLong2)
  {
    AppMethodBeat.i(95462);
    if (paramw.ne() == 1)
    {
      bool = true;
      a.checkArgument(bool);
      if (paramw.nf() != 1) {
        break label223;
      }
      bool = true;
      label36:
      a.checkArgument(bool);
      w.b localb = paramw.a(0, new w.b());
      if (localb.axV) {
        break label229;
      }
      bool = true;
      label66:
      a.checkArgument(bool);
      long l = paramLong2;
      if (paramLong2 == -9223372036854775808L) {
        l = localb.axh;
      }
      paramLong2 = l;
      if (localb.axh != -9223372036854775807L)
      {
        paramLong2 = l;
        if (l > localb.axh) {
          paramLong2 = localb.axh;
        }
        if ((paramLong1 != 0L) && (!localb.axU)) {
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
      if (paramw.a(0, new w.a(), false).axL != 0L) {
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
      this.avJ = paramw;
      this.aOY = paramLong1;
      this.aOZ = paramLong2;
      AppMethodBeat.o(95462);
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
  
  public final int O(Object paramObject)
  {
    AppMethodBeat.i(95466);
    int i = this.avJ.O(paramObject);
    AppMethodBeat.o(95466);
    return i;
  }
  
  public final w.a a(int paramInt, w.a parama, boolean paramBoolean)
  {
    long l = -9223372036854775807L;
    AppMethodBeat.i(95465);
    parama = this.avJ.a(0, parama, paramBoolean);
    if (this.aOZ != -9223372036854775807L) {
      l = this.aOZ - this.aOY;
    }
    parama.axh = l;
    AppMethodBeat.o(95465);
    return parama;
  }
  
  public final w.b a(int paramInt, w.b paramb, boolean paramBoolean, long paramLong)
  {
    AppMethodBeat.i(95464);
    paramb = this.avJ.a(0, paramb, paramBoolean, paramLong);
    if (this.aOZ != -9223372036854775807L)
    {
      paramLong = this.aOZ - this.aOY;
      paramb.axh = paramLong;
      if (paramb.axY != -9223372036854775807L)
      {
        paramb.axY = Math.max(paramb.axY, this.aOY);
        if (this.aOZ != -9223372036854775807L) {
          break label176;
        }
      }
    }
    label176:
    for (paramLong = paramb.axY;; paramLong = Math.min(paramb.axY, this.aOZ))
    {
      paramb.axY = paramLong;
      paramb.axY -= this.aOY;
      paramLong = b.o(this.aOY);
      if (paramb.axS != -9223372036854775807L) {
        paramb.axS += paramLong;
      }
      if (paramb.axT != -9223372036854775807L) {
        paramb.axT = (paramLong + paramb.axT);
      }
      AppMethodBeat.o(95464);
      return paramb;
      paramLong = -9223372036854775807L;
      break;
    }
  }
  
  public final int aS(int paramInt1, int paramInt2)
  {
    AppMethodBeat.i(95463);
    paramInt1 = this.avJ.aS(paramInt1, paramInt2);
    AppMethodBeat.o(95463);
    return paramInt1;
  }
  
  public final int ne()
  {
    return 1;
  }
  
  public final int nf()
  {
    return 1;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.google.android.exoplayer2.source.d.a
 * JD-Core Version:    0.7.0.1
 */