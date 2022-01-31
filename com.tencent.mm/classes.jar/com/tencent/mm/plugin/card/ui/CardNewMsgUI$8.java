package com.tencent.mm.plugin.card.ui;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.card.b.k;
import com.tencent.mm.plugin.card.d.d.a;
import com.tencent.mm.plugin.card.model.am;
import com.tencent.mm.plugin.card.model.g;
import java.util.ArrayList;
import java.util.List;

final class CardNewMsgUI$8
  extends d.a
{
  CardNewMsgUI$8(CardNewMsgUI paramCardNewMsgUI) {}
  
  public final void bei()
  {
    AppMethodBeat.i(88599);
    k localk = am.bch();
    if (localk.kmd.size() != 0)
    {
      ArrayList localArrayList = new ArrayList();
      localArrayList.addAll(localk.kmd);
      int i = 0;
      while (i < localArrayList.size())
      {
        g localg = (g)localArrayList.get(i);
        if (localg != null)
        {
          localk.kmd.remove(localg);
          k.d(localg);
        }
        i += 1;
      }
      localArrayList.clear();
    }
    CardNewMsgUI.g(this.kxl);
    CardNewMsgUI.a(this.kxl).a(null, null);
    AppMethodBeat.o(88599);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.plugin.card.ui.CardNewMsgUI.8
 * JD-Core Version:    0.7.0.1
 */