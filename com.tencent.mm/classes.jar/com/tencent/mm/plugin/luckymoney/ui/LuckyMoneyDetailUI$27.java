package com.tencent.mm.plugin.luckymoney.ui;

import android.content.Intent;
import android.view.MenuItem;
import android.view.MenuItem.OnMenuItemClickListener;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.report.service.h;

final class LuckyMoneyDetailUI$27
  implements MenuItem.OnMenuItemClickListener
{
  LuckyMoneyDetailUI$27(LuckyMoneyDetailUI paramLuckyMoneyDetailUI) {}
  
  public final boolean onMenuItemClick(MenuItem paramMenuItem)
  {
    AppMethodBeat.i(65550);
    h.CyF.a(11701, new Object[] { Integer.valueOf(LuckyMoneyDetailUI.PS(LuckyMoneyDetailUI.r(this.zee))), Integer.valueOf(0), Integer.valueOf(0), Integer.valueOf(0), Integer.valueOf(4) });
    Object localObject = new Intent();
    ((Intent)localObject).setClass(this.zee.getContext(), LuckyMoneyMyRecordUI.class);
    ((Intent)localObject).putExtra("key_type", 2);
    ((Intent)localObject).putExtra("key_username", LuckyMoneyDetailUI.s(this.zee));
    paramMenuItem = this.zee;
    localObject = new com.tencent.mm.hellhoundlib.b.a().bl(localObject);
    com.tencent.mm.hellhoundlib.a.a.a(paramMenuItem, ((com.tencent.mm.hellhoundlib.b.a)localObject).axQ(), "com/tencent/mm/plugin/luckymoney/ui/LuckyMoneyDetailUI$4", "onMenuItemClick", "(Landroid/view/MenuItem;)Z", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
    paramMenuItem.startActivity((Intent)((com.tencent.mm.hellhoundlib.b.a)localObject).pG(0));
    com.tencent.mm.hellhoundlib.a.a.a(paramMenuItem, "com/tencent/mm/plugin/luckymoney/ui/LuckyMoneyDetailUI$4", "onMenuItemClick", "(Landroid/view/MenuItem;)Z", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
    AppMethodBeat.o(65550);
    return true;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.plugin.luckymoney.ui.LuckyMoneyDetailUI.27
 * JD-Core Version:    0.7.0.1
 */