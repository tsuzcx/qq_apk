package com.tencent.mm.plugin.card.ui;

import android.database.Cursor;
import android.os.MessageQueue.IdleHandler;
import com.tencent.mm.kernel.e;
import com.tencent.mm.kernel.g;
import com.tencent.mm.plugin.card.model.CardInfo;
import com.tencent.mm.plugin.card.model.am;
import com.tencent.mm.plugin.card.model.c;
import com.tencent.mm.plugin.card.model.n.a;
import com.tencent.mm.protocal.c.mg;
import com.tencent.mm.sdk.platformtools.y;
import com.tencent.mm.storage.ac.a;
import com.tencent.mm.storage.z;

final class CardHomePageUI$9
  implements MessageQueue.IdleHandler
{
  CardHomePageUI$9(CardHomePageUI paramCardHomePageUI) {}
  
  public final boolean queueIdle()
  {
    Object localObject;
    int i;
    if (CardHomePageUI.g(this.ivb) != null)
    {
      CardHomePageUI.g(this.ivb);
      localObject = (Integer)g.DP().Dz().get(ac.a.upn, Integer.valueOf(0));
      if ((localObject == null) || (((Integer)localObject).intValue() != 1)) {
        break label72;
      }
      i = 0;
    }
    for (;;)
    {
      if (i != 0)
      {
        y.i("MicroMsg.CardHomePageUI", "try2UpdateCardType");
        CardHomePageUI.h(this.ivb);
      }
      return false;
      label72:
      g.DP().Dz().c(ac.a.upn, Integer.valueOf(1));
      localObject = am.aAs().a(n.a.inf);
      if ((localObject != null) && (((Cursor)localObject).getCount() > 0))
      {
        ((Cursor)localObject).moveToFirst();
        if (!((Cursor)localObject).isAfterLast())
        {
          CardInfo localCardInfo = new CardInfo();
          localCardInfo.d((Cursor)localObject);
          if (localCardInfo.field_card_type == -1)
          {
            if (localCardInfo.azx() != null) {
              break label172;
            }
            y.e("MicroMsg.ShareCardDataMgr", "updateCardType fail , info.getCardTpInfo() == null");
          }
          for (;;)
          {
            ((Cursor)localObject).moveToNext();
            break;
            label172:
            localCardInfo.field_card_type = localCardInfo.azx().ilo;
            if (!am.aAs().c(localCardInfo, new String[0])) {
              y.e("MicroMsg.ShareCardDataMgr", "updateCardType fail , cardId = %s", new Object[] { localCardInfo.field_card_id });
            }
          }
        }
        ((Cursor)localObject).close();
        i = 1;
      }
      else
      {
        y.e("MicroMsg.ShareCardDataMgr", "updateAllCardInfoByBlockField cursor is null or size is 0");
        i = 0;
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.plugin.card.ui.CardHomePageUI.9
 * JD-Core Version:    0.7.0.1
 */