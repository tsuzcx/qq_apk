package com.tencent.mm.plugin.finder.nearby.person;

import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.hellhoundlib.a.a;
import kotlin.l;

@l(iBK={1, 1, 16}, iBL={""}, iBM={"<anonymous>", "", "it", "Landroid/view/View;", "kotlin.jvm.PlatformType", "onClick"})
final class b$r
  implements View.OnClickListener
{
  b$r(b paramb) {}
  
  public final void onClick(View paramView)
  {
    AppMethodBeat.i(203652);
    com.tencent.mm.hellhoundlib.b.b localb = new com.tencent.mm.hellhoundlib.b.b();
    localb.bn(paramView);
    a.c("com/tencent/mm/plugin/finder/nearby/person/NearbyPersonV1UIC$showLbsRoomEntry$1", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, localb.aFi());
    b.s(this.zHO);
    a.a(this, "com/tencent/mm/plugin/finder/nearby/person/NearbyPersonV1UIC$showLbsRoomEntry$1", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
    AppMethodBeat.o(203652);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.plugin.finder.nearby.person.b.r
 * JD-Core Version:    0.7.0.1
 */