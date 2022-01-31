package com.tencent.mm.plugin.account.ui;

import android.os.Bundle;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.kernel.g;
import com.tencent.mm.sdk.platformtools.ab;
import com.tencent.mm.storage.z;
import com.tencent.mm.ui.g.a.b;
import com.tencent.mm.ui.g.a.c;
import com.tencent.mm.ui.g.a.c.a;

final class FacebookAuthUI$a
  implements c.a
{
  private FacebookAuthUI$a(FacebookAuthUI paramFacebookAuthUI) {}
  
  public final void a(b paramb)
  {
    AppMethodBeat.i(124785);
    ab.d("MicroMsg.FacebookAuthUI", "onError:" + paramb.getMessage());
    com.tencent.mm.ui.base.h.b(this.gDa, paramb.getMessage(), this.gDa.getString(2131298597), true);
    FacebookAuthUI.ark();
    com.tencent.mm.plugin.report.service.h.qsU.idkeyStat(582L, 3L, 1L, false);
    AppMethodBeat.o(124785);
  }
  
  public final void a(com.tencent.mm.ui.g.a.e parame)
  {
    AppMethodBeat.i(124784);
    ab.d("MicroMsg.FacebookAuthUI", "onFacebookError:" + parame.Aoe);
    com.tencent.mm.ui.base.h.b(this.gDa, parame.getMessage(), this.gDa.getString(2131298597), true);
    FacebookAuthUI.ark();
    com.tencent.mm.plugin.report.service.h.qsU.idkeyStat(582L, 2L, 1L, false);
    AppMethodBeat.o(124784);
  }
  
  public final void onCancel()
  {
    AppMethodBeat.i(124786);
    ab.d("MicroMsg.FacebookAuthUI", "onCancel");
    FacebookAuthUI.ark();
    com.tencent.mm.plugin.report.service.h.qsU.idkeyStat(582L, 4L, 1L, false);
    AppMethodBeat.o(124786);
  }
  
  public final void u(Bundle paramBundle)
  {
    AppMethodBeat.i(124783);
    FacebookAuthUI.a(this.gDa, FacebookAuthUI.g(this.gDa).gsH);
    g.RL().Ru().set(65830, FacebookAuthUI.h(this.gDa));
    if (FacebookAuthUI.g(this.gDa).AnR != 0L) {
      g.RL().Ru().set(65832, Long.valueOf(FacebookAuthUI.g(this.gDa).AnR));
    }
    FacebookAuthUI.d(this.gDa);
    AppMethodBeat.o(124783);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.plugin.account.ui.FacebookAuthUI.a
 * JD-Core Version:    0.7.0.1
 */