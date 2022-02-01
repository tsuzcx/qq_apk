package com.tencent.mm.plugin.ai.b.a.b;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.g.a.uc;
import com.tencent.mm.g.a.uc.a;
import com.tencent.mm.sdk.event.IListener;

final class a$1
  extends IListener<uc>
{
  a$1(a parama)
  {
    AppMethodBeat.i(238888);
    this.__eventId = uc.class.getName().hashCode();
    AppMethodBeat.o(238888);
  }
  
  private boolean a(uc paramuc)
  {
    AppMethodBeat.i(238889);
    if (paramuc == null)
    {
      AppMethodBeat.o(238889);
      return false;
    }
    if (paramuc.eav.type == 0) {
      a.a(this.kwE, paramuc.eav.sessionId, paramuc.eav.eaw);
    }
    AppMethodBeat.o(238889);
    return false;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.plugin.ai.b.a.b.a.1
 * JD-Core Version:    0.7.0.1
 */