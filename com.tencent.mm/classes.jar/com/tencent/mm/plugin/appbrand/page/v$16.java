package com.tencent.mm.plugin.appbrand.page;

import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.luggage.g.f;
import com.tencent.matrix.trace.core.AppMethodBeat;

final class v$16
  implements View.OnClickListener
{
  v$16(v paramv) {}
  
  public final void onClick(View paramView)
  {
    AppMethodBeat.i(87187);
    boolean bool = f.av(this.ixv.getContext());
    paramView = this.ixv;
    v.16.1 local1 = new v.16.1(this);
    if (bool) {}
    for (int i = 100;; i = 0)
    {
      paramView.k(local1, i);
      AppMethodBeat.o(87187);
      return;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes9.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.page.v.16
 * JD-Core Version:    0.7.0.1
 */