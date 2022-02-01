package com.tencent.mm.plugin.finder.nearby.person;

import android.view.View;
import android.widget.AdapterView;
import android.widget.AdapterView.OnItemClickListener;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.hellhoundlib.a.a;
import com.tencent.mm.hellhoundlib.b.b;
import kotlin.l;

@l(hxD={1, 1, 16}, hxE={""}, hxF={"<anonymous>", "", "<anonymous parameter 0>", "Landroid/widget/AdapterView;", "kotlin.jvm.PlatformType", "<anonymous parameter 1>", "Landroid/view/View;", "position", "", "<anonymous parameter 3>", "", "onItemClick"})
final class NearbyPersonV1UIC$h
  implements AdapterView.OnItemClickListener
{
  NearbyPersonV1UIC$h(NearbyPersonV1UIC paramNearbyPersonV1UIC) {}
  
  public final void onItemClick(AdapterView<?> paramAdapterView, View paramView, int paramInt, long paramLong)
  {
    AppMethodBeat.i(249284);
    b localb = new b();
    localb.bm(paramAdapterView);
    localb.bm(paramView);
    localb.pH(paramInt);
    localb.zo(paramLong);
    a.b("com/tencent/mm/plugin/finder/nearby/person/NearbyPersonV1UIC$initContentView$1", "android/widget/AdapterView$OnItemClickListener", "onItemClick", "(Landroid/widget/AdapterView;Landroid/view/View;IJ)V", this, localb.axR());
    NearbyPersonV1UIC.b(this.uSA, paramInt);
    a.a(this, "com/tencent/mm/plugin/finder/nearby/person/NearbyPersonV1UIC$initContentView$1", "android/widget/AdapterView$OnItemClickListener", "onItemClick", "(Landroid/widget/AdapterView;Landroid/view/View;IJ)V");
    AppMethodBeat.o(249284);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.plugin.finder.nearby.person.NearbyPersonV1UIC.h
 * JD-Core Version:    0.7.0.1
 */