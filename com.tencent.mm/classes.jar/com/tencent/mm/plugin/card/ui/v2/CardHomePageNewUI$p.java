package com.tencent.mm.plugin.card.ui.v2;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.protocal.protobuf.pc;
import com.tencent.mm.ui.base.n.c;
import java.util.Iterator;

@a.l(eaO={1, 1, 13}, eaP={""}, eaQ={"<anonymous>", "", "it", "Lcom/tencent/mm/ui/base/MMMenu;", "kotlin.jvm.PlatformType", "onCreateMMMenu", "com/tencent/mm/plugin/card/ui/v2/CardHomePageNewUI$showSortSheet$1$1"})
final class CardHomePageNewUI$p
  implements n.c
{
  CardHomePageNewUI$p(CardHomePageNewUI paramCardHomePageNewUI) {}
  
  public final void onCreateMMMenu(com.tencent.mm.ui.base.l paraml)
  {
    AppMethodBeat.i(152209);
    Iterator localIterator = ((Iterable)CardHomePageNewUI.x(this.kzs)).iterator();
    int i = 0;
    while (localIterator.hasNext())
    {
      paraml.add(0, i, 1, (CharSequence)((pc)localIterator.next()).wFO);
      i += 1;
    }
    AppMethodBeat.o(152209);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.plugin.card.ui.v2.CardHomePageNewUI.p
 * JD-Core Version:    0.7.0.1
 */