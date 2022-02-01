package com.tencent.mm.plugin.boots;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.kernel.h;
import com.tencent.mm.plugin.boots.a.c;
import com.tencent.mm.plugin.boots.a.d;
import com.tencent.mm.plugin.boots.a.e;
import com.tencent.mm.plugin.boots.a.f;
import java.util.List;

public final class a
  implements c
{
  public final void Gs(int paramInt)
  {
    AppMethodBeat.i(117356);
    if (((d)h.ag(d.class)).getTinkerLogic() != null) {
      ((d)h.ag(d.class)).getTinkerLogic().Gs(paramInt);
    }
    AppMethodBeat.o(117356);
  }
  
  public final void a(String paramString1, String paramString2, String paramString3, f paramf)
  {
    AppMethodBeat.i(195272);
    ((d)h.ag(d.class)).getTinkerLogic().a(paramString1, paramString2, paramString3, paramf);
    AppMethodBeat.o(195272);
  }
  
  public final List<com.tencent.mm.plugin.boots.a.a> cym()
  {
    AppMethodBeat.i(117358);
    List localList = ((d)h.ag(d.class)).getTinkerLogic().cym();
    AppMethodBeat.o(117358);
    return localList;
  }
  
  public final void fA(int paramInt1, int paramInt2)
  {
    AppMethodBeat.i(117357);
    if (((d)h.ag(d.class)).getTinkerLogic() != null) {
      ((d)h.ag(d.class)).getTinkerLogic().fA(paramInt1, paramInt2);
    }
    AppMethodBeat.o(117357);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.plugin.boots.a
 * JD-Core Version:    0.7.0.1
 */