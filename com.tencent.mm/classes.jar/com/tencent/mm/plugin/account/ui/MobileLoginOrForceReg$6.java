package com.tencent.mm.plugin.account.ui;

import android.content.Intent;
import com.tencent.mm.kernel.g;
import com.tencent.mm.model.at;
import com.tencent.mm.modelsimple.s;

final class MobileLoginOrForceReg$6
  implements Runnable
{
  MobileLoginOrForceReg$6(MobileLoginOrForceReg paramMobileLoginOrForceReg, com.tencent.mm.ah.m paramm, String paramString) {}
  
  public final void run()
  {
    MobileLoginOrForceReg.a(this.fpa, ((s)this.bEe).QI());
    at.dVC.Y("login_user_name", this.fpg);
    Object localObject = com.tencent.mm.plugin.account.a.a.eUR.aN(this.fpa);
    ((Intent)localObject).addFlags(67108864);
    this.fpa.startActivity((Intent)localObject);
    localObject = new StringBuilder();
    g.DN();
    localObject = ((StringBuilder)localObject).append(com.tencent.mm.kernel.a.Df()).append(",").append(getClass().getName()).append(",R200_600,");
    g.DN();
    com.tencent.mm.plugin.b.a.qk(com.tencent.mm.kernel.a.gd("R200_600") + ",4");
    this.fpa.finish();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.plugin.account.ui.MobileLoginOrForceReg.6
 * JD-Core Version:    0.7.0.1
 */