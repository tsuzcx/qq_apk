package com.tencent.mm.plugin.account.security.ui;

import android.content.Intent;
import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.hellhoundlib.b.b;
import com.tencent.mm.kernel.g;
import com.tencent.mm.pluginsdk.m;
import com.tencent.mm.protocal.GeneralControlWrapper;
import com.tencent.mm.protocal.JsapiPermissionWrapper;
import com.tencent.mm.sdk.platformtools.ad;
import com.tencent.mm.sdk.platformtools.ak;

final class SecurityAccountVerifyUI$4
  implements View.OnClickListener
{
  SecurityAccountVerifyUI$4(SecurityAccountVerifyUI paramSecurityAccountVerifyUI) {}
  
  public final void onClick(View paramView)
  {
    AppMethodBeat.i(125601);
    Object localObject = new b();
    ((b)localObject).bd(paramView);
    com.tencent.mm.hellhoundlib.a.a.b("com/tencent/mm/plugin/account/security/ui/SecurityAccountVerifyUI$4", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, ((b)localObject).ahF());
    paramView = new StringBuilder();
    g.ajP();
    paramView = paramView.append(com.tencent.mm.kernel.a.ajd()).append(",").append(getClass().getName()).append(",L600_300,");
    g.ajP();
    com.tencent.mm.plugin.b.a.vG(com.tencent.mm.kernel.a.xB("L600_300") + ",1");
    paramView = ad.f(this.jlD.getSharedPreferences(ak.fow(), 0));
    localObject = new Intent();
    ((Intent)localObject).putExtra("rawUrl", String.format("https://support.weixin.qq.com/cgi-bin/mmsupport-bin/readtemplate?lang=%s&t=w_unprotect&step=1&f=Android", new Object[] { paramView }));
    ((Intent)localObject).putExtra("useJs", true);
    ((Intent)localObject).putExtra("vertical_scroll", true);
    ((Intent)localObject).putExtra("title", this.jlD.getString(2131762767));
    ((Intent)localObject).putExtra("show_bottom", false);
    ((Intent)localObject).putExtra("showShare", false);
    ((Intent)localObject).putExtra("neverGetA8Key", true);
    ((Intent)localObject).putExtra("hardcode_jspermission", JsapiPermissionWrapper.FGb);
    ((Intent)localObject).putExtra("hardcode_general_ctrl", GeneralControlWrapper.FFX);
    com.tencent.mm.plugin.account.a.a.iUz.i((Intent)localObject, this.jlD);
    com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/account/security/ui/SecurityAccountVerifyUI$4", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
    AppMethodBeat.o(125601);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.plugin.account.security.ui.SecurityAccountVerifyUI.4
 * JD-Core Version:    0.7.0.1
 */