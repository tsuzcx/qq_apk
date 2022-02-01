package com.tencent.mm.plugin.aa.ui;

import android.content.Intent;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.report.service.g;

final class LaunchAAUI$29
  implements a.a
{
  LaunchAAUI$29(LaunchAAUI paramLaunchAAUI) {}
  
  public final void aRM()
  {
    AppMethodBeat.i(63663);
    Object localObject = new Intent(this.jab, AAQueryListUI.class);
    LaunchAAUI localLaunchAAUI = this.jab;
    localObject = new com.tencent.mm.hellhoundlib.b.a().bc(localObject);
    com.tencent.mm.hellhoundlib.a.a.a(localLaunchAAUI, ((com.tencent.mm.hellhoundlib.b.a)localObject).ahE(), "com/tencent/mm/plugin/aa/ui/LaunchAAUI$5", "onClick", "(Landroid/view/View;)V", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
    localLaunchAAUI.startActivity((Intent)((com.tencent.mm.hellhoundlib.b.a)localObject).mt(0));
    com.tencent.mm.hellhoundlib.a.a.a(localLaunchAAUI, "com/tencent/mm/plugin/aa/ui/LaunchAAUI$5", "onClick", "(Landroid/view/View;)V", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
    if (LaunchAAUI.c(this.jab) == com.tencent.mm.plugin.aa.model.a.iUP)
    {
      g.yxI.f(13721, new Object[] { Integer.valueOf(5), Integer.valueOf(1) });
      AppMethodBeat.o(63663);
      return;
    }
    g.yxI.f(13721, new Object[] { Integer.valueOf(5), Integer.valueOf(2) });
    AppMethodBeat.o(63663);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.plugin.aa.ui.LaunchAAUI.29
 * JD-Core Version:    0.7.0.1
 */