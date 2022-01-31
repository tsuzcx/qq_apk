package com.tencent.mm.plugin.card.ui;

import android.content.Intent;
import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.mm.plugin.card.model.g;
import com.tencent.mm.plugin.card.model.g.a;
import com.tencent.mm.plugin.card.sharecard.ui.CardConsumeSuccessUI;
import com.tencent.mm.plugin.report.service.h;
import com.tencent.mm.ui.MMActivity;
import com.tencent.mm.ui.s;

final class CardNewMsgUI$a$1
  implements View.OnClickListener
{
  CardNewMsgUI$a$1(CardNewMsgUI.a parama, g.a parama1, g paramg) {}
  
  public final void onClick(View paramView)
  {
    paramView = new Intent();
    if (this.iwj.imX == 0)
    {
      paramView.setClass(this.iwl.iwh.mController.uMN, CardDetailUI.class);
      paramView.putExtra("key_card_id", this.iwj.cardId);
      paramView.putExtra("key_card_ext", this.iwj.imW);
      paramView.putExtra("key_from_scene", 17);
      this.iwl.iwh.startActivity(paramView);
    }
    for (;;)
    {
      h.nFQ.f(11941, new Object[] { Integer.valueOf(8), this.iwk.field_card_id, this.iwk.field_card_tp_id, this.iwk.field_msg_id, this.iwj.cardId });
      return;
      if (this.iwj.imX == 1)
      {
        paramView.setClass(this.iwl.iwh.mController.uMN, CardConsumeSuccessUI.class);
        paramView.putExtra("key_card_id", this.iwk.field_card_id);
        paramView.putExtra("key_from_scene", 2);
        this.iwl.iwh.startActivity(paramView);
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes9.jar
 * Qualified Name:     com.tencent.mm.plugin.card.ui.CardNewMsgUI.a.1
 * JD-Core Version:    0.7.0.1
 */