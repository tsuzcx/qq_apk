package com.tencent.mm.plugin.account.ui;

import android.os.Bundle;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.kernel.b;
import com.tencent.mm.plugin.b.a;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.ui.base.k;
import com.tencent.mm.ui.mmfb.sdk.e;
import com.tencent.mm.ui.mmfb.sdk.f;
import com.tencent.mm.ui.mmfb.sdk.f.a;

final class MMFBLoginUI$a
  implements f.a
{
  private MMFBLoginUI$a(MMFBLoginUI paramMMFBLoginUI) {}
  
  public final void T(Bundle paramBundle)
  {
    AppMethodBeat.i(305147);
    MMFBLoginUI.a(this.qcb, MMFBLoginUI.a(this.qcb).pNX);
    MMFBLoginUI.g(this.qcb);
    AppMethodBeat.o(305147);
  }
  
  public final void a(e parame)
  {
    AppMethodBeat.i(305152);
    Log.d("MicroMsg.FacebookLoginUI", "onError:" + parame.getMessage());
    k.c(this.qcb, parame.getMessage(), this.qcb.getString(r.j.facebook_auth_failed), true);
    MMFBLoginUI.bYj();
    parame = new StringBuilder();
    com.tencent.mm.kernel.h.baC();
    parame = parame.append(b.aZR()).append(",").append(this.qcb.getClass().getName()).append(",L14,");
    com.tencent.mm.kernel.h.baC();
    a.Du(b.Fw("L14") + ",2");
    com.tencent.mm.plugin.report.service.h.OAn.idkeyStat(582L, 8L, 1L, false);
    AppMethodBeat.o(305152);
  }
  
  public final void a(com.tencent.mm.ui.mmfb.sdk.h paramh)
  {
    AppMethodBeat.i(305149);
    Log.d("MicroMsg.FacebookLoginUI", "onFacebookError:" + paramh.getMessage());
    k.c(this.qcb, paramh.getMessage(), this.qcb.getString(r.j.facebook_auth_failed), true);
    MMFBLoginUI.bYj();
    paramh = new StringBuilder();
    com.tencent.mm.kernel.h.baC();
    paramh = paramh.append(b.aZR()).append(",").append(this.qcb.getClass().getName()).append(",L14,");
    com.tencent.mm.kernel.h.baC();
    a.Du(b.Fw("L14") + ",2");
    com.tencent.mm.plugin.report.service.h.OAn.idkeyStat(582L, 7L, 1L, false);
    AppMethodBeat.o(305149);
  }
  
  public final void onCancel()
  {
    AppMethodBeat.i(305156);
    Log.d("MicroMsg.FacebookLoginUI", "onCancel");
    MMFBLoginUI.bYj();
    StringBuilder localStringBuilder = new StringBuilder();
    com.tencent.mm.kernel.h.baC();
    localStringBuilder = localStringBuilder.append(b.aZR()).append(",").append(this.qcb.getClass().getName()).append(",L14,");
    com.tencent.mm.kernel.h.baC();
    a.Du(b.Fw("L14") + ",2");
    com.tencent.mm.plugin.report.service.h.OAn.idkeyStat(582L, 9L, 1L, false);
    AppMethodBeat.o(305156);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.plugin.account.ui.MMFBLoginUI.a
 * JD-Core Version:    0.7.0.1
 */