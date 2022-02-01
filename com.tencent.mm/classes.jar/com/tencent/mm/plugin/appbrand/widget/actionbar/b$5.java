package com.tencent.mm.plugin.appbrand.widget.actionbar;

import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.Iterator;
import java.util.Set;

final class b$5
  implements View.OnClickListener
{
  private long uyP = 0L;
  
  b$5(b paramb) {}
  
  public final void onClick(View paramView)
  {
    AppMethodBeat.i(324153);
    com.tencent.mm.hellhoundlib.b.b localb = new com.tencent.mm.hellhoundlib.b.b();
    localb.cH(paramView);
    com.tencent.mm.hellhoundlib.a.a.c("com/tencent/mm/plugin/appbrand/widget/actionbar/AppBrandActionBar$5", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, localb.aYj());
    if (System.currentTimeMillis() - this.uyP < 250L)
    {
      paramView = b.e(this.uyN).iterator();
      while (paramView.hasNext()) {
        ((a)paramView.next()).cxP();
      }
      this.uyP = 0L;
    }
    this.uyP = System.currentTimeMillis();
    com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/appbrand/widget/actionbar/AppBrandActionBar$5", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
    AppMethodBeat.o(324153);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.widget.actionbar.b.5
 * JD-Core Version:    0.7.0.1
 */