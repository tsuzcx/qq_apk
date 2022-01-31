package com.tencent.mm.plugin.card.ui;

import android.text.TextUtils;
import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.card.d.b;
import com.tencent.mm.plugin.card.model.g.b;
import com.tencent.mm.sdk.platformtools.ab;

final class CardNewMsgUI$a$2
  implements View.OnClickListener
{
  CardNewMsgUI$a$2(CardNewMsgUI.a parama, g.b paramb) {}
  
  public final void onClick(View paramView)
  {
    AppMethodBeat.i(88602);
    if (!TextUtils.isEmpty(this.kxq.knV))
    {
      b.a(this.kxp.kxl, this.kxq.knV, 2);
      AppMethodBeat.o(88602);
      return;
    }
    ab.e("MicroMsg.CardNewMsgUI", "card msg button url is empty");
    AppMethodBeat.o(88602);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.plugin.card.ui.CardNewMsgUI.a.2
 * JD-Core Version:    0.7.0.1
 */