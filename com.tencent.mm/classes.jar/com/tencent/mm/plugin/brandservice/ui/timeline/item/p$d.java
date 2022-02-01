package com.tencent.mm.plugin.brandservice.ui.timeline.item;

import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.hellhoundlib.a.a;
import com.tencent.mm.hellhoundlib.b.b;
import com.tencent.mm.storage.w;
import d.l;

@l(gjZ={1, 1, 16}, gka={""}, gkb={"<anonymous>", "", "it", "Landroid/view/View;", "kotlin.jvm.PlatformType", "onClick"})
final class p$d
  implements View.OnClickListener
{
  p$d(p paramp, String paramString, w paramw) {}
  
  public final void onClick(View paramView)
  {
    AppMethodBeat.i(208745);
    Object localObject = new b();
    ((b)localObject).bd(paramView);
    a.b("com/tencent/mm/plugin/brandservice/ui/timeline/item/BizTLRecCardItem$refreshHeader$1", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, ((b)localObject).ahF());
    paramView = this.ojX;
    localObject = this.gTN;
    d.g.b.p.g(localObject, "username");
    p.a(paramView, (String)localObject, this.oiy);
    a.a(this, "com/tencent/mm/plugin/brandservice/ui/timeline/item/BizTLRecCardItem$refreshHeader$1", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
    AppMethodBeat.o(208745);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.plugin.brandservice.ui.timeline.item.p.d
 * JD-Core Version:    0.7.0.1
 */