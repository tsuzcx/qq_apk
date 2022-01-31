package com.tencent.mm.plugin.appbrand.ui;

import android.view.View;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.kernel.g;
import com.tencent.mm.modelappbrand.i;
import com.tencent.mm.sdk.platformtools.ab;

final class AppBrandProcessShareMessageProxyUI$2
  implements AppBrandProcessShareMessageProxyUI.b
{
  AppBrandProcessShareMessageProxyUI$2(AppBrandProcessShareMessageProxyUI paramAppBrandProcessShareMessageProxyUI, String paramString, View paramView) {}
  
  public final void e(boolean paramBoolean, String paramString, int paramInt)
  {
    AppMethodBeat.i(133010);
    ab.i("MicroMsg.AppBrandProcessShareMessageProxyUI", "onProcessDone, result:%b", new Object[] { Boolean.valueOf(paramBoolean) });
    if (AppBrandProcessShareMessageProxyUI.a(this.iNi) != null) {
      AppBrandProcessShareMessageProxyUI.a(this.iNi).a(paramBoolean, paramString, paramInt);
    }
    ((i)g.E(i.class)).a(this.hpi, this.val$view);
    AppMethodBeat.o(133010);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.ui.AppBrandProcessShareMessageProxyUI.2
 * JD-Core Version:    0.7.0.1
 */