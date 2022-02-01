package com.tencent.mm.plugin.backup.b;

import com.tencent.matrix.trace.core.AppMethodBeat;

public final class f$b
  implements Cloneable, Comparable<b>
{
  public String nsX;
  public long nsY = 0L;
  public long nsZ = 0L;
  public long nta = -1L;
  public long ntb = -1L;
  
  public final b bHh()
  {
    AppMethodBeat.i(21166);
    b localb = new b();
    localb.nsX = this.nsX;
    localb.nsY = this.nsY;
    localb.nsZ = this.nsZ;
    localb.nta = this.nta;
    localb.ntb = this.ntb;
    AppMethodBeat.o(21166);
    return localb;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.plugin.backup.b.f.b
 * JD-Core Version:    0.7.0.1
 */