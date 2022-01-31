package com.tencent.mm.plugin.bottle.ui;

import com.tencent.mm.sdk.platformtools.y;
import com.tencent.mm.ui.base.MMSlideDelView.f;

final class BottleConversationUI$6
  implements MMSlideDelView.f
{
  BottleConversationUI$6(BottleConversationUI paramBottleConversationUI) {}
  
  public final void bg(Object paramObject)
  {
    if (paramObject == null)
    {
      y.e("MicroMsg.Bottle.BottleConversationUI", "onItemDel object null");
      return;
    }
    BottleConversationUI.a(this.hZr, paramObject.toString());
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.mm.plugin.bottle.ui.BottleConversationUI.6
 * JD-Core Version:    0.7.0.1
 */