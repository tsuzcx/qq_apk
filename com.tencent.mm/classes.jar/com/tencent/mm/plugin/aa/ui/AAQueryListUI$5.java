package com.tencent.mm.plugin.aa.ui;

import android.app.Dialog;
import android.widget.ListView;
import android.widget.Toast;
import com.tencent.mm.plugin.wxpay.a.i;
import com.tencent.mm.sdk.platformtools.y;
import com.tencent.mm.vending.g.d.a;

final class AAQueryListUI$5
  implements d.a
{
  AAQueryListUI$5(AAQueryListUI paramAAQueryListUI) {}
  
  public final void aE(Object paramObject)
  {
    y.i("MicroMsg.AAQueryListUI", "getNexPage failed: %s", new Object[] { paramObject });
    if (AAQueryListUI.g(this.eXG) != null)
    {
      AAQueryListUI.g(this.eXG).dismiss();
      AAQueryListUI.h(this.eXG);
    }
    AAQueryListUI.i(this.eXG);
    if (AAQueryListUI.a(this.eXG).getFooterViewsCount() > 0) {
      AAQueryListUI.a(this.eXG).removeFooterView(AAQueryListUI.d(this.eXG));
    }
    if ((paramObject instanceof String))
    {
      Toast.makeText(this.eXG, paramObject.toString(), 1).show();
      return;
    }
    Toast.makeText(this.eXG, a.i.get_aa_list_record_failed, 1).show();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.plugin.aa.ui.AAQueryListUI.5
 * JD-Core Version:    0.7.0.1
 */