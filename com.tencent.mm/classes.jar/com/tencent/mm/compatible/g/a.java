package com.tencent.mm.compatible.g;

import android.view.MenuItem;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.sdk.platformtools.ae;

public final class a
{
  public static void a(MenuItem paramMenuItem, String paramString)
  {
    AppMethodBeat.i(155859);
    if (paramMenuItem == null)
    {
      ae.w("MicroMsg.MenuItemUtil", "fixTitleCondensed fail, item is null");
      AppMethodBeat.o(155859);
      return;
    }
    if (paramMenuItem.getTitleCondensed() == null)
    {
      ae.w("MicroMsg.MenuItemUtil", "%s title condensed is null, fix it", new Object[] { paramString });
      paramMenuItem.setTitleCondensed("");
      AppMethodBeat.o(155859);
      return;
    }
    if ((paramMenuItem.getTitleCondensed() instanceof String))
    {
      AppMethodBeat.o(155859);
      return;
    }
    ae.w("MicroMsg.MenuItemUtil", "%s title condensed is not String type, cur type[%s], cur value[%s], fix it", new Object[] { paramString, paramMenuItem.getTitleCondensed().getClass().getName(), paramMenuItem.getTitleCondensed() });
    paramMenuItem.setTitleCondensed(paramMenuItem.getTitleCondensed().toString());
    AppMethodBeat.o(155859);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.compatible.g.a
 * JD-Core Version:    0.7.0.1
 */