package com.tencent.mm.plugin.appbrand.ui;

import androidx.lifecycle.j.a;
import androidx.lifecycle.p;
import androidx.lifecycle.z;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ui.base.b;
import com.tencent.mm.ui.base.b.a;

class AppBrandUITranslucentWorkaroundDelegate
  implements p, b.a
{
  final AppBrandUI tOp;
  boolean ufC = false;
  boolean ufD = false;
  
  AppBrandUITranslucentWorkaroundDelegate(AppBrandUI paramAppBrandUI)
  {
    this.tOp = paramAppBrandUI;
  }
  
  public final void cLv()
  {
    this.ufC = true;
  }
  
  public final void cLw()
  {
    this.ufC = false;
  }
  
  @z(Ho=j.a.ON_RESUME)
  void onActivityResumed()
  {
    AppMethodBeat.i(322303);
    if (this.ufD)
    {
      b.bZ(this.tOp);
      this.ufD = false;
    }
    AppMethodBeat.o(322303);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes8.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.ui.AppBrandUITranslucentWorkaroundDelegate
 * JD-Core Version:    0.7.0.1
 */