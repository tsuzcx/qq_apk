package com.tencent.mm.plugin.luckymoney.ui;

import android.content.Intent;
import android.view.MenuItem;
import android.view.MenuItem.OnMenuItemClickListener;
import com.tencent.mm.plugin.wxpay.a.i;
import com.tencent.mm.ui.MMActivity;
import com.tencent.mm.ui.base.h.d;
import com.tencent.mm.ui.s;
import java.util.LinkedList;
import java.util.List;

final class LuckyMoneyIndexUI$4
  implements MenuItem.OnMenuItemClickListener
{
  LuckyMoneyIndexUI$4(LuckyMoneyIndexUI paramLuckyMoneyIndexUI) {}
  
  public final boolean onMenuItemClick(MenuItem paramMenuItem)
  {
    com.tencent.mm.plugin.report.service.h.nFQ.f(11701, new Object[] { Integer.valueOf(3), Integer.valueOf(0), Integer.valueOf(0), Integer.valueOf(0), Integer.valueOf(4) });
    paramMenuItem = new LinkedList();
    LinkedList localLinkedList = new LinkedList();
    paramMenuItem.add(this.lVD.getString(a.i.lucky_money_my_receive));
    localLinkedList.add(Integer.valueOf(0));
    paramMenuItem.add(this.lVD.getString(a.i.lucky_money_my_send));
    localLinkedList.add(Integer.valueOf(1));
    com.tencent.mm.ui.base.h.a(this.lVD.mController.uMN, "", paramMenuItem, localLinkedList, "", false, new h.d()
    {
      public final void bF(int paramAnonymousInt1, int paramAnonymousInt2)
      {
        paramAnonymousInt1 = 1;
        switch (paramAnonymousInt2)
        {
        default: 
          com.tencent.mm.plugin.report.service.h.nFQ.f(11701, new Object[] { Integer.valueOf(3), Integer.valueOf(0), Integer.valueOf(0), Integer.valueOf(0), Integer.valueOf(5) });
          paramAnonymousInt1 = 2;
        }
        for (;;)
        {
          Intent localIntent = new Intent();
          localIntent.setClass(LuckyMoneyIndexUI.4.this.lVD.mController.uMN, LuckyMoneyMyRecordUI.class);
          localIntent.putExtra("key_type", paramAnonymousInt1);
          LuckyMoneyIndexUI.4.this.lVD.startActivity(localIntent);
          return;
          com.tencent.mm.plugin.report.service.h.nFQ.f(11701, new Object[] { Integer.valueOf(3), Integer.valueOf(0), Integer.valueOf(0), Integer.valueOf(0), Integer.valueOf(6) });
        }
      }
    });
    return true;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.plugin.luckymoney.ui.LuckyMoneyIndexUI.4
 * JD-Core Version:    0.7.0.1
 */