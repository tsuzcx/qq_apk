package com.tencent.mm.plugin.luckymoney.ui;

import android.content.Intent;
import android.view.MenuItem;
import android.view.MenuItem.OnMenuItemClickListener;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.report.service.h;

final class LuckyMoneyDetailUI$21
  implements MenuItem.OnMenuItemClickListener
{
  LuckyMoneyDetailUI$21(LuckyMoneyDetailUI paramLuckyMoneyDetailUI) {}
  
  public final boolean onMenuItemClick(MenuItem paramMenuItem)
  {
    AppMethodBeat.i(65550);
    h.wUl.f(11701, new Object[] { Integer.valueOf(LuckyMoneyDetailUI.HV(LuckyMoneyDetailUI.r(this.uux))), Integer.valueOf(0), Integer.valueOf(0), Integer.valueOf(0), Integer.valueOf(4) });
    Object localObject = new Intent();
    ((Intent)localObject).setClass(this.uux.getContext(), LuckyMoneyMyRecordUI.class);
    ((Intent)localObject).putExtra("key_type", 2);
    paramMenuItem = this.uux;
    localObject = new com.tencent.mm.hellhoundlib.b.a().ba(localObject);
    com.tencent.mm.hellhoundlib.a.a.a(paramMenuItem, ((com.tencent.mm.hellhoundlib.b.a)localObject).aeD(), "com/tencent/mm/plugin/luckymoney/ui/LuckyMoneyDetailUI$4", "onMenuItemClick", "(Landroid/view/MenuItem;)Z", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
    paramMenuItem.startActivity((Intent)((com.tencent.mm.hellhoundlib.b.a)localObject).lR(0));
    com.tencent.mm.hellhoundlib.a.a.a(paramMenuItem, "com/tencent/mm/plugin/luckymoney/ui/LuckyMoneyDetailUI$4", "onMenuItemClick", "(Landroid/view/MenuItem;)Z", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
    AppMethodBeat.o(65550);
    return true;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.plugin.luckymoney.ui.LuckyMoneyDetailUI.21
 * JD-Core Version:    0.7.0.1
 */