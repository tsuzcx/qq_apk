package com.tencent.mm.plugin.appbrand.ui;

import androidx.lifecycle.h.a;
import androidx.lifecycle.k;
import androidx.lifecycle.t;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ui.base.b;
import com.tencent.mm.ui.base.b.a;

class AppBrandUITranslucentWorkaroundDelegate
  implements k, b.a
{
  final AppBrandUI qZB;
  boolean qZC = false;
  boolean qZD = false;
  
  AppBrandUITranslucentWorkaroundDelegate(AppBrandUI paramAppBrandUI)
  {
    this.qZB = paramAppBrandUI;
  }
  
  public final void ckh()
  {
    this.qZC = true;
  }
  
  public final void cki()
  {
    this.qZC = false;
  }
  
  @t(jl=h.a.ON_RESUME)
  void onActivityResumed()
  {
    AppMethodBeat.i(274701);
    if (this.qZD)
    {
      b.bv(this.qZB);
      this.qZD = false;
    }
    AppMethodBeat.o(274701);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.ui.AppBrandUITranslucentWorkaroundDelegate
 * JD-Core Version:    0.7.0.1
 */