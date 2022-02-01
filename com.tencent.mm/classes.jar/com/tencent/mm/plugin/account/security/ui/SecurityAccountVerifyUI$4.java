package com.tencent.mm.plugin.account.security.ui;

import android.content.Intent;
import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.kernel.g;
import com.tencent.mm.pluginsdk.l;
import com.tencent.mm.protocal.GeneralControlWrapper;
import com.tencent.mm.protocal.JsapiPermissionWrapper;
import com.tencent.mm.sdk.platformtools.ab;
import com.tencent.mm.sdk.platformtools.ai;

final class SecurityAccountVerifyUI$4
  implements View.OnClickListener
{
  SecurityAccountVerifyUI$4(SecurityAccountVerifyUI paramSecurityAccountVerifyUI) {}
  
  public final void onClick(View paramView)
  {
    AppMethodBeat.i(125601);
    paramView = new StringBuilder();
    g.agP();
    paramView = paramView.append(com.tencent.mm.kernel.a.agc()).append(",").append(getClass().getName()).append(",L600_300,");
    g.agP();
    com.tencent.mm.plugin.b.a.sv(com.tencent.mm.kernel.a.uc("L600_300") + ",1");
    paramView = ab.f(this.iPC.getSharedPreferences(ai.eUX(), 0));
    Intent localIntent = new Intent();
    localIntent.putExtra("rawUrl", String.format("https://support.weixin.qq.com/cgi-bin/mmsupport-bin/readtemplate?lang=%s&t=w_unprotect&step=1&f=Android", new Object[] { paramView }));
    localIntent.putExtra("useJs", true);
    localIntent.putExtra("vertical_scroll", true);
    localIntent.putExtra("title", this.iPC.getString(2131762767));
    localIntent.putExtra("show_bottom", false);
    localIntent.putExtra("showShare", false);
    localIntent.putExtra("neverGetA8Key", true);
    localIntent.putExtra("hardcode_jspermission", JsapiPermissionWrapper.DIw);
    localIntent.putExtra("hardcode_general_ctrl", GeneralControlWrapper.DIs);
    com.tencent.mm.plugin.account.a.a.iyx.i(localIntent, this.iPC);
    AppMethodBeat.o(125601);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.plugin.account.security.ui.SecurityAccountVerifyUI.4
 * JD-Core Version:    0.7.0.1
 */