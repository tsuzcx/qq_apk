package com.tencent.mm.plugin.luckymoney.ui;

import android.content.Intent;
import android.view.MenuItem;
import android.view.MenuItem.OnMenuItemClickListener;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.report.service.g;

final class LuckyMoneyDetailUI$21
  implements MenuItem.OnMenuItemClickListener
{
  LuckyMoneyDetailUI$21(LuckyMoneyDetailUI paramLuckyMoneyDetailUI) {}
  
  public final boolean onMenuItemClick(MenuItem paramMenuItem)
  {
    AppMethodBeat.i(65550);
    g.yxI.f(11701, new Object[] { Integer.valueOf(LuckyMoneyDetailUI.JQ(LuckyMoneyDetailUI.r(this.vJe))), Integer.valueOf(0), Integer.valueOf(0), Integer.valueOf(0), Integer.valueOf(4) });
    Object localObject = new Intent();
    ((Intent)localObject).setClass(this.vJe.getContext(), LuckyMoneyMyRecordUI.class);
    ((Intent)localObject).putExtra("key_type", 2);
    paramMenuItem = this.vJe;
    localObject = new com.tencent.mm.hellhoundlib.b.a().bc(localObject);
    com.tencent.mm.hellhoundlib.a.a.a(paramMenuItem, ((com.tencent.mm.hellhoundlib.b.a)localObject).ahE(), "com/tencent/mm/plugin/luckymoney/ui/LuckyMoneyDetailUI$4", "onMenuItemClick", "(Landroid/view/MenuItem;)Z", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
    paramMenuItem.startActivity((Intent)((com.tencent.mm.hellhoundlib.b.a)localObject).mt(0));
    com.tencent.mm.hellhoundlib.a.a.a(paramMenuItem, "com/tencent/mm/plugin/luckymoney/ui/LuckyMoneyDetailUI$4", "onMenuItemClick", "(Landroid/view/MenuItem;)Z", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
    AppMethodBeat.o(65550);
    return true;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.plugin.luckymoney.ui.LuckyMoneyDetailUI.21
 * JD-Core Version:    0.7.0.1
 */