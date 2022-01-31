package com.tencent.mm.compatible.i;

import android.view.MenuItem;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.sdk.platformtools.ab;

public final class a
{
  public static void a(MenuItem paramMenuItem, String paramString)
  {
    AppMethodBeat.i(93054);
    if (paramMenuItem == null)
    {
      ab.w("MicroMsg.MenuItemUtil", "fixTitleCondensed fail, item is null");
      AppMethodBeat.o(93054);
      return;
    }
    if (paramMenuItem.getTitleCondensed() == null)
    {
      ab.w("MicroMsg.MenuItemUtil", "%s title condensed is null, fix it", new Object[] { paramString });
      paramMenuItem.setTitleCondensed("");
      AppMethodBeat.o(93054);
      return;
    }
    if ((paramMenuItem.getTitleCondensed() instanceof String))
    {
      AppMethodBeat.o(93054);
      return;
    }
    ab.w("MicroMsg.MenuItemUtil", "%s title condensed is not String type, cur type[%s], cur value[%s], fix it", new Object[] { paramString, paramMenuItem.getTitleCondensed().getClass().getName(), paramMenuItem.getTitleCondensed() });
    paramMenuItem.setTitleCondensed(paramMenuItem.getTitleCondensed().toString());
    AppMethodBeat.o(93054);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.compatible.i.a
 * JD-Core Version:    0.7.0.1
 */