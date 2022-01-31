package com.tencent.mm.plugin.card.ui;

import android.content.Intent;
import android.text.TextUtils;
import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.card.d.b;
import com.tencent.mm.plugin.card.model.g;
import com.tencent.mm.plugin.report.service.h;
import com.tencent.mm.protocal.protobuf.oh;
import com.tencent.mm.protocal.protobuf.ov;
import com.tencent.mm.sdk.platformtools.ab;

final class CardNewMsgUI$9
  implements View.OnClickListener
{
  CardNewMsgUI$9(CardNewMsgUI paramCardNewMsgUI) {}
  
  public final void onClick(View paramView)
  {
    AppMethodBeat.i(88600);
    if (paramView.getId() == 2131822296)
    {
      paramView = (g)paramView.getTag();
      if ((paramView == null) || (paramView.bbU() == null))
      {
        AppMethodBeat.o(88600);
        return;
      }
      h.qsU.e(11941, new Object[] { Integer.valueOf(2), paramView.field_card_id, paramView.field_card_tp_id, paramView.field_msg_id, "" });
      if (paramView.bbU().knS == 0)
      {
        ab.i("MicroMsg.CardNewMsgUI", "card msg action_type is MM_CARD_ITEM_XML_MSG_BUTTON_TYPE_URL");
        if (!TextUtils.isEmpty(paramView.bbU().url))
        {
          b.a(this.kxl, paramView.bbU().url, 2);
          AppMethodBeat.o(88600);
          return;
        }
        ab.e("MicroMsg.CardNewMsgUI", "card msg button url is empty");
        AppMethodBeat.o(88600);
        return;
      }
      if (paramView.bbU().knS == 1)
      {
        ab.i("MicroMsg.CardNewMsgUI", "card msg action_type is MM_CARD_ITEM_XML_MSG_BUTTON_TYPE_SHOP");
        Intent localIntent = new Intent();
        localIntent.putExtra("KEY_CARD_ID", paramView.field_card_id);
        localIntent.putExtra("KEY_CARD_TP_ID", paramView.field_card_tp_id);
        localIntent.setClass(this.kxl, CardShopUI.class);
        this.kxl.startActivity(localIntent);
        h.qsU.e(11324, new Object[] { "UsedStoresView", Integer.valueOf(paramView.field_card_type), paramView.field_card_tp_id, paramView.field_card_id, Integer.valueOf(0), Integer.valueOf(0), "", Integer.valueOf(0), "" });
      }
      AppMethodBeat.o(88600);
      return;
    }
    if (paramView.getId() == 2131822300)
    {
      paramView = (g)paramView.getTag();
      if ((paramView == null) || (paramView.bbV() == null))
      {
        AppMethodBeat.o(88600);
        return;
      }
      if (paramView.bbV().type == 0)
      {
        ab.i("MicroMsg.CardNewMsgUI", "card msg action_type is MM_CARD_ITEM_XML_MSG_OPERATION_REGION_TYPE_TEXT");
        if (!TextUtils.isEmpty(paramView.bbV().url))
        {
          b.a(this.kxl, paramView.bbV().url, 2);
          AppMethodBeat.o(88600);
          return;
        }
        ab.e("MicroMsg.CardNewMsgUI", "card msg oper region url is empty");
        AppMethodBeat.o(88600);
        return;
      }
      if (paramView.bbV().type == 1) {
        ab.i("MicroMsg.CardNewMsgUI", "card msg action_type is MM_CARD_ITEM_XML_MSG_OPERATION_REGION_TYPE_CARDS");
      }
    }
    AppMethodBeat.o(88600);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes8.jar
 * Qualified Name:     com.tencent.mm.plugin.card.ui.CardNewMsgUI.9
 * JD-Core Version:    0.7.0.1
 */