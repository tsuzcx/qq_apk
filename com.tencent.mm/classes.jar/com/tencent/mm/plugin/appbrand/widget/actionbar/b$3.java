package com.tencent.mm.plugin.appbrand.widget.actionbar;

import android.view.View;
import android.view.View.OnLongClickListener;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.hellhoundlib.a.a;

final class b$3
  implements View.OnLongClickListener
{
  b$3(b paramb, View.OnLongClickListener paramOnLongClickListener) {}
  
  public final boolean onLongClick(View paramView)
  {
    AppMethodBeat.i(135406);
    com.tencent.mm.hellhoundlib.b.b localb = new com.tencent.mm.hellhoundlib.b.b();
    localb.bd(paramView);
    a.b("com/tencent/mm/plugin/appbrand/widget/actionbar/AppBrandActionBar$3", "android/view/View$OnLongClickListener", "onLongClick", "(Landroid/view/View;)Z", this, localb.ahq());
    if (this.mTV != null)
    {
      boolean bool = this.mTV.onLongClick(paramView);
      a.a(bool, this, "com/tencent/mm/plugin/appbrand/widget/actionbar/AppBrandActionBar$3", "android/view/View$OnLongClickListener", "onLongClick", "(Landroid/view/View;)Z");
      AppMethodBeat.o(135406);
      return bool;
    }
    a.a(false, this, "com/tencent/mm/plugin/appbrand/widget/actionbar/AppBrandActionBar$3", "android/view/View$OnLongClickListener", "onLongClick", "(Landroid/view/View;)Z");
    AppMethodBeat.o(135406);
    return false;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.widget.actionbar.b.3
 * JD-Core Version:    0.7.0.1
 */