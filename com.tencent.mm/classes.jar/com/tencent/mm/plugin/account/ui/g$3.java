package com.tencent.mm.plugin.account.ui;

import android.content.Intent;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.pluginsdk.l;
import com.tencent.mm.ui.MMActivity;

final class g$3
  implements Runnable
{
  g$3(g paramg, MMActivity paramMMActivity) {}
  
  public final void run()
  {
    AppMethodBeat.i(128261);
    Object localObject = com.tencent.mm.plugin.account.a.a.iyx.bD(this.cLd);
    ((Intent)localObject).addFlags(67108864);
    MMActivity localMMActivity = this.cLd;
    localObject = new com.tencent.mm.hellhoundlib.b.a().ba(localObject);
    com.tencent.mm.hellhoundlib.a.a.a(localMMActivity, ((com.tencent.mm.hellhoundlib.b.a)localObject).aeD(), "com/tencent/mm/plugin/account/ui/MobileAutoLogin$3", "run", "()V", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
    localMMActivity.startActivity((Intent)((com.tencent.mm.hellhoundlib.b.a)localObject).lR(0));
    com.tencent.mm.hellhoundlib.a.a.a(localMMActivity, "com/tencent/mm/plugin/account/ui/MobileAutoLogin$3", "run", "()V", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
    this.cLd.finish();
    AppMethodBeat.o(128261);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.plugin.account.ui.g.3
 * JD-Core Version:    0.7.0.1
 */