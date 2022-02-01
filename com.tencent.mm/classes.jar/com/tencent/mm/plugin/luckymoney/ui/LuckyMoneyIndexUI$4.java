package com.tencent.mm.plugin.luckymoney.ui;

import android.content.Intent;
import android.view.MenuItem;
import android.view.MenuItem.OnMenuItemClickListener;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ui.base.h.d;
import java.util.LinkedList;
import java.util.List;

final class LuckyMoneyIndexUI$4
  implements MenuItem.OnMenuItemClickListener
{
  LuckyMoneyIndexUI$4(LuckyMoneyIndexUI paramLuckyMoneyIndexUI) {}
  
  public final boolean onMenuItemClick(MenuItem paramMenuItem)
  {
    AppMethodBeat.i(65602);
    com.tencent.mm.plugin.report.service.h.wUl.f(11701, new Object[] { Integer.valueOf(3), Integer.valueOf(0), Integer.valueOf(0), Integer.valueOf(0), Integer.valueOf(4) });
    paramMenuItem = new LinkedList();
    LinkedList localLinkedList = new LinkedList();
    paramMenuItem.add(this.uuL.getString(2131760896));
    localLinkedList.add(Integer.valueOf(0));
    paramMenuItem.add(this.uuL.getString(2131760898));
    localLinkedList.add(Integer.valueOf(1));
    com.tencent.mm.ui.base.h.b(this.uuL.getContext(), "", paramMenuItem, localLinkedList, "", new h.d()
    {
      public final void ct(int paramAnonymousInt1, int paramAnonymousInt2)
      {
        paramAnonymousInt1 = 1;
        AppMethodBeat.i(65601);
        switch (paramAnonymousInt2)
        {
        default: 
          com.tencent.mm.plugin.report.service.h.wUl.f(11701, new Object[] { Integer.valueOf(3), Integer.valueOf(0), Integer.valueOf(0), Integer.valueOf(0), Integer.valueOf(5) });
          paramAnonymousInt1 = 2;
        }
        for (;;)
        {
          Object localObject = new Intent();
          ((Intent)localObject).setClass(LuckyMoneyIndexUI.4.this.uuL.getContext(), LuckyMoneyMyRecordUI.class);
          ((Intent)localObject).putExtra("key_type", paramAnonymousInt1);
          LuckyMoneyIndexUI localLuckyMoneyIndexUI = LuckyMoneyIndexUI.4.this.uuL;
          localObject = new com.tencent.mm.hellhoundlib.b.a().ba(localObject);
          com.tencent.mm.hellhoundlib.a.a.a(localLuckyMoneyIndexUI, ((com.tencent.mm.hellhoundlib.b.a)localObject).aeD(), "com/tencent/mm/plugin/luckymoney/ui/LuckyMoneyIndexUI$4$1", "onClick", "(II)V", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
          localLuckyMoneyIndexUI.startActivity((Intent)((com.tencent.mm.hellhoundlib.b.a)localObject).lR(0));
          com.tencent.mm.hellhoundlib.a.a.a(localLuckyMoneyIndexUI, "com/tencent/mm/plugin/luckymoney/ui/LuckyMoneyIndexUI$4$1", "onClick", "(II)V", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
          AppMethodBeat.o(65601);
          return;
          com.tencent.mm.plugin.report.service.h.wUl.f(11701, new Object[] { Integer.valueOf(3), Integer.valueOf(0), Integer.valueOf(0), Integer.valueOf(0), Integer.valueOf(6) });
        }
      }
    });
    AppMethodBeat.o(65602);
    return true;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.plugin.luckymoney.ui.LuckyMoneyIndexUI.4
 * JD-Core Version:    0.7.0.1
 */