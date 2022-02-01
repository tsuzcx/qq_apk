package com.tencent.mm.plugin.festival.ui;

import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.hellhoundlib.a.a;
import kotlin.g.b.p;
import kotlin.l;

@l(iBK={1, 1, 16}, iBL={""}, iBM={"<anonymous>", "", "it", "Landroid/view/View;", "kotlin.jvm.PlatformType", "onClick"})
final class FestivalActivityBase$c
  implements View.OnClickListener
{
  FestivalActivityBase$c(kotlin.g.a.b paramb) {}
  
  public final void onClick(View paramView)
  {
    AppMethodBeat.i(258544);
    Object localObject = new com.tencent.mm.hellhoundlib.b.b();
    ((com.tencent.mm.hellhoundlib.b.b)localObject).bn(paramView);
    a.c("com/tencent/mm/plugin/festival/ui/FestivalActivityBase$setActionBarIconOnClick$1", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, ((com.tencent.mm.hellhoundlib.b.b)localObject).aFi());
    localObject = this.wUA;
    if (localObject != null)
    {
      p.j(paramView, "it");
      ((kotlin.g.a.b)localObject).invoke(paramView);
    }
    a.a(this, "com/tencent/mm/plugin/festival/ui/FestivalActivityBase$setActionBarIconOnClick$1", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
    AppMethodBeat.o(258544);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.plugin.festival.ui.FestivalActivityBase.c
 * JD-Core Version:    0.7.0.1
 */