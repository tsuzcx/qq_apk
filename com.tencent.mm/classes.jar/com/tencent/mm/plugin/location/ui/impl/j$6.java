package com.tencent.mm.plugin.location.ui.impl;

import android.app.Activity;
import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.hellhoundlib.a.a;
import com.tencent.mm.hellhoundlib.b.b;

final class j$6
  implements View.OnClickListener
{
  j$6(j paramj) {}
  
  public final void onClick(View paramView)
  {
    AppMethodBeat.i(56151);
    b localb = new b();
    localb.cH(paramView);
    a.c("com/tencent/mm/plugin/location/ui/impl/TrackMapUI$5", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, localb.aYj());
    this.Kks.fVt();
    this.Kks.hideVKB();
    this.Kks.activity.finish();
    a.a(this, "com/tencent/mm/plugin/location/ui/impl/TrackMapUI$5", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
    AppMethodBeat.o(56151);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.plugin.location.ui.impl.j.6
 * JD-Core Version:    0.7.0.1
 */