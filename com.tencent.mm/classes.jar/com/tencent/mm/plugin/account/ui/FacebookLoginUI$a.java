package com.tencent.mm.plugin.account.ui;

import android.os.Bundle;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.kernel.g;
import com.tencent.mm.sdk.platformtools.ab;
import com.tencent.mm.ui.g.a.b;
import com.tencent.mm.ui.g.a.c;
import com.tencent.mm.ui.g.a.c.a;
import com.tencent.mm.ui.g.a.e;

final class FacebookLoginUI$a
  implements c.a
{
  private FacebookLoginUI$a(FacebookLoginUI paramFacebookLoginUI) {}
  
  public final void a(b paramb)
  {
    AppMethodBeat.i(124847);
    ab.d("MicroMsg.FacebookLoginUI", "onError:" + paramb.getMessage());
    com.tencent.mm.ui.base.h.b(this.gDq, paramb.getMessage(), this.gDq.getString(2131299621), true);
    FacebookLoginUI.aro();
    paramb = new StringBuilder();
    g.RJ();
    paramb = paramb.append(com.tencent.mm.kernel.a.QX()).append(",").append(this.gDq.getClass().getName()).append(",L14,");
    g.RJ();
    com.tencent.mm.plugin.b.a.xE(com.tencent.mm.kernel.a.mx("L14") + ",2");
    com.tencent.mm.plugin.report.service.h.qsU.idkeyStat(582L, 8L, 1L, false);
    AppMethodBeat.o(124847);
  }
  
  public final void a(e parame)
  {
    AppMethodBeat.i(124846);
    ab.d("MicroMsg.FacebookLoginUI", "onFacebookError:" + parame.getMessage());
    com.tencent.mm.ui.base.h.b(this.gDq, parame.getMessage(), this.gDq.getString(2131299621), true);
    FacebookLoginUI.aro();
    parame = new StringBuilder();
    g.RJ();
    parame = parame.append(com.tencent.mm.kernel.a.QX()).append(",").append(this.gDq.getClass().getName()).append(",L14,");
    g.RJ();
    com.tencent.mm.plugin.b.a.xE(com.tencent.mm.kernel.a.mx("L14") + ",2");
    com.tencent.mm.plugin.report.service.h.qsU.idkeyStat(582L, 7L, 1L, false);
    AppMethodBeat.o(124846);
  }
  
  public final void onCancel()
  {
    AppMethodBeat.i(124848);
    ab.d("MicroMsg.FacebookLoginUI", "onCancel");
    FacebookLoginUI.aro();
    StringBuilder localStringBuilder = new StringBuilder();
    g.RJ();
    localStringBuilder = localStringBuilder.append(com.tencent.mm.kernel.a.QX()).append(",").append(this.gDq.getClass().getName()).append(",L14,");
    g.RJ();
    com.tencent.mm.plugin.b.a.xE(com.tencent.mm.kernel.a.mx("L14") + ",2");
    com.tencent.mm.plugin.report.service.h.qsU.idkeyStat(582L, 9L, 1L, false);
    AppMethodBeat.o(124848);
  }
  
  public final void u(Bundle paramBundle)
  {
    AppMethodBeat.i(124845);
    FacebookLoginUI.a(this.gDq, FacebookLoginUI.d(this.gDq).gsH);
    FacebookLoginUI.b(this.gDq);
    AppMethodBeat.o(124845);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes8.jar
 * Qualified Name:     com.tencent.mm.plugin.account.ui.FacebookLoginUI.a
 * JD-Core Version:    0.7.0.1
 */