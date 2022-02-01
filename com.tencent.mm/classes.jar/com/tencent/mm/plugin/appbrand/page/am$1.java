package com.tencent.mm.plugin.appbrand.page;

import android.view.View;
import android.view.View.OnLongClickListener;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.hellhoundlib.a.a;
import com.tencent.mm.hellhoundlib.b.b;

final class am$1
  implements View.OnLongClickListener
{
  am$1(am paramam) {}
  
  public final boolean onLongClick(View paramView)
  {
    AppMethodBeat.i(227310);
    b localb = new b();
    localb.bm(paramView);
    a.b("com/tencent/mm/plugin/appbrand/page/AppBrandWebView$1", "android/view/View$OnLongClickListener", "onLongClick", "(Landroid/view/View;)Z", this, localb.axR());
    a.a(false, this, "com/tencent/mm/plugin/appbrand/page/AppBrandWebView$1", "android/view/View$OnLongClickListener", "onLongClick", "(Landroid/view/View;)Z");
    AppMethodBeat.o(227310);
    return false;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.page.am.1
 * JD-Core Version:    0.7.0.1
 */