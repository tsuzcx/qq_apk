package com.tencent.mm.plugin.appbrand.app;

import android.view.View;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.accessibility.core.area.ViewTouchAreaExpander;
import com.tencent.mm.plugin.appbrand.widget.a.b;

final class PluginAppBrand$12
  implements b
{
  PluginAppBrand$12(PluginAppBrand paramPluginAppBrand) {}
  
  public final void expand(View paramView, int paramInt1, int paramInt2, int paramInt3, int paramInt4)
  {
    AppMethodBeat.i(317655);
    ViewTouchAreaExpander.INSTANCE.expand(paramView, paramInt1, paramInt2, paramInt3, paramInt4);
    AppMethodBeat.o(317655);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.app.PluginAppBrand.12
 * JD-Core Version:    0.7.0.1
 */