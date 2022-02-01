package com.tencent.mm.plugin.luckymoney.ui;

import android.content.Intent;
import android.view.MenuItem;
import android.view.MenuItem.OnMenuItemClickListener;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.report.service.h;
import com.tencent.mm.plugin.wxpay.a.i;
import com.tencent.mm.ui.base.k;
import com.tencent.mm.ui.base.k.e;
import java.util.LinkedList;
import java.util.List;

final class LuckyMoneyIndexUI$4
  implements MenuItem.OnMenuItemClickListener
{
  LuckyMoneyIndexUI$4(LuckyMoneyIndexUI paramLuckyMoneyIndexUI) {}
  
  public final boolean onMenuItemClick(MenuItem paramMenuItem)
  {
    AppMethodBeat.i(65602);
    h.OAn.b(11701, new Object[] { Integer.valueOf(3), Integer.valueOf(0), Integer.valueOf(0), Integer.valueOf(0), Integer.valueOf(4) });
    paramMenuItem = new LinkedList();
    LinkedList localLinkedList = new LinkedList();
    paramMenuItem.add(this.KDg.getString(a.i.lucky_money_my_receive));
    localLinkedList.add(Integer.valueOf(0));
    paramMenuItem.add(this.KDg.getString(a.i.lucky_money_my_send));
    localLinkedList.add(Integer.valueOf(1));
    k.b(this.KDg.getContext(), "", paramMenuItem, localLinkedList, "", new k.e()
    {
      public final void onClick(int paramAnonymousInt1, int paramAnonymousInt2)
      {
        paramAnonymousInt1 = 1;
        AppMethodBeat.i(65601);
        switch (paramAnonymousInt2)
        {
        default: 
          h.OAn.b(11701, new Object[] { Integer.valueOf(3), Integer.valueOf(0), Integer.valueOf(0), Integer.valueOf(0), Integer.valueOf(5) });
          paramAnonymousInt1 = 2;
        }
        for (;;)
        {
          Object localObject = new Intent();
          ((Intent)localObject).setClass(LuckyMoneyIndexUI.4.this.KDg.getContext(), LuckyMoneyMyRecordUI.class);
          ((Intent)localObject).putExtra("key_username", LuckyMoneyIndexUI.4.this.KDg.getIntent().getStringExtra("key_username"));
          ((Intent)localObject).putExtra("key_type", paramAnonymousInt1);
          LuckyMoneyIndexUI localLuckyMoneyIndexUI = LuckyMoneyIndexUI.4.this.KDg;
          localObject = new com.tencent.mm.hellhoundlib.b.a().cG(localObject);
          com.tencent.mm.hellhoundlib.a.a.b(localLuckyMoneyIndexUI, ((com.tencent.mm.hellhoundlib.b.a)localObject).aYi(), "com/tencent/mm/plugin/luckymoney/ui/LuckyMoneyIndexUI$4$1", "onClick", "(II)V", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
          localLuckyMoneyIndexUI.startActivity((Intent)((com.tencent.mm.hellhoundlib.b.a)localObject).sb(0));
          com.tencent.mm.hellhoundlib.a.a.c(localLuckyMoneyIndexUI, "com/tencent/mm/plugin/luckymoney/ui/LuckyMoneyIndexUI$4$1", "onClick", "(II)V", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
          AppMethodBeat.o(65601);
          return;
          h.OAn.b(11701, new Object[] { Integer.valueOf(3), Integer.valueOf(0), Integer.valueOf(0), Integer.valueOf(0), Integer.valueOf(6) });
        }
      }
    });
    AppMethodBeat.o(65602);
    return true;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.plugin.luckymoney.ui.LuckyMoneyIndexUI.4
 * JD-Core Version:    0.7.0.1
 */