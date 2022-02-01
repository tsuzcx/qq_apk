package com.tencent.mm.plugin.finder.live.plugin;

import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.hellhoundlib.b.b;
import com.tencent.mm.model.cm;
import com.tencent.mm.model.z;
import com.tencent.mm.plugin.report.service.h;
import kotlin.g.b.p;
import kotlin.l;

@l(iBK={1, 1, 16}, iBL={""}, iBM={"<anonymous>", "", "it", "Landroid/view/View;", "kotlin.jvm.PlatformType", "onClick"})
final class e$a
  implements View.OnClickListener
{
  e$a(e parame) {}
  
  public final void onClick(View paramView)
  {
    AppMethodBeat.i(289102);
    b localb = new b();
    localb.bn(paramView);
    com.tencent.mm.hellhoundlib.a.a.c("com/tencent/mm/plugin/finder/live/plugin/FinderLiveAnchorAfterPlugin$setLiveTaskInfo$1", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, localb.aFi());
    paramView = com.tencent.mm.plugin.finder.utils.a.ACH;
    paramView = this.yls.kiF.getContext();
    p.j(paramView, "root.context");
    com.tencent.mm.plugin.finder.utils.a.ao(paramView, 3);
    h.IzE.a(22748, new Object[] { Integer.valueOf(3), Integer.valueOf(2), Long.valueOf(cm.bfE()), z.bdh() });
    com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/finder/live/plugin/FinderLiveAnchorAfterPlugin$setLiveTaskInfo$1", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
    AppMethodBeat.o(289102);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.plugin.finder.live.plugin.e.a
 * JD-Core Version:    0.7.0.1
 */