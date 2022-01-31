package com.tencent.mm.plugin.appbrand.ui;

import android.support.v7.app.AppCompatActivity;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ui.base.h;
import com.tencent.mm.ui.base.p;

final class AppBrandAuthorizeUI$2
  implements Runnable
{
  AppBrandAuthorizeUI$2(AppBrandAuthorizeUI paramAppBrandAuthorizeUI) {}
  
  public final void run()
  {
    AppMethodBeat.i(132893);
    if (AppBrandAuthorizeUI.f(this.iLF) == null)
    {
      AppBrandAuthorizeUI localAppBrandAuthorizeUI = this.iLF;
      AppCompatActivity localAppCompatActivity = this.iLF.getContext();
      this.iLF.getString(2131297087);
      AppBrandAuthorizeUI.a(localAppBrandAuthorizeUI, h.a(localAppCompatActivity, 3, this.iLF.getString(2131297189), false, new AppBrandAuthorizeUI.2.1(this)));
    }
    AppBrandAuthorizeUI.f(this.iLF).show();
    AppMethodBeat.o(132893);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.ui.AppBrandAuthorizeUI.2
 * JD-Core Version:    0.7.0.1
 */