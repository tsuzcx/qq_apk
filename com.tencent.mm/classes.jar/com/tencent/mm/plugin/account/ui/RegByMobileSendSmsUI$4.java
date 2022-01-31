package com.tencent.mm.plugin.account.ui;

import android.content.Intent;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.kernel.g;
import com.tencent.mm.model.av;
import com.tencent.mm.modelsimple.u;
import com.tencent.mm.pluginsdk.n;

final class RegByMobileSendSmsUI$4
  implements Runnable
{
  RegByMobileSendSmsUI$4(RegByMobileSendSmsUI paramRegByMobileSendSmsUI, u paramu, String paramString) {}
  
  public final void run()
  {
    AppMethodBeat.i(125401);
    RegByMobileSendSmsUI.a(this.gIu, this.gIv.ajQ());
    av.flM.ao("login_user_name", this.gGC);
    com.tencent.mm.vfs.e.deleteFile(com.tencent.mm.compatible.util.e.esy + "temp.avatar");
    Object localObject = com.tencent.mm.plugin.account.a.a.gmO.bm(this.gIu);
    ((Intent)localObject).addFlags(67108864);
    this.gIu.startActivity((Intent)localObject);
    localObject = new StringBuilder();
    g.RJ();
    localObject = ((StringBuilder)localObject).append(com.tencent.mm.kernel.a.QX()).append(",").append(getClass().getName()).append(",R200_600,");
    g.RJ();
    com.tencent.mm.plugin.b.a.xE(com.tencent.mm.kernel.a.mx("R200_600") + ",4");
    this.gIu.finish();
    AppMethodBeat.o(125401);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.mm.plugin.account.ui.RegByMobileSendSmsUI.4
 * JD-Core Version:    0.7.0.1
 */