package com.tencent.mm.plugin.card.ui;

import android.text.TextUtils;
import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.mm.plugin.card.d.b;
import com.tencent.mm.plugin.card.model.g.b;
import com.tencent.mm.sdk.platformtools.y;

final class CardNewMsgUI$a$2
  implements View.OnClickListener
{
  CardNewMsgUI$a$2(CardNewMsgUI.a parama, g.b paramb) {}
  
  public final void onClick(View paramView)
  {
    if (!TextUtils.isEmpty(this.iwm.ina))
    {
      b.a(this.iwl.iwh, this.iwm.ina, 2);
      return;
    }
    y.e("MicroMsg.CardNewMsgUI", "card msg button url is empty");
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.mm.plugin.card.ui.CardNewMsgUI.a.2
 * JD-Core Version:    0.7.0.1
 */