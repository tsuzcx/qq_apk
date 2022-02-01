package com.tencent.mm.plugin.finder.ui;

import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.hellhoundlib.a.a;
import com.tencent.mm.hellhoundlib.b.b;
import d.l;

@l(gjZ={1, 1, 16}, gka={""}, gkb={"<anonymous>", "", "it", "Landroid/view/View;", "kotlin.jvm.PlatformType", "onClick"})
final class FinderMediaCropUI$v
  implements View.OnClickListener
{
  FinderMediaCropUI$v(FinderMediaCropUI paramFinderMediaCropUI) {}
  
  public final void onClick(View paramView)
  {
    AppMethodBeat.i(167371);
    b localb = new b();
    localb.bd(paramView);
    a.b("com/tencent/mm/plugin/finder/ui/FinderMediaCropUI$onCreate$3", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, localb.ahF());
    this.sOs.setResult(0);
    this.sOs.finish();
    a.a(this, "com/tencent/mm/plugin/finder/ui/FinderMediaCropUI$onCreate$3", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
    AppMethodBeat.o(167371);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.plugin.finder.ui.FinderMediaCropUI.v
 * JD-Core Version:    0.7.0.1
 */