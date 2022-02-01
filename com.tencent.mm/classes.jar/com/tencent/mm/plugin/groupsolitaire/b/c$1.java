package com.tencent.mm.plugin.groupsolitaire.b;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.kernel.g;
import com.tencent.mm.plugin.groupsolitaire.PluginGroupSolitaire;

final class c$1
  implements Runnable
{
  c$1(c paramc, String paramString1, String paramString2) {}
  
  public final void run()
  {
    AppMethodBeat.i(110366);
    ((PluginGroupSolitaire)g.ad(PluginGroupSolitaire.class)).getGroupSolitatireStorage().p(this.fOj, this.val$key, true);
    AppMethodBeat.o(110366);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.plugin.groupsolitaire.b.c.1
 * JD-Core Version:    0.7.0.1
 */