package com.tencent.mm.plugin.account.security.ui;

import android.content.Intent;
import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.kernel.h;
import com.tencent.mm.plugin.account.security.a.d;
import com.tencent.mm.pluginsdk.m;
import com.tencent.mm.protocal.GeneralControlWrapper;
import com.tencent.mm.protocal.JsapiPermissionWrapper;
import com.tencent.mm.sdk.platformtools.LocaleUtil;
import com.tencent.mm.sdk.platformtools.MMApplicationContext;

final class SecurityAccountVerifyUI$4
  implements View.OnClickListener
{
  SecurityAccountVerifyUI$4(SecurityAccountVerifyUI paramSecurityAccountVerifyUI) {}
  
  public final void onClick(View paramView)
  {
    AppMethodBeat.i(125601);
    Object localObject = new com.tencent.mm.hellhoundlib.b.b();
    ((com.tencent.mm.hellhoundlib.b.b)localObject).bn(paramView);
    com.tencent.mm.hellhoundlib.a.a.c("com/tencent/mm/plugin/account/security/ui/SecurityAccountVerifyUI$4", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, ((com.tencent.mm.hellhoundlib.b.b)localObject).aFi());
    paramView = new StringBuilder();
    h.aHE();
    paramView = paramView.append(com.tencent.mm.kernel.b.aGR()).append(",").append(getClass().getName()).append(",L600_300,");
    h.aHE();
    com.tencent.mm.plugin.b.a.KP(com.tencent.mm.kernel.b.MN("L600_300") + ",1");
    paramView = LocaleUtil.loadApplicationLanguage(this.nbx.getSharedPreferences(MMApplicationContext.getDefaultPreferencePath(), 0), this.nbx);
    localObject = new Intent();
    ((Intent)localObject).putExtra("rawUrl", String.format(SecurityAccountVerifyUI.bzf(), new Object[] { paramView }));
    ((Intent)localObject).putExtra("useJs", true);
    ((Intent)localObject).putExtra("vertical_scroll", true);
    ((Intent)localObject).putExtra("title", this.nbx.getString(a.d.safe_device_protect_close));
    ((Intent)localObject).putExtra("show_bottom", false);
    ((Intent)localObject).putExtra("showShare", false);
    ((Intent)localObject).putExtra("neverGetA8Key", true);
    ((Intent)localObject).putExtra("hardcode_jspermission", JsapiPermissionWrapper.RBc);
    ((Intent)localObject).putExtra("hardcode_general_ctrl", GeneralControlWrapper.RAX);
    com.tencent.mm.plugin.account.sdk.a.mIG.h((Intent)localObject, this.nbx);
    com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/account/security/ui/SecurityAccountVerifyUI$4", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
    AppMethodBeat.o(125601);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.plugin.account.security.ui.SecurityAccountVerifyUI.4
 * JD-Core Version:    0.7.0.1
 */