package com.tencent.mm.plugin.appbrand.ui;

import com.tencent.mm.kernel.g;
import com.tencent.mm.model.am.b.a;
import com.tencent.mm.plugin.messenger.foundation.a.j;
import com.tencent.mm.sdk.platformtools.y;
import com.tencent.mm.storage.bd;
import com.tencent.mm.ui.base.p;

final class AppBrandOpenWeRunSettingUI$3
  implements am.b.a
{
  AppBrandOpenWeRunSettingUI$3(AppBrandOpenWeRunSettingUI paramAppBrandOpenWeRunSettingUI) {}
  
  public final void m(String paramString, boolean paramBoolean)
  {
    y.i("MicroMsg.AppBrandOpenWeRunSettingUI", "getContactCallBack, suc = %b,user %s", new Object[] { Boolean.valueOf(paramBoolean), paramString });
    AppBrandOpenWeRunSettingUI.a(this.hdj, ((j)g.r(j.class)).Fw().abl("gh_43f2581f6fd6"));
    AppBrandOpenWeRunSettingUI.a(this.hdj);
    AppBrandOpenWeRunSettingUI.b(this.hdj).dismiss();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.ui.AppBrandOpenWeRunSettingUI.3
 * JD-Core Version:    0.7.0.1
 */