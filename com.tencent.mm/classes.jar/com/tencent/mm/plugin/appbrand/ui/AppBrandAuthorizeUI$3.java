package com.tencent.mm.plugin.appbrand.ui;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ui.base.p;

final class AppBrandAuthorizeUI$3
  implements Runnable
{
  AppBrandAuthorizeUI$3(AppBrandAuthorizeUI paramAppBrandAuthorizeUI) {}
  
  public final void run()
  {
    AppMethodBeat.i(132894);
    if ((AppBrandAuthorizeUI.f(this.iLF) != null) && (AppBrandAuthorizeUI.f(this.iLF).isShowing())) {
      AppBrandAuthorizeUI.f(this.iLF).dismiss();
    }
    AppMethodBeat.o(132894);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.ui.AppBrandAuthorizeUI.3
 * JD-Core Version:    0.7.0.1
 */