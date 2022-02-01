package com.tencent.mm.plugin.account.ui;

import android.content.Intent;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.kernel.b;
import com.tencent.mm.kernel.h;
import com.tencent.mm.pluginsdk.m;

final class RegByMobileRegAIOUI$16
  implements Runnable
{
  RegByMobileRegAIOUI$16(RegByMobileRegAIOUI paramRegByMobileRegAIOUI) {}
  
  public final void run()
  {
    AppMethodBeat.i(128528);
    Object localObject2 = com.tencent.mm.plugin.account.sdk.a.pFn.cJ(this.qfw);
    ((Intent)localObject2).addFlags(67108864);
    Object localObject1 = this.qfw;
    localObject2 = new com.tencent.mm.hellhoundlib.b.a().cG(localObject2);
    com.tencent.mm.hellhoundlib.a.a.b(localObject1, ((com.tencent.mm.hellhoundlib.b.a)localObject2).aYi(), "com/tencent/mm/plugin/account/ui/RegByMobileRegAIOUI$23", "run", "()V", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
    ((RegByMobileRegAIOUI)localObject1).startActivity((Intent)((com.tencent.mm.hellhoundlib.b.a)localObject2).sb(0));
    com.tencent.mm.hellhoundlib.a.a.c(localObject1, "com/tencent/mm/plugin/account/ui/RegByMobileRegAIOUI$23", "run", "()V", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
    localObject1 = new StringBuilder();
    h.baC();
    localObject1 = ((StringBuilder)localObject1).append(b.aZR()).append(",").append(this.qfw.getClass().getName()).append(",L14,");
    h.baC();
    com.tencent.mm.plugin.b.a.Du(b.Fw("L14") + ",4");
    this.qfw.finish();
    AppMethodBeat.o(128528);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.plugin.account.ui.RegByMobileRegAIOUI.16
 * JD-Core Version:    0.7.0.1
 */