package com.tencent.mm.plugin.brandservice.ui.widget;

import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.hellhoundlib.a.a;
import com.tencent.mm.hellhoundlib.b.b;

final class MPVideoViewControlBar$5
  implements View.OnClickListener
{
  MPVideoViewControlBar$5(MPVideoViewControlBar paramMPVideoViewControlBar) {}
  
  public final void onClick(View paramView)
  {
    AppMethodBeat.i(6278);
    b localb = new b();
    localb.bd(paramView);
    a.b("com/tencent/mm/plugin/brandservice/ui/widget/MPVideoViewControlBar$2", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, localb.ahF());
    a.a(this, "com/tencent/mm/plugin/brandservice/ui/widget/MPVideoViewControlBar$2", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
    AppMethodBeat.o(6278);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.plugin.brandservice.ui.widget.MPVideoViewControlBar.5
 * JD-Core Version:    0.7.0.1
 */