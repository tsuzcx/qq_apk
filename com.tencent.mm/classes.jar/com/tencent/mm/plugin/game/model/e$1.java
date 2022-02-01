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
    AppMethodBeat.i(206814);
    if (paramBoolean1) {
      a.gsb.c(this.val$appId, 0, 0, null, null);
    }
    AppMethodBeat.o(206814);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.plugin.game.model.e.1
 * JD-Core Version:    0.7.0.1
 */