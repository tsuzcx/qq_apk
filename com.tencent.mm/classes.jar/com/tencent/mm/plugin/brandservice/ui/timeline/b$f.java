package com.tencent.mm.plugin.brandservice.ui.timeline;

import android.content.Context;
import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.hellhoundlib.a.a;
import com.tencent.mm.plugin.brandservice.ui.timeline.item.al;
import com.tencent.mm.pluginsdk.model.b.b;
import com.tencent.mm.storage.z;
import kotlin.l;

@l(iBK={1, 1, 16}, iBL={""}, iBM={"<anonymous>", "", "it", "Landroid/view/View;", "kotlin.jvm.PlatformType", "onClick", "com/tencent/mm/plugin/brandservice/ui/timeline/BizTimeLineAdapter$initHeader$1$1"})
final class b$f
  implements View.OnClickListener
{
  b$f(b paramb, al paramal, z paramz) {}
  
  public final void onClick(View paramView)
  {
    AppMethodBeat.i(260440);
    Object localObject = new com.tencent.mm.hellhoundlib.b.b();
    ((com.tencent.mm.hellhoundlib.b.b)localObject).bn(paramView);
    a.c("com/tencent/mm/plugin/brandservice/ui/timeline/BizTimeLineAdapter$initHeader$$inlined$also$lambda$1", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, ((com.tencent.mm.hellhoundlib.b.b)localObject).aFi());
    paramView = com.tencent.mm.pluginsdk.model.b.QTJ;
    com.tencent.mm.pluginsdk.model.b.a(this.sAU.field_talker, this.sAU);
    this.sAU.Veg = true;
    paramView = com.tencent.mm.pluginsdk.model.b.QTJ;
    int i = com.tencent.mm.pluginsdk.model.b.bpr(this.sAU.field_talker);
    paramView = com.tencent.mm.pluginsdk.model.b.QTJ;
    localObject = (Context)this.sAP.sAm;
    String str = this.sAU.field_talker;
    b.b localb = b.b.QUa;
    paramView.b((Context)localObject, str, null, b.b.hgB(), i);
    a.a(this, "com/tencent/mm/plugin/brandservice/ui/timeline/BizTimeLineAdapter$initHeader$$inlined$also$lambda$1", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
    AppMethodBeat.o(260440);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.plugin.brandservice.ui.timeline.b.f
 * JD-Core Version:    0.7.0.1
 */