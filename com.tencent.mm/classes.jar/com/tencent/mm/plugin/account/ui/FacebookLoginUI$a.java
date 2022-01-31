package com.tencent.mm.plugin.account.ui;

import android.app.ProgressDialog;
import android.os.Bundle;
import com.tencent.mm.ah.p;
import com.tencent.mm.kernel.g;
import com.tencent.mm.modelsimple.q;
import com.tencent.mm.sdk.platformtools.y;
import com.tencent.mm.ui.f.a.b;
import com.tencent.mm.ui.f.a.c;
import com.tencent.mm.ui.f.a.c.a;
import com.tencent.mm.ui.f.a.d;

final class FacebookLoginUI$a
  implements c.a
{
  private FacebookLoginUI$a(FacebookLoginUI paramFacebookLoginUI) {}
  
  public final void a(b paramb)
  {
    y.d("MicroMsg.FacebookLoginUI", "onError:" + paramb.getMessage());
    com.tencent.mm.ui.base.h.b(this.flX, paramb.getMessage(), this.flX.getString(q.j.contact_info_facebookapp_bind_fail), true);
    FacebookLoginUI.cz(false);
    paramb = new StringBuilder();
    g.DN();
    paramb = paramb.append(com.tencent.mm.kernel.a.Df()).append(",").append(this.flX.getClass().getName()).append(",L14,");
    g.DN();
    com.tencent.mm.plugin.b.a.qk(com.tencent.mm.kernel.a.gd("L14") + ",2");
    com.tencent.mm.plugin.report.service.h.nFQ.a(582L, 8L, 1L, false);
  }
  
  public final void a(d paramd)
  {
    y.d("MicroMsg.FacebookLoginUI", "onFacebookError:" + paramd.vVV);
    com.tencent.mm.ui.base.h.b(this.flX, paramd.getMessage(), this.flX.getString(q.j.contact_info_facebookapp_bind_fail), true);
    FacebookLoginUI.cz(false);
    paramd = new StringBuilder();
    g.DN();
    paramd = paramd.append(com.tencent.mm.kernel.a.Df()).append(",").append(this.flX.getClass().getName()).append(",L14,");
    g.DN();
    com.tencent.mm.plugin.b.a.qk(com.tencent.mm.kernel.a.gd("L14") + ",2");
    com.tencent.mm.plugin.report.service.h.nFQ.a(582L, 7L, 1L, false);
  }
  
  public final void l(Bundle paramBundle)
  {
    paramBundle = this.flX.getString(q.j.app_tip);
    String str = this.flX.getString(q.j.facebook_auth_binding);
    FacebookLoginUI.a(this.flX, ProgressDialog.show(this.flX, paramBundle, str, true));
    FacebookLoginUI.e(this.flX).setOnCancelListener(FacebookLoginUI.d(this.flX));
    FacebookLoginUI.a(this.flX, FacebookLoginUI.f(this.flX).faP);
    y.i("MicroMsg.FacebookLoginUI", "dkwt Ready to Facebook auth user[%s] token[%d][%s]", new Object[] { "facebook@wechat_auth", Integer.valueOf(FacebookLoginUI.a(this.flX).length()), FacebookLoginUI.a(this.flX).substring(0, 4) });
    FacebookLoginUI.a(this.flX, new q("facebook@wechat_auth", FacebookLoginUI.a(this.flX), 0, "", "", "", 0, "", true, false));
    g.Dk().a(FacebookLoginUI.b(this.flX), 0);
    FacebookLoginUI.cz(true);
    paramBundle = new StringBuilder();
    g.DN();
    paramBundle = paramBundle.append(com.tencent.mm.kernel.a.Df()).append(",").append(this.flX.getClass().getName()).append(",L14,");
    g.DN();
    com.tencent.mm.plugin.b.a.qk(com.tencent.mm.kernel.a.gd("L14") + ",2");
    com.tencent.mm.plugin.report.service.h.nFQ.a(582L, 6L, 1L, false);
  }
  
  public final void onCancel()
  {
    y.d("MicroMsg.FacebookLoginUI", "onCancel");
    FacebookLoginUI.cz(false);
    StringBuilder localStringBuilder = new StringBuilder();
    g.DN();
    localStringBuilder = localStringBuilder.append(com.tencent.mm.kernel.a.Df()).append(",").append(this.flX.getClass().getName()).append(",L14,");
    g.DN();
    com.tencent.mm.plugin.b.a.qk(com.tencent.mm.kernel.a.gd("L14") + ",2");
    com.tencent.mm.plugin.report.service.h.nFQ.a(582L, 9L, 1L, false);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes8.jar
 * Qualified Name:     com.tencent.mm.plugin.account.ui.FacebookLoginUI.a
 * JD-Core Version:    0.7.0.1
 */