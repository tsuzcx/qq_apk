package com.tencent.mm.plugin.boots;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.kernel.g;
import com.tencent.mm.plugin.boots.a.c;
import com.tencent.mm.plugin.boots.a.d;
import com.tencent.mm.plugin.boots.a.e;
import com.tencent.mm.plugin.boots.a.f;
import java.util.List;

public final class a
  implements c
{
  public final void a(String paramString1, String paramString2, String paramString3, f paramf)
  {
    AppMethodBeat.i(189683);
    ((d)g.ad(d.class)).getTinkerLogic().a(paramString1, paramString2, paramString3, paramf);
    AppMethodBeat.o(189683);
  }
  
  public final List<com.tencent.mm.plugin.boots.a.a> bIG()
  {
    AppMethodBeat.i(117358);
    List localList = ((d)g.ad(d.class)).getTinkerLogic().bIG();
    AppMethodBeat.o(117358);
    return localList;
  }
  
  public final void eJ(int paramInt1, int paramInt2)
  {
    AppMethodBeat.i(117357);
    if (((d)g.ad(d.class)).getTinkerLogic() != null) {
      ((d)g.ad(d.class)).getTinkerLogic().eJ(paramInt1, paramInt2);
    }
    AppMethodBeat.o(117357);
  }
  
  public final void yo(int paramInt)
  {
    AppMethodBeat.i(117356);
    if (((d)g.ad(d.class)).getTinkerLogic() != null) {
      ((d)g.ad(d.class)).getTinkerLogic().yo(paramInt);
    }
    AppMethodBeat.o(117356);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.plugin.boots.a
 * JD-Core Version:    0.7.0.1
 */