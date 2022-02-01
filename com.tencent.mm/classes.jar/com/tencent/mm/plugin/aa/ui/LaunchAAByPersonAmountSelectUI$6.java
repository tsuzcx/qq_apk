package com.tencent.mm.plugin.aa.ui;

import android.content.DialogInterface;
import android.content.DialogInterface.OnClickListener;
import android.view.View;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.report.service.h;
import com.tencent.mm.plugin.wxpay.a.i;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.ui.widget.a.e;
import com.tencent.mm.ui.widget.a.e.a;
import com.tencent.mm.wallet_core.ui.k;
import java.util.Map;

final class LaunchAAByPersonAmountSelectUI$6
  extends k
{
  LaunchAAByPersonAmountSelectUI$6(LaunchAAByPersonAmountSelectUI paramLaunchAAByPersonAmountSelectUI) {}
  
  public final void dr(View paramView)
  {
    AppMethodBeat.i(268526);
    if ((LaunchAAByPersonAmountSelectUI.c(this.pKC) != null) && (LaunchAAByPersonAmountSelectUI.c(this.pKC).size() > 0)) {}
    try
    {
      paramView = new e.a(this.pKC);
      paramView.aEO(a.i.aa_amount_select_clear_confirm);
      paramView.aER(a.i.aa_amount_select_clear_confirm_clear).c(new DialogInterface.OnClickListener()
      {
        public final void onClick(DialogInterface paramAnonymousDialogInterface, int paramAnonymousInt)
        {
          AppMethodBeat.i(63594);
          LaunchAAByPersonAmountSelectUI.o(LaunchAAByPersonAmountSelectUI.6.this.pKC);
          AppMethodBeat.o(63594);
        }
      });
      paramView.aES(a.i.aa_amount_select_clear_confirm_save).d(new DialogInterface.OnClickListener()
      {
        public final void onClick(DialogInterface paramAnonymousDialogInterface, int paramAnonymousInt)
        {
          AppMethodBeat.i(63595);
          h.OAn.b(13721, new Object[] { Integer.valueOf(3), Integer.valueOf(10) });
          AppMethodBeat.o(63595);
        }
      });
      paramView.jHH().show();
      h.OAn.b(13721, new Object[] { Integer.valueOf(3), Integer.valueOf(8) });
      AppMethodBeat.o(268526);
      return;
    }
    catch (Exception paramView)
    {
      for (;;)
      {
        Log.e("MicroMsg.LaunchAAByPersonAmountSelectUI", "clear amount error");
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.plugin.aa.ui.LaunchAAByPersonAmountSelectUI.6
 * JD-Core Version:    0.7.0.1
 */