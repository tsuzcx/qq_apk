package com.tencent.mm.plugin.location.ui.impl;

import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.hellhoundlib.a.a;
import com.tencent.mm.hellhoundlib.b.b;
import com.tencent.mm.sdk.platformtools.ae;

final class j$4
  implements View.OnClickListener
{
  j$4(j paramj) {}
  
  public final void onClick(View paramView)
  {
    AppMethodBeat.i(56150);
    b localb = new b();
    localb.bd(paramView);
    a.b("com/tencent/mm/plugin/location/ui/impl/TrackMapUI$3", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, localb.ahF());
    ae.d("MicroMsg.TrackMapUI", "newpoi old go back onclick");
    this.vua.dsV = 0;
    this.vua.dko();
    this.vua.dkz();
    a.a(this, "com/tencent/mm/plugin/location/ui/impl/TrackMapUI$3", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
    AppMethodBeat.o(56150);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.plugin.location.ui.impl.j.4
 * JD-Core Version:    0.7.0.1
 */