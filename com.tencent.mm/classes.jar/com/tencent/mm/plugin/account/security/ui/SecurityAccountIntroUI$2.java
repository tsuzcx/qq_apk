package com.tencent.mm.plugin.account.security.ui;

import android.content.Intent;
import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.mm.plugin.account.a.a;
import com.tencent.mm.plugin.account.security.a.d;
import com.tencent.mm.pluginsdk.m;
import com.tencent.mm.protocal.GeneralControlWrapper;
import com.tencent.mm.protocal.JsapiPermissionWrapper;
import com.tencent.mm.sdk.platformtools.ae;
import com.tencent.mm.sdk.platformtools.bk;
import com.tencent.mm.sdk.platformtools.x;

final class SecurityAccountIntroUI$2
  implements View.OnClickListener
{
  SecurityAccountIntroUI$2(SecurityAccountIntroUI paramSecurityAccountIntroUI) {}
  
  public final void onClick(View paramView)
  {
    paramView = x.d(this.fkC.getSharedPreferences(ae.cqR(), 0));
    Intent localIntent = new Intent();
    if (bk.bl(SecurityAccountIntroUI.d(this.fkC))) {
      localIntent.putExtra("rawUrl", String.format("https://support.weixin.qq.com/cgi-bin/mmsupport-bin/readtemplate?lang=%s&t=w_unprotect&step=1&f=Android", new Object[] { paramView }));
    }
    for (;;)
    {
      localIntent.putExtra("useJs", true);
      localIntent.putExtra("vertical_scroll", true);
      localIntent.putExtra("title", this.fkC.getString(a.d.safe_device_protect_close));
      localIntent.putExtra("show_bottom", false);
      localIntent.putExtra("showShare", false);
      localIntent.putExtra("neverGetA8Key", true);
      localIntent.putExtra("hardcode_jspermission", JsapiPermissionWrapper.spm);
      localIntent.putExtra("hardcode_general_ctrl", GeneralControlWrapper.spj);
      a.eUR.j(localIntent, this.fkC);
      return;
      localIntent.putExtra("rawUrl", SecurityAccountIntroUI.d(this.fkC));
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.plugin.account.security.ui.SecurityAccountIntroUI.2
 * JD-Core Version:    0.7.0.1
 */