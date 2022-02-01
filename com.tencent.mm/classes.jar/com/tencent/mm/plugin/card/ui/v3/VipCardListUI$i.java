package com.tencent.mm.plugin.card.ui.v3;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.protocal.protobuf.to;
import com.tencent.mm.protocal.protobuf.tp;
import com.tencent.mm.ui.base.n.d;
import d.g.b.p;
import java.util.Iterator;
import java.util.LinkedList;

@d.l(gfx={1, 1, 16}, gfy={""}, gfz={"<anonymous>", "", "it", "Lcom/tencent/mm/ui/base/MMMenu;", "kotlin.jvm.PlatformType", "onCreateMMMenu"})
final class VipCardListUI$i
  implements n.d
{
  VipCardListUI$i(VipCardListUI paramVipCardListUI) {}
  
  public final void onCreateMMMenu(com.tencent.mm.ui.base.l paraml)
  {
    AppMethodBeat.i(215598);
    Object localObject = VipCardListUI.f(this.oNY);
    if (localObject == null) {
      p.gfZ();
    }
    localObject = ((tp)localObject).FRp.iterator();
    while (((Iterator)localObject).hasNext())
    {
      to localto = (to)((Iterator)localObject).next();
      paraml.add(0, localto.FRm, 1, (CharSequence)localto.FRo);
    }
    AppMethodBeat.o(215598);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.plugin.card.ui.v3.VipCardListUI.i
 * JD-Core Version:    0.7.0.1
 */