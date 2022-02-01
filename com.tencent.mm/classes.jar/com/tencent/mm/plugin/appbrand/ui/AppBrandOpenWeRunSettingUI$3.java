package com.tencent.mm.plugin.appbrand.ui;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.kernel.g;
import com.tencent.mm.model.ay.b.a;
import com.tencent.mm.plugin.messenger.foundation.a.l;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.storage.bv;
import com.tencent.mm.ui.base.q;

final class AppBrandOpenWeRunSettingUI$3
  implements ay.b.a
{
  AppBrandOpenWeRunSettingUI$3(AppBrandOpenWeRunSettingUI paramAppBrandOpenWeRunSettingUI) {}
  
  public final void p(String paramString, boolean paramBoolean)
  {
    AppMethodBeat.i(48667);
    Log.i("MicroMsg.AppBrandOpenWeRunSettingUI", "getContactCallBack, suc = %b,user %s", new Object[] { Boolean.valueOf(paramBoolean), paramString });
    AppBrandOpenWeRunSettingUI.a(this.nUr, ((l)g.af(l.class)).aSN().Kn("gh_43f2581f6fd6"));
    AppBrandOpenWeRunSettingUI.a(this.nUr);
    AppBrandOpenWeRunSettingUI.b(this.nUr).dismiss();
    AppMethodBeat.o(48667);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.ui.AppBrandOpenWeRunSettingUI.3
 * JD-Core Version:    0.7.0.1
 */