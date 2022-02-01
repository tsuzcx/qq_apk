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
    ((com.tencent.mm.hellhoundlib.b.b)localObject).cH(paramView);
    com.tencent.mm.hellhoundlib.a.a.c("com/tencent/mm/plugin/account/security/ui/SecurityAccountVerifyUI$4", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, ((com.tencent.mm.hellhoundlib.b.b)localObject).aYj());
    paramView = new StringBuilder();
    h.baC();
    paramView = paramView.append(com.tencent.mm.kernel.b.aZR()).append(",").append(getClass().getName()).append(",L600_300,");
    h.baC();
    com.tencent.mm.plugin.b.a.Du(com.tencent.mm.kernel.b.Fw("L600_300") + ",1");
    paramView = LocaleUtil.loadApplicationLanguage(this.pYF.getSharedPreferences(MMApplicationContext.getDefaultPreferencePath(), 0), this.pYF);
    localObject = new Intent();
    ((Intent)localObject).putExtra("rawUrl", String.format(SecurityAccountVerifyUI.access$600(), new Object[] { paramView }));
    ((Intent)localObject).putExtra("useJs", true);
    ((Intent)localObject).putExtra("vertical_scroll", true);
    ((Intent)localObject).putExtra("title", this.pYF.getString(a.d.safe_device_protect_close));
    ((Intent)localObject).putExtra("show_bottom", false);
    ((Intent)localObject).putExtra("showShare", false);
    ((Intent)localObject).putExtra("neverGetA8Key", true);
    ((Intent)localObject).putExtra("hardcode_jspermission", JsapiPermissionWrapper.YxF);
    ((Intent)localObject).putExtra("hardcode_general_ctrl", GeneralControlWrapper.YxA);
    com.tencent.mm.plugin.account.sdk.a.pFn.h((Intent)localObject, this.pYF);
    com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/account/security/ui/SecurityAccountVerifyUI$4", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
    AppMethodBeat.o(125601);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.plugin.account.security.ui.SecurityAccountVerifyUI.4
 * JD-Core Version:    0.7.0.1
 */