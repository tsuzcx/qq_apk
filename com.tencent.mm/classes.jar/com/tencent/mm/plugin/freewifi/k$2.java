package com.tencent.mm.plugin.freewifi;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.freewifi.f.b;
import com.tencent.mm.plugin.freewifi.g.f;
import com.tencent.mm.plugin.freewifi.model.j;

final class k$2
  implements Runnable
{
  k$2(k paramk, String paramString1, int paramInt, String paramString2, long paramLong) {}
  
  public final void run()
  {
    AppMethodBeat.i(24683);
    j.dNp().b(this.val$id, this.wNh, this.wNi, this.wNj);
    if (m.dML()) {
      b.pl(1);
    }
    AppMethodBeat.o(24683);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.plugin.freewifi.k.2
 * JD-Core Version:    0.7.0.1
 */