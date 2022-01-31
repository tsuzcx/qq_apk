package com.tencent.mm.plugin.aa.ui;

import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.report.service.h;
import com.tencent.mm.sdk.platformtools.ab;
import com.tencent.mm.ui.widget.b.c;
import com.tencent.mm.ui.widget.b.c.a;
import java.util.Map;

final class LaunchAAByPersonAmountSelectUI$6
  implements View.OnClickListener
{
  LaunchAAByPersonAmountSelectUI$6(LaunchAAByPersonAmountSelectUI paramLaunchAAByPersonAmountSelectUI) {}
  
  public final void onClick(View paramView)
  {
    AppMethodBeat.i(40795);
    if ((LaunchAAByPersonAmountSelectUI.c(this.gqx) != null) && (LaunchAAByPersonAmountSelectUI.c(this.gqx).size() > 0)) {}
    try
    {
      paramView = new c.a(this.gqx);
      paramView.Rf(2131296342);
      paramView.Ri(2131297018).a(new LaunchAAByPersonAmountSelectUI.6.1(this));
      paramView.Rj(2131296888).b(new LaunchAAByPersonAmountSelectUI.6.2(this));
      paramView.aLZ().show();
      h.qsU.e(13721, new Object[] { Integer.valueOf(3), Integer.valueOf(8) });
      AppMethodBeat.o(40795);
      return;
    }
    catch (Exception paramView)
    {
      for (;;)
      {
        ab.e("MicroMsg.LaunchAAByPersonAmountSelectUI", "clear amount error");
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes9.jar
 * Qualified Name:     com.tencent.mm.plugin.aa.ui.LaunchAAByPersonAmountSelectUI.6
 * JD-Core Version:    0.7.0.1
 */