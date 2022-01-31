package com.tencent.mm.plugin.game.media;

import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.HashMap;
import java.util.LinkedList;

final class e$1$1
  implements g.a
{
  e$1$1(e.1 param1, LinkedList paramLinkedList) {}
  
  public final void id(boolean paramBoolean)
  {
    AppMethodBeat.i(151807);
    g localg = (g)e.a(this.nlc.nla).remove(this.nlc.nkX.field_taskId);
    if (localg != null) {
      localg.reset();
    }
    if (paramBoolean)
    {
      ((com.tencent.mm.plugin.game.api.e)com.tencent.mm.kernel.g.E(com.tencent.mm.plugin.game.api.e.class)).bEV().ct(this.nlc.nkX.field_taskId, 2);
      e.a(this.nlc.nla, this.nlc.nkX.field_taskId, this.nlc.nkX.field_publishSource, this.nlb, this.nlc.nkX.field_BusinessData);
      AppMethodBeat.o(151807);
      return;
    }
    ((com.tencent.mm.plugin.game.api.e)com.tencent.mm.kernel.g.E(com.tencent.mm.plugin.game.api.e.class)).bEV().ct(this.nlc.nkX.field_taskId, 1);
    ((com.tencent.mm.plugin.game.api.e)com.tencent.mm.kernel.g.E(com.tencent.mm.plugin.game.api.e.class)).bEV().PZ(this.nlc.nkX.field_taskId);
    e.cs(this.nlc.nkX.field_taskId, -1);
    AppMethodBeat.o(151807);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.plugin.game.media.e.1.1
 * JD-Core Version:    0.7.0.1
 */