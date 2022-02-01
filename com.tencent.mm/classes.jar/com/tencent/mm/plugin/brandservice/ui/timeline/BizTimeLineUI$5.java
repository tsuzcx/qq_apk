package com.tencent.mm.plugin.brandservice.ui.timeline;

import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.hellhoundlib.a.a;
import com.tencent.mm.hellhoundlib.b.b;

final class BizTimeLineUI$5
  implements View.OnClickListener
{
  BizTimeLineUI$5(BizTimeLineUI paramBizTimeLineUI) {}
  
  public final void onClick(View paramView)
  {
    AppMethodBeat.i(209508);
    b localb = new b();
    localb.bd(paramView);
    a.b("com/tencent/mm/plugin/brandservice/ui/timeline/BizTimeLineUI$13", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, localb.ahq());
    BizTimeLineUI.m(this.ocb);
    a.a(this, "com/tencent/mm/plugin/brandservice/ui/timeline/BizTimeLineUI$13", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
    AppMethodBeat.o(209508);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.plugin.brandservice.ui.timeline.BizTimeLineUI.5
 * JD-Core Version:    0.7.0.1
 */