package com.tencent.mm.plugin.appbrand.ui;

import android.content.Intent;
import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.br.c;
import com.tencent.mm.hellhoundlib.a.a;
import com.tencent.mm.hellhoundlib.b.b;
import com.tencent.mm.plugin.appbrand.AppBrandRuntime;
import com.tencent.mm.sdk.system.AndroidContextUtil;

final class e$1
  implements View.OnClickListener
{
  e$1(e parame, String paramString) {}
  
  public final void onClick(View paramView)
  {
    AppMethodBeat.i(322341);
    b localb = new b();
    localb.cH(paramView);
    a.c("com/tencent/mm/plugin/appbrand/ui/AppBrandGameUILoadingSplash$1", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, localb.aYj());
    c.b(AndroidContextUtil.castActivityOrNull(e.a(this.uaz).mContext), "webview", ".ui.tools.WebViewUI", new Intent().putExtra("rawUrl", this.val$url).putExtra("forceHideShare", true));
    a.a(this, "com/tencent/mm/plugin/appbrand/ui/AppBrandGameUILoadingSplash$1", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
    AppMethodBeat.o(322341);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.ui.e.1
 * JD-Core Version:    0.7.0.1
 */