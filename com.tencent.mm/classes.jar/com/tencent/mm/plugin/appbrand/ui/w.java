package com.tencent.mm.plugin.appbrand.ui;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.appbrand.au.j;
import com.tencent.mm.ui.ar;
import kotlin.l;

@l(iBK={1, 1, 16}, iBL={""}, iBM={"Lcom/tencent/mm/plugin/appbrand/ui/AppBrandUITheme;", "", "()V", "THEME", "", "plugin-appbrand-integration_release"})
public final class w
{
  public static final w qZA;
  
  static
  {
    AppMethodBeat.i(177768);
    qZA = new w();
    AppMethodBeat.o(177768);
  }
  
  public static final int ckq()
  {
    AppMethodBeat.i(177767);
    if (ar.isDarkMode())
    {
      i = au.j.AppBrandUITheme_DarkMode;
      AppMethodBeat.o(177767);
      return i;
    }
    int i = au.j.AppBrandUITheme;
    AppMethodBeat.o(177767);
    return i;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.ui.w
 * JD-Core Version:    0.7.0.1
 */