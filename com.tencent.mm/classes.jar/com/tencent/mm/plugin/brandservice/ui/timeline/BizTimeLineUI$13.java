package com.tencent.mm.plugin.brandservice.ui.timeline;

import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.hellhoundlib.a.a;
import com.tencent.mm.hellhoundlib.b.b;

final class BizTimeLineUI$13
  implements View.OnClickListener
{
  BizTimeLineUI$13(BizTimeLineUI paramBizTimeLineUI)
  {
    AppMethodBeat.i(160484);
    AppMethodBeat.o(160484);
  }
  
  public final void onClick(View paramView)
  {
    AppMethodBeat.i(301800);
    b localb = new b();
    localb.cH(paramView);
    a.c("com/tencent/mm/plugin/brandservice/ui/timeline/BizTimeLineUI$18", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, localb.aYj());
    BizTimeLineUI.p(this.vIB);
    a.a(this, "com/tencent/mm/plugin/brandservice/ui/timeline/BizTimeLineUI$18", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
    AppMethodBeat.o(301800);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.plugin.brandservice.ui.timeline.BizTimeLineUI.13
 * JD-Core Version:    0.7.0.1
 */