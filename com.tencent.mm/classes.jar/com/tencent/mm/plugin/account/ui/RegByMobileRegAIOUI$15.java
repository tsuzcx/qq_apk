package com.tencent.mm.plugin.account.ui;

import android.content.Intent;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.kernel.b;
import com.tencent.mm.kernel.h;
import com.tencent.mm.pluginsdk.m;

final class RegByMobileRegAIOUI$15
  implements Runnable
{
  RegByMobileRegAIOUI$15(RegByMobileRegAIOUI paramRegByMobileRegAIOUI) {}
  
  public final void run()
  {
    AppMethodBeat.i(220332);
    Object localObject2 = com.tencent.mm.plugin.account.sdk.a.mIG.bX(this.nic);
    ((Intent)localObject2).addFlags(67108864);
    Object localObject1 = this.nic;
    localObject2 = new com.tencent.mm.hellhoundlib.b.a().bm(localObject2);
    com.tencent.mm.hellhoundlib.a.a.b(localObject1, ((com.tencent.mm.hellhoundlib.b.a)localObject2).aFh(), "com/tencent/mm/plugin/account/ui/RegByMobileRegAIOUI$22", "run", "()V", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
    ((RegByMobileRegAIOUI)localObject1).startActivity((Intent)((com.tencent.mm.hellhoundlib.b.a)localObject2).sf(0));
    com.tencent.mm.hellhoundlib.a.a.c(localObject1, "com/tencent/mm/plugin/account/ui/RegByMobileRegAIOUI$22", "run", "()V", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
    localObject1 = new StringBuilder();
    h.aHE();
    localObject1 = ((StringBuilder)localObject1).append(b.aGR()).append(",").append(this.nic.getClass().getName()).append(",L14,");
    h.aHE();
    com.tencent.mm.plugin.b.a.KP(b.MN("L14") + ",4");
    this.nic.finish();
    AppMethodBeat.o(220332);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.plugin.account.ui.RegByMobileRegAIOUI.15
 * JD-Core Version:    0.7.0.1
 */