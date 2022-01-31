package com.tencent.mm.plugin.game.luggage.c.a;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.appbrand.ipc.AppBrandMainProcessService;
import com.tencent.mm.plugin.webview.luggage.FavUrlTask;
import com.tencent.mm.ui.widget.snackbar.a.b;

final class g$2
  implements a.b
{
  g$2(g paramg) {}
  
  public final void aVA()
  {
    AppMethodBeat.i(135905);
    FavUrlTask localFavUrlTask = new FavUrlTask();
    localFavUrlTask.actionType = 2;
    AppBrandMainProcessService.a(localFavUrlTask);
    AppMethodBeat.o(135905);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.plugin.game.luggage.c.a.g.2
 * JD-Core Version:    0.7.0.1
 */