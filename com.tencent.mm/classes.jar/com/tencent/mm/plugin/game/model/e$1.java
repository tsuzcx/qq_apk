package com.tencent.mm.plugin.game.model;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.game.report.api.a;
import com.tencent.mm.pluginsdk.model.app.ap;

final class e$1
  implements ap
{
  e$1(String paramString) {}
  
  public final void onLaunchApp(boolean paramBoolean1, boolean paramBoolean2)
  {
    AppMethodBeat.i(275428);
    if (paramBoolean1) {
      a.mtH.c(this.etl, 0, 0, null, null);
    }
    AppMethodBeat.o(275428);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.plugin.game.model.e.1
 * JD-Core Version:    0.7.0.1
 */