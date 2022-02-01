package com.tencent.mm.plugin.exdevice.ui;

import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.hellhoundlib.a.a;
import com.tencent.mm.hellhoundlib.b.b;
import kotlin.l;
import kotlin.t;

@l(hxD={1, 1, 16}, hxE={""}, hxF={"<anonymous>", "", "it", "Landroid/view/View;", "kotlin.jvm.PlatformType", "onClick"})
final class SportProfileUIC$e
  implements View.OnClickListener
{
  SportProfileUIC$e(SportProfileUIC paramSportProfileUIC) {}
  
  public final void onClick(View paramView)
  {
    AppMethodBeat.i(230640);
    b localb = new b();
    localb.bm(paramView);
    a.b("com/tencent/mm/plugin/exdevice/ui/SportProfileUIC$updateItemView$10", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, localb.axR());
    if ((this.rMU.getActivity() instanceof ExdeviceProfileUI))
    {
      paramView = this.rMU.getActivity();
      if (paramView == null)
      {
        paramView = new t("null cannot be cast to non-null type com.tencent.mm.plugin.exdevice.ui.ExdeviceProfileUI");
        AppMethodBeat.o(230640);
        throw paramView;
      }
      ((ExdeviceProfileUI)paramView).cLP();
    }
    a.a(this, "com/tencent/mm/plugin/exdevice/ui/SportProfileUIC$updateItemView$10", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
    AppMethodBeat.o(230640);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.plugin.exdevice.ui.SportProfileUIC.e
 * JD-Core Version:    0.7.0.1
 */