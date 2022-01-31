package com.tencent.mm.plugin.account.ui;

import android.content.Context;
import android.content.Intent;
import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.mm.plugin.account.a.a;
import com.tencent.mm.pluginsdk.m;
import com.tencent.mm.protocal.GeneralControlWrapper;
import com.tencent.mm.protocal.JsapiPermissionWrapper;
import com.tencent.mm.protocal.d;
import com.tencent.mm.sdk.platformtools.x;

final class WelcomeSelectView$3
  implements View.OnClickListener
{
  WelcomeSelectView$3(WelcomeSelectView paramWelcomeSelectView, Context paramContext) {}
  
  public final void onClick(View paramView)
  {
    if (d.spd)
    {
      paramView = this.val$context.getString(q.j.create_forbiden_uri, new Object[] { "0x" + Integer.toHexString(d.spa), x.cqJ() });
      Intent localIntent = new Intent();
      localIntent.putExtra("rawUrl", paramView);
      localIntent.putExtra("showShare", false);
      localIntent.putExtra("show_bottom", false);
      localIntent.putExtra("needRedirect", false);
      localIntent.putExtra("neverGetA8Key", true);
      localIntent.putExtra("hardcode_jspermission", JsapiPermissionWrapper.spm);
      localIntent.putExtra("hardcode_general_ctrl", GeneralControlWrapper.spj);
      a.eUR.j(localIntent, this.val$context);
      return;
    }
    paramView = new Intent(this.val$context, RegByMobileRegAIOUI.class);
    paramView.putExtra("login_type", 0);
    this.val$context.startActivity(paramView);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes9.jar
 * Qualified Name:     com.tencent.mm.plugin.account.ui.WelcomeSelectView.3
 * JD-Core Version:    0.7.0.1
 */