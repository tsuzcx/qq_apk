package com.tencent.mm.plugin.backup.d;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.backup.b.b.b;
import com.tencent.mm.plugin.backup.g.b;
import com.tencent.mm.sdk.platformtools.al;

final class d$2
  implements b.b
{
  d$2(d paramd) {}
  
  public final void aSH()
  {
    AppMethodBeat.i(153492);
    b.ru(21);
    AppMethodBeat.o(153492);
  }
  
  public final void aSI()
  {
    AppMethodBeat.i(153493);
    this.jCb.cancel(false);
    AppMethodBeat.o(153493);
  }
  
  public final void rf(int paramInt)
  {
    AppMethodBeat.i(153491);
    if (d.c(this.jCb) != null) {
      al.d(new d.2.1(this, paramInt));
    }
    AppMethodBeat.o(153491);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.plugin.backup.d.d.2
 * JD-Core Version:    0.7.0.1
 */