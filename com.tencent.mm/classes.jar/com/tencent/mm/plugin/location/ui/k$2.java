package com.tencent.mm.plugin.location.ui;

import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.hellhoundlib.a.a;
import com.tencent.mm.hellhoundlib.b.b;

final class k$2
  implements View.OnClickListener
{
  k$2(k paramk) {}
  
  public final void onClick(View paramView)
  {
    AppMethodBeat.i(55964);
    b localb = new b();
    localb.bm(paramView);
    a.b("com/tencent/mm/plugin/location/ui/TrackPointViewMgrImpl$2", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, localb.axR());
    a.a(this, "com/tencent/mm/plugin/location/ui/TrackPointViewMgrImpl$2", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
    AppMethodBeat.o(55964);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.plugin.location.ui.k.2
 * JD-Core Version:    0.7.0.1
 */