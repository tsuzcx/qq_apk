package com.tencent.mm.plugin.finder.nearby.person;

import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.hellhoundlib.a.a;
import com.tencent.mm.hellhoundlib.b.b;
import kotlin.l;

@l(hxD={1, 1, 16}, hxE={""}, hxF={"<anonymous>", "", "it", "Landroid/view/View;", "kotlin.jvm.PlatformType", "onClick"})
final class NearbyPersonV1UIC$r
  implements View.OnClickListener
{
  NearbyPersonV1UIC$r(NearbyPersonV1UIC paramNearbyPersonV1UIC) {}
  
  public final void onClick(View paramView)
  {
    AppMethodBeat.i(249296);
    b localb = new b();
    localb.bm(paramView);
    a.b("com/tencent/mm/plugin/finder/nearby/person/NearbyPersonV1UIC$showLbsRoomEntry$1", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, localb.axR());
    NearbyPersonV1UIC.s(this.uSA);
    a.a(this, "com/tencent/mm/plugin/finder/nearby/person/NearbyPersonV1UIC$showLbsRoomEntry$1", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
    AppMethodBeat.o(249296);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.plugin.finder.nearby.person.NearbyPersonV1UIC.r
 * JD-Core Version:    0.7.0.1
 */