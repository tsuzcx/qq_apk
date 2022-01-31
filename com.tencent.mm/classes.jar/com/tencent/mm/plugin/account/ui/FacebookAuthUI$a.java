package com.tencent.mm.plugin.account.ui;

import android.app.ProgressDialog;
import android.os.Bundle;
import com.tencent.mm.ah.p;
import com.tencent.mm.kernel.e;
import com.tencent.mm.kernel.g;
import com.tencent.mm.plugin.account.friend.a.v;
import com.tencent.mm.sdk.platformtools.y;
import com.tencent.mm.storage.z;
import com.tencent.mm.ui.f.a.b;
import com.tencent.mm.ui.f.a.c;
import com.tencent.mm.ui.f.a.c.a;
import com.tencent.mm.ui.f.a.d;

final class FacebookAuthUI$a
  implements c.a
{
  private FacebookAuthUI$a(FacebookAuthUI paramFacebookAuthUI) {}
  
  public final void a(b paramb)
  {
    y.d("MicroMsg.FacebookAuthUI", "onError:" + paramb.getMessage());
    com.tencent.mm.ui.base.h.b(this.flI, paramb.getMessage(), this.flI.getString(q.j.contact_info_facebookapp_bind_fail), true);
    FacebookAuthUI.cy(false);
    com.tencent.mm.plugin.report.service.h.nFQ.a(582L, 3L, 1L, false);
  }
  
  public final void a(d paramd)
  {
    y.d("MicroMsg.FacebookAuthUI", "onFacebookError:" + paramd.vVV);
    com.tencent.mm.ui.base.h.b(this.flI, paramd.getMessage(), this.flI.getString(q.j.contact_info_facebookapp_bind_fail), true);
    FacebookAuthUI.cy(false);
    com.tencent.mm.plugin.report.service.h.nFQ.a(582L, 2L, 1L, false);
  }
  
  public final void l(Bundle paramBundle)
  {
    y.d("MicroMsg.FacebookAuthUI", "token:" + FacebookAuthUI.e(this.flI).faP);
    g.DP().Dz().o(65830, FacebookAuthUI.e(this.flI).faP);
    if (FacebookAuthUI.e(this.flI).vVO != 0L) {
      g.DP().Dz().o(65832, Long.valueOf(FacebookAuthUI.e(this.flI).vVO));
    }
    paramBundle = this.flI.getString(q.j.app_tip);
    String str = this.flI.getString(q.j.facebook_auth_binding);
    FacebookAuthUI.a(this.flI, ProgressDialog.show(this.flI, paramBundle, str, true));
    FacebookAuthUI.d(this.flI).setOnCancelListener(FacebookAuthUI.c(this.flI));
    FacebookAuthUI.a(this.flI, new v(1, FacebookAuthUI.e(this.flI).faP));
    g.Dk().a(FacebookAuthUI.a(this.flI), 0);
    FacebookAuthUI.cy(true);
    com.tencent.mm.plugin.report.service.h.nFQ.a(582L, 1L, 1L, false);
  }
  
  public final void onCancel()
  {
    y.d("MicroMsg.FacebookAuthUI", "onCancel");
    FacebookAuthUI.cy(false);
    com.tencent.mm.plugin.report.service.h.nFQ.a(582L, 4L, 1L, false);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.plugin.account.ui.FacebookAuthUI.a
 * JD-Core Version:    0.7.0.1
 */