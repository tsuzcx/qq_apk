package com.tencent.mm.plugin.honey_pay.model;

import android.view.MenuItem;
import android.view.MenuItem.OnMenuItemClickListener;
import com.tencent.mm.protocal.c.bmi;
import com.tencent.mm.protocal.c.bya;
import com.tencent.mm.ui.MMActivity;
import com.tencent.mm.ui.widget.a.d;

final class c$2
  implements MenuItem.OnMenuItemClickListener
{
  c$2(MMActivity paramMMActivity, bmi parambmi, String paramString, bya parambya, int paramInt) {}
  
  public final boolean onMenuItemClick(MenuItem paramMenuItem)
  {
    paramMenuItem = new d(this.gGJ, 1, false);
    paramMenuItem.phH = new c.2.1(this);
    paramMenuItem.phI = new c.2.2(this);
    paramMenuItem.cfU();
    return false;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes9.jar
 * Qualified Name:     com.tencent.mm.plugin.honey_pay.model.c.2
 * JD-Core Version:    0.7.0.1
 */