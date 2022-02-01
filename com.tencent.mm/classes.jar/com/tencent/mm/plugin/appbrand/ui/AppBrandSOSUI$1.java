package com.tencent.mm.plugin.appbrand.ui;

import android.content.Intent;
import android.text.TextUtils;
import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.br.c;
import com.tencent.mm.hellhoundlib.a.a;
import com.tencent.mm.hellhoundlib.b.b;

final class AppBrandSOSUI$1
  implements View.OnClickListener
{
  AppBrandSOSUI$1(AppBrandSOSUI paramAppBrandSOSUI) {}
  
  public final void onClick(View paramView)
  {
    AppMethodBeat.i(21124);
    Object localObject = new b();
    ((b)localObject).bm(paramView);
    a.b("com/tencent/mm/plugin/appbrand/ui/AppBrandSOSUI$1", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, ((b)localObject).axR());
    if (TextUtils.isEmpty(AppBrandSOSUI.a(this.nWB)))
    {
      a.a(this, "com/tencent/mm/plugin/appbrand/ui/AppBrandSOSUI$1", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
      AppMethodBeat.o(21124);
      return;
    }
    localObject = new Intent();
    ((Intent)localObject).putExtra("showShare", false);
    ((Intent)localObject).putExtra("rawUrl", AppBrandSOSUI.a(this.nWB));
    ((Intent)localObject).putExtra("geta8key_scene", 41);
    ((Intent)localObject).putExtra("show_long_click_popup_menu", false);
    c.b(paramView.getContext(), "webview", ".ui.tools.WebViewUI", (Intent)localObject);
    a.a(this, "com/tencent/mm/plugin/appbrand/ui/AppBrandSOSUI$1", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
    AppMethodBeat.o(21124);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.ui.AppBrandSOSUI.1
 * JD-Core Version:    0.7.0.1
 */