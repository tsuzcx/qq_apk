package com.tencent.mm.plugin.appbrand.ui;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.kernel.g;
import com.tencent.mm.model.ao.b.a;
import com.tencent.mm.plugin.messenger.foundation.a.j;
import com.tencent.mm.sdk.platformtools.ab;
import com.tencent.mm.storage.bd;
import com.tencent.mm.ui.base.p;

final class AppBrandOpenWeRunSettingUI$3
  implements ao.b.a
{
  AppBrandOpenWeRunSettingUI$3(AppBrandOpenWeRunSettingUI paramAppBrandOpenWeRunSettingUI) {}
  
  public final void p(String paramString, boolean paramBoolean)
  {
    AppMethodBeat.i(132996);
    ab.i("MicroMsg.AppBrandOpenWeRunSettingUI", "getContactCallBack, suc = %b,user %s", new Object[] { Boolean.valueOf(paramBoolean), paramString });
    AppBrandOpenWeRunSettingUI.a(this.iNa, ((j)g.E(j.class)).YA().arw("gh_43f2581f6fd6"));
    AppBrandOpenWeRunSettingUI.a(this.iNa);
    AppBrandOpenWeRunSettingUI.b(this.iNa).dismiss();
    AppMethodBeat.o(132996);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.ui.AppBrandOpenWeRunSettingUI.3
 * JD-Core Version:    0.7.0.1
 */