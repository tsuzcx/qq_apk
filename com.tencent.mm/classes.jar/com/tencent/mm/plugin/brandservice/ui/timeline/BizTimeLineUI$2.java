package com.tencent.mm.plugin.brandservice.ui.timeline;

import android.content.Intent;
import android.view.View;
import android.view.View.OnLongClickListener;
import com.tencent.matrix.trace.core.AppMethodBeat;
import d.f;

final class BizTimeLineUI$2
  implements View.OnLongClickListener
{
  BizTimeLineUI$2(BizTimeLineUI paramBizTimeLineUI) {}
  
  public final boolean onLongClick(View paramView)
  {
    AppMethodBeat.i(208460);
    Object localObject = new com.tencent.mm.hellhoundlib.b.b();
    ((com.tencent.mm.hellhoundlib.b.b)localObject).bd(paramView);
    com.tencent.mm.hellhoundlib.a.a.b("com/tencent/mm/plugin/brandservice/ui/timeline/BizTimeLineUI$10", "android/view/View$OnLongClickListener", "onLongClick", "(Landroid/view/View;)Z", this, ((com.tencent.mm.hellhoundlib.b.b)localObject).ahF());
    paramView = com.tencent.mm.plugin.biz.b.b.nUB;
    if (((Boolean)com.tencent.mm.plugin.biz.b.b.nUz.getValue()).booleanValue())
    {
      paramView = this.ohP;
      localObject = new Intent(this.ohP, BizTestUI.class);
      localObject = new com.tencent.mm.hellhoundlib.b.a().bc(localObject);
      com.tencent.mm.hellhoundlib.a.a.a(paramView, ((com.tencent.mm.hellhoundlib.b.a)localObject).ahE(), "com/tencent/mm/plugin/brandservice/ui/timeline/BizTimeLineUI$10", "onLongClick", "(Landroid/view/View;)Z", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
      paramView.startActivity((Intent)((com.tencent.mm.hellhoundlib.b.a)localObject).mt(0));
      com.tencent.mm.hellhoundlib.a.a.a(paramView, "com/tencent/mm/plugin/brandservice/ui/timeline/BizTimeLineUI$10", "onLongClick", "(Landroid/view/View;)Z", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
    }
    com.tencent.mm.hellhoundlib.a.a.a(false, this, "com/tencent/mm/plugin/brandservice/ui/timeline/BizTimeLineUI$10", "android/view/View$OnLongClickListener", "onLongClick", "(Landroid/view/View;)Z");
    AppMethodBeat.o(208460);
    return false;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.plugin.brandservice.ui.timeline.BizTimeLineUI.2
 * JD-Core Version:    0.7.0.1
 */