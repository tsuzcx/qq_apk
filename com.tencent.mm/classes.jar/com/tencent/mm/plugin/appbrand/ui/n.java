package com.tencent.mm.plugin.appbrand.ui;

import android.app.Activity;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.appbrand.b.c;
import com.tencent.mm.plugin.appbrand.b.d;
import com.tencent.mm.plugin.appbrand.b.d.a;
import com.tencent.mm.plugin.appbrand.b.f;
import com.tencent.mm.plugin.appbrand.i;
import com.tencent.mm.plugin.appbrand.k;

class n
  extends f
{
  private k iPE;
  
  n(Activity paramActivity, k paramk)
  {
    super(paramActivity);
    this.iPE = paramk;
  }
  
  public void awv()
  {
    AppMethodBeat.i(114422);
    i locali = this.iPE.atG();
    if (locali != null) {
      locali.gPL.gYj.a(d.a.gYD);
    }
    AppMethodBeat.o(114422);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.ui.n
 * JD-Core Version:    0.7.0.1
 */