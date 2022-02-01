package com.tencent.mm.plugin.boots;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.kernel.g;
import com.tencent.mm.plugin.boots.a.c;
import com.tencent.mm.plugin.boots.a.d;
import com.tencent.mm.plugin.boots.a.e;
import java.util.List;

public final class a
  implements c
{
  public final List<com.tencent.mm.plugin.boots.a.a> bBI()
  {
    AppMethodBeat.i(117358);
    List localList = ((d)g.ad(d.class)).getTinkerLogic().bBI();
    AppMethodBeat.o(117358);
    return localList;
  }
  
  public final void eG(int paramInt1, int paramInt2)
  {
    AppMethodBeat.i(117357);
    if (((d)g.ad(d.class)).getTinkerLogic() != null) {
      ((d)g.ad(d.class)).getTinkerLogic().eG(paramInt1, paramInt2);
    }
    AppMethodBeat.o(117357);
  }
  
  public final void xw(int paramInt)
  {
    AppMethodBeat.i(117356);
    if (((d)g.ad(d.class)).getTinkerLogic() != null) {
      ((d)g.ad(d.class)).getTinkerLogic().xw(paramInt);
    }
    AppMethodBeat.o(117356);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.plugin.boots.a
 * JD-Core Version:    0.7.0.1
 */