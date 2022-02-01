package com.tencent.mm.plugin.aa.ui;

import android.content.DialogInterface;
import android.content.DialogInterface.OnClickListener;
import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.hellhoundlib.a.a;
import com.tencent.mm.hellhoundlib.b.b;
import com.tencent.mm.plugin.report.service.h;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.ui.widget.a.d;
import com.tencent.mm.ui.widget.a.d.a;
import java.util.Map;

final class LaunchAAByPersonAmountSelectUI$6
  implements View.OnClickListener
{
  LaunchAAByPersonAmountSelectUI$6(LaunchAAByPersonAmountSelectUI paramLaunchAAByPersonAmountSelectUI) {}
  
  public final void onClick(View paramView)
  {
    AppMethodBeat.i(63596);
    b localb = new b();
    localb.bm(paramView);
    a.b("com/tencent/mm/plugin/aa/ui/LaunchAAByPersonAmountSelectUI$6", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, localb.axR());
    if ((LaunchAAByPersonAmountSelectUI.c(this.jWI) != null) && (LaunchAAByPersonAmountSelectUI.c(this.jWI).size() > 0)) {}
    try
    {
      paramView = new d.a(this.jWI);
      paramView.aoS(2131755024);
      paramView.aoV(2131755025).c(new DialogInterface.OnClickListener()
      {
        public final void onClick(DialogInterface paramAnonymousDialogInterface, int paramAnonymousInt)
        {
          AppMethodBeat.i(63594);
          LaunchAAByPersonAmountSelectUI.o(LaunchAAByPersonAmountSelectUI.6.this.jWI);
          AppMethodBeat.o(63594);
        }
      });
      paramView.aoW(2131755026).d(new DialogInterface.OnClickListener()
      {
        public final void onClick(DialogInterface paramAnonymousDialogInterface, int paramAnonymousInt)
        {
          AppMethodBeat.i(63595);
          h.CyF.a(13721, new Object[] { Integer.valueOf(3), Integer.valueOf(10) });
          AppMethodBeat.o(63595);
        }
      });
      paramView.hbn().show();
      h.CyF.a(13721, new Object[] { Integer.valueOf(3), Integer.valueOf(8) });
      a.a(this, "com/tencent/mm/plugin/aa/ui/LaunchAAByPersonAmountSelectUI$6", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
      AppMethodBeat.o(63596);
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


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.plugin.aa.ui.LaunchAAByPersonAmountSelectUI.6
 * JD-Core Version:    0.7.0.1
 */