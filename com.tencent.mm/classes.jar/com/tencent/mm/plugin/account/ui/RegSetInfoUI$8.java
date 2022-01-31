package com.tencent.mm.plugin.account.ui;

import android.content.Intent;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ai.m;
import com.tencent.mm.kernel.g;
import com.tencent.mm.model.av;
import com.tencent.mm.modelsimple.u;
import com.tencent.mm.plugin.account.bind.ui.FindMContactAlertUI;
import com.tencent.mm.plugin.account.bind.ui.FindMContactIntroUI;
import com.tencent.mm.pluginsdk.n;
import com.tencent.mm.ui.MMWizardActivity;

final class RegSetInfoUI$8
  implements Runnable
{
  RegSetInfoUI$8(RegSetInfoUI paramRegSetInfoUI, m paramm, String paramString1, String paramString2, boolean paramBoolean, String paramString3, String paramString4, int paramInt) {}
  
  public final void run()
  {
    AppMethodBeat.i(125513);
    RegSetInfoUI.b(this.gJQ, ((u)this.ckS).ajQ());
    av.flM.ao("login_user_name", this.gGC);
    com.tencent.mm.vfs.e.deleteFile(com.tencent.mm.compatible.util.e.esy + "temp.avatar");
    if ((this.gGQ != null) && (this.gGQ.contains("0")))
    {
      com.tencent.mm.plugin.b.a.xD("R300_100_phone");
      if (!this.gGR) {
        localObject = new Intent(this.gJQ, FindMContactIntroUI.class);
      }
      for (;;)
      {
        ((Intent)localObject).addFlags(67108864);
        ((Intent)localObject).putExtra("regsetinfo_ticket", RegSetInfoUI.g(this.gJQ));
        ((Intent)localObject).putExtra("regsetinfo_NextStep", this.gGQ);
        ((Intent)localObject).putExtra("regsetinfo_NextStyle", this.gGU);
        Intent localIntent = com.tencent.mm.plugin.account.a.a.gmO.bm(this.gJQ);
        localIntent.addFlags(67108864);
        MMWizardActivity.b(this.gJQ, (Intent)localObject, localIntent);
        this.gJQ.finish();
        AppMethodBeat.o(125513);
        return;
        localObject = new Intent(this.gJQ, FindMContactAlertUI.class);
        ((Intent)localObject).putExtra("alert_title", this.gGS);
        ((Intent)localObject).putExtra("alert_message", this.gGT);
      }
    }
    Object localObject = com.tencent.mm.plugin.account.a.a.gmO.bm(this.gJQ);
    ((Intent)localObject).addFlags(67108864);
    this.gJQ.startActivity((Intent)localObject);
    localObject = new StringBuilder();
    g.RJ();
    localObject = ((StringBuilder)localObject).append(com.tencent.mm.kernel.a.QX()).append(",").append(this.gJQ.getClass().getName()).append(",R200_900_phone,");
    g.RJ();
    com.tencent.mm.plugin.b.a.xE(com.tencent.mm.kernel.a.mx("R200_900_phone") + ",4");
    this.gJQ.finish();
    AppMethodBeat.o(125513);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.plugin.account.ui.RegSetInfoUI.8
 * JD-Core Version:    0.7.0.1
 */