package com.tencent.mm.plugin.aa.ui;

import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.mm.plugin.report.service.h;
import com.tencent.mm.plugin.wxpay.a.i;
import com.tencent.mm.sdk.platformtools.y;
import com.tencent.mm.ui.widget.a.c;
import com.tencent.mm.ui.widget.a.c.a;
import java.util.Map;

final class LaunchAAByPersonAmountSelectUI$6
  implements View.OnClickListener
{
  LaunchAAByPersonAmountSelectUI$6(LaunchAAByPersonAmountSelectUI paramLaunchAAByPersonAmountSelectUI) {}
  
  public final void onClick(View paramView)
  {
    if ((LaunchAAByPersonAmountSelectUI.c(this.eYG) != null) && (LaunchAAByPersonAmountSelectUI.c(this.eYG).size() > 0)) {}
    try
    {
      paramView = new c.a(this.eYG);
      paramView.Iq(a.i.aa_amount_select_clear_confirm);
      paramView.Is(a.i.app_ok).a(new LaunchAAByPersonAmountSelectUI.6.1(this));
      paramView.It(a.i.app_cancel).b(new LaunchAAByPersonAmountSelectUI.6.2(this));
      paramView.aoP().show();
      h.nFQ.f(13721, new Object[] { Integer.valueOf(3), Integer.valueOf(8) });
      return;
    }
    catch (Exception paramView)
    {
      for (;;)
      {
        y.e("MicroMsg.LaunchAAByPersonAmountSelectUI", "clear amount error");
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes9.jar
 * Qualified Name:     com.tencent.mm.plugin.aa.ui.LaunchAAByPersonAmountSelectUI.6
 * JD-Core Version:    0.7.0.1
 */