package com.tencent.mm.plugin.fts;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.fts.a.a.j;
import com.tencent.mm.plugin.fts.a.l;
import java.lang.ref.WeakReference;

final class b$1
  implements Runnable
{
  b$1(b paramb, j paramj) {}
  
  public final void run()
  {
    AppMethodBeat.i(136517);
    l locall = (l)b.a(this.mPl).get();
    if (locall != null) {
      locall.b(this.mPk);
    }
    AppMethodBeat.o(136517);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.plugin.fts.b.1
 * JD-Core Version:    0.7.0.1
 */