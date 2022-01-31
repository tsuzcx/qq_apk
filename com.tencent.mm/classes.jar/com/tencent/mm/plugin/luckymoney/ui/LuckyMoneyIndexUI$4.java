package com.tencent.mm.plugin.luckymoney.ui;

import android.view.MenuItem;
import android.view.MenuItem.OnMenuItemClickListener;
import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.LinkedList;
import java.util.List;

final class LuckyMoneyIndexUI$4
  implements MenuItem.OnMenuItemClickListener
{
  LuckyMoneyIndexUI$4(LuckyMoneyIndexUI paramLuckyMoneyIndexUI) {}
  
  public final boolean onMenuItemClick(MenuItem paramMenuItem)
  {
    AppMethodBeat.i(42725);
    com.tencent.mm.plugin.report.service.h.qsU.e(11701, new Object[] { Integer.valueOf(3), Integer.valueOf(0), Integer.valueOf(0), Integer.valueOf(0), Integer.valueOf(4) });
    paramMenuItem = new LinkedList();
    LinkedList localLinkedList = new LinkedList();
    paramMenuItem.add(this.otI.getString(2131301254));
    localLinkedList.add(Integer.valueOf(0));
    paramMenuItem.add(this.otI.getString(2131301256));
    localLinkedList.add(Integer.valueOf(1));
    com.tencent.mm.ui.base.h.a(this.otI.getContext(), "", paramMenuItem, localLinkedList, "", false, new LuckyMoneyIndexUI.4.1(this));
    AppMethodBeat.o(42725);
    return true;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.plugin.luckymoney.ui.LuckyMoneyIndexUI.4
 * JD-Core Version:    0.7.0.1
 */