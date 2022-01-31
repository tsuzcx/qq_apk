package com.tencent.mm.plugin.account.ui;

import android.content.Intent;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.kernel.g;
import com.tencent.mm.pluginsdk.n;

final class RegByMobileRegAIOUI$13
  implements Runnable
{
  RegByMobileRegAIOUI$13(RegByMobileRegAIOUI paramRegByMobileRegAIOUI) {}
  
  public final void run()
  {
    AppMethodBeat.i(152595);
    Object localObject = com.tencent.mm.plugin.account.a.a.gmO.bm(this.gIh);
    ((Intent)localObject).addFlags(67108864);
    this.gIh.startActivity((Intent)localObject);
    localObject = new StringBuilder();
    g.RJ();
    localObject = ((StringBuilder)localObject).append(com.tencent.mm.kernel.a.QX()).append(",").append(this.gIh.getClass().getName()).append(",L14,");
    g.RJ();
    com.tencent.mm.plugin.b.a.xE(com.tencent.mm.kernel.a.mx("L14") + ",4");
    this.gIh.finish();
    AppMethodBeat.o(152595);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.plugin.account.ui.RegByMobileRegAIOUI.13
 * JD-Core Version:    0.7.0.1
 */