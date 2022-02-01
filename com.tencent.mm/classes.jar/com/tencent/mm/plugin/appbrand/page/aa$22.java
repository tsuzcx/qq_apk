package com.tencent.mm.plugin.appbrand.page;

import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.appbrand.AppBrandRuntime;
import com.tencent.mm.plugin.appbrand.g;
import com.tencent.mm.plugin.appbrand.g.d;

final class aa$22
  implements View.OnClickListener
{
  aa$22(aa paramaa) {}
  
  public final void onClick(View paramView)
  {
    AppMethodBeat.i(135137);
    g.a(this.lbk.getAppId(), g.d.iDc);
    aa.o(this.lbk).close();
    AppMethodBeat.o(135137);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.page.aa.22
 * JD-Core Version:    0.7.0.1
 */