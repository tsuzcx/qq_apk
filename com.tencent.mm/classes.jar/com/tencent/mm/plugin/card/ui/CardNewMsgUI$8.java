package com.tencent.mm.plugin.card.ui;

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
  
  public final void aBY()
  {
    k localk = am.aAw();
    if (localk.ilf.size() != 0)
    {
      ArrayList localArrayList = new ArrayList();
      localArrayList.addAll(localk.ilf);
      int i = 0;
      while (i < localArrayList.size())
      {
        g localg = (g)localArrayList.get(i);
        if (localg != null)
        {
          localk.ilf.remove(localg);
          k.d(localg);
        }
        i += 1;
      }
      localArrayList.clear();
    }
    CardNewMsgUI.g(this.iwh);
    CardNewMsgUI.a(this.iwh).a(null, null);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.mm.plugin.card.ui.CardNewMsgUI.8
 * JD-Core Version:    0.7.0.1
 */