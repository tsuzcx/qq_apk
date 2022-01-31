package com.tencent.mm.plugin.account.ui;

import android.content.Intent;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ai.m;
import com.tencent.mm.kernel.g;
import com.tencent.mm.model.av;
import com.tencent.mm.modelsimple.u;
import com.tencent.mm.pluginsdk.n;

final class MobileLoginOrForceReg$5
  implements Runnable
{
  MobileLoginOrForceReg$5(MobileLoginOrForceReg paramMobileLoginOrForceReg, m paramm, String paramString) {}
  
  public final void run()
  {
    AppMethodBeat.i(125208);
    MobileLoginOrForceReg.a(this.gGw, ((u)this.ckS).ajQ());
    av.flM.ao("login_user_name", this.gGC);
    com.tencent.mm.vfs.e.deleteFile(com.tencent.mm.compatible.util.e.esy + "temp.avatar");
    Object localObject = com.tencent.mm.plugin.account.a.a.gmO.bm(this.gGw);
    ((Intent)localObject).addFlags(67108864);
    this.gGw.startActivity((Intent)localObject);
    localObject = new StringBuilder();
    g.RJ();
    localObject = ((StringBuilder)localObject).append(com.tencent.mm.kernel.a.QX()).append(",").append(getClass().getName()).append(",R200_600,");
    g.RJ();
    com.tencent.mm.plugin.b.a.xE(com.tencent.mm.kernel.a.mx("R200_600") + ",4");
    this.gGw.finish();
    AppMethodBeat.o(125208);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.plugin.account.ui.MobileLoginOrForceReg.5
 * JD-Core Version:    0.7.0.1
 */