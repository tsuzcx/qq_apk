package com.google.android.exoplayer2.source.dash;

import com.google.android.exoplayer2.c.a;
import com.google.android.exoplayer2.source.dash.manifest.f;
import com.tencent.matrix.trace.core.AppMethodBeat;

public final class e
  implements d
{
  private final a bnB;
  
  public e(a parama)
  {
    this.bnB = parama;
  }
  
  public final int ah(long paramLong)
  {
    return this.bnB.length;
  }
  
  public final long eH(int paramInt)
  {
    return this.bnB.aWE[paramInt];
  }
  
  public final f eI(int paramInt)
  {
    AppMethodBeat.i(10499);
    f localf = new f(null, this.bnB.offsets[paramInt], this.bnB.aWC[paramInt]);
    AppMethodBeat.o(10499);
    return localf;
  }
  
  public final int j(long paramLong1, long paramLong2)
  {
    AppMethodBeat.i(10500);
    int i = this.bnB.J(paramLong1);
    AppMethodBeat.o(10500);
    return i;
  }
  
  public final long k(int paramInt, long paramLong)
  {
    return this.bnB.aWD[paramInt];
  }
  
  public final int ui()
  {
    return 0;
  }
  
  public final boolean uj()
  {
    return true;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.google.android.exoplayer2.source.dash.e
 * JD-Core Version:    0.7.0.1
 */