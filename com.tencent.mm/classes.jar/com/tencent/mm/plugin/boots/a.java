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
  public final List<com.tencent.mm.plugin.boots.a.a> aWg()
  {
    AppMethodBeat.i(90513);
    List localList = ((d)g.G(d.class)).getTinkerLogic().aWg();
    AppMethodBeat.o(90513);
    return localList;
  }
  
  public final void dH(int paramInt1, int paramInt2)
  {
    AppMethodBeat.i(90512);
    if (((d)g.G(d.class)).getTinkerLogic() != null) {
      ((d)g.G(d.class)).getTinkerLogic().dH(paramInt1, paramInt2);
    }
    AppMethodBeat.o(90512);
  }
  
  public final void rQ(int paramInt)
  {
    AppMethodBeat.i(90511);
    if (((d)g.G(d.class)).getTinkerLogic() != null) {
      ((d)g.G(d.class)).getTinkerLogic().rQ(paramInt);
    }
    AppMethodBeat.o(90511);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.plugin.boots.a
 * JD-Core Version:    0.7.0.1
 */