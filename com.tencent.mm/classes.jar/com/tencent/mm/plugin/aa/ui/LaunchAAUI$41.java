package com.tencent.mm.plugin.aa.ui;

import android.content.Intent;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.report.service.h;

final class LaunchAAUI$41
  implements a.a
{
  LaunchAAUI$41(LaunchAAUI paramLaunchAAUI) {}
  
  public final void bmr()
  {
    AppMethodBeat.i(63663);
    Object localObject = new Intent(this.jXQ, AAQueryListUI.class);
    LaunchAAUI localLaunchAAUI = this.jXQ;
    localObject = new com.tencent.mm.hellhoundlib.b.a().bl(localObject);
    com.tencent.mm.hellhoundlib.a.a.a(localLaunchAAUI, ((com.tencent.mm.hellhoundlib.b.a)localObject).axQ(), "com/tencent/mm/plugin/aa/ui/LaunchAAUI$5", "onClick", "(Landroid/view/View;)V", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
    localLaunchAAUI.startActivity((Intent)((com.tencent.mm.hellhoundlib.b.a)localObject).pG(0));
    com.tencent.mm.hellhoundlib.a.a.a(localLaunchAAUI, "com/tencent/mm/plugin/aa/ui/LaunchAAUI$5", "onClick", "(Landroid/view/View;)V", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
    if (LaunchAAUI.b(this.jXQ) == com.tencent.mm.plugin.aa.model.a.jRJ)
    {
      h.CyF.a(13721, new Object[] { Integer.valueOf(5), Integer.valueOf(1) });
      AppMethodBeat.o(63663);
      return;
    }
    h.CyF.a(13721, new Object[] { Integer.valueOf(5), Integer.valueOf(2) });
    AppMethodBeat.o(63663);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.plugin.aa.ui.LaunchAAUI.41
 * JD-Core Version:    0.7.0.1
 */