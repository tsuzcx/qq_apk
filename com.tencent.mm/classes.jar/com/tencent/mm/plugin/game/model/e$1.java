package com.tencent.mm.plugin.game.model;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.kernel.g;
import com.tencent.mm.plugin.game.api.d;
import com.tencent.mm.pluginsdk.model.app.ai;

final class e$1
  implements ai
{
  e$1(String paramString) {}
  
  public final void dZ(boolean paramBoolean)
  {
    AppMethodBeat.i(111196);
    if (paramBoolean)
    {
      ((d)g.E(d.class)).bEQ();
      t.b(this.val$appId, 0, 0, null, null);
    }
    AppMethodBeat.o(111196);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.plugin.game.model.e.1
 * JD-Core Version:    0.7.0.1
 */