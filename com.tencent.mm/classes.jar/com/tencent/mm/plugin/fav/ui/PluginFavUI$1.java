package com.tencent.mm.plugin.fav.ui;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.kernel.g;
import com.tencent.mm.plugin.fav.ui.b.b;
import com.tencent.mm.plugin.fts.a.a.a;
import com.tencent.mm.plugin.fts.a.n;

final class PluginFavUI$1
  extends a
{
  PluginFavUI$1(PluginFavUI paramPluginFavUI) {}
  
  public final boolean execute()
  {
    AppMethodBeat.i(74288);
    Object localObject = new com.tencent.mm.plugin.fav.ui.b.d();
    ((n)g.G(n.class)).registerFTSUILogic((com.tencent.mm.plugin.fts.a.d.d)localObject);
    localObject = new b();
    ((n)g.G(n.class)).registerFTSUILogic((com.tencent.mm.plugin.fts.a.d.d)localObject);
    AppMethodBeat.o(74288);
    return true;
  }
  
  public final String getName()
  {
    return "InitFTSFavUIPluginTask";
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes8.jar
 * Qualified Name:     com.tencent.mm.plugin.fav.ui.PluginFavUI.1
 * JD-Core Version:    0.7.0.1
 */