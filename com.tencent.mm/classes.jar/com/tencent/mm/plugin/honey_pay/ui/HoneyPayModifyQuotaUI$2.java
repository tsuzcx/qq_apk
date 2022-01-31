package com.tencent.mm.plugin.honey_pay.ui;

import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.matrix.trace.core.AppMethodBeat;

final class HoneyPayModifyQuotaUI$2
  implements View.OnClickListener
{
  HoneyPayModifyQuotaUI$2(HoneyPayModifyQuotaUI paramHoneyPayModifyQuotaUI) {}
  
  public final void onClick(View paramView)
  {
    AppMethodBeat.i(41914);
    if (HoneyPayModifyQuotaUI.a(this.nJn))
    {
      HoneyPayModifyQuotaUI.b(this.nJn);
      this.nJn.hideTenpayKB();
    }
    AppMethodBeat.o(41914);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.mm.plugin.honey_pay.ui.HoneyPayModifyQuotaUI.2
 * JD-Core Version:    0.7.0.1
 */