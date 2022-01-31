package com.tencent.mm.plugin.card.ui;

import android.content.Intent;
import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.card.model.g;
import com.tencent.mm.plugin.card.model.g.a;
import com.tencent.mm.plugin.card.sharecard.ui.CardConsumeSuccessUI;
import com.tencent.mm.plugin.report.service.h;

final class CardNewMsgUI$a$1
  implements View.OnClickListener
{
  CardNewMsgUI$a$1(CardNewMsgUI.a parama, g.a parama1, g paramg) {}
  
  public final void onClick(View paramView)
  {
    AppMethodBeat.i(88601);
    paramView = new Intent();
    if (this.kxn.knS == 0)
    {
      paramView.setClass(this.kxp.kxl.getContext(), CardDetailUI.class);
      paramView.putExtra("key_card_id", this.kxn.cardId);
      paramView.putExtra("key_card_ext", this.kxn.knR);
      paramView.putExtra("key_from_scene", 17);
      this.kxp.kxl.startActivity(paramView);
    }
    for (;;)
    {
      h.qsU.e(11941, new Object[] { Integer.valueOf(8), this.kxo.field_card_id, this.kxo.field_card_tp_id, this.kxo.field_msg_id, this.kxn.cardId });
      AppMethodBeat.o(88601);
      return;
      if (this.kxn.knS == 1)
      {
        paramView.setClass(this.kxp.kxl.getContext(), CardConsumeSuccessUI.class);
        paramView.putExtra("key_card_id", this.kxo.field_card_id);
        paramView.putExtra("key_from_scene", 2);
        this.kxp.kxl.startActivity(paramView);
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes8.jar
 * Qualified Name:     com.tencent.mm.plugin.card.ui.CardNewMsgUI.a.1
 * JD-Core Version:    0.7.0.1
 */