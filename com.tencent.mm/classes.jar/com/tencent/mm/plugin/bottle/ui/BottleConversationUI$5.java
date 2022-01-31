package com.tencent.mm.plugin.bottle.ui;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.sdk.platformtools.ab;
import com.tencent.mm.ui.base.MMSlideDelView.f;

final class BottleConversationUI$5
  implements MMSlideDelView.f
{
  BottleConversationUI$5(BottleConversationUI paramBottleConversationUI) {}
  
  public final void bC(Object paramObject)
  {
    AppMethodBeat.i(18560);
    if (paramObject == null)
    {
      ab.e("MicroMsg.Bottle.BottleConversationUI", "onItemDel object null");
      AppMethodBeat.o(18560);
      return;
    }
    BottleConversationUI.a(this.jSo, paramObject.toString());
    AppMethodBeat.o(18560);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes8.jar
 * Qualified Name:     com.tencent.mm.plugin.bottle.ui.BottleConversationUI.5
 * JD-Core Version:    0.7.0.1
 */