package com.tencent.mm.plugin.brandservice.ui.timeline.item;

import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.hellhoundlib.a.a;
import com.tencent.mm.hellhoundlib.b.b;
import com.tencent.mm.storage.w;

public final class y$1
  implements View.OnClickListener
{
  public y$1(y paramy, w paramw) {}
  
  public final void onClick(View paramView)
  {
    AppMethodBeat.i(6015);
    b localb = new b();
    localb.bd(paramView);
    a.b("com/tencent/mm/plugin/brandservice/ui/timeline/item/BizTimeLineImgItem$1", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, localb.ahq());
    y.a(this.ofl, paramView, this.nOy);
    a.a(this, "com/tencent/mm/plugin/brandservice/ui/timeline/item/BizTimeLineImgItem$1", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
    AppMethodBeat.o(6015);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.plugin.brandservice.ui.timeline.item.y.1
 * JD-Core Version:    0.7.0.1
 */