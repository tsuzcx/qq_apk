package com.tencent.mm.plugin.brandservice.ui.timeline;

import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.hellhoundlib.a.a;
import com.tencent.mm.hellhoundlib.b.b;

final class BizTimeLineUI$7
  implements View.OnClickListener
{
  BizTimeLineUI$7(BizTimeLineUI paramBizTimeLineUI) {}
  
  public final void onClick(View paramView)
  {
    AppMethodBeat.i(194939);
    b localb = new b();
    localb.bm(paramView);
    a.b("com/tencent/mm/plugin/brandservice/ui/timeline/BizTimeLineUI$15", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, localb.axR());
    BizTimeLineUI.p(this.ptt);
    a.a(this, "com/tencent/mm/plugin/brandservice/ui/timeline/BizTimeLineUI$15", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
    AppMethodBeat.o(194939);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.plugin.brandservice.ui.timeline.BizTimeLineUI.7
 * JD-Core Version:    0.7.0.1
 */