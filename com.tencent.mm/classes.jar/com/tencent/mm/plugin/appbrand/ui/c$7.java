package com.tencent.mm.plugin.appbrand.ui;

import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.appbrand.e;
import com.tencent.mm.plugin.appbrand.e.d;
import com.tencent.mm.plugin.appbrand.i;
import com.tencent.mm.plugin.appbrand.o;

final class c$7
  implements View.OnClickListener
{
  c$7(c paramc) {}
  
  public final void onClick(View paramView)
  {
    AppMethodBeat.i(132942);
    e.a(c.e(this.iMp).mAppId, e.d.gPe);
    c.e(this.iMp).finish();
    AppMethodBeat.o(132942);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.ui.c.7
 * JD-Core Version:    0.7.0.1
 */