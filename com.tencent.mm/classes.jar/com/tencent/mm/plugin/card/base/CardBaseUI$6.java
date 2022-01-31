package com.tencent.mm.plugin.card.base;

import android.content.res.Resources;
import com.tencent.mm.plugin.card.a.g;
import com.tencent.mm.pluginsdk.ui.applet.q.a;
import com.tencent.mm.ui.base.h;

final class CardBaseUI$6
  implements q.a
{
  CardBaseUI$6(CardBaseUI paramCardBaseUI, String paramString, boolean paramBoolean) {}
  
  public final void a(boolean paramBoolean, String paramString, int paramInt)
  {
    if (paramBoolean)
    {
      CardBaseUI.c(this.ijO, this.dol);
      h.bC(this.ijO, this.ijO.getResources().getString(a.g.card_has_gift_tips));
      if (this.ijR) {
        this.ijO.finish();
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes8.jar
 * Qualified Name:     com.tencent.mm.plugin.card.base.CardBaseUI.6
 * JD-Core Version:    0.7.0.1
 */