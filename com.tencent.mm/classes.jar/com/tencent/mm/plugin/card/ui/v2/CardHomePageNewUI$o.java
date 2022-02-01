package com.tencent.mm.plugin.card.ui.v2;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.protocal.protobuf.to;
import com.tencent.mm.ui.base.n.d;
import java.util.Iterator;

@d.l(gfx={1, 1, 16}, gfy={""}, gfz={"<anonymous>", "", "it", "Lcom/tencent/mm/ui/base/MMMenu;", "kotlin.jvm.PlatformType", "onCreateMMMenu", "com/tencent/mm/plugin/card/ui/v2/CardHomePageNewUI$showSortSheet$1$1"})
final class CardHomePageNewUI$o
  implements n.d
{
  CardHomePageNewUI$o(CardHomePageNewUI paramCardHomePageNewUI) {}
  
  public final void onCreateMMMenu(com.tencent.mm.ui.base.l paraml)
  {
    AppMethodBeat.i(112457);
    Iterator localIterator = ((Iterable)CardHomePageNewUI.y(this.oLf)).iterator();
    int i = 0;
    while (localIterator.hasNext())
    {
      paraml.add(0, i, 1, (CharSequence)((to)localIterator.next()).FRo);
      i += 1;
    }
    AppMethodBeat.o(112457);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.plugin.card.ui.v2.CardHomePageNewUI.o
 * JD-Core Version:    0.7.0.1
 */