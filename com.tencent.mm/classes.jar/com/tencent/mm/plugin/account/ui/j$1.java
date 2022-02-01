package com.tencent.mm.plugin.account.ui;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ui.base.o;
import com.tencent.mm.ui.base.p;
import com.tencent.mm.ui.base.q.f;
import java.util.Iterator;
import java.util.List;

final class j$1
  implements q.f
{
  j$1(j paramj, List paramList) {}
  
  public final void onCreateMMMenu(o paramo)
  {
    AppMethodBeat.i(128274);
    if (paramo.size() == 0)
    {
      Iterator localIterator = this.nen.iterator();
      while (localIterator.hasNext()) {
        paramo.h((p)localIterator.next());
      }
    }
    AppMethodBeat.o(128274);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.plugin.account.ui.j.1
 * JD-Core Version:    0.7.0.1
 */