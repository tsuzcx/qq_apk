package com.tencent.mm.plugin.account.security.ui;

import android.content.Intent;
import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.hellhoundlib.b.b;
import com.tencent.mm.plugin.account.security.a.d;
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
    ((b)localObject).bn(paramView);
    com.tencent.mm.hellhoundlib.a.a.c("com/tencent/mm/plugin/account/security/ui/SecurityAccountIntroUI$2", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, ((b)localObject).aFi());
    paramView = LocaleUtil.loadApplicationLanguage(this.nbp.getSharedPreferences(MMApplicationContext.getDefaultPreferencePath(), 0), this.nbp);
    localObject = new Intent();
    if (Util.isNullOrNil(SecurityAccountIntroUI.d(this.nbp))) {
      ((Intent)localObject).putExtra("rawUrl", String.format(SecurityAccountIntroUI.access$500(), new Object[] { paramView }));
    }
    for (;;)
    {
      ((Intent)localObject).putExtra("useJs", true);
      ((Intent)localObject).putExtra("vertical_scroll", true);
      ((Intent)localObject).putExtra("title", this.nbp.getString(a.d.safe_device_protect_close));
      ((Intent)localObject).putExtra("show_bottom", false);
      ((Intent)localObject).putExtra("showShare", false);
      ((Intent)localObject).putExtra("neverGetA8Key", true);
      ((Intent)localObject).putExtra("hardcode_jspermission", JsapiPermissionWrapper.RBc);
      ((Intent)localObject).putExtra("hardcode_general_ctrl", GeneralControlWrapper.RAX);
      com.tencent.mm.plugin.account.sdk.a.mIG.h((Intent)localObject, this.nbp);
      com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/account/security/ui/SecurityAccountIntroUI$2", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
      AppMethodBeat.o(125587);
      return;
      ((Intent)localObject).putExtra("rawUrl", SecurityAccountIntroUI.d(this.nbp));
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.plugin.account.security.ui.SecurityAccountIntroUI.2
 * JD-Core Version:    0.7.0.1
 */