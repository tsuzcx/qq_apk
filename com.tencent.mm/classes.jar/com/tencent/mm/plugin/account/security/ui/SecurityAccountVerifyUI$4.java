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
import com.tencent.mm.sdk.platformtools.LocaleUtil;
import com.tencent.mm.sdk.platformtools.MMApplicationContext;

final class SecurityAccountVerifyUI$4
  implements View.OnClickListener
{
  SecurityAccountVerifyUI$4(SecurityAccountVerifyUI paramSecurityAccountVerifyUI) {}
  
  public final void onClick(View paramView)
  {
    AppMethodBeat.i(125601);
    Object localObject = new b();
    ((b)localObject).bm(paramView);
    com.tencent.mm.hellhoundlib.a.a.b("com/tencent/mm/plugin/account/security/ui/SecurityAccountVerifyUI$4", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, ((b)localObject).axR());
    paramView = new StringBuilder();
    g.aAf();
    paramView = paramView.append(com.tencent.mm.kernel.a.azt()).append(",").append(getClass().getName()).append(",L600_300,");
    g.aAf();
    com.tencent.mm.plugin.b.a.DX(com.tencent.mm.kernel.a.FN("L600_300") + ",1");
    paramView = LocaleUtil.loadApplicationLanguage(this.kjH.getSharedPreferences(MMApplicationContext.getDefaultPreferencePath(), 0), this.kjH);
    localObject = new Intent();
    ((Intent)localObject).putExtra("rawUrl", String.format(SecurityAccountVerifyUI.boU(), new Object[] { paramView }));
    ((Intent)localObject).putExtra("useJs", true);
    ((Intent)localObject).putExtra("vertical_scroll", true);
    ((Intent)localObject).putExtra("title", this.kjH.getString(2131764852));
    ((Intent)localObject).putExtra("show_bottom", false);
    ((Intent)localObject).putExtra("showShare", false);
    ((Intent)localObject).putExtra("neverGetA8Key", true);
    ((Intent)localObject).putExtra("hardcode_jspermission", JsapiPermissionWrapper.Kzm);
    ((Intent)localObject).putExtra("hardcode_general_ctrl", GeneralControlWrapper.Kzg);
    com.tencent.mm.plugin.account.a.a.jRt.i((Intent)localObject, this.kjH);
    com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/account/security/ui/SecurityAccountVerifyUI$4", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
    AppMethodBeat.o(125601);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.plugin.account.security.ui.SecurityAccountVerifyUI.4
 * JD-Core Version:    0.7.0.1
 */