package com.tencent.mm.plugin.appbrand.widget.desktop;

import android.content.Context;
import android.content.Intent;
import android.view.View;
import android.view.View.OnLongClickListener;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.hellhoundlib.b.b;
import com.tencent.mm.plugin.appbrand.ui.AppBrandDebugUI;
import com.tencent.mm.plugin.appbrand.ui.f;

final class RecentAppBrandViewContainer$3
  implements View.OnLongClickListener
{
  RecentAppBrandViewContainer$3(RecentAppBrandViewContainer paramRecentAppBrandViewContainer, Context paramContext) {}
  
  public final boolean onLongClick(View paramView)
  {
    AppMethodBeat.i(227779);
    Object localObject = new b();
    ((b)localObject).bm(paramView);
    com.tencent.mm.hellhoundlib.a.a.b("com/tencent/mm/plugin/appbrand/widget/desktop/RecentAppBrandViewContainer$3", "android/view/View$OnLongClickListener", "onLongClick", "(Landroid/view/View;)Z", this, ((b)localObject).axR());
    if (f.bWW())
    {
      localObject = new Intent(this.val$context, AppBrandDebugUI.class);
      paramView = this.val$context;
      localObject = new com.tencent.mm.hellhoundlib.b.a().bl(localObject);
      com.tencent.mm.hellhoundlib.a.a.a(paramView, ((com.tencent.mm.hellhoundlib.b.a)localObject).axQ(), "com/tencent/mm/plugin/appbrand/widget/desktop/RecentAppBrandViewContainer$3", "onLongClick", "(Landroid/view/View;)Z", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
      paramView.startActivity((Intent)((com.tencent.mm.hellhoundlib.b.a)localObject).pG(0));
      com.tencent.mm.hellhoundlib.a.a.a(paramView, "com/tencent/mm/plugin/appbrand/widget/desktop/RecentAppBrandViewContainer$3", "onLongClick", "(Landroid/view/View;)Z", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
      com.tencent.mm.hellhoundlib.a.a.a(true, this, "com/tencent/mm/plugin/appbrand/widget/desktop/RecentAppBrandViewContainer$3", "android/view/View$OnLongClickListener", "onLongClick", "(Landroid/view/View;)Z");
      AppMethodBeat.o(227779);
      return true;
    }
    com.tencent.mm.hellhoundlib.a.a.a(false, this, "com/tencent/mm/plugin/appbrand/widget/desktop/RecentAppBrandViewContainer$3", "android/view/View$OnLongClickListener", "onLongClick", "(Landroid/view/View;)Z");
    AppMethodBeat.o(227779);
    return false;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.widget.desktop.RecentAppBrandViewContainer.3
 * JD-Core Version:    0.7.0.1
 */