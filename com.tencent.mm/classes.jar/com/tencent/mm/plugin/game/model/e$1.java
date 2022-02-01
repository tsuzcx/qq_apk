package com.tencent.mm.plugin.game.model;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.game.report.api.a;
import com.tencent.mm.pluginsdk.model.app.al;

final class e$1
  implements al
{
  e$1(String paramString) {}
  
  public final void v(boolean paramBoolean1, boolean paramBoolean2)
  {
    AppMethodBeat.i(195629);
    if (paramBoolean1) {
      a.guC.c(this.val$appId, 0, 0, null, null);
    }
    AppMethodBeat.o(195629);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.plugin.game.model.e.1
 * JD-Core Version:    0.7.0.1
 */