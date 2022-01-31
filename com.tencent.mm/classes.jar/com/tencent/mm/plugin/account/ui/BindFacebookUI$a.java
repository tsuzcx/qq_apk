package com.tencent.mm.plugin.account.ui;

import android.app.ProgressDialog;
import android.os.Bundle;
import com.tencent.mm.ah.p;
import com.tencent.mm.kernel.e;
import com.tencent.mm.kernel.g;
import com.tencent.mm.plugin.account.friend.a.v;
import com.tencent.mm.sdk.platformtools.y;
import com.tencent.mm.storage.z;
import com.tencent.mm.ui.base.h;
import com.tencent.mm.ui.f.a.b;
import com.tencent.mm.ui.f.a.c;
import com.tencent.mm.ui.f.a.c.a;
import com.tencent.mm.ui.f.a.d;

final class BindFacebookUI$a
  implements c.a
{
  private BindFacebookUI$a(BindFacebookUI paramBindFacebookUI) {}
  
  public final void a(b paramb)
  {
    y.d("MicroMsg.BindFacebookUI", "onError:" + paramb.getMessage());
    h.b(this.flf, paramb.getMessage(), this.flf.getString(q.j.contact_info_facebookapp_bind_fail), true);
    BindFacebookUI.cx(false);
  }
  
  public final void a(d paramd)
  {
    y.d("MicroMsg.BindFacebookUI", "onFacebookError:" + paramd.vVV);
    h.b(this.flf, paramd.getMessage(), this.flf.getString(q.j.contact_info_facebookapp_bind_fail), true);
    BindFacebookUI.cx(false);
  }
  
  public final void l(Bundle paramBundle)
  {
    y.d("MicroMsg.BindFacebookUI", "token:" + BindFacebookUI.c(this.flf).faP);
    g.DP().Dz().o(65830, BindFacebookUI.c(this.flf).faP);
    if (BindFacebookUI.c(this.flf).vVO != 0L) {
      g.DP().Dz().o(65832, Long.valueOf(BindFacebookUI.c(this.flf).vVO));
    }
    paramBundle = this.flf.getString(q.j.app_tip);
    String str = this.flf.getString(q.j.facebook_auth_binding);
    BindFacebookUI.a(this.flf, ProgressDialog.show(this.flf, paramBundle, str, true));
    BindFacebookUI.e(this.flf).setOnCancelListener(BindFacebookUI.d(this.flf));
    BindFacebookUI.a(this.flf, new v(1, BindFacebookUI.c(this.flf).faP));
    g.Dk().a(BindFacebookUI.a(this.flf), 0);
    BindFacebookUI.cx(true);
  }
  
  public final void onCancel()
  {
    y.d("MicroMsg.BindFacebookUI", "onCancel");
    BindFacebookUI.cx(false);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.plugin.account.ui.BindFacebookUI.a
 * JD-Core Version:    0.7.0.1
 */