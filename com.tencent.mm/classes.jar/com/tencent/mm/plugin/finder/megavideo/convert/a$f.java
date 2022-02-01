package com.tencent.mm.plugin.finder.megavideo.convert;

import android.app.Activity;
import android.view.View;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.finder.megavideo.ui.f;
import com.tencent.mm.plugin.finder.model.ca;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.view.HardTouchableLayout.g;
import com.tencent.mm.view.recyclerview.j;
import kotlin.Metadata;
import kotlin.g.b.s;

@Metadata(d1={""}, d2={"com/tencent/mm/plugin/finder/megavideo/convert/FinderMegaVideoConvert$initToggleHeaderAndFooter$1$1", "Lcom/tencent/mm/view/HardTouchableLayout$OnSingleClickListener;", "onSingleClick", "", "view", "Landroid/view/View;", "e", "Landroid/view/MotionEvent;", "plugin-finder_release"}, k=1, mv={1, 5, 1}, xi=48)
public final class a$f
  implements HardTouchableLayout.g
{
  a$f(a parama, j paramj, ca paramca) {}
  
  public final void fu(View paramView)
  {
    AppMethodBeat.i(342253);
    s.u(paramView, "view");
    if (this.Ezv.Ezq)
    {
      Log.i("Finder.FinderLongVideoConvert", "initToggleHeaderAndFooter onSingleClick: has been blocked");
      this.Ezv.Ezq = false;
      AppMethodBeat.o(342253);
      return;
    }
    if (a.D(this.wHm))
    {
      Log.i("Finder.FinderLongVideoConvert", "initToggleHeaderAndFooter onSingleClick: hide bullet op layout");
      AppMethodBeat.o(342253);
      return;
    }
    if (a.a(this.Ezv, this.wHm, this.Ezu))
    {
      Log.i("Finder.FinderLongVideoConvert", "initToggleHeaderAndFooter onSingleClick: hide bullet input layout");
      AppMethodBeat.o(342253);
      return;
    }
    paramView = a.Ezn;
    if (a.a.g(this.wHm, 0))
    {
      Log.i("Finder.FinderLongVideoConvert", "initToggleHeaderAndFooter onSingleClick: hide play speed ctrl layout");
      AppMethodBeat.o(342253);
      return;
    }
    paramView = a.Ezn;
    a.a.a(this.wHm, this.Ezu, (Activity)a.a(this.Ezv).CCa, null);
    AppMethodBeat.o(342253);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes12.jar
 * Qualified Name:     com.tencent.mm.plugin.finder.megavideo.convert.a.f
 * JD-Core Version:    0.7.0.1
 */