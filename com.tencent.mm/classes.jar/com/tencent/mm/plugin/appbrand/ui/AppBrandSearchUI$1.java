package com.tencent.mm.plugin.appbrand.ui;

import android.content.Intent;
import android.text.TextUtils;
import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.br.c;
import com.tencent.mm.hellhoundlib.a.a;
import com.tencent.mm.hellhoundlib.b.b;

final class AppBrandSearchUI$1
  implements View.OnClickListener
{
  AppBrandSearchUI$1(AppBrandSearchUI paramAppBrandSearchUI) {}
  
  public final void onClick(View paramView)
  {
    AppMethodBeat.i(21132);
    Object localObject = new b();
    ((b)localObject).bm(paramView);
    a.b("com/tencent/mm/plugin/appbrand/ui/AppBrandSearchUI$1", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, ((b)localObject).axR());
    if (TextUtils.isEmpty(AppBrandSearchUI.a(this.nWC)))
    {
      a.a(this, "com/tencent/mm/plugin/appbrand/ui/AppBrandSearchUI$1", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
      AppMethodBeat.o(21132);
      return;
    }
    localObject = new Intent();
    ((Intent)localObject).putExtra("showShare", false);
    ((Intent)localObject).putExtra("rawUrl", AppBrandSearchUI.a(this.nWC));
    ((Intent)localObject).putExtra("geta8key_scene", 41);
    ((Intent)localObject).putExtra("show_long_click_popup_menu", false);
    c.b(paramView.getContext(), "webview", ".ui.tools.WebViewUI", (Intent)localObject);
    a.a(this, "com/tencent/mm/plugin/appbrand/ui/AppBrandSearchUI$1", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
    AppMethodBeat.o(21132);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.ui.AppBrandSearchUI.1
 * JD-Core Version:    0.7.0.1
 */