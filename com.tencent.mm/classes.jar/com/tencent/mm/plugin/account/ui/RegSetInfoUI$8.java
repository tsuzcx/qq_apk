package com.tencent.mm.plugin.account.ui;

import android.content.Intent;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.al.n;
import com.tencent.mm.kernel.g;
import com.tencent.mm.loader.j.b;
import com.tencent.mm.model.az;
import com.tencent.mm.modelsimple.u;
import com.tencent.mm.plugin.account.bind.ui.FindMContactAlertUI;
import com.tencent.mm.plugin.account.bind.ui.FindMContactIntroUI;
import com.tencent.mm.pluginsdk.m;
import com.tencent.mm.ui.MMWizardActivity;
import com.tencent.mm.vfs.i;

final class RegSetInfoUI$8
  implements Runnable
{
  RegSetInfoUI$8(RegSetInfoUI paramRegSetInfoUI, n paramn, String paramString1, String paramString2, boolean paramBoolean, String paramString3, String paramString4, int paramInt) {}
  
  public final void run()
  {
    AppMethodBeat.i(128674);
    RegSetInfoUI.b(this.jqJ, ((u)this.diy).aKV());
    az.hFS.aM("login_user_name", this.jnr);
    i.deleteFile(b.asc() + "temp.avatar");
    if ((this.jnF != null) && (this.jnF.contains("0")))
    {
      com.tencent.mm.plugin.b.a.Ma("R300_100_phone");
      if (!this.jnG) {
        localObject1 = new Intent(this.jqJ, FindMContactIntroUI.class);
      }
      for (;;)
      {
        ((Intent)localObject1).addFlags(67108864);
        ((Intent)localObject1).putExtra("regsetinfo_ticket", RegSetInfoUI.g(this.jqJ));
        ((Intent)localObject1).putExtra("regsetinfo_NextStep", this.jnF);
        ((Intent)localObject1).putExtra("regsetinfo_NextStyle", this.jnJ);
        localObject2 = com.tencent.mm.plugin.account.a.a.iRG.bC(this.jqJ);
        ((Intent)localObject2).addFlags(67108864);
        MMWizardActivity.b(this.jqJ, (Intent)localObject1, (Intent)localObject2);
        this.jqJ.finish();
        AppMethodBeat.o(128674);
        return;
        localObject1 = new Intent(this.jqJ, FindMContactAlertUI.class);
        ((Intent)localObject1).putExtra("alert_title", this.jnH);
        ((Intent)localObject1).putExtra("alert_message", this.jnI);
      }
    }
    Object localObject2 = com.tencent.mm.plugin.account.a.a.iRG.bC(this.jqJ);
    ((Intent)localObject2).addFlags(67108864);
    Object localObject1 = this.jqJ;
    localObject2 = new com.tencent.mm.hellhoundlib.b.a().bc(localObject2);
    com.tencent.mm.hellhoundlib.a.a.a(localObject1, ((com.tencent.mm.hellhoundlib.b.a)localObject2).ahp(), "com/tencent/mm/plugin/account/ui/RegSetInfoUI$16", "run", "()V", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
    ((RegSetInfoUI)localObject1).startActivity((Intent)((com.tencent.mm.hellhoundlib.b.a)localObject2).mq(0));
    com.tencent.mm.hellhoundlib.a.a.a(localObject1, "com/tencent/mm/plugin/account/ui/RegSetInfoUI$16", "run", "()V", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
    localObject1 = new StringBuilder();
    g.ajA();
    localObject1 = ((StringBuilder)localObject1).append(com.tencent.mm.kernel.a.aiO()).append(",").append(this.jqJ.getClass().getName()).append(",R200_900_phone,");
    g.ajA();
    com.tencent.mm.plugin.b.a.vk(com.tencent.mm.kernel.a.wS("R200_900_phone") + ",4");
    this.jqJ.finish();
    AppMethodBeat.o(128674);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.plugin.account.ui.RegSetInfoUI.8
 * JD-Core Version:    0.7.0.1
 */