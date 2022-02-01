package com.tencent.mm.plugin.appbrand.ui;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ui.component.UIComponent;
import java.util.HashSet;
import java.util.Set;

final class AppBrandUI$2
  extends HashSet<Class<? extends UIComponent>>
{
  AppBrandUI$2(AppBrandUI paramAppBrandUI, Set paramSet)
  {
    AppMethodBeat.i(277521);
    if (this.qYL != null) {
      addAll(this.qYL);
    }
    add(q.class);
    AppMethodBeat.o(277521);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.ui.AppBrandUI.2
 * JD-Core Version:    0.7.0.1
 */