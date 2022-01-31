package com.tencent.mm.plugin.account.ui;

import android.content.Intent;
import com.tencent.mm.kernel.g;
import com.tencent.mm.model.at;
import com.tencent.mm.modelsimple.s;
import com.tencent.mm.plugin.account.bind.ui.FindMContactAlertUI;
import com.tencent.mm.plugin.account.bind.ui.FindMContactIntroUI;
import com.tencent.mm.ui.MMWizardActivity;

final class o$5
  implements Runnable
{
  o$5(o paramo, com.tencent.mm.ah.m paramm, String paramString1, String paramString2, boolean paramBoolean, String paramString3, String paramString4, int paramInt) {}
  
  public final void run()
  {
    this.fpr.dqS = ((s)this.bEe).QI();
    at.dVC.Y("login_user_name", this.fpg);
    com.tencent.mm.vfs.e.deleteFile(com.tencent.mm.compatible.util.e.dzK + "temp.avatar");
    if ((this.fpu != null) && (this.fpu.contains("0")))
    {
      com.tencent.mm.plugin.b.a.qj("R300_100_phone");
      if (!this.fpv) {
        localObject = new Intent(this.fpr.fpj, FindMContactIntroUI.class);
      }
      for (;;)
      {
        ((Intent)localObject).addFlags(67108864);
        ((Intent)localObject).putExtra("regsetinfo_ticket", this.fpr.dqS);
        ((Intent)localObject).putExtra("regsetinfo_NextStep", this.fpu);
        ((Intent)localObject).putExtra("regsetinfo_NextStyle", this.fpy);
        Intent localIntent = com.tencent.mm.plugin.account.a.a.eUR.aN(this.fpr.fpj);
        localIntent.addFlags(67108864);
        MMWizardActivity.b(this.fpr.fpj, (Intent)localObject, localIntent);
        this.fpr.fpj.finish();
        return;
        localObject = new Intent(this.fpr.fpj, FindMContactAlertUI.class);
        ((Intent)localObject).putExtra("alert_title", this.fpw);
        ((Intent)localObject).putExtra("alert_message", this.fpx);
      }
    }
    Object localObject = com.tencent.mm.plugin.account.a.a.eUR.aN(this.fpr.fpj);
    ((Intent)localObject).addFlags(67108864);
    this.fpr.fpj.startActivity((Intent)localObject);
    localObject = new StringBuilder();
    g.DN();
    localObject = ((StringBuilder)localObject).append(com.tencent.mm.kernel.a.Df()).append(",").append(this.fpr.fpj.getClass().getName()).append(",R200_900_phone,");
    g.DN();
    com.tencent.mm.plugin.b.a.qk(com.tencent.mm.kernel.a.gd("R200_900_phone") + ",4");
    this.fpr.fpj.finish();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.plugin.account.ui.o.5
 * JD-Core Version:    0.7.0.1
 */