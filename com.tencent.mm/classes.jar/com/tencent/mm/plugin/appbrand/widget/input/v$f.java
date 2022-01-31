package com.tencent.mm.plugin.appbrand.widget.input;

import android.view.View;
import com.tencent.mm.plugin.appbrand.ui.l;
import com.tencent.mm.plugin.appbrand.widget.input.panel.e;
import com.tencent.mm.sdk.platformtools.u;

final class v$f
  implements v.b
{
  public final void c(v paramv, int paramInt)
  {
    if (l.bW(paramv)) {
      paramv.mT(8);
    }
    while ((v.a(paramv) == null) || (paramInt <= 0)) {
      return;
    }
    v.b(paramv, paramInt);
  }
  
  public final void m(v paramv)
  {
    if (paramv.isShown()) {
      v.a(paramv).setVisibility(0);
    }
    v.b(paramv).asH();
  }
  
  public final void n(v paramv)
  {
    if (l.bW(paramv))
    {
      paramv.mT(8);
      v.g(paramv);
      return;
    }
    if (paramv.isShown()) {
      v.a(paramv).setVisibility(0);
    }
    if (!v.h(paramv))
    {
      v.b(paramv).asH();
      return;
    }
    v.b(paramv).asG();
  }
  
  public final void o(v paramv)
  {
    v.i(paramv).showVKB();
    v.j(paramv);
  }
  
  public final void p(v paramv)
  {
    v.i(paramv).XM();
    v.k(paramv);
    paramv.mP(u.fy(v.l(paramv)));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.widget.input.v.f
 * JD-Core Version:    0.7.0.1
 */