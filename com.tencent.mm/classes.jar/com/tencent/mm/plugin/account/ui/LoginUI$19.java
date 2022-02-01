package com.tencent.mm.plugin.account.ui;

import android.content.Intent;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ak.n;
import com.tencent.mm.modelsimple.s;
import com.tencent.mm.pluginsdk.l;
import com.tencent.mm.sdk.platformtools.ac;

final class LoginUI$19
  implements Runnable
{
  LoginUI$19(LoginUI paramLoginUI, n paramn) {}
  
  public final void run()
  {
    AppMethodBeat.i(128221);
    ac.d("MicroMsg.LoginUI", "onSceneEnd, in runnable");
    Object localObject = com.tencent.mm.plugin.account.a.a.iyx.bD(this.iSO);
    ((Intent)localObject).addFlags(67108864);
    ((Intent)localObject).putExtra("kstyle_show_bind_mobile_afterauth", ((s)this.cXh).aHF());
    ((Intent)localObject).putExtra("kstyle_bind_wording", ((s)this.cXh).aHG());
    ((Intent)localObject).putExtra("kstyle_bind_recommend_show", ((s)this.cXh).aHI());
    LoginUI localLoginUI = this.iSO;
    localObject = new com.tencent.mm.hellhoundlib.b.a().ba(localObject);
    com.tencent.mm.hellhoundlib.a.a.a(localLoginUI, ((com.tencent.mm.hellhoundlib.b.a)localObject).aeD(), "com/tencent/mm/plugin/account/ui/LoginUI$26", "run", "()V", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
    localLoginUI.startActivity((Intent)((com.tencent.mm.hellhoundlib.b.a)localObject).lR(0));
    com.tencent.mm.hellhoundlib.a.a.a(localLoginUI, "com/tencent/mm/plugin/account/ui/LoginUI$26", "run", "()V", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
    this.iSO.finish();
    AppMethodBeat.o(128221);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.plugin.account.ui.LoginUI.19
 * JD-Core Version:    0.7.0.1
 */