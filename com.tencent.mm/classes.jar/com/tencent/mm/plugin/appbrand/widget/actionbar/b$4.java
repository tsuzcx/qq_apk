package com.tencent.mm.plugin.appbrand.widget.actionbar;

import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.Iterator;
import java.util.Set;

final class b$4
  implements View.OnClickListener
{
  private long mTW = 0L;
  
  b$4(b paramb) {}
  
  public final void onClick(View paramView)
  {
    AppMethodBeat.i(135407);
    com.tencent.mm.hellhoundlib.b.b localb = new com.tencent.mm.hellhoundlib.b.b();
    localb.bd(paramView);
    com.tencent.mm.hellhoundlib.a.a.b("com/tencent/mm/plugin/appbrand/widget/actionbar/AppBrandActionBar$4", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, localb.ahq());
    if (System.currentTimeMillis() - this.mTW < 250L)
    {
      paramView = b.d(this.mTU).iterator();
      while (paramView.hasNext()) {
        ((a)paramView.next()).bpo();
      }
      this.mTW = 0L;
    }
    this.mTW = System.currentTimeMillis();
    com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/appbrand/widget/actionbar/AppBrandActionBar$4", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
    AppMethodBeat.o(135407);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.widget.actionbar.b.4
 * JD-Core Version:    0.7.0.1
 */