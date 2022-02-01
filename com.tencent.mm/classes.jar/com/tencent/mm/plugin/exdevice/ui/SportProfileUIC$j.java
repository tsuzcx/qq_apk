package com.tencent.mm.plugin.exdevice.ui;

import android.content.Context;
import android.content.Intent;
import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.br.c;
import com.tencent.mm.hellhoundlib.a.a;
import com.tencent.mm.hellhoundlib.b.b;
import kotlin.l;

@l(hxD={1, 1, 16}, hxE={""}, hxF={"<anonymous>", "", "it", "Landroid/view/View;", "kotlin.jvm.PlatformType", "onClick"})
final class SportProfileUIC$j
  implements View.OnClickListener
{
  SportProfileUIC$j(SportProfileUIC paramSportProfileUIC, String paramString) {}
  
  public final void onClick(View paramView)
  {
    AppMethodBeat.i(230646);
    b localb = new b();
    localb.bm(paramView);
    a.b("com/tencent/mm/plugin/exdevice/ui/SportProfileUIC$updateItemView$9", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, localb.axR());
    paramView = new Intent();
    paramView.putExtra("Contact_User", this.hLl);
    c.b((Context)this.rMU.getActivity(), "profile", ".ui.ContactInfoUI", paramView);
    a.a(this, "com/tencent/mm/plugin/exdevice/ui/SportProfileUIC$updateItemView$9", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
    AppMethodBeat.o(230646);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.plugin.exdevice.ui.SportProfileUIC.j
 * JD-Core Version:    0.7.0.1
 */