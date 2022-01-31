package com.tencent.mm.plugin.aa.ui;

import android.view.MenuItem;
import com.tencent.mm.plugin.wxpay.a.i;
import com.tencent.mm.sdk.platformtools.y;
import com.tencent.mm.ui.base.n.d;

final class AAQueryListUI$4$2
  implements n.d
{
  AAQueryListUI$4$2(AAQueryListUI.4 param4) {}
  
  public final void onMMMenuItemSelected(MenuItem paramMenuItem, int paramInt)
  {
    switch (paramMenuItem.getItemId())
    {
    }
    do
    {
      do
      {
        return;
        y.i("MicroMsg.AAQueryListUI", "go to launch list: %d", new Object[] { Integer.valueOf(AAQueryListUI.e(this.eXH.eXG)) });
      } while (AAQueryListUI.e(this.eXH.eXG) == 1);
      AAQueryListUI.a(this.eXH.eXG, 1);
      this.eXH.eXG.setMMTitle(a.i.aa_record_list_launch_title);
      AAQueryListUI.f(this.eXH.eXG).mode = AAQueryListUI.e(this.eXH.eXG);
      AAQueryListUI.f(this.eXH.eXG).Vy();
      AAQueryListUI.f(this.eXH.eXG).notifyDataSetChanged();
      AAQueryListUI.a(this.eXH.eXG, true, AAQueryListUI.e(this.eXH.eXG));
      return;
      y.i("MicroMsg.AAQueryListUI", "go to pay query list: %d", new Object[] { Integer.valueOf(AAQueryListUI.e(this.eXH.eXG)) });
    } while (AAQueryListUI.e(this.eXH.eXG) == 2);
    this.eXH.eXG.setMMTitle(a.i.aa_record_list_pay_title);
    AAQueryListUI.f(this.eXH.eXG).mode = AAQueryListUI.e(this.eXH.eXG);
    AAQueryListUI.f(this.eXH.eXG).Vy();
    AAQueryListUI.f(this.eXH.eXG).notifyDataSetChanged();
    AAQueryListUI.a(this.eXH.eXG, 2);
    AAQueryListUI.a(this.eXH.eXG, true, AAQueryListUI.e(this.eXH.eXG));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes9.jar
 * Qualified Name:     com.tencent.mm.plugin.aa.ui.AAQueryListUI.4.2
 * JD-Core Version:    0.7.0.1
 */