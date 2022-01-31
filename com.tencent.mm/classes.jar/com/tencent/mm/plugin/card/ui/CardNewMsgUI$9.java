package com.tencent.mm.plugin.card.ui;

import android.content.Intent;
import android.text.TextUtils;
import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.mm.plugin.card.a.d;
import com.tencent.mm.plugin.card.d.b;
import com.tencent.mm.plugin.card.model.g;
import com.tencent.mm.plugin.report.service.h;
import com.tencent.mm.protocal.c.lt;
import com.tencent.mm.protocal.c.ly;
import com.tencent.mm.sdk.platformtools.y;

final class CardNewMsgUI$9
  implements View.OnClickListener
{
  CardNewMsgUI$9(CardNewMsgUI paramCardNewMsgUI) {}
  
  public final void onClick(View paramView)
  {
    if (paramView.getId() == a.d.extent_tv)
    {
      paramView = (g)paramView.getTag();
      if ((paramView != null) && (paramView.aAi() != null)) {}
    }
    do
    {
      do
      {
        do
        {
          do
          {
            return;
            h.nFQ.f(11941, new Object[] { Integer.valueOf(2), paramView.field_card_id, paramView.field_card_tp_id, paramView.field_msg_id, "" });
            if (paramView.aAi().imX == 0)
            {
              y.i("MicroMsg.CardNewMsgUI", "card msg action_type is MM_CARD_ITEM_XML_MSG_BUTTON_TYPE_URL");
              if (!TextUtils.isEmpty(paramView.aAi().url))
              {
                b.a(this.iwh, paramView.aAi().url, 2);
                return;
              }
              y.e("MicroMsg.CardNewMsgUI", "card msg button url is empty");
              return;
            }
          } while (paramView.aAi().imX != 1);
          y.i("MicroMsg.CardNewMsgUI", "card msg action_type is MM_CARD_ITEM_XML_MSG_BUTTON_TYPE_SHOP");
          Intent localIntent = new Intent();
          localIntent.putExtra("KEY_CARD_ID", paramView.field_card_id);
          localIntent.putExtra("KEY_CARD_TP_ID", paramView.field_card_tp_id);
          localIntent.setClass(this.iwh, CardShopUI.class);
          this.iwh.startActivity(localIntent);
          h.nFQ.f(11324, new Object[] { "UsedStoresView", Integer.valueOf(paramView.field_card_type), paramView.field_card_tp_id, paramView.field_card_id, Integer.valueOf(0), Integer.valueOf(0), "", Integer.valueOf(0), "" });
          return;
        } while (paramView.getId() != a.d.oper_layout);
        paramView = (g)paramView.getTag();
      } while ((paramView == null) || (paramView.aAj() == null));
      if (paramView.aAj().type == 0)
      {
        y.i("MicroMsg.CardNewMsgUI", "card msg action_type is MM_CARD_ITEM_XML_MSG_OPERATION_REGION_TYPE_TEXT");
        if (!TextUtils.isEmpty(paramView.aAj().url))
        {
          b.a(this.iwh, paramView.aAj().url, 2);
          return;
        }
        y.e("MicroMsg.CardNewMsgUI", "card msg oper region url is empty");
        return;
      }
    } while (paramView.aAj().type != 1);
    y.i("MicroMsg.CardNewMsgUI", "card msg action_type is MM_CARD_ITEM_XML_MSG_OPERATION_REGION_TYPE_CARDS");
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes8.jar
 * Qualified Name:     com.tencent.mm.plugin.card.ui.CardNewMsgUI.9
 * JD-Core Version:    0.7.0.1
 */