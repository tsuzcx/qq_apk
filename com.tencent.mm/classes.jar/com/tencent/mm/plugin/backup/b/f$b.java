package com.tencent.mm.plugin.backup.b;

import com.tencent.matrix.trace.core.AppMethodBeat;

public final class f$b
  implements Cloneable, Comparable<b>
{
  public long mqA = -1L;
  public long mqB = -1L;
  public String mqx;
  public long mqy = 0L;
  public long mqz = 0L;
  
  public final b bwd()
  {
    AppMethodBeat.i(21166);
    b localb = new b();
    localb.mqx = this.mqx;
    localb.mqy = this.mqy;
    localb.mqz = this.mqz;
    localb.mqA = this.mqA;
    localb.mqB = this.mqB;
    AppMethodBeat.o(21166);
    return localb;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.plugin.backup.b.f.b
 * JD-Core Version:    0.7.0.1
 */