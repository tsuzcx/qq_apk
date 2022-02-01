package com.tencent.mm.plugin.brandservice.ui.timeline.item;

import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.hellhoundlib.a.a;
import kotlin.l;

@l(hxD={1, 1, 16}, hxE={""}, hxF={"<anonymous>", "", "it", "Landroid/view/View;", "kotlin.jvm.PlatformType", "onClick"})
final class af$d
  implements View.OnClickListener
{
  af$d(kotlin.g.a.b paramb) {}
  
  public final void onClick(View paramView)
  {
    AppMethodBeat.i(195492);
    com.tencent.mm.hellhoundlib.b.b localb = new com.tencent.mm.hellhoundlib.b.b();
    localb.bm(paramView);
    a.b("com/tencent/mm/plugin/brandservice/ui/timeline/item/BizTLRecFeedTag$initJumpContent$2", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, localb.axR());
    this.pwT.invoke(Integer.valueOf(24));
    a.a(this, "com/tencent/mm/plugin/brandservice/ui/timeline/item/BizTLRecFeedTag$initJumpContent$2", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
    AppMethodBeat.o(195492);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.plugin.brandservice.ui.timeline.item.af.d
 * JD-Core Version:    0.7.0.1
 */