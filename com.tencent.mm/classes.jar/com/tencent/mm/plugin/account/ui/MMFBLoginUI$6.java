package com.tencent.mm.plugin.account.ui;

import android.content.Intent;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.kernel.b;
import com.tencent.mm.kernel.h;
import com.tencent.mm.pluginsdk.m;

final class MMFBLoginUI$6
  implements Runnable
{
  MMFBLoginUI$6(MMFBLoginUI paramMMFBLoginUI) {}
  
  public final void run()
  {
    AppMethodBeat.i(305254);
    Object localObject2 = com.tencent.mm.plugin.account.sdk.a.pFn.cJ(this.qcb);
    ((Intent)localObject2).addFlags(67108864);
    Object localObject1 = this.qcb;
    localObject2 = new com.tencent.mm.hellhoundlib.b.a().cG(localObject2);
    com.tencent.mm.hellhoundlib.a.a.b(localObject1, ((com.tencent.mm.hellhoundlib.b.a)localObject2).aYi(), "com/tencent/mm/plugin/account/ui/MMFBLoginUI$6", "run", "()V", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
    ((MMFBLoginUI)localObject1).startActivity((Intent)((com.tencent.mm.hellhoundlib.b.a)localObject2).sb(0));
    com.tencent.mm.hellhoundlib.a.a.c(localObject1, "com/tencent/mm/plugin/account/ui/MMFBLoginUI$6", "run", "()V", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
    localObject1 = new StringBuilder();
    h.baC();
    localObject1 = ((StringBuilder)localObject1).append(b.aZR()).append(",").append(this.qcb.getClass().getName()).append(",L14,");
    h.baC();
    com.tencent.mm.plugin.b.a.Du(b.Fw("L14") + ",4");
    this.qcb.finish();
    AppMethodBeat.o(305254);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.plugin.account.ui.MMFBLoginUI.6
 * JD-Core Version:    0.7.0.1
 */