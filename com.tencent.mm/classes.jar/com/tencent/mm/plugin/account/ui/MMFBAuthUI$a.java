package com.tencent.mm.plugin.account.ui;

import android.os.Bundle;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.storage.aq;
import com.tencent.mm.ui.base.k;
import com.tencent.mm.ui.mmfb.sdk.e;
import com.tencent.mm.ui.mmfb.sdk.f.a;

final class MMFBAuthUI$a
  implements f.a
{
  private MMFBAuthUI$a(MMFBAuthUI paramMMFBAuthUI) {}
  
  public final void T(Bundle paramBundle)
  {
    AppMethodBeat.i(304914);
    MMFBAuthUI.a(this.qbO, MMFBAuthUI.e(this.qbO).pNX);
    com.tencent.mm.kernel.h.baE().ban().B(65830, MMFBAuthUI.f(this.qbO));
    if (MMFBAuthUI.e(this.qbO).afzb != 0L) {
      com.tencent.mm.kernel.h.baE().ban().B(65832, Long.valueOf(MMFBAuthUI.e(this.qbO).afzb));
    }
    MMFBAuthUI.g(this.qbO);
    AppMethodBeat.o(304914);
  }
  
  public final void a(e parame)
  {
    AppMethodBeat.i(304916);
    Log.d("MicroMsg.FacebookAuthUI", "onError:" + parame.getMessage());
    k.c(this.qbO, parame.getMessage(), this.qbO.getString(r.j.contact_info_facebookapp_bind_fail), true);
    MMFBAuthUI.bYh();
    com.tencent.mm.plugin.report.service.h.OAn.idkeyStat(582L, 3L, 1L, false);
    AppMethodBeat.o(304916);
  }
  
  public final void a(com.tencent.mm.ui.mmfb.sdk.h paramh)
  {
    AppMethodBeat.i(304915);
    Log.d("MicroMsg.FacebookAuthUI", "onFacebookError:" + paramh.afzj);
    k.c(this.qbO, paramh.getMessage(), this.qbO.getString(r.j.contact_info_facebookapp_bind_fail), true);
    MMFBAuthUI.bYh();
    com.tencent.mm.plugin.report.service.h.OAn.idkeyStat(582L, 2L, 1L, false);
    AppMethodBeat.o(304915);
  }
  
  public final void onCancel()
  {
    AppMethodBeat.i(304917);
    Log.d("MicroMsg.FacebookAuthUI", "onCancel");
    MMFBAuthUI.bYh();
    com.tencent.mm.plugin.report.service.h.OAn.idkeyStat(582L, 4L, 1L, false);
    AppMethodBeat.o(304917);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.plugin.account.ui.MMFBAuthUI.a
 * JD-Core Version:    0.7.0.1
 */