package com.tencent.mm.plugin.account.security.ui;

import android.content.Intent;
import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.account.a.a;
import com.tencent.mm.pluginsdk.n;
import com.tencent.mm.protocal.GeneralControlWrapper;
import com.tencent.mm.protocal.JsapiPermissionWrapper;
import com.tencent.mm.sdk.platformtools.aa;
import com.tencent.mm.sdk.platformtools.ah;
import com.tencent.mm.sdk.platformtools.bo;

final class SecurityAccountIntroUI$2
  implements View.OnClickListener
{
  SecurityAccountIntroUI$2(SecurityAccountIntroUI paramSecurityAccountIntroUI) {}
  
  public final void onClick(View paramView)
  {
    AppMethodBeat.i(69905);
    paramView = aa.f(this.gBT.getSharedPreferences(ah.dsP(), 0));
    Intent localIntent = new Intent();
    if (bo.isNullOrNil(SecurityAccountIntroUI.d(this.gBT))) {
      localIntent.putExtra("rawUrl", String.format("https://support.weixin.qq.com/cgi-bin/mmsupport-bin/readtemplate?lang=%s&t=w_unprotect&step=1&f=Android", new Object[] { paramView }));
    }
    for (;;)
    {
      localIntent.putExtra("useJs", true);
      localIntent.putExtra("vertical_scroll", true);
      localIntent.putExtra("title", this.gBT.getString(2131302855));
      localIntent.putExtra("show_bottom", false);
      localIntent.putExtra("showShare", false);
      localIntent.putExtra("neverGetA8Key", true);
      localIntent.putExtra("hardcode_jspermission", JsapiPermissionWrapper.wib);
      localIntent.putExtra("hardcode_general_ctrl", GeneralControlWrapper.whX);
      a.gmO.i(localIntent, this.gBT);
      AppMethodBeat.o(69905);
      return;
      localIntent.putExtra("rawUrl", SecurityAccountIntroUI.d(this.gBT));
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.plugin.account.security.ui.SecurityAccountIntroUI.2
 * JD-Core Version:    0.7.0.1
 */