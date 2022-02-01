package com.tencent.mm.plugin.account.ui;

import android.content.Intent;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.pluginsdk.m;
import com.tencent.mm.ui.MMActivity;

final class h$3
  implements Runnable
{
  h$3(h paramh, MMActivity paramMMActivity) {}
  
  public final void run()
  {
    AppMethodBeat.i(128261);
    Object localObject = com.tencent.mm.plugin.account.a.a.jRt.bZ(this.knk);
    ((Intent)localObject).addFlags(67108864);
    MMActivity localMMActivity = this.knk;
    localObject = new com.tencent.mm.hellhoundlib.b.a().bl(localObject);
    com.tencent.mm.hellhoundlib.a.a.a(localMMActivity, ((com.tencent.mm.hellhoundlib.b.a)localObject).axQ(), "com/tencent/mm/plugin/account/ui/MobileAutoLogin$3", "run", "()V", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
    localMMActivity.startActivity((Intent)((com.tencent.mm.hellhoundlib.b.a)localObject).pG(0));
    com.tencent.mm.hellhoundlib.a.a.a(localMMActivity, "com/tencent/mm/plugin/account/ui/MobileAutoLogin$3", "run", "()V", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
    this.knk.finish();
    AppMethodBeat.o(128261);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.plugin.account.ui.h.3
 * JD-Core Version:    0.7.0.1
 */