package com.tencent.mm.plugin.appbrand.ui;

import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.appbrand.e;
import com.tencent.mm.plugin.appbrand.e.d;
import com.tencent.mm.plugin.appbrand.i;

final class f$1
  implements View.OnClickListener
{
  f$1(f paramf) {}
  
  public final void onClick(View paramView)
  {
    AppMethodBeat.i(102311);
    e.a(f.a(this.iNc).mAppId, e.d.gPe);
    f.a(this.iNc).finish();
    AppMethodBeat.o(102311);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.ui.f.1
 * JD-Core Version:    0.7.0.1
 */