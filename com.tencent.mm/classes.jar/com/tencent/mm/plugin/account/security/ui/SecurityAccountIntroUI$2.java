package com.tencent.mm.plugin.account.security.ui;

import android.content.Intent;
import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.hellhoundlib.b.b;
import com.tencent.mm.pluginsdk.m;
import com.tencent.mm.protocal.GeneralControlWrapper;
import com.tencent.mm.protocal.JsapiPermissionWrapper;
import com.tencent.mm.sdk.platformtools.LocaleUtil;
import com.tencent.mm.sdk.platformtools.MMApplicationContext;
import com.tencent.mm.sdk.platformtools.Util;

final class SecurityAccountIntroUI$2
  implements View.OnClickListener
{
  SecurityAccountIntroUI$2(SecurityAccountIntroUI paramSecurityAccountIntroUI) {}
  
  public final void onClick(View paramView)
  {
    AppMethodBeat.i(125587);
    Object localObject = new b();
    ((b)localObject).bm(paramView);
    com.tencent.mm.hellhoundlib.a.a.b("com/tencent/mm/plugin/account/security/ui/SecurityAccountIntroUI$2", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, ((b)localObject).axR());
    paramView = LocaleUtil.loadApplicationLanguage(this.kjz.getSharedPreferences(MMApplicationContext.getDefaultPreferencePath(), 0), this.kjz);
    localObject = new Intent();
    if (Util.isNullOrNil(SecurityAccountIntroUI.d(this.kjz))) {
      ((Intent)localObject).putExtra("rawUrl", String.format(SecurityAccountIntroUI.access$500(), new Object[] { paramView }));
    }
    for (;;)
    {
      ((Intent)localObject).putExtra("useJs", true);
      ((Intent)localObject).putExtra("vertical_scroll", true);
      ((Intent)localObject).putExtra("title", this.kjz.getString(2131764852));
      ((Intent)localObject).putExtra("show_bottom", false);
      ((Intent)localObject).putExtra("showShare", false);
      ((Intent)localObject).putExtra("neverGetA8Key", true);
      ((Intent)localObject).putExtra("hardcode_jspermission", JsapiPermissionWrapper.Kzm);
      ((Intent)localObject).putExtra("hardcode_general_ctrl", GeneralControlWrapper.Kzg);
      com.tencent.mm.plugin.account.a.a.jRt.i((Intent)localObject, this.kjz);
      com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/account/security/ui/SecurityAccountIntroUI$2", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
      AppMethodBeat.o(125587);
      return;
      ((Intent)localObject).putExtra("rawUrl", SecurityAccountIntroUI.d(this.kjz));
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.plugin.account.security.ui.SecurityAccountIntroUI.2
 * JD-Core Version:    0.7.0.1
 */