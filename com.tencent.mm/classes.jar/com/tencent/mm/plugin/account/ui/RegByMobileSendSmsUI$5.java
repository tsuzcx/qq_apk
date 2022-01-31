package com.tencent.mm.plugin.account.ui;

import android.content.Intent;
import com.tencent.mm.kernel.g;
import com.tencent.mm.model.at;
import com.tencent.mm.modelsimple.s;
import com.tencent.mm.pluginsdk.m;

final class RegByMobileSendSmsUI$5
  implements Runnable
{
  RegByMobileSendSmsUI$5(RegByMobileSendSmsUI paramRegByMobileSendSmsUI, s params, String paramString) {}
  
  public final void run()
  {
    RegByMobileSendSmsUI.a(this.fqR, this.fqS.QI());
    at.dVC.Y("login_user_name", this.fpg);
    Object localObject = com.tencent.mm.plugin.account.a.a.eUR.aN(this.fqR);
    ((Intent)localObject).addFlags(67108864);
    this.fqR.startActivity((Intent)localObject);
    localObject = new StringBuilder();
    g.DN();
    localObject = ((StringBuilder)localObject).append(com.tencent.mm.kernel.a.Df()).append(",").append(getClass().getName()).append(",R200_600,");
    g.DN();
    com.tencent.mm.plugin.b.a.qk(com.tencent.mm.kernel.a.gd("R200_600") + ",4");
    this.fqR.finish();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes9.jar
 * Qualified Name:     com.tencent.mm.plugin.account.ui.RegByMobileSendSmsUI.5
 * JD-Core Version:    0.7.0.1
 */