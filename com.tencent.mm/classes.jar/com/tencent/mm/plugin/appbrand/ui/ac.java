package com.tencent.mm.plugin.appbrand.ui;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.appbrand.ba.j;
import com.tencent.mm.ui.aw;
import kotlin.Metadata;

@Metadata(d1={""}, d2={"Lcom/tencent/mm/plugin/appbrand/ui/AppBrandUITheme;", "", "()V", "THEME", "", "plugin-appbrand-integration_release"}, k=1, mv={1, 5, 1}, xi=48)
public final class ac
{
  public static final ac ufB;
  
  static
  {
    AppMethodBeat.i(177768);
    ufB = new ac();
    AppMethodBeat.o(177768);
  }
  
  public static final int cLF()
  {
    AppMethodBeat.i(177767);
    if (aw.isDarkMode())
    {
      i = ba.j.AppBrandUITheme_DarkMode;
      AppMethodBeat.o(177767);
      return i;
    }
    int i = ba.j.AppBrandUITheme;
    AppMethodBeat.o(177767);
    return i;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes8.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.ui.ac
 * JD-Core Version:    0.7.0.1
 */